/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.cadastro;

import graficaatual.daos.cadastro.BairroDAO;
import graficaatual.daos.cadastro.CargoDAO;
import graficaatual.daos.cadastro.CidadeDAO;
import graficaatual.daos.cadastro.ClienteDAO;
import graficaatual.daos.cadastro.ColaboradorDAO;
import graficaatual.daos.cadastro.LogradouroDAO;
import graficaatual.daos.cadastro.PessoaDAO;
import graficaatual.entidades.Bairro;
import graficaatual.entidades.Cargo;
import graficaatual.entidades.Cidade;
import graficaatual.entidades.Cliente;
import graficaatual.entidades.Colaborador;
import graficaatual.entidades.Logradouro;
import graficaatual.entidades.Pessoa;
import graficaatual.pesq.cadastro.CnvCadastroCliente;
import graficaatual.pesq.cadastro.CnvCadastroColaborador;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author si10
 */
public class FCadUsuario extends javax.swing.JInternalFrame {

    private static int initControle;
    private int localIncusao;
    private static FCadUsuario instance;
    private static FCadUsuario instanceCont;
    
    private Pessoa pessoa = null;
    private PessoaDAO pessoaDao = new PessoaDAO();
    
    private Cliente cliente = null;
    private ClienteDAO clienteDao = new ClienteDAO();

    private Colaborador colaborador = null;
    private ColaboradorDAO colaboradorDao = new ColaboradorDAO();

    private Cargo cargo = null;
    private CargoDAO cargoDao = new CargoDAO();

    private Logradouro logradouro = null;
    private LogradouroDAO logradouroDao = new LogradouroDAO();

    private Bairro bairro = null;
    private BairroDAO bairroDao = new BairroDAO();

    private Cidade cidade = null;
    private CidadeDAO cidadeDao = new CidadeDAO();

//Lista Suspensa
    private List<Colaborador> listaColaboradorNome = null;
    private List<Pessoa> listaPessoaNome = null;
    private List<Pessoa> listaPessoaNomeColaborador = null;
    private List<Pessoa> listaPessoaCPF = null;
    private List<Pessoa> listaPessoaCPFColaborador = null;
    private List<Logradouro> listaLogradouroNome = null;
    private List<Bairro> listaBairroNome = null;
    private List<Cidade> listaCidadeNome = null;

//Controle Navegação
    CnvCadastroColaborador cnvColaboradorCad = new CnvCadastroColaborador();
    CnvCadastroCliente cnvClienteCad = new CnvCadastroCliente();

