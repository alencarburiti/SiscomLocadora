package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.dao.DiariaDAO;
import br.com.locadora.model.dao.LancamentoDAO;
import br.com.locadora.model.dao.LocacaoDAO;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
import static br.com.locadora.view.LancamentoOcorrencia.jtf_nome_cliente;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class AtendimentoDevolucao extends javax.swing.JFrame {

    public DecimalFormat formatoPreco;
    public MaskFormatter formatoData;
    public Cliente cliente;
    public static Dependente dependente = new Dependente();
    public Objeto objeto;
    public Copia copiaDevolucao;
    public static List<Copia> copiasLocacao = new ArrayList<Copia>();
    public InterfacePool pool;
    public TelaPrincipal janelapai;
    public static List<ItemLocacao> itensDevolucao;
    public ItemLocacao itemDevolucao;
    public Moeda moeda;
    public Lancamento lancamento;
    public AcessoUsuario acesso;
    public DiariaDAO diariaDAO;
    public List<Diaria> promocoesDevolucao;
    public ConsultaCopiaDevolucao consultaCopiaDevolucao;
    public List<Lancamento> lancamentos;
    public FinanceiroReceber financeiroReceber;

    public AtendimentoDevolucao() {
        initComponents();
        TemaInterface.getInterface(this);
        janelapai = null;                
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_codigo_cliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtf_nome_cliente = new javax.swing.JTextField();
        jb_pesquisa_cliente = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbl_devolucao = new javax.swing.JTable();
        jl_codigo_devolucao = new javax.swing.JLabel();
        jtf_codigo_objeto_devolucao = new javax.swing.JTextField();
        jb_pesquisa_devolucao = new javax.swing.JButton();
        jb_adicionar_devolucao = new javax.swing.JButton();
        jb_remover_devolucao = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtf_nome_objeto_devolucao = new javax.swing.JTextField();
        jl_lancamento_aberto = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jtf_total_a_pagar = new javax.swing.JTextField();
        jl_debito_devolucao = new javax.swing.JLabel();
        jtf_saldo = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jtf_valor_total_relocacao = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jtf_total_desconto_entrega_antecipada = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jb_limpar_devolucao = new javax.swing.JButton();
        jb_finalizar_devolucao = new javax.swing.JButton();
        jb_sair = new javax.swing.JButton();
        jb_recebimento = new javax.swing.JButton();

        jDesktopPane1.setName("jDesktopPane1"); // NOI18N
        jDesktopPane1.setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atendimento Devolução");
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
        jDesktopPane2.setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel1.setText("Código ");
        jLabel1.setName("jLabel1"); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 18));

        jtf_codigo_cliente.setEditable(false);
        jtf_codigo_cliente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_codigo_cliente.setName("jtf_codigo_cliente"); // NOI18N
        jtf_codigo_cliente.setPreferredSize(new java.awt.Dimension(100, 24));

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel10.setText("Nome Cliente");
        jLabel10.setName("jLabel10"); // NOI18N
        jLabel10.setPreferredSize(new java.awt.Dimension(300, 18));

        jtf_nome_cliente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_nome_cliente.setName("jtf_nome_cliente"); // NOI18N
        jtf_nome_cliente.setPreferredSize(new java.awt.Dimension(300, 24));
        jtf_nome_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_nome_clienteKeyPressed(evt);
            }
        });

        jb_pesquisa_cliente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_pesquisa_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jb_pesquisa_cliente.setName("jb_pesquisa_cliente"); // NOI18N
        jb_pesquisa_cliente.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_pesquisa_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_pesquisa_clienteActionPerformed(evt);
            }
        });
        jb_pesquisa_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_pesquisa_clienteKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_codigo_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jb_pesquisa_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jb_pesquisa_cliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addComponent(jtf_codigo_cliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens"));
        jPanel3.setName("jPanel3"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jtbl_devolucao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_devolucao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód. Barras", "Nome Objeto", "Data Locação", "Valor Relocação", "Dias Atraso", "Desc. Entrega Antecipada "
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
        jtbl_devolucao.setName("jtbl_devolucao"); // NOI18N
        jtbl_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_devolucaoKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jtbl_devolucao);
        if (jtbl_devolucao.getColumnModel().getColumnCount() > 0) {
            jtbl_devolucao.getColumnModel().getColumn(0).setPreferredWidth(10);
            jtbl_devolucao.getColumnModel().getColumn(1).setPreferredWidth(140);
            jtbl_devolucao.getColumnModel().getColumn(2).setPreferredWidth(20);
            jtbl_devolucao.getColumnModel().getColumn(3).setPreferredWidth(20);
            jtbl_devolucao.getColumnModel().getColumn(4).setPreferredWidth(10);
            jtbl_devolucao.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        jl_codigo_devolucao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jl_codigo_devolucao.setText("Código do Objeto");
        jl_codigo_devolucao.setName("jl_codigo_devolucao"); // NOI18N
        jl_codigo_devolucao.setPreferredSize(new java.awt.Dimension(120, 18));

        jtf_codigo_objeto_devolucao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_codigo_objeto_devolucao.setName("jtf_codigo_objeto_devolucao"); // NOI18N
        jtf_codigo_objeto_devolucao.setPreferredSize(new java.awt.Dimension(120, 24));
        jtf_codigo_objeto_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_codigo_objeto_devolucaoKeyPressed(evt);
            }
        });

        jb_pesquisa_devolucao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_pesquisa_devolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jb_pesquisa_devolucao.setName("jb_pesquisa_devolucao"); // NOI18N
        jb_pesquisa_devolucao.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_pesquisa_devolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_pesquisa_devolucaoActionPerformed(evt);
            }
        });
        jb_pesquisa_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_pesquisa_devolucaoKeyPressed(evt);
            }
        });

        jb_adicionar_devolucao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_adicionar_devolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/adicionar_item.png"))); // NOI18N
        jb_adicionar_devolucao.setToolTipText("Incluir");
        jb_adicionar_devolucao.setName("jb_adicionar_devolucao"); // NOI18N
        jb_adicionar_devolucao.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_adicionar_devolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_adicionar_devolucaoActionPerformed(evt);
            }
        });
        jb_adicionar_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_adicionar_devolucaoKeyPressed(evt);
            }
        });

        jb_remover_devolucao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_remover_devolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/remove_item.png"))); // NOI18N
        jb_remover_devolucao.setToolTipText("Excluir");
        jb_remover_devolucao.setName("jb_remover_devolucao"); // NOI18N
        jb_remover_devolucao.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_remover_devolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_remover_devolucaoActionPerformed(evt);
            }
        });
        jb_remover_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_remover_devolucaoKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel3.setText("Nome Objeto");
        jLabel3.setName("jLabel3"); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(300, 18));

        jtf_nome_objeto_devolucao.setEditable(false);
        jtf_nome_objeto_devolucao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_nome_objeto_devolucao.setName("jtf_nome_objeto_devolucao"); // NOI18N
        jtf_nome_objeto_devolucao.setPreferredSize(new java.awt.Dimension(300, 24));

        jl_lancamento_aberto.setForeground(new java.awt.Color(255, 0, 0));
        jl_lancamento_aberto.setText("Pendente: 0");
        jl_lancamento_aberto.setName("jl_lancamento_aberto"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_codigo_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_codigo_objeto_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtf_nome_objeto_devolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(5, 5, 5)
                                .addComponent(jb_pesquisa_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jb_adicionar_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jb_remover_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jl_lancamento_aberto, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_codigo_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_codigo_objeto_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_nome_objeto_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jb_pesquisa_devolucao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb_remover_devolucao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb_adicionar_devolucao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jl_lancamento_aberto))
        );

        jLabel32.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("Total À Pagar:");
        jLabel32.setName("jLabel32"); // NOI18N

        jtf_total_a_pagar.setEditable(false);
        jtf_total_a_pagar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jtf_total_a_pagar.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtf_total_a_pagar.setText("R$ 0,00");
        jtf_total_a_pagar.setName("jtf_total_a_pagar"); // NOI18N
        jtf_total_a_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_total_a_pagarActionPerformed(evt);
            }
        });
        jtf_total_a_pagar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_total_a_pagarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_total_a_pagarFocusLost(evt);
            }
        });

        jl_debito_devolucao.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jl_debito_devolucao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jl_debito_devolucao.setText("Saldo:");
        jl_debito_devolucao.setName("jl_debito_devolucao"); // NOI18N

        jtf_saldo.setEditable(false);
        jtf_saldo.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jtf_saldo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtf_saldo.setText("R$ 0,00");
        jtf_saldo.setName("jtf_saldo"); // NOI18N
        jtf_saldo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_saldoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_saldoFocusLost(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("Total Relocação:");
        jLabel35.setName("jLabel35"); // NOI18N

        jtf_valor_total_relocacao.setEditable(false);
        jtf_valor_total_relocacao.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jtf_valor_total_relocacao.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtf_valor_total_relocacao.setText("R$ 0,00");
        jtf_valor_total_relocacao.setName("jtf_valor_total_relocacao"); // NOI18N
        jtf_valor_total_relocacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_total_relocacaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valor_total_relocacaoFocusLost(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Desconto Entr. Antecipada:");
        jLabel36.setName("jLabel36"); // NOI18N

        jtf_total_desconto_entrega_antecipada.setEditable(false);
        jtf_total_desconto_entrega_antecipada.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jtf_total_desconto_entrega_antecipada.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtf_total_desconto_entrega_antecipada.setText("R$ 0,00");
        jtf_total_desconto_entrega_antecipada.setName("jtf_total_desconto_entrega_antecipada"); // NOI18N
        jtf_total_desconto_entrega_antecipada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_total_desconto_entrega_antecipadaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_total_desconto_entrega_antecipadaFocusLost(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/BROADWAY-LOGIN.png"))); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel2.setName("jPanel2"); // NOI18N

        jb_limpar_devolucao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_limpar_devolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/limpar.png"))); // NOI18N
        jb_limpar_devolucao.setText("Limpar");
        jb_limpar_devolucao.setName("jb_limpar_devolucao"); // NOI18N
        jb_limpar_devolucao.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_limpar_devolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_limpar_devolucaoActionPerformed(evt);
            }
        });
        jb_limpar_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_limpar_devolucaoKeyPressed(evt);
            }
        });

        jb_finalizar_devolucao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_finalizar_devolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/finalizar.png"))); // NOI18N
        jb_finalizar_devolucao.setText("OK");
        jb_finalizar_devolucao.setName("jb_finalizar_devolucao"); // NOI18N
        jb_finalizar_devolucao.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_finalizar_devolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_finalizar_devolucaoActionPerformed(evt);
            }
        });
        jb_finalizar_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_finalizar_devolucaoKeyPressed(evt);
            }
        });

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

        jb_recebimento.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_recebimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/finances_(add)_16x16.gif"))); // NOI18N
        jb_recebimento.setText("Recebimentos");
        jb_recebimento.setName("jb_recebimento"); // NOI18N
        jb_recebimento.setPreferredSize(new java.awt.Dimension(140, 40));
        jb_recebimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_recebimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jb_recebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_finalizar_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jb_limpar_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_finalizar_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_recebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_limpar_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(jtf_total_desconto_entrega_antecipada, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(jtf_total_a_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(5, 5, 5)
                                            .addComponent(jtf_valor_total_relocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jl_debito_devolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(5, 5, 5)
                                            .addComponent(jtf_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10)
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_debito_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_valor_total_relocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_total_desconto_entrega_antecipada, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_total_a_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_codigo_objeto_devolucao.requestFocus();
        jl_codigo_devolucao.setText("Código de Barras");
    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        acionarAtalho(evt);
    }//GEN-LAST:event_formKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornaJanelaPai();
    }//GEN-LAST:event_formWindowClosed

private void jb_pesquisa_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_pesquisa_clienteActionPerformed
    ConsultaClienteAtendimento consultaCliente = new ConsultaClienteAtendimento();
    consultaCliente.janelapaiDevolucao = this;
    consultaCliente.setVisible(true);    
    consultaCliente.jtf_consulta.setText(jtf_nome_cliente.getText());
    this.setStatusTela(false);
    // TODO add your handling code here:
}//GEN-LAST:event_jb_pesquisa_clienteActionPerformed

