/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.cadastro;


import graficaatual.daos.cadastro.BairroDAO;
import graficaatual.daos.cadastro.CidadeDAO;
import graficaatual.daos.cadastro.FornecedorDAO;
import graficaatual.daos.cadastro.LogradouroDAO;
import graficaatual.daos.cadastro.PessoaDAO;
import graficaatual.entidades.Bairro;
import graficaatual.entidades.Cidade;
import graficaatual.entidades.ControleAcesso;
import graficaatual.entidades.Fornecedor;
import graficaatual.entidades.Logradouro;
import graficaatual.entidades.Pessoa;
import graficaatual.pesq.cadastro.CnvCadastroFornecedor;
import graficaatual.utilitarios.Componentes;
import graficaatual.utilitarios.Data;
import graficaatual.utilitarios.Persistencia;
import graficaatual.utilitarios.ValidarValor;
import graficaatual.utilitarios.VisualizaRelatorio;
import java.awt.Color;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author si10
 */
public class FCadFornecedor extends javax.swing.JInternalFrame {

    // Tela
    private static int initControle;
    private int localIncusao;
    private static FCadFornecedor instance;
    private static FCadFornecedor instanceCont;
    
    //Entidades 
    
    private Fornecedor fornecedor= null;
    private FornecedorDAO fornecedorDao = new FornecedorDAO();
    
    private Pessoa pessoa = null;
    private PessoaDAO pessoaDao = new PessoaDAO();
    
    private Logradouro logradouro = null;
    private LogradouroDAO logradouroDao = new LogradouroDAO();
    
    private Bairro bairro = null;
    private BairroDAO bairroDao = new BairroDAO();
    
    private Cidade cidade = null;
    private CidadeDAO cidadeDao = new CidadeDAO();
    
    
    // Lista Suspensa
    private List<Fornecedor> listaFornecedorNome = null;
    private List<Fornecedor> listaFornecedorCPF = null;
     private List<Fornecedor> listaFornecedorCPF1 = null;
    private List<Logradouro> listaLogradouroNome = null;
    private List<Bairro> listaBairroNome = null;
    private List<Cidade> listaCidadeNome = null;
    
    //Controle de Navegação
    CnvCadastroFornecedor cnvColaboradorCad = new CnvCadastroFornecedor();
            
            
    public FCadFornecedor() {
        initComponents();
        
        listaFornecedorNome = ObservableCollections.observableList(new LinkedList<Fornecedor>());
        Componentes comp1 = new Componentes(listaFornecedorNome, false, codigo, nome, this, jPanel10, nome.getWidth(), 100);
        comp1.addCol(0, "codFornecedor", " Código ", 50, Long.class.getName());
        comp1.addCol(1, "pessoa.cnpj", " CPF/CNPJ ", 100, String.class.getName());
        comp1.addCol(2, "pessoa.nome", " Nome ", 200, String.class.getName());
        comp1.bind();
        
        listaFornecedorCPF = ObservableCollections.observableList(new LinkedList<Fornecedor>());
        Componentes comp2 = new Componentes(listaFornecedorCPF, false, codigo, cnpj, this, jPanel10, cnpj.getWidth(), 100);
        comp2.addCol(0, "codFornecedor", " Código ", 50, Long.class.getName());
        comp2.addCol(1, "pessoa.cnpj", " CPF/CNPJ ", 100, String.class.getName());
        comp2.addCol(2, "pessoa.nome", " Nome ", 200, String.class.getName());
        comp2.bind();
        
        listaFornecedorCPF1 = ObservableCollections.observableList(new LinkedList<Fornecedor>());
        Componentes comp7 = new Componentes(listaFornecedorCPF1, false, codigo, cpf, this, jPanel10, cpf.getWidth(), 100);
        comp7.addCol(0, "codFornecedor", " Código ", 50, Long.class.getName());
        comp7.addCol(1, "pessoa.cnpj", " CPF/CNPJ ", 100, String.class.getName());
        comp7.addCol(2, "pessoa.nome", " Nome ", 200, String.class.getName());
        comp7.bind();
        
        listaLogradouroNome = ObservableCollections.observableList(new LinkedList<Logradouro>());
        Componentes comp4 = new Componentes(listaLogradouroNome, false, codLogradouro, descLogradouro, this, jPanel10, descLogradouro.getWidth(), 100);
        comp4.addCol(0, "codLogradouro", "Código", 50, Long.class.getName());
        comp4.addCol(1, "descricao", "Nome", 200, String.class.getName());
        comp4.bind();

        listaBairroNome = ObservableCollections.observableList(new LinkedList<Bairro>());
        Componentes comp5 = new Componentes(listaBairroNome, false, codBairro, descBairro, this, jPanel10, descBairro.getWidth(), 100);
        comp5.addCol(0, "codBairro", "Código", 50, Long.class.getName());
        comp5.addCol(1, "descricao", "Nome", 200, String.class.getName());
        comp5.bind();

        listaCidadeNome = ObservableCollections.observableList(new LinkedList<Cidade>());
        Componentes comp6 = new Componentes(listaCidadeNome, false, codCidade, descCidade, this, jPanel10, descCidade.getWidth(), 100);
        comp6.addCol(0, "codCidade", "Código", 50, Long.class.getName());
        comp6.addCol(1, "descricao", "Nome", 200, String.class.getName());
        comp6.bind();
        
        habilitaCampos(false);
        cnpj.setVisible(false);
        cpf.setVisible(true);
        atualizaTabela();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        
    }
    
