package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Devolucao;
import br.com.locadora.model.bean.ItemLancamento;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.Locacao;
import br.com.locadora.model.bean.TipoServico;
import br.com.locadora.model.bean.Usuario;
import br.com.locadora.model.bean.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LancamentoDAO {

    private InterfacePool pool;

    public LancamentoDAO(InterfacePool pool) {
        this.pool = pool;
    }

    public void atualizar(Lancamento lancamento) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlAtualizar = " UPDATE lancamento SET bairro=?, celular=?, cep=?, "
                + " cidade=?, cpf_cnpj=?, email=?, endereco=?, estado=?,"
                + " telefone=?, nome=? WHERE codigo = ? ;";

        try {
            ps = con.prepareStatement(sqlAtualizar);

            setPreparedStatement(lancamento, ps);

            ps.executeUpdate();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }

    
    public void excluir(Integer codigo) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlExcluir = "DELETE FROM lancamento WHERE codigo = ?;";

        try {
            ps = con.prepareStatement(sqlExcluir);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }
    
    public boolean excluirItemLancamento(Integer codigo) {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlExcluir = "DELETE FROM item_lancamento WHERE codigo_item_lancamento = ?;";

        try {
            ps = con.prepareStatement(sqlExcluir);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            pool.liberarConnection(con);
        }
    }
    //Utilizado na tela de AtendimentoVenda para checagem de Débito maior que período
    public Lancamento getDebito(Cliente cliente){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");        
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT \n" +
            "    (CASE WHEN MAX(B.CODIGO_ITEM_LANCAMENTO) IS NULL THEN 0 \n" +
            "    ELSE MAX(B.CODIGO_ITEM_LANCAMENTO) \n" +
            "    END) AS CODIGO_ITEM_LANCAMENTO,\n" +
            "    (CASE\n" +
            "        WHEN B.DATA_LANCAMENTO IS NULL THEN 0\n" +
            "        ELSE B.DATA_LANCAMENTO\n" +
            "    END) AS DATA_LANCAMENTO\n" +
            "FROM\n" +
            "    LANCAMENTO A,\n" +
            "    ITEM_LANCAMENTO B,\n" +
            "    TIPO_SERVICO C,\n" +
            "    DEPENDENTE D\n" +
            "WHERE\n" +
            "    A.TIPO_SERVICO_CODIGO_TIPO_SERVICO = C.CODIGO_TIPO_SERVICO\n" +
            "        AND A.DEPENDENTE_CODIGO_DEPENDENTE = D.CODIGO_DEPENDENTE\n" +
            "        AND A.CODIGO_LANCAMENTO = B.LANCAMENTO_CODIGO_LANCAMENTO\n" +
            "        AND D.CLIENTE_CODIGO_CLIENTE = ?\n" +
"        AND C.TIPO = 'C';";
        ResultSet rs = null;
        Lancamento lancamento = new Lancamento();

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, cliente.getCodigo_cliente());
            rs = ps.executeQuery();
            
            rs.next();            
            
            System.out.println(rs.getString("DATA_LANCAMENTO"));
            if(rs.getInt("DATA_LANCAMENTO") == 0){
                lancamento = null;
            } else {
                String dataString = rs.getString("DATA_LANCAMENTO");
                java.util.Date data_lancamento =  format.parse(dataString);
                lancamento.setData_lancamento(data_lancamento);                
            } 
            
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return lancamento;
    }

    
    public List<Lancamento> getLancamentos(Cliente cliente) {
        List<Lancamento> resultado = new ArrayList<Lancamento>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT \n" +
            "    *,\n" +
            "    (CASE\n" +
            "        WHEN (LANC.TIPO = 'D') OR CREDITO IS NULL THEN 0\n" +
            "        ELSE (LANC.VALOR_LANCAMENTO - CREDITO)\n" +
            "    END) AS SALDO,\n" +
            "    (CASE\n" +
            "        WHEN (LANC.TIPO = 'C') OR CREDITO IS NULL THEN 0\n" +
            "        ELSE (LANC.VALOR_LANCAMENTO - CREDITO)\n" +
            "    END) AS DEVEDOR\n" +
            "FROM\n" +
            "    (SELECT \n" +
            "        A.CODIGO_LANCAMENTO,\n" +
            "            A.DATA_LANCAMENTO,\n" +
            "            A.SALDO_DIA,\n" +
            "            A.DESCONTO,\n" +
            "            A.DESCONTO_ENTREGA_ANTECIPADA,\n" +
            "            A.VALOR_PAGO,\n" +
            "            A.TROCO,\n" +
            "            A.VALOR_TOTAL_A_PAGAR,\n" +
            "            B.NOME_DEPENDENTE,\n" +
            "            B.TIPO_DEPENDENTE,\n" +
            "            B.CLIENTE_CODIGO_CLIENTE,\n" +
            "            C.CODIGO_TIPO_SERVICO,\n" +
            "            C.DESCRICAO,\n" +
            "            C.TIPO,\n" +
            "            D.LOGIN,\n" +
            "            D.NOME_USUARIO,\n" +
            "            A.VALOR_LANCAMENTO,\n" +
            "            A.LOCACAO_CODIGO_LOCACAO,\n" +    
            "            A.DEVOLUCAO_CODIGO_DEVOLUCAO,\n" +    
            "            A.VENDA_CODIGO_VENDA,\n" +    
            "            (SELECT \n" +
            "                    (CASE\n" +
            "                            WHEN SUM(VALOR_LANCAMENTO) IS NULL THEN 0\n" +
            "                            ELSE SUM(VALOR_LANCAMENTO)\n" +
            "                        END)\n" +
            "                FROM\n" +
            "                    ITEM_LANCAMENTO IL, TIPO_SERVICO TS\n" +
            "                WHERE\n" +
            "                    IL.TIPO_SERVICO_CODIGO_SERVICO = TS.CODIGO_TIPO_SERVICO\n" +
            "                        AND LANCAMENTO_CODIGO_LANCAMENTO = A.CODIGO_LANCAMENTO\n" +
            "                        AND TS.TIPO = 'C') AS CREDITO,\n" +
            "            (SELECT \n" +
            "                    (CASE\n" +
            "                            WHEN SUM(VALOR_LANCAMENTO) IS NULL THEN 0\n" +
            "                            ELSE SUM(VALOR_LANCAMENTO)\n" +
            "                        END)\n" +
            "                FROM\n" +
            "                    ITEM_LANCAMENTO IL, TIPO_SERVICO TS\n" +
            "                WHERE\n" +
            "                    IL.TIPO_SERVICO_CODIGO_SERVICO = TS.CODIGO_TIPO_SERVICO\n" +
            "                        AND LANCAMENTO_CODIGO_LANCAMENTO = A.CODIGO_LANCAMENTO\n" +
            "                        AND TS.TIPO = 'D') AS DEBITO\n" +
            "    FROM\n" +
            "        LANCAMENTO A, DEPENDENTE B, TIPO_SERVICO C, USUARIO D\n" +
            "    WHERE\n" +
            "        A.DEPENDENTE_CODIGO_DEPENDENTE = B.CODIGO_DEPENDENTE\n" +
            "            AND A.TIPO_SERVICO_CODIGO_TIPO_SERVICO = C.CODIGO_TIPO_SERVICO\n" +
            "            AND A.USUARIO_CODIGO_USUARIO = D.CODIGO_USUARIO\n" +
            "            AND B.CODIGO_DEPENDENTE IN (SELECT \n" +
            "                CODIGO_DEPENDENTE\n" +
            "            FROM\n" +
            "                DEPENDENTE\n" +
            "            WHERE\n" +
            "                CLIENTE_CODIGO_CLIENTE = ?)\n" +
            "    ORDER BY A.CODIGO_LANCAMENTO DESC) AS LANC;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, cliente.getCodigo_cliente());
            rs = ps.executeQuery();

            resultado = getListaLancamento(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    //SQL utilizado para tela de Recebimentos na consulta dos debitos do cliente em aberto
    public List<Lancamento> getLancamentosPendentes(Cliente cliente) {
        List<Lancamento> resultado = new ArrayList<Lancamento>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT \n" +
            "    *\n" +
            "FROM\n" +
            "    (SELECT \n" +
            "        *,\n" +
            "            (CASE\n" +
            "                WHEN (LANC.TIPO = 'D') OR DEBITO IS NULL THEN 0\n" +
            "                ELSE (LANC.VALOR_LANCAMENTO - DEBITO)\n" +
            "            END) AS SALDO,\n" +
            "            (CASE\n" +
            "                WHEN (LANC.TIPO = 'C') OR CREDITO IS NULL THEN 0\n" +
            "                ELSE (LANC.VALOR_LANCAMENTO - CREDITO)\n" +
            "            END) AS DEVEDOR\n" +
            "    FROM\n" +
            "        (SELECT \n" +
            "        A.CODIGO_LANCAMENTO,\n" +
            "            A.DATA_LANCAMENTO,\n" +
            "            A.SALDO_DIA,\n" +
            "            A.DESCONTO,\n" +
            "            A.DESCONTO_ENTREGA_ANTECIPADA,\n" +
            "            A.VALOR_PAGO,\n" +
            "            A.TROCO,\n" +
            "            A.VALOR_TOTAL_A_PAGAR,\n" +
            "            B.NOME_DEPENDENTE,\n" +
            "            B.TIPO_DEPENDENTE,\n" +
            "            B.CLIENTE_CODIGO_CLIENTE,\n" +
            "            C.CODIGO_TIPO_SERVICO,\n" +
            "            C.DESCRICAO,\n" +
            "            C.TIPO,\n" +
            "            D.LOGIN,\n" +
            "            D.NOME_USUARIO,\n" +
            "            A.VALOR_LANCAMENTO,\n" +
                "            A.LOCACAO_CODIGO_LOCACAO,\n" +    
            "            A.DEVOLUCAO_CODIGO_DEVOLUCAO,\n" +    
            "            A.VENDA_CODIGO_VENDA,\n" +    
            "            (SELECT \n" +
            "                    (CASE\n" +
            "                            WHEN SUM(VALOR_LANCAMENTO) IS NULL THEN 0\n" +
            "                            ELSE SUM(VALOR_LANCAMENTO)\n" +
            "                        END)\n" +
            "                FROM\n" +
            "                    ITEM_LANCAMENTO IL, TIPO_SERVICO TS\n" +
            "                WHERE\n" +
            "                    IL.TIPO_SERVICO_CODIGO_SERVICO = TS.CODIGO_TIPO_SERVICO\n" +
            "                        AND LANCAMENTO_CODIGO_LANCAMENTO = A.CODIGO_LANCAMENTO\n" +
            "                        AND TS.TIPO = 'C') AS CREDITO,\n" +
            "            (SELECT \n" +
            "                    (CASE\n" +
            "                            WHEN SUM(VALOR_LANCAMENTO) IS NULL THEN 0\n" +
            "                            ELSE SUM(VALOR_LANCAMENTO)\n" +
            "                        END)\n" +
            "                FROM\n" +
            "                    ITEM_LANCAMENTO IL, TIPO_SERVICO TS\n" +
            "                WHERE\n" +
            "                    IL.TIPO_SERVICO_CODIGO_SERVICO = TS.CODIGO_TIPO_SERVICO\n" +
            "                        AND LANCAMENTO_CODIGO_LANCAMENTO = A.CODIGO_LANCAMENTO\n" +
            "                        AND TS.TIPO = 'D') AS DEBITO\n" +
            "    FROM\n" +
            "        LANCAMENTO A, DEPENDENTE B, TIPO_SERVICO C, USUARIO D\n" +
            "    WHERE\n" +
            "        A.DEPENDENTE_CODIGO_DEPENDENTE = B.CODIGO_DEPENDENTE\n" +
            "            AND A.TIPO_SERVICO_CODIGO_TIPO_SERVICO = C.CODIGO_TIPO_SERVICO\n" +
            "            AND A.USUARIO_CODIGO_USUARIO = D.CODIGO_USUARIO\n" +
            "            AND C.TIPO = 'D'\n" +
            "            AND B.CODIGO_DEPENDENTE IN (SELECT \n" +
            "                CODIGO_DEPENDENTE\n" +
            "            FROM\n" +
            "                DEPENDENTE\n" +
            "            WHERE\n" +
            "                CLIENTE_CODIGO_CLIENTE = ?)\n" +
            "    ORDER BY A.CODIGO_LANCAMENTO DESC) AS LANC) AS FINAL\n" +
            "WHERE\n" +
            "    DEVEDOR > 0;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, cliente.getCodigo_cliente());
            rs = ps.executeQuery();

            resultado = getListaLancamento(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    //SQL Utilizado na consulta para mostrar os depósitos com saldo
    public List<Lancamento> getLancamentosDepositos(Cliente cliente) {
        List<Lancamento> resultado = new ArrayList<Lancamento>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT \n" +
            "    *\n" +
            "FROM\n" +
            "    (SELECT \n" +
            "        *,\n" +
            "            (CASE\n" +
            "                WHEN (LANC.TIPO = 'D') OR DEBITO IS NULL THEN 0\n" +
            "                ELSE (LANC.VALOR_LANCAMENTO - DEBITO)\n" +
            "            END) AS SALDO,\n" +
            "            (CASE\n" +
            "                WHEN (LANC.TIPO = 'C') OR CREDITO IS NULL THEN 0\n" +
            "                ELSE (LANC.VALOR_LANCAMENTO - CREDITO)\n" +
            "            END) AS DEVEDOR\n" +
            "    FROM\n" +
            "        (SELECT \n" +
            "        A.CODIGO_LANCAMENTO,\n" +
            "            A.DATA_LANCAMENTO,\n" +
            "            A.SALDO_DIA,\n" +
            "            A.DESCONTO,\n" +
            "            A.DESCONTO_ENTREGA_ANTECIPADA,\n" +
            "            A.VALOR_PAGO,\n" +
            "            A.TROCO,\n" +
            "            A.VALOR_TOTAL_A_PAGAR,\n" +
            "            B.NOME_DEPENDENTE,\n" +
            "            B.TIPO_DEPENDENTE,\n" +
            "            B.CLIENTE_CODIGO_CLIENTE,\n" +
            "            C.CODIGO_TIPO_SERVICO,\n" +
            "            C.DESCRICAO,\n" +
            "            C.TIPO,\n" +
            "            D.LOGIN,\n" +
            "            D.NOME_USUARIO,\n" +
            "            A.VALOR_LANCAMENTO,\n" +
                "            A.LOCACAO_CODIGO_LOCACAO,\n" +    
            "            A.DEVOLUCAO_CODIGO_DEVOLUCAO,\n" +    
            "            A.VENDA_CODIGO_VENDA,\n" +    
            "            (SELECT \n" +
            "                    (CASE\n" +
            "                            WHEN SUM(VALOR_LANCAMENTO) IS NULL THEN 0\n" +
            "                            ELSE SUM(VALOR_LANCAMENTO)\n" +
            "                        END)\n" +
            "                FROM\n" +
            "                    ITEM_LANCAMENTO IL, TIPO_SERVICO TS\n" +
            "                WHERE\n" +
            "                    IL.TIPO_SERVICO_CODIGO_SERVICO = TS.CODIGO_TIPO_SERVICO\n" +
            "                        AND LANCAMENTO_CODIGO_LANCAMENTO = A.CODIGO_LANCAMENTO\n" +
            "                        AND TS.TIPO = 'C') AS CREDITO,\n" +
            "            (SELECT \n" +
            "                    (CASE\n" +
            "                            WHEN SUM(VALOR_LANCAMENTO) IS NULL THEN 0\n" +
            "                            ELSE SUM(VALOR_LANCAMENTO)\n" +
            "                        END)\n" +
            "                FROM\n" +
            "                    ITEM_LANCAMENTO IL, TIPO_SERVICO TS\n" +
            "                WHERE\n" +
            "                    IL.TIPO_SERVICO_CODIGO_SERVICO = TS.CODIGO_TIPO_SERVICO\n" +
            "                        AND LANCAMENTO_CODIGO_LANCAMENTO = A.CODIGO_LANCAMENTO\n" +
            "                        AND TS.TIPO = 'D') AS DEBITO\n" +
            "    FROM\n" +
            "        LANCAMENTO A, DEPENDENTE B, TIPO_SERVICO C, USUARIO D\n" +
            "    WHERE\n" +
            "        A.DEPENDENTE_CODIGO_DEPENDENTE = B.CODIGO_DEPENDENTE\n" +
            "            AND A.TIPO_SERVICO_CODIGO_TIPO_SERVICO = C.CODIGO_TIPO_SERVICO\n" +
            "            AND A.USUARIO_CODIGO_USUARIO = D.CODIGO_USUARIO\n" +
            "            AND C.TIPO = 'C'\n" +
            "            AND B.CODIGO_DEPENDENTE IN (SELECT \n" +
            "                CODIGO_DEPENDENTE\n" +
            "            FROM\n" +
            "                DEPENDENTE\n" +
            "            WHERE\n" +
            "                CLIENTE_CODIGO_CLIENTE = ?)\n" +
            "    ORDER BY A.CODIGO_LANCAMENTO DESC) AS LANC) AS FINAL\n" +
            "WHERE\n" +
            "    SALDO > 0;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, cliente.getCodigo_cliente());
            rs = ps.executeQuery();

            resultado = getListaLancamento(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<Lancamento> getLancamentoCaixa() {
        List<Lancamento> resultado = new ArrayList<Lancamento>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT \n" +
            "    DATA_LANCAMENTO, CAIXA_CODIGO_CAIXA, SUM(VALOR) AS VALOR\n" +
            "FROM\n" +
            "    (SELECT \n" +
            "        A.data_lancamento,\n" +
            "            caixa_codigo_caixa,\n" +
            "            SUM(VALOR_LANCAMENTO) AS VALOR\n" +
            "    FROM\n" +
            "        LANCAMENTO A, TIPO_SERVICO B\n" +
            "    WHERE\n" +
            "        A.TIPO_SERVICO_CODIGO_TIPO_SERVICO = B.CODIGO_TIPO_SERVICO\n" +
            "            AND B.TIPO = 'C' AND B.CODIGO_TIPO_SERVICO = 4 UNION ALL SELECT \n" +
            "        A.data_lancamento,\n" +
            "            B.caixa_codigo_caixa,\n" +
            "            SUM(B.VALOR_LANCAMENTO) AS VALOR\n" +
            "    FROM\n" +
            "        LANCAMENTO A, ITEM_LANCAMENTO B, TIPO_SERVICO C\n" +
            "    WHERE\n" +
            "        A.CODIGO_LANCAMENTO = B.LANCAMENTO_CODIGO_LANCAMENTO\n" +
            "            AND B.TIPO_SERVICO_CODIGO_SERVICO = C.CODIGO_TIPO_SERVICO\n" +
            "            AND C.TIPO = 'C' AND C.CODIGO_TIPO_SERVICO IN (6,7,11)) AS SEGUNDO WHERE VALOR IS NOT NULL \n" +
            "GROUP BY DATA_LANCAMENTO , CAIXA_CODIGO_CAIXA\n" +
            "ORDER BY DATA_LANCAMENTO DESC;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaLancamentoCaixa(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<Lancamento> getLancamentoDetalhadoLocacaoDevolucao() {
        List<Lancamento> resultado = new ArrayList<Lancamento>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT \n" +
            "    *\n" +
            "FROM\n" +
            "    (SELECT \n" +
            "        A.data_lancamento,\n" +
            "            C.NOME_DEPENDENTE,\n" +
            "            B.DESCRICAO,\n" +
            "            B.TIPO,\n" +
            "            A.VALOR_LANCAMENTO AS VALOR,\n" +
            "            caixa_codigo_caixa,\n" +
            "            D.NOME_USUARIO\n" +
            "    FROM\n" +
            "        LANCAMENTO A, TIPO_SERVICO B, DEPENDENTE C, USUARIO D\n" +
            "    WHERE\n" +
            "        A.DEPENDENTE_CODIGO_DEPENDENTE = C.CODIGO_DEPENDENTE\n" +
            "            AND A.USUARIO_CODIGO_USUARIO = D.CODIGO_USUARIO\n" +            
            "            AND A.TIPO_SERVICO_CODIGO_TIPO_SERVICO = B.CODIGO_TIPO_SERVICO\n" +
            "            AND B.TIPO = 'C' AND CODIGO_TIPO_SERVICO = 4 UNION ALL SELECT \n" +
            "        B.data_lancamento,\n" +
            "            D.NOME_DEPENDENTE,\n" +
            "            C.DESCRICAO,\n" +
            "            C.TIPO,\n" +
            "            B.VALOR_LANCAMENTO AS VALOR,\n" +
            "            B.caixa_codigo_caixa,\n" +
            "            E.NOME_USUARIO\n" +
            "    FROM\n" +
            "        LANCAMENTO A, ITEM_LANCAMENTO B, TIPO_SERVICO C, DEPENDENTE D, USUARIO E\n" +
            "    WHERE\n" +
            "        A.CODIGO_LANCAMENTO = B.LANCAMENTO_CODIGO_LANCAMENTO\n" +
            "            AND B.TIPO_SERVICO_CODIGO_SERVICO = C.CODIGO_TIPO_SERVICO\n" +
            "            AND A.DEPENDENTE_CODIGO_DEPENDENTE = D.CODIGO_DEPENDENTE\n" +
            "            AND B.USUARIO_CODIGO_USUARIO = E.CODIGO_USUARIO\n" +
            "            AND C.TIPO = 'C'\n" +
            "            AND C.CODIGO_TIPO_SERVICO IN (6 , 7)) AS FLUXO\n" +
            "ORDER BY DATA_LANCAMENTO DESC;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaLancamentoDetalhado(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    public List<Lancamento> getLancamentoDetalhadoDesconto() {
        List<Lancamento> resultado = new ArrayList<Lancamento>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT \n" +
            "    *\n" +
            "FROM\n" +
            "    (SELECT \n" +
            "        A.data_lancamento,\n" +
            "            C.NOME_DEPENDENTE,\n" +
            "            B.DESCRICAO,\n" +
            "            B.TIPO,\n" +
            "            A.VALOR_LANCAMENTO AS VALOR,\n" +
            "            caixa_codigo_caixa,\n" +
            "            D.NOME_USUARIO\n" +
            "    FROM\n" +
            "        LANCAMENTO A, TIPO_SERVICO B, DEPENDENTE C, USUARIO D\n" +
            "    WHERE\n" +
            "        A.DEPENDENTE_CODIGO_DEPENDENTE = C.CODIGO_DEPENDENTE\n" +
            "            AND A.USUARIO_CODIGO_USUARIO = D.CODIGO_USUARIO\n" +
            "            AND A.TIPO_SERVICO_CODIGO_TIPO_SERVICO = B.CODIGO_TIPO_SERVICO\n" +
            "            AND B.TIPO = 'C'\n" +
            "            AND CODIGO_TIPO_SERVICO = 9 UNION ALL SELECT \n" +
            "        B.data_lancamento,\n" +
            "            D.NOME_DEPENDENTE,\n" +
            "            C.DESCRICAO,\n" +
            "            C.TIPO,\n" +
            "            B.VALOR_LANCAMENTO AS VALOR,\n" +
            "            B.caixa_codigo_caixa,\n" +
            "            E.NOME_USUARIO\n" +
            "    FROM\n" +
            "        LANCAMENTO A, ITEM_LANCAMENTO B, TIPO_SERVICO C, DEPENDENTE D, USUARIO E\n" +
            "    WHERE\n" +
            "        A.CODIGO_LANCAMENTO = B.LANCAMENTO_CODIGO_LANCAMENTO\n" +
            "            AND B.TIPO_SERVICO_CODIGO_SERVICO = C.CODIGO_TIPO_SERVICO\n" +
            "            AND A.DEPENDENTE_CODIGO_DEPENDENTE = D.CODIGO_DEPENDENTE\n" +
            "            AND B.USUARIO_CODIGO_USUARIO = E.CODIGO_USUARIO\n" +
            "            AND C.TIPO = 'C'\n" +
            "            AND C.CODIGO_TIPO_SERVICO IN (3 , 8, 12, 9)) AS FLUXO\n" +
            "ORDER BY DATA_LANCAMENTO DESC";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaLancamentoDetalhado(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    public List<Lancamento> getLancamentoDetalhadoCreditoDanificado() {
        List<Lancamento> resultado = new ArrayList<Lancamento>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT \n" +
            "    A.data_lancamento,\n" +
            "    C.NOME_DEPENDENTE,\n" +
            "    B.DESCRICAO,\n" +
            "    B.TIPO,\n" +
            "    A.VALOR_LANCAMENTO AS VALOR,\n" +
            "    caixa_codigo_caixa,\n" +
            "    D.NOME_USUARIO\n" +
            "FROM\n" +
            "    LANCAMENTO A,\n" +
            "    TIPO_SERVICO B,\n" +
            "    DEPENDENTE C,\n" +
            "    USUARIO D\n" +
            "WHERE\n" +
            "    A.DEPENDENTE_CODIGO_DEPENDENTE = C.CODIGO_DEPENDENTE\n" +
            "        AND A.USUARIO_CODIGO_USUARIO = D.CODIGO_USUARIO\n" +
            "        AND A.TIPO_SERVICO_CODIGO_TIPO_SERVICO = B.CODIGO_TIPO_SERVICO\n" +
            "        AND B.TIPO = 'C'\n" +
            "        AND CODIGO_TIPO_SERVICO = 15\n" +
            "ORDER BY DATA_LANCAMENTO DESC";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaLancamentoDetalhado(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    public List<Lancamento> getLancamentoDetalhadoVenda() {
        List<Lancamento> resultado = new ArrayList<Lancamento>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT \n" +
            "    B.data_lancamento,\n" +
            "    D.NOME_DEPENDENTE,\n" +
            "    C.DESCRICAO,\n" +
            "    C.TIPO,\n" +
            "    B.VALOR_LANCAMENTO AS VALOR,\n" +
            "    B.caixa_codigo_caixa,\n" +
            "    E.NOME_USUARIO\n" +
            "FROM\n" +
            "    LANCAMENTO A,\n" +
            "    ITEM_LANCAMENTO B,\n" +
            "    TIPO_SERVICO C,\n" +
            "    DEPENDENTE D,\n" +
            "    USUARIO E\n" +
            "WHERE\n" +
            "    A.CODIGO_LANCAMENTO = B.LANCAMENTO_CODIGO_LANCAMENTO\n" +
            "        AND B.TIPO_SERVICO_CODIGO_SERVICO = C.CODIGO_TIPO_SERVICO\n" +
            "        AND A.DEPENDENTE_CODIGO_DEPENDENTE = D.CODIGO_DEPENDENTE\n" +
            "        AND B.USUARIO_CODIGO_USUARIO = E.CODIGO_USUARIO\n" +
            "        AND C.TIPO = 'C'\n" +
            "        AND C.CODIGO_TIPO_SERVICO = 11\n" +
            "        ORDER BY DATA_LANCAMENTO DESC";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaLancamentoDetalhado(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    public List<Lancamento> getLancamentoDetalhadoTodos() {
        List<Lancamento> resultado = new ArrayList<Lancamento>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT \n" +
            "    *\n" +
            "FROM\n" +
            "    (SELECT \n" +
            "        A.data_lancamento,\n" +
            "            C.NOME_DEPENDENTE,\n" +
            "            B.DESCRICAO,\n" +
            "            B.TIPO,\n" +
            "            A.VALOR_LANCAMENTO AS VALOR,\n" +
            "            caixa_codigo_caixa,\n" +
            "            D.NOME_USUARIO\n" +
            "    FROM\n" +
            "        LANCAMENTO A, TIPO_SERVICO B, DEPENDENTE C, USUARIO D\n" +
            "    WHERE\n" +
            "        A.DEPENDENTE_CODIGO_DEPENDENTE = C.CODIGO_DEPENDENTE\n" +
            "            AND A.USUARIO_CODIGO_USUARIO = D.CODIGO_USUARIO\n" +            
            "            AND A.TIPO_SERVICO_CODIGO_TIPO_SERVICO = B.CODIGO_TIPO_SERVICO\n" +
            "            AND B.TIPO = 'C' UNION ALL SELECT \n" +
            "        B.data_lancamento,\n" +
            "            D.NOME_DEPENDENTE,\n" +
            "            C.DESCRICAO,\n" +
            "            C.TIPO,\n" +
            "            B.VALOR_LANCAMENTO AS VALOR,\n" +
            "            B.caixa_codigo_caixa,\n" +
            "            E.NOME_USUARIO\n" +
            "    FROM\n" +
            "        LANCAMENTO A, ITEM_LANCAMENTO B, TIPO_SERVICO C, DEPENDENTE D, USUARIO E\n" +
            "    WHERE\n" +
            "        A.CODIGO_LANCAMENTO = B.LANCAMENTO_CODIGO_LANCAMENTO\n" +
            "            AND B.TIPO_SERVICO_CODIGO_SERVICO = C.CODIGO_TIPO_SERVICO\n" +
            "            AND A.DEPENDENTE_CODIGO_DEPENDENTE = D.CODIGO_DEPENDENTE\n" +
            "            AND B.USUARIO_CODIGO_USUARIO = E.CODIGO_USUARIO\n" +
            "            AND C.TIPO = 'C'\n" +
            "            AND C.CODIGO_TIPO_SERVICO IN (6 , 7, 11, 3 , 8, 12, 9)) AS FLUXO\n" +
            "ORDER BY DATA_LANCAMENTO DESC;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaLancamentoDetalhado(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }


    private List<Lancamento> getListaLancamento(ResultSet rs) throws SQLException {
        List<Lancamento> resultado = new ArrayList<Lancamento>();
        while (rs.next()) {
            Lancamento lancamento = new Lancamento();
            lancamento.setCodigo_lancamento(rs.getInt("CODIGO_LANCAMENTO"));
            lancamento.setData_lancamento(rs.getDate("DATA_LANCAMENTO"));
            lancamento.setValor_total(rs.getDouble("VALOR_LANCAMENTO"));
            lancamento.setSaldo(rs.getDouble("SALDO"));
            lancamento.setDevedor(rs.getDouble("DEVEDOR"));
            lancamento.setSaldo_dia(rs.getDouble("SALDO_DIA"));
            lancamento.setDesconto(rs.getDouble("DESCONTO"));
            lancamento.setDesconto_entrega_antecipada(rs.getDouble("DESCONTO_ENTREGA_ANTECIPADA"));
            lancamento.setValor_pago(rs.getDouble("VALOR_PAGO"));
            lancamento.setTroco(rs.getDouble("TROCO"));
            lancamento.setValor_total_a_pagar(rs.getDouble("VALOR_TOTAL_A_PAGAR"));
            Locacao locacao = new Locacao();
            locacao.setCodigo_locacao(rs.getInt("LOCACAO_CODIGO_LOCACAO"));
            Devolucao devolucao = new Devolucao();
            devolucao.setCodigo_devolucao(rs.getInt("DEVOLUCAO_CODIGO_DEVOLUCAO"));
            Venda venda = new Venda();
            venda.setCodigo_venda(rs.getInt("VENDA_CODIGO_VENDA"));
            lancamento.setLocacao(locacao);
            lancamento.setDevolucao(devolucao);
            lancamento.setVenda(venda);
            
            TipoServico tipo_servico = new TipoServico();
            tipo_servico.setCodigo_tipo_servico(rs.getInt("CODIGO_TIPO_SERVICO"));
            tipo_servico.setDescricao(rs.getString("DESCRICAO"));
            tipo_servico.setTipo(rs.getString("TIPO"));
            lancamento.setTipoServico(tipo_servico);
            
            Dependente dependente = new Dependente();
            dependente.setNome_dependente(rs.getString("NOME_DEPENDENTE"));
            
            if (rs.getInt("TIPO_DEPENDENTE") == 0) {
                dependente.setTipo_dependente("Cliente");

            } else {
                dependente.setTipo_dependente("Dependente");
            }
            Cliente cliente = new Cliente();
            cliente.setCodigo_cliente(rs.getInt("CLIENTE_CODIGO_CLIENTE"));
            dependente.setCliente(cliente);
            
            lancamento.setDependente(dependente);
            
            Usuario usuario = new Usuario();
            usuario.setLogin(rs.getString("LOGIN"));
            usuario.setNome_usuario(rs.getString("NOME_USUARIO"));
            lancamento.setUsuario(usuario);
            resultado.add(lancamento);
        }
        return resultado;
    }

    private List<Lancamento> getListaLancamentoCaixa(ResultSet rs) throws SQLException {
        List<Lancamento> resultado = new ArrayList<Lancamento>();
        while (rs.next()) {
            Lancamento lancamento = new Lancamento();
            lancamento.setData_lancamento(rs.getDate("DATA_LANCAMENTO"));
            lancamento.setCaixa(rs.getInt("CAIXA_CODIGO_CAIXA"));
            lancamento.setValor_total(rs.getDouble("VALOR"));

            resultado.add(lancamento);
        }
        return resultado;
    }

    private List<Lancamento> getListaLancamentoDetalhado(ResultSet rs) throws SQLException {
        List<Lancamento> resultado = new ArrayList<Lancamento>();
        while (rs.next()) {
            Dependente dependente = new Dependente();
            dependente.setNome_dependente(rs.getString("NOME_DEPENDENTE"));

            TipoServico tipoServico = new TipoServico();
            tipoServico.setDescricao(rs.getString("DESCRICAO"));
            tipoServico.setTipo(rs.getString("TIPO"));

            Usuario usuario = new Usuario();
            usuario.setNome_usuario(rs.getString("NOME_USUARIO"));

            Lancamento lancamento = new Lancamento();
            lancamento.setValor_total(rs.getDouble("VALOR"));
            lancamento.setCaixa(rs.getInt("CAIXA_CODIGO_CAIXA"));
            lancamento.setData_lancamento(rs.getDate("DATA_LANCAMENTO"));

            lancamento.setTipoServico(tipoServico);
            lancamento.setDependente(dependente);
            lancamento.setUsuario(usuario);

            resultado.add(lancamento);
        }
        return resultado;
    }
    public Lancamento salvarLancamento(Lancamento lancamento) {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlLancamento = "INSERT INTO lancamento(`DATA_LANCAMENTO`,`VALOR_LANCAMENTO`,\n" +
            "`DEPENDENTE_CODIGO_DEPENDENTE`,`TIPO_SERVICO_CODIGO_TIPO_SERVICO`,\n" +
            "`USUARIO_CODIGO_USUARIO`,`CAIXA_CODIGO_CAIXA`,`CLIENTE_CODIGO_CLIENTE`,\n" +
            "`LOCACAO_CODIGO_LOCACAO`,`VENDA_CODIGO_VENDA`,`DEVOLUCAO_CODIGO_DEVOLUCAO`, SALDO_DIA, DESCONTO, DESCONTO_ENTREGA_ANTECIPADA, "
                + "VALOR_PAGO, TROCO, VALOR_TOTAL_A_PAGAR)\n" +
            "VALUES(current_date(),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        try {

            ps = con.prepareStatement(sqlLancamento);
            
            ps.setDouble(1, lancamento.getValor_total());
            ps.setInt(2, lancamento.getDependente().getCodigo_dependente());
            ps.setInt(3, lancamento.getTipoServico().getCodigo_tipo_servico());
            ps.setInt(4, lancamento.getUsuario().getCodigo_usuario());
            ps.setInt(5, lancamento.getCaixa());
            ps.setInt(6, lancamento.getDependente().getCliente().getCodigo_cliente());
            ps.setInt(7, lancamento.getLocacao().getCodigo_locacao());
            ps.setInt(8, lancamento.getVenda().getCodigo_venda());
            ps.setInt(9, lancamento.getDevolucao().getCodigo_devolucao());
            ps.setDouble(10, lancamento.getSaldo_dia());
            ps.setDouble(11, lancamento.getDesconto());
            ps.setDouble(12, lancamento.getDesconto_entrega_antecipada());
            ps.setDouble(13, lancamento.getValor_pago());
            ps.setDouble(14, lancamento.getTroco());
            ps.setDouble(15, lancamento.getValor_total_a_pagar());
            ps.executeUpdate();           

            ResultSet res;
            Integer codigo_max;
            String sql_max = "SELECT MAX(CODIGO_LANCAMENTO) FROM LANCAMENTO";

            ps = con.prepareStatement(sql_max);
            res = ps.executeQuery();
            res.next();
            codigo_max = res.getInt("MAX(CODIGO_LANCAMENTO)");
            lancamento.setCodigo_lancamento(codigo_max);
            
            ps.close();
            return lancamento;
            
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            pool.liberarConnection(con);
        }
    }
    
    public void salvarItemLancamento(List<ItemLancamento> itensLancamento) {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlLancamento = "INSERT INTO `item_lancamento`(`data_lancamento`,`valor_lancamento`,\n" +
            "`tipo_servico_codigo_servico`,`lancamento_codigo_lancamento`,\n" +
            "usuario_codigo_usuario,caixa_codigo_caixa)\n" +
            "VALUES(?,?,?,?,?,?);";

        try {
            ps = con.prepareStatement(sqlLancamento);
            
            for(int i =0; i < itensLancamento.size(); i++){
                Date data_lancamento_item = null;
                if (itensLancamento.get(i).getData_lancamento() != null) {
                    data_lancamento_item = new Date(itensLancamento.get(i).getData_lancamento().getTime());
                }

                ps.setDate(1, data_lancamento_item);
                ps.setDouble(2, itensLancamento.get(i).getValor_lancamento());
                ps.setInt(3, itensLancamento.get(i).getTipoServico().getCodigo_tipo_servico());
                ps.setInt(4, itensLancamento.get(i).getLancamento().getCodigo_lancamento());
                ps.setInt(5, itensLancamento.get(i).getUsuario().getCodigo_usuario());            
                ps.setInt(6, itensLancamento.get(i).getCaixa());
                ps.executeUpdate();                           
            }

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);            
        } finally {
            pool.liberarConnection(con);
        }
    }

    private void setPreparedStatement1(Lancamento lancamento, PreparedStatement ps)
            throws SQLException {

        ps.setInt(1, lancamento.getDependente().getCodigo_dependente());
        ps.setInt(2, lancamento.getUsuario().getCodigo_usuario());

    }

    private void setPreparedStatement(Lancamento lancamento, PreparedStatement ps)
            throws SQLException {

        ps.setInt(1, lancamento.getDependente().getCodigo_dependente());
        ps.setInt(2, lancamento.getUsuario().getCodigo_usuario());

    }

    private void setPreparedStatementLancamento(Lancamento lancamento, PreparedStatement ps)
            throws SQLException {

        ps.setDouble(1, lancamento.getValor_total());
        ps.setInt(2, lancamento.getDependente().getCodigo_dependente());
        ps.setInt(3, lancamento.getTipoServico().getCodigo_tipo_servico());
        ps.setInt(4, lancamento.getUsuario().getCodigo_usuario());
        ps.setInt(5, lancamento.getCaixa());

    }
    
    public List<ItemLancamento> getItemLancamento(Lancamento lancamento){        
        List<ItemLancamento> resultado = new ArrayList<ItemLancamento>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT CODIGO_ITEM_LANCAMENTO, \n" +
            "    B.DATA_LANCAMENTO,\n" +
            "    C.DESCRICAO,\n" +
            "    C.TIPO,\n" +
            "    B.VALOR_LANCAMENTO,\n" +
            "    D.NOME_USUARIO\n" +
            "FROM\n" +
            "    LANCAMENTO A,\n" +
            "    ITEM_LANCAMENTO B,\n" +
            "    TIPO_SERVICO C,\n" +
            "    USUARIO D\n" +
            "WHERE\n" +
            "    A.CODIGO_LANCAMENTO = B.LANCAMENTO_CODIGO_LANCAMENTO\n" +
            "        AND B.tipo_servico_codigo_servico = C.CODIGO_TIPO_SERVICO\n" +
            "        AND B.usuario_codigo_usuario = D.CODIGO_USUARIO\n" +
            "        AND CODIGO_LANCAMENTO = ?;";
        ResultSet rs = null;        

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, lancamento.getCodigo_lancamento());
            rs = ps.executeQuery();
            
            while(rs.next()){
                ItemLancamento itemLancamento = new ItemLancamento();
                itemLancamento.setCodigo_item_lancamento(rs.getInt("CODIGO_ITEM_LANCAMENTO"));
                itemLancamento.setData_lancamento(rs.getDate("DATA_LANCAMENTO"));
                itemLancamento.setValor_lancamento(rs.getDouble("VALOR_LANCAMENTO"));
                TipoServico tipoServico = new TipoServico();
                tipoServico.setDescricao(rs.getString("DESCRICAO"));
                tipoServico.setTipo(rs.getString("TIPO"));
                Usuario usuario = new Usuario();
                usuario.setNome_usuario(rs.getString("NOME_USUARIO"));
                        
                itemLancamento.setTipoServico(tipoServico);
                itemLancamento.setUsuario(usuario);
                resultado.add(itemLancamento);
            }
            
            
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    

}
