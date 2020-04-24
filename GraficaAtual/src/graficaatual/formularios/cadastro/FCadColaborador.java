/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.cadastro;


import graficaatual.daos.cadastro.BairroDAO;
import graficaatual.daos.cadastro.CargoDAO;
import graficaatual.daos.cadastro.CidadeDAO;
import graficaatual.daos.cadastro.ColaboradorDAO;
import graficaatual.daos.cadastro.LogradouroDAO;
import graficaatual.daos.cadastro.PessoaDAO;
import graficaatual.entidades.Bairro;
import graficaatual.entidades.Cargo;
import graficaatual.entidades.Cidade;
import graficaatual.entidades.Colaborador;
import graficaatual.entidades.Logradouro;
import graficaatual.entidades.Pessoa;
import graficaatual.pesq.cadastro.CnvCadastroColaborador;
import graficaatual.utilitarios.Componentes;
import graficaatual.utilitarios.Data;
import graficaatual.utilitarios.Persistencia;
import graficaatual.utilitarios.ValidarValor;
import java.sql.Timestamp;
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
public class FCadColaborador extends javax.swing.JInternalFrame {

    // Tela
    private static int initControle;
    private int localIncusao;
    private static FCadColaborador instance;
    private static FCadColaborador instanceCont;
    
    //Entidades
    private Cargo cargo = null;
    private CargoDAO cargoDao = new CargoDAO();
    
    private Colaborador colaborador = null;
    private ColaboradorDAO colaboradorDao = new ColaboradorDAO();
    
    private Pessoa pessoa = null;
    private PessoaDAO pessoaDao = new PessoaDAO();
    
    private Logradouro logradouro = null;
    private LogradouroDAO logradouroDao = new LogradouroDAO();
    
    private Bairro bairro = null;
    private BairroDAO bairroDao = new BairroDAO();
    
    private Cidade cidade = null;
    private CidadeDAO cidadeDao = new CidadeDAO();
    
    
    // Lista Suspensa
    private List<Colaborador> listaColaboradorNome = null;
    private List<Colaborador> listaColaboradorCPF = null;
    private List<Cargo> listaCargoNome = null;
    private List<Logradouro> listaLogradouroNome = null;
    private List<Bairro> listaBairroNome = null;
    private List<Cidade> listaCidadeNome = null;
    
