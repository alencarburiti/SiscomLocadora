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
public class SubCategoria {

    private Integer codigo_sub_categoria;
    private String descricao;
    private Categoria categoria;

    public Integer getCodigo_sub_categoria() {
        return codigo_sub_categoria;
    }

    public void setCodigo_sub_categoria(Integer codigo_sub_categoria) {
        this.codigo_sub_categoria = codigo_sub_categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
