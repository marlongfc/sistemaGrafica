/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual;

import graficaatual.daos.UsuariosDAO;
import graficaatual.entidades.ControleAcesso;
import graficaatual.entidades.Usuario;
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
 * @author Projeto X
 */
public class FLogin extends javax.swing.JFrame {

    private String erroV = "", sNomeBanco = "";
    private boolean verConf = true;
    private static FLogin instancia;

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
        habilitaMenus(false);
        this.setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBProducao = new javax.swing.JButton();
        jBPedidos = new javax.swing.JButton();
        jBCadastro = new javax.swing.JButton();
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
        jBFinanceiro = new javax.swing.JButton();
        jBRelatorios = new javax.swing.JButton();
        jBEstoque = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema Gráfica Atual");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMaximumSize(new java.awt.Dimension(2400, 1200));
        setMinimumSize(new java.awt.Dimension(1060, 720));
        setName("FLogin"); // NOI18N
        setSize(new java.awt.Dimension(1060, 720));
        getContentPane().setLayout(null);

        jBProducao.setBackground(new java.awt.Color(255, 255, 255));
        jBProducao.setForeground(new java.awt.Color(255, 255, 255));
        jBProducao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/PRODUÇÃO SEM FUNDO.png"))); // NOI18N
        jBProducao.setBorderPainted(false);
        getContentPane().add(jBProducao);
        jBProducao.setBounds(620, 540, 80, 100);

