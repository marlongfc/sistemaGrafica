/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.financeiro;

import graficaatual.daos.financeiro.CaixaDAO;
import graficaatual.daos.financeiro.LancamentoCaixaDAO;
import graficaatual.daos.financeiro.PlanoDeContasDAO;
import graficaatual.entidades.ControleAcesso;
import graficaatual.entidades.financeiro.Caixa;
import graficaatual.entidades.financeiro.LancamentoCaixa;
import graficaatual.entidades.financeiro.PlanoDeContas;
import graficaatual.utilitarios.Componentes;
import graficaatual.utilitarios.Data;
import graficaatual.utilitarios.Persistencia;
import graficaatual.utilitarios.ValidarValor;
import graficaatual.utilitarios.VisualizaRelatorio;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Moisés
 */
public class FCadLancamento extends javax.swing.JInternalFrame {

    private LancamentoCaixa lancamento;
    private LancamentoCaixaDAO lancamentoDAO = new LancamentoCaixaDAO();

    private PlanoDeContas plano;
    private PlanoDeContasDAO planoDAO = new PlanoDeContasDAO();

    private Caixa caixa;
    private CaixaDAO caixaDAO = new CaixaDAO();

    private List<LancamentoCaixa> listaLancamento = null;
    private List<Caixa> listaCaixa = null;
    private List<PlanoDeContas> listaPlano = null;

    public FCadLancamento() {
        initComponents();

        atualizatabela();

        listaLancamento = ObservableCollections.observableList(new LinkedList<LancamentoCaixa>());
        Componentes comp2 = new Componentes(listaLancamento, false, codLancamento, descLancamento, this, jPanel18, descLancamento.getWidth(), 100);
        comp2.addCol(0, "codLancamento", "Código", 50, Integer.class.getName());
        comp2.addCol(1, "descricao", "Lançamento", 200, String.class.getName());
        comp2.bind();

        listaPlano = ObservableCollections.observableList(new LinkedList<PlanoDeContas>());
        Componentes comp3 = new Componentes(listaPlano, false, codConta, descConta, this, jPanel18, descConta.getWidth(), 100);
        comp3.addCol(0, "codPlano", "Código", 50, Integer.class.getName());
        comp3.addCol(1, "descricao", "Conta", 200, String.class.getName());
        comp3.bind();

        listaCaixa = ObservableCollections.observableList(new LinkedList<Caixa>());
        Componentes comp4 = new Componentes(listaCaixa, false, codCaixa, descCaixa, this, jPanel18, descCaixa.getWidth(), 100);
        comp4.addCol(0, "codCaixa", "Código", 50, Integer.class.getName());
        comp4.addCol(1, "descricao", "Caixa", 200, String.class.getName());
        comp4.bind();

        tipoConta.setEnabled(false);

        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

    }

    private static FCadLancamento instancia;
    private static FCadLancamento instanceCont;
    private static int initControle;

    public static int isInicializado() {
        return initControle;
    }

