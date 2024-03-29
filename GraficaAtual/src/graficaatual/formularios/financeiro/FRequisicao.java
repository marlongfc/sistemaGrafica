/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.financeiro;

import graficaatual.daos.financeiro.RequisicaoFinanceiraDAO;
import graficaatual.entidades.financeiro.RequisicaoFinanceira;
import graficaatual.utilitarios.Componentes;
import graficaatual.utilitarios.ValidarValor;
import graficaatual.utilitarios.VisualizaRelatorio;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Moisés
 */
public class FRequisicao extends javax.swing.JInternalFrame {

    private RequisicaoFinanceira requisicao;
    private RequisicaoFinanceiraDAO requisicaoDAO = new RequisicaoFinanceiraDAO();

    private List<RequisicaoFinanceira> listaRequisicao = null;

    public FRequisicao() {
        initComponents();

        atualizatabela();

        listaRequisicao = ObservableCollections.observableList(new LinkedList<RequisicaoFinanceira>());
        Componentes comp2 = new Componentes(listaRequisicao, false, codRequisicao, descRequisicao, this, jPanel18, descRequisicao.getWidth(), 100);
        comp2.addCol(0, "codRequisicao", "Código", 50, Integer.class.getName());
        comp2.addCol(1, "descricao", "Requisição", 200, String.class.getName());
        comp2.bind();

        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

    }

    private static FRequisicao instancia;
    private static FRequisicao instanceCont;
    private static int initControle;

    public static int isInicializado() {
        return initControle;
    }

