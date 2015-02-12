package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.Combo;
import br.com.locadora.model.bean.Feriado;
import br.com.locadora.model.bean.ItemLocacao;
import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.bean.PromocaoLocacao;
import br.com.locadora.model.dao.CopiaDAO;
import br.com.locadora.model.dao.DependenteDAO;
import br.com.locadora.model.dao.DiariaDAO;
import br.com.locadora.model.dao.LancamentoDAO;
import br.com.locadora.model.dao.ComboDAO;
import br.com.locadora.model.dao.FeriadoDAO;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.LimitadorTexto;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.data.excel.ExcelFormatFieldHandler;

public class AtendimentoLocacao extends javax.swing.JFrame {

    public Dependente dependente;
    public List<Copia> copias;
    public List<Copia> copiasLocacao;
    public Copia copiaAtendimento;
    public InterfacePool pool;
    public TelaPrincipal janelapai;
    public Moeda moeda;
    public Lancamento lancamento;
    public AcessoUsuario acesso;
    public List<Diaria> promocoes;
    public Diaria diariaCombo;
    public PromocaoLocacao promocao;
    public DiariaDAO diariaDAO;
    public CopiaDAO copiaDAO;
    public List<Combo> itensPacotePromocional;
    public ComboDAO pacotePromocionalDAO;
    public List<Lancamento> lancamentos;
    public FinanceiroReceber financeiroReceber;
    public List<Feriado> feriados;

    public AtendimentoLocacao() {
        initComponents();
        TemaInterface.getInterface(this);
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
        jb_cliente = new javax.swing.JButton();
        jp_locacao = new javax.swing.JPanel();
        /*try  {          
            Locale BRAZIL = new Locale("pt","BR");  
            DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
            formatoPreco = new DecimalFormat("¤ ###,###,##0.00",REAL);  
        }    catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        */
        jtf_valor_locacao = new javax.swing.JTextField();
        jtf_tipo_midia = new javax.swing.JTextField(new LimitadorTexto(11), "",10);
        jtf_diaria = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_locacao = new javax.swing.JTable();
        jtf_nome_objeto_locacao = new javax.swing.JTextField();
        jl_codigo_locacao = new javax.swing.JLabel();
        jtf_codigo_objeto_locacao = new javax.swing.JTextField();
        jb_pesquisa_locacao = new javax.swing.JButton();
        jb_adicionar_locacao = new javax.swing.JButton();
        jb_remover_locacao = new javax.swing.JButton();
        jcb_codigo_barras_locacao = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jcb_promocao = new javax.swing.JComboBox();
        jl_total_filmes = new javax.swing.JLabel();
        jl_lancamento_aberto = new javax.swing.JLabel();
        jl_debito_locacao = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jtf_saldo = new javax.swing.JTextField();
        jtf_total_locacao = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jb_finalizar_locacao = new javax.swing.JButton();
        jb_limpar_locacao = new javax.swing.JButton();
        jb_sair = new javax.swing.JButton();
        jb_recebimento = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jtf_total_a_pagar = new javax.swing.JTextField();

        jDesktopPane1.setName("jDesktopPane1"); // NOI18N
        jDesktopPane1.setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atendimento Locação");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_codigo_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_codigo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0))
        );

        jp_locacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens Locação"));
        jp_locacao.setName("jp_locacao"); // NOI18N

