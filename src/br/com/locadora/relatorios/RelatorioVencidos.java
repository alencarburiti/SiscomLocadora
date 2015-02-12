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
public class RelatorioVencidos {

    private InterfacePool pool;

    public RelatorioVencidos(InterfacePool pool) {
        this.pool = pool;
    }

    public void gerarRelatorio(String dataInicial, String dataFinal, String codigo_categoria) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = pool.getConnection();

        try {
            String sqlSelect = "SELECT\n" +
                "    DATA_VENCIMENTO,\n" +
                "    CODIGO_LANCAMENTO_CONTA,\n" +
                "    CODIGO_FORNECEDOR,\n" +
                "    NOME_FANTASIA AS ORIGEM_DESTINO,\n" +
                "    DESCRICAO,\n" +
                "    DOCUMENTO,\n" +
                "    VALOR_A_PAGAR,\n" +
                "    VALOR_PAGO,\n" +
                "    DATA_PAGAMENTO,\n" +
                "    C.NOME_USUARIO,\n" +
                "    A.CAIXA_CODIGO_CAIXA,\n" +
                "    CATEGORIA_CODIGO_CATEGORIA,\n" +
                "    (CASE\n" +
                "        WHEN (VALOR_A_PAGAR - VALOR_PAGO) < 0 THEN 0\n" +
                "        ELSE VALOR_A_PAGAR - VALOR_PAGO\n" +
                "    END) AS DEBITO\n" +
                "FROM\n" +
                "    lancamento_conta A,\n" +
                "    FORNECEDOR B,\n" +
                "    USUARIO C\n" +
                "WHERE\n" +
                "    A.FORNECEDOR_CODIGO_FORNECEDOR = B.CODIGO_FORNECEDOR\n" +
                "        AND A.USUARIO_CODIGO_USUARIO = C.CODIGO_USUARIO\n" +
                "        AND DATA_VENCIMENTO BETWEEN ? AND ?\n" +
                "        AND CATEGORIA_CODIGO_CATEGORIA LIKE ?\n" +
                "        AND DATA_VENCIMENTO < CURRENT_DATE()\n" +
                "        AND DATA_PAGAMENTO IS NULL\n" +
                "        OR DATA_PAGAMENTO = ''\n" +
                "ORDER BY DATA_VENCIMENTO";

            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, dataInicial);
            ps.setString(2, dataFinal);
            ps.setString(3, "%"+codigo_categoria+"%");
            

            rs = ps.executeQuery();
            rs.afterLast();//mover apos a ultima linha  
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            System.out.println("Total de Registro:"+totalRegistro);
            if (totalRegistro > 0) {
                InputStream caminho = getClass().getResourceAsStream("rel_contas_vencidas.jasper");                                
                
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


