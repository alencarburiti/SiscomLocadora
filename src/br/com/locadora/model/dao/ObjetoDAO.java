package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Genero;
import br.com.locadora.model.bean.Objeto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjetoDAO implements InterfaceObjetoDAO {
    
    private InterfacePool pool;
    
    public ObjetoDAO(InterfacePool pool) {
        this.pool = pool;
    }
    
    @Override
    public void atualizar(Objeto objeto) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlAtualizar = "UPDATE `OBJETO`\n" +
            "SET\n" +
            "`TITULO` = ?,\n" +
            "`TITULO_ORIGINAL` = ?,\n" +
            "`TIPO_MOVIMENTO` = ?,\n" +
            "`PRODUCAO` = ?,\n" +
            "`DURACAO` = ?,\n" +            
            "`TIPO_MIDIA` = ?,\n" +
            "`ELENCO` = ?,\n" +
            "`SINOPSE` = ?,\n" +
            "`CENSURA` = ?,\n" +
            "`GENERO_CODIGO_GENERO` = ?,\n" +            
            "`DEL_FLAG` = ?, DIRETOR = ?\n" +
            "WHERE `CODIGO_OBJETO` = ?;";
        try {
            ps = con.prepareStatement(sqlAtualizar);
            
            setPreparedStatement(objeto, ps);

            ps.executeUpdate();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }
    
    @Override
    public void excluir(Integer codigo) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlExcluir = "DELETE FROM OBJETO WHERE CODIGO_OBJETO = ?;";
        
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
    public List<Objeto> getObjeto_objeto(String objeto) throws SQLException {
        List<Objeto> resultado = new ArrayList<Objeto>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    *\n"
                + "FROM\n"
                + "    OBJETO A,\n"                
                + "    GENERO C\n"
                + "WHERE\n"                
                + "        A.GENERO_CODIGO_GENERO = C.CODIGO_GENERO\n"
                + "        AND A.TITULO LIKE ?\n"                
                + "GROUP BY A.CODIGO_OBJETO , A.TITULO LIMIT 0, 50;";
        
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + objeto + "%");
            
            rs = ps.executeQuery();
            
            resultado = getListaObjeto(rs);
            
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    @Override
    public List<Objeto> getObjeto_diretor(String diretor) throws SQLException {
        List<Objeto> resultado = new ArrayList<Objeto>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    *\n"
                + "FROM\n"
                + "    OBJETO A,\n"                
                + "    GENERO C\n"
                + "WHERE\n"                
                + "        A.GENERO_CODIGO_GENERO = C.CODIGO_GENERO\n"
                + "        AND A.DIRETOR LIKE ?\n"                
                + "GROUP BY A.CODIGO_OBJETO , A.DIRETOR LIMIT 0, 50;";
        
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + diretor + "%");
            
            rs = ps.executeQuery();
            
            resultado = getListaObjeto(rs);
            
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    public List<Objeto> getObjeto_sinopse(String sinopse) throws SQLException {
        List<Objeto> resultado = new ArrayList<Objeto>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    *\n"
                + "FROM\n"
                + "    OBJETO A,\n"                
                + "    GENERO C\n"
                + "WHERE\n"                
                + "        A.GENERO_CODIGO_GENERO = C.CODIGO_GENERO\n"
                + "        AND A.SINOPSE LIKE ?\n"                
                + "GROUP BY A.CODIGO_OBJETO , A.SINOPSE LIMIT 0, 50;";
        
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + sinopse + "%");
            
            rs = ps.executeQuery();
            
            resultado = getListaObjeto(rs);
            
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    
    
    @Override
    public List<Objeto> getObjeto_elenco(String elenco) throws SQLException {
        List<Objeto> resultado = new ArrayList<Objeto>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    *\n"
                + "FROM\n"
                + "    OBJETO A,\n"                
                + "    GENERO C\n"
                + "WHERE\n"                
                + "        A.GENERO_CODIGO_GENERO = C.CODIGO_GENERO\n"
                + "        AND A.ELENCO LIKE ? ORDER BY A.ELENCO ASC LIMIT 0, 50;";
        
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + elenco + "%");
            
            rs = ps.executeQuery();
            
            resultado = getListaObjeto(rs);
            
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    @Override
    public List<Objeto> getObjeto_codigo(Integer codigo_objeto) {
        List<Objeto> resultado = new ArrayList<Objeto>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    *\n"
                + "FROM\n"
                + "    OBJETO A,\n"                
                + "    GENERO C\n"
                + "WHERE\n"                
                + "         A.GENERO_CODIGO_GENERO = C.CODIGO_GENERO\n"
                + "        AND A.CODIGO_OBJETO = ? LIMIT 0, 50;";
        
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_objeto);
            
            rs = ps.executeQuery();
            
            resultado = getListaObjeto(rs);
            
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ObjetoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    @Override
    public List<Objeto> getObjetos() throws SQLException {
        List<Objeto> resultado = new ArrayList<Objeto>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM CLIENTE ORDER BY NOME_CLIENTE LIMIT 0, 50;";
        ResultSet rs = null;
        
        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();
            
            resultado = getListaObjeto(rs);
            
            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    private List<Objeto> getListaObjeto(ResultSet rs) throws SQLException {
        List<Objeto> resultado = new ArrayList<Objeto>();
        while (rs.next()) {
            Objeto objeto = new Objeto();
            objeto.setCodigo_objeto(rs.getInt("CODIGO_OBJETO"));
            objeto.setTitulo(rs.getString("TITULO"));
            objeto.setTitulo_original(rs.getString("TITULO_ORIGINAL"));            
            objeto.setTipo_movimento(rs.getString("TIPO_MOVIMENTO"));
            objeto.setProducao(rs.getString("PRODUCAO"));
            objeto.setDuracao(rs.getString("DURACAO"));
            objeto.setTipo_midia(rs.getString("TIPO_MIDIA"));
            objeto.setElenco(rs.getString("ELENCO"));
            objeto.setSinopse(rs.getString("SINOPSE"));
            objeto.setCensura(rs.getInt("CENSURA"));
            objeto.setDiretor(rs.getString("DIRETOR"));            
            
            Genero genero = new Genero();
            genero.setCodigo_genero(rs.getInt("CODIGO_GENERO"));
            genero.setNome_genero(rs.getString("NOME_GENERO"));
            
            objeto.setGenero(genero);            
            resultado.add(objeto);
        }
        return resultado;
    }
    
    
    
    @Override
    public Objeto salvar(Objeto objeto) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;
        
        String sqlInsert = "INSERT INTO `OBJETO`(`TITULO`,`TITULO_ORIGINAL`,"
                + "`TIPO_MOVIMENTO`,`PRODUCAO`,`DURACAO`,`TIPO_MIDIA`,`GENERO_CODIGO_GENERO`,`ELENCO`,"
                + "`SINOPSE`, CENSURA, DIRETOR)VALUES(?,?,?,?,?,?,?,?,?,?,?);";
        
        try {
            ps = con.prepareStatement(sqlInsert);
            
            setPreparedStatement1(objeto, ps);
            
            ps.executeUpdate();
            ResultSet res;
            Integer codigo_max;
            String sql_max = "SELECT MAX(CODIGO_OBJETO) FROM OBJETO";
            
            ps = con.prepareStatement(sql_max);
            res = ps.executeQuery();
            res.next();
            codigo_max = res.getInt("MAX(CODIGO_OBJETO)");
            objeto.setCodigo_objeto(codigo_max);
            System.out.println(codigo_max);
            
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return objeto;
    }
    
    private void setPreparedStatement(Objeto objeto, PreparedStatement ps)
            throws SQLException {
        
        ps.setString(1, objeto.getTitulo());
        ps.setString(2, objeto.getTitulo_original());        
        ps.setString(3, objeto.getTipo_movimento());
        ps.setString(4, objeto.getProducao());
        ps.setString(5, objeto.getDuracao());
        ps.setString(6, objeto.getTipo_midia());
        ps.setString(7, objeto.getElenco());
        ps.setString(8, objeto.getSinopse());
        ps.setInt(9, objeto.getCensura());
        ps.setInt(10, objeto.getGenero().getCodigo_genero());
        ps.setInt(11, Integer.parseInt(objeto.getStatus()));
        ps.setString(12, objeto.getDiretor());
        ps.setInt(13, objeto.getCodigo_objeto());        
    }
    
    private void setPreparedStatement1(Objeto objeto, PreparedStatement ps)
            throws SQLException {
        
        ps.setString(1, objeto.getTitulo());
        ps.setString(2, objeto.getTitulo_original());        
        ps.setString(3, objeto.getTipo_movimento());
        ps.setString(4, objeto.getProducao());
        ps.setString(5, objeto.getDuracao());
        ps.setString(6, objeto.getTipo_midia());
        ps.setInt(7, objeto.getGenero().getCodigo_genero());
        ps.setString(8, objeto.getElenco());
        ps.setString(9, objeto.getSinopse());
        ps.setInt(10, objeto.getCensura());
        ps.setString(11, objeto.getDiretor());
    }
    
}
