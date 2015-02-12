package br.com.locadora.model.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.locadora.model.bean.Objeto;

public interface InterfaceObjetoDAO {

    public abstract void excluir(Integer codigo) throws SQLException;
    public abstract Objeto salvar(Objeto cliente) throws SQLException;
    public abstract void atualizar(Objeto cliente) throws SQLException;
    public abstract List<Objeto> getObjeto_codigo(Integer codigo_cliente) throws SQLException;
    public abstract List<Objeto> getObjeto_objeto(String objeto) throws SQLException;    
    public abstract List<Objeto> getObjeto_diretor(String diretor) throws SQLException;        
    public abstract List<Objeto> getObjeto_elenco(String ator) throws SQLException;    
    public abstract List<Objeto> getObjetos() throws SQLException;
}
