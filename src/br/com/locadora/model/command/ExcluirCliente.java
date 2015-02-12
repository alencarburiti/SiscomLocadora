package br.com.locadora.model.command;

import br.com.locadora.model.dao.InterfaceClienteDAO;
import java.sql.SQLException;


public class ExcluirCliente implements InterfaceCommand {

	private InterfaceClienteDAO clienteDAO;
	
	public ExcluirCliente(InterfaceClienteDAO clienteDAO) {
		super();
		this.clienteDAO = clienteDAO;
	}
	
	public String execute() {
//
//		try {
//			clienteDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
//			request.setAttribute("mensagem", "Cliente exclu�do com sucesso!");
//		} catch (NumberFormatException e) {
//			request.setAttribute("mensagem", "C�digo inv�lido: "+request.getParameter("codigo"));			
//			e.printStackTrace();
//		} catch (SQLException e) {
//			request.setAttribute("mensagem", "Problemas com a base de dados: "+e.getMessage());			
//			e.printStackTrace();
//		}
//		request.setAttribute("titulo", "Consulta - Cliente");
		return "SiscomController?cmd=consultarCliente";
	}

}
