/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastraAlteraDiaria.java
 *
 * Created on 23/05/2011, 20:12:16
 */
package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.LogInfo;
import br.com.locadora.model.bean.PromocaoDevolucao;
import br.com.locadora.model.bean.PromocaoLocacao;
import br.com.locadora.model.dao.DiariaDAO;
import br.com.locadora.model.dao.LogInfoDAO;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.LimitadorTexto;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
import br.com.locadora.util.UnaccentedDocument;
import static br.com.locadora.view.CadastraAlteraCombo.jtf_descricao_pacote;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author ALENCAR
 */
public class CadastraAlteraDiaria extends javax.swing.JFrame {

    public MenuDiaria janelapai;
    public Diaria diaria;
    public PromocaoLocacao promocaoLocacao;
    public PromocaoDevolucao promocaoDevolucao;
    public ConsultaDiaria janelapai2;
    public AcessoUsuario acesso;
    public List<Diaria> itensPromocaoLocacao;
    public List<Diaria> itensPromocaoDevolucao;
    public Moeda moeda;
    public MaskFormatter formatoHora, formatoNumero;
    public DiariaDAO diariaDAO;
    public String actionLocacao;
    public String actionDevolucao;
    public Diaria promocaoLocacaoAlterar;
    public Diaria promocaoDevolucaoAlterar;

    public CadastraAlteraDiaria() {
        initComponents();
        TemaInterface.getInterface(this);
        this.setTitle("Cadastrando Diária");
        janelapai = null;
        janelapai2 = null;
        actionLocacao = "salvar";
        actionDevolucao = "salvar";
    }

