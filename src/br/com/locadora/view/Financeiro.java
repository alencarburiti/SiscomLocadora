package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Categoria;
import br.com.locadora.model.bean.LancamentoConta;
import br.com.locadora.model.bean.LogInfo;
import br.com.locadora.model.bean.SubCategoria;
import br.com.locadora.model.dao.CategoriaDAO;
import br.com.locadora.model.dao.LancamentoContaDAO;
import br.com.locadora.model.dao.LogInfoDAO;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.Colorir;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;
import javax.swing.tree.DefaultMutableTreeNode;

public class Financeiro extends javax.swing.JFrame {

    public InterfacePool pool;
    public TelaPrincipal janelapai;
    public Moeda moeda;
    public AcessoUsuario acesso;
    public MaskFormatter formatoData;
    public List<LancamentoConta> contas;
    public LancamentoConta lancamentoConta;
    public FinanceiroPagar financeiroPagar;
    public FinanceiroReceber financeiroReceber;
    public CategoriaDAO categoriaDAO;
    public List<Categoria> categorias;
    public List<SubCategoria> subCategorias;

    public Financeiro() {
        initComponents();
        TemaInterface.getInterface(this);
        mostrarNodes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        try  {
            formatoData = new MaskFormatter("##/##/####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_data_inicial = new JFormattedTextField(formatoData);
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        try  {
            formatoData = new MaskFormatter("##/##/####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_data_final = new JFormattedTextField(formatoData);
        jrb_recebidos = new javax.swing.JRadioButton();
        jrb_pagos = new javax.swing.JRadioButton();
        jrb_todos = new javax.swing.JRadioButton();
        jrb_vencidos = new javax.swing.JRadioButton();
        jrb_a_pagar = new javax.swing.JRadioButton();
        jrb_a_receber = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_contas = new javax.swing.JTable();
        jl_rodape = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jb_altera_lancamento = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jb_sair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        arvore = new javax.swing.JTree();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();

        jDesktopPane1.setName("jDesktopPane1"); // NOI18N
        jDesktopPane1.setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Financeiro");
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
        jDesktopPane2.setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));
        jPanel3.setName("jPanel3"); // NOI18N

        jtf_data_inicial.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_data_inicial.setMinimumSize(new java.awt.Dimension(70, 24));
        jtf_data_inicial.setName("jtf_data_inicial"); // NOI18N
        jtf_data_inicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_data_inicialActionPerformed(evt);
            }
        });
        jtf_data_inicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_data_inicialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_data_inicialFocusLost(evt);
            }
        });
        jtf_data_inicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_data_inicialKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel2.setText("Data Inicial");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel3.setText("Data Final");
        jLabel3.setName("jLabel3"); // NOI18N

        jtf_data_final.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_data_final.setMinimumSize(new java.awt.Dimension(70, 24));
        jtf_data_final.setName("jtf_data_final"); // NOI18N
        jtf_data_final.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_data_finalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_data_finalFocusLost(evt);
            }
        });
        jtf_data_final.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_data_finalKeyPressed(evt);
            }
        });

        buttonGroup1.add(jrb_recebidos);
        jrb_recebidos.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_recebidos.setText("Recebidos");
        jrb_recebidos.setName("jrb_recebidos"); // NOI18N
        jrb_recebidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_recebidosActionPerformed(evt);
            }
        });
        jrb_recebidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jrb_recebidosKeyPressed(evt);
            }
        });

        buttonGroup1.add(jrb_pagos);
        jrb_pagos.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_pagos.setText("Pagos");
        jrb_pagos.setName("jrb_pagos"); // NOI18N
        jrb_pagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_pagosActionPerformed(evt);
            }
        });
        jrb_pagos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jrb_pagosKeyPressed(evt);
            }
        });

        buttonGroup1.add(jrb_todos);
        jrb_todos.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_todos.setSelected(true);
        jrb_todos.setText("Todos");
        jrb_todos.setName("jrb_todos"); // NOI18N
        jrb_todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_todosActionPerformed(evt);
            }
        });
        jrb_todos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jrb_todosKeyPressed(evt);
            }
        });

        buttonGroup1.add(jrb_vencidos);
        jrb_vencidos.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_vencidos.setText("Vencidos");
        jrb_vencidos.setName("jrb_vencidos"); // NOI18N
        jrb_vencidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_vencidosActionPerformed(evt);
            }
        });
        jrb_vencidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jrb_vencidosKeyPressed(evt);
            }
        });

        buttonGroup1.add(jrb_a_pagar);
        jrb_a_pagar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_a_pagar.setText("À Pagar");
        jrb_a_pagar.setName("jrb_a_pagar"); // NOI18N
        jrb_a_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_a_pagarActionPerformed(evt);
            }
        });
        jrb_a_pagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jrb_a_pagarKeyPressed(evt);
            }
        });

        buttonGroup1.add(jrb_a_receber);
        jrb_a_receber.setText("À Receber");
        jrb_a_receber.setName("jrb_a_receber"); // NOI18N
        jrb_a_receber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_a_receberActionPerformed(evt);
            }
        });
        jrb_a_receber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jrb_a_receberKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jtf_data_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jtf_data_final, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jrb_recebidos)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jrb_a_receber)))
                .addComponent(jrb_pagos)
                .addGap(0, 0, 0)
                .addComponent(jrb_a_pagar)
                .addGap(0, 0, 0)
                .addComponent(jrb_vencidos)
                .addGap(0, 0, 0)
                .addComponent(jrb_todos)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_data_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jrb_recebidos)
                                .addComponent(jrb_pagos)
                                .addComponent(jrb_vencidos)
                                .addComponent(jrb_todos)
                                .addComponent(jrb_a_pagar)
                                .addComponent(jrb_a_receber))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, 0)
                        .addComponent(jtf_data_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jtbl_contas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtbl_contas.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_contas.setForeground(new java.awt.Color(0, 153, 0));
        jtbl_contas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Origem/Destino", "Descrição", "Documento", "Preço Duplicata", "Vencimento", "Preço Pago", "Data Pagamento", "Caixa", "Usuário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_contas.setGridColor(new java.awt.Color(153, 153, 153));
        jtbl_contas.setName("jtbl_contas"); // NOI18N
        jtbl_contas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_contasMouseClicked(evt);
            }
        });
        jtbl_contas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_contasKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbl_contas);
        if (jtbl_contas.getColumnModel().getColumnCount() > 0) {
            jtbl_contas.getColumnModel().getColumn(0).setPreferredWidth(5);
            jtbl_contas.getColumnModel().getColumn(1).setPreferredWidth(130);
            jtbl_contas.getColumnModel().getColumn(2).setPreferredWidth(130);
            jtbl_contas.getColumnModel().getColumn(3).setPreferredWidth(50);
            jtbl_contas.getColumnModel().getColumn(4).setPreferredWidth(50);
            jtbl_contas.getColumnModel().getColumn(5).setPreferredWidth(50);
            jtbl_contas.getColumnModel().getColumn(6).setPreferredWidth(50);
            jtbl_contas.getColumnModel().getColumn(7).setPreferredWidth(50);
            jtbl_contas.getColumnModel().getColumn(8).setPreferredWidth(10);
            jtbl_contas.getColumnModel().getColumn(9).setPreferredWidth(30);
        }

        jl_rodape.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jl_rodape.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jl_rodape.setText("Total à pagar: R$ 0,00 - Total pago: R$ 0,00");
        jl_rodape.setName("jl_rodape"); // NOI18N

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/novo_registro.png"))); // NOI18N
        jButton1.setText("Nova Saída");
        jButton1.setName("jButton1"); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(140, 40));
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

        jButton2.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/delete 16.png"))); // NOI18N
        jButton2.setText("Excluir Saída");
        jButton2.setName("jButton2"); // NOI18N
        jButton2.setPreferredSize(new java.awt.Dimension(140, 40));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        jb_altera_lancamento.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_altera_lancamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/alterar_registro.png"))); // NOI18N
        jb_altera_lancamento.setText("Alterar Saída");
        jb_altera_lancamento.setName("jb_altera_lancamento"); // NOI18N
        jb_altera_lancamento.setPreferredSize(new java.awt.Dimension(140, 40));
        jb_altera_lancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_altera_lancamentoActionPerformed(evt);
            }
        });
        jb_altera_lancamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_altera_lancamentoKeyPressed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/finances_(add)_16x16.gif"))); // NOI18N
        jButton4.setText("Recebimentos");
        jButton4.setName("jButton4"); // NOI18N
        jButton4.setPreferredSize(new java.awt.Dimension(140, 40));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton4KeyPressed(evt);
            }
        });

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

        jLabel1.setText("Tipo de Movimento: E = Entrada; S = Saída");
        jLabel1.setName("jLabel1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        arvore.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        arvore.setName("arvore"); // NOI18N
        arvore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arvoreMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(arvore);

        jMenuBar1.setName("jMenuBar1"); // NOI18N

        jMenu3.setText("Cadastro");
        jMenu3.setName("jMenu3"); // NOI18N

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/fornecedor.png"))); // NOI18N
        jMenuItem3.setText("Fornecedor");
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        jMenu3.add(jMenuItem3);

        jMenuItem6.setText("Categoria");
        jMenuItem6.setName("jMenuItem6"); // NOI18N
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Lançamento");
        jMenu1.setName("jMenu1"); // NOI18N

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/novo_registro.png"))); // NOI18N
        jMenuItem1.setText("Nova Saída");
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/alterar_registro.png"))); // NOI18N
        jMenuItem4.setText("Alterar Saída");
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/delete 16.png"))); // NOI18N
        jMenuItem2.setText("Excluir Saída");
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/finances_(add)_16x16.gif"))); // NOI18N
        jMenuItem5.setText("Recebimentos");
        jMenuItem5.setName("jMenuItem5"); // NOI18N
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Relatório Financeiro");
        jMenu2.setName("jMenu2"); // NOI18N

        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/report.png"))); // NOI18N
        jMenuItem19.setText("Gerar Relatórios");
        jMenuItem19.setName("jMenuItem19"); // NOI18N
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem19);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jb_altera_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(153, 153, Short.MAX_VALUE))
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jl_rodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_altera_lancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_rodape)
                    .addComponent(jLabel1))
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Calendar primeiroDia = Calendar.getInstance();
        primeiroDia.set(Calendar.DAY_OF_MONTH, 1);

        Calendar ultimoDia = Calendar.getInstance();
        ultimoDia.add(Calendar.MONTH, 1);
        ultimoDia.set(Calendar.DAY_OF_MONTH, 1);
        ultimoDia.add(Calendar.DAY_OF_MONTH, -1);

        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

        String data_inicial = out.format(primeiroDia.getTime());
        String data_final = out.format(ultimoDia.getTime());

        jtf_data_inicial.setText(data_inicial);
        jtf_data_final.setText(data_final);

        consultarContas();
    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        acionarAtalho(evt);
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    }//GEN-LAST:event_formKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ((DefaultTableModel) jtbl_contas.getModel()).setRowCount(0);
        jtbl_contas.updateUI();
        retornaJanelaPai();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jtbl_contasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_contasKeyPressed
        acionarAtalho(evt);
