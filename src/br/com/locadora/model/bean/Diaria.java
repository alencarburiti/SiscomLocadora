/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.bean;

import java.util.List;

/**
 *
 * @author Alencar
 */
public class Diaria {

    private Integer codigo_diaria;
    private String nome_diaria;
    private Double valor = 0.00;    
    private Integer dias = 0;
    private Double multas;
    private Integer maximo_dias;
    private Integer dias_previsto = 0;
    private Boolean acumulativo = false;
    private Integer quantidade_filme = 0;
    private Integer ganhados = 0;
    private Integer ganhar = 0;
    private List<PromocaoLocacao> listPromocao;
    private Combo pacotePromocional;
    private PromocaoLocacao promocaoLocacao;
    private PromocaoDevolucao promocaoDevolucao;

    public Integer getCodigo_diaria() {
        return codigo_diaria;
    }

    public void setCodigo_diaria(Integer codigo_diaria) {
        this.codigo_diaria = codigo_diaria;
    }

    public String getNome_diaria() {
        return nome_diaria;
    }

    public void setNome_diaria(String nome_diaria) {
        this.nome_diaria = nome_diaria;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public Double getMultas() {
        return multas;
    }

    public void setMultas(Double multas) {
        this.multas = multas;
    }

    public Integer getMaximo_dias() {
        return maximo_dias;
    }

    public void setMaximo_dias(Integer maximo_dias) {
        this.maximo_dias = maximo_dias;
    }

    public Integer getDias_previsto() {
        return dias_previsto;
    }

    public void setDias_previsto(Integer dias_previsto) {
        this.dias_previsto = dias_previsto;
    }

    public Boolean getAcumulativo() {
        return acumulativo;
    }

    public void setAcumulativo(Boolean acumulativo) {
        this.acumulativo = acumulativo;
    }

    public Integer getQuantidade_filme() {
        return quantidade_filme;
    }

    public void setQuantidade_filme(Integer quantidade_filme) {
        this.quantidade_filme = quantidade_filme;
    }

    public List<PromocaoLocacao> getListPromocao() {
        return listPromocao;
    }

    public void setListPromocao(List<PromocaoLocacao> listPromocao) {
        this.listPromocao = listPromocao;
    }

    public PromocaoLocacao getPromocaoLocacao() {
        return promocaoLocacao;
    }

    public void setPromocaoLocacao(PromocaoLocacao promocaoLocacao) {
        this.promocaoLocacao = promocaoLocacao;
    }

    public PromocaoDevolucao getPromocaoDevolucao() {
        return promocaoDevolucao;
    }

    public void setPromocaoDevolucao(PromocaoDevolucao promocaoDevolucao) {
        this.promocaoDevolucao = promocaoDevolucao;
    }

    public Integer getGanhados() {
        return ganhados;
    }

    public void setGanhados(Integer ganhados) {
        this.ganhados = ganhados;
    }

    public Integer getGanhar() {
        return ganhar;
    }

    public void setGanhar(Integer ganhar) {
        this.ganhar = ganhar;
    }

    public Combo getPacotePromocional() {
        return pacotePromocional;
    }

    public void setPacotePromocional(Combo pacotePromocional) {
        this.pacotePromocional = pacotePromocional;
    }

}
