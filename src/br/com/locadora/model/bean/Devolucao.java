/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.bean;

/**
 *
 * @author alencarburiti
 */
public class Devolucao {

    private Integer codigo_devolucao = 0;
    private Copia copia;
    private Dependente dependente;
    private Locacao locacao;
    private ItemLocacao itemLocacao;

    public Integer getCodigo_devolucao() {
        return codigo_devolucao;
    }

    public void setCodigo_devolucao(Integer codigo_devolucao) {
        this.codigo_devolucao = codigo_devolucao;
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

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    public ItemLocacao getItemLocacao() {
        return itemLocacao;
    }

    public void setItemLocacao(ItemLocacao itemLocacao) {
        this.itemLocacao = itemLocacao;
    }

}
