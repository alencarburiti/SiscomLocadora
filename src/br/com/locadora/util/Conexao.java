/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author ALENCAR
 */
public class Conexao {

    private String driver = "com.mysql.jdbc.Driver";
    private String usuario = "root";
    private String senha = "";
    private ResourceBundle config;

    Connection conexao;

    //metodo de conexao
    public Connection conecta() {

        try {
            config = ResourceBundle.getBundle("br.com.locadora.conexao.bancodedados");
            
            File configFile = new File("config.properties");
            FileReader reader;
            reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);
            String ip_servidor = props.getProperty("url_db");
            String data_base = props.getProperty("data_base");

            String url = config.getString("url") + ip_servidor + ":3306/" + data_base;
            Class.forName(driver);
            
            System.out.println("Usuario: "+config.getString("usuario_station"));
            System.out.println("Senha: "+config.getString("senha_station"));
            System.out.println("URL: "+url);
            conexao = DriverManager.getConnection(url, config.getString("usuario_station"), config.getString("senha_station"));
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Nao foi possivel encontrar o driver");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexao;

    }

    public void desconecta() {
        try {
            conexao.close();
            //   JOptionPane.showMessageDialog(null,"banco fechado");
        } catch (SQLException fecha) {
            JOptionPane.showMessageDialog(null, "nao foi possivel"
                    + "fechar banco de dados " + fecha);
        }
    }
}