        jtf_valor_locacao.setEditable(false);
        jtf_valor_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_valor_locacao.setText("R$ 0,00");
        jtf_valor_locacao.setName("jtf_valor_locacao"); // NOI18N
        jtf_valor_locacao.setPreferredSize(new java.awt.Dimension(0, 24));
        jtf_valor_locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_valor_locacaoActionPerformed(evt);
            }
        });
        jtf_valor_locacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_locacaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valor_locacaoFocusLost(evt);
            }
        });

        jtf_tipo_midia.addKeyListener(new java.awt.event.KeyAdapter() {     // cria um listener ouvinte de digitação do fieldNumero

            public void keyReleased(java.awt.event.KeyEvent evt) {  // cria um ouvinte para cada tecla pressionada

                jtf_tipo_midia.setText(jtf_tipo_midia.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que não(^) seja numero  por ""

            }
        });
        jtf_tipo_midia.setEditable(false);
        jtf_tipo_midia.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_tipo_midia.setName("jtf_tipo_midia"); // NOI18N
        jtf_tipo_midia.setPreferredSize(new java.awt.Dimension(0, 24));
        jtf_tipo_midia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_tipo_midiaFocusGained(evt);
            }
        });
        jtf_tipo_midia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_tipo_midiaKeyPressed(evt);
            }
        });

        jtf_diaria.setEditable(false);
        jtf_diaria.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_diaria.setName("jtf_diaria"); // NOI18N
        jtf_diaria.setPreferredSize(new java.awt.Dimension(0, 24));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel3.setText("Nome Objeto");
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel5.setText("Valor");
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel6.setText("Promoção");
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel13.setText("Diária");
        jLabel13.setName("jLabel13"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jtbl_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_locacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód. de Barras", "Nome Objeto", "Valor", "Diária", "Censura", "Promoção", "Data Prevista"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_locacao.setName("jtbl_locacao"); // NOI18N
        jtbl_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_locacaoKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbl_locacao);
        if (jtbl_locacao.getColumnModel().getColumnCount() > 0) {
            jtbl_locacao.getColumnModel().getColumn(0).setPreferredWidth(40);
            jtbl_locacao.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtbl_locacao.getColumnModel().getColumn(2).setPreferredWidth(30);
            jtbl_locacao.getColumnModel().getColumn(3).setPreferredWidth(30);
            jtbl_locacao.getColumnModel().getColumn(4).setPreferredWidth(10);
            jtbl_locacao.getColumnModel().getColumn(6).setPreferredWidth(40);
        }

        jtf_nome_objeto_locacao.setEditable(false);
        jtf_nome_objeto_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_nome_objeto_locacao.setName("jtf_nome_objeto_locacao"); // NOI18N

        jl_codigo_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jl_codigo_locacao.setText("Código de Barras");
        jl_codigo_locacao.setName("jl_codigo_locacao"); // NOI18N

        jtf_codigo_objeto_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_codigo_objeto_locacao.setName("jtf_codigo_objeto_locacao"); // NOI18N
        jtf_codigo_objeto_locacao.setPreferredSize(new java.awt.Dimension(120, 24));
        jtf_codigo_objeto_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_codigo_objeto_locacaoKeyPressed(evt);
            }
        });

        jb_pesquisa_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_pesquisa_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jb_pesquisa_locacao.setName("jb_pesquisa_locacao"); // NOI18N
        jb_pesquisa_locacao.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_pesquisa_locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_pesquisa_locacaoActionPerformed(evt);
            }
        });

        jb_adicionar_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_adicionar_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/adicionar_item.png"))); // NOI18N
        jb_adicionar_locacao.setToolTipText("Incluir");
        jb_adicionar_locacao.setName("jb_adicionar_locacao"); // NOI18N
        jb_adicionar_locacao.setPreferredSize(new java.awt.Dimension(24, 24));
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

        jb_remover_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_remover_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/remove_item.png"))); // NOI18N
        jb_remover_locacao.setToolTipText("Excluir");
        jb_remover_locacao.setName("jb_remover_locacao"); // NOI18N
        jb_remover_locacao.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_remover_locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_remover_locacaoActionPerformed(evt);
            }
        });
        jb_remover_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_remover_locacaoKeyPressed(evt);
            }
        });

        jcb_codigo_barras_locacao.setSelected(true);
        jcb_codigo_barras_locacao.setText("Usar Código de Barras");
        jcb_codigo_barras_locacao.setName("jcb_codigo_barras_locacao"); // NOI18N
        jcb_codigo_barras_locacao.setPreferredSize(new java.awt.Dimension(170, 24));
        jcb_codigo_barras_locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_codigo_barras_locacaoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel7.setText("Tipo Mídia");
        jLabel7.setName("jLabel7"); // NOI18N

        jcb_promocao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_promocao.setMaximumRowCount(20);
        jcb_promocao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        jcb_promocao.setName("jcb_promocao"); // NOI18N
        jcb_promocao.setPreferredSize(new java.awt.Dimension(0, 24));
        jcb_promocao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_promocaoActionPerformed(evt);
            }
        });
        jcb_promocao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcb_promocaoKeyPressed(evt);
            }
        });

        jl_total_filmes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jl_total_filmes.setText("Total de Objetos: 0");
        jl_total_filmes.setName("jl_total_filmes"); // NOI18N

        jl_lancamento_aberto.setForeground(new java.awt.Color(255, 0, 0));
        jl_lancamento_aberto.setText("Pendente: 0");
        jl_lancamento_aberto.setName("jl_lancamento_aberto"); // NOI18N

        javax.swing.GroupLayout jp_locacaoLayout = new javax.swing.GroupLayout(jp_locacao);
        jp_locacao.setLayout(jp_locacaoLayout);
        jp_locacaoLayout.setHorizontalGroup(
            jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_locacaoLayout.createSequentialGroup()
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                        .addComponent(jl_lancamento_aberto, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jl_total_filmes, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_locacaoLayout.createSequentialGroup()
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_locacaoLayout.createSequentialGroup()
                                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_codigo_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_codigo_objeto_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_nome_objeto_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addComponent(jb_pesquisa_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jcb_codigo_barras_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_locacaoLayout.createSequentialGroup()
                                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_valor_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_diaria, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addGap(5, 5, 5)
                                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_tipo_midia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcb_promocao, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jb_adicionar_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jb_remover_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        jp_locacaoLayout.setVerticalGroup(
            jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_locacaoLayout.createSequentialGroup()
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_codigo_locacao)
                            .addComponent(jLabel3))
                        .addGap(0, 0, 0)
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtf_codigo_objeto_locacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtf_nome_objeto_locacao)))
                    .addComponent(jcb_codigo_barras_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_pesquisa_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jp_locacaoLayout.createSequentialGroup()
                            .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtf_tipo_midia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtf_diaria, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcb_promocao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jb_adicionar_locacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_remover_locacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, 0)
                        .addComponent(jtf_valor_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_total_filmes)
                    .addComponent(jl_lancamento_aberto))
                .addGap(0, 0, 0))
        );

        jl_debito_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jl_debito_locacao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jl_debito_locacao.setText("Saldo:");
        jl_debito_locacao.setName("jl_debito_locacao"); // NOI18N

        jLabel27.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Total Locação:");
        jLabel27.setName("jLabel27"); // NOI18N

        jtf_saldo.setEditable(false);
        jtf_saldo.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
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

        jtf_total_locacao.setEditable(false);
        jtf_total_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jtf_total_locacao.setForeground(new java.awt.Color(255, 51, 51));
        jtf_total_locacao.setText("R$ 0,00");
        jtf_total_locacao.setName("jtf_total_locacao"); // NOI18N
        jtf_total_locacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_total_locacaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_total_locacaoFocusLost(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel2.setName("jPanel2"); // NOI18N

        jb_finalizar_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_finalizar_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/finalizar.png"))); // NOI18N
        jb_finalizar_locacao.setText("OK");
        jb_finalizar_locacao.setName("jb_finalizar_locacao"); // NOI18N
        jb_finalizar_locacao.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_finalizar_locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_finalizar_locacaoActionPerformed(evt);
            }
        });
        jb_finalizar_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_finalizar_locacaoKeyPressed(evt);
            }
        });

        jb_limpar_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_limpar_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/limpar.png"))); // NOI18N
        jb_limpar_locacao.setText("Limpar");
        jb_limpar_locacao.setName("jb_limpar_locacao"); // NOI18N
        jb_limpar_locacao.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_limpar_locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_limpar_locacaoActionPerformed(evt);
            }
        });
        jb_limpar_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_limpar_locacaoKeyPressed(evt);
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
                .addGap(30, 30, 30)
                .addComponent(jb_recebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_finalizar_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jb_limpar_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_finalizar_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_recebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_limpar_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/BROADWAY-LOGIN.png"))); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel28.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Total À Pagar:");
        jLabel28.setName("jLabel28"); // NOI18N

        jtf_total_a_pagar.setEditable(false);
        jtf_total_a_pagar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jtf_total_a_pagar.setText("R$ 0,00");
        jtf_total_a_pagar.setName("jtf_total_a_pagar"); // NOI18N
        jtf_total_a_pagar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_total_a_pagarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_total_a_pagarFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jl_debito_locacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(5, 5, 5)
                                .addComponent(jtf_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(5, 5, 5)
                                .addComponent(jtf_total_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jtf_total_a_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jp_locacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(747, 747, 747)
                        .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jp_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_debito_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_total_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_total_a_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (jcb_codigo_barras_locacao.isSelected() == true) {
            jl_codigo_locacao.setText("Código de Barras");
        } else {
            jl_codigo_locacao.setText("Código do Objeto");
        }
        recalcularValorTotal();
        jtf_nome_cliente.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        acionarAtalho(evt);
    }//GEN-LAST:event_formKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornaJanelaPai();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

private void jb_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_clienteActionPerformed
    ConsultaClienteAtendimento consultaCliente = new ConsultaClienteAtendimento();
    consultaCliente.janelapaiLocacao = this;
    consultaCliente.setVisible(true);
    consultaCliente.jtf_consulta.setText(jtf_nome_cliente.getText().trim());
    this.setStatusTela(false);
}//GEN-LAST:event_jb_clienteActionPerformed

