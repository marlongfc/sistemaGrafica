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
public class FCadCaixa extends javax.swing.JInternalFrame {

    private Caixa caixa;
    private CaixaDAO caixaDAO = new CaixaDAO();

    private List<Caixa> listaCaixa = null;

    public FCadCaixa() {
        initComponents();

        listaCaixa = ObservableCollections.observableList(new LinkedList<Caixa>());
        Componentes comp2 = new Componentes(listaCaixa, false, codCaixa, descCaixa, this, jPanel18, descCaixa.getWidth(), 100);
        comp2.addCol(0, "codCaixa", "Código", 50, Integer.class.getName());
        comp2.addCol(1, "descricao", "Caixa", 200, String.class.getName());
        comp2.addCol(2, "valorInicial", "Valor Abertura", 60, String.class.getName());
        comp2.bind();

        atualizatabela();

        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

    }

    private static FCadCaixa instancia;
    private static FCadCaixa instanceCont;
    private static int initControle;

    public static int isInicializado() {
        return initControle;
    }

    public synchronized static FCadCaixa getInstancia() {
        if (instancia == null) {
            instancia = new FCadCaixa();
            initControle = 1;
        }

        return instancia;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel18 = new javax.swing.JPanel();
        valorInicial = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        descCaixa = new javax.swing.JTextField();
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
        jLabel79 = new javax.swing.JLabel();
        codCaixa = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        btSair1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setPreferredSize(new java.awt.Dimension(1100, 700));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setMinimumSize(new java.awt.Dimension(1100, 700));
        jPanel18.setPreferredSize(new java.awt.Dimension(1100, 700));
        jPanel18.setLayout(null);

        valorInicial.setText("0,00");
        jPanel18.add(valorInicial);
        valorInicial.setBounds(910, 90, 130, 20);

        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel78.setText("Caixa");
        jPanel18.add(jLabel78);
        jLabel78.setBounds(110, 70, 70, 20);

        descCaixa.setBackground(new java.awt.Color(255, 255, 204));
        descCaixa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descCaixaKeyReleased(evt);
            }
        });
        jPanel18.add(descCaixa);
        descCaixa.setBounds(110, 90, 800, 20);

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
        btNovo.setBounds(80, 130, 180, 40);

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar2.png"))); // NOI18N
        btSalvar.setText("Salvar/Atualizar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel18.add(btSalvar);
        btSalvar.setBounds(260, 130, 180, 40);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excuir2.png"))); // NOI18N
        btExcluir.setText("Deletar");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel18.add(btExcluir);
        btExcluir.setBounds(440, 130, 180, 40);

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir2.png"))); // NOI18N
        btSair.setText("Imprimir");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel18.add(btSair);
        btSair.setBounds(620, 130, 180, 40);

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Caixa", "Valor Inicial"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        }

        jPanel18.add(jScrollPane11);
        jScrollPane11.setBounds(20, 190, 1020, 250);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CADASTRO DE CAIXAS");
        jPanel18.add(jLabel1);
        jLabel1.setBounds(0, 0, 1100, 70);

        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel79.setText("Valor Abertura");
        jPanel18.add(jLabel79);
        jLabel79.setBounds(910, 70, 130, 20);

        codCaixa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codCaixa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codCaixaFocusLost(evt);
            }
        });
        jPanel18.add(codCaixa);
        codCaixa.setBounds(20, 90, 90, 20);

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
        btSair1.setBounds(800, 130, 180, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 673, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 673, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregaBanco() throws Exception {
        caixa = caixaDAO.get(ValidarValor.getInt(codCaixa.getText()));
        if (caixa != null) {
            descCaixa.setText(caixa.getDescricao());
            valorInicial.setText(ValidarValor.getDouble(caixa.getValorInicial()));
        } else {
            descCaixa.setText("");
            valorInicial.setText("");
        }
    }


    private void descCaixaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descCaixaKeyReleased
        try {
            List<Caixa> merged = caixaDAO.getList(12,
                    "select e from Caixa e where  lower ( trim(e.descricao) ) like ?1 order by e.codCaixa",
                    descCaixa.getText().trim().toLowerCase() + "%");
            listaCaixa.clear();
            listaCaixa.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Caixas. Erro: " + e);
        }
    }//GEN-LAST:event_descCaixaKeyReleased

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        try {
            caixa = new Caixa();
            limpaCampos();
            habilitaCampos(true);
            descCaixa.requestFocus();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        try {
            caixa = caixaDAO.get(ValidarValor.getInt(codCaixa.getText()));
            if (caixa == null) {
                caixa = new Caixa();
                setCaixa();
                caixa.setDataCadastro(new Date());
                caixa.setDataAtualizacao(new Date());
                if (caixaDAO.confereCaixa(caixa)) {
                    caixa = caixaDAO.salvar(caixa);
                    codCaixa.setText(caixa.getCodCaixa().toString());
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
            caixa = caixaDAO.get(ValidarValor.getInt(codCaixa.getText()));
            if (caixa == null) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um codigo válido. ");
            } else {
                setCaixa();
                caixaDAO.delete(caixa);
                limpaCampos();
                JOptionPane.showMessageDialog(this, "Exclusão realizada com sucesso");
                descCaixa.requestFocus();
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

            new VisualizaRelatorio().visRel("graficaatual/relatorios/arquivos/RelCaixaLista.jasper", "RELATÓRIO DE CAIXAS", null, sql);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório de bancos! \n " + e);
        }
    }//GEN-LAST:event_btSairActionPerformed

    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
        try {
            if (evt.getClickCount() > 1) {
                codCaixa.setText(tab.getValueAt(tab.getSelectedRow(), 0).toString());
                caixa = caixaDAO.get(ValidarValor.getInt(codCaixa.getText()));
                carregaBanco();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_tabMouseClicked

    private void codCaixaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codCaixaFocusLost
        try {
            carregaBanco();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codCaixaFocusLost

    private void btSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSair1ActionPerformed
        dispose();
    }//GEN-LAST:event_btSair1ActionPerformed

    private void limpaCampos() {
        codCaixa.setText("");
        descCaixa.setText("");
        valorInicial.setText("");
    }

    private void habilitaCampos(boolean b) {
        codCaixa.setEnabled(b);
        descCaixa.setEnabled(b);
        valorInicial.setEnabled(b);
        btSalvar.setEnabled(b);
    }

    private void setCaixa() throws Exception {

        if (descCaixa.getText().length() < 2) {
            throw new Exception("Favor inserir um Caixa");
        }

        if (valorInicial.getText().length() < 2) {
            throw new Exception("Favor inserir um Valor");
        }

        caixa.setDescricao(descCaixa.getText());
        caixa.setValorInicial((ValidarValor.getArredondamento(ValidarValor.getDouble(valorInicial.getText()))));
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
    private javax.swing.JTextField codCaixa;
    private javax.swing.JTextField descCaixa;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
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
    private javax.swing.JTable tab;
    private javax.swing.JTextField valorInicial;
    // End of variables declaration//GEN-END:variables
}
