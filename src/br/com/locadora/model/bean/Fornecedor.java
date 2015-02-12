/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model.bean;

/**
 *
 * @author Alencar
 */
public class Fornecedor {

    private Integer codigo_fornecedor;
    private String razao_social;
    private String nome_fantasia;
    private String endereço;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;
    private String cnpj;
    private String telefone;
    private String fax;
    private String tel_vendedor;
    private String nome_vendedor;

    public Integer getCodigo_fornecedor() {
        return codigo_fornecedor;
    }

    public void setCodigo_fornecedor(Integer codigo_fornecedor) {
        this.codigo_fornecedor = codigo_fornecedor;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTel_vendedor() {
        return tel_vendedor;
    }

    public void setTel_vendedor(String tel_vendedor) {
        this.tel_vendedor = tel_vendedor;
    }

    public String getNome_vendedor() {
        return nome_vendedor;
    }

    public void setNome_vendedor(String nome_vendedor) {
        this.nome_vendedor = nome_vendedor;
    }

}
