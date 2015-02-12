/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.bean;

import java.util.Date;

/**
 *
 * @author Alencar
 */
public class Produto {

    private Integer codigo_produto;
    private String nome_produto;
    private String codigo_barras;
    private Double preco_compra;
    private Double preco_venda;    
    private Boolean Status;

    public Integer getCodigo_produto() {
        return codigo_produto;
    }

    public void setCodigo_produto(Integer codigo_produto) {
        this.codigo_produto = codigo_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public Double getPreco_compra() {
        return preco_compra;
    }

    public void setPreco_compra(Double preco_compra) {
        this.preco_compra = preco_compra;
    }

    public Double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean Status) {
        this.Status = Status;
    }


}