        jBPedidos.setBackground(new java.awt.Color(255, 255, 255));
        jBPedidos.setForeground(new java.awt.Color(255, 255, 255));
        jBPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/PEDIDOS SEM FUNDO.png"))); // NOI18N
        jBPedidos.setBorderPainted(false);
        jBPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPedidosActionPerformed(evt);
            }
        });
        getContentPane().add(jBPedidos);
        jBPedidos.setBounds(390, 170, 100, 80);

        jBCadastro.setBackground(new java.awt.Color(255, 255, 255));
        jBCadastro.setForeground(new java.awt.Color(255, 255, 255));
        jBCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CADASTRO SEM FUNDO.png"))); // NOI18N
        jBCadastro.setBorderPainted(false);
        jBCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastroActionPerformed(evt);
            }
        });
        getContentPane().add(jBCadastro);
        jBCadastro.setBounds(400, 420, 80, 90);

        jPanel2.setBackground(new java.awt.Color(71, 37, 131));
        jPanel2.setLayout(null);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Login:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 570, 60, 20);

        login.setText("root");
        login.setToolTipText("");
        jPanel2.add(login);
        login.setBounds(70, 570, 180, 20);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Senha:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 590, 60, 20);

        senhaUsuario.setText("427623");
        senhaUsuario.setToolTipText("");
        jPanel2.add(senhaUsuario);
        senhaUsuario.setBounds(70, 590, 180, 20);

        jToggleButton1.setBackground(new java.awt.Color(71, 37, 131));
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/senha2.png"))); // NOI18N
        jToggleButton1.setText("Confirmar");
        jToggleButton1.setBorderPainted(false);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jToggleButton1);
        jToggleButton1.setBounds(10, 630, 140, 36);

        sair.setBackground(new java.awt.Color(71, 37, 131));
        sair.setForeground(new java.awt.Color(255, 255, 255));
        sair.setText("Sair");
        sair.setBorderPainted(false);
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        jPanel2.add(sair);
        sair.setBounds(150, 630, 100, 36);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("IP:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 70, 70, 20);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Porta:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 90, 51, 20);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Banco:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 150, 51, 20);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Usuário:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(20, 110, 80, 20);

        host.setText("localhost");
        jPanel2.add(host);
        host.setBounds(100, 70, 150, 20);

        user.setText("postgres");
        jPanel2.add(user);
        user.setBounds(100, 110, 150, 20);

        porta.setText("5432");
        jPanel2.add(porta);
        porta.setBounds(100, 90, 150, 20);

        senha.setText("427623");
        jPanel2.add(senha);
        senha.setBounds(100, 130, 150, 20);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Senha:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(20, 130, 51, 20);

        banco.setText("bancoGrafica");
        banco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bancoActionPerformed(evt);
            }
        });
        jPanel2.add(banco);
        banco.setBounds(100, 150, 150, 20);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 260, 690);

        jBFinanceiro.setBackground(new java.awt.Color(255, 255, 255));
        jBFinanceiro.setForeground(new java.awt.Color(255, 255, 255));
        jBFinanceiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/FINANCEIRO SEM FUNDO.png"))); // NOI18N
        jBFinanceiro.setBorderPainted(false);
        jBFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFinanceiroActionPerformed(evt);
            }
        });
        getContentPane().add(jBFinanceiro);
        jBFinanceiro.setBounds(830, 170, 80, 90);

        jBRelatorios.setBackground(new java.awt.Color(255, 255, 255));
        jBRelatorios.setForeground(new java.awt.Color(255, 255, 255));
        jBRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/RELATORIOS  SEM FUNDO.png"))); // NOI18N
        jBRelatorios.setBorderPainted(false);
        getContentPane().add(jBRelatorios);
        jBRelatorios.setBounds(620, 40, 80, 100);

        jBEstoque.setBackground(new java.awt.Color(255, 255, 255));
        jBEstoque.setForeground(new java.awt.Color(255, 255, 255));
        jBEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ESTOQUE SEM FUNDO.png"))); // NOI18N
        jBEstoque.setBorderPainted(false);
        getContentPane().add(jBEstoque);
        jBEstoque.setBounds(840, 410, 70, 100);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LOGO2.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(260, 0, 790, 680);

        getAccessibleContext().setAccessibleName("FLogin");
        getAccessibleContext().setAccessibleDescription("");
        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        try {
            confirmar();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void jBPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPedidosActionPerformed
        try {
            FPedido clComp;
            if (FCadastro.isInicializado() != 1) {
                clComp = FPedido.getInstance();
                clComp.setVisible(true);
            } else {
                clComp = FPedido.getInstance();
            }
            clComp.toFront();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBPedidosActionPerformed

    private void bancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bancoActionPerformed

    private void jBCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastroActionPerformed
        try {
            FCadastro clComp;
            if (FCadastro.isInicializado() != 1) {
                clComp = FCadastro.getInstance();
                clComp.setVisible(true);
            } else {
                clComp = FCadastro.getInstance();
            }
            clComp.toFront();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBCadastroActionPerformed

    private void jBFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFinanceiroActionPerformed
           try {
            FFinanceiro clComp;
            if (FCadastro.isInicializado() != 1) {
                clComp = FFinanceiro.getInstance();
                clComp.setVisible(true);
            } else {
                clComp = FFinanceiro.getInstance();
            }
            clComp.toFront();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBFinanceiroActionPerformed

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
    private javax.swing.JButton jBCadastro;
    private javax.swing.JButton jBEstoque;
    private javax.swing.JButton jBFinanceiro;
    private javax.swing.JButton jBPedidos;
    private javax.swing.JButton jBProducao;
    private javax.swing.JButton jBRelatorios;
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
                    //telas
                    habilitaMenusUsuario(us);
                    
                   //CarregaControle de Acesso
                   carregaControle(us);

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
        ResultSet rs = banco.executeQuery("select senha from usuario where ativo = 'true' and login = '" + login.getText().trim() + "'");
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

    private void habilitaMenus(boolean b) {
        jBCadastro.setEnabled(b);
        jBEstoque.setEnabled(b);
        jBFinanceiro.setEnabled(b);
        jBPedidos.setEnabled(b);
        jBProducao.setEnabled(b);
        jBRelatorios.setEnabled(b);

    }
    
    private void habilitaMenusUsuario(Usuario us) {
        if(us.getAcessoCadastro() != null){
            jBCadastro.setEnabled(us.getAcessoCadastro());
        }else{
            jBCadastro.setEnabled(false);
        }
        
        if(us.getAcessoEstoque() != null){
            jBEstoque.setEnabled(us.getAcessoEstoque());
        }else{
            jBEstoque.setEnabled(false);
        }
        
        if(us.getAcessoFinanceiro() != null){
            jBFinanceiro.setEnabled(us.getAcessoFinanceiro());
        }else{
            jBFinanceiro.setEnabled(false);
        }
        
        if(us.getAcessoPedido() != null){
            jBPedidos.setEnabled(us.getAcessoPedido());
        }else{
            jBPedidos.setEnabled(false);
        }
        
        if(us.getAcessoProducao() != null){
            jBProducao.setEnabled(us.getAcessoProducao());
        }else{
            jBProducao.setEnabled(false);
        }
        
        if(us.getAcessoRelatorios() != null){
            jBRelatorios.setEnabled(us.getAcessoRelatorios());
        }else{
        
        }
    }

    private void carregaControle(Usuario us) {
        ControleAcesso.usuario = us;
        
    }
}
