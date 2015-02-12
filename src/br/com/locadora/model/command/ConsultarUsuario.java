package br.com.locadora.model.command;

import br.com.locadora.model.dao.InterfaceUsuarioDAO;
import java.sql.SQLException;


public class ConsultarUsuario implements InterfaceCommand {

	private InterfaceUsuarioDAO usuarioDAO;
	
	public ConsultarUsuario(InterfaceUsuarioDAO usuarioDAO) {
		super();
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	public String execute() {
//		request.setAttribute("titulo", "Consulta - Usu�rio");
//		try {
//			request.setAttribute("usuarios", usuarioDAO.getUsuarios());
//		} catch (SQLException e) {
//			request.setAttribute("mensagem", "Problemas com o acesso a base de dados: "+e.getMessage());
//			e.printStackTrace();
//		}
		return "consulta_usuario.jsp";
	}

}
