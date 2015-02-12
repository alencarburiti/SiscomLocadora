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
public class Telefone {
    private Integer codigo_telefone;
    private String telefone;
    private Cliente cliente;

    public Telefone() {
        
    }
    
    public Telefone(Integer codigo_telefone) {
        this.codigo_telefone = codigo_telefone;
    }
    
    public Telefone(String telefone) {
        this.telefone = telefone;
    }

  
    
    /**
     * @return the codigo_telefone
     */
    public Integer getCodigo_telefone() {
        return codigo_telefone;
    }

    /**
     * @param codigo_telefone the codigo_telefone to set
     */
    public void setCodigo_telefone(Integer codigo_telefone) {
        this.codigo_telefone = codigo_telefone;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