    public FCadUsuario() {
        initComponents();
         ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        
//         listaPessoaNome = ObservableCollections.observableList(new LinkedList<Pessoa>());
//        Componentes comp1 = new Componentes(listaPessoaNome, false, codPessoa, nomePessoa, this, jPanel10, nomePessoa.getWidth(), 100);
//        comp1.addCol(0, "codPessoa", "Código", 50, Long.class.getName());
//        comp1.addCol(1, "cnpj", "CPF/CNPJ", 100, String.class.getName());
//        comp1.addCol(2, "nome", "Nome", 200, String.class.getName());
//        comp1.bind();
//        
//
//        listaLogradouroNome = ObservableCollections.observableList(new LinkedList<Logradouro>());
//        Componentes comp2 = new Componentes(listaLogradouroNome, false, codLogradouroPessoa, descLogradouroPessoa, this, jPanel10, descLogradouroPessoa.getWidth(), 100);
//        comp2.addCol(0, "codLogradouro", "Código", 50, Long.class.getName());
//        comp2.addCol(1, "descricao", "Nome", 200, String.class.getName());
//        comp2.bind();
//
//        listaBairroNome = ObservableCollections.observableList(new LinkedList<Bairro>());
//        Componentes comp3 = new Componentes(listaBairroNome, false, codBairroPessoa, descBairroPessoa, this, jPanel10, descBairroPessoa.getWidth(), 100);
//        comp3.addCol(0, "codBairro", "Código", 50, Long.class.getName());
//        comp3.addCol(1, "descricao", "Nome", 200, String.class.getName());
//        comp3.bind();
//
//        listaCidadeNome = ObservableCollections.observableList(new LinkedList<Cidade>());
//        Componentes comp4 = new Componentes(listaCidadeNome, false, codCidadePessoa, descCidadePessoa, this, jPanel10, descCidadePessoa.getWidth(), 100);
//        comp4.addCol(0, "codCidade", "Código", 50, Long.class.getName());
//        comp4.addCol(1, "descricao", "Nome", 200, String.class.getName());
//        comp4.bind();
//
//        listaPessoaCPF = ObservableCollections.observableList(new LinkedList<Pessoa>());
//        Componentes comp5 = new Componentes(listaPessoaCPF, false, codPessoa, cnpjPessoa, this, jPanel10, cnpjPessoa.getWidth(), 100);
//        comp5.addCol(0, "codPessoa", "Código", 50, Long.class.getName());
//        comp5.addCol(1, "cnpj", "CPF/CNPJ", 100, String.class.getName());
//        comp5.addCol(2, "nome", "Nome", 200, String.class.getName());
//        comp5.bind();
//        
//        atualizaTabelaPessoa();
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
     
  public synchronized static FCadUsuario getInstance() {
        if (instance == null) {
            instance = new FCadUsuario();
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
        jLabel1 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        codColaborador = new javax.swing.JTextField();
        nomeColaborador = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        login = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        checkCadastro = new javax.swing.JCheckBox();
        checkFinanceiro = new javax.swing.JCheckBox();
        checkEstoque = new javax.swing.JCheckBox();
        checkProducao = new javax.swing.JCheckBox();
        checkPedidos = new javax.swing.JCheckBox();
        checkRelatorios = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabTelas = new javax.swing.JTable();
        novo = new javax.swing.JButton();
        salvar = new javax.swing.JButton();
        deletar = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabUsuario = new javax.swing.JTable();
        inicio = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        proximo = new javax.swing.JButton();
        ultimo = new javax.swing.JButton();
        pequisar = new javax.swing.JButton();
        jComboModulos = new javax.swing.JComboBox<>();
        confirmacao = new javax.swing.JPasswordField();
        senha = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Castro de Usuário");
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setPreferredSize(new java.awt.Dimension(1100, 700));
        getContentPane().setLayout(null);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setToolTipText("Cadastro de Pessoas");
        jPanel10.setMaximumSize(new java.awt.Dimension(999999, 999999));
        jPanel10.setMinimumSize(new java.awt.Dimension(1100, 700));
        jPanel10.setName(""); // NOI18N
        jPanel10.setPreferredSize(new java.awt.Dimension(1000, 700));
        jPanel10.setLayout(null);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(null);
        jPanel11.add(jTextField33);
        jTextField33.setBounds(160, 10, 90, 20);

        jTextField34.setBackground(new java.awt.Color(255, 255, 204));
        jPanel11.add(jTextField34);
        jTextField34.setBounds(340, 30, 310, 19);

        jTextField35.setBackground(new java.awt.Color(255, 255, 204));
        jPanel11.add(jTextField35);
        jTextField35.setBounds(160, 50, 490, 19);
        jPanel11.add(jTextField36);
        jTextField36.setBounds(120, 160, 80, 19);
        jPanel11.add(jTextField37);
        jTextField37.setBounds(200, 160, 470, 19);
        jPanel11.add(jTextField38);
        jTextField38.setBounds(780, 160, 140, 19);
        jPanel11.add(jTextField39);
        jTextField39.setBounds(120, 180, 80, 19);
        jPanel11.add(jTextField40);
        jTextField40.setBounds(200, 180, 470, 19);
        jPanel11.add(jTextField41);
        jTextField41.setBounds(780, 180, 140, 19);
        jPanel11.add(jTextField42);
        jTextField42.setBounds(120, 200, 80, 19);
        jPanel11.add(jTextField43);
        jTextField43.setBounds(200, 200, 310, 19);
        jPanel11.add(jTextField44);
        jTextField44.setBounds(780, 200, 140, 19);
        jPanel11.add(jTextField45);
        jTextField45.setBounds(580, 200, 90, 19);

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
        jTextField46.setBounds(790, 70, 130, 19);
        jPanel11.add(jTextField47);
        jTextField47.setBounds(790, 30, 130, 19);
        jPanel11.add(jTextField48);
        jTextField48.setBounds(790, 50, 130, 19);

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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Nome:");
        jPanel10.add(jLabel1);
        jLabel1.setBounds(120, 140, 60, 15);
        jPanel10.add(codigo);
        codigo.setBounds(30, 90, 70, 19);
        jPanel10.add(codColaborador);
        codColaborador.setBounds(30, 160, 80, 19);

        nomeColaborador.setBackground(new java.awt.Color(255, 255, 204));
        jPanel10.add(nomeColaborador);
        nomeColaborador.setBounds(110, 160, 340, 19);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Login:");
        jPanel10.add(jLabel5);
        jLabel5.setBounds(30, 200, 60, 20);
        jPanel10.add(login);
        login.setBounds(30, 220, 430, 19);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Senha");
        jPanel10.add(jLabel6);
        jLabel6.setBounds(30, 240, 70, 20);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Confirmação");
        jPanel10.add(jLabel3);
        jLabel3.setBounds(30, 280, 110, 20);

        checkCadastro.setBackground(new java.awt.Color(255, 255, 255));
        checkCadastro.setText("Cadastro");
        jPanel10.add(checkCadastro);
        checkCadastro.setBounds(100, 340, 90, 23);

        checkFinanceiro.setBackground(new java.awt.Color(255, 255, 255));
        checkFinanceiro.setText("Financeiro");
        jPanel10.add(checkFinanceiro);
        checkFinanceiro.setBounds(100, 360, 99, 23);

        checkEstoque.setBackground(new java.awt.Color(255, 255, 255));
        checkEstoque.setText("Estoque");
        checkEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkEstoqueActionPerformed(evt);
            }
        });
        jPanel10.add(checkEstoque);
        checkEstoque.setBounds(100, 380, 83, 23);

