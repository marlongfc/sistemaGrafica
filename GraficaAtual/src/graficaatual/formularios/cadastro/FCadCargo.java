/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.cadastro;

import graficaatual.daos.cadsatro.CargoDAO;
import graficaatual.daos.cadsatro.TurnoDAO;
import graficaatual.entidades.Cargo;
import graficaatual.entidades.Turno;
import graficaatual.pesq.cadastro.CnvCadastroCargo;
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
 * @author si10
 */
public class FCadCargo extends javax.swing.JInternalFrame {

    // Tela
    private static int initControle;
    private int localIncusao;
    private static FCadCargo instance;
    private static FCadCargo instanceCont;
    
    //Entidades 
    private Turno turno = null;
    private TurnoDAO TurnoDao = new TurnoDAO();
    
    private Cargo cargo = null;
    private CargoDAO cargoDao = new CargoDAO();
       
    // Lista Suspensa
    private List<Cargo> listaCargo = null;
    private List<Turno> listaTurno = null;

    
    //Controle de Navegação
    CnvCadastroCargo cnvColaboradorCad = new CnvCadastroCargo();
            
            
    public FCadCargo() {
        initComponents();
        
        listaCargo = ObservableCollections.observableList(new LinkedList<Cargo>());
        Componentes comp1 = new Componentes(listaCargo, false, codigo, descCargo, this, jPanel10, descCargo.getWidth(), 100);
        comp1.addCol(0, "codCargo", " Código ", 50, Integer.class.getName());
        comp1.addCol(1, "descricao", "Descrição ", 100, String.class.getName());
        comp1.bind();
        
        listaTurno = ObservableCollections.observableList(new LinkedList<Turno>());
        Componentes comp2 = new Componentes(listaTurno, false, codTurno, descTurno, this, jPanel10, descTurno.getWidth(), 100);
        comp2.addCol(0, "codTurno", " Código ", 50, Integer.class.getName());
        comp2.addCol(1, "descricao", "Descrição", 100, String.class.getName());
        comp2.bind();     
        
        atualizaTabela();
        
    }
    
    public static int isInicializado() {
        return initControle;
    }
    
     private void Finalizar() {

        if (localIncusao == 1) {
            instanceCont = null;
        } else {
            initControle = 0;
            instance = null;
        }
        dispose();
    }
     
