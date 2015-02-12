/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Categoria;
import br.com.locadora.model.bean.Fornecedor;
import br.com.locadora.model.bean.LancamentoConta;
import br.com.locadora.model.bean.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALENCAR
 */
public class LancamentoContaDAO {

    private InterfacePool pool;

    public LancamentoContaDAO(InterfacePool pool) {
        this.pool = pool;
    }

    public void salvar(LancamentoConta lancamentoConta) {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `lancamento_conta`(`DESCRICAO`,`DOCUMENTO`,`VALOR_A_PAGAR`,\n"
                + "`VALOR_PAGO`,`DATA_LANCAMENTO`,`DATA_VENCIMENTO`,`DATA_PAGAMENTO`,\n"
                + "`FORNECEDOR_CODIGO_FORNECEDOR`, USUARIO_CODIGO_USUARIO, CAIXA_CODIGO_CAIXA, CATEGORIA_CODIGO_CATEGORIA) "
                + "VALUES(?,?,?,?,current_date(),?,?,?, ?, ?,?);";

        try {
            ps = con.prepareStatement(sqlInsert);

            setPreparedStatement(lancamentoConta, ps);

            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(LancamentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
    }

    public void atualizar(LancamentoConta lancamentoConta) {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlUpdate = "UPDATE `lancamento_conta` SET `DESCRICAO` = ?,`DOCUMENTO` = ?,\n"
                + "`VALOR_A_PAGAR` = ?,`VALOR_PAGO` = ?,`DATA_VENCIMENTO` = ?,\n"
                + "`DATA_PAGAMENTO` = ?,`FORNECEDOR_CODIGO_FORNECEDOR` = ?, USUARIO_CODIGO_USUARIO = ?, CAIXA_CODIGO_CAIXA = ? ,"
                + " CATEGORIA_CODIGO_CATEGORIA = ? WHERE `CODIGO_LANCAMENTO_CONTA` = ?;";
        try {
            ps = con.prepareStatement(sqlUpdate);

            setPreparedStatement1(lancamentoConta, ps);

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(LancamentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
    }

    public void excluir(Integer codigo) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlExcluir = "DELETE FROM LANCAMENTO_CONTA WHERE CODIGO_LANCAMENTO_CONTA = ?;";

        try {
            ps = con.prepareStatement(sqlExcluir);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }

    public List<LancamentoConta> getLancamentoContas(String dataInicial, String dataFinal, String categoria_codigo_categoria) {
        List<LancamentoConta> resultado = new ArrayList<LancamentoConta>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n" +
            "    *\n" +
            "FROM\n" +
            "    (SELECT \n" +
            "        A.DATA_LANCAMENTO AS DATA_VENCIMENTO,\n" +
            "            A.CODIGO_LANCAMENTO AS CODIGO_LANCAMENTO_CONTA,\n" +
            "            0 AS CODIGO_FORNECEDOR,\n" +
            "            C.NOME_DEPENDENTE AS ORIGEM_DESTINO,\n" +
            "            B.DESCRICAO,\n" +
            "            A.CODIGO_LANCAMENTO AS DOCUMENTO,\n" +
            "            A.VALOR_LANCAMENTO AS VALOR_A_PAGAR,\n" +
            "            A.VALOR_LANCAMENTO AS VALOR_PAGO,\n" +
            "            A.DATA_LANCAMENTO AS DATA_PAGAMENTO,\n" +
            "            D.NOME_USUARIO,\n" +
            "            A.CAIXA_CODIGO_CAIXA,\n" +
            "            0 AS CATEGORIA_CODIGO_CATEGORIA\n" +
            "    FROM\n" +
            "        LANCAMENTO A, TIPO_SERVICO B, DEPENDENTE C, USUARIO D\n" +
            "    WHERE\n" +
            "        A.TIPO_SERVICO_CODIGO_TIPO_SERVICO = B.CODIGO_TIPO_SERVICO\n" +
            "            AND D.CODIGO_USUARIO = A.USUARIO_CODIGO_USUARIO\n" +
            "            AND A.DEPENDENTE_CODIGO_DEPENDENTE = C.CODIGO_DEPENDENTE\n" +
            "            AND A.DATA_LANCAMENTO BETWEEN ? AND ?\n" +
            "            AND B.TIPO = 'C' AND B.CODIGO_TIPO_SERVICO = 4 ) AS PRIMEIRO \n" +
            "UNION ALL (SELECT \n" +
            "    B.DATA_LANCAMENTO AS DATA_VENCIMENTO,\n" +
            "    A.CODIGO_LANCAMENTO AS CODIGO_LANCAMENTO_CONTA,\n" +
            "    0 AS CODIGO_FORNECEDOR,\n" +
            "    D.NOME_DEPENDENTE AS ORIGEM_DESTINO,\n" +
            "    C.DESCRICAO,\n" +
            "    A.CODIGO_LANCAMENTO AS DOCUMENTO,\n" +
            "    B.VALOR_LANCAMENTO AS VALOR_A_PAGAR,\n" +
            "    B.VALOR_LANCAMENTO AS VALOR_PAGO,\n" +
            "    B.DATA_LANCAMENTO AS DATA_PAGAMENTO,\n" +
            "    E.NOME_USUARIO,\n" +
            "    B.CAIXA_CODIGO_CAIXA,\n" +
            "    0 AS CATEGORIA_CODIGO_CATEGORIA\n" +
            "FROM\n" +
            "    LANCAMENTO A,\n" +
            "    ITEM_LANCAMENTO B,\n" +
            "    TIPO_SERVICO C,\n" +
            "    DEPENDENTE D,\n" +
            "    USUARIO E\n" +
            "WHERE\n" +
            "    A.CODIGO_LANCAMENTO = B.LANCAMENTO_CODIGO_LANCAMENTO\n" +
            "        AND B.TIPO_SERVICO_CODIGO_SERVICO = C.CODIGO_TIPO_SERVICO\n" +
            "        AND E.CODIGO_USUARIO = B.USUARIO_CODIGO_USUARIO\n" +
            "        AND A.DEPENDENTE_CODIGO_DEPENDENTE = D.CODIGO_DEPENDENTE\n" +
            "        AND A.DATA_LANCAMENTO BETWEEN ? AND ? \n" +
            "        AND C.TIPO = 'C' AND CODIGO_TIPO_SERVICO IN (6,7,11) ) UNION ALL (SELECT \n" +
            "    DATA_VENCIMENTO,\n" +
            "    CODIGO_LANCAMENTO_CONTA,\n" +
            "    CODIGO_FORNECEDOR,\n" +
            "    NOME_FANTASIA AS ORIGEM_DESTINO,\n" +
            "    DESCRICAO,\n" +
            "    DOCUMENTO,\n" +
            "    VALOR_A_PAGAR,\n" +
            "    VALOR_PAGO,\n" +
            "    DATA_PAGAMENTO,\n" +
            "    C.NOME_USUARIO,\n" +
            "    A.CAIXA_CODIGO_CAIXA,\n" +
            "    CATEGORIA_CODIGO_CATEGORIA\n" +
            "FROM\n" +
            "    lancamento_conta A,\n" +
            "    FORNECEDOR B,\n" +
            "    USUARIO C\n" +
            "WHERE\n" +
            "    A.FORNECEDOR_CODIGO_FORNECEDOR = B.CODIGO_FORNECEDOR\n" +
            "        AND A.USUARIO_CODIGO_USUARIO = C.CODIGO_USUARIO\n" +
            "        AND DATA_VENCIMENTO BETWEEN ? AND ? AND CATEGORIA_CODIGO_CATEGORIA LIKE ?) UNION ALL (SELECT \n" +
            "    *\n" +
            "FROM\n" +
            "    (SELECT \n" +
            "        DATA_VENCIMENTO,\n" +
            "            CODIGO_LANCAMENTO AS CODIGO_LANCAMENTO_CONTA,\n" +
            "            0 AS CODIGO_FORNECEDOR,\n" +
            "            NOME_DEPENDENTE AS ORIGEM_DESTINO,\n" +
            "            DESCRICAO,\n" +
            "            DOCUMENTO,\n" +
            "            VALOR_LANCAMENTO AS VALOR_A_PAGAR,\n" +
            "            CREDITO AS VALOR_PAGO,\n" +
            "            DATA_LANCAMENTO AS DATA_PAGAMENTO,\n" +
            "            NOME_USUARIO,\n" +
            "            CAIXA_CODIGO_CAIXA,\n" +
            "            0 AS CATEGORIA_CODIGO_CATEGORIA\n" +
            "    FROM\n" +
            "        (SELECT \n" +
            "        A.DATA_LANCAMENTO AS DATA_VENCIMENTO,\n" +
            "            A.CODIGO_LANCAMENTO,\n" +
            "            0 AS CODIGO_FORNECEDOR,\n" +
            "            B.NOME_DEPENDENTE,\n" +
            "            C.DESCRICAO,\n" +
            "            C.CODIGO_TIPO_SERVICO,\n" +
            "            A.CODIGO_LANCAMENTO AS DOCUMENTO,\n" +
            "            C.TIPO,\n" +
            "            D.LOGIN,\n" +
            "            D.NOME_USUARIO,\n" +
            "            A.VALOR_LANCAMENTO,\n" +
            "            A.DATA_LANCAMENTO,\n" +
            "            A.CAIXA_CODIGO_CAIXA,\n" +
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
            "                        AND TS.TIPO = 'C') AS CREDITO\n" +
            "    FROM\n" +
            "        LANCAMENTO A, DEPENDENTE B, TIPO_SERVICO C, USUARIO D\n" +
            "    WHERE\n" +
            "        A.DEPENDENTE_CODIGO_DEPENDENTE = B.CODIGO_DEPENDENTE\n" +
            "            AND A.TIPO_SERVICO_CODIGO_TIPO_SERVICO = C.CODIGO_TIPO_SERVICO\n" +
            "            AND A.USUARIO_CODIGO_USUARIO = D.CODIGO_USUARIO\n" +
            "            AND C.TIPO = 'D'\n" +
            "            AND A.DATA_LANCAMENTO BETWEEN ? AND ?\n" +
            "    ORDER BY A.CODIGO_LANCAMENTO DESC) AS LANC) AS FINAL\n" +
            "WHERE\n" +
            "    VALOR_A_PAGAR > VALOR_PAGO) ORDER BY DATA_VENCIMENTO ASC;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, dataInicial);
            ps.setString(2, dataFinal);
            ps.setString(3, dataInicial);
            ps.setString(4, dataFinal);
            ps.setString(5, dataInicial);
            ps.setString(6, dataFinal);
            ps.setString(7, "%"+categoria_codigo_categoria+"%");
            ps.setString(8, dataInicial);
            ps.setString(9, dataFinal);

            rs = ps.executeQuery();

            resultado = getListaLancamentoContas(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<LancamentoConta> getLancamentoContasRecebidas(String dataInicial, String dataFinal) {
        List<LancamentoConta> resultado = new ArrayList<LancamentoConta>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    *\n"
                + "FROM\n"
                + "    (SELECT \n"
                + "        A.DATA_LANCAMENTO AS DATA_VENCIMENTO,\n"
                + "            A.CODIGO_LANCAMENTO AS CODIGO_LANCAMENTO_CONTA,\n"
                + "            0 AS CODIGO_FORNECEDOR,\n"
                + "            C.NOME_DEPENDENTE AS ORIGEM_DESTINO,\n"
                + "            B.DESCRICAO,\n"
                + "            A.CODIGO_LANCAMENTO AS DOCUMENTO,\n"
                + "            A.VALOR_LANCAMENTO AS VALOR_A_PAGAR,\n"
                + "            A.VALOR_LANCAMENTO AS VALOR_PAGO,\n"
                + "            A.DATA_LANCAMENTO AS DATA_PAGAMENTO,\n"
                + "            D.NOME_USUARIO,\n"
                + "            A.CAIXA_CODIGO_CAIXA,\n"
                + "            0 AS CATEGORIA_CODIGO_CATEGORIA\n"
                + "    FROM\n"
                + "        LANCAMENTO A, TIPO_SERVICO B, DEPENDENTE C, USUARIO D\n"
                + "    WHERE\n"
                + "        A.TIPO_SERVICO_CODIGO_TIPO_SERVICO = B.CODIGO_TIPO_SERVICO\n"
                + "            AND D.CODIGO_USUARIO = A.USUARIO_CODIGO_USUARIO\n"
                + "            AND A.DEPENDENTE_CODIGO_DEPENDENTE = C.CODIGO_DEPENDENTE\n"
                + "            AND A.DATA_LANCAMENTO BETWEEN ? AND ?\n"
                + "            AND B.TIPO = 'C' AND B.CODIGO_TIPO_SERVICO = 4) AS PRIMEIRO \n"
                + "UNION ALL (SELECT \n"
                + "    B.DATA_LANCAMENTO AS DATA_VENCIMENTO,\n"
                + "    A.CODIGO_LANCAMENTO AS CODIGO_LANCAMENTO_CONTA,\n"
                + "    0 AS CODIGO_FORNECEDOR,\n"
                + "    D.NOME_DEPENDENTE AS ORIGEM_DESTINO,\n"
                + "    C.DESCRICAO,\n"
                + "    A.CODIGO_LANCAMENTO AS DOCUMENTO,\n"
                + "    B.VALOR_LANCAMENTO AS VALOR_A_PAGAR,\n"
                + "    B.VALOR_LANCAMENTO AS VALOR_PAGO,\n"
                + "    B.DATA_LANCAMENTO AS DATA_PAGAMENTO,\n"
                + "    E.NOME_USUARIO,\n"
                + "    B.CAIXA_CODIGO_CAIXA,\n"
                + "    0 AS CATEGORIA_CODIGO_CATEGORIA\n"
                + "FROM\n"
                + "    LANCAMENTO A,\n"
                + "    ITEM_LANCAMENTO B,\n"
                + "    TIPO_SERVICO C,\n"
                + "    DEPENDENTE D,\n"
                + "    USUARIO E\n"
                + "WHERE\n"
                + "    A.CODIGO_LANCAMENTO = B.LANCAMENTO_CODIGO_LANCAMENTO\n"
                + "        AND B.TIPO_SERVICO_CODIGO_SERVICO = C.CODIGO_TIPO_SERVICO\n"
                + "        AND E.CODIGO_USUARIO = B.USUARIO_CODIGO_USUARIO\n"
                + "        AND A.DEPENDENTE_CODIGO_DEPENDENTE = D.CODIGO_DEPENDENTE\n"
                + "        AND A.DATA_LANCAMENTO BETWEEN ? AND ?\n"
                + "        AND C.TIPO = 'C' AND C.CODIGO_TIPO_SERVICO IN (6,7,11))";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, dataInicial);
            ps.setString(2, dataFinal);
            ps.setString(3, dataInicial);
            ps.setString(4, dataFinal);

            rs = ps.executeQuery();

            resultado = getListaLancamentoContas(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<LancamentoConta> getLancamentoContasAReceber(String dataInicial, String dataFinal) {
        List<LancamentoConta> resultado = new ArrayList<LancamentoConta>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT\n" +
            "    *\n" +
            "FROM\n" +
            "    (SELECT\n" +
            "        DATA_VENCIMENTO,\n" +
            "            CODIGO_LANCAMENTO AS CODIGO_LANCAMENTO_CONTA,\n" +
            "            0 AS CODIGO_FORNECEDOR,\n" +
            "            NOME_DEPENDENTE AS ORIGEM_DESTINO,\n" +
            "            DESCRICAO,\n" +
            "            CODIGO_TIPO_SERVICO,\n" +
            "            DOCUMENTO,\n" +
            "            VALOR_LANCAMENTO AS VALOR_A_PAGAR,\n" +
            "            CREDITO AS VALOR_PAGO,\n" +
            "            DATA_LANCAMENTO AS DATA_PAGAMENTO,\n" +
            "            NOME_USUARIO,\n" +
            "            CAIXA_CODIGO_CAIXA,\n" +
            "            0 AS CATEGORIA_CODIGO_CATEGORIA\n" +
            "    FROM\n" +
            "        (SELECT\n" +
            "        A.DATA_LANCAMENTO AS DATA_VENCIMENTO,\n" +
            "            A.CODIGO_LANCAMENTO,\n" +
            "            0 AS CODIGO_FORNECEDOR,\n" +
            "            B.NOME_DEPENDENTE,\n" +
            "            C.DESCRICAO,\n" +
            "            C.CODIGO_TIPO_SERVICO,\n" +
            "            A.CODIGO_LANCAMENTO AS DOCUMENTO,\n" +
            "            C.TIPO,\n" +
            "            D.LOGIN,\n" +
            "            D.NOME_USUARIO,\n" +
            "            A.VALOR_LANCAMENTO,\n" +
            "            A.DATA_LANCAMENTO,\n" +
            "            A.CAIXA_CODIGO_CAIXA,\n" +
            "            (SELECT\n" +
            "                    (CASE\n" +
            "                            WHEN SUM(VALOR_LANCAMENTO) IS NULL THEN 0\n" +
            "                            ELSE SUM(VALOR_LANCAMENTO)\n" +
            "                        END)\n" +
            "                FROM\n" +
            "                    ITEM_LANCAMENTO IL, TIPO_SERVICO TS\n" +
            "                WHERE\n" +
            "                    IL.TIPO_SERVICO_CODIGO_SERVICO = TS.CODIGO_TIPO_SERVICO\n" +
            "                        AND LANCAMENTO_CODIGO_LANCAMENTO = A.CODIGO_LANCAMENTO\n" +
            "                        AND TS.TIPO = 'C') AS CREDITO\n" +
            "    FROM\n" +
            "        LANCAMENTO A, DEPENDENTE B, TIPO_SERVICO C, USUARIO D\n" +
            "    WHERE\n" +
            "        A.DEPENDENTE_CODIGO_DEPENDENTE = B.CODIGO_DEPENDENTE\n" +
            "            AND A.TIPO_SERVICO_CODIGO_TIPO_SERVICO = C.CODIGO_TIPO_SERVICO\n" +
            "            AND A.USUARIO_CODIGO_USUARIO = D.CODIGO_USUARIO\n" +
            "            AND C.TIPO = 'D'\n" +
            "            AND A.DATA_LANCAMENTO BETWEEN ? AND ?\n" +
            "    ORDER BY A.CODIGO_LANCAMENTO DESC) AS LANC) AS FINAL\n" +
            "WHERE\n" +
            "    VALOR_A_PAGAR > VALOR_PAGO;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, dataInicial);
            ps.setString(2, dataFinal);

            rs = ps.executeQuery();

            resultado = getListaLancamentoContas(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<LancamentoConta> getLancamentoContasVencidas(String dataInicial, String dataFinal, String categoria_codigo_categoria) {
        List<LancamentoConta> resultado = new ArrayList<LancamentoConta>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    DATA_VENCIMENTO,\n"
                + "    CODIGO_LANCAMENTO_CONTA,\n"
                + "    CODIGO_FORNECEDOR,\n"
                + "    NOME_FANTASIA AS ORIGEM_DESTINO,\n"
                + "    DESCRICAO,\n"
                + "    DOCUMENTO,\n"
                + "    VALOR_A_PAGAR,\n"
                + "    VALOR_PAGO,\n"
                + "    DATA_PAGAMENTO,\n"
                + "    C.NOME_USUARIO,\n"
                + "    A.CAIXA_CODIGO_CAIXA, CATEGORIA_CODIGO_CATEGORIA \n"
                + "FROM\n"
                + "    lancamento_conta A,\n"
                + "    FORNECEDOR B,\n"
                + "    USUARIO C\n"
                + "WHERE\n"
                + "    A.FORNECEDOR_CODIGO_FORNECEDOR = B.CODIGO_FORNECEDOR\n"
                + "        AND A.USUARIO_CODIGO_USUARIO = C.CODIGO_USUARIO\n"
                + "        AND DATA_VENCIMENTO BETWEEN ? AND ? AND CATEGORIA_CODIGO_CATEGORIA LIKE ? \n"
                + "        AND DATA_VENCIMENTO < CURRENT_DATE()\n"
                + "        AND DATA_PAGAMENTO IS NULL OR DATA_PAGAMENTO = '' ORDER BY DATA_VENCIMENTO";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, dataInicial);
            ps.setString(2, dataFinal);
            ps.setString(3, "%"+categoria_codigo_categoria+"%");

            rs = ps.executeQuery();

            resultado = getListaLancamentoContas(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<LancamentoConta> getLancamentoContasAPagar(String dataInicial, String dataFinal, String categoria_codigo_categoria) {
        List<LancamentoConta> resultado = new ArrayList<LancamentoConta>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    DATA_VENCIMENTO,\n"
                + "    CODIGO_LANCAMENTO_CONTA,\n"
                + "    CODIGO_FORNECEDOR,\n"
                + "    NOME_FANTASIA AS ORIGEM_DESTINO,\n"
                + "    DESCRICAO,\n"
                + "    DOCUMENTO,\n"
                + "    VALOR_A_PAGAR,\n"
                + "    VALOR_PAGO,\n"
                + "    DATA_PAGAMENTO,\n"
                + "    C.NOME_USUARIO,\n"
                + "    A.CAIXA_CODIGO_CAIXA, CATEGORIA_CODIGO_CATEGORIA \n"
                + "FROM\n"
                + "    lancamento_conta A,\n"
                + "    FORNECEDOR B,\n"
                + "    USUARIO C\n"
                + "WHERE\n"
                + "    A.FORNECEDOR_CODIGO_FORNECEDOR = B.CODIGO_FORNECEDOR\n"
                + "        AND A.USUARIO_CODIGO_USUARIO = C.CODIGO_USUARIO\n"
                + "        AND DATA_VENCIMENTO BETWEEN ? AND ? AND CATEGORIA_CODIGO_CATEGORIA LIKE ?               \n"
                + "        AND DATA_PAGAMENTO IS NULL OR DATA_PAGAMENTO = '' order BY DATA_VENCIMENTO";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, dataInicial);
            ps.setString(2, dataFinal);
            ps.setString(3, "%"+categoria_codigo_categoria+"%");

            rs = ps.executeQuery();

            resultado = getListaLancamentoContas(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<LancamentoConta> getLancamentoContasPagos(String dataInicial, String dataFinal, String categoria_codigo_categoria) {
        List<LancamentoConta> resultado = new ArrayList<LancamentoConta>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    DATA_VENCIMENTO,\n"
                + "    CODIGO_LANCAMENTO_CONTA,\n"
                + "    CODIGO_FORNECEDOR,\n"
                + "    NOME_FANTASIA AS ORIGEM_DESTINO,\n"
                + "    DESCRICAO,\n"
                + "    DOCUMENTO,\n"
                + "    VALOR_A_PAGAR,\n"
                + "    VALOR_PAGO,\n"
                + "    DATA_PAGAMENTO,\n"
                + "    C.NOME_USUARIO,\n"
                + "    A.CAIXA_CODIGO_CAIXA, CATEGORIA_CODIGO_CATEGORIA \n"
                + "FROM\n"
                + "    lancamento_conta A,\n"
                + "    FORNECEDOR B,\n"
                + "    USUARIO C\n"
                + "WHERE\n"
                + "    A.FORNECEDOR_CODIGO_FORNECEDOR = B.CODIGO_FORNECEDOR\n"
                + "        AND A.USUARIO_CODIGO_USUARIO = C.CODIGO_USUARIO\n"
                + "        AND DATA_VENCIMENTO BETWEEN ? AND ? AND CATEGORIA_CODIGO_CATEGORIA LIKE ?\n"
                + "        AND DATA_PAGAMENTO IS NOT NULL order by data_vencimento";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, dataInicial);
            ps.setString(2, dataFinal);
            ps.setString(3, "%"+categoria_codigo_categoria+"%");            

            rs = ps.executeQuery();

            resultado = getListaLancamentoContas(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    private void setPreparedStatement(LancamentoConta lancamentoConta, PreparedStatement ps)
            throws SQLException {

        Date data_vencimento = null;
        Date data_pagamento = null;
        if (lancamentoConta.getData_vencimento() != null) {
            data_vencimento = new Date(lancamentoConta.getData_vencimento().getTime());
        }
        if (lancamentoConta.getData_pagamento() != null) {
            data_pagamento = new Date(lancamentoConta.getData_pagamento().getTime());
        }
        ps.setString(1, lancamentoConta.getDescricao());
        ps.setString(2, lancamentoConta.getDocumento());
        ps.setDouble(3, lancamentoConta.getValor());
        ps.setDouble(4, lancamentoConta.getValorPago());
        ps.setDate(5, data_vencimento);
        ps.setDate(6, data_pagamento);
        ps.setInt(7, lancamentoConta.getFornecedor().getCodigo_fornecedor());
        ps.setInt(8, lancamentoConta.getUsuario().getCodigo_usuario());
        ps.setInt(9, lancamentoConta.getCaixa());
        ps.setInt(10, lancamentoConta.getCategoria().getCodigo_categoria());

    }

    private void setPreparedStatement1(LancamentoConta lancamentoConta, PreparedStatement ps)
            throws SQLException {

        Date data_vencimento = null;
        Date data_pagamento = null;
        if (lancamentoConta.getData_vencimento() != null) {
            data_vencimento = new Date(lancamentoConta.getData_vencimento().getTime());
        }
        if (lancamentoConta.getData_pagamento() != null) {
            data_pagamento = new Date(lancamentoConta.getData_pagamento().getTime());
        }
        ps.setString(1, lancamentoConta.getDescricao());
        ps.setString(2, lancamentoConta.getDocumento());
        ps.setDouble(3, lancamentoConta.getValor());
        ps.setDouble(4, lancamentoConta.getValorPago());
        ps.setDate(5, data_vencimento);
        ps.setDate(6, data_pagamento);
        ps.setInt(7, lancamentoConta.getFornecedor().getCodigo_fornecedor());
        ps.setInt(8, lancamentoConta.getUsuario().getCodigo_usuario());
        ps.setInt(9, lancamentoConta.getCaixa());
        ps.setInt(10, lancamentoConta.getCategoria().getCodigo_categoria());
        ps.setInt(11, lancamentoConta.getCodigo_lancamento_contas());

    }

    private List<LancamentoConta> getListaLancamentoContas(ResultSet rs) throws SQLException {
        List<LancamentoConta> resultado = new ArrayList<LancamentoConta>();
        while (rs.next()) {
            Categoria categoria = new Categoria();
            categoria.setCodigo_categoria(rs.getInt("CATEGORIA_CODIGO_CATEGORIA"));
            
            LancamentoConta lancamentosContas = new LancamentoConta();
            lancamentosContas.setCategoria(categoria);
            lancamentosContas.setCodigo_lancamento_contas(rs.getInt("CODIGO_LANCAMENTO_CONTA"));
            lancamentosContas.setDescricao(rs.getString("DESCRICAO"));
            lancamentosContas.setDocumento(rs.getString("DOCUMENTO"));
            lancamentosContas.setValor(rs.getDouble("VALOR_A_PAGAR"));
            lancamentosContas.setValorPago(rs.getDouble("VALOR_PAGO"));
            lancamentosContas.setData_vencimento(rs.getDate("DATA_VENCIMENTO"));
            lancamentosContas.setData_pagamento(rs.getDate("DATA_PAGAMENTO"));
            lancamentosContas.setCaixa(rs.getInt("CAIXA_CODIGO_CAIXA"));
            Usuario usuario = new Usuario();
            usuario.setNome_usuario(rs.getString("NOME_USUARIO"));
            lancamentosContas.setUsuario(usuario);

            lancamentosContas.setData_pagamento(rs.getDate("DATA_PAGAMENTO"));
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setCodigo_fornecedor(rs.getInt("CODIGO_FORNECEDOR"));
            fornecedor.setNome_fantasia(rs.getString("ORIGEM_DESTINO"));
            lancamentosContas.setFornecedor(fornecedor);
            resultado.add(lancamentosContas);
        }
        return resultado;
    }
}