        checkProducao.setBackground(new java.awt.Color(255, 255, 255));
        checkProducao.setText("Produção");
        jPanel10.add(checkProducao);
        checkProducao.setBounds(290, 360, 92, 23);

        checkPedidos.setBackground(new java.awt.Color(255, 255, 255));
        checkPedidos.setText("Pedidos");
        checkPedidos.setToolTipText("");
        jPanel10.add(checkPedidos);
        checkPedidos.setBounds(290, 340, 82, 23);

        checkRelatorios.setBackground(new java.awt.Color(255, 255, 255));
        checkRelatorios.setText("Relarórios");
        jPanel10.add(checkRelatorios);
        checkRelatorios.setBounds(290, 380, 98, 23);

        jLabel7.setToolTipText("");
        jLabel7.setBorder(javax.swing.BorderFactory.createTitledBorder("  Módulos  "));
        jPanel10.add(jLabel7);
        jLabel7.setBounds(30, 320, 420, 90);

        tabTelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tela", "Modulo", "Acesso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabTelas);

        jPanel10.add(jScrollPane2);
        jScrollPane2.setBounds(480, 120, 560, 290);

        novo.setText("Novo Cadastro");
        jPanel10.add(novo);
        novo.setBounds(190, 420, 180, 40);

        salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar2.png"))); // NOI18N
        salvar.setText("Salvar/Atualizar");
        jPanel10.add(salvar);
        salvar.setBounds(370, 420, 180, 40);

        deletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excuir2.png"))); // NOI18N
        deletar.setText("Inativar");
        jPanel10.add(deletar);
        deletar.setBounds(550, 420, 180, 40);

        sair.setText("Sair");
        jPanel10.add(sair);
        sair.setBounds(730, 420, 180, 40);

        tabUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Colaborador", "login", "Data Cadastro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(tabUsuario);

        jPanel10.add(jScrollPane1);
        jScrollPane1.setBounds(10, 470, 1030, 160);

        inicio.setText("||<<");
        jPanel10.add(inicio);
        inicio.setBounds(430, 640, 62, 25);

        anterior.setText("<<");
        jPanel10.add(anterior);
        anterior.setBounds(490, 640, 54, 25);

        proximo.setText(">>");
        jPanel10.add(proximo);
        proximo.setBounds(540, 640, 54, 25);

        ultimo.setText(">>||");
        jPanel10.add(ultimo);
        ultimo.setBounds(590, 640, 62, 25);

        pequisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar2.png"))); // NOI18N
        pequisar.setText("Pesquisar");
        jPanel10.add(pequisar);
        pequisar.setBounds(850, 80, 190, 40);

        jComboModulos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "CADASTRO", "FINANCEIRO", "ESTOQUE", "PRODUÇÃO", "RELATÓRIOS" }));
        jPanel10.add(jComboModulos);
        jComboModulos.setBounds(480, 90, 210, 24);

        confirmacao.setText("jPasswordField1");
        jPanel10.add(confirmacao);
        confirmacao.setBounds(30, 300, 280, 19);

        senha.setText("jPasswordField1");
        jPanel10.add(senha);
        senha.setBounds(30, 260, 280, 19);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Código ");
        jPanel10.add(jLabel2);
        jLabel2.setBounds(30, 70, 60, 20);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Código ");
        jPanel10.add(jLabel8);
        jLabel8.setBounds(30, 140, 60, 15);

        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Colaborador"));
        jPanel10.add(jLabel4);
        jLabel4.setBounds(20, 120, 440, 80);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("CADASTRO DE USUÁRIO");
        jPanel10.add(jLabel9);
        jLabel9.setBounds(0, 0, 1130, 70);

        getContentPane().add(jPanel10);
        jPanel10.setBounds(0, 0, 1100, 700);
        jPanel10.getAccessibleContext().setAccessibleName("Cadastro de Pessoas");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkEstoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkEstoqueActionPerformed

    /**
     * @param args the command line arguments
     */
   
    