    //Controle de Navegação
    CnvCadastroColaborador cnvColaboradorCad = new CnvCadastroColaborador();
            
            
    public FCadColaborador() {
        initComponents();
        
        listaColaboradorNome = ObservableCollections.observableList(new LinkedList<Colaborador>());
        Componentes comp1 = new Componentes(listaColaboradorNome, false, codigo, nome, this, jPanel10, nome.getWidth(), 100);
        comp1.addCol(0, "codColaborador", " Código ", 50, Integer.class.getName());
        comp1.addCol(1, "pessoa.cnpj", " CPF/CNPJ ", 100, String.class.getName());
        comp1.addCol(2, "pessoa.nome", " Nome ", 200, String.class.getName());
        comp1.bind();
        
        listaColaboradorCPF = ObservableCollections.observableList(new LinkedList<Colaborador>());
        Componentes comp2 = new Componentes(listaColaboradorCPF, false, codigo, cpf, this, jPanel10, cpf.getWidth(), 100);
        comp2.addCol(0, "codColaborador", " Código ", 50, Integer.class.getName());
        comp2.addCol(1, "pessoa.cnpj", " CPF/CNPJ ", 100, String.class.getName());
        comp2.addCol(2, "pessoa.nome", " Nome ", 200, String.class.getName());
        comp2.bind();
        
        listaCargoNome = ObservableCollections.observableList(new LinkedList<Cargo>());
        Componentes comp3 = new Componentes(listaCargoNome, false, codCargo, descCargo, this, jPanel10, descCargo.getWidth(), 100);
        comp3.addCol(0, "codCargo", " Código ", 50, Integer.class.getName());
        comp3.addCol(1, "descricao", " Descrição ", 200, String.class.getName());
        comp3.bind();
        
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
        atualizaTabelaColaborador();
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
     
  public synchronized static FCadColaborador getInstance() {
        if (instance == null) {
            instance = new FCadColaborador();
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
        try{     cep = new JFormattedTextField(     new MaskFormatter("##.###-###"));     ((JFormattedTextField) cep).setFocusLostBehavior(0); }catch(Exception e){}
        uf = new javax.swing.JTextField();
        cpf = new javax.swing.JTextField();
        try {                cpf = new JFormattedTextField(                         new MaskFormatter("###.###.###-##"));                 ((JFormattedTextField) cpf).setFocusLostBehavior(0);                      } catch (Exception e) {         }
        nome = new javax.swing.JTextField();
        dataNascimento = new javax.swing.JTextField();
        try{
            dataNascimento = new JFormattedTextField(
                new MaskFormatter("##/##/####"));
            ((JFormattedTextField) dataNascimento).setFocusLostBehavior(0);
        }catch(Exception e){}
        email = new javax.swing.JTextField();
        telefone = new javax.swing.JTextField();
        codCargo = new javax.swing.JTextField();
        descCargo = new javax.swing.JTextField();
        dtInicioContrato = new javax.swing.JTextField();
        try{
            dtInicioContrato = new JFormattedTextField(
                new MaskFormatter("##/##/####"));
            ((JFormattedTextField) dtInicioContrato).setFocusLostBehavior(0);
        }catch(Exception e){}
        dtFimContrato = new javax.swing.JTextField();
        try{
            dtFimContrato = new JFormattedTextField(
                new MaskFormatter("##/##/####"));
            ((JFormattedTextField) dtFimContrato).setFocusLostBehavior(0);
        }catch(Exception e){}
        ctps = new javax.swing.JTextField();
        salario = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        obs = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabColaborador = new javax.swing.JTable();
        inicio = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        proximo = new javax.swing.JButton();
        ultimo = new javax.swing.JButton();
        novo = new javax.swing.JButton();
        salvar = new javax.swing.JButton();
        inativar = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        ativo = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Colaborador");
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setPreferredSize(new java.awt.Dimension(1100, 700));
        setRequestFocusEnabled(false);
        getContentPane().setLayout(null);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setToolTipText("Cadastro de Pessoas");
        jPanel10.setMaximumSize(new java.awt.Dimension(999999, 99999));
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
        codigo.setBounds(30, 90, 90, 20);

        codLogradouro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codLogradouroFocusLost(evt);
            }
        });
        jPanel10.add(codLogradouro);
        codLogradouro.setBounds(40, 240, 80, 20);