private void jtf_nome_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_clienteKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_F5) {
        jb_pesquisa_cliente.doClick();
    }
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jb_pesquisa_cliente.doClick();
    }
    acionarAtalho(evt);
}//GEN-LAST:event_jtf_nome_clienteKeyPressed

    private void jtf_total_a_pagarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_a_pagarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_a_pagarFocusGained

    private void jtf_total_a_pagarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_a_pagarFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_a_pagarFocusLost

    private void jtf_saldoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_saldoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_saldoFocusGained

    private void jtf_saldoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_saldoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_saldoFocusLost

    private void jtf_valor_total_relocacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_total_relocacaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_total_relocacaoFocusGained

    private void jtf_valor_total_relocacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_total_relocacaoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_total_relocacaoFocusLost

    private void jb_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_sairActionPerformed
        retornaJanelaPai();
    }//GEN-LAST:event_jb_sairActionPerformed

    private void jb_pesquisa_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_pesquisa_clienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_pesquisa_cliente.doClick();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_pesquisa_clienteKeyPressed

    private void jb_finalizar_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_finalizar_devolucaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_finalizar_devolucao.doClick();
        }
        acionarAtalho(evt);

        // TODO add your handling code here:
    }//GEN-LAST:event_jb_finalizar_devolucaoKeyPressed

    private void jb_sairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_sairKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_sair.doClick();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_sairKeyPressed

    private void jb_limpar_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_limpar_devolucaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_limpar_devolucao.doClick();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_limpar_devolucaoKeyPressed

    private void jtf_total_desconto_entrega_antecipadaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_desconto_entrega_antecipadaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_desconto_entrega_antecipadaFocusGained

    private void jtf_total_desconto_entrega_antecipadaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_desconto_entrega_antecipadaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_desconto_entrega_antecipadaFocusLost

    private void jb_pesquisa_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_pesquisa_devolucaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_pesquisa_devolucao.doClick();
        }
        acionarAtalho(evt);        
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_pesquisa_devolucaoKeyPressed

    private void jb_pesquisa_devolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_pesquisa_devolucaoActionPerformed
        if(consultaCopiaDevolucao == null){
            consultaCopiaDevolucao = new ConsultaCopiaDevolucao();
            consultaCopiaDevolucao.janelapaiDevolucao = this;
            consultaCopiaDevolucao.setVisible(true);
            setStatusTela(false);            
        } else {
            consultaCopiaDevolucao.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_pesquisa_devolucaoActionPerformed

    private void jtf_codigo_objeto_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_codigo_objeto_devolucaoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            consultarCopiaLocada(jtf_codigo_objeto_devolucao.getText().trim());
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            jb_pesquisa_devolucao.doClick();
        } 
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_codigo_objeto_devolucaoKeyPressed

    private void jtbl_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_devolucaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            removeObjeto(jtbl_devolucao);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_devolucaoKeyPressed

    private void jb_adicionar_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_adicionar_devolucaoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_adicionar_devolucao.doClick();
        }
    }//GEN-LAST:event_jb_adicionar_devolucaoKeyPressed

    private void jb_remover_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_remover_devolucaoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_remover_devolucao.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_remover_devolucaoKeyPressed

    private void jtf_total_a_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_total_a_pagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_a_pagarActionPerformed

    private void jb_adicionar_devolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_adicionar_devolucaoActionPerformed
        try {
                if (itemDevolucao != null) {
                    adicionarItemDevolvido(itemDevolucao);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Código do Objeto deve ser número");
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_devolucaoActionPerformed

    private void jb_remover_devolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_remover_devolucaoActionPerformed
        removeObjeto(jtbl_devolucao);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_remover_devolucaoActionPerformed

    private void jb_finalizar_devolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_finalizar_devolucaoActionPerformed
        abrirCaixa();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_finalizar_devolucaoActionPerformed

    private void jb_limpar_devolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_limpar_devolucaoActionPerformed
        limparDados();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_limpar_devolucaoActionPerformed

    private void jb_recebimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_recebimentoActionPerformed
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.FinanceiroReceber");

        try {
            if (acesso.getEscrever() == false) {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            } else if (acesso.getEscrever() == true) {
                if(jtf_codigo_cliente.getText().equals("")){
                    financeiroReceber = new FinanceiroReceber();
                }else {
                    financeiroReceber = new FinanceiroReceber(dependente);                    
                }
                financeiroReceber.janelapai3 = this;
                financeiroReceber.setVisible(true);
                setStatusTela(false);
                financeiroReceber.acesso = acesso;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage() + " Entre em contato com o administrador do sistema.");
            ex.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_recebimentoActionPerformed
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

            // testando se ha discrepancia entre a data que foi
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
        }
        return (true);
    }

    public boolean validaDataVencimento(String dataString) throws ParseException {
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
                // dia nao caso
                return false;
            } else if ((new Integer(mes)).intValue() != (new Integer(cal.get(Calendar.MONTH) + 1)).intValue()) {
                // mes nao casou
                return false;
            } else if ((new Integer(ano)).intValue() != (new Integer(cal.get(Calendar.YEAR))).intValue()) {
                // ano nao casou
                return false;
            } else if (dataAtual.after(dataDigitada)) {
                // data maior que atual
                return false;
            }
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new AtendimentoDevolucao().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JButton jb_adicionar_devolucao;
    private javax.swing.JButton jb_finalizar_devolucao;
    private javax.swing.JButton jb_limpar_devolucao;
    private javax.swing.JButton jb_pesquisa_cliente;
    private javax.swing.JButton jb_pesquisa_devolucao;
    private javax.swing.JButton jb_recebimento;
    public static javax.swing.JButton jb_remover_devolucao;
    private javax.swing.JButton jb_sair;
    private javax.swing.JLabel jl_codigo_devolucao;
    public static javax.swing.JLabel jl_debito_devolucao;
    public static javax.swing.JLabel jl_lancamento_aberto;
    public static javax.swing.JTable jtbl_devolucao;
    public static javax.swing.JTextField jtf_codigo_cliente;
    public static javax.swing.JTextField jtf_codigo_objeto_devolucao;
    public static javax.swing.JTextField jtf_nome_cliente;
    public static javax.swing.JTextField jtf_nome_objeto_devolucao;
    public static javax.swing.JTextField jtf_saldo;
    public static javax.swing.JTextField jtf_total_a_pagar;
    public static javax.swing.JTextField jtf_total_desconto_entrega_antecipada;
    public static javax.swing.JTextField jtf_valor_total_relocacao;
    // End of variables declaration//GEN-END:variables

    public void abrirCaixa(){
        if (verificarCampos() == true) {
            EntradaCaixaDevolucao entradaCaixaDevolucao = new EntradaCaixaDevolucao();
            entradaCaixaDevolucao.janelapaiDevolucao = this;
            entradaCaixaDevolucao.setVisible(true);
            setStatusTela(false);
        }
    }
    
    public void removeObjeto(JTable tb) {
        if (tb != null) {
            DefaultTableModel row = (DefaultTableModel) jtbl_devolucao.getModel();
            if (tb.getSelectedRow() != -1) {
                int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_NO_OPTION) {
                    int index_remove = tb.getSelectedRow();
                    System.out.println("Linha deletada: " + index_remove);
                    
                    itensDevolucao.remove(index_remove);
                    row.removeRow(tb.getSelectedRow());
                    recalcularValores();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um Objeto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tabela vazia");
        }
    }

    public boolean verificarCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_codigo_cliente.getText().equals("")) {
            msgERRO = msgERRO + " *Cliente\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jtf_codigo_objeto_devolucao.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public String convertMilisHora(long resultado) {
        long conversaoSegundos = TimeUnit.MILLISECONDS.toSeconds(resultado);
        String retornodeHoras;
        int hr = (int) (conversaoSegundos / 3600);
        int rem = (int) (conversaoSegundos % 3600);
        int mn = rem / 60;
        int sec = rem % 60;
        String hrStr = (hr < 10 ? "0" : "") + hr;
        String mnStr = (mn < 10 ? "0" : "") + mn;
        String secStr = (sec < 10 ? "0" : "") + sec;
        retornodeHoras = (hrStr + ":" + mnStr + ":" + secStr);
        return retornodeHoras;
    }

    public Double calcularDescontoEntregaAntecipado(ItemLocacao itemLocacao) {
        Double desconto_entrega_antecipada = 0.00;
        String retornodeHoras;
        Calendar cal;
        long resultado;
        try {
            pool = new Pool();
            diariaDAO = new DiariaDAO(pool);
            promocoesDevolucao = null;
            promocoesDevolucao = diariaDAO.getDiariaPromocaoDevolucao(itemLocacao.getCopia().getDiaria());

            DateFormat df_data_hora_locada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            DateFormat df_data = new java.text.SimpleDateFormat("dd/MM/yyyy");
            DateFormat df_hora = new SimpleDateFormat("HH:mm:ss");
            System.out.println("===============Calculo Desconto Entrega Antecipada=============");
            System.out.println("Data e Hora Locada: " + df_data_hora_locada.format(itemLocacao.getData_locacao()));

            if (promocoesDevolucao.size() > 0) {

                for (int i = 0; i < promocoesDevolucao.size(); i++) {
                    System.out.println("===============Inicio Calculo=============");
                    String df_horario_locacao = promocoesDevolucao.get(i).getPromocaoDevolucao().getHorario_locacao();
                    String df_horario_devolucao = promocoesDevolucao.get(i).getPromocaoDevolucao().getHorario_devolucao();
                    String df_horas_antecipada = promocoesDevolucao.get(i).getPromocaoDevolucao().getHora_antecipada();

                    Date horario_locacao;
                    Date horario_devolucao;
                    Date horas_antecipada = df_hora.parse(df_horas_antecipada);

                    cal = Calendar.getInstance();
                    cal.setTime(itemLocacao.getData_locacao());
                    cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));
                    String data = new SimpleDateFormat("dd/MM/yyyy").format(cal.getTime());

                    String data_locacao_promocao = data + " " + df_horario_locacao;
                    horario_locacao = df_data_hora_locada.parse(data_locacao_promocao);
                    System.out.println("Horário Locação: " + df_data_hora_locada.format(horario_locacao));

                    Date data_devolucao = Calendar.getInstance().getTime();
                    Date horas_24 = df_hora.parse("24:00:00");

                    //Transformar a data apenas em horas
                    resultado = 0;
                    resultado = itemLocacao.getData_locacao().getTime();
                    retornodeHoras = convertMilisHora(resultado);
                    Date data_locacao = df_hora.parse(retornodeHoras);

                    //Tempo gasto para devolver                    
                    resultado = 0;
                    resultado = data_devolucao.getTime() - itemLocacao.getData_locacao().getTime();
                    retornodeHoras = convertMilisHora(resultado);
                    Date quantidade_horas_antecipada = df_hora.parse(retornodeHoras);

                    //Horas antecipadas
                    Calendar cal_hora_antecipada = Calendar.getInstance();
                    cal_hora_antecipada.setTime(horas_antecipada);

                    //Adicionar as horas de antecipacao no horario de locacao e inserir em nova variavel
                    cal = Calendar.getInstance();
                    cal.setTime(horario_locacao);
                    cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + cal_hora_antecipada.get(Calendar.HOUR_OF_DAY));
                    cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + cal_hora_antecipada.get(Calendar.MINUTE));
                    cal.set(Calendar.SECOND, cal.get(Calendar.SECOND) + cal_hora_antecipada.get(Calendar.SECOND));

                    System.out.println("Previsão de Entrega: " + df_data_hora_locada.format(cal.getTime()));

                    System.out.println("Horas antecipadas para Entrega: " + df_hora.format(horas_antecipada));
                    horas_antecipada = cal.getTime();
                    Calendar hora_atual = Calendar.getInstance();

                    Calendar data_inicial = Calendar.getInstance();
                    data_inicial.setTime(horario_locacao);
                    data_inicial.set(Calendar.HOUR_OF_DAY, 0);
                    data_inicial.set(Calendar.MINUTE, 0);
                    data_inicial.set(Calendar.SECOND, 0);
                    data_inicial.set(Calendar.MILLISECOND, 0);
                    data_inicial.getTime();

                    Calendar data_final = Calendar.getInstance();
                    data_final.setTime(horas_antecipada);
                    data_final.set(Calendar.HOUR_OF_DAY, 0);
                    data_final.set(Calendar.MINUTE, 0);
                    data_final.set(Calendar.SECOND, 0);
                    data_final.set(Calendar.MILLISECOND, 0);
                    data_final.getTime();

                    System.out.println("Verificar se a Entrega será em dias diferentes: " + (data_final.after(data_inicial)));

                    if (data_final.after(data_inicial)) {

                        cal = Calendar.getInstance();
                        cal.setTime(itemLocacao.getData_locacao());
                        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
                        String d1 = new SimpleDateFormat("dd/MM/yyyy").format(cal.getTime());

                        String data_devolucao_promocao = d1 + " " + df_horario_devolucao;
                        horario_devolucao = df_data_hora_locada.parse(data_devolucao_promocao);
                        System.out.println("Horário Devolução: " + df_data_hora_locada.format(horario_devolucao));

                    } else {
                        cal = Calendar.getInstance();
                        cal.setTime(itemLocacao.getData_locacao());
                        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));
                        String d1 = new SimpleDateFormat("dd/MM/yyyy").format(cal.getTime());

                        String data_devolucao_promocao = d1 + " " + df_horario_devolucao;
                        horario_devolucao = df_data_hora_locada.parse(data_devolucao_promocao);
                        System.out.println("Horário Devolução: " + df_data_hora_locada.format(horario_devolucao));
                    }

                    System.out.println("Data da Locação ---> " + df_hora.format(itemLocacao.getData_locacao().getTime()));
                    System.out.println("Data da Devolução ---> " + df_hora.format(data_devolucao.getTime()));

                    System.out.println("Condição 1 --> antecipada_permitida >= antecipada  ---> " + (horas_antecipada.getTime() >= quantidade_horas_antecipada.getTime()));
                    if (horas_antecipada.getTime() >= quantidade_horas_antecipada.getTime()) {

                        System.out.println("Condição 2 ---> (data_locacao > horario_locacao) ---> " + (data_locacao.getTime() > horario_locacao.getTime()));
                        System.out.println("Param. 1 ---> " + data_locacao);
                        System.out.println("Param. 2 ---> " + horario_locacao);
                        System.out.println("Condição 2.1 ---> data_locacao < horario_devolucao ---> " + (data_locacao.getTime() < horario_devolucao.getTime()));
                        System.out.println("Param. 1 ---> " + data_locacao);
                        System.out.println("Param. 2 ---> " + horario_devolucao);

                        if (itemLocacao.getData_locacao().getTime() > horario_locacao.getTime() && itemLocacao.getData_locacao().getTime() < horario_devolucao.getTime()) {

                            System.out.println("Condição 3.1 ---> (data_devolucao < horario_devolucao) ---> " + (data_devolucao.getTime() < horario_devolucao.getTime()));
                            System.out.println("Param. 1 ---> " + data_devolucao);
                            System.out.println("Param. 2 ---> " + horario_devolucao);
                            if (data_devolucao.getTime() < horario_devolucao.getTime()) {
                                desconto_entrega_antecipada = promocoesDevolucao.get(i).getPromocaoDevolucao().getValor_promocao_devolucao();
                                System.out.println("Desconto: " + desconto_entrega_antecipada);
                                System.out.println("Com desconto");
                                break;
                            } else {
                                desconto_entrega_antecipada = 0.00;
                                System.out.println("Demorou devolver ");
                            }
                        } else {
                            desconto_entrega_antecipada = 0.00;
                            System.out.println("Fora do periodo de locacao e devolucao");
                        }

                    } else {
                        desconto_entrega_antecipada = 0.00;
                        System.out.println("Tempo excedido");
                    }
                    System.out.println("===============Fim Calculo=============");
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(AtendimentoDevolucao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return desconto_entrega_antecipada;

    }

    public void recalcularValores(){
        moeda = new Moeda();
        Double relocacao = 0.00;
        Double descontos = 0.00;
        Double valor_total;
        
        for(int i = 0; i < jtbl_devolucao.getRowCount(); i++){
            relocacao = relocacao + moeda.getPrecoFormato(jtbl_devolucao.getValueAt(i, 3).toString());
            descontos = descontos + moeda.getPrecoFormato(jtbl_devolucao.getValueAt(i, 5).toString());
        }
        
        Double saldo_debito_anterior;
        
        if(jtf_saldo.getForeground() == Color.RED){
            saldo_debito_anterior = moeda.getPrecoFormato(jtf_saldo.getText());
//            saldo_debito_anterior = saldo_debito_anterior * (-1);
            valor_total = (saldo_debito_anterior + relocacao) - descontos;
            if(valor_total > 0){
                jtf_total_a_pagar.setText(moeda.setPrecoFormat(valor_total.toString()));
            } else {
                jtf_total_a_pagar.setText("R$ 0,00");
            }
        } else {
            saldo_debito_anterior = moeda.getPrecoFormato(jtf_saldo.getText());
            valor_total = (saldo_debito_anterior + descontos) - relocacao;
            if(valor_total > 0){                
                jtf_total_a_pagar.setText("R$ 0,00");
            } else {
//                valor_total = valor_total * (-1);
                jtf_total_a_pagar.setText(moeda.setPrecoFormat(valor_total.toString()));            
            }
        }
        
        jtf_valor_total_relocacao.setText(moeda.setPrecoFormat(relocacao.toString()));
        jtf_total_desconto_entrega_antecipada.setText(moeda.setPrecoFormat(descontos.toString()));
        
    }
    
    public void carregarCopiaDevolucao(ItemLocacao itemDevolucao){
        if(itemDevolucao != null){
            jtf_codigo_objeto_devolucao.setText(itemDevolucao.getCopia().getCodigo_barras());
            jtf_nome_objeto_devolucao.setText(itemDevolucao.getCopia().getObjeto().getTitulo());
            jb_adicionar_devolucao.requestFocus();
        }
        
    }
    
    public void adicionarItemDevolvido(ItemLocacao itemLocacao) {

        moeda = new Moeda();
        DateFormat df_data_hora_locada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        if (itemLocacao != null) {
            if (verificaTabela(itemLocacao) == false) {

                Double desconto_entrega_antecipada;
                
                if(itemLocacao.getValor_multa() > 0){
                    desconto_entrega_antecipada = 0.00;
                } else if (itemLocacao.getCopia().getDiaria().getPromocaoLocacao().getCodigo_promocao_locacao() == 0){
                    desconto_entrega_antecipada = calcularDescontoEntregaAntecipado(itemLocacao);                                        
                }else {
                    desconto_entrega_antecipada = 0.00;
                }
                
                DefaultTableModel row = (DefaultTableModel) jtbl_devolucao.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(itemLocacao, itemLocacao.getCopia().getObjeto().getTitulo());
                row.addRow(new Object[]{itemLocacao.getCopia().getCodigo_barras(), hashDbGrid, df_data_hora_locada.format(itemLocacao.getData_locacao()),
                    moeda.setPrecoFormat(itemLocacao.getValor_multa().toString()), itemLocacao.getDias_multa(),
                    moeda.setPrecoFormat(desconto_entrega_antecipada.toString())});
                
                recalcularValores();
                itensDevolucao.add(itemLocacao);
                itemDevolucao = null;
                limparItemDevolvido();
            } else {
                JOptionPane.showMessageDialog(null, "Esta cópia já foi adicionada");
                jtf_codigo_objeto_devolucao.requestFocus();
            }
        } 
    }

    public void limparItemDevolvido() {
        jtf_codigo_objeto_devolucao.setText("");
        jtf_nome_objeto_devolucao.setText("");
        jtf_codigo_objeto_devolucao.requestFocus();
    }

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    public void carregarClienteDependente(Dependente dependente) {
        if (dependente != null) {
            this.dependente = dependente;
            System.out.println("Tipo: "+ dependente.getTipo_dependente());
            jtf_saldo.setText("R$ 0,00");

            jtf_nome_cliente.setText(dependente.getNome_dependente());
            setTitle("Atendimento Devolução - " + dependente.getNome_dependente());
            jtf_codigo_cliente.setText(String.valueOf(dependente.getCliente().getCodigo_cliente()));
            moeda = new Moeda();

            pool = new Pool();
            lancamentos = new ArrayList<Lancamento>();
            LancamentoDAO lancamentoDAO = new LancamentoDAO(pool);
            lancamentos = lancamentoDAO.getLancamentos(dependente.getCliente());
            
            Double saldo = 0.00;
            Double devedor = 0.00;
            int quantidade_lancamento_aberto = 0;
            for (int i = 0; i < lancamentos.size(); i++) {
                if (lancamentos.get(i).getTipoServico().getTipo().equals("C")) {
                    saldo = saldo + lancamentos.get(i).getSaldo();
                } else {
                    if (lancamentos.get(i).getDevedor() > 0) {
                        quantidade_lancamento_aberto = quantidade_lancamento_aberto + 1;
                    }
                    devedor = devedor + lancamentos.get(i).getDevedor();
                }
            }
            
            jtf_saldo.setText(moeda.setPrecoFormat(String.valueOf(saldo.toString())));
            jl_lancamento_aberto.setText("Pendente: "+quantidade_lancamento_aberto);

            jtf_codigo_objeto_devolucao.requestFocus();

            //Limpa tabela depois de selecionar novo cliente
            DefaultTableModel tb_devolucao = (DefaultTableModel) jtbl_devolucao.getModel();
            int rows = tb_devolucao.getRowCount();
            for (int i = rows - 1; i >= 0; i--) {
                tb_devolucao.removeRow(i);
            }

            jtf_total_a_pagar.setText("R$ 0,00");
            itensDevolucao = new ArrayList<ItemLocacao>();
        }
    }

    public void consultarCopiaLocada(String codigo_barras) {
        try {
            pool = new Pool();
            LocacaoDAO locacaoDAO = new LocacaoDAO(pool);

            itemDevolucao = new ItemLocacao();
            if (!codigo_barras.equals("")) {
                if (jtf_codigo_cliente.getText().equals("")) {
                    itemDevolucao = locacaoDAO.getLocacaoAberta(codigo_barras);
                    if (itemDevolucao != null) {
                        carregarClienteDependente(itemDevolucao.getDependente());
                        carregarCopiaDevolucao(itemDevolucao);
                    } else {
                        JOptionPane.showMessageDialog(null, "Código de Barra inválido");
                    }
                } else {
                    itemDevolucao = locacaoDAO.getLocacaoAberta(dependente.getCodigo_dependente(), codigo_barras);
                    if (itemDevolucao != null) {
                        carregarCopiaDevolucao(itemDevolucao);
                    } else {
                        JOptionPane.showMessageDialog(null, "Código de Barra inválido para Cliente");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Código de Barra inválido");
                System.out.print("Código de barras vazio");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas com a consulta");
            ex.printStackTrace();
        }
    }

    public void devolver_consulta_codigo_objeto(String codigo_barras) {
        if (!codigo_barras.equals("")) {
            itemDevolucao = new ItemLocacao();
            if (itemDevolucao != null) {
                carregarCopiaDevolucao(itemDevolucao);
            } else {
                JOptionPane.showMessageDialog(null, "Código de Barra inválido");
            }
        }
    }

    public boolean verificaTabela(ItemLocacao itemLocacao) {

        boolean tabela = true;
        if (jtbl_devolucao.getRowCount() == 0) {
            return false;

        } else if (jtbl_devolucao.getRowCount() > 0) {
            int linhas = jtbl_devolucao.getRowCount();

            for (int i = 0; i < linhas; i++) {
                tabela = itemLocacao.getCopia().getCodigo_barras().equals(jtbl_devolucao.getValueAt(i, 0));
                if (tabela == true) {
                    break;
                }
            }
        }

        return tabela;
    }
       
    private void retornaJanelaPai() {
        setVisible(false);
        if (janelapai != null) {
            janelapai.setStatusTela(true);
            janelapai.atendimentoDevolucao = null;
            janelapai = null;
        }
    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            jb_finalizar_devolucao.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            retornaJanelaPai();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            jb_remover_devolucao.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            jb_recebimento.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F6) {
            ConsultaCopiaLocacao copiaCliente = new ConsultaCopiaLocacao();
            copiaCliente.janelapai2 = this;
            copiaCliente.setVisible(true);
            setStatusTela(false);
        }
        
    }

    private void limparDados() {
        jtf_codigo_cliente.setText("");
        jtf_nome_cliente.setText("");
        jtf_total_a_pagar.setText("R$ 0,00");
        jtf_total_desconto_entrega_antecipada.setText("R$ 0,00");
        jtf_saldo.setText("R$ 0,00");

        DefaultTableModel tb_devolucao = (DefaultTableModel) jtbl_devolucao.getModel();
        int rows = tb_devolucao.getRowCount();
        for (int i = rows - 1; i >= 0; i--) {
            tb_devolucao.removeRow(i);
        }
        jtf_codigo_objeto_devolucao.setText("");
        jtf_codigo_objeto_devolucao.requestFocus();
    }

}
