/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual;

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
import graficaatual.formularios.cadastro.FCadPessoa;
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
 * @author Projeto X
 */
public class FCadastro extends javax.swing.JFrame {

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

    public FCadastro() {
        
        initComponents();
        
        //Segurança da Tela
        //Função de Verificaçã de Acesso
        jTabbedPaneCadastro.setEnabledAt(4, false);
        
        listaPessoaNome = ObservableCollections.observableList(new LinkedList<Pessoa>());
        Componentes comp1 = new Componentes(listaPessoaNome, false, codPessoa, nomePessoa, this, jPanel10, nomePessoa.getWidth(), 100);
        comp1.addCol(0, "codPessoa", "Código", 50, Long.class.getName());
        comp1.addCol(1, "cnpj", "CPF/CNPJ", 100, String.class.getName());
        comp1.addCol(2, "nome", "Nome", 200, String.class.getName());
        comp1.bind();
        
        listaPessoaNomeColaborador = ObservableCollections.observableList(new LinkedList<Pessoa>());
        Componentes comp6 = new Componentes(listaPessoaNomeColaborador, false, codPessoaCadColaborador, 
                nomePessoaCadColaborador, this, jPanel13, nomePessoaCadColaborador.getWidth(), 100);
        comp6.addCol(0, "codPessoa", "Código", 50, Long.class.getName());
        comp6.addCol(1, "cnpj", "CPF/CNPJ", 100, String.class.getName());
        comp6.addCol(2, "nome", "Nome", 200, String.class.getName());
        comp6.bind();
        
        listaColaboradorNome = ObservableCollections.observableList(new LinkedList<Colaborador>());
        Componentes comp8 = new Componentes(listaColaboradorNome, false, codColaborador, 
                nomeCadColaborador, this, jPanel13, nomeCadColaborador.getWidth(), 100);
        comp8.addCol(0, "codColaborador", "Código", 50, Integer.class.getName());
        comp8.addCol(1, "pessoa.nome", "Nome", 100, String.class.getName());
        comp8.bind();

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
        
        listaPessoaCPFColaborador = ObservableCollections.observableList(new LinkedList<Pessoa>());
        Componentes comp7 = new Componentes(listaPessoaCPFColaborador, false, codPessoaCadColaborador, 
                cnpjCadColaborador, this, jPanel13, cnpjCadColaborador.getWidth()+nomePessoaCadColaborador.getWidth(), 100);
        comp7.addCol(0, "codPessoa", "Código", 50, Long.class.getName());
        comp7.addCol(1, "cnpj", "CPF/CNPJ", 100, String.class.getName());
        comp7.addCol(2, "nome", "Nome", 200, String.class.getName());
        comp7.bind();
        atualizaTabelaPessoa();
        atualizaTabelaColaborador();
    }

    private static FCadastro instancia;

    public static FCadastro getInstancia() {
        if (instancia == null) {
            instancia = new FCadastro();
        }

        return instancia;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPaneCadastro = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jTextField66 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jTextField67 = new javax.swing.JTextField();
        jTextField68 = new javax.swing.JTextField();
        jTextField69 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jTextField71 = new javax.swing.JTextField();
        jTextField72 = new javax.swing.JTextField();
        jTextField73 = new javax.swing.JTextField();
        jTextField74 = new javax.swing.JTextField();
        jTextField75 = new javax.swing.JTextField();
        jTextField76 = new javax.swing.JTextField();
        jTextField77 = new javax.swing.JTextField();
        jTextField78 = new javax.swing.JTextField();
        jTextField79 = new javax.swing.JTextField();
        jTextField80 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jCheckBox9 = new javax.swing.JCheckBox();
        jLabel70 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        novoCliente = new javax.swing.JButton();
        salvarCliente = new javax.swing.JButton();
        inativarCadCliente = new javax.swing.JButton();
        sairCliente = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabCliente = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        fimCadCliente = new javax.swing.JButton();
        proximoCadCliente = new javax.swing.JButton();
        anteriorCadCliente = new javax.swing.JButton();
        inicioCadCliente = new javax.swing.JButton();
        codCadCliente = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        codPessoaCadCliente = new javax.swing.JTextField();
        cnpjCadCliente = new javax.swing.JTextField();
        nomePessoaCadCliente = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        limiteCliente = new javax.swing.JTextField();
        ativoCliente = new javax.swing.JCheckBox();
        codLogradouroCadCliente = new javax.swing.JTextField();
        nomeLogradouroCadCliente = new javax.swing.JTextField();
        numeroCadCliente = new javax.swing.JTextField();
        codBairroCadCliente = new javax.swing.JTextField();
        nomeBairroCadCliente = new javax.swing.JTextField();
        complementoCadCliente = new javax.swing.JTextField();
        codCidadeCadCliente = new javax.swing.JTextField();
        nomeCidadeCadCliente = new javax.swing.JTextField();
        cepCadCliente = new javax.swing.JTextField();
        ufCadCliente = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        obsCadCliente = new javax.swing.JTextArea();
        serasa = new javax.swing.JCheckBox();
        jLabel73 = new javax.swing.JLabel();
        contatoCliente = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        telefoneCadCliente = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        emailCadCliente = new javax.swing.JTextField();
        nomeCadCliente = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        nomePessoaCadColaborador = new javax.swing.JTextField();
        codColaborador = new javax.swing.JTextField();
        codCargoCadColaborador = new javax.swing.JTextField();
        descCargoCadColaborador = new javax.swing.JTextField();
        codPessoaCadColaborador = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cnpjCadColaborador = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        finalColaborador = new javax.swing.JButton();
        proximoColaborador = new javax.swing.JButton();
        anteriorColaborador = new javax.swing.JButton();
        inicioColaborador = new javax.swing.JButton();
        novoCadColaboradores = new javax.swing.JButton();
        salvarCadColaboradores = new javax.swing.JButton();
        inativarColabotadores = new javax.swing.JButton();
        sairColaboradores = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        ctps = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        dtFimContrato = new javax.swing.JTextField();
        dtInicioContrato = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabColaborador = new javax.swing.JTable();
        jLabel72 = new javax.swing.JLabel();
        salarioColaborador = new javax.swing.JTextField();
        nomeCadColaborador = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
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
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Gráfica Atual - Módulo Cadastro");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1150, 690));
        setName("FCadastro"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1150, 690));

        jPanel1.setBackground(new java.awt.Color(102, 0, 153));
        jPanel1.setLayout(null);

        jTabbedPaneCadastro.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPaneCadastro.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(null);

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Bem-vindo.jpg"))); // NOI18N
        jPanel15.add(jLabel58);
        jLabel58.setBounds(250, 110, 486, 300);

        jTabbedPaneCadastro.addTab("", jPanel15);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        jButton33.setText("Novo Cadastro");
        jPanel4.add(jButton33);
        jButton33.setBounds(120, 290, 180, 25);

        jButton34.setText("Salvar/Atualizar");
        jPanel4.add(jButton34);
        jButton34.setBounds(300, 290, 180, 25);

        jButton35.setText("Inativar");
        jPanel4.add(jButton35);
        jButton35.setBounds(480, 290, 180, 25);

