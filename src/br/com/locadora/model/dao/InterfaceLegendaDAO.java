package br.com.locadora.model.dao;

import br.com.locadora.model.bean.Legenda;
import java.sql.SQLException;
import java.util.List;

public interface InterfaceLegendaDAO {

	public abstract void excluir(Integer codigo) throws SQLException;
	public abstract void salvar(Legenda legenda) throws SQLException;
	public abstract void atualizar(Legenda legenda) throws SQLException;
	public abstract Legenda getLegenda_codigo(Integer codigo) throws SQLException;
	public abstract List<Legenda> getLegenda_nome(String nome_legenda) throws SQLException;
	public abstract List<Legenda> getLegendas() throws SQLException;
}

