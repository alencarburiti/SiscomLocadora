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
public class RelatorioFluxoCaixaDetalhado {

    private InterfacePool pool;

    public RelatorioFluxoCaixaDetalhado(InterfacePool pool) {
        this.pool = pool;
    }

    public void gerarRelatorio(String dataInicial, String dataFinal) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = pool.getConnection();

        try {
            String sqlSelect = "SELECT \n" +
                "    *\n" +
                "FROM\n" +
                "    (SELECT \n" +
                "        A.data_lancamento,\n" +
                "            C.NOME_DEPENDENTE,\n" +
                "            B.DESCRICAO,\n" +
                "            B.TIPO,\n" +
                "            A.VALOR_LANCAMENTO AS VALOR,\n" +
                "            caixa_codigo_caixa,\n" +
                "            D.NOME_USUARIO\n" +
                "    FROM\n" +
                "        LANCAMENTO A, TIPO_SERVICO B, DEPENDENTE C, USUARIO D\n" +
                "    WHERE\n" +
                "        A.DEPENDENTE_CODIGO_DEPENDENTE = C.CODIGO_DEPENDENTE\n" +
                "            AND A.USUARIO_CODIGO_USUARIO = D.CODIGO_USUARIO\n" +
                "            AND A.TIPO_SERVICO_CODIGO_TIPO_SERVICO = B.CODIGO_TIPO_SERVICO\n" +
                "            AND B.TIPO = 'C'\n" +
                "            AND A.DATA_LANCAMENTO BETWEEN ? AND ?\n" +
                "            AND B.CODIGO_TIPO_SERVICO = 4 UNION ALL SELECT \n" +
                "        B.data_lancamento,\n" +
                "            D.NOME_DEPENDENTE,\n" +
                "            C.DESCRICAO,\n" +
                "            C.TIPO,\n" +
                "            B.VALOR_LANCAMENTO AS VALOR,\n" +
                "            B.caixa_codigo_caixa,\n" +
                "            E.NOME_USUARIO\n" +
                "    FROM\n" +
                "        LANCAMENTO A, ITEM_LANCAMENTO B, TIPO_SERVICO C, DEPENDENTE D, USUARIO E\n" +
                "    WHERE\n" +
                "        A.CODIGO_LANCAMENTO = B.LANCAMENTO_CODIGO_LANCAMENTO\n" +
                "            AND B.TIPO_SERVICO_CODIGO_SERVICO = C.CODIGO_TIPO_SERVICO\n" +
                "            AND A.DEPENDENTE_CODIGO_DEPENDENTE = D.CODIGO_DEPENDENTE\n" +
                "            AND B.USUARIO_CODIGO_USUARIO = E.CODIGO_USUARIO\n" +
                "            AND C.TIPO = 'C'\n" +
                "            AND B.DATA_LANCAMENTO BETWEEN ? AND ?\n" +
                "            AND C.CODIGO_TIPO_SERVICO IN (6 , 7, 11)) AS FLUXO\n" +
                "ORDER BY DATA_LANCAMENTO ASC";

            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, dataInicial);
            ps.setString(2, dataFinal);
            ps.setString(3, dataInicial);
            ps.setString(4, dataFinal);

            rs = ps.executeQuery();
            rs.afterLast();//mover apos a ultima linha  
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            System.out.println("Total de Registro:"+totalRegistro);
            if (totalRegistro > 0) {
                InputStream caminho = getClass().getResourceAsStream("rel_fluxo_caixa_detalhado.jasper");                                
                
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


