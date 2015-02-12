/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DestinoCadastroGUI.java
 *
 * Created on 23/05/2011, 20:12:16
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Genero;
import br.com.locadora.model.bean.LogInfo;
import br.com.locadora.model.dao.GeneroDAO;
import br.com.locadora.model.dao.LogInfoDAO;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import br.com.locadora.util.LimitadorTexto;
import br.com.locadora.util.TemaInterface;
import java.sql.SQLException;

/**
 *
 * @author ALENCAR
 */
public class CadastraAlteraGenero extends javax.swing.JFrame {

    private Genero genero;
    public MenuGenero janelapai;
    public ConsultaGeneroObjeto janelapai2;
    public SiscomController controller;
    public GeneroDAO generoDAO;
    public InterfacePool pool;
    public AcessoUsuario acesso;

    /**
     * Creates new form DestinoCadastroGUI
     */
    public CadastraAlteraGenero() {
        initComponents();
        TemaInterface.getInterface(this);
        this.setTitle("Cadastrando Gênero");
        janelapai = null;
    }

    public CadastraAlteraGenero(Genero genero) {
        initComponents();
        if (genero != null) {
            TemaInterface.getInterface(this);
            this.setTitle("Alterando Gênero");
            janelapai = null;
            this.genero = genero;
            jtf_codigo_genero.setText(String.valueOf(genero.getCodigo_genero()));
            jtf_nome_genero.setText(genero.getNome_genero());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jb_salvar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jtf_codigo_genero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtf_nome_genero = new javax.swing.JTextField(new LimitadorTexto(50), "",10);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterando Gênero");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jb_salvar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/save.png"))); // NOI18N
        jb_salvar.setText("Salvar");
        jb_salvar.setName("jb_salvar"); // NOI18N
        jb_salvar.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salvarActionPerformed(evt);
            }
        });
        jb_salvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_salvarKeyPressed(evt);
            }
        });

        jb_cancelar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/sair.png"))); // NOI18N
        jb_cancelar.setText("Sair");
        jb_cancelar.setToolTipText("");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        jb_cancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_cancelarKeyPressed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Gênero"));
        jPanel1.setName("jPanel1"); // NOI18N

        jtf_codigo_genero.setEditable(false);
        jtf_codigo_genero.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_codigo_genero.setName("jtf_codigo_genero"); // NOI18N
        jtf_codigo_genero.setPreferredSize(new java.awt.Dimension(14, 24));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel2.setText("Código");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel3.setText("Nome Gênero*");
        jLabel3.setName("jLabel3"); // NOI18N

        jtf_nome_genero.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_nome_genero.setName("jtf_nome_genero"); // NOI18N
        jtf_nome_genero.setPreferredSize(new java.awt.Dimension(14, 24));
        jtf_nome_genero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_nome_generoFocusGained(evt);
            }
        });
        jtf_nome_genero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_nome_generoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jtf_nome_genero, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_codigo_genero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(jtf_codigo_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(jtf_nome_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jb_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jb_cancelar, jb_salvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jb_salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        cadastrarAlterarGenero();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_nome_genero.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        retornaJanelaPai();
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornaJanelaPai();
    }//GEN-LAST:event_formWindowClosed

    private void jb_salvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_salvarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cadastrarAlterarGenero();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarKeyPressed

    private void jb_cancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_cancelarKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            retornaJanelaPai();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_cancelarKeyPressed

    private void jtf_nome_generoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nome_generoFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nome_generoFocusGained

    private void jtf_nome_generoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_generoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_salvar.requestFocus();
        }
        acionarAtalho(evt);
    }//GEN-LAST:event_jtf_nome_generoKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CadastraAlteraGenero().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_salvar;
    public static javax.swing.JTextField jtf_codigo_genero;
    public static javax.swing.JTextField jtf_nome_genero;
    // End of variables declaration//GEN-END:variables

    private void cadastrarAlterarGenero() {
        if (verificarCampos()) {

            try {
                genero = new Genero();
                pool = new Pool();
                generoDAO = new GeneroDAO(pool);

                genero.setNome_genero(CadastraAlteraGenero.jtf_nome_genero.getText());

                if (jtf_codigo_genero.getText().equals("")) {
                    LogInfo logInfo = new LogInfo();
                    logInfo.setDescricao("Novo Gênero: " + jtf_nome_genero.getText());
                    logInfo.setUsuario(acesso.getUsuario());
                    pool = new Pool();
                    LogInfoDAO logInfoDAO = new LogInfoDAO(pool);
                    logInfoDAO.salvar(logInfo);

                    genero = generoDAO.salvar(genero);
                    jtf_codigo_genero.setText(genero.getCodigo_genero().toString());
                    JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
                } else {
                    LogInfo logInfo = new LogInfo();
                    logInfo.setDescricao("Alterar Gênero -> " + genero.getNome_genero() + " -> " + jtf_nome_genero.getText());
                    logInfo.setUsuario(acesso.getUsuario());
                    pool = new Pool();
                    LogInfoDAO logInfoDAO = new LogInfoDAO(pool);
                    logInfoDAO.salvar(logInfo);

                    genero.setCodigo_genero(Integer.parseInt(CadastraAlteraGenero.jtf_codigo_genero.getText()));
                    generoDAO.atualizar(genero);
                    JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage() + "Problemas com a gravação: ");
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido: " + e.getMessage());
            }
        }
    }

    public boolean verificarCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_nome_genero.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Descrição\n";
        }
        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            return false;
        } else {
            return true;
        }

    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            cadastrarAlterarGenero();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            retornaJanelaPai();
        }
    }

    public void retornaJanelaPai() {
        this.setVisible(false);
        janelapai.setStatusTela(true);
        janelapai.cadastraAlteraGenero = null;
        janelapai.buscarDados();
    }
}
