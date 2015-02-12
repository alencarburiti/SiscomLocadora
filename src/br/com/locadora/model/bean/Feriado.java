/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.bean;

import java.util.Date;

/**
 *
 * @author alencarburiti
 */
public class Feriado {

    private Integer codigo_feriado;
    private String descricao;
    private Date data_feriado;

    public Integer getCodigo_feriado() {
        return codigo_feriado;
    }

    public void setCodigo_feriado(Integer codigo_feriado) {
        this.codigo_feriado = codigo_feriado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData_feriado() {
        return data_feriado;
    }

    public void setData_feriado(Date data_feriado) {
        this.data_feriado = data_feriado;
    }

}
