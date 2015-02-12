package br.com.locadora.model.dao;

import br.com.locadora.model.bean.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface InterfaceUsuarioDAO {

	public abstract void excluir(Integer codigo) throws SQLException;
	public abstract void salvar(Usuario usuario) throws SQLException;
	public abstract void atualizar(Usuario usuario) throws SQLException;
	public abstract List<Usuario> getUsuario(Integer codigo) throws SQLException;
	public abstract List<Usuario> getUsuarios(String usuario) throws SQLException;
	public abstract List<Usuario> getUsuarios() throws SQLException;
}

