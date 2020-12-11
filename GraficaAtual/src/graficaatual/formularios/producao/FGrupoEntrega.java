/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.producao;


import graficaatual.daos.cadastro.ColaboradorDAO;
import graficaatual.daos.producao.EquipeEntregaDAO;
import graficaatual.entidades.Colaborador;
import graficaatual.entidades.ControleAcesso;
import graficaatual.entidades.producao.EquipeEntrega;
import graficaatual.pesq.Producao.CnvEquipe;
import graficaatual.pesq.cadastro.CnvCadastroColaborador;
import graficaatual.utilitarios.Componentes;
import graficaatual.utilitarios.ValidarValor;
import graficaatual.utilitarios.VisualizaRelatorio;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author si10
 */
public class FGrupoEntrega extends javax.swing.JInternalFrame {

    // Tela
    private static int initControle;
    private static FGrupoEntrega instance;

    //Entidades
    private Colaborador colaborador1 = null;
    private Colaborador colaborador2 = null;
    private Colaborador colaborador3 = null;
    private Colaborador colaborador4 = null;
    private ColaboradorDAO colaboradorDao = new ColaboradorDAO();
     
    private EquipeEntrega equipe = null;
    private EquipeEntregaDAO equipeDao = new EquipeEntregaDAO();
    
    // Lista Suspensa
    private List<Colaborador> listaColaboradorNome1 = null;
    private List<Colaborador> listaColaboradorNome2 = null;
    private List<Colaborador> listaColaboradorNome3 = null;
    private List<Colaborador> listaColaboradorNome4 = null;
    private List<EquipeEntrega> listaEquipe = null;


    //Controle de Navegação
    CnvEquipe cnvEquipe = new CnvEquipe();
            
            
    public FGrupoEntrega() {
        initComponents();
        
        listaEquipe = ObservableCollections.observableList(new LinkedList<EquipeEntrega>());
        Componentes comp = new Componentes(listaEquipe, false, codigo, nome, this, jPanel10, nome.getWidth(), 100);
        comp.addCol(0, "codEquipeEntrega", " Código ", 50, Integer.class.getName());
        comp.addCol(1, "nome", " Nome ", 200, String.class.getName());
        comp.bind();
        
        listaColaboradorNome1 = ObservableCollections.observableList(new LinkedList<Colaborador>());
        Componentes comp1 = new Componentes(listaColaboradorNome1, false, codigo1, nome1, this, jPanel10, nome1.getWidth(), 100);
        comp1.addCol(0, "codColaborador", " Código ", 50, Integer.class.getName());
        comp1.addCol(1, "pessoa.nome", " Nome ", 200, String.class.getName());
        comp1.bind();

        listaColaboradorNome2 = ObservableCollections.observableList(new LinkedList<Colaborador>());
        Componentes comp2 = new Componentes(listaColaboradorNome2, false, codigo2, nome2, this, jPanel10, nome2.getWidth(), 100);
        comp2.addCol(0, "codColaborador", " Código ", 50, Integer.class.getName());
        comp2.addCol(1, "pessoa.nome", " Nome ", 200, String.class.getName());
        comp2.bind();
        
        listaColaboradorNome3 = ObservableCollections.observableList(new LinkedList<Colaborador>());
        Componentes comp3 = new Componentes(listaColaboradorNome3, false, codigo3, nome3, this, jPanel10, nome3.getWidth(), 100);
        comp3.addCol(0, "codColaborador", " Código ", 50, Integer.class.getName());
        comp3.addCol(1, "pessoa.nome", " Nome ", 200, String.class.getName());
        comp3.bind();
        
        listaColaboradorNome4 = ObservableCollections.observableList(new LinkedList<Colaborador>());
        Componentes comp4 = new Componentes(listaColaboradorNome4, false, codigo4, nome4, this, jPanel10, nome4.getWidth(), 100);
        comp4.addCol(0, "codColaborador", " Código ", 50, Integer.class.getName());
        comp4.addCol(1, "pessoa.nome", " Nome ", 200, String.class.getName());
        comp4.bind();
      
        habilitaCampos(false);
        cancelado.setVisible(false);
        atualizaTabelaEquipe();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        
    }
    
    public static int isInicializado() {
        return initControle;
    }
         
