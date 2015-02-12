/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Feriado;
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
public class FeriadoDAO {

    private InterfacePool pool;

    public FeriadoDAO(InterfacePool pool) {
        this.pool = pool;
    }

    public Feriado salvar(Feriado feriado) {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `feriado`(`DESCRICAO`,`DATA_FERIADO`) VALUES (?,?);";

        try {
            ps = con.prepareStatement(sqlInsert);

            setPreparedStatement(feriado, ps);

            ps.executeUpdate();
            
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return feriado;
    }

    public void atualizar(Feriado feriado) {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlUpdate = "UPDATE `feriado` SET `DESCRICAO` = ?,`DATA_FERIADO` = ? WHERE `CODIGO_FERIADO` = ?;";
        try {
            ps = con.prepareStatement(sqlUpdate);

            setPreparedStatement1(feriado, ps);

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
    }

    public boolean excluir(Integer codigo) {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlExcluir = "DELETE FROM FERIADO WHERE CODIGO_FERIADO = ?;";

        try {
            ps = con.prepareStatement(sqlExcluir);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            pool.liberarConnection(con);
        }
    }

    public List<Feriado> getFeriado() {
        List<Feriado> resultado = new ArrayList<Feriado>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM FERIADO ORDER BY DATA_FERIADO LIMIT 0, 50;";

        try {
            ps = con.prepareStatement(sqlSelect);            

            rs = ps.executeQuery();

            resultado = getListaFeriado(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    public List<Feriado> getFeriadoData(String data_feriado) {
        List<Feriado> resultado = new ArrayList<Feriado>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM FERIADO WHERE DATA_FERIADO = ? ORDER BY DESCRICAO LIMIT 0, 50;";

        try {
            ps = con.prepareStatement(sqlSelect);   
            ps.setString(1, data_feriado);

            rs = ps.executeQuery();

            resultado = getListaFeriado(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FeriadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    private void setPreparedStatement(Feriado feriado, PreparedStatement ps)
            throws SQLException {
        Date data_feriado = null;
        if (feriado.getData_feriado()!= null) {
            data_feriado = new Date(feriado.getData_feriado().getTime());
        }

        ps.setString(1, feriado.getDescricao());
        ps.setDate(2, data_feriado);
        
    }

    private void setPreparedStatement1(Feriado feriado, PreparedStatement ps)
            throws SQLException {
        Date data_feriado = null;
        if (feriado.getData_feriado()!= null) {
            data_feriado = new Date(feriado.getData_feriado().getTime());
        }

        ps.setString(1, feriado.getDescricao());
        ps.setDate(2, data_feriado);
        ps.setInt(3, feriado.getCodigo_feriado());
    }

    private List<Feriado> getListaFeriado(ResultSet rs) throws SQLException {
        List<Feriado> resultado = new ArrayList<Feriado>();
        while (rs.next()) {
            Feriado feriado = new Feriado();
            feriado.setCodigo_feriado(rs.getInt("CODIGO_FERIADO"));
            feriado.setDescricao(rs.getString("DESCRICAO"));
            feriado.setData_feriado(rs.getDate("DATA_FERIADO"));            

            resultado.add(feriado);
        }
        return resultado;
    }
}