  public synchronized static FCadCargo getInstance() {
        if (instance == null) {
            instance = new FCadCargo();
            initControle = 1;
        }
        return instance;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        codTurno = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        descCargo = new javax.swing.JTextField();
        descTurno = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jTextField37 = new javax.swing.JTextField();
        jTextField38 = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jTextField41 = new javax.swing.JTextField();
        jTextField42 = new javax.swing.JTextField();
        jTextField43 = new javax.swing.JTextField();
        jTextField44 = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTextField46 = new javax.swing.JTextField();
        jTextField47 = new javax.swing.JTextField();
        jTextField48 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        funcao = new javax.swing.JTextArea();
        jLabel46 = new javax.swing.JLabel();
        inicio = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        proximo = new javax.swing.JButton();
        ultimo = new javax.swing.JButton();
        novo = new javax.swing.JButton();
        salvar = new javax.swing.JButton();
        deletar = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabCargo = new javax.swing.JTable();
        codigo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        especificacao = new javax.swing.JTextArea();
        jLabel47 = new javax.swing.JLabel();
        crm = new javax.swing.JTextField();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cargos");
        setMinimumSize(new java.awt.Dimension(880, 550));
        setNormalBounds(new java.awt.Rectangle(0, 0, 880, 0));
        setPreferredSize(new java.awt.Dimension(880, 550));
        getContentPane().setLayout(null);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setToolTipText("Cadastro de Pessoas");
        jPanel10.setMaximumSize(new java.awt.Dimension(880, 550));
        jPanel10.setMinimumSize(new java.awt.Dimension(880, 550));
        jPanel10.setName(""); // NOI18N
        jPanel10.setPreferredSize(new java.awt.Dimension(880, 550));
        jPanel10.setLayout(null);

        codTurno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codTurnoFocusLost(evt);
            }
        });
        jPanel10.add(codTurno);
        codTurno.setBounds(110, 30, 90, 20);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Código: ");
        jPanel10.add(jLabel13);
        jLabel13.setBounds(30, 10, 80, 20);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Funções: ");
        jPanel10.add(jLabel15);
        jLabel15.setBounds(30, 60, 80, 20);

        descCargo.setBackground(new java.awt.Color(255, 255, 204));
        descCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descCargoKeyReleased(evt);
            }
        });
        jPanel10.add(descCargo);
        descCargo.setBounds(200, 10, 650, 19);

        descTurno.setBackground(new java.awt.Color(255, 255, 204));
        descTurno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descTurnoKeyReleased(evt);
            }
        });
        jPanel10.add(descTurno);
        descTurno.setBounds(200, 30, 310, 19);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(null);
        jPanel11.add(jTextField33);
        jTextField33.setBounds(160, 10, 90, 20);

        jTextField34.setBackground(new java.awt.Color(255, 255, 204));
        jPanel11.add(jTextField34);
        jTextField34.setBounds(340, 30, 310, 19);

        jTextField35.setBackground(new java.awt.Color(255, 255, 204));
        jPanel11.add(jTextField35);
        jTextField35.setBounds(160, 50, 490, 19);
        jPanel11.add(jTextField36);
        jTextField36.setBounds(120, 160, 80, 19);
        jPanel11.add(jTextField37);
        jTextField37.setBounds(200, 160, 470, 19);
        jPanel11.add(jTextField38);
        jTextField38.setBounds(780, 160, 140, 19);
        jPanel11.add(jTextField39);
        jTextField39.setBounds(120, 180, 80, 19);
        jPanel11.add(jTextField40);
        jTextField40.setBounds(200, 180, 470, 19);
        jPanel11.add(jTextField41);
        jTextField41.setBounds(780, 180, 140, 19);
        jPanel11.add(jTextField42);
        jTextField42.setBounds(120, 200, 80, 19);
        jPanel11.add(jTextField43);
        jTextField43.setBounds(200, 200, 310, 19);
        jPanel11.add(jTextField44);
        jTextField44.setBounds(780, 200, 140, 19);
        jPanel11.add(jTextField45);
        jTextField45.setBounds(580, 200, 90, 19);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Física", "Juridica" }));
        jPanel11.add(jComboBox2);
        jComboBox2.setBounds(160, 30, 180, 18);

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("UF: ");
        jPanel11.add(jLabel31);
        jLabel31.setBounds(510, 200, 70, 20);

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("CEP: ");
        jPanel11.add(jLabel32);
        jLabel32.setBounds(670, 200, 110, 20);

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("Código: ");
        jPanel11.add(jLabel33);
        jLabel33.setBounds(80, 10, 80, 20);

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("Data Nascimento: ");
        jPanel11.add(jLabel34);
        jLabel34.setBounds(650, 70, 140, 20);

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("Número: ");
        jPanel11.add(jLabel35);
        jLabel35.setBounds(670, 160, 110, 20);

        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Insc. Estadual:");
        jPanel11.add(jLabel36);
        jLabel36.setBounds(650, 50, 140, 20);

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("Bairro: ");
        jPanel11.add(jLabel37);
        jLabel37.setBounds(20, 180, 100, 20);

        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel38.setText("Logradouro: ");
        jPanel11.add(jLabel38);
        jLabel38.setBounds(20, 160, 100, 20);

        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel39.setText("Complemento: ");
        jPanel11.add(jLabel39);
        jLabel39.setBounds(670, 180, 110, 20);

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel40.setText("Cidade: ");
        jPanel11.add(jLabel40);
        jLabel40.setBounds(20, 200, 100, 20);

        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel41.setBorder(javax.swing.BorderFactory.createTitledBorder("Endeço:"));
        jPanel11.add(jLabel41);
        jLabel41.setBounds(10, 130, 920, 110);

        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel42.setText("CPF/CNPJ: ");
        jPanel11.add(jLabel42);
        jLabel42.setBounds(80, 30, 80, 20);
        jPanel11.add(jTextField46);
        jTextField46.setBounds(790, 70, 130, 19);
        jPanel11.add(jTextField47);
        jTextField47.setBounds(790, 30, 130, 19);
        jPanel11.add(jTextField48);
        jTextField48.setBounds(790, 50, 130, 19);

        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel43.setText("Nome/Razão Socia: ");
        jPanel11.add(jLabel43);
        jLabel43.setBounds(10, 50, 150, 20);

        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel44.setText("Insc. Munícipal:");
        jPanel11.add(jLabel44);
        jLabel44.setBounds(650, 30, 140, 20);

        jPanel10.add(jPanel11);
        jPanel11.setBounds(0, 0, 0, 0);

        funcao.setColumns(20);
        funcao.setRows(2);
        jScrollPane4.setViewportView(funcao);

        jPanel10.add(jScrollPane4);
        jScrollPane4.setBounds(30, 80, 820, 70);

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel46.setText("CRM: ");
        jPanel10.add(jLabel46);
        jLabel46.setBounds(510, 30, 60, 20);

        inicio.setText("||<<");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });
        jPanel10.add(inicio);
        inicio.setBounds(320, 480, 62, 20);

        anterior.setText("<<");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });
        jPanel10.add(anterior);
        anterior.setBounds(380, 480, 54, 20);

        proximo.setText(">>");
        proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoActionPerformed(evt);
            }
        });
        jPanel10.add(proximo);
        proximo.setBounds(430, 480, 54, 20);

        ultimo.setText(">>||");
        ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ultimoActionPerformed(evt);
            }
        });
        jPanel10.add(ultimo);
        ultimo.setBounds(480, 480, 62, 20);

        novo.setText("Novo Cadastro");
        novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoActionPerformed(evt);
            }
        });
        jPanel10.add(novo);
        novo.setBounds(100, 250, 180, 25);

        salvar.setText("Salvar/Atualizar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });
        jPanel10.add(salvar);
        salvar.setBounds(280, 250, 180, 25);

        deletar.setText("Deletar");
        deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarActionPerformed(evt);
            }
        });
        jPanel10.add(deletar);
        deletar.setBounds(460, 250, 180, 25);

        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        jPanel10.add(sair);
        sair.setBounds(640, 250, 180, 25);

        tabCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Turno", "CRM"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tabCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabCargoMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabCargo);

        jPanel10.add(jScrollPane6);
        jScrollPane6.setBounds(10, 280, 850, 190);

        codigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigoFocusLost(evt);
            }
        });
        jPanel10.add(codigo);
        codigo.setBounds(110, 10, 90, 20);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Especificações: ");
        jPanel10.add(jLabel16);
        jLabel16.setBounds(30, 150, 120, 20);

        especificacao.setColumns(20);
        especificacao.setRows(2);
        jScrollPane5.setViewportView(especificacao);

        jPanel10.add(jScrollPane5);
        jScrollPane5.setBounds(30, 170, 820, 70);

        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel47.setText("Turno: ");
        jPanel10.add(jLabel47);
        jLabel47.setBounds(50, 30, 60, 20);
        jPanel10.add(crm);
        crm.setBounds(580, 30, 270, 19);

        getContentPane().add(jPanel10);
        jPanel10.setBounds(0, 0, 880, 580);
        jPanel10.getAccessibleContext().setAccessibleName("Cadastro de Pessoas");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codTurnoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codTurnoFocusLost
        try {
            carregaTurno();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        } 
    }//GEN-LAST:event_codTurnoFocusLost

    private void descCargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descCargoKeyReleased
        try {
            List<Cargo> merged = cargoDao.getList(15, "select e from Cargo e where "
                    + "  lower (trim(e.descricao)) like ?1 order by e.descricao", 
                        descCargo.getText().trim().toLowerCase().replace(".", "").replace("-", "").trim() + "%");
            listaCargo.clear();
            listaCargo.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Cargo. Erro: " + e);
        }
    }//GEN-LAST:event_descCargoKeyReleased

    private void descTurnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descTurnoKeyReleased
        try {
            List<Turno> merged = TurnoDao.getList(12,
                "select e from Turno e where  lower ( trim(e.descricao) ) like ?1 order by e.descricao",
                descTurno.getText().trim().toLowerCase() + "%");
            listaTurno.clear();
            listaTurno.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Turno. Erro: " + e);
        }
            
    }//GEN-LAST:event_descTurnoKeyReleased

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        try {
            if (cnvColaboradorCad == null) {
                atualizaTabela();
            } else {
                cnvColaboradorCad.primeiro();
                atualizarTabelaCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_inicioActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        try {
            if (cnvColaboradorCad == null) {
                atualizaTabela();
            } else {
                cnvColaboradorCad.anterior();
                atualizarTabelaCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_anteriorActionPerformed

    private void proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoActionPerformed
        try {
            if (cnvColaboradorCad == null) {
                atualizaTabela();
            } else {
                cnvColaboradorCad.proximo();
                atualizarTabelaCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_proximoActionPerformed

    private void ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ultimoActionPerformed
        try {
            if (cnvColaboradorCad == null) {
                atualizaTabela();
            } else {
                cnvColaboradorCad.ultimo();
                atualizarTabelaCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_ultimoActionPerformed

    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed
        cargo = new Cargo();
        turno= new Turno();
        limpaCampos();
        descCargo.requestFocus();
    }//GEN-LAST:event_novoActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        try {
            salvar();
            atualizaTabela();
            JOptionPane.showMessageDialog(this, " Cadastro realizado com Sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_salvarActionPerformed
  
    private void salvar() throws Exception {
      
        try {
            if (codigo.getText().length() > 0) {
                cargo = cargoDao.get(ValidarValor.getInt(codigo.getText()));
            }
            
            if (cargo == null) {
                cargo = new Cargo();
                cargo.setDataCadastro(new Date());
            }
           cargo.setDataAtualizacao(new Date());

            if(turno == null){
                throw  new Exception("Por favor, inserir um Turno");
            }
            
            setCargo();
            cargo = cargoDao.addCargo(cargo);
            
        } catch(Exception e){
            e.printStackTrace();
            throw new Exception(" Erro ao Salvar ");
        }
    }
    
    private void setCargo() {
        cargo.setTurno(turno);
        cargo.setDescricao(descCargo.getText());
        cargo.setEspecificacao(especificacao.getText());
        cargo.setFuncao(funcao.getText());
        cargo.setCrm(crm.getText());
    }
    
    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed
        try {
            if (cargo != null) {
                Integer resp = JOptionPane.showConfirmDialog(this, "Deseja realmente deletar esse Cargo.");
                if (resp == 0) {
                    cargoDao.deletePojo(cargo);
                    limpaCampos();
                    atualizaTabela();
                }
            } else {
                throw new Exception(" Por Favor, Selecione um Cargo.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_deletarActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void tabCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabCargoMouseClicked
       if (evt.getClickCount() > 1) {
            codigo.setText(("" + tabCargo.getValueAt(tabCargo.getSelectedRow(), 0)));
            codigoFocusLost(null);
        }
    }//GEN-LAST:event_tabCargoMouseClicked

    private void codigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoFocusLost
         try {
            carregaCargo();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        } 
    }//GEN-LAST:event_codigoFocusLost
    
    private void carregaTurno() throws Exception {
        turno = TurnoDao.get(ValidarValor.getInt(codTurno.getText()));
        if(turno!=null){
            descTurno.setText(turno.getDescricao());
        }else{
            descTurno.setText("");
            codTurno.setText("");
        }
    }

    private void carregaCargo() throws Exception {
        cargo = cargoDao.get(ValidarValor.getInt(codigo.getText()));
        if (cargo != null) {
            descCargo.setText(cargo.getDescricao());
            codTurno.setText(cargo.getTurno().getCodTurno().toString());
            carregaTurno();
            crm.setText(cargo.getCrm());
            funcao.setText(cargo.getFuncao());
            especificacao.setText(cargo.getEspecificacao());
        } else {
            limpaCampos();
        }

    }

    
    private void atualizarTabelaCad() {

        DefaultTableModel model = (DefaultTableModel) tabCargo.getModel();
        removeLinhas(tabCargo);

        List<?> lv;

        lv = cnvColaboradorCad.getLista();

        if (lv != null && !lv.isEmpty()) {

            for (Object o : lv) {
                Object[] os = (Object[]) o;
                model.addRow(os);

            }
        }
    }
    
     private void atualizaTabela() {
        try {

            if (cnvColaboradorCad == null) {
                cnvColaboradorCad = new CnvCadastroCargo();
            }

            cnvColaboradorCad.iniciarNavTabela();

            cnvColaboradorCad.primeiro();
            atualizarTabelaCad();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    

    public static void removeLinhas(JTable table) {
        int n = table.getRowCount();

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (int i = n - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private void limpaCampos() {
        codigo.setText("");
        descCargo.setText("");
        codTurno.setText("");
        descTurno.setText("");
        crm.setText("");
        funcao.setText("");
        especificacao.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anterior;
    private javax.swing.JTextField codTurno;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField crm;
    private javax.swing.JButton deletar;
    private javax.swing.JTextField descCargo;
    private javax.swing.JTextField descTurno;
    private javax.swing.JTextArea especificacao;
    private javax.swing.JTextArea funcao;
    private javax.swing.JButton inicio;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JButton novo;
    private javax.swing.JButton proximo;
    private javax.swing.JButton sair;
    private javax.swing.JButton salvar;
    private javax.swing.JTable tabCargo;
    private javax.swing.JButton ultimo;
    // End of variables declaration//GEN-END:variables

   

    
  
}
