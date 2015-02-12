package br.com.locadora.conexao;

import java.sql.Connection;

public interface InterfacePool {

	public abstract Connection getConnection();
	public void liberarConnection(Connection con);
}
