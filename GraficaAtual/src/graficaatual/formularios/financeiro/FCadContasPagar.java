/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.financeiro;

import graficaatual.daos.cadastro.FornecedorDAO;
import graficaatual.daos.financeiro.CaixaDAO;
import graficaatual.daos.financeiro.ContasAPagarDAO;
import graficaatual.daos.financeiro.FormaDePagamentoDAO;
import graficaatual.daos.financeiro.LancamentoCaixaDAO;
import graficaatual.daos.financeiro.PlanoDeContasDAO;
import graficaatual.entidades.ControleAcesso;
import graficaatual.entidades.Fornecedor;
import graficaatual.entidades.financeiro.Caixa;
import graficaatual.entidades.financeiro.ContasAPagar;
import graficaatual.entidades.financeiro.FormaDePagamento;
import graficaatual.entidades.financeiro.LancamentoCaixa;
import graficaatual.entidades.financeiro.PlanoDeContas;
import graficaatual.utilitarios.Componentes;
import graficaatual.utilitarios.Data;
import graficaatual.utilitarios.Persistencia;
import graficaatual.utilitarios.ValidarValor;
import graficaatual.utilitarios.VisualizaRelatorio;
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
 * @author User
 */
public class FCadContasPagar extends javax.swing.JInternalFrame {

    private Caixa caixa;
    private CaixaDAO caixaDAO = new CaixaDAO();

    private ContasAPagar pagar = null;
    private ContasAPagarDAO pagarDao = new ContasAPagarDAO();

    private PlanoDeContas plano = null;
    private PlanoDeContasDAO planoDao = new PlanoDeContasDAO();

    private LancamentoCaixaDAO lancCaixaDao = new LancamentoCaixaDAO();

    private Fornecedor fornecedor;
    private FornecedorDAO fornecedorDao = new FornecedorDAO();

    private FormaDePagamento forma;
    private FormaDePagamentoDAO formaDao = new FormaDePagamentoDAO();

    private List<Fornecedor> listaFornecedor = null;
    private List<PlanoDeContas> listaPlano = null;
    private List<FormaDePagamento> listaForma = null;
    private List<Caixa> listaCaixa = null;

    public FCadContasPagar() {
        initComponents();

        listaFornecedor = ObservableCollections.observableList(new LinkedList<Fornecedor>());
        Componentes comp2 = new Componentes(listaFornecedor, false, codFornecedor, descFornecedor, this, jPanel18, descFornecedor.getWidth(), 100);
        comp2.addCol(0, "codFornecedor", "Código", 50, Long.class.getName());
        comp2.addCol(1, "pessoa.nome", "Nome", 200, String.class.getName());
        comp2.bind();

        listaPlano = ObservableCollections.observableList(new LinkedList<PlanoDeContas>());
        Componentes comp3 = new Componentes(listaPlano, false, codPlanoDeContas, descPlanoDeContas, this, jPanel18, descPlanoDeContas.getWidth(), 100);
        comp3.addCol(0, "codPlano", "Código", 50, Integer.class.getName());
        comp3.addCol(1, "descricao", "Plano de Contas", 200, String.class.getName());
        comp3.bind();

        listaForma = ObservableCollections.observableList(new LinkedList<FormaDePagamento>());
        Componentes comp4 = new Componentes(listaForma, false, codFormaPagamento, descFormaPagamento, this, jPanel18, descFormaPagamento.getWidth(), 100);
        comp4.addCol(0, "codForma", "Código", 50, Integer.class.getName());
        comp4.addCol(1, "descricao", "Forma de Pagamento", 200, String.class.getName());
        comp4.bind();

        listaCaixa = ObservableCollections.observableList(new LinkedList<Caixa>());
        Componentes comp5 = new Componentes(listaCaixa, false, codCaixa, descCaixa, this, jPanel18, descCaixa.getWidth(), 100);
        comp5.addCol(0, "codCaixa", "Código", 50, Integer.class.getName());
        comp5.addCol(1, "descricao", "Caixa", 200, String.class.getName());
        comp5.bind();

        atualizatabela();

        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

    }

