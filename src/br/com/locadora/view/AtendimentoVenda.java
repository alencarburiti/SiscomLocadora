package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.ItemVenda;
import br.com.locadora.model.bean.Lancamento;
import br.com.locadora.model.bean.Produto;
import br.com.locadora.model.dao.LancamentoDAO;
import br.com.locadora.model.dao.ProdutoDAO;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.model.dao.VendaDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AtendimentoVenda extends javax.swing.JFrame {

    public Dependente dependente;
    public InterfacePool pool;
    public TelaPrincipal janelapai;
    public Moeda moeda;
    public Lancamento lancamento;
    public AcessoUsuario acesso;
    public ItemVenda itemAtendimento;
    public ProdutoDAO produtoDAO;
    public List<Produto> produtos;
    public List<ItemVenda> itensVendaAtendimento;
    public List<ItemVenda> itensVenda;
    public EntradaCaixaVenda entradaCaixaVenda;
    public VendaDAO vendaDAO;
    public List<Lancamento> lancamentos;
    public FinanceiroReceber financeiroReceber;

    public AtendimentoVenda() {
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
        jtf_preco_venda = new javax.swing.JTextField();
        jtf_quantidade = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_itens_venda = new javax.swing.JTable();
        jtf_descricao_venda = new javax.swing.JTextField();
        jl_codigo_locacao = new javax.swing.JLabel();
        jtf_codigo_item_venda = new javax.swing.JTextField();
        jb_pesquisa_venda = new javax.swing.JButton();
        jb_adicionar_venda = new javax.swing.JButton();
        jb_remover_venda = new javax.swing.JButton();
        jl_lancamento_aberto = new javax.swing.JLabel();
        jl_itens = new javax.swing.JLabel();
        jl_debito_locacao = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jtf_saldo = new javax.swing.JTextField();
        jtf_total_venda = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jb_finalizar_venda = new javax.swing.JButton();
        jb_limpar_venda = new javax.swing.JButton();
        jb_sair_venda = new javax.swing.JButton();
        jb_recebimento = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jtf_total_a_pagar = new javax.swing.JTextField();

        jDesktopPane1.setName("jDesktopPane1"); // NOI18N
        jDesktopPane1.setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atendimento Venda");
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

        jtf_codigo_cliente.setEditable(false);
        jtf_codigo_cliente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_codigo_cliente.setName("jtf_codigo_cliente"); // NOI18N
        jtf_codigo_cliente.setPreferredSize(new java.awt.Dimension(100, 24));

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel10.setText("Nome Cliente");
        jLabel10.setName("jLabel10"); // NOI18N

        jtf_nome_cliente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_nome_cliente.setName("jtf_nome_cliente"); // NOI18N
        jtf_nome_cliente.setPreferredSize(new java.awt.Dimension(300, 24));
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_codigo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jtf_codigo_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jp_locacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens Venda"));
        jp_locacao.setName("jp_locacao"); // NOI18N

        jtf_preco_venda.setEditable(false);
        jtf_preco_venda.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_preco_venda.setText("R$ 0,00");
        jtf_preco_venda.setName("jtf_preco_venda"); // NOI18N
        jtf_preco_venda.setPreferredSize(new java.awt.Dimension(60, 24));
        jtf_preco_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_preco_vendaActionPerformed(evt);
            }
        });
        jtf_preco_venda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_preco_vendaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_preco_vendaFocusLost(evt);
            }
        });

        jtf_quantidade.addKeyListener(new java.awt.event.KeyAdapter() {     // cria um listener ouvinte de digitação do fieldNumero

            public void keyReleased(java.awt.event.KeyEvent evt) {  // cria um ouvinte para cada tecla pressionada

                jtf_quantidade.setText(jtf_quantidade.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que não(^) seja numero  por ""

            }
        });
        jtf_quantidade.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_quantidade.setName("jtf_quantidade"); // NOI18N
        jtf_quantidade.setPreferredSize(new java.awt.Dimension(50, 24));
        jtf_quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_quantidadeKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel3.setText("Nome Produto");
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel5.setText("Preço Venda");
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel13.setText("Qtd.");
        jLabel13.setName("jLabel13"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jtbl_itens_venda.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_itens_venda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código de Barras", "Nome Objeto", "Quantidade", "Preço Unitário", "Preço Total"
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
        jtbl_itens_venda.setName("jtbl_itens_venda"); // NOI18N
        jtbl_itens_venda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_itens_vendaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbl_itens_venda);
        if (jtbl_itens_venda.getColumnModel().getColumnCount() > 0) {
            jtbl_itens_venda.getColumnModel().getColumn(0).setPreferredWidth(50);
            jtbl_itens_venda.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtbl_itens_venda.getColumnModel().getColumn(3).setPreferredWidth(30);
            jtbl_itens_venda.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        jtf_descricao_venda.setEditable(false);
        jtf_descricao_venda.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_descricao_venda.setName("jtf_descricao_venda"); // NOI18N
        jtf_descricao_venda.setPreferredSize(new java.awt.Dimension(300, 24));
        jtf_descricao_venda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_descricao_vendaFocusGained(evt);
            }
        });
        jtf_descricao_venda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_descricao_vendaKeyPressed(evt);
            }
        });

        jl_codigo_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jl_codigo_locacao.setText("Código de Barras");
        jl_codigo_locacao.setName("jl_codigo_locacao"); // NOI18N

        jtf_codigo_item_venda.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_codigo_item_venda.setName("jtf_codigo_item_venda"); // NOI18N
        jtf_codigo_item_venda.setPreferredSize(new java.awt.Dimension(120, 24));
        jtf_codigo_item_venda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_codigo_item_vendaKeyPressed(evt);
            }
        });

        jb_pesquisa_venda.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_pesquisa_venda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jb_pesquisa_venda.setName("jb_pesquisa_venda"); // NOI18N
        jb_pesquisa_venda.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_pesquisa_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_pesquisa_vendaActionPerformed(evt);
            }
        });
        jb_pesquisa_venda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_pesquisa_vendaKeyPressed(evt);
            }
        });

        jb_adicionar_venda.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_adicionar_venda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/adicionar_item.png"))); // NOI18N
        jb_adicionar_venda.setToolTipText("Incluir");
        jb_adicionar_venda.setName("jb_adicionar_venda"); // NOI18N
        jb_adicionar_venda.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_adicionar_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_adicionar_vendaActionPerformed(evt);
            }
        });
        jb_adicionar_venda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_adicionar_vendaKeyPressed(evt);
            }
        });

        jb_remover_venda.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_remover_venda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/remove_item.png"))); // NOI18N
        jb_remover_venda.setToolTipText("Excluir");
        jb_remover_venda.setName("jb_remover_venda"); // NOI18N
        jb_remover_venda.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_remover_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_remover_vendaActionPerformed(evt);
            }
        });
        jb_remover_venda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_remover_vendaKeyPressed(evt);
            }
        });

        jl_lancamento_aberto.setForeground(new java.awt.Color(255, 0, 0));
        jl_lancamento_aberto.setText("Pendente: 0");
        jl_lancamento_aberto.setName("jl_lancamento_aberto"); // NOI18N

        jl_itens.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jl_itens.setText("Total de Itens: 0");
        jl_itens.setName("jl_itens"); // NOI18N

        javax.swing.GroupLayout jp_locacaoLayout = new javax.swing.GroupLayout(jp_locacao);
        jp_locacao.setLayout(jp_locacaoLayout);
        jp_locacaoLayout.setHorizontalGroup(
            jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jp_locacaoLayout.createSequentialGroup()
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_codigo_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_codigo_item_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_descricao_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_pesquisa_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_preco_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                        .addComponent(jtf_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_adicionar_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jb_remover_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jp_locacaoLayout.createSequentialGroup()
                .addComponent(jl_lancamento_aberto, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jl_itens, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_codigo_item_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_descricao_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, 0)
                        .addComponent(jtf_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, 0)
                        .addComponent(jtf_preco_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jb_pesquisa_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jb_remover_venda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addComponent(jb_adicionar_venda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_lancamento_aberto)
                    .addComponent(jl_itens)))
        );

        jl_debito_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jl_debito_locacao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jl_debito_locacao.setText("Saldo:");
        jl_debito_locacao.setName("jl_debito_locacao"); // NOI18N

        jLabel27.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Total Venda:");
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

        jtf_total_venda.setEditable(false);
        jtf_total_venda.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jtf_total_venda.setForeground(new java.awt.Color(255, 51, 51));
        jtf_total_venda.setText("R$ 0,00");
        jtf_total_venda.setName("jtf_total_venda"); // NOI18N
        jtf_total_venda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_total_vendaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_total_vendaFocusLost(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel2.setName("jPanel2"); // NOI18N

        jb_finalizar_venda.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_finalizar_venda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/finalizar.png"))); // NOI18N
        jb_finalizar_venda.setText("OK");
        jb_finalizar_venda.setName("jb_finalizar_venda"); // NOI18N
        jb_finalizar_venda.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_finalizar_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_finalizar_vendaActionPerformed(evt);
            }
        });
        jb_finalizar_venda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_finalizar_vendaKeyPressed(evt);
            }
        });

        jb_limpar_venda.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_limpar_venda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/limpar.png"))); // NOI18N
        jb_limpar_venda.setText("Limpar");
        jb_limpar_venda.setName("jb_limpar_venda"); // NOI18N
        jb_limpar_venda.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_limpar_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_limpar_vendaActionPerformed(evt);
            }
        });
        jb_limpar_venda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_limpar_vendaKeyPressed(evt);
            }
        });

        jb_sair_venda.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_sair_venda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/sair.png"))); // NOI18N
        jb_sair_venda.setText("Sair");
        jb_sair_venda.setMaximumSize(new java.awt.Dimension(101, 33));
        jb_sair_venda.setName("jb_sair_venda"); // NOI18N
        jb_sair_venda.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_sair_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_sair_vendaActionPerformed(evt);
            }
        });
        jb_sair_venda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_sair_vendaKeyPressed(evt);
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
                .addGap(20, 20, 20)
                .addComponent(jb_recebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_finalizar_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jb_limpar_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jb_sair_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_finalizar_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_recebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_limpar_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_sair_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                                .addComponent(jtf_total_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                            .addComponent(jtf_total_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    consultaCliente.janelapaiVenda = this;
    consultaCliente.setVisible(true);
    consultaCliente.jtf_consulta.setText(jtf_nome_cliente.getText().trim());
    setStatusTela(false);
}//GEN-LAST:event_jb_clienteActionPerformed

private void jtf_nome_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_clienteKeyPressed
    acionarAtalho(evt);
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        jb_cliente.doClick();
    }
}//GEN-LAST:event_jtf_nome_clienteKeyPressed

