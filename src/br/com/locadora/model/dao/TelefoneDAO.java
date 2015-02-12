package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Telefone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelefoneDAO implements InterfaceTelefoneDAO {

    private InterfacePool pool;

    public TelefoneDAO(InterfacePool pool) {
        this.pool = pool;
    }

    @Override
    public void atualizar(Telefone telefone) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlAtualizar = " UPDATE telefone SET bairro=?, celular=?, cep=?, "
                + " cidade=?, cpf_cnpj=?, email=?, endereco=?, estado=?,"
                + " telefone=?, nome=? WHERE codigo = ? ;";

        try {
            ps = con.prepareStatement(sqlAtualizar);

            setPreparedStatement(telefone, ps);

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
        String sqlExcluir = "DELETE FROM TELEFONE WHERE CODIGO_TELEFONE = ?;";

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
    public Telefone getTelefone(String nome) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM telefone WHERE nome like ?";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + nome + "%");

            rs = ps.executeQuery();

            List<Telefone> resultado = getListaTelefone(rs);

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
    public Telefone getTelefone(Integer codigo) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM telefone WHERE codigo = ?;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo);

            rs = ps.executeQuery();

            List<Telefone> resultado = getListaTelefone(rs);
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
    public List<Telefone> getTelefones() throws SQLException {
        List<Telefone> resultado = new ArrayList<Telefone>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM CLIENTE ORDER BY NOME; ";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaTelefone(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    @Override
    public List<Telefone> getTelefones(Integer codigo_cliente) {
        List<Telefone> resultado = new ArrayList<Telefone>();
        Connection con = pool.getConnection();
        PreparedStatement ps;
        String sqlSelect = "SELECT * FROM TELEFONE WHERE CLIENTE_CODIGO_CLIENTE = ? ORDER BY TELEFONE; ";
        ResultSet rs;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_cliente);
            rs = ps.executeQuery();

            resultado = getListaTelefone(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    private List<Telefone> getListaTelefone(ResultSet rs) throws SQLException {
        List<Telefone> resultado = new ArrayList<Telefone>();
        while (rs.next()) {
            Telefone telefone = new Telefone();
            telefone.setTelefone(rs.getString("TELEFONE"));
            telefone.setCodigo_telefone(rs.getInt("CODIGO_TELEFONE"));

            Cliente cliente = new Cliente();
            cliente.setCodigo_cliente(rs.getInt("CLIENTE_CODIGO_CLIENTE"));

            telefone.setCliente(cliente);
            resultado.add(telefone);
        }
        return resultado;
    }

    @Override
    public void salvar(List<Telefone> telefones, Cliente cliente) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO TELEFONE (TELEFONE, CLIENTE_CODIGO_CLIENTE) VALUES"
                + "( ? ,? );";

        try {
            ps = con.prepareStatement(sqlInsert);

            for (int i = 0; i < telefones.size(); i++) {
                ps.setString(1, telefones.get(i).getTelefone());
                ps.setInt(2, cliente.getCodigo_cliente());
                ps.executeUpdate();

            }

            ps.close();
        } finally {
            pool.liberarConnection(con);
        }

    }

    private void setPreparedStatement(Telefone telefone, PreparedStatement ps)
            throws SQLException {
//		ps.setString(1, telefone.getNome_telefone());
//		ps.setString(2, telefone.getNome_empresa_trabalho());
//		ps.setString(3, telefone.getProfissao());
//		ps.setString(4, telefone.getCpf());
//                ps.setString(5, telefone.getData_nascimento());
//		ps.setString(7, telefone.getEndereco());
//		ps.setString(9, telefone.getBairro());
//                ps.setString(8, telefone.getComplemento());
//		ps.setString(10, telefone.getCidade());
//		ps.setString(12, telefone.getEstado());
//		ps.setString(11, telefone.getEmail());
//                ps.setString(13, telefone.getLogin());
//		ps.setString(14, telefone.getSenha());
//		ps.setString(15, telefone.getObservacao());
//		ps.setString(16, telefone.getStatus());
    }

}
