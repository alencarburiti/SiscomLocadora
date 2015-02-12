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
public class PromocaoDevolucao {

    private Integer codigo_promocao_devolucao;
    private String descricao;
    private Double valor_promocao_devolucao;
    private Boolean pagamento_a_vista;
    private Diaria diaria;
    private String hora_antecipada;
    private String horario_locacao;
    private String horario_devolucao;
    private boolean status;

    public Integer getCodigo_promocao_devolucao() {
        return codigo_promocao_devolucao;
    }

    public void setCodigo_promocao_devolucao(Integer codigo_promocao_devolucao) {
        this.codigo_promocao_devolucao = codigo_promocao_devolucao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor_promocao_devolucao() {
        return valor_promocao_devolucao;
    }

    public void setValor_promocao_devolucao(Double valor_promocao) {
        this.valor_promocao_devolucao = valor_promocao;
    }

    public Boolean getPagamento_a_vista() {
        return pagamento_a_vista;
    }

    public void setPagamento_a_vista(Boolean pagamento_a_vista) {
        this.pagamento_a_vista = pagamento_a_vista;
    }

    public Diaria getDiaria() {
        return diaria;
    }

    public void setDiaria(Diaria diaria) {
        this.diaria = diaria;
    }

    public String getHora_antecipada() {
        return hora_antecipada;
    }

    public void setHora_antecipada(String hora_antecipada) {
        this.hora_antecipada = hora_antecipada;
    }

    public String getHorario_locacao() {
        return horario_locacao;
    }

    public void setHorario_locacao(String horario_locacao) {
        this.horario_locacao = horario_locacao;
    }

    public String getHorario_devolucao() {
        return horario_devolucao;
    }

    public void setHorario_devolucao(String horario_devolucao) {
        this.horario_devolucao = horario_devolucao;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
