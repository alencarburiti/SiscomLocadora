package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.Combo;
import br.com.locadora.model.bean.Feriado;
import br.com.locadora.model.bean.OcorrenciaDanificado;
import br.com.locadora.model.bean.PromocaoLocacao;
import br.com.locadora.model.dao.CopiaDAO;
import br.com.locadora.model.dao.DiariaDAO;
import br.com.locadora.model.dao.ComboDAO;
import br.com.locadora.model.dao.OcorrenciaDanificadoDAO;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConsultarOcorrencia extends javax.swing.JFrame {

    public InterfacePool pool;
    public TelaPrincipal janelapai;
    public Moeda moeda;
    public AcessoUsuario acesso;
    public OcorrenciaDanificado ocorrenciaDanificado;
    public List<OcorrenciaDanificado> ocorrencias;
    public OcorrenciaDanificadoDAO ocorrenciaDanificadoDAO;

    public ConsultarOcorrencia() {
        initComponents();
        TemaInterface.getInterface(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jtf_pesquisa = new javax.swing.JTextField();
        jb_pesquisa = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_ocorrencia = new javax.swing.JTable();
        jrb_objeto = new javax.swing.JRadioButton();
        jrb_cliente_dependente = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jb_sair = new javax.swing.JButton();

        jDesktopPane1.setName("jDesktopPane1"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Ocorrências Danificado");
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

        jDesktopPane2.setName("jDesktopPane2"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta Ocorrência"));
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel10.setText("Parâmetro");
        jLabel10.setName("jLabel10"); // NOI18N
        jLabel10.setPreferredSize(new java.awt.Dimension(300, 18));

        jtf_pesquisa.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_pesquisa.setName("jtf_pesquisa"); // NOI18N
        jtf_pesquisa.setPreferredSize(new java.awt.Dimension(300, 24));
        jtf_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_pesquisaKeyPressed(evt);
            }
        });

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

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jtbl_ocorrencia.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_ocorrencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód. Ocorrência", "Título", "Cliente/Dependente", "Data Ocorrência", "Observação", "Usuário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jtbl_ocorrencia.setName("jtbl_ocorrencia"); // NOI18N
        jtbl_ocorrencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_ocorrenciaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbl_ocorrencia);
        if (jtbl_ocorrencia.getColumnModel().getColumnCount() > 0) {
            jtbl_ocorrencia.getColumnModel().getColumn(0).setPreferredWidth(20);
            jtbl_ocorrencia.getColumnModel().getColumn(1).setPreferredWidth(100);
            jtbl_ocorrencia.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtbl_ocorrencia.getColumnModel().getColumn(3).setPreferredWidth(30);
            jtbl_ocorrencia.getColumnModel().getColumn(4).setPreferredWidth(150);
            jtbl_ocorrencia.getColumnModel().getColumn(5).setPreferredWidth(40);
        }

        buttonGroup1.add(jrb_objeto);
        jrb_objeto.setSelected(true);
        jrb_objeto.setText("Objeto");
        jrb_objeto.setName("jrb_objeto"); // NOI18N

        buttonGroup1.add(jrb_cliente_dependente);
        jrb_cliente_dependente.setText("Cliente/Dependente");
        jrb_cliente_dependente.setName("jrb_cliente_dependente"); // NOI18N
        jrb_cliente_dependente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_cliente_dependenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jrb_objeto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrb_cliente_dependente)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrb_objeto)
                    .addComponent(jrb_cliente_dependente))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jb_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jtf_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel2.setName("jPanel2"); // NOI18N

        jb_sair.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/sair.png"))); // NOI18N
        jb_sair.setText("Sair");
        jb_sair.setMaximumSize(new java.awt.Dimension(101, 33));
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(400, 400, 400))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_pesquisa.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        acionarAtalho(evt);
    }//GEN-LAST:event_formKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornaJanelaPai();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

private void jb_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_pesquisaActionPerformed
    consultarOcorrencias();
}//GEN-LAST:event_jb_pesquisaActionPerformed

