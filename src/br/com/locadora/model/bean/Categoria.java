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
public class Categoria {

    private Integer codigo_categoria;
    private String descricao;

    public Integer getCodigo_categoria() {
        return codigo_categoria;
    }

    public void setCodigo_categoria(Integer codigo_categoria) {
        this.codigo_categoria = codigo_categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