    public CadastraAlteraDiaria(Diaria diaria){
        initComponents();
        if (diaria != null) {
            TemaInterface.getInterface(this);
            this.setTitle("Alterando Diária");
            janelapai = null;
            this.diaria = diaria;
            System.out.println("Código Diária: " + this.diaria.getCodigo_diaria());
            jtf_codigo_diaria.setText(String.valueOf(this.diaria.getCodigo_diaria()));
            jtf_nome_diaria.setText(this.diaria.getNome_diaria());
            jtf_dias.setText(this.diaria.getDias().toString());
            jtf_dias_maximo.setText(this.diaria.getMaximo_dias().toString());
            moeda = new Moeda();
            jtf_valor.setText(moeda.setPrecoFormat(this.diaria.getValor().toString()));
            jtf_relocacao.setText(moeda.setPrecoFormat(this.diaria.getMultas().toString()));
            if (diaria.getAcumulativo() == true) {
                jcb_acumulativo.setSelected(true);
            } else {
                jcb_acumulativo.setSelected(false);
            }
            carregarPromocoesLocacao(diaria);
            carregarPromocoesDevolucao(diaria);
            actionLocacao = "salvar";
            actionDevolucao = "salvar";
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox2 = new javax.swing.JCheckBox();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jb_salvar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtf_codigo_diaria = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtf_valor = new javax.swing.JTextField(new LimitadorTexto(10), "",10);
        jLabel7 = new javax.swing.JLabel();
        jtf_relocacao = new javax.swing.JTextField(new LimitadorTexto(10), "",10);
        jtf_nome_diaria = new javax.swing.JTextField(new LimitadorTexto(50), "",10);
        jLabel6 = new javax.swing.JLabel();
        jtf_dias = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jtf_dias_maximo = new javax.swing.JFormattedTextField();
        jcb_acumulativo = new javax.swing.JCheckBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jtf_valor_promocao_locacao = new javax.swing.JTextField(new LimitadorTexto(10), "",10);
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jb_eliminar_promocao_locacao = new javax.swing.JButton();
        jb_adicionar_promocao_locacao = new javax.swing.JButton();
        jtf_descricao_locacao = new javax.swing.JTextField(new LimitadorTexto(50), "",10);
        jLabel12 = new javax.swing.JLabel();
        jcb_a_vista_locacao = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jtf_locar_quantidade = new javax.swing.JFormattedTextField();
        jtf_ganhar_quantidade = new javax.swing.JFormattedTextField();
        jtf_ordem = new javax.swing.JFormattedTextField();
        jrb_ativo_locacao = new javax.swing.JRadioButton();
        jrb_inativo_locacao = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_promocao_locacao = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jcb_domingo = new javax.swing.JCheckBox();
        jcb_segunda = new javax.swing.JCheckBox();
        jcb_terca = new javax.swing.JCheckBox();
        jcb_quarta = new javax.swing.JCheckBox();
        jcb_quinta = new javax.swing.JCheckBox();
        jcb_sexta = new javax.swing.JCheckBox();
        jcb_sabado = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jb_eliminar_promocao_devolucao = new javax.swing.JButton();
        jb_adicionar_promocao_devolucao = new javax.swing.JButton();
        jtf_descricao_devolucao = new javax.swing.JTextField(new LimitadorTexto(50), "",10);
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtf_valor_promocao_devolucao = new javax.swing.JTextField(new LimitadorTexto(10), "",10);
        try  {
            formatoHora = new MaskFormatter("##:##:##");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_horas_antecipada = new JFormattedTextField(formatoHora);
        try  {
            formatoHora = new MaskFormatter("##:##:##");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_horario_locacao = new JFormattedTextField(formatoHora);
        try  {
            formatoHora = new MaskFormatter("##:##:##");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_horario_devolucao = new JFormattedTextField(formatoHora);
        jcb_a_vista_devolucao = new javax.swing.JCheckBox();
        jrb_ativo_devolucao = new javax.swing.JRadioButton();
        jrb_inativo_devolucao = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_promocao_devolucao = new javax.swing.JTable();

        jCheckBox2.setText("jCheckBox2");
        jCheckBox2.setName("jCheckBox2"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrando Diária");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        jb_cancelar.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/sair.png"))); // NOI18N
        jb_cancelar.setText("Sair");
        jb_cancelar.setName("jb_cancelar"); // NOI18N
        jb_cancelar.setPreferredSize(new java.awt.Dimension(100, 40));
        jb_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_cancelarMouseClicked(evt);
            }
        });
        jb_cancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_cancelarKeyPressed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informação Diária"));
        jPanel2.setName("jPanel2"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel3.setText("Nome*");
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel2.setText("Código Diária");
        jLabel2.setName("jLabel2"); // NOI18N

        jtf_codigo_diaria.setEditable(false);
        jtf_codigo_diaria.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_codigo_diaria.setName("jtf_codigo_diaria"); // NOI18N
        jtf_codigo_diaria.setPreferredSize(new java.awt.Dimension(100, 24));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel4.setText("Locação*");
        jLabel4.setName("jLabel4"); // NOI18N

        jtf_valor.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_valor.setText("R$ 0,00");
        jtf_valor.setName("jtf_valor"); // NOI18N
        jtf_valor.setPreferredSize(new java.awt.Dimension(80, 24));
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

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel7.setText("Relocação*");
        jLabel7.setName("jLabel7"); // NOI18N

        jtf_relocacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_relocacao.setText("R$ 0,00");
        jtf_relocacao.setName("jtf_relocacao"); // NOI18N
        jtf_relocacao.setPreferredSize(new java.awt.Dimension(80, 24));
        jtf_relocacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_relocacaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_relocacaoFocusLost(evt);
            }
        });
        jtf_relocacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_relocacaoKeyPressed(evt);
            }
        });

        jtf_nome_diaria.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_nome_diaria.setName("jtf_nome_diaria"); // NOI18N
        jtf_nome_diaria.setPreferredSize(new java.awt.Dimension(300, 24));
        jtf_nome_diaria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_nome_diariaKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel6.setText("Minimo Dias*");
        jLabel6.setName("jLabel6"); // NOI18N

        jtf_dias.addKeyListener(new java.awt.event.KeyAdapter() {     // cria um listener ouvinte de digitação do fieldNumero

            public void keyReleased(java.awt.event.KeyEvent evt) {  // cria um ouvinte para cada tecla pressionada

                jtf_dias.setText(jtf_dias.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que não(^) seja numero  por ""

            }
        });
        jtf_dias.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_dias.setName("jtf_dias"); // NOI18N
        jtf_dias.setPreferredSize(new java.awt.Dimension(80, 24));
        jtf_dias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_diasKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel15.setText("Máximo Dias*");
        jLabel15.setName("jLabel15"); // NOI18N

        jtf_dias_maximo.addKeyListener(new java.awt.event.KeyAdapter() {     // cria um listener ouvinte de digitação do fieldNumero

            public void keyReleased(java.awt.event.KeyEvent evt) {  // cria um ouvinte para cada tecla pressionada

                jtf_dias_maximo.setText(jtf_dias_maximo.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que não(^) seja numero  por ""

            }
        });
        jtf_dias_maximo.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_dias_maximo.setName("jtf_dias_maximo"); // NOI18N
        jtf_dias_maximo.setPreferredSize(new java.awt.Dimension(80, 24));
        jtf_dias_maximo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_dias_maximoKeyPressed(evt);
            }
        });

        jcb_acumulativo.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_acumulativo.setText("Acumulativo");
        jcb_acumulativo.setName("jcb_acumulativo"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jtf_codigo_diaria, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_nome_diaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtf_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_relocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtf_dias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jtf_dias_maximo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jcb_acumulativo)))))
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_codigo_diaria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_nome_diaria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jcb_acumulativo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel15))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel7)))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtf_relocacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtf_dias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtf_dias_maximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtf_valor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, 0))
        );

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel4.setName("jPanel4"); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes"));
        jPanel3.setName("jPanel3"); // NOI18N

        jtf_valor_promocao_locacao.setDocument(new UnaccentedDocument());
        jtf_valor_promocao_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_valor_promocao_locacao.setText("R$ 0,00");
        jtf_valor_promocao_locacao.setName("jtf_valor_promocao_locacao"); // NOI18N
        jtf_valor_promocao_locacao.setPreferredSize(new java.awt.Dimension(60, 24));
        jtf_valor_promocao_locacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_promocao_locacaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valor_promocao_locacaoFocusLost(evt);
            }
        });
        jtf_valor_promocao_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_valor_promocao_locacaoKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel5.setText("Valor Cada Item Ganhado");
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel8.setText("Ordem");
        jLabel8.setName("jLabel8"); // NOI18N

        jb_eliminar_promocao_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_eliminar_promocao_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/remove_item.png"))); // NOI18N
        jb_eliminar_promocao_locacao.setToolTipText("Excluir");
        jb_eliminar_promocao_locacao.setName("jb_eliminar_promocao_locacao"); // NOI18N
        jb_eliminar_promocao_locacao.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_eliminar_promocao_locacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_eliminar_promocao_locacaoMouseClicked(evt);
            }
        });
        jb_eliminar_promocao_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_eliminar_promocao_locacaoKeyPressed(evt);
            }
        });

        jb_adicionar_promocao_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_adicionar_promocao_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/adicionar_item.png"))); // NOI18N
        jb_adicionar_promocao_locacao.setToolTipText("Incluir");
        jb_adicionar_promocao_locacao.setName("jb_adicionar_promocao_locacao"); // NOI18N
        jb_adicionar_promocao_locacao.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_adicionar_promocao_locacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_adicionar_promocao_locacaoMouseClicked(evt);
            }
        });
        jb_adicionar_promocao_locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_adicionar_promocao_locacaoActionPerformed(evt);
            }
        });
        jb_adicionar_promocao_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_adicionar_promocao_locacaoKeyPressed(evt);
            }
        });

        jtf_descricao_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_descricao_locacao.setName("jtf_descricao_locacao"); // NOI18N
        jtf_descricao_locacao.setPreferredSize(new java.awt.Dimension(300, 24));
        jtf_descricao_locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_descricao_locacaoActionPerformed(evt);
            }
        });
        jtf_descricao_locacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_descricao_locacaoFocusGained(evt);
            }
        });
        jtf_descricao_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_descricao_locacaoKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel12.setText("Descrição");
        jLabel12.setName("jLabel12"); // NOI18N

        jcb_a_vista_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_a_vista_locacao.setText("Aplicar esta regra apenas para pagamentos à vista.");
        jcb_a_vista_locacao.setName("jcb_a_vista_locacao"); // NOI18N

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel16.setText("Locar Qtd.");
        jLabel16.setName("jLabel16"); // NOI18N

        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel17.setText("Ganha Qtd.");
        jLabel17.setName("jLabel17"); // NOI18N

        jtf_locar_quantidade.addKeyListener(new java.awt.event.KeyAdapter() {     // cria um listener ouvinte de digitação do fieldNumero

            public void keyReleased(java.awt.event.KeyEvent evt) {  // cria um ouvinte para cada tecla pressionada

                jtf_locar_quantidade.setText(jtf_locar_quantidade.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que não(^) seja numero  por ""

            }
        });
        jtf_locar_quantidade.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_locar_quantidade.setName("jtf_locar_quantidade"); // NOI18N
        jtf_locar_quantidade.setPreferredSize(new java.awt.Dimension(80, 24));
        jtf_locar_quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_locar_quantidadeKeyPressed(evt);
            }
        });

        jtf_ganhar_quantidade.addKeyListener(new java.awt.event.KeyAdapter() {     // cria um listener ouvinte de digitação do fieldNumero

            public void keyReleased(java.awt.event.KeyEvent evt) {  // cria um ouvinte para cada tecla pressionada

                jtf_ganhar_quantidade.setText(jtf_ganhar_quantidade.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que não(^) seja numero  por ""

            }
        });
        jtf_ganhar_quantidade.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_ganhar_quantidade.setName("jtf_ganhar_quantidade"); // NOI18N
        jtf_ganhar_quantidade.setPreferredSize(new java.awt.Dimension(80, 24));
        jtf_ganhar_quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_ganhar_quantidadeKeyPressed(evt);
            }
        });

        jtf_ordem.addKeyListener(new java.awt.event.KeyAdapter() {     // cria um listener ouvinte de digitação do fieldNumero

            public void keyReleased(java.awt.event.KeyEvent evt) {  // cria um ouvinte para cada tecla pressionada

                jtf_ordem.setText(jtf_ordem.getText().replaceAll("[^0-9]", "")); // faz com que pegue o texto a cada tecla digitada, e substituir tudo que não(^) seja numero  por ""

            }
        });
        jtf_ordem.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_ordem.setName("jtf_ordem"); // NOI18N
        jtf_ordem.setPreferredSize(new java.awt.Dimension(80, 24));
        jtf_ordem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_ordemKeyPressed(evt);
            }
        });

        buttonGroup1.add(jrb_ativo_locacao);
        jrb_ativo_locacao.setSelected(true);
        jrb_ativo_locacao.setText("Ativo");
        jrb_ativo_locacao.setName("jrb_ativo_locacao"); // NOI18N
        jrb_ativo_locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_ativo_locacaoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrb_inativo_locacao);
        jrb_inativo_locacao.setText("Inativo");
        jrb_inativo_locacao.setName("jrb_inativo_locacao"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(jrb_ativo_locacao))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtf_valor_promocao_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jtf_locar_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jtf_ganhar_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jtf_ordem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jb_adicionar_promocao_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(jb_eliminar_promocao_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jcb_a_vista_locacao)
                            .addComponent(jtf_descricao_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 116, Short.MAX_VALUE)))
                .addGap(0, 0, 0)
                .addComponent(jrb_inativo_locacao))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jrb_inativo_locacao)
                        .addComponent(jrb_ativo_locacao))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, 0)
                        .addComponent(jtf_descricao_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_ganhar_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_locar_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_valor_promocao_locacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addGap(0, 0, 0)
                                .addComponent(jtf_ordem, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jb_eliminar_promocao_locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jb_adicionar_promocao_locacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(jcb_a_vista_locacao)))
                .addGap(0, 0, 0))
        );

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jtbl_promocao_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_promocao_locacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Locar Qtd.", "Ganhar Qtd.", "Valor", "À vista", "Ordem", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.Boolean.class
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
        jtbl_promocao_locacao.setName("jtbl_promocao_locacao"); // NOI18N
        jtbl_promocao_locacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_promocao_locacaoMouseClicked(evt);
            }
        });
        jtbl_promocao_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_promocao_locacaoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbl_promocao_locacao);
        if (jtbl_promocao_locacao.getColumnModel().getColumnCount() > 0) {
            jtbl_promocao_locacao.getColumnModel().getColumn(0).setPreferredWidth(150);
            jtbl_promocao_locacao.getColumnModel().getColumn(1).setPreferredWidth(30);
            jtbl_promocao_locacao.getColumnModel().getColumn(2).setPreferredWidth(30);
            jtbl_promocao_locacao.getColumnModel().getColumn(3).setPreferredWidth(20);
            jtbl_promocao_locacao.getColumnModel().getColumn(4).setPreferredWidth(10);
            jtbl_promocao_locacao.getColumnModel().getColumn(5).setPreferredWidth(10);
            jtbl_promocao_locacao.getColumnModel().getColumn(6).setPreferredWidth(10);
        }

        jLabel1.setText("* Selecione item na Tabela para verificar dias de promoção");
        jLabel1.setName("jLabel1"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dias"));
        jPanel1.setName("jPanel1"); // NOI18N

        jcb_domingo.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_domingo.setSelected(true);
        jcb_domingo.setText("Domingo");
        jcb_domingo.setName("jcb_domingo"); // NOI18N
        jcb_domingo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_domingoActionPerformed(evt);
            }
        });
        jPanel1.add(jcb_domingo);

        jcb_segunda.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_segunda.setSelected(true);
        jcb_segunda.setText("Segunda");
        jcb_segunda.setName("jcb_segunda"); // NOI18N
        jPanel1.add(jcb_segunda);

        jcb_terca.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_terca.setSelected(true);
        jcb_terca.setText("Terça");
        jcb_terca.setName("jcb_terca"); // NOI18N
        jPanel1.add(jcb_terca);

        jcb_quarta.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_quarta.setSelected(true);
        jcb_quarta.setText("Quarta");
        jcb_quarta.setName("jcb_quarta"); // NOI18N
        jPanel1.add(jcb_quarta);

        jcb_quinta.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_quinta.setSelected(true);
        jcb_quinta.setText("Quinta");
        jcb_quinta.setName("jcb_quinta"); // NOI18N
        jPanel1.add(jcb_quinta);

        jcb_sexta.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_sexta.setSelected(true);
        jcb_sexta.setText("Sexta");
        jcb_sexta.setName("jcb_sexta"); // NOI18N
        jPanel1.add(jcb_sexta);

        jcb_sabado.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_sabado.setSelected(true);
        jcb_sabado.setText("Sábado");
        jcb_sabado.setName("jcb_sabado"); // NOI18N
        jPanel1.add(jcb_sabado);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1))
        );

        jTabbedPane1.addTab("Regras Locação", jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel5.setName("jPanel5"); // NOI18N

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes"));
        jPanel6.setName("jPanel6"); // NOI18N

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel9.setText("Horário Loc.");
        jLabel9.setName("jLabel9"); // NOI18N

        jb_eliminar_promocao_devolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/remove_item.png"))); // NOI18N
        jb_eliminar_promocao_devolucao.setToolTipText("Excluir");
        jb_eliminar_promocao_devolucao.setName("jb_eliminar_promocao_devolucao"); // NOI18N
        jb_eliminar_promocao_devolucao.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_eliminar_promocao_devolucao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_eliminar_promocao_devolucaoMouseClicked(evt);
            }
        });
        jb_eliminar_promocao_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_eliminar_promocao_devolucaoKeyPressed(evt);
            }
        });

        jb_adicionar_promocao_devolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/adicionar_item.png"))); // NOI18N
        jb_adicionar_promocao_devolucao.setToolTipText("Incluir");
        jb_adicionar_promocao_devolucao.setName("jb_adicionar_promocao_devolucao"); // NOI18N
        jb_adicionar_promocao_devolucao.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_adicionar_promocao_devolucao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_adicionar_promocao_devolucaoMouseClicked(evt);
            }
        });
        jb_adicionar_promocao_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_adicionar_promocao_devolucaoKeyPressed(evt);
            }
        });

        jtf_descricao_devolucao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_descricao_devolucao.setName("jtf_descricao_devolucao"); // NOI18N
        jtf_descricao_devolucao.setPreferredSize(new java.awt.Dimension(300, 24));
        jtf_descricao_devolucao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_descricao_devolucaoFocusGained(evt);
            }
        });
        jtf_descricao_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_descricao_devolucaoKeyPressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel14.setText("Descrição");
        jLabel14.setName("jLabel14"); // NOI18N

        jLabel18.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel18.setText("Horas Antec.");
        jLabel18.setName("jLabel18"); // NOI18N

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel10.setText("Horário Dev.");
        jLabel10.setName("jLabel10"); // NOI18N

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel11.setText("Valor");
        jLabel11.setName("jLabel11"); // NOI18N

        jtf_valor_promocao_devolucao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_valor_promocao_devolucao.setText("R$ 0,00");
        jtf_valor_promocao_devolucao.setName("jtf_valor_promocao_devolucao"); // NOI18N
        jtf_valor_promocao_devolucao.setPreferredSize(new java.awt.Dimension(80, 24));
        jtf_valor_promocao_devolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_valor_promocao_devolucaoActionPerformed(evt);
            }
        });
        jtf_valor_promocao_devolucao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_valor_promocao_devolucaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_valor_promocao_devolucaoFocusLost(evt);
            }
        });
        jtf_valor_promocao_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_valor_promocao_devolucaoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_valor_promocao_devolucaoKeyReleased(evt);
            }
        });

        jtf_horas_antecipada.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtf_horas_antecipada.setText("00:00:00");
        jtf_horas_antecipada.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_horas_antecipada.setName("jtf_horas_antecipada"); // NOI18N
        jtf_horas_antecipada.setPreferredSize(new java.awt.Dimension(80, 24));
        jtf_horas_antecipada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_horas_antecipadaFocusLost(evt);
            }
        });
        jtf_horas_antecipada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_horas_antecipadaKeyPressed(evt);
            }
        });

        jtf_horario_locacao.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtf_horario_locacao.setText("00:00:00");
        jtf_horario_locacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_horario_locacao.setName("jtf_horario_locacao"); // NOI18N
        jtf_horario_locacao.setPreferredSize(new java.awt.Dimension(80, 24));
        jtf_horario_locacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_horario_locacaoFocusLost(evt);
            }
        });
        jtf_horario_locacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_horario_locacaoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_horario_locacaoKeyTyped(evt);
            }
        });

        jtf_horario_devolucao.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtf_horario_devolucao.setText("00:00:00");
        jtf_horario_devolucao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_horario_devolucao.setName("jtf_horario_devolucao"); // NOI18N
        jtf_horario_devolucao.setPreferredSize(new java.awt.Dimension(80, 24));
        jtf_horario_devolucao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_horario_devolucaoFocusLost(evt);
            }
        });
        jtf_horario_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_horario_devolucaoKeyPressed(evt);
            }
        });

        jcb_a_vista_devolucao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_a_vista_devolucao.setText("Aplicar esta regra apenas para pagamentos à vista.");
        jcb_a_vista_devolucao.setName("jcb_a_vista_devolucao"); // NOI18N

        buttonGroup2.add(jrb_ativo_devolucao);
        jrb_ativo_devolucao.setSelected(true);
        jrb_ativo_devolucao.setText("Ativo");
        jrb_ativo_devolucao.setName("jrb_ativo_devolucao"); // NOI18N
        jrb_ativo_devolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_ativo_devolucaoActionPerformed(evt);
            }
        });

        buttonGroup2.add(jrb_inativo_devolucao);
        jrb_inativo_devolucao.setText("Inativo");
        jrb_inativo_devolucao.setName("jrb_inativo_devolucao"); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_descricao_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addComponent(jrb_ativo_devolucao)
                .addGap(0, 0, 0)
                .addComponent(jrb_inativo_devolucao))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jtf_horario_locacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jtf_horario_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtf_horas_antecipada, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtf_valor_promocao_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_adicionar_promocao_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jb_eliminar_promocao_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcb_a_vista_devolucao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jrb_ativo_devolucao)
                    .addComponent(jrb_inativo_devolucao)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, 0)
                        .addComponent(jtf_descricao_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_valor_promocao_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_horas_antecipada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtf_horario_locacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtf_horario_devolucao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jb_eliminar_promocao_devolucao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addComponent(jb_adicionar_promocao_devolucao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jcb_a_vista_devolucao))
        );

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jtbl_promocao_devolucao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_promocao_devolucao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Horário Loc.", "Horário Dev.", "Horas Antec.", "Valor", "À vista", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class
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
        jtbl_promocao_devolucao.setName("jtbl_promocao_devolucao"); // NOI18N
        jtbl_promocao_devolucao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_promocao_devolucaoMouseClicked(evt);
            }
        });
        jtbl_promocao_devolucao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_promocao_devolucaoKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtbl_promocao_devolucao);
        if (jtbl_promocao_devolucao.getColumnModel().getColumnCount() > 0) {
            jtbl_promocao_devolucao.getColumnModel().getColumn(0).setPreferredWidth(150);
            jtbl_promocao_devolucao.getColumnModel().getColumn(1).setPreferredWidth(50);
            jtbl_promocao_devolucao.getColumnModel().getColumn(2).setPreferredWidth(50);
            jtbl_promocao_devolucao.getColumnModel().getColumn(3).setPreferredWidth(50);
            jtbl_promocao_devolucao.getColumnModel().getColumn(4).setPreferredWidth(50);
            jtbl_promocao_devolucao.getColumnModel().getColumn(5).setPreferredWidth(10);
            jtbl_promocao_devolucao.getColumnModel().getColumn(6).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Regras Devolução", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jb_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jb_cancelar, jb_salvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jb_salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_nome_diaria.requestFocus();
        this.setEnabled(true);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornaJanelaPai();
    }//GEN-LAST:event_formWindowClosed

    private void jtf_valorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valorFocusGained
        jtf_valor.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valorFocusGained

    private void jtf_valorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_relocacao.requestFocus();
        }
        acionarAtalho(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valorKeyPressed

    private void jtf_valor_promocao_locacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_promocao_locacaoFocusGained
        jtf_valor_promocao_locacao.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocao_locacaoFocusGained

    private void jtf_valor_promocao_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_promocao_locacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_locar_quantidade.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocao_locacaoKeyPressed

    private void jtf_relocacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_relocacaoFocusGained
        jtf_relocacao.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_relocacaoFocusGained

    private void jtf_relocacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_relocacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (jtf_relocacao.getText().equals("")) {
                jtf_relocacao.setText("R$ 0,00");
            } else {
                moeda = new Moeda();
                jtf_relocacao.setText(moeda.setPrecoFormat(jtf_relocacao.getText()));
            }
            jtf_dias.requestFocus();
        }

        acionarAtalho(evt);
