/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.util;

/**
 *
 * @author ALENCAR
 */
public class ItemDbGrid {

    private Object objeto;
    private String label;

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public ItemDbGrid(Object objeto, String label) {
        this.objeto = objeto;
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }


}
