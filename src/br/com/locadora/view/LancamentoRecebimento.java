package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.ItemLancamento;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.TipoServico;
import br.com.locadora.model.bean.Usuario;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class LancamentoRecebimento extends javax.swing.JFrame {

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

    public LancamentoRecebimento() {
        initComponents();
        TemaInterface.getInterface(this);
    }

    public LancamentoRecebimento(Lancamento lancamento) {
        initComponents();
        TemaInterface.getInterface(this);
        this.setTitle("Recebendo - Controle Interno: " + lancamento.getCodigo_lancamento());
        this.lancamento = lancamento;
        moeda = new Moeda();
        jtf_codigo_lancamento.setText(lancamento.getCodigo_lancamento().toString());
        jtf_descricao_lancamento.setText(lancamento.getTipoServico().getDescricao());
        jtf_valor_total.setText(moeda.setPrecoFormat(lancamento.getValor_total().toString()));

        carregarItensLancamentos(lancamento);
        carregarTipoLancamento();

        Calendar data_atual = Calendar.getInstance();
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        String data_inicial = out.format(data_atual.getTime());
        jtf_data_lancamento.setText(data_inicial);

        if (lancamento.getTipoServico().getTipo().equals("C")) {
            jcb_tipo_servico.setEnabled(false);
            jtf_data_lancamento.setEnabled(false);
            jtf_valor_lancamento.setEnabled(false);
            jb_adicionar_locacao.setEnabled(false);
            jb_remover_locacao.setEnabled(false);
            jb_sair.requestFocus();
        } else {
            jcb_tipo_servico.requestFocus();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_codigo_lancamento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtf_descricao_lancamento = new javax.swing.JTextField();
        jtf_valor_total = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
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
        jtf_valor_lancamento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_recebimento = new javax.swing.JTable();
        jl_codigo_locacao = new javax.swing.JLabel();
        jb_adicionar_locacao = new javax.swing.JButton();
        jb_remover_locacao = new javax.swing.JButton();
        jcb_tipo_servico = new javax.swing.JComboBox();
        try  {
            formatoData = new MaskFormatter("##/##/####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_data_lancamento = new JFormattedTextField(formatoData);
        jLabel4 = new javax.swing.JLabel();
        jl_rodape = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jb_sair = new javax.swing.JButton();

        jDesktopPane1.setName("jDesktopPane1"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recebendo - Controle Interno - 0");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
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

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel1.setText("Código ");
        jLabel1.setName("jLabel1"); // NOI18N

        jtf_codigo_lancamento.setEditable(false);
        jtf_codigo_lancamento.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_codigo_lancamento.setName("jtf_codigo_lancamento"); // NOI18N

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel10.setText("Descrição");
        jLabel10.setName("jLabel10"); // NOI18N

        jtf_descricao_lancamento.setEditable(false);
        jtf_descricao_lancamento.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_descricao_lancamento.setName("jtf_descricao_lancamento"); // NOI18N
        jtf_descricao_lancamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_descricao_lancamentoFocusLost(evt);
            }
        });
        jtf_descricao_lancamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_descricao_lancamentoKeyPressed(evt);
            }
        });

        jtf_valor_total.setName("jtf_valor_total"); // NOI18N

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel11.setText("Valor Lançamento");
        jLabel11.setName("jLabel11"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_codigo_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_descricao_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_valor_total, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_codigo_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtf_descricao_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtf_valor_total, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        jp_locacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Recebimentos"));
        jp_locacao.setName("jp_locacao"); // NOI18N

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

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel3.setText("Data Lançamento");
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel5.setText("Valor Lançamento");
        jLabel5.setName("jLabel5"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jtbl_recebimento.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_recebimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data Lançamento", "Descrição", "Tipo", "Valor Lançamento", "Usuário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
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
        jtbl_recebimento.setName("jtbl_recebimento"); // NOI18N
        jtbl_recebimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_recebimentoKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbl_recebimento);
        if (jtbl_recebimento.getColumnModel().getColumnCount() > 0) {
            jtbl_recebimento.getColumnModel().getColumn(0).setPreferredWidth(70);
            jtbl_recebimento.getColumnModel().getColumn(1).setPreferredWidth(120);
            jtbl_recebimento.getColumnModel().getColumn(2).setPreferredWidth(5);
            jtbl_recebimento.getColumnModel().getColumn(3).setPreferredWidth(50);
            jtbl_recebimento.getColumnModel().getColumn(4).setPreferredWidth(80);
        }

        jl_codigo_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jl_codigo_locacao.setText("Serviço");
        jl_codigo_locacao.setName("jl_codigo_locacao"); // NOI18N

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

        jcb_tipo_servico.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_tipo_servico.setName("jcb_tipo_servico"); // NOI18N
        jcb_tipo_servico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcb_tipo_servicoKeyPressed(evt);
            }
        });

        jtf_data_lancamento.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_data_lancamento.setName("jtf_data_lancamento"); // NOI18N
        jtf_data_lancamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_data_lancamentoFocusLost(evt);
            }
        });
        jtf_data_lancamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_data_lancamentoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jp_locacaoLayout = new javax.swing.GroupLayout(jp_locacao);
        jp_locacao.setLayout(jp_locacaoLayout);
        jp_locacaoLayout.setHorizontalGroup(
            jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_locacaoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_codigo_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcb_tipo_servico, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(jtf_data_lancamento))
                        .addGap(5, 5, 5)
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_locacaoLayout.createSequentialGroup()
                                .addComponent(jtf_valor_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jb_adicionar_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jb_remover_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 48, Short.MAX_VALUE))))
        );
        jp_locacaoLayout.setVerticalGroup(
            jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_locacaoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_codigo_locacao)
                    .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel3)))
                .addGap(0, 0, 0)
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jb_adicionar_locacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jtf_valor_lancamento, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_data_lancamento, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcb_tipo_servico, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_remover_locacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jLabel4.setText("Tipo: D = Débito: C = Crédito ");
        jLabel4.setName("jLabel4"); // NOI18N

        jl_rodape.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jl_rodape.setText("Devedor: R$ 0,00");
        jl_rodape.setName("jl_rodape"); // NOI18N

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jl_rodape, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jp_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(266, 266, 266))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jp_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_rodape)
                    .addComponent(jLabel4))
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F10) {

        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    }//GEN-LAST:event_formKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornarJanelaPai();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