// TODO add your handling code here:
    }//GEN-LAST:event_jtf_relocacaoKeyPressed

    private void jcb_domingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_domingoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_domingoActionPerformed

    private void jb_adicionar_promocao_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_adicionar_promocao_locacaoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            adicionarPromocaoLocacao();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_promocao_locacaoKeyPressed

    private void jtf_descricao_locacaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_descricao_locacaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_descricao_locacaoFocusGained

    private void jtf_descricao_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_descricao_locacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_valor_promocao_locacao.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_descricao_locacaoKeyPressed

    private void jtf_valor_promocao_locacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_promocao_locacaoFocusLost
        if (jtf_valor_promocao_locacao.getText().equals("")) {
            jtf_valor_promocao_locacao.setText("R$ 0,00");
        } else {
            moeda = new Moeda();
            jtf_valor_promocao_locacao.setText(moeda.setPrecoFormat(jtf_valor_promocao_locacao.getText()));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocao_locacaoFocusLost

    private void jb_eliminar_promocao_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_eliminar_promocao_locacaoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            excluirPromocaoLocacao();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_eliminar_promocao_locacaoKeyPressed

    private void jtf_valorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valorFocusLost
        if (jtf_valor.getText().equals("")) {
            jtf_valor.setText("R$ 0,00");
        } else {
            moeda = new Moeda();
            jtf_valor.setText(moeda.setPrecoFormat(jtf_valor.getText()));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valorFocusLost

    private void jtf_relocacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_relocacaoFocusLost
        if (jtf_relocacao.getText().equals("")) {
            jtf_relocacao.setText("R$ 0,00");
        } else {
            moeda = new Moeda();
            jtf_relocacao.setText(moeda.setPrecoFormat(jtf_relocacao.getText()));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_relocacaoFocusLost

    private void jb_salvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_salvarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_salvar.doClick();
        }
        acionarAtalho(evt);

        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarKeyPressed

    private void jtbl_promocao_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_promocao_locacaoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jcb_domingo.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getDomingo());
            jcb_segunda.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getSegunda());
            jcb_terca.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getTerca());
            jcb_quarta.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getQuarta());
            jcb_quinta.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getQuinta());
            jcb_sexta.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getSexta());
            jcb_sabado.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getSabado());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_promocao_locacaoKeyPressed

    private void jtbl_promocao_locacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_promocao_locacaoMouseClicked
        jcb_domingo.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getDomingo());
        jcb_segunda.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getSegunda());
        jcb_terca.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getTerca());
        jcb_quarta.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getQuarta());
        jcb_quinta.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getQuinta());
        jcb_sexta.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getSexta());
        jcb_sabado.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getSabado());
        if (evt.getClickCount() > 1) {
            alteraPromocaoLocacao();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_promocao_locacaoMouseClicked

    private void jb_eliminar_promocao_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_eliminar_promocao_devolucaoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            excluirPromocaoDevolucao();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_eliminar_promocao_devolucaoKeyPressed

    private void jb_adicionar_promocao_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_adicionar_promocao_devolucaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            adicionarPromocaoDevolucao();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_promocao_devolucaoKeyPressed

    private void jtf_descricao_devolucaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_descricao_devolucaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_descricao_devolucaoFocusGained

    private void jtf_descricao_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_descricao_devolucaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_horario_locacao.requestFocus();
            jtf_horario_locacao.select(0, 0);
        }
        acionarAtalho(evt);

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_descricao_devolucaoKeyPressed

    private void jtbl_promocao_devolucaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_promocao_devolucaoMouseClicked
        if (evt.getClickCount() > 1) {
            alteraPromocaoDevolucao();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_promocao_devolucaoMouseClicked

    private void jtbl_promocao_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_promocao_devolucaoKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_promocao_devolucaoKeyPressed

    private void jtf_valor_promocao_devolucaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_promocao_devolucaoFocusGained
        jtf_valor_promocao_devolucao.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocao_devolucaoFocusGained

    private void jtf_valor_promocao_devolucaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_valor_promocao_devolucaoFocusLost
        if (jtf_valor_promocao_devolucao.getText().equals("")) {
            jtf_valor_promocao_devolucao.setText("R$ 0,00");
        } else {
            moeda = new Moeda();
            jtf_valor_promocao_devolucao.setText(moeda.setPrecoFormat(jtf_valor_promocao_devolucao.getText()));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocao_devolucaoFocusLost

    private void jtf_valor_promocao_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_promocao_devolucaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_adicionar_promocao_devolucao.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocao_devolucaoKeyPressed

    private void jtf_horas_antecipadaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_horas_antecipadaFocusLost
        jtf_horas_antecipada.setText(validarHora(jtf_horas_antecipada.getText()));
    }//GEN-LAST:event_jtf_horas_antecipadaFocusLost

    private void jtf_horas_antecipadaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_horas_antecipadaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_valor_promocao_devolucao.requestFocus();
        }
        acionarAtalho(evt);

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_horas_antecipadaKeyPressed

    private void jtf_horario_locacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_horario_locacaoFocusLost
        jtf_horario_locacao.setText(validarHora(jtf_horario_locacao.getText()));
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_horario_locacaoFocusLost

    private void jtf_horario_locacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_horario_locacaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_horario_devolucao.requestFocus();
            jtf_horario_devolucao.select(0, 0);
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_horario_locacaoKeyPressed

    private void jtf_horario_devolucaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_horario_devolucaoFocusLost
        jtf_horario_devolucao.setText(validarHora(jtf_horario_devolucao.getText()));
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_horario_devolucaoFocusLost

    private void jtf_horario_devolucaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_horario_devolucaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_horas_antecipada.requestFocus();
            jtf_horas_antecipada.select(0, 0);
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_horario_devolucaoKeyPressed

    private void jtf_horario_locacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_horario_locacaoKeyTyped

