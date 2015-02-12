package br.com.locadora.model.dao;

import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.bean.Lancamento;
import java.sql.SQLException;
import java.util.List;
import br.com.locadora.model.bean.Locacao;

public interface InterfaceLocacaoDAO {

    public abstract void excluir(Integer codigo) throws SQLException;
    public abstract Locacao salvar(Locacao locacao) throws SQLException;
    public abstract void salvarLancamento(List<Lancamento> lancamentos) throws SQLException;
    public abstract void salvarItem(List<ItemLocacao> itemLocacao) throws SQLException;    
    public abstract void salvarDevolucao(List<ItemLocacao> itemLocacao) throws SQLException;
    public abstract void atualizar(Locacao locacao) throws SQLException;
    public abstract List<ItemLocacao> getLocacao_codigo(Integer codigo_locacao) throws SQLException;
    public abstract Locacao getLocacao_nome(String nome_locacao) throws SQLException;
    public abstract Locacao getLocacao_cpf(String cpf) throws SQLException;
    public abstract List<Locacao> getLocacaos() throws SQLException;
}