  public synchronized static FGrupoEntrega getInstance() {
        if (instance == null) {
            instance = new FGrupoEntrega();
            initControle = 1;
        }
        return instance;
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        codigo = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        telefone1 = new javax.swing.JTextField();
        placaCarro = new javax.swing.JTextField();
        capacidade = new javax.swing.JTextField();
        modeloCarro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        obs = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabEquipe = new javax.swing.JTable();
        inicio = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        proximo = new javax.swing.JButton();
        ultimo = new javax.swing.JButton();
        novo = new javax.swing.JButton();
        salvar = new javax.swing.JButton();
        inativar = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        telefone2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        codigo1 = new javax.swing.JTextField();
        nome2 = new javax.swing.JTextField();
        codigo2 = new javax.swing.JTextField();
        nome3 = new javax.swing.JTextField();
        codigo3 = new javax.swing.JTextField();
        codigo4 = new javax.swing.JTextField();
        nome4 = new javax.swing.JTextField();
        nome1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        cancelado = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Colaborador");
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setPreferredSize(new java.awt.Dimension(1100, 700));
        setRequestFocusEnabled(false);
        getContentPane().setLayout(null);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setToolTipText("Cadastro de Pessoas");
        jPanel10.setMaximumSize(new java.awt.Dimension(999999, 99999));
        jPanel10.setMinimumSize(new java.awt.Dimension(1100, 700));
        jPanel10.setName(""); // NOI18N
        jPanel10.setPreferredSize(new java.awt.Dimension(1100, 700));
        jPanel10.setLayout(null);

        codigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigoFocusLost(evt);
            }
        });
        jPanel10.add(codigo);
        codigo.setBounds(30, 90, 110, 20);

        nome.setBackground(new java.awt.Color(255, 255, 204));
        nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeKeyReleased(evt);
            }
        });
        jPanel10.add(nome);
        nome.setBounds(140, 90, 530, 20);
        jPanel10.add(telefone1);
        telefone1.setBounds(670, 90, 120, 20);
        jPanel10.add(placaCarro);
        placaCarro.setBounds(30, 130, 110, 20);
        jPanel10.add(capacidade);
        capacidade.setBounds(910, 130, 120, 20);
        jPanel10.add(modeloCarro);
        modeloCarro.setBounds(140, 130, 770, 20);

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Colaborador 1:");
        jPanel10.add(jLabel13);
        jLabel13.setBounds(30, 180, 80, 20);

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Observação: ");
        jPanel10.add(jLabel15);
        jLabel15.setBounds(30, 270, 100, 20);

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Telefone 1");
        jPanel10.add(jLabel9);
        jLabel9.setBounds(670, 70, 90, 20);

        jLabel71.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel71.setText("Nome");
        jPanel10.add(jLabel71);
        jLabel71.setBounds(140, 70, 80, 20);

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Placa de Carro");
        jPanel10.add(jLabel12);
        jLabel12.setBounds(30, 110, 80, 20);

        jLabel27.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Capacidade (KG)");
        jPanel10.add(jLabel27);
        jLabel27.setBounds(910, 110, 120, 20);

        jLabel26.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Modelo de Carro");
        jPanel10.add(jLabel26);
        jLabel26.setBounds(140, 110, 80, 20);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CADASTRO DE EQUIPE ENTREGA");
        jPanel10.add(jLabel2);
        jLabel2.setBounds(0, 0, 1100, 70);

        obs.setColumns(20);
        obs.setRows(2);
        jScrollPane4.setViewportView(obs);

        jPanel10.add(jScrollPane4);
        jScrollPane4.setBounds(30, 290, 1000, 130);

        tabEquipe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Placa", "Telefone1", "Telefone2", "Ativo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabEquipe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabEquipeMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabEquipe);

        jPanel10.add(jScrollPane3);
        jScrollPane3.setBounds(20, 490, 1000, 140);

        inicio.setText("||<<");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });
        jPanel10.add(inicio);
        inicio.setBounds(390, 630, 57, 30);

        anterior.setText("<<");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });
        jPanel10.add(anterior);
        anterior.setBounds(450, 630, 49, 30);

        proximo.setText(">>");
        proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoActionPerformed(evt);
            }
        });
        jPanel10.add(proximo);
        proximo.setBounds(500, 630, 49, 30);

        ultimo.setText(">>||");
        ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ultimoActionPerformed(evt);
            }
        });
        jPanel10.add(ultimo);
        ultimo.setBounds(550, 630, 57, 30);

        novo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/NOVO2.png"))); // NOI18N
        novo.setText("Novo Cadastro");
        novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoActionPerformed(evt);
            }
        });
        jPanel10.add(novo);
        novo.setBounds(180, 440, 180, 40);

        salvar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar2.png"))); // NOI18N
        salvar.setText("Salvar/Atualizar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });
        jPanel10.add(salvar);
        salvar.setBounds(360, 440, 180, 40);

        inativar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        inativar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excuir2.png"))); // NOI18N
        inativar.setText("Inativar");
        inativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inativarActionPerformed(evt);
            }
        });
        jPanel10.add(inativar);
        inativar.setBounds(540, 440, 180, 40);

        sair.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAIR2.png"))); // NOI18N
        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        jPanel10.add(sair);
        sair.setBounds(720, 440, 180, 40);

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Telefone 2");
        jPanel10.add(jLabel10);
        jLabel10.setBounds(790, 70, 90, 20);
        jPanel10.add(telefone2);
        telefone2.setBounds(790, 90, 120, 20);

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Colaborador 4:");
        jPanel10.add(jLabel14);
        jLabel14.setBounds(30, 240, 80, 20);

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Código");
        jPanel10.add(jLabel18);
        jLabel18.setBounds(30, 70, 80, 20);

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Colaborador 2:");
        jPanel10.add(jLabel16);
        jLabel16.setBounds(30, 200, 80, 20);

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Colaborador 3:");
        jPanel10.add(jLabel17);
        jLabel17.setBounds(30, 220, 80, 20);

        codigo1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigo1FocusLost(evt);
            }
        });
        jPanel10.add(codigo1);
        codigo1.setBounds(110, 180, 110, 20);

        nome2.setBackground(new java.awt.Color(255, 255, 204));
        nome2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nome2KeyReleased(evt);
            }
        });
        jPanel10.add(nome2);
        nome2.setBounds(220, 200, 810, 20);

        codigo2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigo2FocusLost(evt);
            }
        });
        jPanel10.add(codigo2);
        codigo2.setBounds(110, 200, 110, 20);

        nome3.setBackground(new java.awt.Color(255, 255, 204));
        nome3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nome3KeyReleased(evt);
            }
        });
        jPanel10.add(nome3);
        nome3.setBounds(220, 220, 810, 20);

        codigo3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigo3FocusLost(evt);
            }
        });
        jPanel10.add(codigo3);
        codigo3.setBounds(110, 220, 110, 20);

        codigo4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigo4FocusLost(evt);
            }
        });
        jPanel10.add(codigo4);
        codigo4.setBounds(110, 240, 110, 20);

        nome4.setBackground(new java.awt.Color(255, 255, 204));
        nome4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nome4KeyReleased(evt);
            }
        });
        jPanel10.add(nome4);
        nome4.setBounds(220, 240, 810, 20);

        nome1.setBackground(new java.awt.Color(255, 255, 204));
        nome1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nome1KeyReleased(evt);
            }
        });
        jPanel10.add(nome1);
        nome1.setBounds(220, 180, 810, 20);

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Código");
        jPanel10.add(jLabel19);
        jLabel19.setBounds(110, 160, 80, 20);

        jLabel73.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel73.setText("Nome");
        jPanel10.add(jLabel73);
        jLabel73.setBounds(220, 160, 80, 20);

        cancelado.setBackground(new java.awt.Color(255, 0, 0));
        cancelado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cancelado.setForeground(new java.awt.Color(255, 255, 255));
        cancelado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelado.setText("CANCELADO");
        cancelado.setOpaque(true);
        jPanel10.add(cancelado);
        cancelado.setBounds(910, 90, 140, 20);

        getContentPane().add(jPanel10);
        jPanel10.setBounds(0, 0, 1100, 700);
        jPanel10.getAccessibleContext().setAccessibleName("Cadastro de Pessoas");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoFocusLost
        try {
            equipe = equipeDao.get(ValidarValor.getInt(codigo.getText()));
            if(equipe!=null){
                
                carregaEquipe();
                
                if(equipe.getDataCancelamento()!=null){
                    cancelado.setVisible(true);
                    habilitaCampos(false);
                    inativar.setEnabled(false);
                    salvar.setEnabled(true);
                }else{
                    cancelado.setVisible(false);
                    habilitaCampos(true);
                    inativar.setEnabled(true);
                }
            }else{
                JOptionPane.showMessageDialog(this, " Equipe não existe. ");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        } 
    }//GEN-LAST:event_codigoFocusLost

    private void nomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeKeyReleased
        try {
            List<EquipeEntrega> merged = equipeDao.getList(12,
                    "select e from EquipeEntrega e where  lower ( trim(e.nome) ) like ?1 order by e.nome",
                    nome.getText().trim().toLowerCase() + "%");
            listaEquipe.clear();
            listaEquipe.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Colaborador. Erro: " + e);
        }
            
    }//GEN-LAST:event_nomeKeyReleased

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        try {
            if (cnvEquipe == null) {
                atualizaTabelaEquipe();
            } else {
                cnvEquipe.primeiro();
                atualizarTabelaEquipeCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_inicioActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        try {
            if (cnvEquipe == null) {
                atualizaTabelaEquipe();
            } else {
                cnvEquipe.anterior();
                atualizarTabelaEquipeCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_anteriorActionPerformed

    private void proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoActionPerformed
        try {
            if (cnvEquipe == null) {
                atualizaTabelaEquipe();
            } else {
                cnvEquipe.proximo();
                atualizarTabelaEquipeCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_proximoActionPerformed

    private void ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ultimoActionPerformed
        try {
            if (cnvEquipe == null) {
                atualizaTabelaEquipe();
            } else {
                cnvEquipe.ultimo();
                atualizarTabelaEquipeCad();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_ultimoActionPerformed

    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed
        colaborador1 = null;
        colaborador2 = null;
        colaborador3 = null;
        colaborador4 = null;
        equipe = null;
        limpaCampos();
        habilitaCampos(true);

    }//GEN-LAST:event_novoActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        try {
            equipe = equipeDao.get(ValidarValor.getInt(codigo.getText()));
            if(equipe==null){
                equipe = new EquipeEntrega();
                equipe.setUsuarioCadastro( ControleAcesso.usuario.getCodUsuario()+" "+ ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                equipe.setDataCadastro(new Date());
            }
            
            setGrupo();
            equipe = equipeDao.addEquipe(equipe);
            codigo.setText(equipe.getCodEquipeEntrega()+"");
            
            atualizaTabelaEquipe();

            
            JOptionPane.showMessageDialog(this, " Cadastro realizado com Sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_salvarActionPerformed
  
   
   
    private void inativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inativarActionPerformed
        try {
            equipe = equipeDao.get(ValidarValor.getInt(codigo.getText()));
            if(equipe!=null){
                equipe.setUsuarioCancelamento( ControleAcesso.usuario.getCodUsuario()+" "+ ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                equipe.setDataCancelamento(new Date());
                equipe = equipeDao.addEquipe(equipe);
                habilitaCampos(false);
                cancelado.setVisible(true);
            }else{
                throw new Exception(" Selecione uma Equipe.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_inativarActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void tabEquipeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabEquipeMouseClicked
        if (evt.getClickCount() > 1) {
            codigo.setText(("" + tabEquipe.getValueAt(tabEquipe.getSelectedRow(), 0)));
            codigoFocusLost(null);
        }
    }//GEN-LAST:event_tabEquipeMouseClicked

    private void codigo1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigo1FocusLost
       try {
           colaborador1 = colaboradorDao.get(ValidarValor.getInt(codigo1.getText()));
           if(colaborador1!=null){
               carregaColaborador(codigo1, nome1, colaborador1);
           }else{
               limpaColaborador(codigo1, nome1);
           }
       
       }catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Colaborador. Erro: " + e);
        }
    }//GEN-LAST:event_codigo1FocusLost

    private void nome2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nome2KeyReleased
        try {
            List<Colaborador> merged = colaboradorDao.getList(12,
                    "select e from Colaborador e where  lower ( trim(e.pessoa.nome) ) like ?1 order by e.pessoa.nome",
                    nome2.getText().trim().toLowerCase() + "%");
            listaColaboradorNome2.clear();
            listaColaboradorNome2.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Colaborador. Erro: " + e);
        }
    }//GEN-LAST:event_nome2KeyReleased

    private void codigo2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigo2FocusLost
        try {
            colaborador2 = colaboradorDao.get(ValidarValor.getInt(codigo2.getText()));
            if (colaborador2 != null) {
                carregaColaborador(codigo2, nome2, colaborador2);
            } else {
                limpaColaborador(codigo2, nome2);
            }

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Colaborador. Erro: " + e);
        }
    }//GEN-LAST:event_codigo2FocusLost

    private void nome3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nome3KeyReleased
           try {
            List<Colaborador> merged = colaboradorDao.getList(12,
                    "select e from Colaborador e where  lower ( trim(e.pessoa.nome) ) like ?1 order by e.pessoa.nome",
                    nome3.getText().trim().toLowerCase() + "%");
            listaColaboradorNome3.clear();
            listaColaboradorNome3.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Colaborador. Erro: " + e);
        }
    }//GEN-LAST:event_nome3KeyReleased

    private void codigo3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigo3FocusLost
        try {
            colaborador3 = colaboradorDao.get(ValidarValor.getInt(codigo3.getText()));
            if (colaborador3 != null) {
                carregaColaborador(codigo3, nome3, colaborador3);
            } else {
                limpaColaborador(codigo3, nome3);
            }

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Colaborador. Erro: " + e);
        }
    }//GEN-LAST:event_codigo3FocusLost

    private void codigo4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigo4FocusLost
        try {
            colaborador4 = colaboradorDao.get(ValidarValor.getInt(codigo4.getText()));
            if (colaborador4 != null) {
                carregaColaborador(codigo4, nome4, colaborador4);
            } else {
                limpaColaborador(codigo4, nome4);
            }

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Colaborador. Erro: " + e);
        }
    }//GEN-LAST:event_codigo4FocusLost

    private void nome4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nome4KeyReleased
        try {
            List<Colaborador> merged = colaboradorDao.getList(12,
                    "select e from Colaborador e where  lower ( trim(e.pessoa.nome) ) like ?1 order by e.pessoa.nome",
                    nome4.getText().trim().toLowerCase() + "%");
            listaColaboradorNome4.clear();
            listaColaboradorNome4.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Colaborador. Erro: " + e);
        }
    }//GEN-LAST:event_nome4KeyReleased

    private void nome1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nome1KeyReleased
        try {
            List<Colaborador> merged = colaboradorDao.getList(12,
                    "select e from Colaborador e where  lower ( trim(e.pessoa.nome) ) like ?1 order by e.pessoa.nome",
                    nome1.getText().trim().toLowerCase() + "%");
            listaColaboradorNome1.clear();
            listaColaboradorNome1.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar Colaborador. Erro: " + e);
        }
    }//GEN-LAST:event_nome1KeyReleased

      
   
    private void atualizarTabelaEquipeCad() {

        DefaultTableModel model = (DefaultTableModel) tabEquipe.getModel();
        removeLinhas(tabEquipe);

        List<?> lv;

        lv = cnvEquipe.getLista();

        if (lv != null && !lv.isEmpty()) {

            for (Object o : lv) {
                Object[] os = (Object[]) o;
                model.addRow(os);

            }
        }
    }
    
     private void atualizaTabelaEquipe() {
        try {

            if (cnvEquipe == null) {
                cnvEquipe = new CnvEquipe();
            }

            cnvEquipe.iniciarNavTabela();

            cnvEquipe.primeiro();
            atualizarTabelaEquipeCad();

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
    
    
    private void habilitaCampos(boolean b) {
        codigo.setEnabled(b);
        nome.setEnabled(b);
        telefone1.setEnabled(b);
        telefone2.setEnabled(b);
        placaCarro.setEnabled(b);
        modeloCarro.setEnabled(b);
        capacidade.setEnabled(b);
        codigo1.setEnabled(b);
        codigo2.setEnabled(b);
        codigo3.setEnabled(b);
        codigo4.setEnabled(b);
        nome1.setEnabled(b);
        nome2.setEnabled(b);
        nome3.setEnabled(b);
        nome4.setEnabled(b);
        obs.setEnabled(b);
        salvar.setEnabled(b);
        inativar.setEnabled(!b);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anterior;
    private javax.swing.JLabel cancelado;
    private javax.swing.JTextField capacidade;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField codigo1;
    private javax.swing.JTextField codigo2;
    private javax.swing.JTextField codigo3;
    private javax.swing.JTextField codigo4;
    private javax.swing.JButton inativar;
    private javax.swing.JButton inicio;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField modeloCarro;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField nome1;
    private javax.swing.JTextField nome2;
    private javax.swing.JTextField nome3;
    private javax.swing.JTextField nome4;
    private javax.swing.JButton novo;
    private javax.swing.JTextArea obs;
    private javax.swing.JTextField placaCarro;
    private javax.swing.JButton proximo;
    private javax.swing.JButton sair;
    private javax.swing.JButton salvar;
    private javax.swing.JTable tabEquipe;
    private javax.swing.JTextField telefone1;
    private javax.swing.JTextField telefone2;
    private javax.swing.JButton ultimo;
    // End of variables declaration//GEN-END:variables

     private void imprimir()throws Exception{
         String r = colaboradorDao.getSqlLista(0,99999999);  
            new VisualizaRelatorio().visRel("graficaatual/relatorios/arquivos/listaColaborador.jasper", "Relatório de Lista de Colaborador", null, r);
    }

    private void limpaCampos() {
        codigo.setText("");
        nome.setText("");
        telefone1.setText("");
        telefone2.setText("");
        placaCarro.setText("");
        modeloCarro.setText("");
        capacidade.setText("");
        codigo1.setText("");
        codigo2.setText("");
        codigo3.setText("");
        codigo4.setText("");
        nome1.setText("");
        nome2.setText("");
        nome3.setText("");
        nome4.setText("");
        obs.setText("");
        cancelado.setVisible(false);
    }

    private void setGrupo() {
        equipe.setNome(nome.getText());
        equipe.setTelefone1(telefone1.getText());
        equipe.setTelefone2(telefone2.getText());
        equipe.setPlacaCarro(placaCarro.getText());
        equipe.setModeloCarro(modeloCarro.getText());
        equipe.setCapacidade(ValidarValor.getDouble(capacidade.getText()));
        equipe.setObservacao(obs.getText());
        equipe.setColaborador1(colaborador1);
        equipe.setColaborador2(colaborador2);
        equipe.setColaborador3(colaborador3);
        equipe.setColaborador4(colaborador4);
    }

    private void carregaColaborador(JTextField cod, JTextField n, Colaborador cobo) {
        cod.setText(cobo.getCodColaborador() + "");
        n.setText(cobo.getPessoa().getNome());
    }

    private void limpaColaborador(JTextField cod, JTextField n) {
        cod.setText("");
        n.setText("");
    }

    private void carregaEquipe() {
        codigo.setText(equipe.getCodEquipeEntrega()+"");
        nome.setText(equipe.getNome());
        telefone1.setText(equipe.getTelefone1());
        telefone2.setText(equipe.getTelefone2());
        placaCarro.setText(equipe.getPlacaCarro());
        modeloCarro.setText(equipe.getModeloCarro());
        capacidade.setText(ValidarValor.getDouble(equipe.getCapacidade()));
        
        if (equipe.getColaborador1() != null) {
            colaborador1 = equipe.getColaborador1();
            carregaColaborador(codigo1, nome1, colaborador1);
        } else {
            limpaColaborador(codigo1, nome1);
        }

        if (equipe.getColaborador2() != null) {
            colaborador2 = equipe.getColaborador2();
            carregaColaborador(codigo2, nome2, colaborador2);
        } else {
            limpaColaborador(codigo2, nome2);
        }

        if (equipe.getColaborador3() != null) {
            colaborador3 = equipe.getColaborador3();
            carregaColaborador(codigo3, nome3, colaborador3);
        } else {
            limpaColaborador(codigo3, nome3);
        }

        if (equipe.getColaborador4() != null) {
            colaborador4 = equipe.getColaborador4();
            carregaColaborador(codigo4, nome4, colaborador4);
        } else {
            limpaColaborador(codigo4, nome4);
        }

        obs.setText(equipe.getObservacao());
        cancelado.setVisible(false);
    }

   
}
