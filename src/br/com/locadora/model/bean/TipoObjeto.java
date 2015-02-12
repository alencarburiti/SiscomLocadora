/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.bean;

/**
 *
 * @author Alencar
 */
public class TipoObjeto {

    private Integer codigo_tipo_objeto;
    private String nome_tipo_objeto;

    /**
     * @return the codigo_tipo_objeto
     */
    public Integer getCodigo_tipo_objeto() {
        return codigo_tipo_objeto;
    }

    /**
     * @param codigo_tipo_objeto the codigo_tipo_objeto to set
     */
    public void setCodigo_tipo_objeto(Integer codigo_tipo_objeto) {
        this.codigo_tipo_objeto = codigo_tipo_objeto;
    }

    /**
     * @return the nome_tipo_objeto
     */
    public String getNome_tipo_objeto() {
        return nome_tipo_objeto;
    }

    /**
     * @param nome_tipo_objeto the nome_tipo_objeto to set
     */
    public void setNome_tipo_objeto(String nome_tipo_objeto) {
        this.nome_tipo_objeto = nome_tipo_objeto;
    }

}
