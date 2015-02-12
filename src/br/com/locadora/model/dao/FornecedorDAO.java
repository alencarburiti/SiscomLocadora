/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Fornecedor;
import java.sql.Connection;
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
public class FornecedorDAO {

    private InterfacePool pool;

    public FornecedorDAO(InterfacePool pool) {
        this.pool = pool;
    }

    public Fornecedor salvar(Fornecedor fornecedor) {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `fornecedor` (`RAZAO_SOCIAL`, `NOME_FANTASIA`,`ENDERECO`,`BAIRRO`,\n"
                + "`COMPLEMENTO`,`CIDADE`,`ESTADO`,`CNPJ`,`TELEFONE`,`FAX`,`NOME_VENDEDOR`,\n"
                + "`TELEFONE_VENDEDOR`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? );";

        try {
            ps = con.prepareStatement(sqlInsert);

            setPreparedStatement(fornecedor, ps);

            ps.executeUpdate();

            ResultSet res;
            Integer codigo_max;
            String sql_max = "SELECT MAX(CODIGO_FORNECEDOR) FROM FORNECEDOR";

            ps = con.prepareStatement(sql_max);
            res = ps.executeQuery();
            res.next();
            codigo_max = res.getInt("MAX(CODIGO_FORNECEDOR)");
            fornecedor.setCodigo_fornecedor(codigo_max);

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return fornecedor;
    }

    public void atualizar(Fornecedor fornecedor) {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlUpdate = "UPDATE `fornecedor` SET `RAZAO_SOCIAL` = ?, `NOME_FANTASIA` = ?, \n"
                + "`ENDERECO` = ?, `BAIRRO` = ?, `COMPLEMENTO` = ?, `CIDADE` = ?, `ESTADO` = ?,\n"
                + "`CNPJ` = ?, `TELEFONE` = ?,`FAX` = ?, `NOME_VENDEDOR` = ?, `TELEFONE_VENDEDOR` = ?\n"
                + "WHERE `CODIGO_FORNECEDOR` = ?;";
        try {
            ps = con.prepareStatement(sqlUpdate);

            setPreparedStatement1(fornecedor, ps);

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
    }

    public void excluir(Integer codigo) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlExcluir = "DELETE FROM FORNECEDOR WHERE CODIGO_FORNECEDOR = ?;";

        try {
            ps = con.prepareStatement(sqlExcluir);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }

    public List<Fornecedor> getFornecedorNomeFantasia(String nome_fantasia) {
        List<Fornecedor> resultado = new ArrayList<Fornecedor>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM FORNECEDOR WHERE NOME_FANTASIA LIKE ? ORDER BY NOME_FANTASIA LIMIT 0, 50;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + nome_fantasia + "%");

            rs = ps.executeQuery();

            resultado = getListaFornecedor(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<Fornecedor> getFornecedorCodigo(int codigo_fornecedor) {
        List<Fornecedor> resultado = new ArrayList<Fornecedor>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM FORNECEDOR WHERE CODIGO_FORNECEDOR = ? ORDER BY NOME_FANTASIA LIMIT 0, 50;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_fornecedor);

            rs = ps.executeQuery();

            resultado = getListaFornecedor(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<Fornecedor> getFornecedores() {
        List<Fornecedor> resultado = new ArrayList<Fornecedor>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM FORNECEDOR ORDER BY NOME_FANTASIA LIMIT 0, 50;";

        try {
            ps = con.prepareStatement(sqlSelect);

            rs = ps.executeQuery();

            resultado = getListaFornecedor(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }


    private void setPreparedStatement(Fornecedor fornecedor, PreparedStatement ps)
            throws SQLException {
        ps.setString(1, fornecedor.getRazao_social());
        ps.setString(2, fornecedor.getNome_fantasia());
        ps.setString(3, fornecedor.getEndereço());
        ps.setString(4, fornecedor.getBairro());
        ps.setString(5, fornecedor.getComplemento());
        ps.setString(6, fornecedor.getCidade());
        ps.setString(7, fornecedor.getEstado());
        ps.setString(8, fornecedor.getCnpj());
        ps.setString(9, fornecedor.getTelefone());
        ps.setString(10, fornecedor.getFax());
        ps.setString(11, fornecedor.getNome_vendedor());
        ps.setString(12, fornecedor.getTel_vendedor());
    }

    private void setPreparedStatement1(Fornecedor fornecedor, PreparedStatement ps)
            throws SQLException {
        ps.setString(1, fornecedor.getRazao_social());
        ps.setString(2, fornecedor.getNome_fantasia());
        ps.setString(3, fornecedor.getEndereço());
        ps.setString(4, fornecedor.getBairro());
        ps.setString(5, fornecedor.getComplemento());
        ps.setString(6, fornecedor.getCidade());
        ps.setString(7, fornecedor.getEstado());
        ps.setString(8, fornecedor.getCnpj());
        ps.setString(9, fornecedor.getTelefone());
        ps.setString(10, fornecedor.getFax());
        ps.setString(11, fornecedor.getNome_vendedor());
        ps.setString(12, fornecedor.getTel_vendedor());
        ps.setInt(13, fornecedor.getCodigo_fornecedor());
    }

    private List<Fornecedor> getListaFornecedor(ResultSet rs) throws SQLException {
        List<Fornecedor> resultado = new ArrayList<Fornecedor>();
        while (rs.next()) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setCodigo_fornecedor(rs.getInt("CODIGO_FORNECEDOR"));
            fornecedor.setRazao_social(rs.getString("RAZAO_SOCIAL"));
            fornecedor.setNome_fantasia(rs.getString("NOME_FANTASIA"));
            fornecedor.setEndereço(rs.getString("ENDERECO"));
            fornecedor.setBairro(rs.getString("BAIRRO"));
            fornecedor.setComplemento(rs.getString("COMPLEMENTO"));
            fornecedor.setCidade(rs.getString("CIDADE"));
            fornecedor.setEstado(rs.getString("ESTADO"));
            fornecedor.setCnpj(rs.getString("CNPJ"));
            fornecedor.setTelefone(rs.getString("TELEFONE"));
            fornecedor.setFax(rs.getString("FAX"));
            fornecedor.setNome_vendedor(rs.getString("NOME_VENDEDOR"));
            fornecedor.setTel_vendedor(rs.getString("TELEFONE_VENDEDOR"));

            resultado.add(fornecedor);
        }
        return resultado;
    }
}
