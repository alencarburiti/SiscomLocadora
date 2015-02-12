package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Categoria;
import br.com.locadora.model.bean.Fornecedor;
import br.com.locadora.model.bean.LancamentoConta;
import br.com.locadora.model.bean.LogInfo;
import br.com.locadora.model.bean.SubCategoria;
import br.com.locadora.model.bean.Usuario;
import br.com.locadora.model.dao.CategoriaDAO;
import br.com.locadora.model.dao.LancamentoContaDAO;
import br.com.locadora.model.dao.LogInfoDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
import java.awt.Color;
import java.awt.event.KeyEvent;
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
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class FinanceiroPagar extends javax.swing.JFrame {

    public InterfacePool pool;
    public Financeiro janelapai;
    public Moeda moeda;
    public AcessoUsuario acesso;
    public Financeiro financeiro;
    public MaskFormatter formatoData;
    public List<Fornecedor> fornecedores;
    public Fornecedor fornecedorSaida;
    public CategoriaDAO categoriaDAO;
    public List<Categoria> categorias;
    public List<SubCategoria> subCategorias;
    public Categoria categoriaCombo;

    public FinanceiroPagar() {
        initComponents();
        TemaInterface.getInterface(this);

        Calendar primeiroDia = Calendar.getInstance();

        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

        String data_inicial = out.format(primeiroDia.getTime());

        jtf_data_vencimento.setText(data_inicial);
        carregarCategorias();
    }

    public FinanceiroPagar(LancamentoConta lancamentoConta) {
        initComponents();
        TemaInterface.getInterface(this);
        moeda = new Moeda();

        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        String data_vencimento = null;
        try {
            data_vencimento = out.format(in.parse(lancamentoConta.getData_vencimento().toString()));
        } catch (ParseException ex) {
            Logger.getLogger(FinanceiroPagar.class.getName()).log(Level.SEVERE, null, ex);
        }
        String data_pagamento = "";
        try {
            data_pagamento = out.format(in.parse(lancamentoConta.getData_pagamento().toString()));
        } catch (Exception e) {
        }

        jtf_codigo_lancamento_conta.setText(lancamentoConta.getCodigo_lancamento_contas().toString());
        jtf_descricao.setText(lancamentoConta.getDescricao());
        jtf_documento.setText(lancamentoConta.getDocumento());
        jtf_valor.setText(moeda.setPrecoFormat(lancamentoConta.getValor().toString()));
        jtf_data_vencimento.setText(data_vencimento);
        jtf_valor_pago.setText(moeda.setPrecoFormat(lancamentoConta.getValorPago().toString()));
        jtf_data_pagamento.setText(data_pagamento);
        jtf_codigo_fornecedor.setText(lancamentoConta.getFornecedor().getCodigo_fornecedor().toString());
        jtf_nome_fantasia.setText(lancamentoConta.getFornecedor().getNome_fantasia());
        fornecedorSaida = lancamentoConta.getFornecedor();

        carregarCategorias();
        for(int i =0; i < categorias.size(); i++){
                        
            if(categorias.get(i).getCodigo_categoria().equals(lancamentoConta.getCategoria().getCodigo_categoria())){
                jcb_categoria.setSelectedIndex(i);
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jDesktopPane2 = new javax.swing.JDesktopPane();
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
        jtf_valor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jl_codigo_locacao = new javax.swing.JLabel();
        jtf_descricao = new javax.swing.JTextField();
        jl_codigo_locacao1 = new javax.swing.JLabel();
        jtf_documento = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        /*try  {          
            Locale BRAZIL = new Locale("pt","BR");  
            DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
            formatoPreco = new DecimalFormat("¤ ###,###,##0.00",REAL);  
        }    catch (Exception erro)  
        {    
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");  
        }
        */
        jtf_valor_pago = new javax.swing.JTextField();
        try  {
            formatoData = new MaskFormatter("##/##/####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_data_pagamento = new JFormattedTextField(formatoData);
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        try  {
            formatoData = new MaskFormatter("##/##/####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_data_vencimento = new JFormattedTextField(formatoData);
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtf_codigo_lancamento_conta = new javax.swing.JTextField();
        jtf_codigo_fornecedor = new javax.swing.JTextField();
        jtf_nome_fantasia = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jb_pesquisa_fornecedor = new javax.swing.JButton();
        jcb_categoria = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jb_salvar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();

        jDesktopPane1.setName("jDesktopPane1"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Financeiro - Contas À Pagar");
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

        jp_locacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Lançamento"));
        jp_locacao.setName("jp_locacao"); // NOI18N

        jtf_valor.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_valor.setText("R$ 0,00");
        jtf_valor.setName("jtf_valor"); // NOI18N
        jtf_valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_valorActionPerformed(evt);
            }
        });
        jtf_valor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valorFocusLost(evt);
            }
        });
        jtf_valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_valorKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel5.setText("Valor*");
        jLabel5.setName("jLabel5"); // NOI18N

        jl_codigo_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jl_codigo_locacao.setText("Descrição*");
        jl_codigo_locacao.setName("jl_codigo_locacao"); // NOI18N

        jtf_descricao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_descricao.setName("jtf_descricao"); // NOI18N
        jtf_descricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_descricaoKeyPressed(evt);
            }
        });

        jl_codigo_locacao1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jl_codigo_locacao1.setText("Documento");
        jl_codigo_locacao1.setName("jl_codigo_locacao1"); // NOI18N

        jtf_documento.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_documento.setName("jtf_documento"); // NOI18N
        jtf_documento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_documentoKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel8.setText("Valor Pago");
        jLabel8.setName("jLabel8"); // NOI18N

        jtf_valor_pago.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_valor_pago.setText("R$ 0,00");
        jtf_valor_pago.setName("jtf_valor_pago"); // NOI18N
        jtf_valor_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_valor_pagoActionPerformed(evt);
            }
        });
        jtf_valor_pago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_pagoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valor_pagoFocusLost(evt);
            }
        });
        jtf_valor_pago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_valor_pagoKeyPressed(evt);
            }
        });

        jtf_data_pagamento.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_data_pagamento.setName("jtf_data_pagamento"); // NOI18N
        jtf_data_pagamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_data_pagamentoFocusLost(evt);
            }
        });
        jtf_data_pagamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_data_pagamentoKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel9.setText("Data Pagamento");
        jLabel9.setName("jLabel9"); // NOI18N

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel11.setText("Data Vencimento*");
        jLabel11.setName("jLabel11"); // NOI18N

        jtf_data_vencimento.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_data_vencimento.setName("jtf_data_vencimento"); // NOI18N
        jtf_data_vencimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_data_vencimentoFocusLost(evt);
            }
        });
        jtf_data_vencimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_data_vencimentoKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel10.setText("Código Fornecedor");
        jLabel10.setName("jLabel10"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel1.setText("Código Lançamento");
        jLabel1.setName("jLabel1"); // NOI18N

        jtf_codigo_lancamento_conta.setEditable(false);
        jtf_codigo_lancamento_conta.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_codigo_lancamento_conta.setName("jtf_codigo_lancamento_conta"); // NOI18N
        jtf_codigo_lancamento_conta.setPreferredSize(new java.awt.Dimension(120, 24));
        jtf_codigo_lancamento_conta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_codigo_lancamento_contaActionPerformed(evt);
            }
        });

        jtf_codigo_fornecedor.setEditable(false);
        jtf_codigo_fornecedor.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_codigo_fornecedor.setName("jtf_codigo_fornecedor"); // NOI18N

        jtf_nome_fantasia.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_nome_fantasia.setName("jtf_nome_fantasia"); // NOI18N
        jtf_nome_fantasia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_nome_fantasiaFocusLost(evt);
            }
        });
        jtf_nome_fantasia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_nome_fantasiaKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel12.setText("Nome Fantasia");
        jLabel12.setName("jLabel12"); // NOI18N

        jb_pesquisa_fornecedor.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_pesquisa_fornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jb_pesquisa_fornecedor.setName("jb_pesquisa_fornecedor"); // NOI18N
        jb_pesquisa_fornecedor.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_pesquisa_fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_pesquisa_fornecedorActionPerformed(evt);
            }
        });
        jb_pesquisa_fornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_pesquisa_fornecedorKeyPressed(evt);
            }
        });

        jcb_categoria.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_categoria.setMaximumRowCount(20);
        jcb_categoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        jcb_categoria.setName("jcb_categoria"); // NOI18N
        jcb_categoria.setPreferredSize(new java.awt.Dimension(0, 24));
        jcb_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_categoriaActionPerformed(evt);
            }
        });
        jcb_categoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcb_categoriaKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel6.setText("Categoria*");
        jLabel6.setName("jLabel6"); // NOI18N

        javax.swing.GroupLayout jp_locacaoLayout = new javax.swing.GroupLayout(jp_locacao);
        jp_locacao.setLayout(jp_locacaoLayout);
        jp_locacaoLayout.setHorizontalGroup(
            jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_locacaoLayout.createSequentialGroup()
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_codigo_lancamento_conta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_locacaoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcb_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jp_locacaoLayout.createSequentialGroup()
                                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_codigo_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_codigo_locacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jp_locacaoLayout.createSequentialGroup()
                                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtf_codigo_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                                        .addComponent(jtf_nome_fantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jb_pesquisa_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jp_locacaoLayout.createSequentialGroup()
                                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtf_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_data_vencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtf_valor_pago, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtf_data_pagamento)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jp_locacaoLayout.setVerticalGroup(
            jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_locacaoLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jtf_codigo_lancamento_conta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel6)
                .addGap(0, 0, 0)
                .addComponent(jcb_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, 0)))
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jb_pesquisa_fornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtf_codigo_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtf_nome_fantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, 0)
                        .addComponent(jtf_valor_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_locacaoLayout.createSequentialGroup()
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_locacaoLayout.createSequentialGroup()
                                .addComponent(jl_codigo_locacao)
                                .addGap(0, 0, 0)
                                .addComponent(jtf_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jp_locacaoLayout.createSequentialGroup()
                                .addComponent(jl_codigo_locacao1)
                                .addGap(0, 0, 0)
                                .addComponent(jtf_documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_locacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jp_locacaoLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(0, 0, 0)
                                    .addComponent(jtf_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jp_locacaoLayout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(0, 0, 0)
                                    .addComponent(jtf_data_vencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_locacaoLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, 0)
                                .addComponent(jtf_data_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, 0))
        );

        jp_locacaoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jtf_descricao, jtf_valor});

        jp_locacaoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jtf_codigo_fornecedor, jtf_nome_fantasia});

        jb_salvar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/save.png"))); // NOI18N
        jb_salvar.setText("Salvar");
        jb_salvar.setName("jb_salvar"); // NOI18N
        jb_salvar.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_salvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_salvarMouseClicked(evt);
            }
        });
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

        jb_cancelar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/sair.png"))); // NOI18N
        jb_cancelar.setText("Sair");
        jb_cancelar.setMaximumSize(new java.awt.Dimension(101, 33));
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        jb_cancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_cancelarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jp_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jb_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jp_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jcb_categoria.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
//            abrirCaixa();
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
    }//GEN-LAST:event_formKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jtf_valorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valorFocusLost
        moeda = new Moeda();
        jtf_valor.setText(moeda.setPrecoFormat(jtf_valor.getText()));
    }//GEN-LAST:event_jtf_valorFocusLost

    private void jtf_valorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valorFocusGained
        jtf_valor.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valorFocusGained

    private void jtf_descricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_descricaoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_documento.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_descricaoKeyPressed

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        retornaJanelaPai();
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void jb_salvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_salvarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cadastrarLancamento();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarKeyPressed

    private void jtf_valorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_valorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valorActionPerformed

    private void jb_cancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_cancelarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_cancelar.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_cancelarKeyPressed

    private void jb_salvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_salvarMouseClicked
        if (evt.getClickCount() == 1) {
            cadastrarLancamento();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarMouseClicked

    private void jtf_documentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_documentoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_valor.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_documentoKeyPressed

    private void jtf_valor_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_valor_pagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_pagoActionPerformed

    private void jtf_valor_pagoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_pagoFocusGained
        jtf_valor_pago.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_pagoFocusGained

    private void jtf_valor_pagoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_pagoFocusLost
        moeda = new Moeda();
        jtf_valor_pago.setText(moeda.setPrecoFormat(jtf_valor_pago.getText()));
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_pagoFocusLost

    private void jtf_data_pagamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_pagamentoFocusLost
        try {

            if (jtf_data_pagamento.getText().trim().length() < 10) {
                jtf_data_pagamento.setForeground(Color.red);
            } else if (jtf_data_pagamento.getText().equals("  /  /    ")) {
                jtf_data_pagamento.setForeground(Color.red);
            } else {
                if (validaData(jtf_data_pagamento.getText())) {
                    jtf_data_pagamento.setForeground(Color.black);
                } else {
                    jtf_data_pagamento.setForeground(Color.red);
                }
            }
        } catch (ParseException ex) {
            jtf_data_pagamento.setForeground(Color.red);
        } catch (NumberFormatException ex) {
            jtf_data_pagamento.setText("  /  /    ");
            jtf_data_pagamento.setForeground(Color.red);
        }
    }//GEN-LAST:event_jtf_data_pagamentoFocusLost

    private void jtf_data_pagamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_data_pagamentoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_salvar.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_pagamentoKeyPressed

    private void jtf_data_vencimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_vencimentoFocusLost
        try {

            if (jtf_data_vencimento.getText().trim().length() < 10) {
                jtf_data_vencimento.setForeground(Color.red);
            } else if (jtf_data_vencimento.getText().equals("  /  /    ")) {
                jtf_data_vencimento.setForeground(Color.red);
            } else {
                if (validaData(jtf_data_vencimento.getText())) {
                    jtf_data_vencimento.setForeground(Color.black);
                } else {
                    jtf_data_vencimento.setForeground(Color.red);
                }
            }
        } catch (ParseException ex) {
            jtf_data_vencimento.setForeground(Color.red);
        } catch (NumberFormatException ex) {
            jtf_data_vencimento.setText("  /  /    ");
            jtf_data_vencimento.setForeground(Color.red);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_vencimentoFocusLost

    private void jtf_data_vencimentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_data_vencimentoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_valor_pago.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_vencimentoKeyPressed

    private void jtf_valorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valorKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_data_vencimento.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valorKeyPressed

    private void jtf_valor_pagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_pagoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_data_pagamento.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_pagoKeyPressed

    private void jtf_nome_fantasiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nome_fantasiaFocusLost

    }//GEN-LAST:event_jtf_nome_fantasiaFocusLost

    private void jtf_nome_fantasiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_fantasiaKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_pesquisa_fornecedor.doClick();
        }
    }//GEN-LAST:event_jtf_nome_fantasiaKeyPressed

    private void jb_pesquisa_fornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_pesquisa_fornecedorActionPerformed
        ConsultaFornecedorSaida consultaFornecedor = new ConsultaFornecedorSaida();
        consultaFornecedor.janelapai = this;
        consultaFornecedor.setVisible(true);
        consultaFornecedor.jtf_consulta.setText(jtf_nome_fantasia.getText().trim());
        setStatusTela(false);
    }//GEN-LAST:event_jb_pesquisa_fornecedorActionPerformed

    private void jb_pesquisa_fornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_pesquisa_fornecedorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_pesquisa_fornecedor.doClick();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_pesquisa_fornecedorKeyPressed

    private void jcb_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_categoriaActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_categoriaActionPerformed

    private void jcb_categoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_categoriaKeyPressed
        acionarAtalho(evt);
        try {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                jtf_nome_fantasia.requestFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_categoriaKeyPressed

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarActionPerformed

    private void jtf_codigo_lancamento_contaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_codigo_lancamento_contaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_codigo_lancamento_contaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FinanceiroPagar().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_pesquisa_fornecedor;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JComboBox jcb_categoria;
    private javax.swing.JLabel jl_codigo_locacao;
    private javax.swing.JLabel jl_codigo_locacao1;
    public static javax.swing.JPanel jp_locacao;
    public static javax.swing.JTextField jtf_codigo_fornecedor;
    public javax.swing.JTextField jtf_codigo_lancamento_conta;
    public static javax.swing.JFormattedTextField jtf_data_pagamento;
    public static javax.swing.JFormattedTextField jtf_data_vencimento;
    private javax.swing.JTextField jtf_descricao;
    private javax.swing.JTextField jtf_documento;
    public static javax.swing.JTextField jtf_nome_fantasia;
    private javax.swing.JTextField jtf_valor;
    private javax.swing.JTextField jtf_valor_pago;
    // End of variables declaration//GEN-END:variables

    public void limparCampos() {
//        jtf_codigo_cliente.setText("");
//        jtf_codigo_consulta_locacao.setText("");
//        jtf_valor_locacao.setText("");
//        jtf_tipo_midia.setText("");
//        jtf_diaria.setText("");
    }

    public void carregarCategorias() {
        jcb_categoria.removeAllItems();

        pool = new Pool();
        categoriaDAO = new CategoriaDAO(pool);
        categorias = new ArrayList<>();
        categorias = categoriaDAO.getCategoria();
        if (categorias.size() > 0) {
            for (int i = 0; i < categorias.size(); i++) {
                ItemDbGrid hashDbGrid = new ItemDbGrid(categorias.get(i), categorias.get(i).getDescricao());
                jcb_categoria.addItem(hashDbGrid);
            }
        }
    }

    public boolean verificarCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_descricao.getText().equals("")) {
            msgERRO = msgERRO + " *Descrição\n";
        }

        try {
            if (jtf_codigo_fornecedor.getText().length() == 0) {
                msgERRO = msgERRO + " *Fornecedor\n";
            }
            if (jtf_data_vencimento.getForeground().equals(Color.red)) {
                msgERRO = msgERRO + " *Data de Vencimento inválida\n";
            } else if (jtf_data_vencimento.getText().trim().length() < 10) {
                msgERRO = msgERRO + " *Data de Vencimento inválida\n";
            } else if (!validaData(jtf_data_vencimento.getText())) {
                msgERRO = msgERRO + " *Data de Vencimento inválida\n";
            }

            if (jtf_data_pagamento.getText().trim().length() < 10) {
                jtf_data_pagamento.setText("  /  /    ");
                jtf_data_pagamento.setForeground(Color.red);
            }
            if (!validaData(jtf_data_pagamento.getText())) {
                msgERRO = msgERRO + " *Data de Pagamento inválida\n";
            }

        } catch (ParseException ex) {

        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jtf_nome_fantasia.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void setStatusTela(boolean status) {
        if (status) {
            this.setVisible(status);
        }
        this.setEnabled(status);
    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {

        if (evt.getKeyCode() == KeyEvent.VK_F10) {
//            abrirCaixa();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            retornaJanelaPai();
        }
    }

    private void retornaJanelaPai() {
        setVisible(false);
        if (janelapai != null) {
            janelapai.setStatusTela(true);
            janelapai.consultarContas();
            janelapai.financeiroPagar = null;
            janelapai = null;
        }
    }

    private void cadastrarLancamento() {

        try {
            if (verificarCampos() == true) {
                ItemDbGrid hashDbGrid = (ItemDbGrid) jcb_categoria.getSelectedItem();
                categoriaCombo = (Categoria) hashDbGrid.getObjeto();

                moeda = new Moeda();
                LancamentoConta lancamentoContas = new LancamentoConta();
                lancamentoContas.setDescricao(jtf_descricao.getText().trim());
                lancamentoContas.setDocumento(jtf_documento.getText());
                lancamentoContas.setValor(moeda.getPrecoFormato(jtf_valor.getText()));
                lancamentoContas.setCategoria(categoriaCombo);
                if (jtf_data_vencimento.getForeground().equals(Color.BLACK)) {
                    lancamentoContas.setData_vencimento(new SimpleDateFormat("dd/MM/yyyy").parse((String) jtf_data_vencimento.getText()));
                }
                lancamentoContas.setValorPago(moeda.getPrecoFormato(jtf_valor_pago.getText()));
                if (jtf_data_pagamento.getForeground().equals(Color.BLACK)) {
                    lancamentoContas.setData_pagamento(new SimpleDateFormat("dd/MM/yyyy").parse((String) jtf_data_pagamento.getText()));
                }
                lancamentoContas.setFornecedor(fornecedorSaida);

                ArquivoConfiguracao conf = new ArquivoConfiguracao();

                Usuario usuario = new Usuario();
                usuario.setCodigo_usuario(Integer.parseInt(conf.readPropertie("codigo_usuario")));
                lancamentoContas.setCaixa(Integer.parseInt(conf.readPropertie("caixa")));
                lancamentoContas.setUsuario(usuario);

                pool = new Pool();
                LancamentoContaDAO lancamDAO = new LancamentoContaDAO(pool);
                if (jtf_codigo_lancamento_conta.getText().equals("")) {
                    LogInfo logInfo = new LogInfo();
                    logInfo.setDescricao("Nova Conta à pagar:-> " + lancamentoContas.getDescricao() + " Fornecedor: "+ lancamentoContas.getFornecedor().getNome_fantasia());
                    logInfo.setUsuario(acesso.getUsuario());
                    pool = new Pool();
                    LogInfoDAO logInfoDAO = new LogInfoDAO(pool);
                    logInfoDAO.salvar(logInfo);                                      
                            
                    lancamDAO.salvar(lancamentoContas);
                } else {
                    LogInfo logInfo = new LogInfo();
                    logInfo.setDescricao("Alterar Conta à pagar:-> " + lancamentoContas.getDescricao() + " Fornecedor: "+ lancamentoContas.getFornecedor().getNome_fantasia());
                    logInfo.setUsuario(acesso.getUsuario());
                    pool = new Pool();
                    LogInfoDAO logInfoDAO = new LogInfoDAO(pool);
                    logInfoDAO.salvar(logInfo);                  
                    
                    lancamentoContas.setCodigo_lancamento_contas(Integer.parseInt(jtf_codigo_lancamento_conta.getText()));
                    lancamDAO.atualizar(lancamentoContas);
                }
                retornaJanelaPai();
            }
        } catch (ParseException ex) {
            Logger.getLogger(FinanceiroPagar.class.getName()).log(Level.SEVERE, null, ex);
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

            return (true);
        }
        return false;
    }

    public void carregarFornecedor(Fornecedor fornecedor) {
        if (fornecedor != null) {
            fornecedorSaida = fornecedor;

            jtf_codigo_fornecedor.setText(fornecedor.getCodigo_fornecedor().toString());
            jtf_nome_fantasia.setText(fornecedor.getNome_fantasia());

            jtf_descricao.requestFocus();

        }
    }
}
