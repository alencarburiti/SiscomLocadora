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
public class InfoSystem {

    private Integer codigo_info_system;
    private String nome_empresa;
    private String cnpj;
    private Date data_aquisicao;
    private Date data_inicio_licenca;
    private Date data_final_licenca;
    private Date data_ultimo_acesso;
    private Integer qtd_licenca;
    private String chave;

    public Integer getCodigo_info_system() {
        return codigo_info_system;
    }

    public void setCodigo_info_system(Integer codigo_info_system) {
        this.codigo_info_system = codigo_info_system;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getData_aquisicao() {
        return data_aquisicao;
    }

    public void setData_aquisicao(Date data_aquisicao) {
        this.data_aquisicao = data_aquisicao;
    }

    public Date getData_inicio_licenca() {
        return data_inicio_licenca;
    }

    public void setData_inicio_licenca(Date data_inicio_licenca) {
        this.data_inicio_licenca = data_inicio_licenca;
    }

    public Date getData_final_licenca() {
        return data_final_licenca;
    }

    public void setData_final_licenca(Date data_final_licenca) {
        this.data_final_licenca = data_final_licenca;
    }

    public Date getData_ultimo_acesso() {
        return data_ultimo_acesso;
    }

    public void setData_ultimo_acesso(Date data_ultimo_acesso) {
        this.data_ultimo_acesso = data_ultimo_acesso;
    }

    public Integer getQtd_licenca() {
        return qtd_licenca;
    }

    public void setQtd_licenca(Integer qtd_licenca) {
        this.qtd_licenca = qtd_licenca;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

}
