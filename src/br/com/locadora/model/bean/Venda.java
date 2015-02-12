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
public class Venda {

    private Integer codigo_venda = 0;
    private Cliente cliente;
    private Dependente dependente;
    private Integer type_product;
    private Usuario usuario;
    

    public Integer getCodigo_venda() {
        return codigo_venda;
    }

    public void setCodigo_venda(Integer codigo_venda) {
        this.codigo_venda = codigo_venda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getType_product() {
        return type_product;
    }

    public void setType_product(Integer type_product) {
        this.type_product = type_product;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

}