private void jtf_descricao_lancamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_descricao_lancamentoKeyPressed

}//GEN-LAST:event_jtf_descricao_lancamentoKeyPressed

private void jtf_descricao_lancamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_descricao_lancamentoFocusLost

}//GEN-LAST:event_jtf_descricao_lancamentoFocusLost

    private void jb_remover_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_remover_locacaoActionPerformed
        removeItemLancamento(jtbl_recebimento);
    }//GEN-LAST:event_jb_remover_locacaoActionPerformed

    private void jtf_valor_lancamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_lancamentoFocusLost
        moeda = new Moeda();
        jtf_valor_lancamento.setText(moeda.setPrecoFormat(jtf_valor_lancamento.getText()));
    }//GEN-LAST:event_jtf_valor_lancamentoFocusLost

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

    private void jb_adicionar_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_adicionar_locacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_adicionar_locacao.doClick();
        }
        acionarAtalho(evt);

    }//GEN-LAST:event_jb_adicionar_locacaoKeyPressed

    private void jtf_data_lancamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_lancamentoFocusLost
        try {
            if (jtf_data_lancamento.getText().trim().length() < 10) {
                jtf_data_lancamento.setForeground(Color.red);
            } else if (jtf_data_lancamento.getText().equals("  /  /    ")) {
                jtf_data_lancamento.setForeground(Color.red);
            } else {
                if (validaData(jtf_data_lancamento.getText())) {
                    jtf_data_lancamento.setForeground(Color.black);
                } else {
                    jtf_data_lancamento.setForeground(Color.red);
                }
            }
        } catch (ParseException ex) {
            jtf_data_lancamento.setForeground(Color.red);
        } catch (NumberFormatException ex) {
            jtf_data_lancamento.setText("  /  /    ");
            jtf_data_lancamento.setForeground(Color.red);
        }
    }//GEN-LAST:event_jtf_data_lancamentoFocusLost

    private void jtf_data_lancamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_data_lancamentoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_valor_lancamento.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_lancamentoKeyPressed

    private void jtf_valor_lancamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_lancamentoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_adicionar_locacao.requestFocus();
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

    private void jb_adicionar_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_adicionar_locacaoActionPerformed
        adicionarLancamento();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_locacaoActionPerformed

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

    private void jtbl_recebimentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_recebimentoKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_recebimentoKeyPressed

    private void jb_remover_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_remover_locacaoKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_remover_locacaoKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new LancamentoRecebimento().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_adicionar_locacao;
    private javax.swing.JButton jb_remover_locacao;
    private javax.swing.JButton jb_sair;
    private javax.swing.JComboBox jcb_tipo_servico;
    private javax.swing.JLabel jl_codigo_locacao;
    private javax.swing.JLabel jl_rodape;
    public static javax.swing.JPanel jp_locacao;
    public static javax.swing.JTable jtbl_recebimento;
    public static javax.swing.JTextField jtf_codigo_lancamento;
    public static javax.swing.JFormattedTextField jtf_data_lancamento;
    public static javax.swing.JTextField jtf_descricao_lancamento;
    private javax.swing.JTextField jtf_valor_lancamento;
    private javax.swing.JTextField jtf_valor_total;
    // End of variables declaration//GEN-END:variables

    public void removeItemLancamento(JTable tb) {
        if (tb != null) {
            DefaultTableModel row = (DefaultTableModel) jtbl_recebimento.getModel();
            if (tb.getSelectedRow() != -1) {
                itemLancamento = tbItemLancamentoLinhaSelecionada(tb);
                if (itemLancamento != null) {
                    int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_NO_OPTION) {
                        pool = new Pool();
                        LancamentoDAO lancamentoDAO = new LancamentoDAO(pool);
                        lancamentoDAO.excluirItemLancamento(itensLancamento.get(tb.getSelectedRow()).getCodigo_item_lancamento());
                        carregarItensLancamentos(lancamento);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um Objeto");
            }
        }
    }

    public ItemLancamento tbItemLancamentoLinhaSelecionada(JTable tb) {
        ItemLancamento itemLancamento = new ItemLancamento();
        if (tb != null && tb.getSelectedRow() != -1) {
            itemLancamento = itensLancamento.get(tb.getSelectedRow());
        } else {
            itemLancamento = null;
        }
        return itemLancamento;
    }

    public boolean verificarItemLancamento() {
        Double valor_tabela = 0.00;
        Double valor_lancamento = moeda.getPrecoFormato(jtf_valor_lancamento.getText());
        Double valor_total = moeda.getPrecoFormato(jtf_valor_total.getText());
        moeda = new Moeda();
        for (int i = 0; i < jtbl_recebimento.getRowCount(); i++) {
            valor_tabela = valor_tabela + moeda.getPrecoFormato(jtbl_recebimento.getValueAt(i, 3).toString());
        }
        Double restante = (valor_total - valor_tabela);

        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_data_lancamento.getText().trim().length() != 10) {
            msgERRO = msgERRO + " *Data Inválida\n";
        }

        if (jtf_valor_lancamento.getText().trim().equals("R$ 0,00") || jtf_valor_lancamento.getText().trim().length() == 0) {
            msgERRO = msgERRO + " *Valor Inválido\n";
        } else if (restante < valor_lancamento) {
            msgERRO = msgERRO + " *Valor Maior que Débito\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jcb_tipo_servico.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void adicionarLancamento() {

        try {
            if (verificarItemLancamento() == true) {
                ItemDbGrid hashDbGrid = (ItemDbGrid) jcb_tipo_servico.getSelectedItem();
                tipoServico = new TipoServico();
                tipoServico = (TipoServico) hashDbGrid.getObjeto();

                ArquivoConfiguracao conf = new ArquivoConfiguracao();
                Usuario usuario = new Usuario();
                usuario.setCodigo_usuario(Integer.parseInt(conf.readPropertie("codigo_usuario")));

                moeda = new Moeda();
                itemLancamento = new ItemLancamento();
                itemLancamento.setData_lancamento(new SimpleDateFormat("dd/MM/yyyy").parse((String) jtf_data_lancamento.getText()));
                itemLancamento.setLancamento(lancamento);
                itemLancamento.setValor_lancamento(moeda.getPrecoFormato(jtf_valor_lancamento.getText()));

                itemLancamento.setTipoServico(tipoServico);
                itemLancamento.setCaixa(Integer.parseInt(conf.readPropertie("caixa")));
                itemLancamento.setUsuario(usuario);
                List<ItemLancamento> itemLancamentoSalvar = new ArrayList<>();
                itemLancamentoSalvar.add(itemLancamento);
                pool = new Pool();
                LancamentoDAO lancamentoDAO = new LancamentoDAO(pool);
                lancamentoDAO.salvarItemLancamento(itemLancamentoSalvar);
                limparItemLancado();
                carregarItensLancamentos(lancamento);
            }
        } catch (ParseException ex) {
            Logger.getLogger(LancamentoRecebimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limparItemLancado() {
        Calendar data_atual = Calendar.getInstance();
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        String data_inicial = out.format(data_atual.getTime());

        jtf_data_lancamento.setText(data_inicial);
        jcb_tipo_servico.setSelectedIndex(0);

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
        tipos = tipoServicoDAO.getTipoServicos("U");

        if (tipos.isEmpty()) {

        } else {
            for (int i = 0; i < tipos.size(); i++) {
                ItemDbGrid hashDbGrid = new ItemDbGrid(tipos.get(i), tipos.get(i).getDescricao());
                jcb_tipo_servico.addItem(hashDbGrid);
                System.out.println(hashDbGrid);
            }
        }
    }

    public void carregarItensLancamentos(Lancamento lancamento) {
        if (lancamento != null) {
            DefaultTableModel tb_recebimentos = (DefaultTableModel) jtbl_recebimento.getModel();
            int rows = tb_recebimentos.getRowCount();
            for (int i = rows - 1; i >= 0; i--) {
                tb_recebimentos.removeRow(i);
            }
            try {
                pool = new Pool();

                itensLancamento = new ArrayList<ItemLancamento>();
                LancamentoDAO lancamentoDAO = new LancamentoDAO(pool);
                itensLancamento = lancamentoDAO.getItemLancamento(lancamento);

                for (int i = 0; i < itensLancamento.size(); i++) {
                    SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

                    String data_lancamento;
                    data_lancamento = out.format(in.parse(itensLancamento.get(i).getData_lancamento().toString()));

                    moeda = new Moeda();

                    DefaultTableModel row = (DefaultTableModel) jtbl_recebimento.getModel();
                    row.addRow(new Object[]{data_lancamento, itensLancamento.get(i).getTipoServico().getDescricao(),
                        itensLancamento.get(i).getTipoServico().getTipo(),
                        moeda.setPrecoFormat(itensLancamento.get(i).getValor_lancamento().toString()),
                        itensLancamento.get(i).getUsuario().getNome_usuario()});
                }

                Double valor_tabela = 0.00;
                Double valor_lancamento = moeda.getPrecoFormato(jtf_valor_lancamento.getText());
                Double valor_total = moeda.getPrecoFormato(jtf_valor_total.getText());
                moeda = new Moeda();
                for (int i = 0; i < jtbl_recebimento.getRowCount(); i++) {
                    valor_tabela = valor_tabela + moeda.getPrecoFormato(jtbl_recebimento.getValueAt(i, 3).toString());
                }
                Double restante = (valor_total - valor_tabela);
                if (lancamento.getTipoServico().getTipo().equals("D")) {
                    jl_rodape.setText("Devedor: " + moeda.setPrecoFormat(restante.toString()));
                    jtf_valor_lancamento.setText(moeda.setPrecoFormat(restante.toString()));
                } else {
                    jl_rodape.setText("Saldo: " + moeda.setPrecoFormat(restante.toString()));
                }
                jcb_tipo_servico.requestFocus();

            } catch (ParseException ex) {
                Logger.getLogger(LancamentoRecebimento.class.getName()).log(Level.SEVERE, null, ex);
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
            retornarJanelaPai();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            jb_remover_locacao.doClick();
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
            int index = janelapai.jtbl_recebimento.getSelectedRow();
            janelapai.carregarClienteDependente(janelapai.dependente);
        }
    }
}
