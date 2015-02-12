package br.com.locadora.model.dao;

import br.com.locadora.model.bean.Cliente;
import java.sql.SQLException;
import java.util.List;
import br.com.locadora.model.bean.Lancamento;

public interface InterfaceLancamentoDAO {

    public abstract void excluir(Integer codigo) throws SQLException;
    public abstract Lancamento salvar(Lancamento lancamento) throws SQLException;
    public abstract void salvarLancamento(Lancamento lancamento) throws SQLException;
    public abstract void atualizar(Lancamento lancamento) throws SQLException;
    public abstract Lancamento getLancamento_nome(String nome_lancamento) throws SQLException;
    public abstract List<Lancamento> getLancamentos(Cliente cliente) throws SQLException;
}
