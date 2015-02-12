/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.bean;

import java.util.Date;

/**
 *
 * @author alencarburiti
 */
public class OcorrenciaDanificado {

    private Integer codigo_ocorrencia_danificado;
    private String observacao;
    private Copia copia;
    private Dependente dependente;
    private Lancamento lancamento;
    private ItemLancamento itemLancamento;
    private Usuario usuario;
    private Date data_ocorrencia;

    public Integer getCodigo_ocorrencia_danificado() {
        return codigo_ocorrencia_danificado;
    }

    public void setCodigo_ocorrencia_danificado(Integer codigo_ocorrencia_danificado) {
        this.codigo_ocorrencia_danificado = codigo_ocorrencia_danificado;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Copia getCopia() {
        return copia;
    }

    public void setCopia(Copia copia) {
        this.copia = copia;
    }

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

    public Lancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(Lancamento lancamento) {
        this.lancamento = lancamento;
    }

    public ItemLancamento getItemLancamento() {
        return itemLancamento;
    }

    public void setItemLancamento(ItemLancamento itemLancamento) {
        this.itemLancamento = itemLancamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getData_ocorrencia() {
        return data_ocorrencia;
    }

    public void setData_ocorrencia(Date data_ocorrencia) {
        this.data_ocorrencia = data_ocorrencia;
    }

}
