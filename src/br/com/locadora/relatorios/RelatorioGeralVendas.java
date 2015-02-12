/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.relatorios;

import br.com.locadora.conexao.InterfacePool;
import java.awt.HeadlessException;
import java.io.File;
import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ALENCAR
 */
public class RelatorioGeralVendas {

    private InterfacePool pool;

    public RelatorioGeralVendas(InterfacePool pool) {
        this.pool = pool;
    }

    public void gerarRelatorio(String dataInicial, String dataFinal, String produto_combo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = pool.getConnection();

        try {
            String sqlSelect = "SELECT\n" +
                "    *\n" +
                "FROM\n" +
                "    (SELECT\n" +
                "        NOME_PRODUTO AS DESCRICAO,\n" +
                "            SUM(QUANTIDADE) AS QUANTIDADE,\n" +
                "            PRECO_UNITARIO,\n" +
                "            PRECO_TOTAL,\n" +
                "            DATA_LANCAMENTO\n" +
                "    FROM\n" +
                "        ITEM_VENDA A, PRODUTO B\n" +
                "    WHERE\n" +
                "        A.PRODUTO_CODIGO_PRODUTO = B.CODIGO_PRODUTO\n" +
                "            AND DATA_LANCAMENTO BETWEEN ? AND ?\n" +
                "            AND TYPE_PRODUCT = 1\n" +
                "            AND NOME_PRODUTO LIKE ?\n" +
                "    GROUP BY PRODUTO_CODIGO_PRODUTO , DATA_LANCAMENTO UNION ALL SELECT\n" +
                "        DESCRICAO,\n" +
                "            SUM(QUANTIDADE),\n" +
                "            PRECO_UNITARIO,\n" +
                "            PRECO_TOTAL,\n" +
                "            DATA_LANCAMENTO\n" +
                "    FROM\n" +
                "        ITEM_VENDA IV, PACOTE_PROMOCIONAL PP\n" +
                "    WHERE\n" +
                "        IV.PACOTE_PROMOCIONAL_CODIGO_PACOTE_PROMOCIONAL = PP.CODIGO_PACOTE_PROMOCIONAL\n" +
                "            AND DATA_LANCAMENTO BETWEEN ? AND ?\n" +
                "            AND TYPE_PRODUCT = 0\n" +
                "            AND DESCRICAO LIKE ?\n" +
                "    GROUP BY CODIGO_PACOTE_PROMOCIONAL , DATA_LANCAMENTO) AS CONSULTA\n" +
                "ORDER BY DESCRICAO ASC";

            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, dataInicial);
            ps.setString(2, dataFinal);
            ps.setString(3, "%"+produto_combo+"%");
            ps.setString(4, dataInicial);
            ps.setString(5, dataFinal);
            ps.setString(6, "%"+produto_combo+"%");
            

            rs = ps.executeQuery();
            rs.afterLast();//mover apos a ultima linha  
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            System.out.println("Total de Registro:"+totalRegistro);
            if (totalRegistro > 0) {
                InputStream caminho = getClass().getResourceAsStream("rel_geral_vendas.jasper");                                
                
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(caminho, parametros, jrRS);
//                JasperViewer jrviewer = new JasperViewer(jasperPrint); 
//                jrviewer.setVisible(true);
                JasperViewer.viewReport(jasperPrint, false);
            } else {
                JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
            }
        } catch (SQLException | JRException | HeadlessException erro) {
            erro.printStackTrace();
        }
    }
    
    public void gerarRelatorioExcel(String dataInicial, String dataFinal, String titulo, File arquivo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = pool.getConnection();

        try {
            String sqlSelect = "SELECT\n"
                    + "    CODIGO_OBJETO,\n"
                    + "    TITULO,\n"
                    + "    COUNT(CODIGO_ITEM_LOCACAO) AS QTD_LOCACAO,\n"
                    + "    SUM(VALOR_LOCADO) AS VALOR_LOCACAO,\n"
                    + "    SUM(DIAS_RELOCACAO) AS QTD_RELOCACAO,\n"
                    + "    SUM(VALOR_RELOCACAO) AS VALOR_RELOCACAO\n"
                    + "FROM\n"
                    + "    OBJETO A,\n"
                    + "    COPIA B,\n"
                    + "    ITEM_LOCACAO C\n"
                    + "WHERE\n"
                    + "    A.CODIGO_OBJETO = B.OBJETO_CODIGO_OBJETO\n"
                    + "        AND B.CODIGO_COPIA = C.COPIA_CODIGO_COPIA\n"
                    + "        AND DATA_LOCACAO BETWEEN ? AND ? AND TITULO LIKE ?\n"
                    + "GROUP BY 1,2;";

            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, dataInicial);
            ps.setString(2, dataFinal);
            ps.setString(3, "%" + titulo + "%");

            rs = ps.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            System.out.println("Total de Registro:"+totalRegistro);
            if (totalRegistro > 0) {
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport("jasper/rel_fluxo_caixa_detalhado.jasper", parametros, jrRS);
                
                JRXlsExporter exporter = new JRXlsExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(arquivo));
                
                SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
                configuration.setDetectCellType(true);
                configuration.setCollapseRowSpan(false);
                configuration.setMaxRowsPerSheet(20000);
                configuration.setOnePagePerSheet(false);
                configuration.setRemoveEmptySpaceBetweenRows(Boolean.TRUE);
                configuration.setRemoveEmptySpaceBetweenColumns(Boolean.TRUE);
                
                exporter.setConfiguration(configuration);
                
                exporter.exportReport();
                
                System.out.println("Relatorio gerado");
            } else {
                JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
            }
        } catch (SQLException | JRException | HeadlessException erro) {
            erro.printStackTrace();
        }
    }
    
}


