package br.com.locadora.controller;

import java.io.IOException;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.command.InterfaceCommand;
import br.com.locadora.model.helper.SiscomHelper;

/**
 * Servlet implementation class for Servlet: SiscomController
 *
 */
 public class SiscomController  {
   static final long serialVersionUID = 1L;
   
   private InterfacePool pool = new Pool();
   private SiscomHelper siscomHelper = new SiscomHelper(pool);
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public SiscomController() {
		super();
	}
	
	public void processarRequisicao(String command) 
	{		
            siscomHelper.setCommand(command);
            InterfaceCommand commando = siscomHelper.getCommand();
            commando.execute();		
	}

	
}