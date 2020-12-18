/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.financeiro;

import graficaatual.daos.financeiro.CaixaDAO;
import graficaatual.entidades.financeiro.Caixa;
import graficaatual.utilitarios.Componentes;
import graficaatual.utilitarios.ValidarValor;
import graficaatual.utilitarios.VisualizaRelatorio;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author User
 */
public class FCadContasAReceber extends javax.swing.JInternalFrame {

    private Caixa caixa;
    private CaixaDAO caixaDAO = new CaixaDAO();

    private List<Caixa> listaCaixa = null;

    public FCadContasAReceber() {
        initComponents();

        listaCaixa = ObservableCollections.observableList(new LinkedList<Caixa>());
        Componentes comp2 = new Componentes(listaCaixa, false, codCliente, descCliente, this, jPanel18, descCliente.getWidth(), 100);
        comp2.addCol(0, "codCaixa", "Código", 50, Integer.class.getName());
        comp2.addCol(1, "descricao", "Caixa", 200, String.class.getName());
        comp2.addCol(2, "valorInicial", "Valor Abertura", 60, String.class.getName());
        comp2.bind();

        atualizatabela();

        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

    }

    private static FCadContasAReceber instancia;
    private static FCadContasAReceber instanceCont;
    private static int initControle;

    public static int isInicializado() {
        return initControle;
    }

