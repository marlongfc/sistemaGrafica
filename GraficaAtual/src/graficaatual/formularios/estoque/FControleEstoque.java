/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.estoque;

import graficaatual.daos.cadastro.FornecedorDAO;
import graficaatual.daos.cadastro.MaterialDAO;
import graficaatual.daos.estoque.EntradaEstoqueDAO;
import graficaatual.daos.estoque.SaidaEstoqueDAO;
import graficaatual.entidades.ControleAcesso;
import graficaatual.entidades.Fornecedor;
import graficaatual.entidades.Material;
import graficaatual.entidades.estoque.EntradaEstoque;
import graficaatual.entidades.estoque.SaidaEstoque;
import graficaatual.utilitarios.Componentes;
import graficaatual.utilitarios.Conexao;
import graficaatual.utilitarios.Data;
import graficaatual.utilitarios.Persistencia;
import graficaatual.utilitarios.ValidarConexao;
import graficaatual.utilitarios.ValidarValor;
import graficaatual.utilitarios.VisualizaRelatorio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Marlon
 */
public class FControleEstoque extends javax.swing.JInternalFrame {

    private static int initControle;
    private static FControleEstoque instancia;

    public static int isInicializado() {
        return initControle;
    }

    /**
     * Creates new form FCadProduto
     */
    private Material material, materialS;
    private Fornecedor fornecedor;
    private EntradaEstoque entrada, entradaAuxSaida;
    private SaidaEstoque saida;
    private EntradaEstoqueDAO entradaDao = new EntradaEstoqueDAO();
    private SaidaEstoqueDAO saidaDao = new SaidaEstoqueDAO();
    private MaterialDAO materialDao = new MaterialDAO();
    private FornecedorDAO fornecedorDao = new FornecedorDAO();

    private List<Material> listaMaterial = null, listaMaterialS = null;
    private List<Fornecedor> listaFornecedor = null;
    private List<Object[]> listaAbaixoMinimo;

    private Integer indexTabelaEntrada, indexTabelaSaida;

    public static FControleEstoque getInstancia() {
        if (instancia == null) {
            instancia = new FControleEstoque();
        }

        return instancia;
    }

