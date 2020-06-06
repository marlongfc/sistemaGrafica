/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual;

import graficaatual.entidades.ControleAcesso;
import graficaatual.entidades.Permissao;
import graficaatual.formularios.financeiro.FCadBanco;
import graficaatual.formularios.financeiro.FCadFormaDePagamento;
import graficaatual.formularios.financeiro.FCadLancamento;
import graficaatual.formularios.financeiro.FCadSangria;
import javax.swing.JButton;

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
        
        //verificação de acesso as telas
        acessotela(jBLancCaixa,"FCadLancamento");
        acessotela(jBSangria,"FCadSangria");
        acessotela(jBBanco,"FCadBanco");


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

        jBLancamento = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        deskTop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jBLancCaixa = new javax.swing.JButton();
        jBSair = new javax.swing.JButton();
        jBBanco = new javax.swing.JButton();
        jBSangria = new javax.swing.JButton();

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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LOGO Amarela sem Fundo2.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 20, 120, 110);

        jBLancCaixa.setBackground(new java.awt.Color(71, 37, 131));
        jBLancCaixa.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBLancCaixa.setForeground(new java.awt.Color(255, 255, 255));
        jBLancCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tudofinanceiro2.png"))); // NOI18N
        jBLancCaixa.setText("Lançamentos Caixa");
        jBLancCaixa.setBorderPainted(false);
        jBLancCaixa.setFocusPainted(false);
        jBLancCaixa.setFocusable(false);
        jBLancCaixa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBLancCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLancCaixaActionPerformed(evt);
            }
        });
        jPanel1.add(jBLancCaixa);
        jBLancCaixa.setBounds(20, 180, 200, 30);

        jBSair.setBackground(new java.awt.Color(71, 37, 131));
        jBSair.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBSair.setForeground(new java.awt.Color(255, 255, 255));
        jBSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAIR2.png"))); // NOI18N
        jBSair.setText("SAIR");
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
        jBSair.setBounds(20, 300, 200, 30);

        jBBanco.setBackground(new java.awt.Color(71, 37, 131));
        jBBanco.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBBanco.setForeground(new java.awt.Color(255, 255, 255));
        jBBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tudofinanceiro2.png"))); // NOI18N
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
        jBBanco.setBounds(20, 260, 200, 30);

        jBSangria.setBackground(new java.awt.Color(71, 37, 131));
        jBSangria.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBSangria.setForeground(new java.awt.Color(255, 255, 255));
        jBSangria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tudofinanceiro2.png"))); // NOI18N
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
        jBSangria.setBounds(20, 220, 200, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
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

    private void jBLancCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLancCaixaActionPerformed
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
    }//GEN-LAST:event_jBLancCaixaActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane deskTop;
    private javax.swing.JButton jBBanco;
    private javax.swing.JButton jBLancCaixa;
    private javax.swing.JButton jBLancamento;
    private javax.swing.JButton jBSair;
    private javax.swing.JButton jBSangria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
private void acessotela(JButton jB, String fCadCliente) {
        Permissao p = ControleAcesso.getPermissaoFormulario(fCadCliente,"FINANCEIRO");
        if(p!= null){
            jB.setEnabled(p.isAcesso());
        }else{
            jB.setEnabled(false);
        }
    }
}
