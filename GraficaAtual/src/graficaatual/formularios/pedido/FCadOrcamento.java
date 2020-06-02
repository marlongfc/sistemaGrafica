/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.pedido;

import graficaatual.daos.cadastro.AcabamentoDAO;
import graficaatual.daos.pedido.OrcamentoDAO;
import graficaatual.daos.cadastro.ClienteDAO;
import graficaatual.daos.cadastro.ProdutoDAO;
import graficaatual.daos.financeiro.FormaDePagamentoDAO;
import graficaatual.daos.pedido.ItemOrcamentoDAO;
import graficaatual.daos.relatorio.TextoPadraoDAO;
import graficaatual.entidades.Acabamento;
import graficaatual.entidades.Cliente;
import graficaatual.entidades.pedido.Orcamento;
import graficaatual.entidades.Produto;
import graficaatual.entidades.financeiro.FormaDePagamento;
import graficaatual.entidades.pedido.ItemOrcamento;
import graficaatual.utilitarios.Componentes;
import graficaatual.utilitarios.Data;
import graficaatual.utilitarios.Persistencia;
import graficaatual.utilitarios.ValidarValor;
import graficaatual.utilitarios.VisualizaRelatorio;
import java.awt.Color;
import java.text.ParseException;
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

    private Cliente cliente;
    private ClienteDAO clientedao = new ClienteDAO();

    private FormaDePagamento formaPagamento;
    private FormaDePagamentoDAO formaPagamentoDao = new FormaDePagamentoDAO();

    private Acabamento acabamento;
    private AcabamentoDAO acabamentoDao = new AcabamentoDAO();

    private Produto produto;
    private ProdutoDAO produtoDAO = new ProdutoDAO();

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
        jScrollPane11 = new javax.swing.JScrollPane();
        tabProdutos = new javax.swing.JTable();
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
        checkSituacao = new javax.swing.JCheckBox();
        labelAprovado = new javax.swing.JLabel();
        btSalvarOrca = new javax.swing.JButton();
        btNovoOrca = new javax.swing.JButton();
        btExcluirOrca = new javax.swing.JButton();
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
        jPanel3 = new javax.swing.JPanel();
        checkCaixariaAcabamento = new javax.swing.JCheckBox();
        checkPloterRecorte = new javax.swing.JCheckBox();
        checkProjeto = new javax.swing.JCheckBox();
        checkPlotagem = new javax.swing.JCheckBox();
        checkImpDigital = new javax.swing.JCheckBox();
        checkAcabImpressao = new javax.swing.JCheckBox();
        checkCriacao = new javax.swing.JCheckBox();
        checkSerralheria = new javax.swing.JCheckBox();
        checkEntrega = new javax.swing.JCheckBox();
        checkPintura = new javax.swing.JCheckBox();
        checkCorteRouter = new javax.swing.JCheckBox();
        checkFaturamento = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        comboFormaPag = new javax.swing.JComboBox<>();
        validadeProposta = new javax.swing.JFormattedTextField();
        prazoEntrega = new javax.swing.JFormattedTextField();
        jButton2 = new javax.swing.JButton();
        jLabel117 = new javax.swing.JLabel();
        descontoPorcentagem = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setPreferredSize(new java.awt.Dimension(1100, 700));

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

        tabProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Quantidade m²", "Produto", "Medida", "UN", "Acabamento", "Valor Unit.", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabProdutosMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tabProdutos);
        if (tabProdutos.getColumnModel().getColumnCount() > 0) {
            tabProdutos.getColumnModel().getColumn(0).setPreferredWidth(70);
            tabProdutos.getColumnModel().getColumn(1).setPreferredWidth(120);
            tabProdutos.getColumnModel().getColumn(2).setPreferredWidth(600);
            tabProdutos.getColumnModel().getColumn(3).setPreferredWidth(80);
            tabProdutos.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabProdutos.getColumnModel().getColumn(5).setPreferredWidth(150);
            tabProdutos.getColumnModel().getColumn(6).setPreferredWidth(100);
            tabProdutos.getColumnModel().getColumn(7).setPreferredWidth(100);
        }

        jPanel18.add(jScrollPane11);
        jScrollPane11.setBounds(40, 300, 910, 120);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ORÇAMENTO");
        jPanel18.add(jLabel1);
        jLabel1.setBounds(0, 0, 1330, 70);

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
        valortotalProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valortotalProdutoFocusLost(evt);
            }
        });
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

        jPanel18.add(jPanel1);
        jPanel1.setBounds(40, 175, 910, 120);

        checkSituacao.setBackground(new java.awt.Color(204, 0, 0));
        checkSituacao.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        checkSituacao.setForeground(new java.awt.Color(255, 255, 255));
        checkSituacao.setText("Aprovado");
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
        btSalvarOrca.setText("Salvar Orçamento");
        btSalvarOrca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarOrcaActionPerformed(evt);
            }
        });
        jPanel18.add(btSalvarOrca);
        btSalvarOrca.setBounds(241, 625, 180, 40);

        btNovoOrca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/NOVO2.png"))); // NOI18N
        btNovoOrca.setText("Novo Orçamento");
        btNovoOrca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoOrcaActionPerformed(evt);
            }
        });
        jPanel18.add(btNovoOrca);
        btNovoOrca.setBounds(60, 625, 180, 40);

        btExcluirOrca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excuir2.png"))); // NOI18N
        btExcluirOrca.setText("Excluir Orçamento");
        btExcluirOrca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirOrcaActionPerformed(evt);
            }
        });
        jPanel18.add(btExcluirOrca);
        btExcluirOrca.setBounds(422, 625, 180, 40);

        descontoMoeda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        descontoMoeda.setText("0,00");
        descontoMoeda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                descontoMoedaFocusLost(evt);
            }
        });
        jPanel18.add(descontoMoeda);
        descontoMoeda.setBounds(690, 490, 100, 20);

        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel89.setText("Desconto R$");
        jPanel18.add(jLabel89);
        jLabel89.setBounds(690, 470, 100, 20);

        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel104.setText("Formas de Pagamento");
        jPanel18.add(jLabel104);
        jLabel104.setBounds(690, 425, 150, 20);

        jLabel106.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel106.setText("Total Geral do Orçamento");
        jPanel18.add(jLabel106);
        jLabel106.setBounds(690, 510, 220, 20);
        jPanel18.add(totalGeralOrc);
        totalGeralOrc.setBounds(690, 530, 130, 20);

        try{
            dataOrc = new JFormattedTextField(new MaskFormatter("##/##/####"));
        }catch(Exception e){};
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
        jPanel2.setBounds(40, 425, 640, 130);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Etapas"));
        jPanel3.setLayout(null);

        checkCaixariaAcabamento.setBackground(new java.awt.Color(255, 255, 255));
        checkCaixariaAcabamento.setText("Caixaria Acabamento");
        jPanel3.add(checkCaixariaAcabamento);
        checkCaixariaAcabamento.setBounds(260, 40, 130, 23);

        checkPloterRecorte.setBackground(new java.awt.Color(255, 255, 255));
        checkPloterRecorte.setText("Ploter Recorte");
        jPanel3.add(checkPloterRecorte);
        checkPloterRecorte.setBounds(760, 20, 120, 23);

        checkProjeto.setBackground(new java.awt.Color(255, 255, 255));
        checkProjeto.setText("Projeto");
        jPanel3.add(checkProjeto);
        checkProjeto.setBounds(130, 20, 120, 23);

        checkPlotagem.setBackground(new java.awt.Color(255, 255, 255));
        checkPlotagem.setText("Plotagem");
        jPanel3.add(checkPlotagem);
        checkPlotagem.setBounds(260, 20, 130, 23);

        checkImpDigital.setBackground(new java.awt.Color(255, 255, 255));
        checkImpDigital.setText("Impressão Digital");
        jPanel3.add(checkImpDigital);
        checkImpDigital.setBounds(440, 20, 140, 23);

        checkAcabImpressao.setBackground(new java.awt.Color(255, 255, 255));
        checkAcabImpressao.setText("Acabamento Impressão");
        jPanel3.add(checkAcabImpressao);
        checkAcabImpressao.setBounds(590, 20, 170, 23);

        checkCriacao.setBackground(new java.awt.Color(255, 255, 255));
        checkCriacao.setText("Criação");
        jPanel3.add(checkCriacao);
        checkCriacao.setBounds(10, 20, 100, 23);

        checkSerralheria.setBackground(new java.awt.Color(255, 255, 255));
        checkSerralheria.setText("Serralheria");
        jPanel3.add(checkSerralheria);
        checkSerralheria.setBounds(10, 40, 100, 23);

        checkEntrega.setBackground(new java.awt.Color(255, 255, 255));
        checkEntrega.setText("Instalação Entrega");
        checkEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkEntregaActionPerformed(evt);
            }
        });
        jPanel3.add(checkEntrega);
        checkEntrega.setBounds(760, 40, 140, 23);

        checkPintura.setBackground(new java.awt.Color(255, 255, 255));
        checkPintura.setText("Pintura");
        jPanel3.add(checkPintura);
        checkPintura.setBounds(130, 40, 120, 23);

        checkCorteRouter.setBackground(new java.awt.Color(255, 255, 255));
        checkCorteRouter.setText("Corte Router");
        checkCorteRouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCorteRouterActionPerformed(evt);
            }
        });
        jPanel3.add(checkCorteRouter);
        checkCorteRouter.setBounds(440, 40, 140, 23);

        checkFaturamento.setBackground(new java.awt.Color(255, 255, 255));
        checkFaturamento.setText("Faturamento");
        jPanel3.add(checkFaturamento);
        checkFaturamento.setBounds(590, 40, 150, 23);

        jPanel18.add(jPanel3);
        jPanel3.setBounds(40, 555, 910, 70);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir2.png"))); // NOI18N
        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton1);
        jButton1.setBounds(603, 625, 180, 40);

        comboFormaPag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));
        jPanel18.add(comboFormaPag);
        comboFormaPag.setBounds(690, 445, 260, 20);

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

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAIR2.png"))); // NOI18N
        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton2);
        jButton2.setBounds(783, 625, 140, 40);

        jLabel117.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel117.setText("Desconto %");
        jPanel18.add(jLabel117);
        jLabel117.setBounds(800, 470, 100, 20);

        descontoPorcentagem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        descontoPorcentagem.setText("0,00");
        descontoPorcentagem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                descontoPorcentagemFocusLost(evt);
            }
        });
        jPanel18.add(descontoPorcentagem);
        descontoPorcentagem.setBounds(800, 490, 100, 20);

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1095, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Orçamentos Cadastrados", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1095, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
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

    private void btExcluirOrcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirOrcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btExcluirOrcaActionPerformed

    private void btNovoOrcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoOrcaActionPerformed
        try {
            orcamento = new Orcamento();
            limpaCampos();
            adicionarComboFormaPagamento();
            adicionarComboAcabamento();
            tabProdutos.removeAll();
            descCliente.requestFocus();

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
                setOrcamento();
                orcamento.setDataCadastro(new Date());
                orcamento.setDataAtualizacao(new Date());

                orcamento = orcamentoDAO.salvar(session, orcamento);

                if (orcamento != null) {
                    JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
                }

                DefaultTableModel model = (DefaultTableModel) tabProdutos.getModel();
                int i = 0;

                for (i = 0; i < model.getRowCount(); i++) {

                    itemOrcamento = new ItemOrcamento();

                    itemOrcamento.setProduto(produto);

                    itemOrcamento.setOrcamento(orcamento);

                    itemOrcaDAO.salvar(session, itemOrcamento);

                }

            }
            session.getTransaction().commit();
            session.close();
            setOrcamento();
            orcamentoDAO.salvar(orcamento);
            limpaCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }


    }//GEN-LAST:event_btSalvarOrcaActionPerformed

    private void btRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverItemActionPerformed
        try {
            if (tabProdutos.getRowCount() > 0) {
                if (tabProdutos.getSelectedRow() < 0) {
                    JOptionPane.showMessageDialog(null, "Selecione um produto para exclusão!");
                } else {
                    tabProdutos.remove(tabProdutos.getSelectedRow());
                    limpaCamposProduto();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }//GEN-LAST:event_btRemoverItemActionPerformed

    private void btAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarItemActionPerformed

        try {
            if (codProduto.getText().equals("") || descProduto.getText().equals("") || produto == null) {
                JOptionPane.showMessageDialog(this, "Favor Selecionar um Produto. ");
            }

            if (quantidadeProduto.getText().equals("0,00") || ValidarValor.getDouble(quantidadeProduto.getText()) <= 0) {
                JOptionPane.showMessageDialog(this, "Favor Informar a quantidade. ");
            }
            Double vl, vt;

            vl = Double.parseDouble(valorUnitario.getText().replaceAll(",", "."));
            vt = Double.parseDouble(valortotalProduto.getText().replaceAll(",", "."));

            DefaultTableModel model = (DefaultTableModel) tabProdutos.getModel();

            Object[] os = new Object[8];
            os[0] = codProduto.getText();
            os[1] = quantidadeProduto.getText();
            os[2] = descProduto.getText();
            os[3] = medidaProduto.getText();
            os[4] = unidadeProduto.getText();
            os[5] = comboAcabamento.getSelectedItem().toString();
            os[6] = vl;
            os[7] = vt;

            model.addRow(os);

            calculaPreçoTotalOrcamentoSemDesconto();

        } catch (Exception e) {
            e.printStackTrace();
        }

        /*try {
            produto = produtoDAO.getPorCodigo(ValidarValor.getLong(codProduto.getText()));
            if (produto == null) {
                JOptionPane.showMessageDialog(this, "Favor Inserir um Produto.");
            } else {
                if (listaProduto != null) {
                    listaProduto.add(produto);
                    listaQtdProd.add(ValidarValor.getInt(quantidadeProduto.getText()));
                    listaDescontoProd.add(ValidarValor.getDouble(descontoProduto.getText()));
                }
            }
            atualizatabelaProdutos();

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }//GEN-LAST:event_btAdicionarItemActionPerformed

    private void btNovoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoItemActionPerformed
        try {
            produto = new Produto();
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

    private void tabProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabProdutosMouseClicked
        try {
            if (evt.getClickCount() > 1) {
                codProduto.setText(tabProdutos.getValueAt(tabProdutos.getSelectedRow(), 0).toString());
                produto = produtoDAO.getPorCodigo(ValidarValor.getInt(codProduto.getText()));
                carregaTabProd();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tabProdutosMouseClicked

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

    private void checkEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkEntregaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkEntregaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            String sql = "SELECT cli.codcliente, pes.nome, pes.cnpj, pes.inscestadual, log.descricao logradouro, bai.descricao bairro,"
                    + " cid.descricao cidade, pes.numcasa, pes.uf,pes.cep, orc.clientesecundario, pes.email,pes.telefone, "
                    + " orc.codorcamento,orc.quantprod,prod.codproduto codProduto, prod.descricao produto,orc.medida, orc.unidade, "
                    + " aca.descricao acabamento,prod.valorunitario, orc.valortotal, "
                    + " orc.dataorcamento, orc.validadeorcamento, orc.prazoentrega, orc.formapagamento, orc.clientesecundario, "
                    + " orc.enderecosecundario, orc.telefonesecundario, orc.tipodeentrega "
                    + " FROM orcamento orc "
                    + " INNER JOIN cliente cli ON cli.codcliente = orc.cliente "
                    + " INNER JOIN pessoa pes ON pes.codPessoa = cli.pessoa "
                    + " INNER JOIN logradouro log ON log.codlogradouro = pes.logradouro "
                    + " INNER JOIN bairro bai ON bai.codbairro = pes.bairro "
                    + " INNER JOIN cidade cid ON cid.codcidade = pes.cidade "
                    + " INNER JOIN produto prod ON prod.codproduto = orc.produto"
                    + " INNER JOIN acabamento aca ON aca.codacabamento = orc.acabamento"
                    + " WHERE orc.codOrcamento = " + codOrcamento.getText();

            Map tx = new HashMap();

            tx.put("TEXTOPADRAO", new TextoPadraoDAO().get(1).getTextoOrcamento());

            new VisualizaRelatorio().visRel("graficaatual/relatorios/arquivos/RelOrcamento.jasper", "Orçamento", null, sql);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório de produtos! \n " + e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void checkCorteRouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCorteRouterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkCorteRouterActionPerformed

    private void valortotalProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valortotalProdutoFocusLost

    }//GEN-LAST:event_valortotalProdutoFocusLost

    private void descontoMoedaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descontoMoedaFocusLost
        if (ValidarValor.getDouble(descontoMoeda.getText()) > 0.00) {
            descontoPorcentagem.setText("0,00");
        }
        calculaPreçoTotalOrcamentoComDesconto();


    }//GEN-LAST:event_descontoMoedaFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            tabProdutos.removeAll();
            clienteSecundario.setText(orcamento.getClienteSecundario());
            telefoneSecundario.setText(orcamento.getTelefoneSecundario());
            enderecoSecundario.setText(orcamento.getEnderecoSecundario());
            comboTipoEntrega.setSelectedIndex(orcamento.getTipoDeEntrega());
            comboFormaPag.setSelectedIndex(orcamento.getFormaPagamento().getCodForma());
            descontoMoeda.setText(orcamento.getDescontoGeral().toString());
            descontoPorcentagem.setText(orcamento.getDescontoGeralPorcentagem().toString());
            totalGeralOrc.setText(orcamento.getValorTotal().toString());
            desmarcarChecksSetores();
        } else {
            limpaCamposProduto();
        }
    }

    private void carregaTudo() throws Exception {
        carregaOrcamento();
        carregaCliente();
        carregaProduto();
        carregaComboFormaPagamento();
        carregaComboAcabamento();
    }

    private void carregaComboFormaPagamento() {
        try {
            formaPagamento = orcamento.getFormaPagamento();
            listaFormaPagamento = formaPagamentoDao.getList();

            comboFormaPag.removeAllItems();

            int x = 0;

            for (int i = 0; i < listaFormaPagamento.size(); i++) {
                comboFormaPag.addItem(listaFormaPagamento.get(i).getDescricao());
                if (formaPagamento.getDescricao().equals(listaFormaPagamento.get(i).getDescricao())) {
                    x = i;
                }
            }
            comboFormaPag.setSelectedIndex(x);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void carregaComboAcabamento() {
        try {
            acabamento = orcamento.getAcabamento();
            listaAcabamento = acabamentoDao.getList();

            comboAcabamento.removeAllItems();

            int x = 0;

            for (int i = 0; i < listaAcabamento.size(); i++) {
                comboAcabamento.addItem(listaAcabamento.get(i).getDescricao());
                if (acabamento.getDescricao().equals(listaAcabamento.get(i).getDescricao())) {
                    x = i;
                }
            }
            comboAcabamento.setSelectedIndex(x);
        } catch (Exception e) {
            e.printStackTrace();
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
            quantidadeProduto.setText(orcamento.getQuantProd().toString());
            valortotalProduto.setText(ValidarValor.getDouble(orcamento.getValorTotal()));
            medidaProduto.setText(orcamento.getMedida());
            unidadeProduto.setText(orcamento.getUnidade());
            orcamento.setAcabamento(acabamentoDao.getByDescricao(comboAcabamento.getSelectedItem().toString()));

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
        tabProdutos.removeAll();
        clienteSecundario.setText("");
        telefoneSecundario.setText("");
        enderecoSecundario.setText("");
        comboTipoEntrega.setSelectedIndex(0);
        comboFormaPag.setSelectedIndex(0);
        descontoMoeda.setText("");
        descontoPorcentagem.setText("");
        totalGeralOrc.setText("");
        desmarcarChecksSetores();

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
        checkFaturamento.setSelected(false);
        checkPloterRecorte.setSelected(false);
        checkEntrega.setSelected(false);

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
    }

    private void setOrcamento() throws Exception {

        if (descCliente.getText().length() < 2) {
            throw new Exception("Favor inserir um Cliente");
        }
        if (validadeProposta.getText() == null) {
            throw new Exception("Favor inserir um Data de Validade válida");
        }

        orcamento.setSituacao(checkSituacao.isSelected());
        orcamento.setCliente(cliente);
        orcamento.setDataOrcamento(Data.getDateSQL(dataOrc.getText()));
        orcamento.setValidadeOrcamento(Data.getDateSQL(validadeProposta.getText()));
        orcamento.setPrazoEntrega(Data.getDateSQL(prazoEntrega.getText()));
        orcamento.setProduto(produto);
        orcamento.setQuantProd(ValidarValor.getInt(quantidadeProduto.getText()));
        orcamento.setValorTotalProduto(ValidarValor.getDouble(valortotalProduto.getText()));
        orcamento.setMedida(medidaProduto.getText());
        orcamento.setUnidade(unidadeProduto.getText());
        orcamento.setAcabamento(acabamentoDao.getByDescricao(comboAcabamento.getSelectedItem().toString()));
        orcamento.setClienteSecundario(clienteSecundario.getText());
        orcamento.setTelefoneSecundario(telefoneSecundario.getText());
        orcamento.setEnderecoSecundario(enderecoSecundario.getText());
        orcamento.setTipoDeEntrega(comboTipoEntrega.getSelectedIndex());
        orcamento.setFormaPagamento(formaPagamentoDao.getByDescricao(comboFormaPag.getSelectedItem().toString()));
        orcamento.setDescontoGeral(ValidarValor.getDouble(descontoMoeda.getText()));
        orcamento.setDescontoGeralPorcentagem(ValidarValor.getDouble(descontoPorcentagem.getText()));
        orcamento.setValorTotal(ValidarValor.getDouble(totalGeralOrc.getText()));
        orcamento.setCheckCriacao(checkCriacao.isSelected());
        orcamento.setCheckSerralheria(checkSerralheria.isSelected());
        orcamento.setCheckProjeto(checkProjeto.isSelected());
        orcamento.setCheckPintura(checkPintura.isSelected());
        orcamento.setCheckPlotagem(checkPlotagem.isSelected());
        orcamento.setCheckCaixariaAcabamento(checkCaixariaAcabamento.isSelected());
        orcamento.setCheckImpressaoDigital(checkImpDigital.isSelected());
        orcamento.setCheckRouter(checkCorteRouter.isSelected());
        orcamento.setCheckAcabamentoImp(checkAcabImpressao.isSelected());
        orcamento.setCheckFaturamento(checkFaturamento.isSelected());
        orcamento.setCheckPloterRecorte(checkPloterRecorte.isSelected());
        orcamento.setCheckEntrega(checkEntrega.isSelected());

    }

    private void atualizatabelaProdutos() {
        DefaultTableModel model = (DefaultTableModel) tabProdutos.getModel();
        if (listaProduto.size() > 0) {
            model.setNumRows(0);
            int i = 0;
            for (Produto p : listaProduto) {
                Object o[] = new Object[]{
                    p.getCodProduto(),
                    p.getDescricao(),
                    p.getValorUnitario(),
                    listaQtdProd.get(i),
                    listaDescontoProd.get(i),
                    ((p.getValorUnitario() * listaQtdProd.get(i)) - listaDescontoProd.get(i))};

                model.addRow(o);

                i++;
            }
        }

        tabProdutos.setModel(model);
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

            if (valortotalProduto.getText() != null) {

                System.out.println("TOTALLLL --- " + totalGlobal);

                Double x = totalGlobal;

                Double desco = ValidarValor.getDouble(descontoMoeda.getText());
                Double descoPorc = ValidarValor.getDouble(descontoPorcentagem.getText());

                System.out.println("desconto 1 --- " + desco);
                System.out.println("x1  --- " + x);

                x = x - desco;

                x = x - (x * (descoPorc / 100));

                System.out.println("desconto 2 --- " + desco);
                System.out.println("x2  --- " + x);

                totalGeralOrc.setText(ValidarValor.getDouble(x));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarItem;
    private javax.swing.JButton btExcluirOrca;
    private javax.swing.JButton btNovoItem;
    private javax.swing.JButton btNovoOrca;
    private javax.swing.JButton btRemoverItem;
    private javax.swing.JButton btSalvarOrca;
    private javax.swing.JCheckBox checkAcabImpressao;
    private javax.swing.JCheckBox checkCaixariaAcabamento;
    private javax.swing.JCheckBox checkCorteRouter;
    private javax.swing.JCheckBox checkCriacao;
    private javax.swing.JCheckBox checkEntrega;
    private javax.swing.JCheckBox checkFaturamento;
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JScrollPane jScrollPane11;
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
    private javax.swing.JTable tabProdutos;
    private javax.swing.JTextField telefoneSecundario;
    private javax.swing.JTextField totalGeralOrc;
    private javax.swing.JTextField unidadeProduto;
    private javax.swing.JFormattedTextField validadeProposta;
    private javax.swing.JTextField valorUnitario;
    private javax.swing.JTextField valortotalProduto;
    // End of variables declaration//GEN-END:variables
}
