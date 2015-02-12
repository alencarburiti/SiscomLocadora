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
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.dao.ClienteDAO;
import br.com.locadora.model.dao.LocacaoDAO;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class LocacaoEmAberto extends javax.swing.JFrame {

    public TelaPrincipal janelapai;
    public List<ItemLocacao> itens;
    public Copia copia;
    public InterfacePool pool;
    public SiscomController controller;
    public static List<ItemLocacao> itensDevolucao;
    public LocacaoDAO locacaoDAO;
    public CadastraAlteraCliente cadastraAlteraCliente;

    public LocacaoEmAberto() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jtf_consulta = new javax.swing.JTextField();
        jb_buscar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtbl_locacao_aberto = new javax.swing.JTable();
        jrb_ator = new javax.swing.JRadioButton();
        jrb_codigo_barras = new javax.swing.JRadioButton();
        jrb_codigo = new javax.swing.JRadioButton();
        jrb_titulo = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jb_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta locação em Aberto");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Objeto"));
        jPanel1.setName("jPanel1"); // NOI18N

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

        jScrollPane6.setName("jScrollPane6"); // NOI18N

        jtbl_locacao_aberto.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_locacao_aberto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Barras", "Cliente/Dependente", "Objeto", "Data Locação", "Data Prevista", "Valor Multa", "Dia atraso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_locacao_aberto.setName("jtbl_locacao_aberto"); // NOI18N
        jtbl_locacao_aberto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_locacao_abertoMouseClicked(evt);
            }
        });
        jtbl_locacao_aberto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_locacao_abertoKeyPressed(evt);
            }
        });
        jScrollPane6.setViewportView(jtbl_locacao_aberto);
        if (jtbl_locacao_aberto.getColumnModel().getColumnCount() > 0) {
            jtbl_locacao_aberto.getColumnModel().getColumn(0).setPreferredWidth(20);
            jtbl_locacao_aberto.getColumnModel().getColumn(1).setPreferredWidth(100);
            jtbl_locacao_aberto.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtbl_locacao_aberto.getColumnModel().getColumn(3).setPreferredWidth(30);
            jtbl_locacao_aberto.getColumnModel().getColumn(4).setPreferredWidth(20);
            jtbl_locacao_aberto.getColumnModel().getColumn(5).setPreferredWidth(20);
            jtbl_locacao_aberto.getColumnModel().getColumn(6).setPreferredWidth(20);
        }

        buttonGroup1.add(jrb_ator);
        jrb_ator.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_ator.setText("Ator");
        jrb_ator.setName("jrb_ator"); // NOI18N
        jrb_ator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_atorActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrb_codigo_barras);
        jrb_codigo_barras.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_codigo_barras.setText("Código de Barras");
        jrb_codigo_barras.setName("jrb_codigo_barras"); // NOI18N
        jrb_codigo_barras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_codigo_barrasActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrb_codigo);
        jrb_codigo.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_codigo.setText("Código Objeto");
        jrb_codigo.setName("jrb_codigo"); // NOI18N
        jrb_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_codigoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrb_titulo);
        jrb_titulo.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_titulo.setSelected(true);
        jrb_titulo.setText("Título");
        jrb_titulo.setName("jrb_titulo"); // NOI18N
        jrb_titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_tituloActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel1.setText("Parâmetro");
        jLabel1.setName("jLabel1"); // NOI18N

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/cliente.png"))); // NOI18N
        jButton1.setText("Verificar Cliente");
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 941, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jrb_titulo)
                        .addGap(0, 0, 0)
                        .addComponent(jrb_ator)
                        .addGap(0, 0, 0)
                        .addComponent(jrb_codigo_barras)
                        .addGap(0, 0, 0)
                        .addComponent(jrb_codigo))
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtf_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrb_titulo)
                    .addComponent(jrb_ator)
                    .addComponent(jrb_codigo_barras)
                    .addComponent(jrb_codigo))
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtf_consulta, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jb_buscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel2.setName("jPanel2"); // NOI18N

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(430, 430, 430)
                .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(420, 420, 420))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    public void botaoOK(JTable tb) {
        if (tb.getSelectedRow() != -1) {
            ItemLocacao itemLinha = tbItemLocacaoLinhaSelecionada(jtbl_locacao_aberto);
            setVisible(false);
            if ((janelapai != null) && (itemLinha != null)) {                
            janelapai.setStatusTela(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Copia");
        }
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
            if (janelapai != null){
            janelapai.setStatusTela(true);
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_consulta.requestFocus();

    }//GEN-LAST:event_formWindowOpened

    private void jb_buscarActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed1
        try {
            if (jrb_codigo.isSelected() == true) {
                if (jtf_consulta.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Informe um código");
                } else {
                    listaCopia_codigo_objeto(Integer.parseInt(jtf_consulta.getText().trim()));
                }
            } else if (jrb_titulo.isSelected() == true) {
                listaCopia_titulo(jtf_consulta.getText().trim());
            } else if (jrb_codigo_barras.isSelected() == true) {
                listaCopia_codigo_barras(jtf_consulta.getText().trim());
            } else {
                listaCopia_ator(jtf_consulta.getText().trim());
            }
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoEmAberto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jb_buscarActionPerformed1

    private void jrb_codigo_barrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_codigo_barrasActionPerformed
        jtf_consulta.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_codigo_barrasActionPerformed

    private void jrb_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_codigoActionPerformed
        jtf_consulta.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_codigoActionPerformed

    private void jrb_tituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_tituloActionPerformed
        jtf_consulta.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_tituloActionPerformed

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowDeactivated

    private void jtf_consultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_consultaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            try {
                if (jrb_codigo.isSelected() == true) {
                    if (jtf_consulta.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Informe um código");
                    } else {
                        listaCopia_codigo_objeto(Integer.parseInt(jtf_consulta.getText().trim()));
                    }
                } else if (jrb_titulo.isSelected() == true) {
                    listaCopia_titulo(jtf_consulta.getText().trim());
                } else if (jrb_codigo_barras.isSelected() == true) {
                    listaCopia_codigo_barras(jtf_consulta.getText().trim());
                } else {
                    listaCopia_ator(jtf_consulta.getText().trim());
                }
            } catch (SQLException ex) {
                Logger.getLogger(LocacaoEmAberto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_consultaKeyPressed

    private void jtbl_locacao_abertoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_locacao_abertoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            jtf_consulta.requestFocus();
        }
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            verificarCliente();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_locacao_abertoKeyPressed

    private void jrb_atorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_atorActionPerformed
        jtf_consulta.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_atorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        verificarCliente();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtbl_locacao_abertoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_locacao_abertoMouseClicked
        if(evt.getClickCount() > 1){
            verificarCliente();
        }
            // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_locacao_abertoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new LocacaoEmAberto().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton jb_buscar;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JRadioButton jrb_ator;
    private javax.swing.JRadioButton jrb_codigo;
    private javax.swing.JRadioButton jrb_codigo_barras;
    private javax.swing.JRadioButton jrb_titulo;
    public static javax.swing.JTable jtbl_locacao_aberto;
    private javax.swing.JTextField jtf_consulta;
    // End of variables declaration//GEN-END:variables

    public ItemLocacao tbItemLocacaoLinhaSelecionada(JTable tb) {
        ItemLocacao itemSelecionada = null;
        if (tb.getSelectedRow() != -1) {
            itemSelecionada = new ItemLocacao();

            itemSelecionada.setCodigo_item_locacao(itensDevolucao.get(tb.getSelectedRow()).getCodigo_item_locacao());
            itemSelecionada.setValor_multa(itensDevolucao.get(tb.getSelectedRow()).getValor_multa());
            itemSelecionada.setDias_multa(itensDevolucao.get(tb.getSelectedRow()).getDias_multa());
            itemSelecionada.setData_locacao(itensDevolucao.get(tb.getSelectedRow()).getData_locacao());
            itemSelecionada.setValor_locado(itensDevolucao.get(tb.getSelectedRow()).getValor_locado());
            itemSelecionada.setValor_pago(itensDevolucao.get(tb.getSelectedRow()).getValor_pago());

            Diaria diaria = new Diaria();
            diaria.setDias(itensDevolucao.get(tb.getSelectedRow()).getCopia().getDiaria().getDias());
            diaria.setCodigo_diaria(itensDevolucao.get(tb.getSelectedRow()).getCopia().getDiaria().getCodigo_diaria());

            Objeto objeto = new Objeto();
            objeto.setTitulo(itensDevolucao.get(tb.getSelectedRow()).getCopia().getObjeto().getTitulo());

            Copia copia = new Copia();
            copia.setDiaria(diaria);
            copia.setObjeto(objeto);
            copia.setCodigo_copia(itensDevolucao.get(tb.getSelectedRow()).getCopia().getCodigo_copia());
            copia.setCodigo_barras(itensDevolucao.get(tb.getSelectedRow()).getCopia().getCodigo_barras());

            itemSelecionada.setCopia(copia);

        }
        return itemSelecionada;
    }

    public void listaCopia_codigo_objeto(Integer codigo_objeto) throws SQLException {
        pool = new Pool();
        locacaoDAO = new LocacaoDAO(pool);
        itens = null;
        itens = locacaoDAO.getCopiaCodigoObjeto(codigo_objeto);
        mostrar_locacoes(itens);
    }

    public void listaCopia_titulo(String titulo) {
        pool = new Pool();
        locacaoDAO = new LocacaoDAO(pool);
        itens = null;
        itens = locacaoDAO.getCopiaDevolucaoTitulo(titulo,0);
        mostrar_locacoes(itens);
    }

    public void listaCopia_ator(String ator) {
        pool = new Pool();
        locacaoDAO = new LocacaoDAO(pool);
        itens = null;
        itens = locacaoDAO.getCopiaDevolucaoAtor(ator,0);
        mostrar_locacoes(itens);
    }

    public void listaCopia_codigo_barras(String codigo_barras) {
        pool = new Pool();
        locacaoDAO = new LocacaoDAO(pool);
        itens = null;
        itens = locacaoDAO.getCopiaDevolucaoCodigoBarras(codigo_barras,0);
        mostrar_locacoes(itens);
    }

    public void mostrar_locacoes(List<ItemLocacao> itemLocacoes) {

        try {
            DefaultTableModel tableModel = (DefaultTableModel) LocacaoEmAberto.jtbl_locacao_aberto.getModel();
            tableModel.setNumRows(0);

            if (itemLocacoes.size() == 0) {
                JOptionPane.showMessageDialog(null, "Objeto não encontrado");
                jtf_consulta.requestFocus();
            } else {

                for (int i = 0; i < itemLocacoes.size(); i++) {

                    ItemLocacao itemLocacao = new ItemLocacao();
                    itemLocacao.setCodigo_item_locacao(itemLocacoes.get(i).getCodigo_item_locacao());

                    itemLocacao.setValor_multa(itemLocacoes.get(i).getValor_multa());
                    itemLocacao.setDias_multa(itemLocacoes.get(i).getDias_multa());
                    itemLocacao.setData_locacao(itemLocacoes.get(i).getData_locacao());
                    itemLocacao.setData_devolucao(itemLocacoes.get(i).getData_devolucao());
                    itemLocacao.setDependente(itemLocacoes.get(i).getDependente());
                    
                    Diaria diaria = new Diaria();
                    diaria.setDias(itemLocacoes.get(i).getCopia().getDiaria().getDias());

                    Objeto objeto = new Objeto();
                    objeto.setTitulo(itemLocacoes.get(i).getCopia().getObjeto().getTitulo());

                    Copia copia = new Copia();
                    copia.setDiaria(diaria);
                    copia.setObjeto(objeto);
                    copia.setCodigo_barras(itemLocacoes.get(i).getCopia().getCodigo_barras());

                    itemLocacao.setCopia(copia);
                    SimpleDateFormat df_data_hora_locada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

                    String data_prevista = out.format(in.parse(itemLocacoes.get(i).getData_prevista().toString()));

                    Moeda moeda = new Moeda();

                    DefaultTableModel row = (DefaultTableModel) LocacaoEmAberto.jtbl_locacao_aberto.getModel();
                    ItemDbGrid hashDbGrid = new ItemDbGrid(itemLocacao, itemLocacao.getCopia().getObjeto().getTitulo());
                    row.addRow(new Object[]{itemLocacao.getCopia().getCodigo_barras(), itemLocacao.getDependente().getNome_dependente(), 
                        hashDbGrid, df_data_hora_locada.format(itemLocacao.getData_locacao()), data_prevista,
                        moeda.setPrecoFormat(String.valueOf(itemLocacao.getValor_multa())), itemLocacao.getDias_multa()});

                }
                LocacaoEmAberto.itensDevolucao = itemLocacoes;
                jtbl_locacao_aberto.requestFocus();
                jtbl_locacao_aberto.setSelectionMode(1);
            }
        } catch (ParseException ex) {
            Logger.getLogger(LocacaoEmAberto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            botaoOK(jtbl_locacao_aberto);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setVisible(false);
            janelapai.setStatusTela(true);
        }
    }
    
    public void verificarCliente() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        AcessoUsuario acesso;
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.Locadora.view.MenuCliente");
        try {
            System.out.println("Escrever: " + acesso.getEscrever());
            if (acesso.getEscrever() == true) {
                if(jtbl_locacao_aberto.getSelectedRow() != -1){
                    pool = new Pool();
                    ClienteDAO clienteDAO = new ClienteDAO(pool);
                    Cliente cliente = clienteDAO.getCliente_codigo(itensDevolucao.get(jtbl_locacao_aberto.getSelectedRow()).getDependente().getCliente().getCodigo_cliente()).get(0);

                    if (cliente != null) {
                        if(cadastraAlteraCliente == null ){
                            cadastraAlteraCliente = new CadastraAlteraCliente(cliente);
                            cadastraAlteraCliente.janelapai3 = this;
                            cadastraAlteraCliente.setVisible(true);
                            setEnabled(false);
                        } else {
                            cadastraAlteraCliente.setVisible(true);
                        }
                    }
                }
                 else {
                    JOptionPane.showMessageDialog(null, "Selecione um cliente");
                    jtf_consulta.requestFocus();                    
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
    }
    
    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }
}