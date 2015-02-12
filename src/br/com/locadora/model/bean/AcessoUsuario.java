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
public class AcessoUsuario {

    private Integer codigo_acesso;
    private String action;
    private boolean ler;
    private boolean escrever;
    private boolean deletar;
    private boolean super_usuario;
    private Usuario usuario;
    private InterfaceAcesso interfaceAcesso;

    public Integer getCodigo_acesso() {
        return codigo_acesso;
    }

    public void setCodigo_acesso(Integer codigo_acesso) {
        this.codigo_acesso = codigo_acesso;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean getLer() {
        return ler;
    }

    public void setLer(boolean ler) {
        this.ler = ler;
    }

    public boolean getEscrever() {
        return escrever;
    }

    public void setEscrever(boolean escrever) {
        this.escrever = escrever;
    }

    public boolean getDeletar() {
        return deletar;
    }

    public void setDeletar(boolean deletar) {
        this.deletar = deletar;
    }

    public boolean getSuper_usuario() {
        return super_usuario;
    }

    public void setSuper_usuario(boolean super_usuario) {
        this.super_usuario = super_usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public InterfaceAcesso getInterfaceAcesso() {
        return interfaceAcesso;
    }

    public void setInterfaceAcesso(InterfaceAcesso interfaceAcesso) {
        this.interfaceAcesso = interfaceAcesso;
    }

    
}
