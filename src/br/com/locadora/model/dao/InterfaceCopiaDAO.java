package br.com.locadora.model.dao;

import br.com.locadora.model.bean.Copia;
import java.sql.SQLException;
import java.util.List;

public interface InterfaceCopiaDAO {

	public abstract void excluir(Integer codigo) throws SQLException;
	public abstract Copia salvar(Copia Copia) throws SQLException;
	public abstract void atualizar(Copia Copia) throws SQLException;
        public abstract void alterarStatusFilme(Copia copia) throws SQLException;
	public abstract List<Copia> getCopia(Integer codigo) throws SQLException;
	public abstract List<Copia> getCopias(String nome_Copia) throws SQLException;
	public abstract List<Copia> getCopias() throws SQLException;
}

