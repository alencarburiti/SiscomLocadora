package br.com.locadora.model.dao;

import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Dependente;
import java.sql.SQLException;
import java.util.List;

public interface InterfaceDependenteDAO {

	public abstract boolean excluir(Integer codigo) throws SQLException;
	public abstract void salvar(Dependente dependente, Cliente cliente) throws SQLException;
	public abstract void atualizar(Dependente dependentes) throws SQLException;
	public abstract Dependente getDependente(Integer codigo) throws SQLException;
        public abstract List<Dependente> getDependentes(Integer codigo_cliente) throws SQLException;
	public abstract Dependente getDependente(String nome) throws SQLException;
	public abstract List<Dependente> getDependentes() throws SQLException;
}

