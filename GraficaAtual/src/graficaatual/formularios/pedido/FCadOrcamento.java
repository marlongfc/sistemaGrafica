/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.pedido;

import graficaatual.daos.cadastro.AcabamentoDAO;
import graficaatual.daos.pedido.OrcamentoDAO;
import graficaatual.daos.cadastro.ClienteDAO;
import graficaatual.daos.cadastro.ComposicaoProdutoDAO;
import graficaatual.daos.cadastro.ProdutoDAO;
import graficaatual.daos.estoque.SaidaEstoqueDAO;
import graficaatual.daos.financeiro.FormaDePagamentoDAO;
import graficaatual.daos.pedido.ItemOrcamentoDAO;
import graficaatual.daos.producao.OrdemServicoDAO;
import graficaatual.daos.relatorio.TextoPadraoDAO;
import graficaatual.entidades.Acabamento;
import graficaatual.entidades.Cliente;
import graficaatual.entidades.ComposicaoProduto;
import graficaatual.entidades.ControleAcesso;
import graficaatual.entidades.pedido.Orcamento;
import graficaatual.entidades.Produto;
import graficaatual.entidades.estoque.SaidaEstoque;
import graficaatual.entidades.financeiro.FormaDePagamento;
import graficaatual.entidades.pedido.ItemOrcamento;
import graficaatual.utilitarios.Componentes;
import graficaatual.utilitarios.Data;
import graficaatual.utilitarios.Persistencia;
import graficaatual.utilitarios.ValidarValor;
import graficaatual.utilitarios.VisualizaRelatorio;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Moises
 */
public class FCadOrcamento extends javax.swing.JInternalFrame {

    private Orcamento orcamento;
    private OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
    private ItemOrcamento itemOrcamento;
    private ItemOrcamentoDAO itemOrcaDAO = new ItemOrcamentoDAO();
    private List<ItemOrcamento> listaItem = new ArrayList<ItemOrcamento>();

    private Cliente cliente;
    private ClienteDAO clientedao = new ClienteDAO();

    private FormaDePagamento formaPagamento;
    private FormaDePagamentoDAO formaPagamentoDao = new FormaDePagamentoDAO();

    private Acabamento acabamento;
    private AcabamentoDAO acabamentoDao = new AcabamentoDAO();

    private Produto produto;
    private ProdutoDAO produtoDAO = new ProdutoDAO();

    private ComposicaoProdutoDAO composicaoDao = new ComposicaoProdutoDAO();
    private SaidaEstoqueDAO saidaDao = new SaidaEstoqueDAO();

    private List<Cliente> listaCliente = null;
    private List<Produto> listaProduto = null;

    private List<Integer> listaQtdProd = null;
    private List<Double> listaDescontoProd = null;

    private List<FormaDePagamento> listaFormaPagamento;
    private List<Acabamento> listaAcabamento;

    Double totalGlobal = 0.00;

    public FCadOrcamento() {
        initComponents();

        listaCliente = ObservableCollections.observableList(new LinkedList<Cliente>());
        Componentes comp1 = new Componentes(listaCliente, false, codCliente, descCliente, jPanel18, jPanel18, descCliente.getWidth(), 100);
        comp1.addCol(0, "codCliente", "Código", 50, Long.class.getName());
        comp1.addCol(1, "pessoa.nome", "Nome", 200, String.class.getName());
        comp1.bind();

        listaProduto = ObservableCollections.observableList(new LinkedList<Produto>());
        Componentes comp2 = new Componentes(listaProduto, false, codProduto, descProduto, jPanel18, jPanel1, descProduto.getWidth(), 100);
        comp2.addCol(0, "codProduto", "Código", 50, Long.class.getName());
        comp2.addCol(1, "descricao", "Produto", 200, String.class.getName());
        comp2.bind();

        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        checkSituacao.setBackground(Color.red);

        atualizarTabelaOrcamento();
        atualizarTabelaPedido();

        adicionarComboFormaPagamento();
        adicionarComboAcabamento();

        dataOrc.setText(Data.getDate(new Date()));

        Date dataTeste = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(dataTeste);
        cal.add(Calendar.DATE, 15);
        dataTeste = cal.getTime();
        validadeProposta.setText(Data.getDate(dataTeste));

        habilitaCamposProduto(false);

    }

    private static FCadOrcamento instancia;
    private static FCadOrcamento instanceCont;
    private static int initControle;

    public static int isInicializado() {
        return initControle;
    }

