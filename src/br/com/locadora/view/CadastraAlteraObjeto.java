package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.controller.SiscomController;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Copia;
import br.com.locadora.model.bean.Diaria;
import br.com.locadora.model.bean.Genero;
import br.com.locadora.model.bean.LogInfo;
import br.com.locadora.model.bean.Objeto;
import br.com.locadora.model.bean.Telefone;
import br.com.locadora.model.dao.CopiaDAO;
import br.com.locadora.model.dao.LogInfoDAO;
import br.com.locadora.model.dao.ObjetoDAO;
import br.com.locadora.model.dao.UsuarioDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.Data;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.LimitadorTexto;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
import static br.com.locadora.view.CadastraAlteraGenero.jtf_nome_genero;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author ALENCAR
 */
public final class CadastraAlteraObjeto extends javax.swing.JFrame {

//    public List<Produto> produtos;
    public MenuObjeto janelapai;
    public static Diaria diaria;
    public static Genero genero;
    public AcessoUsuario acesso;
    public Copia copia;
    public Objeto objeto;
    public Copia copiaAlterar;
    public MaskFormatter formatoData, formatoCPF, formatoTelefone, formatoNumero;
    public Moeda moeda;
    public ObjetoDAO objetoDAO;
    public InterfacePool pool;
    public List<Copia> copias;
    public List<Objeto> objetos;
    public ConsultaGeneroObjeto consultaGenero;
    public ConsultaDiaria consultaDiaria;
    public String action;
    public ConsultaCopiaLocacao consultaCopiaLocacao;

    /**
     * Creates new form ProdutoCadastroGUI
     */
    public CadastraAlteraObjeto() {
        initComponents();
        TemaInterface.getInterface(this);
        this.setTitle("Cadastrando Objeto");
        janelapai = null;
        consultaCopiaLocacao = null;
        action = "salvar";
    }

    public CadastraAlteraObjeto(Objeto objeto) {
        initComponents();
        if (objeto != null) {
            TemaInterface.getInterface(this);
            this.setTitle("Alterando Objeto");
            janelapai = null;
            consultaCopiaLocacao = null;
            
            jtf_codigo_objeto.setText(String.valueOf(objeto.getCodigo_objeto()));
            jtf_titulo.setText(objeto.getTitulo());
            jcb_tipo.setSelectedItem(objeto.getTipo_movimento());
            jtf_titulo_original.setText(objeto.getTitulo_original());
            jcb_producao.setSelectedItem(objeto.getProducao());
            jtf_duracao.setText(objeto.getDuracao());
            jcb_tipo_midia.setSelectedItem(objeto.getTipo_midia());
            jtf_censura.setText(String.valueOf(objeto.getCensura()));
            jta_elenco.setText(objeto.getElenco());
            jta_sinopse.setText(objeto.getSinopse());
            jta_diretor.setText(objeto.getDiretor());

            carregaGenero(objeto.getGenero());
            carregaCopia(objeto.getCodigo_objeto());
            action = "salvar";
        }
    }
    
    public CadastraAlteraObjeto(Integer codigo_objeto) {
        initComponents();
        
        pool = new Pool();
        objetoDAO = new ObjetoDAO(pool);
        objetos = objetoDAO.getObjeto_codigo(codigo_objeto);        
        this.objeto = objetos.get(0);
        
        TemaInterface.getInterface(this);
        this.setTitle("Alterando Objeto");
        janelapai = null;
        consultaCopiaLocacao = null;
        
        jtf_codigo_objeto.setText(String.valueOf(objeto.getCodigo_objeto()));
        jtf_titulo.setText(objeto.getTitulo());
        jcb_tipo.setSelectedItem(objeto.getTipo_movimento());
        jtf_titulo_original.setText(objeto.getTitulo_original());
        jcb_producao.setSelectedItem(objeto.getProducao());
        jtf_duracao.setText(objeto.getDuracao());
        jcb_tipo_midia.setSelectedItem(objeto.getTipo_midia());
        jtf_censura.setText(String.valueOf(objeto.getCensura()));
        jta_elenco.setText(objeto.getElenco());
        jta_sinopse.setText(objeto.getSinopse());
        jta_diretor.setText(objeto.getDiretor());

        carregaGenero(objeto.getGenero());
        carregaCopia(objeto.getCodigo_objeto());
        action = "salvar";
    }

