/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.util;

import br.com.locadora.model.bean.Fornecedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author alencarburiti
 */
public class AbstractComboBoxModel  extends AbstractListModel implements ComboBoxModel{
    private Object selectedItem;
    private List<Fornecedor> list;
    
    public AbstractComboBoxModel(){
        list = new ArrayList<Fornecedor>();
    }    

    public AbstractComboBoxModel(List<Fornecedor> lista){
        this();
        Fornecedor fornecedor = new Fornecedor();
        list.add(fornecedor);
        list.addAll(lista);
    }
    
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Object getElementAt(int index) {
        Fornecedor f = list.get(index);
        return f.getNome_fantasia();
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}
