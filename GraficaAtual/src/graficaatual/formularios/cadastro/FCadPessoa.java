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
import graficaatual.pesq.cadastro.CnvCadastroPessoa;
import graficaatual.utilitarios.Componentes;
import graficaatual.utilitarios.Data;
import graficaatual.utilitarios.Persistencia;
import graficaatual.utilitarios.ValidarValor;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author si10
 */
public class FCadPessoa extends javax.swing.JInternalFrame {

    private static int initControle;
    private int localIncusao;
    private static FCadPessoa instance;
    private static FCadPessoa instanceCont;
    
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
    CnvCadastroPessoa cnvPessoaCad = new CnvCadastroPessoa();
    CnvCadastroColaborador cnvColaboradorCad = new CnvCadastroColaborador();
    CnvCadastroCliente cnvClienteCad = new CnvCadastroCliente();

    public FCadPessoa() {
        initComponents();
        
         listaPessoaNome = ObservableCollections.observableList(new LinkedList<Pessoa>());
        Componentes comp1 = new Componentes(listaPessoaNome, false, codPessoa, nomePessoa, this, jPanel10, nomePessoa.getWidth(), 100);
        comp1.addCol(0, "codPessoa", "Código", 50, Long.class.getName());
        comp1.addCol(1, "cnpj", "CPF/CNPJ", 100, String.class.getName());
        comp1.addCol(2, "nome", "Nome", 200, String.class.getName());
        comp1.bind();
        

        listaLogradouroNome = ObservableCollections.observableList(new LinkedList<Logradouro>());
        Componentes comp2 = new Componentes(listaLogradouroNome, false, codLogradouroPessoa, descLogradouroPessoa, this, jPanel10, descLogradouroPessoa.getWidth(), 100);
        comp2.addCol(0, "codLogradouro", "Código", 50, Long.class.getName());
        comp2.addCol(1, "descricao", "Nome", 200, String.class.getName());
        comp2.bind();

        listaBairroNome = ObservableCollections.observableList(new LinkedList<Bairro>());
        Componentes comp3 = new Componentes(listaBairroNome, false, codBairroPessoa, descBairroPessoa, this, jPanel10, descBairroPessoa.getWidth(), 100);
        comp3.addCol(0, "codBairro", "Código", 50, Long.class.getName());
        comp3.addCol(1, "descricao", "Nome", 200, String.class.getName());
        comp3.bind();

        listaCidadeNome = ObservableCollections.observableList(new LinkedList<Cidade>());
        Componentes comp4 = new Componentes(listaCidadeNome, false, codCidadePessoa, descCidadePessoa, this, jPanel10, descCidadePessoa.getWidth(), 100);
        comp4.addCol(0, "codCidade", "Código", 50, Long.class.getName());
        comp4.addCol(1, "descricao", "Nome", 200, String.class.getName());
        comp4.bind();

        listaPessoaCPF = ObservableCollections.observableList(new LinkedList<Pessoa>());
        Componentes comp5 = new Componentes(listaPessoaCPF, false, codPessoa, cnpjPessoa, this, jPanel10, cnpjPessoa.getWidth(), 100);
        comp5.addCol(0, "codPessoa", "Código", 50, Long.class.getName());
        comp5.addCol(1, "cnpj", "CPF/CNPJ", 100, String.class.getName());
        comp5.addCol(2, "nome", "Nome", 200, String.class.getName());
        comp5.bind();
        
        atualizaTabelaPessoa();
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
     
  public synchronized static FCadPessoa getInstance() {
        if (instance == null) {
            instance = new FCadPessoa();
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
        codPessoa = new javax.swing.JTextField();
        codLogradouroPessoa = new javax.swing.JTextField();
        descLogradouroPessoa = new javax.swing.JTextField();
        numeroPessoa = new javax.swing.JTextField();
        codBairroPessoa = new javax.swing.JTextField();
        descBairroPessoa = new javax.swing.JTextField();
        complementoPessoa = new javax.swing.JTextField();
        codCidadePessoa = new javax.swing.JTextField();
        descCidadePessoa = new javax.swing.JTextField();
        cepPessoa = new javax.swing.JTextField();
        ufPessoa = new javax.swing.JTextField();
        tipoPessoa = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cnpjPessoa = new javax.swing.JTextField();
        nomePessoa = new javax.swing.JTextField();
        dataNascimentoPessoa = new javax.swing.JTextField();
        inscMunicipalPessoa = new javax.swing.JTextField();
        inscEstadualPessao = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
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
        jLabel45 = new javax.swing.JLabel();
        emailPessoa = new javax.swing.JTextField();
        telefonePessoa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        obsPessoa = new javax.swing.JTextArea();
        jLabel46 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        salvarPessoa = new javax.swing.JButton();
        InativarPessoa = new javax.swing.JButton();
        sairPessoa = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabPessoa = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        finalPessoa = new javax.swing.JButton();
        proximoPessoa = new javax.swing.JButton();
        anteriorPessoa = new javax.swing.JButton();
        inicioPessoa = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        nomeFantasiaPessoa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        codPessoa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codPessoaFocusLost(evt);
            }
        });
        jPanel10.add(codPessoa);
        codPessoa.setBounds(160, 10, 90, 20);