    public synchronized static FCadContasAReceber getInstancia() {
        if (instancia == null) {
            instancia = new FCadContasAReceber();
            initControle = 1;
        }

        return instancia;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        codCliente = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        btSair1 = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        codCentrodeCusto = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        descCentroDeCusto = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        codPlanoDeContas = new javax.swing.JTextField();
        descPlanoDeContas = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        valorAPagar = new javax.swing.JTextField();
        dataPagamento = new javax.swing.JFormattedTextField();
        jLabel86 = new javax.swing.JLabel();
        valorPago = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        codFormaPagamento = new javax.swing.JTextField();
        descFormaPagamento = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        obs = new javax.swing.JTextArea();
        jLabel89 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setPreferredSize(new java.awt.Dimension(1100, 700));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setMinimumSize(new java.awt.Dimension(1100, 700));
        jPanel18.setPreferredSize(new java.awt.Dimension(1100, 700));
        jPanel18.setLayout(null);

        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel78.setText("Cliente");
        jPanel18.add(jLabel78);
        jLabel78.setBounds(110, 70, 140, 20);

        descCliente.setBackground(new java.awt.Color(255, 255, 204));
        descCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descClienteKeyReleased(evt);
            }
        });
        jPanel18.add(descCliente);
        descCliente.setBounds(110, 90, 930, 20);

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
        btNovo.setBounds(70, 330, 180, 40);

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar2.png"))); // NOI18N
        btSalvar.setText("Salvar/Atualizar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel18.add(btSalvar);
        btSalvar.setBounds(250, 330, 180, 40);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excuir2.png"))); // NOI18N
        btExcluir.setText("Deletar");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel18.add(btExcluir);
        btExcluir.setBounds(430, 330, 180, 40);

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir2.png"))); // NOI18N
        btSair.setText("Imprimir");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel18.add(btSair);
        btSair.setBounds(610, 330, 180, 40);

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cliente", "Valor a Pagar", "Valor Pago"
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
        jScrollPane11.setBounds(20, 400, 1020, 250);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONTAS A RECEBER");
        jPanel18.add(jLabel1);
        jLabel1.setBounds(0, 0, 1100, 70);

        codCliente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codClienteFocusLost(evt);
            }
        });
        jPanel18.add(codCliente);
        codCliente.setBounds(20, 90, 90, 20);

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
        btSair1.setBounds(790, 330, 180, 40);

        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel81.setText("Código");
        jPanel18.add(jLabel81);
        jLabel81.setBounds(530, 120, 80, 20);

        codCentrodeCusto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codCentrodeCusto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codCentrodeCustoFocusLost(evt);
            }
        });
        jPanel18.add(codCentrodeCusto);
        codCentrodeCusto.setBounds(530, 140, 90, 20);

        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel79.setText("Centro de Custo");
        jPanel18.add(jLabel79);
        jLabel79.setBounds(620, 120, 140, 20);

        descCentroDeCusto.setBackground(new java.awt.Color(255, 255, 204));
        descCentroDeCusto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descCentroDeCustoKeyReleased(evt);
            }
        });
        jPanel18.add(descCentroDeCusto);
        descCentroDeCusto.setBounds(620, 140, 420, 20);

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
        jLabel84.setText("Data Pagamento");
        jPanel18.add(jLabel84);
        jLabel84.setBounds(530, 170, 100, 20);

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel85.setText("Valor a Pagar");
        jPanel18.add(jLabel85);
        jLabel85.setBounds(730, 170, 80, 20);

        valorAPagar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        valorAPagar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorAPagarFocusLost(evt);
            }
        });
        jPanel18.add(valorAPagar);
        valorAPagar.setBounds(730, 190, 90, 20);
        jPanel18.add(dataPagamento);
        dataPagamento.setBounds(530, 190, 120, 20);

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
        jLabel87.setBounds(20, 220, 80, 20);

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
        jScrollPane4.setBounds(20, 240, 1010, 70);

        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel89.setText("Código");
        jPanel18.add(jLabel89);
        jLabel89.setBounds(20, 170, 80, 20);

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

    private void carregaBanco() throws Exception {
        caixa = caixaDAO.get(ValidarValor.getInt(codCliente.getText()));
        if (caixa != null) {
            descCliente.setText(caixa.getDescricao());
            
        } else {
            descCliente.setText("");
            
        }
    }


    private void descClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descClienteKeyReleased
        try {
            List<Caixa> merged = caixaDAO.getList(12,
                    "select e from Caixa e where  lower ( trim(e.descricao) ) like ?1 order by e.codCaixa",
                    descCliente.getText().trim().toLowerCase() + "%");
            listaCaixa.clear();
            listaCaixa.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Caixas. Erro: " + e);
        }
    }//GEN-LAST:event_descClienteKeyReleased

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        try {
            caixa = new Caixa();
            limpaCampos();
            habilitaCampos(true);
            descCliente.requestFocus();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        try {
            caixa = caixaDAO.get(ValidarValor.getInt(codCliente.getText()));
            if (caixa == null) {
                caixa = new Caixa();
                setCaixa();
                caixa.setDataCadastro(new Date());
                caixa.setDataAtualizacao(new Date());
                if (caixaDAO.confereCaixa(caixa)) {
                    caixa = caixaDAO.salvar(caixa);
                    codCliente.setText(caixa.getCodCaixa().toString());
                    caixa.setDataAtualizacao(new Date());
                    btSalvar.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Caixa já Cadastrado");
                }
            }
            setCaixa();
            caixaDAO.salvar(caixa);
            atualizatabela();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        try {
            caixa = caixaDAO.get(ValidarValor.getInt(codCliente.getText()));
            if (caixa == null) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um codigo válido. ");
            } else {
                setCaixa();
                caixaDAO.delete(caixa);
                limpaCampos();
                JOptionPane.showMessageDialog(this, "Exclusão realizada com sucesso");
                descCliente.requestFocus();
            }
            atualizatabela();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        try {
            String sql = "SELECT codCaixa, descricao, valorInicial "
                    + " FROM Caixa "
                    + " ORDER BY descricao asc";

            new VisualizaRelatorio().visRel("graficaatual/relatorios/arquivos/RelBancoLista.jasper", "RELATÓRIO DE CAIXAS", null, sql);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório de bancos! \n " + e);
        }
    }//GEN-LAST:event_btSairActionPerformed

    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
        try {
            if (evt.getClickCount() > 1) {
                codCliente.setText(tab.getValueAt(tab.getSelectedRow(), 0).toString());
                caixa = caixaDAO.get(ValidarValor.getInt(codCliente.getText()));
                carregaBanco();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_tabMouseClicked

    private void codClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codClienteFocusLost
        try {
            carregaBanco();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codClienteFocusLost

    private void btSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSair1ActionPerformed
        dispose();
    }//GEN-LAST:event_btSair1ActionPerformed

    private void codCentrodeCustoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codCentrodeCustoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_codCentrodeCustoFocusLost

    private void descCentroDeCustoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descCentroDeCustoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_descCentroDeCustoKeyReleased

    private void codPlanoDeContasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codPlanoDeContasFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_codPlanoDeContasFocusLost

    private void descPlanoDeContasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descPlanoDeContasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_descPlanoDeContasKeyReleased

    private void valorAPagarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorAPagarFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_valorAPagarFocusLost

    private void valorPagoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorPagoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_valorPagoFocusLost

    private void codFormaPagamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codFormaPagamentoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_codFormaPagamentoFocusLost

    private void descFormaPagamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descFormaPagamentoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_descFormaPagamentoKeyReleased

    private void limpaCampos() {
        codCliente.setText("");
        descCliente.setText("");
         
    }

    private void habilitaCampos(boolean b) {
        codCliente.setEnabled(b);
        descCliente.setEnabled(b);
        
        btSalvar.setEnabled(b);
    }

    private void setCaixa() throws Exception {

        if (descCliente.getText().length() < 2) {
            throw new Exception("Favor inserir um Caixa");
        }

  

        caixa.setDescricao(descCliente.getText());
         
    }

    public static void removeLinhas(JTable table) {
        int n = table.getRowCount();

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (int i = n - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private void atualizatabela() {
        try {
            DefaultTableModel model = (DefaultTableModel) tab.getModel();
            removeLinhas(tab);
            List<Caixa> listaT = caixaDAO.getList();
            if (listaT.size() > 0) {
                model.setNumRows(0);
                for (Caixa c : listaT) {
                    Object o[] = new Object[]{
                        c.getCodCaixa(),
                        c.getDescricao(),
                        c.getValorInicial()};

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
    private javax.swing.JTextField codCentrodeCusto;
    private javax.swing.JTextField codCliente;
    private javax.swing.JTextField codFormaPagamento;
    private javax.swing.JTextField codPlanoDeContas;
    private javax.swing.JFormattedTextField dataPagamento;
    private javax.swing.JTextField descCentroDeCusto;
    private javax.swing.JTextField descCliente;
    private javax.swing.JTextField descFormaPagamento;
    private javax.swing.JTextField descPlanoDeContas;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
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
