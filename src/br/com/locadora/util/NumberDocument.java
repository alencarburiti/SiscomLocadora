/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.util;

import javax.print.attribute.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author ALENCAR
 */
    public class NumberDocument extends PlainDocument {  
      
        //@Override  
        public void insertString(int offs, String str, AttributeSet a)  
                throws BadLocationException {  
              
            if (str == null) {  
                return;  
            }  
      
            String accepted = str.replaceAll("[^0-9]", ""); // aqui apago os caracteres que não sejam números, assim mantenho apenas os números na String de entrada (representada pela variável str).  
      
          //   super.insertString(offs, accepted, a); // chamo o método de PlainDocument, que vai exibir no text field apenas os caracteres que passaram pelo "filtro" acima.  
        }  
      
    }  
