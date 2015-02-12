/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.util;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author alencarburiti
 */
public class TemaInterface {

    public static void getInterface(javax.swing.JFrame frame) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(frame);

            URL url = frame.getClass().getResource("/br/com/locadora/image/movies.png");
            Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
            frame.setIconImage(iconeTitulo);
                        
        } catch (Exception erro) {
            System.out.println("Error: " + erro);
        }

    }

}