    public synchronized static FCadLancamento getInstancia() {
        if (instancia == null) {
            instancia = new FCadLancamento();
            initControle = 1;
        }

        return instancia;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel18 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        descLancamento = new javax.swing.JTextField();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        codLancamento = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        valorEntrada = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        obs = new javax.swing.JTextArea();
        btSair1 = new javax.swing.JButton();
        codConta = new javax.swing.JTextField();
        descConta = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        valorSaida = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        tipoConta = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        codCaixa = new javax.swing.JTextField();
        descCaixa = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setPreferredSize(new java.awt.Dimension(1100, 700));

        jTabbedPane2.setMinimumSize(new java.awt.Dimension(1100, 700));
        jTabbedPane2.setPreferredSize(new java.awt.Dimension(1100, 700));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setMinimumSize(new java.awt.Dimension(1100, 700));
        jPanel18.setPreferredSize(new java.awt.Dimension(1100, 700));
        jPanel18.setLayout(null);

        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel78.setText("Lançamento");
        jPanel18.add(jLabel78);
        jLabel78.setBounds(140, 70, 130, 20);

        descLancamento.setBackground(new java.awt.Color(255, 255, 204));
        descLancamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descLancamentoKeyReleased(evt);
            }
        });
        jPanel18.add(descLancamento);
        descLancamento.setBounds(140, 90, 900, 20);

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/NOVO2.png"))); // NOI18N
        btNovo.setText("Novo Cadastro");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel18.add(btNovo);
        btNovo.setBounds(90, 420, 180, 40);

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar2.png"))); // NOI18N
        btSalvar.setText("Salvar/Atualizar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel18.add(btSalvar);
        btSalvar.setBounds(270, 420, 180, 40);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excuir2.png"))); // NOI18N
        btExcluir.setText("Deletar");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel18.add(btExcluir);
        btExcluir.setBounds(450, 420, 180, 40);

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir2.png"))); // NOI18N
        btSair.setText("Imprimir");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel18.add(btSair);
        btSair.setBounds(630, 420, 180, 40);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LANÇAMENTO NO CAIXA");
        jPanel18.add(jLabel1);
        jLabel1.setBounds(0, 0, 1100, 70);

        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel79.setText("Observação");
        jPanel18.add(jLabel79);
        jLabel79.setBounds(20, 280, 230, 20);

        codLancamento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codLancamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codLancamentoFocusLost(evt);
            }
        });
        jPanel18.add(codLancamento);
        codLancamento.setBounds(20, 90, 120, 20);

        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel80.setText("Código");
        jPanel18.add(jLabel80);
        jLabel80.setBounds(20, 70, 80, 20);

        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel81.setText("Valor Enrtrada (R$)");
        jPanel18.add(jLabel81);
        jLabel81.setBounds(20, 220, 130, 20);

        valorEntrada.setText("0,00");
        valorEntrada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorEntradaFocusLost(evt);
            }
        });
        jPanel18.add(valorEntrada);
        valorEntrada.setBounds(20, 240, 120, 20);

        obs.setColumns(20);
        obs.setLineWrap(true);
        obs.setRows(5);
        jScrollPane1.setViewportView(obs);

        jPanel18.add(jScrollPane1);
        jScrollPane1.setBounds(20, 300, 1030, 96);

        btSair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAIR2.png"))); // NOI18N
        btSair1.setText("Sair");
        btSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSair1ActionPerformed(evt);
            }
        });
        jPanel18.add(btSair1);
        btSair1.setBounds(810, 420, 180, 40);

        codConta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codConta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codContaFocusLost(evt);
            }
        });
        jPanel18.add(codConta);
        codConta.setBounds(20, 140, 120, 20);

        descConta.setBackground(new java.awt.Color(255, 255, 204));
        descConta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descContaKeyReleased(evt);
            }
        });
        jPanel18.add(descConta);
        descConta.setBounds(140, 140, 780, 20);

        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel82.setText("Código");
        jPanel18.add(jLabel82);
        jLabel82.setBounds(20, 120, 80, 20);

        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel83.setText("Conta");
        jPanel18.add(jLabel83);
        jLabel83.setBounds(140, 120, 130, 20);

        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel84.setText("Valor Saída (R$)");
        jPanel18.add(jLabel84);
        jLabel84.setBounds(170, 220, 130, 20);

        valorSaida.setText("0,00");
        valorSaida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valorSaidaFocusLost(evt);
            }
        });
        jPanel18.add(valorSaida);
        valorSaida.setBounds(170, 240, 120, 20);

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel85.setText("Tipo");
        jPanel18.add(jLabel85);
        jLabel85.setBounds(920, 120, 120, 20);

        tipoConta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tipoContaFocusLost(evt);
            }
        });
        jPanel18.add(tipoConta);
        tipoConta.setBounds(920, 140, 120, 20);

        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel86.setText("Código");
        jPanel18.add(jLabel86);
        jLabel86.setBounds(20, 170, 80, 20);

        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel87.setText("Caixa");
        jPanel18.add(jLabel87);
        jLabel87.setBounds(140, 170, 130, 20);

        codCaixa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codCaixa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codCaixaFocusLost(evt);
            }
        });
        jPanel18.add(codCaixa);
        codCaixa.setBounds(20, 190, 120, 20);

        descCaixa.setBackground(new java.awt.Color(255, 255, 204));
        descCaixa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descCaixaKeyReleased(evt);
            }
        });
        jPanel18.add(descCaixa);
        descCaixa.setBounds(140, 190, 900, 20);

        jTabbedPane2.addTab("Lançamentos", jPanel18);

        jPanel1.setLayout(null);

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Lançamento", "Caixa", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
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
        tab.setPreferredSize(new java.awt.Dimension(1000, 10000));
        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tab);
        if (tab.getColumnModel().getColumnCount() > 0) {
            tab.getColumnModel().getColumn(0).setPreferredWidth(100);
            tab.getColumnModel().getColumn(1).setPreferredWidth(600);
            tab.getColumnModel().getColumn(2).setPreferredWidth(200);
            tab.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(10, 51, 1020, 480);

        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(900, 10, 130, 30);

        jTabbedPane2.addTab("Lançamentos Cadastrados", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregaLancamento() throws Exception {
        lancamento = lancamentoDAO.get(ValidarValor.getInt(codLancamento.getText()));
        if (lancamento != null) {
            descLancamento.setText(lancamento.getDescricao());
            codConta.setText(lancamento.getPlanoConta().getCodPlano().toString());
            descConta.setText(lancamento.getPlanoConta().getDescricao());
            codCaixa.setText(lancamento.getCaixa().getCodCaixa().toString());
            descCaixa.setText(lancamento.getCaixa().getDescricao());
            if (lancamento.getValorEntrada() == null) {
                valorEntrada.setText("0,00");
            } else {
                valorEntrada.setText(ValidarValor.getDouble(lancamento.getValorEntrada()));
            }
            if (lancamento.getValorSaida() == null) {
                valorSaida.setText("0,00");
            } else {
                valorSaida.setText(ValidarValor.getDouble(lancamento.getValorSaida()));
            }

            obs.setText(lancamento.getObservacao());
        } else {
            descLancamento.setText("");
            codConta.setText("");
            descConta.setText("");
            codCaixa.setText("");
            descCaixa.setText("");
            valorEntrada.setText("0.00");
            valorSaida.setText("0.00");
            obs.setText("");
        }
    }

    private void carregaConta() throws Exception {
        plano = planoDAO.get(ValidarValor.getInt(codConta.getText()));
        if (plano != null) {
            descConta.setText(plano.getDescricao());

            String tipo = "";
            if (plano.getCentro().getTipo() == 0) {
                tipo = "Receita";
                valorEntrada.setEnabled(true);
                valorSaida.setEnabled(false);

            } else {
                tipo = "Despesa";
                valorEntrada.setEnabled(false);
                valorSaida.setEnabled(true);
            }

            tipoConta.setText(tipo);
        } else {
            descConta.setText("");
            tipoConta.setText("");
        }
    }

    private void carregaCaixa() throws Exception {
        caixa = caixaDAO.get(ValidarValor.getInt(codCaixa.getText()));
        if (caixa != null) {
            descCaixa.setText(caixa.getDescricao());
        } else {
            descCaixa.setText("");
        }
    }


    private void descLancamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descLancamentoKeyReleased
        try {
            List<LancamentoCaixa> merged = lancamentoDAO.getList(15,
                    "select e from LancamentoCaixa e where  lower ( trim(e.descricao) ) like ?1 order by e.descricao",
                    descLancamento.getText().trim().toLowerCase() + "%");
            listaLancamento.clear();
            listaLancamento.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Lançamento. Erro: " + e);
        }
    }//GEN-LAST:event_descLancamentoKeyReleased

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        try {
            lancamento = new LancamentoCaixa();
            limpaCampos();
            habilitaCampos(true);
            descLancamento.requestFocus();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            if (caixa != null) {
                if (plano != null) {

                    //Faz o Lancamento 
                    LancamentoCaixa lancCaixa = new LancamentoCaixa();
                    lancCaixa.setCaixa(caixa);
                    lancCaixa.setDataCadastro(new Date());
                    lancCaixa.setDescricao(obs.getText());
                    lancCaixa.setPlanoConta(plano);
                    lancCaixa.setUsuarioCadastro(ControleAcesso.usuario.getCodUsuario() + " "
                            + ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                    lancCaixa.setValorEntrada(ValidarValor.getDouble(valorEntrada.getText()));
                    lancCaixa.setValorSaida(ValidarValor.getDouble(valorSaida.getText()));

                    lancCaixa = lancamentoDAO.salvar(session, lancCaixa);

                    //Atualizar valor Caixa
                    caixa = lancamento.getCaixa();
                    caixa.setValorFechamentoDia(caixa.getValorInicial());
                    caixa.setValorInicial(caixa.getValorInicial() + ValidarValor.getDouble(valorEntrada.getText()) - ValidarValor.getDouble(valorSaida.getText()));
                    caixa = caixaDAO.salvar(session, caixa);

                    session.getTransaction().commit();
                    session.close();

                    JOptionPane.showMessageDialog(this, " Tarefa Finalizada com Sucesso! ");

                } else {
                    throw new Exception("Favor inserir os dados de Caixa.");
                }
            } else {
                throw new Exception("Favor inserir os dados de Plano de Conta.");
            }

        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            lancamento = lancamentoDAO.get(ValidarValor.getInt(codLancamento.getText()));
            if (lancamento == null) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um codigo válido. ");
            } else {

                //Atualizar valor Caixa
                caixa = lancamento.getCaixa();
                caixa.setValorFechamentoDia(caixa.getValorInicial());
                caixa.setValorInicial(caixa.getValorInicial() - (lancamento.getValorEntrada()) + lancamento.getValorSaida());
                caixa = caixaDAO.salvar(session, caixa);

                lancamentoDAO.deletePojo(session, lancamento);
                limpaCampos();

                session.getTransaction().commit();
                session.close();

                atualizatabela();
                JOptionPane.showMessageDialog(this, "Exclusão realizada com sucesso");

            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        try {
            String sql = "SELECT codLancamento, descricao, valor FROM lancamentoCaixa ORDER BY descricao asc";

            new VisualizaRelatorio().visRel("graficaatual/relatorios/arquivos/RelLancamentoCaixaLista.jasper", "RELATÓRIO DE LANÇAMENTOS EM CAIXA", null, sql);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório de Lançamentos! \n " + e);
        }
    }//GEN-LAST:event_btSairActionPerformed

    private void codLancamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codLancamentoFocusLost
        try {
            carregaLancamento();
            carregaConta();
            carregaCaixa();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codLancamentoFocusLost

    private void valorEntradaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorEntradaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_valorEntradaFocusLost

    private void btSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSair1ActionPerformed
        dispose();
    }//GEN-LAST:event_btSair1ActionPerformed

    private void codContaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codContaFocusLost
        try {
            carregaConta();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codContaFocusLost

    private void descContaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descContaKeyReleased
        try {
            List<PlanoDeContas> merged = planoDAO.getList(15,
                    "select e from PlanoDeContas e where  lower ( trim(e.descricao) ) like ?1 order by e.descricao",
                    descConta.getText().trim().toLowerCase() + "%");
            listaPlano.clear();
            listaPlano.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Plano de Contas. Erro: " + e);
        }
    }//GEN-LAST:event_descContaKeyReleased

    private void valorSaidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valorSaidaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_valorSaidaFocusLost

    private void tipoContaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tipoContaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoContaFocusLost

    private void codCaixaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codCaixaFocusLost
        try {
            carregaCaixa();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codCaixaFocusLost

    private void descCaixaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descCaixaKeyReleased
        try {
            List<Caixa> merged = caixaDAO.getList(15,
                    "select e from Caixa e where  lower ( trim(e.descricao) ) like ?1 order by e.descricao",
                    descCaixa.getText().trim().toLowerCase() + "%");
            listaCaixa.clear();
            listaCaixa.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Caixas. Erro: " + e);
        }
    }//GEN-LAST:event_descCaixaKeyReleased

    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
        try {
            if (evt.getClickCount() > 1) {
                codLancamento.setText(tab.getValueAt(tab.getSelectedRow(), 0).toString());
                lancamento = lancamentoDAO.get(ValidarValor.getInt(codLancamento.getText()));
                carregaLancamento();

                jTabbedPane2.setSelectedIndex(0);

                codLancamento.requestFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_tabMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        atualizatabela();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void limpaCampos() {
        codLancamento.setText("");
        descLancamento.setText("");
        codConta.setText("");
        descConta.setText("");
        tipoConta.setText("");
        codCaixa.setText("");
        descCaixa.setText("");
        valorEntrada.setText("0,00");
        valorSaida.setText("0,00");
        obs.setText("");
    }

    private void habilitaCampos(boolean b) {

        codLancamento.setEnabled(b);
        descLancamento.setEnabled(b);
        codConta.setEnabled(b);
        descConta.setEnabled(b);
        codCaixa.setEnabled(b);
        descCaixa.setEnabled(b);
        valorEntrada.setEnabled(b);
        valorSaida.setEnabled(b);
        obs.setEnabled(b);

        btSalvar.setEnabled(b);

    }

    private void setLancamento() throws Exception {

        if (descLancamento.getText().length() < 2) {
            throw new Exception("Favor inserir um Lançamento");
        }

        if (descCaixa.getText().length() < 2) {
            throw new Exception("Favor inserir uma conta");
        }

        if (descCaixa.getText().length() < 2) {
            throw new Exception("Favor inserir uma caixa");
        }

        if (ValidarValor.getDouble(valorEntrada.getText()) <= 0.00 && ValidarValor.getDouble(valorSaida.getText()) <= 0.00) {
            throw new Exception("Favor inserir um Valor válido");
        }

        lancamento.setDescricao(descLancamento.getText());
        lancamento.setPlanoConta(plano);
        lancamento.setCaixa(caixa);
        lancamento.setValorEntrada(ValidarValor.getDouble(valorEntrada.getText()));
        lancamento.setValorEntrada(ValidarValor.getDouble(valorSaida.getText()));
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
            List<LancamentoCaixa> listaT = lancamentoDAO.getList();
            if (listaT.size() > 0) {
                model.setNumRows(0);
                
                System.out.println("--------------1");
                
                for (LancamentoCaixa l : listaT) {

                    Double valor = 0.00;
                     System.out.println("--------------2");
                    if (l.getValorEntrada() != 0) {
                        valor = l.getValorEntrada();
                    } else {
                        valor = l.getValorSaida();
                    }

                     System.out.println("--------------3");
                    Object o[] = new Object[]{
                        l.getCodLancamento(),
                        l.getDescricao(),
                        l.getCaixa().getDescricao(),
                        valor};
                     System.out.println("--------------4");
                    model.addRow(o);
                     System.out.println("--------------5");
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
    private javax.swing.JTextField codConta;
    private javax.swing.JTextField codLancamento;
    private javax.swing.JTextField descCaixa;
    private javax.swing.JTextField descConta;
    private javax.swing.JTextField descLancamento;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea obs;
    private javax.swing.JTable tab;
    private javax.swing.JTextField tipoConta;
    private javax.swing.JTextField valorEntrada;
    private javax.swing.JTextField valorSaida;
    // End of variables declaration//GEN-END:variables
}