private void jtf_nome_clienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nome_clienteFocusLost
    jtf_codigo_item_venda.requestFocus();
}//GEN-LAST:event_jtf_nome_clienteFocusLost

    private void jtf_saldoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_saldoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_saldoFocusLost

    private void jtf_saldoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_saldoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_saldoFocusGained

    private void jtf_total_vendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_vendaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_vendaFocusLost

    private void jtf_total_vendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_vendaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_vendaFocusGained

    private void jb_pesquisa_vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_pesquisa_vendaActionPerformed
        if (jtf_codigo_cliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe primeiro um Cliente");
            jtf_nome_cliente.requestFocus();
        } else {
            ConsultaProdutoComboVenda consultaProdutoVenda = new ConsultaProdutoComboVenda();
            consultaProdutoVenda.janelapai = this;
            consultaProdutoVenda.setVisible(true);
            setStatusTela(false);
        }
    }//GEN-LAST:event_jb_pesquisa_vendaActionPerformed

    private void jtf_descricao_vendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_descricao_vendaKeyPressed

    }//GEN-LAST:event_jtf_descricao_vendaKeyPressed

    private void jtf_descricao_vendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_descricao_vendaFocusGained
    }//GEN-LAST:event_jtf_descricao_vendaFocusGained

    private void jb_remover_vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_remover_vendaActionPerformed
        removeObjeto(jtbl_itens_venda);
    }//GEN-LAST:event_jb_remover_vendaActionPerformed

    private void jtf_preco_vendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco_vendaFocusLost
        moeda = new Moeda();
        jtf_preco_venda.setText(moeda.setPrecoFormat(jtf_preco_venda.getText()));
    }//GEN-LAST:event_jtf_preco_vendaFocusLost

    private void jtf_preco_vendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco_vendaFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco_vendaFocusGained

    private void jtf_codigo_item_vendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_codigo_item_vendaKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            getProdutoPacotePromocionalCodigoBarras(jtf_codigo_item_venda.getText());
        }
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            jb_pesquisa_venda.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_codigo_item_vendaKeyPressed

    private void jb_adicionar_vendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_adicionar_vendaKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_adicionar_venda.doClick();
        }
    }//GEN-LAST:event_jb_adicionar_vendaKeyPressed

    private void jb_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_clienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_cliente.doClick();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_clienteKeyPressed

    private void jb_sair_vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_sair_vendaActionPerformed
        retornaJanelaPai();
    }//GEN-LAST:event_jb_sair_vendaActionPerformed

    private void jb_finalizar_vendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_finalizar_vendaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_finalizar_venda.doClick();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_finalizar_vendaKeyPressed

    private void jb_limpar_vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_limpar_vendaActionPerformed
        limparCampos();
        limparItemLocado();
        DefaultTableModel tableModel = (DefaultTableModel) jtbl_itens_venda.getModel();
        tableModel.setNumRows(0);
    }//GEN-LAST:event_jb_limpar_vendaActionPerformed

    private void jb_limpar_vendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_limpar_vendaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_limpar_venda.doClick();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_limpar_vendaKeyPressed

    private void jtf_preco_vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_preco_vendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco_vendaActionPerformed

    private void jb_remover_vendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_remover_vendaKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_remover_venda.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_remover_vendaKeyPressed

    private void jtbl_itens_vendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_itens_vendaKeyPressed
        acionarAtalho(evt);