private void jtf_pesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_pesquisaKeyPressed
    acionarAtalho(evt);
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jb_pesquisa.doClick();
    }
    if (evt.getKeyCode() == KeyEvent.VK_F5) {
        jb_pesquisa.doClick();
    }
}//GEN-LAST:event_jtf_pesquisaKeyPressed

    private void jb_pesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_pesquisaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_pesquisa.doClick();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_pesquisaKeyPressed

    private void jtbl_ocorrenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_ocorrenciaKeyPressed
        acionarAtalho(evt);
// TODO add your handling code here:
    }//GEN-LAST:event_jtbl_ocorrenciaKeyPressed

    private void jb_sairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_sairKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_sair.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_sairKeyPressed

    private void jb_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_sairActionPerformed
        retornaJanelaPai();
    }//GEN-LAST:event_jb_sairActionPerformed

    private void jrb_cliente_dependenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_cliente_dependenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_cliente_dependenteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ConsultarOcorrencia().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_pesquisa;
    private javax.swing.JButton jb_sair;
    private javax.swing.JRadioButton jrb_cliente_dependente;
    private javax.swing.JRadioButton jrb_objeto;
    public static javax.swing.JTable jtbl_ocorrencia;
    public static javax.swing.JTextField jtf_pesquisa;
    // End of variables declaration//GEN-END:variables

    public void consultarOcorrencias() {
        pool = new Pool();
        ocorrencias = new ArrayList<>();
        ocorrenciaDanificadoDAO = new OcorrenciaDanificadoDAO(pool);
        if (jrb_objeto.isSelected()) {
            ocorrencias = ocorrenciaDanificadoDAO.getOcorrenciaObjeto(jtf_pesquisa.getText());
            mostrarOcorrencias(ocorrencias);
        } else if (jrb_cliente_dependente.isSelected()) {
            ocorrencias = ocorrenciaDanificadoDAO.getOcorrenciaCliente(jtf_pesquisa.getText());
            mostrarOcorrencias(ocorrencias);
        }
    }

    public void mostrarOcorrencias(List<OcorrenciaDanificado> ocorrencias) {
        if (ocorrencias.size() > 0) {
            for (int i = 0; i < ocorrencias.size(); i++) {
                SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
                String data_ocorrencia = "";
                try {
                    data_ocorrencia = out.format(in.parse(ocorrencias.get(i).getData_ocorrencia().toString()));
                } catch (ParseException ex) {

                }

                DefaultTableModel row = (DefaultTableModel) jtbl_ocorrencia.getModel();
                row.addRow(new Object[]{ocorrencias.get(i).getCodigo_ocorrencia_danificado(),
                    ocorrencias.get(i).getCopia().getObjeto().getTitulo(),
                    ocorrencias.get(i).getDependente().getNome_dependente(),
                    data_ocorrencia,
                    ocorrencias.get(i).getObservacao(),
                    ocorrencias.get(i).getUsuario().getNome_usuario()});
            }

        }
    }

    public void alimentarTabelaCopia(Copia copiaAtendimento) {
        if (copiaAtendimento != null) {
            copiaAtendimento.getDiaria().getPromocaoLocacao().setValor_promocao_locacao(copiaAtendimento.getDiaria().getValor());

            DefaultTableModel row = (DefaultTableModel) jtbl_ocorrencia.getModel();
            row.addRow(new Object[]{copiaAtendimento.getCodigo_barras(),
                copiaAtendimento.getObjeto().getTitulo(),
                moeda.setPrecoFormat(String.valueOf(copiaAtendimento.getDiaria().getValor())),
                copiaAtendimento.getDiaria().getNome_diaria(),
                copiaAtendimento.getObjeto().getCensura(),
                copiaAtendimento.getDiaria().getPromocaoLocacao().getDescricao()});
        }
    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            retornaJanelaPai();
        }
    }

    private void retornaJanelaPai() {
        setVisible(false);
        if (janelapai != null) {
            janelapai.setStatusTela(true);
            janelapai.atendimentoLocacao = null;
            janelapai = null;
        }
    }

}