    public static int isInicializado() {
        return initControle;
    }
    
     private void Finalizar() {

        if (localIncusao == 1) {
            instanceCont = null;
        } else {
            initControle = 0;
            instance = null;
        }
        dispose();
    }
     
  public synchronized static FCadFornecedor getInstance() {
        if (instance == null) {
            instance = new FCadFornecedor();
            initControle = 1;
        }
        return instance;
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        codigo = new javax.swing.JTextField();
        codLogradouro = new javax.swing.JTextField();
        descLogradouro = new javax.swing.JTextField();
        numero = new javax.swing.JTextField();
        codBairro = new javax.swing.JTextField();
        descBairro = new javax.swing.JTextField();
        complemento = new javax.swing.JTextField();
        codCidade = new javax.swing.JTextField();
        descCidade = new javax.swing.JTextField();
        cep = new javax.swing.JTextField();
        try{
            cep = new JFormattedTextField(
                new MaskFormatter("##.###-###"));
            ((JFormattedTextField) cep).setFocusLostBehavior(0);
        }catch(Exception e){}
        comboTipo = new javax.swing.JComboBox<>();
        uf = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cnpj = new javax.swing.JTextField();
        try {
            cnpj = new JFormattedTextField(
                new MaskFormatter("##.###.###/####-##"));
            ((JFormattedTextField) cnpj).setFocusLostBehavior(0);

        } catch (Exception e) {
        }
        nome = new javax.swing.JTextField();
        dataNascimento = new javax.swing.JTextField();
        try{
            dataNascimento = new JFormattedTextField(
                new MaskFormatter("##/##/####"));
            ((JFormattedTextField) dataNascimento).setFocusLostBehavior(0);
        }catch(Exception e){}
        jLabel29 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jTextField37 = new javax.swing.JTextField();
        jTextField38 = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jTextField41 = new javax.swing.JTextField();
        jTextField42 = new javax.swing.JTextField();
        jTextField43 = new javax.swing.JTextField();
        jTextField44 = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTextField46 = new javax.swing.JTextField();
        jTextField47 = new javax.swing.JTextField();
        jTextField48 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        telefone = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        obs = new javax.swing.JTextArea();
        jLabel46 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        inicio = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        proximo = new javax.swing.JButton();
        ultimo = new javax.swing.JButton();
        novo = new javax.swing.JButton();
        salvar = new javax.swing.JButton();
        inativar = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        ativo = new javax.swing.JCheckBox();
        contato = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabFornecedor = new javax.swing.JTable();
        tipoPessoa = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        inscMunicipal = new javax.swing.JTextField();
        inscEstadual = new javax.swing.JTextField();
        nomeFantasia = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cpf = new javax.swing.JTextField();
        try {
            cpf = new JFormattedTextField(
                new MaskFormatter("###.###.###-##"));
            ((JFormattedTextField) cpf).setFocusLostBehavior(0);

        } catch (Exception e) {
        }
        inativar1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Fornecedor");
        setMinimumSize(new java.awt.Dimension(1335, 750));
        setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1335, 750));
        getContentPane().setLayout(null);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setToolTipText("Cadastro de Pessoas");
        jPanel10.setMaximumSize(new java.awt.Dimension(1100, 700));
        jPanel10.setMinimumSize(new java.awt.Dimension(1100, 700));
        jPanel10.setName(""); // NOI18N
        jPanel10.setPreferredSize(new java.awt.Dimension(1100, 700));
        jPanel10.setLayout(null);

        codigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigoFocusLost(evt);
            }
        });
        jPanel10.add(codigo);
        codigo.setBounds(20, 90, 90, 20);

        codLogradouro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codLogradouroFocusLost(evt);
            }
        });
        jPanel10.add(codLogradouro);
        codLogradouro.setBounds(50, 240, 80, 20);

        descLogradouro.setBackground(new java.awt.Color(255, 255, 204));
        descLogradouro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descLogradouroKeyReleased(evt);
            }
        });
        jPanel10.add(descLogradouro);
        descLogradouro.setBounds(300, 240, 480, 20);
        jPanel10.add(numero);
        numero.setBounds(780, 240, 250, 20);

        codBairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codBairroFocusLost(evt);
            }
        });
        jPanel10.add(codBairro);
        codBairro.setBounds(50, 280, 80, 20);

        descBairro.setBackground(new java.awt.Color(255, 255, 204));
        descBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descBairroKeyReleased(evt);
            }
        });
        jPanel10.add(descBairro);
        descBairro.setBounds(130, 280, 650, 20);
        jPanel10.add(complemento);
        complemento.setBounds(780, 280, 250, 20);

        codCidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codCidadeFocusLost(evt);
            }
        });
        jPanel10.add(codCidade);
        codCidade.setBounds(50, 320, 80, 20);

        descCidade.setBackground(new java.awt.Color(255, 255, 204));
        descCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descCidadeKeyReleased(evt);
            }
        });
        jPanel10.add(descCidade);
        descCidade.setBounds(130, 320, 650, 20);
        jPanel10.add(cep);
        cep.setBounds(880, 320, 150, 20);

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rua", "Avenida", "Praça", "Travessa", "Rodovia","Quadra", "Anel Rodoviário", "Beco", "Chácara", "Comunidade", "Condomínio", "Distrito", "Estrada", "Estacionamento", "Favela", "Fazenda", "Largo", "Lagoa", "Loteamento", "Lote", "Morro", "Passagem", "Ponte","Rancho", "Sítio", "Vila"  }));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });
        jPanel10.add(comboTipo);
        comboTipo.setBounds(130, 240, 170, 20);
        jPanel10.add(uf);
        uf.setBounds(780, 320, 100, 20);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("UF ");
        jPanel10.add(jLabel23);
        jLabel23.setBounds(780, 300, 50, 20);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("CEP");
        jPanel10.add(jLabel22);
        jLabel22.setBounds(880, 300, 110, 20);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Código: ");
        jPanel10.add(jLabel13);
        jLabel13.setBounds(20, 70, 80, 20);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Observação: ");
        jPanel10.add(jLabel15);
        jLabel15.setBounds(30, 350, 100, 20);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Número");
        jPanel10.add(jLabel16);
        jLabel16.setBounds(780, 220, 110, 20);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Bairro");
        jPanel10.add(jLabel18);
        jLabel18.setBounds(130, 260, 100, 20);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Logradouro");
        jPanel10.add(jLabel19);
        jLabel19.setBounds(130, 220, 100, 20);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Complemento");
        jPanel10.add(jLabel20);
        jLabel20.setBounds(780, 260, 110, 20);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Código");
        jPanel10.add(jLabel21);
        jLabel21.setBounds(50, 220, 80, 20);

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("Tipo de Pessoa");
        jPanel10.add(jLabel28);
        jLabel28.setBounds(110, 70, 130, 20);

        cnpj.setBackground(new java.awt.Color(255, 255, 204));
        cnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cnpjKeyReleased(evt);
            }
        });
        jPanel10.add(cnpj);
        cnpj.setBounds(350, 90, 250, 20);

        nome.setBackground(new java.awt.Color(255, 255, 204));
        nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeKeyReleased(evt);
            }
        });
        jPanel10.add(nome);
        nome.setBounds(20, 130, 380, 20);
        jPanel10.add(dataNascimento);
        dataNascimento.setBounds(880, 170, 160, 20);

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("Email");
        jPanel10.add(jLabel29);
        jLabel29.setBounds(20, 150, 80, 20);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(null);
        jPanel11.add(jTextField33);
        jTextField33.setBounds(160, 10, 90, 20);

        jTextField34.setBackground(new java.awt.Color(255, 255, 204));
        jPanel11.add(jTextField34);
        jTextField34.setBounds(340, 30, 310, 20);

        jTextField35.setBackground(new java.awt.Color(255, 255, 204));
        jPanel11.add(jTextField35);
        jTextField35.setBounds(160, 50, 490, 20);
        jPanel11.add(jTextField36);
        jTextField36.setBounds(120, 160, 80, 20);
        jPanel11.add(jTextField37);
        jTextField37.setBounds(200, 160, 470, 20);
        jPanel11.add(jTextField38);
        jTextField38.setBounds(780, 160, 140, 20);
        jPanel11.add(jTextField39);
        jTextField39.setBounds(120, 180, 80, 20);
        jPanel11.add(jTextField40);
        jTextField40.setBounds(200, 180, 470, 20);
        jPanel11.add(jTextField41);
        jTextField41.setBounds(780, 180, 140, 20);
        jPanel11.add(jTextField42);
        jTextField42.setBounds(120, 200, 80, 20);
        jPanel11.add(jTextField43);
        jTextField43.setBounds(200, 200, 310, 20);
        jPanel11.add(jTextField44);
        jTextField44.setBounds(780, 200, 140, 20);
        jPanel11.add(jTextField45);
        jTextField45.setBounds(580, 200, 90, 20);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Física", "Juridica" }));
        jPanel11.add(jComboBox2);
        jComboBox2.setBounds(160, 30, 180, 18);

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("UF: ");
        jPanel11.add(jLabel31);
        jLabel31.setBounds(510, 200, 70, 20);

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("CEP: ");
        jPanel11.add(jLabel32);
        jLabel32.setBounds(670, 200, 110, 20);

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("Código: ");
        jPanel11.add(jLabel33);
        jLabel33.setBounds(80, 10, 80, 20);

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("Data Nascimento: ");
        jPanel11.add(jLabel34);
        jLabel34.setBounds(650, 70, 140, 20);

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("Número: ");
        jPanel11.add(jLabel35);
        jLabel35.setBounds(670, 160, 110, 20);

        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Insc. Estadual:");
        jPanel11.add(jLabel36);
        jLabel36.setBounds(650, 50, 140, 20);

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("Bairro: ");
        jPanel11.add(jLabel37);
        jLabel37.setBounds(20, 180, 100, 20);

        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel38.setText("Logradouro: ");
        jPanel11.add(jLabel38);
        jLabel38.setBounds(20, 160, 100, 20);

        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel39.setText("Complemento: ");
        jPanel11.add(jLabel39);
        jLabel39.setBounds(670, 180, 110, 20);

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("Cidade: ");
        jPanel11.add(jLabel40);
        jLabel40.setBounds(20, 200, 100, 20);

        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel41.setBorder(javax.swing.BorderFactory.createTitledBorder("Endeço:"));
        jPanel11.add(jLabel41);
        jLabel41.setBounds(10, 130, 920, 110);

        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel42.setText("CPF/CNPJ: ");
        jPanel11.add(jLabel42);
        jLabel42.setBounds(80, 30, 80, 20);
        jPanel11.add(jTextField46);
        jTextField46.setBounds(790, 70, 130, 20);
        jPanel11.add(jTextField47);
        jTextField47.setBounds(790, 30, 130, 20);
        jPanel11.add(jTextField48);
        jTextField48.setBounds(790, 50, 130, 20);

        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel43.setText("Nome/Razão Socia: ");
        jPanel11.add(jLabel43);
        jLabel43.setBounds(10, 50, 150, 20);

        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel44.setText("Insc. Munícipal:");
        jPanel11.add(jLabel44);
        jLabel44.setBounds(650, 30, 140, 20);

        jPanel10.add(jPanel11);
        jPanel11.setBounds(0, 0, 0, 0);
        jPanel10.add(email);
        email.setBounds(20, 170, 380, 20);
        jPanel10.add(telefone);
        telefone.setBounds(740, 170, 140, 20);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Telefone");
        jPanel10.add(jLabel9);
        jLabel9.setBounds(740, 150, 90, 20);

        obs.setColumns(20);
        obs.setLineWrap(true);
        obs.setRows(2);
        jScrollPane4.setViewportView(obs);

        jPanel10.add(jScrollPane4);
        jScrollPane4.setBounds(30, 370, 1010, 70);

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel46.setText("Data Nascimento");
        jPanel10.add(jLabel46);
        jLabel46.setBounds(880, 150, 140, 20);

        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel71.setText("Nome/Razão");
        jPanel10.add(jLabel71);
        jLabel71.setBounds(20, 110, 100, 20);

        inicio.setText("||<<");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });
        jPanel10.add(inicio);
        inicio.setBounds(390, 630, 57, 30);

        anterior.setText("<<");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });
        jPanel10.add(anterior);
        anterior.setBounds(450, 630, 49, 30);

        proximo.setText(">>");
        proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoActionPerformed(evt);
            }
        });
        jPanel10.add(proximo);
        proximo.setBounds(500, 630, 49, 30);

        ultimo.setText(">>||");
        ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ultimoActionPerformed(evt);
            }
        });
        jPanel10.add(ultimo);
        ultimo.setBounds(550, 630, 57, 30);

        novo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/NOVO2.png"))); // NOI18N
        novo.setText("Novo Cadastro");
        novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoActionPerformed(evt);
            }
        });
        jPanel10.add(novo);
        novo.setBounds(80, 450, 180, 40);

        salvar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar2.png"))); // NOI18N
        salvar.setText("Salvar/Atualizar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });
        jPanel10.add(salvar);
        salvar.setBounds(260, 450, 180, 40);

        inativar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        inativar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excuir2.png"))); // NOI18N
        inativar.setText("Inativar");
        inativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inativarActionPerformed(evt);
            }
        });
        jPanel10.add(inativar);
        inativar.setBounds(440, 450, 180, 40);

        sair.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAIR2.png"))); // NOI18N
        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        jPanel10.add(sair);
        sair.setBounds(800, 450, 180, 40);

        ativo.setBackground(new java.awt.Color(255, 0, 51));
        ativo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ativo.setForeground(new java.awt.Color(255, 255, 255));
        ativo.setText("Ativo");
        ativo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ativo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ativoStateChanged(evt);
            }
        });
        jPanel10.add(ativo);
        ativo.setBounds(600, 90, 100, 20);

        contato.setToolTipText("");
        jPanel10.add(contato);
        contato.setBounds(400, 170, 340, 20);

        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel74.setText("Contato");
        jPanel10.add(jLabel74);
        jLabel74.setBounds(400, 150, 80, 20);

        tabFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Fantasia", "Telefone", "Ativo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
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
        tabFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabFornecedorMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabFornecedor);

        jPanel10.add(jScrollPane6);
        jScrollPane6.setBounds(30, 500, 1010, 130);

        tipoPessoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Física", "Juridica" }));
        tipoPessoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoPessoaItemStateChanged(evt);
            }
        });
        jPanel10.add(tipoPessoa);
        tipoPessoa.setBounds(110, 90, 240, 20);

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Insc. Munícipal");
        jPanel10.add(jLabel30);
        jLabel30.setBounds(740, 110, 140, 20);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Insc. Estadual");
        jPanel10.add(jLabel17);
        jLabel17.setBounds(880, 110, 140, 20);
        jPanel10.add(inscMunicipal);
        inscMunicipal.setBounds(740, 130, 140, 20);
        jPanel10.add(inscEstadual);
        inscEstadual.setBounds(880, 130, 160, 20);
        jPanel10.add(nomeFantasia);
        nomeFantasia.setBounds(400, 130, 340, 20);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Nome Fantasia");
        jPanel10.add(jLabel1);
        jLabel1.setBounds(400, 110, 140, 20);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Cidade");
        jPanel10.add(jLabel24);
        jLabel24.setBounds(130, 300, 100, 20);

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Código");
        jPanel10.add(jLabel25);
        jLabel25.setBounds(50, 300, 80, 20);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Código");
        jPanel10.add(jLabel26);
        jLabel26.setBounds(50, 260, 80, 20);

        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel45.setText("CPF/CNPJ ");
        jPanel10.add(jLabel45);
        jLabel45.setBounds(350, 70, 80, 20);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CADASTRO DE FORNECEDOR");
        jPanel10.add(jLabel2);
        jLabel2.setBounds(10, 0, 1050, 70);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço:"));
        jPanel10.add(jLabel14);
        jLabel14.setBounds(20, 200, 1020, 150);

        cpf.setBackground(new java.awt.Color(255, 255, 204));
        cpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cpfKeyReleased(evt);
            }
        });
        jPanel10.add(cpf);
        cpf.setBounds(350, 90, 250, 20);

        inativar1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        inativar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir2.png"))); // NOI18N
        inativar1.setText("Imprimir");
        inativar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inativar1ActionPerformed(evt);
            }
        });
        jPanel10.add(inativar1);
        inativar1.setBounds(620, 450, 180, 40);

        getContentPane().add(jPanel10);
        jPanel10.setBounds(10, 0, 1100, 700);
        jPanel10.getAccessibleContext().setAccessibleName("Cadastro de Pessoas");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoFocusLost
        try {
            carrega();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        } 
    }//GEN-LAST:event_codigoFocusLost

    private void codLogradouroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codLogradouroFocusLost
        try {
            carregaLogCadPessoa();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codLogradouroFocusLost

    private void descLogradouroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descLogradouroKeyReleased
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            List<Logradouro> merged = new LogradouroDAO().getPureList(session, 0, 12, Logradouro.class,
                "select e from Logradouro e where lower ( trim(e.descricao) ) like ?1 order by e.descricao",
                descLogradouro.getText().trim().toLowerCase() + "%");
            listaLogradouroNome.clear();
            listaLogradouroNome.addAll(merged);
        } catch (Exception e) {
        } finally {
            session.close();
        }
    }//GEN-LAST:event_descLogradouroKeyReleased

    private void codBairroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codBairroFocusLost
        try {
            carregaBairroCadPessoa();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codBairroFocusLost

    private void descBairroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descBairroKeyReleased
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            List<Bairro> merged = new BairroDAO().getPureList(session, 0, 12, Bairro.class,
                "select e from Bairro e where lower ( trim(e.descricao) ) like ?1 order by e.descricao",
                descBairro.getText().trim().toLowerCase() + "%");
            listaBairroNome.clear();
            listaBairroNome.addAll(merged);
        } catch (Exception e) {
        } finally {
            session.close();
        }
    }//GEN-LAST:event_descBairroKeyReleased

    private void codCidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codCidadeFocusLost
        try {
            carregaCidadeCadPessoa();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codCidadeFocusLost

    private void descCidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descCidadeKeyReleased
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            List<Cidade> merged = new CidadeDAO().getPureList(session, 0, 12, Cidade.class,
                "select e from Cidade e where lower ( trim(e.descricao) ) like ?1 order by e.descricao",
                descCidade.getText().trim().toLowerCase() + "%");
            listaCidadeNome.clear();
            listaCidadeNome.addAll(merged);
        } catch (Exception e) {
        } finally {
            session.close();
        }
    }//GEN-LAST:event_descCidadeKeyReleased

    private void cnpjKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnpjKeyReleased
        try {
            List<Fornecedor> merged = fornecedorDao.getList(15, "select e from Fornecedor e where "
                    + "  REPLACE(REPLACE(REPLACE(trim(e.pessoa.cnpj),'.',''),'-',''),' ', '') like ?1 order by e.pessoa.cnpj", 
                        cnpj.getText().trim().toLowerCase().replace(".", "").replace("-", "").trim() + "%");
            listaFornecedorCPF.clear();
            listaFornecedorCPF.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Fornecedor. Erro: " + e);
        }
    }//GEN-LAST:event_cnpjKeyReleased

    private void nomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeKeyReleased
        try {
            List<Fornecedor> merged = fornecedorDao.getList(12,
                "select e from Fornecedor e where  lower ( trim(e.pessoa.nome) ) like ?1 order by e.pessoa.nome",
                nome.getText().trim().toLowerCase() + "%");
            listaFornecedorNome.clear();
            listaFornecedorNome.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Forncedor. Erro: " + e);
        }
            
    }//GEN-LAST:event_nomeKeyReleased

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        try {
            if (cnvColaboradorCad == null) {
                atualizaTabela();
            } else {
                cnvColaboradorCad.primeiro();
                atualizarTabelaCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_inicioActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        try {
            if (cnvColaboradorCad == null) {
                atualizaTabela();
            } else {
                cnvColaboradorCad.anterior();
                atualizarTabelaCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_anteriorActionPerformed

    private void proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoActionPerformed
        try {
            if (cnvColaboradorCad == null) {
                atualizaTabela();
            } else {
                cnvColaboradorCad.proximo();
                atualizarTabelaCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_proximoActionPerformed

    private void ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ultimoActionPerformed
        try {
            if (cnvColaboradorCad == null) {
                atualizaTabela();
            } else {
                cnvColaboradorCad.ultimo();
                atualizarTabelaCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_ultimoActionPerformed

    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed
        pessoa = new Pessoa();
        fornecedor= new Fornecedor();
        cidade = null;
        bairro= null;
        logradouro= null;
        limpaCampos();
        habilitaCampos(true);
        tipoPessoa.requestFocus();
    }//GEN-LAST:event_novoActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        try {
            salvar();
            atualizaTabela();
            habilitaCampos(false);
            JOptionPane.showMessageDialog(this, " Cadastro realizado com Sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_salvarActionPerformed
  
    private void salvar() throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

           try {
               
            if (fornecedor != null) {
                if (codigo.getText().length() > 0) {
                    fornecedor.setDataAtualizacao( new Date());
                    fornecedor.setUsuarioAtualizacao(ControleAcesso.usuario.getCodUsuario()+" - "+ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                    pessoa = fornecedor.getPessoa();
                    pessoa.setDataAtualizacao(new Date());
                    pessoa.setUsuarioAtualizacao(ControleAcesso.usuario.getCodUsuario()+" - "+ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                } else {
                    fornecedor = new Fornecedor();
                    if(tipoPessoa.getSelectedIndex()==0){
                         pessoa = pessoaDao.getByCnpj(cpf.getText().replaceAll(".","").replaceAll("-",""));
                    }else{
                         pessoa = pessoaDao.getByCnpj(cnpj.getText().replaceAll(".","").replaceAll("-","").replaceAll("/",""));
                    }
                    pessoa = pessoaDao.getByCnpj(cnpj.getText());
                    if (pessoa == null) {
                        pessoa = new Pessoa();
                    }
                    pessoa.setDataCadastro(new Date());
                    pessoa.setDataAtualizacao(new Date());
                    pessoa.setUsuarioAtualizacao(ControleAcesso.usuario.getCodUsuario()+" - "+ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                    pessoa.setUsuarioCadastro(ControleAcesso.usuario.getCodUsuario()+" - "+ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                    fornecedor.setDataCadastro(new Date());
                    fornecedor.setDataAtualizacao(new Date());
                    fornecedor.setUsuarioAtualizacao(ControleAcesso.usuario.getCodUsuario()+" - "+ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                    fornecedor.setUsuarioCadastro(ControleAcesso.usuario.getCodUsuario()+" - "+ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                }
            } else {
                fornecedor = new Fornecedor();
                if(tipoPessoa.getSelectedIndex()==0){
                         pessoa = pessoaDao.getByCnpj(cpf.getText().replaceAll(".","").replaceAll("-",""));
                    }else{
                         pessoa = pessoaDao.getByCnpj(cnpj.getText().replaceAll(".","").replaceAll("-","").replaceAll("/",""));
                    }
                if (pessoa == null) {
                    pessoa = new Pessoa();
                }
                pessoa.setDataCadastro(new Date());
                pessoa.setDataAtualizacao(new Date());
                fornecedor.setDataCadastro(new Date());
                fornecedor.setDataAtualizacao(new Date());
                fornecedor.setUsuarioAtualizacao(ControleAcesso.usuario.getCodUsuario()+" - "+ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                fornecedor.setUsuarioCadastro(ControleAcesso.usuario.getCodUsuario()+" - "+ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                pessoa.setUsuarioAtualizacao(ControleAcesso.usuario.getCodUsuario()+" - "+ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                pessoa.setUsuarioCadastro(ControleAcesso.usuario.getCodUsuario()+" - "+ControleAcesso.usuario.getColaborador().getPessoa().getNome());
            }

            if (logradouro == null) {
                throw new Exception(" Por favor, inserir um Logradouro ");
            }
            if (bairro == null) {
                throw new Exception(" Por favor, inserir um Bairro ");
            }
            if (cidade == null) {
                throw new Exception(" Por favor, inserir uma Cidade ");
            }

            setPessoa();
            pessoa = pessoaDao.salvar(session, pessoa);
            setFornecedor();
            fornecedor = fornecedorDao.addFornecedor(session, fornecedor);

            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
            e.printStackTrace();
            throw new Exception(" Erro ao Salvar ");
        }
    }
    
    private void setFornecedor() throws Exception {
        fornecedor.setAtivo(ativo.isSelected());
        fornecedor.setContato(contato.getText());
       
        if (pessoa != null) {
            fornecedor.setPessoa(pessoa);
        } else {
            throw new Exception(" Por favor, inserir uma Pessoa.");
        }

    }
    
    private void inativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inativarActionPerformed
        try {
            if (fornecedor != null) {
                Integer resp = JOptionPane.showConfirmDialog(this, "Deseja realmente Inativar esse Fornecedor.");
                if (resp == 0) {
                    inativar();
                    atualizaTabela();
                    habilitaCampos(false);
                }
            } else {
                throw new Exception(" Por Favor, Selecione um Fornecedor.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_inativarActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void tabFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabFornecedorMouseClicked
       if (evt.getClickCount() > 1) {
            codigo.setText(("" + tabFornecedor.getValueAt(tabFornecedor.getSelectedRow(), 0)));
            codigoFocusLost(null);
            habilitaCampos(true);
        }
    }//GEN-LAST:event_tabFornecedorMouseClicked

    private void cpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpfKeyReleased
        try {
            List<Fornecedor> merged = fornecedorDao.getList(15, "select e from Fornecedor e where "
                    + "  REPLACE(REPLACE(REPLACE(trim(e.pessoa.cnpj),'.',''),'-',''),' ', '') like ?1 order by e.pessoa.cnpj", 
                        cpf.getText().trim().toLowerCase().replace(".", "").replace("-", "").trim() + "%");
            listaFornecedorCPF1.clear();
            listaFornecedorCPF1.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Fornecedor. Erro: " + e);
        }
    }//GEN-LAST:event_cpfKeyReleased

    private void tipoPessoaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoPessoaItemStateChanged
        try {
            if (tipoPessoa.getSelectedIndex() == 0) {
                cpf.setVisible(true);
                cnpj.setVisible(false);
            } else {
                cpf.setVisible(false);
                cnpj.setVisible(true);
            }  
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tipoPessoaItemStateChanged

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoActionPerformed

    private void inativar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inativar1ActionPerformed
        try {
            imprimir();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_inativar1ActionPerformed

    private void ativoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ativoStateChanged
        if (ativo.isSelected()) {
            ativo.setBackground(Color.GREEN);
            ativo.setForeground(Color.BLACK);
        } else {
            ativo.setBackground(Color.RED);
            ativo.setForeground(Color.WHITE);
        }

    }//GEN-LAST:event_ativoStateChanged

  
    
    private void inativar() throws Exception {
        fornecedor.setAtivo(false);
        fornecedor = fornecedorDao.addFornecedor(fornecedor);
        limpaCampos();

    }
    
    private void atualizarTabelaCad() {

        DefaultTableModel model = (DefaultTableModel) tabFornecedor.getModel();
        removeLinhas(tabFornecedor);

        List<?> lv;

        lv = cnvColaboradorCad.getLista();

        if (lv != null && !lv.isEmpty()) {

            for (Object o : lv) {
                Object[] os = (Object[]) o;
                model.addRow(os);

            }
        }
    }
    
     private void atualizaTabela() {
        try {

            if (cnvColaboradorCad == null) {
                cnvColaboradorCad = new CnvCadastroFornecedor();
            }

            cnvColaboradorCad.iniciarNavTabela();

            cnvColaboradorCad.primeiro();
            atualizarTabelaCad();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    

    public static void removeLinhas(JTable table) {
        int n = table.getRowCount();

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (int i = n - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private void carregaPessoa() throws Exception {
        pessoa = fornecedor.getPessoa();
        logradouro = pessoa.getLogradouro();
        bairro = pessoa.getBairro();
        cidade = pessoa.getCidade();
        if (pessoa != null) {
            nomeFantasia.setText(pessoa.getNomeFantasia());
            tipoPessoa.setSelectedIndex((pessoa.getTipoPessoa()-1));
            if(pessoa.getTipoPessoa()==1){
                
                cpf.setVisible(true);
                cnpj.setVisible(false);
                cpf.setText(pessoa.getCnpj());
                
            }else{
                
                cnpj.setVisible(true);
                cpf.setVisible(false);
                cnpj.setText(pessoa.getCnpj());
            }
            nome.setText(pessoa.getNome());
            inscEstadual.setText(pessoa.getInscEstadual());
            inscMunicipal.setText(pessoa.getInscMunicipal());
            email.setText(pessoa.getEmail());
            telefone.setText(pessoa.getTelefone());
            dataNascimento.setText(Data.getDateParse(pessoa.getDataNascimento(), Data.FORMAT_DATA_BR));
            codLogradouro.setText(pessoa.getLogradouro().getCodLogradouro().toString());
            descLogradouro.setText(pessoa.getLogradouro().getDescricao());
            numero.setText(pessoa.getNumCasa());
            codBairro.setText(pessoa.getBairro().getCodBairro().toString());
            descBairro.setText(pessoa.getBairro().getDescricao());
            comboTipo.setSelectedIndex(pessoa.getLogradouro().getTipo());
            complemento.setText(pessoa.getComplemento());
            codCidade.setText(pessoa.getCidade().getCodCidade().toString());
            descCidade.setText(pessoa.getCidade().getDescricao());
            uf.setText(pessoa.getUf());
            cep.setText(pessoa.getCep());
            obs.setText(pessoa.getObs());

        } else{
            throw  new Exception("Pessoa nula");
        }

    }

    private void salvarPessoa() throws Exception {
        Pessoa pessoaAux;
        if (pessoa != null) {
            setPessoa();
            if (codigo.getText().equals("")) {
                pessoaAux = null;
            } else {
                pessoaAux = pessoaDao.get(pessoa.getCodPessoa());
            }

            if (pessoaAux == null) {
                pessoa = pessoaDao.addUsuario(pessoa);

            } else {
                pessoa = pessoaDao.addUsuario(pessoa);
            }
        } else {
            throw new Exception(" Para inserir um cadastro novo, aperte o botão "
                    + " Novo Cadastro.");
        }
    }

    private void setPessoa() {        
       
        pessoa.setTipoPessoa(tipoPessoa.getSelectedIndex()+1);
         if (tipoPessoa.getSelectedIndex() == 0) {
            pessoa.setCnpj(cpf.getText().replace(".", "").replace("-", ""));
        } else {
            pessoa.setCnpj(cnpj.getText().replace(".", "").replace("-", "").replace("/", ""));
        }
        pessoa.setNome(nome.getText());
        pessoa.setDataNascimento(Data.getDateUtil(dataNascimento.getText()));
        pessoa.setInscMunicipal(inscMunicipal.getText());
        pessoa.setNomeFantasia(nomeFantasia.getText());
        pessoa.setTelefone(telefone.getText());
        pessoa.setInscEstadual(inscEstadual.getText());
        pessoa.setEmail(email.getText());        
        pessoa.setLogradouro(logradouro);
        pessoa.setNumCasa(numero.getText());
        pessoa.setBairro(bairro);
        pessoa.setComplemento(complemento.getText());
        pessoa.setCidade(cidade);
        pessoa.setUf(uf.getText());
        pessoa.setCep(cep.getText());
        pessoa.setObs(obs.getText());
    }

    private void carregaLogCadPessoa() throws Exception {
        logradouro = logradouroDao.getPorCodigo(ValidarValor.getLong(codLogradouro.getText()));
        if (logradouro != null) {
            codLogradouro.setText(logradouro.getCodLogradouro().toString());
            descLogradouro.setText(logradouro.getDescricao());
            comboTipo.setSelectedIndex(logradouro.getTipo());
        } else {
            codLogradouro.setText("");
            descLogradouro.setText("");
            comboTipo.setSelectedIndex(0);
        }
    }

    private void carregaBairroCadPessoa() throws Exception {
        bairro = bairroDao.getPorCodigo(ValidarValor.getInt(codBairro.getText()));
        if (bairro != null) {
            codBairro.setText(bairro.getCodBairro().toString());
            descBairro.setText(bairro.getDescricao());
        } else {
            codBairro.setText("");
            descBairro.setText("");
        }
    }

    private void carregaCidadeCadPessoa() throws Exception {
        cidade = cidadeDao.getPorCodigo(ValidarValor.getInt(codCidade.getText()));
        if (cidade != null) {
            codCidade.setText(cidade.getCodCidade().toString());
            descCidade.setText(cidade.getDescricao());
        } else {
            codCidade.setText("");
            descCidade.setText("");
        }
    }


    
    private void carrega() throws Exception {
        fornecedor = fornecedorDao.get(ValidarValor.getLong(codigo.getText()));
        if (fornecedor != null) {
            contato.setText(fornecedor.getContato());
            ativo.setSelected(fornecedor.getAtivo());
            ativoStateChanged(null);
            carregaPessoa();

        } else {
            limpaCampos();
            new Exception("Por favor, inserir um código válido.");
        }
    }

  
    private void limpaCampos() {
        
        codigo.setText("");
        ativo.setSelected(true);
        tipoPessoa.setSelectedIndex(0);
        cnpj.setVisible(false);
        cpf.setVisible(true);
        cnpj.setText("");
        cpf.setText("");
        nome.setText("");
        email.setText("");
        contato.setText("");
        dataNascimento.setText("");
        telefone.setText("");
        inscMunicipal.setText("");
        inscEstadual.setText("");
        codLogradouro.setText("");
        descLogradouro.setText("");
        numero.setText("");
        codBairro.setText("");
        descBairro.setText("");
        complemento.setText("");
        codCidade.setText("");
        descCidade.setText("");
        nomeFantasia.setText("");
        uf.setText("");
        cep.setText("");
        obs.setText("");
        comboTipo.setSelectedIndex(0);
       
    }
    
    private void habilitaCampos(boolean b) {
        
        codigo.setEnabled(b);
        ativo.setEnabled(b);
        cnpj.setEnabled(b);
        cpf.setEnabled(b);
        nome.setEnabled(b);
        email.setEnabled(b);
        contato.setEnabled(b);
        dataNascimento.setEnabled(b);
        telefone.setEnabled(b);
        inscMunicipal.setEnabled(b);
        inscEstadual.setEnabled(b);
        codLogradouro.setEnabled(b);
        descLogradouro.setEnabled(b);
        numero.setEnabled(b);
        codBairro.setEnabled(b);
        descBairro.setEnabled(b);
        complemento.setEnabled(b);
        codCidade.setEnabled(b);
        descCidade.setEnabled(b);
        nomeFantasia.setEnabled(b);
        uf.setEnabled(b);
        cep.setEnabled(b);
        obs.setEnabled(b);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anterior;
    private javax.swing.JCheckBox ativo;
    private javax.swing.JTextField cep;
    private javax.swing.JTextField cnpj;
    private javax.swing.JTextField codBairro;
    private javax.swing.JTextField codCidade;
    private javax.swing.JTextField codLogradouro;
    private javax.swing.JTextField codigo;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JTextField complemento;
    private javax.swing.JTextField contato;
    private javax.swing.JTextField cpf;
    private javax.swing.JTextField dataNascimento;
    private javax.swing.JTextField descBairro;
    private javax.swing.JTextField descCidade;
    private javax.swing.JTextField descLogradouro;
    private javax.swing.JTextField email;
    private javax.swing.JButton inativar;
    private javax.swing.JButton inativar1;
    private javax.swing.JButton inicio;
    private javax.swing.JTextField inscEstadual;
    private javax.swing.JTextField inscMunicipal;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField nomeFantasia;
    private javax.swing.JButton novo;
    private javax.swing.JTextField numero;
    private javax.swing.JTextArea obs;
    private javax.swing.JButton proximo;
    private javax.swing.JButton sair;
    private javax.swing.JButton salvar;
    private javax.swing.JTable tabFornecedor;
    private javax.swing.JTextField telefone;
    private javax.swing.JComboBox<String> tipoPessoa;
    private javax.swing.JTextField uf;
    private javax.swing.JButton ultimo;
    // End of variables declaration//GEN-END:variables

    private void imprimir()throws Exception{
         String r = fornecedorDao.getSqlList(0,99999999);  
            new VisualizaRelatorio().visRel("graficaatual/relatorios/arquivos/listaCliente.jasper", "Relatório de Lista de Fornecedor", null, r);
    }
  
}
