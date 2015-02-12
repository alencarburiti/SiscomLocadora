

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
public class RelatorioClientePendente {

    private InterfacePool pool;

    public RelatorioClientePendente(InterfacePool pool) {
        this.pool = pool;
    }

    public void gerarRelatorio() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = pool.getConnection();

        try {
            String sqlSelect = "SELECT\n" +
            "    *\n" +
            "FROM\n" +
            "    (SELECT\n" +
            "        DATA_VENCIMENTO,\n" +
            "            CODIGO_LANCAMENTO AS CODIGO_LANCAMENTO_CONTA,\n" +
            "            0 AS CODIGO_FORNECEDOR,\n" +
            "            NOME_DEPENDENTE AS ORIGEM_DESTINO,\n" +
            "            DESCRICAO,\n" +
            "            CODIGO_TIPO_SERVICO,\n" +
            "            DOCUMENTO,\n" +
            "            VALOR_LANCAMENTO AS VALOR_A_PAGAR,\n" +
            "            CREDITO AS VALOR_PAGO,\n" +
            "            DATA_LANCAMENTO AS DATA_PAGAMENTO,\n" +
            "            NOME_USUARIO,\n" +
            "            CAIXA_CODIGO_CAIXA\n" +
            "    FROM\n" +
            "        (SELECT\n" +
            "        A.DATA_LANCAMENTO AS DATA_VENCIMENTO,\n" +
            "            A.CODIGO_LANCAMENTO,\n" +
            "            0 AS CODIGO_FORNECEDOR,\n" +
            "            B.NOME_DEPENDENTE,\n" +
            "            C.DESCRICAO,\n" +
            "            C.CODIGO_TIPO_SERVICO,\n" +
            "            A.CODIGO_LANCAMENTO AS DOCUMENTO,\n" +
            "            C.TIPO,\n" +
            "            D.LOGIN,\n" +
            "            D.NOME_USUARIO,\n" +
            "            A.VALOR_LANCAMENTO,\n" +
            "            A.DATA_LANCAMENTO,\n" +
            "            A.CAIXA_CODIGO_CAIXA,\n" +
            "            (SELECT\n" +
            "                    (CASE\n" +
            "                            WHEN SUM(VALOR_LANCAMENTO) IS NULL THEN 0\n" +
            "                            ELSE SUM(VALOR_LANCAMENTO)\n" +
            "                        END)\n" +
            "                FROM\n" +
            "                    ITEM_LANCAMENTO IL, TIPO_SERVICO TS\n" +
            "                WHERE\n" +
            "                    IL.TIPO_SERVICO_CODIGO_SERVICO = TS.CODIGO_TIPO_SERVICO\n" +
            "                        AND LANCAMENTO_CODIGO_LANCAMENTO = A.CODIGO_LANCAMENTO\n" +
            "                        AND TS.TIPO = 'C') AS CREDITO\n" +
            "    FROM\n" +
            "        LANCAMENTO A, DEPENDENTE B, TIPO_SERVICO C, USUARIO D\n" +
            "    WHERE\n" +
            "        A.DEPENDENTE_CODIGO_DEPENDENTE = B.CODIGO_DEPENDENTE\n" +
            "            AND A.TIPO_SERVICO_CODIGO_TIPO_SERVICO = C.CODIGO_TIPO_SERVICO\n" +
            "            AND A.USUARIO_CODIGO_USUARIO = D.CODIGO_USUARIO\n" +
            "            AND C.TIPO = 'D'\n" +
            "            \n" +
            "    ORDER BY A.CODIGO_LANCAMENTO DESC) AS LANC) AS FINAL\n" +
            "WHERE\n" +
            "    VALOR_A_PAGAR > VALOR_PAGO;";

            ps = con.prepareStatement(sqlSelect);

            rs = ps.executeQuery();
            rs.afterLast();//mover apos a ultima linha  
            rs.previous(); //entao ir para ultima linha
            int totalRegistro = rs.getRow();//valor da ultima linha"numero de dados registrados"
            rs.beforeFirst();//retornar ao primeiro resultado
            System.out.println("Total de Registro:"+totalRegistro);
            if (totalRegistro > 0) {
                InputStream caminho = getClass().getResourceAsStream("rel_cliente_pendente.jasper");                                
                
                JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
                Map parametros = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(caminho, parametros, jrRS);
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
                JasperPrint jasperPrint = JasperFillManager.fillReport("jasper/rel_cliente_pendente.jasper", parametros, jrRS);
                
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


