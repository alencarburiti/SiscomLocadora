package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Devolucao;
import br.com.locadora.model.bean.ItemLancamento;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.Locacao;
import br.com.locadora.model.bean.TipoServico;
import br.com.locadora.model.bean.Usuario;
import br.com.locadora.model.bean.Venda;
import br.com.locadora.model.dao.LancamentoDAO;
import br.com.locadora.model.dao.TipoServicoDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class LancamentoDeposito extends javax.swing.JFrame {

    public DecimalFormat formatoPreco;
    public MaskFormatter formatoData;
    public InterfacePool pool;
    public FinanceiroReceber janelapai;
    public Moeda moeda;
    public Lancamento lancamento;
    public TipoServico tipoServico;
    public AcessoUsuario acesso;
    public List<ItemLancamento> itensLancamento;
    public ItemLancamento itemLancamento;

    public LancamentoDeposito() {
        initComponents();
        TemaInterface.getInterface(this);
    }   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        try  {
            formatoData = new MaskFormatter("##/##/####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_data_lancamento = new JFormattedTextField(formatoData);
        /*try  {          
            Locale BRAZIL = new Locale("pt","BR");  
            DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
            formatoPreco = new DecimalFormat("¤ ###,###,##0.00",REAL);  
        }    catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        */
        jtf_valor_lancamento = new javax.swing.JTextField();
        jcb_tipo_servico = new javax.swing.JComboBox();
        jl_codigo_locacao1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jb_sair = new javax.swing.JButton();
        jb_salvar = new javax.swing.JButton();

        jDesktopPane1.setName("jDesktopPane1"); // NOI18N
        jDesktopPane1.setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lançamento - Depósito Antecipado");
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jDesktopPane2.setName("jDesktopPane2"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lançamento"));
        jPanel1.setName("jPanel1"); // NOI18N

        jtf_data_lancamento.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_data_lancamento.setName("jtf_data_lancamento"); // NOI18N
        jtf_data_lancamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_data_lancamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_data_lancamentoFocusLost(evt);
            }
        });
        jtf_data_lancamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_data_lancamentoKeyPressed(evt);
            }
        });

        jtf_valor_lancamento.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_valor_lancamento.setText("R$ 0,00");
        jtf_valor_lancamento.setName("jtf_valor_lancamento"); // NOI18N
        jtf_valor_lancamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_lancamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valor_lancamentoFocusLost(evt);
            }
        });
        jtf_valor_lancamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_valor_lancamentoKeyPressed(evt);
            }
        });

        jcb_tipo_servico.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_tipo_servico.setName("jcb_tipo_servico"); // NOI18N
        jcb_tipo_servico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcb_tipo_servicoKeyPressed(evt);
            }
        });

        jl_codigo_locacao1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jl_codigo_locacao1.setText("Depósito");
        jl_codigo_locacao1.setName("jl_codigo_locacao1"); // NOI18N

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel6.setText("Data Lançamento");
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel7.setText("Valor");
        jLabel7.setName("jLabel7"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_codigo_locacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_tipo_servico, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtf_data_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_valor_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jl_codigo_locacao1)
                .addGap(0, 0, 0)
                .addComponent(jcb_tipo_servico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_data_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_valor_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel6.setName("jPanel6"); // NOI18N

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jb_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jb_salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Calendar data_atual = Calendar.getInstance();               
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        String data_inicial = out.format(data_atual.getTime());       
        jtf_data_lancamento.setText(data_inicial);    
        
        carregarTipoLancamento();
        jcb_tipo_servico.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            jb_salvar.doClick();
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    }//GEN-LAST:event_formKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornarJanelaPai();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jb_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_sairActionPerformed
        retornarJanelaPai();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_sairActionPerformed

    private void jb_sairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_sairKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_sair.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_sairKeyPressed

    private void jtf_data_lancamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_lancamentoFocusGained
        jtf_data_lancamento.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_lancamentoFocusGained

    private void jtf_data_lancamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_lancamentoFocusLost
        try {

            if (jtf_data_lancamento.getText().trim().length() < 10) {
                jtf_data_lancamento.setForeground(Color.red);
                jtf_data_lancamento.requestFocus();
            } else if (jtf_data_lancamento.getText().equals("  /  /    ")) {
                jtf_data_lancamento.setForeground(Color.red);
                jtf_data_lancamento.requestFocus();
            } else {
                if (validaData(jtf_data_lancamento.getText())) {
                    jtf_data_lancamento.setForeground(Color.black);
                } else {
                    jtf_data_lancamento.setForeground(Color.red);
                    jtf_data_lancamento.requestFocus();
                }

            }
        } catch (ParseException ex) {
            jtf_data_lancamento.setForeground(Color.red);
            jtf_data_lancamento.requestFocus();
        } catch (NumberFormatException ex) {
            jtf_data_lancamento.setText("  /  /    ");
            jtf_data_lancamento.setForeground(Color.red);
            jtf_data_lancamento.requestFocus();
        }
    }//GEN-LAST:event_jtf_data_lancamentoFocusLost

    private void jtf_data_lancamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_data_lancamentoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_valor_lancamento.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_lancamentoKeyPressed

    private void jtf_valor_lancamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_lancamentoFocusGained
        Moeda moeda = new Moeda();
        if (jtf_valor_lancamento.getText().equals("R$ 0,00")) {
            jtf_valor_lancamento.setText("");
        } else {
            jtf_valor_lancamento.setText(moeda.setPrecoFormat(jtf_valor_lancamento.getText()));
        }
        jtf_valor_lancamento.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_lancamentoFocusGained

    private void jtf_valor_lancamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_lancamentoFocusLost
        moeda = new Moeda();
        jtf_valor_lancamento.setText(moeda.setPrecoFormat(jtf_valor_lancamento.getText()));
    }//GEN-LAST:event_jtf_valor_lancamentoFocusLost

    private void jtf_valor_lancamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_lancamentoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_salvar.requestFocus();
        }
        acionarAtalho(evt);

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_lancamentoKeyPressed

    private void jcb_tipo_servicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_tipo_servicoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_data_lancamento.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_tipo_servicoKeyPressed

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        adicionarLancamento();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarActionPerformed

    private void jb_salvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_salvarKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_salvar.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new LancamentoDeposito().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton jb_sair;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JComboBox jcb_tipo_servico;
    private javax.swing.JLabel jl_codigo_locacao1;
    public static javax.swing.JFormattedTextField jtf_data_lancamento;
    private javax.swing.JTextField jtf_valor_lancamento;
    // End of variables declaration//GEN-END:variables

    public void adicionarLancamento() {

        if (verificarItemLancamento() == true) {
            moeda = new Moeda();
            ArquivoConfiguracao conf = new ArquivoConfiguracao();
            lancamento = new Lancamento();
            
            ItemDbGrid hashDbGrid = (ItemDbGrid) jcb_tipo_servico.getSelectedItem();
            tipoServico = new TipoServico();
            tipoServico = (TipoServico) hashDbGrid.getObjeto();

            lancamento.setValor_total(moeda.getPrecoFormato(jtf_valor_lancamento.getText()));
            lancamento.setSaldo_dia(0.00);
            lancamento.setDesconto(0.00);
            lancamento.setDesconto_entrega_antecipada(0.00);
            lancamento.setValor_pago(0.00);
            lancamento.setTroco(0.00);
            lancamento.setValor_total_a_pagar(0.00);
            lancamento.setTipoServico(tipoServico);
            lancamento.setDependente(janelapai.dependente);
            Usuario usuario = new Usuario();
            usuario.setCodigo_usuario(Integer.parseInt(conf.readPropertie("codigo_usuario")));
            lancamento.setCaixa(Integer.parseInt(conf.readPropertie("caixa")));
            lancamento.setUsuario(usuario);
            lancamento.setLocacao(new Locacao());
            lancamento.setDevolucao(new Devolucao());
            lancamento.setVenda(new Venda());

            pool = new Pool();
            LancamentoDAO lancamentoDAO = new LancamentoDAO(pool);
            lancamentoDAO.salvarLancamento(lancamento);            
            retornarJanelaPai();
        } 
    }  
    
    
    public boolean verificarItemLancamento() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_data_lancamento.getText().trim().length() != 10) {
            msgERRO = msgERRO + " *Data Inválida\n";
        }

        if (jtf_valor_lancamento.getText().trim().equals("R$ 0,00") || jtf_valor_lancamento.getText().trim().equals("R$")) {
            msgERRO = msgERRO + " *Valor Inválido\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jcb_tipo_servico.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void statusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    public void carregarTipoLancamento() {
        List<TipoServico> tipos;
        pool = new Pool();
        TipoServicoDAO tipoServicoDAO = new TipoServicoDAO(pool);
        tipos = tipoServicoDAO.getTipoServicos("R");

        if (tipos.isEmpty()) {

        } else {
            for (int i = 0; i < tipos.size(); i++) {
                ItemDbGrid hashDbGrid = new ItemDbGrid(tipos.get(i), tipos.get(i).getDescricao());
                jcb_tipo_servico.addItem(hashDbGrid);
                System.out.println(hashDbGrid);
            }
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
            setVisible(false);
            retornarJanelaPai();
        }        
    }

    public static boolean validaData(String dataString) throws java.text.ParseException {

        if (!dataString.equals("")) {

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = new GregorianCalendar();
            Date dataDigitada = new Date(df.parse(dataString).getTime());
            Date dataAtual = new Date(System.currentTimeMillis());

            // gerando o calendar
            cal.setTime(df.parse(dataString));

            // separando os dados da string para comparacao e validacao
            String[] data = dataString.split("/");
            String dia = data[0];
            String mes = data[1];
            String ano = data[2];

            // testando se hah discrepancia entre a data que foi
            // inserida no caledar e a data que foi passada como
            // string. se houver diferenca, a data passada era
            // invalida
            if ((new Integer(dia)).intValue() != (new Integer(cal.get(Calendar.DAY_OF_MONTH))).intValue()) {
                // dia nao casou
                return (false);
            }
            if ((new Integer(mes)).intValue() != (new Integer(cal.get(Calendar.MONTH) + 1)).intValue()) {
                // mes nao casou

                return (false);
            }
            if ((new Integer(ano)).intValue() != (new Integer(cal.get(Calendar.YEAR))).intValue()) {
                // ano nao casou

                return (false);
            }
            if (dataDigitada.after(dataAtual)) {
                // data maior que atual
                return (false);
            }
            return (true);
        }
        return false;
    }

    public void retornarJanelaPai() {
        setVisible(false);
        if (janelapai != null) {
            janelapai.setStatusTela(true);
            janelapai.lancamentoRecebimento = null;
            janelapai.carregarClienteDependente(janelapai.dependente);            
        }
    }
}
