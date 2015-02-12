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
public class Lancamento {

    private Integer codigo_lancamento;
    private Double valor_total;
    private Locacao locacao;
    private Devolucao devolucao;
    private Venda venda;
    private TipoServico tipoServico;
    private Dependente dependente;
    private Usuario usuario;
    private Date data_lancamento;
    private Double credito;
    private Double debito;
    private Double saldo;
    private Double devedor;
    private Integer caixa;
    private Double saldo_dia;
    private Double desconto;
    private Double desconto_entrega_antecipada;
    private Double valor_pago;
    private Double troco;
    private Double valor_total_a_pagar;

    public Integer getCodigo_lancamento() {
        return codigo_lancamento;
    }

    public void setCodigo_lancamento(Integer codigo_lancamento) {
        this.codigo_lancamento = codigo_lancamento;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    public Devolucao getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Devolucao devolucao) {
        this.devolucao = devolucao;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(Date data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public Double getCredito() {
        return credito;
    }

    public void setCredito(Double credito) {
        this.credito = credito;
    }

    public Double getDebito() {
        return debito;
    }

    public void setDebito(Double debito) {
        this.debito = debito;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getCaixa() {
        return caixa;
    }

    public void setCaixa(Integer caixa) {
        this.caixa = caixa;
    }

    public Double getDevedor() {
        return devedor;
    }

    public void setDevedor(Double devedor) {
        this.devedor = devedor;
    }

    public Double getSaldo_dia() {
        return saldo_dia;
    }

    public void setSaldo_dia(Double saldo_dia) {
        this.saldo_dia = saldo_dia;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getDesconto_entrega_antecipada() {
        return desconto_entrega_antecipada;
    }

    public void setDesconto_entrega_antecipada(Double desconto_entrega_antecipada) {
        this.desconto_entrega_antecipada = desconto_entrega_antecipada;
    }

    public Double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(Double valor_pago) {
        this.valor_pago = valor_pago;
    }

    public Double getTroco() {
        return troco;
    }

    public void setTroco(Double troco) {
        this.troco = troco;
    }

    public Double getValor_total_a_pagar() {
        return valor_total_a_pagar;
    }

    public void setValor_total_a_pagar(Double valor_total_a_pagar) {
        this.valor_total_a_pagar = valor_total_a_pagar;
    }

}