    public FControleEstoque() {
        initComponents();

        listaMaterial = ObservableCollections.observableList(new LinkedList<Material>());
        Componentes comp3 = new Componentes(listaMaterial, false, codMaterial, descMaterial, this, jTabbedPane1, descMaterial.getWidth(), 100);
        comp3.addCol(0, "codMaterial", "Código", 50, Long.class.getName());
        comp3.addCol(1, "descricao", "Nome do Material", 200, String.class.getName());
        comp3.bind();

        listaMaterialS = ObservableCollections.observableList(new LinkedList<Material>());
        Componentes comp4 = new Componentes(listaMaterialS, false, codMaterialS, descMaterialS, this, jPanel21, descMaterialS.getWidth(), 100);
        comp4.addCol(0, "codMaterial", "Código", 50, Long.class.getName());
        comp4.addCol(1, "descricao", "Nome do Material", 200, String.class.getName());
        comp4.bind();

        listaFornecedor = ObservableCollections.observableList(new LinkedList<Fornecedor>());
        Componentes comp5 = new Componentes(listaFornecedor, false, codFornecedor, descFornecedor, this, jTabbedPane1, descFornecedor.getWidth(), 100);
        comp5.addCol(0, "codFornecedor", "Código", 50, Long.class.getName());
        comp5.addCol(1, "pessoa.nome", "Nome", 200, String.class.getName());
        comp5.bind();

        limparTelaEntrada();
        limparTelaSaida();

        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        try {
            atualizarEstoque();

            if (listaAbaixoMinimo != null && listaAbaixoMinimo.size() > 0) {

                JOptionPane.showMessageDialog(null, "Atenção! \n Há materiais com estoque abaixo da quantidade mínima!"
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void limparTelaEntrada() {

        btNovo.requestFocus();
        msgEntrada.setVisible(false);
        removeLinhas(tabMateriaisAddEntrada);

        limparCamposEntrada(true);
        tabMateriaisAddEntrada.removeAll();
    }

    private void limparTelaSaida() {

        btNovoS.requestFocus();
        removeLinhas(tabMateriaisSaida);

        limparCamposSaida(true);
        msgSaida.setVisible(false);
        tabMateriaisSaida.removeAll();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel18 = new javax.swing.JPanel();
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabMateriaisAddEntrada = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        codMaterial = new javax.swing.JTextField();
        descMaterial = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btAddMaterial = new javax.swing.JButton();
        msgEntrada = new javax.swing.JLabel();
        removerMaterial = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        metragemLinear = new javax.swing.JTextField();
        largura = new javax.swing.JTextField();
        unidade = new javax.swing.JTextField();
        peso = new javax.swing.JTextField();
        litro = new javax.swing.JTextField();
        altura = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        tipoEntrada = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        notaFiscal = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        dataEntrada = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        valor = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        observacaoEntrada = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        cor = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        marca = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        dataValidade = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        labelCancelada = new javax.swing.JLabel();
        descFornecedor = new javax.swing.JTextField();
        codFornecedor = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jTextField65 = new javax.swing.JTextField();
        jTextField66 = new javax.swing.JTextField();
        jTextField67 = new javax.swing.JTextField();
        jTextField68 = new javax.swing.JTextField();
        jTextField69 = new javax.swing.JTextField();
        jTextField70 = new javax.swing.JTextField();
        jTextField71 = new javax.swing.JTextField();
        jTextField72 = new javax.swing.JTextField();
        jTextField73 = new javax.swing.JTextField();
        jTextField74 = new javax.swing.JTextField();
        jTextField75 = new javax.swing.JTextField();
        jTextField76 = new javax.swing.JTextField();
        jTextField77 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jTextField78 = new javax.swing.JTextField();
        jTextField79 = new javax.swing.JTextField();
        jTextField80 = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        codSaida = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tipoSaida = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        dataSaida = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        codMaterialS = new javax.swing.JTextField();
        descMaterialS = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        codPedido = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabMateriaisSaida = new javax.swing.JTable();
        metragemLinearS = new javax.swing.JTextField();
        larguraS = new javax.swing.JTextField();
        alturaS = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        unidadeS = new javax.swing.JTextField();
        pesoS = new javax.swing.JTextField();
        litroS = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        btNovoS = new javax.swing.JButton();
        btSalvarS = new javax.swing.JButton();
        btExcluirS = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        observacaoSaida = new javax.swing.JTextField();
        labelCancelada1 = new javax.swing.JLabel();
        btAddMaterialS = new javax.swing.JButton();
        removerMaterialS = new javax.swing.JButton();
        msgSaida = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        btSair1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel5 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaEstoque = new javax.swing.JTable();
        btAddMaterial1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1335, 700));
        setPreferredSize(new java.awt.Dimension(1335, 700));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1335, 700));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1335, 700));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setLayout(null);

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
        btNovo.setBounds(50, 620, 190, 39);

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar2.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel18.add(btSalvar);
        btSalvar.setBounds(240, 620, 190, 39);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excuir2.png"))); // NOI18N
        btExcluir.setText("Cancelar Entrada");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel18.add(btExcluir);
        btExcluir.setBounds(430, 620, 190, 39);

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAIR2.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel18.add(btSair);
        btSair.setBounds(810, 620, 190, 39);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ENTRADA DE MATERIAL");
        jPanel18.add(jLabel1);
        jLabel1.setBounds(0, 0, 1030, 70);

        tabMateriaisAddEntrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "  ", "Tipo", "Nota Fiscal", "Data", "Cód.", "Material", "Cód. Fornecedor", "Fornecedor", "Metrag. Linear (m)", "Largura (m)", "Altura (m)", "Quantidade (u)", "Peso (Kg)", "Litros (L)", "Valor Unitário", "Cor", "Marca", "Data Validade", "Observacao"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabMateriaisAddEntrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMateriaisAddEntradaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tabMateriaisAddEntradaMouseExited(evt);
            }
        });
        tabMateriaisAddEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabMateriaisAddEntradaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabMateriaisAddEntrada);
        if (tabMateriaisAddEntrada.getColumnModel().getColumnCount() > 0) {
            tabMateriaisAddEntrada.getColumnModel().getColumn(0).setMinWidth(0);
            tabMateriaisAddEntrada.getColumnModel().getColumn(0).setPreferredWidth(0);
            tabMateriaisAddEntrada.getColumnModel().getColumn(0).setMaxWidth(0);
            tabMateriaisAddEntrada.getColumnModel().getColumn(1).setPreferredWidth(20);
            tabMateriaisAddEntrada.getColumnModel().getColumn(3).setPreferredWidth(20);
            tabMateriaisAddEntrada.getColumnModel().getColumn(4).setPreferredWidth(5);
            tabMateriaisAddEntrada.getColumnModel().getColumn(8).setPreferredWidth(15);
            tabMateriaisAddEntrada.getColumnModel().getColumn(9).setPreferredWidth(15);
            tabMateriaisAddEntrada.getColumnModel().getColumn(10).setPreferredWidth(15);
            tabMateriaisAddEntrada.getColumnModel().getColumn(11).setPreferredWidth(15);
            tabMateriaisAddEntrada.getColumnModel().getColumn(12).setPreferredWidth(15);
            tabMateriaisAddEntrada.getColumnModel().getColumn(13).setPreferredWidth(15);
        }

        jPanel18.add(jScrollPane1);
        jScrollPane1.setBounds(30, 440, 990, 150);

        jLabel8.setText("Cód. Material");
        jPanel18.add(jLabel8);
        jLabel8.setBounds(30, 130, 80, 14);

        codMaterial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codMaterial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codMaterialFocusLost(evt);
            }
        });
        jPanel18.add(codMaterial);
        codMaterial.setBounds(30, 150, 110, 20);

        descMaterial.setBackground(new java.awt.Color(255, 255, 204));
        descMaterial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descMaterialKeyReleased(evt);
            }
        });
        jPanel18.add(descMaterial);
        descMaterial.setBounds(140, 150, 630, 20);

        jLabel9.setText("Material");
        jPanel18.add(jLabel9);
        jLabel9.setBounds(140, 130, 100, 14);

        btAddMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ADICIONAR2.png"))); // NOI18N
        btAddMaterial.setText("Adicionar ");
        btAddMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddMaterialActionPerformed(evt);
            }
        });
        jPanel18.add(btAddMaterial);
        btAddMaterial.setBounds(500, 350, 170, 39);

        msgEntrada.setForeground(new java.awt.Color(255, 0, 0));
        msgEntrada.setText("* Material adicionado/removido ainda não foi salvo! Informe os dados e clique em salvar abaixo para lançar entrada!");
        jPanel18.add(msgEntrada);
        msgEntrada.setBounds(30, 400, 770, 14);

        removerMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/REMOVER2.png"))); // NOI18N
        removerMaterial.setText("Remover ");
        removerMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerMaterialActionPerformed(evt);
            }
        });
        jPanel18.add(removerMaterial);
        removerMaterial.setBounds(670, 350, 180, 39);

        jLabel13.setText("Materiais à Lançar no Estoque");
        jPanel18.add(jLabel13);
        jLabel13.setBounds(30, 420, 200, 20);

        metragemLinear.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        metragemLinear.setText("0,00");
        jPanel18.add(metragemLinear);
        metragemLinear.setBounds(30, 250, 110, 20);

        largura.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        largura.setText("0,00");
        jPanel18.add(largura);
        largura.setBounds(160, 250, 80, 20);

        unidade.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        unidade.setText("0");
        jPanel18.add(unidade);
        unidade.setBounds(350, 250, 110, 20);

        peso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        peso.setText("0,00");
        jPanel18.add(peso);
        peso.setBounds(470, 250, 110, 20);

        litro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        litro.setText("0,00");
        jPanel18.add(litro);
        litro.setBounds(590, 250, 110, 20);

        altura.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        altura.setText("0,00");
        jPanel18.add(altura);
        altura.setBounds(250, 250, 80, 20);

        jLabel10.setText("Metragem (linear)");
        jPanel18.add(jLabel10);
        jLabel10.setBounds(30, 230, 110, 14);

        jLabel15.setText("Largura (m)");
        jPanel18.add(jLabel15);
        jLabel15.setBounds(160, 230, 80, 14);

        jLabel16.setText("Altura (m)");
        jPanel18.add(jLabel16);
        jLabel16.setBounds(250, 230, 80, 14);

        jLabel17.setText("Unidades");
        jPanel18.add(jLabel17);
        jLabel17.setBounds(350, 230, 70, 14);

        jLabel18.setText("Peso (kg)");
        jPanel18.add(jLabel18);
        jLabel18.setBounds(470, 230, 80, 14);

        jLabel19.setText("Litros (l)");
        jPanel18.add(jLabel19);
        jLabel19.setBounds(590, 230, 80, 14);

        jLabel20.setText("X");
        jPanel18.add(jLabel20);
        jLabel20.setBounds(240, 250, 10, 20);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir2.png"))); // NOI18N
        jButton2.setText("Imprimir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton2);
        jButton2.setBounds(620, 620, 190, 39);

        tipoEntrada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " Compra", " Devolução ", " Reaproveitamento", " Doação" }));
        jPanel18.add(tipoEntrada);
        tipoEntrada.setBounds(150, 100, 150, 20);

        jLabel14.setText("Tipo");
        jPanel18.add(jLabel14);
        jLabel14.setBounds(150, 80, 110, 14);
        jPanel18.add(notaFiscal);
        notaFiscal.setBounds(310, 100, 220, 20);

        jLabel21.setText("Nota Fiscal");
        jPanel18.add(jLabel21);
        jLabel21.setBounds(310, 80, 100, 14);

        dataEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataEntradaActionPerformed(evt);
            }
        });
        jPanel18.add(dataEntrada);
        dataEntrada.setBounds(540, 100, 110, 20);

        jLabel22.setText("Data");
        jPanel18.add(jLabel22);
        jLabel22.setBounds(540, 80, 40, 14);

        valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorActionPerformed(evt);
            }
        });
        jPanel18.add(valor);
        valor.setBounds(660, 100, 110, 20);

        jLabel23.setText("Valor");
        jPanel18.add(jLabel23);
        jLabel23.setBounds(660, 80, 40, 14);

        codigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigoFocusLost(evt);
            }
        });
        jPanel18.add(codigo);
        codigo.setBounds(30, 100, 110, 20);

        jLabel24.setText("Código");
        jPanel18.add(jLabel24);
        jLabel24.setBounds(30, 80, 60, 14);

        observacaoEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                observacaoEntradaActionPerformed(evt);
            }
        });
        jPanel18.add(observacaoEntrada);
        observacaoEntrada.setBounds(30, 350, 430, 40);

        jLabel27.setText("Observação");
        jPanel18.add(jLabel27);
        jLabel27.setBounds(30, 320, 110, 20);
        jPanel18.add(cor);
        cor.setBounds(30, 300, 110, 20);

        jLabel37.setText("Cor");
        jPanel18.add(jLabel37);
        jLabel37.setBounds(30, 280, 80, 14);
        jPanel18.add(marca);
        marca.setBounds(160, 300, 170, 20);

        jLabel38.setText("Marca");
        jPanel18.add(jLabel38);
        jLabel38.setBounds(160, 280, 80, 14);
        jPanel18.add(dataValidade);
        dataValidade.setBounds(350, 300, 110, 20);

        jLabel39.setText("Data de Validade");
        jPanel18.add(jLabel39);
        jLabel39.setBounds(350, 280, 110, 14);

        labelCancelada.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        labelCancelada.setForeground(new java.awt.Color(255, 0, 51));
        labelCancelada.setText("ENTRADA CANCELADA");
        jPanel18.add(labelCancelada);
        labelCancelada.setBounds(490, 290, 350, 50);

        descFornecedor.setBackground(new java.awt.Color(255, 255, 204));
        descFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descFornecedorKeyReleased(evt);
            }
        });
        jPanel18.add(descFornecedor);
        descFornecedor.setBounds(140, 200, 630, 20);

        codFornecedor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codFornecedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codFornecedorFocusLost(evt);
            }
        });
        jPanel18.add(codFornecedor);
        codFornecedor.setBounds(30, 200, 110, 20);

        jLabel25.setText("Cód. Fornecedor");
        jPanel18.add(jLabel25);
        jLabel25.setBounds(30, 180, 110, 14);

        jLabel26.setText("Fornecedor");
        jPanel18.add(jLabel26);
        jLabel26.setBounds(140, 180, 100, 14);

        jTabbedPane1.addTab("Entrada de Material", jPanel18);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setLayout(null);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setLayout(null);
        jPanel22.add(jTextField65);
        jTextField65.setBounds(160, 10, 90, 20);

        jTextField66.setBackground(new java.awt.Color(255, 255, 204));
        jPanel22.add(jTextField66);
        jTextField66.setBounds(340, 30, 310, 20);

        jTextField67.setBackground(new java.awt.Color(255, 255, 204));
        jPanel22.add(jTextField67);
        jTextField67.setBounds(160, 50, 490, 20);
        jPanel22.add(jTextField68);
        jTextField68.setBounds(120, 160, 80, 20);
        jPanel22.add(jTextField69);
        jTextField69.setBounds(200, 160, 470, 20);
        jPanel22.add(jTextField70);
        jTextField70.setBounds(780, 160, 140, 20);
        jPanel22.add(jTextField71);
        jTextField71.setBounds(120, 180, 80, 20);
        jPanel22.add(jTextField72);
        jTextField72.setBounds(200, 180, 470, 20);
        jPanel22.add(jTextField73);
        jTextField73.setBounds(780, 180, 140, 20);
        jPanel22.add(jTextField74);
        jTextField74.setBounds(120, 200, 80, 20);
        jPanel22.add(jTextField75);
        jTextField75.setBounds(200, 200, 310, 20);
        jPanel22.add(jTextField76);
        jTextField76.setBounds(780, 200, 140, 20);
        jPanel22.add(jTextField77);
        jTextField77.setBounds(580, 200, 90, 20);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Física", "Juridica" }));
        jPanel22.add(jComboBox4);
        jComboBox4.setBounds(160, 30, 180, 18);

        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel104.setText("UF: ");
        jPanel22.add(jLabel104);
        jLabel104.setBounds(510, 200, 70, 20);

        jLabel105.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel105.setText("CEP: ");
        jPanel22.add(jLabel105);
        jLabel105.setBounds(670, 200, 110, 20);

        jLabel106.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel106.setText("Código: ");
        jPanel22.add(jLabel106);
        jLabel106.setBounds(80, 10, 80, 20);

        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel107.setText("Data Nascimento: ");
        jPanel22.add(jLabel107);
        jLabel107.setBounds(650, 70, 140, 20);

        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel108.setText("Número: ");
        jPanel22.add(jLabel108);
        jLabel108.setBounds(670, 160, 110, 20);

        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel109.setText("Insc. Estadual:");
        jPanel22.add(jLabel109);
        jLabel109.setBounds(650, 50, 140, 20);

        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel110.setText("Bairro: ");
        jPanel22.add(jLabel110);
        jLabel110.setBounds(20, 180, 100, 20);

        jLabel111.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel111.setText("Logradouro: ");
        jPanel22.add(jLabel111);
        jLabel111.setBounds(20, 160, 100, 20);

        jLabel112.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel112.setText("Complemento: ");
        jPanel22.add(jLabel112);
        jLabel112.setBounds(670, 180, 110, 20);

        jLabel113.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel113.setText("Cidade: ");
        jPanel22.add(jLabel113);
        jLabel113.setBounds(20, 200, 100, 20);

        jLabel114.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel114.setBorder(javax.swing.BorderFactory.createTitledBorder("Endeço:"));
        jPanel22.add(jLabel114);
        jLabel114.setBounds(10, 130, 920, 110);

        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel115.setText("CPF/CNPJ: ");
        jPanel22.add(jLabel115);
        jLabel115.setBounds(80, 30, 80, 20);
        jPanel22.add(jTextField78);
        jTextField78.setBounds(790, 70, 130, 20);
        jPanel22.add(jTextField79);
        jTextField79.setBounds(790, 30, 130, 20);
        jPanel22.add(jTextField80);
        jTextField80.setBounds(790, 50, 130, 20);

        jLabel116.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel116.setText("Nome/Razão Socia: ");
        jPanel22.add(jLabel116);
        jLabel116.setBounds(10, 50, 150, 20);

        jLabel117.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel117.setText("Insc. Munícipal:");
        jPanel22.add(jLabel117);
        jLabel117.setBounds(650, 30, 140, 20);

        jPanel21.add(jPanel22);
        jPanel22.setBounds(0, 0, 0, 0);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("SAÍDA DE MATERIAL");
        jPanel21.add(jLabel11);
        jLabel11.setBounds(0, 0, 970, 70);

        codSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codSaidaActionPerformed(evt);
            }
        });
        jPanel21.add(codSaida);
        codSaida.setBounds(30, 100, 110, 20);

        jLabel2.setText("Código");
        jPanel21.add(jLabel2);
        jLabel2.setBounds(30, 80, 110, 14);

        tipoSaida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pedido/Produção", "Venda Avulsa", "Descarte", "Brinde/Doação" }));
        tipoSaida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoSaidaItemStateChanged(evt);
            }
        });
        tipoSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoSaidaActionPerformed(evt);
            }
        });
        jPanel21.add(tipoSaida);
        tipoSaida.setBounds(170, 100, 160, 20);

        jLabel3.setText("Tipo");
        jPanel21.add(jLabel3);
        jLabel3.setBounds(170, 80, 30, 14);

        dataSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataSaidaActionPerformed(evt);
            }
        });
        jPanel21.add(dataSaida);
        dataSaida.setBounds(340, 100, 110, 20);

        jLabel4.setText("Data");
        jPanel21.add(jLabel4);
        jLabel4.setBounds(340, 80, 50, 14);

        codMaterialS.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codMaterialSFocusLost(evt);
            }
        });
        codMaterialS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codMaterialSActionPerformed(evt);
            }
        });
        jPanel21.add(codMaterialS);
        codMaterialS.setBounds(30, 150, 110, 20);

        descMaterialS.setBackground(new java.awt.Color(255, 255, 204));
        descMaterialS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descMaterialSActionPerformed(evt);
            }
        });
        descMaterialS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descMaterialSKeyReleased(evt);
            }
        });
        jPanel21.add(descMaterialS);
        descMaterialS.setBounds(140, 150, 560, 20);

        jLabel5.setText("Código");
        jPanel21.add(jLabel5);
        jLabel5.setBounds(30, 130, 110, 14);

        jLabel6.setText("Material");
        jPanel21.add(jLabel6);
        jLabel6.setBounds(140, 130, 70, 14);
        jPanel21.add(codPedido);
        codPedido.setBounds(460, 100, 120, 20);

        jLabel12.setText("Número do Pedido");
        jPanel21.add(jLabel12);
        jLabel12.setBounds(460, 80, 110, 14);

        tabMateriaisSaida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Tipo", "Nº Pedido", "Data", "Cód.", "Material", "Metrag. Linear (m)", "Largura (m)", "Altura (m)", "Unidades (u)", "Peso (Kg)", "Litros (L)", "Observação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabMateriaisSaida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMateriaisSaidaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tabMateriaisSaidaMouseExited(evt);
            }
        });
        tabMateriaisSaida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabMateriaisSaidaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tabMateriaisSaida);
        if (tabMateriaisSaida.getColumnModel().getColumnCount() > 0) {
            tabMateriaisSaida.getColumnModel().getColumn(0).setMinWidth(0);
            tabMateriaisSaida.getColumnModel().getColumn(0).setPreferredWidth(0);
            tabMateriaisSaida.getColumnModel().getColumn(0).setMaxWidth(0);
            tabMateriaisSaida.getColumnModel().getColumn(1).setPreferredWidth(20);
            tabMateriaisSaida.getColumnModel().getColumn(3).setPreferredWidth(20);
            tabMateriaisSaida.getColumnModel().getColumn(4).setPreferredWidth(5);
            tabMateriaisSaida.getColumnModel().getColumn(6).setPreferredWidth(15);
            tabMateriaisSaida.getColumnModel().getColumn(7).setPreferredWidth(15);
            tabMateriaisSaida.getColumnModel().getColumn(8).setPreferredWidth(15);
            tabMateriaisSaida.getColumnModel().getColumn(9).setPreferredWidth(15);
            tabMateriaisSaida.getColumnModel().getColumn(10).setPreferredWidth(15);
            tabMateriaisSaida.getColumnModel().getColumn(11).setPreferredWidth(15);
        }

        jPanel21.add(jScrollPane2);
        jScrollPane2.setBounds(30, 400, 990, 130);

        metragemLinearS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        metragemLinearS.setText("0,00");
        jPanel21.add(metragemLinearS);
        metragemLinearS.setBounds(30, 210, 110, 20);

        larguraS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        larguraS.setText("0,00");
        jPanel21.add(larguraS);
        larguraS.setBounds(160, 210, 80, 20);

        alturaS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        alturaS.setText("0,00");
        jPanel21.add(alturaS);
        alturaS.setBounds(250, 210, 80, 20);

        jLabel28.setText("X");
        jPanel21.add(jLabel28);
        jLabel28.setBounds(240, 210, 10, 20);

        unidadeS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        unidadeS.setText("0");
        jPanel21.add(unidadeS);
        unidadeS.setBounds(350, 210, 110, 20);

        pesoS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pesoS.setText("0,00");
        jPanel21.add(pesoS);
        pesoS.setBounds(470, 210, 110, 20);

        litroS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        litroS.setText("0,00");
        jPanel21.add(litroS);
        litroS.setBounds(590, 210, 110, 20);

        jLabel29.setText("Metragem (linear)");
        jPanel21.add(jLabel29);
        jLabel29.setBounds(30, 190, 110, 14);

        jLabel30.setText("Largura (m)");
        jPanel21.add(jLabel30);
        jLabel30.setBounds(160, 190, 80, 14);

        jLabel31.setText("Altura (m)");
        jPanel21.add(jLabel31);
        jLabel31.setBounds(250, 190, 80, 14);

        jLabel32.setText("Unidades");
        jPanel21.add(jLabel32);
        jLabel32.setBounds(350, 190, 70, 14);

        jLabel33.setText("Peso (kg)");
        jPanel21.add(jLabel33);
        jLabel33.setBounds(470, 190, 80, 14);

        jLabel34.setText("Litros (l)");
        jPanel21.add(jLabel34);
        jLabel34.setBounds(590, 190, 80, 14);

        btNovoS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/NOVO2.png"))); // NOI18N
        btNovoS.setText("Nova Saída");
        btNovoS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoSActionPerformed(evt);
            }
        });
        jPanel21.add(btNovoS);
        btNovoS.setBounds(40, 540, 190, 39);

        btSalvarS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar2.png"))); // NOI18N
        btSalvarS.setText("Salvar");
        btSalvarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarSActionPerformed(evt);
            }
        });
        jPanel21.add(btSalvarS);
        btSalvarS.setBounds(230, 540, 190, 39);

        btExcluirS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excuir2.png"))); // NOI18N
        btExcluirS.setText("Cancelar Saída");
        btExcluirS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirSActionPerformed(evt);
            }
        });
        jPanel21.add(btExcluirS);
        btExcluirS.setBounds(420, 540, 190, 39);

        jLabel36.setText("Observação");
        jPanel21.add(jLabel36);
        jLabel36.setBounds(30, 240, 110, 14);
        jPanel21.add(observacaoSaida);
        observacaoSaida.setBounds(30, 260, 430, 40);

        labelCancelada1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        labelCancelada1.setForeground(new java.awt.Color(255, 0, 51));
        labelCancelada1.setText("SAÍDA CANCELADA");
        jPanel21.add(labelCancelada1);
        labelCancelada1.setBounds(530, 330, 350, 50);

        btAddMaterialS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ADICIONAR2.png"))); // NOI18N
        btAddMaterialS.setText("Adicionar ");
        btAddMaterialS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddMaterialSActionPerformed(evt);
            }
        });
        jPanel21.add(btAddMaterialS);
        btAddMaterialS.setBounds(470, 260, 170, 39);

        removerMaterialS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/REMOVER2.png"))); // NOI18N
        removerMaterialS.setText("Remover ");
        removerMaterialS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerMaterialSActionPerformed(evt);
            }
        });
        jPanel21.add(removerMaterialS);
        removerMaterialS.setBounds(640, 260, 180, 39);

        msgSaida.setForeground(new java.awt.Color(255, 0, 0));
        msgSaida.setText("* Material adicionado/removido ainda não foi salvo! Informe os dados e clique em salvar abaixo para lançar entrada!");
        jPanel21.add(msgSaida);
        msgSaida.setBounds(30, 310, 770, 14);

        jLabel40.setText("Materiais à serem removidos no Estoque");
        jPanel21.add(jLabel40);
        jLabel40.setBounds(30, 370, 350, 20);

        btSair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAIR2.png"))); // NOI18N
        btSair1.setText("Sair");
        btSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSair1ActionPerformed(evt);
            }
        });
        jPanel21.add(btSair1);
        btSair1.setBounds(800, 540, 190, 39);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir2.png"))); // NOI18N
        jButton3.setText("Imprimir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton3);
        jButton3.setBounds(610, 540, 190, 39);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 1092, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGap(0, 12, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 227, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Saída de Material", jPanel1);

        jInternalFrame1.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame1.setVisible(true);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1022, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("ESTOQUE");

        tabelaEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód.", "Material", "Metragem (m)", "Largura (m)", "Altura (m)", "Peso (Kg)", "Litros (L)", "Unidades (U)", "Estoque Mínimo", "Quantidade Total", "Estoque Abaixo Minimo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEstoqueMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tabelaEstoqueMouseExited(evt);
            }
        });
        tabelaEstoque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaEstoqueKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaEstoque);
        if (tabelaEstoque.getColumnModel().getColumnCount() > 0) {
            tabelaEstoque.getColumnModel().getColumn(0).setPreferredWidth(5);
            tabelaEstoque.getColumnModel().getColumn(2).setPreferredWidth(15);
            tabelaEstoque.getColumnModel().getColumn(3).setPreferredWidth(15);
            tabelaEstoque.getColumnModel().getColumn(4).setPreferredWidth(15);
            tabelaEstoque.getColumnModel().getColumn(5).setPreferredWidth(15);
            tabelaEstoque.getColumnModel().getColumn(6).setPreferredWidth(15);
            tabelaEstoque.getColumnModel().getColumn(10).setResizable(false);
            tabelaEstoque.getColumnModel().getColumn(10).setPreferredWidth(0);
        }

        btAddMaterial1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ADICIONAR2.png"))); // NOI18N
        btAddMaterial1.setText("Adicionar ");
        btAddMaterial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddMaterial1ActionPerformed(evt);
            }
        });

        jButton1.setText("Atualizar Estoque");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(422, 422, 422)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btAddMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 405, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 713, Short.MAX_VALUE))
            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jInternalFrame1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btAddMaterial1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1027, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Estoque", jPanel3);

        jPanel4.setLayout(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void removeLinhas(JTable table) {
        int n = table.getRowCount();

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (int i = n - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private void atualizarEstoque() throws SQLException {

        try {

            Connection conexao = Conexao.getConexao();
            Statement banco = Conexao.getBanco(conexao);

            removeLinhas(tabelaEstoque);
            listaAbaixoMinimo = new ArrayList<Object[]>();
            listaAbaixoMinimo.clear();

            DefaultTableModel model = (DefaultTableModel) tabelaEstoque.getModel();

            String sql = "with tmpSomaEntrada as (Select t.codMaterial, t.descMaterial, t.quantAlturaEntrada, t.quantLarguraEntrada, t.quantMetragemEntrada,"
                    + " t.quantLitroEntrada, t.quantPesoEntrada, t.quantUnidadeEntrada,"
                    + " Case t.unidadeMedida when 1 then (t.quantAlturaEntrada * t.quantLarguraEntrada) else "
                    + " ((case when t.quantMetragemEntrada is null then 0 else t.quantMetragemEntrada end) + "
                    + " (case when t.quantLitroEntrada is null then 0 else t.quantLitroEntrada end)  "
                    + " +(case when t.quantPesoEntrada is null then 0 else quantPesoEntrada end)"
                    + " + (case when t.quantUnidadeEntrada is null then 0 else quantUnidadeEntrada end)) end as quantidadeTotal"
                    + " "
                    + " from (select e.codMaterial as codMaterial, m.unidademedida as unidadeMedida, e.descMaterial as descMaterial, Sum(e.altura) as quantAlturaEntrada, Sum(e.largura) as quantLarguraEntrada, Sum(e.metragemLinear) as quantMetragemEntrada,"
                    + " Sum(e.litro) as quantLitroEntrada, Sum(e.peso) as quantPesoEntrada, Sum(e.unidade) as quantUnidadeEntrada "
                    + " "
                    + " from entradaEstoque e "
                    + " left join material m on m.codMaterial=e.codMaterial"
                    + " where e.cancelada=FALSE"
                    + " group by e.codMaterial, descMaterial, unidadeMedida order by e.codMaterial) as t), "
                    + " "
                    + " tempSomaSaida as (Select t.codMaterial, t.descMaterial, t.quantAlturaSaida, t.quantLarguraSaida, t.quantMetragemSaida,"
                    + " t.quantLitroSaida, t.quantPesoSaida, t.quantUnidadeSaida,"
                    + " Case t.unidadeMedida when 1 then (t.quantAlturaSaida * t.quantLarguraSaida) else "
                    + " ((case when t.quantMetragemSaida is null then 0 else t.quantMetragemSaida end) + "
                    + " (case when t.quantLitroSaida is null then 0 else t.quantLitroSaida end)  "
                    + " +(case when t.quantPesoSaida is null then 0 else quantPesoSaida end)"
                    + " + (case when t.quantUnidadeSaida is null then 0 else quantUnidadeSaida end)) end as quantidadeTotal"
                    + " "
                    + " from (select e.codMaterial as codMaterial, m.unidademedida as unidadeMedida, e.descMaterial as descMaterial, Sum(e.altura) as quantAlturaSaida, Sum(e.largura) as quantLarguraSaida, Sum(e.metragemLinear) as quantMetragemSaida,"
                    + " Sum(e.litro) as quantLitroSaida, Sum(e.peso) as quantPesoSaida, Sum(e.unidade) as quantUnidadeSaida "
                    + " "
                    + " from saidaEstoque e "
                    + " left join material m on m.codMaterial=e.codMaterial"
                    + " where e.cancelada=FALSE"
                    + " group by e.codMaterial, descMaterial, unidadeMedida order by e.codMaterial)  as t)"
                    + " "
                    + " Select tE.codMaterial, tE.descMaterial, "
                    + " ((Case when tE.quantAlturaEntrada is null then 0 else tE.quantAlturaEntrada end) - (Case when tS.quantAlturaSaida is null then 0 else tS.quantAlturaSaida end)) as quantAltura, "
                    + " ((Case when tE.quantLarguraEntrada is null then 0 else tE.quantLarguraEntrada end) - (Case when tS.quantLarguraSaida is null then 0 else tS.quantLarguraSaida end)) as quantLargura, "
                    + " ((Case when tE.quantMetragemEntrada is null then 0 else tE.quantMetragemEntrada end) - (Case when tS.quantMetragemSaida is null then 0 else tS.quantMetragemSaida end)) as quantMetragem, "
                    + " ((Case when tE.quantLitroEntrada is null then 0 else tE.quantLitroEntrada end) - (Case when tS.quantLitroSaida is null then 0 else tS.quantLitroSaida end)) as quantLitro, "
                    + " ((Case when tE.quantPesoEntrada is null then 0 else tE.quantPesoEntrada end) - (Case when tS.quantPesoSaida is null then 0 else tS.quantPesoSaida end)) as quantPeso, "
                    + " ((Case when tE.quantUnidadeEntrada is null then 0 else tE.quantUnidadeEntrada end) - (Case when tS.quantUnidadeSaida is null then 0 else tS.quantUnidadeSaida end)) as quantUnidade, "
                    + " ((Case when tE.quantidadeTotal is null then 0 else tE.quantidadeTotal end) - (Case when tS.quantidadeTotal is null then 0 else tS.quantidadeTotal end)) as quantTotal, "
                    + "  m.estoqueMinimo as estoqueMin, "
                    + " Case when ((Case when tE.quantidadeTotal is null then 0 else tE.quantidadeTotal end) - (Case when tS.quantidadeTotal is null then 0 else tS.quantidadeTotal end))<=m.estoqueMinimo then true else false end as estoqueAbaixoMinimo"
                    + " "
                    + " from tmpSomaEntrada as tE"
                    + " left Join tempSomaSaida as tS on tE.codMaterial = tS.codMaterial "
                    + " left Join material as m on m.codMaterial = tE.codMaterial"
                    + " "
                    + " order by tE.descMaterial";

            ResultSet rs = null;

            if (conexao == null || !ValidarConexao.isValidConexao(conexao, "postgres")) {
                throw new Exception("Conexão com o banco inválida, tente conectar novamente!");
            }

            rs = banco.executeQuery(sql);

            if (rs != null) {
                Object os[] = null;

                while (rs.next()) {

                    os = new Object[]{
                        rs.getLong("codMaterial"),
                        rs.getString("descMaterial"),
                        rs.getDouble("quantMetragem") > 0 ? ValidarValor.getDouble(rs.getDouble("quantMetragem")) : null,
                        rs.getDouble("quantAltura") > 0 ? ValidarValor.getDouble(rs.getDouble("quantAltura")) : null,
                        rs.getDouble("quantLargura") > 0 ? ValidarValor.getDouble(rs.getDouble("quantLargura")) : null,
                        rs.getDouble("quantPeso") > 0 ? ValidarValor.getDouble(rs.getDouble("quantPeso")) : null,
                        rs.getDouble("quantLitro") > 0 ? ValidarValor.getDouble(rs.getDouble("quantLitro")) : null,
                        rs.getDouble("quantUnidade") > 0 ? ValidarValor.getDouble(rs.getDouble("quantUnidade")) : null,
                        rs.getDouble("estoqueMin") > 0 ? ValidarValor.getDouble(rs.getDouble("estoqueMin")) : null,
                        rs.getDouble("quantTotal") > 0 ? ValidarValor.getDouble(rs.getDouble("quantTotal")) : null,
                        rs.getBoolean("estoqueAbaixoMinimo")
                    };

                    if ((Boolean) os[10] == true) {
                        listaAbaixoMinimo.add(os);
                    }

                    model.addRow(os);
                };

                tabelaEstoque.setModel(model);

                if (banco != null) {
                    banco.close();
                }
                if (conexao != null) {
                    conexao.close();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getLocalizedMessage();
        }
    }


    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        try {

            limparTelaEntrada();
            codigo.setText("" + entradaDao.getNextItem());
            entrada = new EntradaEstoque();
            tipoEntrada.requestFocus();
            dataEntrada.setText(Data.getDateParse(new Date(), "dd/MM/yyyy"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btNovoActionPerformed

    private void limparCamposEntrada(Boolean limparTudo) {
        try {

            if (limparTudo) {
                codigo.setText("");
                entrada = null;
                tipoEntrada.setSelectedIndex(0);
                notaFiscal.setText("");
                dataEntrada.setText(Data.getDateParse(new Date(), "dd/MM/yyyy"));
                valor.setText("");
                codFornecedor.setText("");
                descFornecedor.setText("");
                fornecedor = null;
                codMaterial.setText("");
                descMaterial.setText("");
                material = null;
                observacaoEntrada.setText("");
                limparMedidas();
                cor.setText("");
                marca.setText("");
                dataValidade.setText("");
                observacaoEntrada.setText("");
                labelCancelada.setVisible(false);
                btSalvar.setEnabled(true);
                btExcluir.setEnabled(true);
                btAddMaterial.setEnabled(true);
                removerMaterial.setEnabled(true);
                indexTabelaEntrada = null;
            } else {
                codigo.setText("");
                entrada = null;
                tipoEntrada.setSelectedIndex(0);
                valor.setText("");
                codMaterial.setText("");
                descMaterial.setText("");
                material = null;
                limparMedidas();
                cor.setText("");
                marca.setText("");
                dataValidade.setText("");
                observacaoEntrada.setText("");
                labelCancelada.setVisible(false);
                btSalvar.setEnabled(true);
                btExcluir.setEnabled(true);
                btAddMaterial.setEnabled(true);
                removerMaterial.setEnabled(true);
                indexTabelaEntrada = null;

            }
            habilitaCamposEntrada(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void limparCamposSaida(Boolean limparTudo) {
        try {
            if (limparTudo) {

                codSaida.setText("");
                saida = null;

                tipoSaida.setSelectedIndex(0);
                notaFiscal.setText("");
                dataSaida.setText(Data.getDateParse(new Date(), "dd/MM/yyyy"));
                codPedido.setText("");
                codMaterialS.setText("");
                descMaterialS.setText("");

                materialS = null;
                observacaoSaida.setText("");

                labelCancelada1.setVisible(false);
                btSalvarS.setEnabled(true);
                btExcluirS.setEnabled(true);
                btAddMaterialS.setEnabled(true);
                removerMaterialS.setEnabled(true);

                limparMedidasSaida();

            } else {

                codSaida.setText("");
                saida = null;
                tipoSaida.setSelectedIndex(0);
                codMaterialS.setText("");
                descMaterialS.setText("");
                materialS = null;
                observacaoSaida.setText("");

                labelCancelada1.setVisible(false);
                btSalvarS.setEnabled(true);
                btExcluirS.setEnabled(true);
                btAddMaterialS.setEnabled(true);
                removerMaterialS.setEnabled(true);

                limparMedidasSaida();

            }

            habilitaCamposSaida(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        try {

            DefaultTableModel model = (DefaultTableModel) tabMateriaisAddEntrada.getModel();

            for (int i = 0; i < model.getRowCount(); i++) {

                entrada = new EntradaEstoque();

                entrada.setCodEntradaEstoque(entradaDao.getNextItem());
                entrada.setTipoEntrada(Integer.parseInt("" + model.getValueAt(i, 1)));
                entrada.setNotaFiscal("" + model.getValueAt(i, 2));
                entrada.setDataCadastro(Data.getDateSQL("" + model.getValueAt(i, 3)));
                entrada.setCodMaterial(Long.parseLong("" + model.getValueAt(i, 4)));
                entrada.setDescMaterial("" + model.getValueAt(i, 5));
                entrada.setCodFornecedor(model.getValueAt(i, 6) == null ? null : ("" + model.getValueAt(i, 6)).equals("") ? null : ValidarValor.getLong("" + model.getValueAt(i, 6)));
                entrada.setDescFornecedor("" + model.getValueAt(i, 7));
                entrada.setMetragemLinear(ValidarValor.getDouble("" + model.getValueAt(i, 8)) > 0 ? ValidarValor.getDouble("" + model.getValueAt(i, 8)) : null);
                entrada.setLargura(ValidarValor.getDouble("" + model.getValueAt(i, 9)) > 0 ? ValidarValor.getDouble("" + model.getValueAt(i, 9)) : null);
                entrada.setAltura(ValidarValor.getDouble("" + model.getValueAt(i, 10)) > 0 ? ValidarValor.getDouble("" + model.getValueAt(i, 10)) : null);
                entrada.setUnidade(ValidarValor.getDouble("" + model.getValueAt(i, 11)) > 0 ? ValidarValor.getDouble("" + model.getValueAt(i, 11)) : null);
                entrada.setPeso(ValidarValor.getDouble("" + model.getValueAt(i, 12)) > 0 ? ValidarValor.getDouble("" + model.getValueAt(i, 12)) : null);
                entrada.setLitro(ValidarValor.getDouble("" + model.getValueAt(i, 13)) > 0 ? ValidarValor.getDouble("" + model.getValueAt(i, 13)) : null);
                entrada.setValorCompra(ValidarValor.getArredondamento(ValidarValor.getDouble(("" + model.getValueAt(i, 14)))));
                entrada.setCor("" + model.getValueAt(i, 15));
                entrada.setMarca("" + model.getValueAt(i, 16));
                entrada.setDataValidade(Data.getDateSQL("" + model.getValueAt(i, 17)));
                entrada.setObservacao("" + model.getValueAt(i, 18));
                entrada.setUsuarioCadastro(ControleAcesso.usuario.getCodUsuario() + " - " + ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                entrada.setUsuarioAtualizacao(ControleAcesso.usuario.getCodUsuario() + " - " + ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                entrada.setDataAtualizacao(Data.getDateSQL());
                entrada.setCancelada(false);

                entradaDao.salvar(entrada);

            }

            JOptionPane.showMessageDialog(null, "Processamento concluído!");

            limparTelaEntrada();

            atualizarEstoque();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar entrada. Erro: " + e);
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        try {

            if (entrada == null) {
                throw new Exception("Erro: Entrada inválida!");
            } else {
                int op = JOptionPane.showConfirmDialog(this, "Deseja realmente cancelar a entrada selecionada? \n A mesma não será excluída, somente cancelada!");

                if (op == 0) {

                    entrada.setCancelada(true);
                    entradaDao.salvar(entrada);

                    JOptionPane.showMessageDialog(null, "Cancelamento concluído!");
                    limparTelaEntrada();

                    atualizarEstoque();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cancelar entrada. Erro: " + e);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed

        limparTelaEntrada();
        limparTelaSaida();
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void codMaterialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codMaterialFocusLost
        try {

            material = materialDao.getPorCodigo(ValidarValor.getLong(codMaterial.getText()));
            if (material == null) {
                descMaterial.setText("");
            } else {
                descMaterial.setText(material.getDescricao());
                habilitaCamposMedidasEntrada(material);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_codMaterialFocusLost

    private void habilitaCamposMedidasEntrada(Material m) {
        try {

            if (m == null) {

                metragemLinear.setEnabled(false);
                largura.setEnabled(false);
                altura.setEnabled(false);
                unidade.setEnabled(false);
                peso.setEnabled(false);
                litro.setEnabled(false);

                limparMedidas();

            } else {

                int u = m.getUnidadeMedida();

                switch (u) {
                    case 0:
                        //metro linear

                        metragemLinear.setEnabled(true);
                        largura.setEnabled(false);
                        altura.setEnabled(false);
                        unidade.setEnabled(false);
                        peso.setEnabled(false);
                        litro.setEnabled(false);

                        limparMedidas();

                        break;
                    case 1:
                        //metro quadrado

                        metragemLinear.setEnabled(false);
                        largura.setEnabled(true);
                        altura.setEnabled(true);
                        unidade.setEnabled(false);
                        peso.setEnabled(false);
                        litro.setEnabled(false);

                        limparMedidas();

                        break;
                    case 2:
                        //unidade

                        metragemLinear.setEnabled(false);
                        largura.setEnabled(false);
                        altura.setEnabled(false);
                        unidade.setEnabled(true);
                        peso.setEnabled(false);
                        litro.setEnabled(false);

                        limparMedidas();

                        break;

                    case 3:
                        //peso

                        metragemLinear.setEnabled(false);
                        largura.setEnabled(false);
                        altura.setEnabled(false);
                        unidade.setEnabled(false);
                        peso.setEnabled(true);
                        litro.setEnabled(false);

                        limparMedidas();

                        break;

                    case 4:
                        //litro
                        metragemLinear.setEnabled(false);
                        largura.setEnabled(false);
                        altura.setEnabled(false);
                        unidade.setEnabled(false);
                        peso.setEnabled(false);
                        litro.setEnabled(true);

                        limparMedidas();

                        break;
                    default:
                        metragemLinear.setEnabled(false);
                        largura.setEnabled(false);
                        altura.setEnabled(false);
                        unidade.setEnabled(false);
                        peso.setEnabled(false);
                        litro.setEnabled(false);

                        limparMedidas();
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void limparMedidas() {
        metragemLinear.setText("0,00");
        largura.setText("0,00");
        altura.setText("0,00");
        unidade.setText("0");
        peso.setText("0,00");
        litro.setText("0,00");
    }

    private void limparMedidasSaida() {
        metragemLinearS.setText("0,00");
        larguraS.setText("0,00");
        alturaS.setText("0,00");
        unidadeS.setText("0");
        pesoS.setText("0,00");
        litroS.setText("0,00");
    }

    private void descMaterialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descMaterialKeyReleased

        try {

            List<Material> merged = materialDao.getList(15, "select e from Material e where lower (trim(e.descricao))   like ?1 order by e.descricao asc", (descMaterial.getText().trim().toLowerCase() + "%"));
            listaMaterial.clear();
            listaMaterial.addAll(merged);
            limparMedidas();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar materials. Erro: " + e);
        }
    }//GEN-LAST:event_descMaterialKeyReleased

    private void btAddMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddMaterialActionPerformed
        try {

            material = materialDao.getPorCodigo(ValidarValor.getInt(codMaterial.getText()));

            if (codMaterial.getText().equals("") || descMaterial.getText().equals("") || material == null) {
                JOptionPane.showMessageDialog(null, "Selecione um material válido!");
                return;
            } else {

                switch (material.getUnidadeMedida()) {
                    case 0:
                        //metro linear
                        if (metragemLinear.getText().equals("0,00") || Double.parseDouble(metragemLinear.getText().replaceAll(",", ".")) <= 0) {
                            JOptionPane.showMessageDialog(null, "Informe o tamanho do material !");
                            return;
                        }

                        break;
                    case 1:
                        //metro quadrado

                        if (largura.getText().equals("0,00") || Double.parseDouble(largura.getText().replaceAll(",", ".")) <= 0 || altura.getText().equals("0,00") || Double.parseDouble(altura.getText().replaceAll(",", ".")) <= 0) {
                            JOptionPane.showMessageDialog(null, "Informe largura e altura do material !");
                            return;
                        }

                        break;
                    case 2:
                        //unidade

                        if (unidade.getText().equals("0,00") || Double.parseDouble(unidade.getText().replaceAll(",", ".")) <= 0) {
                            JOptionPane.showMessageDialog(null, "Informe a quantidade do material !");
                            return;
                        }

                        break;

                    case 3:
                        //peso
                        if (peso.getText().equals("0,00") || Double.parseDouble(peso.getText().replaceAll(",", ".")) <= 0) {
                            JOptionPane.showMessageDialog(null, "Informe o peso do material !");
                            return;
                        }
                        break;

                    case 4:
                        //litro
                        if (litro.getText().equals("0,00") || Double.parseDouble(litro.getText().replaceAll(",", ".")) <= 0) {
                            JOptionPane.showMessageDialog(null, "Informe a dosagem do material !");
                            return;
                        }
                        break;
                    default:
                        break;
                }

                DefaultTableModel model = (DefaultTableModel) tabMateriaisAddEntrada.getModel();

                Object[] os = new Object[19];
                os[0] = "";
                os[1] = tipoEntrada.getSelectedIndex();
                os[2] = notaFiscal.getText();
                os[3] = dataEntrada.getText();
                os[4] = codMaterial.getText();
                os[5] = descMaterial.getText();
                os[6] = codFornecedor.getText();
                os[7] = descFornecedor.getText();
                os[8] = (ValidarValor.getDouble(metragemLinear.getText()) > 0 ? ValidarValor.getDouble((Double.parseDouble(metragemLinear.getText().replaceAll(",", ".")))) : "");
                os[9] = (ValidarValor.getDouble(largura.getText()) > 0 ? ValidarValor.getDouble(Double.parseDouble(largura.getText().replaceAll(",", "."))) : "");
                os[10] = (ValidarValor.getDouble(altura.getText()) > 0 ? ValidarValor.getDouble(Double.parseDouble(altura.getText().replaceAll(",", "."))) : "");
                os[11] = (ValidarValor.getDouble(unidade.getText()) > 0 ? ValidarValor.getDouble(Double.parseDouble(unidade.getText().replaceAll(",", "."))) : "");
                os[12] = (ValidarValor.getDouble(peso.getText()) > 0 ? ValidarValor.getDouble3Casas(ValidarValor.getDouble(peso.getText()/*.replaceAll(",", ".")*/)) : "");
                os[13] = (ValidarValor.getDouble(litro.getText()) > 0 ? ValidarValor.getDouble3Casas(ValidarValor.getDouble(litro.getText()/*.replaceAll(",", ".")*/)) : "");
                os[14] = (ValidarValor.getDouble(valor.getText()) > 0 ? ValidarValor.getDouble(Double.parseDouble(valor.getText().replaceAll(",", "."))) : "");
                os[15] = (cor.getText());
                os[16] = (marca.getText());
                os[17] = (dataValidade.getText());
                os[18] = (observacaoEntrada.getText());

                model.addRow(os);

                msgEntrada.setVisible(true);

                limparCamposEntrada(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btAddMaterialActionPerformed

    private void limparMaterial() {
        codMaterial.setText("");
        descMaterial.setText("");
        limparMedidas();
        material = null;
    }


    private void removerMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerMaterialActionPerformed
        try {
            if (indexTabelaEntrada != null) {
                DefaultTableModel model = (DefaultTableModel) tabMateriaisAddEntrada.getModel();
                model.removeRow(indexTabelaEntrada);
                tabMateriaisAddEntrada.setModel(model);
                limparCamposEntrada(true);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }//GEN-LAST:event_removerMaterialActionPerformed

    private void tabMateriaisAddEntradaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabMateriaisAddEntradaKeyReleased

    }//GEN-LAST:event_tabMateriaisAddEntradaKeyReleased

    private void tabMateriaisAddEntradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMateriaisAddEntradaMouseClicked
        if (evt.getClickCount() > 1) {
            indexTabelaEntrada = tabMateriaisAddEntrada.getSelectedRow();

            carregaCamposEntrada(indexTabelaEntrada);
        }
    }//GEN-LAST:event_tabMateriaisAddEntradaMouseClicked

    private void carregaCamposEntrada(int i) {
        try {
            DefaultTableModel model = (DefaultTableModel) tabMateriaisAddEntrada.getModel();

            codigo.setText("" + model.getValueAt(i, 0));
            tipoEntrada.setSelectedIndex(Integer.parseInt("" + model.getValueAt(i, 1)));
            notaFiscal.setText("" + model.getValueAt(i, 2));
            dataEntrada.setText(("" + model.getValueAt(i, 3)));

            material = materialDao.getPorCodigo(Long.parseLong("" + model.getValueAt(i, 4)));

            codMaterial.setText("" + model.getValueAt(i, 4));
            descMaterial.setText("" + model.getValueAt(i, 5));

            fornecedor = fornecedorDao.get(Long.parseLong("" + model.getValueAt(i, 6)));

            codFornecedor.setText("" + model.getValueAt(i, 6));
            descFornecedor.setText("" + model.getValueAt(i, 7));

            metragemLinear.setText("" + model.getValueAt(i, 8));
            largura.setText("" + model.getValueAt(i, 9));
            altura.setText("" + model.getValueAt(i, 10));
            unidade.setText("" + model.getValueAt(i, 11));
            peso.setText("" + model.getValueAt(i, 12));
            litro.setText("" + model.getValueAt(i, 13));
            valor.setText("" + model.getValueAt(i, 14));
            cor.setText("" + model.getValueAt(i, 15));
            marca.setText("" + model.getValueAt(i, 16));
            dataValidade.setText("" + model.getValueAt(i, 17));
            observacaoEntrada.setText("" + model.getValueAt(i, 18));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    private void carregarCamposSaida(int i) {
        try {
            DefaultTableModel model = (DefaultTableModel) tabMateriaisSaida.getModel();

            codSaida.setText("" + model.getValueAt(i, 0));
            tipoSaida.setSelectedIndex(Integer.parseInt("" + model.getValueAt(i, 1)));
            codPedido.setText("" + model.getValueAt(i, 2));
            dataSaida.setText(("" + model.getValueAt(i, 3)));

            materialS = materialDao.getPorCodigo(Long.parseLong("" + model.getValueAt(i, 4)));
            codMaterialS.setText("" + model.getValueAt(i, 4));
            descMaterialS.setText("" + model.getValueAt(i, 5));

            metragemLinearS.setText("" + model.getValueAt(i, 6));
            larguraS.setText("" + model.getValueAt(i, 7));
            alturaS.setText("" + model.getValueAt(i, 8));
            unidadeS.setText("" + model.getValueAt(i, 9));
            pesoS.setText("" + model.getValueAt(i, 10));
            litroS.setText("" + model.getValueAt(i, 11));
            observacaoSaida.setText("" + model.getValueAt(i, 12));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    private void tabMateriaisAddEntradaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMateriaisAddEntradaMouseExited

    }//GEN-LAST:event_tabMateriaisAddEntradaMouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            Map parametros = null;
            // if (produto != null) {

            String sql = "";

            new VisualizaRelatorio().visRel("graficaatual/relatorios/arquivos/produto.jasper", "RELATÓRIO DE PRODUTOS (INDIVIDUAL)", parametros, sql);
            //   } else {
            //       JOptionPane.showMessageDialog(null, "Selecione um produto!");
            //   }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório de produtos! \n " + e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void dataEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataEntradaActionPerformed

    private void valorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorActionPerformed

    private void codSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codSaidaActionPerformed
        try {
            saida = saidaDao.getPorCodigo(ValidarValor.getLong(codSaida.getText()));
            if (saida != null) {
                carregarCamposSaida();
            } else {
                limparCamposSaida(false);
                habilitaCamposSaida(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_codSaidaActionPerformed

    private void dataSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataSaidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataSaidaActionPerformed

    private void codMaterialSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codMaterialSActionPerformed

    }//GEN-LAST:event_codMaterialSActionPerformed

    private Boolean temEntradaDoMaterial(Long cod) {
        Boolean temEntrada = false;
        try {
            List<EntradaEstoque> lista = entradaDao.getListPorMaterial(cod);

            if (lista != null && lista.size() > 0) {
                temEntrada = true;
            } else {
                temEntrada = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            temEntrada = false;
        }
        return temEntrada;
    }

    private void habilitaCamposMedidasSaida(Material m) {
        try {

            if (m == null) {

                metragemLinearS.setEnabled(false);
                larguraS.setEnabled(false);
                alturaS.setEnabled(false);
                unidadeS.setEnabled(false);
                pesoS.setEnabled(false);
                litroS.setEnabled(false);

                limparMedidasSaida();

            } else {

                int u = m.getUnidadeMedida();

                switch (u) {
                    case 0:
                        //metro linear

                        metragemLinearS.setEnabled(true);
                        larguraS.setEnabled(false);
                        alturaS.setEnabled(false);
                        unidadeS.setEnabled(false);
                        pesoS.setEnabled(false);
                        litroS.setEnabled(false);

                        limparMedidasSaida();

                        break;
                    case 1:
                        //metro quadrado

                        metragemLinearS.setEnabled(false);
                        larguraS.setEnabled(true);
                        alturaS.setEnabled(true);
                        unidadeS.setEnabled(false);
                        pesoS.setEnabled(false);
                        litroS.setEnabled(false);

                        limparMedidasSaida();

                        break;
                    case 2:
                        //unidade

                        metragemLinearS.setEnabled(false);
                        larguraS.setEnabled(false);
                        alturaS.setEnabled(false);
                        unidadeS.setEnabled(true);
                        pesoS.setEnabled(false);
                        litroS.setEnabled(false);

                        limparMedidasSaida();

                        break;

                    case 3:
                        //peso

                        metragemLinearS.setEnabled(false);
                        larguraS.setEnabled(false);
                        alturaS.setEnabled(false);
                        unidadeS.setEnabled(false);
                        pesoS.setEnabled(true);
                        litroS.setEnabled(false);

                        limparMedidasSaida();

                        break;

                    case 4:
                        //litro
                        metragemLinearS.setEnabled(false);
                        larguraS.setEnabled(false);
                        alturaS.setEnabled(false);
                        unidadeS.setEnabled(false);
                        pesoS.setEnabled(false);
                        litroS.setEnabled(true);

                        limparMedidasSaida();

                        break;
                    default:
                        metragemLinearS.setEnabled(false);
                        larguraS.setEnabled(false);
                        alturaS.setEnabled(false);
                        unidadeS.setEnabled(false);
                        pesoS.setEnabled(false);
                        litroS.setEnabled(false);

                        limparMedidasSaida();
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void descMaterialSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descMaterialSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descMaterialSActionPerformed

    private void tipoSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoSaidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoSaidaActionPerformed

    private void tabMateriaisSaidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMateriaisSaidaMouseClicked
        if (evt.getClickCount() > 1) {
            indexTabelaSaida = tabMateriaisSaida.getSelectedRow();

            carregarCamposSaida(indexTabelaSaida);
        }
    }//GEN-LAST:event_tabMateriaisSaidaMouseClicked

    private void tabMateriaisSaidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMateriaisSaidaMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tabMateriaisSaidaMouseExited

    private void tabMateriaisSaidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabMateriaisSaidaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tabMateriaisSaidaKeyReleased

    private void tabelaEstoqueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaEstoqueKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaEstoqueKeyReleased

    private void tabelaEstoqueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEstoqueMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaEstoqueMouseExited

    private void tabelaEstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEstoqueMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaEstoqueMouseClicked

    private void codigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoFocusLost
        try {
            entrada = entradaDao.getPorCodigo(ValidarValor.getLong(codigo.getText()));
            if (entrada != null) {
                carregarCamposEntrada();
            } else {
                limparCamposEntrada(false);
                habilitaCamposEntrada(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_codigoFocusLost

    private void btNovoSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoSActionPerformed
        try {

            limparTelaSaida();
            codSaida.setText("" + saidaDao.getNextItem());
            saida = new SaidaEstoque();
            tipoSaida.requestFocus();
            dataSaida.setText(Data.getDateParse(new Date(), "dd/MM/yyyy"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btNovoSActionPerformed

    private void observacaoEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_observacaoEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_observacaoEntradaActionPerformed

    private void tipoSaidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoSaidaItemStateChanged
        if (tipoSaida.getSelectedIndex() == 0) {
            codPedido.setEnabled(true);
        } else {
            codPedido.setEnabled(false);
        }
    }//GEN-LAST:event_tipoSaidaItemStateChanged

    private void descMaterialSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descMaterialSKeyReleased
        //   if (temEntradaDoMaterial(ValidarValor.getLong(codMaterialS.getText()))) {

        try {
            List<Material> merged = materialDao.getList(15, "select e from Material e where lower (trim(e.descricao))   like ?1 order by e.descricao asc", (descMaterial.getText().trim().toLowerCase() + "%"));
            listaMaterialS.clear();
            listaMaterialS.addAll(merged);
            limparMedidas();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar materials. Erro: " + e);
        }
        // } else {
        //     JOptionPane.showMessageDialog(null, "Não existe entrada deste material no estoque, \n portanto não é possível lançar uma saída!");
        // }
    }//GEN-LAST:event_descMaterialSKeyReleased

    private void btAddMaterialSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddMaterialSActionPerformed
        try {

            materialS = materialDao.getPorCodigo(ValidarValor.getInt(codMaterialS.getText()));

            if (codMaterialS.getText().equals("") || descMaterialS.getText().equals("") || materialS == null) {
                JOptionPane.showMessageDialog(null, "Selecione um material válido!");
                return;
            } /*   criar função pra ver se o material tem estoque
            else if () {
               JOptionPane.showMessageDialog(null, "Não existe entrada deste material no estoque, \n portanto não é possível lançar uma saída!");
                       return;
           
            }
             */ else {

                switch (materialS.getUnidadeMedida()) {
                    case 0:
                        //metro linear
                        if (metragemLinearS.getText().equals("0,00") || Double.parseDouble(metragemLinearS.getText().replaceAll(",", ".")) <= 0) {
                            JOptionPane.showMessageDialog(null, "Informe o tamanho do material !");
                            return;
                        }

                        break;
                    case 1:
                        //metro quadrado

                        if (larguraS.getText().equals("0,00") || Double.parseDouble(larguraS.getText().replaceAll(",", ".")) <= 0 || altura.getText().equals("0,00") || Double.parseDouble(altura.getText().replaceAll(",", ".")) <= 0) {
                            JOptionPane.showMessageDialog(null, "Informe largura e altura do material !");
                            return;
                        }

                        break;
                    case 2:
                        //unidade

                        if (unidadeS.getText().equals("0,00") || Double.parseDouble(unidadeS.getText().replaceAll(",", ".")) <= 0) {
                            JOptionPane.showMessageDialog(null, "Informe a quantidade do material !");
                            return;
                        }

                        break;

                    case 3:
                        //peso
                        if (pesoS.getText().equals("0,00") || Double.parseDouble(pesoS.getText().replaceAll(",", ".")) <= 0) {
                            JOptionPane.showMessageDialog(null, "Informe o peso do material !");
                            return;
                        }
                        break;

                    case 4:
                        //litro
                        if (litroS.getText().equals("0,00") || Double.parseDouble(litroS.getText().replaceAll(",", ".")) <= 0) {
                            JOptionPane.showMessageDialog(null, "Informe a dosagem do material !");
                            return;
                        }
                        break;
                    default:
                        break;
                }

                DefaultTableModel model = (DefaultTableModel) tabMateriaisSaida.getModel();

                Object[] os = new Object[13];

                os[0] = "";
                os[1] = tipoSaida.getSelectedIndex();
                os[2] = codPedido.getText();
                os[3] = dataSaida.getText();
                os[4] = codMaterialS.getText();
                os[5] = descMaterialS.getText();
                os[6] = (ValidarValor.getDouble(metragemLinearS.getText()) > 0 ? ValidarValor.getDouble((Double.parseDouble(metragemLinearS.getText().replaceAll(",", ".")))) : "");
                os[7] = (ValidarValor.getDouble(larguraS.getText()) > 0 ? ValidarValor.getDouble(Double.parseDouble(larguraS.getText().replaceAll(",", "."))) : "");
                os[8] = (ValidarValor.getDouble(alturaS.getText()) > 0 ? ValidarValor.getDouble(Double.parseDouble(alturaS.getText().replaceAll(",", "."))) : "");
                os[9] = (ValidarValor.getDouble(unidadeS.getText()) > 0 ? ValidarValor.getDouble(Double.parseDouble(unidadeS.getText().replaceAll(",", "."))) : "");
                os[10] = (ValidarValor.getDouble(pesoS.getText()) > 0 ? ValidarValor.getDouble3Casas(ValidarValor.getDouble(pesoS.getText()/*.replaceAll(",", ".")*/)) : "");
                os[11] = (ValidarValor.getDouble(litroS.getText()) > 0 ? ValidarValor.getDouble3Casas(ValidarValor.getDouble(litroS.getText()/*.replaceAll(",", ".")*/)) : "");
                os[12] = (observacaoSaida.getText());

                model.addRow(os);

                msgSaida.setVisible(true);

                limparCamposSaida(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btAddMaterialSActionPerformed

    private void removerMaterialSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerMaterialSActionPerformed
        if (indexTabelaSaida != null) {
            DefaultTableModel model = (DefaultTableModel) tabMateriaisSaida.getModel();
            model.removeRow(indexTabelaSaida);
            tabMateriaisSaida.setModel(model);
            limparCamposSaida(true);
        }
    }//GEN-LAST:event_removerMaterialSActionPerformed

    private void btSalvarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarSActionPerformed

        try {

            DefaultTableModel model = (DefaultTableModel) tabMateriaisSaida.getModel();

            for (int i = 0; i < model.getRowCount(); i++) {

                //      SaidaEstoque e = saidaDao.getPorCodigo(Long.parseLong("" + (model.getValueAt(i, 0) == null ? 0 : model.getValueAt(i, 0).equals("") ? 0 : (model.getValueAt(i, 0)))));
                //     if (e == null) {
                saida = new SaidaEstoque();

                saida.setCodSaidaEstoque(saidaDao.getNextItem());
                saida.setTipoSaida(Integer.parseInt("" + model.getValueAt(i, 1)));
                saida.setNumeroPedido(model.getValueAt(i, 2) == null ? null : ("" + model.getValueAt(i, 2)).equals("") ? null : Integer.parseInt("" + model.getValueAt(i, 2)));
                saida.setDataCadastro(Data.getDateSQL("" + model.getValueAt(i, 3)));
                saida.setCodMaterial(Long.parseLong("" + model.getValueAt(i, 4)));
                saida.setDescMaterial("" + model.getValueAt(i, 5));
                saida.setMetragemLinear(ValidarValor.getDouble("" + model.getValueAt(i, 6)) > 0 ? ValidarValor.getDouble("" + model.getValueAt(i, 6)) : null);
                saida.setLargura(ValidarValor.getDouble("" + model.getValueAt(i, 7)) > 0 ? ValidarValor.getDouble("" + model.getValueAt(i, 7)) : null);
                saida.setAltura(ValidarValor.getDouble("" + model.getValueAt(i, 8)) > 0 ? ValidarValor.getDouble("" + model.getValueAt(i, 8)) : null);
                saida.setUnidade(ValidarValor.getDouble("" + model.getValueAt(i, 9)) > 0 ? ValidarValor.getDouble("" + model.getValueAt(i, 9)) : null);
                saida.setPeso(ValidarValor.getDouble("" + model.getValueAt(i, 10)) > 0 ? ValidarValor.getDouble("" + model.getValueAt(i, 10)) : null);
                saida.setLitro(ValidarValor.getDouble("" + model.getValueAt(i, 11)) > 0 ? ValidarValor.getDouble("" + model.getValueAt(i, 11)) : null);
                saida.setObservacao("" + model.getValueAt(i, 12));
                saida.setUsuarioCadastro(ControleAcesso.usuario.getCodUsuario() + " - " + ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                saida.setUsuarioAtualizacao(ControleAcesso.usuario.getCodUsuario() + " - " + ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                saida.setDataAtualizacao(Data.getDateSQL());
                saida.setCancelada(false);

                saidaDao.salvar(saida);

                //   } else {
                //       saida = e;
                //      JOptionPane.showMessageDialog(null, "Saída de material já existe e não pode ser alterada. \n A mesma não será salva!");
                //   }
            }

            JOptionPane.showMessageDialog(null, "Processamento concluído!");

            limparTelaSaida();

            atualizarEstoque();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar saída de material. Erro: " + e);
        }
    }//GEN-LAST:event_btSalvarSActionPerformed

    private void btExcluirSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirSActionPerformed
        try {
            EntityManager session = Persistencia.getInstance().getSessionComBegin();

            if (saida == null) {
                throw new Exception("Erro: Saída inválida!");
            } else {
                int op = JOptionPane.showConfirmDialog(this, "Deseja realmente cancelar a saída selecionada? \n A mesma não será excluída, somente cancelada!");

                if (op == 0) {

                    saida.setCancelada(true);
                    saidaDao.salvar(saida);

                    JOptionPane.showMessageDialog(null, "Cancelamento concluído!");
                    limparTelaSaida();

                    atualizarEstoque();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cancelar saída. Erro: " + e);
        }
    }//GEN-LAST:event_btExcluirSActionPerformed

    private void btSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSair1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSair1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void descFornecedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descFornecedorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_descFornecedorKeyReleased

    private void codFornecedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codFornecedorFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_codFornecedorFocusLost

    private void btAddMaterial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddMaterial1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAddMaterial1ActionPerformed

    private void codMaterialSFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codMaterialSFocusLost
        try {

            System.out.println("Teste entrou");

            materialS = materialDao.getPorCodigo(ValidarValor.getLong(codMaterialS.getText()));
            if (materialS == null) {
                descMaterialS.setText("");
            } else {
                descMaterialS.setText(materialS.getDescricao());
                habilitaCamposMedidasSaida(materialS);

                System.out.println("Teste, achou material: " + material.getDescricao());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_codMaterialSFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            atualizarEstoque();

            if (listaAbaixoMinimo != null && listaAbaixoMinimo.size() > 0) {

                JOptionPane.showMessageDialog(null, "Atenção! \n Há materiais com estoque abaixo da quantidade mínima!"
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void carregarCamposEntrada() {
        try {
            codigo.setText("" + entrada.getCodEntradaEstoque());

            tipoEntrada.setSelectedIndex(entrada.getTipoEntrada());
            notaFiscal.setText(entrada.getNotaFiscal());
            dataEntrada.setText("" + entrada.getDataCadastro());
            valor.setText(ValidarValor.getDouble(entrada.getValorCompra()));

            fornecedor = fornecedorDao.get(entrada.getCodFornecedor());
            if (fornecedor != null) {
                codFornecedor.setText("" + fornecedor.getCodFornecedor());
                descFornecedor.setText(fornecedor.getPessoa().getNome());
            } else {
                codFornecedor.setText("");
                descFornecedor.setText("");
            }

            material = materialDao.getPorCodigo(entrada.getCodMaterial());
            if (material != null) {
                codMaterial.setText("" + material.getCodMaterial());
                descMaterial.setText(material.getDescricao());
            } else {
                codMaterial.setText("");
                descMaterial.setText("");
            }
            observacaoEntrada.setText("" + entrada.getObservacao());

            metragemLinear.setText(entrada.getMetragemLinear() == null ? "0,00" : ValidarValor.getDouble(entrada.getMetragemLinear()));
            largura.setText(entrada.getLargura() == null ? "0,00" : ValidarValor.getDouble(entrada.getLargura()));
            altura.setText(entrada.getAltura() == null ? "0,00" : ValidarValor.getDouble(entrada.getAltura()));
            unidade.setText(entrada.getUnidade() == null ? "0,00" : ValidarValor.getDouble(entrada.getUnidade()));
            peso.setText(entrada.getPeso() == null ? "0,00" : ValidarValor.getDouble(entrada.getPeso()));
            litro.setText(entrada.getLitro() == null ? "0,00" : ValidarValor.getDouble(entrada.getLitro()));
            cor.setText("" + entrada.getCor());
            marca.setText("" + entrada.getMarca());
            dataValidade.setText(entrada.getDataValidade() != null ? Data.getDateParse(entrada.getDataValidade(), "dd/MM/yyyy") : "");

            habilitaCamposEntrada(false);

            if (entrada.isCancelada()) {
                labelCancelada.setVisible(true);
                btSalvar.setEnabled(false);
                btExcluir.setEnabled(false);
                btAddMaterial.setEnabled(false);
                removerMaterial.setEnabled(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void habilitaCamposEntrada(Boolean b) {

        tipoEntrada.setEnabled(b);
        notaFiscal.setEnabled(b);
        dataEntrada.setEnabled(b);
        valor.setEnabled(b);
        codFornecedor.setEnabled(b);
        descFornecedor.setEnabled(b);
        codMaterial.setEnabled(b);
        descMaterial.setEnabled(b);
        observacaoEntrada.setEnabled(b);
        metragemLinear.setEnabled(b);
        largura.setEnabled(b);
        altura.setEnabled(b);
        unidade.setEnabled(b);
        peso.setEnabled(b);
        litro.setEnabled(b);
        cor.setEnabled(b);
        marca.setEnabled(b);
        dataValidade.setEnabled(b);
    }

    private void carregarCamposSaida() {
        try {
            codSaida.setText("" + saida.getCodSaidaEstoque());

            tipoSaida.setSelectedIndex(saida.getTipoSaida());
            dataSaida.setText("" + saida.getDataCadastro());

            materialS = materialDao.getPorCodigo(saida.getCodMaterial());
            if (material != null) {
                codMaterialS.setText("" + materialS.getCodMaterial());
                descMaterialS.setText(materialS.getDescricao());
            } else {
                codMaterialS.setText("");
                descMaterialS.setText("");
            }
            observacaoSaida.setText("" + saida.getObservacao());

            metragemLinearS.setText(saida.getMetragemLinear() == null ? "0,00" : "" + saida.getMetragemLinear());
            larguraS.setText(saida.getLargura() == null ? "0,00" : "" + saida.getLargura());
            alturaS.setText(saida.getAltura() == null ? "0,00" : "" + saida.getAltura());
            unidadeS.setText(saida.getUnidade() == null ? "0,00" : "" + saida.getUnidade());
            pesoS.setText(saida.getPeso() == null ? "0,00" : "" + saida.getPeso());
            litroS.setText(saida.getLitro() == null ? "0,00" : "" + saida.getLitro());

            habilitaCamposSaida(false);

            if (saida.isCancelada()) {
                labelCancelada1.setVisible(true);
                btSalvarS.setEnabled(false);
                btExcluirS.setEnabled(false);
                btAddMaterialS.setEnabled(false);
                removerMaterialS.setEnabled(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void habilitaCamposSaida(Boolean b) {
        tipoSaida.setEnabled(b);
        dataSaida.setEnabled(b);
        codMaterialS.setEnabled(b);
        descMaterialS.setEnabled(b);
        observacaoSaida.setEnabled(b);
        metragemLinearS.setEnabled(b);
        larguraS.setEnabled(b);
        alturaS.setEnabled(b);
        unidadeS.setEnabled(b);
        pesoS.setEnabled(b);
        litroS.setEnabled(b);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField altura;
    private javax.swing.JTextField alturaS;
    private javax.swing.JButton btAddMaterial;
    private javax.swing.JButton btAddMaterial1;
    private javax.swing.JButton btAddMaterialS;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btExcluirS;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btNovoS;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSair1;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btSalvarS;
    private javax.swing.JTextField codFornecedor;
    private javax.swing.JTextField codMaterial;
    private javax.swing.JTextField codMaterialS;
    private javax.swing.JTextField codPedido;
    private javax.swing.JTextField codSaida;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField cor;
    private javax.swing.JTextField dataEntrada;
    private javax.swing.JTextField dataSaida;
    private javax.swing.JTextField dataValidade;
    private javax.swing.JTextField descFornecedor;
    private javax.swing.JTextField descMaterial;
    private javax.swing.JTextField descMaterialS;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
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
    private javax.swing.JTextField jTextField65;
    private javax.swing.JTextField jTextField66;
    private javax.swing.JTextField jTextField67;
    private javax.swing.JTextField jTextField68;
    private javax.swing.JTextField jTextField69;
    private javax.swing.JTextField jTextField70;
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
    private javax.swing.JLabel labelCancelada;
    private javax.swing.JLabel labelCancelada1;
    private javax.swing.JTextField largura;
    private javax.swing.JTextField larguraS;
    private javax.swing.JTextField litro;
    private javax.swing.JTextField litroS;
    private javax.swing.JTextField marca;
    private javax.swing.JTextField metragemLinear;
    private javax.swing.JTextField metragemLinearS;
    private javax.swing.JLabel msgEntrada;
    private javax.swing.JLabel msgSaida;
    private javax.swing.JTextField notaFiscal;
    private javax.swing.JTextField observacaoEntrada;
    private javax.swing.JTextField observacaoSaida;
    private javax.swing.JTextField peso;
    private javax.swing.JTextField pesoS;
    private javax.swing.JButton removerMaterial;
    private javax.swing.JButton removerMaterialS;
    private javax.swing.JTable tabMateriaisAddEntrada;
    private javax.swing.JTable tabMateriaisSaida;
    private javax.swing.JTable tabelaEstoque;
    private javax.swing.JComboBox<String> tipoEntrada;
    private javax.swing.JComboBox<String> tipoSaida;
    private javax.swing.JTextField unidade;
    private javax.swing.JTextField unidadeS;
    private javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
}