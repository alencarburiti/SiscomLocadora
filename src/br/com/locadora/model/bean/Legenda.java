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
public class Legenda {

    private Integer codigo_legenda;
    private String nome_legenda;

    public Integer getCodigo_legenda() {
        return codigo_legenda;
    }

    public void setCodigo_legenda(Integer codigo_legenda) {
        this.codigo_legenda = codigo_legenda;
    }

    public String getNome_legenda() {
        return nome_legenda;
    }

    public void setNome_legenda(String nome_legenda) {
        this.nome_legenda = nome_legenda;
    }

}
