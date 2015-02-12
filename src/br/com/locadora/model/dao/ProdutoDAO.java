/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ALENCAR
 */
public class ProdutoDAO {

    private InterfacePool pool;

    public ProdutoDAO(InterfacePool pool) {
        this.pool = pool;
    }

    public Produto salvar(Produto produto) {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `produto` (`NOME_PRODUTO`,`CODIGO_BARRAS`,\n"
                + "`PRECO_COMPRA`,`PRECO_VENDA`)VALUES(?,?,?,?);";

        try {
            ps = con.prepareStatement(sqlInsert);

            setPreparedStatement(produto, ps);

            ps.executeUpdate();

            ResultSet res;
            Integer codigo_max;
            String sql_max = "SELECT MAX(CODIGO_PRODUTO) FROM PRODUTO";

            ps = con.prepareStatement(sql_max);
            res = ps.executeQuery();
            res.next();
            codigo_max = res.getInt("MAX(CODIGO_PRODUTO)");
            produto.setCodigo_produto(codigo_max);

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código de Barras "+ produto.getCodigo_barras()+" já Cadastrado!");
        } finally {
            pool.liberarConnection(con);
        }
        return produto;
    }

    public boolean atualizar(Produto produto) {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlUpdate = "UPDATE `produto` SET `NOME_PRODUTO` = ?, `CODIGO_BARRAS` = ?,\n"
                + "`PRECO_COMPRA` = ?,`PRECO_VENDA` = ? WHERE `CODIGO_PRODUTO` = ?;";
        try {
            ps = con.prepareStatement(sqlUpdate);

            setPreparedStatement1(produto, ps);

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código de Barras "+ produto.getCodigo_barras()+" já Cadastrado!");
            return false;
        } finally {
            pool.liberarConnection(con);
        }
    }

    public void excluir(Integer codigo) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlExcluir = "DELETE FROM PRODUTO WHERE CODIGO_PRODUTO = ?;";

        try {
            ps = con.prepareStatement(sqlExcluir);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }

    public List<Produto> getProdutoNome(String nome_produto) {
        List<Produto> resultado = new ArrayList<Produto>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM PRODUTO WHERE NOME_PRODUTO LIKE ? ORDER BY NOME_PRODUTO LIMIT 0, 50;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + nome_produto + "%");

            rs = ps.executeQuery();

            resultado = getListaProduto(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    public List<Produto> getProdutoCodigoBarras(String codigo_barras) {
        List<Produto> resultado = new ArrayList<Produto>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM PRODUTO WHERE CODIGO_BARRAS = ? ORDER BY NOME_PRODUTO LIMIT 0, 50;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, codigo_barras);

            rs = ps.executeQuery();

            resultado = getListaProduto(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<Produto> getProdutoCodigo(int codigo_produto) {
        List<Produto> resultado = new ArrayList<Produto>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM PRODUTO WHERE CODIGO_PRODUTO LIKE ? ORDER BY NOME_PRODUTO LIMIT 0, 50;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_produto);

            rs = ps.executeQuery();

            resultado = getListaProduto(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<Produto> getProdutoes() {
        List<Produto> resultado = new ArrayList<Produto>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM PRODUTO ORDER BY NOME_PRODUTO LIMIT 0, 50;";

        try {
            ps = con.prepareStatement(sqlSelect);

            rs = ps.executeQuery();

            resultado = getListaProduto(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    private void setPreparedStatement(Produto produto, PreparedStatement ps)
            throws SQLException {
        ps.setString(1, produto.getNome_produto());
        ps.setString(2, produto.getCodigo_barras());
        ps.setDouble(3, produto.getPreco_compra());
        ps.setDouble(4, produto.getPreco_venda());

    }

    private void setPreparedStatement1(Produto produto, PreparedStatement ps)
            throws SQLException {
        ps.setString(1, produto.getNome_produto());
        ps.setString(2, produto.getCodigo_barras());
        ps.setDouble(3, produto.getPreco_compra());
        ps.setDouble(4, produto.getPreco_venda());
        ps.setInt(5, produto.getCodigo_produto());
    }

    private List<Produto> getListaProduto(ResultSet rs) throws SQLException {
        List<Produto> resultado = new ArrayList<Produto>();
        while (rs.next()) {
            Produto produto = new Produto();
            produto.setCodigo_produto(rs.getInt("CODIGO_PRODUTO"));
            produto.setNome_produto(rs.getString("NOME_PRODUTO"));
            produto.setCodigo_barras(rs.getString("CODIGO_BARRAS"));
            produto.setPreco_compra(rs.getDouble("PRECO_COMPRA"));
            produto.setPreco_venda(rs.getDouble("PRECO_VENDA"));

            resultado.add(produto);
        }
        return resultado;
    }
}
