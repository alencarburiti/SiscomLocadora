/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.bean.OcorrenciaDanificado;
import br.com.locadora.model.bean.Usuario;
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
public class OcorrenciaDanificadoDAO {

    private InterfacePool pool;

    public OcorrenciaDanificadoDAO(InterfacePool pool) {
        this.pool = pool;
    }

    public void salvar(OcorrenciaDanificado ocorrenciaDanificado) {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `ocorrencia_danificado` (`copia_codigo_copia`, \n" +
            "`dependente_codigo_dependente`, `observacao`, \n" +
            "`usuario_codigo_usuario`, data_ocorrencia) VALUES (?,?,?,?, current_date());";

        try {
            ps = con.prepareStatement(sqlInsert);

            setPreparedStatement(ocorrenciaDanificado, ps);            
            ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(OcorrenciaDanificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }        
    }    

    public List<OcorrenciaDanificado> getOcorrenciaObjeto(String titulo) {
        List<OcorrenciaDanificado> resultado = new ArrayList<OcorrenciaDanificado>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n" +
            "    CODIGO_OCORRENCIA_DANIFICADO,\n" +
            "    TITULO,\n" +
            "    NOME_DEPENDENTE,\n" +
            "    OBSERVACAO,\n" +
            "    DATA_OCORRENCIA,\n" +
            "    NOME_USUARIO\n" +
            "FROM\n" +
            "    OCORRENCIA_DANIFICADO A,\n" +
            "    COPIA B,\n" +
            "    DEPENDENTE C,\n" +
            "    OBJETO D, \n" +
            "    USUARIO E\n" +
            "WHERE\n" +
            "    A.copia_codigo_copia = B.CODIGO_COPIA\n" +
            "        AND A.dependente_codigo_dependente = C.CODIGO_DEPENDENTE\n" +
            "        AND A.USUARIO_CODIGO_USUARIO = E.CODIGO_USUARIO\n" +
            "        AND D.CODIGO_OBJETO = B.OBJETO_CODIGO_OBJETO\n" +
            "        AND TITULO LIKE ?\n" +
            "ORDER BY DATA_OCORRENCIA DESC;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + titulo + "%");

            rs = ps.executeQuery();

            resultado = getListaOcorrenciaDanificado(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(OcorrenciaDanificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    public List<OcorrenciaDanificado> getOcorrenciaCliente(String cliente) {
        List<OcorrenciaDanificado> resultado = new ArrayList<OcorrenciaDanificado>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n" +
            "    CODIGO_OCORRENCIA_DANIFICADO,\n" +
            "    TITULO,\n" +
            "    NOME_DEPENDENTE,\n" +
            "    OBSERVACAO,\n" +
            "    DATA_OCORRENCIA,\n" +
            "    NOME_USUARIO\n" +
            "FROM\n" +
            "    OCORRENCIA_DANIFICADO A,\n" +
            "    COPIA B,\n" +
            "    DEPENDENTE C,\n" +
            "    OBJETO D, \n" +
            "    USUARIO E\n" +
            "WHERE\n" +
            "    A.copia_codigo_copia = B.CODIGO_COPIA\n" +
            "        AND A.dependente_codigo_dependente = C.CODIGO_DEPENDENTE\n" +
            "        AND A.USUARIO_CODIGO_USUARIO = E.CODIGO_USUARIO\n" +
            "        AND D.CODIGO_OBJETO = B.OBJETO_CODIGO_OBJETO\n" +
            "        AND NOME_DEPENDENTE LIKE ?\n" +
            "ORDER BY DATA_OCORRENCIA DESC;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + cliente + "%");

            rs = ps.executeQuery();

            resultado = getListaOcorrenciaDanificado(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(OcorrenciaDanificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    private void setPreparedStatement(OcorrenciaDanificado ocorrenciaDanificado, PreparedStatement ps)
            throws SQLException {
        ps.setInt(1, ocorrenciaDanificado.getCopia().getCodigo_copia());
        ps.setInt(2, ocorrenciaDanificado.getDependente().getCodigo_dependente());
        ps.setString(3, ocorrenciaDanificado.getObservacao());
        ps.setInt(4, ocorrenciaDanificado.getUsuario().getCodigo_usuario());        
        
    }
    
    private List<OcorrenciaDanificado> getListaOcorrenciaDanificado(ResultSet rs) throws SQLException {
        List<OcorrenciaDanificado> resultado = new ArrayList<OcorrenciaDanificado>();
        while (rs.next()) {
            OcorrenciaDanificado ocorrenciaDanificado = new OcorrenciaDanificado();
            ocorrenciaDanificado.setCodigo_ocorrencia_danificado(rs.getInt("CODIGO_OCORRENCIA_DANIFICADO"));
            ocorrenciaDanificado.setData_ocorrencia(rs.getDate("DATA_OCORRENCIA"));
            ocorrenciaDanificado.setObservacao(rs.getString("OBSERVACAO"));
            
            Objeto objeto = new Objeto();
            objeto.setTitulo(rs.getString("TITULO"));
            
            Copia copia = new Copia();
            copia.setObjeto(objeto);
            
            Usuario usuario = new Usuario();
            usuario.setNome_usuario(rs.getString("NOME_USUARIO"));
            
            Dependente dependente = new Dependente();
            dependente.setNome_dependente(rs.getString("NOME_DEPENDENTE"));
            ocorrenciaDanificado.setCopia(copia);
            ocorrenciaDanificado.setDependente(dependente);
            ocorrenciaDanificado.setUsuario(usuario);
            
            resultado.add(ocorrenciaDanificado);
        }
        return resultado;
    }
}
