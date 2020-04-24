/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.cadastro;

import graficaatual.daos.cadastro.LogradouroDAO;
import graficaatual.entidades.Logradouro;
import graficaatual.pesq.cadastro.CnvLogradouro;
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
public class FCadLogradouro extends javax.swing.JInternalFrame {

    /**
     * Creates new form FCadLogradouro
     */
    private Logradouro logradouro;
    private LogradouroDAO logradouroDao = new LogradouroDAO();
    private List<Logradouro> lista = null;
    private CnvLogradouro cnvLogradouro = new CnvLogradouro();

    private static FCadLogradouro instancia;

    public static FCadLogradouro getInstancia() {
        if (instancia == null) {
            instancia = new FCadLogradouro();
        }

        return instancia;
    }

    public FCadLogradouro() {
        initComponents();

        lista = ObservableCollections.observableList(new LinkedList<Logradouro>());
        Componentes comp2 = new Componentes(lista, false, codLogradouro, descLogradouro, this, jPanel18, descLogradouro.getWidth(), 100);
        comp2.addCol(0, "codLogradouro", "Código", 50, Long.class.getName());
        comp2.addCol(1, "descricao", "Nome do Logradouro", 200, String.class.getName());
        comp2.bind();

        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        limparTela();
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
        codLogradouro = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        descLogradouro = new javax.swing.JTextField();
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
        tabLogradouro = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        ultimo = new javax.swing.JButton();
        proximo = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        inicio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1335, 700));
        setPreferredSize(new java.awt.Dimension(1335, 700));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setMinimumSize(new java.awt.Dimension(1335, 700));
        jPanel18.setLayout(null);

        codLogradouro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codLogradouro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codLogradouroFocusLost(evt);
            }
        });
        jPanel18.add(codLogradouro);
        codLogradouro.setBounds(60, 90, 80, 20);

        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel78.setText("Código ");
        jPanel18.add(jLabel78);
        jLabel78.setBounds(60, 70, 60, 20);

        descLogradouro.setBackground(new java.awt.Color(255, 255, 204));
        descLogradouro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descLogradouroKeyReleased(evt);
            }
        });
        jPanel18.add(descLogradouro);
        descLogradouro.setBounds(320, 90, 630, 20);

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
        btNovo.setBounds(140, 160, 180, 39);

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar2.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel18.add(btSalvar);
        btSalvar.setBounds(320, 160, 180, 39);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excuir2.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel18.add(btExcluir);
        btExcluir.setBounds(500, 160, 180, 39);

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAIR2.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel18.add(btSair);
        btSair.setBounds(680, 160, 180, 39);

        tabLogradouro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Tipo", "Logradouro"
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
        tabLogradouro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabLogradouroMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tabLogradouro);
        if (tabLogradouro.getColumnModel().getColumnCount() > 0) {
            tabLogradouro.getColumnModel().getColumn(0).setMinWidth(250);
            tabLogradouro.getColumnModel().getColumn(0).setPreferredWidth(250);
            tabLogradouro.getColumnModel().getColumn(0).setMaxWidth(250);
            tabLogradouro.getColumnModel().getColumn(1).setMinWidth(250);
            tabLogradouro.getColumnModel().getColumn(1).setPreferredWidth(250);
            tabLogradouro.getColumnModel().getColumn(1).setMaxWidth(250);
        }

        jPanel18.add(jScrollPane11);
        jScrollPane11.setBounds(20, 240, 930, 240);

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
        jLabel1.setText("CADASTRO DE LOGRADOURO");
        jPanel18.add(jLabel1);
        jLabel1.setBounds(0, 0, 1060, 70);

        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel80.setText("Logradouro: ");
        jPanel18.add(jLabel80);
        jLabel80.setBounds(320, 70, 170, 20);

        jLabel2.setText("Tipo");
        jPanel18.add(jLabel2);
        jLabel2.setBounds(150, 70, 150, 14);

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rua", "Avenida", "Praça", "Travessa", "Rodovia","Quadra", "Anel Rodoviário", "Beco", "Chácara", "Comunidade", "Condomínio", "Distrito", "Estrada", "Estacionamento", "Favela", "Fazenda", "Largo", "Lagoa", "Loteamento", "Lote", "Morro", "Passagem", "Ponte","Rancho", "Sítio", "Vila"  }));
        jPanel18.add(comboTipo);
        comboTipo.setBounds(140, 90, 180, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1319, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 1209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 110, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 722, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limparTela() {
        btNovo.requestFocus();
        codLogradouro.setText("");
        comboTipo.setSelectedIndex(0);
        //  codLogradouro.setEnabled(false);
        descLogradouro.setText("");
        logradouro = null;

        atualizarTabela();
    }


    private void codLogradouroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codLogradouroFocusLost
        try {
            logradouro = logradouroDao.getPorCodigo(ValidarValor.getLong(codLogradouro.getText()));
            if (logradouro != null) {
                descLogradouro.setText(logradouro.getDescricao());
            } else {
                logradouro = new Logradouro();
                descLogradouro.setText("");
                comboTipo.setSelectedIndex(logradouro.getTipo());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_codLogradouroFocusLost

    private void descLogradouroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descLogradouroKeyReleased
        try {

            List<Logradouro> merged = logradouroDao.getList(15, "select e from Logradouro e where lower (trim(e.descricao))   like ?1 order by e.descricao asc", (descLogradouro.getText().trim().toLowerCase() + "%"));
            lista.clear();
            lista.addAll(merged);

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar logradouros. Erro: " + e);
        }
    }//GEN-LAST:event_descLogradouroKeyReleased

    private void atualizarTabela() {
        try {
            DefaultTableModel model = (DefaultTableModel) tabLogradouro.getModel();
            removeLinhas(tabLogradouro);

            List<Logradouro> listaAux = logradouroDao.getList();
            if (listaAux.size() > 0) {
                model.setNumRows(0);
                for (Logradouro b : listaAux) {
                    Object o[] = new Object[]{
                        b.getCodLogradouro(),
                        buscaDescricaoTipoLogradouro(b.getTipo()),
                        b.getDescricao()};

                    model.addRow(o);
                }
            }
            tabLogradouro.setModel(model);
        } catch (Exception e) {
            removeLinhas(tabLogradouro);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar lista de logradouros cadastrados. Erro: " + e);

        }
    }

    private String buscaDescricaoTipoLogradouro(int tipo) {
        try {

            switch (tipo) {

                case 0:
                    return "Rua";
                case 1:
                    return "Praça";
                case 2:
                    return "Avenida";
                case 3:
                    return "Travessa";
                case 4:
                    return "Rodovia";
                case 5:
                    return "Anel Rodoviário";
                case 6:
                    return "Quadra";
                case 7:
                    return "Beco";
                    case 8:
                    return "Campo";
                case 9:
                    return "Chácara";
                case 10:
                    return "Comunidade";
                case 11:
                    return "Condomínio";
                case 12:
                    return "Distrito";
                case 13:
                    return "Estrada";
                case 14:
                    return "Estacionamento";
                case 15:
                    return "Favela";
                case 16:
                    return "Fazenda";
                case 17:
                    return "Largo";
                case 18:
                    return "Lagoa";
                case 19:
                    return "Loteamento";
                case 20:
                    return "Lote";
                case 21:
                    return "Morro";
                case 22:
                    return "Passagem";
                case 23:
                    return "Ponte";
                case 24:
                    return "Rancho";
                case 25:
                    return "Sítio";
                case 26:
                    return "Vila";
                    
                    default: return "";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
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

            limparTela();
            codLogradouro.setText("" + logradouroDao.getNextItem());
            comboTipo.requestFocus();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        try {
            if (logradouro == null) {
                logradouro = new Logradouro();
                logradouro.setDataCadastro(new Date());
                logradouro.setDataAtualizacao(new Date());
            } else {
                logradouro.setDataAtualizacao(new Date());
            }
            logradouro.setCodLogradouro(Long.parseLong(codLogradouro.getText()));
            logradouro.setDescricao(descLogradouro.getText());

            if (logradouroDao.salvar(logradouro) != null) {
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            }

            limparTela();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar logradouro. Erro: " + e);
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        try {
            if (logradouro == null) {
                throw new Exception("Erro: logradouro inválido!");
            }
            int op = 0;
            JOptionPane.showConfirmDialog(null, "Deseja realmente excluir logradouro selecionado?", "CONFIRMAÇÃO DE EXCLUSÃO", op);

            // considerando 0 como sim
            if (op == 0) {

                if (logradouroDao.delete(logradouro)) {
                    limparTela();
                }
            } else {
                return;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir logradouro. Erro: " + e);
        }
    }//GEN-LAST:event_btExcluirActionPerformed


    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        limparTela();
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void tabLogradouroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabLogradouroMouseClicked
        if (evt.getClickCount() > 1) {
            codLogradouro.setText(("" + tabLogradouro.getValueAt(tabLogradouro.getSelectedRow(), 0)));
            codLogradouroFocusLost(null);
            descLogradouro.requestFocus();
        }
    }//GEN-LAST:event_tabLogradouroMouseClicked

    private void ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ultimoActionPerformed
        try {
            cnvLogradouro.ultimo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ultimoActionPerformed

    private void proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoActionPerformed
        try {
            cnvLogradouro.proximo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_proximoActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        try {
            cnvLogradouro.anterior();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_anteriorActionPerformed

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        try {
            cnvLogradouro.primeiro();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_inicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anterior;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JTextField codLogradouro;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JTextField descLogradouro;
    private javax.swing.JButton inicio;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel78;
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
    private javax.swing.JButton proximo;
    private javax.swing.JTable tabLogradouro;
    private javax.swing.JButton ultimo;
    // End of variables declaration//GEN-END:variables
}
