/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Categoria;
import br.com.locadora.model.bean.SubCategoria;
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
public class CategoriaDAO {

    private InterfacePool pool;

    public CategoriaDAO(InterfacePool pool) {
        this.pool = pool;
    }

    public void salvar(Categoria categoria) {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO CATEGORIA (DESCRICAO) VALUES ( ? )";

        try {
            ps = con.prepareStatement(sqlInsert);
            ps.setString(1, categoria.getDescricao());

            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
    }

    public boolean excluir(Integer codigo) {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "DELETE FROM CATEGORIA WHERE CODIGO_CATEGORIA = ? ";

        try {
            ps = con.prepareStatement(sqlInsert);
            ps.setInt(1, codigo);

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            pool.liberarConnection(con);
        }
    }

    public void atualizar(Categoria categoria) {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlUpdate = "UPDATE CATEGORIA SET DESCRICAO = ? WHERE CODIGO_CATEGORIA = ? ";
        try {
            ps = con.prepareStatement(sqlUpdate);

            ps.setString(1, categoria.getDescricao());
            ps.setInt(2, categoria.getCodigo_categoria());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
    }

    public List<Categoria> getCategoria() {
        List<Categoria> resultado = new ArrayList<Categoria>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM CATEGORIA ORDER BY DESCRICAO;";

        try {
            ps = con.prepareStatement(sqlSelect);

            rs = ps.executeQuery();

            resultado = getListaCategoria(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<Categoria> getCategoria(String descricao) {
        List<Categoria> resultado = new ArrayList<Categoria>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM CATEGORIA WHERE DESCRICAO = ? ORDER BY DESCRICAO;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, descricao);

            rs = ps.executeQuery();

            resultado = getListaCategoria(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<SubCategoria> getSubCategoria(Categoria categoria) {
        List<SubCategoria> resultado = new ArrayList<SubCategoria>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM SUB_CATEGORIA WHERE CATEGORIA_CODIGO_CATEGORIA = ? ORDER BY DESCRICAO;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, categoria.getCodigo_categoria());

            rs = ps.executeQuery();

            resultado = getListaSubCategoria(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }    

    private List<Categoria> getListaCategoria(ResultSet rs) throws SQLException {
        List<Categoria> resultado = new ArrayList<Categoria>();
        while (rs.next()) {
            Categoria categoria = new Categoria();
            categoria.setCodigo_categoria(rs.getInt("CODIGO_CATEGORIA"));
            categoria.setDescricao(rs.getString("DESCRICAO"));

            resultado.add(categoria);
        }
        return resultado;
    }

    private List<SubCategoria> getListaSubCategoria(ResultSet rs) throws SQLException {
        List<SubCategoria> resultado = new ArrayList<SubCategoria>();
        while (rs.next()) {
            Categoria categoria = new Categoria();
            categoria.setCodigo_categoria(rs.getInt("CATEGORIA_CODIGO_CATEGORIA"));

            SubCategoria subCategoria = new SubCategoria();
            subCategoria.setCodigo_sub_categoria(rs.getInt("CODIGO_SUB_CATEGORIA"));
            subCategoria.setDescricao(rs.getString("DESCRICAO"));
            subCategoria.setCategoria(categoria);

            resultado.add(subCategoria);
        }
        return resultado;
    }
}
