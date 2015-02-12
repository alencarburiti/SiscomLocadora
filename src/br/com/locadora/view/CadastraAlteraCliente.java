package br.com.locadora.view;

import br.com.locadora.conexao.InterfacePool;
import br.com.locadora.conexao.Pool;
import br.com.locadora.model.bean.AcessoUsuario;
import br.com.locadora.model.bean.Cliente;
import br.com.locadora.model.bean.Dependente;
import br.com.locadora.model.bean.Combo;
import br.com.locadora.model.bean.LogInfo;
import br.com.locadora.model.bean.Telefone;
import br.com.locadora.model.dao.ClienteDAO;
import br.com.locadora.model.dao.DependenteDAO;
import br.com.locadora.model.dao.ComboDAO;
import br.com.locadora.model.dao.LogInfoDAO;
import br.com.locadora.model.dao.TelefoneDAO;
import br.com.locadora.util.ArquivoConfiguracao;
import br.com.locadora.util.Data;
import br.com.locadora.util.ItemDbGrid;
import br.com.locadora.util.LimitadorTexto;
import br.com.locadora.util.Moeda;
import br.com.locadora.util.TemaInterface;
import br.com.locadora.util.ValidaCPF;
import java.awt.Color;
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
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author ALENCAR
 */
public final class CadastraAlteraCliente extends javax.swing.JFrame {

    private Cliente cliente;
    public MenuCliente janelapai;
    public ConsultaClienteAtendimento janelapai2;
    public LocacaoEmAberto janelapai3;
    public ConsultaClienteAtendimento janelapai4;
    private InterfacePool pool;
    public List<Telefone> telefones;
    public List<Dependente> dependentes;
    public MaskFormatter formatoData, formatoCPF, formatoTelefone;
    public ClienteDAO clienteDAO;
    public Dependente dependenteAlterar;
    public String action;
    public TelefoneDAO telefoneDAO;
    public AcessoUsuario acesso;
    public ComboDAO comboDAO;
    public List<Combo> combos;
    public Moeda moeda;

    /**
     * Creates new form ProdutoCadastroGUI
     */
    public CadastraAlteraCliente() {
        initComponents();
        TemaInterface.getInterface(this);
        this.setTitle("Cadastrando Cliente");
        janelapai = null;
        janelapai2 = null;
        janelapai3 = null;
        janelapai4 = null;
        action = "salvar";
        
        Calendar data_atual = Calendar.getInstance();
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        String data_inicial = out.format(data_atual.getTime());
        jtf_data_cadastro.setText(data_inicial);
    }

    public CadastraAlteraCliente(Cliente cliente) {
        initComponents();
        if (cliente != null) {
            TemaInterface.getInterface(this);
            this.setTitle("Alterando Cliente");
            janelapai = null;
            janelapai2 = null;
            janelapai3 = null;
            janelapai4 = null;
            this.cliente = cliente;

            jtf_codigo_cliente.setText(String.valueOf(cliente.getCodigo_cliente()));
            jtf_nome_cliente.setText(cliente.getNome_cliente());

            SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

            String data_nascimento = null;
            String data_cadastro = null;
            try {
                data_nascimento = out.format(in.parse(cliente.getData_nascimento().toString()));
                data_cadastro = out.format(in.parse(cliente.getData_cadastro().toString()));
            } catch (ParseException ex) {
                Logger.getLogger(CadastraAlteraCliente.class.getName()).log(Level.SEVERE, null, ex);
            }

            jtf_data_nascimento.setText(data_nascimento);
            jtf_data_cadastro.setText(data_cadastro);
            jtf_cpf_cliente.setText(cliente.getCpf());
            jtf_empresa.setText(cliente.getNome_empresa_trabalho());
            jtf_profissao.setText(cliente.getProfissao());
            jtf_endereco.setText(cliente.getEndereco());
            jtf_bairro.setText(cliente.getBairro());
            jtf_complemento.setText(cliente.getComplemento());
            jtf_cidade.setText(cliente.getCidade());
            jtf_estado.setText(cliente.getEstado());
            jtf_email.setText(cliente.getEmail());
            jta_observacao.setText(cliente.getObservacao());
            System.out.println("Status: " + cliente.getStatus());
            if (cliente.getStatus() == true) {
                jrb_ativo.setSelected(true);
            } else {
                jrb_inativo.setSelected(true);
            }

            carregaTelefone(cliente.getCodigo_cliente());
            carregaDependente(cliente.getCodigo_cliente());
            consultarCombosAdquiridos(cliente.getCodigo_cliente());

            action = "salvar";

        }
    }

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
        jb_salvar = new javax.swing.JButton();
        jtp_cliente = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jtf_codigo_cliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtf_empresa = new javax.swing.JTextField(new LimitadorTexto(50), "",10);
        jtf_nome_cliente = new javax.swing.JTextField(new LimitadorTexto(50), "",10);
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtf_profissao = new javax.swing.JTextField(new LimitadorTexto(50), "",10);
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtf_endereco = new javax.swing.JTextField(new LimitadorTexto(50), "",10);
        jLabel14 = new javax.swing.JLabel();
        jtf_bairro = new javax.swing.JTextField(new LimitadorTexto(50), "",10);
        jLabel15 = new javax.swing.JLabel();
        jtf_complemento = new javax.swing.JTextField(new LimitadorTexto(50), "",10);
        jLabel16 = new javax.swing.JLabel();
        jtf_email = new javax.swing.JTextField(new LimitadorTexto(50), "",10);
        jrb_ativo = new javax.swing.JRadioButton();
        jrb_inativo = new javax.swing.JRadioButton();
        jLabel20 = new javax.swing.JLabel();
        jtf_estado = new javax.swing.JTextField(new LimitadorTexto(50), "",10);
        jLabel23 = new javax.swing.JLabel();
        jtf_cidade = new javax.swing.JTextField(new LimitadorTexto(50), "",10);
        try  {
            formatoData = new MaskFormatter("##/##/####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_data_nascimento = new JFormattedTextField(formatoData);
        try  {
            formatoCPF = new MaskFormatter("###.###.###-##");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_cpf_cliente = new JFormattedTextField(formatoCPF);
        jLabel21 = new javax.swing.JLabel();
        try  {
            formatoTelefone = new MaskFormatter("(##) ####-####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_telefone = new JFormattedTextField(formatoTelefone);
        jb_adicionar_telefone = new javax.swing.JButton();
        jb_eliminar_telefone = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbl_telefone = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jta_observacao = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        try  {
            formatoData = new MaskFormatter("##/##/####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_data_cadastro = new JFormattedTextField(formatoData);
        jPanel2 = new javax.swing.JPanel();
        jb_adicionar_dependente = new javax.swing.JButton();
        jb_eliminar_dependente = new javax.swing.JButton();
        jrb_ativo_dependente = new javax.swing.JRadioButton();
        jrb_inativo_dependente = new javax.swing.JRadioButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtbl_dependente = new javax.swing.JTable();
        try  {
            formatoCPF = new MaskFormatter("###.###.###-##");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_cpf_dependente = new JFormattedTextField(formatoCPF);
        jcb_parentesco = new javax.swing.JComboBox();
        try  {
            formatoTelefone = new MaskFormatter("(##) ####-####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_telefone_dependente = new JFormattedTextField(formatoTelefone);
        jtf_nome_dependente = new javax.swing.JTextField(new LimitadorTexto(50), "",10);
        try  {
            formatoData = new MaskFormatter("##/##/####");
        }
        catch (Exception erro)
        {
            JOptionPane.showMessageDialog(null,"Não foi possivel setar");
        }
        jtf_data_nascimento_dependente = new JFormattedTextField(formatoData);
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtbl_pacotes_adquiridos = new javax.swing.JTable();

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tfa_similar.setColumns(20);
        tfa_similar.setRows(5);
        tfa_similar.setName("tfa_similar"); // NOI18N
        jScrollPane1.setViewportView(tfa_similar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterando Cliente");
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
        jb_cancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_cancelarKeyPressed(evt);
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

        jtp_cliente.setName("jtp_cliente"); // NOI18N
        jtp_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtp_clienteMouseClicked(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel3.setName("jPanel3"); // NOI18N

        jtf_codigo_cliente.setEditable(false);
        jtf_codigo_cliente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_codigo_cliente.setName("jtf_codigo_cliente"); // NOI18N

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel6.setText("CPF*");
        jLabel6.setName("jLabel6"); // NOI18N

        jtf_empresa.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_empresa.setName("jtf_empresa"); // NOI18N
        jtf_empresa.setPreferredSize(new java.awt.Dimension(14, 24));
        jtf_empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_empresaActionPerformed(evt);
            }
        });
        jtf_empresa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_empresaFocusGained(evt);
            }
        });
        jtf_empresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_empresaKeyPressed(evt);
            }
        });

        jtf_nome_cliente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_nome_cliente.setName("jtf_nome_cliente"); // NOI18N
        jtf_nome_cliente.setPreferredSize(new java.awt.Dimension(14, 24));
        jtf_nome_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_nome_clienteActionPerformed(evt);
            }
        });
        jtf_nome_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_nome_clienteKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel1.setText("Código Cliente");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel3.setText("Nome*");
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel10.setText("Empresa*");
        jLabel10.setName("jLabel10"); // NOI18N

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel11.setText("Profissão*");
        jLabel11.setName("jLabel11"); // NOI18N

