package br.com.locadora.conexao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PoolStation {

    private InterfaceDataSource ds;
    private ResourceBundle config;
    private String driver = "com.mysql.jdbc.Driver";

    public PoolStation() {
        
    }
    
    public Connection getConnection() {
        Connection conn = null;
try {
            File configFile = new File("config.properties");
            FileReader reader;
            reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);
            String ip_servidor = props.getProperty("url_db");
            String data_base = props.getProperty("data_base");

            config = ResourceBundle.getBundle("br.com.locadora.conexao.bancodedados");

            String url = config.getString("url") + ip_servidor + ":3306/" + data_base;
            Class.forName(driver);
            conn = DriverManager.getConnection(url, config.getString("usuario_station"), config.getString("senha_station"));
//            Connection conn = (Connection) new DataSource(url, config.getString("driver"),
//                    config.getString("usuario_station"), config.getString("senha_station"));
            
//            ds.getConnection();
            
       } catch (FileNotFoundException ex) {
            Logger.getLogger(PoolStation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PoolStation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PoolStation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PoolStation.class.getName()).log(Level.SEVERE, null, ex);
        }
return conn;
    }
//    
//    public void liberarConnection(Connection con) {
//        try {
//            conexoesLivres.add(con);
//            conexoesUtilizadas.remove(con.toString());
//        } catch (Exception e) {
//            System.out.println("Error: " + e);
//        }
//    }
}
