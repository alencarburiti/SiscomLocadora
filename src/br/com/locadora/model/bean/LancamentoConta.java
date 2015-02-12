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
public class LancamentoConta {

    private Integer codigo_lancamento_contas;
    private String descricao;
    private String documento;
    private Double valor;
    private Double valor_pago;
    private Date data_vencimento;
    private Date data_lancamento;
    private Date data_pagamento;
    private Fornecedor fornecedor;
    private Usuario usuario;
    private Integer caixa;
    private Categoria categoria;
    
    public Integer getCodigo_lancamento_contas() {
        return codigo_lancamento_contas;
    }

    public void setCodigo_lancamento_contas(Integer codigo_lancamento_contas) {
        this.codigo_lancamento_contas = codigo_lancamento_contas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public Date getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(Date data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Double getValorPago() {
        return getValor_pago();
    }

    public void setValorPago(Double valor_pago) {
        this.setValor_pago(valor_pago);
    }

    public Double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(Double valor_pago) {
        this.valor_pago = valor_pago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getCaixa() {
        return caixa;
    }

    public void setCaixa(Integer caixa) {
        this.caixa = caixa;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
