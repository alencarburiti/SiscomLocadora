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
public class LogInfo {

    private Integer codigo_log_info;
    private String descricao;
    private Usuario usuario;
    private Date data_log; 
    
    public Integer getCodigo_log_info() {
        return codigo_log_info;
    }

    public void setCodigo_log_info(Integer codigo_log_info) {
        this.codigo_log_info = codigo_log_info;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getData_log() {
        return data_log;
    }

    public void setData_log(Date data_log) {
        this.data_log = data_log;
    }

}
