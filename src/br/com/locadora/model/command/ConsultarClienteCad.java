package br.com.locadora.model.command;

import br.com.locadora.model.dao.InterfaceClienteDAO;

public class ConsultarClienteCad implements InterfaceCommand {

	private InterfaceClienteDAO clienteDAO;
	
	public ConsultarClienteCad(InterfaceClienteDAO clienteDAO) {
		super();
		this.clienteDAO = clienteDAO;
	}

	public String execute() {
//		String nome = request.getParameter("nome");
//		System.out.println(nome);
//		try {
//			request.setAttribute("clientes", clienteDAO.getCliente(nome));
//			
//		} catch (SQLException e) {
//			request.setAttribute("mensagem", "Problemas com acesso a base de dados!");
//			e.printStackTrace();
//		}
//		
		return "consulta_cliente.jsp";
	}

}
