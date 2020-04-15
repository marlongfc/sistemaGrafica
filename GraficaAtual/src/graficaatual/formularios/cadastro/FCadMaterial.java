/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.cadastro;

import graficaatual.daos.cadastro.MaterialDAO;
import graficaatual.entidades.Material;
import graficaatual.pesq.cadastro.CnvMaterial;
import graficaatual.utilitarios.Componentes;
import graficaatual.utilitarios.ValidarValor;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Marlon
 */
public class FCadMaterial extends javax.swing.JInternalFrame {

    /**
     * Creates new form FCadMaterial
     */
    private Material material;
    private MaterialDAO materialDao = new MaterialDAO();
    private List<Material> lista = null;
    private CnvMaterial cnvMaterial = new CnvMaterial();

    private static FCadMaterial instancia;

    public static FCadMaterial getInstancia() {
        if (instancia == null) {
            instancia = new FCadMaterial();
        }

        return instancia;
    }

    public FCadMaterial() {
        initComponents();

        lista = ObservableCollections.observableList(new LinkedList<Material>());
        Componentes comp2 = new Componentes(lista, false, codMaterial, descMaterial, this, jPanel18, descMaterial.getWidth(), 100);
        comp2.addCol(0, "codMaterial", "Código", 50, Long.class.getName());
        comp2.addCol(1, "descricao", "Nome do Material", 200, String.class.getName());
        comp2.bind();

        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        limparTela();

    }

