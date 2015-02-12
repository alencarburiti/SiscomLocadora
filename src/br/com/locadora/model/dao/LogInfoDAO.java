/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.LogInfo;
import br.com.locadora.model.bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALENCAR
 */
public class LogInfoDAO {

    private InterfacePool pool;

    public LogInfoDAO(InterfacePool pool) {
        this.pool = pool;
    }

    public void salvar(LogInfo logInfo) {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO LOG_INFO (DESCRICAO, USUARIO_CODIGO_USUARIO, DATA_LOG) VALUES (?,?, NOW());";

        try {
            ps = con.prepareStatement(sqlInsert);
            ps.setString(1, logInfo.getDescricao());
            ps.setInt(2, logInfo.getUsuario().getCodigo_usuario());            

            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(LogInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }        
    }
        
    public List<LogInfo> getLogInfo() {
        List<LogInfo> resultado = new ArrayList<LogInfo>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM LOG_INFO A, USUARIO B WHERE A.USUARIO_CODIGO_USUARIO = B.CODIGO_USUARIO ORDER BY DATA_LOG DESC LIMIT 0, 500;";

        try {
            ps = con.prepareStatement(sqlSelect);            

            rs = ps.executeQuery();

            resultado = getListaLog(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LogInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

        
    private List<LogInfo> getListaLog(ResultSet rs) throws SQLException {
        List<LogInfo> resultado = new ArrayList<LogInfo>();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (rs.next()) {
            

            Usuario usuario = new Usuario();
            usuario.setNome_usuario(rs.getString("NOME_USUARIO"));

            LogInfo logInfo = new LogInfo();
            logInfo.setUsuario(usuario);
            logInfo.setDescricao(rs.getString("DESCRICAO"));
            
            String dataString = rs.getString("DATA_LOG");
            Date dataLog = null;            
            try {
                dataLog = format.parse(dataString);
            } catch (ParseException ex) {
                Logger.getLogger(LogInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            logInfo.setData_log(dataLog);
            resultado.add(logInfo);
        }
        return resultado;
    }
}
