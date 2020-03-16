/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual;

import graficaatual.daos.UsuariosDAO;
import graficaatual.entidades.Usuario;
import graficaatual.utilitarios.Persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author Pro
 */
public class FLogin extends javax.swing.JFrame { 

    private String erroV = "", sNomeBanco = "";
    private boolean verConf = true; 

    /**
     * Creates new form Geral
     */
    public FLogin() {
        initComponents();
        //Visualizar as Configurações
        host.setVisible(verConf);
        porta.setVisible(verConf);
        user.setVisible(verConf);
        senha.setVisible(verConf);
        banco.setVisible(verConf);
        jLabel1.setVisible(verConf);
        jLabel3.setVisible(verConf);
        jLabel6.setVisible(verConf);
        jLabel7.setVisible(verConf);
        jLabel8.setVisible(verConf);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        login = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        senhaUsuario = new javax.swing.JPasswordField();
        jToggleButton1 = new javax.swing.JToggleButton();
        sair = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        host = new javax.swing.JTextField();
        user = new javax.swing.JTextField();
        porta = new javax.swing.JTextField();
        senha = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        banco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1060, 600));
        setSize(new java.awt.Dimension(1060, 600));
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(153, 0, 153));
        jPanel2.setLayout(null);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Login:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 460, 60, 20);

        login.setText("root");
        login.setToolTipText("");
        jPanel2.add(login);
        login.setBounds(70, 460, 180, 19);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Senha:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 480, 60, 20);

        senhaUsuario.setText("427623");
        senhaUsuario.setToolTipText("");
        jPanel2.add(senhaUsuario);
        senhaUsuario.setBounds(70, 480, 180, 19);

        jToggleButton1.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("Confirmar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jToggleButton1);
        jToggleButton1.setBounds(10, 520, 140, 36);

        sair.setBackground(new java.awt.Color(255, 255, 255));
        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        jPanel2.add(sair);
        sair.setBounds(150, 520, 100, 36);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("IP:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 120, 70, 20);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Porta:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 140, 51, 20);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Banco:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(10, 200, 51, 20);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Usuário:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 160, 80, 20);

        host.setText("localhost");
        jPanel2.add(host);
        host.setBounds(90, 120, 150, 19);

        user.setText("postgres");
        jPanel2.add(user);
        user.setBounds(90, 160, 150, 19);

        porta.setText("5432");
        jPanel2.add(porta);
        porta.setBounds(90, 140, 150, 19);

        senha.setText("427623");
        jPanel2.add(senha);
        senha.setBounds(90, 180, 150, 19);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Senha:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 180, 51, 20);

        banco.setText("bancoGrafica");
        jPanel2.add(banco);
        banco.setBounds(90, 200, 150, 19);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 260, 580);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LOGO COM FUNDO.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-350, -50, 2028, 630);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        try {
            confirmar();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        dispose();
    }//GEN-LAST:event_sairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField banco;
    private javax.swing.JTextField host;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField login;
    private javax.swing.JTextField porta;
    private javax.swing.JToggleButton sair;
    private javax.swing.JTextField senha;
    private javax.swing.JPasswordField senhaUsuario;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables

    
    private void confirmar() throws Exception {

        if (erroV.trim().length() > 0) {
            JOptionPane.showMessageDialog(this, erroV);
            return;
        }
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PesistenceHibernate");
                    EntityManager em = emf.createEntityManager();
                    em.close();
                    emf.close();
        
        if (isValidoUsuario()) {
            try {

                UsuariosDAO usDao = new UsuariosDAO();
                Usuario us;

                //Pesquisa o usuário
                us = usDao.getUsuario(login.getText().trim());
                if (us != null) {

                    System.out.println("É Usuário");
                  
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);

            }
        } else {
            JOptionPane.showMessageDialog(this, "O nome de usuário e/ou a senha não são válidos.\nVerifique os dados e tente novamente.");
        }

    }

    private boolean isValidoUsuario() throws Exception {
        
       
        String sHost = host.getText();
        String sPorta = porta.getText();
        String sUsr = user.getText();
        String sSenha = senha.getText();

        Class.forName("org.postgresql.Driver");
        Connection conexao;
        System.out.println("gerar conexão");
        conexao = DriverManager.getConnection("jdbc:postgresql://" + sHost + ":" + sPorta + "/" + banco.getText(), sUsr, sSenha);
        System.out.println("conexão false");
        conexao.setAutoCommit(true);
        System.out.println("conexão True");
        Statement banco = conexao.createStatement(1004, 1008);
        System.out.println("vai fazer Pesquisa");
        ResultSet rs = banco.executeQuery("select senha from usuarios where login = '" + login.getText().trim() + "'");
        System.out.println("realizou pesquisa");
        if (rs.next()) {
            String str = rs.getString("senha");
            boolean b = str.equals(((JTextField) senhaUsuario).getText().trim());
            if (b == false) {
                System.out.println("inv");
            }

            return b;
        } else {
            System.out.println("inex");
        }

        rs.close();
        banco.close();
        conexao.close();

        return false;

    }
     
}
