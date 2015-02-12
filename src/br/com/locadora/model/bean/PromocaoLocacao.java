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
public class PromocaoLocacao {

    private Integer codigo_promocao_locacao = 0;
    private String descricao = "";
    private Double valor_promocao_locacao = 0.00;

    private Boolean pagamento_a_vista;
    private Integer orderm;
    private Diaria diaria;

    private Boolean domingo = false;
    private Boolean segunda = false;
    private Boolean terca = false;
    private Boolean quarta = false;
    private Boolean quinta = false;
    private Boolean sexta = false;
    private Boolean sabado = false;
    private Integer locar_quantidade = 0;
    private Integer ganhar_quantidade = 0;

    private String hora_antecipada;
    
    private boolean status;

    public Integer getCodigo_promocao_locacao() {
        return codigo_promocao_locacao;
    }

    public void setCodigo_promocao_locacao(Integer codigo_promocao_locacao) {
        this.codigo_promocao_locacao = codigo_promocao_locacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor_promocao_locacao() {
        return valor_promocao_locacao;
    }

    public void setValor_promocao_locacao(Double valor_promocao_locacao) {
        this.valor_promocao_locacao = valor_promocao_locacao;
    }

    public Boolean getPagamento_a_vista() {
        return pagamento_a_vista;
    }

    public void setPagamento_a_vista(Boolean pagamento_a_vista) {
        this.pagamento_a_vista = pagamento_a_vista;
    }

    public Integer getOrderm() {
        return orderm;
    }

    public void setOrderm(Integer orderm) {
        this.orderm = orderm;
    }

    public Diaria getDiaria() {
        return diaria;
    }

    public void setDiaria(Diaria diaria) {
        this.diaria = diaria;
    }

    public Boolean getDomingo() {
        return domingo;
    }

    public void setDomingo(Boolean domingo) {
        this.domingo = domingo;
    }

    public Boolean getSegunda() {
        return segunda;
    }

    public void setSegunda(Boolean segunda) {
        this.segunda = segunda;
    }

    public Boolean getTerca() {
        return terca;
    }

    public void setTerca(Boolean terca) {
        this.terca = terca;
    }

    public Boolean getQuarta() {
        return quarta;
    }

    public void setQuarta(Boolean quarta) {
        this.quarta = quarta;
    }

    public Boolean getQuinta() {
        return quinta;
    }

    public void setQuinta(Boolean quinta) {
        this.quinta = quinta;
    }

    public Boolean getSexta() {
        return sexta;
    }

    public void setSexta(Boolean sexta) {
        this.sexta = sexta;
    }

    public Boolean getSabado() {
        return sabado;
    }

    public void setSabado(Boolean sabado) {
        this.sabado = sabado;
    }

    public Integer getLocar_quantidade() {
        return locar_quantidade;
    }

    public void setLocar_quantidade(Integer locar_quantidade) {
        this.locar_quantidade = locar_quantidade;
    }

    public Integer getGanhar_quantidade() {
        return ganhar_quantidade;
    }

    public void setGanhar_quantidade(Integer ganhar_quantidade) {
        this.ganhar_quantidade = ganhar_quantidade;
    }

    public String getHora_antecipada() {
        return hora_antecipada;
    }

    public void setHora_antecipada(String hora_antecipada) {
        this.hora_antecipada = hora_antecipada;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
