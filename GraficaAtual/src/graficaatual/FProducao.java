/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual;

import graficaatual.entidades.ControleAcesso;
import graficaatual.entidades.Permissao;
import graficaatual.formularios.producao.FGestaoOrdemServico;
import graficaatual.formularios.producao.FGrupoEntrega;
import graficaatual.formularios.producao.FOrdemEntrega;
import graficaatual.formularios.producao.FOrdemFaturamento;
import graficaatual.formularios.producao.FOrdemServico;
import javax.swing.JButton;

import javax.swing.JOptionPane;
/**
 *
 * @author Projeto X
 */
public class FProducao extends javax.swing.JFrame {
    
    private static FProducao instance;
    private static int initControle;


    public static int isInicializado() {
        return initControle;
    }
    
    public FProducao() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        
        
        //verificação de acesso as telas
        acessotela(jBGgestaoProducao,"FGestaoOrdemServico");
        acessotela(jBProducao,"FOrdemServico");
        acessotela(jBEntrega,"FOrdemEntrega");
        acessotela(jBGrupoEntrega,"FGrupoEntrega");
        acessotela(jBFatura,"FOrdemFaturamento");
        
       
    }
    
    

    public static FProducao getInstance() {
        
        if (instance == null) {
            instance = new FProducao();
        }

        return instance;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBGgestaoProducao = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jBSair = new javax.swing.JButton();
        deskTop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jBProducao = new javax.swing.JButton();
        jBEntrega = new javax.swing.JButton();
        jBGrupoEntrega = new javax.swing.JButton();
        jBFatura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema Gráfica Atual - Módulo Cadastro");
        setBackground(new java.awt.Color(255, 255, 255));
        setExtendedState(6);
        setMinimumSize(new java.awt.Dimension(1310, 760));
        setName("FCadastro"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1310, 760));

        jPanel1.setBackground(new java.awt.Color(71, 37, 131));
        jPanel1.setMinimumSize(new java.awt.Dimension(1100, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 700));
        jPanel1.setLayout(null);

        jBGgestaoProducao.setBackground(new java.awt.Color(71, 37, 131));
        jBGgestaoProducao.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBGgestaoProducao.setForeground(new java.awt.Color(255, 255, 255));
        jBGgestaoProducao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Clientes2.png"))); // NOI18N
        jBGgestaoProducao.setText("Gestão Produção");
        jBGgestaoProducao.setBorderPainted(false);
        jBGgestaoProducao.setFocusPainted(false);
        jBGgestaoProducao.setFocusable(false);
        jBGgestaoProducao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBGgestaoProducao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGgestaoProducaoActionPerformed(evt);
            }
        });
        jPanel1.add(jBGgestaoProducao);
        jBGgestaoProducao.setBounds(30, 180, 180, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LOGO Amarela sem Fundo2.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 20, 120, 110);

        jBSair.setBackground(new java.awt.Color(71, 37, 131));
        jBSair.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBSair.setForeground(new java.awt.Color(255, 255, 255));
        jBSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAIR2.png"))); // NOI18N
        jBSair.setText("  SAIR");
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
        jBSair.setBounds(30, 380, 180, 30);

        deskTop.setMinimumSize(new java.awt.Dimension(1100, 700));
        deskTop.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                deskTopComponentResized(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/PRODUÇÃO COM FUNDO.jpg"))); // NOI18N
        deskTop.add(jLabel1);
        jLabel1.setBounds(280, 90, 550, 510);

        jPanel1.add(deskTop);
        deskTop.setBounds(210, 10, 1070, 700);

        jBProducao.setBackground(new java.awt.Color(71, 37, 131));
        jBProducao.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBProducao.setForeground(new java.awt.Color(255, 255, 255));
        jBProducao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Clientes2.png"))); // NOI18N
        jBProducao.setText("Produção Geral");
        jBProducao.setBorderPainted(false);
        jBProducao.setFocusPainted(false);
        jBProducao.setFocusable(false);
        jBProducao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBProducao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProducaoActionPerformed(evt);
            }
        });
        jPanel1.add(jBProducao);
        jBProducao.setBounds(30, 220, 180, 30);

        jBEntrega.setBackground(new java.awt.Color(71, 37, 131));
        jBEntrega.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBEntrega.setForeground(new java.awt.Color(255, 255, 255));
        jBEntrega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Clientes2.png"))); // NOI18N
        jBEntrega.setText("Entrega");
        jBEntrega.setBorderPainted(false);
        jBEntrega.setFocusPainted(false);
        jBEntrega.setFocusable(false);
        jBEntrega.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEntregaActionPerformed(evt);
            }
        });
        jPanel1.add(jBEntrega);
        jBEntrega.setBounds(30, 260, 180, 30);

        jBGrupoEntrega.setBackground(new java.awt.Color(71, 37, 131));
        jBGrupoEntrega.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBGrupoEntrega.setForeground(new java.awt.Color(255, 255, 255));
        jBGrupoEntrega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Clientes2.png"))); // NOI18N
        jBGrupoEntrega.setText("Grupo Entrega");
        jBGrupoEntrega.setBorderPainted(false);
        jBGrupoEntrega.setFocusPainted(false);
        jBGrupoEntrega.setFocusable(false);
        jBGrupoEntrega.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBGrupoEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGrupoEntregaActionPerformed(evt);
            }
        });
        jPanel1.add(jBGrupoEntrega);
        jBGrupoEntrega.setBounds(30, 340, 180, 30);

        jBFatura.setBackground(new java.awt.Color(71, 37, 131));
        jBFatura.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBFatura.setForeground(new java.awt.Color(255, 255, 255));
        jBFatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Clientes2.png"))); // NOI18N
        jBFatura.setText("Faturamento");
        jBFatura.setBorderPainted(false);
        jBFatura.setFocusPainted(false);
        jBFatura.setFocusable(false);
        jBFatura.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBFatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFaturaActionPerformed(evt);
            }
        });
        jPanel1.add(jBFatura);
        jBFatura.setBounds(30, 300, 180, 30);
        jBFatura.getAccessibleContext().setAccessibleName("Fatura");

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

    private void jBGgestaoProducaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGgestaoProducaoActionPerformed
        try {
            deskTop.removeAll();
            FGestaoOrdemServico clComp;

            clComp = FGestaoOrdemServico.getInstance();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBGgestaoProducaoActionPerformed

    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
       dispose();
    }//GEN-LAST:event_jBSairActionPerformed

    private void jBProducaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProducaoActionPerformed
        try {
            deskTop.removeAll();
            FOrdemServico clComp;

            clComp = FOrdemServico.getInstance();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBProducaoActionPerformed

    private void jBEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEntregaActionPerformed
        try {
            deskTop.removeAll();
            FOrdemEntrega clComp;

            clComp = FOrdemEntrega.getInstance();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBEntregaActionPerformed

    private void jBGrupoEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGrupoEntregaActionPerformed
        try {
            deskTop.removeAll();
            FGrupoEntrega clComp;

            clComp = FGrupoEntrega.getInstance();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBGrupoEntregaActionPerformed

    private void jBFaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFaturaActionPerformed
        try {
            deskTop.removeAll();
            FOrdemFaturamento clComp;

            clComp = FOrdemFaturamento.getInstance();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBFaturaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane deskTop;
    private javax.swing.JButton jBEntrega;
    private javax.swing.JButton jBFatura;
    private javax.swing.JButton jBGgestaoProducao;
    private javax.swing.JButton jBGrupoEntrega;
    private javax.swing.JButton jBProducao;
    private javax.swing.JButton jBSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void acessotela(JButton jB, String fCadCliente) {
        Permissao p = ControleAcesso.getPermissaoFormulario(fCadCliente,"PRODUCAO");
        if(p!= null){
            jB.setEnabled(p.isAcesso());
        }else{
            jB.setEnabled(false);
        }
    }

}