// TODO add your handling code here:
    }//GEN-LAST:event_jtbl_contasKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        novoLancamento();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtf_data_inicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_inicialFocusLost
        try {
            if (jtf_data_inicial.getText().trim().length() < 10) {
                jtf_data_inicial.setForeground(Color.red);
            } else if (jtf_data_inicial.getText().equals("  /  /    ")) {
                jtf_data_inicial.setForeground(Color.red);
            }
        } catch (NumberFormatException ex) {
            jtf_data_inicial.setText("  /  /    ");
            jtf_data_inicial.setForeground(Color.red);
        }
    }//GEN-LAST:event_jtf_data_inicialFocusLost

    private void jtf_data_inicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_data_inicialKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_data_final.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_inicialKeyPressed

    private void jtf_data_finalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_finalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_finalFocusLost

    private void jtf_data_finalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_data_finalKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_finalKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        excluirLancamento();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        novoLancamento();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jb_altera_lancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_altera_lancamentoActionPerformed
        alterarLancamento();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_altera_lancamentoActionPerformed

    private void jtbl_contasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_contasMouseClicked
        if (evt.getClickCount() > 1) {
            alterarLancamento();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_contasMouseClicked

    private void jtf_data_inicialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_inicialFocusGained
        jtf_data_inicial.setSelectionStart(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_inicialFocusGained

    private void jtf_data_finalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_finalFocusGained
        jtf_data_final.setSelectionStart(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_finalFocusGained

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        alterarLancamento();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        excluirLancamento();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.FinanceiroReceber");

        try {
            if (acesso.getEscrever() == false) {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            } else if (acesso.getEscrever() == true) {
                financeiroReceber = new FinanceiroReceber();
                financeiroReceber.janelapai = this;
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
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jrb_todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_todosActionPerformed
        consultarContas();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_todosActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.FinanceiroReceber");

        try {
            if (acesso.getEscrever() == false) {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            } else if (acesso.getEscrever() == true) {
                financeiroReceber = new FinanceiroReceber();
                financeiroReceber.janelapai = this;
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
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jb_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_sairActionPerformed
        retornaJanelaPai();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_sairActionPerformed

    private void jrb_recebidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_recebidosActionPerformed
        consultarContas();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_recebidosActionPerformed

    private void jrb_a_receberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_a_receberActionPerformed
        consultarContas();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_a_receberActionPerformed

    private void jrb_pagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_pagosActionPerformed
        consultarContas();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_pagosActionPerformed

    private void jrb_a_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_a_pagarActionPerformed
        consultarContas();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_a_pagarActionPerformed

    private void jrb_vencidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_vencidosActionPerformed
        consultarContas();
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_vencidosActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyPressed

    private void jb_altera_lancamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_altera_lancamentoKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_altera_lancamentoKeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4KeyPressed

    private void jb_sairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_sairKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_sairKeyPressed

    private void jrb_recebidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jrb_recebidosKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_recebidosKeyPressed

    private void jrb_a_receberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jrb_a_receberKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_a_receberKeyPressed

    private void jrb_pagosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jrb_pagosKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_pagosKeyPressed

    private void jrb_a_pagarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jrb_a_pagarKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_a_pagarKeyPressed

    private void jrb_vencidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jrb_vencidosKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_vencidosKeyPressed

    private void jrb_todosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jrb_todosKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_todosKeyPressed

    private void jtf_data_inicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_data_inicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_inicialActionPerformed

    private void arvoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arvoreMouseClicked
        consultarContas();
//        if (!arvore.isSelectionEmpty()) {
//
//            DefaultMutableTreeNode node = (DefaultMutableTreeNode) arvore.getLastSelectedPathComponent();
//            System.out.println("Level " + node.getLevel());
//            System.out.println("Level " + node.toString());
//            if (node.getLevel() == 1) {
//                pool = new Pool();
//                categoriaDAO = new CategoriaDAO(pool);
//                categorias = new ArrayList<>();
//                categorias = categoriaDAO.getCategoria(node.toString());
//
//            }
//        }
        // TODO add your handling code here:
    }//GEN-LAST:event_arvoreMouseClicked

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        ConfiguraCategoria configuraCategoria = new ConfiguraCategoria();
        configuraCategoria.setVisible(true);
        configuraCategoria.janelapai = this;
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        MenuRelatorioFinanceiro menuRelatorio = new MenuRelatorioFinanceiro();
        menuRelatorio.janelapai = this;
        menuRelatorio.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Financeiro().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arvore;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_altera_lancamento;
    private javax.swing.JButton jb_sair;
    private javax.swing.JLabel jl_rodape;
    private javax.swing.JRadioButton jrb_a_pagar;
    private javax.swing.JRadioButton jrb_a_receber;
    private javax.swing.JRadioButton jrb_pagos;
    private javax.swing.JRadioButton jrb_recebidos;
    private javax.swing.JRadioButton jrb_todos;
    private javax.swing.JRadioButton jrb_vencidos;
    public static javax.swing.JTable jtbl_contas;
    public static javax.swing.JFormattedTextField jtf_data_final;
    public static javax.swing.JFormattedTextField jtf_data_inicial;
    // End of variables declaration//GEN-END:variables

    public LancamentoConta tbFornecedorLinhaSelecionada(JTable tb) {

        if (tb.getSelectedRow() != -1) {
            if (contas.get(tb.getSelectedRow()).getFornecedor().getCodigo_fornecedor().equals(0)) {
                JOptionPane.showMessageDialog(null, "Recebimentos não pode ser Alterado/Excluido");
                lancamentoConta = null;
            } else {
                lancamentoConta = contas.get(tb.getSelectedRow());
            }
        } else {
            lancamentoConta = null;
            JOptionPane.showMessageDialog(null, "Selecione um lançamento");
        }
        return lancamentoConta;
    }

    public void alterarLancamento() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.FinanceiroPagar");
        try {
            if (acesso.getEscrever() == true) {
                lancamentoConta = tbFornecedorLinhaSelecionada(jtbl_contas);
                if (lancamentoConta != null) {
                    if (financeiroPagar == null) {
                        financeiroPagar = new FinanceiroPagar(lancamentoConta);
                        financeiroPagar.janelapai = this;
                        financeiroPagar.setVisible(true);
                        financeiroPagar.acesso = acesso;
                    } else {
                        financeiroPagar.setVisible(true);
                    }
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

    private void mostrarContas(List<LancamentoConta> contas) throws ParseException {
        DefaultTableModel tableModel = (DefaultTableModel) jtbl_contas.getModel();
        tableModel.setNumRows(0);

        if (contas.size() == 0) {   
            String rodape = "Total Pago: R$ 0,00 - Total à pagar: R$ 0,00 - Total Recebido: R$ 0,00 - Total à receber: R$ 0,00";
            jl_rodape.setText(rodape);

            jtf_data_inicial.requestFocus();
        } else {
            moeda = new Moeda();
            Double total_saida = 0.00;
            Double total_recebido = 0.00;
            Double total_entrada = 0.00;
            Double total_pago = 0.00;
            for (int i = 0; i < contas.size(); i++) {

                SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
                String data_vencimento = out.format(in.parse(contas.get(i).getData_vencimento().toString()));
                String data_pagamento = "";
                try {
                    data_pagamento = out.format(in.parse(contas.get(i).getData_pagamento().toString()));
                } catch (Exception e) {
                }
                String tipo;

                if (contas.get(i).getFornecedor().getCodigo_fornecedor().equals(0)) {
                    total_recebido = total_recebido + contas.get(i).getValor_pago();
                    total_entrada = total_entrada + contas.get(i).getValor();
                    tipo = "E";
                } else {
                    tipo = "S";
                    total_pago = total_pago + contas.get(i).getValorPago();
                    total_saida = total_saida + contas.get(i).getValor();
                }
                if (data_pagamento.equals("")) {
                }

                DefaultTableModel row = (DefaultTableModel) jtbl_contas.getModel();

                row.addRow(new Object[]{tipo, contas.get(i).getFornecedor().getNome_fantasia(),
                    contas.get(i).getDescricao(), contas.get(i).getDocumento(),
                    moeda.setPrecoFormat(contas.get(i).getValor().toString()),
                    data_vencimento,
                    moeda.setPrecoFormat(contas.get(i).getValorPago().toString()),
                    data_pagamento, contas.get(i).getCaixa(), contas.get(i).getUsuario().getNome_usuario()});
            }

            TableCellRenderer tcr = new Colorir(this, null, null);
            TableColumn column = jtbl_contas.getColumnModel().getColumn(0);
            column.setCellRenderer(tcr);
            column = jtbl_contas.getColumnModel().getColumn(1);
            column.setCellRenderer(tcr);
            column = jtbl_contas.getColumnModel().getColumn(2);
            column.setCellRenderer(tcr);
            column = jtbl_contas.getColumnModel().getColumn(3);
            column.setCellRenderer(tcr);
            column = jtbl_contas.getColumnModel().getColumn(4);
            column.setCellRenderer(tcr);
            column = jtbl_contas.getColumnModel().getColumn(5);
            column.setCellRenderer(tcr);
            column = jtbl_contas.getColumnModel().getColumn(6);
            column.setCellRenderer(tcr);
            column = jtbl_contas.getColumnModel().getColumn(7);
            column.setCellRenderer(tcr);
            column = jtbl_contas.getColumnModel().getColumn(8);
            column.setCellRenderer(tcr);
            column = jtbl_contas.getColumnModel().getColumn(9);
            column.setCellRenderer(tcr);

            Double total_a_pagar = total_saida - total_pago;
            Double total_a_receber = total_entrada - total_recebido;
            String rodape = "Total Pago: " + moeda.setPrecoFormat(total_pago.toString()) + " - Total à pagar:  "
                    + moeda.setPrecoFormat(total_a_pagar.toString()) + " - Total Recebido: " + moeda.setPrecoFormat(total_recebido.toString())
                    + " - Total à receber: " + moeda.setPrecoFormat(total_a_receber.toString());
            jl_rodape.setText(rodape);

            jtbl_contas.requestFocus();
        }

    }

    public void consultarContas() {
        String categoria = "";
        if (!arvore.isSelectionEmpty()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) arvore.getLastSelectedPathComponent();
            System.out.println("Level " + node.getLevel());
            System.out.println("Level " + node.toString());
            if (node.getLevel() == 1) {
                pool = new Pool();
                categoriaDAO = new CategoriaDAO(pool);
                categorias = new ArrayList<>();
                categorias = categoriaDAO.getCategoria(node.toString());
                categoria = categorias.get(0).getCodigo_categoria().toString();
            }
        }

        SimpleDateFormat in = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");

        String dataInicial = null;
        String dataFinal = null;
        try {
            dataInicial = out.format(in.parse(jtf_data_inicial.getText()));
            dataFinal = out.format(in.parse(jtf_data_final.getText()));
        } catch (ParseException ex) {
        }

        pool = new Pool();
        LancamentoContaDAO lancDAO = new LancamentoContaDAO(pool);
        if (jrb_todos.isSelected()) {
            contas = lancDAO.getLancamentoContas(dataInicial, dataFinal, categoria);
        } else if (jrb_recebidos.isSelected()) {
            contas = lancDAO.getLancamentoContasRecebidas(dataInicial, dataFinal);
        } else if (jrb_pagos.isSelected()) {
            contas = lancDAO.getLancamentoContasPagos(dataInicial, dataFinal, categoria);
        } else if (jrb_a_pagar.isSelected()) {
            contas = lancDAO.getLancamentoContasAPagar(dataInicial, dataFinal, categoria);
        } else if (jrb_vencidos.isSelected()) {
            contas = lancDAO.getLancamentoContasVencidas(dataInicial, dataFinal, categoria);
        } else if (jrb_a_receber.isSelected()) {
            contas = lancDAO.getLancamentoContasAReceber(dataInicial, dataFinal);
        }

        try {
            mostrarContas(contas);
        } catch (ParseException ex) {
            Logger.getLogger(Financeiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void novoLancamento() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.FinanceiroPagar");
        try {
            if (acesso.getEscrever() == true) {
                financeiroPagar = new FinanceiroPagar();
                financeiroPagar.janelapai = this;
                financeiroPagar.setVisible(true);
                financeiroPagar.acesso = acesso;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
    }

    private void excluirLancamento() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuCliente");
        try {
            if (acesso.getDeletar() == true) {
                lancamentoConta = tbFornecedorLinhaSelecionada(jtbl_contas);
                if (lancamentoConta != null) {
                    int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_NO_OPTION) {

                        pool = new Pool();
                        LancamentoContaDAO lancamentoDAO = new LancamentoContaDAO(pool);
                        lancamentoDAO.excluir(lancamentoConta.getCodigo_lancamento_contas());
                        consultarContas();
                        
                        LogInfo logInfo = new LogInfo();
                        logInfo.setDescricao("Excluir Conta à pagar:-> " + lancamentoConta.getDescricao() + " Fornecedor: "+ lancamentoConta.getFornecedor().getNome_fantasia());
                        logInfo.setUsuario(acesso.getUsuario());
                        pool = new Pool();
                        LogInfoDAO logInfoDAO = new LogInfoDAO(pool);
                        logInfoDAO.salvar(logInfo);                  
                    
                    }

                }

            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
    }

    public void mostrarNodes() {

        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Categorias");

        pool = new Pool();
        categoriaDAO = new CategoriaDAO(pool);
        categorias = new ArrayList<>();
        categorias = categoriaDAO.getCategoria();

        DefaultMutableTreeNode dmt_categoria;

        if (!categorias.isEmpty()) {

            for (int i = 0; i < categorias.size(); i++) {
                ItemDbGrid hashDbGrid = new ItemDbGrid(categorias.get(i), categorias.get(i).getDescricao());
                dmt_categoria = new DefaultMutableTreeNode(hashDbGrid);
                top.add(dmt_categoria);
            }
        } else {
        }

        arvore.setModel(new javax.swing.tree.DefaultTreeModel(top));
    }

}
