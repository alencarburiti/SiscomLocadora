package br.com.locadora.model.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.locadora.model.bean.TipoServico;

public interface InterfaceTipoServicoDAO {

    public abstract void excluir(Integer codigo) throws SQLException;
    public abstract TipoServico salvar(TipoServico tipoServico) throws SQLException;
    public abstract void atualizar(TipoServico tipoServico) throws SQLException;
    public abstract List<TipoServico> getTipoServico(Integer codigo_tipo_servico) throws SQLException;   
    public abstract List<TipoServico> getTipoServicos() throws SQLException;
}
