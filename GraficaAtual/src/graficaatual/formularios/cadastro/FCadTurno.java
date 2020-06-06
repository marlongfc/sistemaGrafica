/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.cadastro;

import graficaatual.daos.cadastro.TurnoDAO;
import graficaatual.entidades.Turno;
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
 * @author Moisés
 */
public class FCadTurno extends javax.swing.JInternalFrame {

    private Turno turno;
    private TurnoDAO turnoDao = new TurnoDAO();

    private List<Turno> listaTurno = null;

    public FCadTurno() {
        initComponents();

        atualizatabela();

        listaTurno = ObservableCollections.observableList(new LinkedList<Turno>());
        Componentes comp2 = new Componentes(listaTurno, false, codTurnoo, descTurno, this, jPanel18, descTurno.getWidth(), 100);
        comp2.addCol(0, "codTurno", "Código", 50, Integer.class.getName());
        comp2.addCol(1, "descricao", "Turno", 200, String.class.getName());
        comp2.bind();

        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

    }

    private static FCadTurno instancia;
    private static FCadTurno instanceCont;
    private static int initControle;

    public static int isInicializado() {
        return initControle;
    }

    public synchronized static FCadTurno getInstancia() {
        if (instancia == null) {
            instancia = new FCadTurno();
            initControle = 1;
        }
        return instancia;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel18 = new javax.swing.JPanel();
        codTurnoo = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        descTurno = new javax.swing.JTextField();
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
        btSair1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setPreferredSize(new java.awt.Dimension(1100, 700));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setMaximumSize(new java.awt.Dimension(999999, 999999));
        jPanel18.setMinimumSize(new java.awt.Dimension(1100, 700));
        jPanel18.setLayout(null);

        codTurnoo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codTurnoo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codTurnooFocusLost(evt);
            }
        });
        jPanel18.add(codTurnoo);
        codTurnoo.setBounds(30, 90, 110, 20);

        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel78.setText("Turno");
        jPanel18.add(jLabel78);
        jLabel78.setBounds(140, 70, 40, 20);

        descTurno.setBackground(new java.awt.Color(255, 255, 204));
        descTurno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descTurnoKeyReleased(evt);
            }
        });
        jPanel18.add(descTurno);
        descTurno.setBounds(140, 90, 920, 20);

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
        btNovo.setBounds(100, 140, 180, 40);

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar2.png"))); // NOI18N
        btSalvar.setText("Salvar/Atualizar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel18.add(btSalvar);
        btSalvar.setBounds(280, 140, 180, 40);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excuir2.png"))); // NOI18N
        btExcluir.setText("Deletar");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel18.add(btExcluir);
        btExcluir.setBounds(460, 140, 180, 40);

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir2.png"))); // NOI18N
        btSair.setText("Imprimir");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel18.add(btSair);
        btSair.setBounds(640, 140, 180, 40);

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Turno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
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
            tab.getColumnModel().getColumn(1).setPreferredWidth(1000);
        }

        jPanel18.add(jScrollPane11);
        jScrollPane11.setBounds(20, 200, 1040, 380);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CADASTRO DE TURNO");
        jPanel18.add(jLabel1);
        jLabel1.setBounds(0, 0, 1100, 70);

        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel79.setText("Código");
        jPanel18.add(jLabel79);
        jLabel79.setBounds(60, 70, 40, 20);

        btSair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAIR2.png"))); // NOI18N
        btSair1.setText("Sair");
        btSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSair1ActionPerformed(evt);
            }
        });
        jPanel18.add(btSair1);
        btSair1.setBounds(820, 140, 180, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
        );

        jPanel18.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codTurnooFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codTurnooFocusLost
        try {
            carregaTurno();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codTurnooFocusLost

    private void carregaTurno() throws Exception {
        turno = turnoDao.get(ValidarValor.getInt(codTurnoo.getText()));
        if (turno != null) {
            descTurno.setText(turno.getDescricao());
        } else {
            descTurno.setText("");
        }
    }


    private void descTurnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descTurnoKeyReleased
        try {
            List<Turno> merged = turnoDao.getList(12,
                    "select e from Turno e where  lower ( trim(e.descricao) ) like ?1 order by e.codTurno",
                    descTurno.getText().trim().toLowerCase() + "%");
            listaTurno.clear();
            listaTurno.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Turno. Erro: " + e);
        }
    }//GEN-LAST:event_descTurnoKeyReleased

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        try {
            turno = new Turno();
            limpaCampos();
            habilitaCampos(true);
            descTurno.requestFocus();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        try {

            turno = turnoDao.get(ValidarValor.getInt(codTurnoo.getText()));
            if (turno == null) {
                turno = new Turno();
                setTurno();
                turno.setDataCadastro(new Date());
                turno.setDataAtualizacao(new Date());
                if (turnoDao.confereTurno(turno)) {
                    turno = turnoDao.salvar(turno);
                    codTurnoo.setText(turno.getCodTurno().toString());
                    turno.setDataAtualizacao(new Date());
                    btSalvar.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Causa de Morte já Cadastrada");
                }
            }
            setTurno();
            turnoDao.salvar(turno);
            limpaCampos();
            atualizatabela();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        try {
            turno = turnoDao.get(ValidarValor.getInt(codTurnoo.getText()));
            if (turno == null) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um codigo válido. ");
            } else {
                setTurno();
                turnoDao.delete(turno);
                limpaCampos();
                JOptionPane.showMessageDialog(this, "Exclusão realizada com sucesso");
                descTurno.requestFocus();
            }
            atualizatabela();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        try {
            String sql = "SELECT codTurno, descricao FROM turno ORDER BY descricao asc";

            new VisualizaRelatorio().visRel("graficaatual/relatorios/arquivos/RelTurnoLista.jasper", "RELATÓRIO DE TURNOS", null, sql);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório de turnos! \n " + e);
        }
    }//GEN-LAST:event_btSairActionPerformed

    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
        try {
            if (evt.getClickCount() > 1) {
                codTurnoo.setText(tab.getValueAt(tab.getSelectedRow(), 0).toString());
                turno = turnoDao.get(ValidarValor.getInt(codTurnoo.getText()));
                carregaTurno();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_tabMouseClicked

    private void btSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSair1ActionPerformed
        dispose();
    }//GEN-LAST:event_btSair1ActionPerformed

    private void limpaCampos() {
        codTurnoo.setText("");
        descTurno.setText("");
    }

    private void habilitaCampos(boolean b) {
        codTurnoo.setEnabled(b);
        descTurno.setEnabled(b);
        btSalvar.setEnabled(b);
    }

    private void setTurno() throws Exception {
        if (descTurno.getText().length() < 2) {
            throw new Exception("Favor inserir um Turno");
        }
        turno.setDescricao(descTurno.getText());
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
            List<Turno> listaT = turnoDao.getList();
            if (listaT.size() > 0) {
                model.setNumRows(0);
                for (Turno t : listaT) {
                    Object o[] = new Object[]{
                        t.getCodTurno(),
                        t.getDescricao()};

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
    private javax.swing.JTextField codTurnoo;
    private javax.swing.JTextField descTurno;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
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
    // End of variables declaration//GEN-END:variables
}