        jtf_profissao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_profissao.setName("jtf_profissao"); // NOI18N
        jtf_profissao.setPreferredSize(new java.awt.Dimension(14, 24));
        jtf_profissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_profissaoActionPerformed(evt);
            }
        });
        jtf_profissao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_profissaoKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel12.setText("Nascimento*");
        jLabel12.setName("jLabel12"); // NOI18N

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel13.setText("Endereço*");
        jLabel13.setName("jLabel13"); // NOI18N

        jtf_endereco.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_endereco.setName("jtf_endereco"); // NOI18N
        jtf_endereco.setPreferredSize(new java.awt.Dimension(14, 24));
        jtf_endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_enderecoActionPerformed(evt);
            }
        });
        jtf_endereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_enderecoKeyPressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel14.setText("Bairro*");
        jLabel14.setName("jLabel14"); // NOI18N

        jtf_bairro.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_bairro.setName("jtf_bairro"); // NOI18N
        jtf_bairro.setPreferredSize(new java.awt.Dimension(14, 24));
        jtf_bairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_bairroKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel15.setText("Complemento");
        jLabel15.setName("jLabel15"); // NOI18N

        jtf_complemento.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_complemento.setName("jtf_complemento"); // NOI18N
        jtf_complemento.setPreferredSize(new java.awt.Dimension(14, 24));
        jtf_complemento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_complementoKeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel16.setText("Email");
        jLabel16.setName("jLabel16"); // NOI18N

        jtf_email.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_email.setName("jtf_email"); // NOI18N
        jtf_email.setPreferredSize(new java.awt.Dimension(14, 24));
        jtf_email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_emailFocusGained(evt);
            }
        });
        jtf_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_emailKeyPressed(evt);
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

        jLabel20.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel20.setText("Estado*");
        jLabel20.setName("jLabel20"); // NOI18N

        jtf_estado.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_estado.setName("jtf_estado"); // NOI18N
        jtf_estado.setPreferredSize(new java.awt.Dimension(14, 24));
        jtf_estado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_estadoKeyPressed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel23.setText("Cidade*");
        jLabel23.setName("jLabel23"); // NOI18N

        jtf_cidade.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_cidade.setName("jtf_cidade"); // NOI18N
        jtf_cidade.setPreferredSize(new java.awt.Dimension(14, 24));
        jtf_cidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_cidadeActionPerformed(evt);
            }
        });
        jtf_cidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_cidadeKeyPressed(evt);
            }
        });

        jtf_data_nascimento.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_data_nascimento.setName("jtf_data_nascimento"); // NOI18N
        jtf_data_nascimento.setPreferredSize(new java.awt.Dimension(14, 24));
        jtf_data_nascimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_data_nascimentoFocusLost(evt);
            }
        });
        jtf_data_nascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_data_nascimentoKeyPressed(evt);
            }
        });

        jtf_cpf_cliente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_cpf_cliente.setName("jtf_cpf_cliente"); // NOI18N
        jtf_cpf_cliente.setPreferredSize(new java.awt.Dimension(14, 24));
        jtf_cpf_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_cpf_clienteActionPerformed(evt);
            }
        });
        jtf_cpf_cliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_cpf_clienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_cpf_clienteFocusLost(evt);
            }
        });
        jtf_cpf_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_cpf_clienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_cpf_clienteKeyReleased(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel21.setText("Telefone*");
        jLabel21.setName("jLabel21"); // NOI18N

        jtf_telefone.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_telefone.setName("jtf_telefone"); // NOI18N
        jtf_telefone.setPreferredSize(new java.awt.Dimension(14, 24));
        jtf_telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_telefoneActionPerformed(evt);
            }
        });
        jtf_telefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_telefoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_telefoneFocusLost(evt);
            }
        });
        jtf_telefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_telefoneKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_telefoneKeyReleased(evt);
            }
        });

        jb_adicionar_telefone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/adicionar_item.png"))); // NOI18N
        jb_adicionar_telefone.setToolTipText("Incluir");
        jb_adicionar_telefone.setName("jb_adicionar_telefone"); // NOI18N
        jb_adicionar_telefone.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_adicionar_telefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_adicionar_telefoneMouseClicked(evt);
            }
        });
        jb_adicionar_telefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_adicionar_telefoneKeyPressed(evt);
            }
        });

        jb_eliminar_telefone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/remove_item.png"))); // NOI18N
        jb_eliminar_telefone.setToolTipText("Excluir");
        jb_eliminar_telefone.setName("jb_eliminar_telefone"); // NOI18N
        jb_eliminar_telefone.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_eliminar_telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_eliminar_telefoneActionPerformed(evt);
            }
        });
        jb_eliminar_telefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_eliminar_telefoneKeyPressed(evt);
            }
        });

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        jtbl_telefone.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jtbl_telefone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_telefone.setName("jtbl_telefone"); // NOI18N
        jtbl_telefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_telefoneKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(jtbl_telefone);

        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel17.setText("Observação");
        jLabel17.setName("jLabel17"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jta_observacao.setColumns(20);
        jta_observacao.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jta_observacao.setRows(5);
        jta_observacao.setName("jta_observacao"); // NOI18N
        jta_observacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jta_observacaoKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jta_observacao);

        jLabel18.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel18.setText("Data Cadastro*");
        jLabel18.setName("jLabel18"); // NOI18N

        jtf_data_cadastro.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_data_cadastro.setName("jtf_data_cadastro"); // NOI18N
        jtf_data_cadastro.setPreferredSize(new java.awt.Dimension(80, 29));
        jtf_data_cadastro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_data_cadastroFocusLost(evt);
            }
        });
        jtf_data_cadastro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_data_cadastroKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jtf_data_nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jtf_cpf_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(0, 247, Short.MAX_VALUE))
                            .addComponent(jtf_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jtf_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jb_adicionar_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jb_eliminar_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel17)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jScrollPane2))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jrb_ativo)
                        .addGap(0, 0, 0)
                        .addComponent(jrb_inativo))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jtf_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jtf_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jtf_profissao, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jtf_empresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jtf_codigo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtf_data_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jtf_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(355, 355, 355))
                            .addComponent(jtf_complemento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jrb_inativo)
                        .addComponent(jrb_ativo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(jLabel1)))
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_codigo_cliente)
                    .addComponent(jtf_data_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, 0)
                        .addComponent(jtf_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel6))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jtf_cpf_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtf_data_nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, 0)
                        .addComponent(jtf_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel15)))
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtf_bairro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_complemento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_endereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20)
                                .addComponent(jLabel11)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtf_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtf_profissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtf_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, 0)
                        .addComponent(jtf_empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jb_eliminar_telefone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                .addComponent(jb_adicionar_telefone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jtf_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jtf_estado, jtf_profissao});

        jtp_cliente.addTab("Cliente Titular", jPanel3);

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel2FocusGained(evt);
            }
        });

        jb_adicionar_dependente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/adicionar_item.png"))); // NOI18N
        jb_adicionar_dependente.setToolTipText("Incluir");
        jb_adicionar_dependente.setName("jb_adicionar_dependente"); // NOI18N
        jb_adicionar_dependente.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_adicionar_dependente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_adicionar_dependenteMouseClicked(evt);
            }
        });
        jb_adicionar_dependente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_adicionar_dependenteActionPerformed(evt);
            }
        });
        jb_adicionar_dependente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_adicionar_dependenteKeyPressed(evt);
            }
        });

        jb_eliminar_dependente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/remove_item.png"))); // NOI18N
        jb_eliminar_dependente.setToolTipText("Excluir");
        jb_eliminar_dependente.setName("jb_eliminar_dependente"); // NOI18N
        jb_eliminar_dependente.setPreferredSize(new java.awt.Dimension(24, 24));
        jb_eliminar_dependente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb_eliminar_dependenteMouseClicked(evt);
            }
        });
        jb_eliminar_dependente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_eliminar_dependenteActionPerformed(evt);
            }
        });
        jb_eliminar_dependente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_eliminar_dependenteKeyPressed(evt);
            }
        });

        buttonGroup2.add(jrb_ativo_dependente);
        jrb_ativo_dependente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_ativo_dependente.setSelected(true);
        jrb_ativo_dependente.setText("Ativo");
        jrb_ativo_dependente.setName("jrb_ativo_dependente"); // NOI18N
        jrb_ativo_dependente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_ativo_dependenteActionPerformed(evt);
            }
        });
        jrb_ativo_dependente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jrb_ativo_dependenteKeyPressed(evt);
            }
        });

        buttonGroup2.add(jrb_inativo_dependente);
        jrb_inativo_dependente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jrb_inativo_dependente.setText("Inativo");
        jrb_inativo_dependente.setName("jrb_inativo_dependente"); // NOI18N
        jrb_inativo_dependente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_inativo_dependenteActionPerformed(evt);
            }
        });
        jrb_inativo_dependente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jrb_inativo_dependenteKeyPressed(evt);
            }
        });

        jScrollPane5.setName("jScrollPane5"); // NOI18N

        jtbl_dependente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_dependente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Data Nascimento", "Telefone", "Parentesco", "CPF", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
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
        jtbl_dependente.setName("jtbl_dependente"); // NOI18N
        jtbl_dependente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_dependenteMouseClicked(evt);
            }
        });
        jtbl_dependente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_dependenteKeyPressed(evt);
            }
        });
        jScrollPane5.setViewportView(jtbl_dependente);
        if (jtbl_dependente.getColumnModel().getColumnCount() > 0) {
            jtbl_dependente.getColumnModel().getColumn(0).setPreferredWidth(150);
            jtbl_dependente.getColumnModel().getColumn(1).setPreferredWidth(20);
            jtbl_dependente.getColumnModel().getColumn(2).setPreferredWidth(20);
            jtbl_dependente.getColumnModel().getColumn(3).setPreferredWidth(40);
            jtbl_dependente.getColumnModel().getColumn(4).setPreferredWidth(50);
            jtbl_dependente.getColumnModel().getColumn(5).setPreferredWidth(10);
        }

        jtf_cpf_dependente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_cpf_dependente.setName("jtf_cpf_dependente"); // NOI18N
        jtf_cpf_dependente.setPreferredSize(new java.awt.Dimension(0, 24));
        jtf_cpf_dependente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_cpf_dependenteActionPerformed(evt);
            }
        });
        jtf_cpf_dependente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtf_cpf_dependenteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_cpf_dependenteFocusLost(evt);
            }
        });
        jtf_cpf_dependente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_cpf_dependenteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_cpf_dependenteKeyReleased(evt);
            }
        });

        jcb_parentesco.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jcb_parentesco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Esposa", "Esposo", "Filho", "Filha", "Neta", "Neto", "Pai", "Mãe", "Irmão", "Irmã", "Sobrinho", "Sobrinha", "Avô", "Avó", "Tio", "Tia", "Namorada", "Namorado", "Noiva", "Noivo", "Cunhado", "Cunhada", "Primo", "Prima", "Amigo", "Amiga", "Outro" }));
        jcb_parentesco.setName("jcb_parentesco"); // NOI18N
        jcb_parentesco.setPreferredSize(new java.awt.Dimension(0, 24));
        jcb_parentesco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_parentescoActionPerformed(evt);
            }
        });
        jcb_parentesco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jcb_parentescoFocusGained(evt);
            }
        });
        jcb_parentesco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcb_parentescoKeyPressed(evt);
            }
        });

        jtf_telefone_dependente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_telefone_dependente.setName("jtf_telefone_dependente"); // NOI18N
        jtf_telefone_dependente.setPreferredSize(new java.awt.Dimension(0, 24));
        jtf_telefone_dependente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_telefone_dependenteFocusLost(evt);
            }
        });
        jtf_telefone_dependente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_telefone_dependenteKeyPressed(evt);
            }
        });

        jtf_nome_dependente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_nome_dependente.setName("jtf_nome_dependente"); // NOI18N
        jtf_nome_dependente.setPreferredSize(new java.awt.Dimension(0, 24));
        jtf_nome_dependente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_nome_dependenteActionPerformed(evt);
            }
        });
        jtf_nome_dependente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_nome_dependenteFocusLost(evt);
            }
        });
        jtf_nome_dependente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_nome_dependenteKeyPressed(evt);
            }
        });

        jtf_data_nascimento_dependente.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtf_data_nascimento_dependente.setName("jtf_data_nascimento_dependente"); // NOI18N
        jtf_data_nascimento_dependente.setPreferredSize(new java.awt.Dimension(0, 24));
        jtf_data_nascimento_dependente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_data_nascimento_dependenteFocusLost(evt);
            }
        });
        jtf_data_nascimento_dependente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtf_data_nascimento_dependenteKeyPressed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel24.setText("Parentesco*");
        jLabel24.setName("jLabel24"); // NOI18N

        jLabel25.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel25.setText("Telefone*");
        jLabel25.setName("jLabel25"); // NOI18N

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel5.setText("CPF");
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel4.setText("Data Nasc.");
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel22.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jLabel22.setText("Nome*");
        jLabel22.setName("jLabel22"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jtf_nome_dependente, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jtf_data_nascimento_dependente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jtf_telefone_dependente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jcb_parentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jtf_cpf_dependente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jb_adicionar_dependente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jb_eliminar_dependente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jrb_ativo_dependente)
                .addGap(0, 0, 0)
                .addComponent(jrb_inativo_dependente))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrb_ativo_dependente)
                    .addComponent(jrb_inativo_dependente))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jb_adicionar_dependente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jb_eliminar_dependente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel4))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_data_nascimento_dependente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_nome_dependente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(0, 0, 0)
                        .addComponent(jtf_telefone_dependente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(3, 3, 3)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcb_parentesco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtf_cpf_dependente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jtp_cliente.addTab("Dependentes", jPanel2);

        jPanel1.setName("jPanel1"); // NOI18N

        jScrollPane6.setName("jScrollPane6"); // NOI18N

        jtbl_pacotes_adquiridos.setFont(new java.awt.Font("Helvetica Neue", 0, 13)); // NOI18N
        jtbl_pacotes_adquiridos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Qtd. Troca", "Preço", "Data Aquisição", "Dias Corridos", "Dias Combo", "Dias Restante", "Trocas Efetuadas", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbl_pacotes_adquiridos.setName("jtbl_pacotes_adquiridos"); // NOI18N
        jtbl_pacotes_adquiridos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_pacotes_adquiridosMouseClicked(evt);
            }
        });
        jtbl_pacotes_adquiridos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbl_pacotes_adquiridosKeyPressed(evt);
            }
        });
        jScrollPane6.setViewportView(jtbl_pacotes_adquiridos);
        if (jtbl_pacotes_adquiridos.getColumnModel().getColumnCount() > 0) {
            jtbl_pacotes_adquiridos.getColumnModel().getColumn(0).setPreferredWidth(130);
            jtbl_pacotes_adquiridos.getColumnModel().getColumn(1).setPreferredWidth(20);
            jtbl_pacotes_adquiridos.getColumnModel().getColumn(2).setPreferredWidth(20);
            jtbl_pacotes_adquiridos.getColumnModel().getColumn(3).setPreferredWidth(10);
            jtbl_pacotes_adquiridos.getColumnModel().getColumn(4).setPreferredWidth(20);
            jtbl_pacotes_adquiridos.getColumnModel().getColumn(5).setPreferredWidth(20);
            jtbl_pacotes_adquiridos.getColumnModel().getColumn(6).setPreferredWidth(20);
            jtbl_pacotes_adquiridos.getColumnModel().getColumn(7).setPreferredWidth(20);
            jtbl_pacotes_adquiridos.getColumnModel().getColumn(8).setPreferredWidth(20);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
        );

        jtp_cliente.addTab("Combos Adquiridos", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jb_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtp_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jb_cancelar, jb_salvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jtp_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jtf_nome_cliente.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        retornaJanelaPai();
    }//GEN-LAST:event_formWindowClosed

    private void jb_salvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_salvarKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_salvar.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed


    private void jb_cancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_cancelarKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_cancelarKeyPressed

    private void jb_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salvarActionPerformed
        cadastrarAlterarCliente();
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_salvarActionPerformed

    private void jtp_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtp_clienteMouseClicked
        jtf_nome_dependente.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jtp_clienteMouseClicked

    private void jtbl_pacotes_adquiridosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_pacotes_adquiridosKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_pacotes_adquiridosKeyPressed

    private void jtbl_pacotes_adquiridosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_pacotes_adquiridosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_pacotes_adquiridosMouseClicked

    private void jPanel2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel2FocusGained
        jtf_nome_dependente.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2FocusGained

    private void jtf_data_nascimento_dependenteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_data_nascimento_dependenteKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_telefone_dependente.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_nascimento_dependenteKeyPressed

    private void jtf_data_nascimento_dependenteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_nascimento_dependenteFocusLost
        try {
            Data data = new Data();
            int idade;

            if (jtf_data_nascimento_dependente.getText().trim().length() < 10) {
                jtf_data_nascimento_dependente.setForeground(Color.red);                
            } else if (jtf_data_nascimento_dependente.getText().equals("  /  /    ")) {
                jtf_data_nascimento_dependente.setForeground(Color.red);                
            } else {
                if (validaData(jtf_data_nascimento_dependente.getText())) {
                    jtf_data_nascimento_dependente.setForeground(Color.black);
                } else {
                    jtf_data_nascimento_dependente.setForeground(Color.red);                    
                }

            }
        } catch (ParseException ex) {
            jtf_data_nascimento_dependente.setForeground(Color.red);
        } catch (NumberFormatException ex) {
            jtf_data_nascimento_dependente.setText("  /  /    ");
            jtf_data_nascimento_dependente.setForeground(Color.red);
        }
    }//GEN-LAST:event_jtf_data_nascimento_dependenteFocusLost

    private void jtf_nome_dependenteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_dependenteKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_data_nascimento_dependente.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nome_dependenteKeyPressed

    private void jtf_nome_dependenteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_nome_dependenteFocusLost

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nome_dependenteFocusLost

    private void jtf_nome_dependenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_nome_dependenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nome_dependenteActionPerformed

    private void jtf_telefone_dependenteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_telefone_dependenteKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jcb_parentesco.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_telefone_dependenteKeyPressed

    private void jtf_telefone_dependenteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_telefone_dependenteFocusLost
        System.out.println(jtf_telefone_dependente.getText().trim().length());
        if (jtf_telefone_dependente.getText().trim().length() != 14) {
            jtf_telefone_dependente.setForeground(Color.red);            
        } else {
            jtf_telefone_dependente.setForeground(Color.black);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_telefone_dependenteFocusLost

    private void jcb_parentescoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_parentescoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_cpf_dependente.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_parentescoKeyPressed

    private void jcb_parentescoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcb_parentescoFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_parentescoFocusGained

    private void jcb_parentescoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_parentescoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_parentescoActionPerformed

    private void jtf_cpf_dependenteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_cpf_dependenteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_cpf_dependenteKeyReleased

    private void jtf_cpf_dependenteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_cpf_dependenteKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_adicionar_dependente.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_cpf_dependenteKeyPressed

    private void jtf_cpf_dependenteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_cpf_dependenteFocusLost
        try {
            if (jtf_cpf_dependente.getText().trim().length() == 14) {
                if (ValidaCPF.isCPF(jtf_cpf_dependente.getText()) == true) {
                    if (verificaCadastroDependente(jtf_cpf_dependente.getText().trim()) == true) {
                        jtf_cpf_dependente.setForeground(Color.black);
                    } else {
                        jtf_cpf_dependente.setForeground(Color.red);
                    }
                } else {
                    jtf_cpf_dependente.setForeground(Color.red);
                }
            } else {
                jtf_cpf_dependente.setForeground(Color.red);
            }
        } catch (Exception e) {
            jtf_cpf_dependente.setForeground(Color.red);
        }
    }//GEN-LAST:event_jtf_cpf_dependenteFocusLost

    private void jtf_cpf_dependenteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_cpf_dependenteFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_cpf_dependenteFocusGained

    private void jtf_cpf_dependenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_cpf_dependenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_cpf_dependenteActionPerformed

    private void jtbl_dependenteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_dependenteKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            jb_eliminar_dependente.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_dependenteKeyPressed

    private void jtbl_dependenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_dependenteMouseClicked
        if (evt.getClickCount() > 1) {
            alteraDependente();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_dependenteMouseClicked

    private void jrb_inativo_dependenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_inativo_dependenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_inativo_dependenteActionPerformed

    private void jrb_ativo_dependenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_ativo_dependenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_ativo_dependenteActionPerformed

    private void jb_eliminar_dependenteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_eliminar_dependenteKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (action.equals("salvar")) {
                removeDependente(jtbl_dependente);
            } else if (action.equals("alterar")) {
                jb_adicionar_dependente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/adicionar_item.png")));
                jb_eliminar_dependente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/remove_item.png"))); // NOI18N

                jtf_nome_dependente.setText("");
                jtf_nome_dependente.requestFocus();
                jtf_data_nascimento_dependente.setText("");
                jtf_cpf_dependente.setText("");
                jtf_telefone_dependente.setText("");
                jcb_parentesco.setSelectedIndex(0);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_eliminar_dependenteKeyPressed

    private void jb_eliminar_dependenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_eliminar_dependenteActionPerformed
        removeDependente(jtbl_dependente);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_eliminar_dependenteActionPerformed

    private void jb_eliminar_dependenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_eliminar_dependenteMouseClicked
        if (evt.getClickCount() == 1) {
            if (action.equals("salvar")) {
                removeDependente(jtbl_dependente);
            } else if (action.equals("alterar")) {
                jb_adicionar_dependente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_add.png")));
                jb_eliminar_dependente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/edit_remove.png"))); // NOI18N

                jtf_nome_dependente.setText("");
                jtf_nome_dependente.requestFocus();
                jtf_data_nascimento_dependente.setText("");
                jtf_cpf_dependente.setText("");
                jtf_telefone_dependente.setText("");
                jcb_parentesco.setSelectedIndex(0);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_eliminar_dependenteMouseClicked

    private void jb_adicionar_dependenteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_adicionar_dependenteKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            adicionarDependente();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_dependenteKeyPressed

    private void jb_adicionar_dependenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_adicionar_dependenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_dependenteActionPerformed

    private void jb_adicionar_dependenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_adicionar_dependenteMouseClicked
        if (evt.getClickCount() == 1) {
            adicionarDependente();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_dependenteMouseClicked

    private void jta_observacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jta_observacaoKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jta_observacaoKeyPressed

    private void jtbl_telefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbl_telefoneKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            removeTelefone(jtbl_telefone);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jtbl_telefoneKeyPressed

    private void jb_eliminar_telefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_eliminar_telefoneKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            jb_eliminar_telefone.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_eliminar_telefoneKeyPressed

    private void jb_eliminar_telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_eliminar_telefoneActionPerformed
        removeTelefone(jtbl_telefone);
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_eliminar_telefoneActionPerformed

    private void jb_adicionar_telefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_adicionar_telefoneKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            alimentarTelefone();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_telefoneKeyPressed

    private void jb_adicionar_telefoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_adicionar_telefoneMouseClicked
        if (evt.getClickCount() == 1) {
            alimentarTelefone();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_adicionar_telefoneMouseClicked

    private void jtf_telefoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_telefoneKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_telefoneKeyReleased

    private void jtf_telefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_telefoneKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_adicionar_telefone.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_telefoneKeyPressed

    private void jtf_telefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_telefoneFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_telefoneFocusLost

    private void jtf_telefoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_telefoneFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_telefoneFocusGained

    private void jtf_telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_telefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_telefoneActionPerformed

    private void jtf_cpf_clienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_cpf_clienteKeyReleased

    }//GEN-LAST:event_jtf_cpf_clienteKeyReleased

    private void jtf_cpf_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_cpf_clienteKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_email.requestFocus();
        }
    }//GEN-LAST:event_jtf_cpf_clienteKeyPressed

    private void jtf_cpf_clienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_cpf_clienteFocusLost
        try {

            ValidaCPF valida = new ValidaCPF();
            if (jtf_cpf_cliente.getText().trim().length() == 14) {
                if (valida.isCPF(jtf_cpf_cliente.getText()) == true) {
                    if (verificaCadastro(jtf_cpf_cliente.getText()) == true) {
                        jtf_cpf_cliente.setForeground(Color.black);
                    } else {
                        jtf_cpf_cliente.setForeground(Color.red);                        
                    }
                } else {
                    jtf_cpf_cliente.setForeground(Color.red);                    
                }
            } else {
                jtf_cpf_cliente.setForeground(Color.red);                
            }
        } catch (Exception e) {
            jtf_cpf_cliente.setForeground(Color.red);            
        }
    }//GEN-LAST:event_jtf_cpf_clienteFocusLost

    private void jtf_cpf_clienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_cpf_clienteFocusGained

    }//GEN-LAST:event_jtf_cpf_clienteFocusGained

    private void jtf_cpf_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_cpf_clienteActionPerformed

    }//GEN-LAST:event_jtf_cpf_clienteActionPerformed

    private void jtf_data_nascimentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_data_nascimentoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_cpf_cliente.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_nascimentoKeyPressed

    private void jtf_data_nascimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_nascimentoFocusLost
        try {
            Data data = new Data();
            int idade;

            if (jtf_data_nascimento.getText().trim().length() < 10) {
                jtf_data_nascimento.setForeground(Color.red);
            } else if (jtf_data_nascimento.getText().equals("  /  /    ")) {
                jtf_data_nascimento.setForeground(Color.red);
            } else {
                if (validaData(jtf_data_nascimento.getText())) {
                    idade = data.calcularIdade(new SimpleDateFormat("dd/MM/yyyy").parse((String) jtf_data_nascimento.getText()));
                    if (idade < 18) {
                        int selectedOption = JOptionPane.showConfirmDialog(this, "Cliente menor de Idade, Desejar continuar?", "Atenção", JOptionPane.YES_NO_OPTION);
                        if (selectedOption == JOptionPane.YES_NO_OPTION) {
                            jtf_data_nascimento.setForeground(Color.black);
                        } else {
                            jtf_data_nascimento.setForeground(Color.red);
                        }
                    } else {
                        jtf_data_nascimento.setForeground(Color.black);
                    }
                } else {
                    jtf_data_nascimento.setForeground(Color.red);
                }

            }
        } catch (ParseException ex) {
            jtf_data_nascimento.setForeground(Color.red);
        } catch (NumberFormatException ex) {
            jtf_data_nascimento.setText("  /  /    ");
            jtf_data_nascimento.setForeground(Color.red);
        }
    }//GEN-LAST:event_jtf_data_nascimentoFocusLost

    private void jtf_cidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_cidadeKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_estado.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_cidadeKeyPressed

    private void jtf_cidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_cidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_cidadeActionPerformed

    private void jtf_estadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_estadoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_profissao.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_estadoKeyPressed

    private void jrb_ativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_ativoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_ativoActionPerformed

    private void jtf_emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_emailKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_endereco.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_emailKeyPressed

    private void jtf_emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_emailFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_emailFocusGained

    private void jtf_complementoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_complementoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_cidade.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_complementoKeyPressed

    private void jtf_bairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_bairroKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_complemento.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_bairroKeyPressed

    private void jtf_enderecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_enderecoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_bairro.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_enderecoKeyPressed

    private void jtf_enderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_enderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_enderecoActionPerformed

    private void jtf_profissaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_profissaoKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_empresa.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_profissaoKeyPressed

    private void jtf_profissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_profissaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_profissaoActionPerformed

    private void jtf_nome_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nome_clienteKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_data_nascimento.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nome_clienteKeyPressed

    private void jtf_nome_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_nome_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_nome_clienteActionPerformed

    private void jtf_empresaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_empresaKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_telefone.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_empresaKeyPressed

    private void jtf_empresaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_empresaFocusGained

    }//GEN-LAST:event_jtf_empresaFocusGained

    private void jtf_empresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_empresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_empresaActionPerformed

    private void jrb_ativoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jrb_ativoKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_ativoKeyPressed

    private void jrb_inativoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jrb_inativoKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_inativoKeyPressed

    private void jrb_ativo_dependenteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jrb_ativo_dependenteKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_ativo_dependenteKeyPressed

    private void jrb_inativo_dependenteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jrb_inativo_dependenteKeyPressed
        acionarAtalho(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb_inativo_dependenteKeyPressed

    private void jtf_data_cadastroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_data_cadastroFocusLost
                try {
            
            if (jtf_data_cadastro.getText().trim().length() < 10) {
                jtf_data_cadastro.setForeground(Color.red);
            } else if (jtf_data_cadastro.getText().equals("  /  /    ")) {
                jtf_data_cadastro.setForeground(Color.red);
            } else {
                if (validaDataCadastro(jtf_data_cadastro.getText())) {                    
                    jtf_data_cadastro.setForeground(Color.black);                    
                } else {
                    jtf_data_cadastro.setForeground(Color.red);
                }
            }
        } catch (ParseException ex) {
            jtf_data_cadastro.setForeground(Color.red);
        } catch (NumberFormatException ex) {
            jtf_data_cadastro.setText("  /  /    ");
            jtf_data_cadastro.setForeground(Color.red);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_cadastroFocusLost

    private void jtf_data_cadastroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_data_cadastroKeyPressed
        acionarAtalho(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jtf_nome_cliente.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_data_cadastroKeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CadastraAlteraCliente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton jb_adicionar_dependente;
    private javax.swing.JButton jb_adicionar_telefone;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_eliminar_dependente;
    private javax.swing.JButton jb_eliminar_telefone;
    private javax.swing.JButton jb_salvar;
    private javax.swing.JComboBox jcb_parentesco;
    public static javax.swing.JRadioButton jrb_ativo;
    public static javax.swing.JRadioButton jrb_ativo_dependente;
    public static javax.swing.JRadioButton jrb_inativo;
    public static javax.swing.JRadioButton jrb_inativo_dependente;
    public static javax.swing.JTextArea jta_observacao;
    public static javax.swing.JTable jtbl_dependente;
    public static javax.swing.JTable jtbl_pacotes_adquiridos;
    public static javax.swing.JTable jtbl_telefone;
    public static javax.swing.JTextField jtf_bairro;
    public static javax.swing.JTextField jtf_cidade;
    public static javax.swing.JTextField jtf_codigo_cliente;
    public static javax.swing.JTextField jtf_complemento;
    public static javax.swing.JFormattedTextField jtf_cpf_cliente;
    public static javax.swing.JFormattedTextField jtf_cpf_dependente;
    public static javax.swing.JFormattedTextField jtf_data_cadastro;
    public static javax.swing.JFormattedTextField jtf_data_nascimento;
    public static javax.swing.JFormattedTextField jtf_data_nascimento_dependente;
    public static javax.swing.JTextField jtf_email;
    public static javax.swing.JTextField jtf_empresa;
    public static javax.swing.JTextField jtf_endereco;
    public static javax.swing.JTextField jtf_estado;
    public static javax.swing.JTextField jtf_nome_cliente;
    public static javax.swing.JTextField jtf_nome_dependente;
    public static javax.swing.JTextField jtf_profissao;
    public static javax.swing.JFormattedTextField jtf_telefone;
    public static javax.swing.JFormattedTextField jtf_telefone_dependente;
    private javax.swing.JTabbedPane jtp_cliente;
    private javax.swing.JTextArea tfa_similar;
    // End of variables declaration//GEN-END:variables

    public boolean verificaCadastro(String cpf) {
        if (cpf.equals("")) {
        } else {
            pool = new Pool();
            ClienteDAO clienteDAO = new ClienteDAO(pool);
            cliente = null;

            if (jtf_codigo_cliente.getText().equals("")) {
                cliente = clienteDAO.getCliente_cpf(cpf);
                if (null == cliente) {
                    return true;
                } else {
                    //            jtf_cpf_cliente.requestFocus();
                    JOptionPane.showMessageDialog(null, "CPF já existente");
                    return false;
                }
            } else {
                cliente = clienteDAO.getCliente_cpf(cpf, Integer.parseInt(jtf_codigo_cliente.getText()));
                if (null != cliente) {
                    return true;
                } else {
                    pool = new Pool();
                    clienteDAO = new ClienteDAO(pool);
                    cliente = null;
                    cliente = clienteDAO.getCliente_cpf(cpf);
                    if (null == cliente) {
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "CPF já existente");
                        return false;
                    }
                }

            }

        }
        return false;
    }

    public boolean verificaCadastroDependente(String cpf) {
        pool = new Pool();
        ClienteDAO clienteDAO = new ClienteDAO(pool);
        cliente = null;
        cliente = clienteDAO.getCliente_cpf(cpf);
        if (null == cliente) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "CPF já existente");
            return false;
        }
    }

    public boolean verificarCampos() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_nome_cliente.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Nome\n";
        }
        if (jtf_data_nascimento.getForeground().equals(Color.red)) {
            msgERRO = msgERRO + " *Data de Nascimento\n";
        } else if (jtf_data_nascimento.getText().trim().length() < 10) {
            msgERRO = msgERRO + " *Data de Nascimento\n";
        }
        
        if (jtf_data_cadastro.getForeground().equals(Color.red)) {
            msgERRO = msgERRO + " *Data de Cadastro\n";
        } else if (jtf_data_cadastro.getText().trim().length() < 10) {
            msgERRO = msgERRO + " *Data de Cadastro\n";
        }

        if (jtf_cpf_cliente.getForeground().equals(Color.red)) {
            msgERRO = msgERRO + " *CPF\n";
        } else if (jtf_cpf_cliente.getText().trim().length() < 14) {
            msgERRO = msgERRO + " *CPF\n";
        }

        if (jtf_endereco.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Endereço\n";
        }
        if (jtf_bairro.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Bairro\n";
        }
        if (jtf_cidade.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Cidade\n";
        }
        if (jtf_estado.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Estado\n";
        }
        if (jtf_profissao.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Profissão\n";
        }
        if (jtf_empresa.getText().trim().equals("")) {
            msgERRO = msgERRO + " *Empresa\n";
        }

        if (jtbl_telefone.getRowCount() <= 0) {
            msgERRO = msgERRO + " *Informe no mínimo um telefone\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jtf_nome_cliente.requestFocus();
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

    Telefone telefone = new Telefone();

    public void alimentarTelefone() {
        if (verificar_campo_telefone(jtf_telefone.getText()) == true) { //&& (verificaTabela()

            adicionarTelefone();

            telefone.setCliente(cliente);
            telefone.setTelefone(jtf_telefone.getText());

            DefaultTableModel row = (DefaultTableModel) jtbl_telefone.getModel();
            row.addRow(new Object[]{telefone.getTelefone()});

            jtf_telefone.setText("");
            jtf_telefone.requestFocus();
        }
    }

    public boolean verificar_campo_telefone(String telefone) {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (telefone.equals("")) {
            msgERRO = msgERRO + " *Telefone\n";
        } else if (telefone.trim().length() < 14) {
            msgERRO = msgERRO + " *Telefone\n";
        }

        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            return false;
        } else {
            return true;
        }
    }

    public boolean verificar_campo_dependente() {
        String msgERRO = "Preencha os campos obrigatórios:\n";

        if (jtf_nome_dependente.getText().equals("")) {
            msgERRO = msgERRO + " *Nome Dependente\n";
        }

        if (jtf_telefone_dependente.getText().trim().length() != 14) {
            msgERRO = msgERRO + " *Telefone Dependente\n";
        }

        try {
            Data data = new Data();
            int idade;

            if (jtf_data_nascimento_dependente.getText().trim().length() != 10) {
                jtf_data_nascimento_dependente.setForeground(Color.red);
                msgERRO = msgERRO + " *Data de Nascimento inválida\n";
            } else if (jtf_data_nascimento_dependente.getText().equals("  /  /    ")) {
                jtf_data_nascimento_dependente.setForeground(Color.red);
                msgERRO = msgERRO + " *Data de Nascimento inválida\n";
            } else {
                if (validaData(jtf_data_nascimento_dependente.getText())) {
                    jtf_data_nascimento_dependente.setForeground(Color.black);
                } else {
                    jtf_data_nascimento_dependente.setForeground(Color.red);
                    msgERRO = msgERRO + " *Data de Nascimento inválida\n";
                }

            }
        } catch (ParseException ex) {
            jtf_data_nascimento_dependente.setForeground(Color.red);
            msgERRO = msgERRO + " *Data de Nascimento inválida\n";
        } catch (NumberFormatException ex) {
            jtf_data_nascimento_dependente.setText("  /  /    ");
            jtf_data_nascimento_dependente.setForeground(Color.red);
            msgERRO = msgERRO + " *Data de Nascimento inválida\n";
        }

//        if (jtf_data_nascimento_dependente.getText().trim().length() != 10) {
//            msgERRO = msgERRO + " *Data Inválida\n";
//        }
        if (!msgERRO.equals("Preencha os campos obrigatórios:\n")) {
            JOptionPane.showMessageDialog(this, msgERRO);
            jtf_nome_dependente.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void removeCliente(JTable tb) {
        if (tb != null) {
            DefaultTableModel row = (DefaultTableModel) jtbl_telefone.getModel();
            if (tb.getSelectedRow() != -1) {
                int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_NO_OPTION) {
                    row.removeRow(tb.getSelectedRow());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um produto");
            }
        }
    }

    public void carregaTelefone(Integer codigo_cliente) {
        try {
            if (codigo_cliente != null) {
                pool = new Pool();
                TelefoneDAO telefoneDAO = new TelefoneDAO(pool);
                telefones = null;
                telefones = telefoneDAO.getTelefones(codigo_cliente);
                if (telefones != null) {
                    mostrar_telefones(telefones);
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(CadastraAlteraCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregaDependente(Integer codigo_cliente) {
        try {
            if (codigo_cliente != null) {
                pool = new Pool();
                dependentes = null;
                DependenteDAO dependenteDAO = new DependenteDAO(pool);
                dependentes = dependenteDAO.getDependentes(codigo_cliente);

                mostrar_dependentes(dependentes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastraAlteraCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CadastraAlteraCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrar_telefones(List<Telefone> telefones) throws ParseException {
        DefaultTableModel tableModel = (DefaultTableModel) jtbl_telefone.getModel();
        tableModel.setNumRows(0);

        if (telefones != null) {

            for (Telefone telefone1 : telefones) {
                Telefone tel = new Telefone();
                tel.setCodigo_telefone(telefone1.getCodigo_telefone());
                tel.setTelefone(telefone1.getTelefone());
                Cliente cli = new Cliente();
                cli.setCodigo_cliente(telefone1.getCodigo_telefone());
                tel.setCliente(cli);
                DefaultTableModel row = (DefaultTableModel) jtbl_telefone.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(tel, tel.getTelefone());
                row.addRow(new Object[]{hashDbGrid});
            }
        }
    }

    public void mostrar_dependentes(List<Dependente> dependentes) throws ParseException {
        DefaultTableModel tableModel = (DefaultTableModel) jtbl_dependente.getModel();
        tableModel.setNumRows(0);

        if (dependentes != null) {

            for (Dependente dependente1 : dependentes) {
                Dependente dependente = new Dependente();
                dependente.setCodigo_dependente(dependente1.getCodigo_dependente());
                dependente.setNome_dependente(dependente1.getNome_dependente());
                dependente.setParentesco(dependente1.getParentesco());
                dependente.setTelefone(dependente1.getTelefone());
                dependente.setCPF(dependente1.getCPF());
                dependente.setStatus(dependente1.getStatus());

                SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
                String data_nascimento = out.format(in.parse(dependente1.getData_nascimento().toString()));
                Cliente cli = new Cliente();
                cli.setCodigo_cliente(dependente1.getCodigo_dependente());
                dependente.setCliente(cli);

                DefaultTableModel row = (DefaultTableModel) jtbl_dependente.getModel();
                ItemDbGrid hashDbGrid = new ItemDbGrid(dependente, dependente.getNome_dependente());
                row.addRow(new Object[]{hashDbGrid, data_nascimento, dependente.getTelefone(), dependente.getParentesco(), dependente.getCPF(), dependente.getStatus()});
            }

        }
    }

    public void removeDependente(JTable tb) {
        if (tb != null) {
            DefaultTableModel row = (DefaultTableModel) tb.getModel();

            try {
                if (tb.getSelectedRow() != -1) {
                    int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_NO_OPTION) {
                        DependenteDAO dependenteDAo = new DependenteDAO(pool);

                        if (dependenteDAo.excluir(dependentes.get(tb.getSelectedRow()).getCodigo_dependente())) {
                            row.removeRow(tb.getSelectedRow());
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um Dependente");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CadastraAlteraCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void removeTelefone(JTable tb) {
        if (tb != null) {
            DefaultTableModel row = (DefaultTableModel) tb.getModel();
            try {
                if (tb.getSelectedRow() != -1) {
                    int selectedOption = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "Atenção", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_NO_OPTION) {
                        TelefoneDAO telefoneDAO = new TelefoneDAO(pool);

                        if (telefoneDAO.excluir(telefones.get(tb.getSelectedRow()).getCodigo_telefone())) {
                            row.removeRow(tb.getSelectedRow());
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um Telefone");
                }
            } catch (SQLException ex) {
            } catch (Exception ex) {
                row.removeRow(tb.getSelectedRow());

            }
        }
    }

    public void adicionarTelefone() {
        try {
            List<Telefone> itens_telefone = new ArrayList();

            telefone = new Telefone();
            telefone.setTelefone(jtf_telefone.getText());
            itens_telefone.add(telefone);

            cliente = new Cliente();
            if (!jtf_codigo_cliente.getText().equals("")) {
                cliente.setCodigo_cliente(Integer.parseInt(jtf_codigo_cliente.getText()));

                TelefoneDAO telefoneDAO = new TelefoneDAO(pool);
                telefoneDAO.salvar(itens_telefone, cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastraAlteraCliente.class.getName()).log(Level.SEVERE, null, ex);
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

    private void adicionarDependente() {
        try {
            Dependente dependente = new Dependente();
            if (!jtf_codigo_cliente.getText().equals("")) {
                if (verificar_campo_dependente() == true) {
                    Cliente cliente = new Cliente();
                    cliente.setCodigo_cliente(Integer.parseInt(jtf_codigo_cliente.getText()));
                    dependente.setCliente(cliente);
                    dependente.setNome_dependente(jtf_nome_dependente.getText());
                    dependente.setData_nascimento(new SimpleDateFormat("dd/MM/yyyy").parse((String) jtf_data_nascimento_dependente.getText()));
                    dependente.setTelefone(jtf_telefone_dependente.getText());
                    dependente.setParentesco((String) jcb_parentesco.getSelectedItem());
                    dependente.setTipo_dependente("1");
                    if (jtf_cpf_dependente.getText().trim().length() != 14) {
                        dependente.setCPF("");
                    } else if (jtf_cpf_dependente.getForeground().equals(Color.RED)) {
                        dependente.setCPF("");
                    } else {
                        String cpf_formata = jtf_cpf_dependente.getText();  
                        cpf_formata = cpf_formata.replace( " " , ""); //tira espaço em branco  
                        cpf_formata = cpf_formata.replace( "." , ""); //tira ponto  
                        cpf_formata = cpf_formata.replace( "/" , ""); //tira barra  
                        cpf_formata = cpf_formata.replace( "-" , ""); //tira hífen  
                
                        dependente.setCPF(cpf_formata);
                    }

                    if (jrb_ativo_dependente.isSelected() == true) {
                        dependente.setStatus(true);
                    } else {
                        dependente.setStatus(false);
                    }

                    if (action.equals("salvar")) {
                        DependenteDAO dependenteDAO = new DependenteDAO(pool);
                        dependenteDAO.salvar(dependente, cliente);
                    } else if (action.equals("alterar")) {
                        dependente.setCodigo_dependente(dependenteAlterar.getCodigo_dependente());
                        DependenteDAO dependenteDAO = new DependenteDAO(pool);
                        dependenteDAO.atualizar(dependente);

                        jb_adicionar_dependente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/adicionar_item.png"))); // NOI18N                        
                        jb_eliminar_dependente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/remove_item.png"))); // NOI18N
                        action = "salvar";
                    }

                    carregaDependente(cliente.getCodigo_cliente());
                    jtf_nome_dependente.setText("");
                    jtf_nome_dependente.requestFocus();
                    jtf_data_nascimento_dependente.setText("  /  /    ");
                    jtf_cpf_dependente.setText("");
                    jtf_telefone_dependente.setText("");
                    jcb_parentesco.setSelectedIndex(0);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Salvar primeiro o Cliente");
            }
        } catch (ParseException ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
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
    
    public static boolean validaDataCadastro(String dataString) throws java.text.ParseException {

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

    public void cadastrarAlterarCliente() {
        if (verificarCampos()) {
            try {
                cliente = new Cliente();
                cliente.setUsuario(acesso.getUsuario());
                cliente.setNome_cliente(jtf_nome_cliente.getText());
                cliente.setData_nascimento(new SimpleDateFormat("dd/MM/yyyy").parse((String) jtf_data_nascimento.getText()));
                cliente.setData_cadastro(new SimpleDateFormat("dd/MM/yyyy").parse((String) jtf_data_cadastro.getText()));
                
                String cpf_formata = jtf_cpf_cliente.getText();  
                cpf_formata = cpf_formata.replace( " " , ""); //tira espaço em branco  
                cpf_formata = cpf_formata.replace( "." , ""); //tira ponto  
                cpf_formata = cpf_formata.replace( "/" , ""); //tira barra  
                cpf_formata = cpf_formata.replace( "-" , ""); //tira hífen  
                
                cliente.setCpf(cpf_formata);
                cliente.setNome_empresa_trabalho(jtf_empresa.getText());
                cliente.setProfissao(jtf_profissao.getText());
                cliente.setEndereco(jtf_endereco.getText());
                cliente.setBairro(jtf_bairro.getText());
                cliente.setComplemento(jtf_complemento.getText());
                cliente.setCidade(jtf_cidade.getText());
                cliente.setEstado(jtf_estado.getText());
                cliente.setEmail(jtf_email.getText());
                cliente.setObservacao(jta_observacao.getText());
                if (jrb_ativo.isSelected() == true) {
                    cliente.setStatus(true);

                } else {
                    cliente.setStatus(false);
                }
                
                if (jtf_codigo_cliente.getText().equals("")) {
                    LogInfo logInfo = new LogInfo();
                    logInfo.setDescricao("Novo Cliente: "+jtf_nome_cliente.getText());
                    logInfo.setUsuario(acesso.getUsuario());
                    pool = new Pool();
                    LogInfoDAO logInfoDAO = new LogInfoDAO(pool);
                    logInfoDAO.salvar(logInfo);
                    
                    pool = new Pool();
                    clienteDAO = new ClienteDAO(pool);
                    cliente = clienteDAO.salvar(cliente);
                    jtf_codigo_cliente.setText(cliente.getCodigo_cliente().toString());
                    JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

                    pool = new Pool();
                    DependenteDAO dependenteDAO = new DependenteDAO(pool);
                    Dependente dependente = new Dependente();
                    dependente.setNome_dependente(cliente.getNome_cliente());
                    dependente.setData_nascimento(cliente.getData_nascimento());
                    dependente.setTipo_dependente("0");
                    if (jrb_ativo.isSelected() == true) {
                        dependente.setStatus(true);
                    } else {
                        dependente.setStatus(false);
                    }
                    dependenteDAO.salvar(dependente, cliente);

                    List<Telefone> itens_telefone = new ArrayList();
                    for (int i = 0; i < jtbl_telefone.getRowCount(); i++) {
                        Telefone telefone = new Telefone();
                        telefone.setTelefone((String) jtbl_telefone.getValueAt(i, 0));
                        itens_telefone.add(telefone);
                    }
                    pool = new Pool();
                    telefoneDAO = new TelefoneDAO(pool);
                    telefoneDAO.salvar(itens_telefone, cliente);
                } else {
                    LogInfo logInfo = new LogInfo();
                    logInfo.setDescricao("Alterar Cliente -> "+cliente.getNome_cliente() + " -> " + jtf_nome_cliente.getText());
                    logInfo.setUsuario(acesso.getUsuario());
                    pool = new Pool();
                    LogInfoDAO logInfoDAO = new LogInfoDAO(pool);
                    logInfoDAO.salvar(logInfo);

                    cliente.setCodigo_cliente(Integer.parseInt(jtf_codigo_cliente.getText()));

                    pool = new Pool();
                    clienteDAO = new ClienteDAO(pool);
                    clienteDAO.atualizar(cliente);
                    JOptionPane.showMessageDialog(null, "Atualizado com sucesso.");

                    jtp_cliente.setSelectedIndex(1);
                    jtf_nome_dependente.requestFocus();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage() + "Problemas com a gravação: ");

                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido: " + e.getMessage());

                e.printStackTrace();
            } catch (ParseException ex) {

            }

            jtp_cliente.setSelectedIndex(1);
            jtf_nome_dependente.requestFocus();
        }
    }

    private void retornaJanelaPai() {
        setVisible(false);
        if (janelapai != null) {
            janelapai.setStatusTela(true);
            janelapai.cadastraAlteraCliente = null;
            janelapai.consultarCliente();
        } else if (janelapai2 != null) {
            janelapai2.setStatusTela(true);
            janelapai2.cadastraAlteraCliente = null;
        } else if (janelapai3 != null) {
            janelapai3.setStatusTela(true);
            janelapai3.cadastraAlteraCliente = null;
        } else if (janelapai4 != null) {
            janelapai4.setStatusTela(true);
            janelapai4.cadastraAlteraCliente = null;
        }
    }

    public void alteraDependente() {
        if (jtbl_dependente.getRowCount() != -1) {
            dependenteAlterar = dependentes.get(jtbl_dependente.getSelectedRow());
            jtf_nome_dependente.setText(dependentes.get(jtbl_dependente.getSelectedRow()).getNome_dependente());

            SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
            String data_nascimento = null;
            try {
                data_nascimento = out.format(in.parse(dependentes.get(jtbl_dependente.getSelectedRow()).getData_nascimento().toString()));
            } catch (ParseException ex) {
//                Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            jtf_data_nascimento_dependente.setText(data_nascimento);
            jtf_telefone_dependente.setText(dependentes.get(jtbl_dependente.getSelectedRow()).getTelefone());
            if (dependentes.get(jtbl_dependente.getSelectedRow()).getStatus() == true) {
                jrb_ativo_dependente.setSelected(true);
            } else {
                jrb_inativo_dependente.setSelected(true);
            }

            for (int i = 0; i < jcb_parentesco.getItemCount(); i++) {
                if (jcb_parentesco.getItemAt(i).toString().equals(dependentes.get(jtbl_dependente.getSelectedRow()).getParentesco())) {
                    jcb_parentesco.setSelectedIndex(i);
                    break;
                }
            }
            jtf_cpf_dependente.setText(dependentes.get(jtbl_dependente.getSelectedRow()).getCPF());

            jb_adicionar_dependente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/alterar_registro.png"))); // NOI18N
            jb_eliminar_dependente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadora/image/sair.png"))); // NOI18N
            action = "alterar";
            jtf_nome_dependente.requestFocus();
        }

    }

    public void consultarCombosAdquiridos(Integer codigo_cliente) {
        if (!jtf_codigo_cliente.getText().equals("")) {
            pool = new Pool();
            comboDAO = new ComboDAO(pool);
            combos = comboDAO.getPacotePromocionalCliente(codigo_cliente);
            mostrarCombosAdquiridos(combos);
        }
    }

    public void mostrarCombosAdquiridos(List<Combo> pacotesPromocionais) {
        DefaultTableModel tableModel = (DefaultTableModel) jtbl_pacotes_adquiridos.getModel();
        tableModel.setNumRows(0);

        if (pacotesPromocionais != null) {
            moeda = new Moeda();
            for (int i = 0; i < pacotesPromocionais.size(); i++) {
                System.out.println("Linhas: " + pacotesPromocionais.size());
                SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
                String data_aquisicao = null;
                try {
                    data_aquisicao = out.format(in.parse(pacotesPromocionais.get(i).getData_lancamento().toString()));
                } catch (ParseException ex) {

                }
                Boolean status;
                status = pacotesPromocionais.get(i).getDias_restantes() > 0;
                DefaultTableModel row = (DefaultTableModel) jtbl_pacotes_adquiridos.getModel();

                row.addRow(new Object[]{pacotesPromocionais.get(i).getDescricao(),
                    pacotesPromocionais.get(i).getQuantidade_troca(),
                    moeda.setPrecoFormat(pacotesPromocionais.get(i).getValor().toString()),
                    data_aquisicao,
                    pacotesPromocionais.get(i).getDias_corridos(),
                    pacotesPromocionais.get(i).getDias_combo(),
                    pacotesPromocionais.get(i).getDias_restantes(),
                    pacotesPromocionais.get(i).getQuantidade_troca_efetuada(),
                    status
                });
            }
        }
    }

}
