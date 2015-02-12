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
public class ItemLancamento {

    private Integer codigo_item_lancamento;
    private Double valor_lancamento;
    private Date data_lancamento;
    private TipoServico tipoServico;
    private Lancamento lancamento;
    private Usuario usuario;
    private Integer caixa;

    public Integer getCodigo_item_lancamento() {
        return codigo_item_lancamento;
    }

    public void setCodigo_item_lancamento(Integer codigo_item_lancamento) {
        this.codigo_item_lancamento = codigo_item_lancamento;
    }

    public Double getValor_lancamento() {
        return valor_lancamento;
    }

    public void setValor_lancamento(Double valor_lancamento) {
        this.valor_lancamento = valor_lancamento;
    }

    public Date getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(Date data_pagamento) {
        this.data_lancamento = data_pagamento;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public Lancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(Lancamento lancamento) {
        this.lancamento = lancamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getCaixa() {
        return caixa;
    }

    public void setCaixa(Integer caixa) {
        this.caixa = caixa;
    }


}
