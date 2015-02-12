package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.TipoServico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TipoServicoDAO implements InterfaceTipoServicoDAO {
    
    private InterfacePool pool;
    
    public TipoServicoDAO(InterfacePool pool) {
        this.pool = pool;
    }
    
    @Override
    public void atualizar(TipoServico objeto) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareCall("{CALL SP_UPDATE_OBJETO_BY_PK(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
            setPreparedStatement(objeto, ps);

            ps.execute();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }
    
    @Override
    public void excluir(Integer codigo) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlExcluir = "DELETE FROM objeto WHERE codigo = ?;";
        
        try {
            ps = con.prepareStatement(sqlExcluir);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }
    
    @Override
    public List<TipoServico> getTipoServico(Integer codigo_tipo_servico) throws SQLException {
        List<TipoServico> resultado = new ArrayList<TipoServico>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    *\n"
                + "FROM\n"
                + "    OBJETO A,\n"
                + "    DIARIA B,\n"
                + "    GENERO C\n"
                + "WHERE\n"
                + "    A.DIARIA_CODIGO_DIARIA = B.CODIGO_DIARIA\n"
                + "        AND A.GENERO_CODIGO_GENERO = C.CODIGO_GENERO\n"
                + "        AND A.CODIGO_OBJETO = ?;";
        
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_tipo_servico);
            
            rs = ps.executeQuery();
            
            resultado = getListaTipoServico(rs);
            
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    @Override
    public List<TipoServico> getTipoServicos() {
        List<TipoServico> resultado = new ArrayList<TipoServico>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM TIPO_SERVICO;";
        ResultSet rs = null;
        
        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            
            resultado = getListaTipoServico(rs);
            
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    public List<TipoServico> getTipoServicos(String movimento) {
        List<TipoServico> resultado = new ArrayList<TipoServico>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM TIPO_SERVICO WHERE MOVIMENTO = ? ORDER BY ORDEM ASC;";
        ResultSet rs = null;
        
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, movimento);
            rs = ps.executeQuery();
            
            resultado = getListaTipoServico(rs);
            
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    private List<TipoServico> getListaTipoServico(ResultSet rs) throws SQLException {
        List<TipoServico> resultado = new ArrayList<TipoServico>();
        while (rs.next()) {
            TipoServico tipoServico = new TipoServico();
            tipoServico.setCodigo_tipo_servico(rs.getInt("CODIGO_TIPO_SERVICO"));
            tipoServico.setDescricao(rs.getString("DESCRICAO"));
            System.out.println("Descrição: "+rs.getString("DESCRICAO"));
            tipoServico.setTipo(rs.getString("TIPO"));
            resultado.add(tipoServico);
        }
        return resultado;
    }
    
    @Override
    public TipoServico salvar(TipoServico tipoServico) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;
        
        String sqlInsert = "INSERT INTO `OBJETO`(`DESCRICAO_OBJETO`,`TITULO_ORIGINAL`,`DESCRICAO_RESUMIDA`,"
                + "`TIPO_MOVIMENTO`,`PRODUCAO`,`DURACAO`,`MIDIA`,`TIPO_MIDIA`,`DIARIA_CODIGO_DIARIA`,`GENERO_CODIGO_GENERO`,`ELENCO`,"
                + "`SINOPSE`, CENSURA)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";
        
        try {
            ps = con.prepareStatement(sqlInsert);
            
            setPreparedStatement1(tipoServico, ps);
            
            ps.executeUpdate();
            ResultSet res;
            Integer codigo_max;
            String sql_max = "SELECT MAX(CODIGO_OBJETO) FROM OBJETO";
            
            ps = con.prepareStatement(sql_max);
            res = ps.executeQuery();
            res.next();
            codigo_max = res.getInt("MAX(CODIGO_OBJETO)");
//            tipoServico.setCodigo_objeto(codigo_max);
            System.out.println(codigo_max);
            
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return tipoServico;
    }
    
    private void setPreparedStatement(TipoServico tipoServico, PreparedStatement ps)
            throws SQLException {
        
        
    }
    
    private void setPreparedStatement1(TipoServico tipoServico, PreparedStatement ps)
            throws SQLException {
        
        
    }
    
}
