package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Devolucao;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.Locacao;
import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.bean.OcorrenciaDanificado;
import br.com.locadora.model.bean.TipoServico;
import br.com.locadora.model.bean.Venda;
import br.com.locadora.model.dao.CopiaDAO;
import br.com.locadora.model.dao.DiariaDAO;
import br.com.locadora.model.dao.LancamentoDAO;
import br.com.locadora.model.dao.LocacaoDAO;
import br.com.locadora.model.dao.OcorrenciaDanificadoDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
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
import javax.swing.text.MaskFormatter;

public class LancamentoOcorrencia extends javax.swing.JFrame {

    public DecimalFormat formatoPreco;
    public MaskFormatter formatoData;
    public Cliente cliente;
    public static Dependente dependente = new Dependente();
    public Objeto objeto;
    public Copia copiaDevolucao;
    public static List<Copia> copiasLocacao = new ArrayList<Copia>();
    public InterfacePool pool;
    public TelaPrincipal janelapai;
    public ItemLocacao itemDevolucao;
    public Moeda moeda;
    public Lancamento lancamento;
    public AcessoUsuario acesso;
    public DiariaDAO diariaDAO;
    public ConsultaCopiaDevolucao consultaCopiaDevolucao;
    public List<Lancamento> lancamentos;
    public FinanceiroReceber financeiroReceber;
    public LancamentoDAO lancamentoDAO;

    public LancamentoOcorrencia() {
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
        jl_codigo_devolucao = new javax.swing.JLabel();
        jtf_codigo_objeto_devolucao = new javax.swing.JTextField();
        jb_pesquisa_devolucao = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtf_nome_objeto_devolucao = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jta_observacao = new javax.swing.JTextArea();
        jl_codigo_devolucao1 = new javax.swing.JLabel();
        jl_codigo_devolucao2 = new javax.swing.JLabel();
        jtf_valor_locado = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jb_limpar_devolucao = new javax.swing.JButton();
        jb_salvar = new javax.swing.JButton();
        jb_sair = new javax.swing.JButton();

        jDesktopPane1.setName("jDesktopPane1"); // NOI18N

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_pesquisa_cliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_codigo_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Item"));
        jPanel3.setName("jPanel3"); // NOI18N

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

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel3.setText("Nome Objeto");
        jLabel3.setName("jLabel3"); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(300, 18));

        jtf_nome_objeto_devolucao.setEditable(false);
        jtf_nome_objeto_devolucao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_nome_objeto_devolucao.setName("jtf_nome_objeto_devolucao"); // NOI18N
        jtf_nome_objeto_devolucao.setPreferredSize(new java.awt.Dimension(300, 24));

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        jta_observacao.setColumns(20);
        jta_observacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jta_observacao.setLineWrap(true);
        jta_observacao.setRows(6);
        jta_observacao.setWrapStyleWord(true);
        jta_observacao.setName("jta_observacao"); // NOI18N
        jta_observacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jta_observacaoKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(jta_observacao);

        jl_codigo_devolucao1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jl_codigo_devolucao1.setText("Observação*");
        jl_codigo_devolucao1.setName("jl_codigo_devolucao1"); // NOI18N
        jl_codigo_devolucao1.setPreferredSize(new java.awt.Dimension(120, 18));

        jl_codigo_devolucao2.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jl_codigo_devolucao2.setText("Preço Locado");
        jl_codigo_devolucao2.setName("jl_codigo_devolucao2"); // NOI18N
        jl_codigo_devolucao2.setPreferredSize(new java.awt.Dimension(120, 18));

