package br.com.locadora.model.dao;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.Objeto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CopiaDAO implements InterfaceCopiaDAO {

    private InterfacePool pool;

    public CopiaDAO(InterfacePool pool) {
        this.pool = pool;
    }

    @Override
    public void atualizar(Copia copia) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlAtualizar = " UPDATE `copia` SET `IDIOMA` = ?, `LEGENDA` = ?, `DATA_AQUISICAO` = ?,\n" +
            "`PRECO_CUSTO` = ?, `DEFECT_FLAG` = ?, `DIARIA_CODIGO_DIARIA` = ?, `MIDIA` = ?\n" +
            "WHERE `CODIGO_COPIA` = ?;";

        try {
            ps = con.prepareStatement(sqlAtualizar);

            setPreparedStatement(copia, ps);

            ps.executeUpdate();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }

    @Override
    public void alterarStatusFilme(Copia copia) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlAtualizar = " UPDATE COPIA SET DEL_FLAG = ? WHERE CODIGO_COPIA = ? ;";

        try {
            ps = con.prepareStatement(sqlAtualizar);

            ps.setString(1, copia.getStatus());
            ps.setInt(2, copia.getCodigo_copia());

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
        String sqlExcluir = "DELETE FROM COPIA WHERE CODIGO_COPIA = ?;";

        try {
            ps = con.prepareStatement(sqlExcluir);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
    }

    public Integer getObjetoDisponivel(Integer codigo_interno) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    COUNT(CODIGO_COPIA) AS QUANTIDADE_DISPONIVEL\n"
                + "FROM\n"
                + "	OBJETO A,\n"
                + "    COPIA B\n"
                + "WHERE\n"
                + "	A.CODIGO_OBJETO = B.CODIGO_OBJETO\n"
                + "    AND A.CODIGO_OBJETO = ?\n"
                + "	AND B.DEL_FLAG = 0;";

        Integer quantidade_disponivel;
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_interno);

            rs = ps.executeQuery();

            quantidade_disponivel = rs.getInt("QUANTIDADE_DISPONIVEL");
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return quantidade_disponivel;
    }

    @Override
    public List<Copia> getCopia(Integer codigo_interno) throws SQLException {
        List<Copia> resultado = new ArrayList<Copia>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    *,\n"
                + "    (CASE\n"
                + "        WHEN OB.DEL_FLAG = 0 THEN ''\n"
                + "        ELSE (SELECT \n"
                + "                MAX(DATA_PREVISTA)\n"
                + "            FROM\n"
                + "                ITEM_LOCACAO\n"
                + "            WHERE\n"
                + "                COPIA_CODIGO_COPIA = OB.CODIGO_COPIA AND DEL_FLAG = 1)\n"
                + "    END) AS DATA_PREVISTA\n"
                + "FROM\n"
                + "    (SELECT \n"
                + "        A.CODIGO_COPIA AS CODIGO_COPIA,\n"
                + "            A.OBJETO_CODIGO_OBJETO AS OBJETO_CODIGO_OBJETO,\n"
                + "            A.CODIGO_BARRAS AS CODIGO_BARRAS,\n"
                + "            A.DEL_FLAG AS DEL_FLAG,\n"
                + "            A.DEFECT_FLAG AS DEFECT_FLAG,\n"
                + "            A.PRECO_CUSTO AS PRECO_CUSTO,\n"
                + "            A.DATA_AQUISICAO AS DATA_AQUISICAO,\n"
                + "            A.NUMERO_COPIA AS NUMERO_COPIA,\n"
                + "            B.TITULO AS TITULO,\n"
                + "            B.TIPO_MOVIMENTO AS TIPO_MOVIMENTO,\n"
                + "            B.TIPO_MIDIA AS TIPO_MIDIA,\n"
                + "            B.CENSURA AS CENSURA,\n"
                + "            A.IDIOMA AS IDIOMA,\n"
                + "            A.LEGENDA AS LEGENDA,\n"
                + "            C.CODIGO_DIARIA AS CODIGO_DIARIA,\n"
                + "            C.NOME_DIARIA,\n"
                + "            C.DIAS AS DIAS,\n"
                + "            C.VALOR AS VALOR,\n"
                + "            C.MAXIMO_DIAS AS MAXIMO_DIAS,\n"
                + "            C.ACUMULATIVO AS ACUMULATIVO\n"
                + "    FROM\n"
                + "        COPIA A, OBJETO B, DIARIA C\n"
                + "    WHERE\n"
                + "        A.OBJETO_CODIGO_OBJETO = B.CODIGO_OBJETO\n"
                + "            AND C.CODIGO_DIARIA = A.DIARIA_CODIGO_DIARIA\n"
                + "            AND TIPO_MOVIMENTO = 'Locação'\n"
                + "            AND A.CODIGO_COPIA = ? \n"
                + "    ORDER BY B.TITULO , CODIGO_COPIA\n"
                + "    LIMIT 0 , 50) AS OB;\n"
                + "           \n"
                + "           ";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_interno);

            rs = ps.executeQuery();

            resultado = getListaCopia(rs);
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public boolean getCopia_existente(String codigo_barras) throws SQLException {

        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT COUNT(CODIGO_COPIA) AS COUNT FROM COPIA WHERE CODIGO_BARRAS = ? AND DEFECT_FLAG = 0 LIMIT 0, 50;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, codigo_barras);

            rs = ps.executeQuery();
            Integer quantidade_existente;
            rs.next();

            quantidade_existente = rs.getInt("COUNT");

            if (quantidade_existente > 0) {
                return true;
            }
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return false;
    }

    public boolean getObjeto_existente(Integer codigo_objeto) throws SQLException {

        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT COUNT(CODIGO_OBJETO) AS COUNT FROM OBJETO WHERE CODIGO_OBJETO = ? AND DEL_FLAG = 0 LIMIT 0, 50;";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_objeto);

            rs = ps.executeQuery();
            Integer quantidade_existente;
            rs.next();

            quantidade_existente = rs.getInt("COUNT");

            if (quantidade_existente > 0) {
                return true;
            }
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return false;
    }

    public List<Copia> getCopia_codigo_barras(String codigo_barras) {
        List<Copia> resultado = new ArrayList<Copia>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    *,\n"
                + "    (CASE\n"
                + "        WHEN OB.DEL_FLAG = 0 THEN ''\n"
                + "        ELSE (SELECT \n"
                + "                MAX(DATA_PREVISTA)\n"
                + "            FROM\n"
                + "                ITEM_LOCACAO\n"
                + "            WHERE\n"
                + "                COPIA_CODIGO_COPIA = OB.CODIGO_COPIA AND DEL_FLAG = 1)\n"
                + "    END) AS DATA_PREVISTA\n"
                + "FROM\n"
                + "    (SELECT \n"
                + "        A.CODIGO_COPIA AS CODIGO_COPIA,\n"
                + "            A.OBJETO_CODIGO_OBJETO AS OBJETO_CODIGO_OBJETO,\n"
                + "            A.CODIGO_BARRAS AS CODIGO_BARRAS,\n"
                + "            A.DEL_FLAG AS DEL_FLAG,\n"
                + "            A.DEFECT_FLAG AS DEFECT_FLAG,\n"
                + "            A.PRECO_CUSTO AS PRECO_CUSTO,\n"
                + "            A.DATA_AQUISICAO AS DATA_AQUISICAO,\n"
                + "            A.NUMERO_COPIA AS NUMERO_COPIA,\n"
                + "            B.TITULO AS TITULO,\n"
                + "            B.TIPO_MOVIMENTO AS TIPO_MOVIMENTO,\n"
                + "            B.TIPO_MIDIA AS TIPO_MIDIA,\n"
                + "            A.MIDIA AS MIDIA,\n"
                + "            B.CENSURA AS CENSURA,\n"
                + "            A.IDIOMA AS IDIOMA,\n"
                + "            A.LEGENDA AS LEGENDA,\n"
                + "            C.CODIGO_DIARIA AS CODIGO_DIARIA,\n"
                + "            C.NOME_DIARIA,\n"
                + "            C.DIAS AS DIAS,\n"
                + "            C.VALOR AS VALOR,\n"
                + "            C.MAXIMO_DIAS AS MAXIMO_DIAS,\n"
                + "            C.ACUMULATIVO AS ACUMULATIVO\n"
                + "    FROM\n"
                + "        COPIA A, OBJETO B, DIARIA C\n"
                + "    WHERE\n"
                + "        A.OBJETO_CODIGO_OBJETO = B.CODIGO_OBJETO\n"
                + "            AND C.CODIGO_DIARIA = A.DIARIA_CODIGO_DIARIA\n"
                + "            AND TIPO_MOVIMENTO = 'Locação'\n"
                + "            AND A.CODIGO_BARRAS = ? \n"
                + "    ORDER BY B.TITULO , CODIGO_COPIA\n"
                + "    LIMIT 0 , 50) AS OB;\n"
                + "           \n"
                + "           ";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, codigo_barras);

            rs = ps.executeQuery();

            resultado = getListaCopia(rs);

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CopiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;

    }

    public List<Copia> getCopia_codigo_objeto(Integer codigo_objeto, Integer del_flag, String tipo_movimento) throws SQLException {
        List<Copia> resultado = new ArrayList<Copia>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect_del_flag = "SELECT \n"
                + "    *,\n"
                + "    (CASE\n"
                + "        WHEN OB.DEL_FLAG = 0 THEN ''\n"
                + "        ELSE (SELECT \n"
                + "                MAX(DATA_PREVISTA)\n"
                + "            FROM\n"
                + "                ITEM_LOCACAO\n"
                + "            WHERE\n"
                + "                COPIA_CODIGO_COPIA = OB.CODIGO_COPIA AND DEL_FLAG = 1)\n"
                + "    END) AS DATA_PREVISTA\n"
                + "FROM\n"
                + "    (SELECT \n"
                + "     A.CODIGO_COPIA, \n"
                + "     A.OBJETO_CODIGO_OBJETO, \n"
                + "    A.CODIGO_BARRAS,\n"
                + "    A.NUMERO_COPIA,\n"
                + "    A.PRECO_CUSTO,\n"
                + "    A.DEL_FLAG,\n"
                + "    A.DEFECT_FLAG,\n"
                + "    A.DATA_AQUISICAO,\n"
                + "    B.TITULO,\n"
                + "    B.CODIGO_OBJETO,\n"
                + "    B.TIPO_MOVIMENTO,\n"
                + "    B.TIPO_MIDIA,\n"
                + "    A.MIDIA AS MIDIA,\n"
                + "    B.CENSURA,\n"
                + "    A.IDIOMA,\n"
                + "    A.LEGENDA,\n"
                + "    C.CODIGO_DIARIA,\n"
                + "    C.NOME_DIARIA,\n"
                + "    C.DIAS,\n"
                + "    C.VALOR,\n"
                + "    C.MAXIMO_DIAS,\n"
                + "    C.ACUMULATIVO\n"
                + "FROM\n"
                + "    COPIA A,\n"
                + "    OBJETO B,\n"
                + "    DIARIA C\n"
                + "WHERE\n"
                + "    A.OBJETO_CODIGO_OBJETO = B.CODIGO_OBJETO\n"
                + "        AND C.CODIGO_DIARIA = A.DIARIA_CODIGO_DIARIA\n"
                + "        AND A.DEL_FLAG = 0\n"
                + "        AND A.DEFECT_FLAG = 0\n"
                + "        AND TIPO_MOVIMENTO LIKE ?\n"
                + "           AND B.CODIGO_OBJETO = ? ORDER BY CODIGO_COPIA, CODIGO_BARRAS LIMIT 0, 50) AS OB;";

        String sqlSelect = "SELECT \n"
                + "    *,\n"
                + "    (CASE\n"
                + "        WHEN OB.DEL_FLAG = 0 THEN ''\n"
                + "        ELSE (SELECT \n"
                + "                MAX(DATA_PREVISTA)\n"
                + "            FROM\n"
                + "                ITEM_LOCACAO\n"
                + "            WHERE\n"
                + "                COPIA_CODIGO_COPIA = OB.CODIGO_COPIA\n"
                + "                    AND DEL_FLAG = 1)\n"
                + "    END) AS DATA_PREVISTA\n"
                + "FROM\n"
                + "    (SELECT \n"
                + "        A.CODIGO_COPIA,\n"
                + "            A.OBJETO_CODIGO_OBJETO,\n"
                + "            A.CODIGO_BARRAS,\n"
                + "            A.NUMERO_COPIA,\n"
                + "            A.PRECO_CUSTO,\n"
                + "            A.DEL_FLAG,\n"
                + "            A.DEFECT_FLAG,\n"
                + "            A.IDIOMA,\n"
                + "            A.LEGENDA,\n"
                + "            A.DATA_AQUISICAO,\n"                
                + "            B.TITULO,\n"
                + "            B.CODIGO_OBJETO,\n"
                + "            B.TIPO_MOVIMENTO,\n"
                + "            B.TIPO_MIDIA,\n"
                + "            A.MIDIA AS MIDIA,\n"
                + "            B.CENSURA,\n"
                + "            C.CODIGO_DIARIA,\n"
                + "    C.NOME_DIARIA,\n"
                + "            C.DIAS,\n"
                + "            C.VALOR,\n"
                + "            C.MAXIMO_DIAS,\n"
                + "            C.ACUMULATIVO\n"
                + "    FROM\n"
                + "        COPIA A, OBJETO B, DIARIA C\n"
                + "    WHERE\n"
                + "        A.OBJETO_CODIGO_OBJETO = B.CODIGO_OBJETO\n"
                + "            AND C.CODIGO_DIARIA = A.DIARIA_CODIGO_DIARIA\n"
                + "            AND TIPO_MOVIMENTO LIKE ?\n"
                + "            AND B.CODIGO_OBJETO = ?\n"
                + "    ORDER BY CODIGO_COPIA , CODIGO_BARRAS\n"
                + "    LIMIT 0 , 50) AS OB;";

        try {
            if (del_flag == 0) {
                ps = con.prepareStatement(sqlSelect_del_flag);
            } else {
                ps = con.prepareStatement(sqlSelect);
            }
            ps.setString(1, "%" + tipo_movimento);
            ps.setInt(2, codigo_objeto);

            rs = ps.executeQuery();

            resultado = getListaCopia(rs);
            ps.close();
            return resultado;
        } catch (SQLException ex) {
            Logger.getLogger(CopiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return null;

    }

    public List<Copia> getCopia_titulo(String titulo) throws SQLException {
        List<Copia> resultado = new ArrayList<Copia>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sqlSelect = "SELECT \n"
                + "    *,\n"
                + "    (CASE\n"
                + "        WHEN OB.DEL_FLAG = 0 THEN ''\n"
                + "        ELSE (SELECT \n"
                + "                MAX(DATA_PREVISTA)\n"
                + "            FROM\n"
                + "                ITEM_LOCACAO\n"
                + "            WHERE\n"
                + "                COPIA_CODIGO_COPIA = OB.CODIGO_COPIA AND DEL_FLAG = 1)\n"
                + "    END) AS DATA_PREVISTA\n"
                + "FROM\n"
                + "    (SELECT \n"
                + "        A.CODIGO_COPIA AS CODIGO_COPIA,\n"
                + "            A.OBJETO_CODIGO_OBJETO AS OBJETO_CODIGO_OBJETO,\n"
                + "            A.CODIGO_BARRAS AS CODIGO_BARRAS,\n"
                + "            A.DEL_FLAG AS DEL_FLAG,\n"
                + "            A.PRECO_CUSTO AS PRECO_CUSTO,\n"
                + "            A.DATA_AQUISICAO AS DATA_AQUISICAO,\n"
                + "            A.NUMERO_COPIA AS NUMERO_COPIA,\n"
                + "            A.DEFECT_FLAG AS DEFECT_FLAG,\n"
                + "            B.TITULO AS TITULO,\n"
                + "            B.TIPO_MOVIMENTO AS TIPO_MOVIMENTO,\n"
                + "            B.TIPO_MIDIA AS TIPO_MIDIA,\n"
                + "            A.MIDIA AS MIDIA,\n"
                + "            B.CENSURA AS CENSURA,\n"
                + "            A.IDIOMA AS IDIOMA,\n"
                + "            A.LEGENDA AS LEGENDA,\n"
                + "            C.CODIGO_DIARIA AS CODIGO_DIARIA,\n"
                + "            C.NOME_DIARIA,\n"
                + "            C.DIAS AS DIAS,\n"
                + "            C.VALOR AS VALOR,\n"
                + "            C.MAXIMO_DIAS AS MAXIMO_DIAS,\n"
                + "            C.ACUMULATIVO AS ACUMULATIVO\n"
                + "    FROM\n"
                + "        COPIA A, OBJETO B, DIARIA C\n"
                + "    WHERE\n"
                + "        A.OBJETO_CODIGO_OBJETO = B.CODIGO_OBJETO\n"
                + "            AND C.CODIGO_DIARIA = A.DIARIA_CODIGO_DIARIA\n"
                + "            AND TIPO_MOVIMENTO = 'Locação'\n"
                + "            AND B.TITULO LIKE ? \n"
                + "    ORDER BY B.TITULO , CODIGO_COPIA\n"
                + "    LIMIT 0 , 50) AS OB;\n"
                + "           \n"
                + "           ";
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + titulo + "%");

            rs = ps.executeQuery();

            resultado = getListaCopia(rs);
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    public List<Copia> getCopia_diretor(String diretor) throws SQLException {
        List<Copia> resultado = new ArrayList<Copia>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sqlSelect = "SELECT \n"
                + "    *,\n"
                + "    (CASE\n"
                + "        WHEN OB.DEL_FLAG = 0 THEN ''\n"
                + "        ELSE (SELECT \n"
                + "                MAX(DATA_PREVISTA)\n"
                + "            FROM\n"
                + "                ITEM_LOCACAO\n"
                + "            WHERE\n"
                + "                COPIA_CODIGO_COPIA = OB.CODIGO_COPIA AND DEL_FLAG = 1)\n"
                + "    END) AS DATA_PREVISTA\n"
                + "FROM\n"
                + "    (SELECT \n"
                + "        A.CODIGO_COPIA AS CODIGO_COPIA,\n"
                + "            A.OBJETO_CODIGO_OBJETO AS OBJETO_CODIGO_OBJETO,\n"
                + "            A.CODIGO_BARRAS AS CODIGO_BARRAS,\n"
                + "            A.DEL_FLAG AS DEL_FLAG,\n"
                + "            A.PRECO_CUSTO AS PRECO_CUSTO,\n"
                + "            A.DATA_AQUISICAO AS DATA_AQUISICAO,\n"
                + "            A.NUMERO_COPIA AS NUMERO_COPIA,\n"
                + "            A.DEFECT_FLAG AS DEFECT_FLAG,\n"
                + "            B.TITULO AS TITULO,\n"
                + "            B.TIPO_MOVIMENTO AS TIPO_MOVIMENTO,\n"
                + "            B.TIPO_MIDIA AS TIPO_MIDIA,\n"
                + "            A.MIDIA AS MIDIA,\n"
                + "            B.CENSURA AS CENSURA,\n"
                + "            A.IDIOMA AS IDIOMA,\n"
                + "            A.LEGENDA AS LEGENDA,\n"
                + "            C.CODIGO_DIARIA AS CODIGO_DIARIA,\n"
                + "            C.NOME_DIARIA,\n"
                + "            C.DIAS AS DIAS,\n"
                + "            C.VALOR AS VALOR,\n"
                + "            C.MAXIMO_DIAS AS MAXIMO_DIAS,\n"
                + "            C.ACUMULATIVO AS ACUMULATIVO\n"
                + "    FROM\n"
                + "        COPIA A, OBJETO B, DIARIA C\n"
                + "    WHERE\n"
                + "        A.OBJETO_CODIGO_OBJETO = B.CODIGO_OBJETO\n"
                + "            AND C.CODIGO_DIARIA = A.DIARIA_CODIGO_DIARIA\n"
                + "            AND TIPO_MOVIMENTO = 'Locação'\n"
                + "            AND B.DIRETOR LIKE ? \n"
                + "    ORDER BY B.TITULO , CODIGO_COPIA\n"
                + "    LIMIT 0 , 50) AS OB;\n"
                + "           \n"
                + "           ";
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + diretor + "%");

            rs = ps.executeQuery();

            resultado = getListaCopia(rs);
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    public List<Copia> getCopia_sinopse(String diretor) throws SQLException {
        List<Copia> resultado = new ArrayList<Copia>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sqlSelect = "SELECT \n"
                + "    *,\n"
                + "    (CASE\n"
                + "        WHEN OB.DEL_FLAG = 0 THEN ''\n"
                + "        ELSE (SELECT \n"
                + "                MAX(DATA_PREVISTA)\n"
                + "            FROM\n"
                + "                ITEM_LOCACAO\n"
                + "            WHERE\n"
                + "                COPIA_CODIGO_COPIA = OB.CODIGO_COPIA AND DEL_FLAG = 1)\n"
                + "    END) AS DATA_PREVISTA\n"
                + "FROM\n"
                + "    (SELECT \n"
                + "        A.CODIGO_COPIA AS CODIGO_COPIA,\n"
                + "            A.OBJETO_CODIGO_OBJETO AS OBJETO_CODIGO_OBJETO,\n"
                + "            A.CODIGO_BARRAS AS CODIGO_BARRAS,\n"
                + "            A.DEL_FLAG AS DEL_FLAG,\n"
                + "            A.PRECO_CUSTO AS PRECO_CUSTO,\n"
                + "            A.DATA_AQUISICAO AS DATA_AQUISICAO,\n"
                + "            A.NUMERO_COPIA AS NUMERO_COPIA,\n"
                + "            A.DEFECT_FLAG AS DEFECT_FLAG,\n"
                + "            B.TITULO AS TITULO,\n"
                + "            B.TIPO_MOVIMENTO AS TIPO_MOVIMENTO,\n"
                + "            B.TIPO_MIDIA AS TIPO_MIDIA,\n"
                + "            A.MIDIA AS MIDIA,\n"
                + "            B.CENSURA AS CENSURA,\n"
                + "            A.IDIOMA AS IDIOMA,\n"
                + "            A.LEGENDA AS LEGENDA,\n"
                + "            C.CODIGO_DIARIA AS CODIGO_DIARIA,\n"
                + "            C.NOME_DIARIA,\n"
                + "            C.DIAS AS DIAS,\n"
                + "            C.VALOR AS VALOR,\n"
                + "            C.MAXIMO_DIAS AS MAXIMO_DIAS,\n"
                + "            C.ACUMULATIVO AS ACUMULATIVO\n"
                + "    FROM\n"
                + "        COPIA A, OBJETO B, DIARIA C\n"
                + "    WHERE\n"
                + "        A.OBJETO_CODIGO_OBJETO = B.CODIGO_OBJETO\n"
                + "            AND C.CODIGO_DIARIA = A.DIARIA_CODIGO_DIARIA\n"
                + "            AND TIPO_MOVIMENTO = 'Locação'\n"
                + "            AND B.DIRETOR LIKE ? \n"
                + "    ORDER BY B.TITULO , CODIGO_COPIA\n"
                + "    LIMIT 0 , 50) AS OB;\n"
                + "           \n"
                + "           ";
        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + diretor + "%");

            rs = ps.executeQuery();

            resultado = getListaCopia(rs);
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<Copia> getCopia_elenco(String ator) throws SQLException {
        List<Copia> resultado = new ArrayList<Copia>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n"
                + "    *,\n"
                + "    (CASE\n"
                + "        WHEN OB.DEL_FLAG = 0 THEN ''\n"
                + "        ELSE (SELECT \n"
                + "                MAX(DATA_PREVISTA)\n"
                + "            FROM\n"
                + "                ITEM_LOCACAO\n"
                + "            WHERE\n"
                + "                COPIA_CODIGO_COPIA = OB.CODIGO_COPIA AND DEL_FLAG = 1)\n"
                + "    END) AS DATA_PREVISTA\n"
                + "FROM\n"
                + "    (SELECT \n"
                + "        A.CODIGO_COPIA AS CODIGO_COPIA,\n"
                + "            A.OBJETO_CODIGO_OBJETO AS OBJETO_CODIGO_OBJETO,\n"
                + "            A.CODIGO_BARRAS AS CODIGO_BARRAS,\n"
                + "            A.DEL_FLAG AS DEL_FLAG,\n"
                + "            A.PRECO_CUSTO AS PRECO_CUSTO,\n"
                + "            A.DATA_AQUISICAO AS DATA_AQUISICAO,\n"
                + "            A.NUMERO_COPIA AS NUMERO_COPIA,\n"
                + "            A.DEFECT_FLAG AS DEFECT_FLAG,\n"
                + "            B.TITULO AS TITULO,\n"
                + "            B.TIPO_MOVIMENTO AS TIPO_MOVIMENTO,\n"
                + "            A.MIDIA AS MIDIA,\n"
                + "            B.TIPO_MIDIA AS TIPO_MIDIA,\n"
                + "            B.CENSURA AS CENSURA,\n"
                + "            A.IDIOMA AS IDIOMA,\n"
                + "            A.LEGENDA AS LEGENDA,\n"
                + "            C.CODIGO_DIARIA AS CODIGO_DIARIA,\n"
                + "            C.NOME_DIARIA,\n"
                + "            C.DIAS AS DIAS,\n"
                + "            C.VALOR AS VALOR,\n"
                + "            C.MAXIMO_DIAS AS MAXIMO_DIAS,\n"
                + "            C.ACUMULATIVO AS ACUMULATIVO\n"
                + "    FROM\n"
                + "        COPIA A, OBJETO B, DIARIA C\n"
                + "    WHERE\n"
                + "        A.OBJETO_CODIGO_OBJETO = B.CODIGO_OBJETO\n"
                + "            AND C.CODIGO_DIARIA = A.DIARIA_CODIGO_DIARIA\n"
                + "            AND TIPO_MOVIMENTO = 'Locação'\n"
                + "            AND B.ELENCO LIKE ?\n"
                + "    ORDER BY B.TITULO , CODIGO_COPIA\n"
                + "    LIMIT 0 , 50) AS OB;\n"
                + "           \n"
                + "           ";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%" + ator + "%");

            rs = ps.executeQuery();

            resultado = getListaCopia(rs);
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    @Override
    public List<Copia> getCopias(String nome_copia) throws SQLException {
        List<Copia> resultado = new ArrayList<Copia>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM DIARIA WHERE NOME_DIARIA LIKE ? ORDER BY NOME_DIARIA LIMIT 0, 50;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, nome_copia);
            rs = ps.executeQuery();

            resultado = getListaCopia(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public String getQuantidadeAssistida(Integer codigo_cliente, String codigo_barras) {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT \n"
                + "    COUNT(C.LOCACAO_CODIGO_LOCACAO) AS COUNT,\n"
                + "    MAX(DATE_FORMAT(C.DATA_LOCACAO, '%d/%m/%Y')) AS ULTIMA_DATA_LOCACAO\n"
                + "FROM\n"
                + "    COPIA A,\n"
                + "    LOCACAO B,\n"
                + "    ITEM_LOCACAO C,\n"
                + "    DEPENDENTE D,\n"
                + "    OBJETO E\n"
                + "WHERE\n"
                + "    B.CODIGO_LOCACAO = C.LOCACAO_CODIGO_LOCACAO\n"
                + "        AND B.DEPENDENTE_CODIGO_DEPENDENTE = D.CODIGO_DEPENDENTE\n"
                + "        AND A.CODIGO_COPIA = C.COPIA_CODIGO_COPIA\n"
                + "        AND A.OBJETO_CODIGO_OBJETO = E.CODIGO_OBJETO\n"
                + "        AND E.CODIGO_OBJETO = (SELECT \n"
                + "            OBJETO_CODIGO_OBJETO\n"
                + "        FROM\n"
                + "            COPIA\n"
                + "        WHERE\n"
                + "            CODIGO_BARRAS = ?)		\n"
                + "        AND D.CODIGO_DEPENDENTE = ? LIMIT 0, 50;";
        ResultSet rs = null;

        try {
            Integer quantidade_locado;
            String ultima_data_locado;
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, codigo_barras);
            ps.setInt(2, codigo_cliente);

            rs = ps.executeQuery();
            rs.next();
            quantidade_locado = rs.getInt("COUNT");
            ultima_data_locado = rs.getString("ULTIMA_DATA_LOCACAO");

            rs.close();
            ps.close();
            if (quantidade_locado >= 1) {
                return "Cliente já assistiu " + quantidade_locado + ", última vez foi no dia " + ultima_data_locado + ". Deseja locar novamente ?";
            } else {
                return "";
            }
        } catch (SQLException ex) {
            Logger.getLogger(CopiaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            pool.liberarConnection(con);
        }

    }

    public List<Copia> getTodasCopias() throws SQLException {
        List<Copia> resultado = new ArrayList<Copia>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM DIARIA ORDER BY NOME_DIARIA LIMIT 0, 50;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaCopia(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    private List<Copia> getListaCopia(ResultSet rs) throws SQLException {
        List<Copia> resultado = new ArrayList<Copia>();
        while (rs.next()) {
            Copia copia = new Copia();
            Diaria diaria = new Diaria();
            Objeto objeto = new Objeto();
            diaria.setCodigo_diaria(rs.getInt("CODIGO_DIARIA"));
            diaria.setNome_diaria(rs.getString("NOME_DIARIA"));
            diaria.setDias(rs.getInt("DIAS"));
            diaria.setValor(rs.getDouble("VALOR"));
            diaria.setMaximo_dias(rs.getInt("MAXIMO_DIAS"));
            if (rs.getInt("ACUMULATIVO") == 0) {
                diaria.setAcumulativo(true);
            } else {
                diaria.setAcumulativo(false);
            }

            objeto.setTitulo(rs.getString("TITULO"));
            objeto.setTipo_movimento(rs.getString("TIPO_MOVIMENTO"));
            objeto.setTipo_midia(rs.getString("TIPO_MIDIA"));
            objeto.setCodigo_objeto(rs.getInt("OBJETO_CODIGO_OBJETO"));
            objeto.setCensura(rs.getInt("CENSURA"));

            copia.setDiaria(diaria);
            copia.setObjeto(objeto);

            copia.setCodigo_copia(rs.getInt("CODIGO_COPIA"));
            copia.setCodigo_barras(rs.getString("CODIGO_BARRAS"));
            copia.setPreco_custo(rs.getDouble("PRECO_CUSTO"));
            copia.setMidia(rs.getString("MIDIA"));

            copia.setIdioma(rs.getString("IDIOMA"));
            copia.setLegenda(rs.getString("LEGENDA"));
            copia.setData_aquisicao(rs.getDate("DATA_AQUISICAO"));
            System.out.println("Data prevista Devolução: " + rs.getString("DATA_PREVISTA"));
            if (rs.getString("DATA_PREVISTA").equals("")) {
                copia.setData_prevista(null);
            } else {
                copia.setData_prevista(rs.getDate("DATA_PREVISTA"));
            }
            copia.setNumero_copia(rs.getInt("NUMERO_COPIA"));

            if (rs.getInt("DEL_FLAG") == 0) {
                copia.setStatus("Disponível");
            } else {
                copia.setStatus("X");
            }
            if (rs.getInt("DEFECT_FLAG") == 0) {
                copia.setDefect_flag(true);
            } else {
                copia.setDefect_flag(false);
            }

            resultado.add(copia);
        }
        return resultado;
    }

    @Override
    public Copia salvar(Copia copia) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `COPIA`(`IDIOMA`,`LEGENDA`,`DATA_AQUISICAO`,"
                + "`PRECO_CUSTO`,`OBJETO_CODIGO_OBJETO`,NUMERO_COPIA, CODIGO_BARRAS, MIDIA, DIARIA_CODIGO_DIARIA, DEFECT_FLAG)VALUES(?,?,?,?,?,?,?, ?,?,?);";

        try {
            //Pega o numero da ultima copia adicionada para aquele filme
            ResultSet res;
            Integer numero_copia_max;
            String sql_max = "SELECT \n"
                    + "    CASE\n"
                    + "        WHEN MAX(NUMERO_COPIA) + 1 IS NULL THEN 1\n"
                    + "        ELSE MAX(NUMERO_COPIA) + 1\n"
                    + "    END AS NUMERO_COPIA\n"
                    + "FROM\n"
                    + "    OBJETO A,\n"
                    + "    COPIA B\n"
                    + "WHERE\n"
                    + "    A.CODIGO_OBJETO = B.OBJETO_CODIGO_OBJETO\n"
                    + "        AND A.CODIGO_OBJETO = ? ;";
            ps = con.prepareStatement(sql_max);
            ps.setInt(1, copia.getObjeto().getCodigo_objeto());
            res = ps.executeQuery();
            res.next();
            numero_copia_max = res.getInt("NUMERO_COPIA");
            copia.setCodigo_barras(copia.getObjeto().getCodigo_objeto() + "-" + numero_copia_max);
            copia.setNumero_copia(numero_copia_max);
            ps = con.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);

            setPreparedStatement1(copia, ps);

            ps.executeUpdate();

            ResultSet rs_teste = ps.getGeneratedKeys();
            if (rs_teste.next()) {

            }
            copia.setCodigo_copia(rs_teste.getInt(1));
            ps.close();
            return copia;
        } finally {
            pool.liberarConnection(con);
        }

    }

    private void setPreparedStatement(Copia copia, PreparedStatement ps)
            throws SQLException {
        Date data_aquisicao = null;
        if (copia.getData_aquisicao() != null) {
            data_aquisicao = new Date(copia.getData_aquisicao().getTime());
        }

        ps.setString(1, copia.getIdioma());
        ps.setString(2, copia.getLegenda());
        ps.setDate(3, data_aquisicao);
        ps.setDouble(4, copia.getPreco_custo());
        if (copia.getDefect_flag() == true) {
            ps.setInt(5, 0);
        } else {
            ps.setInt(5, 1);
        }
        ps.setInt(6, copia.getDiaria().getCodigo_diaria());
        ps.setString(7, copia.getMidia());
        ps.setInt(8, copia.getCodigo_copia());
    }

    private void setPreparedStatement1(Copia copia, PreparedStatement ps)
            throws SQLException {
        Date data_aquisicao = null;
        if (copia.getData_aquisicao() != null) {
            data_aquisicao = new Date(copia.getData_aquisicao().getTime());
        }
        ps.setString(1, copia.getIdioma());
        ps.setString(2, copia.getLegenda());
        ps.setDate(3, data_aquisicao);
        ps.setDouble(4, copia.getPreco_custo());
        ps.setInt(5, copia.getObjeto().getCodigo_objeto());
        ps.setInt(6, copia.getNumero_copia());
        ps.setString(7, copia.getCodigo_barras());
        ps.setString(8, copia.getMidia());
        ps.setInt(9, copia.getDiaria().getCodigo_diaria());
        if (copia.getDefect_flag() == true) {
            ps.setInt(10, 0);
        } else {
            ps.setInt(10, 1);
        }
    }

    public List<Copia> getCopias() throws SQLException {
        List<Copia> resultado = new ArrayList<Copia>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM CLIENTE ORDER BY NOME_CLIENTE;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            rs = ps.executeQuery();

            resultado = getListaCopia(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

}
