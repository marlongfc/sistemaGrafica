/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual;

import graficaatual.entidades.ControleAcesso;
import graficaatual.entidades.Permissao;
import graficaatual.formularios.relatorio.FCadCParametro;
import graficaatual.formularios.relatorio.FCadTextoPadrao;
import graficaatual.formularios.relatorio.FRelatorioCadastro;
import graficaatual.formularios.relatorio.FRelatorioFinanceiro;
import javax.swing.JButton;

import javax.swing.JOptionPane;
/**
 *
 * @author Projeto X
 */
public class FRelatorio extends javax.swing.JFrame {
    
    private static FRelatorio instance;
    private static int initControle;


    public static int isInicializado() {
        return initControle;
    }
    
    public FRelatorio() {
        
        initComponents();
        this.setLocationRelativeTo(null);
       
        //verificação de acesso as telas
        acessotela(jBParametros,"FCadParametros");
        acessotela(jBTextoPadrao,"FCadTextoPadro");   
        acessotela(jBReltCadastro,"FRelatorioCadastro");
        acessotela(jBRELTFinanc,"FRelatorioFinanceiro");  
        
    }
    
    

    public static FRelatorio getInstance() {
        
        if (instance == null) {
            instance = new FRelatorio();
        }

        return instance;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBParametros = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jBTextoPadrao = new javax.swing.JButton();
        jBSair = new javax.swing.JButton();
        deskTop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jBReltCadastro = new javax.swing.JButton();
        jBRELTFinanc = new javax.swing.JButton();

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

        jBParametros.setBackground(new java.awt.Color(71, 37, 131));
        jBParametros.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBParametros.setForeground(new java.awt.Color(255, 255, 255));
        jBParametros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/NOVO2.png"))); // NOI18N
        jBParametros.setText("Parâmetros");
        jBParametros.setBorderPainted(false);
        jBParametros.setFocusPainted(false);
        jBParametros.setFocusable(false);
        jBParametros.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBParametrosActionPerformed(evt);
            }
        });
        jPanel1.add(jBParametros);
        jBParametros.setBounds(30, 230, 180, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LOGO Amarela sem Fundo2.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 20, 120, 110);

        jBTextoPadrao.setBackground(new java.awt.Color(71, 37, 131));
        jBTextoPadrao.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBTextoPadrao.setForeground(new java.awt.Color(255, 255, 255));
        jBTextoPadrao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/NOVO2.png"))); // NOI18N
        jBTextoPadrao.setText("Texto Padrão ");
        jBTextoPadrao.setBorderPainted(false);
        jBTextoPadrao.setFocusPainted(false);
        jBTextoPadrao.setFocusable(false);
        jBTextoPadrao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBTextoPadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTextoPadraoActionPerformed(evt);
            }
        });
        jPanel1.add(jBTextoPadrao);
        jBTextoPadrao.setBounds(30, 270, 180, 30);

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
        jBSair.setBounds(30, 310, 180, 30);

        deskTop.setMinimumSize(new java.awt.Dimension(1100, 700));
        deskTop.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                deskTopComponentResized(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RELATORIOS COM FUNDO.jpg"))); // NOI18N
        deskTop.add(jLabel1);
        jLabel1.setBounds(280, 90, 550, 510);

        jPanel1.add(deskTop);
        deskTop.setBounds(210, 10, 1070, 700);

        jBReltCadastro.setBackground(new java.awt.Color(71, 37, 131));
        jBReltCadastro.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBReltCadastro.setForeground(new java.awt.Color(255, 255, 255));
        jBReltCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CADASTRO SEM FUNDO4.jpg"))); // NOI18N
        jBReltCadastro.setText("Cadastros");
        jBReltCadastro.setBorderPainted(false);
        jBReltCadastro.setFocusPainted(false);
        jBReltCadastro.setFocusable(false);
        jBReltCadastro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBReltCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBReltCadastroActionPerformed(evt);
            }
        });
        jPanel1.add(jBReltCadastro);
        jBReltCadastro.setBounds(30, 150, 180, 30);

        jBRELTFinanc.setBackground(new java.awt.Color(71, 37, 131));
        jBRELTFinanc.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBRELTFinanc.setForeground(new java.awt.Color(255, 255, 255));
        jBRELTFinanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CADASTRO SEM FUNDO4.jpg"))); // NOI18N
        jBRELTFinanc.setText("Financeiro");
        jBRELTFinanc.setBorderPainted(false);
        jBRELTFinanc.setFocusPainted(false);
        jBRELTFinanc.setFocusable(false);
        jBRELTFinanc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBRELTFinanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRELTFinancActionPerformed(evt);
            }
        });
        jPanel1.add(jBRELTFinanc);
        jBRELTFinanc.setBounds(30, 190, 180, 30);

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

    private void jBTextoPadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTextoPadraoActionPerformed
        try {
            deskTop.removeAll();
            FCadTextoPadrao clComp;

            clComp = FCadTextoPadrao.getInstance();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }  
    }//GEN-LAST:event_jBTextoPadraoActionPerformed

    private void jBParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBParametrosActionPerformed
       try {
            deskTop.removeAll();
            FCadCParametro clComp;

            clComp = FCadCParametro.getInstance();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBParametrosActionPerformed

    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
       dispose();
    }//GEN-LAST:event_jBSairActionPerformed

    private void jBReltCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBReltCadastroActionPerformed
         try {
            deskTop.removeAll();
            FRelatorioCadastro clComp;

            clComp = FRelatorioCadastro.getInstance();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBReltCadastroActionPerformed

    private void jBRELTFinancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRELTFinancActionPerformed
         try {
            deskTop.removeAll();
             FRelatorioFinanceiro clComp;

            clComp = FRelatorioFinanceiro.getInstance();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBRELTFinancActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane deskTop;
    private javax.swing.JButton jBParametros;
    private javax.swing.JButton jBRELTFinanc;
    private javax.swing.JButton jBReltCadastro;
    private javax.swing.JButton jBSair;
    private javax.swing.JButton jBTextoPadrao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void acessotela(JButton jB, String fCadCliente) {
        Permissao p = ControleAcesso.getPermissaoFormulario(fCadCliente,"RELATORIO");
        if(p!= null){
            jB.setEnabled(p.isAcesso());
        }else{
            jB.setEnabled(false);
        }
    }

}
