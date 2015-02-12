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
public class InterfaceAcesso {

    private String descricao;
    private Integer codigo_interface;
    private String tipo;
    private String nome_classe;
    private Integer del_flag;
    private Integer codigo_pai;
    private Integer operacao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodigo_interface() {
        return codigo_interface;
    }

    public void setCodigo_interface(Integer codigo_interface) {
        this.codigo_interface = codigo_interface;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome_classe() {
        return nome_classe;
    }

    public void setNome_classe(String nome_classe) {
        this.nome_classe = nome_classe;
    }

    public Integer getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
    }

    public Integer getCodigo_pai() {
        return codigo_pai;
    }

    public void setCodigo_pai(Integer codigo_pai) {
        this.codigo_pai = codigo_pai;
    }

    public Integer getOperacao() {
        return operacao;
    }

    public void setOperacao(Integer operacao) {
        this.operacao = operacao;
    }

}