    private void limparTela() {
        codMaterial.setEnabled(true);
        codMaterial.setText("");
        precoFreteKg.setEnabled(false);
        precoFretePeca.setEnabled(false);

        limparCampos();

        atualizarTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel18 = new javax.swing.JPanel();
        codMaterial = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        descMaterial = new javax.swing.JTextField();
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
        tabMaterial = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        ultimo = new javax.swing.JButton();
        proximo = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        inicio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        altura = new javax.swing.JTextField();
        largura = new javax.swing.JTextField();
        peso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        precoFreteM2 = new javax.swing.JTextField();
        precoFreteKg = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        precoCustoCompra = new javax.swing.JTextField();
        precoCustoTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboUnidade = new javax.swing.JComboBox<>();
        precoFretePeca = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1335, 700));
        setPreferredSize(new java.awt.Dimension(1335, 700));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setMinimumSize(new java.awt.Dimension(1335, 700));
        jPanel18.setPreferredSize(new java.awt.Dimension(1335, 700));
        jPanel18.setLayout(null);

        codMaterial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codMaterialFocusLost(evt);
            }
        });
        jPanel18.add(codMaterial);
        codMaterial.setBounds(60, 90, 80, 20);

        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel78.setText("Código ");
        jPanel18.add(jLabel78);
        jLabel78.setBounds(60, 70, 60, 20);

        descMaterial.setBackground(new java.awt.Color(255, 255, 204));
        descMaterial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descMaterialKeyReleased(evt);
            }
        });
        jPanel18.add(descMaterial);
        descMaterial.setBounds(140, 90, 810, 20);

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

        btNovo.setText("Novo Cadastro");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel18.add(btNovo);
        btNovo.setBounds(140, 250, 180, 23);

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar2.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel18.add(btSalvar);
        btSalvar.setBounds(320, 250, 180, 39);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excuir2.png"))); // NOI18N
        btExcluir.setText("Deletar");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel18.add(btExcluir);
        btExcluir.setBounds(500, 250, 180, 39);

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel18.add(btSair);
        btSair.setBounds(680, 250, 180, 23);

        tabMaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Material", "Unidade", "Altura (m)", "Largura(m)", "Peso (kg)", "Preço Custo Frete", "Preço de Compra", "Preço de Custo Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tabMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMaterialMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tabMaterial);
        if (tabMaterial.getColumnModel().getColumnCount() > 0) {
            tabMaterial.getColumnModel().getColumn(0).setPreferredWidth(15);
            tabMaterial.getColumnModel().getColumn(1).setPreferredWidth(200);
            tabMaterial.getColumnModel().getColumn(2).setPreferredWidth(15);
            tabMaterial.getColumnModel().getColumn(3).setPreferredWidth(15);
            tabMaterial.getColumnModel().getColumn(4).setPreferredWidth(20);
            tabMaterial.getColumnModel().getColumn(5).setPreferredWidth(15);
            tabMaterial.getColumnModel().getColumn(6).setPreferredWidth(20);
            tabMaterial.getColumnModel().getColumn(7).setPreferredWidth(20);
            tabMaterial.getColumnModel().getColumn(8).setPreferredWidth(30);
        }

        jPanel18.add(jScrollPane11);
        jScrollPane11.setBounds(20, 300, 930, 190);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        ultimo.setText(">>||");
        ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ultimoActionPerformed(evt);
            }
        });

        proximo.setText(">>");
        proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoActionPerformed(evt);
            }
        });

        anterior.setText("<<");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        inicio.setText("||<<");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(proximo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ultimo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 36, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(anterior)
                        .addComponent(inicio))
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(proximo)
                        .addComponent(ultimo)))
                .addGap(23, 23, 23))
        );

        jPanel18.add(jPanel20);
        jPanel20.setBounds(280, 500, 430, 40);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CADASTRO DE MATERIAL");
        jPanel18.add(jLabel1);
        jLabel1.setBounds(-110, 0, 1260, 70);

        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel80.setText("Material");
        jPanel18.add(jLabel80);
        jLabel80.setBounds(140, 70, 70, 20);

        jLabel2.setText("Unidade de Medida");
        jPanel18.add(jLabel2);
        jLabel2.setBounds(60, 120, 110, 14);

        jLabel3.setText("Altura (metros)");
        jPanel18.add(jLabel3);
        jLabel3.setBounds(210, 120, 130, 14);

        jLabel4.setText("Largura (metros)");
        jPanel18.add(jLabel4);
        jLabel4.setBounds(360, 120, 100, 14);

        jLabel5.setText("Peso (Kg)");
        jPanel18.add(jLabel5);
        jLabel5.setBounds(510, 120, 80, 14);

        altura.setText("0.00");
        altura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alturaActionPerformed(evt);
            }
        });
        jPanel18.add(altura);
        altura.setBounds(210, 140, 130, 20);

        largura.setText("0.00");
        largura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                larguraActionPerformed(evt);
            }
        });
        jPanel18.add(largura);
        largura.setBounds(360, 140, 130, 20);

        peso.setText("0.00");
        peso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesoActionPerformed(evt);
            }
        });
        jPanel18.add(peso);
        peso.setBounds(510, 140, 130, 20);

        jLabel6.setText("Preço Custo Frete (m²)");
        jPanel18.add(jLabel6);
        jLabel6.setBounds(60, 170, 140, 20);

        precoFreteM2.setText("0.00");
        jPanel18.add(precoFreteM2);
        precoFreteM2.setBounds(60, 190, 130, 20);

        precoFreteKg.setText("0.00");
        jPanel18.add(precoFreteKg);
        precoFreteKg.setBounds(210, 190, 130, 20);

        jLabel7.setText("Preço Custo Frete (Kg)");
        jPanel18.add(jLabel7);
        jLabel7.setBounds(210, 170, 120, 20);

        precoCustoCompra.setText("0.00");
        precoCustoCompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                precoCustoCompraFocusLost(evt);
            }
        });
        jPanel18.add(precoCustoCompra);
        precoCustoCompra.setBounds(510, 190, 130, 20);

        precoCustoTotal.setBackground(new java.awt.Color(255, 255, 204));
        precoCustoTotal.setText("0.00");
        jPanel18.add(precoCustoTotal);
        precoCustoTotal.setBounds(660, 190, 130, 20);

        jLabel8.setText("Preço Compra");
        jPanel18.add(jLabel8);
        jLabel8.setBounds(510, 170, 100, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Preço de Custo Total");
        jPanel18.add(jLabel9);
        jLabel9.setBounds(660, 170, 120, 14);

        comboUnidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Metro (m)", "Quilo (kg)", "Peça (pc)" }));
        comboUnidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboUnidadeItemStateChanged(evt);
            }
        });
        jPanel18.add(comboUnidade);
        comboUnidade.setBounds(60, 140, 130, 20);

        precoFretePeca.setText("0.00");
        jPanel18.add(precoFretePeca);
        precoFretePeca.setBounds(360, 190, 130, 20);

        jLabel10.setText("Preço Custo Frete (pc)");
        jPanel18.add(jLabel10);
        jLabel10.setBounds(360, 170, 120, 14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1335, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codMaterialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codMaterialFocusLost
        try {
            material = materialDao.getPorCodigo(ValidarValor.getLong(codMaterial.getText()));
            if (material != null) {
                carregarCampos(material);
            } else {
                limparCampos();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_codMaterialFocusLost

    private void descMaterialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descMaterialKeyReleased
        try {
            List<Material> merged = materialDao.getList(15, "select e from Material e where 1=1 and REPLACE(REPLACE(REPLACE(trim(e.descricao),'.',''),'-',''),' ', '') "
                    + " like ?1 order by e.descricao", descMaterial.getText().trim().toLowerCase().replace(".", "").replace("-", "").trim() + "%");
            lista.clear();
            lista.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar materials. Erro: " + e);
        }
    }//GEN-LAST:event_descMaterialKeyReleased

    private void atualizarTabela() {
        try {
            DefaultTableModel model = (DefaultTableModel) tabMaterial.getModel();
            removeLinhas(tabMaterial);

            List<Material> listaAux = materialDao.getList();
            if (listaAux.size() > 0) {
                model.setNumRows(0);
                for (Material m : listaAux) {
                    Object o[] = new Object[]{
                        m.getCodMaterial(),
                        m.getDescricao()};
                    m.getUnidade();
                    m.getAltura();
                    m.getLargura();
                    m.getPeso();
                    m.getPrecoFreteMetro();
                    m.getPrecoFreteQuilo();
                    m.getPrecoFretePeca();
                    m.getPrecoCompra();
                    m.getPrecoCustoTotal();

                    model.addRow(o);
                }
            }
            tabMaterial.setModel(model);
        } catch (Exception e) {
            removeLinhas(tabMaterial);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar lista de materiais cadastrados. Erro: " + e);

        }
    }

    public static void removeLinhas(JTable table) {
        int n = table.getRowCount();

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (int i = n - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }


    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        try {
            codMaterial.setText("" + materialDao.getNextItem());
            //   codMaterial.setEnabled(false);

            limparCampos();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btNovoActionPerformed

    private void limparCampos() {
        descMaterial.setText("");
        material = null;

        comboUnidade.setSelectedIndex(0);

        altura.setText("0,00");
        largura.setText("0,00");
        peso.setText("0,00");

        precoFreteM2.setEnabled(true);
        precoFreteM2.setText("0,00");
        precoFreteKg.setEnabled(false);
        precoFreteKg.setText("0,00");
        precoFretePeca.setEnabled(false);
        precoFretePeca.setText("0,00");

        precoCustoCompra.setText("0,00");
        precoCustoTotal.setText("0,00");

    }

    private void carregarCampos(Material m) {

        if (m != null) {
            material = m;
            descMaterial.setText(m.getDescricao());
            comboUnidade.setSelectedIndex(m.getUnidade());

            altura.setText("" + m.getAltura());
            largura.setText("" + m.getLargura());
            peso.setText("" + m.getPeso());

            precoFreteM2.setEnabled(m.getUnidade() == 0);
            precoFreteM2.setText("" + m.getPrecoFreteMetro());
            precoFreteKg.setEnabled(m.getUnidade() == 1);
            precoFreteKg.setText("" + m.getPrecoFreteQuilo());
            precoFretePeca.setEnabled(m.getUnidade() == 2);
            precoFretePeca.setText("" + m.getPrecoFretePeca());

            precoCustoCompra.setText("" + m.getPrecoCompra());
            precoCustoTotal.setText("" + m.getPrecoCustoTotal());
        }
    }

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        try {
            if (material == null) {
                material = new Material();
                material.setDataCadastro(new Date());
                material.setDataAtualizacao(new Date());
            } else {
                material.setDataAtualizacao(new Date());
            }
            material.setCodMaterial(Long.parseLong(codMaterial.getText()));
            material.setDescricao(descMaterial.getText());

            material.setUnidade(comboUnidade.getSelectedIndex());

            material.setAltura(Double.parseDouble(altura.getText().replaceAll(",", ".")));
            material.setLargura(Double.parseDouble(largura.getText().replaceAll(",", ".")));
            material.setPeso(Double.parseDouble(peso.getText().replaceAll(",", ".")));

            material.setPrecoFreteMetro(Double.parseDouble(precoFreteM2.getText().replaceAll(",", ".")));
            material.setPrecoFreteQuilo(Double.parseDouble(precoFreteKg.getText().replaceAll(",", ".")));
            material.setPrecoFretePeca(Double.parseDouble(precoFretePeca.getText().replaceAll(",", ".")));
            material.setPrecoCompra(Double.parseDouble(precoCustoCompra.getText().replaceAll(",", ".")));
            material.setPrecoCustoTotal(Double.parseDouble(precoCustoTotal.getText().replaceAll(",", ".")));

            if (materialDao.salvar(material) != null) {
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            }

            codMaterial.setEnabled(true);
            atualizarTabela();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar material. Erro: " + e);
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        try {
            if (material == null) {
                throw new Exception("Erro: material inválido!");
            }
            int op = 0;
            JOptionPane.showConfirmDialog(null, "Deseja realmente excluir material selecionado?", "CONFIRMAÇÃO DE EXCLUSÃO", op);

            // considerando 0 como sim
            if (op == 0) {

                materialDao.delete(material);
                limparTela();

            } else {
                return;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir material. Erro: " + e);
        }
    }//GEN-LAST:event_btExcluirActionPerformed


    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        limparTela();
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void tabMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMaterialMouseClicked
        if (evt.getClickCount() > 1) {
            codMaterial.setText(("" + tabMaterial.getValueAt(tabMaterial.getSelectedRow(), 0)));
            codMaterialFocusLost(null);
            descMaterial.requestFocus();
        }
    }//GEN-LAST:event_tabMaterialMouseClicked

    private void ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ultimoActionPerformed
        try {
            cnvMaterial.ultimo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ultimoActionPerformed

    private void proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoActionPerformed
        try {
            cnvMaterial.proximo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_proximoActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        try {
            cnvMaterial.anterior();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_anteriorActionPerformed

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        try {
            cnvMaterial.primeiro();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_inicioActionPerformed

    private void alturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alturaActionPerformed

    private void larguraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_larguraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_larguraActionPerformed

    private void pesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesoActionPerformed

    private void comboUnidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboUnidadeItemStateChanged
        try {
            switch (comboUnidade.getSelectedIndex()) {
                case 0:
                    precoFreteM2.setEnabled(true);
                    precoFreteM2.setText("0,00");
                    precoFreteKg.setEnabled(false);
                    precoFreteKg.setText("0,00");
                    precoFretePeca.setEnabled(false);
                    precoFretePeca.setText("0,00");
                    break;
                case 1:
                    precoFreteKg.setEnabled(true);
                    precoFreteM2.setEnabled(false);
                    precoFreteM2.setText("0,00");
                    precoFretePeca.setEnabled(false);
                    precoFretePeca.setText("0,00");
                    break;
                case 2:
                    precoFretePeca.setEnabled(true);
                    precoFreteM2.setEnabled(false);
                    precoFreteM2.setText("0,00");
                    precoFreteKg.setEnabled(false);
                    precoFreteKg.setText("0,00");
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_comboUnidadeItemStateChanged

    private void precoCustoCompraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_precoCustoCompraFocusLost
        atualizaPrecoCustoTotal();
    }//GEN-LAST:event_precoCustoCompraFocusLost

    private void atualizaPrecoCustoTotal() {
        try {
            switch (comboUnidade.getSelectedIndex()) {
                case 0:
                    precoCustoTotal.setText("" + (Double.parseDouble(precoFreteM2.getText().replaceAll(",", ".")) + Double.parseDouble(precoCustoCompra.getText().replaceAll(",", "."))));
                    break;
                case 1:
                    precoCustoTotal.setText("" + (Double.parseDouble(precoFreteKg.getText().replaceAll(",", ".")) + Double.parseDouble(precoCustoCompra.getText().replaceAll(",", "."))));
                    break;
                case 2:
                    precoCustoTotal.setText("" + (Double.parseDouble(precoFretePeca.getText().replaceAll(",", ".")) + Double.parseDouble(precoCustoCompra.getText().replaceAll(",", "."))));
                    break;
                default:
                    precoCustoTotal.setText("0,00");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            precoCustoTotal.setText("0,00");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField altura;
    private javax.swing.JButton anterior;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JTextField codMaterial;
    private javax.swing.JComboBox<String> comboUnidade;
    private javax.swing.JTextField descMaterial;
    private javax.swing.JButton inicio;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
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
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JScrollPane jScrollPane11;
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
    private javax.swing.JTextField largura;
    private javax.swing.JTextField peso;
    private javax.swing.JTextField precoCustoCompra;
    private javax.swing.JTextField precoCustoTotal;
    private javax.swing.JTextField precoFreteKg;
    private javax.swing.JTextField precoFreteM2;
    private javax.swing.JTextField precoFretePeca;
    private javax.swing.JButton proximo;
    private javax.swing.JTable tabMaterial;
    private javax.swing.JButton ultimo;
    // End of variables declaration//GEN-END:variables
}
