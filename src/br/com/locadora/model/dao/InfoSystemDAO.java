/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.InfoSystem;
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
public class InfoSystemDAO {

    private InterfacePool pool;

    public InfoSystemDAO(InterfacePool pool) {
        this.pool = pool;
    }

    public void atualizar(InfoSystem infoSystem) {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "UPDATE `info_system` SET `data_aquisicao` = ?, `qtd_licenca` = ?,\n" +
            "`cnpj` = ?, `data_inicio_licenca` = ?, `data_final_licenca` = ?,\n" +
            "`nome_empresa` = ?, data_ultimo_acesso = now(), chave = ? WHERE `codigo_info_system` = ?;";

        try {
            java.sql.Date data_aquisicao = null;
            if (infoSystem.getData_aquisicao() != null) {
                data_aquisicao = new java.sql.Date(infoSystem.getData_aquisicao().getTime());
            }
            java.sql.Date data_inicio_licenca = null;
            if (infoSystem.getData_inicio_licenca()!= null) {
                data_inicio_licenca = new java.sql.Date(infoSystem.getData_inicio_licenca().getTime());
            }
            java.sql.Date data_final_licenca = null;
            if (infoSystem.getData_final_licenca() != null) {
                data_final_licenca = new java.sql.Date(infoSystem.getData_final_licenca().getTime());
            }
        
        
            ps = con.prepareStatement(sqlInsert);
            ps.setDate(1, data_aquisicao);            
            ps.setInt(2, infoSystem.getQtd_licenca());
            ps.setString(3, infoSystem.getCnpj());
            ps.setDate(4, data_inicio_licenca);            
            ps.setDate(5, data_final_licenca);            
            ps.setString(6, infoSystem.getNome_empresa());
            ps.setString(7, infoSystem.getChave());
            ps.setInt(8, 1);

            ps.executeUpdate();

            ps.close();            
        } catch (SQLException ex) {
            Logger.getLogger(InfoSystemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }        
    }
    
    public Integer getInfoSystemLicenca() {        
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT \n" +
            "    COUNT(QTD_LICENCA) AS QTD_LICENCA\n" +
            "FROM\n" +
            "    INFO_SYSTEM\n" +
            "WHERE\n" +
            "    CURRENT_DATE() BETWEEN DATA_INICIO_LICENCA AND DATA_FINAL_LICENCA;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);            
            rs = ps.executeQuery();
            rs.next();
            Integer count_licenca = rs.getInt("QTD_LICENCA");            

            rs.close();
            ps.close();
            return count_licenca;
        } catch (SQLException ex) {
//            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            pool.liberarConnection(con);
        }
    }

    
    public void atualizarAcesso() {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "UPDATE `info_system` SET data_ultimo_acesso = now() WHERE `codigo_info_system` = ?;";

        try {
            ps = con.prepareStatement(sqlInsert);            
            ps.setInt(1, 1);

            ps.executeUpdate();

            ps.close();            
        } catch (SQLException ex) {
            Logger.getLogger(InfoSystemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }        
    }
        
    public List<InfoSystem> getSystemInfo() {
        List<InfoSystem> resultado = new ArrayList<InfoSystem>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM INFO_SYSTEM;";

        try {
            ps = con.prepareStatement(sqlSelect);            

            rs = ps.executeQuery();

            resultado = getListaInfoSystem(rs);

            rs.close();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(InfoSystemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

        
    private List<InfoSystem> getListaInfoSystem(ResultSet rs) throws SQLException {
        List<InfoSystem> resultado = new ArrayList<InfoSystem>();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (rs.next()) {
            InfoSystem infoSystem = new InfoSystem();
            infoSystem.setCnpj(rs.getString("CNPJ"));
            infoSystem.setQtd_licenca(rs.getInt("QTD_LICENCA"));
            infoSystem.setData_aquisicao(rs.getDate("DATA_AQUISICAO"));
            infoSystem.setData_inicio_licenca(rs.getDate("DATA_INICIO_LICENCA"));
            infoSystem.setData_final_licenca(rs.getDate("DATA_FINAL_LICENCA"));
            infoSystem.setNome_empresa(rs.getString("NOME_EMPRESA"));
            infoSystem.setChave(rs.getString("CHAVE"));
            
            String dataString = rs.getString("DATA_ULTIMO_ACESSO");
            Date data_ultmi_acesso = null;            
            try {
                if(dataString != null){
                    data_ultmi_acesso = format.parse(dataString);                    
                }
            } catch (ParseException ex) {
            }
            infoSystem.setData_ultimo_acesso(data_ultmi_acesso);
            resultado.add(infoSystem);
        }
        return resultado;
    }
}
