package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.util.ArquivoConfiguracao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DependenteDAO implements InterfaceDependenteDAO {

    private InterfacePool pool;

    public DependenteDAO(InterfacePool pool) {
        this.pool = pool;
    }

    @Override
    public void atualizar(Dependente dependente) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlAtualizar = " UPDATE `dependente`SET`NOME_DEPENDENTE` = ?,`PARENTESCO` = ?,`CPF` = ?,\n"
                + "`DATA_NASCIMENTO` = ?,`DEL_FLAG` = ?,`TELEFONE` = ? WHERE `CODIGO_DEPENDENTE` = ?;";

        try {
            ps = con.prepareStatement(sqlAtualizar);

            setPreparedStatement(dependente, ps);

            ps.executeUpdate();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }

    @Override
    public boolean excluir(Integer codigo) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlExcluir = "DELETE FROM DEPENDENTE WHERE CODIGO_DEPENDENTE = ?;";

        try {
            ps = con.prepareStatement(sqlExcluir);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
            return false;
        } finally {
            pool.liberarConnection(con);
        }

    }

    @Override
    public Dependente getDependente(String nome) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM dependente WHERE nome like ?";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + nome + "%");

            rs = ps.executeQuery();

            List<Dependente> resultado = getListaDependente(rs);

            if (resultado.size() > 0) {
                return resultado.get(0);
            }
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return null;
    }

    public List<Dependente> getClienteDependente(String nome_cliente_dependente) throws SQLException {
        List<Dependente> resultado = new ArrayList<Dependente>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    CLIENTE_CODIGO_CLIENTE,\n"
                + "    NOME_DEPENDENTE,\n"
                + "    DATA_NASCIMENTO,\n"                
                + "    TIPO_DEPENDENTE,\n"
                + "    (CASE\n"
                + "        WHEN (TIPO_DEPENDENTE = 0) THEN 'Cliente'\n"
                + "        ELSE 'Dependente'\n"
                + "    END) AS TIPO,\n"
                + "    DEL_FLAG,\n"
                + "    CODIGO_DEPENDENTE,\n"
                + "    (SELECT \n"
                + "            DEL_FLAG\n"
                + "        FROM\n"
                + "            CLIENTE\n"
                + "        WHERE\n"
                + "            A.CLIENTE_CODIGO_CLIENTE = CODIGO_CLIENTE) AS STATUS_TITULAR\n"
                + "FROM\n"
                + "    DEPENDENTE A\n"
                + "WHERE\n"
                + "    CODIGO_DEPENDENTE IN (SELECT \n"
                + "            CODIGO_DEPENDENTE\n"
                + "        FROM\n"
                + "            DEPENDENTE\n"
                + "        WHERE\n"
                + "            CLIENTE_CODIGO_CLIENTE IN (SELECT \n"
                + "                    B.CLIENTE_CODIGO_CLIENTE\n"
                + "                FROM\n"
                + "                    CLIENTE A,\n"
                + "                    DEPENDENTE B\n"
                + "                WHERE\n"
                + "                    A.CODIGO_CLIENTE = B.CLIENTE_CODIGO_CLIENTE\n"
                + "                        AND B.NOME_DEPENDENTE LIKE ?)); ";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + nome_cliente_dependente + "%");

            rs = ps.executeQuery();

            resultado = getListaClienteDependente(rs);

            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public Lancamento getClienteDependente(Integer codigo_cliente) {
        List<Lancamento> resultado = new ArrayList<Lancamento>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;        
        String sqlSelect = "SELECT \n"
                + "    (CASE\n"
                + "        WHEN (DEBITO.VALOR - CREDITO.VALOR) IS NULL THEN 0\n"
                + "        ELSE (DEBITO.VALOR - CREDITO.VALOR)\n"
                + "    END) AS SALDO,\n"
                + "    SUM(DEBITO.VALOR) AS DEBITO,\n"
                + "    SUM(CREDITO.VALOR) AS CREDITO\n"
                + "FROM\n"
                + "    (SELECT \n"
                + "        (CASE\n"
                + "                WHEN SUM(VALOR) IS NULL THEN 0\n"
                + "                ELSE SUM(VALOR)\n"
                + "            END) AS VALOR\n"
                + "    FROM\n"
                + "        LANCAMENTO A, TIPO_SERVICO B\n"
                + "    WHERE\n"
                + "        A.TIPO_SERVICO_CODIGO_TIPO_SERVICO = B.CODIGO_TIPO_SERVICO\n"
                + "            AND A.DEPENDENTE_CODIGO_DEPENDENTE IN (SELECT \n"
                + "                CODIGO_DEPENDENTE\n"
                + "            FROM\n"
                + "                DEPENDENTE\n"
                + "            WHERE\n"
                + "                CLIENTE_CODIGO_CLIENTE = ?\n"
                + "                    AND TIPO = 'D')) AS DEBITO,\n"
                + "    (SELECT \n"
                + "        (CASE\n"
                + "                WHEN SUM(VALOR) IS NULL THEN 0\n"
                + "                ELSE SUM(VALOR)\n"
                + "            END) AS VALOR\n"
                + "    FROM\n"
                + "        LANCAMENTO A, TIPO_SERVICO B\n"
                + "    WHERE\n"
                + "        A.TIPO_SERVICO_CODIGO_TIPO_SERVICO = B.CODIGO_TIPO_SERVICO\n"
                + "            AND A.DEPENDENTE_CODIGO_DEPENDENTE IN (SELECT \n"
                + "                CODIGO_DEPENDENTE\n"
                + "            FROM\n"
                + "                DEPENDENTE\n"
                + "            WHERE\n"
                + "                CLIENTE_CODIGO_CLIENTE = ?\n"
                + "                    AND TIPO = 'C')) AS CREDITO;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_cliente);
            ps.setInt(2, codigo_cliente);

            rs = ps.executeQuery();

            resultado = getLancamentosSaldos(rs);
            if (resultado.size() > 0) {
                return resultado.get(0);
            }

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DependenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return null;
    }

    @Override
    public Dependente getDependente(Integer codigo) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM dependente WHERE codigo = ?;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo);

            rs = ps.executeQuery();

            List<Dependente> resultado = getListaDependente(rs);
            if (resultado.size() > 0) {
                return resultado.get(0);
            }
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return null;
    }

    @Override
    public List<Dependente> getDependentes() throws SQLException {
        List<Dependente> resultado = new ArrayList<Dependente>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM CLIENTE ORDER BY NOME; ";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaDependente(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<Dependente> getDependentes(Integer codigo_cliente) throws SQLException {
        List<Dependente> resultado = new ArrayList<Dependente>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM DEPENDENTE WHERE CLIENTE_CODIGO_CLIENTE = ? AND TIPO_DEPENDENTE = 1 ORDER BY NOME_DEPENDENTE;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_cliente);
            rs = ps.executeQuery();

            resultado = getListaDependente(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    private List<Dependente> getListaDependente(ResultSet rs) throws SQLException {
        List<Dependente> resultado = new ArrayList<Dependente>();
        while (rs.next()) {
            Dependente dependente = new Dependente();
            dependente.setCodigo_dependente(rs.getInt("CODIGO_DEPENDENTE"));
            dependente.setNome_dependente(rs.getString("NOME_DEPENDENTE"));
            dependente.setTipo_dependente(rs.getString("TIPO_DEPENDENTE"));
            dependente.setData_nascimento(rs.getDate("DATA_NASCIMENTO"));
            dependente.setParentesco(rs.getString("PARENTESCO"));
            dependente.setTelefone(rs.getString("TELEFONE"));
            dependente.setCPF(rs.getString("CPF"));
            if (rs.getInt("DEL_FLAG") == 0) {
                dependente.setStatus(true);
            } else {
                dependente.setStatus(false);
            }
            Cliente cliente = new Cliente();
            cliente.setCodigo_cliente(rs.getInt("CLIENTE_CODIGO_CLIENTE"));

            dependente.setCliente(cliente);

            resultado.add(dependente);
        }
        return resultado;
    }

    private List<Dependente> getListaClienteDependente(ResultSet rs) throws SQLException {
        List<Dependente> resultado = new ArrayList<Dependente>();
        while (rs.next()) {
            Dependente dependente = new Dependente();
            dependente.setCodigo_dependente(rs.getInt("CODIGO_DEPENDENTE"));
            dependente.setNome_dependente(rs.getString("NOME_DEPENDENTE"));
            dependente.setData_nascimento(rs.getDate("DATA_NASCIMENTO"));
            if (rs.getInt("TIPO_DEPENDENTE") == 0) {
                dependente.setTipo_dependente("Cliente");

            } else {
                dependente.setTipo_dependente("Dependente");
            }

            if (rs.getInt("DEL_FLAG") == 0) {
                dependente.setStatus(true);
            } else {
                dependente.setStatus(false);
            }
//            dependente.setDebito(rs.getString("DEVEDOR"));

            Cliente cliente = new Cliente();
            cliente.setCodigo_cliente(rs.getInt("CLIENTE_CODIGO_CLIENTE"));
            if (rs.getInt("STATUS_TITULAR") == 0) {
                cliente.setStatus(true);

            } else {
                cliente.setStatus(false);
            }

            dependente.setCliente(cliente);

            resultado.add(dependente);
        }
        return resultado;
    }

    private List<Lancamento> getLancamentosSaldos(ResultSet rs) throws SQLException {
        List<Lancamento> resultado = new ArrayList<Lancamento>();
        while (rs.next()) {
            Lancamento lancamento = new Lancamento();
            lancamento.setSaldo(rs.getDouble("SALDO"));
            lancamento.setDebito(rs.getDouble("DEBITO"));
            lancamento.setCredito(rs.getDouble("CREDITO"));

            resultado.add(lancamento);
        }
        return resultado;
    }

    @Override
    public void salvar(Dependente dependente, Cliente cliente) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO DEPENDENTE (NOME_DEPENDENTE, CLIENTE_CODIGO_CLIENTE, TIPO_DEPENDENTE, "
                + "DATA_NASCIMENTO, CPF, TELEFONE, PARENTESCO, USUARIO_CODIGO_USUARIO, DEL_FLAG) VALUES"
                + "( ? ,?, ?, ?, ?, ?, ? , ?, ?);";

        try {
            ps = con.prepareStatement(sqlInsert);
            Date data_nascimento = null;

            if (dependente.getData_nascimento() != null) {
                data_nascimento = new Date(dependente.getData_nascimento().getTime());
            }
            ps.setString(1, dependente.getNome_dependente());
            ps.setInt(2, cliente.getCodigo_cliente());
            ps.setInt(3, Integer.parseInt(dependente.getTipo_dependente()));
            ps.setDate(4, data_nascimento);
            ps.setString(5, dependente.getCPF());
            ps.setString(6, dependente.getTelefone());
            ps.setString(7, dependente.getParentesco());

            ArquivoConfiguracao conf = new ArquivoConfiguracao();
            ps.setInt(8, Integer.parseInt(conf.readPropertie("codigo_usuario")));

            if (dependente.getStatus() == true) {
                ps.setInt(9, 0);
            } else {
                ps.setInt(9, 1);
            }
            ps.executeUpdate();

            ps.close();
        } finally {
            pool.liberarConnection(con);
        }

    }

    private void setPreparedStatement(Dependente dependente, PreparedStatement ps)
            throws SQLException {

        Date data_nascimento = null;

        if (dependente.getData_nascimento() != null) {
            data_nascimento = new Date(dependente.getData_nascimento().getTime());
        }
        ps.setString(1, dependente.getNome_dependente());
        ps.setString(2, dependente.getParentesco());
        ps.setString(3, dependente.getCPF());
        ps.setDate(4, data_nascimento);
        if (dependente.getStatus() == true) {
            ps.setInt(5, 0);
        } else {
            ps.setInt(5, 1);
        }
        ps.setString(6, dependente.getTelefone());
        ps.setInt(7, dependente.getCodigo_dependente());
    }
}
