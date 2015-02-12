/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.bean;

/**
 *
 * @author Alencar
 */
public class Genero {

    private Integer codigo_genero;
    private String nome_genero;

    public Genero(Integer codigo_genero) {
        this.codigo_genero = codigo_genero;
    }

    public Genero(Integer codigo_genero, String nome_genero) {
        this.codigo_genero = codigo_genero;
        this.nome_genero = nome_genero;
    }

    public Genero() {
    }

    /**
     * @return the codigo_genero
     */
    public Integer getCodigo_genero() {
        return codigo_genero;
    }

    /**
     * @param codigo_genero the codigo_genero to set
     */
    public void setCodigo_genero(Integer codigo_genero) {
        this.codigo_genero = codigo_genero;
    }

    /**
     * @return the nome_genero
     */
    public String getNome_genero() {
        return nome_genero;
    }

    /**
     * @param nome_genero the nome_genero to set
     */
    public void setNome_genero(String nome_genero) {
        this.nome_genero = nome_genero;
    }

    
    
}
