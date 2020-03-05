/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual;

import graficaatual.daos.UsuariosDao;
import graficaatual.entidades.Usuarios;
import java.awt.Color;
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

    private Statement stmtPgEntrada = null;
 
    private String inicioAtualizacao = "";
    private String inicioGeracao = "";
    private long tempoEntreAtualizacao = 0;
    private long tempoEntreGeracao = 0;
    private long horaUltimaAtualizacao = 0;
    private long horaUltimaGeracao = 0;

    private String erroV = "", sNomeBanco = "";

    private int aux = 0;
    private String tipo = "0";

    /**
     * Creates new form Geral
     */
    public FLogin() {
        initComponents();

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
        jButton24 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        host = new javax.swing.JTextField();
        sair = new javax.swing.JToggleButton();
        porta = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        senha = new javax.swing.JPasswordField();
        jLabel46 = new javax.swing.JLabel();
        banco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(153, 0, 153));
        jPanel2.setLayout(null);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Login:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(17, 294, 37, 15);

        login.setText("root");
        login.setToolTipText("");
        jPanel2.add(login);
        login.setBounds(80, 291, 133, 19);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Senha:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(12, 318, 50, 15);

        senhaUsuario.setText("427623");
        senhaUsuario.setToolTipText("");
        jPanel2.add(senhaUsuario);
        senhaUsuario.setBounds(80, 316, 133, 19);

        jToggleButton1.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("Confirmar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jToggleButton1);
        jToggleButton1.setBounds(95, 341, 118, 36);

        jButton24.setText("<html><center>Testar Conexão");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton24);
        jButton24.setBounds(95, 383, 118, 30);

        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel42.setText("Ip/Host:");
        jPanel2.add(jLabel42);
        jLabel42.setBounds(40, 40, 70, 15);

        host.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        host.setText("localhost");
        host.setToolTipText("");
        jPanel2.add(host);
        host.setBounds(120, 40, 61, 19);

        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        jPanel2.add(sair);
        sair.setBounds(150, 420, 62, 25);

        porta.setText("5432");
        porta.setToolTipText("");
        jPanel2.add(porta);
        porta.setBounds(100, 80, 48, 19);

        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel43.setText("Porta:");
        jPanel2.add(jLabel43);
        jLabel43.setBounds(30, 90, 60, 15);

        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel44.setText("User:");
        jPanel2.add(jLabel44);
        jLabel44.setBounds(20, 110, 70, 15);

        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel45.setText("Senha:");
        jPanel2.add(jLabel45);
        jLabel45.setBounds(20, 130, 70, 15);

        senha.setText("427623");
        jPanel2.add(senha);
        senha.setBounds(100, 130, 46, 19);

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel46.setText("Nome BD:");
        jPanel2.add(jLabel46);
        jLabel46.setBounds(20, 160, 70, 15);

        banco.setText("bancoGrafica");
        banco.setToolTipText("");
        jPanel2.add(banco);
        banco.setBounds(100, 150, 110, 19);

        jLabel7.setText("Versão: 1.0.08");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(20, 230, 101, 15);

        user.setText("postgres");
        jPanel2.add(user);
        user.setBounds(100, 110, 96, 19);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 220, 450);

        jPanel1.setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LOGO.png"))); // NOI18N
        jPanel1.add(jButton1);
        jButton1.setBounds(3, 5, 610, 440);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(220, 0, 620, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        getConexaoPostgresDesck();
    }//GEN-LAST:event_jButton24ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField login;
    private javax.swing.JTextField porta;
    private javax.swing.JToggleButton sair;
    private javax.swing.JPasswordField senha;
    private javax.swing.JPasswordField senhaUsuario;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables

    private void getConexaoPostgresDesck() {
        conexoes.Conectar.setDriveJDBC("org.postgresql.Driver");
        conexoes.Conectar.setIpServidor(host.getText());
        conexoes.Conectar.setNomeDB(banco.getText());
        conexoes.Conectar.setPorta(porta.getText());
        conexoes.Conectar.setSenhaBanco(senha.getText());
        conexoes.Conectar.setUsurioBanco(user.getText());
        conexoes.Conectar.setUrlConexao("jdbc:postgresql://" + conexoes.Conectar.getIpServidor() + ":" + conexoes.Conectar.getPorta() + "/" + conexoes.Conectar.getNomeDB());
        stmtPgEntrada = conexoes.Conectar.getStatement();
//        if (conexoes.clBuscaResultSet.getCount("SELECT DATNAME FROM PG_DATABASE where datname like '" + banco.getText() + "' ORDER BY LOWER(DATNAME)  ") > 0) {
//            status5.setForeground(new Color(0, 153, 51));
//            status5.setText("Conectado");
//        } else {
//            status5.setForeground(new Color(204, 0, 0));
//            status5.setText("Desconectado");
//        }
    }


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

                UsuariosDao usDao = new UsuariosDao();
                Usuarios us;

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
