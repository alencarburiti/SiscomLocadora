package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.LogInfo;
import br.com.locadora.model.bean.Produto;
import br.com.locadora.model.dao.LogInfoDAO;
import br.com.locadora.model.dao.ProdutoDAO;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
import static br.com.locadora.view.MenuObjeto.jtbl_objeto;
import static br.com.locadora.view.MenuObjeto.objetos;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alencar
 */
public class MenuProduto extends javax.swing.JFrame {

    public TelaPrincipal janelapai;
    public AcessoUsuario acesso;
    public InterfacePool pool;
    public CadastraAlteraProduto cadastraAlteraProduto;
    public ProdutoDAO produtoDAO;
    public List<Produto> produtos;
    public Produto produto;
    public Moeda moeda;

    /**
     * Creates new form Cad_Fornecedor
     */
    public MenuProduto() {
        initComponents();
        TemaInterface.getInterface(this);
        janelapai = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_codigo = new java.awt.TextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_pesquisa = new javax.swing.JTextField();
        jb_pesquisa = new javax.swing.JButton();
        jrb_codigo = new javax.swing.JRadioButton();
        jrb_nome_produto = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_produto = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jb_novo = new javax.swing.JButton();
        jb_alterar = new javax.swing.JButton();
        jb_excluir = new javax.swing.JButton();
        jb_sair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        tf_codigo.setName("tf_codigo"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de Produtos");
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

        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Produto"));
        jPanel5.setName("jPanel5"); // NOI18N
        jPanel5.setPreferredSize(new java.awt.Dimension(350, 90));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel1.setText("Parâmetro");
        jLabel1.setName("jLabel1"); // NOI18N

        jtf_pesquisa.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jtf_pesquisa.setName("jtf_pesquisa"); // NOI18N
        jtf_pesquisa.setPreferredSize(new java.awt.Dimension(300, 24));
        jtf_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_pesquisaKeyPressed(evt);
            }
        });

        jb_pesquisa.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
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

        buttonGroup2.add(jrb_codigo);
        jrb_codigo.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_codigo.setText("Código");
        jrb_codigo.setName("jrb_codigo"); // NOI18N
        jrb_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_codigoActionPerformed(evt);
            }
        });

        buttonGroup2.add(jrb_nome_produto);
        jrb_nome_produto.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_nome_produto.setSelected(true);
        jrb_nome_produto.setText("Descrição");
        jrb_nome_produto.setName("jrb_nome_produto"); // NOI18N
        jrb_nome_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_nome_produtoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jrb_nome_produto)
                        .addGap(0, 0, 0)
                        .addComponent(jrb_codigo))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jtf_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrb_nome_produto)
                    .addComponent(jrb_codigo))
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_pesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_pesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jtbl_produto.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_produto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Produto", "Código de Barras", "Preço Compra", "Preço Venda"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_produto.setName("jtbl_produto"); // NOI18N
        jtbl_produto.getTableHeader().setReorderingAllowed(false);
        jtbl_produto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_produtoMouseClicked(evt);
            }
        });
        jtbl_produto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_produtoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbl_produto);
        if (jtbl_produto.getColumnModel().getColumnCount() > 0) {
            jtbl_produto.getColumnModel().getColumn(0).setPreferredWidth(30);
            jtbl_produto.getColumnModel().getColumn(1).setPreferredWidth(200);
            jtbl_produto.getColumnModel().getColumn(2).setPreferredWidth(80);
            jtbl_produto.getColumnModel().getColumn(3).setPreferredWidth(50);
            jtbl_produto.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

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
                .addGap(150, 150, 150)
                .addComponent(jb_novo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))
                        .addGap(10, 10, 10)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        getAccessibleContext().setAccessibleParent(this);

        setSize(new java.awt.Dimension(754, 400));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_pesquisa.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void jb_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_pesquisaActionPerformed
        consultarProduto();
    }//GEN-LAST:event_jb_pesquisaActionPerformed

    private void jb_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_novoActionPerformed

        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        AcessoUsuario acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuProduto");
        try {
            if (acesso.getEscrever() == true) {
                if (cadastraAlteraProduto == null) {
                    cadastraAlteraProduto = new CadastraAlteraProduto();
                    cadastraAlteraProduto.janelapai = this;
                    cadastraAlteraProduto.setVisible(true);
                    setStatusTela(false);
                    cadastraAlteraProduto.setTitle("Cadastrando Produto");
                    cadastraAlteraProduto.acesso = acesso;
                } else {
                    cadastraAlteraProduto.setVisible(true);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }


}//GEN-LAST:event_jb_novoActionPerformed

    private void jb_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_alterarActionPerformed
        alterar();
        // TODO add your handling code here:
}//GEN-LAST:event_jb_alterarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornarJanelaPai();
    }//GEN-LAST:event_formWindowClosed

    private void jb_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_excluirActionPerformed
        excluirProduto();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_excluirActionPerformed

    private void jtf_pesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_pesquisaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_pesquisa.doClick();
        }
        acionarAtalho(evt);
    }//GEN-LAST:event_jtf_pesquisaKeyPressed

    private void jtbl_produtoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_produtoMouseClicked
        if (evt.getClickCount() > 1) {
            jb_alterar.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_produtoMouseClicked

    private void jtbl_produtoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_produtoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_alterar.doClick();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_produtoKeyPressed

    private void jb_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_sairActionPerformed
        retornarJanelaPai();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_sairActionPerformed

    private void jb_sairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_sairKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_sairKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void jb_pesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_pesquisaKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_pesquisa.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_pesquisaKeyPressed

    private void jrb_nome_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_nome_produtoActionPerformed
        jtf_pesquisa.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_nome_produtoActionPerformed

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
                new MenuProduto().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_alterar;
    private javax.swing.JButton jb_excluir;
    private javax.swing.JButton jb_novo;
    private javax.swing.JButton jb_pesquisa;
    private javax.swing.JButton jb_sair;
    private javax.swing.JRadioButton jrb_codigo;
    private javax.swing.JRadioButton jrb_nome_produto;
    private javax.swing.JTable jtbl_produto;
    private javax.swing.JTextField jtf_pesquisa;
    private java.awt.TextField tf_codigo;
    // End of variables declaration//GEN-END:variables

    public void consultarProduto() {
        if (jrb_codigo.isSelected() == true) {
            getProdutoCodigo();
        } else {
            getProdutoNome();
        }
    }

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    public void retornarJanelaPai() {
        this.setVisible(false);
        if (janelapai != null) {
            janelapai.setStatusTela(true);
        }
    }

    private void getProdutoCodigo() {
        pool = new Pool();
        produtoDAO = new ProdutoDAO(pool);
        produtos = produtoDAO.getProdutoCodigo(Integer.parseInt(jtf_pesquisa.getText()));
        mostrarProdutos(produtos);
    }

    public void getProdutoNome() {
        pool = new Pool();
        produtoDAO = new ProdutoDAO(pool);
        produtos = produtoDAO.getProdutoNome(jtf_pesquisa.getText());
        mostrarProdutos(produtos);
    }

    private void mostrarProdutos(List<Produto> produtos) {
        DefaultTableModel tableModel = (DefaultTableModel) jtbl_produto.getModel();
        tableModel.setNumRows(0);

        if (produtos.size() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum Produto encontrado");

        } else {
            moeda = new Moeda();
            for (int i = 0; i < produtos.size(); i++) {

                DefaultTableModel row = (DefaultTableModel) jtbl_produto.getModel();
                row.addRow(new Object[]{produtos.get(i).getCodigo_produto(), produtos.get(i).getNome_produto(),
                    produtos.get(i).getCodigo_barras(), moeda.setPrecoFormat(produtos.get(i).getPreco_compra().toString()),
                    moeda.setPrecoFormat(produtos.get(i).getPreco_venda().toString())});
            }
            jtbl_produto.requestFocus();
            jtbl_produto.setSelectionMode(1);
        }

    }

    public Produto tbProdutoLinhaSelecionada(JTable tb) {

        if (tb.getSelectedRow() != -1) {
            produto = new Produto();
            produto = produtos.get(tb.getSelectedRow());
        } else {
            produto = null;
        }
        return produto;
    }

    public void alterar() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        AcessoUsuario acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuProduto");
        try {
            if (acesso.getEscrever() == true) {
                Produto prod = tbProdutoLinhaSelecionada(jtbl_produto);
                if (prod != null) {
                    if (cadastraAlteraProduto == null) {
                        cadastraAlteraProduto = new CadastraAlteraProduto(prod);
                        cadastraAlteraProduto.janelapai = this;
                        cadastraAlteraProduto.setVisible(true);
                        setStatusTela(false);
                        cadastraAlteraProduto.setTitle("Alterando Produto");
                        cadastraAlteraProduto.acesso = acesso;
                    } else {
                        cadastraAlteraProduto.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um Produto");
                    jtf_pesquisa.requestFocus();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
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

    private void excluirProduto() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuProduto");

        try {
            if (acesso.getDeletar() == true) {
                DefaultTableModel row = (DefaultTableModel) jtbl_produto.getModel();
                if (jtbl_produto.getSelectedRow() != -1) {
                    int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_NO_OPTION) {
                        pool = new Pool();
                        produtoDAO = new ProdutoDAO(pool);
                        produto = produtos.get(jtbl_produto.getSelectedRow());                        

                        try {
                            produtoDAO.excluir(produto.getCodigo_produto());
                            row.removeRow(jtbl_produto.getSelectedRow());
                            
                            LogInfo logInfo = new LogInfo();
                            logInfo.setDescricao("Excluir Produto -> " + produto.getNome_produto());
                            logInfo.setUsuario(acesso.getUsuario());
                            pool = new Pool();
                            LogInfoDAO logInfoDAO = new LogInfoDAO(pool);
                            logInfoDAO.salvar(logInfo);                                                
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um Produto");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
    }
}