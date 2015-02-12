package br.com.locadora.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Legenda;

public class LegendaDAO implements InterfaceLegendaDAO {

    private InterfacePool pool;

    public LegendaDAO(InterfacePool pool) {
        this.pool = pool;
    }

    @Override
    public void atualizar(Legenda legenda) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareCall("{CALL SP_UPDATE_GENERO_BY_PK(?,?)}");
            
            setPreparedStatement(legenda, ps);

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
    public Legenda getLegenda_codigo(Integer codigo) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT * FROM GENERO WHERE CODIGO_GENERO = ?;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo);

            rs = ps.executeQuery();

            List<Legenda> resultado = getListaLegenda(rs);
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
    public List<Legenda> getLegenda_nome(String nome_legenda) throws SQLException {
        List<Legenda> resultado = new ArrayList<Legenda>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM LEGENDA WHERE NOME_LEGENDA LIKE ? ORDER BY NOME_LEGENDA;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%"+nome_legenda+"%");
            rs = ps.executeQuery();

            resultado = getListaLegenda(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
        
    private List<Legenda> getListaLegenda(ResultSet rs) throws SQLException {
        List<Legenda> resultado = new ArrayList<Legenda>();
        while (rs.next()) {
            Legenda legenda = new Legenda();
            legenda.setCodigo_legenda(rs.getInt("CODIGO_LEGENDA"));
            legenda.setNome_legenda(rs.getString("NOME_LEGENDA"));
            
            resultado.add(legenda);
        }
        return resultado;
    }

    @Override
    public void salvar(Legenda legenda) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `GENERO`(`NOME_GENERO`)VALUES(?);";

        try {
            ps = con.prepareStatement(sqlInsert);

            setPreparedStatement1(legenda, ps);

            ps.executeUpdate();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }

    private void setPreparedStatement(Legenda legenda, PreparedStatement ps)
            throws SQLException {
        ps.setInt(1, legenda.getCodigo_legenda());
        ps.setString(2, legenda.getNome_legenda());
     
    }

    private void setPreparedStatement1(Legenda legenda, PreparedStatement ps)
            throws SQLException {
            ps.setString(1, legenda.getNome_legenda());
    }

    public List<Legenda> getLegendas() throws SQLException {
        List<Legenda> resultado = new ArrayList<Legenda>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM CLIENTE ORDER BY NOME_CLIENTE;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaLegenda(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

}