    public synchronized static FRequisicao getInstancia() {
        if (instancia == null) {
            instancia = new FRequisicao();
            initControle = 1;
        }

        return instancia;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel18 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        descRequisicao = new javax.swing.JTextField();
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
        codRequisicao = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        valorUnit = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        quantidade = new javax.swing.JTextField();
        btSair1 = new javax.swing.JButton();
        jLabel83 = new javax.swing.JLabel();
        valorTotal = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setPreferredSize(new java.awt.Dimension(1100, 700));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setMinimumSize(new java.awt.Dimension(1100, 700));
        jPanel18.setLayout(null);

        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel78.setText("Requisição");
        jPanel18.add(jLabel78);
        jLabel78.setBounds(140, 70, 290, 20);

        descRequisicao.setBackground(new java.awt.Color(255, 255, 204));
        descRequisicao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descRequisicaoKeyReleased(evt);
            }
        });
        jPanel18.add(descRequisicao);
        descRequisicao.setBounds(140, 90, 910, 20);

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
        btNovo.setBounds(110, 200, 180, 40);

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar2.png"))); // NOI18N
        btSalvar.setText("Salvar/Atualizar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel18.add(btSalvar);
        btSalvar.setBounds(290, 200, 180, 40);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excuir2.png"))); // NOI18N
        btExcluir.setText("Deletar");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel18.add(btExcluir);
        btExcluir.setBounds(470, 200, 180, 40);

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir2.png"))); // NOI18N
        btSair.setText("Imprimir");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel18.add(btSair);
        btSair.setBounds(650, 200, 180, 40);

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Quantidade", "Requisição", "Valor Unitário (R$)", "Valor Total (R$)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tab);
        if (tab.getColumnModel().getColumnCount() > 0) {
            tab.getColumnModel().getColumn(0).setPreferredWidth(70);
            tab.getColumnModel().getColumn(1).setPreferredWidth(100);
            tab.getColumnModel().getColumn(2).setPreferredWidth(700);
            tab.getColumnModel().getColumn(3).setPreferredWidth(150);
            tab.getColumnModel().getColumn(4).setPreferredWidth(150);
        }

        jPanel18.add(jScrollPane11);
        jScrollPane11.setBounds(20, 280, 1050, 310);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REQUISIÇÃO DE RETIRADA");
        jPanel18.add(jLabel1);
        jLabel1.setBounds(0, 0, 1130, 70);

        codRequisicao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codRequisicao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codRequisicaoFocusLost(evt);
            }
        });
        jPanel18.add(codRequisicao);
        codRequisicao.setBounds(20, 90, 120, 20);

        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel80.setText("Código");
        jPanel18.add(jLabel80);
        jLabel80.setBounds(20, 70, 80, 20);

        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel81.setText("Valor Unitário (R$)");
        jPanel18.add(jLabel81);
        jLabel81.setBounds(140, 120, 120, 20);

        valorUnit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorUnitFocusLost(evt);
            }
        });
        jPanel18.add(valorUnit);
        valorUnit.setBounds(140, 140, 120, 20);

        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel82.setText("Quantidade");
        jPanel18.add(jLabel82);
        jLabel82.setBounds(20, 120, 110, 20);

        quantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                quantidadeFocusLost(evt);
            }
        });
        jPanel18.add(quantidade);
        quantidade.setBounds(20, 140, 80, 20);

        btSair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAIR2.png"))); // NOI18N
        btSair1.setText("Sair");
        btSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSair1ActionPerformed(evt);
            }
        });
        jPanel18.add(btSair1);
        btSair1.setBounds(830, 200, 180, 40);

        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel83.setText("Valor Total (R$)");
        jPanel18.add(jLabel83);
        jLabel83.setBounds(290, 120, 130, 20);

        valorTotal.setEnabled(false);
        valorTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorTotalFocusLost(evt);
            }
        });
        jPanel18.add(valorTotal);
        valorTotal.setBounds(290, 140, 120, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1335, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregaRequisicao() throws Exception {

        requisicao = requisicaoDAO.get(ValidarValor.getInt(codRequisicao.getText()));
        if (requisicao != null) {
            descRequisicao.setText(requisicao.getDescricao());
            valorUnit.setText(ValidarValor.getDouble(requisicao.getValorUnitario()));
            quantidade.setText(requisicao.getQuantidade().toString());
            valorTotal.setText(ValidarValor.getDouble(requisicao.getValorTotal()));
        } else {
            descRequisicao.setText("");
            valorUnit.setText("");
            quantidade.setText("");
            valorTotal.setText("");
        }

    }


    private void descRequisicaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descRequisicaoKeyReleased
        try {
            List<RequisicaoFinanceira> merged = requisicaoDAO.getList(12,
                    "select e from RequisicaoFinanceira e where  lower ( trim(e.descricao) ) like ?1 order by e.codRequisicao",
                    descRequisicao.getText().trim().toLowerCase() + "%");
            listaRequisicao.clear();
            listaRequisicao.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Requisições. Erro: " + e);
        }

    }//GEN-LAST:event_descRequisicaoKeyReleased

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        try {
            requisicao = new RequisicaoFinanceira();
            limpaCampos();
            habilitaCampos(true);
            descRequisicao.requestFocus();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        try {
            requisicao = requisicaoDAO.get(ValidarValor.getInt(codRequisicao.getText()));
            if (requisicao == null) {
                requisicao = new RequisicaoFinanceira();
                setRequisicao();
                requisicao.setDataCadastro(new Date());
                requisicao.setDataAtualizacao(new Date());
                if (requisicaoDAO.confereRequisicao(requisicao)) {
                    requisicao = requisicaoDAO.salvar(requisicao);
                    codRequisicao.setText(requisicao.getCodRequisicao().toString());
                    requisicao.setDataAtualizacao(new Date());
                    btSalvar.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Requisição já Cadastrada");
                }
            }
            setRequisicao();
            requisicaoDAO.salvar(requisicao);
            atualizatabela();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        try {
            requisicao = requisicaoDAO.get(ValidarValor.getInt(codRequisicao.getText()));
            if (requisicao == null) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um codigo válido. ");
            } else {
                setRequisicao();
                requisicaoDAO.delete(requisicao);
                limpaCampos();
                JOptionPane.showMessageDialog(this, "Exclusão realizada com sucesso");
                descRequisicao.requestFocus();
            }
            atualizatabela();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        try {

            if (codRequisicao.getText() == null || codRequisicao.getText().isEmpty()) {
                throw new Exception("Favor inserir um Valor válido");
            } else {

                String sql = "SELECT codRequisicao, descricao, valorUnitario,valorTotal,quantidade, quantidade "
                        + " FROM requisicaofinanceira "
                        + " WHERE codRequisicao = " + codRequisicao.getText()
                        + " ORDER BY descricao asc";

                new VisualizaRelatorio().visRel("graficaatual/relatorios/arquivos/RelRequisicaoFinanceira.jasper", "Requisição Financeira", null, sql);

            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório de Requisição! \n " + e);
        }
    }//GEN-LAST:event_btSairActionPerformed

    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
        try {
            if (evt.getClickCount() > 1) {
                codRequisicao.setText(tab.getValueAt(tab.getSelectedRow(), 0).toString());
                requisicao = requisicaoDAO.get(ValidarValor.getInt(codRequisicao.getText()));
                carregaRequisicao();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tabMouseClicked

    private void codRequisicaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codRequisicaoFocusLost
        try {
            carregaRequisicao();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codRequisicaoFocusLost

    private void valorUnitFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorUnitFocusLost
        if (quantidade.getText() != null) {
            valorTotal.setText(ValidarValor.getDouble(ValidarValor.getDouble(quantidade.getText()) * ValidarValor.getDouble(valorUnit.getText())));
        }
    }//GEN-LAST:event_valorUnitFocusLost

    private void quantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantidadeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_quantidadeFocusLost

    private void btSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSair1ActionPerformed
        dispose();
    }//GEN-LAST:event_btSair1ActionPerformed

    private void valorTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorTotalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_valorTotalFocusLost

    private void limpaCampos() {
        codRequisicao.setText("");
        descRequisicao.setText("");
        valorUnit.setText("");
        quantidade.setText("");
        valorTotal.setText("");
    }

    private void habilitaCampos(boolean b) {
        codRequisicao.setEnabled(b);
        descRequisicao.setEnabled(b);
        valorUnit.setEnabled(b);
        quantidade.setEnabled(b);
        valorTotal.setEnabled(b);
        btSalvar.setEnabled(b);
    }

    private void setRequisicao() throws Exception {

        if (descRequisicao.getText().length() < 2) {
            throw new Exception("Favor inserir uma Requisição");
        }

        if (quantidade.getText().length() < 0) {
            throw new Exception("Favor inserir uma Quantidade válida");
        }

        if (valorUnit.getText().length() < 0) {
            throw new Exception("Favor inserir um Valor válido");
        }

        requisicao.setDescricao(descRequisicao.getText());
        requisicao.setValorUnitario(ValidarValor.getBigD(valorUnit.getText()));
        requisicao.setQuantidade(ValidarValor.getInt(quantidade.getText()));
        requisicao.setValorTotal(ValidarValor.getDouble(valorTotal.getText()));
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

            List<RequisicaoFinanceira> listaT = requisicaoDAO.getList();
            if (listaT.size() > 0) {
                model.setNumRows(0);
                for (RequisicaoFinanceira r : listaT) {
                    Object o[] = new Object[]{
                        r.getCodRequisicao(),
                        r.getQuantidade(),
                        r.getDescricao(),
                        r.getValorUnitario(),
                        r.getValorTotal()};

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
    private javax.swing.JTextField codRequisicao;
    private javax.swing.JTextField descRequisicao;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
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
    private javax.swing.JTextField quantidade;
    private javax.swing.JTable tab;
    private javax.swing.JTextField valorTotal;
    private javax.swing.JTextField valorUnit;
    // End of variables declaration//GEN-END:variables
}
