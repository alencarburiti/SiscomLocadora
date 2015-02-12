/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.bean;

/**
 *
 * @author Alencar
 */
public class Usuario {

    public Usuario(Integer codigo_usuario, String nome_usuario) {
        this.codigo_usuario = codigo_usuario;
        this.nome_usuario = nome_usuario;
    }
    private Integer codigo_usuario;
    private String nome_usuario;
    private String login;
    private String senha;

    public Usuario() {
    }

    public void setCodigo_usuario(Integer codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;

    }

    public Integer getCodigo_usuario() {
        return codigo_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

}