private void jtf_nome_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_clienteKeyPressed
    acionarAtalho(evt);
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jb_cliente.doClick();
    }
    if (evt.getKeyCode() == KeyEvent.VK_F5) {
        jb_cliente.doClick();
    }
}//GEN-LAST:event_jtf_nome_clienteKeyPressed

    private void jtf_saldoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_saldoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_saldoFocusLost

    private void jtf_saldoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_saldoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_saldoFocusGained

    private void jtf_total_locacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_locacaoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_locacaoFocusLost

    private void jtf_total_locacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_locacaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_locacaoFocusGained

    private void jb_pesquisa_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_pesquisa_locacaoActionPerformed
        if (jtf_codigo_cliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe primeiro um Cliente");
            jtf_nome_cliente.requestFocus();
        } else {
            ConsultaCopiaLocacao copiaCliente = new ConsultaCopiaLocacao();
            copiaCliente.janelapai = this;
            copiaCliente.setVisible(true);
            setStatusTela(false);
        }
    }//GEN-LAST:event_jb_pesquisa_locacaoActionPerformed

    private void jb_remover_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_remover_locacaoActionPerformed
        removeObjeto(jtbl_locacao);
    }//GEN-LAST:event_jb_remover_locacaoActionPerformed

    private void jtf_tipo_midiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_tipo_midiaKeyPressed

    }//GEN-LAST:event_jtf_tipo_midiaKeyPressed

    private void jtf_tipo_midiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_tipo_midiaFocusGained
        jtf_tipo_midia.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jtf_tipo_midia.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Informe a quantidade");
                    jtf_tipo_midia.requestFocus();
                    return false;
                } else {
                    jtf_diaria.requestFocus();
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_tipo_midiaFocusGained

    private void jtf_valor_locacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_locacaoFocusLost
        moeda = new Moeda();
        jtf_valor_locacao.setText(moeda.setPrecoFormat(jtf_valor_locacao.getText()));
    }//GEN-LAST:event_jtf_valor_locacaoFocusLost

    private void jtf_valor_locacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_locacaoFocusGained
        jtf_valor_locacao.setInputVerifier(new InputVerifier() {

            public boolean verify(JComponent input) {
                if (jtf_valor_locacao.getText().trim().equals("RS")) {
                    JOptionPane.showMessageDialog(null, "Informe o preço");
                    jtf_valor_locacao.requestFocus();
                    return false;
                } else {
                    jtf_tipo_midia.requestFocus();
                    return true;
                }
            }
        });
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_locacaoFocusGained

    private void jtf_codigo_objeto_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_codigo_objeto_locacaoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            consultarObjeto();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            jb_pesquisa_locacao.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_codigo_objeto_locacaoKeyPressed

    private void jb_adicionar_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_adicionar_locacaoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_adicionar_locacao.doClick();
        }
    }//GEN-LAST:event_jb_adicionar_locacaoKeyPressed

    private void jb_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_clienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_cliente.doClick();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_clienteKeyPressed

    private void jb_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_sairActionPerformed
        retornaJanelaPai();
    }//GEN-LAST:event_jb_sairActionPerformed

    private void jb_finalizar_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_finalizar_locacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_finalizar_locacao.doClick();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_finalizar_locacaoKeyPressed

    private void jcb_codigo_barras_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_codigo_barras_locacaoActionPerformed
        if (jcb_codigo_barras_locacao.isSelected() == true) {
            jl_codigo_locacao.setText("Código de Barras");
        } else {
            jl_codigo_locacao.setText("Código do Objeto");
        }
        jtf_codigo_objeto_locacao.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_codigo_barras_locacaoActionPerformed

    private void jcb_promocaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_promocaoKeyPressed
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                jb_adicionar_locacao.requestFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_promocaoKeyPressed

    private void jb_limpar_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_limpar_locacaoActionPerformed
        limparCampos();
        limparItemLocado();
        DefaultTableModel tableModel = (DefaultTableModel) jtbl_locacao.getModel();
        tableModel.setNumRows(0);
    }//GEN-LAST:event_jb_limpar_locacaoActionPerformed

    private void jb_limpar_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_limpar_locacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_limpar_locacao.doClick();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_limpar_locacaoKeyPressed

    private void jtf_valor_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_valor_locacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_locacaoActionPerformed

    private void jb_remover_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_remover_locacaoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_remover_locacao.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_remover_locacaoKeyPressed

    private void jtbl_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_locacaoKeyPressed
        acionarAtalho(evt);
