/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual;


import graficaatual.entidades.ControleAcesso;
import graficaatual.entidades.Permissao;
import graficaatual.formularios.financeiro.FRequisicao;
import graficaatual.formularios.pedido.FCadOrcamento;
import javax.swing.JButton;

import javax.swing.JOptionPane;

/**
 *
 * @author Projeto X
 */
public class FPedido extends javax.swing.JFrame {

    private static FPedido instance;
    private static int initControle;

    public static int isInicializado() {
        return initControle;
    }

    public FPedido() {

        initComponents();
        this.setLocationRelativeTo(null);
        
        //verificação de acesso as telas
        acessotela(jBOrcamento,"FCadOrcamento");
        //acessotela(jbPedido,"FCadOrcamento");
        acessotela(jbRequisicao,"FCadRequisicao");
  
    }

    public static FPedido getInstance() {

        if (instance == null) {
            instance = new FPedido();
        }

        return instance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        deskTop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jBOrcamento = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jbSair = new javax.swing.JButton();
        jbRequisicao = new javax.swing.JButton();

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/PEDIDOS COM FUNDO.jpg"))); // NOI18N
        deskTop.add(jLabel1);
        jLabel1.setBounds(280, 90, 550, 510);

        jPanel1.add(deskTop);
        deskTop.setBounds(220, 10, 1070, 700);

        jBOrcamento.setBackground(new java.awt.Color(71, 37, 131));
        jBOrcamento.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBOrcamento.setForeground(new java.awt.Color(255, 255, 255));
        jBOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ORÇAMENTO2.png"))); // NOI18N
        jBOrcamento.setText("Orçamento/Pedido");
        jBOrcamento.setBorderPainted(false);
        jBOrcamento.setFocusPainted(false);
        jBOrcamento.setFocusable(false);
        jBOrcamento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBOrcamentoActionPerformed(evt);
            }
        });
        jPanel1.add(jBOrcamento);
        jBOrcamento.setBounds(30, 180, 190, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LOGO Amarela sem Fundo2.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 20, 120, 110);

        jbSair.setBackground(new java.awt.Color(71, 37, 131));
        jbSair.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jbSair.setForeground(new java.awt.Color(255, 255, 255));
        jbSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAIR2.png"))); // NOI18N
        jbSair.setText("Sair");
        jbSair.setBorderPainted(false);
        jbSair.setFocusPainted(false);
        jbSair.setFocusable(false);
        jbSair.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });
        jPanel1.add(jbSair);
        jbSair.setBounds(30, 260, 190, 30);

        jbRequisicao.setBackground(new java.awt.Color(71, 37, 131));
        jbRequisicao.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jbRequisicao.setForeground(new java.awt.Color(255, 255, 255));
        jbRequisicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/REQUISIÇÃO2.png"))); // NOI18N
        jbRequisicao.setText("Requisição");
        jbRequisicao.setBorderPainted(false);
        jbRequisicao.setFocusPainted(false);
        jbRequisicao.setFocusable(false);
        jbRequisicao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbRequisicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRequisicaoActionPerformed(evt);
            }
        });
        jPanel1.add(jbRequisicao);
        jbRequisicao.setBounds(30, 220, 190, 30);

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

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        dispose();
    }//GEN-LAST:event_jbSairActionPerformed

    private void jBOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBOrcamentoActionPerformed
        try {
            deskTop.removeAll();
            FCadOrcamento clComp;

            clComp = FCadOrcamento.getInstancia();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBOrcamentoActionPerformed

    private void jbRequisicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRequisicaoActionPerformed
        try {
            deskTop.removeAll();
            FRequisicao clComp;

            clComp = FRequisicao.getInstancia();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jbRequisicaoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane deskTop;
    private javax.swing.JButton jBOrcamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbRequisicao;
    private javax.swing.JButton jbSair;
    // End of variables declaration//GEN-END:variables
private void acessotela(JButton jB, String fCadCliente) {
        Permissao p = ControleAcesso.getPermissaoFormulario(fCadCliente,"PEDIDO");
        if(p!= null){
            jB.setEnabled(p.isAcesso());
        }else{
            jB.setEnabled(false);
        }
    }
}