        codLogradouroPessoa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codLogradouroPessoaFocusLost(evt);
            }
        });
        jPanel10.add(codLogradouroPessoa);
        codLogradouroPessoa.setBounds(120, 130, 80, 19);

        descLogradouroPessoa.setBackground(new java.awt.Color(255, 255, 204));
        descLogradouroPessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descLogradouroPessoaKeyReleased(evt);
            }
        });
        jPanel10.add(descLogradouroPessoa);
        descLogradouroPessoa.setBounds(200, 130, 360, 19);
        jPanel10.add(numeroPessoa);
        numeroPessoa.setBounds(710, 130, 140, 19);

        codBairroPessoa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codBairroPessoaFocusLost(evt);
            }
        });
        jPanel10.add(codBairroPessoa);
        codBairroPessoa.setBounds(120, 150, 80, 19);

        descBairroPessoa.setBackground(new java.awt.Color(255, 255, 204));
        descBairroPessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descBairroPessoaKeyReleased(evt);
            }
        });
        jPanel10.add(descBairroPessoa);
        descBairroPessoa.setBounds(200, 150, 360, 19);
        jPanel10.add(complementoPessoa);
        complementoPessoa.setBounds(710, 150, 140, 19);

        codCidadePessoa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codCidadePessoaFocusLost(evt);
            }
        });
        jPanel10.add(codCidadePessoa);
        codCidadePessoa.setBounds(120, 170, 80, 19);

        descCidadePessoa.setBackground(new java.awt.Color(255, 255, 204));
        descCidadePessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descCidadePessoaKeyReleased(evt);
            }
        });
        jPanel10.add(descCidadePessoa);
        descCidadePessoa.setBounds(200, 170, 240, 19);
        jPanel10.add(cepPessoa);
        cepPessoa.setBounds(710, 170, 140, 19);
        jPanel10.add(ufPessoa);
        ufPessoa.setBounds(490, 170, 70, 19);

        tipoPessoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Física", "Juridica" }));
        jPanel10.add(tipoPessoa);
        tipoPessoa.setBounds(160, 30, 180, 18);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("UF: ");
        jPanel10.add(jLabel23);
        jLabel23.setBounds(440, 170, 50, 20);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("CEP: ");
        jPanel10.add(jLabel22);
        jLabel22.setBounds(600, 170, 110, 20);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Código: ");
        jPanel10.add(jLabel13);
        jLabel13.setBounds(80, 10, 80, 20);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Observação: ");
        jPanel10.add(jLabel15);
        jLabel15.setBounds(20, 200, 100, 20);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Número: ");
        jPanel10.add(jLabel16);
        jLabel16.setBounds(600, 130, 110, 20);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Insc. Estadual: ");
        jPanel10.add(jLabel17);
        jLabel17.setBounds(570, 50, 140, 20);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Bairro: ");
        jPanel10.add(jLabel18);
        jLabel18.setBounds(20, 150, 100, 20);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Logradouro: ");
        jPanel10.add(jLabel19);
        jLabel19.setBounds(20, 130, 100, 20);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Complemento: ");
        jPanel10.add(jLabel20);
        jLabel20.setBounds(600, 150, 110, 20);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Cidade: ");
        jPanel10.add(jLabel21);
        jLabel21.setBounds(20, 170, 100, 20);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço:"));
        jPanel10.add(jLabel14);
        jLabel14.setBounds(20, 110, 850, 90);

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("CPF/CNPJ: ");
        jPanel10.add(jLabel28);
        jLabel28.setBounds(80, 30, 80, 20);

        cnpjPessoa.setBackground(new java.awt.Color(255, 255, 204));
        cnpjPessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cnpjPessoaKeyReleased(evt);
            }
        });
        jPanel10.add(cnpjPessoa);
        cnpjPessoa.setBounds(340, 30, 220, 19);

        nomePessoa.setBackground(new java.awt.Color(255, 255, 204));
        nomePessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomePessoaKeyReleased(evt);
            }
        });
        jPanel10.add(nomePessoa);
        nomePessoa.setBounds(160, 50, 400, 19);
        jPanel10.add(dataNascimentoPessoa);
        dataNascimentoPessoa.setBounds(710, 70, 140, 19);
        jPanel10.add(inscMunicipalPessoa);
        inscMunicipalPessoa.setBounds(710, 30, 140, 19);
        jPanel10.add(inscEstadualPessao);
        inscEstadualPessao.setBounds(710, 50, 140, 19);

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Email: ");
        jPanel10.add(jLabel29);
        jLabel29.setBounds(10, 90, 150, 20);

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Insc. Munícipal: ");
        jPanel10.add(jLabel30);
        jLabel30.setBounds(570, 30, 140, 20);

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

        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel45.setText("Nome Fantasia: ");
        jPanel10.add(jLabel45);
        jLabel45.setBounds(10, 70, 150, 20);
        jPanel10.add(emailPessoa);
        emailPessoa.setBounds(160, 90, 400, 19);
        jPanel10.add(telefonePessoa);
        telefonePessoa.setBounds(710, 90, 140, 19);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Telefone: ");
        jPanel10.add(jLabel9);
        jLabel9.setBounds(620, 90, 90, 20);

        obsPessoa.setColumns(20);
        obsPessoa.setRows(4);
        jScrollPane4.setViewportView(obsPessoa);

        jPanel10.add(jScrollPane4);
        jScrollPane4.setBounds(20, 220, 840, 70);

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel46.setText("Data Nascimento: ");
        jPanel10.add(jLabel46);
        jLabel46.setBounds(570, 70, 140, 20);

        jButton17.setText("Novo Cadastro");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton17);
        jButton17.setBounds(90, 300, 180, 25);

        salvarPessoa.setText("Salvar/Atualizar");
        salvarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarPessoaActionPerformed(evt);
            }
        });
        jPanel10.add(salvarPessoa);
        salvarPessoa.setBounds(270, 300, 180, 25);

        InativarPessoa.setText("Inativar");
        InativarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InativarPessoaActionPerformed(evt);
            }
        });
        jPanel10.add(InativarPessoa);
        InativarPessoa.setBounds(450, 300, 180, 25);

        sairPessoa.setText("Sair");
        sairPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairPessoaActionPerformed(evt);
            }
        });
        jPanel10.add(sairPessoa);
        sairPessoa.setBounds(630, 300, 180, 25);

        tabPessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "CPF", "Nome", "Nome Fantasia", "Ativo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
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
        tabPessoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPessoaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabPessoa);

        jPanel10.add(jScrollPane5);
        jScrollPane5.setBounds(20, 340, 840, 120);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        finalPessoa.setText(">>||");
        finalPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalPessoaActionPerformed(evt);
            }
        });

        proximoPessoa.setText(">>");
        proximoPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoPessoaActionPerformed(evt);
            }
        });

        anteriorPessoa.setText("<<");
        anteriorPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorPessoaActionPerformed(evt);
            }
        });

        inicioPessoa.setText("||<<");
        inicioPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioPessoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(inicioPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anteriorPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(proximoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finalPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 36, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(anteriorPessoa)
                        .addComponent(inicioPessoa))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(proximoPessoa)
                        .addComponent(finalPessoa)))
                .addGap(23, 23, 23))
        );

        jPanel10.add(jPanel12);
        jPanel12.setBounds(260, 460, 430, 40);

        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel71.setText("Nome/Razão Socia: ");
        jPanel10.add(jLabel71);
        jLabel71.setBounds(10, 50, 150, 20);
        jPanel10.add(nomeFantasiaPessoa);
        nomeFantasiaPessoa.setBounds(160, 70, 400, 19);

        getContentPane().add(jPanel10);
        jPanel10.setBounds(0, 0, 880, 510);
        jPanel10.getAccessibleContext().setAccessibleName("Cadastro de Pessoas");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codPessoaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codPessoaFocusLost
        try {
            carregaPessoa();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codPessoaFocusLost

    private void codLogradouroPessoaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codLogradouroPessoaFocusLost
        try {
            carregaLogCadPessoa();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codLogradouroPessoaFocusLost

    private void descLogradouroPessoaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descLogradouroPessoaKeyReleased
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            List<Logradouro> merged = new LogradouroDAO().getPureList(session, 0, 12, Logradouro.class,
                "select e from Logradouro e where lower ( trim(e.descricao) ) like ?1 order by e.descricao",
                descLogradouroPessoa.getText().trim().toLowerCase() + "%");
            listaLogradouroNome.clear();
            listaLogradouroNome.addAll(merged);
        } catch (Exception e) {
        } finally {
            session.close();
        }
    }//GEN-LAST:event_descLogradouroPessoaKeyReleased

    private void codBairroPessoaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codBairroPessoaFocusLost
        try {
            carregaBairroCadPessoa();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codBairroPessoaFocusLost

    private void descBairroPessoaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descBairroPessoaKeyReleased
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            List<Bairro> merged = new BairroDAO().getPureList(session, 0, 12, Bairro.class,
                "select e from Bairro e where lower ( trim(e.descricao) ) like ?1 order by e.descricao",
                descBairroPessoa.getText().trim().toLowerCase() + "%");
            listaBairroNome.clear();
            listaBairroNome.addAll(merged);
        } catch (Exception e) {
        } finally {
            session.close();
        }
    }//GEN-LAST:event_descBairroPessoaKeyReleased

    private void codCidadePessoaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codCidadePessoaFocusLost
        try {
            carregaCidadeCadPessoa();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codCidadePessoaFocusLost

    private void descCidadePessoaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descCidadePessoaKeyReleased
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            List<Cidade> merged = new CidadeDAO().getPureList(session, 0, 12, Cidade.class,
                "select e from Cidade e where lower ( trim(e.descricao) ) like ?1 order by e.descricao",
                descCidadePessoa.getText().trim().toLowerCase() + "%");
            listaCidadeNome.clear();
            listaCidadeNome.addAll(merged);
        } catch (Exception e) {
        } finally {
            session.close();
        }
    }//GEN-LAST:event_descCidadePessoaKeyReleased

    private void cnpjPessoaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnpjPessoaKeyReleased
        try {
            List<Pessoa> merged = pessoaDao.getList(15, "select e from Pessoa e where e.ativo='true' and  REPLACE(REPLACE(REPLACE(trim(e.cnpj),'.',''),'-',''),' ', '') like ?1 order by e.cnpj", cnpjPessoa.getText().trim().toLowerCase().replace(".", "").replace("-", "").trim() + "%");
            listaPessoaCPF.clear();
            listaPessoaCPF.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar pessoas. Erro: " + e);
        }
    }//GEN-LAST:event_cnpjPessoaKeyReleased

    private void nomePessoaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomePessoaKeyReleased
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            List<Pessoa> merged = pessoaDao.getPureList(session, 0, 12, Pessoa.class,
                "select e from Pessoa e where e.ativo='true' and  lower ( trim(e.nome) ) like ?1 order by e.nome",
                nomePessoa.getText().trim().toLowerCase() + "%");
            listaPessoaNome.clear();
            listaPessoaNome.addAll(merged);
        } catch (Exception e) {
        } finally {
            session.close();
        }
    }//GEN-LAST:event_nomePessoaKeyReleased

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        pessoa = new Pessoa();
        limpaCamposPessoa();
        tipoPessoa.requestFocus();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void salvarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarPessoaActionPerformed
        try {
            salvarPessoa();
            JOptionPane.showMessageDialog(this, " Cadastro realizado com Sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_salvarPessoaActionPerformed

    private void InativarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InativarPessoaActionPerformed
        try {
            if (pessoa != null) {
                Integer resp = JOptionPane.showConfirmDialog(this, "Deseja realmente Inativar essa Pessoa.");
                if (resp == 0) {
                    inativarPessoa();
                    atualizaTabelaPessoa();
                }
            } else {
                throw new Exception(" Por Favor, Selecione uma Pessoa.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_InativarPessoaActionPerformed

    private void sairPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairPessoaActionPerformed
        dispose();
    }//GEN-LAST:event_sairPessoaActionPerformed

    private void tabPessoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPessoaMouseClicked
        if (evt.getClickCount() > 1) {
            codPessoa.setText(("" + tabPessoa.getValueAt(tabPessoa.getSelectedRow(), 0)));
            codPessoaFocusLost(null);
            nomePessoa.requestFocus();
        }
    }//GEN-LAST:event_tabPessoaMouseClicked

    private void finalPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalPessoaActionPerformed
        try {
            if (cnvPessoaCad == null) {
                atualizaTabelaPessoa();
            } else {
                cnvPessoaCad.ultimo();
                atualizarTabelaPessoaCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_finalPessoaActionPerformed

    private void proximoPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoPessoaActionPerformed
        try {
            if (cnvPessoaCad == null) {
                atualizaTabelaPessoa();
            } else {
                cnvPessoaCad.proximo();
                atualizarTabelaPessoaCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_proximoPessoaActionPerformed

    private void anteriorPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorPessoaActionPerformed
        try {
            if (cnvPessoaCad == null) {
                atualizaTabelaPessoa();
            } else {
                cnvPessoaCad.anterior();
                atualizarTabelaPessoaCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_anteriorPessoaActionPerformed

    private void inicioPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioPessoaActionPerformed
        try {
            if (cnvPessoaCad == null) {
                atualizaTabelaPessoa();
            } else {
                cnvPessoaCad.primeiro();
                atualizarTabelaPessoaCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_inicioPessoaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FCadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FCadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FCadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FCadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FCadPessoa().setVisible(true);
            }
        });
    }
    
    private void limpaCamposPessoa() {
        codPessoa.setText("");
        tipoPessoa.setSelectedIndex(0);
        cnpjPessoa.setText("");
        inscMunicipalPessoa.setText("");
        nomePessoa.setText("");
        inscEstadualPessao.setText("");
        nomeFantasiaPessoa.setText("");
        emailPessoa.setText("");
        telefonePessoa.setText("");
        dataNascimentoPessoa.setText("");

        codLogradouroPessoa.setText("");
        descLogradouroPessoa.setText("");
        numeroPessoa.setText("");
        codBairroPessoa.setText("");
        descBairroPessoa.setText("");
        complementoPessoa.setText("");
        codCidadePessoa.setText("");
        descCidadePessoa.setText("");
        ufPessoa.setText("");
        cepPessoa.setText("");

        obsPessoa.setText("");

        atualizaTabelaPessoa();

    }

    private void atualizaTabelaPessoa() {
        try {

            if (cnvPessoaCad == null) {
                cnvPessoaCad = new CnvCadastroPessoa();
            }

            cnvPessoaCad.iniciarNavTabelaPessoa();

            cnvPessoaCad.primeiro();
            atualizarTabelaPessoaCad();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void atualizarTabelaPessoaCad() {

        DefaultTableModel model = (DefaultTableModel) tabPessoa.getModel();
        removeLinhas(tabPessoa);

        List<?> lv;

        lv = cnvPessoaCad.getLista();

        if (lv != null && !lv.isEmpty()) {

            for (Object o : lv) {
                Object[] os = (Object[]) o;
                model.addRow(os);
                //Colocar tamanho nas colunas

            }
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
        pessoa = pessoaDao.get(ValidarValor.getLong(codPessoa.getText()));
        if (pessoa != null) {

            codPessoa.setText(pessoa.getCodPessoa().toString());
            tipoPessoa.setSelectedIndex(pessoa.getTipoPessoa());
            cnpjPessoa.setText(pessoa.getCnpj());
            inscMunicipalPessoa.setText(pessoa.getInscMunicipal());
            nomePessoa.setText(pessoa.getNome());
            nomeFantasiaPessoa.setText(pessoa.getNomeFantasia());
            inscEstadualPessao.setText(pessoa.getInscEstadual());
            emailPessoa.setText(pessoa.getEmail());
            telefonePessoa.setText(pessoa.getTelefone());
            dataNascimentoPessoa.setText(Data.getDateParse(pessoa.getDataNascimento(), Data.FORMAT_DATA));

            codLogradouroPessoa.setText(pessoa.getLogradouro().getCodLogradouro().toString());
            descLogradouroPessoa.setText(pessoa.getLogradouro().getDescricao());
            numeroPessoa.setText(pessoa.getNumCasa());
            codBairroPessoa.setText(pessoa.getBairro().getCodBairro().toString());
            descBairroPessoa.setText(pessoa.getBairro().getDescricao());
            complementoPessoa.setText(pessoa.getComplemento());
            codCidadePessoa.setText(pessoa.getCidade().getCodCidade().toString());
            descCidadePessoa.setText(pessoa.getCidade().getDescricao());
            ufPessoa.setText(pessoa.getUf());
            cepPessoa.setText(pessoa.getCep());

            obsPessoa.setText(pessoa.getObs());

        } else {
            limpaCamposPessoa();
            new Exception("Por favor, inserir um código válido.");
        }

    }

    private void salvarPessoa() throws Exception {
        Pessoa pessoaAux;
        if (pessoa != null) {
            setPessoa();
            if (codPessoa.getText().equals("")) {
                pessoaAux = null;
            } else {
                pessoaAux = pessoaDao.get(pessoa.getCodPessoa());
            }

            if (pessoaAux == null) {
                pessoa = pessoaDao.addUsuario(pessoa);

            } else {
                pessoa = pessoaDao.addUsuario(pessoa);
            }
            atualizaTabelaPessoa();
        } else {
            throw new Exception(" Para inserir um cadastro novo, aperte o botão "
                    + " Novo Cadastro.");
        }
    }

    private void setPessoa() {
        //codPessoa.setText("");
        pessoa.setTipoPessoa(tipoPessoa.getSelectedIndex());
        pessoa.setCnpj(cnpjPessoa.getText());
        pessoa.setInscMunicipal(inscMunicipalPessoa.getText());
        pessoa.setNome(nomePessoa.getText());
        pessoa.setInscEstadual(inscEstadualPessao.getText());
        pessoa.setNomeFantasia(nomeFantasiaPessoa.getText());
        pessoa.setEmail(emailPessoa.getText());
        pessoa.setTelefone(telefonePessoa.getText());
        pessoa.setDataNascimento(Data.getDateUtil(dataNascimentoPessoa.getText()));
        pessoa.setLogradouro(logradouro);
        pessoa.setNumCasa(numeroPessoa.getText());
        pessoa.setBairro(bairro);
        pessoa.setComplemento(complementoPessoa.getText());
        pessoa.setCidade(cidade);
        pessoa.setUf(ufPessoa.getText());
        pessoa.setCep(cepPessoa.getText());
        pessoa.setObs(obsPessoa.getText());
    }

    private void carregaLogCadPessoa() throws Exception {
        logradouro = logradouroDao.getPorCodigo(ValidarValor.getLong(codLogradouroPessoa.getText()));
        if (logradouro != null) {
            codLogradouroPessoa.setText(logradouro.getCodLogradouro().toString());
            descLogradouroPessoa.setText(logradouro.getDescricao());
        } else {
            codLogradouroPessoa.setText("");
            descLogradouroPessoa.setText("");
        }
    }

    private void carregaBairroCadPessoa() throws Exception {
        bairro = bairroDao.getPorCodigo(ValidarValor.getInt(codBairroPessoa.getText()));
        if (bairro != null) {
            codBairroPessoa.setText(bairro.getCodBairro().toString());
            descBairroPessoa.setText(bairro.getDescricao());
        } else {
            codBairroPessoa.setText("");
            descBairroPessoa.setText("");
        }
    }

    private void carregaCidadeCadPessoa() throws Exception {
        cidade = cidadeDao.getPorCodigo(ValidarValor.getInt(codCidadePessoa.getText()));
        if (cidade != null) {
            codCidadePessoa.setText(cidade.getCodCidade().toString());
            descCidadePessoa.setText(cidade.getDescricao());
        } else {
            codCidadePessoa.setText("");
            descCidadePessoa.setText("");
        }
    }

   

    

    private void inativarPessoa() throws Exception {
        pessoa.setAtivo(false);
        pessoa = pessoaDao.addUsuario(pessoa);
        limpaCamposPessoa();
    }

    

  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton InativarPessoa;
    private javax.swing.JButton anteriorPessoa;
    private javax.swing.JTextField cepPessoa;
    private javax.swing.JTextField cnpjPessoa;
    private javax.swing.JTextField codBairroPessoa;
    private javax.swing.JTextField codCidadePessoa;
    private javax.swing.JTextField codLogradouroPessoa;
    private javax.swing.JTextField codPessoa;
    private javax.swing.JTextField complementoPessoa;
    private javax.swing.JTextField dataNascimentoPessoa;
    private javax.swing.JTextField descBairroPessoa;
    private javax.swing.JTextField descCidadePessoa;
    private javax.swing.JTextField descLogradouroPessoa;
    private javax.swing.JTextField emailPessoa;
    private javax.swing.JButton finalPessoa;
    private javax.swing.JButton inicioPessoa;
    private javax.swing.JTextField inscEstadualPessao;
    private javax.swing.JTextField inscMunicipalPessoa;
    private javax.swing.JButton jButton17;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
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
    private javax.swing.JTextField nomeFantasiaPessoa;
    private javax.swing.JTextField nomePessoa;
    private javax.swing.JTextField numeroPessoa;
    private javax.swing.JTextArea obsPessoa;
    private javax.swing.JButton proximoPessoa;
    private javax.swing.JButton sairPessoa;
    private javax.swing.JButton salvarPessoa;
    private javax.swing.JTable tabPessoa;
    private javax.swing.JTextField telefonePessoa;
    private javax.swing.JComboBox<String> tipoPessoa;
    private javax.swing.JTextField ufPessoa;
    // End of variables declaration//GEN-END:variables

   
}