        jtf_valor_locado.setEditable(false);
        jtf_valor_locado.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_valor_locado.setText("R$ 0,00");
        jtf_valor_locado.setName("jtf_valor_locado"); // NOI18N
        jtf_valor_locado.setPreferredSize(new java.awt.Dimension(120, 24));
        jtf_valor_locado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_valor_locadoActionPerformed(evt);
            }
        });
        jtf_valor_locado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_valor_locadoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_valor_locado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_codigo_devolucao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_codigo_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_codigo_objeto_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                                    .addComponent(jtf_nome_objeto_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jb_pesquisa_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jl_codigo_devolucao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_codigo_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtf_nome_objeto_devolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtf_codigo_objeto_devolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jb_pesquisa_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jl_codigo_devolucao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jtf_valor_locado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jl_codigo_devolucao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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

        jb_salvar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/save.png"))); // NOI18N
        jb_salvar.setText("Salvar\n");
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
                .addGap(80, 80, 80)
                .addComponent(jb_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jb_limpar_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_limpar_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_nome_cliente.requestFocus();
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
    consultaCliente.janelapaiOcorrencia = this;
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

    private void jb_salvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_salvarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_salvar.doClick();
        }
        acionarAtalho(evt);

        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarKeyPressed

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

    private void jb_pesquisa_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_pesquisa_devolucaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_pesquisa_devolucao.doClick();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_pesquisa_devolucaoKeyPressed

    private void jb_pesquisa_devolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_pesquisa_devolucaoActionPerformed
        if (consultaCopiaDevolucao == null) {
            consultaCopiaDevolucao = new ConsultaCopiaDevolucao();
            consultaCopiaDevolucao.janelapaiOcorrencia = this;
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

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        cadastrarOcorrenciaDanificado();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarActionPerformed

    private void jb_limpar_devolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_limpar_devolucaoActionPerformed
        limparCampos();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_limpar_devolucaoActionPerformed

    private void jta_observacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jta_observacaoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_salvar.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jta_observacaoKeyPressed

    private void jtf_valor_locadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_locadoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_locadoKeyPressed

    private void jtf_valor_locadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_valor_locadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_locadoActionPerformed
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

                new LancamentoOcorrencia().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jb_limpar_devolucao;
    private javax.swing.JButton jb_pesquisa_cliente;
    private javax.swing.JButton jb_pesquisa_devolucao;
    private javax.swing.JButton jb_sair;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JLabel jl_codigo_devolucao;
    private javax.swing.JLabel jl_codigo_devolucao1;
    private javax.swing.JLabel jl_codigo_devolucao2;
    public static javax.swing.JTextArea jta_observacao;
    public static javax.swing.JTextField jtf_codigo_cliente;
    public static javax.swing.JTextField jtf_codigo_objeto_devolucao;
    public static javax.swing.JTextField jtf_nome_cliente;
    public static javax.swing.JTextField jtf_nome_objeto_devolucao;
    public static javax.swing.JTextField jtf_valor_locado;
    // End of variables declaration//GEN-END:variables

    public boolean verificarCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_codigo_cliente.getText().equals("")) {
            msgERRO = msgERRO + " *Cliente\n";
        }
        if (jtf_nome_objeto_devolucao.getText().equals("")) {
            msgERRO = msgERRO + " *Objeto\n";
        }
        if (jta_observacao.getText().trim().length() == 0) {
            msgERRO = msgERRO + " *Observação\n";
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

    public void carregarCopiaDevolucao(ItemLocacao itemDevolucao) {
        if (itemDevolucao != null) {
            moeda = new Moeda();
            jtf_codigo_objeto_devolucao.setText(itemDevolucao.getCopia().getCodigo_barras());
            jtf_nome_objeto_devolucao.setText(itemDevolucao.getCopia().getObjeto().getTitulo());
            jtf_valor_locado.setText(moeda.setPrecoFormat(itemDevolucao.getValor_locado().toString()));
            jta_observacao.requestFocus();
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

            jtf_nome_cliente.setText(dependente.getNome_dependente());
            setTitle("Ocorrência Danificado - " + dependente.getNome_dependente());
            jtf_codigo_cliente.setText(String.valueOf(dependente.getCliente().getCodigo_cliente()));
            moeda = new Moeda();

            pool = new Pool();
            lancamentos = new ArrayList<Lancamento>();
            LancamentoDAO lancamentoDAO = new LancamentoDAO(pool);
            lancamentos = lancamentoDAO.getLancamentos(dependente.getCliente());

            jtf_codigo_objeto_devolucao.requestFocus();
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

    private void retornaJanelaPai() {
        setVisible(false);
        if (janelapai != null) {
            janelapai.setStatusTela(true);
            janelapai.ocorrenciaDanificado = null;
            janelapai = null;
        }
    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            jb_salvar.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            retornaJanelaPai();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
//            jb_remover_devolucao.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F6) {
            ConsultaCopiaLocacao copiaCliente = new ConsultaCopiaLocacao();
//            copiaCliente.janelapai2 = this;
            copiaCliente.setVisible(true);
            setStatusTela(false);
        }

    }

    private void limparCampos() {
        jtf_codigo_cliente.setText("");
        jtf_nome_cliente.setText("");
        jtf_codigo_objeto_devolucao.setText("");
        jtf_nome_objeto_devolucao.setText("");
        jtf_valor_locado.setText("R$ 0,00");
        jta_observacao.setText("");
        this.setTitle("Ocorrência Danificado");
        jtf_nome_cliente.requestFocus();
    }

    public void cadastrarOcorrenciaDanificado() {

        if (verificarCampos() == true) {
            moeda = new Moeda();
            Double valor_locado = moeda.getPrecoFormato(jtf_valor_locado.getText());
            if (valor_locado != 0) {

                try {
                    ArquivoConfiguracao conf = new ArquivoConfiguracao();

                    OcorrenciaDanificado ocorrencia = new OcorrenciaDanificado();
                    ocorrencia.setDependente(dependente);
                    ocorrencia.setUsuario(acesso.getUsuario());
                    ocorrencia.setCopia(itemDevolucao.getCopia());
                    ocorrencia.setObservacao(jta_observacao.getText());

                    pool = new Pool();
                    OcorrenciaDanificadoDAO ocorreciaDAO = new OcorrenciaDanificadoDAO(pool);
                    ocorreciaDAO.salvar(ocorrencia);

                    lancamento = new Lancamento();
                    lancamento.setValor_pago(0.00);
                    lancamento.setSaldo_dia(0.00);
                    lancamento.setDesconto(0.00);
                    lancamento.setDesconto_entrega_antecipada(0.00);
                    lancamento.setValor_total(moeda.getPrecoFormato(jtf_valor_locado.getText()));
                    lancamento.setTroco(0.00);
                    lancamento.setValor_total_a_pagar(0.00);
                    lancamento.setDependente(dependente);
                    TipoServico tipoServico;
                    tipoServico = new TipoServico();
                    tipoServico.setCodigo_tipo_servico(15);
                    lancamento.setTipoServico(tipoServico);
                    lancamento.setUsuario(acesso.getUsuario());
                    lancamento.setCaixa(Integer.parseInt(conf.readPropertie("caixa")));
                    lancamento.setLocacao(new Locacao());
                    lancamento.setDevolucao(new Devolucao());
                    lancamento.setVenda(new Venda());

                    pool = new Pool();
                    lancamentoDAO = new LancamentoDAO(pool);
                    lancamento = lancamentoDAO.salvarLancamento(lancamento);

                    Calendar data_atual = Calendar.getInstance();

                    pool = new Pool();
                    List<Lancamento> lancamentos = new ArrayList<Lancamento>();
                    LancamentoDAO lancamentoDAO = new LancamentoDAO(pool);
                    lancamentos = lancamentoDAO.getLancamentos(dependente.getCliente());

                    List<ItemLocacao> itens = new ArrayList();

                    Copia copia;
                    copia = new Copia();
                    copia.setCodigo_copia(itemDevolucao.getCopia().getCodigo_copia());
                    copia.setStatus("0");

                    Date data = new Date();
                    data.setDate(data.getDate());

                    itemDevolucao.setData_devolucao(data);
                    itens.add(itemDevolucao);

                    pool = new Pool();
                    CopiaDAO copiaDAO = new CopiaDAO(pool);
                    copiaDAO.alterarStatusFilme(copia);

                    pool = new Pool();
                    LocacaoDAO locacaoDAO = new LocacaoDAO(pool);
                    locacaoDAO.salvarDevolucao(itens);

                    limparCampos();
                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido: " + e.getMessage());

                    e.printStackTrace();
                } catch (SQLException ex) {
                    Logger.getLogger(EntradaCaixaDevolucao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else {
                JOptionPane.showMessageDialog(null, "Não é possível gerar Ocorrência Danificado para valor locadora R$ 0,00");
            }
        }
    }
}
