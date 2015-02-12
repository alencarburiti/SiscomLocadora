package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Usuario;
import br.com.locadora.model.bean.InterfaceAcesso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AcessoUsuarioDAO {

    private InterfacePool pool;

    public AcessoUsuarioDAO(InterfacePool pool) {
        this.pool = pool;
    }
    
    public void atualizar(List<AcessoUsuario> acessos) {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlAtualizar = " UPDATE `acesso` SET `LER` = ?,`ESCREVER` = ?,`DELETAR` = ?, `SUPER_USUARIO` = ? \n" +        
        "WHERE `CODIGO_ACESSO` = ?";

        try {
            ps = con.prepareStatement(sqlAtualizar);

            for(int i = 0; i < acessos.size(); i++){
                setPreparedStatement(acessos.get(i), ps);
                ps.executeUpdate();                
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AcessoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
    }

    
    public void excluir(Integer codigo) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlExcluir = "DELETE FROM DIARIA WHERE CODIGO_DIARIA = ?;";

        try {
            ps = con.prepareStatement(sqlExcluir);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }

    
    public List<Usuario> getUsuario(Integer codigo_interno) throws SQLException {
        List<Usuario> resultado = new ArrayList<Usuario>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "	A.CODIGO_COPIA, \n"
                + "    A.CODIGO_INTERNO,\n"
                + "    A.DEL_FLAG,\n"
                + "    B.TITULO,\n"
                + "    B.TIPO_MOVIMENTO,\n"
                + "    B.TIPO_MIDIA,\n"
                + "    A.LOCALIZACAO,\n"
                + "    A.IDIOMA,\n"
                + "    A.LEGENDA,\n"
                + "    C.DIAS,\n"
                + "    C.VALOR,\n"
                + "    C.VALOR_PROMOCAO\n"
                + "FROM\n"
                + "    COPIA A,\n"
                + "    OBJETO B,\n"
                + "    DIARIA C\n"
                + "WHERE\n"
                + "    A.CODIGO_OBJETO = B.CODIGO_OBJETO\n"
                + "        AND C.CODIGO_DIARIA = B.CODIGO_DIARIA\n"
                + "        AND A.DEL_FLAG = 0\n"
                + "        AND TIPO_MOVIMENTO = 'Locação'\n"
                + "		AND A.CODIGO_INTERNO = ?;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_interno);

            rs = ps.executeQuery();

            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
       
    public List<InterfaceAcesso> getPermissoes() {
        List<InterfaceAcesso> resultado = new ArrayList<InterfaceAcesso>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM INTERFACE WHERE DEL_FLAG = 0";

        try {
            ps = con.prepareStatement(sqlSelect);            

            rs = ps.executeQuery();

            resultado = getListaPermissao(rs);
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AcessoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    public List<InterfaceAcesso> getInterface(String descricao) {
        List<InterfaceAcesso> resultado = new ArrayList<InterfaceAcesso>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM INTERFACE WHERE DESCRICAO = ? AND DEL_FLAG = 0";

        try {
            ps = con.prepareStatement(sqlSelect);            
            ps.setString(1, descricao);
            rs = ps.executeQuery();

            resultado = getListaPermissao(rs);
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AcessoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    
    public List<AcessoUsuario> getPermissaoUsuario(Usuario usuario) {
        List<AcessoUsuario> resultado = new ArrayList<AcessoUsuario>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM ACESSO A, INTERFACE B WHERE A.INTERFACE_CODIGO_INTERFACE = B.CODIGO_INTERFACE "
                + "AND  USUARIO_CODIGO_USUARIO = ? ORDER BY B.ORDEM ASC;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, usuario.getCodigo_usuario());
            rs = ps.executeQuery();

            resultado = getListaPermissaoUsuario(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AcessoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    

    public List<Usuario> getTodasUsuarios() throws SQLException {
        List<Usuario> resultado = new ArrayList<Usuario>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM DIARIA ORDER BY NOME_DIARIA;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

//            resultado = getListaUsuario(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    private List<AcessoUsuario> getListaPermissaoUsuario(ResultSet rs) throws SQLException {
        List<AcessoUsuario> resultado = new ArrayList<AcessoUsuario>();
        while (rs.next()) {
            AcessoUsuario acessoUsuario = new AcessoUsuario();
            acessoUsuario.setCodigo_acesso(rs.getInt("CODIGO_ACESSO"));
            if(rs.getInt("LER") == 0){
                acessoUsuario.setLer(true);                
            } else {
                acessoUsuario.setLer(false);                
            }
            
            if(rs.getInt("ESCREVER") == 0){
                acessoUsuario.setEscrever(true);                
            } else {
                acessoUsuario.setEscrever(false);                
            }
            
            if(rs.getInt("DELETAR") == 0){
                acessoUsuario.setDeletar(true);                
            } else {
                acessoUsuario.setDeletar(false);                
            }
            
            if(rs.getInt("SUPER_USUARIO") == 0){
                acessoUsuario.setSuper_usuario(true);                
            } else {
                acessoUsuario.setSuper_usuario(false);                
            }
            
            
            InterfaceAcesso inter = new InterfaceAcesso();
            inter.setDescricao(rs.getString("DESCRICAO"));
            inter.setCodigo_interface(rs.getInt("CODIGO_INTERFACE"));
            inter.setOperacao(rs.getInt("OPERACAO"));
            acessoUsuario.setInterfaceAcesso(inter);
            
            resultado.add(acessoUsuario);
        }
        return resultado;
    }
    
    private List<InterfaceAcesso> getListaPermissao(ResultSet rs) throws SQLException {
        List<InterfaceAcesso> resultado = new ArrayList<InterfaceAcesso>();
        while (rs.next()) {
            InterfaceAcesso interfaceAcesso = new InterfaceAcesso();
            interfaceAcesso.setCodigo_interface(rs.getInt("CODIGO_INTERFACE"));
            interfaceAcesso.setDescricao(rs.getString("DESCRICAO"));
            interfaceAcesso.setNome_classe(rs.getString("NOME_CLASSE"));
            interfaceAcesso.setDel_flag(rs.getInt("DEL_FLAG"));
            interfaceAcesso.setOperacao(rs.getInt("OPERACAO"));
            
            resultado.add(interfaceAcesso);
        }
        return resultado;
    }

    
    public void salvar(AcessoUsuario acessoUsuario)  {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `acesso`(`LER`,`ESCREVER`,`DELETAR`,`SUPER_USUARIO`,\n" +
            "`USUARIO_CODIGO_USUARIO`,`INTERFACE_CODIGO_INTERFACE`)VALUES(?,?,?,?,?,?);";

        try {
            ps = con.prepareStatement(sqlInsert);

            setPreparedStatement1(acessoUsuario, ps);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AcessoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
    }

    private void setPreparedStatement(AcessoUsuario acessoUsuario, PreparedStatement ps)
            throws SQLException {
        if(acessoUsuario.getLer() == true){
            ps.setInt(1, 0);            
        } else {
            ps.setInt(1, 1);            
        }
        
        if(acessoUsuario.getEscrever()== true){
            ps.setInt(2, 0);            
        } else {
            ps.setInt(2, 1);            
        }
        
        if(acessoUsuario.getDeletar()== true){
            ps.setInt(3, 0);            
        } else {
            ps.setInt(3, 1);            
        }
        
        if(acessoUsuario.getSuper_usuario()== true){
            ps.setInt(4, 0);            
        } else {
            ps.setInt(4, 1);            
        }
        
        ps.setInt(5, acessoUsuario.getCodigo_acesso());
        
    }

    private void setPreparedStatement1(AcessoUsuario acessoUsuario, PreparedStatement ps)
            throws SQLException {
        
        if(acessoUsuario.getLer() == true){
            ps.setInt(1, 0);            
        } else {
            ps.setInt(1, 1);            
        }
        
        if(acessoUsuario.getEscrever()== true){
            ps.setInt(2, 0);            
        } else {
            ps.setInt(2, 1);            
        }
        
        if(acessoUsuario.getDeletar()== true){
            ps.setInt(3, 0);            
        } else {
            ps.setInt(3, 1);            
        }
        
        if(acessoUsuario.getSuper_usuario()== true){
            ps.setInt(4, 0);            
        } else {
            ps.setInt(4, 1);            
        }
                
        ps.setInt(5, acessoUsuario.getUsuario().getCodigo_usuario());
        ps.setInt(6, acessoUsuario.getInterfaceAcesso().getCodigo_interface());
        
    }

    public List<Usuario> getUsuarios() throws SQLException {
        List<Usuario> resultado = new ArrayList<Usuario>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM CLIENTE ORDER BY NOME_CLIENTE;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

//            resultado = getListaUsuario(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

}