    //public ProdutoConsultarGUI janelapaim;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tfa_similar = new javax.swing.JTextArea();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jb_cancelar = new javax.swing.JButton();
        jtp_menu = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jtf_codigo_objeto = new javax.swing.JTextField();
        jtf_titulo_original = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jtf_titulo = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jtf_duracao = new javax.swing.JTextField(new LimitadorTexto(45), "",10);
        jLabel15 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jb_genero = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jcb_producao = new javax.swing.JComboBox();
        jrb_ativo = new javax.swing.JRadioButton();
        jrb_inativo = new javax.swing.JRadioButton();
        jcb_tipo_midia = new javax.swing.JComboBox();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jcb_tipo = new javax.swing.JComboBox();
        jtf_descricao_genero = new javax.swing.JTextField();
        jtf_censura = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jta_elenco = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jta_sinopse = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jta_diretor = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jb_adicionar_copia = new javax.swing.JButton();
        jb_eliminar_copia = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtbl_copia = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jcb_idioma = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        jcb_legenda = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        jtf_preco_custo = new javax.swing.JTextField(new LimitadorTexto(10), "",10);
        jLabel31 = new javax.swing.JLabel();
        try  {
            formatoData = new MaskFormatter("##/##/####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_data_aquisicao = new JFormattedTextField(formatoData);
        jLabel36 = new javax.swing.JLabel();
        jcb_midia = new javax.swing.JComboBox();
        jLabel41 = new javax.swing.JLabel();
        jtf_descricao_diaria = new javax.swing.JTextField();
        jb_diaria = new javax.swing.JButton();
        jtf_diaria_dias = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jtf_valor = new javax.swing.JTextField();
        jrb_ativo_copia = new javax.swing.JRadioButton();
        jrb_inativo_copia = new javax.swing.JRadioButton();
        jb_salvar = new javax.swing.JButton();

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tfa_similar.setColumns(20);
        tfa_similar.setRows(5);
        tfa_similar.setName("tfa_similar"); // NOI18N
        jScrollPane1.setViewportView(tfa_similar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrando Objeto");
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

        jtp_menu.setName("jtp_menu"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel1.setName("jPanel1"); // NOI18N

        jtf_codigo_objeto.setEditable(false);
        jtf_codigo_objeto.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_codigo_objeto.setName("jtf_codigo_objeto"); // NOI18N
        jtf_codigo_objeto.setPreferredSize(new java.awt.Dimension(100, 24));

        jtf_titulo_original.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_titulo_original.setName("jtf_titulo_original"); // NOI18N
        jtf_titulo_original.setPreferredSize(new java.awt.Dimension(350, 24));
        jtf_titulo_original.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_titulo_originalActionPerformed(evt);
            }
        });
        jtf_titulo_original.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_titulo_originalFocusGained(evt);
            }
        });
        jtf_titulo_original.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_titulo_originalKeyPressed(evt);
            }
        });

        jtf_titulo.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_titulo.setName("jtf_titulo"); // NOI18N
        jtf_titulo.setPreferredSize(new java.awt.Dimension(350, 24));
        jtf_titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_tituloActionPerformed(evt);
            }
        });
        jtf_titulo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_tituloFocusGained(evt);
            }
        });
        jtf_titulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_tituloKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_tituloKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel1.setText("Código Objeto");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel3.setText("Título*");
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel10.setText("Título Original *");
        jLabel10.setName("jLabel10"); // NOI18N

        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel14.setText("Duração*");
        jLabel14.setName("jLabel14"); // NOI18N

        jtf_duracao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_duracao.setName("jtf_duracao"); // NOI18N
        jtf_duracao.setPreferredSize(new java.awt.Dimension(14, 24));
        jtf_duracao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_duracaoKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel15.setText("Censura*");
        jLabel15.setName("jLabel15"); // NOI18N

        jLabel23.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel23.setText("Gênero");
        jLabel23.setName("jLabel23"); // NOI18N

        jb_genero.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_genero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jb_genero.setName("jb_genero"); // NOI18N
        jb_genero.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_genero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_generoActionPerformed(evt);
            }
        });
        jb_genero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_generoKeyPressed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel24.setText("Produção");
        jLabel24.setName("jLabel24"); // NOI18N

        jcb_producao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_producao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Americana", "Espanhola", "Francesa", "Italiana", "Japonesa", "Nacional" }));
        jcb_producao.setName("jcb_producao"); // NOI18N
        jcb_producao.setPreferredSize(new java.awt.Dimension(14, 24));
        jcb_producao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcb_producaoKeyPressed(evt);
            }
        });

        buttonGroup1.add(jrb_ativo);
        jrb_ativo.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_ativo.setSelected(true);
        jrb_ativo.setText("Ativo");
        jrb_ativo.setName("jrb_ativo"); // NOI18N
        jrb_ativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_ativoActionPerformed(evt);
            }
        });
        jrb_ativo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jrb_ativoKeyPressed(evt);
            }
        });

        buttonGroup1.add(jrb_inativo);
        jrb_inativo.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_inativo.setText("Inativo");
        jrb_inativo.setName("jrb_inativo"); // NOI18N
        jrb_inativo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jrb_inativoKeyPressed(evt);
            }
        });

        jcb_tipo_midia.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_tipo_midia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Filme", "Seriado", "Game", "Livro" }));
        jcb_tipo_midia.setName("jcb_tipo_midia"); // NOI18N
        jcb_tipo_midia.setPreferredSize(new java.awt.Dimension(14, 24));
        jcb_tipo_midia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_tipo_midiaActionPerformed(evt);
            }
        });
        jcb_tipo_midia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcb_tipo_midiaKeyPressed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel38.setText("Tipo de Mídia");
        jLabel38.setName("jLabel38"); // NOI18N

        jLabel39.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel39.setText("Tipo*");
        jLabel39.setName("jLabel39"); // NOI18N

        jcb_tipo.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Locação", "Venda", " " }));
        jcb_tipo.setName("jcb_tipo"); // NOI18N
        jcb_tipo.setPreferredSize(new java.awt.Dimension(14, 24));
        jcb_tipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcb_tipoKeyPressed(evt);
            }
        });

        jtf_descricao_genero.setEditable(false);
        jtf_descricao_genero.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_descricao_genero.setName("jtf_descricao_genero"); // NOI18N
        jtf_descricao_genero.setPreferredSize(new java.awt.Dimension(14, 24));
        jtf_descricao_genero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_descricao_generoActionPerformed(evt);
            }
        });

        jtf_censura.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_censura.setName("jtf_censura"); // NOI18N
        jtf_censura.setPreferredSize(new java.awt.Dimension(14, 24));
        jtf_censura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_censuraKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel5.setText("Elenco");
        jLabel5.setName("jLabel5"); // NOI18N

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        jta_elenco.setColumns(20);
        jta_elenco.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jta_elenco.setLineWrap(true);
        jta_elenco.setRows(6);
        jta_elenco.setWrapStyleWord(true);
        jta_elenco.setName("jta_elenco"); // NOI18N
        jta_elenco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jta_elencoKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(jta_elenco);

        jScrollPane6.setName("jScrollPane6"); // NOI18N

        jta_sinopse.setColumns(20);
        jta_sinopse.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jta_sinopse.setLineWrap(true);
        jta_sinopse.setRows(5);
        jta_sinopse.setWrapStyleWord(true);
        jta_sinopse.setName("jta_sinopse"); // NOI18N
        jta_sinopse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jta_sinopseKeyPressed(evt);
            }
        });
        jScrollPane6.setViewportView(jta_sinopse);

        jLabel18.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel18.setText("Sinopse");
        jLabel18.setName("jLabel18"); // NOI18N

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel6.setText("Diretores");
        jLabel6.setName("jLabel6"); // NOI18N

        jScrollPane7.setName("jScrollPane7"); // NOI18N

        jta_diretor.setColumns(20);
        jta_diretor.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jta_diretor.setLineWrap(true);
        jta_diretor.setRows(2);
        jta_diretor.setWrapStyleWord(true);
        jta_diretor.setName("jta_diretor"); // NOI18N
        jta_diretor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jta_diretorKeyPressed(evt);
            }
        });
        jScrollPane7.setViewportView(jta_diretor);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jtf_codigo_objeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jtf_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(262, 262, 262))
                    .addComponent(jtf_titulo_original, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jrb_ativo)
                .addGap(0, 0, 0)
                .addComponent(jrb_inativo))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_duracao, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel15)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_censura, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jcb_producao, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jcb_tipo_midia, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtf_descricao_genero, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jb_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 29, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane6)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrb_ativo)
                    .addComponent(jrb_inativo))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_codigo_objeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_titulo_original, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel38))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jb_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtf_descricao_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcb_tipo_midia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcb_producao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(jLabel39))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel14)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_duracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtf_censura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jcb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addGap(24, 24, 24))))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel5)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jtf_codigo_objeto, jtf_titulo, jtf_titulo_original});

        jtp_menu.addTab("Cadastro", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel2.setToolTipText("");
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel2FocusGained(evt);
            }
        });

        jb_adicionar_copia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/adicionar_item.png"))); // NOI18N
        jb_adicionar_copia.setToolTipText("Adicionar/Alterar");
        jb_adicionar_copia.setName("jb_adicionar_copia"); // NOI18N
        jb_adicionar_copia.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_adicionar_copia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_adicionar_copiaMouseClicked(evt);
            }
        });
        jb_adicionar_copia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_adicionar_copiaActionPerformed(evt);
            }
        });
        jb_adicionar_copia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_adicionar_copiaKeyPressed(evt);
            }
        });

        jb_eliminar_copia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/remove_item.png"))); // NOI18N
        jb_eliminar_copia.setToolTipText("Excluir/Sair");
        jb_eliminar_copia.setName("jb_eliminar_copia"); // NOI18N
        jb_eliminar_copia.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_eliminar_copia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_eliminar_copiaActionPerformed(evt);
            }
        });

        jScrollPane5.setName("jScrollPane5"); // NOI18N

        jtbl_copia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código de Barras", "Diária", "Valor Locação", "Mídia", "Idioma", "Legenda", "Preço Custo", "Data Aquisição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jtbl_copia.setName("jtbl_copia"); // NOI18N
        jtbl_copia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_copiaMouseClicked(evt);
            }
        });
        jtbl_copia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_copiaKeyPressed(evt);
            }
        });
        jScrollPane5.setViewportView(jtbl_copia);
        if (jtbl_copia.getColumnModel().getColumnCount() > 0) {
            jtbl_copia.getColumnModel().getColumn(0).setPreferredWidth(40);
            jtbl_copia.getColumnModel().getColumn(1).setPreferredWidth(100);
            jtbl_copia.getColumnModel().getColumn(2).setPreferredWidth(30);
            jtbl_copia.getColumnModel().getColumn(3).setPreferredWidth(30);
            jtbl_copia.getColumnModel().getColumn(4).setPreferredWidth(40);
            jtbl_copia.getColumnModel().getColumn(5).setPreferredWidth(40);
            jtbl_copia.getColumnModel().getColumn(6).setPreferredWidth(30);
            jtbl_copia.getColumnModel().getColumn(7).setPreferredWidth(30);
        }

        jLabel27.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel27.setText("Idioma");
        jLabel27.setName("jLabel27"); // NOI18N

        jcb_idioma.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_idioma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chinês", "Espanhol", "Francês", "Inglês", "Italiano", "Japonês", "Polonês", "Português" }));
        jcb_idioma.setName("jcb_idioma"); // NOI18N
        jcb_idioma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcb_idiomaKeyPressed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel28.setText("Legenda");
        jLabel28.setName("jLabel28"); // NOI18N

        jcb_legenda.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_legenda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chinês", "Espanhol", "Francês", "Inglês", "Italiano", "Japonês", "Polonês", "Português", "Não Legendado" }));
        jcb_legenda.setName("jcb_legenda"); // NOI18N
        jcb_legenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcb_legendaKeyPressed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel29.setText("Preço custo");
        jLabel29.setName("jLabel29"); // NOI18N

        jtf_preco_custo.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_preco_custo.setText("R$ 0,00");
        jtf_preco_custo.setName("jtf_preco_custo"); // NOI18N
        jtf_preco_custo.setPreferredSize(new java.awt.Dimension(0, 24));
        jtf_preco_custo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_preco_custoActionPerformed(evt);
            }
        });
        jtf_preco_custo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_preco_custoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_preco_custoFocusLost(evt);
            }
        });
        jtf_preco_custo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_preco_custoKeyPressed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel31.setText("Data Aquisição");
        jLabel31.setName("jLabel31"); // NOI18N

        jtf_data_aquisicao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_data_aquisicao.setName("jtf_data_aquisicao"); // NOI18N
        jtf_data_aquisicao.setPreferredSize(new java.awt.Dimension(0, 24));
        jtf_data_aquisicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_data_aquisicaoActionPerformed(evt);
            }
        });
        jtf_data_aquisicao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_data_aquisicaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_data_aquisicaoFocusLost(evt);
            }
        });
        jtf_data_aquisicao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_data_aquisicaoKeyPressed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel36.setText("Mídia");
        jLabel36.setName("jLabel36"); // NOI18N

        jcb_midia.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_midia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blu-Ray", "Blu-Ray 3D", "CD", "DVD", "PS3", "VHs", "Xbox" }));
        jcb_midia.setName("jcb_midia"); // NOI18N
        jcb_midia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcb_midiaKeyPressed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel41.setText("Diária");
        jLabel41.setName("jLabel41"); // NOI18N

        jtf_descricao_diaria.setEditable(false);
        jtf_descricao_diaria.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_descricao_diaria.setName("jtf_descricao_diaria"); // NOI18N
        jtf_descricao_diaria.setPreferredSize(new java.awt.Dimension(0, 24));

        jb_diaria.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jb_diaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/pesquisar.png"))); // NOI18N
        jb_diaria.setName("jb_diaria"); // NOI18N
        jb_diaria.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_diaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_diariaActionPerformed(evt);
            }
        });
        jb_diaria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_diariaKeyPressed(evt);
            }
        });

        jtf_diaria_dias.setEditable(false);
        jtf_diaria_dias.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_diaria_dias.setName("jtf_diaria_dias"); // NOI18N
        jtf_diaria_dias.setPreferredSize(new java.awt.Dimension(0, 24));
        jtf_diaria_dias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_diaria_diasActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel42.setText("Dias");
        jLabel42.setName("jLabel42"); // NOI18N

        jLabel43.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel43.setText("Valor");
        jLabel43.setName("jLabel43"); // NOI18N

        jtf_valor.setEditable(false);
        jtf_valor.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_valor.setText("R$ 0,00");
        jtf_valor.setName("jtf_valor"); // NOI18N
        jtf_valor.setPreferredSize(new java.awt.Dimension(0, 24));
        jtf_valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_valorActionPerformed(evt);
            }
        });

        buttonGroup2.add(jrb_ativo_copia);
        jrb_ativo_copia.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_ativo_copia.setSelected(true);
        jrb_ativo_copia.setText("Ativo");
        jrb_ativo_copia.setName("jrb_ativo_copia"); // NOI18N
        jrb_ativo_copia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_ativo_copiaActionPerformed(evt);
            }
        });
        jrb_ativo_copia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jrb_ativo_copiaKeyPressed(evt);
            }
        });

        buttonGroup2.add(jrb_inativo_copia);
        jrb_inativo_copia.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_inativo_copia.setText("Inativo");
        jrb_inativo_copia.setName("jrb_inativo_copia"); // NOI18N
        jrb_inativo_copia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jrb_inativo_copiaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jtf_descricao_diaria, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jb_diaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jtf_diaria_dias, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addComponent(jtf_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcb_midia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcb_idioma, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jcb_legenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtf_data_aquisicao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jtf_preco_custo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jb_adicionar_copia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jb_eliminar_copia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jrb_ativo_copia)
                .addGap(0, 0, 0)
                .addComponent(jrb_inativo_copia)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrb_ativo_copia)
                    .addComponent(jrb_inativo_copia))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel43)
                                .addComponent(jLabel42)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtf_diaria_dias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtf_descricao_diaria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jb_diaria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcb_midia)
                            .addComponent(jtf_valor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcb_idioma)))
                    .addComponent(jLabel27)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(0, 0, 0)
                        .addComponent(jcb_legenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(0, 0, 0)
                        .addComponent(jtf_data_aquisicao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtf_preco_custo, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                            .addComponent(jb_adicionar_copia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jb_eliminar_copia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jtp_menu.addTab("Cópias", jPanel2);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jb_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtp_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jtp_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jb_salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        retornaJanelaPai();

}//GEN-LAST:event_jb_cancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jtf_titulo.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornaJanelaPai();
    }//GEN-LAST:event_formWindowClosed

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        cadastrarAlterarObjeto();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarActionPerformed

    private void jb_salvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_salvarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cadastrarAlterarObjeto();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarKeyPressed

    private void jtf_titulo_originalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_titulo_originalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_titulo_originalActionPerformed

    private void jtf_titulo_originalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_titulo_originalFocusGained

    }//GEN-LAST:event_jtf_titulo_originalFocusGained

    private void jtf_titulo_originalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_titulo_originalKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_duracao.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_titulo_originalKeyPressed

    private void jtf_tituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_tituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_tituloActionPerformed

    private void jtf_tituloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_tituloFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_tituloFocusGained

    private void jtf_tituloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_tituloKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_titulo_original.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_tituloKeyPressed

    private void jtf_tituloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_tituloKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_tituloKeyReleased

    private void jtf_duracaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_duracaoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_censura.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_duracaoKeyPressed

    private void jb_generoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_generoActionPerformed
        if (consultaGenero == null) {
            consultaGenero = new ConsultaGeneroObjeto();
            consultaGenero.janelapai = this;
            consultaGenero.listaTodasGeneros();
            consultaGenero.setVisible(true);
            setStatusTela(false);
        } else {
            consultaGenero.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_generoActionPerformed

    private void jb_generoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_generoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (consultaGenero == null) {
                consultaGenero = new ConsultaGeneroObjeto();
                consultaGenero.janelapai = this;
                consultaGenero.listaTodasGeneros();
                consultaGenero.setVisible(true);
                setStatusTela(false);
            } else {
                consultaGenero.setVisible(true);
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_generoKeyPressed

    private void jcb_producaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_producaoKeyPressed

        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jcb_tipo_midia.requestFocus();
        }// TODO add your handling code here:
    }//GEN-LAST:event_jcb_producaoKeyPressed

    private void jrb_ativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_ativoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_ativoActionPerformed

    private void jcb_tipo_midiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_tipo_midiaKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_genero.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_tipo_midiaKeyPressed

    private void jcb_tipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_tipoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jcb_producao.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_tipoKeyPressed

    private void jtf_descricao_generoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_descricao_generoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_descricao_generoActionPerformed

    private void jb_adicionar_copiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_adicionar_copiaActionPerformed

    }//GEN-LAST:event_jb_adicionar_copiaActionPerformed

    private void jb_adicionar_copiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_adicionar_copiaKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cadastrarCopia();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_copiaKeyPressed

    private void jb_eliminar_copiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_eliminar_copiaActionPerformed

        if (action.equals("salvar")) {
            excluirCopia();
        } else if (action.equals("alterar")) {
            jb_adicionar_copia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/adicionar_item.png")));
            jb_eliminar_copia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/remove_item.png"))); // NOI18N            

            jrb_ativo_copia.setSelected(true);
            jtf_descricao_diaria.setText("");
            jtf_diaria_dias.setText("");
            jtf_valor.setText("R$ 0,00");
            jtf_data_aquisicao.setText("");
            jtf_preco_custo.setText("R$ 0,00");
            jb_diaria.requestFocus();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jb_eliminar_copiaActionPerformed

    private void jtbl_copiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_copiaKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            alterarCopia();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_copiaKeyPressed

    private void jcb_idiomaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_idiomaKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jcb_legenda.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_idiomaKeyPressed

    private void jcb_legendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_legendaKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_data_aquisicao.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_legendaKeyPressed

    private void jtf_preco_custoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_preco_custoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco_custoActionPerformed

    private void jtf_preco_custoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco_custoFocusLost
        Moeda moeda = new Moeda();
        if (jtf_preco_custo.getText().equals("")) {
            jtf_preco_custo.setText("R$ 0,00");
        } else {
            jtf_preco_custo.setText(moeda.setPrecoFormat(String.valueOf(moeda.getPrecoFormato(jtf_preco_custo.getText()))));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco_custoFocusLost

    private void jtf_preco_custoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_preco_custoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_adicionar_copia.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco_custoKeyPressed

    private void jtf_data_aquisicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_data_aquisicaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_aquisicaoActionPerformed

    private void jtf_data_aquisicaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_aquisicaoFocusLost
        try {
            Data data = new Data();
            int idade;

            if (jtf_data_aquisicao.getText().trim().length() < 10) {
                jtf_data_aquisicao.setForeground(Color.red);
            } else if (jtf_data_aquisicao.getText().equals("  /  /    ")) {
                jtf_data_aquisicao.setForeground(Color.red);
            } else {
                if (validaData(jtf_data_aquisicao.getText())) {
                    jtf_data_aquisicao.setForeground(Color.black);
                } else {
                    jtf_data_aquisicao.setForeground(Color.red);
                }

            }
        } catch (ParseException ex) {
            jtf_data_aquisicao.setForeground(Color.red);
        } catch (NumberFormatException ex) {
            jtf_data_aquisicao.setText("  /  /    ");
            jtf_data_aquisicao.setForeground(Color.red);
        }
    }//GEN-LAST:event_jtf_data_aquisicaoFocusLost

    private void jtf_data_aquisicaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_data_aquisicaoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_preco_custo.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_aquisicaoKeyPressed

    private void jtf_preco_custoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_preco_custoFocusGained
        jtf_preco_custo.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_preco_custoFocusGained

    private void jtf_data_aquisicaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_aquisicaoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_aquisicaoFocusGained

    private void jtf_censuraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_censuraKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jcb_tipo.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_censuraKeyPressed

    private void jb_adicionar_copiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_adicionar_copiaMouseClicked
        if (evt.getClickCount() == 1) {
            cadastrarCopia();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_copiaMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void jcb_midiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_midiaKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jcb_idioma.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_midiaKeyPressed

    private void jb_diariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_diariaActionPerformed
        if (consultaDiaria == null) {
            consultaDiaria = new ConsultaDiaria();
            consultaDiaria.janelapai = this;
            consultaDiaria.listaTodasDiarias();
            consultaDiaria.setVisible(true);
            setStatusTela(false);
        } else {
            consultaDiaria.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_diariaActionPerformed

    private void jb_diariaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_diariaKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (consultaDiaria == null) {
                consultaDiaria = new ConsultaDiaria();
                consultaDiaria.janelapai = this;
                consultaDiaria.listaTodasDiarias();
                consultaDiaria.setVisible(true);
                setStatusTela(false);
            } else {
                consultaDiaria.setVisible(true);
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_diariaKeyPressed

    private void jtf_diaria_diasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_diaria_diasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_diaria_diasActionPerformed

    private void jtf_valorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_valorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_valorActionPerformed

    private void jta_elencoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jta_elencoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jta_sinopse.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jta_elencoKeyPressed

    private void jta_sinopseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jta_sinopseKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_salvar.requestFocus();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jta_sinopseKeyPressed

    private void jrb_ativo_copiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_ativo_copiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_ativo_copiaActionPerformed

    private void jtbl_copiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_copiaMouseClicked
        if (evt.getClickCount() > 1) {
            alterarCopia();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_copiaMouseClicked

    private void jPanel2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel2FocusGained
        jb_diaria.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2FocusGained

    private void jcb_tipo_midiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_tipo_midiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_tipo_midiaActionPerformed

    private void jta_diretorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jta_diretorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jta_elenco.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jta_diretorKeyPressed

    private void jrb_ativo_copiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jrb_ativo_copiaKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_ativo_copiaKeyPressed

    private void jrb_inativo_copiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jrb_inativo_copiaKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_inativo_copiaKeyPressed

    private void jrb_ativoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jrb_ativoKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_ativoKeyPressed

    private void jrb_inativoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jrb_inativoKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_inativoKeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CadastraAlteraObjeto().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton jb_adicionar_copia;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_diaria;
    private javax.swing.JButton jb_eliminar_copia;
    private javax.swing.JButton jb_genero;
    private javax.swing.JButton jb_salvar;
    public static javax.swing.JComboBox jcb_idioma;
    public static javax.swing.JComboBox jcb_legenda;
    public static javax.swing.JComboBox jcb_midia;
    public static javax.swing.JComboBox jcb_producao;
    public static javax.swing.JComboBox jcb_tipo;
    public static javax.swing.JComboBox jcb_tipo_midia;
    public static javax.swing.JRadioButton jrb_ativo;
    public static javax.swing.JRadioButton jrb_ativo_copia;
    public static javax.swing.JRadioButton jrb_inativo;
    public static javax.swing.JRadioButton jrb_inativo_copia;
    public static javax.swing.JTextArea jta_diretor;
    public static javax.swing.JTextArea jta_elenco;
    public static javax.swing.JTextArea jta_sinopse;
    public static javax.swing.JTable jtbl_copia;
    private javax.swing.JFormattedTextField jtf_censura;
    public static javax.swing.JTextField jtf_codigo_objeto;
    public static javax.swing.JFormattedTextField jtf_data_aquisicao;
    private javax.swing.JTextField jtf_descricao_diaria;
    public static javax.swing.JTextField jtf_descricao_genero;
    public static javax.swing.JTextField jtf_diaria_dias;
    public static javax.swing.JTextField jtf_duracao;
    public static javax.swing.JTextField jtf_preco_custo;
    public static javax.swing.JTextField jtf_titulo;
    public static javax.swing.JTextField jtf_titulo_original;
    public static javax.swing.JTextField jtf_valor;
    private javax.swing.JTabbedPane jtp_menu;
    private javax.swing.JTextArea tfa_similar;
    // End of variables declaration//GEN-END:variables

    public void setTela(String permissao) {
        if (permissao.equals("usuario")) {
        } else {
        }
    }
    SiscomController controller;

    public boolean verificarCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_titulo.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Título\n";
        }

        if (jtf_titulo_original.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Título Original\n";
        }

        if (jtf_duracao.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Duração\n";
        }

        if (jtf_descricao_genero.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Gênero\n";
        }

        if (jtf_censura.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Censura\n";
        }

        if (jtf_censura.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Censura\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jtf_titulo.requestFocus();
            return false;
        } else {
            return true;
        }

    }

    public boolean verificarCamposCopia() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        try {
            Data data = new Data();
            int idade;

            if (jtf_diaria_dias.getText().trim().equals("")) {
                msgERRO = msgERRO + " *Diária\n";
            }

            if (jtf_data_aquisicao.getText().trim().length() != 10) {
                jtf_data_aquisicao.setForeground(Color.red);
                msgERRO = msgERRO + " *Data de Aquisição inválida\n";
            } else if (jtf_data_aquisicao.getText().equals("  /  /    ")) {
                jtf_data_aquisicao.setForeground(Color.red);
                msgERRO = msgERRO + " *Data de Aquisição inválida\n";
            } else {
                if (validaData(jtf_data_aquisicao.getText())) {
                    jtf_data_aquisicao.setForeground(Color.black);
                } else {
                    jtf_data_aquisicao.setForeground(Color.red);
                    msgERRO = msgERRO + " *Data de Aquisição inválida\n";
                }

            }
        } catch (ParseException ex) {
            jtf_data_aquisicao.setForeground(Color.red);
            msgERRO = msgERRO + " *Data de Aquisição inválida\n";
        } catch (NumberFormatException ex) {
            jtf_data_aquisicao.setText("  /  /    ");
            jtf_data_aquisicao.setForeground(Color.red);
            msgERRO = msgERRO + " *Data de Aquisição inválida\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);

            jb_diaria.requestFocus();

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

    public boolean verificar_campo_copia() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);

            return false;
        } else {
            return true;
        }
    }

    public boolean verificaTabela() {

        boolean tabela = true;
        if (jtbl_copia.getRowCount() == 0) {
            return true;

        } else if (jtbl_copia.getRowCount() > 0) {
            int linhas = jtbl_copia.getRowCount();

            for (int i = 0; i < linhas; i++) {
                Cliente cliente = new Cliente();
                cliente.setTelefone(new Telefone((Integer) jtbl_copia.getValueAt(i, 0)));

                String telefone = null;
//                telefone = jtf_localizacao.getText();

            }

            return tabela;
        }
        return tabela;
    }

    public void carregaDiaria(Diaria diaria) {
        if (diaria != null) {
            this.diaria = diaria;
            jtf_diaria_dias.setText(String.valueOf(diaria.getDias()));
            jtf_descricao_diaria.setText(diaria.getNome_diaria());

            moeda = new Moeda();

            jtf_valor.setText(moeda.setPrecoFormat(diaria.getValor().toString()));

            jcb_midia.requestFocus();
        } 
    }

    public void carregaGenero(Genero genero) {
        if (genero != null) {
            this.genero = genero;
            jtf_descricao_genero.setText(genero.getNome_genero());

            jta_diretor.requestFocus();

        } else {
            JOptionPane.showMessageDialog(null, "Objeto gênero nulo");
        }

    }

    public void setRequestDiaria() {

    }

    public void setRequestGenero() {

    }

    public static Diaria getObjetoDiaria() {
        return diaria;
    }

    public static Genero getObjetoGenero() {
        return genero;
    }

    private void excluirCopia() {
        pool = new Pool();
        UsuarioDAO usuarioControl = new UsuarioDAO(pool);
        ArquivoConfiguracao conf = new ArquivoConfiguracao();
        acesso = usuarioControl.permissaoInterface(conf.readPropertie("login"), "br.com.locadora.view.MenuObjeto");

        try {
            if (acesso.getDeletar() == true) {
                DefaultTableModel row = (DefaultTableModel) jtbl_copia.getModel();
                if (jtbl_copia.getSelectedRow() != -1) {
                    int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_NO_OPTION) {
                        pool = new Pool();
                        CopiaDAO copiaDAO = new CopiaDAO(pool);
                        copia = new Copia();
                        copia.setCodigo_copia((Integer) jtbl_copia.getValueAt(jtbl_copia.getSelectedRow(), 0));

                        try {
                            copiaDAO.excluir(copia.getCodigo_copia());
                            row.removeRow(jtbl_copia.getSelectedRow());
                            jtbl_copia.requestFocus();
                            jtbl_copia.setSelectionMode(1);
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Este registro não pode ser excluído pois está referenciado em outra tabela");
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma cópia");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Usuário sem permissão. Consultar o administrador");
        }
    }

    public void acionarAtalho(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_F10) {
            cadastrarAlterarObjeto();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            retornaJanelaPai();
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

    public void cadastrarAlterarObjeto() {

        try {

            if (verificarCampos()) {

                pool = new Pool();
                objetoDAO = new ObjetoDAO(pool);
                Objeto objeto = new Objeto();
                objeto.setTitulo(jtf_titulo.getText().trim());
                objeto.setTitulo_original(jtf_titulo_original.getText().trim());
                objeto.setTipo_movimento((String) jcb_tipo.getSelectedItem());
                objeto.setProducao((String) jcb_producao.getSelectedItem());
                objeto.setDuracao(jtf_duracao.getText().trim());
                objeto.setTipo_midia((String) jcb_tipo_midia.getSelectedItem());
                objeto.setGenero(getObjetoGenero());
                if (jta_elenco.getText().length() > 1000) {
                    objeto.setElenco(jta_elenco.getText().substring(0, 1000));
                } else {
                    objeto.setElenco(jta_elenco.getText().trim());
                }
                
                if (jta_diretor.getText().length() > 500) {
                    objeto.setDiretor(jta_diretor.getText().substring(0, 500));
                } else {
                    objeto.setDiretor(jta_diretor.getText().trim());
                }
                
                if (jta_sinopse.getText().length() > 1000) {
                    objeto.setSinopse(jta_sinopse.getText().substring(0, 1000));
                } else {
                    objeto.setSinopse(jta_sinopse.getText().trim());
                
                }
                objeto.setCensura(Integer.parseInt(jtf_censura.getText()));
                if (jrb_ativo.isSelected() == true) {
                    objeto.setStatus("0");
                } else {
                    objeto.setStatus("1");
                }
                if (jtf_codigo_objeto.getText().isEmpty()) {
                    LogInfo logInfo = new LogInfo();
                    logInfo.setDescricao("Novo Objeto: " + jtf_titulo.getText());
                    logInfo.setUsuario(acesso.getUsuario());
                    pool = new Pool();
                    LogInfoDAO logInfoDAO = new LogInfoDAO(pool);
                    logInfoDAO.salvar(logInfo);

                    objeto = objetoDAO.salvar(objeto);
                    JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

                    jtf_codigo_objeto.setText(String.valueOf(objeto.getCodigo_objeto()));

                } else {
                    LogInfo logInfo = new LogInfo();
                    logInfo.setDescricao("Alterar Objeto -> " + objeto.getTitulo()+ " -> " + jtf_titulo.getText());
                    logInfo.setUsuario(acesso.getUsuario());
                    pool = new Pool();
                    LogInfoDAO logInfoDAO = new LogInfoDAO(pool);
                    logInfoDAO.salvar(logInfo);

                    objeto.setCodigo_objeto(Integer.parseInt(jtf_codigo_objeto.getText()));
                    objetoDAO.atualizar(objeto);
                    JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
                }
                jtp_menu.setSelectedIndex(1);
                jb_diaria.requestFocus();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Problemas com a gravação: ");

            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Valor inválido: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void cadastrarCopia() {
        try {
            if (jtf_codigo_objeto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Salvar primeiro o Objeto");
            } else {
                if (verificarCamposCopia() == true) {

                    Moeda moeda = new Moeda();
                    Copia copia = new Copia();
                    Objeto objeto = new Objeto();

                    System.out.println("Código do Objeto: " + Integer.parseInt(jtf_codigo_objeto.getText()));
                    objeto.setCodigo_objeto(Integer.parseInt(jtf_codigo_objeto.getText()));

                    copia.setObjeto(objeto);
                    copia.setDiaria(getObjetoDiaria());
                    copia.setMidia((String) jcb_midia.getSelectedItem());
                    copia.setIdioma((String) jcb_idioma.getSelectedItem());
                    copia.setLegenda((String) jcb_legenda.getSelectedItem());
                    copia.setData_aquisicao(new SimpleDateFormat("dd/MM/yyyy").parse((String) jtf_data_aquisicao.getText()));
                    copia.setPreco_custo(moeda.getPrecoFormato((String) jtf_preco_custo.getText()));
                    if (jrb_ativo_copia.isSelected() == true) {
                        copia.setDefect_flag(true);
                    } else {
                        copia.setDefect_flag(false);
                    }

                    if (action.equals("salvar")) {
                        pool = new Pool();
                        CopiaDAO copiaDAO = new CopiaDAO(pool);
                        copiaDAO.salvar(copia);
                        carregaCopia(objeto.getCodigo_objeto());
                    } else if (action.equals("alterar")) {
                        copia.setCodigo_copia(copiaAlterar.getCodigo_copia());
                        pool = new Pool();
                        CopiaDAO copiaDAO = new CopiaDAO(pool);
                        copiaDAO.atualizar(copia);
                        carregaCopia(objeto.getCodigo_objeto());

                        jb_adicionar_copia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/adicionar_item.png"))); // NOI18N                        
                        jb_eliminar_copia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/remove_item.png"))); // NOI18N
                        action = "salvar";
                    }

                    jrb_ativo_copia.setSelected(true);
                    jtf_descricao_diaria.setText("");
                    jtf_diaria_dias.setText("");
                    jtf_valor.setText("R$ 0,00");
                    jtf_data_aquisicao.setText("");
                    jtf_preco_custo.setText("R$ 0,00");
                    jb_diaria.requestFocus();
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Valor inválido: " + e.getMessage());

            e.printStackTrace();
        } catch (Exception ex) {

        }

    }

    public void carregaCopia(Integer codigo_objeto) {
        try {
            if (codigo_objeto != null) {
                pool = new Pool();
                CopiaDAO copiaDAO = new CopiaDAO(pool);
                copias = null;
                copias = copiaDAO.getCopia_codigo_objeto(codigo_objeto, 1, "");
                if (copias != null && copias.size() > 0) {
                    DefaultTableModel tableModel = (DefaultTableModel) jtbl_copia.getModel();
                    tableModel.setNumRows(0);

                    for (int i = 0; i < copias.size(); i++) {
                        String preco_custo;

                        preco_custo = String.valueOf(copias.get(i).getPreco_custo());
                        Moeda moeda = new Moeda();
                        preco_custo = moeda.setPrecoFormat(preco_custo);

                        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
                        String data_aquisicao = out.format(in.parse(copias.get(i).getData_aquisicao().toString()));

                        DefaultTableModel row = (DefaultTableModel) jtbl_copia.getModel();
                        ItemDbGrid hashDbGrid = new ItemDbGrid(copias.get(i), copias.get(i).getCodigo_barras());
                        row.addRow(new Object[]{hashDbGrid, copias.get(i).getDiaria().getNome_diaria(),
                            moeda.setPrecoFormat(copias.get(i).getDiaria().getValor().toString()), copias.get(i).getMidia(),
                            copias.get(i).getIdioma(), copias.get(i).getLegenda(), preco_custo, data_aquisicao});

                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    private void alterarCopia() {
        if (jtbl_copia.getSelectedRow() != -1) {
            copiaAlterar = copias.get(jtbl_copia.getSelectedRow());

            carregaDiaria(copias.get(jtbl_copia.getSelectedRow()).getDiaria());
            for (int i = 0; i < jcb_midia.getItemCount(); i++) {
                if (jcb_midia.getItemAt(i).toString().equals(copias.get(jtbl_copia.getSelectedRow()).getMidia())) {
                    jcb_midia.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 0; i < jcb_idioma.getItemCount(); i++) {
                if (jcb_idioma.getItemAt(i).toString().equals(copias.get(jtbl_copia.getSelectedRow()).getIdioma())) {
                    jcb_idioma.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 0; i < jcb_legenda.getItemCount(); i++) {
                if (jcb_legenda.getItemAt(i).toString().equals(copias.get(jtbl_copia.getSelectedRow()).getLegenda())) {
                    jcb_legenda.setSelectedIndex(i);
                    break;
                }
            }
            SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
            String data_aquisicao = null;
            try {
                data_aquisicao = out.format(in.parse(copias.get(jtbl_copia.getSelectedRow()).getData_aquisicao().toString()));
            } catch (ParseException ex) {

            }

            jtf_data_aquisicao.setText(data_aquisicao);

            jtf_preco_custo.setText(moeda.setPrecoFormat(copias.get(jtbl_copia.getSelectedRow()).getPreco_custo().toString()));

            jb_adicionar_copia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/alterar_registro.png"))); // NOI18N
            jb_eliminar_copia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/sair.png"))); // NOI18N
            action = "alterar";

        }
    }

    private void retornaJanelaPai() {
        setVisible(false);

        if (janelapai != null) {
            janelapai.setStatusTela(true);
            janelapai.buscarDados();
            janelapai.jtf_pesquisa.requestFocus();
            janelapai.cadastraAlteraObjeto = null;
        } else if(consultaCopiaLocacao != null){
            consultaCopiaLocacao.setStatusTela(true);
            consultaCopiaLocacao.jtf_pesquisa.requestFocus();            
        }

    }
}
