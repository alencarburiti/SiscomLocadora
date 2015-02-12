/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EntradaGUI.java
 *
 * Created on 27/05/2011, 15:13:50
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.dao.LancamentoDAO;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FluxodeCaixaDetalhado extends javax.swing.JFrame {

    public TelaPrincipal janelapai;
    public static List<Lancamento> lancamentos;
    public InterfacePool pool;
    public SiscomController controller;

    public FluxodeCaixaDetalhado() {
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
        jb_sair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jl_total = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbl_lancamento_caixa = new javax.swing.JTable();
        jrb_locacao_devolucao = new javax.swing.JRadioButton();
        jrb_venda = new javax.swing.JRadioButton();
        jrb_descontos = new javax.swing.JRadioButton();
        jrb_credito_danificado = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fluxo de Caixa Detalhado");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel1.setName("jPanel1"); // NOI18N

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
                .addGap(380, 380, 380)
                .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(380, 380, 380))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Fluxo Detalhado"));
        jPanel2.setName("jPanel2"); // NOI18N

        jl_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jl_total.setText("Total: ");
        jl_total.setName("jl_total"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jtbl_lancamento_caixa.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_lancamento_caixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente/Dependente", "Tipo Serviço", "Caixa", "Data Lançamento", "Valor", "Usuário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_lancamento_caixa.setName("jtbl_lancamento_caixa"); // NOI18N
        jtbl_lancamento_caixa.getTableHeader().setReorderingAllowed(false);
        jtbl_lancamento_caixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_lancamento_caixaMouseClicked(evt);
            }
        });
        jtbl_lancamento_caixa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_lancamento_caixaKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jtbl_lancamento_caixa);
        if (jtbl_lancamento_caixa.getColumnModel().getColumnCount() > 0) {
            jtbl_lancamento_caixa.getColumnModel().getColumn(0).setPreferredWidth(130);
            jtbl_lancamento_caixa.getColumnModel().getColumn(1).setPreferredWidth(120);
            jtbl_lancamento_caixa.getColumnModel().getColumn(2).setPreferredWidth(10);
            jtbl_lancamento_caixa.getColumnModel().getColumn(3).setPreferredWidth(30);
            jtbl_lancamento_caixa.getColumnModel().getColumn(4).setPreferredWidth(30);
            jtbl_lancamento_caixa.getColumnModel().getColumn(5).setPreferredWidth(20);
        }

        buttonGroup1.add(jrb_locacao_devolucao);
        jrb_locacao_devolucao.setSelected(true);
        jrb_locacao_devolucao.setText("Locação / Devolução");
        jrb_locacao_devolucao.setName("jrb_locacao_devolucao"); // NOI18N
        jrb_locacao_devolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_locacao_devolucaoActionPerformed(evt);
            }
        });
        jrb_locacao_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jrb_locacao_devolucaoKeyPressed(evt);
            }
        });

        buttonGroup1.add(jrb_venda);
        jrb_venda.setText("Venda");
        jrb_venda.setName("jrb_venda"); // NOI18N
        jrb_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_vendaActionPerformed(evt);
            }
        });
        jrb_venda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jrb_vendaKeyPressed(evt);
            }
        });

        buttonGroup1.add(jrb_descontos);
        jrb_descontos.setText("Descontos Concedidos");
        jrb_descontos.setName("jrb_descontos"); // NOI18N
        jrb_descontos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_descontosActionPerformed(evt);
            }
        });
        jrb_descontos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jrb_descontosKeyPressed(evt);
            }
        });

        buttonGroup1.add(jrb_credito_danificado);
        jrb_credito_danificado.setText("Crédito Danificado");
        jrb_credito_danificado.setName("jrb_credito_danificado"); // NOI18N
        jrb_credito_danificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_credito_danificadoActionPerformed(evt);
            }
        });
        jrb_credito_danificado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jrb_credito_danificadoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jrb_locacao_devolucao)
                        .addGap(0, 0, 0)
                        .addComponent(jrb_venda)
                        .addGap(0, 0, 0)
                        .addComponent(jrb_descontos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrb_credito_danificado)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jrb_locacao_devolucao)
                        .addComponent(jrb_venda))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jrb_descontos)
                        .addComponent(jrb_credito_danificado)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jl_total))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscarActionPerformed
        
}//GEN-LAST:event_jb_buscarActionPerformed

    private void jb_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_sairActionPerformed
        setVisible(false);
        janelapai.setStatusTela(true);
}//GEN-LAST:event_jb_sairActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setVisible(false);
        janelapai.setStatusTela(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jtbl_lancamento_caixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_lancamento_caixaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_lancamento_caixaMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        lancamentoCaixa();
    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void jrb_locacao_devolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_locacao_devolucaoActionPerformed
        lancamentoCaixa();        
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_locacao_devolucaoActionPerformed

    private void jrb_vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_vendaActionPerformed
        lancamentoCaixa();        
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_vendaActionPerformed

    private void jrb_locacao_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jrb_locacao_devolucaoKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_locacao_devolucaoKeyPressed

    private void jrb_vendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jrb_vendaKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_vendaKeyPressed

    private void jtbl_lancamento_caixaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_lancamento_caixaKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_lancamento_caixaKeyPressed

    private void jb_sairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_sairKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_sairKeyPressed

    private void jrb_descontosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_descontosActionPerformed
        lancamentoCaixa();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_descontosActionPerformed

    private void jrb_descontosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jrb_descontosKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_descontosKeyPressed

    private void jrb_credito_danificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_credito_danificadoActionPerformed
        lancamentoCaixa();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_credito_danificadoActionPerformed

    private void jrb_credito_danificadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jrb_credito_danificadoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_credito_danificadoKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FluxodeCaixaDetalhado().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jb_sair;
    private javax.swing.JLabel jl_total;
    private javax.swing.JRadioButton jrb_credito_danificado;
    private javax.swing.JRadioButton jrb_descontos;
    private javax.swing.JRadioButton jrb_locacao_devolucao;
    private javax.swing.JRadioButton jrb_venda;
    public static javax.swing.JTable jtbl_lancamento_caixa;
    // End of variables declaration//GEN-END:variables

    public void lancamentoCaixa() {
        pool = new Pool();
        LancamentoDAO lancDAO = new LancamentoDAO(pool);
        if(jrb_locacao_devolucao.isSelected()){
            lancamentos = lancDAO.getLancamentoDetalhadoLocacaoDevolucao();
            mostrarLancamentoCaixa(lancamentos);            
        } else if(jrb_venda.isSelected()){
            lancamentos = lancDAO.getLancamentoDetalhadoVenda();
            mostrarLancamentoCaixa(lancamentos);            
        } else if(jrb_descontos.isSelected()){
            lancamentos = lancDAO.getLancamentoDetalhadoDesconto();
            mostrarLancamentoCaixa(lancamentos);                        
        } else if(jrb_credito_danificado.isSelected()){
            lancamentos = lancDAO.getLancamentoDetalhadoCreditoDanificado();
            mostrarLancamentoCaixa(lancamentos);                        
        } else {
            lancamentos = lancDAO.getLancamentoDetalhadoTodos();
            mostrarLancamentoCaixa(lancamentos);            
        }
    }

    public void mostrarLancamentoCaixa(List<Lancamento> lancamentos) {
        DefaultTableModel tableModel = (DefaultTableModel) jtbl_lancamento_caixa.getModel();
        tableModel.setNumRows(0);

        if (lancamentos.size() == 0) {            
            jl_total.setText("Total: R$ 0,00");
        } else {
            Double valor_total =0.00;
            Moeda moeda = new Moeda();
            for (int i = 0; i < lancamentos.size(); i++) {

                String valor = null;

                valor = String.valueOf(lancamentos.get(i).getValor_total());


                valor = moeda.setPrecoFormat(valor);
                valor_total = valor_total + moeda.getPrecoFormato(valor);
                SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

                String data_lancamento = null;
                try {
                    data_lancamento = out.format(in.parse(lancamentos.get(i).getData_lancamento().toString()));
                } catch (ParseException ex) {
                    Logger.getLogger(FluxodeCaixaDetalhado.class.getName()).log(Level.SEVERE, null, ex);
                }

                DefaultTableModel row = (DefaultTableModel) jtbl_lancamento_caixa.getModel();
//                ItemDbGrid hashDbGrid = new ItemDbGrid(diaria, diaria.getNome_diaria());
                row.addRow(new Object[]{lancamentos.get(i).getDependente().getNome_dependente(), lancamentos.get(i).getTipoServico().getDescricao(),
                    lancamentos.get(i).getCaixa(), data_lancamento, valor, lancamentos.get(i).getUsuario().getNome_usuario()});
            
            }
            jl_total.setText("Total: "+moeda.setPrecoFormat(valor_total.toString()));

        }
    }

    public void statusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }
    
    public void acionarAtalho(java.awt.event.KeyEvent evt) {        
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            retornarJanelaPai();
        }
    }
    
    public void retornarJanelaPai(){
        this.setVisible(false);
        if(janelapai != null){
            janelapai.setStatusTela(true);
        }
    }
}