//    private void limpaCamposPessoa() {
//        codPessoa.setText("");
//        tipoPessoa.setSelectedIndex(0);
//        cnpjPessoa.setText("");
//        inscMunicipalPessoa.setText("");
//        nomePessoa.setText("");
//        inscEstadualPessao.setText("");
//        nomeFantasiaPessoa.setText("");
//        emailPessoa.setText("");
//        telefonePessoa.setText("");
//        dataNascimentoPessoa.setText("");
//
//        codLogradouroPessoa.setText("");
//        descLogradouroPessoa.setText("");
//        numeroPessoa.setText("");
//        codBairroPessoa.setText("");
//        descBairroPessoa.setText("");
//        complementoPessoa.setText("");
//        codCidadePessoa.setText("");
//        descCidadePessoa.setText("");
//        ufPessoa.setText("");
//        cepPessoa.setText("");
//
//        obsPessoa.setText("");
//
//        atualizaTabelaPessoa();
//
//    }

//    private void atualizaTabelaPessoa() {
//        try {
//
//            if (cnvPessoaCad == null) {
//                cnvPessoaCad = new CnvCadastroPessoa();
//            }
//
//            cnvPessoaCad.iniciarNavTabelaPessoa();
//
//            cnvPessoaCad.primeiro();
//            atualizarTabelaPessoaCad();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//    }