// TODO add your handling code here:
    }//GEN-LAST:event_jtbl_itens_vendaKeyPressed

    private void jb_sair_vendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_sair_vendaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_sair_venda.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_sair_vendaKeyPressed

    private void jtf_total_a_pagarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_a_pagarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_a_pagarFocusGained

    private void jtf_total_a_pagarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_total_a_pagarFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_total_a_pagarFocusLost

    private void jtf_quantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_quantidadeKeyPressed
                acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_adicionar_venda.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_quantidadeKeyPressed

    private void jb_adicionar_vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_adicionar_vendaActionPerformed
        try {
                if (itemAtendimento != null) {
                    adicionarItemVenda(itemAtendimento);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Código do Objeto deve ser número");
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_vendaActionPerformed

    private void jb_pesquisa_vendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_pesquisa_vendaKeyPressed
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_pesquisa_venda.doClick();
        }
        acionarAtalho(evt);   
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_pesquisa_vendaKeyPressed

    private void jb_finalizar_vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_finalizar_vendaActionPerformed
        abrirCaixa();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_finalizar_vendaActionPerformed

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
                financeiroReceber.janelapai4 = this;
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
                new AtendimentoVenda().setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_adicionar_venda;
    private javax.swing.JButton jb_cliente;
    private javax.swing.JButton jb_finalizar_venda;
    private javax.swing.JButton jb_limpar_venda;
    private javax.swing.JButton jb_pesquisa_venda;
    private javax.swing.JButton jb_recebimento;
    private javax.swing.JButton jb_remover_venda;
    private javax.swing.JButton jb_sair_venda;
    private javax.swing.JLabel jl_codigo_locacao;
    private javax.swing.JLabel jl_debito_locacao;
    public static javax.swing.JLabel jl_itens;
    public static javax.swing.JLabel jl_lancamento_aberto;
    public static javax.swing.JPanel jp_locacao;
    public static javax.swing.JTable jtbl_itens_venda;
    public static javax.swing.JTextField jtf_codigo_cliente;
    private javax.swing.JTextField jtf_codigo_item_venda;
    public static javax.swing.JTextField jtf_descricao_venda;
    public static javax.swing.JTextField jtf_nome_cliente;
    private javax.swing.JTextField jtf_preco_venda;
    private javax.swing.JFormattedTextField jtf_quantidade;
    public static javax.swing.JTextField jtf_saldo;
    public static javax.swing.JTextField jtf_total_a_pagar;
    public static javax.swing.JTextField jtf_total_venda;
    // End of variables declaration//GEN-END:variables


    public void consultarProdutoCombo() {
        ConsultaProdutoComboVenda consultaProdutoVenda = new ConsultaProdutoComboVenda();
        consultaProdutoVenda.janelapai = this;
        consultaProdutoVenda.setVisible(true);
        setStatusTela(false);
    }

    private void abrirCaixa() {
        if (verificarCampos() == true) {
            if (jtbl_itens_venda.getRowCount() > 0) {                
                entradaCaixaVenda = new EntradaCaixaVenda();
                entradaCaixaVenda.setVisible(true);
                entradaCaixaVenda.janelapaiVenda = this;
                this.setStatusTela(false);
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
        jtf_codigo_item_venda.setText("");
        jtf_preco_venda.setText("");        
        jtf_quantidade.setText("");
    }

    public void removeObjeto(JTable tb) {
        if (tb != null) {
            DefaultTableModel row = (DefaultTableModel) jtbl_itens_venda.getModel();
            if (tb.getSelectedRow() != -1) {
                int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_NO_OPTION) {
                    
                    int index_remove = tb.getSelectedRow();
                    System.out.println("Linha deletada: " + index_remove);
                    row.removeRow(tb.getSelectedRow());
                    itensVendaAtendimento.remove(index_remove);
                    
                    recalcularValorTotal();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um Item");
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

    public boolean verificarCamposItemVenda() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_descricao_venda.getText().equals("")) {
            msgERRO = msgERRO + " *Produto\n";
        }
        
        if (jtf_quantidade.getText().equals("")) {
            msgERRO = msgERRO + " *Quantidade\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jtf_codigo_item_venda.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void adicionarItemVenda(ItemVenda itemAtendimento) {

        if (verificarCamposItemVenda() == true) {
            moeda = new Moeda();
            DefaultTableModel row = (DefaultTableModel) jtbl_itens_venda.getModel();
            Integer quantidade = Integer.parseInt(jtf_quantidade.getText());
            System.out.println("Type Product"+ itemAtendimento.getType_product());
            if(itemAtendimento.getType_product() == 0){
                Double preco_total = quantidade * itemAtendimento.getCombo().getValor();
                itemAtendimento.setPreco_total(preco_total);
                itemAtendimento.setQuantidade(quantidade);
            
                row.addRow(new Object[]{itemAtendimento.getCombo().getCodigo_barras(), 
                    itemAtendimento.getCombo().getDescricao(),
                    itemAtendimento.getQuantidade(),
                    moeda.setPrecoFormat(itemAtendimento.getCombo().getValor().toString()),
                    moeda.setPrecoFormat(itemAtendimento.getPreco_total().toString())});
            } else if(itemAtendimento.getType_product() == 1){
                Double preco_total = quantidade * itemAtendimento.getProduto().getPreco_venda();
                itemAtendimento.setPreco_total(preco_total);
                itemAtendimento.setQuantidade(quantidade);
            
                row.addRow(new Object[]{itemAtendimento.getProduto().getCodigo_barras(), 
                    itemAtendimento.getProduto().getNome_produto(),
                    itemAtendimento.getQuantidade(),
                    moeda.setPrecoFormat(itemAtendimento.getProduto().getPreco_venda().toString()),
                    moeda.setPrecoFormat(itemAtendimento.getPreco_total().toString())});
            }
            itensVendaAtendimento.add(itemAtendimento);
            this.itemAtendimento = null;
            recalcularValorTotal();
            limparItemLocado();
            jtf_codigo_item_venda.requestFocus();
        } 
    }

    public void recalcularValorTotal() {

        moeda = new Moeda();
        Double total_venda = 0.00;
        Double total_a_pagar = 0.00;
        Double saldo = moeda.getPrecoFormato(jtf_saldo.getText());

        for (int i = 0; i < jtbl_itens_venda.getRowCount(); i++) {
            Double valor_adicionar = moeda.getPrecoFormato(jtbl_itens_venda.getValueAt(i, 4).toString());
            total_venda = total_venda + valor_adicionar;
        }
        
        if (saldo >= total_venda) {
            total_a_pagar = 0.00;
        } else if(saldo < total_venda){
            total_a_pagar = total_venda - saldo;            
        }        
        jtf_total_venda.setText(moeda.setPrecoFormat(String.valueOf(total_venda)));
        jtf_total_a_pagar.setText(moeda.setPrecoFormat(String.valueOf(total_a_pagar)));
        jl_itens.setText("Total de Itens: " + jtbl_itens_venda.getRowCount());

    }

    public void limparItemLocado() {
        jtf_codigo_item_venda.setText("");
        jtf_descricao_venda.setText("");
        jtf_preco_venda.setText("R$ 0,00");
        jtf_quantidade.setText("");
    }

    public void statusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    public void carregarProdutoPacotePromocional(ItemVenda itemVenda) {
        if (itemVenda != null) {
            this.itemAtendimento = itemVenda;
            moeda = new Moeda();
            if(itemAtendimento.getType_product() == 0){
                jtf_codigo_item_venda.setText(itemAtendimento.getCombo().getCodigo_barras());
                jtf_descricao_venda.setText(itemAtendimento.getCombo().getDescricao());
                jtf_preco_venda.setText(moeda.setPrecoFormat(itemAtendimento.getCombo().getValor().toString()));
                jtf_quantidade.setEditable(false);
                jtf_quantidade.setText("1");
                jb_adicionar_venda.requestFocus();                
            } else if(itemAtendimento.getType_product() == 1){
                jtf_codigo_item_venda.setText(itemAtendimento.getProduto().getCodigo_barras());
                jtf_descricao_venda.setText(itemAtendimento.getProduto().getNome_produto());
                jtf_preco_venda.setText(moeda.setPrecoFormat(itemAtendimento.getProduto().getPreco_venda().toString()));
                jtf_quantidade.setEditable(true);
                jtf_quantidade.setText("1");
                jb_adicionar_venda.requestFocus();                
            }
        }
    }

    public void carregarClienteDependente(Dependente dependente) {
        if (dependente != null) {
            itensVendaAtendimento = new ArrayList<>();
            this.dependente = dependente;
            jtf_saldo.setText("R$ 0,00");

            jtf_nome_cliente.setText(dependente.getNome_dependente());
            setTitle("Atendimento Venda - " + dependente.getNome_dependente());
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

            jtf_codigo_item_venda.requestFocus();

            //Limpa tabela depois de selecionar novo cliente
            DefaultTableModel tb_locacao = (DefaultTableModel) jtbl_itens_venda.getModel();
            int rows = tb_locacao.getRowCount();
            for (int i = rows - 1; i >= 0; i--) {
                tb_locacao.removeRow(i);
            }

            jtf_total_venda.setText("R$ 0,00");

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

            if (duracaoDebito > 3) {
                JOptionPane.showMessageDialog(null, "Cliente com débito desde: " + df.format(lancamento.getData_lancamento()));
                jtf_codigo_item_venda.setEnabled(false);
            } else {
                jtf_codigo_item_venda.setEnabled(true);
            }
        }
    }

    public void getProdutoPacotePromocionalCodigoBarras(String codigo_barras) {
        pool = new Pool();
        vendaDAO = new VendaDAO(pool);
        itensVenda = vendaDAO.getProdutoPacoteCodigoBarras(codigo_barras);
        if(!itensVenda.isEmpty()){
            carregarProdutoPacotePromocional(itensVenda.get(0));            
        }
    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            jb_finalizar_venda.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            retornaJanelaPai();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            jb_remover_venda.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F12) {
            jb_recebimento.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_F6) {
            ConsultaCopiaLocacao copiaCliente = new ConsultaCopiaLocacao();
            copiaCliente.janelapai3 = this;
            copiaCliente.setVisible(true);
            setStatusTela(false);
        }
    }
    
    private void retornaJanelaPai() {
        setVisible(false);
        if (janelapai != null) {
            janelapai.setStatusTela(true);
            janelapai.atendimentoVenda = null;
            janelapai = null;
        }
    }

}
