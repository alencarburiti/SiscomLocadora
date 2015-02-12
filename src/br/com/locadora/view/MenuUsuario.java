/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Cad_Usuário.java
 *
 * Created on 07/04/2011, 20:29:27
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.LogInfo;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.model.bean.Usuario;
import br.com.locadora.model.dao.LogInfoDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.TemaInterface;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alencar
 */
public class MenuUsuario extends javax.swing.JFrame {

    public String tipoCadastro;
    public List<Usuario> usuarios;
    public TelaPrincipal janelapai;
    public InterfacePool pool;
    public AcessoUsuario acesso;
    public AtualizaUsuario atualizaUsuario;
    /**
     * Creates new form Cad_Usuário
     */
    public MenuUsuario() {
        initComponents();
        getUsuarios();
        TemaInterface.getInterface(this);
        atualizaUsuario = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        popupMenu1 = new java.awt.PopupMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_usuario = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jrb_codigo = new javax.swing.JRadioButton();
        jrb_nome = new javax.swing.JRadioButton();
        jrb_login = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jb_pesquisa = new javax.swing.JButton();
        jtf_pesquisa = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jb_novo = new javax.swing.JButton();
        jb_alterar = new javax.swing.JButton();
        jb_excluir = new javax.swing.JButton();
        jb_sair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setName("jTable1"); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de Usuários");
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

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jtbl_usuario.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Usuário", "Login"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_usuario.setUpdateSelectionOnSort(false);

        jtbl_usuario.setVerifyInputWhenFocusTarget(false);
        jtbl_usuario.setDefaultEditor(Object.class, null);
        jtbl_usuario.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    alterar();
                }}});
                jtbl_usuario.setName("jtbl_usuario"); // NOI18N
                jtbl_usuario.getTableHeader().setReorderingAllowed(false);
                jtbl_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jtbl_usuarioMouseClicked(evt);
                    }
                });
                jtbl_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jtbl_usuarioKeyPressed(evt);
                    }
                });
                jScrollPane2.setViewportView(jtbl_usuario);
                if (jtbl_usuario.getColumnModel().getColumnCount() > 0) {
                    jtbl_usuario.getColumnModel().getColumn(0).setPreferredWidth(10);
                    jtbl_usuario.getColumnModel().getColumn(1).setPreferredWidth(300);
                    jtbl_usuario.getColumnModel().getColumn(2).setPreferredWidth(80);
                }

                jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Usuário"));
                jPanel3.setName("jPanel3"); // NOI18N
                jPanel3.setPreferredSize(new java.awt.Dimension(400, 90));

                buttonGroup1.add(jrb_codigo);
                jrb_codigo.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jrb_codigo.setText("Código");
                jrb_codigo.setName("jrb_codigo"); // NOI18N
                jrb_codigo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jrb_codigoActionPerformed(evt);
                    }
                });

                buttonGroup1.add(jrb_nome);
                jrb_nome.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jrb_nome.setSelected(true);
                jrb_nome.setText("Nome");
                jrb_nome.setName("jrb_nome"); // NOI18N
                jrb_nome.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jrb_nomeActionPerformed(evt);
                    }
                });

                buttonGroup1.add(jrb_login);
                jrb_login.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jrb_login.setText("Login");
                jrb_login.setName("jrb_login"); // NOI18N
                jrb_login.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jrb_loginActionPerformed(evt);
                    }
                });

                jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jLabel1.setText("Parâmetro");
                jLabel1.setName("jLabel1"); // NOI18N

                jb_pesquisa.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jb_pesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
                jb_pesquisa.setName("jb_pesquisa"); // NOI18N
                jb_pesquisa.setPreferredSize(new java.awt.Dimension(24, 24));
                jb_pesquisa.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_pesquisaActionPerformed(evt);
                    }
                });
                jb_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jb_pesquisaKeyPressed(evt);
                    }
                });

                jtf_pesquisa.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jtf_pesquisa.setName("jtf_pesquisa"); // NOI18N
                jtf_pesquisa.setPreferredSize(new java.awt.Dimension(300, 24));
                jtf_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jtf_pesquisaKeyPressed(evt);
                    }
                });

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                    jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jrb_nome)
                                .addGap(0, 0, 0)
                                .addComponent(jrb_login)
                                .addGap(0, 0, 0)
                                .addComponent(jrb_codigo))
                            .addComponent(jLabel1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jtf_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jb_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5))
                );
                jPanel3Layout.setVerticalGroup(
                    jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jb_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jrb_nome)
                                    .addComponent(jrb_login)
                                    .addComponent(jrb_codigo))
                                .addGap(0, 0, 0)
                                .addComponent(jLabel1)
                                .addGap(0, 0, 0)
                                .addComponent(jtf_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0))
                );

                jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
                jPanel1.setName("jPanel1"); // NOI18N

                jb_novo.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jb_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/novo_registro.png"))); // NOI18N
                jb_novo.setText("Novo");
                jb_novo.setName("jb_novo"); // NOI18N
                jb_novo.setPreferredSize(new java.awt.Dimension(100, 40));
                jb_novo.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_novoActionPerformed(evt);
                    }
                });

                jb_alterar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jb_alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/alterar_registro.png"))); // NOI18N
                jb_alterar.setText("Alterar");
                jb_alterar.setName("jb_alterar"); // NOI18N
                jb_alterar.setPreferredSize(new java.awt.Dimension(100, 40));
                jb_alterar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_alterarActionPerformed(evt);
                    }
                });

                jb_excluir.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jb_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/delete 16.png"))); // NOI18N
                jb_excluir.setText("Excluir");
                jb_excluir.setName("jb_excluir"); // NOI18N
                jb_excluir.setPreferredSize(new java.awt.Dimension(100, 40));
                jb_excluir.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_excluirActionPerformed(evt);
                    }
                });

                jb_sair.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
                jb_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/sair.png"))); // NOI18N
                jb_sair.setText("Sair");
                jb_sair.setName("jb_sair"); // NOI18N
                jb_sair.setPreferredSize(new java.awt.Dimension(100, 40));
                jb_sair.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jb_sairActionPerformed(evt);
                    }
                });
                jb_sair.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        jb_sairKeyPressed(evt);
                    }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jb_novo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                );
                jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_novo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                );

                jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/BROADWAY-LOGIN.png"))); // NOI18N
                jLabel2.setName("jLabel2"); // NOI18N

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                );

                pack();
                setLocationRelativeTo(null);
            }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_pesquisa.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jb_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_novoActionPerformed
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuUsuario");
        try {
            if (acesso.getSuper_usuario()== true) {
                CadastroUsuario cadastroUsuario = new CadastroUsuario();
                cadastroUsuario.janelapai = this;
                cadastroUsuario.setVisible(true);
                setStatusTela(false);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }

        // TODO add your handling code here:
}//GEN-LAST:event_jb_novoActionPerformed

    private void jb_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_alterarActionPerformed
        alterar();
        // TODO add your handling code here:
}//GEN-LAST:event_jb_alterarActionPerformed
    
    private void jb_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_pesquisaActionPerformed
        if (jrb_codigo.isSelected() == true) {
            getUsuarioCodigo();

        } else if (jrb_nome.isSelected() == true) {
            getUsuarioNome();
        } else if (jrb_login.isSelected() == true) {
            getUsuarios();
        } else {
            getUsuarios();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_pesquisaActionPerformed

    private void jb_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_excluirActionPerformed
        excluirUsuario();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_excluirActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        janelapai.setStatusTela(true);
        setVisible(false);
    }//GEN-LAST:event_formWindowClosed

    private void jb_pesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_pesquisaKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_pesquisa.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_pesquisaKeyPressed

    private void jtf_pesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_pesquisaKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_pesquisa.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_pesquisaKeyPressed

    private void jtbl_usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_usuarioKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_alterar.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_usuarioKeyPressed

    private void jtbl_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_usuarioMouseClicked
        if (evt.getClickCount() == 2) {
            jb_alterar.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_usuarioMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void jb_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_sairActionPerformed
        retornarJanelaPai();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_sairActionPerformed

    private void jb_sairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_sairKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_sairKeyPressed

    private void jrb_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_nomeActionPerformed
        jtf_pesquisa.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_nomeActionPerformed

    private void jrb_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_loginActionPerformed
        jtf_pesquisa.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_loginActionPerformed

    private void jrb_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_codigoActionPerformed
        jtf_pesquisa.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_codigoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MenuUsuario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jb_alterar;
    private javax.swing.JButton jb_excluir;
    private javax.swing.JButton jb_novo;
    private javax.swing.JButton jb_pesquisa;
    private javax.swing.JButton jb_sair;
    private javax.swing.JRadioButton jrb_codigo;
    private javax.swing.JRadioButton jrb_login;
    private javax.swing.JRadioButton jrb_nome;
    private javax.swing.JTable jtbl_usuario;
    public static javax.swing.JTextField jtf_pesquisa;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables
    Usuario usuario = new Usuario();

    public void request() {
        jtf_pesquisa.requestFocus();
    }

    public void getUsuarios() {
        pool = new Pool();
        UsuarioDAO usu = new UsuarioDAO(pool);
        usuarios = usu.getUsuarios("%" + jtf_pesquisa.getText().trim() + "%");
        mostrarUsuarios(usuarios);
    }

    public void getUsuarioCodigo() {
        if (jtf_pesquisa.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe um Código");
        } else {
            pool = new Pool();
            UsuarioDAO usu = new UsuarioDAO(pool);
            usuarios = usu.listarUsuarioCodigo(jtf_pesquisa.getText().trim());
            mostrarUsuarios(usuarios);
        }
    }

    public void getUsuarioNome() {
        pool = new Pool();
        UsuarioDAO usu = new UsuarioDAO(pool);

        usuarios = usu.listarUsuarioDescrição("%"+jtf_pesquisa.getText().trim() + "%");
        mostrarUsuarios(usuarios);
    }

    public void mostrarUsuarios(List<Usuario> usuarios) {
        DefaultTableModel tableModel = (DefaultTableModel) jtbl_usuario.getModel();
        tableModel.setNumRows(0);

        if (usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum Usuário encontrado");

        } else {

            for (int i = 0; i < usuarios.size(); i++) {

                DefaultTableModel row = (DefaultTableModel) jtbl_usuario.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(usuarios.get(i), usuarios.get(i).getNome_usuario());
                row.addRow(new Object[]{usuarios.get(i).getCodigo_usuario(), hashDbGrid, usuarios.get(i).getLogin()});
            }
            jtbl_usuario.requestFocus();
            jtbl_usuario.setSelectionMode(1);
        }

    }

    public Usuario tbUsuarioLinhaSelecionada(JTable tb) {
        Usuario usu = null;
        if (tb.getSelectedRow() != -1) {
            usu = usuarios.get(tb.getSelectedRow());            
        }
        return usu;
    }

    private void excluirUsuario() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuObjeto");

        try {
            if (acesso.getSuper_usuario() == true) {
                DefaultTableModel row = (DefaultTableModel) jtbl_usuario.getModel();
                if (jtbl_usuario.getSelectedRow() != -1) {
                    int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_NO_OPTION) {
                        pool = new Pool();
                        UsuarioDAO usuarioDAO = new UsuarioDAO(pool);
                        usuario = new Usuario();
                        usuario = usuarios.get(jtbl_usuario.getSelectedRow());

                        try {
                            usuarioDAO.excluiUsuario(usuario);
                            row.removeRow(jtbl_usuario.getSelectedRow());
                            
                            LogInfo logInfo = new LogInfo();
                            logInfo.setDescricao("Excluir Usuário -> " + usuario.getNome_usuario());
                            logInfo.setUsuario(acesso.getUsuario());
                            pool = new Pool();
                            LogInfoDAO logInfoDAO = new LogInfoDAO(pool);
                            logInfoDAO.salvar(logInfo);                  
                            
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um Usuário");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
    }

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            retornarJanelaPai();            
        }
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            jb_excluir.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            jtf_pesquisa.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            jb_novo.doClick();
        }
    }
    
    public void alterar() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.Locadora.view.MenuUsuario");
        try {
            System.out.println("Escrever: " + acesso.getEscrever());
            if (acesso.getSuper_usuario()== true) {
                Usuario usu = tbUsuarioLinhaSelecionada(jtbl_usuario);
                if (usu != null) {
                    if(atualizaUsuario == null){
                        atualizaUsuario = new AtualizaUsuario(usu);
                        atualizaUsuario.janelapai = this;
                        atualizaUsuario.setVisible(true);
                        this.setEnabled(false);                
                    } else {
                        atualizaUsuario.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um Usuário");
                    jtf_pesquisa.requestFocus();
                }
                
            }
        
    }  catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
    }
    
    public void retornarJanelaPai(){
        this.setVisible(false);
        if(janelapai != null){
            janelapai.setStatusTela(true);            
        }
    }
}
