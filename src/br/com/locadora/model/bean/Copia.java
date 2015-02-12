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
public class Copia {

    private Integer codigo_copia;
    private String idioma;
    private String legenda;
    private Date data_aquisicao;
    private Date data_prevista;
    private Double preco_custo;
    private Objeto objeto;
    private String status;
    private String codigo_barras;
    private Integer numero_copia;
    private Diaria diaria;
    private String midia;
    private boolean defect_flag;
    private Combo pacotePromocional;

    public Integer getCodigo_copia() {
        return codigo_copia;
    }

    public void setCodigo_copia(Integer codigo_copia) {
        this.codigo_copia = codigo_copia;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public Date getData_aquisicao() {
        return data_aquisicao;
    }

    public void setData_aquisicao(Date data_aquisicao) {
        this.data_aquisicao = data_aquisicao;
    }

    public Double getPreco_custo() {
        return preco_custo;
    }

    public void setPreco_custo(Double preco_custo) {
        this.preco_custo = preco_custo;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public Integer getNumero_copia() {
        return numero_copia;
    }

    public void setNumero_copia(Integer numero_copia) {
        this.numero_copia = numero_copia;
    }

    public Date getData_prevista() {
        return data_prevista;
    }

    public void setData_prevista(Date data_prevista) {
        this.data_prevista = data_prevista;
    }

    public Diaria getDiaria() {
        return diaria;
    }

    public void setDiaria(Diaria diaria) {
        this.diaria = diaria;
    }

    public String getMidia() {
        return midia;
    }

    public void setMidia(String midia) {
        this.midia = midia;
    }

    public boolean getDefect_flag() {
        return isDefect_flag();
    }

    public void setDefect_flag(boolean defect_flag) {
        this.defect_flag = defect_flag;
    }

    public boolean isDefect_flag() {
        return defect_flag;
    }

    public Combo getPacotePromocional() {
        return pacotePromocional;
    }

    public void setPacotePromocional(Combo pacotePromocional) {
        this.pacotePromocional = pacotePromocional;
    }

}
