/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.cadastro;

import graficaatual.daos.cadastro.PatrimonioDAO;
import graficaatual.entidades.Patrimonio;
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
public class FCadPatrimonio extends javax.swing.JInternalFrame {

    private Patrimonio patrimonio;
    private PatrimonioDAO patrimonioDao = new PatrimonioDAO();

    private List<Patrimonio> listaPatrimonio = null;

    public FCadPatrimonio() {
        initComponents();

        atualizatabela();

        listaPatrimonio = ObservableCollections.observableList(new LinkedList<Patrimonio>());
        Componentes comp2 = new Componentes(listaPatrimonio, false, codPatrimonio, descPatrimonio, this, jPanel18, descPatrimonio.getWidth(), 100);
        comp2.addCol(0, "codPatrimonio", "Código", 50, Integer.class.getName());
        comp2.addCol(1, "descricao", "Patrimônio", 200, String.class.getName());
        comp2.bind();

        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

    }

    private static FCadPatrimonio instancia;
    private static FCadPatrimonio instanceCont;
    private static int initControle;

    public static int isInicializado() {
        return initControle;
    }

    public synchronized static FCadPatrimonio getInstancia() {
        if (instancia == null) {
            instancia = new FCadPatrimonio();
            initControle = 1;
        }
        return instancia;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel18 = new javax.swing.JPanel();
        codPatrimonio = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        descPatrimonio = new javax.swing.JTextField();
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
        jLabel82 = new javax.swing.JLabel();
        marcaPatrimonio = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        modeloPatrimonio = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        ano = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        numPatrimonio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        observacao = new javax.swing.JTextArea();
        jLabel81 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setPreferredSize(new java.awt.Dimension(1100, 700));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setMaximumSize(new java.awt.Dimension(999999, 999999));
        jPanel18.setMinimumSize(new java.awt.Dimension(1100, 700));
        jPanel18.setLayout(null);

        codPatrimonio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codPatrimonio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codPatrimonioFocusLost(evt);
            }
        });
        jPanel18.add(codPatrimonio);
        codPatrimonio.setBounds(30, 90, 80, 20);

        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel78.setText("Descrição");
        jPanel18.add(jLabel78);
        jLabel78.setBounds(210, 70, 420, 20);

        descPatrimonio.setBackground(new java.awt.Color(255, 255, 204));
        descPatrimonio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descPatrimonioKeyReleased(evt);
            }
        });
        jPanel18.add(descPatrimonio);
        descPatrimonio.setBounds(210, 90, 850, 20);

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
        btNovo.setBounds(100, 280, 180, 40);

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar2.png"))); // NOI18N
        btSalvar.setText("Salvar/Atualizar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel18.add(btSalvar);
        btSalvar.setBounds(280, 280, 180, 40);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excuir2.png"))); // NOI18N
        btExcluir.setText("Deletar");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel18.add(btExcluir);
        btExcluir.setBounds(460, 280, 180, 40);

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir2.png"))); // NOI18N
        btSair.setText("Imprimir");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel18.add(btSair);
        btSair.setBounds(640, 280, 180, 40);

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Patrimônio", "Marca", "Modelo", "Ano"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
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
            tab.getColumnModel().getColumn(1).setPreferredWidth(600);
            tab.getColumnModel().getColumn(2).setPreferredWidth(300);
            tab.getColumnModel().getColumn(3).setPreferredWidth(300);
            tab.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        jPanel18.add(jScrollPane11);
        jScrollPane11.setBounds(20, 340, 1040, 240);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CADASTRO DE PATRIMÔNIO");
        jPanel18.add(jLabel1);
        jLabel1.setBounds(0, 0, 1100, 70);

        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel79.setText("Código");
        jPanel18.add(jLabel79);
        jLabel79.setBounds(30, 70, 70, 20);

        btSair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAIR2.png"))); // NOI18N
        btSair1.setText("Sair");
        btSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSair1ActionPerformed(evt);
            }
        });
        jPanel18.add(btSair1);
        btSair1.setBounds(820, 280, 180, 40);

        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel82.setText("Marca");
        jPanel18.add(jLabel82);
        jLabel82.setBounds(30, 110, 110, 20);

        marcaPatrimonio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                marcaPatrimonioFocusLost(evt);
            }
        });
        jPanel18.add(marcaPatrimonio);
        marcaPatrimonio.setBounds(30, 130, 310, 20);

        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel83.setText("Modelo");
        jPanel18.add(jLabel83);
        jLabel83.setBounds(350, 110, 450, 20);

        modeloPatrimonio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                modeloPatrimonioFocusLost(evt);
            }
        });
        modeloPatrimonio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeloPatrimonioActionPerformed(evt);
            }
        });
        jPanel18.add(modeloPatrimonio);
        modeloPatrimonio.setBounds(350, 130, 590, 20);

        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel84.setText("Ano");
        jPanel18.add(jLabel84);
        jLabel84.setBounds(950, 110, 100, 20);

        ano.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                anoFocusLost(evt);
            }
        });
        ano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anoActionPerformed(evt);
            }
        });
        jPanel18.add(ano);
        ano.setBounds(950, 130, 110, 20);

        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel80.setText("Número");
        jPanel18.add(jLabel80);
        jLabel80.setBounds(110, 70, 100, 20);

        numPatrimonio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        numPatrimonio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                numPatrimonioFocusLost(evt);
            }
        });
        jPanel18.add(numPatrimonio);
        numPatrimonio.setBounds(110, 90, 100, 20);

        observacao.setColumns(20);
        observacao.setLineWrap(true);
        observacao.setRows(5);
        jScrollPane1.setViewportView(observacao);

        jPanel18.add(jScrollPane1);
        jScrollPane1.setBounds(30, 180, 1030, 80);

        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel81.setText("Observação");
        jPanel18.add(jLabel81);
        jLabel81.setBounds(30, 160, 220, 20);

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

    private void codPatrimonioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codPatrimonioFocusLost
        try {
            carregaPatrimonio();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codPatrimonioFocusLost

    private void carregaPatrimonio() throws Exception {
        patrimonio = patrimonioDao.get(ValidarValor.getInt(codPatrimonio.getText()));
        if (patrimonio != null) {
            numPatrimonio.setText(patrimonio.getNumPatrimonio().toString());
            descPatrimonio.setText(patrimonio.getDescricao());
            marcaPatrimonio.setText(patrimonio.getMarca());
            modeloPatrimonio.setText(patrimonio.getModelo());
            ano.setText(patrimonio.getAno().toString());
            observacao.setText(patrimonio.getDescricao());

        } else {
            numPatrimonio.setText("");
            descPatrimonio.setText("");
            marcaPatrimonio.setText("");
            modeloPatrimonio.setText("");
            ano.setText("");
            observacao.setText("");
        }
    }


    private void descPatrimonioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descPatrimonioKeyReleased
        try {
            List<Patrimonio> merged = patrimonioDao.getList(12,
                    "select e from Patrimonio e where  lower ( trim(e.descricao) ) like ?1 order by e.codPatrimonio",
                    descPatrimonio.getText().trim().toLowerCase() + "%");
            listaPatrimonio.clear();
            listaPatrimonio.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Patrimônio. Erro: " + e);
        }
    }//GEN-LAST:event_descPatrimonioKeyReleased

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        try {
            patrimonio = new Patrimonio();
            limpaCampos();
            habilitaCampos(true);
            descPatrimonio.requestFocus();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        try {

            patrimonio = patrimonioDao.get(ValidarValor.getInt(codPatrimonio.getText()));
            if (patrimonio == null) {
                patrimonio = new Patrimonio();
                setPatrimonio();
                patrimonio.setDataCadastro(new Date());
                patrimonio.setDataAtualizacao(new Date());
                if (patrimonioDao.conferePatrimonio(patrimonio)) {
                    patrimonio = patrimonioDao.salvar(patrimonio);
                    codPatrimonio.setText(patrimonio.getCodPatrimonio().toString());
                    patrimonio.setDataAtualizacao(new Date());
                    btSalvar.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Patrimônio já Cadastrado");
                }
            }
            setPatrimonio();
            patrimonioDao.salvar(patrimonio);
            limpaCampos();
            atualizatabela();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        try {
            patrimonio = patrimonioDao.get(ValidarValor.getInt(codPatrimonio.getText()));
            if (patrimonio == null) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um codigo válido. ");
            } else {
                setPatrimonio();
                patrimonioDao.delete(patrimonio);
                limpaCampos();
                JOptionPane.showMessageDialog(this, "Exclusão realizada com sucesso");
                descPatrimonio.requestFocus();
            }
            atualizatabela();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        try {
            String sql = "SELECT * FROM Patrimonio ORDER BY descricao asc";

            new VisualizaRelatorio().visRel("graficaatual/relatorios/arquivos/RelPatrimonio.jasper", "RELATÓRIO DE PATRIMÔNIOS", null, sql);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório de Patrimônio! \n " + e);
        }
    }//GEN-LAST:event_btSairActionPerformed

    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
        try {
            if (evt.getClickCount() > 1) {
                codPatrimonio.setText(tab.getValueAt(tab.getSelectedRow(), 0).toString());
                patrimonio = patrimonioDao.get(ValidarValor.getInt(codPatrimonio.getText()));
                carregaPatrimonio();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_tabMouseClicked

    private void btSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSair1ActionPerformed
        dispose();
    }//GEN-LAST:event_btSair1ActionPerformed

    private void marcaPatrimonioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_marcaPatrimonioFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_marcaPatrimonioFocusLost

    private void modeloPatrimonioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_modeloPatrimonioFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_modeloPatrimonioFocusLost

    private void modeloPatrimonioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeloPatrimonioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modeloPatrimonioActionPerformed

    private void anoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_anoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_anoFocusLost

    private void anoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anoActionPerformed

    private void numPatrimonioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numPatrimonioFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_numPatrimonioFocusLost

    private void limpaCampos() {
        codPatrimonio.setText("");
        numPatrimonio.setText("");
        descPatrimonio.setText("");
        marcaPatrimonio.setText("");
        modeloPatrimonio.setText("");
        ano.setText("");
        observacao.setText("");
    }

    private void habilitaCampos(boolean b) {
        codPatrimonio.setEnabled(b);
        numPatrimonio.setEnabled(b);
        descPatrimonio.setEnabled(b);
        marcaPatrimonio.setEnabled(b);
        modeloPatrimonio.setEnabled(b);
        ano.setEnabled(b);
        observacao.setEnabled(b);
        btSalvar.setEnabled(b);
    }

    private void setPatrimonio() throws Exception {
        if (descPatrimonio.getText().length() < 2) {
            throw new Exception("Favor inserir um Patrimônio");
        }

        if (marcaPatrimonio.getText().length() < 2) {
            throw new Exception("Favor inserir uma marca");
        }
        patrimonio.setNumPatrimonio(ValidarValor.getInt(numPatrimonio.getText()));
        patrimonio.setDescricao(descPatrimonio.getText());
        patrimonio.setMarca(marcaPatrimonio.getText());
        patrimonio.setModelo(modeloPatrimonio.getText());
        patrimonio.setAno(ValidarValor.getInt(ano.getText()));
        patrimonio.setObservacao(observacao.getText());

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
            List<Patrimonio> listaT = patrimonioDao.getList();
            if (listaT.size() > 0) {
                model.setNumRows(0);
                for (Patrimonio p : listaT) {
                    Object o[] = new Object[]{
                        p.getCodPatrimonio(),
                        p.getDescricao(),
                        p.getMarca(),
                        p.getModelo(),
                        p.getAno()};

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
    private javax.swing.JTextField ano;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSair1;
    private javax.swing.JButton btSalvar;
    private javax.swing.JTextField codPatrimonio;
    private javax.swing.JTextField descPatrimonio;
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
    private javax.swing.JScrollPane jScrollPane1;
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
    private javax.swing.JTextField marcaPatrimonio;
    private javax.swing.JTextField modeloPatrimonio;
    private javax.swing.JTextField numPatrimonio;
    private javax.swing.JTextArea observacao;
    private javax.swing.JTable tab;
    // End of variables declaration//GEN-END:variables
}
