package br.com.locadora.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.ItemCombo;
import br.com.locadora.model.bean.ItemVenda;
import br.com.locadora.model.bean.Combo;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComboDAO {

    private InterfacePool pool;

    public ComboDAO(InterfacePool pool) {
        this.pool = pool;
    }
    
    public void atualizar(Combo pacotePromocional) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlAtualizar = "UPDATE `pacote_promocional` SET `DESCRICAO` = ?, `QUANTIDADE_TROCA` = ?,\n" +
            "`DIAS_COMBO` = ?, `VALOR` = ?, `DEL_FLAG` = ? WHERE `CODIGO_PACOTE_PROMOCIONAL` = ?;";
                
        try {            
        
            ps = con.prepareStatement(sqlAtualizar);

            setPreparedStatement1(pacotePromocional, ps);

            ps.executeUpdate();
                                  
            ps.close();
            
            System.out.println("Gravado com sucesso");
        } finally {
            pool.liberarConnection(con);
        }
    }
    
    public boolean excluir(Integer codigo)  {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlExcluir = "DELETE FROM PACOTE_PROMOCIONAL WHERE CODIGO_PACOTE_PROMOCIONAL = ?;";

        try {
            ps = con.prepareStatement(sqlExcluir);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;            
        } finally {
            pool.liberarConnection(con);
        } 
    }  
    
    public boolean excluirItem(Integer codigo)  {
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlExcluir = "DELETE FROM ITEM_PACOTE_PROMOCIONAL WHERE CODIGO_ITEM_PACOTE_PROMOCIONAL = ?;";

        try {
            ps = con.prepareStatement(sqlExcluir);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;            
        } finally {
            pool.liberarConnection(con);
        } 
    }  
    
    public List<Combo> getPacotePromocionalCodigo(Integer codigo_pacote_promocional) {        
        List<Combo> resultado = new ArrayList<Combo>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM PACOTE_PROMOCIONAL WHERE CODIGO_PACOTE_PROMOCIONAL = ? ORDER BY DESCRICAO LIMIT 0, 50;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_pacote_promocional);

            rs = ps.executeQuery();

            resultado = getListaPacotePromocional(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    public List<Combo> getPacotePromocionalDescricao(String descricao) {        
        List<Combo> resultado = new ArrayList<Combo>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM PACOTE_PROMOCIONAL WHERE DESCRICAO LIKE ? ORDER BY DESCRICAO LIMIT 0, 50;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%"+descricao+"%");

            rs = ps.executeQuery();

            resultado = getListaPacotePromocional(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    public List<ItemCombo> getItensPacotePromocional(Integer codigo_pacote_promocional) throws SQLException {        
        List<ItemCombo> resultado = new ArrayList<ItemCombo>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT * FROM PACOTE_PROMOCIONAL A, ITEM_PACOTE_PROMOCIONAL B, DIARIA C "
                + "WHERE A.CODIGO_PACOTE_PROMOCIONAL = B.PACOTE_PROMOCIONAL_CODIGO_PACOTE_PROMOCIONAL "
                + "AND B.DIARIA_CODIGO_DIARIA = C.CODIGO_DIARIA AND B.PACOTE_PROMOCIONAL_CODIGO_PACOTE_PROMOCIONAL = ? "
                + " ORDER BY NOME_DIARIA LIMIT 0, 50;";
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_pacote_promocional);

            rs = ps.executeQuery();

            resultado = getListaItemPacotePromocional(rs);

            rs.close();
            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    public List<Combo> getPacotePromocionalCliente(Integer codigo_cliente) {        
        List<Combo> resultado = new ArrayList<Combo>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT \n" +
            "    B.CODIGO_PACOTE_PROMOCIONAL,\n" +
            "    DESCRICAO,\n" +
            "    QUANTIDADE_TROCA,\n" +
            "    DIAS_COMBO,\n" +
            "    QUANTIDADE,\n" +
            "    PRECO_TOTAL,\n" +
            "    DATA_LANCAMENTO,\n" +
            "    (CURRENT_DATE - DATA_LANCAMENTO) AS DIAS_CORRIDOS,\n" +
            "    (DIAS_COMBO) AS DIAS_PACOTE,\n" +
            "    (DIAS_COMBO) - (CURRENT_DATE - DATA_LANCAMENTO) AS DIAS_RESTANTE,\n" +
            "    DEL_FLAG,\n" +
            "    (SELECT \n" +
            "            COUNT(ITEM_VENDA_CODIGO_ITEM_VENDA)\n" +
            "        FROM\n" +
            "            ITEM_LOCACAO IL,\n" +
            "            LOCACAO B\n" +
            "        WHERE\n" +
            "            IL.LOCACAO_CODIGO_LOCACAO = B.CODIGO_LOCACAO\n" +
            "                AND B.DEPENDENTE_CODIGO_DEPENDENTE IN (SELECT \n" +
            "                    CODIGO_DEPENDENTE\n" +
            "                FROM\n" +
            "                    DEPENDENTE\n" +
            "                WHERE\n" +
            "                    CLIENTE_CODIGO_CLIENTE = ?)\n" +
            "                AND ITEM_VENDA_CODIGO_ITEM_VENDA != 0\n" +
            "                AND ITEM_VENDA_CODIGO_ITEM_VENDA = A.CODIGO_ITEM_VENDA) AS TROCA_EFETUADA\n" +
            "FROM\n" +
            "    ITEM_VENDA A,\n" +
            "    PACOTE_PROMOCIONAL B\n" +
            "WHERE\n" +
            "    VENDA_CODIGO_VENDA IN (SELECT \n" +
            "            CODIGO_VENDA\n" +
            "        FROM\n" +
            "            VENDA\n" +
            "        WHERE\n" +
            "            DEPENDENTE_CODIGO_DEPENDENTE IN (SELECT \n" +
            "                    CODIGO_DEPENDENTE\n" +
            "                FROM\n" +
            "                    DEPENDENTE\n" +
            "                WHERE\n" +
            "                    CLIENTE_CODIGO_CLIENTE = ?))\n" +
            "        AND TYPE_PRODUCT = 0\n" +
            "        AND B.CODIGO_PACOTE_PROMOCIONAL = A.PACOTE_PROMOCIONAL_CODIGO_PACOTE_PROMOCIONAl;";                        
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_cliente);
            ps.setInt(2, codigo_cliente);

            rs = ps.executeQuery();

            resultado = getListaPacotePromocionalCliente(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    public List<Combo> getPacotePromocionalClienteDiaria(Integer codigo_cliente, Integer codigo_diaria) {        
        List<Combo> resultado = new ArrayList<Combo>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "SELECT \n" +
            "    B.CODIGO_PACOTE_PROMOCIONAL,\n" +
            "    D.NOME_DIARIA,\n" +
            "    DESCRICAO,\n" +
            "    CODIGO_ITEM_VENDA,\n" +
            "    QUANTIDADE_TROCA,\n" +
            "    (CURRENT_DATE - DATA_LANCAMENTO) AS DIAS_CORRIDOS,\n" +
            "    (DIAS_COMBO) AS DIAS_PACOTE,\n" +
            "    (DIAS_COMBO) - (CURRENT_DATE - DATA_LANCAMENTO) AS DIAS_RESTANTE,\n" +
            "    DIARIA_CODIGO_DIARIA,\n" +
            "    (SELECT \n" +
            "            COUNT(ITEM_VENDA_CODIGO_ITEM_VENDA)\n" +
            "        FROM\n" +
            "            ITEM_LOCACAO IL,\n" +
            "            LOCACAO B\n" +
            "        WHERE\n" +
            "            IL.LOCACAO_CODIGO_LOCACAO = B.CODIGO_LOCACAO\n" +
            "                AND B.DEPENDENTE_CODIGO_DEPENDENTE IN (SELECT \n" +
            "                    CODIGO_DEPENDENTE\n" +
            "                FROM\n" +
            "                    DEPENDENTE\n" +
            "                WHERE\n" +
            "                    CLIENTE_CODIGO_CLIENTE = ?)\n" +
            "                AND ITEM_VENDA_CODIGO_ITEM_VENDA != 0\n" +
            "                AND ITEM_VENDA_CODIGO_ITEM_VENDA = A.CODIGO_ITEM_VENDA) AS TROCA_EFETUADA\n" +
            "FROM\n" +
            "    ITEM_VENDA A,\n" +
            "    PACOTE_PROMOCIONAL B,\n" +
            "    ITEM_PACOTE_PROMOCIONAL C,\n" +
            "    DIARIA D\n" +
            "WHERE\n" +
            "    B.CODIGO_PACOTE_PROMOCIONAL = C.PACOTE_PROMOCIONAL_CODIGO_PACOTE_PROMOCIONAL\n" +
            "        AND C.DIARIA_CODIGO_DIARIA = D.CODIGO_DIARIA\n" +
            "        AND DIARIA_CODIGO_DIARIA = ?\n" +
            "        AND VENDA_CODIGO_VENDA IN (SELECT \n" +
            "            CODIGO_VENDA\n" +
            "        FROM\n" +
            "            VENDA\n" +
            "        WHERE\n" +
            "            DEPENDENTE_CODIGO_DEPENDENTE IN (SELECT \n" +
            "                    CODIGO_DEPENDENTE\n" +
            "                FROM\n" +
            "                    DEPENDENTE\n" +
            "                WHERE\n" +
            "                    CLIENTE_CODIGO_CLIENTE = ?))\n" +
            "        AND TYPE_PRODUCT = 0\n" +
            "        AND B.CODIGO_PACOTE_PROMOCIONAL = A.PACOTE_PROMOCIONAL_CODIGO_PACOTE_PROMOCIONAL;" +
            "";                        
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigo_cliente);
            ps.setInt(2, codigo_diaria);
            ps.setInt(3, codigo_cliente);

            rs = ps.executeQuery();

            resultado = getListaPacotePromocionalClienteDiaria(rs);

            rs.close();
            ps.close();
            return resultado;
        } catch (SQLException ex) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            pool.liberarConnection(con);
        }
    }

    private List<Combo> getListaPacotePromocional(ResultSet rs) throws SQLException {
        List<Combo> resultado = new ArrayList<Combo>();
        while (rs.next()) {
            Combo pacotePromocional = new Combo();
            pacotePromocional.setCodigo_combo(rs.getInt("CODIGO_PACOTE_PROMOCIONAL"));
            pacotePromocional.setDescricao(rs.getString("DESCRICAO"));
            pacotePromocional.setQuantidade_troca(rs.getInt("QUANTIDADE_TROCA"));
            pacotePromocional.setDias_combo(rs.getInt("DIAS_COMBO"));
            pacotePromocional.setValor(rs.getDouble("VALOR"));

            if(rs.getInt("DEL_FLAG") == 0){
                pacotePromocional.setStatus(true);                
            } else {
                pacotePromocional.setStatus(false);                
            }
            
            resultado.add(pacotePromocional);
        }
        return resultado;
    }
    
    private List<Combo> getListaPacotePromocionalCliente(ResultSet rs) throws SQLException {
        List<Combo> resultado = new ArrayList<Combo>();
        while (rs.next()) {
            Combo pacotePromocional = new Combo();
            pacotePromocional.setCodigo_combo(rs.getInt("CODIGO_PACOTE_PROMOCIONAL"));
            pacotePromocional.setDescricao(rs.getString("DESCRICAO"));
            pacotePromocional.setQuantidade_troca(rs.getInt("QUANTIDADE_TROCA"));
            pacotePromocional.setDias_combo(rs.getInt("DIAS_COMBO"));
            pacotePromocional.setData_lancamento(rs.getDate("DATA_LANCAMENTO"));
            pacotePromocional.setDias_corridos(rs.getInt("DIAS_CORRIDOS"));
            pacotePromocional.setDias_combo(rs.getInt("DIAS_PACOTE"));
            pacotePromocional.setDias_restantes(rs.getInt("DIAS_RESTANTE"));
            pacotePromocional.setValor(rs.getDouble("PRECO_TOTAL"));
            pacotePromocional.setQuantidade_troca_efetuada(rs.getInt("TROCA_EFETUADA"));

            if(rs.getInt("DEL_FLAG") == 0){
                pacotePromocional.setStatus(true);                
            } else {
                pacotePromocional.setStatus(false);                
            }
            
            resultado.add(pacotePromocional);
        }
        return resultado;
    }
    
    private List<Combo> getListaPacotePromocionalClienteDiaria(ResultSet rs) throws SQLException {
        List<Combo> resultado = new ArrayList<Combo>();
        while (rs.next()) {
            Combo pacotePromocional = new Combo();
            pacotePromocional.setCodigo_combo(rs.getInt("CODIGO_PACOTE_PROMOCIONAL"));
            pacotePromocional.setDescricao(rs.getString("DESCRICAO"));
            pacotePromocional.setQuantidade_troca(rs.getInt("QUANTIDADE_TROCA"));
            pacotePromocional.setDias_corridos(rs.getInt("DIAS_CORRIDOS"));
            pacotePromocional.setDias_combo(rs.getInt("DIAS_PACOTE"));
            pacotePromocional.setDias_restantes(rs.getInt("DIAS_RESTANTE"));
            pacotePromocional.setQuantidade_troca_efetuada(rs.getInt("TROCA_EFETUADA"));
            
            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setCodigo_item_venda(rs.getInt("CODIGO_ITEM_VENDA"));
            
            Diaria diaria = new Diaria();
            diaria.setCodigo_diaria(rs.getInt("DIARIA_CODIGO_DIARIA"));            
            diaria.setNome_diaria(rs.getString("NOME_DIARIA"));
            
            pacotePromocional.setDiarias(diaria);
            pacotePromocional.setItemVenda(itemVenda);
            resultado.add(pacotePromocional);
        }
        return resultado;
    }
    
    private List<ItemCombo> getListaItemPacotePromocional(ResultSet rs) throws SQLException {
        List<ItemCombo> resultado = new ArrayList<ItemCombo>();
        while (rs.next()) {
            ItemCombo itemPacotePromocional = new ItemCombo();
            itemPacotePromocional.setCodigo_item_pacote_promocional(rs.getInt("CODIGO_ITEM_PACOTE_PROMOCIONAL"));
            Combo pacotePromocional = new Combo();
            pacotePromocional.setCodigo_combo(rs.getInt("CODIGO_PACOTE_PROMOCIONAL"));
            
            Diaria diaria = new Diaria();
            diaria.setCodigo_diaria(rs.getInt("CODIGO_DIARIA"));
            diaria.setNome_diaria(rs.getString("NOME_DIARIA"));
            diaria.setDias(rs.getInt("DIAS"));
            diaria.setValor(rs.getDouble("VALOR"));
            
            itemPacotePromocional.setPacotePromocional(pacotePromocional);
            itemPacotePromocional.setDiaria(diaria);

            resultado.add(itemPacotePromocional);
        }
        return resultado;
    }
    

    
    public Combo salvar(Combo pacotePromocional) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `pacote_promocional` ( `DESCRICAO`, `QUANTIDADE_TROCA`,\n" +
            "`DIAS_COMBO`, `VALOR`, `DEL_FLAG`) VALUES (?,?,?,?,?);";

        try {
            ps = con.prepareStatement(sqlInsert);

            setPreparedStatement(pacotePromocional, ps);

            ps.executeUpdate();
            ResultSet res;
            Integer codigo_max;
            String sql_max = "SELECT MAX(CODIGO_PACOTE_PROMOCIONAL) FROM PACOTE_PROMOCIONAL";

            ps = con.prepareStatement(sql_max);
            res = ps.executeQuery();
            res.next();
            codigo_max = res.getInt("MAX(CODIGO_PACOTE_PROMOCIONAL)");
            pacotePromocional.setCodigo_combo(codigo_max);

            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return pacotePromocional;
    }
    
    public void salvarItem(ItemCombo itemPacotePromocional) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `ITEM_PACOTE_PROMOCIONAL`\n" +
            "( `PACOTE_PROMOCIONAL_CODIGO_PACOTE_PROMOCIONAL`, `DIARIA_CODIGO_DIARIA`) VALUES (? , ? );";

        try {
            ps = con.prepareStatement(sqlInsert);
            
            ps.setInt(1, itemPacotePromocional.getPacotePromocional().getCodigo_combo());
            ps.setInt(2, itemPacotePromocional.getDiaria().getCodigo_diaria());                        

            ps.executeUpdate();            

            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        
    }

    private void setPreparedStatement(Combo pacotePromocional, PreparedStatement ps)
            throws SQLException {

        ps.setString(1, pacotePromocional.getDescricao());
        ps.setInt(2, pacotePromocional.getQuantidade_troca());
        ps.setInt(3, pacotePromocional.getDias_combo());
        ps.setDouble(4, pacotePromocional.getValor());
        if(pacotePromocional.getStatus() == true){
            ps.setInt(5, 0);
        } else {
            ps.setInt(5, 1);
        }

    }

    private void setPreparedStatement1(Combo pacotePromocional, PreparedStatement ps)
            throws SQLException {
        ps.setString(1, pacotePromocional.getDescricao());
        ps.setInt(2, pacotePromocional.getQuantidade_troca());
        ps.setInt(3, pacotePromocional.getDias_combo());
        ps.setDouble(4, pacotePromocional.getValor());
        if(pacotePromocional.getStatus() == true){
            ps.setInt(5, 0);
        } else {
            ps.setInt(5, 1);
        }
        ps.setInt(6, pacotePromocional.getCodigo_combo());
    }

}
