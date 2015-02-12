package br.com.locadora.model.command;

import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.dao.InterfaceDiariaDAO;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.Moeda;
import br.com.locadora.view.MenuDiaria;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultarDiaria implements InterfaceCommand {

    private final InterfaceDiariaDAO diariaDAO;
    public List<Diaria> diarias;
    public Diaria diaria;

    public ConsultarDiaria(InterfaceDiariaDAO diariaDAO) {
        super();
        this.diariaDAO = diariaDAO;
    }

    public String execute() {

        try {
            
                if (MenuDiaria.jrb_codigo_diaria.isSelected() == true) {
                    diaria = null;
                    diaria = diariaDAO.getDiaria_codigo(Integer.parseInt(MenuDiaria.jtf_pesquisa.getText().trim()));
                } else {
                    diarias = null;
                    diarias = diariaDAO.getDiaria_nome(MenuDiaria.jtf_pesquisa.getText().trim());
                    mostrar_Diarias(diarias);
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarDiaria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException e) {            
            JOptionPane.showMessageDialog(null, "Informe um Código");
        }

        return "OK";
    }

    public void mostrar_Diarias(List<Diaria> diarias) {
        DefaultTableModel tableModel = (DefaultTableModel) MenuDiaria.jtbl_diaria.getModel();
        tableModel.setNumRows(0);

        if (diarias.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma Diária encontrada");

        } else {
            for (int i = 0; i < diarias.size(); i++) {
                Diaria diaria = new Diaria();
                diaria.setCodigo_diaria(diarias.get(i).getCodigo_diaria());
                diaria.setNome_diaria(diarias.get(i).getNome_diaria());
                diaria.setDias(diarias.get(i).getDias());

                String valor = null;
                
                String relocacao = null;

                valor = String.valueOf(diarias.get(i).getValor());
                
                relocacao = String.valueOf(diarias.get(i).getMultas());

                Moeda moeda = new Moeda();

                valor = moeda.setPrecoFormat(valor);
                
                

                DefaultTableModel row = (DefaultTableModel) MenuDiaria.jtbl_diaria.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(diaria, diaria.getNome_diaria());
                row.addRow(new Object[]{diaria.getCodigo_diaria(), hashDbGrid, valor, moeda.setPrecoFormat(relocacao), diaria.getDias(),});
            }
            MenuDiaria.diarias = diarias;

            MenuDiaria.jtbl_diaria.requestFocus();
            MenuDiaria.jtbl_diaria.setSelectionMode(1);
        }
    }

    public void mostrar_Diaria(Diaria diaria) throws ParseException {
        DefaultTableModel tableModel = (DefaultTableModel) MenuDiaria.jtbl_diaria.getModel();
        tableModel.setNumRows(0);

        if (diaria == null) {

        } else {
            String valor = null;
            String valor_promocao = null;
            String relocacao = null;

            valor = String.valueOf(diaria.getValor());            
            relocacao = String.valueOf(diaria.getMultas());

            Moeda moeda = new Moeda();

            valor = moeda.setPrecoFormat(valor);
            valor_promocao = moeda.setPrecoFormat(valor_promocao);
            

            DefaultTableModel row = (DefaultTableModel) MenuDiaria.jtbl_diaria.getModel();
            ItemDbGrid hashDbGrid = new ItemDbGrid(diaria, diaria.getNome_diaria());
            row.addRow(new Object[]{diaria.getCodigo_diaria(), hashDbGrid, valor, moeda.setPrecoFormat(relocacao), diaria.getDias(),});
            diarias.add(diaria);
        }
        MenuDiaria.diarias = diarias;

        MenuDiaria.jtbl_diaria.requestFocus();
        MenuDiaria.jtbl_diaria.setSelectionMode(1);
    }

}
