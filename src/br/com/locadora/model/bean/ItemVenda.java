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
public class ItemVenda {

    private Integer codigo_item_venda;
    private Produto produto;
    private Combo pacotePromocional;
    private Integer quantidade;
    private Double preco_total;
    private Integer type_product;

    public Integer getCodigo_item_venda() {
        return codigo_item_venda;
    }

    public void setCodigo_item_venda(Integer codigo_item_venda) {
        this.codigo_item_venda = codigo_item_venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Combo getCombo() {
        return pacotePromocional;
    }

    public void setCombo(Combo pacotePromocional) {
        this.pacotePromocional = pacotePromocional;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getType_product() {
        return type_product;
    }

    public void setType_product(Integer type_product) {
        this.type_product = type_product;
    }

    public Double getPreco_total() {
        return preco_total;
    }

    public void setPreco_total(Double preco_total) {
        this.preco_total = preco_total;
    }

}
