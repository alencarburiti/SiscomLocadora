package br.com.locadora.model.command;

import br.com.locadora.model.dao.InterfaceUsuarioDAO;
import java.sql.SQLException;


public class ExcluirFuncionario implements InterfaceCommand {

	private InterfaceUsuarioDAO usuarioDAO;
	
	public ExcluirFuncionario(InterfaceUsuarioDAO usuarioDAO) {
		super();
		this.usuarioDAO = usuarioDAO;
	}

	public String execute() {
//		
//		try {
//			usuarioDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
//		} catch (NumberFormatException e) {
//			request.setAttribute("mensagem", "C�digo do Usu�rio inv�lido. "+e.getMessage());
//			e.printStackTrace();
//		} catch (SQLException e) {
//			request.setAttribute("mensagem", "Problemas com exclus�o: "+e.getMessage());
//			e.printStackTrace();
//		}
//		request.setAttribute("titulo", "Consulta - Usu�rio");
		return "SiscomController?cmd=consultarUsuario";
	}

}
