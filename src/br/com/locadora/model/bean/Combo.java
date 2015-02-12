/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.bean;

import java.util.Date;
import java.util.List;

/**
 *
 * @author alencarburiti
 */
public class Combo {

    private Integer codigo_combo = 0;
    private String codigo_barras;
    private String descricao = "";
    private Integer quantidade_troca;
    private Integer quantidade_troca_efetuada;    
    private Integer dias_corridos;
    private Integer dias_combo;
    private Integer dias_restantes = 0;
    private Date data_lancamento;
    private Double valor;
    private Diaria diaria;
    private Boolean status;
    private ItemVenda itemVenda;

    public Integer getCodigo_combo() {
        return codigo_combo;
    }

    public void setCodigo_combo(Integer codigo_pacote_promocioanl) {
        this.codigo_combo = codigo_pacote_promocioanl;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade_troca() {
        return quantidade_troca;
    }

    public void setQuantidade_troca(Integer quantidade_vez) {
        this.quantidade_troca = quantidade_vez;
    }
    
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Diaria getDiarias() {
        return getDiaria();
    }

    public void setDiarias(Diaria diaria) {
        this.setDiaria(diaria);
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public Diaria getDiaria() {
        return diaria;
    }

    public void setDiaria(Diaria diaria) {
        this.diaria = diaria;
    }

    public Integer getDias_corridos() {
        return dias_corridos;
    }

    public void setDias_corridos(Integer dias_corridos) {
        this.dias_corridos = dias_corridos;
    }

    public Integer getDias_combo() {
        return dias_combo;
    }

    public void setDias_combo(Integer dias_pacote) {
        this.dias_combo = dias_pacote;
    }

    public Integer getDias_restantes() {
        return dias_restantes;
    }

    public void setDias_restantes(Integer dias_restantes) {
        this.dias_restantes = dias_restantes;
    }

    public Date getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(Date data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public ItemVenda getItemVenda() {
        return itemVenda;
    }

    public void setItemVenda(ItemVenda itemVenda) {
        this.itemVenda = itemVenda;
    }

    public Integer getQuantidade_troca_efetuada() {
        return quantidade_troca_efetuada;
    }

    public void setQuantidade_troca_efetuada(Integer quantidade_troca_efetuada) {
        this.quantidade_troca_efetuada = quantidade_troca_efetuada;
    }

}
