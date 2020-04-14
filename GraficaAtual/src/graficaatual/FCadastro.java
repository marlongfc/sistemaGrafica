/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual;

import graficaatual.formularios.cadastro.FCadCargo;
import graficaatual.formularios.cadastro.FCadCliente;
import graficaatual.formularios.cadastro.FCadColaborador;
import graficaatual.formularios.cadastro.FCadFornecedor;
import graficaatual.formularios.cadastro.FCadTurno;
import graficaatual.formularios.cadastro.FCadUsuario;
import javax.swing.JOptionPane;
/**
 *
 * @author Projeto X
 */
public class FCadastro extends javax.swing.JFrame {
    
    private static FCadastro instance;
    private static int initControle;


    public static int isInicializado() {
        return initControle;
    }
    
    public FCadastro() {
        
        initComponents();
        
       
    }

    public static FCadastro getInstance() {
        
        if (instance == null) {
            instance = new FCadastro();
        }

        return instance;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        deskTop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Gráfica Atual - Módulo Cadastro");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1150, 690));
        setName("FCadastro"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1150, 690));

        jPanel1.setBackground(new java.awt.Color(102, 0, 153));
        jPanel1.setLayout(null);

        deskTop.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                deskTopComponentResized(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Bem-vindo.jpg"))); // NOI18N
        deskTop.add(jLabel1);
        jLabel1.setBounds(200, 100, 550, 340);

        jPanel1.add(deskTop);
        deskTop.setBounds(250, 80, 880, 550);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LOGO3.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 110, 140, 130);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CADASTRO SEM FUNDO.png"))); // NOI18N
        jPanel1.add(jLabel10);
        jLabel10.setBounds(260, 0, 70, 110);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Módulo de Cadastros");
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(1, 0, 1140, 70);

        jButton9.setBackground(new java.awt.Color(131, 37, 135));
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/teste2.png"))); // NOI18N
        jButton9.setText("Cliente");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(20, 380, 200, 40);

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/teste2.png"))); // NOI18N
        jButton10.setText("Fornecedor");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(20, 430, 200, 40);

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/teste2.png"))); // NOI18N
        jButton11.setText("Colaboradores");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11);
        jButton11.setBounds(20, 480, 200, 40);

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/teste2.png"))); // NOI18N
        jButton13.setText("Usuário");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13);
        jButton13.setBounds(20, 580, 200, 40);

        jButton14.setBackground(new java.awt.Color(255, 255, 255));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/teste2.png"))); // NOI18N
        jButton14.setText("Cargo");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton14);
        jButton14.setBounds(20, 530, 200, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("FCadastro");
        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
            deskTop.removeAll();
            FCadFornecedor clComp;

            clComp = FCadFornecedor.getInstance();
            deskTop.add(clComp);
            clComp.setVisible(true);
                
         } catch (Exception e) {
              e.printStackTrace();
              JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
         }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            deskTop.removeAll();
            FCadCliente clComp;

            clComp = FCadCliente.getInstance();
            deskTop.add(clComp);
            clComp.setVisible(true);
                
         } catch (Exception e) {
              e.printStackTrace();
              JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
         }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        try {
            deskTop.removeAll();
            FCadUsuario clComp;

            clComp = FCadUsuario.getInstance();
            deskTop.add(clComp);
            clComp.setVisible(true);
                
         } catch (Exception e) {
              e.printStackTrace();
              JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
         }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void deskTopComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_deskTopComponentResized

    }//GEN-LAST:event_deskTopComponentResized

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
    try {
          deskTop.removeAll();
          FCadColaborador clComp;

            clComp = FCadColaborador.getInstance();
            deskTop.add(clComp);
            clComp.setVisible(true);
                
         } catch (Exception e) {
              e.printStackTrace();
              JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
         }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        try {
            deskTop.removeAll();
            FCadCargo clComp;

            clComp = FCadCargo.getInstance();
            deskTop.add(clComp);
            clComp.setVisible(true);
                
         } catch (Exception e) {
              e.printStackTrace();
              JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
         }
    }//GEN-LAST:event_jButton14ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane deskTop;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
