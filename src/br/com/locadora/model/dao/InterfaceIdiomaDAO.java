package br.com.locadora.model.dao;

import br.com.locadora.model.bean.Idioma;
import java.sql.SQLException;
import java.util.List;

public interface InterfaceIdiomaDAO {

	public abstract void excluir(Integer codigo) throws SQLException;
	public abstract void salvar(Idioma idioma) throws SQLException;
	public abstract void atualizar(Idioma idioma) throws SQLException;
	public abstract Idioma getIdioma_codigo(Integer codigo) throws SQLException;
	public abstract List<Idioma> getIdioma_nome(String nome_idioma) throws SQLException;
	public abstract List<Idioma> getIdiomas() throws SQLException;
}

