/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual;

import graficaatual.formularios.financeiro.FCadBanco;
import graficaatual.formularios.financeiro.FCadFormaDePagamento;
import graficaatual.formularios.financeiro.FCadLancamento;
import graficaatual.formularios.financeiro.FCadSangria;
import graficaatual.formularios.pedido.FCadOrcamento;

import javax.swing.JOptionPane;

/**
 *
 * @author Moisés
 */
public class FFinanceiro extends javax.swing.JFrame {

    private static FFinanceiro instance;
    private static int initControle;

    public static int isInicializado() {
        return initControle;
    }

    public FFinanceiro() {

        initComponents();
        this.setLocationRelativeTo(null);

    }

    public static FFinanceiro getInstance() {

        if (instance == null) {
            instance = new FFinanceiro();
        }

        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        deskTop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jBCliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jBFornecedor = new javax.swing.JButton();
        jBLogradouro = new javax.swing.JButton();
        jBLogradouro1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Gráfica Atual - Módulo Cadastro");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(null);
        setName("FCadastro"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1310, 750));

        jPanel1.setBackground(new java.awt.Color(71, 37, 131));
        jPanel1.setMinimumSize(new java.awt.Dimension(1100, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 700));
        jPanel1.setLayout(null);

        deskTop.setMinimumSize(new java.awt.Dimension(1100, 700));
        deskTop.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                deskTopComponentResized(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/PEDIDOS COM FUNDO.jpg"))); // NOI18N
        deskTop.add(jLabel1);
        jLabel1.setBounds(280, 90, 550, 510);

        jPanel1.add(deskTop);
        deskTop.setBounds(220, 10, 1070, 700);

        jBCliente.setBackground(new java.awt.Color(71, 37, 131));
        jBCliente.setForeground(new java.awt.Color(255, 255, 255));
        jBCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pessoa2.png"))); // NOI18N
        jBCliente.setText("Lançamento de Caixa");
        jBCliente.setBorderPainted(false);
        jBCliente.setFocusPainted(false);
        jBCliente.setFocusable(false);
        jBCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBClienteActionPerformed(evt);
            }
        });
        jPanel1.add(jBCliente);
        jBCliente.setBounds(0, 180, 220, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LOGO Amarela sem Fundo2.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 20, 120, 110);

        jBFornecedor.setBackground(new java.awt.Color(71, 37, 131));
        jBFornecedor.setForeground(new java.awt.Color(255, 255, 255));
        jBFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pessoa2.png"))); // NOI18N
        jBFornecedor.setText("Sangrias");
        jBFornecedor.setBorderPainted(false);
        jBFornecedor.setFocusPainted(false);
        jBFornecedor.setFocusable(false);
        jBFornecedor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFornecedorActionPerformed(evt);
            }
        });
        jPanel1.add(jBFornecedor);
        jBFornecedor.setBounds(0, 220, 220, 30);

        jBLogradouro.setBackground(new java.awt.Color(71, 37, 131));
        jBLogradouro.setForeground(new java.awt.Color(255, 255, 255));
        jBLogradouro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pessoa2.png"))); // NOI18N
        jBLogradouro.setText("Formas de Pagamento");
        jBLogradouro.setBorderPainted(false);
        jBLogradouro.setFocusPainted(false);
        jBLogradouro.setFocusable(false);
        jBLogradouro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLogradouroActionPerformed(evt);
            }
        });
        jPanel1.add(jBLogradouro);
        jBLogradouro.setBounds(0, 300, 220, 30);

        jBLogradouro1.setBackground(new java.awt.Color(71, 37, 131));
        jBLogradouro1.setForeground(new java.awt.Color(255, 255, 255));
        jBLogradouro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pessoa2.png"))); // NOI18N
        jBLogradouro1.setText("Bancos");
        jBLogradouro1.setBorderPainted(false);
        jBLogradouro1.setFocusPainted(false);
        jBLogradouro1.setFocusable(false);
        jBLogradouro1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBLogradouro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLogradouro1ActionPerformed(evt);
            }
        });
        jPanel1.add(jBLogradouro1);
        jBLogradouro1.setBounds(0, 260, 220, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleName("FCadastro");
        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deskTopComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_deskTopComponentResized

    }//GEN-LAST:event_deskTopComponentResized

    private void jBLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLogradouroActionPerformed
        try {
            deskTop.removeAll();
            FCadFormaDePagamento clComp;

            clComp = FCadFormaDePagamento.getInstancia();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBLogradouroActionPerformed

    private void jBFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFornecedorActionPerformed
        try {
            deskTop.removeAll();
            FCadSangria clComp;

            clComp = FCadSangria.getInstancia().getInstancia();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBFornecedorActionPerformed

    private void jBClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBClienteActionPerformed
        try {
            deskTop.removeAll();
            FCadLancamento clComp;

            clComp = FCadLancamento.getInstancia();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBClienteActionPerformed

    private void jBLogradouro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLogradouro1ActionPerformed
       try {
            deskTop.removeAll();
            FCadBanco clComp;

            clComp = FCadBanco.getInstancia();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBLogradouro1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane deskTop;
    private javax.swing.JButton jBCliente;
    private javax.swing.JButton jBFornecedor;
    private javax.swing.JButton jBLogradouro;
    private javax.swing.JButton jBLogradouro1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
