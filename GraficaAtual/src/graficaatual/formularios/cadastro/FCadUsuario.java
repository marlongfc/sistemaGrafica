/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.cadastro;

import graficaatual.daos.cadsatro.BairroDAO;
import graficaatual.daos.cadsatro.CargoDAO;
import graficaatual.daos.cadsatro.CidadeDAO;
import graficaatual.daos.cadsatro.ClienteDAO;
import graficaatual.daos.cadsatro.ColaboradorDAO;
import graficaatual.daos.cadsatro.LogradouroDAO;
import graficaatual.daos.cadsatro.PessoaDAO;
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
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Castro de Usuário");
        setMinimumSize(new java.awt.Dimension(890, 550));
        setPreferredSize(new java.awt.Dimension(890, 550));
        getContentPane().setLayout(null);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setToolTipText("Cadastro de Pessoas");
        jPanel10.setMaximumSize(new java.awt.Dimension(880, 550));
        jPanel10.setMinimumSize(new java.awt.Dimension(880, 550));
        jPanel10.setName(""); // NOI18N
        jPanel10.setPreferredSize(new java.awt.Dimension(880, 550));
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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Código: ");
        jPanel10.add(jLabel1);
        jLabel1.setBounds(80, 20, 60, 15);
        jPanel10.add(jTextField1);
        jTextField1.setBounds(140, 20, 70, 19);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Colaborador: ");
        jPanel10.add(jLabel2);
        jLabel2.setBounds(40, 40, 100, 15);
        jPanel10.add(jTextField2);
        jTextField2.setBounds(140, 40, 70, 19);

        jTextField3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel10.add(jTextField3);
        jTextField3.setBounds(210, 40, 190, 19);

        jTextField4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel10.add(jTextField4);
        jTextField4.setBounds(400, 40, 430, 19);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Login: ");
        jPanel10.add(jLabel5);
        jLabel5.setBounds(80, 60, 60, 15);
        jPanel10.add(jTextField5);
        jTextField5.setBounds(140, 60, 260, 19);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Senha: ");
        jPanel10.add(jLabel6);
        jLabel6.setBounds(70, 80, 70, 15);
        jPanel10.add(jTextField7);
        jTextField7.setBounds(140, 80, 260, 19);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Confirmação: ");
        jPanel10.add(jLabel3);
        jLabel3.setBounds(30, 100, 110, 15);
        jPanel10.add(jTextField6);
        jTextField6.setBounds(140, 100, 260, 19);

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("Cadastro");
        jPanel10.add(jCheckBox2);
        jCheckBox2.setBounds(60, 170, 90, 23);

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setText("Financeiro");
        jPanel10.add(jCheckBox3);
        jCheckBox3.setBounds(60, 210, 99, 23);

        jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setText("Estoque");
        jPanel10.add(jCheckBox4);
        jCheckBox4.setBounds(60, 250, 83, 23);

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Produção");
        jPanel10.add(jCheckBox1);
        jCheckBox1.setBounds(210, 210, 92, 23);

        jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox6.setText("Pedidos");
        jCheckBox6.setToolTipText("");
        jPanel10.add(jCheckBox6);
        jCheckBox6.setBounds(210, 170, 82, 23);

        jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setText("Relarórios");
        jPanel10.add(jCheckBox5);
        jCheckBox5.setBounds(210, 250, 98, 23);

        jLabel7.setToolTipText("");
        jLabel7.setBorder(javax.swing.BorderFactory.createTitledBorder("  Módulos  "));
        jPanel10.add(jLabel7);
        jLabel7.setBounds(20, 140, 330, 150);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jPanel10.add(jScrollPane2);
        jScrollPane2.setBounds(420, 70, 410, 230);

        jButton8.setText("Novo Cadastro");
        jPanel10.add(jButton8);
        jButton8.setBounds(90, 310, 180, 25);

        jButton5.setText("Salvar/Atualizar");
        jPanel10.add(jButton5);
        jButton5.setBounds(270, 310, 180, 25);

        jButton6.setText("Inativar");
        jPanel10.add(jButton6);
        jButton6.setBounds(450, 310, 180, 25);

        jButton7.setText("Sair");
        jPanel10.add(jButton7);
        jButton7.setBounds(630, 310, 180, 25);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel10.add(jScrollPane1);
        jScrollPane1.setBounds(30, 340, 810, 130);

        jButton1.setText("||<<");
        jPanel10.add(jButton1);
        jButton1.setBounds(310, 470, 62, 25);

        jButton2.setText("<<");
        jPanel10.add(jButton2);
        jButton2.setBounds(370, 470, 54, 25);

        jButton3.setText(">>");
        jPanel10.add(jButton3);
        jButton3.setBounds(420, 470, 54, 25);

        jButton4.setText(">>||");
        jPanel10.add(jButton4);
        jButton4.setBounds(470, 470, 62, 25);

        getContentPane().add(jPanel10);
        jPanel10.setBounds(0, 0, 880, 520);
        jPanel10.getAccessibleContext().setAccessibleName("Cadastro de Pessoas");

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JComboBox<String> jComboBox2;
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
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables

   
}