    public synchronized static FCadOrcamento getInstancia() {
        if (instancia == null) {
            instancia = new FCadOrcamento();
            initControle = 1;
        }

        return instancia;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        descCliente = new javax.swing.JTextField();
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
        jLabel1 = new javax.swing.JLabel();
        codOrcamento = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        descProduto = new javax.swing.JTextField();
        codProduto = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        valorUnitario = new javax.swing.JTextField();
        quantidadeProduto = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        btNovoItem = new javax.swing.JButton();
        btAdicionarItem = new javax.swing.JButton();
        btRemoverItem = new javax.swing.JButton();
        jLabel88 = new javax.swing.JLabel();
        valortotalProduto = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        medidaProduto = new javax.swing.JTextField();
        jLabel115 = new javax.swing.JLabel();
        unidadeProduto = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        comboAcabamento = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        checkCaixariaAcabamento = new javax.swing.JCheckBox();
        checkPloterRecorte = new javax.swing.JCheckBox();
        checkProjeto = new javax.swing.JCheckBox();
        checkPlotagem = new javax.swing.JCheckBox();
        checkImpDigital = new javax.swing.JCheckBox();
        checkAcabImpressao = new javax.swing.JCheckBox();
        checkCriacao = new javax.swing.JCheckBox();
        checkSerralheria = new javax.swing.JCheckBox();
        checkPintura = new javax.swing.JCheckBox();
        checkCorteRouter = new javax.swing.JCheckBox();
        checkSituacao = new javax.swing.JCheckBox();
        labelAprovado = new javax.swing.JLabel();
        btSalvarOrca = new javax.swing.JButton();
        btNovoOrca = new javax.swing.JButton();
        descontoMoeda = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        totalGeralOrc = new javax.swing.JTextField();
        dataOrc = new javax.swing.JFormattedTextField();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        codCliente = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        clienteSecundario = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        telefoneSecundario = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        enderecoSecundario = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        comboTipoEntrega = new javax.swing.JComboBox<>();
        btImprimir = new javax.swing.JButton();
        comboFormaPag = new javax.swing.JComboBox<>();
        validadeProposta = new javax.swing.JFormattedTextField();
        prazoEntrega = new javax.swing.JFormattedTextField();
        btExcluir = new javax.swing.JButton();
        jLabel117 = new javax.swing.JLabel();
        descontoPorcentagem = new javax.swing.JTextField();
        btAprovar = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tabItens = new javax.swing.JTable();
        btSair = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabOrcamento = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabPedido = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setPreferredSize(new java.awt.Dimension(1100, 700));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1100, 700));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1100, 700));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setForeground(new java.awt.Color(255, 255, 255));
        jPanel18.setMinimumSize(new java.awt.Dimension(1100, 700));
        jPanel18.setPreferredSize(new java.awt.Dimension(1100, 700));
        jPanel18.setLayout(null);

        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel78.setText("Cliente");
        jPanel18.add(jLabel78);
        jLabel78.setBounds(120, 90, 150, 20);

        descCliente.setBackground(new java.awt.Color(255, 255, 204));
        descCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descClienteKeyReleased(evt);
            }
        });
        jPanel18.add(descCliente);
        descCliente.setBounds(120, 110, 830, 20);

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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ORÇAMENTO/PEDIDO");
        jPanel18.add(jLabel1);
        jLabel1.setBounds(0, 0, 1090, 70);

        codOrcamento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codOrcamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codOrcamentoFocusLost(evt);
            }
        });
        jPanel18.add(codOrcamento);
        codOrcamento.setBounds(40, 70, 80, 20);

        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel80.setText("Código");
        jPanel18.add(jLabel80);
        jLabel80.setBounds(40, 50, 40, 20);

        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel82.setText("Validade da Proposta");
        jPanel18.add(jLabel82);
        jLabel82.setBounds(190, 130, 140, 20);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11))); // NOI18N
        jPanel1.setLayout(null);

        descProduto.setBackground(new java.awt.Color(255, 255, 204));
        descProduto.setEnabled(false);
        descProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descProdutoKeyReleased(evt);
            }
        });
        jPanel1.add(descProduto);
        descProduto.setBounds(80, 40, 510, 20);

        codProduto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codProduto.setEnabled(false);
        codProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codProdutoFocusLost(evt);
            }
        });
        jPanel1.add(codProduto);
        codProduto.setBounds(10, 40, 70, 20);

        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel83.setText("Cód. Produto");
        jPanel1.add(jLabel83);
        jLabel83.setBounds(10, 20, 80, 20);

        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel84.setText("Produto");
        jPanel1.add(jLabel84);
        jLabel84.setBounds(90, 20, 130, 20);

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel85.setText("Valor Unitário");
        jPanel1.add(jLabel85);
        jLabel85.setBounds(590, 20, 90, 20);

        valorUnitario.setEnabled(false);
        valorUnitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorUnitarioFocusLost(evt);
            }
        });
        jPanel1.add(valorUnitario);
        valorUnitario.setBounds(590, 40, 100, 20);

        quantidadeProduto.setEnabled(false);
        quantidadeProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                quantidadeProdutoFocusLost(evt);
            }
        });
        jPanel1.add(quantidadeProduto);
        quantidadeProduto.setBounds(691, 40, 100, 20);

        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel86.setText("Quantidade");
        jPanel1.add(jLabel86);
        jLabel86.setBounds(691, 20, 90, 20);

        btNovoItem.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        btNovoItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/NOVO2.png"))); // NOI18N
        btNovoItem.setText("Novo Produto");
        btNovoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoItemActionPerformed(evt);
            }
        });
        jPanel1.add(btNovoItem);
        btNovoItem.setBounds(420, 70, 160, 40);

        btAdicionarItem.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        btAdicionarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar2.png"))); // NOI18N
        btAdicionarItem.setText("Adicionar Produto");
        btAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarItemActionPerformed(evt);
            }
        });
        jPanel1.add(btAdicionarItem);
        btAdicionarItem.setBounds(580, 70, 160, 40);

        btRemoverItem.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        btRemoverItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excuir2.png"))); // NOI18N
        btRemoverItem.setText("Remover Produto");
        btRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverItemActionPerformed(evt);
            }
        });
        jPanel1.add(btRemoverItem);
        btRemoverItem.setBounds(740, 70, 150, 40);

        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel88.setText("Valor Total Produto");
        jPanel1.add(jLabel88);
        jLabel88.setBounds(792, 20, 110, 20);

        valortotalProduto.setEnabled(false);
        jPanel1.add(valortotalProduto);
        valortotalProduto.setBounds(792, 40, 110, 20);

        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel109.setText("Medida");
        jPanel1.add(jLabel109);
        jLabel109.setBounds(10, 70, 80, 20);

        medidaProduto.setEnabled(false);
        jPanel1.add(medidaProduto);
        medidaProduto.setBounds(10, 90, 90, 20);

        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel115.setText("Unidade");
        jPanel1.add(jLabel115);
        jLabel115.setBounds(110, 70, 80, 20);

        unidadeProduto.setEnabled(false);
        jPanel1.add(unidadeProduto);
        unidadeProduto.setBounds(110, 90, 90, 20);

        jLabel116.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel116.setText("Acabamento");
        jPanel1.add(jLabel116);
        jLabel116.setBounds(210, 70, 90, 20);

        comboAcabamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));
        comboAcabamento.setEnabled(false);
        jPanel1.add(comboAcabamento);
        comboAcabamento.setBounds(210, 90, 200, 20);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Etapas"));
        jPanel3.setLayout(null);

        checkCaixariaAcabamento.setBackground(new java.awt.Color(255, 255, 255));
        checkCaixariaAcabamento.setText("Caixaria Acabamento");
        jPanel3.add(checkCaixariaAcabamento);
        checkCaixariaAcabamento.setBounds(300, 40, 170, 23);

        checkPloterRecorte.setBackground(new java.awt.Color(255, 255, 255));
        checkPloterRecorte.setText("Ploter Recorte");
        jPanel3.add(checkPloterRecorte);
        checkPloterRecorte.setBounds(700, 40, 130, 23);

        checkProjeto.setBackground(new java.awt.Color(255, 255, 255));
        checkProjeto.setText("Projeto");
        jPanel3.add(checkProjeto);
        checkProjeto.setBounds(150, 20, 120, 23);

        checkPlotagem.setBackground(new java.awt.Color(255, 255, 255));
        checkPlotagem.setText("Plotagem");
        jPanel3.add(checkPlotagem);
        checkPlotagem.setBounds(300, 20, 130, 23);

        checkImpDigital.setBackground(new java.awt.Color(255, 255, 255));
        checkImpDigital.setText("Impressão Digital");
        jPanel3.add(checkImpDigital);
        checkImpDigital.setBounds(500, 20, 140, 23);

        checkAcabImpressao.setBackground(new java.awt.Color(255, 255, 255));
        checkAcabImpressao.setText("Acabamento Impressão");
        jPanel3.add(checkAcabImpressao);
        checkAcabImpressao.setBounds(700, 20, 170, 23);

        checkCriacao.setBackground(new java.awt.Color(255, 255, 255));
        checkCriacao.setText("Criação");
        jPanel3.add(checkCriacao);
        checkCriacao.setBounds(10, 20, 100, 23);

        checkSerralheria.setBackground(new java.awt.Color(255, 255, 255));
        checkSerralheria.setText("Serralheria");
        jPanel3.add(checkSerralheria);
        checkSerralheria.setBounds(10, 40, 100, 23);

        checkPintura.setBackground(new java.awt.Color(255, 255, 255));
        checkPintura.setText("Pintura");
        jPanel3.add(checkPintura);
        checkPintura.setBounds(150, 40, 120, 23);

        checkCorteRouter.setBackground(new java.awt.Color(255, 255, 255));
        checkCorteRouter.setText("Corte Router");
        jPanel3.add(checkCorteRouter);
        checkCorteRouter.setBounds(500, 40, 140, 23);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 120, 890, 70);

        jPanel18.add(jPanel1);
        jPanel1.setBounds(40, 175, 910, 200);

        checkSituacao.setBackground(new java.awt.Color(204, 0, 0));
        checkSituacao.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        checkSituacao.setForeground(new java.awt.Color(255, 255, 255));
        checkSituacao.setText("Aprovado");
        checkSituacao.setEnabled(false);
        checkSituacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkSituacaoMouseClicked(evt);
            }
        });
        jPanel18.add(checkSituacao);
        checkSituacao.setBounds(840, 70, 100, 23);

        labelAprovado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelAprovado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel18.add(labelAprovado);
        labelAprovado.setBounds(810, 100, 140, 30);

        btSalvarOrca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar2.png"))); // NOI18N
        btSalvarOrca.setText("Salvar");
        btSalvarOrca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarOrcaActionPerformed(evt);
            }
        });
        jPanel18.add(btSalvarOrca);
        btSalvarOrca.setBounds(190, 630, 150, 40);

        btNovoOrca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/NOVO2.png"))); // NOI18N
        btNovoOrca.setText("Novo");
        btNovoOrca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoOrcaActionPerformed(evt);
            }
        });
        jPanel18.add(btNovoOrca);
        btNovoOrca.setBounds(40, 630, 150, 40);

        descontoMoeda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        descontoMoeda.setText("0,00");
        descontoMoeda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                descontoMoedaFocusLost(evt);
            }
        });
        jPanel18.add(descontoMoeda);
        descontoMoeda.setBounds(690, 550, 100, 20);

        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel89.setText("Desconto R$");
        jPanel18.add(jLabel89);
        jLabel89.setBounds(690, 530, 100, 20);

        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel104.setText("Formas de Pagamento");
        jPanel18.add(jLabel104);
        jLabel104.setBounds(690, 490, 150, 20);

        jLabel106.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel106.setText("Total Geral do Orçamento");
        jPanel18.add(jLabel106);
        jLabel106.setBounds(690, 570, 220, 20);

        totalGeralOrc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel18.add(totalGeralOrc);
        totalGeralOrc.setBounds(690, 590, 130, 20);

        try{
            dataOrc = new JFormattedTextField(new MaskFormatter("##/##/####"));
        }catch(Exception e){};
        dataOrc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dataOrcFocusLost(evt);
            }
        });
        jPanel18.add(dataOrc);
        dataOrc.setBounds(40, 150, 120, 20);

        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel107.setText("Cód. Cliente");
        jPanel18.add(jLabel107);
        jLabel107.setBounds(40, 90, 80, 20);

        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel108.setText("Data do Orçamento");
        jPanel18.add(jLabel108);
        jLabel108.setBounds(40, 130, 140, 20);

        codCliente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codClienteFocusLost(evt);
            }
        });
        jPanel18.add(codCliente);
        codCliente.setBounds(40, 110, 80, 20);

        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel110.setText("Prazo de Entrega");
        jPanel18.add(jLabel110);
        jLabel110.setBounds(340, 130, 140, 20);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Forma de Entrega", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11))); // NOI18N
        jPanel2.setLayout(null);

        jLabel111.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel111.setText("Cliente");
        jPanel2.add(jLabel111);
        jLabel111.setBounds(10, 15, 80, 20);
        jPanel2.add(clienteSecundario);
        clienteSecundario.setBounds(10, 35, 420, 20);

        jLabel112.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel112.setText("Telefone");
        jPanel2.add(jLabel112);
        jLabel112.setBounds(430, 15, 70, 20);
        jPanel2.add(telefoneSecundario);
        telefoneSecundario.setBounds(430, 35, 200, 20);

        jLabel113.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel113.setText("Endereço");
        jPanel2.add(jLabel113);
        jLabel113.setBounds(10, 55, 150, 20);
        jPanel2.add(enderecoSecundario);
        enderecoSecundario.setBounds(10, 75, 420, 20);

        jLabel114.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel114.setText("Tipo de Entrega");
        jPanel2.add(jLabel114);
        jLabel114.setBounds(430, 55, 90, 20);

        comboTipoEntrega.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Interna", "Externa" }));
        jPanel2.add(comboTipoEntrega);
        comboTipoEntrega.setBounds(430, 75, 200, 20);

        jPanel18.add(jPanel2);
        jPanel2.setBounds(40, 490, 640, 130);

        btImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir2.png"))); // NOI18N
        btImprimir.setText("Imprimir");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });
        jPanel18.add(btImprimir);
        btImprimir.setBounds(640, 630, 170, 40);

        comboFormaPag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));
        jPanel18.add(comboFormaPag);
        comboFormaPag.setBounds(690, 510, 260, 20);

        try{
            validadeProposta = new JFormattedTextField(new MaskFormatter("##/##/####"));
        }catch(Exception e){};
        jPanel18.add(validadeProposta);
        validadeProposta.setBounds(190, 150, 120, 20);

        try{
            prazoEntrega = new JFormattedTextField(new MaskFormatter("##/##/####"));
        }catch(Exception e){};
        jPanel18.add(prazoEntrega);
        prazoEntrega.setBounds(340, 150, 120, 20);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAIR2.png"))); // NOI18N
        btExcluir.setText("Deletar");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel18.add(btExcluir);
        btExcluir.setBounds(490, 630, 150, 40);

        jLabel117.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel117.setText("Desconto %");
        jPanel18.add(jLabel117);
        jLabel117.setBounds(800, 530, 100, 20);

        descontoPorcentagem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        descontoPorcentagem.setText("0,00");
        descontoPorcentagem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                descontoPorcentagemFocusLost(evt);
            }
        });
        jPanel18.add(descontoPorcentagem);
        descontoPorcentagem.setBounds(800, 550, 100, 20);

        btAprovar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ADICIONAR2.png"))); // NOI18N
        btAprovar.setText("Aprovar");
        btAprovar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAprovarActionPerformed(evt);
            }
        });
        jPanel18.add(btAprovar);
        btAprovar.setBounds(340, 630, 150, 40);

        tabItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Quantidade m²", "Cód.Produto", "Produto", "Medida", "UN", "Acabamento", "Valor Unit.", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
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
        tabItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabItensMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tabItens);
        if (tabItens.getColumnModel().getColumnCount() > 0) {
            tabItens.getColumnModel().getColumn(0).setPreferredWidth(70);
            tabItens.getColumnModel().getColumn(1).setPreferredWidth(120);
            tabItens.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabItens.getColumnModel().getColumn(3).setPreferredWidth(600);
            tabItens.getColumnModel().getColumn(4).setPreferredWidth(80);
            tabItens.getColumnModel().getColumn(5).setPreferredWidth(100);
            tabItens.getColumnModel().getColumn(6).setPreferredWidth(150);
            tabItens.getColumnModel().getColumn(7).setPreferredWidth(100);
            tabItens.getColumnModel().getColumn(8).setPreferredWidth(100);
        }

        jPanel18.add(jScrollPane11);
        jScrollPane11.setBounds(40, 380, 910, 100);

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAIR2.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel18.add(btSair);
        btSair.setBounds(810, 630, 130, 40);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Orçamento", jPanel4);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setMinimumSize(new java.awt.Dimension(1100, 700));
        jPanel7.setPreferredSize(new java.awt.Dimension(1100, 700));
        jPanel7.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ORÇAMENTOS CADASTRADOS");
        jPanel7.add(jLabel2);
        jLabel2.setBounds(0, 0, 1090, 70);

        tabOrcamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód.Orçamento", "Cliente", "Valor (R$)", "Situação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
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
        tabOrcamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabOrcamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabOrcamento);
        if (tabOrcamento.getColumnModel().getColumnCount() > 0) {
            tabOrcamento.getColumnModel().getColumn(0).setPreferredWidth(150);
            tabOrcamento.getColumnModel().getColumn(1).setPreferredWidth(700);
            tabOrcamento.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabOrcamento.getColumnModel().getColumn(3).setResizable(false);
            tabOrcamento.getColumnModel().getColumn(3).setPreferredWidth(80);
        }

        jPanel7.add(jScrollPane1);
        jScrollPane1.setBounds(10, 80, 1030, 570);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Orçamentos Cadastrados", jPanel5);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setMinimumSize(new java.awt.Dimension(1100, 700));
        jPanel8.setPreferredSize(new java.awt.Dimension(1100, 700));
        jPanel8.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PEDIDOS CADASTRADOS");
        jPanel8.add(jLabel3);
        jLabel3.setBounds(0, 0, 1090, 70);

        tabPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód.Pedido", "Cliente", "Valor (R$)", "Situação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPedidoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabPedido);
        if (tabPedido.getColumnModel().getColumnCount() > 0) {
            tabPedido.getColumnModel().getColumn(0).setPreferredWidth(150);
            tabPedido.getColumnModel().getColumn(1).setPreferredWidth(700);
            tabPedido.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabPedido.getColumnModel().getColumn(3).setPreferredWidth(80);
        }

        jPanel8.add(jScrollPane2);
        jScrollPane2.setBounds(10, 80, 1030, 570);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Pedidos Cadastrados", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoOrcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoOrcaActionPerformed
        try {
            orcamento = new Orcamento();
            itemOrcamento = new ItemOrcamento();
            totalGlobal = 0.0;
            listaItem.clear();
            listaItem = new ArrayList<ItemOrcamento>();
            limpaCampos();
            adicionarComboFormaPagamento();
            adicionarComboAcabamento();
            habilitacampos(true);
            dataOrc.setText(Data.getDate(new Date()));
            checkSituacao.setBackground(Color.red);
            descCliente.requestFocus();
            atualizarTabelaOrcamento();
            atualizarTabelaPedido();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btNovoOrcaActionPerformed

    private void btSalvarOrcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarOrcaActionPerformed
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            orcamento = orcamentoDAO.get(ValidarValor.getInt(codOrcamento.getText()));
            if (orcamento == null) {
                orcamento = new Orcamento();
                orcamento.setUsuarioCadastro(ControleAcesso.usuario.getCodUsuario() + " " + ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                orcamento.setDataCadastro(new Date());
            } else {
                orcamento.setUsuarioAtualizacao(ControleAcesso.usuario.getCodUsuario() + " " + ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                orcamento.setDataAtualizacao(new Date());
            }
            setOrcamento();

            orcamento = orcamentoDAO.salvar(session, orcamento);

            List<ItemOrcamento> listaItemExcluir = itemOrcaDAO.getListOrcamento(orcamento.getCodOrcamento());
            for (ItemOrcamento item : listaItemExcluir) {
                itemOrcamento = new ItemOrcamento();
                itemOrcamento = item;
                itemOrcaDAO.salvar(session, itemOrcamento);
            }

            for (ItemOrcamento item : listaItem) {
                itemOrcamento = new ItemOrcamento();
                itemOrcamento = item;
                itemOrcamento.setOrcamento(orcamento);
                itemOrcaDAO.salvar(session, itemOrcamento);
            }

            session.getTransaction().commit();
            session.close();
            limpaCampos();

            atualizarTabelaOrcamento();
            atualizarTabelaPedido();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }


    }//GEN-LAST:event_btSalvarOrcaActionPerformed

    private void btRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverItemActionPerformed
        try {
            if (tabItens.getRowCount() > 0) {
                if (tabItens.getSelectedRow() < 0) {
                    JOptionPane.showMessageDialog(null, "Selecione um produto para exclusão!");
                } else {
                    listaItem.remove(tabItens.getSelectedRow());
                    itemOrcaDAO.delete(itemOrcamento);
                    atualizatabelaItens();
                    limpaCamposProduto();
                    calculaPreçoTotalOrcamentoComDesconto();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }//GEN-LAST:event_btRemoverItemActionPerformed

    private void btAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarItemActionPerformed

        try {

            if (itemOrcamento == null) {
                itemOrcamento = new ItemOrcamento();
            }

            if (codProduto.getText().equals("") || descProduto.getText().equals("") || produto == null) {
                throw new Exception(" Favor Selecionar um Produto. ");
            }

            if (quantidadeProduto.getText().equals("0,00") || ValidarValor.getDouble(quantidadeProduto.getText()) <= 0) {
                throw new Exception(" Favor Informar a quantidade. ");
            }

            if (!checkCriacao.isSelected() && !checkSerralheria.isSelected()
                    && !checkProjeto.isSelected() && !checkPintura.isSelected()
                    && !checkPlotagem.isSelected() && !checkCaixariaAcabamento.isSelected()
                    && !checkImpDigital.isSelected() && !checkCorteRouter.isSelected()
                    && !checkAcabImpressao.isSelected() && !checkPloterRecorte.isSelected()) {
                throw new Exception(" Selecione au menos um setor da produção. ");
            }
            Double vl, vt;

            vl = ValidarValor.getDouble(valorUnitario.getText());
            vt = ValidarValor.getDouble(valortotalProduto.getText());

            acabamento = acabamentoDao.get(comboAcabamento.getSelectedIndex() + 1);

            itemOrcamento.setAcabamento(acabamento);
            itemOrcamento.setProduto(produto);
            itemOrcamento.setQuantProd(ValidarValor.getInt(quantidadeProduto.getText()));
            itemOrcamento.setMedida(medidaProduto.getText());
            itemOrcamento.setUnidade(unidadeProduto.getText());
            itemOrcamento.setValorUnitario(vl);
            itemOrcamento.setValorTotalProduto(vt);

            itemOrcamento.setCheckCriacao(checkCriacao.isSelected());
            itemOrcamento.setCheckSerralheria(checkSerralheria.isSelected());

            itemOrcamento.setCheckProjeto(checkProjeto.isSelected());
            itemOrcamento.setCheckPintura(checkPintura.isSelected());

            itemOrcamento.setCheckPlotagem(checkPlotagem.isSelected());
            itemOrcamento.setCheckCaixariaAcabamento(checkCaixariaAcabamento.isSelected());

            itemOrcamento.setCheckImpressaoDigital(checkImpDigital.isSelected());
            itemOrcamento.setCheckRouter(checkCorteRouter.isSelected());

            itemOrcamento.setCheckAcabamentoImp(checkAcabImpressao.isSelected());
            itemOrcamento.setCheckFaturamento(false);

            itemOrcamento.setCheckPloterRecorte(checkPloterRecorte.isSelected());
            itemOrcamento.setCheckEntrega(false);

            listaItem.add(itemOrcamento);

            atualizatabelaItens();
            calculaPreçoTotalOrcamentoComDesconto();
            habilitaCamposProduto(false);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, " Erro :" + e.getMessage());
        }

    }//GEN-LAST:event_btAdicionarItemActionPerformed

    private void btNovoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoItemActionPerformed
        try {
            produto = new Produto();
            itemOrcamento = new ItemOrcamento();
            limpaCamposProduto();
            habilitaCamposProduto(true);
            descProduto.requestFocus();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btNovoItemActionPerformed

    private void quantidadeProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantidadeProdutoFocusLost
        calculaPrecoTotalProduto();
    }//GEN-LAST:event_quantidadeProdutoFocusLost

    private void valorUnitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorUnitarioFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_valorUnitarioFocusLost

    private void codProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codProdutoFocusLost
        try {
            carregaProduto();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codProdutoFocusLost

    private void descProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descProdutoKeyReleased
        try {
            List<Produto> merged = produtoDAO.getList(12,
                    "select e from Produto e where  lower ( trim(e.descricao) ) like ?1 order by e.codProduto",
                    descProduto.getText().trim().toLowerCase() + "%");
            listaProduto.clear();
            listaProduto.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Produto. Erro: " + e);
        }
    }//GEN-LAST:event_descProdutoKeyReleased

    private void codOrcamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codOrcamentoFocusLost
        try {
            carregaTudo();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codOrcamentoFocusLost

    private void tabItensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabItensMouseClicked
        try {
            if (evt.getClickCount() > 1) {
                limpaCamposProduto();
                itemOrcamento = listaItem.get(tabItens.getSelectedRow());
                if (itemOrcamento != null) {
                    carregaTabProd();
                    codProduto.setText(itemOrcamento.getProduto().getCodProduto() + "");
                    descProduto.setText(itemOrcamento.getProduto().getDescricao());
                    valorUnitario.setText(ValidarValor.getDouble(itemOrcamento.getValorUnitario()));
                    quantidadeProduto.setText(itemOrcamento.getQuantProd().toString());
                    valortotalProduto.setText(ValidarValor.getDouble(itemOrcamento.getValorTotalProduto()));
                    medidaProduto.setText(itemOrcamento.getMedida());
                    unidadeProduto.setText(itemOrcamento.getUnidade());
                    comboAcabamento.setSelectedIndex(itemOrcamento.getAcabamento().getCodAcabamento());
                    checkAcabImpressao.setSelected(itemOrcamento.getCheckAcabamentoImp());
                    checkCaixariaAcabamento.setSelected(itemOrcamento.getCheckCaixariaAcabamento());
                    checkCorteRouter.setSelected(itemOrcamento.getCheckRouter());
                    checkCriacao.setSelected(itemOrcamento.getCheckCriacao());
                    checkImpDigital.setSelected(itemOrcamento.getCheckImpressaoDigital());
                    checkPintura.setSelected(itemOrcamento.getCheckPintura());
                    checkPlotagem.setSelected(itemOrcamento.getCheckPlotagem());
                    checkPloterRecorte.setSelected(itemOrcamento.getCheckPloterRecorte());
                    checkProjeto.setSelected(itemOrcamento.getCheckProjeto());
                    checkSerralheria.setSelected(itemOrcamento.getCheckSerralheria());
                    checkSituacao.setSelected(itemOrcamento.getCheckSerralheria());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tabItensMouseClicked

    private void descClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descClienteKeyReleased
        try {
            List<Cliente> merged = clientedao.getList(12,
                    "select e from Cliente e where  lower ( trim(e.pessoa.nome) ) like ?1 order by e.codCliente",
                    descCliente.getText().trim().toLowerCase() + "%");
            listaCliente.clear();
            listaCliente.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Cliente. Erro: " + e);
        }
    }//GEN-LAST:event_descClienteKeyReleased

    private void codClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codClienteFocusLost
        try {
            carregaCliente();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codClienteFocusLost

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        try {

            String sql = "select cli.codcliente, pes.nome, pes.cnpj, pes.inscestadual, pes.numcasa, pes.uf, pes.cep,pes.email, pes.telefone,"
                    + " log.descricao logradouro, bai.descricao bairro, cid.descricao cidade, "
                    + " orc.clientesecundario, orc.codorcamento,orc.dataorcamento, orc.validadeorcamento, orc.prazoentrega, orc.formapagamento, orc.clientesecundario, "
                    + " orc.enderecosecundario, orc.telefonesecundario, orc.tipodeentrega, "
                    + " prod.codproduto, prod.descricao produto,item.quantprod, item.medida, item.unidade, item.valortotalproduto, item.valorunitario,aca.descricao acabamento, orc.valortotal,"
                    + " case when orc.situacao = true then 'PEDIDO' "
                    + " ELSE 'ORÇAMENTO' end nomeRell "
                    + " FROM orcamento orc "
                    + " INNER JOIN cliente cli ON cli.codcliente = orc.cliente "
                    + " INNER JOIN pessoa pes ON pes.codPessoa = cli.pessoa "
                    + " INNER JOIN itemorcamento item ON item.orcamento = orc.codOrcamento "
                    + " LEFT JOIN logradouro log ON log.codlogradouro = pes.logradouro "
                    + " LEFT JOIN bairro bai ON bai.codbairro = pes.bairro "
                    + " LEFT JOIN cidade cid ON cid.codcidade = pes.cidade "
                    + " LEFT JOIN produto prod ON prod.codproduto = item.produto"
                    + " LEFT JOIN acabamento aca ON aca.codacabamento = item.acabamento"
                    + " WHERE orc.codOrcamento = " + codOrcamento.getText();

            Map tx = new HashMap();

            tx.put("TEXTOPADRAO", new TextoPadraoDAO().get(1).getTextoOrcamento());

            new VisualizaRelatorio().visRel("graficaatual/relatorios/arquivos/RelOrcamento.jasper", "Orçamento/Pedido", tx, sql);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar Orçamento! \n " + e);
        }
    }//GEN-LAST:event_btImprimirActionPerformed

    private void descontoMoedaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descontoMoedaFocusLost
        if (ValidarValor.getDouble(descontoMoeda.getText()) > 0.00) {
            descontoPorcentagem.setText("0,00");
        }
        calculaPreçoTotalOrcamentoComDesconto();


    }//GEN-LAST:event_descontoMoedaFocusLost

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        try {
            orcamento = orcamentoDAO.get(ValidarValor.getInt(codOrcamento.getText()));
            if (orcamento == null) {
                throw new Exception("Favor selecionar um orçamento válido.");
            } else {
                if (orcamento.getSituacao() == true) {
                    throw new Exception("Orçamento Aprovado não pode ser excluído.");
                } else {
                    setOrcamento();
                    orcamentoDAO.delete(orcamento);
                    limpaCampos();
                    JOptionPane.showMessageDialog(this, "Exclusão realizada com sucesso");
                    descCliente.requestFocus();
                }
            }

            atualizarTabelaOrcamento();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void descontoPorcentagemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descontoPorcentagemFocusLost
        if (ValidarValor.getDouble(descontoPorcentagem.getText()) > 0.00) {
            descontoMoeda.setText("0,00");
        }
        calculaPreçoTotalOrcamentoComDesconto();


    }//GEN-LAST:event_descontoPorcentagemFocusLost

    private void checkSituacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkSituacaoMouseClicked
        if (checkSituacao.isSelected()) {
            checkSituacao.setBackground(Color.green);
        } else {
            checkSituacao.setBackground(Color.red);
        }
    }//GEN-LAST:event_checkSituacaoMouseClicked

    private void conferirSituacao() {
        if (orcamento.getSituacao()) {
            checkSituacao.setBackground(Color.green);
            checkSituacao.setSelected(true);
            habilitacampos(false);
        } else {
            checkSituacao.setBackground(Color.red);
            checkSituacao.setSelected(false);
            habilitacampos(true);
        }
    }

    private void tabOrcamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabOrcamentoMouseClicked
        try {
            if (evt.getClickCount() > 1) {
                codOrcamento.setText(tabOrcamento.getValueAt(tabOrcamento.getSelectedRow(), 0).toString());
                orcamento = orcamentoDAO.get(ValidarValor.getInt(codOrcamento.getText()));
                carregaTudo();

                jTabbedPane1.setSelectedIndex(0);

                habilitaCamposProduto(true);

                codOrcamento.requestFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_tabOrcamentoMouseClicked

    private void tabPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPedidoMouseClicked
        try {
            if (evt.getClickCount() > 1) {
                codOrcamento.setText(tabPedido.getValueAt(tabPedido.getSelectedRow(), 0).toString());
                orcamento = orcamentoDAO.get(ValidarValor.getInt(codOrcamento.getText()));
                carregaTudo();

                jTabbedPane1.setSelectedIndex(0);

                habilitacampos(false);

                codOrcamento.requestFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tabPedidoMouseClicked

    private void btAprovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAprovarActionPerformed
        try {
            if (prazoEntrega.getText().length() > 2) {
                aprovarOrcamento();
                codOrcamentoFocusLost(null);
            } else {
                throw new Exception("Favor inserir um Data de Entrega Válida.");
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btAprovarActionPerformed

    private void dataOrcFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dataOrcFocusLost
        Date dataTeste = Data.getDateParse(dataOrc.getText(), Data.FORMAT_DATA_BR);

        Calendar cal = Calendar.getInstance();
        cal.setTime(dataTeste);
        cal.add(Calendar.DATE, 15);
        dataTeste = cal.getTime();
        validadeProposta.setText(Data.getDate(dataTeste));
    }//GEN-LAST:event_dataOrcFocusLost

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        instancia = null;
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void carregaOrcamento() throws Exception {
        orcamento = orcamentoDAO.get(ValidarValor.getInt(codOrcamento.getText()));
        if (orcamento != null) {

            codCliente.setText(orcamento.getCliente().getCodCliente().toString());
            descCliente.setText(orcamento.getCliente().getPessoa().getNome());
            checkSituacao.setSelected(orcamento.getSituacao());
            dataOrc.setText(Data.getDate(orcamento.getDataOrcamento()));
            validadeProposta.setText(Data.getDate(orcamento.getValidadeOrcamento()));
            prazoEntrega.setText(Data.getDate(orcamento.getPrazoEntrega()));
            limpaCamposProduto();
            tabItens.removeAll();
            clienteSecundario.setText(orcamento.getClienteSecundario());
            telefoneSecundario.setText(orcamento.getTelefoneSecundario());
            enderecoSecundario.setText(orcamento.getEnderecoSecundario());
            comboTipoEntrega.setSelectedIndex(orcamento.getTipoDeEntrega());
            comboFormaPag.setSelectedIndex((orcamento.getFormaPagamento().getCodForma() - 1));
            descontoMoeda.setText(ValidarValor.getDouble(orcamento.getDescontoGeral()));
            descontoPorcentagem.setText(ValidarValor.getDouble(orcamento.getDescontoGeralPorcentagem()));
            totalGlobal = orcamento.getValorTotal();
            totalGeralOrc.setText(orcamento.getValorTotal().toString());
            listaItem = itemOrcaDAO.getListOrcamento(orcamento.getCodOrcamento());

        } else {
            limpaCamposProduto();
            limpaCampos();
        }
    }

    private void carregaTudo() throws Exception {
        orcamento = orcamentoDAO.get(ValidarValor.getInt(codOrcamento.getText()));
        if (orcamento != null) {
            carregaOrcamento();
            carregaCliente();
            carregaProduto();

            atualizaTabelaProdutoBusca();
            calculaPreçoTotalOrcamentoComDesconto();

            conferirSituacao();
        } else {
            throw new Exception("Favor inserir um Orçamento Válido.");
        }

    }

    private void carregaCliente() throws Exception {
        cliente = clientedao.get(ValidarValor.getLong(codCliente.getText()));
        if (cliente != null) {
            descCliente.setText(cliente.getPessoa().getNome());
        } else {
            descCliente.setText("");
        }
    }

    private void carregaProduto() throws Exception {
        produto = produtoDAO.getPorCodigo(ValidarValor.getLong(codProduto.getText()));
        if (produto != null) {
            descProduto.setText(produto.getDescricao());
            valorUnitario.setText(ValidarValor.getDouble(produto.getValorUnitario()));
        } else {
            limpaCamposProduto();
        }
    }

    private void carregaTabProd() throws Exception {
        produto = produtoDAO.getPorCodigo(ValidarValor.getLong(codProduto.getText()));
        if (produto != null) {
            descProduto.setText(produto.getDescricao());
            valorUnitario.setText(ValidarValor.getDouble(produto.getValorUnitario()));
            quantidadeProduto.setText(itemOrcamento.getQuantProd().toString());
            valortotalProduto.setText(ValidarValor.getDouble(itemOrcamento.getValorTotalProduto()));
            medidaProduto.setText(itemOrcamento.getMedida());
            unidadeProduto.setText(itemOrcamento.getUnidade());
            itemOrcamento.setAcabamento(acabamentoDao.getByDescricao(comboAcabamento.getSelectedItem().toString()));
        }
    }

    private void limpaCamposProduto() {
        codProduto.setText("");
        descProduto.setText("");
        valorUnitario.setText("");
        quantidadeProduto.setText("");
        valortotalProduto.setText("");
        medidaProduto.setText("");
        unidadeProduto.setText("");
        comboAcabamento.setSelectedIndex(0);
        checkCriacao.setSelected(false);
        checkSerralheria.setSelected(false);
        checkProjeto.setSelected(false);
        checkPintura.setSelected(false);
        checkPlotagem.setSelected(false);
        checkCaixariaAcabamento.setSelected(false);
        checkImpDigital.setSelected(false);
        checkCorteRouter.setSelected(false);
        checkAcabImpressao.setSelected(false);
        checkPloterRecorte.setSelected(false);

    }

    private void limpaCampos() {
        codOrcamento.setText("");
        codCliente.setText("");
        descCliente.setText("");
        checkSituacao.setSelected(false);
        dataOrc.setText("");
        validadeProposta.setText("");
        prazoEntrega.setText("");
        limpaCamposProduto();
        limpaTabelaProdutoBusca();
        clienteSecundario.setText("");
        telefoneSecundario.setText("");
        enderecoSecundario.setText("");
        comboTipoEntrega.setSelectedIndex(0);
        comboFormaPag.setSelectedIndex(0);
        descontoMoeda.setText("");
        descontoPorcentagem.setText("");
        totalGeralOrc.setText("");
        desmarcarChecksSetores();

        atualizarTabelaOrcamento();
        atualizarTabelaPedido();

    }

    private void desmarcarChecksSetores() {
        checkCriacao.setSelected(false);
        checkSerralheria.setSelected(false);
        checkProjeto.setSelected(false);
        checkPintura.setSelected(false);
        checkPlotagem.setSelected(false);
        checkCaixariaAcabamento.setSelected(false);
        checkImpDigital.setSelected(false);
        checkCorteRouter.setSelected(false);
        checkAcabImpressao.setSelected(false);
        checkPloterRecorte.setSelected(false);

    }

    private void adicionarComboFormaPagamento() {
        comboFormaPag.removeAllItems();
        listaFormaPagamento = formaPagamentoDao.getList();
        for (FormaDePagamento x : listaFormaPagamento) {
            comboFormaPag.addItem(x.getDescricao());
        }
    }

    private void adicionarComboAcabamento() {
        comboAcabamento.removeAllItems();
        listaAcabamento = acabamentoDao.getList();
        for (Acabamento x : listaAcabamento) {
            comboAcabamento.addItem(x.getDescricao());
        }
    }

    private void habilitaCamposProduto(boolean b) {
        codProduto.setEnabled(b);
        descProduto.setEnabled(b);
        valorUnitario.setEnabled(b);
        quantidadeProduto.setEnabled(b);
        valortotalProduto.setEnabled(b);
        medidaProduto.setEnabled(b);
        unidadeProduto.setEnabled(b);
        comboAcabamento.setEnabled(b);
        checkCriacao.setEnabled(b);
        checkSerralheria.setEnabled(b);
        checkProjeto.setEnabled(b);
        checkPintura.setEnabled(b);
        checkPlotagem.setEnabled(b);
        checkCaixariaAcabamento.setEnabled(b);
        checkImpDigital.setEnabled(b);
        checkCorteRouter.setEnabled(b);
        checkAcabImpressao.setEnabled(b);
        checkPloterRecorte.setEnabled(b);

    }

    private void habilitacampos(boolean b) {
        codOrcamento.setEnabled(b);
        codCliente.setEnabled(b);
        descCliente.setEnabled(b);
        checkSituacao.setEnabled(false);
        dataOrc.setEnabled(b);
        validadeProposta.setEnabled(b);
        prazoEntrega.setEnabled(b);
        habilitaCamposProduto(false);
        clienteSecundario.setEnabled(b);
        telefoneSecundario.setEnabled(b);
        enderecoSecundario.setEnabled(b);
        comboTipoEntrega.setEnabled(b);
        comboFormaPag.setEnabled(b);
        descontoMoeda.setEnabled(b);
        descontoPorcentagem.setEnabled(b);
        totalGeralOrc.setEnabled(b);
        btNovoItem.setEnabled(b);
        btAdicionarItem.setEnabled(b);
        btRemoverItem.setEnabled(b);
        btSalvarOrca.setEnabled(b);

    }

    private void setOrcamento() throws Exception {

        if (descCliente.getText().length() < 2) {
            throw new Exception("Favor inserir um Cliente.");
        }
        if (validadeProposta.getText().length() < 2) {
            throw new Exception("Favor inserir um Data de Validade válida.");
        }

        if (prazoEntrega.getText().length() < 2) {
            throw new Exception("Favor inserir um Prazo de Entrega válido.");
        }

        orcamento.setSituacao(false);
        orcamento.setCliente(cliente);
        orcamento.setDataOrcamento(Data.getDateSQL(dataOrc.getText()));
        orcamento.setValidadeOrcamento(Data.getDateSQL(validadeProposta.getText()));
        orcamento.setPrazoEntrega(Data.getDateSQL(prazoEntrega.getText()));
        orcamento.setProduto(produto);
        orcamento.setClienteSecundario(clienteSecundario.getText());
        orcamento.setTelefoneSecundario(telefoneSecundario.getText());
        orcamento.setEnderecoSecundario(enderecoSecundario.getText());
        orcamento.setTipoDeEntrega(comboTipoEntrega.getSelectedIndex());
        orcamento.setFormaPagamento(formaPagamentoDao.getByDescricao(comboFormaPag.getSelectedItem().toString()));
        orcamento.setDescontoGeral(ValidarValor.getDouble(descontoMoeda.getText()));
        orcamento.setDescontoGeralPorcentagem(ValidarValor.getDouble(descontoPorcentagem.getText()));
        orcamento.setValorTotal(ValidarValor.getDouble(totalGeralOrc.getText()));

    }

    private void atualizatabelaItens() {
        DefaultTableModel model = (DefaultTableModel) tabItens.getModel();
        removeLinhas(tabItens);
        if (listaItem.size() > 0) {
            for (ItemOrcamento p : listaItem) {
                Object o[] = new Object[]{
                    null,
                    p.getQuantProd(),
                    p.getProduto().getCodProduto() + "",
                    p.getProduto().getDescricao(),
                    p.getMedida(),
                    p.getUnidade(),
                    p.getAcabamento().getDescricao(),
                    p.getValorUnitario(),
                    p.getValorTotalProduto()};

                model.addRow(o);

            }
            tabItens.setModel(model);

        }

    }

    private void calculaPrecoTotalProduto() {
        try {

            if (quantidadeProduto.getText() != null && !"0".equals(quantidadeProduto.getText())) {

                valortotalProduto.setText(ValidarValor.getDouble((ValidarValor.getDouble(valorUnitario.getText()) * ValidarValor.getDouble(quantidadeProduto.getText()))));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void calculaPreçoTotalOrcamentoSemDesconto() {
        try {

            if (valortotalProduto.getText() != null && !"0".equals(valortotalProduto.getText())) {

                Double vlrProd = ValidarValor.getDouble(valortotalProduto.getText());
                Double descoMoeda = ValidarValor.getDouble(descontoMoeda.getText());
                Double descPorcentagem = ValidarValor.getDouble(descontoPorcentagem.getText());

                Double tot = (vlrProd - descoMoeda - descPorcentagem);

                totalGlobal = totalGlobal + tot;

                totalGeralOrc.setText(ValidarValor.getDouble(totalGlobal));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void calculaPreçoTotalOrcamentoComDesconto() {
        try {
            totalGlobal = 0.0;
            for (int i = 0; i < tabItens.getRowCount(); i++) {
                totalGlobal = totalGlobal + (Double) tabItens.getValueAt(i, 8);
            }

            if (totalGlobal != null) {

                Double x = totalGlobal;

                Double desco = ValidarValor.getDouble(descontoMoeda.getText());
                Double descoPorc = ValidarValor.getDouble(descontoPorcentagem.getText());

                x = x - desco;

                x = x - (x * (descoPorc / 100));

                totalGeralOrc.setText(ValidarValor.getDouble(x));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void atualizarTabelaOrcamento() {
        try {
            DefaultTableModel model = (DefaultTableModel) tabOrcamento.getModel();
            removeLinhas(tabOrcamento);

            List<Orcamento> listaAux = orcamentoDAO.getListOrcamento();
            if (listaAux.size() > 0) {
                model.setNumRows(0);
                for (Orcamento orca : listaAux) {
                    Object o[] = new Object[]{
                        orca.getCodOrcamento(),
                        orca.getCliente().getPessoa().getNome(),
                        orca.getValorTotal(),
                        orca.getSituacao()};

                    model.addRow(o);
                }
            }
            tabOrcamento.setModel(model);
        } catch (Exception e) {
            removeLinhas(tabOrcamento);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar lista de Orçamentos cadastrados. Erro: " + e);

        }
    }

    private void atualizarTabelaPedido() {
        try {
            DefaultTableModel model = (DefaultTableModel) tabPedido.getModel();
            removeLinhas(tabPedido);

            List<Orcamento> listaAux = orcamentoDAO.getListPedido();
            if (listaAux.size() > 0) {
                model.setNumRows(0);
                for (Orcamento orca : listaAux) {
                    Object o[] = new Object[]{
                        orca.getCodOrcamento(),
                        orca.getCliente().getPessoa().getNome(),
                        orca.getValorTotal(),
                        orca.getSituacao()};

                    model.addRow(o);
                }
            }
            tabPedido.setModel(model);
        } catch (Exception e) {
            removeLinhas(tabOrcamento);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar lista de Pedidos cadastrados. Erro: " + e);

        }
    }

    public static void removeLinhas(JTable table) {
        int n = table.getRowCount();

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (int i = n - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private void atualizaTabelaProdutoBusca() {
        try {
            listaItem = new ArrayList<ItemOrcamento>();
            listaItem = itemOrcaDAO.getListOrcamento(ValidarValor.getInt(codOrcamento.getText()));

            DefaultTableModel model = (DefaultTableModel) tabItens.getModel();
            removeLinhas(tabItens);
            for (int i = 0; i < listaItem.size(); i++) {

                Object[] os = new Object[9];
                os[0] = listaItem.get(i).getCodItemOrca();
                os[1] = listaItem.get(i).getQuantProd();
                os[2] = (listaItem.get(i).getProduto().getCodProduto() + "");
                os[3] = listaItem.get(i).getProduto().getDescricao();
                os[4] = listaItem.get(i).getMedida();
                os[5] = listaItem.get(i).getUnidade();
                os[6] = listaItem.get(i).getAcabamento().getDescricao();
                os[7] = listaItem.get(i).getValorUnitario();
                os[8] = listaItem.get(i).getValorTotalProduto();

                model.addRow(os);

            }

        } catch (Exception ex) {
            Logger.getLogger(FCadOrcamento.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }

    }

    private void limpaTabelaProdutoBusca() {
        try {

            DefaultTableModel model = (DefaultTableModel) tabItens.getModel();
            removeLinhas(tabItens);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarItem;
    private javax.swing.JButton btAprovar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton btNovoItem;
    private javax.swing.JButton btNovoOrca;
    private javax.swing.JButton btRemoverItem;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvarOrca;
    private javax.swing.JCheckBox checkAcabImpressao;
    private javax.swing.JCheckBox checkCaixariaAcabamento;
    private javax.swing.JCheckBox checkCorteRouter;
    private javax.swing.JCheckBox checkCriacao;
    private javax.swing.JCheckBox checkImpDigital;
    private javax.swing.JCheckBox checkPintura;
    private javax.swing.JCheckBox checkPlotagem;
    private javax.swing.JCheckBox checkPloterRecorte;
    private javax.swing.JCheckBox checkProjeto;
    private javax.swing.JCheckBox checkSerralheria;
    private javax.swing.JCheckBox checkSituacao;
    private javax.swing.JTextField clienteSecundario;
    private javax.swing.JTextField codCliente;
    private javax.swing.JTextField codOrcamento;
    private javax.swing.JTextField codProduto;
    private javax.swing.JComboBox<String> comboAcabamento;
    private javax.swing.JComboBox<String> comboFormaPag;
    private javax.swing.JComboBox<String> comboTipoEntrega;
    private javax.swing.JFormattedTextField dataOrc;
    private javax.swing.JTextField descCliente;
    private javax.swing.JTextField descProduto;
    private javax.swing.JTextField descontoMoeda;
    private javax.swing.JTextField descontoPorcentagem;
    private javax.swing.JTextField enderecoSecundario;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
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
    private javax.swing.JLabel labelAprovado;
    private javax.swing.JTextField medidaProduto;
    private javax.swing.JFormattedTextField prazoEntrega;
    private javax.swing.JTextField quantidadeProduto;
    private javax.swing.JTable tabItens;
    private javax.swing.JTable tabOrcamento;
    private javax.swing.JTable tabPedido;
    private javax.swing.JTextField telefoneSecundario;
    private javax.swing.JTextField totalGeralOrc;
    private javax.swing.JTextField unidadeProduto;
    private javax.swing.JFormattedTextField validadeProposta;
    private javax.swing.JTextField valorUnitario;
    private javax.swing.JTextField valortotalProduto;
    // End of variables declaration//GEN-END:variables

    private void aprovarOrcamento() throws Exception {
        if (orcamento != null && orcamento.getCodOrcamento() > 0) {

            if (!orcamento.getSituacao()) {
                EntityManager session = Persistencia.getInstance().getSessionComBegin();
                try {
                    orcamento.setSituacao(true);
                    orcamento = orcamentoDAO.salvar(session, orcamento);
                    //        System.out.println("fffffffffff " + listaItem.size());

                    //busca uma lista de materiais para cada item de orçamento, e gera uma saída aprovisionada para cada um.
                    for (ItemOrcamento it : listaItem) {

                        List<ComposicaoProduto> listaComposicao = composicaoDao.getListPorProduto(it.getProduto().getCodProduto());
                        for (ComposicaoProduto c : listaComposicao) {

                            SaidaEstoque saida = new SaidaEstoque();

                            saida.setCodSaidaEstoque(saidaDao.getNextItem());
                            saida.setTipoSaida(0);
                            saida.setNumeroPedido(orcamento.getCodOrcamento());
                            saida.setDataCadastro(Data.getDateSQL(orcamento.getDataCadastro()));
                            saida.setCodMaterial(c.getMaterial().getCodMaterial());
                            saida.setDescMaterial(c.getMaterial().getDescricao());
                            saida.setMetragemLinear(c.getMetragemLinear());
                            saida.setLargura(c.getLargura());
                            saida.setAltura(c.getAltura());
                            saida.setUnidade(c.getUnidade());
                            saida.setPeso(c.getPeso());
                            saida.setLitro(c.getLitro());
                            saida.setObservacao("Material aprovisionado por pedido sem aprovação.");
                            saida.setUsuarioCadastro(ControleAcesso.usuario.getCodUsuario() + " - " + ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                            saida.setUsuarioAtualizacao(ControleAcesso.usuario.getCodUsuario() + " - " + ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                            saida.setDataAtualizacao(Data.getDateSQL());
                            saida.setCancelada(false);
                            saida.setAprovisionada(true);

                            saidaDao.salvar(saida);

                        }
                    }

                    Boolean aux = new OrdemServicoDAO().gerarOrdemServico(listaItem, session);

                    if (aux == null || aux == false) {
                        throw new Exception(" Erro ao gerar Ordem(ns) de Serviço(s). ");
                    } else {
                        JOptionPane.showMessageDialog(this, "Orçamento Aprovado e Ordens de Serviços geradas. ");
                    }
                    session.getTransaction().commit();
                    session.close();
                } catch (Exception ex) {
                    session.getTransaction().rollback();
                    session.close();
                    JOptionPane.showMessageDialog(this, " Erro ao gerar Ordem(ns) de Serviço(s). " + ex.getMessage());
                }
            } else {
                throw new Exception(" Já é um pedido!");
            }
        } else {
            throw new Exception(" Por Favor, selecione um orçamento!");
        }
    }
}