        descLogradouro.setBackground(new java.awt.Color(255, 255, 204));
        descLogradouro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descLogradouroKeyReleased(evt);
            }
        });
        jPanel10.add(descLogradouro);
        descLogradouro.setBounds(120, 240, 720, 20);
        jPanel10.add(numero);
        numero.setBounds(840, 240, 160, 20);

        codBairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codBairroFocusLost(evt);
            }
        });
        jPanel10.add(codBairro);
        codBairro.setBounds(40, 280, 80, 20);

        descBairro.setBackground(new java.awt.Color(255, 255, 204));
        descBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descBairroKeyReleased(evt);
            }
        });
        jPanel10.add(descBairro);
        descBairro.setBounds(120, 280, 720, 20);
        jPanel10.add(complemento);
        complemento.setBounds(840, 280, 160, 20);

        codCidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codCidadeFocusLost(evt);
            }
        });
        jPanel10.add(codCidade);
        codCidade.setBounds(40, 320, 80, 20);

        descCidade.setBackground(new java.awt.Color(255, 255, 204));
        descCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descCidadeKeyReleased(evt);
            }
        });
        jPanel10.add(descCidade);
        descCidade.setBounds(120, 320, 640, 20);
        jPanel10.add(cep);
        cep.setBounds(840, 320, 160, 20);
        jPanel10.add(uf);
        uf.setBounds(760, 320, 80, 20);

        cpf.setBackground(new java.awt.Color(255, 255, 204));
        cpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cpfKeyReleased(evt);
            }
        });
        jPanel10.add(cpf);
        cpf.setBounds(640, 90, 250, 20);

        nome.setBackground(new java.awt.Color(255, 255, 204));
        nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeKeyReleased(evt);
            }
        });
        jPanel10.add(nome);
        nome.setBounds(120, 90, 520, 20);
        jPanel10.add(dataNascimento);
        dataNascimento.setBounds(760, 130, 120, 20);
        jPanel10.add(email);
        email.setBounds(30, 130, 610, 20);
        jPanel10.add(telefone);
        telefone.setBounds(640, 130, 120, 20);

        codCargo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codCargoFocusLost(evt);
            }
        });
        jPanel10.add(codCargo);
        codCargo.setBounds(30, 170, 70, 20);

        descCargo.setBackground(new java.awt.Color(255, 255, 204));
        descCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descCargoKeyReleased(evt);
            }
        });
        jPanel10.add(descCargo);
        descCargo.setBounds(100, 170, 350, 20);
        jPanel10.add(dtInicioContrato);
        dtInicioContrato.setBounds(640, 170, 120, 20);
        jPanel10.add(dtFimContrato);
        dtFimContrato.setBounds(760, 170, 120, 20);
        jPanel10.add(ctps);
        ctps.setBounds(450, 170, 190, 20);

        salario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        salario.setText("0,00");
        jPanel10.add(salario);
        salario.setBounds(880, 170, 130, 20);

        jLabel23.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("UF");
        jPanel10.add(jLabel23);
        jLabel23.setBounds(760, 300, 50, 20);

        jLabel22.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("CEP");
        jPanel10.add(jLabel22);
        jLabel22.setBounds(840, 300, 160, 20);

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Código");
        jPanel10.add(jLabel13);
        jLabel13.setBounds(30, 70, 80, 20);

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Observação: ");
        jPanel10.add(jLabel15);
        jLabel15.setBounds(20, 350, 100, 20);

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Número");
        jPanel10.add(jLabel16);
        jLabel16.setBounds(840, 220, 110, 20);

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Bairro");
        jPanel10.add(jLabel18);
        jLabel18.setBounds(120, 260, 100, 20);

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Logradouro ");
        jPanel10.add(jLabel19);
        jLabel19.setBounds(120, 220, 100, 20);

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Complemento ");
        jPanel10.add(jLabel20);
        jLabel20.setBounds(840, 260, 110, 20);

        jLabel21.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Codigo");
        jPanel10.add(jLabel21);
        jLabel21.setBounds(30, 150, 80, 20);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço:"));
        jPanel10.add(jLabel14);
        jLabel14.setBounds(20, 200, 1000, 150);

        jLabel28.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("CPF");
        jPanel10.add(jLabel28);
        jLabel28.setBounds(640, 70, 80, 20);

        jLabel29.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("Email");
        jPanel10.add(jLabel29);
        jLabel29.setBounds(30, 110, 80, 20);

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Telefone");
        jPanel10.add(jLabel9);
        jLabel9.setBounds(640, 110, 90, 20);

        jLabel46.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel46.setText("Data Nascimento");
        jPanel10.add(jLabel46);
        jLabel46.setBounds(760, 110, 140, 20);

        jLabel71.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel71.setText("Nome");
        jPanel10.add(jLabel71);
        jLabel71.setBounds(120, 70, 80, 20);

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Cargo");
        jPanel10.add(jLabel12);
        jLabel12.setBounds(100, 150, 80, 20);

        jLabel27.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Data de Início");
        jPanel10.add(jLabel27);
        jLabel27.setBounds(640, 150, 130, 20);

        jLabel24.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Data de Fim");
        jPanel10.add(jLabel24);
        jLabel24.setBounds(760, 150, 130, 20);

        jLabel26.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("CTPS");
        jPanel10.add(jLabel26);
        jLabel26.setBounds(450, 150, 80, 20);

        jLabel72.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel72.setText("Salário");
        jPanel10.add(jLabel72);
        jLabel72.setBounds(880, 150, 150, 20);

        jLabel25.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Cidade");
        jPanel10.add(jLabel25);
        jLabel25.setBounds(120, 300, 100, 20);

        jLabel30.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Codigo");
        jPanel10.add(jLabel30);
        jLabel30.setBounds(40, 300, 80, 20);

        jLabel45.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel45.setText("Codigo");
        jPanel10.add(jLabel45);
        jLabel45.setBounds(40, 260, 80, 20);

        jLabel47.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel47.setText("Codigo");
        jPanel10.add(jLabel47);
        jLabel47.setBounds(40, 220, 80, 20);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CADASTRO DE COLABORADOR");
        jPanel10.add(jLabel2);
        jLabel2.setBounds(0, 0, 1100, 70);

        obs.setColumns(20);
        obs.setRows(2);
        jScrollPane4.setViewportView(obs);

        jPanel10.add(jScrollPane4);
        jScrollPane4.setBounds(20, 370, 1000, 60);

        tabColaborador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Cargo", "Ativo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabColaborador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabColaboradorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabColaborador);

        jPanel10.add(jScrollPane3);
        jScrollPane3.setBounds(20, 490, 1000, 140);

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
        novo.setBounds(170, 440, 180, 40);

        salvar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar2.png"))); // NOI18N
        salvar.setText("Salvar/Atualizar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });
        jPanel10.add(salvar);
        salvar.setBounds(350, 440, 180, 40);

        inativar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        inativar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excuir2.png"))); // NOI18N
        inativar.setText("Inativar");
        inativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inativarActionPerformed(evt);
            }
        });
        jPanel10.add(inativar);
        inativar.setBounds(530, 440, 180, 40);

        sair.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAIR2.png"))); // NOI18N
        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        jPanel10.add(sair);
        sair.setBounds(710, 440, 180, 40);

        ativo.setBackground(new java.awt.Color(255, 0, 51));
        ativo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ativo.setForeground(new java.awt.Color(255, 255, 255));
        ativo.setText("Ativo");
        ativo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ativo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ativoItemStateChanged(evt);
            }
        });
        jPanel10.add(ativo);
        ativo.setBounds(890, 90, 130, 20);

        getContentPane().add(jPanel10);
        jPanel10.setBounds(0, 0, 1100, 700);
        jPanel10.getAccessibleContext().setAccessibleName("Cadastro de Pessoas");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoFocusLost
        try {
            carregaColaborador();
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

    private void cpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpfKeyReleased
        try {
            List<Colaborador> merged = colaboradorDao.getList(15, "select e from Colaborador e where "
                    + "  REPLACE(REPLACE(REPLACE(trim(e.pessoa.cnpj),'.',''),'-',''),' ', '') like ?1 order by e.pessoa.cnpj", 
                        cpf.getText().trim().toLowerCase().replace(".", "").replace("-", "").trim() + "%");
            listaColaboradorCPF.clear();
            listaColaboradorCPF.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Colaboador. Erro: " + e);
        }
    }//GEN-LAST:event_cpfKeyReleased

    private void nomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeKeyReleased
        try {
            List<Colaborador> merged = colaboradorDao.getList(12,
                "select e from Colaborador e where  lower ( trim(e.pessoa.nome) ) like ?1 order by e.pessoa.nome",
                nome.getText().trim().toLowerCase() + "%");
            listaColaboradorNome.clear();
            listaColaboradorNome.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Colaborador. Erro: " + e);
        }
            
    }//GEN-LAST:event_nomeKeyReleased

    private void codCargoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codCargoFocusLost
        try {
            carregaCargo();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codCargoFocusLost

    private void tabColaboradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabColaboradorMouseClicked
        if (evt.getClickCount() > 1) {
            codigo.setText(("" + tabColaborador.getValueAt(tabColaborador.getSelectedRow(), 0)));
            codigoFocusLost(null);
            habilitaCampos(true);
        }
    }//GEN-LAST:event_tabColaboradorMouseClicked

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        try {
            if (cnvColaboradorCad == null) {
                atualizaTabelaColaborador();
            } else {
                cnvColaboradorCad.primeiro();
                atualizarTabelaColaboradorCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_inicioActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        try {
            if (cnvColaboradorCad == null) {
                atualizaTabelaColaborador();
            } else {
                cnvColaboradorCad.anterior();
                atualizarTabelaColaboradorCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_anteriorActionPerformed

    private void proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoActionPerformed
        try {
            if (cnvColaboradorCad == null) {
                atualizaTabelaColaborador();
            } else {
                cnvColaboradorCad.proximo();
                atualizarTabelaColaboradorCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_proximoActionPerformed

    private void ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ultimoActionPerformed
        try {
            if (cnvColaboradorCad == null) {
                atualizaTabelaColaborador();
            } else {
                cnvColaboradorCad.ultimo();
                atualizarTabelaColaboradorCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_ultimoActionPerformed

    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed
        pessoa = new Pessoa();
        cargo = new Cargo();
        colaborador= new Colaborador();
        cidade = null;
        bairro= null;
        logradouro= null;
        limpaCamposColaborador();
        habilitaCampos(true);
        cpf.requestFocus();
    }//GEN-LAST:event_novoActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        try {
            salvarColaborador();
            atualizaTabelaColaborador();
            habilitaCampos(false);
            JOptionPane.showMessageDialog(this, " Cadastro realizado com Sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_salvarActionPerformed
  
    private void salvarColaborador() throws Exception {
      
        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {
            if (colaborador != null) {
                if (codigo.getText().length() > 0) {
                    colaborador.setDataAtualizacao( new Date());
                    pessoa = colaborador.getPessoa();
                    pessoa.setDataAtualizacao(new Date());
                } else {
                    colaborador = new Colaborador();
                    pessoa = pessoaDao.getByCnpj(cpf.getText());
                    if (pessoa == null) {
                        pessoa = new Pessoa();
                    }
                    pessoa.setDataCadastro(new Date());
                    pessoa.setDataAtualizacao(new Date());
                    colaborador.setDataCadastro(new Date());
                    colaborador.setDataAtualizacao(new Date());
                }
            } else {
                colaborador = new Colaborador();
                pessoa = pessoaDao.getByCnpj(cpf.getText());
                if (pessoa == null) {
                    pessoa = new Pessoa();
                }
                pessoa.setDataCadastro(new Date());
                pessoa.setDataAtualizacao(new Date());
                colaborador.setDataCadastro(new Date());
                colaborador.setDataAtualizacao(new Date());
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
            if (cargo == null) {
                throw new Exception(" Por favor, inserir um Cargo ");
            }
            setPessoa();
            pessoa = pessoaDao.salvar(session, pessoa);
            setColaborador();
            colaborador = colaboradorDao.salvar(session, colaborador);
            
            session.getTransaction().commit();
            session.close();

        } catch(Exception e){
            session.getTransaction().rollback();
            session.close();
            e.printStackTrace();
            throw new Exception(" Erro ao Salvar ");
        }
    }
    
    private void setColaborador() throws Exception {
        colaborador.setAtivo(ativo.isSelected());
        colaborador.setCtps(ctps.getText());
        colaborador.setDataInicio(Data.getDateSQL(dtInicioContrato.getText()));
        colaborador.setDataFim(Data.getDateSQL(dtFimContrato.getText()));
        if (pessoa != null) {
            colaborador.setPessoa(pessoa);
        } else {
            throw new Exception(" Por favor, inserir uma Pessoa.");
        }
        
        colaborador.setCargo(cargo);
        colaborador.setSalario(ValidarValor.getDouble(salario.getText()));
    }
    
    private void inativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inativarActionPerformed
        try {
            if (colaborador != null) {
                Integer resp = JOptionPane.showConfirmDialog(this, "Deseja realmente Inativar esse Colaborador.");
                if (resp == 0) {
                    inativarColaborador();
                    atualizaTabelaColaborador();
                    habilitaCampos(false);
                }
            } else {
                throw new Exception(" Por Favor, Selecione um Colaborador.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_inativarActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void descCargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descCargoKeyReleased
        try {
            List<Cargo> merged = cargoDao.getList(12,
                "select e from Cargo e where   lower ( trim(e.descricao) ) like ?1 order by e.descricao",
                descCargo.getText().trim().toLowerCase() + "%");
            listaCargoNome.clear();
            listaCargoNome.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Cargo. Erro: " + e);
        }
    }//GEN-LAST:event_descCargoKeyReleased

    private void ativoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ativoItemStateChanged
        if(!ativo.isSelected()){
            dtFimContrato.setText(Data.getDataAtual(Data.FORMAT_DATA_BR));
        }else{
            dtFimContrato.setText(Data.getDataAtual(""));
        }
    }//GEN-LAST:event_ativoItemStateChanged

      
    private void limpaCamposPessoa() {

        cpf.setText("");
        nome.setText("");
        email.setText("");
        telefone.setText("");
        dataNascimento.setText("");

        codLogradouro.setText("");
        descLogradouro.setText("");
        numero.setText("");
        codBairro.setText("");
        descBairro.setText("");
        complemento.setText("");
        codCidade.setText("");
        descCidade.setText("");
        uf.setText("");
        cep.setText("");

        obs.setText("");


    }
    
    private void inativarColaborador() throws Exception {
        colaborador.setAtivo(false);
        colaborador = colaboradorDao.addColaborador(colaborador);
        limpaCamposColaborador();

    }
    
    private void atualizarTabelaColaboradorCad() {

        DefaultTableModel model = (DefaultTableModel) tabColaborador.getModel();
        removeLinhas(tabColaborador);

        List<?> lv;

        lv = cnvColaboradorCad.getLista();

        if (lv != null && !lv.isEmpty()) {

            for (Object o : lv) {
                Object[] os = (Object[]) o;
                model.addRow(os);

            }
        }
    }
    
     private void atualizaTabelaColaborador() {
        try {

            if (cnvColaboradorCad == null) {
                cnvColaboradorCad = new CnvCadastroColaborador();
            }

            cnvColaboradorCad.iniciarNavTabela();

            cnvColaboradorCad.primeiro();
            atualizarTabelaColaboradorCad();

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
        pessoa = colaborador.getPessoa();
        logradouro = colaborador.getPessoa().getLogradouro();
        bairro = colaborador.getPessoa().getBairro();
        cidade = colaborador.getPessoa().getCidade();
        if (pessoa != null) {
            cpf.setText(pessoa.getCnpj());
            nome.setText(pessoa.getNome());
            email.setText(pessoa.getEmail());
            telefone.setText(pessoa.getTelefone());
            dataNascimento.setText(Data.getDateParse(pessoa.getDataNascimento(), Data.FORMAT_DATA));
            codLogradouro.setText(pessoa.getLogradouro().getCodLogradouro().toString());
            descLogradouro.setText(pessoa.getLogradouro().getDescricao());
            numero.setText(pessoa.getNumCasa());
            codBairro.setText(pessoa.getBairro().getCodBairro().toString());
            descBairro.setText(pessoa.getBairro().getDescricao());
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
       
        pessoa.setTipoPessoa(1);
        pessoa.setCnpj(cpf.getText());
        pessoa.setInscMunicipal("");
        pessoa.setNome(nome.getText());
        pessoa.setInscEstadual("");
        pessoa.setNomeFantasia("");
        pessoa.setEmail(email.getText());
        pessoa.setTelefone(telefone.getText());
        pessoa.setDataNascimento(Data.getDateUtil(dataNascimento.getText()));
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
        } else {
            codLogradouro.setText("");
            descLogradouro.setText("");
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

   

    

    private void inativarPessoa() throws Exception {
        pessoa.setAtivo(false);
        pessoa = pessoaDao.addUsuario(pessoa);
        limpaCamposPessoa();
    }

    
 private void carregaColaborador() throws Exception {
       colaborador = colaboradorDao.get(ValidarValor.getInteger(codigo.getText()));
        if (colaborador != null) {
            ativo.setSelected(colaborador.isAtivo());
            codigo.setText(colaborador.getCodColaborador().toString());
            carregaPessoa();
            codCargo.setText(colaborador.getCargo().getCodCargo().toString());
            carregaCargo();
            ctps.setText(colaborador.getCtps());
            salario.setText(ValidarValor.getDouble(colaborador.getSalario()));
            dtInicioContrato.setText(Data.getDate(colaborador.getDataInicio()));
            dtFimContrato.setText(Data.getDate(colaborador.getDataFim()));

        } else {
            limpaCamposColaborador();
            new Exception("Por favor, inserir um código válido.");
        }
    }

  
    private void limpaCamposColaborador() {
        ativo.setSelected(true);
        codigo.setText("");
        cpf.setText("");
        nome.setText("");
        codCargo.setText("");
        descCargo.setText("");
        email.setText("");
        ctps.setText("");
        dataNascimento.setText("");
        telefone.setText("");
        dtInicioContrato.setText(Data.getDataAtual(Data.FORMAT_DATA_BR));
        dtFimContrato.setText("");
        salario.setText("0,00");
        codLogradouro.setText("");
        descLogradouro.setText("");
        numero.setText("");
        codBairro.setText("");
        descBairro.setText("");
        complemento.setText("");
        codCidade.setText("");
        descCidade.setText("");
        uf.setText("");
        cep.setText("");
        obs.setText("");

    }
    
    private void habilitaCampos(boolean b) {
        ativo.setEnabled(b);
        codigo.setEnabled(b);
        cpf.setEnabled(b);
        nome.setEnabled(b);
        codCargo.setEnabled(b);
        descCargo.setEnabled(b);
        email.setEnabled(b);
        ctps.setEnabled(b);
        dataNascimento.setEnabled(b);
        telefone.setEnabled(b);
        dtInicioContrato.setEnabled(b);
        dtFimContrato.setEnabled(b);
        salario.setEnabled(b);
        codLogradouro.setEnabled(b);
        descLogradouro.setEnabled(b);
        numero.setEnabled(b);
        codBairro.setEnabled(b);
        descBairro.setEnabled(b);
        complemento.setEnabled(b);
        codCidade.setEnabled(b);
        descCidade.setEnabled(b);
        uf.setEnabled(b);
        cep.setEnabled(b);
        obs.setEnabled(b);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anterior;
    private javax.swing.JCheckBox ativo;
    private javax.swing.JTextField cep;
    private javax.swing.JTextField codBairro;
    private javax.swing.JTextField codCargo;
    private javax.swing.JTextField codCidade;
    private javax.swing.JTextField codLogradouro;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField complemento;
    private javax.swing.JTextField cpf;
    private javax.swing.JTextField ctps;
    private javax.swing.JTextField dataNascimento;
    private javax.swing.JTextField descBairro;
    private javax.swing.JTextField descCargo;
    private javax.swing.JTextField descCidade;
    private javax.swing.JTextField descLogradouro;
    private javax.swing.JTextField dtFimContrato;
    private javax.swing.JTextField dtInicioContrato;
    private javax.swing.JTextField email;
    private javax.swing.JButton inativar;
    private javax.swing.JButton inicio;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField nome;
    private javax.swing.JButton novo;
    private javax.swing.JTextField numero;
    private javax.swing.JTextArea obs;
    private javax.swing.JButton proximo;
    private javax.swing.JButton sair;
    private javax.swing.JTextField salario;
    private javax.swing.JButton salvar;
    private javax.swing.JTable tabColaborador;
    private javax.swing.JTextField telefone;
    private javax.swing.JTextField uf;
    private javax.swing.JButton ultimo;
    // End of variables declaration//GEN-END:variables

    private void carregaCargo() throws Exception{
       
        cargo = cargoDao.get(ValidarValor.getInt(codCargo.getText()));
        if(cargo!=null){
            descCargo.setText(cargo.getDescricao());
            
            
        }else{
            descCargo.setText("");
            codCargo.setText("");
        }
    }
    

   
}