    private static FCadContasPagar instancia;
    private static FCadContasPagar instanceCont;
    private static int initControle;

    public static int isInicializado() {
        return initControle;
    }

    public synchronized static FCadContasPagar getInstancia() {
        if (instancia == null) {
            instancia = new FCadContasPagar();
            initControle = 1;
        }

        return instancia;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel18 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        descFornecedor = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jTextField49 = new javax.swing.JTextField();
        jTextField50 = new javax.swing.JTextField();
        jTextField51 = new javax.swing.JTextField();
        jTextField52 = new javax.swing.JTextField();
        jTextField53 = new javax.swing.JTextField();
        jTextField54 = new javax.swing.JTextField();
        jTextField55 = new javax.swing.JTextField();
        jTextField56 = new javax.swing.JTextField();
        jTextField57 = new javax.swing.JTextField();
        jTextField58 = new javax.swing.JTextField();
        jTextField59 = new javax.swing.JTextField();
        jTextField60 = new javax.swing.JTextField();
        jTextField61 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jTextField62 = new javax.swing.JTextField();
        jTextField63 = new javax.swing.JTextField();
        jTextField64 = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        codPagar = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        btSair1 = new javax.swing.JButton();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        codPlanoDeContas = new javax.swing.JTextField();
        descPlanoDeContas = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        valorAPagar = new javax.swing.JTextField();
        dataPrevista = new javax.swing.JFormattedTextField();
        try{
            dataPrevista = new JFormattedTextField(
                new MaskFormatter("##/##/####"));
            ((JFormattedTextField) dataPrevista).setFocusLostBehavior(0);
        }catch(Exception e){}
        jLabel86 = new javax.swing.JLabel();
        valorPago = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        codFormaPagamento = new javax.swing.JTextField();
        descFormaPagamento = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        obs = new javax.swing.JTextArea();
        jLabel89 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        codFornecedor = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        dataPagamento = new javax.swing.JFormattedTextField();
        try{
            dataPagamento = new JFormattedTextField(
                new MaskFormatter("##/##/####"));
            ((JFormattedTextField) dataPagamento).setFocusLostBehavior(0);
        }catch(Exception e){}
        btSalvar1 = new javax.swing.JButton();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        codCaixa = new javax.swing.JTextField();
        descCaixa = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setPreferredSize(new java.awt.Dimension(1100, 700));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setMinimumSize(new java.awt.Dimension(1100, 700));
        jPanel18.setPreferredSize(new java.awt.Dimension(1100, 700));
        jPanel18.setLayout(null);

        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel78.setText("Fornecedor");
        jPanel18.add(jLabel78);
        jLabel78.setBounds(200, 70, 380, 20);

        descFornecedor.setBackground(new java.awt.Color(255, 255, 204));
        descFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descFornecedorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descFornecedorKeyReleased(evt);
            }
        });
        jPanel18.add(descFornecedor);
        descFornecedor.setBounds(200, 90, 840, 20);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setLayout(null);
        jPanel19.add(jTextField49);
        jTextField49.setBounds(160, 10, 90, 20);

        jTextField50.setBackground(new java.awt.Color(255, 255, 204));
        jPanel19.add(jTextField50);
        jTextField50.setBounds(340, 30, 310, 20);

        jTextField51.setBackground(new java.awt.Color(255, 255, 204));
        jPanel19.add(jTextField51);
        jTextField51.setBounds(160, 50, 490, 20);
        jPanel19.add(jTextField52);
        jTextField52.setBounds(120, 160, 80, 20);
        jPanel19.add(jTextField53);
        jTextField53.setBounds(200, 160, 470, 20);
        jPanel19.add(jTextField54);
        jTextField54.setBounds(780, 160, 140, 20);
        jPanel19.add(jTextField55);
        jTextField55.setBounds(120, 180, 80, 20);
        jPanel19.add(jTextField56);
        jTextField56.setBounds(200, 180, 470, 20);
        jPanel19.add(jTextField57);
        jTextField57.setBounds(780, 180, 140, 20);
        jPanel19.add(jTextField58);
        jTextField58.setBounds(120, 200, 80, 20);
        jPanel19.add(jTextField59);
        jTextField59.setBounds(200, 200, 310, 20);
        jPanel19.add(jTextField60);
        jTextField60.setBounds(780, 200, 140, 20);
        jPanel19.add(jTextField61);
        jTextField61.setBounds(580, 200, 90, 20);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Física", "Juridica" }));
        jPanel19.add(jComboBox3);
        jComboBox3.setBounds(160, 30, 180, 18);

        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel90.setText("UF: ");
        jPanel19.add(jLabel90);
        jLabel90.setBounds(510, 200, 70, 20);

        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel91.setText("CEP: ");
        jPanel19.add(jLabel91);
        jLabel91.setBounds(670, 200, 110, 20);

        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel92.setText("Código: ");
        jPanel19.add(jLabel92);
        jLabel92.setBounds(80, 10, 80, 20);

        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel93.setText("Data Nascimento: ");
        jPanel19.add(jLabel93);
        jLabel93.setBounds(650, 70, 140, 20);

        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel94.setText("Número: ");
        jPanel19.add(jLabel94);
        jLabel94.setBounds(670, 160, 110, 20);

        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel95.setText("Insc. Estadual:");
        jPanel19.add(jLabel95);
        jLabel95.setBounds(650, 50, 140, 20);

        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel96.setText("Bairro: ");
        jPanel19.add(jLabel96);
        jLabel96.setBounds(20, 180, 100, 20);

        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel97.setText("Logradouro: ");
        jPanel19.add(jLabel97);
        jLabel97.setBounds(20, 160, 100, 20);

        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel98.setText("Complemento: ");
        jPanel19.add(jLabel98);
        jLabel98.setBounds(670, 180, 110, 20);

        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel99.setText("Cidade: ");
        jPanel19.add(jLabel99);
        jLabel99.setBounds(20, 200, 100, 20);

        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel100.setBorder(javax.swing.BorderFactory.createTitledBorder("Endeço:"));
        jPanel19.add(jLabel100);
        jLabel100.setBounds(10, 130, 920, 110);

        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel101.setText("CPF/CNPJ: ");
        jPanel19.add(jLabel101);
        jLabel101.setBounds(80, 30, 80, 20);
        jPanel19.add(jTextField62);
        jTextField62.setBounds(790, 70, 130, 20);
        jPanel19.add(jTextField63);
        jTextField63.setBounds(790, 30, 130, 20);
        jPanel19.add(jTextField64);
        jTextField64.setBounds(790, 50, 130, 20);

        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel102.setText("Nome/Razão Socia: ");
        jPanel19.add(jLabel102);
        jLabel102.setBounds(10, 50, 150, 20);

        jLabel103.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel103.setText("Insc. Munícipal:");
        jPanel19.add(jLabel103);
        jLabel103.setBounds(650, 30, 140, 20);

        jPanel18.add(jPanel19);
        jPanel19.setBounds(0, 0, 0, 0);

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/NOVO2.png"))); // NOI18N
        btNovo.setText("Novo Cadastro");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel18.add(btNovo);
        btNovo.setBounds(20, 340, 160, 40);

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/formasPagamento2.png"))); // NOI18N
        btSalvar.setText("Conf.Pag.");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel18.add(btSalvar);
        btSalvar.setBounds(360, 340, 180, 40);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excuir2.png"))); // NOI18N
        btExcluir.setText("Deletar");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel18.add(btExcluir);
        btExcluir.setBounds(540, 340, 170, 40);

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir2.png"))); // NOI18N
        btSair.setText("Imprimir");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel18.add(btSair);
        btSair.setBounds(710, 340, 170, 40);

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Fornecedor", "Valor a Pagar", "Valor Pago"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
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
        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tab);
        if (tab.getColumnModel().getColumnCount() > 0) {
            tab.getColumnModel().getColumn(0).setPreferredWidth(100);
            tab.getColumnModel().getColumn(1).setPreferredWidth(700);
            tab.getColumnModel().getColumn(2).setPreferredWidth(150);
            tab.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        jPanel18.add(jScrollPane11);
        jScrollPane11.setBounds(10, 400, 1020, 260);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONTAS A PAGAR");
        jPanel18.add(jLabel1);
        jLabel1.setBounds(0, 0, 1100, 70);

        codPagar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codPagar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codPagarFocusLost(evt);
            }
        });
        jPanel18.add(codPagar);
        codPagar.setBounds(20, 90, 90, 20);

        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel80.setText("Código");
        jPanel18.add(jLabel80);
        jLabel80.setBounds(20, 70, 80, 20);

        btSair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAIR2.png"))); // NOI18N
        btSair1.setText("Sair");
        btSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSair1ActionPerformed(evt);
            }
        });
        jPanel18.add(btSair1);
        btSair1.setBounds(880, 340, 160, 40);

        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel82.setText("Código");
        jPanel18.add(jLabel82);
        jLabel82.setBounds(20, 120, 80, 20);

        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel83.setText("Plano de Contas");
        jPanel18.add(jLabel83);
        jLabel83.setBounds(110, 120, 140, 20);

        codPlanoDeContas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codPlanoDeContas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codPlanoDeContasFocusLost(evt);
            }
        });
        jPanel18.add(codPlanoDeContas);
        codPlanoDeContas.setBounds(20, 140, 90, 20);

        descPlanoDeContas.setBackground(new java.awt.Color(255, 255, 204));
        descPlanoDeContas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descPlanoDeContasKeyReleased(evt);
            }
        });
        jPanel18.add(descPlanoDeContas);
        descPlanoDeContas.setBounds(110, 140, 400, 20);

        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel84.setText("Data Prevista");
        jPanel18.add(jLabel84);
        jLabel84.setBounds(530, 170, 100, 20);

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel85.setText("Valor a Pagar");
        jPanel18.add(jLabel85);
        jLabel85.setBounds(820, 170, 80, 20);

        valorAPagar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        valorAPagar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorAPagarFocusLost(evt);
            }
        });
        jPanel18.add(valorAPagar);
        valorAPagar.setBounds(820, 190, 90, 20);
        jPanel18.add(dataPrevista);
        dataPrevista.setBounds(530, 190, 120, 20);

        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel86.setText("Valor Pago");
        jPanel18.add(jLabel86);
        jLabel86.setBounds(950, 170, 80, 20);

        valorPago.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        valorPago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorPagoFocusLost(evt);
            }
        });
        jPanel18.add(valorPago);
        valorPago.setBounds(950, 190, 90, 20);

        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel87.setText("Observação");
        jPanel18.add(jLabel87);
        jLabel87.setBounds(20, 220, 140, 20);

        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel88.setText("Forma de Pagamento");
        jPanel18.add(jLabel88);
        jLabel88.setBounds(110, 170, 140, 20);

        codFormaPagamento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codFormaPagamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codFormaPagamentoFocusLost(evt);
            }
        });
        jPanel18.add(codFormaPagamento);
        codFormaPagamento.setBounds(20, 190, 90, 20);

        descFormaPagamento.setBackground(new java.awt.Color(255, 255, 204));
        descFormaPagamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descFormaPagamentoKeyReleased(evt);
            }
        });
        jPanel18.add(descFormaPagamento);
        descFormaPagamento.setBounds(110, 190, 400, 20);

        obs.setColumns(20);
        obs.setLineWrap(true);
        obs.setRows(2);
        jScrollPane4.setViewportView(obs);

        jPanel18.add(jScrollPane4);
        jScrollPane4.setBounds(20, 240, 1020, 80);

        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel89.setText("Código");
        jPanel18.add(jLabel89);
        jLabel89.setBounds(20, 170, 80, 20);

        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel104.setText("Código");
        jPanel18.add(jLabel104);
        jLabel104.setBounds(110, 70, 80, 20);

        codFornecedor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codFornecedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codFornecedorFocusLost(evt);
            }
        });
        jPanel18.add(codFornecedor);
        codFornecedor.setBounds(110, 90, 90, 20);

        jLabel105.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel105.setText("Data Pagamento");
        jPanel18.add(jLabel105);
        jLabel105.setBounds(680, 170, 100, 20);
        jPanel18.add(dataPagamento);
        dataPagamento.setBounds(680, 190, 120, 20);

        btSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar2.png"))); // NOI18N
        btSalvar1.setText("Salvar/Atualizar");
        btSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvar1ActionPerformed(evt);
            }
        });
        jPanel18.add(btSalvar1);
        btSalvar1.setBounds(180, 340, 180, 40);

        jLabel106.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel106.setText("Código");
        jPanel18.add(jLabel106);
        jLabel106.setBounds(530, 120, 80, 20);

        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel107.setText("Caixa");
        jPanel18.add(jLabel107);
        jLabel107.setBounds(620, 120, 140, 20);

        codCaixa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codCaixa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codCaixaFocusLost(evt);
            }
        });
        jPanel18.add(codCaixa);
        codCaixa.setBounds(530, 140, 90, 20);

        descCaixa.setBackground(new java.awt.Color(255, 255, 204));
        descCaixa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descCaixaKeyReleased(evt);
            }
        });
        jPanel18.add(descCaixa);
        descCaixa.setBounds(620, 140, 400, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 673, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void descFornecedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descFornecedorKeyReleased
        try {
            List<Fornecedor> merged = fornecedorDao.getList(12,
                    "select e from Fornecedor e where  lower ( trim(e.pessoa.nome) ) like ?1 order by e.codFornecedor",
                    descFornecedor.getText().trim().toLowerCase() + "%");
            listaFornecedor.clear();
            listaFornecedor.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Fornecedores. Erro: " + e);
        }
    }//GEN-LAST:event_descFornecedorKeyReleased

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        try {
            pagar = new ContasAPagar();
            limpaCampos();
            habilitaCampos(true);
            descFornecedor.requestFocus();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {
            pagar = pagarDao.get(ValidarValor.getInt(codPagar.getText()));
            if (pagar != null) {
                if (dataPagamento.getText().length() > 5) {
                    //Salvar a Data de Pagamento no a receber
                    pagar.setDataPagamento(Data.getDateParse(dataPagamento.getText(), Data.FORMAT_DATA_BR));
                    pagar.setValorPago(ValidarValor.getDouble(valorPago.getText()));
                    pagarDao.salvar(session, pagar);

                    //Faz o Lancamento 
                    LancamentoCaixa lancCaixa = new LancamentoCaixa();
                    lancCaixa.setCaixa(pagar.getCaixa());
                    lancCaixa.setDataCadastro(new Date());
                    lancCaixa.setDescricao("Conta " + pagar.getCodContasPag() + " confirmado o pagamento");
                    lancCaixa.setPlanoConta(pagar.getPlanoContas());
                    lancCaixa.setUsuarioCadastro(ControleAcesso.usuario.getCodUsuario() + " "
                            + ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                    lancCaixa.setValorEntrada(ValidarValor.getDouble(valorPago.getText()));
                    lancCaixa.setValorSaida(0.0);

                    lancCaixa = lancCaixaDao.salvar(session, lancCaixa);

                    //Atualizar valor Caixa
                    caixa = pagar.getCaixa();
                    caixa.setValorFechamentoDia(caixa.getValorInicial());
                    caixa.setValorInicial(caixa.getValorInicial() - ValidarValor.getDouble(valorPago.getText()));
                    caixa = caixaDAO.salvar(session, caixa);

                    session.getTransaction().commit();
                    session.close();

                    JOptionPane.showMessageDialog(this, " Tarefa Finalizada com Sucesso! ");
                } else {
                    throw new Exception(" Insira Uma data de Pagamento");
                }
            } else {
                throw new Exception(" Selecione uma Conta à Pagar");
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        try {
            pagar = pagarDao.get(ValidarValor.getInt(codPagar.getText()));
            if (pagar == null) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um codigo válido. ");
            } else {
                setPagar();
                pagarDao.delete(pagar);
                limpaCampos();
                JOptionPane.showMessageDialog(this, "Exclusão realizada com sucesso");
                descFornecedor.requestFocus();
            }
            atualizatabela();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        try {

            if (codPagar.getText().length() > 0) {

                String sql = " SELECT c.codcontaspag, c.valorpagar, p.nome, f.descricao as forma, cx.descricao as caixa  "
                        + " FROM contasapagar c "
                        + " INNER JOIN fornecedor fornec ON fornec.codfornecedor = c.fornecedor"
                        + " INNER JOIN pessoa p ON p.codpessoa = fornec.pessoa "
                        + " INNER JOIN formadepagamento f ON f.codforma = c.formapagamento "
                        + " INNER JOIN caixa cx On cx.codcaixa = c.caixa "
                        + " WHERE c.codcontaspag = " + codPagar.getText()
                        + " ORDER BY p.nome asc";

                new VisualizaRelatorio().visRel("graficaatual/relatorios/arquivos/RelContasPagarIndividual.jasper", "RELATÓRIO DE CONTAS A PAGAR INDIVIDUAL", null, sql);

            } else {

                throw new Exception("Por favor escolha uma conta a receber.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório de bancos! \n " + e);
        }
    }//GEN-LAST:event_btSairActionPerformed

    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
        try {
            if (evt.getClickCount() > 1) {
                codPagar.setText(tab.getValueAt(tab.getSelectedRow(), 0).toString());
                caixa = caixaDAO.get(ValidarValor.getInt(codPagar.getText()));
                codPagarFocusLost(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_tabMouseClicked

    private void codPagarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codPagarFocusLost
        try {
            pagar = pagarDao.get(ValidarValor.getInt(codPagar.getText()));
            if (pagar != null) {

                codFornecedor.setText(pagar.getFornecedor().getCodFornecedor() + "");
                codPlanoDeContas.setText(pagar.getPlanoContas().getCodPlano() + "");
                codFormaPagamento.setText(pagar.getFormaPagamento().getCodForma() + "");
                codCaixa.setText(pagar.getCaixa().getCodCaixa() + "");

                carregaTudo();
            } else {
                limpaCampos();
            }

            atualizatabela();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_codPagarFocusLost

    private void btSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSair1ActionPerformed
        dispose();
    }//GEN-LAST:event_btSair1ActionPerformed

    private void codPlanoDeContasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codPlanoDeContasFocusLost
        try {
            carregaPlano();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codPlanoDeContasFocusLost

    private void descPlanoDeContasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descPlanoDeContasKeyReleased
        try {
            List<PlanoDeContas> merged = planoDao.getList(12,
                    "select e from PlanoDeContas e where  lower ( trim(e.descricao) ) like ?1 order by e.codPlano",
                    descPlanoDeContas.getText().trim().toLowerCase() + "%");
            listaPlano.clear();
            listaPlano.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Plano de Contas. Erro: " + e);
        }
    }//GEN-LAST:event_descPlanoDeContasKeyReleased

    private void valorAPagarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorAPagarFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_valorAPagarFocusLost

    private void valorPagoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorPagoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_valorPagoFocusLost

    private void codFormaPagamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codFormaPagamentoFocusLost
        try {
            carregaForma();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codFormaPagamentoFocusLost

    private void descFormaPagamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descFormaPagamentoKeyReleased
        try {
            List<FormaDePagamento> merged = formaDao.getList(12,
                    "select e from FormaDePagamento e where  lower ( trim(e.descricao) ) like ?1 order by e.codForma",
                    descFormaPagamento.getText().trim().toLowerCase() + "%");
            listaForma.clear();
            listaForma.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Plano de Contas. Erro: " + e);
        }
    }//GEN-LAST:event_descFormaPagamentoKeyReleased

    private void codFornecedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codFornecedorFocusLost
        try {
            carregaFornecedor();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codFornecedorFocusLost

    private void btSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvar1ActionPerformed
        try {
            pagar = pagarDao.get(ValidarValor.getInt(codPagar.getText()));
            if (pagar == null) {
                pagar = new ContasAPagar();
                setPagar();
                pagar.setDataCadastro(new Date());
                pagar.setDataAtualizacao(new Date());
                if (pagarDao.confereContaPagar(pagar)) {
                    pagar = pagarDao.salvar(pagar);
                    codPagar.setText(pagar.getCodContasPag().toString());
                    pagar.setDataAtualizacao(new Date());
                    btSalvar.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Contas a Pagar já Cadastrada");
                }
            }
            setPagar();
            pagarDao.salvar(pagar);
            atualizatabela();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btSalvar1ActionPerformed

    private void descFornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descFornecedorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_descFornecedorKeyPressed

    private void codCaixaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codCaixaFocusLost
        try {
            carregaCaixa();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codCaixaFocusLost

    private void descCaixaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descCaixaKeyReleased
        try {
            List<Caixa> merged = caixaDAO.getList(12,
                    "select e from Caixa e where  lower ( trim(e.descricao) ) like ?1 order by e.codCaixa",
                    descCaixa.getText().trim().toLowerCase() + "%");
            listaCaixa.clear();
            listaCaixa.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Caixa. Erro: " + e);
        }
    }//GEN-LAST:event_descCaixaKeyReleased

    private void limpaCampos() {
        codPagar.setText("");
        codFornecedor.setText("");
        descFornecedor.setText("");
        codPlanoDeContas.setText("");
        descPlanoDeContas.setText("");
        codFormaPagamento.setText("");
        descFormaPagamento.setText("");
        codCaixa.setText("");
        descCaixa.setText("");
        dataPrevista.setText("");
        dataPagamento.setText("");
        valorAPagar.setText("");
        valorPago.setText("");
        obs.setText("");
    }

    private void habilitaCampos(boolean b) {
        codPagar.setEnabled(b);
        descFornecedor.setEnabled(b);
        codPlanoDeContas.setEnabled(b);
        descPlanoDeContas.setEnabled(b);
        codFormaPagamento.setEnabled(b);
        descFormaPagamento.setEnabled(b);
        dataPrevista.setEnabled(b);
        dataPagamento.setEnabled(b);
        valorAPagar.setEnabled(b);
        valorPago.setEnabled(b);

        btSalvar.setEnabled(b);
    }

    private void setPagar() throws Exception {

        if (descFornecedor.getText().length() < 2) {
            throw new Exception("Favor inserir um Fornecedor");
        }

        if (descPlanoDeContas.getText().length() < 2) {
            throw new Exception("Favor inserir um Plano de Contas");
        }

        if (descFormaPagamento.getText().length() < 2) {
            throw new Exception("Favor inserir uma Forma de Pagamento");
        }
        
        if(descCaixa.getText().length() < 2){
            throw  new Exception("Favor inserir uma Caixa");
        }

        pagar.setFornecedor(fornecedor);
        pagar.setPlanoContas(plano);
        pagar.setFormaPagamento(forma);
        pagar.setCaixa(caixa);
        pagar.setObservacao(obs.getText());
        pagar.setDataPrevista(Data.getDateSQL(dataPrevista.getText()));
        pagar.setDataPagamento(Data.getDateSQL(dataPagamento.getText()));
        pagar.setValorPago(ValidarValor.getDouble(valorPago.getText()));
        pagar.setValorPagar(ValidarValor.getDouble(valorAPagar.getText()));

    }

    public static void removeLinhas(JTable table) {
        int n = table.getRowCount();

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (int i = n - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private void carregaFornecedor() throws Exception {
        fornecedor = fornecedorDao.get(ValidarValor.getLong(codFornecedor.getText()));
        if (fornecedor != null) {
            descFornecedor.setText(fornecedor.getPessoa().getNome());

        } else {
            descFornecedor.setText("");

        }
    }

    private void carregaPlano() throws Exception {
        plano = planoDao.get(ValidarValor.getInt(codPlanoDeContas.getText()));
        if (plano != null) {
            descPlanoDeContas.setText(plano.getDescricao());

        } else {
            descPlanoDeContas.setText("");

        }
    }

    private void carregaCaixa() throws Exception {
        caixa = caixaDAO.get(ValidarValor.getInt(codCaixa.getText()));
        if (caixa != null) {
            descCaixa.setText(caixa.getDescricao());

        } else {
            descCaixa.setText("");

        }
    }

    private void carregaForma() throws Exception {
        forma = formaDao.get(ValidarValor.getInt(codFormaPagamento.getText()));
        if (forma != null) {
            descFormaPagamento.setText(plano.getDescricao());

        } else {
            descFormaPagamento.setText("");

        }
    }

    private void carregaTudo() throws Exception {
        carregaFornecedor();
        carregaPlano();
        carregaForma();
        carregaCaixa();

        dataPrevista.setText(Data.getDate(pagar.getDataPrevista()));
        dataPagamento.setText(Data.getDate(pagar.getDataPagamento()));
        valorAPagar.setText(ValidarValor.getDouble(pagar.getValorPagar()));
        valorPago.setText(ValidarValor.getDouble(pagar.getValorPago()));
        obs.setText(pagar.getObservacao());

    }

    private void atualizatabela() {
        try {
            DefaultTableModel model = (DefaultTableModel) tab.getModel();
            removeLinhas(tab);
            List<ContasAPagar> listaT = pagarDao.getList();
            if (listaT.size() > 0) {
                model.setNumRows(0);
                for (ContasAPagar c : listaT) {
                    Object o[] = new Object[]{
                        c.getCodContasPag(),
                        c.getFornecedor().getPessoa().getNome(),
                        c.getValorPagar(),
                        c.getValorPago()};

                    model.addRow(o);
                }
            }
            tab.setModel(model);
        } catch (Exception e) {
            removeLinhas(tab);
            e.printStackTrace();
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSair1;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btSalvar1;
    private javax.swing.JTextField codCaixa;
    private javax.swing.JTextField codFormaPagamento;
    private javax.swing.JTextField codFornecedor;
    private javax.swing.JTextField codPagar;
    private javax.swing.JTextField codPlanoDeContas;
    private javax.swing.JFormattedTextField dataPagamento;
    private javax.swing.JFormattedTextField dataPrevista;
    private javax.swing.JTextField descCaixa;
    private javax.swing.JTextField descFormaPagamento;
    private javax.swing.JTextField descFornecedor;
    private javax.swing.JTextField descPlanoDeContas;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField55;
    private javax.swing.JTextField jTextField56;
    private javax.swing.JTextField jTextField57;
    private javax.swing.JTextField jTextField58;
    private javax.swing.JTextField jTextField59;
    private javax.swing.JTextField jTextField60;
    private javax.swing.JTextField jTextField61;
    private javax.swing.JTextField jTextField62;
    private javax.swing.JTextField jTextField63;
    private javax.swing.JTextField jTextField64;
    private javax.swing.JTextArea obs;
    private javax.swing.JTable tab;
    private javax.swing.JTextField valorAPagar;
    private javax.swing.JTextField valorPago;
    // End of variables declaration//GEN-END:variables
}
