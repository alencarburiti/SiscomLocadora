/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.locadora.util;

/**
 *
 * @author ALENCAR
 */
import javax.swing.text.*;

public class LimitadorTexto extends PlainDocument {

    private int limite = 0;

    public LimitadorTexto(int l){
        this.limite = l;
    }

    public void insertString(int offs, String str, AttributeSet a)
               throws BadLocationException {

        int sobra = limite - getLength();
        int comprimento =  ( sobra > str.length() ) ? str.length() : sobra;
        super.insertString(offs, str.substring(0, comprimento), a);
    }
} 
