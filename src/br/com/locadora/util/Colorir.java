/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.util;

import br.com.locadora.view.ConsultaClienteAtendimento;
import br.com.locadora.view.Financeiro;
import br.com.locadora.view.FinanceiroReceber;
import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author alencarburiti
 */
public class Colorir extends DefaultTableCellRenderer {
    
    public Financeiro janelapai1;
    public ConsultaClienteAtendimento janelapai2;
    public FinanceiroReceber janelapai3;
    public Moeda moeda;
    
    public Colorir(Financeiro financeiro, ConsultaClienteAtendimento consultaClienteAtendimento, FinanceiroReceber financeiroReceber){
        janelapai1 = financeiro;
        janelapai2 = consultaClienteAtendimento;
        janelapai3 = financeiroReceber;
    }

    private Color fDarkGreen = Color.green.darker();

    @Override
    public JComponent getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        JComponent renderer = (JComponent) super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column
        );

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = new GregorianCalendar();
        Date data_vencimento = null;
        try {
            data_vencimento = new Date(df.parse(table.getValueAt(row, 5).toString()).getTime());
        } catch (ParseException ex) {

        }
        Date dataAtual = new Date(System.currentTimeMillis());
        if (isSelected == false) {
                
            if(janelapai1 != null){
                moeda = new Moeda();
                Double preco_duplicata = moeda.getPrecoFormato(table.getValueAt(row, 4).toString());
                Double preco_pago = moeda.getPrecoFormato(table.getValueAt(row, 6).toString());
                if(table.getValueAt(row, 0).toString().equals("E")){
                    if (data_vencimento.before(dataAtual) && preco_duplicata > preco_pago) {                    
                        renderer.setForeground(Color.red);
                        System.out.println("À Receber");
                    } else if (preco_duplicata <= preco_pago) {
                        renderer.setForeground(Color.BLUE);
                        System.out.println("Pago");
                    } else if (data_vencimento.after(dataAtual)) {
                        renderer.setForeground(Color.BLACK);
                        System.out.println("A vencer");
                    }                      
                }else {
                    if (data_vencimento.before(dataAtual) && table.getValueAt(row, 7).toString().equals("")) {                    
                        renderer.setForeground(Color.RED);
                        System.out.println("Vencido");
                    } else if (!table.getValueAt(row, 7).toString().equals("")) {
                        renderer.setForeground(fDarkGreen);
                        System.out.println("Pago");
                    } else if (data_vencimento.after(dataAtual)) {
                        renderer.setForeground(Color.BLACK);
                        System.out.println("A vencer");
                    }                                    
                }
            } else if(janelapai2 != null){
                if(table.getValueAt(row, 3).toString().equals("Cliente")){
                    renderer.setForeground(fDarkGreen);
                } else {
                    renderer.setForeground(Color.red);
                }
            } else if(janelapai3 != null){
                if(table.getValueAt(row, 3).toString().equals("D")){
                    if(!table.getValueAt(row, 4).toString().equals("R$ 0,00")){
                        if(table.getValueAt(row, 5).toString().equals("R$ 0,00")){
                            renderer.setForeground(Color.BLUE);
                        } else {
                            renderer.setForeground(Color.red);
                        }
                    } else {
                        renderer.setForeground(Color.BLUE);
                    }
                } else {
                    renderer.setForeground(Color.black);
                }
            }

        }

        return renderer;
    }
}
