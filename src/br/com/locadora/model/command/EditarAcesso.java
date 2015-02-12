package br.com.locadora.model.command;

import java.sql.SQLException;


public class EditarAcesso implements InterfaceCommand {

//	private InterfaceUsuarioDAO usuarioDAO;
//	private AcessoDAO acessoDAO;
//	public EditarAcesso(InterfaceUsuarioDAO usuarioDAO,
//			AcessoDAO acessoDAO) {
//		super();
//		this.usuarioDAO = usuarioDAO;
//		this.acessoDAO = acessoDAO;
//	}
	public String execute() {
//		
//		try {
//			Integer codigo = Integer.parseInt(request.getParameter("codigo"));
//			request.setAttribute("usuario", usuarioDAO.getUsuario(codigo));
//			request.setAttribute("acessos", acessoDAO.getAcessosUsuario(codigo).values());
//		} catch (NumberFormatException e) {
//			request.setAttribute("mensagem", "C�digo inv�lido: "+request.getParameter("codigo"));
//			e.printStackTrace();
//			return "SiscomController?cmd=editarFuncionario";
//		} catch (SQLException e) {
//			request.setAttribute("mensagem", "Problemas de acesso ao banco de dados: "+e.getMessage());
//			e.printStackTrace();
//			return "SiscomController?cmd=editarFuncionario";
//		}
//		request.setAttribute("titulo", "Atualizar acessos");
		return "atualiza_acesso.jsp";
	}

}
