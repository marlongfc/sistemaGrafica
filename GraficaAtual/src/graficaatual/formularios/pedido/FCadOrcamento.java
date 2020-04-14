/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.pedido;

import graficaatual.daos.pedido.OrcamentoDAO;
import graficaatual.daos.cadastro.ClienteDAO;
import graficaatual.daos.cadastro.ProdutoDAO;
import graficaatual.entidades.Cliente;
import graficaatual.entidades.pedido.Orcamento;
import graficaatual.entidades.Produto;
import graficaatual.entidades.itemDoOrcamento;
import graficaatual.utilitarios.Componentes;
import graficaatual.utilitarios.Persistencia;
import graficaatual.utilitarios.ValidarValor;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Moises
 */
public class FCadOrcamento extends javax.swing.JInternalFrame {

    private Orcamento orcamento;
    private OrcamentoDAO orcamentoDAO = new OrcamentoDAO();

    private Cliente cliente;
    private ClienteDAO clientedao = new ClienteDAO();

    private Produto produto;
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    
   // private itemDoOrcamento  

    private List<Cliente> listaCliente = null;
    private List<Produto> listaProduto = null;

    private List<Integer> listaQtdProd = null;
    private List<Double> listaDescontoProd = null;
    
    

    public FCadOrcamento() {
        initComponents();

        listaCliente = ObservableCollections.observableList(new LinkedList<Cliente>());
        Componentes comp1 = new Componentes(listaCliente, false, validadeProposta, descCliente, jPanel18, jPanel1, descCliente.getWidth(), 100);
        comp1.addCol(0, "codCliente", "Código", 50, Long.class.getName());
        comp1.addCol(1, "pessoa.nome", "Nome", 200, String.class.getName());
        comp1.bind();

        listaProduto = ObservableCollections.observableList(new LinkedList<Produto>());
        Componentes comp2 = new Componentes(listaProduto, false, codProduto, descProduto, jPanel18, jPanel1, descProduto.getWidth(), 100);
        comp2.addCol(0, "codProduto", "Código", 50, Long.class.getName());
        comp2.addCol(1, "descricao", "Produto", 200, String.class.getName());
        comp2.bind();
        
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

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
        validadeProposta = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        descProduto = new javax.swing.JTextField();
        codProduto = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        valorUnitario = new javax.swing.JTextField();
        quantidadeProduto = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        descontoProduto = new javax.swing.JTextField();
        btNovoItem = new javax.swing.JButton();
        btAdicionarItem = new javax.swing.JButton();
        btRemoverItem = new javax.swing.JButton();
        jLabel88 = new javax.swing.JLabel();
        valortotalProduto = new javax.swing.JTextField();
        checkAprovado = new javax.swing.JCheckBox();
        labelAprovado = new javax.swing.JLabel();
        btSalvarOrca = new javax.swing.JButton();
        btNovoOrca = new javax.swing.JButton();
        btExcluirOrca = new javax.swing.JButton();
        valorTotal1 = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        valorTotal2 = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        valorTotal3 = new javax.swing.JTextField();
        dataOrc = new javax.swing.JFormattedTextField();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        codCliente1 = new javax.swing.JTextField();
        prazoEntrega = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        valorUnitario1 = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        valorUnitario2 = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        valorUnitario3 = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox<>();
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
        jLabel78.setBounds(140, 90, 130, 20);

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
            tabProdutos.getColumnModel().getColumn(1).setPreferredWidth(80);
            tabProdutos.getColumnModel().getColumn(2).setPreferredWidth(700);
            tabProdutos.getColumnModel().getColumn(3).setPreferredWidth(80);
            tabProdutos.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabProdutos.getColumnModel().getColumn(5).setPreferredWidth(150);
            tabProdutos.getColumnModel().getColumn(6).setPreferredWidth(80);
            tabProdutos.getColumnModel().getColumn(7).setPreferredWidth(80);
        }

        jPanel18.add(jScrollPane11);
        jScrollPane11.setBounds(40, 300, 910, 120);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ORÇAMENTO");
        jPanel18.add(jLabel1);
        jLabel1.setBounds(0, 0, 1330, 70);

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
        jLabel82.setBounds(180, 130, 140, 20);

