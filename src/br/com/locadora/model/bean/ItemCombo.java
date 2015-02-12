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
public class ItemCombo {

    private Integer codigo_item_combo;
    private Combo combo;
    private Boolean Status;
    private Diaria diaria;

    public Integer getCodigo_item_pacote_promocional() {
        return codigo_item_combo;
    }

    public void setCodigo_item_pacote_promocional(Integer codigo_item_pacote_promocional) {
        this.codigo_item_combo = codigo_item_pacote_promocional;
    }

    public Combo getPacotePromocional() {
        return combo;
    }

    public void setPacotePromocional(Combo pacotePromocional) {
        this.combo = pacotePromocional;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean Status) {
        this.Status = Status;
    }

    public Diaria getDiaria() {
        return diaria;
    }

    public void setDiaria(Diaria diaria) {
        this.diaria = diaria;
    }

}
