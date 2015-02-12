package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.ItemLancamento;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.bean.ItemVenda;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.TipoServico;
import br.com.locadora.model.dao.LancamentoDAO;
import br.com.locadora.model.dao.LocacaoDAO;
import br.com.locadora.model.dao.VendaDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.Colorir;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.Printer;
import br.com.locadora.util.TemaInterface;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;

public class FinanceiroReceber extends javax.swing.JFrame {

    public DecimalFormat formatoPreco;
    public MaskFormatter formatoData;
    public String permissao;
    public Cliente cliente;
    public static Dependente dependente = new Dependente();
    private Date data;
    public InterfacePool pool;
    public SiscomController controller;
    public Financeiro janelapai;
    public AtendimentoLocacao janelapai2;
    public AtendimentoDevolucao janelapai3;
    public AtendimentoVenda janelapai4;
    public Moeda moeda;
    public List<Lancamento> lancamentos;
    public Lancamento lancamento;
    public TipoServico tipoServico;
    public AcessoUsuario acesso;
    public LancamentoRecebimento lancamentoRecebimento;
    public LancamentoDeposito lancamentoDeposito;

    public FinanceiroReceber() {
        initComponents();
        TemaInterface.getInterface(this);
        janelapai = null;
        janelapai2 = null;
        janelapai3 = null;
        jtf_nome_cliente.requestFocus();
    }

