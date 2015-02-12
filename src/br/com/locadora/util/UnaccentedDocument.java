/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.util;

import java.text.Normalizer;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/** 
 * 
 * @author murilo 
 */
    public class UnaccentedDocument extends PlainDocument {  
        @Override  
        public void insertString(int offs, String str, AttributeSet a)  
                throws BadLocationException {  
              
            if (str == null) {  
                return;  
            }  
      
            String unaccented = Normalizer.normalize(str, Normalizer.Form.NFD); // elimina os acentos.  
            unaccented = unaccented.replaceAll("[^\\p{ASCII}]", ""); // remove as sujeiras do processo acima.  
      
            super.insertString(offs, unaccented, a);  
        }  
    }  