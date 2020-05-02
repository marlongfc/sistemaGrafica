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
        jBLancamento = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jBSangria = new javax.swing.JButton();
        jBSair = new javax.swing.JButton();
        jBBanco = new javax.swing.JButton();
        jBFormaPagamento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema Gráfica Atual - Módulo Cadastro");
        setBackground(new java.awt.Color(255, 255, 255));
        setExtendedState(6);
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/FINANCEIRO COM FUNDO.jpg"))); // NOI18N
        deskTop.add(jLabel1);
        jLabel1.setBounds(280, 90, 550, 510);

        jPanel1.add(deskTop);
        deskTop.setBounds(220, 10, 1070, 700);

        jBLancamento.setBackground(new java.awt.Color(71, 37, 131));
        jBLancamento.setForeground(new java.awt.Color(255, 255, 255));
        jBLancamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pessoa2.png"))); // NOI18N
        jBLancamento.setText("Lançamento de Caixa");
        jBLancamento.setBorderPainted(false);
        jBLancamento.setFocusPainted(false);
        jBLancamento.setFocusable(false);
        jBLancamento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBLancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLancamentoActionPerformed(evt);
            }
        });
        jPanel1.add(jBLancamento);
        jBLancamento.setBounds(0, 180, 220, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LOGO Amarela sem Fundo2.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 20, 120, 110);

        jBSangria.setBackground(new java.awt.Color(71, 37, 131));
        jBSangria.setForeground(new java.awt.Color(255, 255, 255));
        jBSangria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pessoa2.png"))); // NOI18N
        jBSangria.setText("Sangrias");
        jBSangria.setBorderPainted(false);
        jBSangria.setFocusPainted(false);
        jBSangria.setFocusable(false);
        jBSangria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBSangria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSangriaActionPerformed(evt);
            }
        });
        jPanel1.add(jBSangria);
        jBSangria.setBounds(0, 220, 220, 30);

        jBSair.setBackground(new java.awt.Color(71, 37, 131));
        jBSair.setForeground(new java.awt.Color(255, 255, 255));
        jBSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pessoa2.png"))); // NOI18N
        jBSair.setText("Sair");
        jBSair.setBorderPainted(false);
        jBSair.setFocusPainted(false);
        jBSair.setFocusable(false);
        jBSair.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });
        jPanel1.add(jBSair);
        jBSair.setBounds(0, 350, 220, 30);

        jBBanco.setBackground(new java.awt.Color(71, 37, 131));
        jBBanco.setForeground(new java.awt.Color(255, 255, 255));
        jBBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pessoa2.png"))); // NOI18N
        jBBanco.setText("Bancos");
        jBBanco.setBorderPainted(false);
        jBBanco.setFocusPainted(false);
        jBBanco.setFocusable(false);
        jBBanco.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBancoActionPerformed(evt);
            }
        });
        jPanel1.add(jBBanco);
        jBBanco.setBounds(0, 260, 220, 30);

        jBFormaPagamento.setBackground(new java.awt.Color(71, 37, 131));
        jBFormaPagamento.setForeground(new java.awt.Color(255, 255, 255));
        jBFormaPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pessoa2.png"))); // NOI18N
        jBFormaPagamento.setText("Formas de Pagamento");
        jBFormaPagamento.setBorderPainted(false);
        jBFormaPagamento.setFocusPainted(false);
        jBFormaPagamento.setFocusable(false);
        jBFormaPagamento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFormaPagamentoActionPerformed(evt);
            }
        });
        jPanel1.add(jBFormaPagamento);
        jBFormaPagamento.setBounds(0, 300, 220, 30);

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

    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        dispose();
    }//GEN-LAST:event_jBSairActionPerformed

    private void jBSangriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSangriaActionPerformed
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
    }//GEN-LAST:event_jBSangriaActionPerformed

    private void jBLancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLancamentoActionPerformed
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
    }//GEN-LAST:event_jBLancamentoActionPerformed

    private void jBBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBancoActionPerformed
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
    }//GEN-LAST:event_jBBancoActionPerformed

    private void jBFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFormaPagamentoActionPerformed
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
    }//GEN-LAST:event_jBFormaPagamentoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane deskTop;
    private javax.swing.JButton jBBanco;
    private javax.swing.JButton jBFormaPagamento;
    private javax.swing.JButton jBLancamento;
    private javax.swing.JButton jBSair;
    private javax.swing.JButton jBSangria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