    public FinanceiroReceber(Dependente dependente) {
        initComponents();
        TemaInterface.getInterface(this);
        janelapai = null;
        janelapai2 = null;
        janelapai3 = null;
        janelapai4 = null;
        carregarClienteDependente(dependente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_codigo_cliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtf_nome_cliente = new javax.swing.JTextField();
        jb_cliente = new javax.swing.JButton();
        jp_locacao = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_recebimento = new javax.swing.JTable();
        jrb_pendente = new javax.swing.JRadioButton();
        jrb_deposito = new javax.swing.JRadioButton();
        jrb_historico = new javax.swing.JRadioButton();
        jl_rodape2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jb_receber = new javax.swing.JButton();
        jb_cancelar1 = new javax.swing.JButton();
        jb_adicionar_locacao = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jb_receber1 = new javax.swing.JButton();

        jDesktopPane1.setName("jDesktopPane1"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Financeiro - Contas À Receber");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel1.setText("Código ");
        jLabel1.setName("jLabel1"); // NOI18N

        jtf_codigo_cliente.setEditable(false);
        jtf_codigo_cliente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_codigo_cliente.setName("jtf_codigo_cliente"); // NOI18N

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel10.setText("Cliente");
        jLabel10.setName("jLabel10"); // NOI18N

        jtf_nome_cliente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_nome_cliente.setName("jtf_nome_cliente"); // NOI18N
        jtf_nome_cliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_nome_clienteFocusLost(evt);
            }
        });
        jtf_nome_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_nome_clienteKeyPressed(evt);
            }
        });

        jb_cliente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jb_cliente.setName("jb_cliente"); // NOI18N
        jb_cliente.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_clienteActionPerformed(evt);
            }
        });
        jb_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_clienteKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_codigo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_codigo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jb_cliente, jtf_codigo_cliente, jtf_nome_cliente});

        jp_locacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta"));
        jp_locacao.setName("jp_locacao"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jtbl_recebimento.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_recebimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Controle Interno", "Data Lançamento", "Descrição", "Tipo", "Valor Total", "Valor Devedor", "Cliente/Dependente", "Usuário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_recebimento.setName("jtbl_recebimento"); // NOI18N
        jtbl_recebimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_recebimentoMouseClicked(evt);
            }
        });
        jtbl_recebimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_recebimentoKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbl_recebimento);
        if (jtbl_recebimento.getColumnModel().getColumnCount() > 0) {
            jtbl_recebimento.getColumnModel().getColumn(0).setPreferredWidth(70);
            jtbl_recebimento.getColumnModel().getColumn(1).setPreferredWidth(70);
            jtbl_recebimento.getColumnModel().getColumn(2).setPreferredWidth(120);
            jtbl_recebimento.getColumnModel().getColumn(3).setPreferredWidth(5);
            jtbl_recebimento.getColumnModel().getColumn(4).setPreferredWidth(50);
            jtbl_recebimento.getColumnModel().getColumn(5).setPreferredWidth(50);
            jtbl_recebimento.getColumnModel().getColumn(6).setPreferredWidth(80);
            jtbl_recebimento.getColumnModel().getColumn(7).setPreferredWidth(80);
        }

        buttonGroup1.add(jrb_pendente);
        jrb_pendente.setSelected(true);
        jrb_pendente.setText("Pendente");
        jrb_pendente.setName("jrb_pendente"); // NOI18N
        jrb_pendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_pendenteActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrb_deposito);
        jrb_deposito.setText("Depósito");
        jrb_deposito.setName("jrb_deposito"); // NOI18N
        jrb_deposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_depositoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrb_historico);
        jrb_historico.setText("Histórico");
        jrb_historico.setName("jrb_historico"); // NOI18N
        jrb_historico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_historicoActionPerformed(evt);
            }
        });

        jl_rodape2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jl_rodape2.setText("Devedor: R$ 0,00 - Saldo Depósito Antecipado: R$ 0,00");
        jl_rodape2.setName("jl_rodape2"); // NOI18N

        jLabel4.setText("Tipo: D = Débito: C = Crédito ");
        jLabel4.setName("jLabel4"); // NOI18N

        javax.swing.GroupLayout jp_locacaoLayout = new javax.swing.GroupLayout(jp_locacao);
        jp_locacao.setLayout(jp_locacaoLayout);
        jp_locacaoLayout.setHorizontalGroup(
            jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jp_locacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jrb_pendente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrb_deposito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrb_historico)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_locacaoLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                .addComponent(jl_rodape2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jp_locacaoLayout.setVerticalGroup(
            jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_locacaoLayout.createSequentialGroup()
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrb_pendente)
                    .addComponent(jrb_deposito)
                    .addComponent(jrb_historico))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_rodape2)
                    .addComponent(jLabel4))
                .addGap(0, 0, 0))
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/BROADWAY-LOGIN.png"))); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jPanel2.setName("jPanel2"); // NOI18N

        jb_receber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/money-16.png"))); // NOI18N
        jb_receber.setText("Receber");
        jb_receber.setName("jb_receber"); // NOI18N
        jb_receber.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_receber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_receberActionPerformed(evt);
            }
        });

        jb_cancelar1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_cancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/sair.png"))); // NOI18N
        jb_cancelar1.setText("Sair");
        jb_cancelar1.setMaximumSize(new java.awt.Dimension(101, 33));
        jb_cancelar1.setName("jb_cancelar1"); // NOI18N
        jb_cancelar1.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelar1ActionPerformed(evt);
            }
        });
        jb_cancelar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_cancelar1KeyPressed(evt);
            }
        });

        jb_adicionar_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_adicionar_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/money_box-16.png"))); // NOI18N
        jb_adicionar_locacao.setText("Depositar");
        jb_adicionar_locacao.setToolTipText("");
        jb_adicionar_locacao.setName("jb_adicionar_locacao"); // NOI18N
        jb_adicionar_locacao.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_adicionar_locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_adicionar_locacaoActionPerformed(evt);
            }
        });
        jb_adicionar_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_adicionar_locacaoKeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/printer.png"))); // NOI18N
        jButton1.setText("Imprimir");
        jButton1.setName("jButton1"); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(100, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jb_receber1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/money_bag-2.png"))); // NOI18N
        jb_receber1.setText("Receber Todos");
        jb_receber1.setName("jb_receber1"); // NOI18N
        jb_receber1.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_receber1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_receber1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_adicionar_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_receber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_receber1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_receber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_adicionar_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_receber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jp_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jp_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
//            enviarDadosLocacao();
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    }//GEN-LAST:event_formKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornarJanelaPai();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

private void jb_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_clienteActionPerformed
    consultarClienteAtendimento();
}//GEN-LAST:event_jb_clienteActionPerformed

