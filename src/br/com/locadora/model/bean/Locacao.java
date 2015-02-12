/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.bean;

import java.util.List;

/**
 *
 * @author alencarburiti
 */
public class Locacao {

    private Integer codigo_locacao = 0;
    private Cliente cliente;
    private Dependente dependente;
    private List<ItemLocacao> itemLocacao;
    private Double valor_pago;
    private Usuario usuario;
    
    public Integer getCodigo_locacao() {
        return codigo_locacao;
    }

    public void setCodigo_locacao(Integer codigo_locacao) {
        this.codigo_locacao = codigo_locacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemLocacao> getItemLocacao() {
        return itemLocacao;
    }

    public void setItemLocacao(List<ItemLocacao> itemLocacao) {
        this.itemLocacao = itemLocacao;
    }

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

    public Double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(Double valor_pago) {
        this.valor_pago = valor_pago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
