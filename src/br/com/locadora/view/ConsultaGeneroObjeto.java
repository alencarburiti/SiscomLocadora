/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConsultarProdutoGUI.java
 *
 * Created on 02/06/2011, 03:08:41
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Genero;
import br.com.locadora.model.dao.GeneroDAO;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.TemaInterface;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALENCAR
 */
public class ConsultaGeneroObjeto extends javax.swing.JFrame {

    public CadastraAlteraObjeto janelapai;
    public AcessoUsuario acesso;

    public ConsultaGeneroObjeto() {
        initComponents();
        TemaInterface.getInterface(this);
        janelapai = null;        
    }
    List<Genero> generos;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_genero = new javax.swing.JTable();
        jtf_consulta = new javax.swing.JTextField();
        jb_buscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jb_ok = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jb_novo1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Gênero");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Gênero"));
        jPanel1.setName("jPanel1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jtbl_genero.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_genero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_genero.setName("jtbl_genero"); // NOI18N
        jtbl_genero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_generoMouseClicked(evt);
            }
        });
        jtbl_genero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_generoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbl_genero);
        if (jtbl_genero.getColumnModel().getColumnCount() > 0) {
            jtbl_genero.getColumnModel().getColumn(0).setResizable(false);
            jtbl_genero.getColumnModel().getColumn(0).setPreferredWidth(15);
            jtbl_genero.getColumnModel().getColumn(1).setResizable(false);
            jtbl_genero.getColumnModel().getColumn(1).setPreferredWidth(150);
        }

        jtf_consulta.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_consulta.setName("jtf_consulta"); // NOI18N
        jtf_consulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_consultaKeyPressed(evt);
            }
        });

        jb_buscar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jb_buscar.setName("jb_buscar"); // NOI18N
        jb_buscar.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_buscarActionPerformed1(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel1.setText("Parâmetro");
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtf_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jb_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel2.setName("jPanel2"); // NOI18N

        jb_ok.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/finalizar.png"))); // NOI18N
        jb_ok.setText("OK");
        jb_ok.setName("jb_ok"); // NOI18N
        jb_ok.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_okActionPerformed(evt);
            }
        });

        jb_cancelar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/sair.png"))); // NOI18N
        jb_cancelar.setText("Sair");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });

        jb_novo1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_novo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/novo_registro.png"))); // NOI18N
        jb_novo1.setText("Novo");
        jb_novo1.setName("jb_novo1"); // NOI18N
        jb_novo1.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_novo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_novo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jb_novo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_ok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_novo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_ok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        setVisible(false);
        if ((janelapai != null)) {
            janelapai.setEnabled(true);
            janelapai.setVisible(true);
            //telaCadastroObjeto.setStatusTela(false);
        }

}//GEN-LAST:event_jb_cancelarActionPerformed


    private void jb_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_okActionPerformed
        if (jtbl_genero.getSelectedRow() != 1) {
            botaoOK(jtbl_genero);
        }
}//GEN-LAST:event_jb_okActionPerformed
    public void botaoOK(JTable tb) {
        if (tb.getSelectedRow() != -1) {
            setVisible(false);
            Genero genero = tbGeneroLinhaSelecionada(jtbl_genero);
            if ((janelapai != null) && (genero != null)) {
                janelapai.setStatusTela(true);
                janelapai.carregaGenero(genero);
                janelapai.consultaGenero = null;
            } 
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Gênero");
        }
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornaJanelaPai();

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jb_novo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_novo1ActionPerformed
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuGenero");
        try {
            if (acesso.getEscrever() == true) {
                CadastraAlteraGenero cadastroGenero = new CadastraAlteraGenero();
                cadastroGenero.janelapai2 = this;
                cadastroGenero.setVisible(true);
                setStatusTela(false);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }

        // TODO add your handling code here:
}//GEN-LAST:event_jb_novo1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtbl_genero.requestFocus();
        jtbl_genero.setSelectionMode(1);
    }//GEN-LAST:event_formWindowOpened

private void jtbl_generoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_generoKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        botaoOK(jtbl_genero);
    }
    if (evt.getKeyCode() == KeyEvent.VK_F5) {
        jtf_consulta.requestFocus();
    }
    if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
        retornaJanelaPai();
    }

    // TODO add your handling code here:
}//GEN-LAST:event_jtbl_generoKeyPressed

    private void jb_buscarActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed1
        listaGenero();
    }//GEN-LAST:event_jb_buscarActionPerformed1

    private void jtf_consultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_consultaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            listaGenero();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            jtf_consulta.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            retornaJanelaPai();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_consultaKeyPressed

    private void jtbl_generoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_generoMouseClicked
        if (evt.getClickCount() > 1) {
            botaoOK(jtbl_genero);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_generoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ConsultaGeneroObjeto().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_buscar;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_novo1;
    private javax.swing.JButton jb_ok;
    private javax.swing.JTable jtbl_genero;
    private javax.swing.JTextField jtf_consulta;
    // End of variables declaration//GEN-END:variables

    public void setCadastro() {
        jb_novo1.setEnabled(false);
    }

    public Genero tbGeneroLinhaSelecionada(JTable tb) {
        Genero genero = null;
        if (tb.getSelectedRow() != -1) {
            genero = new Genero();
            genero.setCodigo_genero(generos.get(tb.getSelectedRow()).getCodigo_genero());
            genero.setNome_genero(generos.get(tb.getSelectedRow()).getNome_genero());
        }
        return genero;
    }
    private InterfacePool pool;

    public void listaGenero() {
        try {
            pool = new Pool();
            GeneroDAO generoDAO = new GeneroDAO(pool);
            generos = generoDAO.getGeneros("%" + jtf_consulta.getText().trim() + "%");
            mostraGenero(generos);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaGeneroObjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listaTodasGeneros() {
        pool = new Pool();
        GeneroDAO generoDAO = new GeneroDAO(pool);
        generos = generoDAO.getTodasGeneros();
        mostraGenero(generos);
    }

    public void mostraGenero(List<Genero> generos) {
        ((DefaultTableModel) jtbl_genero.getModel()).setRowCount(0);
        jtbl_genero.updateUI();

        if (generos.size() == 0) {
            JOptionPane.showMessageDialog(this, "Nenhum Gênero encontrado");

        } else {
            for (int i = 0; i < generos.size(); i++) {
                Genero genero = new Genero();
                genero.setCodigo_genero(generos.get(i).getCodigo_genero());
                genero.setNome_genero(generos.get(i).getNome_genero());

                DefaultTableModel row = (DefaultTableModel) jtbl_genero.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(genero, genero.getNome_genero());
                row.addRow(new Object[]{genero.getCodigo_genero(), hashDbGrid});
            }
            jtbl_genero.requestFocus();
            jtbl_genero.setSelectionMode(1);
        }
    }

    public void setStatusTela(boolean status) {

        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);

    }
    private void retornaJanelaPai() {
        setVisible(false);
        if (janelapai != null) {
            janelapai.setStatusTela(true);            
        } 
    }
}