package br.com.locadora.model.command;

import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Devolucao;
import br.com.locadora.model.dao.InterfaceLocacaoDAO;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.view.MenuCliente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ConsultarDevolucao implements InterfaceCommand {

    private final InterfaceLocacaoDAO locacaoDAO;

    public ConsultarDevolucao(InterfaceLocacaoDAO locacaoDAO) {
        super();
        this.locacaoDAO = locacaoDAO;
    }

    List<Devolucao> devolucoes;
    Devolucao devolucao;

    public String execute() {

        
        return "OK";
    }

    public void mostrar_devolucao(List<Cliente> clientes) throws ParseException {
        DefaultTableModel tableModel = (DefaultTableModel) MenuCliente.jtbl_cliente.getModel();
        tableModel.setNumRows(0);

        if (clientes.size() == 0) {

        } else {

            for (int i = 0; i < clientes.size(); i++) {

                Cliente cliente = new Cliente();
                cliente.setCodigo_cliente(clientes.get(i).getCodigo_cliente());
                cliente.setNome_cliente(clientes.get(i).getNome_cliente());
                cliente.setCpf(clientes.get(i).getCpf());
                cliente.setEmail(clientes.get(i).getEmail());                
                cliente.setStatus(clientes.get(i).getStatus());

                SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
                
                String data_nascimento = out.format(in.parse(clientes.get(i).getData_nascimento().toString()));
                
                DefaultTableModel row = (DefaultTableModel) MenuCliente.jtbl_cliente.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(cliente, cliente.getNome_cliente());
                row.addRow(new Object[]{cliente.getCodigo_cliente(), hashDbGrid, data_nascimento, cliente.getCpf(), cliente.getEmail(), cliente.getStatus()});
                System.out.print(cliente.getEmail());
            }
            MenuCliente.clientes = clientes;
        }

    }

    public void mostrar_clientes(Cliente cliente) throws ParseException {
        DefaultTableModel tableModel = (DefaultTableModel) MenuCliente.jtbl_cliente.getModel();
        tableModel.setNumRows(0);

        if (cliente == null) {

        } else {

                SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
                
                String data_nascimento = out.format(in.parse(cliente.getData_nascimento().toString()));
                
                DefaultTableModel row = (DefaultTableModel) MenuCliente.jtbl_cliente.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(cliente, cliente.getNome_cliente());
                row.addRow(new Object[]{cliente.getCodigo_cliente(), hashDbGrid, data_nascimento, cliente.getCpf(), cliente.getEmail(), cliente.getStatus()});
                
        }
    }

}

