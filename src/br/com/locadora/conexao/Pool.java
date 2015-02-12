package br.com.locadora.conexao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Pool implements InterfacePool {

    private InterfaceDataSource ds;
    private ArrayBlockingQueue<Connection> conexoesLivres;
    private HashMap<String, Connection> conexoesUtilizadas;
    private Integer numeroMaximoConexoes;
    private ResourceBundle config;

    public Pool() {
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

            ds = new DataSource(url, config.getString("driver"),
                    config.getString("usuario"), config.getString("senha"));
            numeroMaximoConexoes = Integer.parseInt(config.getString("numeroMaximoConexoes"));
            conexoesLivres = new ArrayBlockingQueue<Connection>(numeroMaximoConexoes, true);
            conexoesUtilizadas = new HashMap<String, Connection>();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Pool.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Pool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Connection getConnection() {

        Connection con = null;

        try {
            if (conexoesUtilizadas.size() < numeroMaximoConexoes) {
                con = conexoesLivres.poll();
                if (con == null) {
                    con = ds.getConnection();
                } else if (con.isClosed()) {
                    this.getConnection();
                }
                conexoesUtilizadas.put(con.toString(), con);
            }
        } catch (SQLException e) {
            System.out.println("Problemas com o pool!");
            JOptionPane.showMessageDialog(null, "Verificar conexão com Banco de Dados");
        }
        return con;
    }

    @Override
    public void liberarConnection(Connection con) {
        try {
            conexoesLivres.add(con);
            conexoesUtilizadas.remove(con.toString());
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