        jButton36.setText("Sair");
        jPanel4.add(jButton36);
        jButton36.setBounds(660, 290, 180, 25);

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "Cargo", "Ativo"
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
        jScrollPane7.setViewportView(jTable6);

        jPanel4.add(jScrollPane7);
        jScrollPane7.setBounds(20, 331, 910, 160);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jButton37.setText(">>||");

        jButton38.setText(">>");

        jButton39.setText("<<");

        jButton40.setText("||<<");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 36, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton39)
                        .addComponent(jButton40))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton38)
                        .addComponent(jButton37)))
                .addGap(23, 23, 23))
        );

        jPanel4.add(jPanel14);
        jPanel14.setBounds(280, 490, 430, 40);
        jPanel4.add(jTextField66);
        jTextField66.setBounds(90, 10, 70, 20);

        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel59.setText("Pessoa: ");
        jPanel4.add(jLabel59);
        jLabel59.setBounds(10, 30, 80, 15);
        jPanel4.add(jTextField67);
        jTextField67.setBounds(90, 30, 70, 18);

        jTextField68.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.add(jTextField68);
        jTextField68.setBounds(160, 30, 200, 19);

        jTextField69.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.add(jTextField69);
        jTextField69.setBounds(360, 30, 560, 19);

        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel60.setText("Código: ");
        jPanel4.add(jLabel60);
        jLabel60.setBounds(10, 10, 80, 15);
        jPanel4.add(jTextField71);
        jTextField71.setBounds(120, 110, 80, 19);
        jPanel4.add(jTextField72);
        jTextField72.setBounds(200, 110, 470, 19);
        jPanel4.add(jTextField73);
        jTextField73.setBounds(780, 110, 140, 19);
        jPanel4.add(jTextField74);
        jTextField74.setBounds(120, 130, 80, 19);
        jPanel4.add(jTextField75);
        jTextField75.setBounds(200, 130, 470, 19);
        jPanel4.add(jTextField76);
        jTextField76.setBounds(780, 130, 140, 19);
        jPanel4.add(jTextField77);
        jTextField77.setBounds(120, 150, 80, 19);
        jPanel4.add(jTextField78);
        jTextField78.setBounds(200, 150, 310, 19);
        jPanel4.add(jTextField79);
        jTextField79.setBounds(780, 150, 140, 19);
        jPanel4.add(jTextField80);
        jTextField80.setBounds(580, 150, 90, 19);

        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel61.setText("UF: ");
        jPanel4.add(jLabel61);
        jLabel61.setBounds(510, 150, 70, 20);

        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel62.setText("CEP: ");
        jPanel4.add(jLabel62);
        jLabel62.setBounds(670, 150, 110, 20);

        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel63.setText("Número: ");
        jPanel4.add(jLabel63);
        jLabel63.setBounds(670, 110, 110, 20);

        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel64.setText("Bairro: ");
        jPanel4.add(jLabel64);
        jLabel64.setBounds(20, 130, 100, 20);

        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel65.setText("Logradouro: ");
        jPanel4.add(jLabel65);
        jLabel65.setBounds(20, 110, 100, 20);

        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel66.setText("Complemento: ");
        jPanel4.add(jLabel66);
        jLabel66.setBounds(670, 130, 110, 20);

        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel67.setText("Cidade: ");
        jPanel4.add(jLabel67);
        jLabel67.setBounds(20, 150, 100, 20);

        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel68.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço:"));
        jPanel4.add(jLabel68);
        jLabel68.setBounds(10, 80, 920, 110);

        jCheckBox9.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox9.setText("Ativo");
        jPanel4.add(jCheckBox9);
        jCheckBox9.setBounds(90, 50, 104, 23);

        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel70.setText("Observação: ");
        jPanel4.add(jLabel70);
        jLabel70.setBounds(20, 190, 100, 20);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane9.setViewportView(jTextArea3);

        jPanel4.add(jScrollPane9);
        jScrollPane9.setBounds(20, 210, 910, 70);

        jTabbedPaneCadastro.addTab("Fornecedores", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(null);

        novoCliente.setText("Novo Cadastro");
        novoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoClienteActionPerformed(evt);
            }
        });
        jPanel5.add(novoCliente);
        novoCliente.setBounds(120, 310, 180, 30);

        salvarCliente.setText("Salvar/Atualizar");
        salvarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarClienteActionPerformed(evt);
            }
        });
        jPanel5.add(salvarCliente);
        salvarCliente.setBounds(300, 310, 180, 30);

        inativarCadCliente.setText("Inativar");
        inativarCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inativarCadClienteActionPerformed(evt);
            }
        });
        jPanel5.add(inativarCadCliente);
        inativarCadCliente.setBounds(480, 310, 180, 30);

        sairCliente.setText("Sair");
        sairCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairClienteActionPerformed(evt);
            }
        });
        jPanel5.add(sairCliente);
        sairCliente.setBounds(660, 310, 180, 30);

        tabCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Telefone", "Limite", "Ativo"
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
        jScrollPane6.setViewportView(tabCliente);

        jPanel5.add(jScrollPane6);
        jScrollPane6.setBounds(20, 350, 890, 140);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        fimCadCliente.setText(">>||");
        fimCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fimCadClienteActionPerformed(evt);
            }
        });

        proximoCadCliente.setText(">>");
        proximoCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoCadClienteActionPerformed(evt);
            }
        });

        anteriorCadCliente.setText("<<");
        anteriorCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorCadClienteActionPerformed(evt);
            }
        });

        inicioCadCliente.setText("||<<");
        inicioCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioCadClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(inicioCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anteriorCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(proximoCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fimCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 36, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(anteriorCadCliente)
                        .addComponent(inicioCadCliente))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(proximoCadCliente)
                        .addComponent(fimCadCliente)))
                .addGap(23, 23, 23))
        );

        jPanel5.add(jPanel13);
        jPanel13.setBounds(280, 490, 430, 40);

        codCadCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codCadClienteFocusLost(evt);
            }
        });
        jPanel5.add(codCadCliente);
        codCadCliente.setBounds(90, 10, 70, 20);

        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel47.setText("Limite Gastos: ");
        jPanel5.add(jLabel47);
        jLabel47.setBounds(590, 50, 110, 20);

        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel48.setText("E-mail: ");
        jPanel5.add(jLabel48);
        jLabel48.setBounds(10, 70, 80, 15);

        codPessoaCadCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codPessoaCadClienteFocusLost(evt);
            }
        });
        jPanel5.add(codPessoaCadCliente);
        codPessoaCadCliente.setBounds(90, 30, 70, 18);

        cnpjCadCliente.setBackground(new java.awt.Color(255, 255, 204));
        cnpjCadCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cnpjCadClienteKeyReleased(evt);
            }
        });
        jPanel5.add(cnpjCadCliente);
        cnpjCadCliente.setBounds(160, 30, 200, 19);

        nomePessoaCadCliente.setBackground(new java.awt.Color(255, 255, 204));
        nomePessoaCadCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomePessoaCadClienteKeyReleased(evt);
            }
        });
        jPanel5.add(nomePessoaCadCliente);
        nomePessoaCadCliente.setBounds(360, 30, 550, 19);

        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel49.setText("Código: ");
        jPanel5.add(jLabel49);
        jLabel49.setBounds(10, 10, 80, 15);
        jPanel5.add(limiteCliente);
        limiteCliente.setBounds(710, 50, 200, 19);

        ativoCliente.setBackground(new java.awt.Color(255, 255, 255));
        ativoCliente.setText("Ativo");
        jPanel5.add(ativoCliente);
        ativoCliente.setBounds(720, 10, 104, 20);

        codLogradouroCadCliente.setEnabled(false);
        jPanel5.add(codLogradouroCadCliente);
        codLogradouroCadCliente.setBounds(120, 130, 80, 19);

        nomeLogradouroCadCliente.setEnabled(false);
        jPanel5.add(nomeLogradouroCadCliente);
        nomeLogradouroCadCliente.setBounds(200, 130, 450, 19);

        numeroCadCliente.setEnabled(false);
        jPanel5.add(numeroCadCliente);
        numeroCadCliente.setBounds(770, 130, 130, 19);

        codBairroCadCliente.setEnabled(false);
        jPanel5.add(codBairroCadCliente);
        codBairroCadCliente.setBounds(120, 150, 80, 19);

        nomeBairroCadCliente.setEnabled(false);
        jPanel5.add(nomeBairroCadCliente);
        nomeBairroCadCliente.setBounds(200, 150, 450, 19);

        complementoCadCliente.setEnabled(false);
        jPanel5.add(complementoCadCliente);
        complementoCadCliente.setBounds(770, 150, 130, 19);

        codCidadeCadCliente.setEnabled(false);
        jPanel5.add(codCidadeCadCliente);
        codCidadeCadCliente.setBounds(120, 170, 80, 19);

        nomeCidadeCadCliente.setEnabled(false);
        jPanel5.add(nomeCidadeCadCliente);
        nomeCidadeCadCliente.setBounds(200, 170, 310, 19);

        cepCadCliente.setEnabled(false);
        jPanel5.add(cepCadCliente);
        cepCadCliente.setBounds(770, 170, 130, 19);

        ufCadCliente.setEnabled(false);
        jPanel5.add(ufCadCliente);
        ufCadCliente.setBounds(580, 170, 70, 19);

        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel50.setText("UF: ");
        jPanel5.add(jLabel50);
        jLabel50.setBounds(510, 170, 70, 20);

        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel51.setText("CEP: ");
        jPanel5.add(jLabel51);
        jLabel51.setBounds(660, 170, 110, 20);

        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel52.setText("Número: ");
        jPanel5.add(jLabel52);
        jLabel52.setBounds(660, 130, 110, 20);

        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel53.setText("Bairro: ");
        jPanel5.add(jLabel53);
        jLabel53.setBounds(20, 150, 100, 20);

        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel54.setText("Logradouro: ");
        jPanel5.add(jLabel54);
        jLabel54.setBounds(20, 130, 100, 20);

        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel55.setText("Complemento: ");
        jPanel5.add(jLabel55);
        jLabel55.setBounds(660, 150, 110, 20);

        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel56.setText("Cidade: ");
        jPanel5.add(jLabel56);
        jLabel56.setBounds(20, 170, 100, 20);

        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel57.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço:"));
        jPanel5.add(jLabel57);
        jLabel57.setBounds(10, 100, 900, 110);

        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel69.setText("Observação: ");
        jPanel5.add(jLabel69);
        jLabel69.setBounds(10, 210, 100, 20);

        obsCadCliente.setColumns(20);
        obsCadCliente.setRows(4);
        jScrollPane8.setViewportView(obsCadCliente);

        jPanel5.add(jScrollPane8);
        jScrollPane8.setBounds(10, 230, 890, 70);

        serasa.setBackground(new java.awt.Color(255, 255, 255));
        serasa.setText("Serasa");
        jPanel5.add(serasa);
        serasa.setBounds(830, 10, 75, 20);

        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel73.setText("Pessoa: ");
        jPanel5.add(jLabel73);
        jLabel73.setBounds(10, 30, 80, 15);

        contatoCliente.setToolTipText("");
        jPanel5.add(contatoCliente);
        contatoCliente.setBounds(90, 50, 470, 19);

        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel74.setText("Contato: ");
        jPanel5.add(jLabel74);
        jLabel74.setBounds(10, 50, 80, 15);

        telefoneCadCliente.setEnabled(false);
        jPanel5.add(telefoneCadCliente);
        telefoneCadCliente.setBounds(710, 70, 200, 19);

        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel75.setText("Telefone: ");
        jPanel5.add(jLabel75);
        jLabel75.setBounds(620, 70, 80, 15);

        emailCadCliente.setEnabled(false);
        jPanel5.add(emailCadCliente);
        emailCadCliente.setBounds(90, 70, 470, 19);

        nomeCadCliente.setBackground(new java.awt.Color(255, 255, 204));
        nomeCadCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeCadClienteKeyReleased(evt);
            }
        });
        jPanel5.add(nomeCadCliente);
        nomeCadCliente.setBounds(160, 10, 550, 19);

        jTabbedPaneCadastro.addTab("Clientes", new javax.swing.ImageIcon(getClass().getResource("/imagens/teste2.png")), jPanel5); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        nomePessoaCadColaborador.setBackground(new java.awt.Color(255, 255, 204));
        nomePessoaCadColaborador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomePessoaCadColaboradorKeyReleased(evt);
            }
        });
        jPanel3.add(nomePessoaCadColaborador);
        nomePessoaCadColaborador.setBounds(360, 30, 550, 19);

        codColaborador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codColaboradorFocusLost(evt);
            }
        });
        jPanel3.add(codColaborador);
        codColaborador.setBounds(90, 10, 70, 20);

        codCargoCadColaborador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codCargoCadColaboradorFocusLost(evt);
            }
        });
        jPanel3.add(codCargoCadColaborador);
        codCargoCadColaborador.setBounds(90, 50, 70, 20);

        descCargoCadColaborador.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.add(descCargoCadColaborador);
        descCargoCadColaborador.setBounds(160, 50, 200, 19);

        codPessoaCadColaborador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codPessoaCadColaboradorFocusLost(evt);
            }
        });
        jPanel3.add(codPessoaCadColaborador);
        codPessoaCadColaborador.setBounds(90, 30, 70, 20);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Código: ");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(10, 10, 80, 15);

        cnpjCadColaborador.setBackground(new java.awt.Color(255, 255, 204));
        cnpjCadColaborador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cnpjCadColaboradorKeyReleased(evt);
            }
        });
        jPanel3.add(cnpjCadColaborador);
        cnpjCadColaborador.setBounds(160, 30, 200, 19);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Cargo: ");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(10, 50, 80, 15);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        finalColaborador.setText(">>||");
        finalColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalColaboradorActionPerformed(evt);
            }
        });

        proximoColaborador.setText(">>");
        proximoColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoColaboradorActionPerformed(evt);
            }
        });

        anteriorColaborador.setText("<<");
        anteriorColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorColaboradorActionPerformed(evt);
            }
        });

        inicioColaborador.setText("||<<");
        inicioColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioColaboradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(inicioColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anteriorColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(proximoColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finalColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 36, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(anteriorColaborador)
                        .addComponent(inicioColaborador))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(proximoColaborador)
                        .addComponent(finalColaborador)))
                .addGap(23, 23, 23))
        );

        jPanel3.add(jPanel9);
        jPanel9.setBounds(280, 490, 430, 40);

        novoCadColaboradores.setText("Novo Cadastro");
        novoCadColaboradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoCadColaboradoresActionPerformed(evt);
            }
        });
        jPanel3.add(novoCadColaboradores);
        novoCadColaboradores.setBounds(140, 140, 180, 25);

        salvarCadColaboradores.setText("Salvar/Atualizar");
        salvarCadColaboradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarCadColaboradoresActionPerformed(evt);
            }
        });
        jPanel3.add(salvarCadColaboradores);
        salvarCadColaboradores.setBounds(320, 140, 180, 25);

        inativarColabotadores.setText("Inativar");
        inativarColabotadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inativarColabotadoresActionPerformed(evt);
            }
        });
        jPanel3.add(inativarColabotadores);
        inativarColabotadores.setBounds(500, 140, 180, 25);

        sairColaboradores.setText("Sair");
        sairColaboradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairColaboradoresActionPerformed(evt);
            }
        });
        jPanel3.add(sairColaboradores);
        sairColaboradores.setBounds(680, 140, 180, 25);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Data de Fim Contrato: ");
        jPanel3.add(jLabel24);
        jLabel24.setBounds(530, 70, 190, 15);

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Pessoa: ");
        jPanel3.add(jLabel25);
        jLabel25.setBounds(10, 30, 80, 15);
        jPanel3.add(ctps);
        ctps.setBounds(90, 70, 270, 19);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("CTPS: ");
        jPanel3.add(jLabel26);
        jLabel26.setBounds(10, 70, 80, 15);

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Data de Início Contrato: ");
        jPanel3.add(jLabel27);
        jLabel27.setBounds(530, 50, 190, 15);
        jPanel3.add(dtFimContrato);
        dtFimContrato.setBounds(730, 70, 180, 19);
        jPanel3.add(dtInicioContrato);
        dtInicioContrato.setBounds(730, 50, 180, 19);

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

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(20, 181, 890, 310);

        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel72.setText("Salário:");
        jPanel3.add(jLabel72);
        jLabel72.setBounds(10, 90, 80, 15);

        salarioColaborador.setText("0,00");
        jPanel3.add(salarioColaborador);
        salarioColaborador.setBounds(90, 90, 270, 19);

        nomeCadColaborador.setBackground(new java.awt.Color(255, 255, 204));
        nomeCadColaborador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeCadColaboradorKeyReleased(evt);
            }
        });
        jPanel3.add(nomeCadColaborador);
        nomeCadColaborador.setBounds(160, 10, 750, 19);

        jTabbedPaneCadastro.addTab("Colaboradores", new javax.swing.ImageIcon(getClass().getResource("/imagens/teste2.png")), jPanel3); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Código: ");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(80, 20, 60, 15);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Colaborador: ");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(40, 40, 100, 15);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Confirmação: ");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 100, 110, 15);

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

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(30, 350, 890, 140);
        jPanel2.add(jTextField1);
        jTextField1.setBounds(140, 20, 70, 19);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jButton4.setText(">>||");

        jButton3.setText(">>");

        jButton2.setText("<<");

        jButton1.setText("||<<");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 36, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton1))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton4)))
                .addGap(23, 23, 23))
        );

        jPanel2.add(jPanel6);
        jPanel6.setBounds(280, 490, 430, 40);

        jButton5.setText("Salvar/Atualizar");
        jPanel2.add(jButton5);
        jButton5.setBounds(330, 310, 180, 25);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Login: ");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(80, 60, 60, 15);

        jButton6.setText("Inativar");
        jPanel2.add(jButton6);
        jButton6.setBounds(510, 310, 180, 25);

        jButton7.setText("Sair");
        jPanel2.add(jButton7);
        jButton7.setBounds(690, 310, 180, 25);
        jPanel2.add(jTextField2);
        jTextField2.setBounds(140, 40, 70, 19);

        jTextField3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.add(jTextField3);
        jTextField3.setBounds(210, 40, 190, 19);

        jTextField4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.add(jTextField4);
        jTextField4.setBounds(400, 40, 520, 19);
        jPanel2.add(jTextField5);
        jTextField5.setBounds(140, 60, 260, 19);
        jPanel2.add(jTextField6);
        jTextField6.setBounds(140, 100, 260, 19);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Senha: ");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(70, 80, 70, 15);
        jPanel2.add(jTextField7);
        jTextField7.setBounds(140, 80, 260, 19);

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

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(450, 100, 470, 180);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(null);

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Produção");
        jPanel7.add(jCheckBox1);
        jCheckBox1.setBounds(190, 70, 92, 23);

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("Cadastro");
        jPanel7.add(jCheckBox2);
        jCheckBox2.setBounds(30, 30, 90, 23);

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setText("Financeiro");
        jPanel7.add(jCheckBox3);
        jCheckBox3.setBounds(30, 70, 99, 23);

        jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setText("Estoque");
        jPanel7.add(jCheckBox4);
        jCheckBox4.setBounds(30, 110, 83, 23);

        jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setText("Relarórios");
        jPanel7.add(jCheckBox5);
        jCheckBox5.setBounds(190, 110, 98, 23);

        jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox6.setText("Pedidos");
        jCheckBox6.setToolTipText("");
        jPanel7.add(jCheckBox6);
        jCheckBox6.setBounds(190, 30, 82, 23);

        jLabel7.setToolTipText("");
        jLabel7.setBorder(javax.swing.BorderFactory.createTitledBorder("  Módulos  "));
        jPanel7.add(jLabel7);
        jLabel7.setBounds(0, 10, 370, 150);

        jPanel2.add(jPanel7);
        jPanel7.setBounds(50, 120, 380, 160);

        jButton8.setText("Novo Cadastro");
        jPanel2.add(jButton8);
        jButton8.setBounds(150, 310, 180, 25);

        jTabbedPaneCadastro.addTab("\n\nUsuários\n\n\n", jPanel2);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
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
        codLogradouroPessoa.setBounds(120, 150, 80, 19);

        descLogradouroPessoa.setBackground(new java.awt.Color(255, 255, 204));
        descLogradouroPessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descLogradouroPessoaKeyReleased(evt);
            }
        });
        jPanel10.add(descLogradouroPessoa);
        descLogradouroPessoa.setBounds(200, 150, 430, 19);
        jPanel10.add(numeroPessoa);
        numeroPessoa.setBounds(770, 150, 120, 19);

        codBairroPessoa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codBairroPessoaFocusLost(evt);
            }
        });
        jPanel10.add(codBairroPessoa);
        codBairroPessoa.setBounds(120, 170, 80, 19);

        descBairroPessoa.setBackground(new java.awt.Color(255, 255, 204));
        descBairroPessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descBairroPessoaKeyReleased(evt);
            }
        });
        jPanel10.add(descBairroPessoa);
        descBairroPessoa.setBounds(200, 170, 430, 19);
        jPanel10.add(complementoPessoa);
        complementoPessoa.setBounds(770, 170, 120, 19);

        codCidadePessoa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codCidadePessoaFocusLost(evt);
            }
        });
        jPanel10.add(codCidadePessoa);
        codCidadePessoa.setBounds(120, 190, 80, 19);

        descCidadePessoa.setBackground(new java.awt.Color(255, 255, 204));
        descCidadePessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descCidadePessoaKeyReleased(evt);
            }
        });
        jPanel10.add(descCidadePessoa);
        descCidadePessoa.setBounds(200, 190, 310, 19);
        jPanel10.add(cepPessoa);
        cepPessoa.setBounds(770, 190, 120, 19);
        jPanel10.add(ufPessoa);
        ufPessoa.setBounds(560, 190, 70, 19);

        tipoPessoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Física", "Juridica" }));
        jPanel10.add(tipoPessoa);
        tipoPessoa.setBounds(160, 30, 180, 18);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("UF: ");
        jPanel10.add(jLabel23);
        jLabel23.setBounds(510, 190, 50, 20);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("CEP: ");
        jPanel10.add(jLabel22);
        jLabel22.setBounds(660, 190, 110, 20);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Código: ");
        jPanel10.add(jLabel13);
        jLabel13.setBounds(80, 10, 80, 20);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Observação: ");
        jPanel10.add(jLabel15);
        jLabel15.setBounds(20, 230, 100, 20);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Número: ");
        jPanel10.add(jLabel16);
        jLabel16.setBounds(660, 150, 110, 20);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Insc. Estadual:");
        jPanel10.add(jLabel17);
        jLabel17.setBounds(630, 50, 140, 20);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Bairro: ");
        jPanel10.add(jLabel18);
        jLabel18.setBounds(20, 170, 100, 20);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Logradouro: ");
        jPanel10.add(jLabel19);
        jLabel19.setBounds(20, 150, 100, 20);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Complemento: ");
        jPanel10.add(jLabel20);
        jLabel20.setBounds(660, 170, 110, 20);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Cidade: ");
        jPanel10.add(jLabel21);
        jLabel21.setBounds(20, 190, 100, 20);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço:"));
        jPanel10.add(jLabel14);
        jLabel14.setBounds(10, 120, 900, 110);

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
        cnpjPessoa.setBounds(340, 30, 290, 19);

        nomePessoa.setBackground(new java.awt.Color(255, 255, 204));
        nomePessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomePessoaKeyReleased(evt);
            }
        });
        jPanel10.add(nomePessoa);
        nomePessoa.setBounds(160, 50, 470, 19);
        jPanel10.add(dataNascimentoPessoa);
        dataNascimentoPessoa.setBounds(770, 70, 140, 19);
        jPanel10.add(inscMunicipalPessoa);
        inscMunicipalPessoa.setBounds(770, 30, 140, 19);
        jPanel10.add(inscEstadualPessao);
        inscEstadualPessao.setBounds(770, 50, 140, 19);

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Email: ");
        jPanel10.add(jLabel29);
        jLabel29.setBounds(10, 90, 150, 20);

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Insc. Munícipal:");
        jPanel10.add(jLabel30);
        jLabel30.setBounds(630, 30, 140, 20);

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
        emailPessoa.setBounds(160, 90, 470, 19);
        jPanel10.add(telefonePessoa);
        telefonePessoa.setBounds(770, 90, 140, 19);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Telefone: ");
        jPanel10.add(jLabel9);
        jLabel9.setBounds(680, 90, 90, 20);

        obsPessoa.setColumns(20);
        obsPessoa.setRows(4);
        jScrollPane4.setViewportView(obsPessoa);

        jPanel10.add(jScrollPane4);
        jScrollPane4.setBounds(20, 250, 890, 70);

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel46.setText("Data Nascimento: ");
        jPanel10.add(jLabel46);
        jLabel46.setBounds(630, 70, 140, 20);

        jButton17.setText("Novo Cadastro");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton17);
        jButton17.setBounds(140, 330, 180, 25);

        salvarPessoa.setText("Salvar/Atualizar");
        salvarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarPessoaActionPerformed(evt);
            }
        });
        jPanel10.add(salvarPessoa);
        salvarPessoa.setBounds(320, 330, 180, 25);

        InativarPessoa.setText("Inativar");
        InativarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InativarPessoaActionPerformed(evt);
            }
        });
        jPanel10.add(InativarPessoa);
        InativarPessoa.setBounds(500, 330, 180, 25);

        sairPessoa.setText("Sair");
        sairPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairPessoaActionPerformed(evt);
            }
        });
        jPanel10.add(sairPessoa);
        sairPessoa.setBounds(680, 330, 180, 25);

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
        jScrollPane5.setBounds(20, 360, 923, 150);

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
        jPanel12.setBounds(280, 500, 430, 40);

        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel71.setText("Nome/Razão Socia: ");
        jPanel10.add(jLabel71);
        jLabel71.setBounds(10, 50, 150, 20);
        jPanel10.add(nomeFantasiaPessoa);
        nomeFantasiaPessoa.setBounds(160, 70, 470, 19);

        jTabbedPaneCadastro.addTab("Pessoa", new javax.swing.ImageIcon(getClass().getResource("/imagens/teste2.png")), jPanel10); // NOI18N

        jPanel1.add(jTabbedPaneCadastro);
        jTabbedPaneCadastro.setBounds(40, 70, 1090, 560);
        jTabbedPaneCadastro.getAccessibleContext().setAccessibleName("");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LOGO3.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 470, 140, 130);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CADASTRO SEM FUNDO.png"))); // NOI18N
        jPanel1.add(jLabel10);
        jLabel10.setBounds(240, 0, 70, 90);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Módulo de Cadastros");
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(1, 0, 1140, 70);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("FCadastro");
        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        pessoa = new Pessoa();
        limpaCamposPessoa();
        tipoPessoa.requestFocus();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void codPessoaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codPessoaFocusLost
        try {
            carregaPessoa();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codPessoaFocusLost

    private void salvarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarPessoaActionPerformed
        try {
            salvarPessoa();
            JOptionPane.showMessageDialog(this, " Cadastro realizado com Sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_salvarPessoaActionPerformed

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

    private void codLogradouroPessoaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codLogradouroPessoaFocusLost
        try {
            carregaLogCadPessoa();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_codLogradouroPessoaFocusLost

    private void codBairroPessoaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codBairroPessoaFocusLost
        try {
            carregaBairroCadPessoa();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codBairroPessoaFocusLost

    private void codCidadePessoaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codCidadePessoaFocusLost
        try {
            carregaCidadeCadPessoa();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codCidadePessoaFocusLost

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

    private void tabPessoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPessoaMouseClicked
        if (evt.getClickCount() > 1) {
            codPessoa.setText(("" + tabPessoa.getValueAt(tabPessoa.getSelectedRow(), 0)));
            codPessoaFocusLost(null);
            nomePessoa.requestFocus();
        }
    }//GEN-LAST:event_tabPessoaMouseClicked

    private void cnpjCadColaboradorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnpjCadColaboradorKeyReleased
        try {
            List<Pessoa> merged = pessoaDao.getList(15, "select e from Pessoa e where e.ativo='true' and REPLACE(REPLACE(REPLACE(trim(e.cnpj),'.',''),'-',''),' ', '') "
                    + " like ?1 order by e.cnpj", cnpjCadColaborador.getText().trim().toLowerCase().replace(".", "").replace("-", "").trim() + "%");
            listaPessoaCPFColaborador.clear();
            listaPessoaCPFColaborador.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar pessoas. Erro: " + e);
        }
    }//GEN-LAST:event_cnpjCadColaboradorKeyReleased

    private void nomePessoaCadColaboradorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomePessoaCadColaboradorKeyReleased
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            List<Pessoa> merged = pessoaDao.getPureList(session, 0, 12, Pessoa.class,
                    "select e from Pessoa e where e.ativo='true' and  lower ( trim(e.nome) ) like ?1   order by e.nome",
                    nomePessoaCadColaborador.getText().trim().toLowerCase() + "%");
            listaPessoaNomeColaborador.clear();
            listaPessoaNomeColaborador.addAll(merged);
        } catch (Exception e) {
        } finally {
            session.close();
        }
    }//GEN-LAST:event_nomePessoaCadColaboradorKeyReleased

    private void codPessoaCadColaboradorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codPessoaCadColaboradorFocusLost
        try {
            carregaPessoaColaborador();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }  
    }//GEN-LAST:event_codPessoaCadColaboradorFocusLost

    private void codColaboradorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codColaboradorFocusLost
        try {
            carregaColaborador();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }     
    }//GEN-LAST:event_codColaboradorFocusLost

    private void codCargoCadColaboradorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codCargoCadColaboradorFocusLost
        try {
            carregaCargoColaborador();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }  
    }//GEN-LAST:event_codCargoCadColaboradorFocusLost

    private void novoCadColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoCadColaboradoresActionPerformed
        pessoa = null;
        cargo = null;
        colaborador= new Colaborador();
        limpaCamposColaborador();
        codPessoaCadColaborador.requestFocus();
    }//GEN-LAST:event_novoCadColaboradoresActionPerformed

    private void salvarCadColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarCadColaboradoresActionPerformed
        try {
            salvarColaborador();
            atualizaTabelaColaborador();
            JOptionPane.showMessageDialog(this, " Cadastro realizado com Sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_salvarCadColaboradoresActionPerformed

    private void inativarColabotadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inativarColabotadoresActionPerformed
        try {
            if (colaborador != null) {
                Integer resp = JOptionPane.showConfirmDialog(this, "Deseja realmente Inativar esse Colaborador.");
                if (resp == 0) {
                    inativarColaborador();
                    atualizaTabelaColaborador();
                }
            } else {
                throw new Exception(" Por Favorm Selecione um Colaborador.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_inativarColabotadoresActionPerformed

    private void sairPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairPessoaActionPerformed
        dispose();
    }//GEN-LAST:event_sairPessoaActionPerformed

    private void sairColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairColaboradoresActionPerformed
        dispose();
    }//GEN-LAST:event_sairColaboradoresActionPerformed

    private void inicioColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioColaboradorActionPerformed
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
    }//GEN-LAST:event_inicioColaboradorActionPerformed

    private void anteriorColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorColaboradorActionPerformed
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
    }//GEN-LAST:event_anteriorColaboradorActionPerformed

    private void proximoColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoColaboradorActionPerformed
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
    }//GEN-LAST:event_proximoColaboradorActionPerformed

    private void finalColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalColaboradorActionPerformed
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
    }//GEN-LAST:event_finalColaboradorActionPerformed

    private void tabColaboradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabColaboradorMouseClicked
         if (evt.getClickCount() > 1) {
            codColaborador.setText(("" + tabColaborador.getValueAt(tabColaborador.getSelectedRow(), 0)));
            codColaboradorFocusLost(null);
            codPessoaCadColaborador.requestFocus();
        }
    }//GEN-LAST:event_tabColaboradorMouseClicked

    private void nomeCadColaboradorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeCadColaboradorKeyReleased
        try {
            List<Colaborador> merged = colaboradorDao.getList(12, "select c from Colaborador c where c.pessoa.ativo='true' and  "
                    + "lower ( trim(c.pessoa.nome) ) like ?1   order by c.pessoa.nome",
                    nomeCadColaborador.getText().trim().toLowerCase() + "%");
            listaColaboradorNome.clear();
            listaColaboradorNome.addAll(merged);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Erro ao Buscar Colaborador");
        }
    }//GEN-LAST:event_nomeCadColaboradorKeyReleased

    private void novoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoClienteActionPerformed
        pessoa = null;
        cliente = new Cliente();
        limpaCamposCliente();
        codPessoaCadCliente.requestFocus();
    }//GEN-LAST:event_novoClienteActionPerformed

    private void salvarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarClienteActionPerformed
         try {
            salvarCliente();
            atualizaTabCliente();
            JOptionPane.showMessageDialog(this, " Cadastro realizado com Sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_salvarClienteActionPerformed

    private void inativarCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inativarCadClienteActionPerformed
        try {
            if (cliente != null) {
                Integer resp = JOptionPane.showConfirmDialog(this, "Deseja realmente Inativar esse Cliente.");
                if (resp == 0) {
                    inativarCliente();
                    atualizaTabCliente();
                }
            } else {
                throw new Exception(" Por Favor, Selecione um Cliente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_inativarCadClienteActionPerformed

    private void sairClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairClienteActionPerformed
        
    }//GEN-LAST:event_sairClienteActionPerformed

    private void inicioCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioCadClienteActionPerformed
        try {
            if (cnvColaboradorCad == null) {
                atualizaTabCliente();
            } else {
                cnvColaboradorCad.primeiro();
                atualizarTabelaClienteCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_inicioCadClienteActionPerformed

    private void anteriorCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorCadClienteActionPerformed
         try {
            if (cnvColaboradorCad == null) {
                atualizaTabCliente();
            } else {
                cnvColaboradorCad.anterior();
                atualizarTabelaClienteCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_anteriorCadClienteActionPerformed

    private void proximoCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoCadClienteActionPerformed
        try {
            if (cnvColaboradorCad == null) {
                atualizaTabCliente();
            } else {
                cnvColaboradorCad.proximo();
                atualizarTabelaClienteCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_proximoCadClienteActionPerformed

    private void fimCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fimCadClienteActionPerformed
        try {
            if (cnvColaboradorCad == null) {
                atualizaTabCliente();
            } else {
                cnvColaboradorCad.ultimo();
                atualizarTabelaClienteCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_fimCadClienteActionPerformed

    private void codCadClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codCadClienteFocusLost
        try {
            carregaCliente();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }    
    }//GEN-LAST:event_codCadClienteFocusLost

    private void nomeCadClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeCadClienteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeCadClienteKeyReleased

    private void cnpjCadClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnpjCadClienteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cnpjCadClienteKeyReleased

    private void nomePessoaCadClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomePessoaCadClienteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_nomePessoaCadClienteKeyReleased

    private void codPessoaCadClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codPessoaCadClienteFocusLost
          try {
            carregaPessoaCliente();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }    
    }//GEN-LAST:event_codPessoaCadClienteFocusLost
  
private void Finalizar() {

        if (localIncusao == 1) {
            instanceCont = null;

        } else {
            initControle = 0;
            instance = null;

        }

        dispose();
    }

    private static FCadPessoa instance;
    private static FCadPessoa instanceCont;
    private static int initControle;
    private int localIncusao;
    
    
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton InativarPessoa;
    private javax.swing.JButton anteriorCadCliente;
    private javax.swing.JButton anteriorColaborador;
    private javax.swing.JButton anteriorPessoa;
    private javax.swing.JCheckBox ativoCliente;
    private javax.swing.JTextField cepCadCliente;
    private javax.swing.JTextField cepPessoa;
    private javax.swing.JTextField cnpjCadCliente;
    private javax.swing.JTextField cnpjCadColaborador;
    private javax.swing.JTextField cnpjPessoa;
    private javax.swing.JTextField codBairroCadCliente;
    private javax.swing.JTextField codBairroPessoa;
    private javax.swing.JTextField codCadCliente;
    private javax.swing.JTextField codCargoCadColaborador;
    private javax.swing.JTextField codCidadeCadCliente;
    private javax.swing.JTextField codCidadePessoa;
    private javax.swing.JTextField codColaborador;
    private javax.swing.JTextField codLogradouroCadCliente;
    private javax.swing.JTextField codLogradouroPessoa;
    private javax.swing.JTextField codPessoa;
    private javax.swing.JTextField codPessoaCadCliente;
    private javax.swing.JTextField codPessoaCadColaborador;
    private javax.swing.JTextField complementoCadCliente;
    private javax.swing.JTextField complementoPessoa;
    private javax.swing.JTextField contatoCliente;
    private javax.swing.JTextField ctps;
    private javax.swing.JTextField dataNascimentoPessoa;
    private javax.swing.JTextField descBairroPessoa;
    private javax.swing.JTextField descCargoCadColaborador;
    private javax.swing.JTextField descCidadePessoa;
    private javax.swing.JTextField descLogradouroPessoa;
    private javax.swing.JTextField dtFimContrato;
    private javax.swing.JTextField dtInicioContrato;
    private javax.swing.JTextField emailCadCliente;
    private javax.swing.JTextField emailPessoa;
    private javax.swing.JButton fimCadCliente;
    private javax.swing.JButton finalColaborador;
    private javax.swing.JButton finalPessoa;
    private javax.swing.JButton inativarCadCliente;
    private javax.swing.JButton inativarColabotadores;
    private javax.swing.JButton inicioCadCliente;
    private javax.swing.JButton inicioColaborador;
    private javax.swing.JButton inicioPessoa;
    private javax.swing.JTextField inscEstadualPessao;
    private javax.swing.JTextField inscMunicipalPessoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
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
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox<String> jComboBox2;
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
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPaneCadastro;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextArea jTextArea3;
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
    private javax.swing.JTextField jTextField66;
    private javax.swing.JTextField jTextField67;
    private javax.swing.JTextField jTextField68;
    private javax.swing.JTextField jTextField69;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField71;
    private javax.swing.JTextField jTextField72;
    private javax.swing.JTextField jTextField73;
    private javax.swing.JTextField jTextField74;
    private javax.swing.JTextField jTextField75;
    private javax.swing.JTextField jTextField76;
    private javax.swing.JTextField jTextField77;
    private javax.swing.JTextField jTextField78;
    private javax.swing.JTextField jTextField79;
    private javax.swing.JTextField jTextField80;
    private javax.swing.JTextField limiteCliente;
    private javax.swing.JTextField nomeBairroCadCliente;
    private javax.swing.JTextField nomeCadCliente;
    private javax.swing.JTextField nomeCadColaborador;
    private javax.swing.JTextField nomeCidadeCadCliente;
    private javax.swing.JTextField nomeFantasiaPessoa;
    private javax.swing.JTextField nomeLogradouroCadCliente;
    private javax.swing.JTextField nomePessoa;
    private javax.swing.JTextField nomePessoaCadCliente;
    private javax.swing.JTextField nomePessoaCadColaborador;
    private javax.swing.JButton novoCadColaboradores;
    private javax.swing.JButton novoCliente;
    private javax.swing.JTextField numeroCadCliente;
    private javax.swing.JTextField numeroPessoa;
    private javax.swing.JTextArea obsCadCliente;
    private javax.swing.JTextArea obsPessoa;
    private javax.swing.JButton proximoCadCliente;
    private javax.swing.JButton proximoColaborador;
    private javax.swing.JButton proximoPessoa;
    private javax.swing.JButton sairCliente;
    private javax.swing.JButton sairColaboradores;
    private javax.swing.JButton sairPessoa;
    private javax.swing.JTextField salarioColaborador;
    private javax.swing.JButton salvarCadColaboradores;
    private javax.swing.JButton salvarCliente;
    private javax.swing.JButton salvarPessoa;
    private javax.swing.JCheckBox serasa;
    private javax.swing.JTable tabCliente;
    private javax.swing.JTable tabColaborador;
    private javax.swing.JTable tabPessoa;
    private javax.swing.JTextField telefoneCadCliente;
    private javax.swing.JTextField telefonePessoa;
    private javax.swing.JComboBox<String> tipoPessoa;
    private javax.swing.JTextField ufCadCliente;
    private javax.swing.JTextField ufPessoa;
    // End of variables declaration//GEN-END:variables

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
     
     private void atualizarTabelaClienteCad() {

        DefaultTableModel model = (DefaultTableModel) tabCliente.getModel();
        removeLinhas(tabCliente);

        List<?> lv;

        lv = cnvClienteCad.getLista();

        if (lv != null && !lv.isEmpty()) {

            for (Object o : lv) {
                Object[] os = (Object[]) o;
                model.addRow(os);

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

    private void limpaCamposColaborador() {
        codColaborador.setText("");
        nomeCadColaborador.setText("");
        codPessoaCadColaborador.setText("");
        cnpjCadColaborador.setText("");
        nomePessoaCadColaborador.setText("");
        ctps.setText("");
        codCargoCadColaborador.setText("");
        descCargoCadColaborador.setText("");
        dtInicioContrato.setText(Data.getDataAtual(Data.FORMAT_DATA_BR));
        dtFimContrato.setText("");
        salarioColaborador.setText("0,00");

    }

    private void salvarColaborador() throws Exception {

        Colaborador colaboradorAux;
        if (colaborador != null) {
            setColaborador();
            if (codColaborador.getText().equals("")) {
                colaboradorAux = null;
            } else {
                colaboradorAux = colaboradorDao.get(colaborador.getCodColaborador());
            }

            if (colaboradorAux == null) {
                colaborador = colaboradorDao.addColaborador(colaborador);

            } else {
                colaborador = colaboradorDao.addColaborador(colaborador);
            }
            atualizaTabelaColaborador();
        } else {
            throw new Exception(" Para inserir um cadastro novo, aperte o botão "
                    + " Novo Cadastro.");
        }

    }

    private void setColaborador() throws Exception {
        colaborador.setAtivo(true);
        colaborador.setCtps(ctps.getText());
        colaborador.setDataInicio(Data.getDateSQL(dtInicioContrato.getText()));
        colaborador.setDataFim(Data.getDateSQL(dtFimContrato.getText()));
        if (pessoa != null) {
            colaborador.setPessoa(pessoa);
        } else {
            throw new Exception(" Por favor, inserir uma Pessoa.");
        }
        if (cargo != null) {
            colaborador.setCargo(cargo);
        } else {
            throw new Exception(" Por favor, inserir um cargo.");
        }
        colaborador.setSalario(ValidarValor.getDouble(salarioColaborador.getText()));
    }

    private void inativarPessoa() throws Exception {
        pessoa.setAtivo(false);
        pessoa = pessoaDao.addUsuario(pessoa);
        limpaCamposPessoa();
    }

    private void inativarColaborador() throws Exception {
        colaborador.setAtivo(false);
        colaborador = colaboradorDao.addColaborador(colaborador);
        limpaCamposColaborador();

    }

    private void carregaColaborador() throws Exception {
       colaborador = colaboradorDao.get(ValidarValor.getInteger(codColaborador.getText()));
        if (colaborador != null) {

            codColaborador.setText(colaborador.getCodColaborador().toString());
            codPessoaCadColaborador.setText(colaborador.getPessoa().getCodPessoa().toString());
            carregaPessoaColaborador();
            codCargoCadColaborador.setText(colaborador.getCargo().getCodCargo().toString());
            carregaCargoColaborador();
            ctps.setText(colaborador.getCtps());
            salarioColaborador.setText(ValidarValor.getDouble(colaborador.getSalario()));
            dtInicioContrato.setText(Data.getDate(colaborador.getDataInicio()));
            dtFimContrato.setText(Data.getDate(colaborador.getDataFim()));

        } else {
            limpaCamposColaborador();
            new Exception("Por favor, inserir um código válido.");
        }
    }

    private void carregaCargoColaborador()  throws Exception {
        cargo = cargoDao.get(ValidarValor.getInt(codCargoCadColaborador.getText()));
        if(cargo!=null){
            descCargoCadColaborador.setText(cargo.getDescricao());
            
            
        }else{
            descCargoCadColaborador.setText("");
            codCargoCadColaborador.setText("");
        }
    }

    private void carregaPessoaColaborador() throws Exception{
        pessoa = pessoaDao.get(ValidarValor.getLong(codPessoaCadColaborador.getText()));
        if(pessoa!=null){
            nomeCadColaborador.setText(pessoa.getNome());
            nomePessoaCadColaborador.setText(pessoa.getNome());
            cnpjCadColaborador.setText(pessoa.getCnpj());
        }else{
            nomeCadColaborador.setText("");
            nomePessoaCadColaborador.setText("");
            cnpjCadColaborador.setText("");
            codPessoaCadColaborador.setText("");            
        }
    }

    private void limpaCamposCliente() {
        codCadCliente.setText("");
        nomeCadCliente.setText("");
        ativoCliente.setSelected(true);
        serasa.setSelected(false);
        codPessoaCadCliente.setText("");
        contatoCliente.setText("");
        limiteCliente.setText("");
        obsCadCliente.setText("");
        limpaPessoaCadCliente();
    }

    private void limpaPessoaCadCliente() {
        codPessoaCadCliente.setText("");
        cnpjCadCliente.setText("");
        nomePessoaCadCliente.setText("");
        telefoneCadCliente.setText("");
        emailCadCliente.setText("");
        codLogradouroCadCliente.setText("");
        nomeLogradouroCadCliente.setText("");
        numeroCadCliente.setText("");
        codBairroCadCliente.setText("");
        nomeBairroCadCliente.setText("");
        complementoCadCliente.setText("");
        codCidadeCadCliente.setText("");
        nomeCidadeCadCliente.setText("");
        ufCadCliente.setText("");
        cepCadCliente.setText("");
    }

    private void salvarCliente() throws Exception{
        Cliente clienteAux;
        if (cliente != null) {
            setCliente();
            if (codCadCliente.getText().equals("")) {
                clienteAux = null;
            } else {
                clienteAux = clienteDao.get(cliente.getCodCliente());
            }

            if (clienteAux == null) {
                cliente = clienteDao.addCliente(cliente);

            } else {
                cliente = clienteDao.addCliente(cliente);
            }
        } else {
            throw new Exception(" Para inserir um novo cadastro, aperte o botão "
                    + " Novo Cadastro.");
        }
    }

    private void setCliente() throws Exception{
        
        cliente.setAtivo(ativoCliente.isSelected());
        cliente.setSerasa(serasa.isSelected());
        cliente.setContato(contatoCliente.getText());
        cliente.setLimite(ValidarValor.getDouble(limiteCliente.getText()));
        cliente.setObs(obsCadCliente.getText());
        
        if (pessoa != null) {
            cliente.setPessoa(pessoa);
        } else {
            throw new Exception(" Por favor, inserir uma Pessoa.");
        }        
    }

    private void atualizaTabCliente() {
       try {

            if (cnvClienteCad == null) {
                cnvClienteCad = new CnvCadastroCliente();
            }

            cnvClienteCad.iniciarNavTabela();

            cnvClienteCad.primeiro();
            atualizarTabelaClienteCad();

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    private void inativarCliente() throws Exception {
        cliente.setAtivo(false);
        cliente = clienteDao.addCliente(cliente);
        limpaCamposCliente();
    }

    private void carregaCliente() throws Exception{
        cliente = clienteDao.get(ValidarValor.getLong(codCadCliente.getText()));
        if (cliente != null) {

            codCadCliente.setText(cliente.getCodCliente().toString());
            carregaPessoaCliente();
            
            ativoCliente.setSelected(cliente.getAtivo());
            serasa.setSelected(cliente.getSerasa());
            contatoCliente.setText(cliente.getContato());
            limiteCliente.setText(ValidarValor.getDouble(cliente.getLimite()));
            obsCadCliente.setText(cliente.getObs());
            
        } else {
            limpaCamposCliente();
            new Exception("Por favor, inserir um código válido.");
        }
    }

    private void carregaPessoaCliente() throws Exception {
        pessoa = pessoaDao.get(ValidarValor.getLong(codPessoaCadCliente.getText()));
        
        if (pessoa != null) {
            
            cnpjCadCliente.setText(pessoa.getCnpj());
            nomePessoaCadCliente.setText(pessoa.getNome());
            telefoneCadCliente.setText(pessoa.getTelefone());
            emailCadCliente.setText(pessoa.getEmail());
            codLogradouroCadCliente.setText(pessoa.getLogradouro().getCodLogradouro().toString());
            nomeLogradouroCadCliente.setText(pessoa.getLogradouro().getDescricao());
            numeroCadCliente.setText(pessoa.getNumCasa());
            codBairroCadCliente.setText(pessoa.getBairro().getCodBairro().toString());
            nomeBairroCadCliente.setText(pessoa.getBairro().getDescricao());
            complementoCadCliente.setText(pessoa.getComplemento());
            codCidadeCadCliente.setText(pessoa.getCidade().getCodCidade().toString());
            nomeCidadeCadCliente.setText(pessoa.getCidade().getDescricao());
            ufCadCliente.setText(pessoa.getUf());
            cepCadCliente.setText(pessoa.getCep());
            
        } else {
            new Exception("Pessao Cadastra ao Cliente null.");
        }
    }

}
