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
public class Idioma {

    private Integer codigo_idioma;
    private String nome_idioma;

    public Integer getCodigo_idioma() {
        return codigo_idioma;
    }

    public void setCodigo_idioma(Integer codigo_idioma) {
        this.codigo_idioma = codigo_idioma;
    }

    public String getNome_idioma() {
        return nome_idioma;
    }

    public void setNome_idioma(String nome_idioma) {
        this.nome_idioma = nome_idioma;
    }

}
