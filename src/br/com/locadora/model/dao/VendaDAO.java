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
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.Produto;
import br.com.locadora.model.bean.Venda;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaDAO {

    private InterfacePool pool;

    public VendaDAO(InterfacePool pool) {
        this.pool = pool;
    }
    
    public List<ItemVenda> getProdutoPacoteDescricao(String descricao) {        
        List<ItemVenda> resultado = new ArrayList<ItemVenda>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "(SELECT \n" +
            "    NOME_PRODUTO AS DESCRICAO,\n" +
            "    CODIGO_PRODUTO AS CODIGO,\n" +
            "    CODIGO_BARRAS,\n" +
            "    PRECO_VENDA AS VALOR,\n" +
            "    DEL_FLAG,\n" +
            "    1 AS TYPE_PRODUCT\n" +
            "FROM\n" +
            "    PRODUTO WHERE NOME_PRODUTO LIKE ? AND DEL_FLAG = 0) UNION ALL (SELECT \n" +
            "    DESCRICAO,\n" +
            "    CODIGO_PACOTE_PROMOCIONAL AS CODIGO,\n" +
            "    '' AS CODIGO_BARRAS,\n" +
            "    VALOR,\n" +
            "    DEL_FLAG,\n" +
            "    0 AS TYPE_PRODUCT\n" +
            "FROM\n" +
            "    PACOTE_PROMOCIONAL WHERE DESCRICAO LIKE ? AND DEL_FLAG = 0)";
        
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, "%"+descricao+"%");
            ps.setString(2, "%"+descricao+"%");

            rs = ps.executeQuery();

            resultado = getListaProdutoPacotePromocional(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }
    
    public List<ItemVenda> getProdutoPacoteCodigoBarras(String codigo_barras) {        
        List<ItemVenda> resultado = new ArrayList<ItemVenda>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String sqlSelect = "(SELECT \n" +
            "    NOME_PRODUTO AS DESCRICAO,\n" +
            "    CODIGO_PRODUTO AS CODIGO,\n" +
            "    CODIGO_BARRAS,\n" +
            "    PRECO_VENDA AS VALOR,\n" +
            "    DEL_FLAG,\n" +
            "    1 AS TYPE_PRODUCT\n" +
            "FROM\n" +
            "    PRODUTO WHERE CODIGO_BARRAS = ? AND DEL_FLAG = 0) UNION ALL (SELECT \n" +
            "    DESCRICAO,\n" +
            "    CODIGO_PACOTE_PROMOCIONAL AS CODIGO,\n" +
            "    '' AS CODIGO_BARRAS,\n" +
            "    VALOR,\n" +
            "    DEL_FLAG,\n" +
            "    0 AS TYPE_PRODUCT\n" +
            "FROM\n" +
            "    PACOTE_PROMOCIONAL WHERE CODIGO_BARRAS = ? AND DEL_FLAG = 0)";
        
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, codigo_barras);
            ps.setString(2, codigo_barras);

            rs = ps.executeQuery();

            resultado = getListaProdutoPacotePromocional(rs);

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

//    public List<PacotePromocional> getPacotePromocionalDescricao(String descricao) {        
//        List<PacotePromocional> resultado = new ArrayList<PacotePromocional>();
//        Connection con = pool.getConnection();
//        PreparedStatement ps = null;
//        String sqlSelect = "SELECT * FROM PACOTE_PROMOCIONAL WHERE DESCRICAO LIKE ? ORDER BY DESCRICAO LIMIT 0, 50;";
//        ResultSet rs = null;
//
//        try {
//            ps = con.prepareStatement(sqlSelect);
//            ps.setString(1, "%"+descricao+"%");
//
//            rs = ps.executeQuery();
//
//            resultado = getListaPacotePromocional(rs);
//
//            rs.close();
//            ps.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            pool.liberarConnection(con);
//        }
//        return resultado;
//    }
    
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
    
    private List<ItemVenda> getListaProdutoPacotePromocional(ResultSet rs) throws SQLException {
        List<ItemVenda> resultado = new ArrayList<ItemVenda>();
        while (rs.next()) {
            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setType_product(Integer.parseInt(rs.getString("TYPE_PRODUCT")));
            System.out.println("Type Product: "+ rs.getString("TYPE_PRODUCT"));
            if(rs.getInt("TYPE_PRODUCT") == 0){      
                Combo pacotePromocional = new Combo();
                pacotePromocional.setCodigo_combo(rs.getInt("CODIGO"));
                pacotePromocional.setDescricao(rs.getString("DESCRICAO"));
                pacotePromocional.setCodigo_barras(rs.getString("CODIGO_BARRAS"));                
                pacotePromocional.setValor(rs.getDouble("VALOR"));
                if(rs.getInt("DEL_FLAG") == 0){
                    pacotePromocional.setStatus(true);
                } else {
                    pacotePromocional.setStatus(false);
                }                
                itemVenda.setCombo(pacotePromocional);                
            } else if(rs.getInt("TYPE_PRODUCT") == 1){
                Produto produto = new Produto();
                produto.setCodigo_produto(rs.getInt("CODIGO"));
                produto.setNome_produto(rs.getString("DESCRICAO"));
                produto.setCodigo_barras(rs.getString("CODIGO_BARRAS"));                
                produto.setPreco_venda(rs.getDouble("VALOR"));
                if(rs.getInt("DEL_FLAG") == 0){
                    produto.setStatus(true);
                } else {
                    produto.setStatus(false);
                }                
                itemVenda.setProduto(produto);                
            }            
            resultado.add(itemVenda);
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
    

    
    public Venda salvar(Venda venda) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `venda` ( `dependente_codigo_dependente`, usuario_codigo_usuario) VALUES (?,?);";

        try {
            ps = con.prepareStatement(sqlInsert);

            setPreparedStatement(venda, ps);

            ps.executeUpdate();
            ResultSet res;
            Integer codigo_max;
            String sql_max = "SELECT MAX(CODIGO_VENDA) FROM VENDA";

            ps = con.prepareStatement(sql_max);
            res = ps.executeQuery();
            res.next();
            codigo_max = res.getInt("MAX(CODIGO_VENDA)");
            venda.setCodigo_venda(codigo_max);

            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return venda;
    }
    
    public Venda salvarItens(List<ItemVenda> itens, Venda venda) throws SQLException {
        Connection con = pool.getConnection();
        PreparedStatement ps;

        String sqlInsert = "INSERT INTO `ITEM_VENDA` (`VENDA_CODIGO_VENDA`,\n" +
            "`TYPE_PRODUCT`,`QUANTIDADE`,`PRECO_TOTAL`,\n" +
            "`PACOTE_PROMOCIONAL_CODIGO_PACOTE_PROMOCIONAL`,\n" +
            "`PRODUTO_CODIGO_PRODUTO`, data_lancamento, PRECO_UNITARIO)VALUES(?,?,?,?,?,?, CURRENT_DATE(),?);";

        try {
            ps = con.prepareStatement(sqlInsert);

            for(int i =0; i < itens.size(); i++){
                ps.setInt(1, venda.getCodigo_venda());
                ps.setInt(2, itens.get(i).getType_product());
                ps.setInt(3, itens.get(i).getQuantidade());
                ps.setDouble(4, itens.get(i).getPreco_total());
                if(itens.get(i).getType_product() == 0){
                    ps.setInt(5, itens.get(i).getCombo().getCodigo_combo());
                    ps.setInt(6, 0);
                    ps.setDouble(7, itens.get(i).getCombo().getValor());
                } else if(itens.get(i).getType_product() == 1){
                    ps.setInt(5, 0);
                    ps.setInt(6, itens.get(i).getProduto().getCodigo_produto());
                    ps.setDouble(7, itens.get(i).getProduto().getPreco_venda());
                }
                ps.executeUpdate();
            }

            ps.close();
        } finally {
            pool.liberarConnection(con);
        }
        return venda;
    }
    
    //SQL para busca de itens para a reimpressao
    public List<ItemVenda> getItemVenda(Lancamento lancamento) {

        List<ItemVenda> resultado = new ArrayList<ItemVenda>();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlSelect = "SELECT \n" +
            "    *\n" +
            "FROM\n" +
            "    (SELECT \n" +
            "        A.CODIGO_LANCAMENTO,\n" +
            "            D.CODIGO_PRODUTO AS CODIGO_PRODUTO,\n" +
            "            D.NOME_PRODUTO AS DESCRICAO,\n" +
            "            C.QUANTIDADE,\n" +
            "            C.PRECO_TOTAL,\n" +
            "            C.PRECO_UNITARIO,\n" +
            "            C.TYPE_PRODUCT\n" +
            "    FROM\n" +
            "        LANCAMENTO A, VENDA B, ITEM_VENDA C, PRODUTO D\n" +
            "    WHERE\n" +
            "        A.VENDA_CODIGO_VENDA = B.CODIGO_VENDA\n" +
            "            AND B.CODIGO_VENDA = C.VENDA_CODIGO_VENDA\n" +
            "            AND C.PRODUTO_CODIGO_PRODUTO = D.CODIGO_PRODUTO UNION ALL SELECT \n" +
            "        A.CODIGO_LANCAMENTO,\n" +
            "            D.CODIGO_PACOTE_PROMOCIONAL AS CODIGO_PRODUTO,\n" +
            "            D.DESCRICAO,\n" +
            "            C.QUANTIDADE,\n" +
            "            C.PRECO_TOTAL,\n" +
            "            C.PRECO_UNITARIO,\n" +
            "            C.TYPE_PRODUCT\n" +
            "    FROM\n" +
            "        LANCAMENTO A, VENDA B, ITEM_VENDA C, PACOTE_PROMOCIONAL D\n" +
            "    WHERE\n" +
            "        A.VENDA_CODIGO_VENDA = B.CODIGO_VENDA\n" +
            "            AND B.CODIGO_VENDA = C.VENDA_CODIGO_VENDA\n" +
            "            AND C.PACOTE_PROMOCIONAL_CODIGO_PACOTE_PROMOCIONAL = D.CODIGO_PACOTE_PROMOCIONAL) AS CONSULTA\n" +
            "            WHERE CODIGO_LANCAMENTO = ?";

        try {
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, lancamento.getCodigo_lancamento());

            rs = ps.executeQuery();

            resultado = getListaItensVenda(rs);

            ps.close();
        } catch (ParseException ex) {
            return null;

        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pool.liberarConnection(con);
        }
        return resultado;
    }

    private void setPreparedStatement(Venda venda, PreparedStatement ps)
            throws SQLException {

        ps.setInt(1, venda.getDependente().getCodigo_dependente());
        ps.setInt(2, venda.getUsuario().getCodigo_usuario());        

    }
    
    private List<ItemVenda> getListaItensVenda(ResultSet rs) throws SQLException, ParseException {
        List<ItemVenda> resultado = new ArrayList<ItemVenda>();
        
        while (rs.next()) {
            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setType_product(rs.getInt("TYPE_PRODUCT"));
            if(rs.getInt("TYPE_PRODUCT") == 0){
                Combo combo = new Combo();
                combo.setCodigo_combo(rs.getInt("CODIGO_PRODUTO"));
                combo.setDescricao(rs.getString("DESCRICAO"));
                combo.setValor(rs.getDouble("PRECO_TOTAL"));
                itemVenda.setCombo(combo);
            } else if(rs.getInt("TYPE_PRODUCT") == 1){
                Produto produto = new Produto();
                produto.setCodigo_produto(rs.getInt("CODIGO_PRODUTO"));
                produto.setNome_produto(rs.getString("DESCRICAO"));
                produto.setPreco_venda(rs.getDouble("PRECO_UNITARIO"));                
                itemVenda.setProduto(produto);
            } 
            itemVenda.setQuantidade(rs.getInt("QUANTIDADE"));
            itemVenda.setPreco_total(rs.getDouble("PRECO_TOTAL"));

            resultado.add(itemVenda);
        }
        return resultado;
    }

}