        validadeProposta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                validadePropostaFocusLost(evt);
            }
        });
        jPanel18.add(validadeProposta);
        validadeProposta.setBounds(180, 150, 100, 20);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11))); // NOI18N
        jPanel1.setLayout(null);

        descProduto.setBackground(new java.awt.Color(255, 255, 204));
        descProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descProdutoKeyReleased(evt);
            }
        });
        jPanel1.add(descProduto);
        descProduto.setBounds(90, 40, 790, 20);

        codProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codProdutoFocusLost(evt);
            }
        });
        jPanel1.add(codProduto);
        codProduto.setBounds(10, 40, 80, 20);

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
        jLabel85.setBounds(10, 70, 80, 20);

        valorUnitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorUnitarioFocusLost(evt);
            }
        });
        jPanel1.add(valorUnitario);
        valorUnitario.setBounds(10, 90, 100, 20);

        quantidadeProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                quantidadeProdutoFocusLost(evt);
            }
        });
        jPanel1.add(quantidadeProduto);
        quantidadeProduto.setBounds(120, 90, 100, 20);

        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel86.setText("Quantidade");
        jPanel1.add(jLabel86);
        jLabel86.setBounds(120, 70, 80, 20);

        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel87.setText("Desconto");
        jPanel1.add(jLabel87);
        jLabel87.setBounds(230, 70, 80, 20);

        descontoProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                descontoProdutoFocusLost(evt);
            }
        });
        jPanel1.add(descontoProduto);
        descontoProduto.setBounds(230, 90, 100, 20);

        btNovoItem.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        btNovoItem.setText("Novo Produto");
        btNovoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoItemActionPerformed(evt);
            }
        });
        jPanel1.add(btNovoItem);
        btNovoItem.setBounds(450, 70, 130, 40);

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
        jLabel88.setBounds(340, 70, 120, 20);

        valortotalProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valortotalProdutoFocusLost(evt);
            }
        });
        jPanel1.add(valortotalProduto);
        valortotalProduto.setBounds(340, 90, 100, 20);

        jPanel18.add(jPanel1);
        jPanel1.setBounds(40, 175, 910, 120);

        checkAprovado.setBackground(new java.awt.Color(204, 0, 0));
        checkAprovado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        checkAprovado.setForeground(new java.awt.Color(255, 255, 255));
        checkAprovado.setText("Aprovado");
        jPanel18.add(checkAprovado);
        checkAprovado.setBounds(840, 70, 100, 23);

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
        btSalvarOrca.setBounds(310, 625, 180, 40);

        btNovoOrca.setText("Novo Orçamento");
        btNovoOrca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoOrcaActionPerformed(evt);
            }
        });
        jPanel18.add(btNovoOrca);
        btNovoOrca.setBounds(130, 625, 180, 40);

        btExcluirOrca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excuir2.png"))); // NOI18N
        btExcluirOrca.setText("Excluir Orçamento");
        btExcluirOrca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirOrcaActionPerformed(evt);
            }
        });
        jPanel18.add(btExcluirOrca);
        btExcluirOrca.setBounds(490, 625, 180, 40);

        valorTotal1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorTotal1FocusLost(evt);
            }
        });
        jPanel18.add(valorTotal1);
        valorTotal1.setBounds(690, 490, 100, 20);

        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel89.setText("Desconto Geral");
        jPanel18.add(jLabel89);
        jLabel89.setBounds(690, 470, 100, 20);

        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel104.setText("Formas de Pagamento");
        jPanel18.add(jLabel104);
        jLabel104.setBounds(690, 425, 150, 20);

        jLabel105.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel105.setText("Acréscimo Geral");
        jPanel18.add(jLabel105);
        jLabel105.setBounds(800, 470, 100, 20);

        valorTotal2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorTotal2FocusLost(evt);
            }
        });
        jPanel18.add(valorTotal2);
        valorTotal2.setBounds(800, 490, 100, 20);

        jLabel106.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel106.setText("Total Geral do Orçamento");
        jPanel18.add(jLabel106);
        jLabel106.setBounds(690, 510, 140, 20);

        valorTotal3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorTotal3FocusLost(evt);
            }
        });
        jPanel18.add(valorTotal3);
        valorTotal3.setBounds(690, 530, 130, 20);
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

        codCliente1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codCliente1FocusLost(evt);
            }
        });
        jPanel18.add(codCliente1);
        codCliente1.setBounds(40, 110, 80, 20);

        prazoEntrega.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                prazoEntregaFocusLost(evt);
            }
        });
        jPanel18.add(prazoEntrega);
        prazoEntrega.setBounds(300, 150, 100, 20);

        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel110.setText("Prazo de Entrega");
        jPanel18.add(jLabel110);
        jLabel110.setBounds(300, 130, 140, 20);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Forma de Entrega", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11))); // NOI18N
        jPanel2.setLayout(null);

        jLabel111.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel111.setText("Cliente");
        jPanel2.add(jLabel111);
        jLabel111.setBounds(10, 15, 80, 20);

        valorUnitario1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorUnitario1FocusLost(evt);
            }
        });
        jPanel2.add(valorUnitario1);
        valorUnitario1.setBounds(10, 35, 420, 20);

        jLabel112.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel112.setText("Telefone");
        jPanel2.add(jLabel112);
        jLabel112.setBounds(430, 15, 70, 20);

        valorUnitario2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorUnitario2FocusLost(evt);
            }
        });
        jPanel2.add(valorUnitario2);
        valorUnitario2.setBounds(430, 35, 200, 20);

        jLabel113.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel113.setText("Endereço");
        jPanel2.add(jLabel113);
        jLabel113.setBounds(10, 55, 150, 20);

        valorUnitario3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorUnitario3FocusLost(evt);
            }
        });
        jPanel2.add(valorUnitario3);
        valorUnitario3.setBounds(10, 75, 420, 20);

        jLabel114.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel114.setText("Tipo de Entrega");
        jPanel2.add(jLabel114);
        jLabel114.setBounds(430, 55, 90, 20);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Interna", "Externa" }));
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(430, 75, 200, 20);

        jPanel18.add(jPanel2);
        jPanel2.setBounds(40, 425, 640, 130);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Etapas"));
        jPanel3.setLayout(null);

        jCheckBox1.setText("Caixaria Acabamento");
        jPanel3.add(jCheckBox1);
        jCheckBox1.setBounds(270, 40, 130, 23);

        jCheckBox6.setText("Ploter Recorte");
        jPanel3.add(jCheckBox6);
        jCheckBox6.setBounds(780, 20, 100, 23);

        jCheckBox7.setText("Projeto");
        jPanel3.add(jCheckBox7);
        jCheckBox7.setBounds(140, 20, 61, 23);

        jCheckBox8.setText("Plotagem");
        jPanel3.add(jCheckBox8);
        jCheckBox8.setBounds(270, 20, 81, 23);

        jCheckBox9.setText("Impressão Digital");
        jPanel3.add(jCheckBox9);
        jCheckBox9.setBounds(450, 20, 140, 23);

        jCheckBox10.setText("Acabamento Impressão");
        jPanel3.add(jCheckBox10);
        jCheckBox10.setBounds(600, 20, 150, 23);

        jCheckBox2.setText("Criação");
        jPanel3.add(jCheckBox2);
        jCheckBox2.setBounds(10, 20, 61, 23);

        jCheckBox3.setText("Serralheria");
        jPanel3.add(jCheckBox3);
        jCheckBox3.setBounds(10, 40, 80, 23);

        jCheckBox4.setText("Instalação Entrega");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        jPanel3.add(jCheckBox4);
        jCheckBox4.setBounds(780, 40, 120, 23);

        jCheckBox5.setText("Pintura");
        jPanel3.add(jCheckBox5);
        jCheckBox5.setBounds(140, 40, 70, 23);

        jCheckBox11.setText("Corte Router");
        jPanel3.add(jCheckBox11);
        jCheckBox11.setBounds(450, 40, 100, 23);

        jCheckBox12.setText("Faturamento");
        jPanel3.add(jCheckBox12);
        jCheckBox12.setBounds(600, 40, 100, 23);

        jPanel18.add(jPanel3);
        jPanel3.setBounds(40, 555, 910, 70);

        jButton1.setText("Sair");
        jPanel18.add(jButton1);
        jButton1.setBounds(670, 625, 180, 40);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel18.add(jComboBox4);
        jComboBox4.setBounds(690, 445, 260, 20);

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

    private void valorTotal3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorTotal3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_valorTotal3FocusLost

    private void valorTotal2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorTotal2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_valorTotal2FocusLost

    private void valorTotal1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorTotal1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_valorTotal1FocusLost

    private void btExcluirOrcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirOrcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btExcluirOrcaActionPerformed

    private void btNovoOrcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoOrcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btNovoOrcaActionPerformed

    private void btSalvarOrcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarOrcaActionPerformed
        try{
            EntityManager session = Persistencia.getInstance().getSessionComBegin();
            if(orcamento != null){
                if (listaProduto != null || listaProduto.isEmpty()){
                    orcamento = orcamentoDAO.get(ValidarValor.getInt((codOrcamento.getText())));
                    if(orcamento == null){
                        orcamento = new Orcamento();

                        setOrcamento(); //verificar
                        orcamento = orcamentoDAO.salvar(session, orcamento);

                        for (int i = 0; i < listaProduto.size(); i++) {
                            //setListas();
                        }
                    }

                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btSalvarOrcaActionPerformed

    private void valortotalProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valortotalProdutoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_valortotalProdutoFocusLost

    private void btRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverItemActionPerformed
        try {
            produto = produtoDAO.getPorCodigo(ValidarValor.getLong(codProduto.getText()));

            if (produto == null) {
                JOptionPane.showMessageDialog(this, "Favor Selecionar um Produto. ");
            } else {
                if (listaProduto != null || listaProduto.isEmpty()) {
                    int i = listaProduto.indexOf(produto);
                    listaQtdProd.remove(i);
                    listaDescontoProd.remove(i);
                    listaProduto.remove(produto);
                }
            }
            atualizatabelaProdutos();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btRemoverItemActionPerformed

    private void btAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarItemActionPerformed
        try {
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
        }
    }//GEN-LAST:event_btAdicionarItemActionPerformed

    private void btNovoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoItemActionPerformed
        try {
            produto = new Produto();
            limpaCamposProduto();
            habilitaCampos(true);
            descProduto.requestFocus();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btNovoItemActionPerformed

    private void descontoProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descontoProdutoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_descontoProdutoFocusLost

    private void quantidadeProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantidadeProdutoFocusLost
        // TODO add your handling code here:
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
            List<Produto> merged = produtoDAO.getList(15, "select e from Produto e where e.descricao order by e.codigo", descProduto.getText().trim().toLowerCase());
            listaProduto.clear();
            listaProduto.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Produto. Erro: " + e);
        }
    }//GEN-LAST:event_descProdutoKeyReleased

    private void validadePropostaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_validadePropostaFocusLost
        try {
            carregaCliente();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_validadePropostaFocusLost

    private void codOrcamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codOrcamentoFocusLost
        try {
            carregaTudo();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codOrcamentoFocusLost

    private void tabProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabProdutosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabProdutosMouseClicked

    private void descClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descClienteKeyReleased
        try {
            List<Cliente> merged = clientedao.getList(12,
                    "select e from Cliente e where  lower ( trim(e.descricao) ) like ?1 order by e.codCliente",
                    descCliente.getText().trim().toLowerCase() + "%");
            listaCliente.clear();
            listaCliente.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Cliente. Erro: " + e);
        }
    }//GEN-LAST:event_descClienteKeyReleased

    private void codCliente1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codCliente1FocusLost
       try {
            carregaCliente();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codCliente1FocusLost

    private void prazoEntregaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prazoEntregaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_prazoEntregaFocusLost

    private void valorUnitario1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorUnitario1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_valorUnitario1FocusLost

    private void valorUnitario2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorUnitario2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_valorUnitario2FocusLost

    private void valorUnitario3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorUnitario3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_valorUnitario3FocusLost

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void carregaOrcamento() throws Exception {
        orcamento = orcamentoDAO.get(ValidarValor.getInt(codOrcamento.getText()));
        if (orcamento != null) {
            carregaCliente();
            carregaProduto();
            
        } else {
            limpaCamposProduto();
        }
    }
    
     private void carregaTudo() throws Exception {
         carregaOrcamento();
         carregaCliente();
         carregaProduto();
     }

    private void carregaCliente() throws Exception {
        cliente = clientedao.get(ValidarValor.getLong(validadeProposta.getText()));
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
            descProduto.setText("");
            valorUnitario.setText("");
        }
    }

    private void limpaCamposProduto() {
        codProduto.setText("");
        descProduto.setText("");
        valorUnitario.setText("");
        quantidadeProduto.setText("");
        descontoProduto.setText("");
        valortotalProduto.setText("");
    }

    private void habilitaCampos(boolean b) {
        codProduto.setEnabled(b);
        descProduto.setEnabled(b);
        valorUnitario.setEnabled(b);
        quantidadeProduto.setEnabled(b);
        descontoProduto.setEnabled(b);
        valortotalProduto.setEnabled(b);
    }

    private void setCausa() {
        produto.setDescricao(descProduto.getText());
        produto.setValorUnitario(ValidarValor.getDouble(valorUnitario.getText()));
    }

    private void setOrcamento(){
        orcamento.setCliente(cliente);                
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarItem;
    private javax.swing.JButton btExcluirOrca;
    private javax.swing.JButton btNovoItem;
    private javax.swing.JButton btNovoOrca;
    private javax.swing.JButton btRemoverItem;
    private javax.swing.JButton btSalvarOrca;
    private javax.swing.JCheckBox checkAprovado;
    private javax.swing.JTextField codCliente1;
    private javax.swing.JTextField codOrcamento;
    private javax.swing.JTextField codProduto;
    private javax.swing.JFormattedTextField dataOrc;
    private javax.swing.JTextField descCliente;
    private javax.swing.JTextField descProduto;
    private javax.swing.JTextField descontoProduto;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
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
    private javax.swing.JTextField prazoEntrega;
    private javax.swing.JTextField quantidadeProduto;
    private javax.swing.JTable tabProdutos;
    private javax.swing.JTextField validadeProposta;
    private javax.swing.JTextField valorTotal1;
    private javax.swing.JTextField valorTotal2;
    private javax.swing.JTextField valorTotal3;
    private javax.swing.JTextField valorUnitario;
    private javax.swing.JTextField valorUnitario1;
    private javax.swing.JTextField valorUnitario2;
    private javax.swing.JTextField valorUnitario3;
    private javax.swing.JTextField valortotalProduto;
    // End of variables declaration//GEN-END:variables
}