private void jtf_nome_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_clienteKeyPressed
    acionarAtalho(evt);
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        consultarClienteAtendimento();
    }
}//GEN-LAST:event_jtf_nome_clienteKeyPressed

private void jtf_nome_clienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nome_clienteFocusLost

}//GEN-LAST:event_jtf_nome_clienteFocusLost

    private void jb_adicionar_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_adicionar_locacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cadastrarDepositoLancamento();
        }
        acionarAtalho(evt);

    }//GEN-LAST:event_jb_adicionar_locacaoKeyPressed

    private void jb_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_clienteKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_clienteKeyPressed

    private void jb_receberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_receberActionPerformed
        alterarItemLancamento();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_receberActionPerformed

    private void jtbl_recebimentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_recebimentoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_receber.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_recebimentoKeyPressed

    private void jtbl_recebimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_recebimentoMouseClicked
        if (evt.getClickCount() > 1) {
            jb_receber.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_recebimentoMouseClicked

    private void jb_cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelar1ActionPerformed
        retornarJanelaPai();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_cancelar1ActionPerformed

    private void jb_cancelar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_cancelar1KeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_cancelar1.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_cancelar1KeyPressed

    private void jb_adicionar_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_adicionar_locacaoActionPerformed
        cadastrarDepositoLancamento();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_locacaoActionPerformed

    private void jrb_depositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_depositoActionPerformed
        consultarLancamentos();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_depositoActionPerformed

    private void jrb_pendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_pendenteActionPerformed
        consultarLancamentos();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_pendenteActionPerformed

    private void jrb_historicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_historicoActionPerformed
        consultarLancamentos();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_historicoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        imprimir();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyPressed

    private void jb_receber1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_receber1ActionPerformed
        if (lancamentos.size() > 0) {
            receberTodos();
        } else {
            JOptionPane.showMessageDialog(null, "Sem Lançamentos para receber.");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_receber1ActionPerformed

    public void consultarClienteAtendimento() {
        ConsultaClienteAtendimento consultaCliente = new ConsultaClienteAtendimento();
        consultaCliente.janelapaiRecebimento = this;
        consultaCliente.setVisible(true);
        consultaCliente.jtf_consulta.setText(jtf_nome_cliente.getText().trim());
        setStatusTela(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FinanceiroReceber().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_adicionar_locacao;
    private javax.swing.JButton jb_cancelar1;
    private javax.swing.JButton jb_cliente;
    private javax.swing.JButton jb_receber;
    private javax.swing.JButton jb_receber1;
    private javax.swing.JLabel jl_rodape2;
    public static javax.swing.JPanel jp_locacao;
    private javax.swing.JRadioButton jrb_deposito;
    private javax.swing.JRadioButton jrb_historico;
    private javax.swing.JRadioButton jrb_pendente;
    public static javax.swing.JTable jtbl_recebimento;
    public static javax.swing.JTextField jtf_codigo_cliente;
    public static javax.swing.JTextField jtf_nome_cliente;
    // End of variables declaration//GEN-END:variables

    private void excluirProduto() {
        removeObjeto(jtbl_recebimento);
    }

    public void removeObjeto(JTable tb) {
        if (tb != null) {
            DefaultTableModel row = (DefaultTableModel) jtbl_recebimento.getModel();
            if (tb.getSelectedRow() != -1) {
                int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_NO_OPTION) {
                    carregarClienteDependente(dependente);
                    row.removeRow(tb.getSelectedRow());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um Objeto");
            }
        }
    }

    public boolean verificarCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_codigo_cliente.getText().equals("")) {
            msgERRO = msgERRO + " *Cliente\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);

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

    public void consultarLancamentos() {
        pool = new Pool();
        lancamentos = new ArrayList<Lancamento>();
        LancamentoDAO lancamentoDAO = new LancamentoDAO(pool);

        if (jrb_pendente.isSelected()) {
            lancamentos = lancamentoDAO.getLancamentosPendentes(dependente.getCliente());
        } else if (jrb_deposito.isSelected()) {
            lancamentos = lancamentoDAO.getLancamentosDepositos(dependente.getCliente());
        } else if (jrb_historico.isSelected()) {
            lancamentos = lancamentoDAO.getLancamentos(dependente.getCliente());
        }
        mostrarLancamentos(lancamentos);
    }

    public void mostrarLancamentos(List<Lancamento> lancamentos) {
        DefaultTableModel tb_recebimentos = (DefaultTableModel) jtbl_recebimento.getModel();
        int rows = tb_recebimentos.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            tb_recebimentos.removeRow(i);
        }
        try {

            for (int i = 0; i < lancamentos.size(); i++) {
                SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

                String data_lancamento;
                data_lancamento = out.format(in.parse(lancamentos.get(i).getData_lancamento().toString()));

                moeda = new Moeda();

                DefaultTableModel row = (DefaultTableModel) jtbl_recebimento.getModel();
                row.addRow(new Object[]{lancamentos.get(i).getCodigo_lancamento(), data_lancamento,
                    lancamentos.get(i).getTipoServico().getDescricao(),
                    lancamentos.get(i).getTipoServico().getTipo(),
                    moeda.setPrecoFormat(lancamentos.get(i).getValor_total().toString()),
                    moeda.setPrecoFormat(lancamentos.get(i).getDevedor().toString()),
                    lancamentos.get(i).getDependente().getNome_dependente(),
                    lancamentos.get(i).getUsuario().getNome_usuario()});

            }

            TableCellRenderer tcr = new Colorir(null, null, this);
            TableColumn column = jtbl_recebimento.getColumnModel().getColumn(0);
            column.setCellRenderer(tcr);
            column = jtbl_recebimento.getColumnModel().getColumn(1);
            column.setCellRenderer(tcr);
            column = jtbl_recebimento.getColumnModel().getColumn(2);
            column.setCellRenderer(tcr);
            column = jtbl_recebimento.getColumnModel().getColumn(3);
            column.setCellRenderer(tcr);
            column = jtbl_recebimento.getColumnModel().getColumn(4);
            column.setCellRenderer(tcr);
            column = jtbl_recebimento.getColumnModel().getColumn(5);
            column.setCellRenderer(tcr);
            column = jtbl_recebimento.getColumnModel().getColumn(6);
            column.setCellRenderer(tcr);
            column = jtbl_recebimento.getColumnModel().getColumn(7);
            column.setCellRenderer(tcr);

            jtbl_recebimento.requestFocus();
            jtbl_recebimento.setSelectionMode(1);
        } catch (ParseException ex) {
            Logger.getLogger(FinanceiroReceber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarClienteDependente(Dependente dependente) {
        if (dependente != null) {
            this.dependente = dependente;

            jtf_nome_cliente.setText(dependente.getNome_dependente());
            jtf_codigo_cliente.setText(String.valueOf(dependente.getCliente().getCodigo_cliente()));
            moeda = new Moeda();

            pool = new Pool();
            List<Lancamento> lancamentosGetSaldo = new ArrayList<Lancamento>();
            LancamentoDAO lancamentoDAO = new LancamentoDAO(pool);
            lancamentosGetSaldo = lancamentoDAO.getLancamentos(dependente.getCliente());
            Double saldo = 0.00;
            Double devedor = 0.00;
            int quantidade_lancamento_aberto = 0;
            for (int i = 0; i < lancamentosGetSaldo.size(); i++) {
                if (lancamentosGetSaldo.get(i).getTipoServico().getTipo().equals("C")) {
                    saldo = saldo + lancamentosGetSaldo.get(i).getSaldo();
                } else {
                    if (lancamentosGetSaldo.get(i).getDevedor() > 0) {
                        quantidade_lancamento_aberto = quantidade_lancamento_aberto + 1;
                    }
                    devedor = devedor + lancamentosGetSaldo.get(i).getDevedor();
                }
            }

            jl_rodape2.setText("Devedor: " + moeda.setPrecoFormat(devedor.toString()) + " - Saldo Depósito Antecipado: " + moeda.setPrecoFormat(saldo.toString()));

            //Limpa tabela depois de selecionar novo cliente
            DefaultTableModel tb_locacao = (DefaultTableModel) jtbl_recebimento.getModel();
            int rows = tb_locacao.getRowCount();
            for (int i = rows - 1; i >= 0; i--) {
                tb_locacao.removeRow(i);
            }
            consultarLancamentos();

            jtbl_recebimento.requestFocus();
            jtbl_recebimento.setSelectionMode(0);
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
            janelapai.consultarContas();
        } else if (janelapai2 != null) {
            janelapai2.setStatusTela(true);
            janelapai2.carregarClienteDependente(dependente);
        } else if (janelapai3 != null) {
            janelapai3.setStatusTela(true);
            janelapai3.carregarClienteDependente(dependente);
        } else if (janelapai4 != null) {
            janelapai4.setStatusTela(true);
            janelapai4.carregarClienteDependente(dependente);
        }
    }

    public Lancamento tbLancamentoLinhaSelecionada(JTable tb) {

        lancamento = new Lancamento();
        if (tb != null && tb.getSelectedRow() != -1) {
            lancamento = lancamentos.get(tb.getSelectedRow());
        } else {
            lancamento = null;
        }
        return lancamento;
    }

    public void alterarItemLancamento() {
        lancamento = tbLancamentoLinhaSelecionada(jtbl_recebimento);
        if (lancamento != null) {
            if (lancamentoRecebimento == null) {
                lancamentoRecebimento = new LancamentoRecebimento(lancamento);
                lancamentoRecebimento.janelapai = this;
                lancamentoRecebimento.setVisible(true);
                this.setEnabled(false);
            } else {
                lancamentoRecebimento.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Lançamento");
            jtf_nome_cliente.requestFocus();
        }
    }

    public void cadastrarDepositoLancamento() {

        if (lancamentoDeposito == null) {
            lancamentoDeposito = new LancamentoDeposito();
            lancamentoDeposito.janelapai = this;
            lancamentoDeposito.setVisible(true);
            this.setEnabled(false);
        } else {
            lancamentoDeposito.setVisible(true);
        }

    }

    public void imprimir() {
        if (jtbl_recebimento != null && jtbl_recebimento.getSelectedRow() != -1) {

            if (lancamentos.get(jtbl_recebimento.getSelectedRow()).getLocacao().getCodigo_locacao() != 0) {
                pool = new Pool();
                LocacaoDAO locacaoDAO = new LocacaoDAO(pool);
                List<ItemLocacao> itensLocacao = new ArrayList<ItemLocacao>();
                itensLocacao = locacaoDAO.getItemLocacao(lancamentos.get(jtbl_recebimento.getSelectedRow()));

                String nome_arquivo = "Imprimir/reimpressaocomprovanteLocacao_" + lancamentos.get(jtbl_recebimento.getSelectedRow()).getDependente().getNome_dependente() + ".txt";
                Printer imprimir = new Printer();
                imprimir.comprovanteLocacao(itensLocacao, lancamentos.get(jtbl_recebimento.getSelectedRow()).getDependente(),
                        lancamentos.get(jtbl_recebimento.getSelectedRow()).getUsuario(), lancamentos.get(jtbl_recebimento.getSelectedRow()),
                        nome_arquivo);
                if (imprimir.imprimirArquivo(nome_arquivo)) {
                    File arquivo = new File(nome_arquivo);
                    arquivo.deleteOnExit();
                    arquivo.delete();
                } else {
                    File arquivo = new File(nome_arquivo);
                    arquivo.deleteOnExit();
                    arquivo.delete();
                }
            } else if (lancamentos.get(jtbl_recebimento.getSelectedRow()).getVenda().getCodigo_venda() != 0) {
                pool = new Pool();
                VendaDAO vendaDAOVenda = new VendaDAO(pool);
                List<ItemVenda> itensVenda = new ArrayList<ItemVenda>();
                itensVenda = vendaDAOVenda.getItemVenda(lancamentos.get(jtbl_recebimento.getSelectedRow()));

                String nome_arquivo = "Imprimir/reimpressaocomprovanteVenda_" + lancamentos.get(jtbl_recebimento.getSelectedRow()).getDependente().getNome_dependente() + ".txt";
                Printer imprimir = new Printer();
                imprimir.comprovanteVenda(itensVenda, lancamentos.get(jtbl_recebimento.getSelectedRow()).getDependente(),
                        lancamentos.get(jtbl_recebimento.getSelectedRow()).getUsuario(), lancamentos.get(jtbl_recebimento.getSelectedRow()),
                        nome_arquivo);
                if (imprimir.imprimirArquivo(nome_arquivo)) {
                    File arquivo = new File(nome_arquivo);
                    arquivo.deleteOnExit();
                    arquivo.delete();
                } else {
                    File arquivo = new File(nome_arquivo);
                    arquivo.deleteOnExit();
                    arquivo.delete();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Lançamento sem Reimpressão configurada.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Lançamento.");
        }

    }

    public void receberTodos() {
        Calendar data_atual = Calendar.getInstance();
        List<ItemLancamento> itensLancamento = new ArrayList<>();
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        Double devedor = 0.00;
        for (int i = 0; i < lancamentos.size(); i++) {
            devedor = devedor + lancamentos.get(i).getDevedor();
        }

        if (devedor > 0) {
            int selectedOption = JOptionPane.showConfirmDialog(this, "Débito Total de " + moeda.setPrecoFormat(devedor.toString()) + ".\n Deseja Receber Todos?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (selectedOption == JOptionPane.YES_NO_OPTION) {

                for (int i = 0; i < lancamentos.size(); i++) {
                    //Se Locação
                    if (lancamentos.get(i).getLocacao().getCodigo_locacao() != 0) {
                        if (lancamentos.get(i).getDevedor() > 0) {
                            ItemLancamento itemLancamento = new ItemLancamento();
                            itemLancamento.setData_lancamento(data_atual.getTime());
                            itemLancamento.setLancamento(lancamentos.get(i));
                            itemLancamento.setValor_lancamento(lancamentos.get(i).getDevedor());
                            tipoServico = new TipoServico();
                            tipoServico.setCodigo_tipo_servico(6);
                            itemLancamento.setTipoServico(tipoServico);
                            itemLancamento.setCaixa(Integer.parseInt(conf.readPropertie("caixa")));
                            itemLancamento.setUsuario(acesso.getUsuario());
                            itensLancamento.add(itemLancamento);
                        }
                    } else if (lancamentos.get(i).getTipoServico().getCodigo_tipo_servico() == 2) {
                        if (lancamentos.get(i).getDevedor() > 0) {
                            ItemLancamento itemLancamento = new ItemLancamento();
                            itemLancamento.setData_lancamento(data_atual.getTime());
                            itemLancamento.setLancamento(lancamentos.get(i));
                            itemLancamento.setValor_lancamento(lancamentos.get(i).getDevedor());
                            tipoServico = new TipoServico();
                            tipoServico.setCodigo_tipo_servico(7);
                            itemLancamento.setTipoServico(tipoServico);
                            itemLancamento.setCaixa(Integer.parseInt(conf.readPropertie("caixa")));
                            itemLancamento.setUsuario(acesso.getUsuario());
                            itensLancamento.add(itemLancamento);
                        }
                    } else if (lancamentos.get(i).getVenda().getCodigo_venda() != 0) {
                        if (lancamentos.get(i).getDevedor() > 0) {
                            ItemLancamento itemLancamento = new ItemLancamento();
                            itemLancamento.setData_lancamento(data_atual.getTime());
                            itemLancamento.setLancamento(lancamentos.get(i));
                            itemLancamento.setValor_lancamento(lancamentos.get(i).getDevedor());
                            tipoServico = new TipoServico();
                            tipoServico.setCodigo_tipo_servico(11);
                            itemLancamento.setTipoServico(tipoServico);
                            itemLancamento.setCaixa(Integer.parseInt(conf.readPropertie("caixa")));
                            itemLancamento.setUsuario(acesso.getUsuario());
                            itensLancamento.add(itemLancamento);
                        }
                    }

                }
                pool = new Pool();
                LancamentoDAO lancamentoDAO = new LancamentoDAO(pool);
                lancamentoDAO.salvarItemLancamento(itensLancamento);
                consultarLancamentos();
            }

        }

    }
}