// TODO add your handling code here:
    }//GEN-LAST:event_jtf_horario_locacaoKeyTyped

    private void jtf_valor_promocao_devolucaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_valor_promocao_devolucaoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocao_devolucaoKeyReleased

    private void jtf_descricao_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_descricao_locacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_descricao_locacaoActionPerformed

    private void jb_adicionar_promocao_devolucaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_adicionar_promocao_devolucaoMouseClicked
        if (evt.getClickCount() == 1) {
            adicionarPromocaoDevolucao();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_promocao_devolucaoMouseClicked

    private void jb_eliminar_promocao_devolucaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_eliminar_promocao_devolucaoMouseClicked
        if (evt.getClickCount() == 1) {
            excluirPromocaoDevolucao();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_eliminar_promocao_devolucaoMouseClicked

    private void jb_adicionar_promocao_locacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_adicionar_promocao_locacaoMouseClicked
        if (evt.getClickCount() == 1) {
            adicionarPromocaoLocacao();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_promocao_locacaoMouseClicked

    private void jb_eliminar_promocao_locacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_eliminar_promocao_locacaoMouseClicked
        if (evt.getClickCount() == 1) {
            excluirPromocaoLocacao();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_eliminar_promocao_locacaoMouseClicked

    private void jtf_nome_diariaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_diariaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_valor.requestFocus();
        }
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nome_diariaKeyPressed

    private void jtf_diasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_diasKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_dias_maximo.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_diasKeyPressed

    private void jtf_dias_maximoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_dias_maximoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_salvar.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_dias_maximoKeyPressed

    private void jtf_locar_quantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_locar_quantidadeKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_ganhar_quantidade.requestFocus();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jtf_locar_quantidadeKeyPressed

    private void jtf_ganhar_quantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_ganhar_quantidadeKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_ordem.requestFocus();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jtf_ganhar_quantidadeKeyPressed

    private void jtf_ordemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_ordemKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_adicionar_promocao_locacao.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_ordemKeyPressed

    private void jb_adicionar_promocao_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_adicionar_promocao_locacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_promocao_locacaoActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void jb_cancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_cancelarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            retornaJanelaPai();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_cancelarKeyPressed

    private void jb_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_cancelarMouseClicked
        if (evt.getClickCount() == 1) {
            retornaJanelaPai();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_cancelarMouseClicked

    private void jrb_ativo_locacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_ativo_locacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_ativo_locacaoActionPerformed

    private void jrb_ativo_devolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_ativo_devolucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_ativo_devolucaoActionPerformed

    private void jtf_valor_promocao_devolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_valor_promocao_devolucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valor_promocao_devolucaoActionPerformed

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        cadastrarAlterarDiaria();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CadastraAlteraDiaria().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jb_adicionar_promocao_devolucao;
    private javax.swing.JButton jb_adicionar_promocao_locacao;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_eliminar_promocao_devolucao;
    private javax.swing.JButton jb_eliminar_promocao_locacao;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JCheckBox jcb_a_vista_devolucao;
    private javax.swing.JCheckBox jcb_a_vista_locacao;
    public static javax.swing.JCheckBox jcb_acumulativo;
    public static javax.swing.JCheckBox jcb_domingo;
    public static javax.swing.JCheckBox jcb_quarta;
    public static javax.swing.JCheckBox jcb_quinta;
    public static javax.swing.JCheckBox jcb_sabado;
    public static javax.swing.JCheckBox jcb_segunda;
    public static javax.swing.JCheckBox jcb_sexta;
    public static javax.swing.JCheckBox jcb_terca;
    public static javax.swing.JRadioButton jrb_ativo_devolucao;
    public static javax.swing.JRadioButton jrb_ativo_locacao;
    public static javax.swing.JRadioButton jrb_inativo_devolucao;
    public static javax.swing.JRadioButton jrb_inativo_locacao;
    private javax.swing.JTable jtbl_promocao_devolucao;
    private javax.swing.JTable jtbl_promocao_locacao;
    public static javax.swing.JTextField jtf_codigo_diaria;
    public static javax.swing.JTextField jtf_descricao_devolucao;
    public static javax.swing.JTextField jtf_descricao_locacao;
    private javax.swing.JFormattedTextField jtf_dias;
    private javax.swing.JFormattedTextField jtf_dias_maximo;
    private javax.swing.JFormattedTextField jtf_ganhar_quantidade;
    public static javax.swing.JFormattedTextField jtf_horario_devolucao;
    public static javax.swing.JFormattedTextField jtf_horario_locacao;
    public static javax.swing.JFormattedTextField jtf_horas_antecipada;
    private javax.swing.JFormattedTextField jtf_locar_quantidade;
    private javax.swing.JTextField jtf_nome_diaria;
    private javax.swing.JFormattedTextField jtf_ordem;
    public static javax.swing.JTextField jtf_relocacao;
    public static javax.swing.JTextField jtf_valor;
    public static javax.swing.JTextField jtf_valor_promocao_devolucao;
    public static javax.swing.JTextField jtf_valor_promocao_locacao;
    // End of variables declaration//GEN-END:variables

    private void retornaJanelaPai() {
        setVisible(false);
        if (janelapai != null) {
            janelapai.setStatusTela(true);
            janelapai.buscarDados();
            janelapai.cadastraAlteraDiaria = null;
        }
        if (janelapai2 != null) {
            janelapai2.setStatusTela(true);
            janelapai2.listaDiaria();
            
        }
    }

    InterfacePool pool;
    SiscomController controller;

    public boolean verificarCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_nome_diaria.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Descrição\n";
        }
        if (jtf_valor.getText().trim().equals("") || jtf_valor.getText().trim().equals("R$ 0,00")) {
            msgERRO = msgERRO + " *Valor Locação\n";
        }
        if (jtf_relocacao.getText().trim().equals("") || jtf_relocacao.getText().trim().equals("R$ 0,00")) {
            msgERRO = msgERRO + " *Valor Relocação\n";
        }
        if (jtf_dias.getText().trim().equals("") || Integer.parseInt(jtf_dias.getText()) < 0) {
            msgERRO = msgERRO + " *Mínimo dias\n";
        }
        if (jtf_dias_maximo.getText().trim().equals("") || Integer.parseInt(jtf_dias_maximo.getText()) < 0) {
            msgERRO = msgERRO + " *Máximo dias\n";
        }
        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);

            jtf_nome_diaria.requestFocus();
            return false;
        } else {
            return true;
        }

    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            jb_salvar.doClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            retornaJanelaPai();
        }
    }

    public boolean verificarCamposPromocaoLocacao() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_descricao_locacao.getText().equals("")) {
            msgERRO = msgERRO + " *Descrição Promoção\n";
        }
        if (jtf_valor_promocao_locacao.getText().equals("") ) {
            msgERRO = msgERRO + " *Valor Promoção\n";
        }
        if (jtf_locar_quantidade.getText().equals("") || Integer.parseInt(jtf_locar_quantidade.getText()) < 0) {
            msgERRO = msgERRO + " *Locar Quantidade\n";
        }
        if (jtf_ganhar_quantidade.getText().equals("") || Integer.parseInt(jtf_ganhar_quantidade.getText()) < 0) {
            msgERRO = msgERRO + " *Ganhar Quantidade\n";
        }
        if (jtf_ordem.getText().equals("")) {
            msgERRO = msgERRO + " *Ordem\n";
        }
        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jtf_descricao_locacao.requestFocus();
            return false;
        } else {
            return true;
        }

    }

    public boolean verificarCamposPromocaoDevolucao() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_descricao_devolucao.getText().equals("")) {
            msgERRO = msgERRO + " *Descrição Promoção Devolução\n";
        }
        if (jtf_valor_promocao_devolucao.getText().equals("") || jtf_valor_promocao_devolucao.getText().equals("R$ 0,00")) {
            msgERRO = msgERRO + " *Valor Promoção Devolução\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jtf_descricao_devolucao.requestFocus();
            return false;
        } else {
            return true;
        }

    }

    public void adicionarPromocaoLocacao() {

        if (jtf_codigo_diaria.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Salvar primeiro a Diária");
        } else {
            if (verificarCamposPromocaoLocacao() == true) {
                diaria = new Diaria();
                diaria.setCodigo_diaria(Integer.parseInt(jtf_codigo_diaria.getText()));

                moeda = new Moeda();

                promocaoLocacao = new PromocaoLocacao();
                promocaoLocacao.setDiaria(diaria);
                promocaoLocacao.setDescricao(jtf_descricao_locacao.getText());
                promocaoLocacao.setValor_promocao_locacao(moeda.getPrecoFormato(jtf_valor_promocao_locacao.getText()));
                promocaoLocacao.setOrderm(Integer.parseInt(jtf_ordem.getText()));
                promocaoLocacao.setPagamento_a_vista(jcb_a_vista_locacao.isSelected());
                promocaoLocacao.setDomingo(jcb_domingo.isSelected());
                promocaoLocacao.setSegunda(jcb_segunda.isSelected());
                promocaoLocacao.setTerca(jcb_terca.isSelected());
                promocaoLocacao.setQuarta(jcb_quarta.isSelected());
                promocaoLocacao.setQuinta(jcb_quinta.isSelected());
                promocaoLocacao.setSexta(jcb_sexta.isSelected());
                promocaoLocacao.setSabado(jcb_sabado.isSelected());
                promocaoLocacao.setLocar_quantidade(Integer.parseInt(jtf_locar_quantidade.getText()));
                promocaoLocacao.setGanhar_quantidade(Integer.parseInt(jtf_ganhar_quantidade.getText()));
                if (jrb_ativo_locacao.isSelected() == true) {
                    promocaoLocacao.setStatus(true);
                } else if (jrb_inativo_locacao.isSelected() == true) {
                    promocaoLocacao.setStatus(false);
                }

                if (actionLocacao.equals("salvar")) {
                    diaria.setPromocaoLocacao(promocaoLocacao);
                    pool = new Pool();
                    DiariaDAO diariaDAO = new DiariaDAO(pool);
                    diaria = diariaDAO.salvarPromocaoLocacao(diaria);
                    diaria.setCodigo_diaria(Integer.parseInt(jtf_codigo_diaria.getText()));
                    carregarPromocoesLocacao(diaria);
                } else if (actionLocacao.equals("alterar")) {
                    promocaoLocacao.setCodigo_promocao_locacao(promocaoLocacaoAlterar.getPromocaoLocacao().getCodigo_promocao_locacao());
                    diaria.setPromocaoLocacao(promocaoLocacao);
                    pool = new Pool();
                    DiariaDAO diariaDAO = new DiariaDAO(pool);
                    diaria = diariaDAO.atualizarPromocaoLocacao(diaria);
                    diaria.setCodigo_diaria(Integer.parseInt(jtf_codigo_diaria.getText()));
                    carregarPromocoesLocacao(diaria);

                    jb_adicionar_promocao_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/adicionar_item.png"))); // NOI18N                        
                    jb_eliminar_promocao_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/remove_item.png"))); // NOI18N
                    actionLocacao = "salvar";
                }

//                itensPromocaoLocacao.add(diaria);
                limparPromocaoLocacao();

            }
        }
    }

    public void adicionarPromocaoDevolucao() {

        if (jtf_codigo_diaria.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Salvar primeiro a Diária");
        } else {
            if (verificarCamposPromocaoDevolucao() == true) {
                diaria = new Diaria();
                diaria.setCodigo_diaria(Integer.parseInt(jtf_codigo_diaria.getText()));

                moeda = new Moeda();

                promocaoDevolucao = new PromocaoDevolucao();
                promocaoDevolucao.setDiaria(diaria);
                promocaoDevolucao.setDescricao(jtf_descricao_devolucao.getText());
                promocaoDevolucao.setValor_promocao_devolucao(moeda.getPrecoFormato(jtf_valor_promocao_devolucao.getText()));
                if (jcb_a_vista_devolucao.isSelected() == true) {
                    promocaoDevolucao.setPagamento_a_vista(true);
                } else {
                    promocaoDevolucao.setPagamento_a_vista(false);
                }

                promocaoDevolucao.setHorario_locacao(jtf_horario_locacao.getText());
                promocaoDevolucao.setHorario_devolucao(jtf_horario_devolucao.getText());
                promocaoDevolucao.setHora_antecipada(jtf_horas_antecipada.getText());
                promocaoDevolucao.setStatus(jrb_ativo_devolucao.isSelected());
                if (jrb_ativo_devolucao.isSelected() == true) {
                    promocaoDevolucao.setStatus(true);
                } else if (jrb_inativo_devolucao.isSelected() == true) {
                    promocaoDevolucao.setStatus(false);
                }

                if (actionDevolucao.equals("salvar")) {
                    diaria.setPromocaoDevolucao(promocaoDevolucao);
                    pool = new Pool();
                    DiariaDAO diariaDAO = new DiariaDAO(pool);
                    diaria = diariaDAO.salvarPromocaoDevolucao(diaria);
                    diaria.setCodigo_diaria(Integer.parseInt(jtf_codigo_diaria.getText()));
                    carregarPromocoesDevolucao(diaria);
                } else if (actionDevolucao.equals("alterar")) {
                    promocaoDevolucao.setCodigo_promocao_devolucao(promocaoDevolucaoAlterar.getPromocaoDevolucao().getCodigo_promocao_devolucao());
                    diaria.setPromocaoDevolucao(promocaoDevolucao);
                    pool = new Pool();
                    DiariaDAO diariaDAO = new DiariaDAO(pool);
                    diaria = diariaDAO.atualizaPromocaoDevolucao(diaria);
                    diaria.setCodigo_diaria(Integer.parseInt(jtf_codigo_diaria.getText()));
                    carregarPromocoesDevolucao(diaria);

                    jb_adicionar_promocao_devolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/adicionar_item.png"))); // NOI18N                        
                    jb_eliminar_promocao_devolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/remove_item.png"))); // NOI18N
                    actionDevolucao = "salvar";
                }

                limparPromocaoDevolucao();

            }
        }
    }

    private void limparPromocaoLocacao() {
        jtf_descricao_locacao.setText("");
        jtf_valor_promocao_locacao.setText("R$ 0,00");
        jtf_locar_quantidade.setText("");
        jtf_ganhar_quantidade.setText("");
        jtf_ordem.setText("");
        jtf_descricao_locacao.requestFocus();

    }

    private void limparPromocaoDevolucao() {
        jtf_descricao_devolucao.setText("");
        jtf_valor_promocao_devolucao.setText("R$ 0,00");
        jtf_horario_locacao.setText("00:00:00");
        jtf_horario_devolucao.setText("00:00:00");
        jtf_horas_antecipada.setText("00:00:00  ");
        jtf_descricao_devolucao.requestFocus();
    }

    private void excluirPromocaoLocacao() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        AcessoUsuario acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuDiaria");

        try {

            if (acesso.getDeletar() == true) {
                DefaultTableModel row = (DefaultTableModel) jtbl_promocao_locacao.getModel();
                if (jtbl_promocao_locacao.getSelectedRow() != -1) {
                    int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_NO_OPTION) {
                        pool = new Pool();
                        DiariaDAO diariaDAO = new DiariaDAO(pool);
                        promocaoLocacao = new PromocaoLocacao();
                        promocaoLocacao.setCodigo_promocao_locacao(Integer.parseInt((String) jtbl_promocao_locacao.getValueAt(jtbl_promocao_locacao.getSelectedRow(), 0).toString()));

                        try {
                            diariaDAO.excluirPromocaoLocacao(promocaoLocacao.getCodigo_promocao_locacao());
                            row.removeRow(jtbl_promocao_locacao.getSelectedRow());
                            carregarPromocoesLocacao(diaria);
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma diária");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
    }

    private void excluirPromocaoDevolucao() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        AcessoUsuario acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuDiaria");

        try {

            if (acesso.getDeletar() == true) {
                DefaultTableModel row = (DefaultTableModel) jtbl_promocao_devolucao.getModel();
                if (jtbl_promocao_devolucao.getSelectedRow() != -1) {
                    int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_NO_OPTION) {
                        pool = new Pool();
                        DiariaDAO diariaDAO = new DiariaDAO(pool);
                        promocaoDevolucao = new PromocaoDevolucao();
                        promocaoDevolucao.setCodigo_promocao_devolucao(Integer.parseInt((String) jtbl_promocao_devolucao.getValueAt(jtbl_promocao_devolucao.getSelectedRow(), 0).toString()));

                        try {
                            diariaDAO.excluirPromocaoDevolucao(promocaoDevolucao.getCodigo_promocao_devolucao());
                            row.removeRow(jtbl_promocao_devolucao.getSelectedRow());
                            carregarPromocoesLocacao(diaria);
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma diária");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
    }

    public void carregarPromocoesDevolucao(Diaria diaria) {
        DefaultTableModel tableModel = (DefaultTableModel) jtbl_promocao_devolucao.getModel();
        tableModel.setNumRows(0);

        pool = new Pool();
        DiariaDAO diariaDAO = new DiariaDAO(pool);

        itensPromocaoDevolucao = null;
        itensPromocaoDevolucao = diariaDAO.getDiariaPromocaoDevolucao(diaria);

        for (int i = 0; i < itensPromocaoDevolucao.size(); i++) {
            DefaultTableModel row = (DefaultTableModel) jtbl_promocao_devolucao.getModel();
            ItemDbGrid hashDbGrid = new ItemDbGrid(itensPromocaoDevolucao.get(i), itensPromocaoDevolucao.get(i).getPromocaoDevolucao().getDescricao());
            row.addRow(new Object[]{hashDbGrid,
                itensPromocaoDevolucao.get(i).getPromocaoDevolucao().getHorario_locacao(), itensPromocaoDevolucao.get(i).getPromocaoDevolucao().getHorario_devolucao(),
                itensPromocaoDevolucao.get(i).getPromocaoDevolucao().getHora_antecipada(),
                moeda.setPrecoFormat(String.valueOf(itensPromocaoDevolucao.get(i).getPromocaoDevolucao().getValor_promocao_devolucao())),
                itensPromocaoDevolucao.get(i).getPromocaoDevolucao().getPagamento_a_vista(), itensPromocaoDevolucao.get(i).getPromocaoDevolucao().getStatus()});
        }

    }

    public void carregarPromocoesLocacao(Diaria diaria) {
        DefaultTableModel tableModel = (DefaultTableModel) jtbl_promocao_locacao.getModel();
        tableModel.setNumRows(0);

        pool = new Pool();
        DiariaDAO diariaDAO = new DiariaDAO(pool);

        itensPromocaoLocacao = null;
        itensPromocaoLocacao = diariaDAO.getDiariaPromocao(diaria);

        for (int i = 0; i < itensPromocaoLocacao.size(); i++) {
            DefaultTableModel row = (DefaultTableModel) jtbl_promocao_locacao.getModel();
            ItemDbGrid hashDbGrid = new ItemDbGrid(itensPromocaoLocacao.get(i), itensPromocaoLocacao.get(i).getPromocaoLocacao().getDescricao());
            row.addRow(new Object[]{hashDbGrid,
                itensPromocaoLocacao.get(i).getPromocaoLocacao().getLocar_quantidade(),
                itensPromocaoLocacao.get(i).getPromocaoLocacao().getGanhar_quantidade(),
                moeda.setPrecoFormat(String.valueOf(itensPromocaoLocacao.get(i).getPromocaoLocacao().getValor_promocao_locacao())),
                itensPromocaoLocacao.get(i).getPromocaoLocacao().getPagamento_a_vista(),
                itensPromocaoLocacao.get(i).getPromocaoLocacao().getOrderm(),
                itensPromocaoLocacao.get(i).getPromocaoLocacao().getStatus()});
        }

    }

    public String validarHora(String str) {
        String hora = null;
        String minuto = null;
        String segundos = null;

        try {
            System.out.println("Minutos antes: " + str.substring(2));
            if (Integer.valueOf(str.substring(0, 2)) > 23) {
                hora = "23" + str.substring(2);
            } else {
                hora = str;
            }

            System.out.println("Horas: " + hora);
            System.out.println("Minutos: " + hora.substring(3, 5));
            System.out.println("Segundo: " + hora.substring(6, 8));

            if (Integer.valueOf(hora.substring(3, 5)) > 59) {
                minuto = hora.substring(0, 2) + ":59:" + hora.substring(6, 8);
            } else {
                minuto = hora;
            }
            System.out.println("Minutos depois: " + minuto);
            if (Integer.valueOf(minuto.substring(6, 8)) > 59) {
                segundos = minuto.substring(0, 2) + ":59:" + "59";
            } else {
                segundos = hora;
            }

            System.out.println("Horário final: " + segundos);
        } catch (Exception ex) {
            segundos = "00:00:00";
        }
        return segundos;
    }

    public void cadastrarAlterarDiaria() {

        try {
            if (verificarCampos() == true) {
                moeda = new Moeda();
                pool = new Pool();
                diariaDAO = new DiariaDAO(pool);
                diaria = new Diaria();
                diaria.setNome_diaria(jtf_nome_diaria.getText());
                diaria.setValor(moeda.getPrecoFormato((String) jtf_valor.getText()));                
                diaria.setMultas(moeda.getPrecoFormato((String) jtf_relocacao.getText()));
                diaria.setDias(Integer.parseInt((String) jtf_dias.getText()));
                diaria.setMaximo_dias(Integer.parseInt((String) jtf_dias_maximo.getText()));
                diaria.setAcumulativo(jcb_acumulativo.isSelected());

                if (jtf_codigo_diaria.getText().equals("")) {
                    LogInfo logInfo = new LogInfo();
                    logInfo.setDescricao("Nova Diária: "+jtf_nome_diaria.getText());
                    logInfo.setUsuario(acesso.getUsuario());
                    pool = new Pool();
                    LogInfoDAO logInfoDAO = new LogInfoDAO(pool);
                    logInfoDAO.salvar(logInfo);

                    
                    diaria = diariaDAO.salvar(diaria);
                    jtf_codigo_diaria.setText(diaria.getCodigo_diaria().toString());

                    JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
                    jtf_descricao_locacao.requestFocus();
                } else {
                    LogInfo logInfo = new LogInfo();
                    logInfo.setDescricao("Alterar Diária -> "+diaria.getNome_diaria()+ " -> " + jtf_nome_diaria.getText());
                    logInfo.setUsuario(acesso.getUsuario());
                    pool = new Pool();
                    LogInfoDAO logInfoDAO = new LogInfoDAO(pool);
                    logInfoDAO.salvar(logInfo);
                    
                    diaria.setCodigo_diaria(Integer.parseInt(jtf_codigo_diaria.getText()));
                    diariaDAO.atualizar(diaria);
                    jtf_codigo_diaria.setText(diaria.getCodigo_diaria().toString());

                    JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
                    jtf_descricao_locacao.requestFocus();
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Problemas com a gravação: ");

            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido: " + e.getMessage());

            e.printStackTrace();
        }
    }

    public void alteraPromocaoLocacao() {
        if (jtbl_promocao_locacao.getRowCount() != -1) {
            promocaoLocacaoAlterar = itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow());
            jtf_descricao_locacao.setText(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getDescricao());
            jtf_valor_promocao_locacao.setText(moeda.setPrecoFormat(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getValor_promocao_locacao().toString()));
            jtf_locar_quantidade.setText(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getLocar_quantidade().toString());
            jtf_ganhar_quantidade.setText(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getGanhar_quantidade().toString());
            jtf_ordem.setText(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getOrderm().toString());

            if(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getStatus() == true){
                jrb_ativo_locacao.setSelected(true);
            } else {
                jrb_inativo_locacao.setSelected(true);
            }
            
            jcb_a_vista_locacao.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getPagamento_a_vista());

            jcb_domingo.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getDomingo());
            jcb_segunda.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getSegunda());
            jcb_terca.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getTerca());
            jcb_quarta.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getQuarta());
            jcb_quinta.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getQuinta());
            jcb_sexta.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getSexta());
            jcb_sabado.setSelected(itensPromocaoLocacao.get(jtbl_promocao_locacao.getSelectedRow()).getPromocaoLocacao().getSabado());

            jb_adicionar_promocao_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/alterar_registro.png"))); // NOI18N
            jb_eliminar_promocao_locacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/sair.png"))); // NOI18N
            actionLocacao = "alterar";

            jtf_descricao_locacao.requestFocus();
        }
    }

    public void alteraPromocaoDevolucao() {
        if (jtbl_promocao_devolucao.getRowCount() != -1) {
            promocaoDevolucaoAlterar = itensPromocaoDevolucao.get(jtbl_promocao_devolucao.getSelectedRow());
            jtf_descricao_devolucao.setText(itensPromocaoDevolucao.get(jtbl_promocao_devolucao.getSelectedRow()).getPromocaoDevolucao().getDescricao());
            jtf_horario_locacao.setText(itensPromocaoDevolucao.get(jtbl_promocao_devolucao.getSelectedRow()).getPromocaoDevolucao().getHorario_locacao());
            jtf_horario_devolucao.setText(itensPromocaoDevolucao.get(jtbl_promocao_devolucao.getSelectedRow()).getPromocaoDevolucao().getHorario_devolucao());
            jtf_horas_antecipada.setText(itensPromocaoDevolucao.get(jtbl_promocao_devolucao.getSelectedRow()).getPromocaoDevolucao().getHora_antecipada());
            jtf_valor_promocao_devolucao.setText(moeda.setPrecoFormat(itensPromocaoDevolucao.get(jtbl_promocao_devolucao.getSelectedRow()).getPromocaoDevolucao().getValor_promocao_devolucao().toString()));

            if(itensPromocaoDevolucao.get(jtbl_promocao_devolucao.getSelectedRow()).getPromocaoDevolucao().getStatus() == true){
                jrb_ativo_devolucao.setSelected(true);
            } else {
                jrb_inativo_devolucao.setSelected(true);
            }
            
            jcb_a_vista_locacao.setSelected(itensPromocaoDevolucao.get(jtbl_promocao_devolucao.getSelectedRow()).getPromocaoDevolucao().getPagamento_a_vista());

            jb_adicionar_promocao_devolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/alterar_registro.png"))); // NOI18N
            jb_eliminar_promocao_devolucao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/sair.png"))); // NOI18N
            actionDevolucao = "alterar";

            jtf_descricao_devolucao.requestFocus();
        }
    }
}
