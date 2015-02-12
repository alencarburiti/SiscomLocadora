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

public class ConsultarFornecedor implements InterfaceCommand {

    private final InterfaceDiariaDAO diariaDAO;
    public List<Diaria> diarias;
    public Diaria diaria;

    public ConsultarFornecedor(InterfaceDiariaDAO diariaDAO) {
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
            Logger.getLogger(ConsultarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "OK";
    }

    public void mostrar_Diarias(List<Diaria> diarias) {
        DefaultTableModel tableModel = (DefaultTableModel) MenuDiaria.jtbl_diaria.getModel();
        tableModel.setNumRows(0);

        if (diarias.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma diaria encontrada");

        } else {
            for (int i = 0; i < diarias.size(); i++) {
                Diaria diaria = new Diaria();
                diaria.setCodigo_diaria(diarias.get(i).getCodigo_diaria());
                diaria.setNome_diaria(diarias.get(i).getNome_diaria());
                diaria.setDias(diarias.get(i).getDias());

                String valor = null;
                String valor_promocao = null;
                String multa = null;

                valor = String.valueOf(diarias.get(i).getValor());
                multa = String.valueOf(diarias.get(i).getMultas());

                Moeda moeda = new Moeda();

                valor = moeda.setPrecoFormat(valor);
                valor_promocao = moeda.setPrecoFormat(valor_promocao);
                multa = moeda.setPrecoFormat(multa);

                DefaultTableModel row = (DefaultTableModel) MenuDiaria.jtbl_diaria.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(diaria, diaria.getNome_diaria());
                row.addRow(new Object[]{diaria.getCodigo_diaria(), hashDbGrid, diaria.getDias(), valor, valor_promocao, multa});
            }
            MenuDiaria.diarias = diarias;
        }
    }

    public void mostrar_Diaria(Diaria diaria) throws ParseException {
        DefaultTableModel tableModel = (DefaultTableModel) MenuDiaria.jtbl_diaria.getModel();
        tableModel.setNumRows(0);

        if (diaria == null) {

        } else {
            String valor = null;
            String valor_promocao = null;
            String multa = null;

            valor = String.valueOf(diaria.getValor());   
            multa = String.valueOf(diaria.getMultas());

            Moeda moeda = new Moeda();

            valor = moeda.setPrecoFormat(valor);
            valor_promocao = moeda.setPrecoFormat(valor_promocao);
            multa = moeda.setPrecoFormat(multa);

            DefaultTableModel row = (DefaultTableModel) MenuDiaria.jtbl_diaria.getModel();
            ItemDbGrid hashDbGrid = new ItemDbGrid(diaria, diaria.getNome_diaria());
            row.addRow(new Object[]{diaria.getCodigo_diaria(), hashDbGrid, diaria.getDias(), valor, valor_promocao, multa});
        }
        MenuDiaria.diarias = diarias;
    }

}