//    private void atualizarTabelaPessoaCad() {
//
//        DefaultTableModel model = (DefaultTableModel) tabPessoa.getModel();
//        removeLinhas(tabPessoa);
//
//        List<?> lv;
//
//        lv = cnvPessoaCad.getLista();
//
//        if (lv != null && !lv.isEmpty()) {
//
//            for (Object o : lv) {
//                Object[] os = (Object[]) o;
//                model.addRow(os);
//                //Colocar tamanho nas colunas
//
//            }
//        }
//    }
    

    public static void removeLinhas(JTable table) {
        int n = table.getRowCount();

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (int i = n - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

//    private void carregaPessoa() throws Exception {
//        pessoa = pessoaDao.get(ValidarValor.getLong(codPessoa.getText()));
//        if (pessoa != null) {
//
//            codPessoa.setText(pessoa.getCodPessoa().toString());
//            tipoPessoa.setSelectedIndex(pessoa.getTipoPessoa());
//            cnpjPessoa.setText(pessoa.getCnpj());
//            inscMunicipalPessoa.setText(pessoa.getInscMunicipal());
//            nomePessoa.setText(pessoa.getNome());
//            nomeFantasiaPessoa.setText(pessoa.getNomeFantasia());
//            inscEstadualPessao.setText(pessoa.getInscEstadual());
//            emailPessoa.setText(pessoa.getEmail());
//            telefonePessoa.setText(pessoa.getTelefone());
//            dataNascimentoPessoa.setText(Data.getDateParse(pessoa.getDataNascimento(), Data.FORMAT_DATA));
//
//            codLogradouroPessoa.setText(pessoa.getLogradouro().getCodLogradouro().toString());
//            descLogradouroPessoa.setText(pessoa.getLogradouro().getDescricao());
//            numeroPessoa.setText(pessoa.getNumCasa());
//            codBairroPessoa.setText(pessoa.getBairro().getCodBairro().toString());
//            descBairroPessoa.setText(pessoa.getBairro().getDescricao());
//            complementoPessoa.setText(pessoa.getComplemento());
//            codCidadePessoa.setText(pessoa.getCidade().getCodCidade().toString());
//            descCidadePessoa.setText(pessoa.getCidade().getDescricao());
//            ufPessoa.setText(pessoa.getUf());
//            cepPessoa.setText(pessoa.getCep());
//
//            obsPessoa.setText(pessoa.getObs());
//
//        } else {
//            limpaCamposPessoa();
//            new Exception("Por favor, inserir um código válido.");
//        }
//
//    }
//
//    private void salvarPessoa() throws Exception {
//        Pessoa pessoaAux;
//        if (pessoa != null) {
//            setPessoa();
//            if (codPessoa.getText().equals("")) {
//                pessoaAux = null;
//            } else {
//                pessoaAux = pessoaDao.get(pessoa.getCodPessoa());
//            }
//
//            if (pessoaAux == null) {
//                pessoa = pessoaDao.addUsuario(pessoa);
//
//            } else {
//                pessoa = pessoaDao.addUsuario(pessoa);
//            }
//            atualizaTabelaPessoa();
//        } else {
//            throw new Exception(" Para inserir um cadastro novo, aperte o botão "
//                    + " Novo Cadastro.");
//        }
//    }
//
//    private void setPessoa() {
//        //codPessoa.setText("");
//        pessoa.setTipoPessoa(tipoPessoa.getSelectedIndex());
//        pessoa.setCnpj(cnpjPessoa.getText());
//        pessoa.setInscMunicipal(inscMunicipalPessoa.getText());
//        pessoa.setNome(nomePessoa.getText());
//        pessoa.setInscEstadual(inscEstadualPessao.getText());
//        pessoa.setNomeFantasia(nomeFantasiaPessoa.getText());
//        pessoa.setEmail(emailPessoa.getText());
//        pessoa.setTelefone(telefonePessoa.getText());
//        pessoa.setDataNascimento(Data.getDateUtil(dataNascimentoPessoa.getText()));
//        pessoa.setLogradouro(logradouro);
//        pessoa.setNumCasa(numeroPessoa.getText());
//        pessoa.setBairro(bairro);
//        pessoa.setComplemento(complementoPessoa.getText());
//        pessoa.setCidade(cidade);
//        pessoa.setUf(ufPessoa.getText());
//        pessoa.setCep(cepPessoa.getText());
//        pessoa.setObs(obsPessoa.getText());
//    }
//
//    private void carregaLogCadPessoa() throws Exception {
//        logradouro = logradouroDao.getPorCodigo(ValidarValor.getLong(codLogradouroPessoa.getText()));
//        if (logradouro != null) {
//            codLogradouroPessoa.setText(logradouro.getCodLogradouro().toString());
//            descLogradouroPessoa.setText(logradouro.getDescricao());
//        } else {
//            codLogradouroPessoa.setText("");
//            descLogradouroPessoa.setText("");
//        }
//    }
//
//    private void carregaBairroCadPessoa() throws Exception {
//        bairro = bairroDao.getPorCodigo(ValidarValor.getInt(codBairroPessoa.getText()));
//        if (bairro != null) {
//            codBairroPessoa.setText(bairro.getCodBairro().toString());
//            descBairroPessoa.setText(bairro.getDescricao());
//        } else {
//            codBairroPessoa.setText("");
//            descBairroPessoa.setText("");
//        }
//    }
//
//    private void carregaCidadeCadPessoa() throws Exception {
//        cidade = cidadeDao.getPorCodigo(ValidarValor.getInt(codCidadePessoa.getText()));
//        if (cidade != null) {
//            codCidadePessoa.setText(cidade.getCodCidade().toString());
//            descCidadePessoa.setText(cidade.getDescricao());
//        } else {
//            codCidadePessoa.setText("");
//            descCidadePessoa.setText("");
//        }
//    }
//
//   
//
//    
//
//    private void inativarPessoa() throws Exception {
//        pessoa.setAtivo(false);
//        pessoa = pessoaDao.addUsuario(pessoa);
//        limpaCamposPessoa();
//    }

    

  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anterior;
    private javax.swing.JCheckBox checkCadastro;
    private javax.swing.JCheckBox checkEstoque;
    private javax.swing.JCheckBox checkFinanceiro;
    private javax.swing.JCheckBox checkPedidos;
    private javax.swing.JCheckBox checkProducao;
    private javax.swing.JCheckBox checkRelatorios;
    private javax.swing.JTextField codColaborador;
    private javax.swing.JTextField codigo;
    private javax.swing.JPasswordField confirmacao;
    private javax.swing.JButton deletar;
    private javax.swing.JButton inicio;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboModulos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JTextField login;
    private javax.swing.JTextField nomeColaborador;
    private javax.swing.JButton novo;
    private javax.swing.JButton pequisar;
    private javax.swing.JButton proximo;
    private javax.swing.JButton sair;
    private javax.swing.JButton salvar;
    private javax.swing.JPasswordField senha;
    private javax.swing.JTable tabTelas;
    private javax.swing.JTable tabUsuario;
    private javax.swing.JButton ultimo;
    // End of variables declaration//GEN-END:variables

   
}
