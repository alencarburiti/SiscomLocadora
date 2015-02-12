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
public class RelatorioLocacaoAberta {

    private InterfacePool pool;

    public RelatorioLocacaoAberta(InterfacePool pool) {
        this.pool = pool;
    }

    public void gerarRelatorio(String dataInicial, String dataFinal) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = pool.getConnection();
        try {
            String sqlSelect = "SELECT \n" +
            "    C.CODIGO_LOCACAO,\n" +
            "    D.CODIGO_ITEM_LOCACAO,\n" +
            "    D.VALOR_LOCADO,\n" +
            "    D.DATA_PREVISTA,\n" +
            "    D.VALOR_PAGO,\n" +
            "    E.CODIGO_DEPENDENTE,\n" +
            "    E.NOME_DEPENDENTE,\n" +
            "    A.TITULO AS TITULO,\n" +
            "    F.DIAS AS DIARIA,\n" +
            "    B.CODIGO_BARRAS,\n" +
            "    B.CODIGO_COPIA,\n" +
            "    F.MULTAS AS VALOR_MULTA_DIA,\n" +
            "    F.CODIGO_DIARIA,\n" +
            "    D.DATA_LOCACAO AS DATA_LOCACAO,\n" +
            "    ADDDATE(D.DATA_LOCACAO, F.DIAS) AS DATA_DEVOLUCAO,\n" +
            "    CURRENT_DATE AS DATA_ATUAL,\n" +
            "    (CASE\n" +
            "        WHEN ((DATEDIFF(CURDATE(), DATA_LOCACAO)) <= (DATEDIFF(DATA_PREVISTA, DATA_LOCACAO))) THEN 0\n" +
            "        ELSE ((DATEDIFF(CURDATE(), DATA_LOCACAO)) - (DATEDIFF(DATA_PREVISTA, DATA_LOCACAO)))\n" +
            "    END) AS DIAS_MULTA,\n" +
            "    CASE\n" +
            "        WHEN\n" +
            "            (((DATEDIFF(CURDATE(), DATA_LOCACAO)) <= (DATEDIFF(DATA_PREVISTA, DATA_LOCACAO))) * F.MULTAS) IS NULL\n" +
            "                OR (((DATEDIFF(CURDATE(), DATA_LOCACAO)) - (DATEDIFF(DATA_PREVISTA, DATA_LOCACAO))) * F.MULTAS < 0)\n" +
            "        THEN\n" +
            "            0\n" +
            "        ELSE (((DATEDIFF(CURDATE(), DATA_LOCACAO)) - (DATEDIFF(DATA_PREVISTA, DATA_LOCACAO))) * F.MULTAS)\n" +
            "    END AS VALOR_RELOCACAO\n" +
            "FROM\n" +
            "    OBJETO A,\n" +
            "    COPIA B,\n" +
            "    LOCACAO C,\n" +
            "    ITEM_LOCACAO D,\n" +
            "    DEPENDENTE E,\n" +
            "    DIARIA F\n" +
            "WHERE\n" +
            "    A.CODIGO_OBJETO = B.OBJETO_CODIGO_OBJETO\n" +
            "        AND C.DEPENDENTE_CODIGO_DEPENDENTE = E.CODIGO_DEPENDENTE\n" +
            "        AND C.CODIGO_LOCACAO = D.LOCACAO_CODIGO_LOCACAO\n" +
            "        AND D.COPIA_CODIGO_COPIA = B.CODIGO_COPIA\n" +
            "        AND B.DIARIA_CODIGO_DIARIA = F.CODIGO_DIARIA\n" +
            "        AND D.DEL_FLAG = 1\n" +
            "        AND A.TIPO_MOVIMENTO = 'LOCACAO'\n" +
            "        AND D.DATA_LOCACAO BETWEEN ? AND ?\n" +            
            "ORDER BY DATA_PREVISTA DESC\n";

            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, dataInicial);
            ps.setString(2, dataFinal);            

