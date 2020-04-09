/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.cadastro;

import graficaatual.daos.cadsatro.ProdutoDAO;
import graficaatual.entidades.Produto;
import graficaatual.pesq.cadastro.CnvProduto;
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
public class FCadProduto extends javax.swing.JPanel {

    /**
     * Creates new form FCadProduto
     */
    private Produto produto;
    private ProdutoDAO produtoDao = new ProdutoDAO();
    private List<Produto> lista = null;
    private CnvProduto cnvProduto = new CnvProduto();

    private static FCadProduto instancia;

    public static FCadProduto getInstancia() {
        if (instancia == null) {
            instancia = new FCadProduto();
        }

        return instancia;
    }

    public FCadProduto() {
        initComponents();

        lista = ObservableCollections.observableList(new LinkedList<Produto>());
        Componentes comp2 = new Componentes(lista, false, codProduto, descProduto, this, jPanel18, descProduto.getWidth(), 100);
        comp2.addCol(0, "codProduto", "Código", 50, Long.class.getName());
        comp2.addCol(1, "descricao", "Nome do Produto", 200, String.class.getName());
        comp2.bind();
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
        codProduto = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        descProduto = new javax.swing.JTextField();
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
        tabProduto = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        ultimo = new javax.swing.JButton();
        proximo = new javax.swing.JButton();
        anterior = new javax.swing.JButton();
        inicio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabComposicao = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        valorProduto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        maoDeObra = new javax.swing.JTextField();
        custoEmpresa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setLayout(null);

        codProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codProdutoFocusLost(evt);
            }
        });
        jPanel18.add(codProduto);
        codProduto.setBounds(60, 90, 80, 20);

        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel78.setText("Código ");
        jPanel18.add(jLabel78);
        jLabel78.setBounds(60, 70, 60, 20);

        descProduto.setBackground(new java.awt.Color(255, 255, 204));
        descProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descProdutoKeyReleased(evt);
            }
        });
        jPanel18.add(descProduto);
        descProduto.setBounds(140, 90, 810, 20);

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
        btNovo.setBounds(140, 350, 180, 23);

        btSalvar.setText("Salvar/Atualizar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel18.add(btSalvar);
        btSalvar.setBounds(320, 350, 180, 23);

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel18.add(btExcluir);
        btExcluir.setBounds(500, 350, 180, 23);

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel18.add(btSair);
        btSair.setBounds(680, 350, 180, 23);

        tabProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto"
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
        tabProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabProdutoMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tabProduto);

        jPanel18.add(jScrollPane11);
        jScrollPane11.setBounds(20, 390, 930, 100);

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
        jLabel1.setText("CADASTRO DE PRODUTO");
        jPanel18.add(jLabel1);
        jLabel1.setBounds(0, 0, 970, 70);

        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel80.setText("Produto");
        jPanel18.add(jLabel80);
        jLabel80.setBounds(140, 70, 70, 20);

        tabComposicao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código Material", "Material", "Valor Unitário (R$)", "Quantidade", "Total (R$)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabComposicao);

        jPanel18.add(jScrollPane1);
        jScrollPane1.setBounds(20, 140, 930, 110);

        jLabel2.setText("Valor Produto m²");
        jPanel18.add(jLabel2);
        jLabel2.setBounds(20, 280, 110, 14);

        valorProduto.setText("0,00");
        jPanel18.add(valorProduto);
        valorProduto.setBounds(20, 300, 120, 20);

        jLabel3.setText("Mão De Obra m²");
        jPanel18.add(jLabel3);
        jLabel3.setBounds(160, 280, 90, 14);

        maoDeObra.setText("0,00");
        jPanel18.add(maoDeObra);
        maoDeObra.setBounds(160, 300, 120, 20);

        custoEmpresa.setText("0,00");
        jPanel18.add(custoEmpresa);
        custoEmpresa.setBounds(300, 300, 130, 20);

        jLabel4.setText("Custo Empresa m² / hora");
        jPanel18.add(jLabel4);
        jLabel4.setBounds(300, 280, 120, 14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 965, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void codProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codProdutoFocusLost
        try {
            produto = produtoDao.getPorCodigo(ValidarValor.getLong(codProduto.getText()));
            if (produto != null) {
                descProduto.setText(produto.getDescricao());
            } else {
                produto = new Produto();
                descProduto.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_codProdutoFocusLost

    private void descProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descProdutoKeyReleased
        try {
            List<Produto> merged = produtoDao.getList(15, "select e from Produto e where 1=1 and REPLACE(REPLACE(REPLACE(trim(e.descricao),'.',''),'-',''),' ', '') "
                    + " like ?1 order by e.descricao", descProduto.getText().trim().toLowerCase().replace(".", "").replace("-", "").trim() + "%");
            lista.clear();
            lista.addAll(merged);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar produtos. Erro: " + e);
        }
    }//GEN-LAST:event_descProdutoKeyReleased

    private void atualizarTabela() {

        DefaultTableModel model = (DefaultTableModel) tabProduto.getModel();
        removeLinhas(tabProduto);

        List<?> lv;

        lv = cnvProduto.getLista();

        if (lv != null && !lv.isEmpty()) {

            for (Object o : lv) {
                Object[] os = (Object[]) o;
                model.addRow(os);
                //Colocar tamanho nas colunas

            }
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
            codProduto.setText("" + produtoDao.getNextItem());
            codProduto.setEnabled(false);
            descProduto.setText("");
            produto = new Produto();
            removeLinhas(tabProduto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        try {
            if (produto == null) {
                produto = new Produto();
                produto.setDataCadastro(new Date());
                produto.setDataAtualizacao(new Date());
            } else {
                produto.setDataAtualizacao(new Date());
            }
            produto.setCodProduto(Long.parseLong(codProduto.getText()));
            produto.setDescricao(descProduto.getText());

            if (produtoDao.salvar(produto) != null) {
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            }

            codProduto.setEnabled(true);
            atualizarTabela();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar produto. Erro: " + e);
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        try {
            if (produto == null) {
                throw new Exception("Erro: produto inválido!");
            }
            int op = 0;
            JOptionPane.showConfirmDialog(null, "Deseja realmente excluir produto selecionado?", "CONFIRMAÇÃO DE EXCLUSÃO", op);

            // considerando 0 como sim
            if (op == 0) {

                produtoDao.delete(produto);

                codProduto.setText("");
                descProduto.setText("");
                atualizarTabela();

            } else {
                return;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir produto. Erro: " + e);
        }
    }//GEN-LAST:event_btExcluirActionPerformed


    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSairActionPerformed

    private void tabProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabProdutoMouseClicked
        if (evt.getClickCount() > 1) {
            codProduto.setText(("" + tabProduto.getValueAt(tabProduto.getSelectedRow(), 0)));
            codProdutoFocusLost(null);
            descProduto.requestFocus();
        }
    }//GEN-LAST:event_tabProdutoMouseClicked

    private void ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ultimoActionPerformed
        try {
            cnvProduto.ultimo();
        } catch (Exception e) {
             e.printStackTrace();
        }    
    }//GEN-LAST:event_ultimoActionPerformed

    private void proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoActionPerformed
        try {
            cnvProduto.proximo();
        } catch (Exception e) {
             e.printStackTrace();
        }       
    }//GEN-LAST:event_proximoActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        try {
            cnvProduto.anterior();
        } catch (Exception e) {
             e.printStackTrace();
        }    
    }//GEN-LAST:event_anteriorActionPerformed

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        try {
            cnvProduto.primeiro();
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
    private javax.swing.JTextField codProduto;
    private javax.swing.JTextField custoEmpresa;
    private javax.swing.JTextField descProduto;
    private javax.swing.JButton inicio;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JTextField maoDeObra;
    private javax.swing.JButton proximo;
    private javax.swing.JTable tabComposicao;
    private javax.swing.JTable tabProduto;
    private javax.swing.JButton ultimo;
    private javax.swing.JTextField valorProduto;
    // End of variables declaration//GEN-END:variables
}
