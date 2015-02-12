package br.com.locadora.model.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.locadora.model.bean.Cliente;

public interface InterfaceClienteDAO {

    public abstract void excluir(Integer codigo) throws SQLException;
    public abstract Cliente salvar(Cliente cliente) throws SQLException;
    public abstract void atualizar(Cliente cliente) throws SQLException;
    public abstract List<Cliente> getCliente_codigo(Integer codigo_cliente) throws SQLException;
    public abstract List<Cliente> getClientes_codigo(Integer codigo_cliente) throws SQLException;
    public abstract List<Cliente> getCliente_nome(String nome_cliente) throws SQLException;
    public abstract Cliente getCliente_cpf(String cpf) throws SQLException;
    public abstract List<Cliente> getClienteCpf(String cpf) throws SQLException;
    public abstract List<Cliente> getClientes() throws SQLException;
}