            rs = ps.executeQuery();
            rs.afterLast();//mover apos a ultima linha
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            if (totalRegistro > 0) {
                InputStream caminho = getClass().getResourceAsStream("rel_locacao_aberta.jasper");                                
                
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(caminho, new HashMap(), jrRS);
                JasperViewer.viewReport(jasperPrint, false);
            } else {
                JOptionPane.showMessageDialog(null, "Registro não encontrado para o filtro informado.");
            }
        } catch (Exception erro) {
            erro.printStackTrace();
        }
    }
    
    public void gerarRelatorioExcel(String dataInicial, String dataFinal, String titulo, File arquivo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = pool.getConnection();
        try {
            String sqlSelect = "SELECT\n"
                    + "    C.CODIGO_LOCACAO,\n"
                    + "    D.CODIGO_ITEM_LOCACAO,\n"
                    + "    D.VALOR_LOCADO,\n"
                    + "    D.DATA_PREVISTA,\n"
                    + "    D.VALOR_PAGO,\n"
                    + "    E.CODIGO_DEPENDENTE,\n"
                    + "    E.NOME_DEPENDENTE,\n"
                    + "    A.TITULO AS TITULO,\n"
                    + "    F.DIAS AS DIARIA,\n"
                    + "    B.CODIGO_BARRAS,\n"
                    + "    B.CODIGO_COPIA,\n"
                    + "    F.MULTAS AS VALOR_MULTA_DIA,\n"
                    + "    F.CODIGO_DIARIA,\n"
                    + "    D.DATA_LOCACAO AS DATA_LOCACAO,\n"
                    + "    ADDDATE(D.DATA_LOCACAO, F.DIAS) AS DATA_DEVOLUCAO,\n"
                    + "    CURRENT_DATE AS DATA_ATUAL,\n"
                    + "    (case\n"
                    + "        when\n"
                    + "            ((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS) IS NULL\n"
                    + "                OR ((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS) < 0\n"
                    + "        then\n"
                    + "            0\n"
                    + "        else ((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS)\n"
                    + "    end) AS DIAS_MULTA,\n"
                    + "    CASE\n"
                    + "        WHEN\n"
                    + "            ((((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS)) * F.MULTAS) IS NULL\n"
                    + "                OR (((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS)) < 0\n"
                    + "        THEN\n"
                    + "            0\n"
                    + "        ELSE ((((CURRENT_DATE - D.DATA_LOCACAO) - F.DIAS)) * F.MULTAS)\n"
                    + "    END AS VALOR_RELOCACAO\n"
                    + "FROM\n"
                    + "    OBJETO A,\n"
                    + "    COPIA B,\n"
                    + "    LOCACAO C,\n"
                    + "    ITEM_LOCACAO D,\n"
                    + "    DEPENDENTE E,\n"
                    + "    DIARIA F\n"
                    + "WHERE\n"
                    + "    A.CODIGO_OBJETO = B.OBJETO_CODIGO_OBJETO\n"
                    + "        AND C.DEPENDENTE_CODIGO_DEPENDENTE = E.CODIGO_DEPENDENTE\n"
                    + "        AND C.CODIGO_LOCACAO = D.LOCACAO_CODIGO_LOCACAO\n"
                    + "        AND D.COPIA_CODIGO_COPIA = B.CODIGO_COPIA\n"
                    + "        AND A.DIARIA_CODIGO_DIARIA = F.CODIGO_DIARIA\n"
                    + "        AND D.DEL_FLAG = 0\n"
                    + "        AND A.TIPO_MOVIMENTO = 'LOCACAO' \n"
                    + "        AND D.DATA_LOCACAO BETWEEN ? AND ? AND A.TITULO LIKE ?\n";

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
                JasperPrint jasperPrint = JasperFillManager.fillReport("jasper/rel_locacao_aberta.jasper", parametros, jrRS);
                
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
