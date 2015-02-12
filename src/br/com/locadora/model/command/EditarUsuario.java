package br.com.locadora.model.command;

import java.sql.SQLException;


import br.com.locadora.model.dao.InterfaceUsuarioDAO;

public class EditarUsuario implements InterfaceCommand {

	private InterfaceUsuarioDAO usuarioDAO;

	public EditarUsuario(InterfaceUsuarioDAO usuarioDAO) {
		super();
		this.usuarioDAO = usuarioDAO;

	}

	public String execute() {
//		if (request.getParameter("codigo") == null) {
//			request.setAttribute("titulo", "Cadastro - Usu�rio");
//			return "cadastro_usuario.jsp";
//		}
//		try {
//			request.setAttribute("usuario", usuarioDAO.getUsuario(Integer
//					.valueOf(request.getParameter("codigo"))));
//			
//		} catch (SQLException e) {
//			request.setAttribute("mensagem", "Problemas com a base de dados: "
//					+ e.getMessage());
//			e.printStackTrace();
//		} catch (NumberFormatException e) {
//			request.setAttribute("mensagem",
//					"Valor do c�digo inv�lido: " + e.getMessage());
//			e.printStackTrace();
//		}
//		System.out.println("Passou aqui");
//		request.setAttribute("titulo", "Atualiza��o - Usu�rio");

		return "atualiza_usuario.jsp";
	}

}