// TODO add your handling code here:
    }//GEN-LAST:event_jtbl_locacaoKeyPressed

    private void jb_sairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_sairKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_sair.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_sairKeyPressed

    private void jb_finalizar_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_finalizar_locacaoActionPerformed
        abrirCaixa();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_finalizar_locacaoActionPerformed

    private void jtf_total_a_pagarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_a_pagarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_a_pagarFocusGained

    private void jtf_total_a_pagarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_a_pagarFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_a_pagarFocusLost

    private void jcb_promocaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_promocaoActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_promocaoActionPerformed

    private void jb_adicionar_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_adicionar_locacaoActionPerformed
        try {
            ItemDbGrid hashDbGrid = (ItemDbGrid) jcb_promocao.getSelectedItem();
            diariaCombo = (Diaria) hashDbGrid.getObjeto();
            adicionarItemLocado(copiaAtendimento, diariaCombo);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código do Objeto deve ser número");
            jtf_codigo_objeto_locacao.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Código do Objeto deve ser número");
            jtf_codigo_objeto_locacao.requestFocus();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_locacaoActionPerformed

    private void jb_recebimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_recebimentoActionPerformed
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.FinanceiroReceber");

        try {
            if (acesso.getEscrever() == false) {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            } else if (acesso.getEscrever() == true) {
                if (jtf_codigo_cliente.getText().equals("")) {
                    financeiroReceber = new FinanceiroReceber();
                } else {
                    financeiroReceber = new FinanceiroReceber(dependente);
                }
                financeiroReceber.janelapai2 = this;
                financeiroReceber.setVisible(true);
                setStatusTela(false);
                financeiroReceber.acesso = acesso;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage() + " Entre em contato com o administrador do sistema.");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_recebimentoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AtendimentoLocacao().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_adicionar_locacao;
    private javax.swing.JButton jb_cliente;
    private javax.swing.JButton jb_finalizar_locacao;
    private javax.swing.JButton jb_limpar_locacao;
    private javax.swing.JButton jb_pesquisa_locacao;
    private javax.swing.JButton jb_recebimento;
    private javax.swing.JButton jb_remover_locacao;
    private javax.swing.JButton jb_sair;
    private javax.swing.JCheckBox jcb_codigo_barras_locacao;
    private javax.swing.JComboBox jcb_promocao;
    private javax.swing.JLabel jl_codigo_locacao;
    private javax.swing.JLabel jl_debito_locacao;
    public static javax.swing.JLabel jl_lancamento_aberto;
    public static javax.swing.JLabel jl_total_filmes;
    public static javax.swing.JPanel jp_locacao;
    public static javax.swing.JTable jtbl_locacao;
    public static javax.swing.JTextField jtf_codigo_cliente;
    private javax.swing.JTextField jtf_codigo_objeto_locacao;
    private javax.swing.JFormattedTextField jtf_diaria;
    public static javax.swing.JTextField jtf_nome_cliente;
    public static javax.swing.JTextField jtf_nome_objeto_locacao;
    public static javax.swing.JTextField jtf_saldo;
    private javax.swing.JTextField jtf_tipo_midia;
    public static javax.swing.JTextField jtf_total_a_pagar;
    public static javax.swing.JTextField jtf_total_locacao;
    private javax.swing.JTextField jtf_valor_locacao;
    // End of variables declaration//GEN-END:variables

    public void consultarObjeto() {
        try {
            if (!jtf_codigo_cliente.getText().equals("")) {
                if (jcb_codigo_barras_locacao.isSelected() == true) {
                    consultarCodigoDeBarras(jtf_codigo_objeto_locacao.getText().trim());
                } else {
                    locar_consulta_codigo_objeto(Integer.parseInt(jtf_codigo_objeto_locacao.getText().trim()));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Informe primeiro um Cliente");
                jtf_codigo_cliente.requestFocus();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Consulta por Código do Objeto inválida.");
        }
    }

    public void consultarCliente() {
        ConsultaCopiaLocacao copiaCliente = new ConsultaCopiaLocacao();
        copiaCliente.janelapai = this;
        copiaCliente.setVisible(true);
        setStatusTela(false);
    }

    private void abrirCaixa() {
        if (verificarCampos() == true) {
            if (jtbl_locacao.getRowCount() > 0) {
                EntradaCaixaLocacao entradaCaixa;
                entradaCaixa = new EntradaCaixaLocacao();
                entradaCaixa.setVisible(true);
                setStatusTela(false);
                entradaCaixa.janelapaiLocacao = this;
            } else {
                JOptionPane.showMessageDialog(null, "Insina um objeto no mínimo");
            }
        }
    }

    public void setJanelaPai(TelaPrincipal janelapai) {
        this.janelapai = janelapai;
    }

    public void limparCampos() {
        jtf_codigo_cliente.setText("");
        jtf_codigo_objeto_locacao.setText("");
        jtf_valor_locacao.setText("");
        jtf_tipo_midia.setText("");
        jtf_diaria.setText("");
    }

    public void removeObjeto(JTable tb) {
        if (tb != null) {
            DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
            if (tb.getSelectedRow() != -1) {
                int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_NO_OPTION) {
                    for (int i = 0; i < copiasLocacao.size(); i++) {
                        System.out.println("Antes de deletar: " + copiasLocacao.get(i).getCodigo_barras());
                    }

                    int index_remove = tb.getSelectedRow();
                    System.out.println("Linha deletada: " + index_remove);
                    row.removeRow(tb.getSelectedRow());
                    copiasLocacao.remove(index_remove);

                    for (int i = 0; i < copiasLocacao.size(); i++) {
                        System.out.println("Depois de deletar: " + copiasLocacao.get(i).getCodigo_barras());
                    }
                    calcularPromocaoLocacao();
                    recalcularValorTotal();
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
            jtf_nome_cliente.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public boolean verificarItemLocacao() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_codigo_objeto_locacao.getText().equals("")) {
            msgERRO = msgERRO + " *Cópia\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jtf_nome_objeto_locacao.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void adicionarItemLocado(Copia copiaAtendimento, Diaria diaria) {
        copiaAtendimento.setDiaria(diaria);
        if (verificarItemLocacao() == true) {
            if (copiaAtendimento.getDiaria().getPacotePromocional().getCodigo_combo() == 0) {
                if (verificaTabela(copiaAtendimento) == false) {
                    pool = new Pool();
                    copiaDAO = new CopiaDAO(pool);
                    String assistido_anteriormente = copiaDAO.getQuantidadeAssistida(dependente.getCodigo_dependente(), copiaAtendimento.getCodigo_barras());

                    if (!"".equals(assistido_anteriormente)) {
                        int selectedOption = JOptionPane.showConfirmDialog(this, assistido_anteriormente, "Atenção", JOptionPane.YES_NO_OPTION);
                        if (selectedOption == JOptionPane.YES_NO_OPTION) {
                            adicionarItemTabela(copiaAtendimento);
                        } else {
                            limparItemLocado();
                            jtf_codigo_objeto_locacao.requestFocus();
                        }
                    } else {
                        adicionarItemTabela(copiaAtendimento);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Última cópia disponível já foi adicionada: " + copiaAtendimento.getCodigo_barras());
                    jtf_codigo_objeto_locacao.requestFocus();
                }
            } else {
                if (verificaTabela(copiaAtendimento) == false) {
                    pool = new Pool();
                    copiaDAO = new CopiaDAO(pool);
                    String assistido_anteriormente = copiaDAO.getQuantidadeAssistida(dependente.getCodigo_dependente(), copiaAtendimento.getCodigo_barras());

                    if (!"".equals(assistido_anteriormente)) {
                        int selectedOption = JOptionPane.showConfirmDialog(this, assistido_anteriormente, "Atenção", JOptionPane.YES_NO_OPTION);
                        if (selectedOption == JOptionPane.YES_NO_OPTION) {
                            adicionarItemTabela(copiaAtendimento);
                        } else {
                            limparItemLocado();
                            jtf_codigo_objeto_locacao.requestFocus();
                        }
                    } else {
                        adicionarItemTabela(copiaAtendimento);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Combo " + copiaAtendimento.getDiaria().getPacotePromocional().getDescricao()
                            + " já utilizado! Favor escolher outra promoção.");
                    jtf_codigo_objeto_locacao.requestFocus();
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel adicionar ");
        }
    }

    public void alimentarTabelaCopia(Copia copiaAtendimento) {
        if (copiaAtendimento != null) {
            copiaAtendimento.getDiaria().getPromocaoLocacao().setValor_promocao_locacao(copiaAtendimento.getDiaria().getValor());

            DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
            row.addRow(new Object[]{copiaAtendimento.getCodigo_barras(),
                copiaAtendimento.getObjeto().getTitulo(),
                moeda.setPrecoFormat(String.valueOf(copiaAtendimento.getDiaria().getValor())),
                copiaAtendimento.getDiaria().getNome_diaria(),
                copiaAtendimento.getObjeto().getCensura(),
                copiaAtendimento.getDiaria().getPromocaoLocacao().getDescricao()});
        }
    }

    public void adicionarItemTabela(Copia copiaAtendimento) {
        Date d = new Date();
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        int dia = c.get(c.DAY_OF_WEEK);

        try {
            if (copiaAtendimento.getDiaria().getPromocaoLocacao().getDomingo() == true && dia == 1) {
                alimentarTabelaCopia(copiaAtendimento);
            } else if (copiaAtendimento.getDiaria().getPromocaoLocacao().getSegunda() == true && dia == 2) {
                alimentarTabelaCopia(copiaAtendimento);
            } else if (copiaAtendimento.getDiaria().getPromocaoLocacao().getTerca() == true && dia == 3) {
                alimentarTabelaCopia(copiaAtendimento);
            } else if (copiaAtendimento.getDiaria().getPromocaoLocacao().getQuarta() == true && dia == 4) {
                alimentarTabelaCopia(copiaAtendimento);
            } else if (copiaAtendimento.getDiaria().getPromocaoLocacao().getQuinta() == true && dia == 5) {
                alimentarTabelaCopia(copiaAtendimento);
            } else if (copiaAtendimento.getDiaria().getPromocaoLocacao().getSexta() == true && dia == 6) {
                alimentarTabelaCopia(copiaAtendimento);
            } else if (copiaAtendimento.getDiaria().getPromocaoLocacao().getSabado() == true && dia == 7) {
                alimentarTabelaCopia(copiaAtendimento);
            } else if (copiaAtendimento.getDiaria().getPacotePromocional().getDias_restantes() > 0) {

                DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
                row.addRow(new Object[]{copiaAtendimento.getCodigo_barras(),
                    copiaAtendimento.getObjeto().getTitulo(),
                    moeda.setPrecoFormat(String.valueOf(copiaAtendimento.getDiaria().getValor())),
                    copiaAtendimento.getDiaria().getNome_diaria(),
                    copiaAtendimento.getObjeto().getCensura(),
                    copiaAtendimento.getDiaria().getPacotePromocional().getDescricao()});
            } else {
                copiaAtendimento.getDiaria().setPromocaoLocacao(new PromocaoLocacao());
                DefaultTableModel row = (DefaultTableModel) jtbl_locacao.getModel();
                row.addRow(new Object[]{copiaAtendimento.getCodigo_barras(),
                    copiaAtendimento.getObjeto().getTitulo(),
                    moeda.setPrecoFormat(String.valueOf(copiaAtendimento.getDiaria().getValor())),
                    copiaAtendimento.getDiaria().getNome_diaria(),
                    copiaAtendimento.getObjeto().getCensura()});
            }

            copiasLocacao.add(copiaAtendimento);
            calcularPromocaoLocacao();
            limparItemLocado();
            calcularDiaPrevisto();
            jtf_codigo_objeto_locacao.requestFocus();
            recalcularValorTotal();
        } catch (Exception e) {

        }
    }

    public void recalcularValorTotal() {

        moeda = new Moeda();
        Double total_locacao = 0.00;
        Double total_a_pagar = 0.00;
        Double saldo = moeda.getPrecoFormato(jtf_saldo.getText());

        for (int i = 0; i < jtbl_locacao.getRowCount(); i++) {
            Double valor_adicionar = moeda.getPrecoFormato(jtbl_locacao.getValueAt(i, 2).toString());
            total_locacao = total_locacao + valor_adicionar;
        }

        if (saldo >= total_locacao) {
            total_a_pagar = 0.00;
        } else if (saldo < total_locacao) {
            total_a_pagar = total_locacao - saldo;
        }
        jtf_total_locacao.setText(moeda.setPrecoFormat(String.valueOf(total_locacao)));
        jtf_total_a_pagar.setText(moeda.setPrecoFormat(String.valueOf(total_a_pagar)));
        jl_total_filmes.setText("Total de Objetos: " + jtbl_locacao.getRowCount());

    }

    public void limparItemLocado() {
        jtf_valor_locacao.setText("R$ 0,00");
        jtf_tipo_midia.setText("");
        jtf_diaria.setText("");
        jtf_codigo_objeto_locacao.setText("");
        jtf_nome_objeto_locacao.setText("");
        promocoes = null;
        jcb_promocao.removeAllItems();
    }

    public void statusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    public void carregarCopiaLocacao(Copia copia) {
        if (copia != null) {
            this.copiaAtendimento = copia;
            moeda = new Moeda();

            if (jcb_codigo_barras_locacao.isSelected() == true) {
                jtf_codigo_objeto_locacao.setText(copia.getCodigo_barras());
            } else {
                jtf_codigo_objeto_locacao.setText(copia.getObjeto().getCodigo_objeto().toString());
            }
            jtf_nome_objeto_locacao.setText(copia.getObjeto().getTitulo());
            jtf_diaria.setText(String.valueOf(copia.getDiaria().getDias()));
            jtf_valor_locacao.setText(moeda.setPrecoFormat(String.valueOf(copia.getDiaria().getValor())));
            jtf_tipo_midia.setText(copia.getObjeto().getTipo_midia());
            jcb_promocao.removeAllItems();

            pool = new Pool();
            diariaDAO = new DiariaDAO(pool);
            promocoes = diariaDAO.getDiariaPromocao(copia.getDiaria());

            pool = new Pool();
            pacotePromocionalDAO = new ComboDAO(pool);
            itensPacotePromocional = pacotePromocionalDAO.getPacotePromocionalClienteDiaria(dependente.getCliente().getCodigo_cliente(), copia.getDiaria().getCodigo_diaria());

            if (promocoes.size() > 0) {
                for (int i = 0; i < promocoes.size(); i++) {
                    Combo semPacotePromocional = new Combo();
                    promocoes.get(i).setPacotePromocional(semPacotePromocional);
                    ItemDbGrid hashDbGrid = new ItemDbGrid(promocoes.get(i), promocoes.get(i).getPromocaoLocacao().getDescricao());
                    jcb_promocao.addItem(hashDbGrid);
                }
            }
            Date d = new Date();
            Calendar c = new GregorianCalendar();
            c.setTime(d);
            int dia = c.get(c.DAY_OF_WEEK);

            if (promocoes.size() > 0) {
                for (int i = 0; i < jcb_promocao.getItemCount(); i++) {
                    if (promocoes.get(i).getPromocaoLocacao().getDomingo() == true && dia == 1) {
                        jcb_promocao.setSelectedIndex(i);
                        break;
                    } else if (promocoes.get(i).getPromocaoLocacao().getSegunda() == true && dia == 2) {
                        jcb_promocao.setSelectedIndex(i);
                        break;
                    } else if (promocoes.get(i).getPromocaoLocacao().getTerca() == true && dia == 3) {
                        jcb_promocao.setSelectedIndex(i);
                        break;
                    } else if (promocoes.get(i).getPromocaoLocacao().getQuarta() == true && dia == 4) {
                        jcb_promocao.setSelectedIndex(i);
                        break;
                    } else if (promocoes.get(i).getPromocaoLocacao().getQuinta() == true && dia == 5) {
                        jcb_promocao.setSelectedIndex(i);
                        break;
                    } else if (promocoes.get(i).getPromocaoLocacao().getSexta() == true && dia == 6) {
                        jcb_promocao.setSelectedIndex(i);
                        break;
                    } else if (promocoes.get(i).getPromocaoLocacao().getSabado() == true && dia == 7) {
                        jcb_promocao.setSelectedIndex(i);
                        break;
                    }
                }
            }
            for (int i = 0; i < itensPacotePromocional.size(); i++) {
                if (itensPacotePromocional.size() > 0) {
                    if (itensPacotePromocional.get(i).getDias_restantes() > 0
                            && itensPacotePromocional.get(i).getQuantidade_troca_efetuada() < itensPacotePromocional.get(i).getQuantidade_troca()) {

                        PromocaoLocacao semPromocao = new PromocaoLocacao();

                        Diaria diaria = itensPacotePromocional.get(i).getDiaria();
                        diaria.setPromocaoLocacao(semPromocao);
                        diaria.setPacotePromocional(itensPacotePromocional.get(i));

                        ItemDbGrid hashDbGrid = new ItemDbGrid(diaria, diaria.getPacotePromocional().getDescricao());
                        jcb_promocao.addItem(hashDbGrid);
                        jcb_promocao.setSelectedItem(hashDbGrid);
                    }
                }
            }

            Diaria diaria = copia.getDiaria();
            diaria.setPromocaoLocacao(new PromocaoLocacao());
            diaria.setPacotePromocional(new Combo());

            ItemDbGrid hashDbGrid = new ItemDbGrid(diaria, "Sem Promoção");
            jcb_promocao.addItem(hashDbGrid);

            jb_adicionar_locacao.requestFocus();
        }
    }

    public void carregarClienteDependente(Dependente dependente) {
        if (dependente != null) {
            copiasLocacao = new ArrayList<>();
            this.dependente = dependente;
            jtf_saldo.setText("R$ 0,00");

            jtf_nome_cliente.setText(dependente.getNome_dependente());
            setTitle("Atendimento Locação - " + dependente.getNome_dependente());
            jtf_codigo_cliente.setText(String.valueOf(dependente.getCliente().getCodigo_cliente()));
            moeda = new Moeda();

            pool = new Pool();
            DependenteDAO dependenteDAO = new DependenteDAO(pool);

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

            //Limpa tabela depois de selecionar novo cliente
            DefaultTableModel tb_locacao = (DefaultTableModel) jtbl_locacao.getModel();
            int rows = tb_locacao.getRowCount();
            for (int i = rows - 1; i >= 0; i--) {
                tb_locacao.removeRow(i);
            }

            jl_lancamento_aberto.setText("Pendente: " + quantidade_lancamento_aberto);
            jtf_total_locacao.setText("R$ 0,00");
            jtf_saldo.setText(moeda.setPrecoFormat(String.valueOf(saldo.toString())));
            jtf_codigo_objeto_locacao.requestFocus();
            verificarDebito(dependente.getCliente());

        }
    }

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    public void verificarDebito(Cliente cliente) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        pool = new Pool();
        LancamentoDAO lancDAO = new LancamentoDAO(pool);

        lancamento = lancDAO.getDebito(cliente);

        if (lancamento != null) {

            Calendar data_inicial = Calendar.getInstance();
            data_inicial.setTime(lancamento.getData_lancamento());
            data_inicial.set(Calendar.HOUR_OF_DAY, 0);
            data_inicial.set(Calendar.MINUTE, 0);
            data_inicial.set(Calendar.SECOND, 0);
            data_inicial.set(Calendar.MILLISECOND, 0);
            data_inicial.getTime();

            Calendar data_final = Calendar.getInstance();
            data_final.set(Calendar.HOUR_OF_DAY, 0);
            data_final.set(Calendar.MINUTE, 0);
            data_final.set(Calendar.SECOND, 0);
            data_final.set(Calendar.MILLISECOND, 0);
            data_final.getTime();

            long intervalo = data_final.getTimeInMillis() - data_inicial.getTimeInMillis();
            int duracaoDebito = (int) (intervalo / (1000 * 60 * 60 * 24 * 30)); // resultado em meses 
            System.out.println("Calculo de dias em Debito:" + duracaoDebito);

            ConfiguraSistema configuraSistema = new ConfiguraSistema();
            int tempo_inadiplente = Integer.parseInt(configuraSistema.jtf_a_prazo_inadiplente.getText());

            if (duracaoDebito > tempo_inadiplente) {

                int selectedOption = JOptionPane.showConfirmDialog(this, "Cliente com débito desde: " + df.format(lancamento.getData_lancamento()) + "\n Deseja Autorizar?", "Atenção", JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_NO_OPTION) {
                    jtf_codigo_objeto_locacao.setEnabled(true);
                } else {
                    jtf_codigo_objeto_locacao.setEnabled(false);
                }

            } else {
                jtf_codigo_objeto_locacao.setEnabled(true);
            }
        }
    }

    public boolean consultarCodigoDeBarras(String codigo_barras) {
        boolean retorno = false;
        try {
            pool = new Pool();
            copias = null;
            CopiaDAO copiaDAO = new CopiaDAO(pool);
            //Checar se a cópia existe
            if (copiaDAO.getCopia_existente(codigo_barras) == true) {

                copias = copiaDAO.getCopia_codigo_barras(codigo_barras);
                //Checar se a cópia esta disponivel
                if (copias.get(0).getStatus().equals("Disponível")) {
                    //Checar a censura para o filme dizendo inapropriado para idade
                    if (checkCensura(copias.get(0).getObjeto().getCensura(), dependente.getData_nascimento()) == true) {
                        //Carregar as copias e os campos com as informações
                        carregarCopiaLocacao(copias.get(0));
                        retorno = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Filme inapropriado para este Cliente");
                        retorno = false;
                    }
                } else {
                    SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
                    String data_prevista = "";
                    try {
                        if (copias.get(0).getData_prevista() != null) {
                            data_prevista = out.format(in.parse(copias.get(0).getData_prevista().toString()));
                        }
                    } catch (ParseException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    JOptionPane.showMessageDialog(null, "Cópia indisponivel no momento. Devolução prevista para " + data_prevista);
                    retorno = false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Código de Barra inválido e/ou não cadastrado");
                retorno = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AtendimentoLocacao.class.getName()).log(Level.SEVERE, null, ex);
            return retorno = false;
        }
        return retorno;
    }

    public boolean checkCensura(int censura, Date data_nascimento) {

        int idade = calcularIdade(data_nascimento);

        if (data_nascimento != null) {
            return idade >= censura;
        }
        return false;

    }

    public int calcularIdade(Date dataNascimento) {
        if (dataNascimento != null) {
            //Calcula a Idade baseado em java.util.Date   
            Calendar dateOfBirth = new GregorianCalendar();

            dateOfBirth.setTime(dataNascimento);

            // Cria um objeto calendar com a data atual
            Calendar today = Calendar.getInstance();

            // Obtém a idade baseado no ano
            int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

            dateOfBirth.add(Calendar.YEAR, age);

            //se a data de hoje é antes da data de Nascimento, então diminui 1(um)
            if (today.before(dateOfBirth)) {

                age--;

            }

            return age;
        }
        return 0;
    }

    public void locar_consulta_codigo_objeto(Integer codigo_objeto) {

        try {
            pool = new Pool();
            copias = null;
            CopiaDAO copiaDAO = new CopiaDAO(pool);
            if (codigo_objeto != null) {

                if (copiaDAO.getObjeto_existente(codigo_objeto) == true) {

                    copias = copiaDAO.getCopia_codigo_objeto(codigo_objeto, 0, "Locação");

                    if (copias.size() > 0) {
                        String codigo_barras = verificaTabelaObjeto(copias);

                        if (!codigo_barras.equals("")) {
                            consultarCodigoDeBarras(codigo_barras);
                        } else {
                            JOptionPane.showMessageDialog(null, "Cópia Indisponível");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Cópia indisponivel no momento");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Código de Objeto inválido e/ou não cadastrado");

                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Grave: " + ex);
        }

    }

    public boolean verificaTabela(Copia copia) {

        boolean tabela = true;
        if (jtbl_locacao.getRowCount() == 0) {
            return false;
        } else if (jtbl_locacao.getRowCount() > 0) {
            int linhas = jtbl_locacao.getRowCount();

            for (int i = 0; i < linhas; i++) {
                Copia copiaVerificarTabela = new Copia();

                copiaVerificarTabela.setCodigo_barras((String) jtbl_locacao.getValueAt(i, 0));

                tabela = copiaVerificarTabela.getCodigo_barras().equals(copia.getCodigo_barras());

                if (tabela == true) {
                    break;
                } else {
                    if (copia.getDiaria().getPacotePromocional().getCodigo_combo() != 0) {
                        System.out.println("Codigo Pacote Promocional:" + copia.getDiaria().getPacotePromocional().getCodigo_combo());
                        if (copia.getDiaria().getPacotePromocional().getCodigo_combo().equals(
                                copiasLocacao.get(i).getDiaria().getPacotePromocional().getCodigo_combo())) {
                            tabela = true;
                            break;
                        }
                    } else {
                        tabela = false;
                    }
                }
            }
        }
        return tabela;
    }

    public String verificaTabelaObjeto(List<Copia> copias) {
        boolean tabela = false;
        String codigo_barras = "";
        if (jtbl_locacao.getRowCount() == 0) {
            codigo_barras = copias.get(0).getCodigo_barras();
        } else if (jtbl_locacao.getRowCount() > 0) {
            int linhas = jtbl_locacao.getRowCount();

            for (int i = 0; i < linhas; i++) {
                System.out.println("Linhas:" + i + " Size: " + copias.size());
                for (int x = 0; x < copias.size();) {

                    Copia copiaVerificarTabela = new Copia();

                    copiaVerificarTabela.setCodigo_barras((String) jtbl_locacao.getValueAt(i, 0));

                    tabela = copiaVerificarTabela.getCodigo_barras().equals(copias.get(x).getCodigo_barras());

                    System.out.println(copias.get(x).getCodigo_barras() + " " + tabela + " Posição: " + x);
                    if (tabela == false) {
                        codigo_barras = copias.get(x).getCodigo_barras();
                        break;
                    } else {
                        System.out.println("Passou pela posição: " + x);
                        copias.remove(x);
                        x = 0;
                        continue;
                    }
                }
                System.out.println("Linhas:" + i + " Size: " + copias.size());
            }

        }

        return codigo_barras;
    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {

        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            jb_finalizar_locacao.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            jb_recebimento.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F6) {
            jb_pesquisa_locacao.doClick();
        }
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

    public void calcularPromocaoLocacao() {
        try {

            pool = new Pool();
            diariaDAO = new DiariaDAO(pool);
            moeda = new Moeda();
            List<Diaria> dias = diariaDAO.getDiariaPromocao();

            System.out.println("Tamanho do Array Copias Locação: " + copiasLocacao.size());
            System.out.println("Tamanho da Tabela Locação: " + jtbl_locacao.getRowCount());
            System.out.println("Tamanho do Array Diária: " + dias.size());

            for (int i = 0; i < copiasLocacao.size(); i++) {
                System.out.println("=============Inicio de Verificacao no Array " + i + "=============");
                System.out.println("Iniciar Verificação na Linha: " + i);
                System.out.println("Código da Promoção: " + copiasLocacao.get(i).getDiaria().getPromocaoLocacao().getCodigo_promocao_locacao());
                System.out.println("================Fim de Verificacao no Array " + i + "=============");
            }
            for (int i = 0; i < copiasLocacao.size(); i++) {
                System.out.println("=============Inicio de Teste Debug 1 =============");
                for (int x = 0; x < dias.size(); x++) {
                    System.out.println("Código Promoção - Diária: " + dias.get(x).getPromocaoLocacao().getCodigo_promocao_locacao()
                            + " Código Promoção - Cópia: " + copiasLocacao.get(i).getDiaria().getPromocaoLocacao().getCodigo_promocao_locacao());
                    System.out.println("Posição: " + i + " Locar: " + copiasLocacao.get(i).getDiaria().getPromocaoLocacao().getLocar_quantidade());
                    System.out.println("Posição: " + i + " Ganhar: " + copiasLocacao.get(i).getDiaria().getPromocaoLocacao().getGanhar_quantidade());
                    System.out.println("Posição: " + i + " Preço Promoção: " + copiasLocacao.get(i).getDiaria().getPromocaoLocacao().getValor_promocao_locacao());
                    System.out.println("Posição: " + i + " Preço da Tabela: " + jtbl_locacao.getValueAt(i, 2));
                    if (dias.get(x).getPromocaoLocacao().getCodigo_promocao_locacao().equals(
                            copiasLocacao.get(i).getDiaria().getPromocaoLocacao().getCodigo_promocao_locacao())) {
                        dias.get(x).setQuantidade_filme(dias.get(x).getQuantidade_filme() + 1);
                        System.out.println("Quantidade de filme: " + dias.get(x).getQuantidade_filme());
                        Double valor_tabela_locacao = moeda.getPrecoFormato(jtbl_locacao.getValueAt(i, 2).toString());
                        if (dias.get(x).getPromocaoLocacao().getValor_promocao_locacao().equals(valor_tabela_locacao)) {
                            dias.get(x).setGanhados(dias.get(x).getGanhados() + 1);
                            System.out.println("Quantidade de filme ganhados: " + dias.get(x).getGanhados());
                        }
                    }
                }
                System.out.println("=============Fim de Teste Debug 1 =============");
            }
            for (int i = 0; i < dias.size(); i++) {
                System.out.println("=============Inicio de Verificacao no Array Dias Após Verificações =============");
                System.out.println("Iniciar Verificação na Linha: " + i);
                System.out.println("Código da Promoção: " + dias.get(i).getPromocaoLocacao().getCodigo_promocao_locacao());
                System.out.println("Nome da Promoção: " + dias.get(i).getPromocaoLocacao().getDescricao());
                System.out.println("Quantidade de filme: " + dias.get(i).getQuantidade_filme());
                System.out.println("Posição: " + i + " Locar: " + dias.get(i).getPromocaoLocacao().getLocar_quantidade());
                System.out.println("Posição: " + i + " Ganhar: " + dias.get(i).getPromocaoLocacao().getGanhar_quantidade());
                System.out.println("================Fim de Verificacao no Array Dias Após Verificações=============");

                int ganhar;
                int locar_quantidade = (dias.get(i).getPromocaoLocacao().getLocar_quantidade() + 1);
                ganhar = (dias.get(i).getQuantidade_filme() / locar_quantidade);

                for (int z = 0; z < copiasLocacao.size(); z++) {
                    if (ganhar > 0) {
                        if (dias.get(i).getPromocaoLocacao().getCodigo_promocao_locacao().equals(
                                copiasLocacao.get(z).getDiaria().getPromocaoLocacao().getCodigo_promocao_locacao())) {

                            jtbl_locacao.setValueAt(moeda.setPrecoFormat(dias.get(i).getPromocaoLocacao().getValor_promocao_locacao().toString()), z, 2);
                            copiasLocacao.get(z).getDiaria().getPromocaoLocacao().setValor_promocao_locacao(dias.get(i).getPromocaoLocacao().getValor_promocao_locacao());
                            System.out.println("Colocar promocação na Linha: " + z);
                            System.out.println("Promoção adicionada: " + moeda.setPrecoFormat(copiasLocacao.get(z).getDiaria().getPromocaoLocacao().getValor_promocao_locacao().toString()));
                            ganhar = ganhar - 1;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void calcularDiaPrevisto() {
        try {

            List<Diaria> diariasAcumulativas = new ArrayList<Diaria>();
            pool = new Pool();
            DiariaDAO diaDAO = new DiariaDAO(pool);
            diariasAcumulativas = diaDAO.getTodasDiarias();
            for (int i = 0; i < jtbl_locacao.getRowCount(); i++) {
                System.out.println("==================================================");
                System.out.println("Inciar Verificação: " + copiasLocacao.get(i).getObjeto().getTitulo());
                System.out.println("Acumulativo: " + copiasLocacao.get(i).getDiaria().getAcumulativo());
                if (copiasLocacao.get(i).getDiaria().getAcumulativo() == true) {
                    for (int j = 0; j < diariasAcumulativas.size(); j++) {
                        if (diariasAcumulativas.size() > 0) {
                            System.out.println("CODIGO DIARIA - DIARIA: " + diariasAcumulativas.get(j).getCodigo_diaria() + " CODIGO DIARIA - COPIA: " + copiasLocacao.get(i).getDiaria().getCodigo_diaria());
                            if (diariasAcumulativas.get(j).getCodigo_diaria().equals(copiasLocacao.get(i).getDiaria().getCodigo_diaria())) {
                                System.out.println("Debug 1 - Quantidade de Dias: " + copiasLocacao.get(i).getDiaria().getDias());
                                System.out.println("Debug 2 - Quantidade de Dias Máximo: " + copiasLocacao.get(i).getDiaria().getMaximo_dias());
                                if ((diariasAcumulativas.get(j).getQuantidade_filme() * copiasLocacao.get(i).getDiaria().getDias()) < copiasLocacao.get(i).getDiaria().getMaximo_dias()) {
                                    diariasAcumulativas.get(j).setQuantidade_filme(diariasAcumulativas.get(j).getQuantidade_filme() + 1);
                                    diariasAcumulativas.get(j).setDias_previsto(diariasAcumulativas.get(j).getDias_previsto() + 1);
                                    System.out.println("Quantidade de filme: " + diariasAcumulativas.get(j).getQuantidade_filme() + " Dias Previsto: " + diariasAcumulativas.get(j).getDias_previsto());
                                } else {
                                    diariasAcumulativas.get(j).setQuantidade_filme(diariasAcumulativas.get(j).getQuantidade_filme() + 1);
                                    System.out.println("Quantidade de filme: " + diariasAcumulativas.get(j).getQuantidade_filme() + " Dias Previsto: " + diariasAcumulativas.get(j).getDias_previsto());
                                }
                            }
                        }
                    }
                } else {
                    for (int j = 0; j < diariasAcumulativas.size(); j++) {
                        if (diariasAcumulativas.size() > 0) {
                            System.out.println("CODIGO DIARIA - DIARIA: " + diariasAcumulativas.get(j).getCodigo_diaria() + " CODIGO DIARIA - COPIA: " + copiasLocacao.get(i).getDiaria().getCodigo_diaria());
                            if (diariasAcumulativas.get(j).getCodigo_diaria().equals(copiasLocacao.get(i).getDiaria().getCodigo_diaria())) {
                                diariasAcumulativas.get(j).setDias_previsto(diariasAcumulativas.get(j).getDias());
                            }
                        }
                    }
                }
                System.out.println("==================================================");
            }

            for (int i = 0; i < jtbl_locacao.getRowCount(); i++) {
                ItemLocacao itemLocacao = new ItemLocacao();

                PromocaoLocacao promocaoLocacao = copiasLocacao.get(i).getDiaria().getPromocaoLocacao();
                Diaria diaria = copiasLocacao.get(i).getDiaria();
                diaria.setPromocaoLocacao(promocaoLocacao);
                Objeto objeto = copiasLocacao.get(i).getObjeto();

                Copia copia = copiasLocacao.get(i);
                copia.setDiaria(diaria);
                copia.setObjeto(objeto);
                copia.setStatus("1");
                System.out.println("");

            //Inserir a lógica da promoção de objetos e para cada um sera gravada  a data prevista de devolucao no banco e somar
                //conforme quantidade e regra de negócio
                Calendar cal = Calendar.getInstance();

                for (int d = 0; d < diariasAcumulativas.size(); d++) {
                    if (diariasAcumulativas.get(d).getCodigo_diaria() == copiasLocacao.get(i).getDiaria().getCodigo_diaria()) {
                        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + diariasAcumulativas.get(d).getDias_previsto());
                        System.out.println("Dias: " + diariasAcumulativas.get(d).getDias_previsto());
                        System.out.println("Day Month: " + cal.get(Calendar.DAY_OF_MONTH));
                        System.out.println("Data prevista: " + cal.getTime());
                    }
                }

                try {
                    if (copiasLocacao.get(i).getDiaria().getPacotePromocional().getDias_restantes() > 0) {
                        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + copiasLocacao.get(i).getDiaria().getPacotePromocional().getDias_restantes());
                        itemLocacao.setData_prevista(cal.getTime());
                        System.out.println("Data Prevista 1:" + cal.getTime());
                    } else {
                        itemLocacao.setData_prevista(cal.getTime());
                        System.out.println("Data Prevista 2:" + cal.getTime());
                    }
                } catch (Exception e) {
                    itemLocacao.setData_prevista(cal.getTime());
                }

                int dia = cal.get(cal.DAY_OF_WEEK);
                System.out.println("Dia da semana:" + dia);
                if (dia == 1) {
                    cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
                    if (checarFeriado(cal) == false) {
                        itemLocacao.setData_prevista(cal.getTime());
                    } else {
                        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
                        if (checarFeriado(cal) == false) {
                            itemLocacao.setData_prevista(cal.getTime());
                        } else {
                            cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
                            if (checarFeriado(cal) == false) {
                                itemLocacao.setData_prevista(cal.getTime());
                            } else {
                                cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
                                if (checarFeriado(cal) == false) {
                                    itemLocacao.setData_prevista(cal.getTime());
                                } else {
                                    cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
                                    if (checarFeriado(cal) == false) {
                                        itemLocacao.setData_prevista(cal.getTime());
                                    } else {
                                        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
                                        itemLocacao.setData_prevista(cal.getTime());
                                    }

                                }

                            }

                        }
                    }
                } else {
                    if (checarFeriado(cal) == false) {
                        itemLocacao.setData_prevista(cal.getTime());
                    } else {
                        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
                        if (checarFeriado(cal) == false) {
                            itemLocacao.setData_prevista(cal.getTime());
                        } else {
                            cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
                            if (checarFeriado(cal) == false) {
                                itemLocacao.setData_prevista(cal.getTime());
                            } else {
                                cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
                                if (checarFeriado(cal) == false) {
                                    itemLocacao.setData_prevista(cal.getTime());
                                } else {
                                    cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
                                    if (checarFeriado(cal) == false) {
                                        itemLocacao.setData_prevista(cal.getTime());
                                    } else {
                                        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
                                        itemLocacao.setData_prevista(cal.getTime());
                                    }

                                }

                            }

                        }
                    }
                }
                SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
                
                String data_prev = out.format(itemLocacao.getData_prevista().getTime());

                jtbl_locacao.setValueAt(data_prev, i, 6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checarFeriado(Calendar cal) {
        pool = new Pool();
        feriados = new ArrayList<>();
        FeriadoDAO feriadoDAO = new FeriadoDAO(pool);

        SimpleDateFormat in = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");

        String data_prev = out.format(cal.getTime());

        feriados = feriadoDAO.getFeriadoData(data_prev);
        if (feriados.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
