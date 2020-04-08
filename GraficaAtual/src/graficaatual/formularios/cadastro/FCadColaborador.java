/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.cadastro;

import graficaatual.daos.cadsatro.BairroDAO;
import graficaatual.daos.cadsatro.CargoDAO;
import graficaatual.daos.cadsatro.CidadeDAO;
import graficaatual.daos.cadsatro.ColaboradorDAO;
import graficaatual.daos.cadsatro.LogradouroDAO;
import graficaatual.daos.cadsatro.PessoaDAO;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
        Componentes comp2 = new Componentes(listaColaboradorCPF, false, codigo, cnpj, this, jPanel10, cnpj.getWidth(), 100);
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
        
        
        atualizaTabelaColaborador();
        
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
        jLabel14 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cnpj = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        dataNascimento = new javax.swing.JTextField();
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
        jLabel12 = new javax.swing.JLabel();
        codCargo = new javax.swing.JTextField();
        descCargo = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        dtInicioContrato = new javax.swing.JTextField();
        dtFimContrato = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        ctps = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        salario = new javax.swing.JTextField();
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

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Colaborador");
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

        codigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigoFocusLost(evt);
            }
        });
        jPanel10.add(codigo);
        codigo.setBounds(110, 10, 90, 20);

        codLogradouro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codLogradouroFocusLost(evt);
            }
        });
        jPanel10.add(codLogradouro);
        codLogradouro.setBounds(130, 160, 80, 19);

        descLogradouro.setBackground(new java.awt.Color(255, 255, 204));
        descLogradouro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descLogradouroKeyReleased(evt);
            }
        });
        jPanel10.add(descLogradouro);
        descLogradouro.setBounds(210, 160, 360, 19);
        jPanel10.add(numero);
        numero.setBounds(710, 160, 140, 19);

        codBairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codBairroFocusLost(evt);
            }
        });
        jPanel10.add(codBairro);
        codBairro.setBounds(130, 180, 80, 19);

        descBairro.setBackground(new java.awt.Color(255, 255, 204));
        descBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descBairroKeyReleased(evt);
            }
        });
        jPanel10.add(descBairro);
        descBairro.setBounds(210, 180, 360, 19);
        jPanel10.add(complemento);
        complemento.setBounds(710, 180, 140, 19);

        codCidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codCidadeFocusLost(evt);
            }
        });
        jPanel10.add(codCidade);
        codCidade.setBounds(130, 200, 80, 19);

        descCidade.setBackground(new java.awt.Color(255, 255, 204));
        descCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descCidadeKeyReleased(evt);
            }
        });
        jPanel10.add(descCidade);
        descCidade.setBounds(210, 200, 240, 19);
        jPanel10.add(cep);
        cep.setBounds(710, 200, 140, 19);
        jPanel10.add(uf);
        uf.setBounds(500, 200, 70, 19);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("UF: ");
        jPanel10.add(jLabel23);
        jLabel23.setBounds(450, 200, 50, 20);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("CEP: ");
        jPanel10.add(jLabel22);
        jLabel22.setBounds(600, 200, 110, 20);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Código: ");
        jPanel10.add(jLabel13);
        jLabel13.setBounds(30, 10, 80, 20);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Observação: ");
        jPanel10.add(jLabel15);
        jLabel15.setBounds(30, 230, 100, 20);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Número: ");
        jPanel10.add(jLabel16);
        jLabel16.setBounds(600, 160, 110, 20);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Bairro: ");
        jPanel10.add(jLabel18);
        jLabel18.setBounds(30, 180, 100, 20);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Logradouro: ");
        jPanel10.add(jLabel19);
        jLabel19.setBounds(30, 160, 100, 20);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Complemento: ");
        jPanel10.add(jLabel20);
        jLabel20.setBounds(600, 180, 110, 20);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Cidade: ");
        jPanel10.add(jLabel21);
        jLabel21.setBounds(30, 200, 100, 20);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço:"));
        jPanel10.add(jLabel14);
        jLabel14.setBounds(30, 140, 830, 90);

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("CPF: ");
        jPanel10.add(jLabel28);
        jLabel28.setBounds(30, 30, 80, 20);

        cnpj.setBackground(new java.awt.Color(255, 255, 204));
        cnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cnpjKeyReleased(evt);
            }
        });
        jPanel10.add(cnpj);
        cnpj.setBounds(110, 30, 400, 19);

        nome.setBackground(new java.awt.Color(255, 255, 204));
        nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeKeyReleased(evt);
            }
        });
        jPanel10.add(nome);
        nome.setBounds(110, 50, 400, 19);
        jPanel10.add(dataNascimento);
        dataNascimento.setBounds(720, 30, 140, 19);

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Email: ");
        jPanel10.add(jLabel29);
        jLabel29.setBounds(30, 90, 80, 20);

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
        jPanel10.add(email);
        email.setBounds(110, 90, 400, 19);
        jPanel10.add(telefone);
        telefone.setBounds(720, 50, 140, 19);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Telefone: ");
        jPanel10.add(jLabel9);
        jLabel9.setBounds(630, 50, 90, 20);

        obs.setColumns(20);
        obs.setRows(2);
        jScrollPane4.setViewportView(obs);

        jPanel10.add(jScrollPane4);
        jScrollPane4.setBounds(30, 250, 830, 50);

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel46.setText("Data Nascimento: ");
        jPanel10.add(jLabel46);
        jLabel46.setBounds(580, 30, 140, 20);

        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel71.setText("Nome: ");
        jPanel10.add(jLabel71);
        jLabel71.setBounds(30, 50, 80, 20);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Cargo: ");
        jPanel10.add(jLabel12);
        jLabel12.setBounds(30, 70, 80, 20);

        codCargo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codCargoFocusLost(evt);
            }
        });
        jPanel10.add(codCargo);
        codCargo.setBounds(110, 70, 70, 20);

        descCargo.setBackground(new java.awt.Color(255, 255, 204));
        descCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descCargoKeyReleased(evt);
            }
        });
        jPanel10.add(descCargo);
        descCargo.setBounds(180, 70, 330, 19);

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Data de Início Contrato: ");
        jPanel10.add(jLabel27);
        jLabel27.setBounds(530, 70, 190, 15);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Data de Fim Contrato: ");
        jPanel10.add(jLabel24);
        jLabel24.setBounds(530, 90, 190, 15);
        jPanel10.add(dtInicioContrato);
        dtInicioContrato.setBounds(720, 70, 140, 19);
        jPanel10.add(dtFimContrato);
        dtFimContrato.setBounds(720, 90, 140, 19);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("CTPS: ");
        jPanel10.add(jLabel26);
        jLabel26.setBounds(30, 110, 80, 20);
        jPanel10.add(ctps);
        ctps.setBounds(110, 110, 360, 19);

        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel72.setText("Salário: ");
        jPanel10.add(jLabel72);
        jLabel72.setBounds(640, 110, 80, 20);

        salario.setText("0,00");
        jPanel10.add(salario);
        salario.setBounds(720, 110, 140, 19);

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
        jScrollPane3.setBounds(30, 350, 830, 130);

        inicio.setText("||<<");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });
        jPanel10.add(inicio);
        inicio.setBounds(320, 490, 62, 20);

        anterior.setText("<<");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });
        jPanel10.add(anterior);
        anterior.setBounds(380, 490, 54, 20);

        proximo.setText(">>");
        proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoActionPerformed(evt);
            }
        });
        jPanel10.add(proximo);
        proximo.setBounds(430, 490, 54, 20);

        ultimo.setText(">>||");
        ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ultimoActionPerformed(evt);
            }
        });
        jPanel10.add(ultimo);
        ultimo.setBounds(480, 490, 62, 20);

        novo.setText("Novo Cadastro");
        novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoActionPerformed(evt);
            }
        });
        jPanel10.add(novo);
        novo.setBounds(80, 318, 180, 25);

        salvar.setText("Salvar/Atualizar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });
        jPanel10.add(salvar);
        salvar.setBounds(260, 318, 180, 25);

        inativar.setText("Inativar");
        inativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inativarActionPerformed(evt);
            }
        });
        jPanel10.add(inativar);
        inativar.setBounds(440, 318, 180, 25);

        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        jPanel10.add(sair);
        sair.setBounds(620, 318, 180, 25);

        ativo.setBackground(new java.awt.Color(255, 255, 255));
        ativo.setText("Ativo");
        ativo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ativo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ativoItemStateChanged(evt);
            }
        });
        jPanel10.add(ativo);
        ativo.setBounds(210, 10, 100, 20);

        getContentPane().add(jPanel10);
        jPanel10.setBounds(0, 0, 880, 540);
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

    private void cnpjKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnpjKeyReleased
        try {
            List<Colaborador> merged = colaboradorDao.getList(15, "select e from Colaborador e where "
                    + "  REPLACE(REPLACE(REPLACE(trim(e.pessoa.cnpj),'.',''),'-',''),' ', '') like ?1 order by e.pessoa.cnpj", 
                        cnpj.getText().trim().toLowerCase().replace(".", "").replace("-", "").trim() + "%");
            listaColaboradorCPF.clear();
            listaColaboradorCPF.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Colaboador. Erro: " + e);
        }
    }//GEN-LAST:event_cnpjKeyReleased

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
        cnpj.requestFocus();
    }//GEN-LAST:event_novoActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        try {
            salvarColaborador();
            atualizaTabelaColaborador();
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
                    pessoa = pessoaDao.getByCnpj(cnpj.getText());
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
                pessoa = pessoaDao.getByCnpj(cnpj.getText());
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

        cnpj.setText("");
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
            cnpj.setText(pessoa.getCnpj());
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
        pessoa.setCnpj(cnpj.getText());
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
        cnpj.setText("");
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anterior;
    private javax.swing.JCheckBox ativo;
    private javax.swing.JTextField cep;
    private javax.swing.JTextField cnpj;
    private javax.swing.JTextField codBairro;
    private javax.swing.JTextField codCargo;
    private javax.swing.JTextField codCidade;
    private javax.swing.JTextField codLogradouro;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField complemento;
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
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
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
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
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
