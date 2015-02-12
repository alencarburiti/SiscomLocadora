package br.com.locadora.model.command;

import br.com.locadora.model.dao.InterfaceClienteDAO;
import java.sql.SQLException;



public class EditarCliente implements InterfaceCommand {

	private InterfaceClienteDAO clienteDAO;

//	public EditarCliente(InterfaceClienteDAO clienteDAO) {
//		super();
//		this.clienteDAO = clienteDAO;
//	}

	
	public String execute() {
//		if (request.getParameter("codigo") == null) {
//			request.setAttribute("titulo", "Cadastro - Cliente");
//			return "cadastro_cliente.jsp";
//		}
//		try {
//			request.setAttribute("cliente", clienteDAO.getCliente(Integer
//					.valueOf(request.getParameter("codigo"))));			
//		} catch (NumberFormatException e) {
//			request.setAttribute("mensagem", "Valor do c�digo inv�lido: "
//					+ request.getParameter("codigo"));
//		} catch (SQLException e) {
//			request.setAttribute("mensagem",
//					"Problema com o acesso a base de dados: " + e.getMessage());
//			e.printStackTrace();
//		}
//		request.setAttribute("titulo", "Atualiza��o - Cliente");

		return "atualiza_cliente.jsp";
	}

}
