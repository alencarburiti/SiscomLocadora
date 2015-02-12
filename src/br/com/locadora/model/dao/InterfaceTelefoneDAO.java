package br.com.locadora.model.dao;

import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Telefone;
import java.sql.SQLException;
import java.util.List;

public interface InterfaceTelefoneDAO {

	public abstract boolean excluir(Integer codigo) throws SQLException;
	public abstract void salvar(List<Telefone> telefones, Cliente cliente) throws SQLException;
	public abstract void atualizar(Telefone telefone) throws SQLException;
	public abstract Telefone getTelefone(Integer codigo) throws SQLException;
        public abstract List<Telefone> getTelefones(Integer codigo_cliente) throws SQLException;
	public abstract Telefone getTelefone(String nome) throws SQLException;
	public abstract List<Telefone> getTelefones() throws SQLException;
}

