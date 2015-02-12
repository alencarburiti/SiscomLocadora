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
public class TipoServico {
    private Integer codigo_tipo_servico;
    private String tipo;
    private String descricao;

    public Integer getCodigo_tipo_servico() {
        return codigo_tipo_servico;
    }

    public void setCodigo_tipo_servico(Integer codigo_tipo_servico) {
        this.codigo_tipo_servico = codigo_tipo_servico;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
