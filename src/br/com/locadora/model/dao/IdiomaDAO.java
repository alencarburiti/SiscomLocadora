package br.com.locadora.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Idioma;

public class IdiomaDAO implements InterfaceIdiomaDAO {

    private InterfacePool pool;

    public IdiomaDAO(InterfacePool pool) {
        this.pool = pool;
    }

    @Override
    public void atualizar(Idioma idioma) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareCall("{CALL SP_UPDATE_GENERO_BY_PK(?,?)}");
            
            setPreparedStatement(idioma, ps);

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
        String sqlExcluir = "DELETE FROM GENERO WHERE CODIGO_GENERO = ?;";

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
    public Idioma getIdioma_codigo(Integer codigo) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM GENERO WHERE CODIGO_GENERO = ?;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo);

            rs = ps.executeQuery();

            List<Idioma> resultado = getListaIdioma(rs);
            if (resultado.size() > 0) {
                return resultado.get(0);
            }
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return null;
    }

    @Override
    public List<Idioma> getIdioma_nome(String nome_idioma) throws SQLException {
        List<Idioma> resultado = new ArrayList<Idioma>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM IDIOMA WHERE NOME_IDIOMA LIKE ? ORDER BY NOME_IDIOMA;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%"+nome_idioma+"%");
            rs = ps.executeQuery();

            resultado = getListaIdioma(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
        
    private List<Idioma> getListaIdioma(ResultSet rs) throws SQLException {
        List<Idioma> resultado = new ArrayList<Idioma>();
        while (rs.next()) {
            Idioma idioma = new Idioma();
            idioma.setCodigo_idioma(rs.getInt("CODIGO_IDIOMA"));
            idioma.setNome_idioma(rs.getString("NOME_IDIOMA"));
            
            resultado.add(idioma);
        }
        return resultado;
    }

    @Override
    public void salvar(Idioma idioma) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `GENERO`(`NOME_GENERO`)VALUES(?);";

        try {
            ps = con.prepareStatement(sqlInsert);

            setPreparedStatement1(idioma, ps);

            ps.executeUpdate();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }

    private void setPreparedStatement(Idioma idioma, PreparedStatement ps)
            throws SQLException {
        ps.setInt(1, idioma.getCodigo_idioma());
        ps.setString(2, idioma.getNome_idioma());
     
    }

    private void setPreparedStatement1(Idioma idioma, PreparedStatement ps)
            throws SQLException {
            ps.setString(1, idioma.getNome_idioma());
    }

    public List<Idioma> getIdiomas() throws SQLException {
        List<Idioma> resultado = new ArrayList<Idioma>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM CLIENTE ORDER BY NOME_CLIENTE;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaIdioma(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

}
