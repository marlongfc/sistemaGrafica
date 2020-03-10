package graficaatual;


import graficaatual.utilitarios.ConfigMenus;
import graficaatual.utilitarios.ControleAcesso;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Projeto X
 *
 */
public class FTelaPrincipal extends javax.swing.JFrame {

    private static FTelaPrincipal instance;
    private static int initControle;
    public String TituloOriginal = "";


    public static int isInicializado() {
        return initControle;
    }

    public synchronized static FTelaPrincipal getInstance() {
        if (instance == null) {
            instance = new FTelaPrincipal();
            initControle = 1;
        }
        return instance;
    }

    private FTelaPrincipal() {

       

       
            //MDIRoot.getInstance().setVisible(true);
            this.setSize(0, 0);
            this.setLocation(getX(), -50);

        

            initComponents();
            //setExtendedState(CFrame.getExtendedStateDefault());


            TituloOriginal = getTitle();



            setMenus();
            setBorderBotoes();
            //Checando cadastros
            ChecarCadastros();
            //Checando Permissão de acesso aos sistemas
            ChecarPrmissaoSistema();
            //Atualiza a versão


            iniciarParmetosTitulo();

           

            

        

        System.setProperty("line.separator", "\r\n");

    }

    private void setBorderBotoes() {

        Border borda = javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204), 2);

        Component[] botoes = painelDeLink.getComponents();

        for (Component botao : botoes) {
            if (botao instanceof JButton) {
                ((JButton) botao).setBorder(borda);
            }
        }

    }

    private void setMenus() {
        ConfigMenus cm = new ConfigMenus(jMenuBar1);

        cm.setFont(new Font("Dialog", Font.PLAIN, 12));

        cm.aplicar();
    }

   

    

    private void ChecarPrmissaoSistema() {
        try {

            if (ControleAcesso.usuario.getTipoPermissao().getCodigo() != 30 && ControleAcesso.usuario.getTipoPermissao().getCodigo() != 10) {

//                PermissaoSistemaDAO psdao = new PermissaoSistemaDAO();
//
//                JMParametros.setEnabled(psdao.getAcessoSistema(0));

//                btContabilidade.setEnabled(psdao.getAcessoSistema(1));
//                btFolha.setEnabled(psdao.getAcessoSistema(2));
//                btTributos.setEnabled(psdao.getAcessoSistema(3));
//                btLicitacao.setEnabled(psdao.getAcessoSistema(4));
//                btAlmoxarifado.setEnabled(psdao.getAcessoSistema(5));
//                btSicom.setEnabled(psdao.getAcessoSistema(6));
//                btFrota.setEnabled(psdao.getAcessoSistema(7));
//                btPatrimonio.setEnabled(psdao.getAcessoSistema(8));
//                btProtocolo.setEnabled(psdao.getAcessoSistema(9));
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar checar permissão de acesso aos sistemas. Erro: " + e);
            e.printStackTrace();
        }
    }

    private void ChecarCadastros() {
        //Cadastrar tipos de sistemas
        try {
//            TipoSistemaDAO tpdao = new TipoSistemaDAO();
//            List<TipoSistema> lista = tpdao.getList();
//            if (lista.size() <= 12) {
//                TipoSistema tp = new TipoSistema();
//                tp.setCodigo(0);
//                tp.setNome("hlh.integrado");
//                tp.setDescricao("Sistema de Configuração Geral");
//                tpdao.savePojo(tp);
//
//                tp = new TipoSistema();
//                tp.setCodigo(1);
//                tp.setNome("hlh.contabilidade");
//                tp.setDescricao("Sistema de Contabilidade");
//                tpdao.savePojo(tp);
//
//                tp = new TipoSistema();
//                tp.setCodigo(2);
//                tp.setNome("hlh.folha");
//                tp.setDescricao("Sistema de Folha de Pagamento");
//                tpdao.savePojo(tp);
//
//                tp = new TipoSistema();
//                tp.setCodigo(3);
//                tp.setNome("hlh.tributos");
//                tp.setDescricao("Sistema de Tributos");
//                tpdao.savePojo(tp);
//
//                tp = new TipoSistema();
//                tp.setCodigo(4);
//                tp.setNome("hlh.licitacao");
//                tp.setDescricao("Sistema de Compras e Licitações");
//                tpdao.savePojo(tp);
//
//                tp = new TipoSistema();
//                tp.setCodigo(5);
//                tp.setNome("hlh.almoxarifado");
//                tp.setDescricao("Sistema de Almoxarifado");
//                tpdao.savePojo(tp);
//
//                tp = new TipoSistema();
//                tp.setCodigo(6);
//                tp.setNome("hlh.SICOM");
//                tp.setDescricao("Sistema SICOM");
//                tpdao.savePojo(tp);
//
//                tp = new TipoSistema();
//                tp.setCodigo(7);
//                tp.setNome("hlh.frotas");
//                tp.setDescricao("Sistema de Frotas");
//                tpdao.savePojo(tp);
//
//                tp = new TipoSistema();
//                tp.setCodigo(8);
//                tp.setNome("hlh.patrimonio");
//                tp.setDescricao("Sistema de Patrimônio");
//                tpdao.savePojo(tp);
//
//                tp = new TipoSistema();
//                tp.setCodigo(9);
//                tp.setNome("hlh.protocolos");
//                tp.setDescricao("Sistema de Protocolos");
//                tpdao.savePojo(tp);
//
//                tp = new TipoSistema();
//                tp.setCodigo(10);
//                tp.setNome("hlh.controleInterno");
//                tp.setDescricao("Sistema de Controle Interno");
//                tpdao.savePojo(tp);
//
//                tp = new TipoSistema();
//                tp.setCodigo(11);
//                tp.setNome("hlh.fluxoEletronicodeDocumentos");
//                tp.setDescricao("Sistema de Fluxo Eletrônico de Documentos");
//                tpdao.savePojo(tp);
//
//                tp = new TipoSistema();
//                tp.setCodigo(12);
//                tp.setNome("hlh.obras");
//                tp.setDescricao("Sistema de Obras");
//                tpdao.savePojo(tp);

//                System.out.println("Cadastra tipos de sistema. ");
//            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar cadastrar tipos de sistema. Erro: " + e);
            e.printStackTrace();
        }

        //Cadastrar tipos de permissão
        try {
//            TipoPermissaoDAO tperdao = new TipoPermissaoDAO();
//            List<TipoPermissao> listaper = tperdao.getList();
//            if (listaper.size() <= 0) {
//                TipoPermissao tper = new TipoPermissao();
//                tper.setCodigo(1);
//                tper.setDescricao("Sem Acesso");
//                tperdao.savePojo(tper);
//
//                tper = new TipoPermissao();
//                tper.setCodigo(2);
//                tper.setDescricao("Acesso Personalizado");
//                tperdao.savePojo(tper);
//
//                tper = new TipoPermissao();
//                tper.setCodigo(5);
//                tper.setDescricao("Administrador do Modulo");
//                tperdao.savePojo(tper);
//
//                tper = new TipoPermissao();
//                tper.setCodigo(10);
//                tper.setDescricao("Administrador Geral");
//                tperdao.savePojo(tper);

                //tper = new TipoPermissao();
                //tper.setCodigo(30);
                //tper.setDescricao("Administrador Master");
                //tperdao.savePojo(tper);
//            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar cadastro tipos de permissão. Erro: " + e);
            e.printStackTrace();
        }

        try {
            //new At_Usuario().updateTipoPermisaoUsuario();
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        DeskTop = new javax.swing.JDesktopPane();
        planoDeFundo = new javax.swing.JLabel();
        painelDeLink = new javax.swing.JPanel();
        btContabilidade = new javax.swing.JButton();
        btFolha = new javax.swing.JButton();
        painelTitulo = new javax.swing.JPanel();
        nomePrefeitura = new javax.swing.JLabel();
        exerc = new javax.swing.JLabel();
        nrVersaoSistema = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        msgExpiracao = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMParametros = new javax.swing.JMenu();
        JMEntidade = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        JMUsuario = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SIGP - Sistema de Gestão Pública Integrado");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        DeskTop.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                DeskTopComponentResized(evt);
            }
        });

        planoDeFundo.setBackground(new java.awt.Color(0, 0, 0));
        planoDeFundo.setOpaque(true);
        DeskTop.setLayer(planoDeFundo, -1);
        DeskTop.add(planoDeFundo);
        planoDeFundo.setBounds(0, 0, 30, 20);

        painelDeLink.setBackground(new java.awt.Color(0, 0, 0));
        painelDeLink.setOpaque(false);
        painelDeLink.setLayout(null);

        btContabilidade.setBackground(new java.awt.Color(255, 255, 255));
        btContabilidade.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btContabilidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CADASTRO SEM FUNDO.png"))); // NOI18N
        btContabilidade.setText("<html><center>Cadastro</center></html>");
        btContabilidade.setToolTipText("Sistema de Contabilidade");
        btContabilidade.setBorder(null);
        btContabilidade.setBorderPainted(false);
        btContabilidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btContabilidade.setFocusPainted(false);
        btContabilidade.setFocusable(false);
        btContabilidade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btContabilidade.setMaximumSize(new java.awt.Dimension(140, 140));
        btContabilidade.setMinimumSize(new java.awt.Dimension(140, 140));
        btContabilidade.setOpaque(false);
        btContabilidade.setPreferredSize(new java.awt.Dimension(140, 140));
        btContabilidade.setRequestFocusEnabled(false);
        btContabilidade.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/hlh/integrado/images/iconesmodulos/iconContabilidade_hover.png"))); // NOI18N
        btContabilidade.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btContabilidade.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btContabilidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btContabilidadeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btContabilidadeMouseExited(evt);
            }
        });
        btContabilidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btContabilidadeActionPerformed(evt);
            }
        });
        painelDeLink.add(btContabilidade);
        btContabilidade.setBounds(10, 10, 260, 310);

        btFolha.setBackground(new java.awt.Color(255, 255, 255));
        btFolha.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btFolha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hlh/integrado/images/iconesmodulos/iconFolha.png"))); // NOI18N
        btFolha.setText("<html><center>Financeiro</center></html>");
        btFolha.setToolTipText("Sistema de Folha");
        btFolha.setBorder(null);
        btFolha.setBorderPainted(false);
        btFolha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btFolha.setFocusPainted(false);
        btFolha.setFocusable(false);
        btFolha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btFolha.setMaximumSize(new java.awt.Dimension(140, 140));
        btFolha.setMinimumSize(new java.awt.Dimension(140, 140));
        btFolha.setOpaque(false);
        btFolha.setPreferredSize(new java.awt.Dimension(140, 140));
        btFolha.setRequestFocusEnabled(false);
        btFolha.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/hlh/integrado/images/iconesmodulos/iconFolha_hover.png"))); // NOI18N
        btFolha.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btFolha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btFolha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btFolhaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btFolhaMouseExited(evt);
            }
        });
        btFolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFolhaActionPerformed(evt);
            }
        });
        painelDeLink.add(btFolha);
        btFolha.setBounds(270, 10, 140, 140);

        DeskTop.add(painelDeLink);
        painelDeLink.setBounds(30, 100, 910, 380);

        painelTitulo.setOpaque(false);
        painelTitulo.setLayout(null);

        nomePrefeitura.setBackground(new java.awt.Color(51, 51, 51));
        nomePrefeitura.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        nomePrefeitura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomePrefeitura.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        painelTitulo.add(nomePrefeitura);
        nomePrefeitura.setBounds(0, 0, 760, 60);

        exerc.setBackground(new java.awt.Color(51, 51, 51));
        exerc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exerc.setText("EXERCÍCIO");
        painelTitulo.add(exerc);
        exerc.setBounds(300, 60, 190, 15);

        nrVersaoSistema.setBackground(new java.awt.Color(51, 51, 51));
        nrVersaoSistema.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        nrVersaoSistema.setText("00.00.00");
        painelTitulo.add(nrVersaoSistema);
        nrVersaoSistema.setBounds(680, 60, 60, 15);

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Versão:");
        painelTitulo.add(jLabel4);
        jLabel4.setBounds(630, 60, 50, 15);

        DeskTop.add(painelTitulo);
        painelTitulo.setBounds(30, 10, 760, 80);

        msgExpiracao.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        msgExpiracao.setForeground(new java.awt.Color(153, 51, 0));
        DeskTop.add(msgExpiracao);
        msgExpiracao.setBounds(490, 590, 380, 30);

        getContentPane().add(DeskTop, java.awt.BorderLayout.CENTER);

        jMenuBar1.setBackground(new java.awt.Color(51, 102, 255));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        JMParametros.setForeground(new java.awt.Color(255, 255, 255));
        JMParametros.setText("Parâmetro");
        JMParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMParametrosActionPerformed(evt);
            }
        });

        JMEntidade.setBackground(new java.awt.Color(255, 255, 255));
        JMEntidade.setText("Entidade");
        JMEntidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMEntidadeActionPerformed(evt);
            }
        });
        JMParametros.add(JMEntidade);

        jMenu1.setBackground(null);
        jMenu1.setText("Usuário");

        JMUsuario.setBackground(null);
        JMUsuario.setText("Cadastro de Usuários");
        JMUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(JMUsuario);

        jMenuItem9.setBackground(null);
        jMenuItem9.setText("Alteração de Senha");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuItem5.setBackground(null);
        jMenuItem5.setText("Alteração de Senha Responsável");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem8.setBackground(null);
        jMenuItem8.setText("Importação de Perfil de Usuários");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        JMParametros.add(jMenu1);

        jMenuBar1.add(JMParametros);

        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Backup");

        jMenuItem10.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jMenuItem10.setText("Backup");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(950, 620));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


private void JMParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMParametrosActionPerformed

}//GEN-LAST:event_JMParametrosActionPerformed


private void JMEntidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMEntidadeActionPerformed
    try {
//        hlh.parametros.CadParametros clComp;
//        if (hlh.parametros.CadParametros.isInicializado() != 1) {
//            clComp = hlh.parametros.CadParametros.getInstance();
//            clComp.setVisible(true);
//
//            DeskTop.add(clComp);
//        } else {
//            clComp = hlh.parametros.CadParametros.getInstance();
//        }
//
//        clComp.toFront();
//        clComp.setSelected(true);
//        clComp.setVisible(true);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
    }
}//GEN-LAST:event_JMEntidadeActionPerformed

    private void visualiza(JInternalFrame jif) {
        DeskTop.add(jif);
        jif.setVisible(true);

        int posX = (int) (DeskTop.getWidth() - jif.getWidth()) / 2;
        int posY = (int) (DeskTop.getHeight() - jif.getHeight()) / 2;

        jif.setBounds(posX, posY, jif.getWidth(), jif.getHeight());
    }


private void JMUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMUsuarioActionPerformed

    try {

//        if (!ControleAcesso.getAcessoFormulario(10, "hlh.integrado.formularios.cadastro.CadUsuarios")) {
//            JOptionPane.showMessageDialog(this, ControleAcesso.MensagemSeguranca, CParametro.getSigla() + " - Sistema de Segurança", JOptionPane.INFORMATION_MESSAGE);
//            return;
//        }
//
//        hlh.integrado.formularios.cadastro.CadUsuarios_Novo clComp;
//        if (hlh.integrado.formularios.cadastro.CadUsuarios_Novo.isInicializado() != 1) {
//            clComp = hlh.integrado.formularios.cadastro.CadUsuarios_Novo.getInstance();
//            DeskTop.add(clComp);
//            clComp.setVisible(true);
//
//        } else {
//            clComp = hlh.integrado.formularios.cadastro.CadUsuarios_Novo.getInstance();
//            if (DeskTop.getComponentZOrder(clComp) < 0) {
//                DeskTop.add(clComp);
//                clComp.setVisible(true);
//            }
//        }
//        clComp.setSelected(true);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
    }

}//GEN-LAST:event_JMUsuarioActionPerformed
        
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
//        visualizaAlerta(new FAlertasSIGP());
//        
//        if(CSistema.getAcaoArquitetura() != 2){
//            processarImagemPlanoDeFundo();
//        }else{
//            planoDeFundo.setVisible(false);
//        }
//        
//        posicaoPaineis();
    }//GEN-LAST:event_formComponentShown

    private JInternalFrame palerta;
    private boolean telaAlertaAtica = false;

    private void visualizaAlerta(JInternalFrame jif) {
        palerta = jif;
        DeskTop.add(palerta);
        palerta.setVisible(true);

        int posX = (int) (DeskTop.getWidth() - palerta.getWidth() - 3);
        int posY = (int) -20;

        int h = DeskTop.getHeight() + 20;

        palerta.setBounds(posX, posY, palerta.getWidth(), h);
    }

    private void DeskTopComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_DeskTopComponentResized
        processarImagemPlanoDeFundo();
        posicaoPaineis();
    }//GEN-LAST:event_DeskTopComponentResized

    private static final javax.swing.border.Border entered = new javax.swing.border.LineBorder(new Color(70, 169, 86), 2, false);
    private static final javax.swing.border.Border exited = new javax.swing.border.LineBorder(new Color(0, 102, 204), 2, false);

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
//        visualiza(new FBackupPostigres());
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (JOptionPane.showConfirmDialog(this, "Tem certeza que deseja fechar o sistema?", "Confirmação", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            sair();
        }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        try {
//            if (!ControleAcesso.getAcessoFormulario(10, "hlh.integrado.formularios.cadastro.CadAlteracaoSenha")) {
//                JOptionPane.showMessageDialog(this, ControleAcesso.MensagemSeguranca, CParametro.getSigla() + " - Sistema de Segurança", JOptionPane.INFORMATION_MESSAGE);
//                return;
//            }
//            hlh.integrado.formularios.cadastro.CadAlteracaoSenha clComp;
//            if (hlh.integrado.formularios.cadastro.CadAlteracaoSenha.isInicializado() != 1) {
//                clComp = hlh.integrado.formularios.cadastro.CadAlteracaoSenha.getInstance();
//                DeskTop.add(clComp);
//                clComp.setVisible(true);
//            } else {
//                clComp = hlh.integrado.formularios.cadastro.CadAlteracaoSenha.getInstance();
//                if (DeskTop.getComponentZOrder(clComp) < 0) {
//                    DeskTop.add(clComp);
//                    clComp.setVisible(true);
//                }
//            }
//            clComp.setSelected(true);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try {
//            if (!ControleAcesso.getAcessoFormulario(10, "hlh.integrado.formularios.cadastro.CadAlteracaoSenhaRespLic")) {
//                JOptionPane.showMessageDialog(this, ControleAcesso.MensagemSeguranca, CParametro.getSigla() + " - Sistema de Segurança", JOptionPane.INFORMATION_MESSAGE);
//                return;
//            }
//            hlh.integrado.formularios.cadastro.CadAlteracaoSenhaRespLic clComp;
//            if (hlh.integrado.formularios.cadastro.CadAlteracaoSenhaRespLic.isInicializado() != 1) {
//                clComp = hlh.integrado.formularios.cadastro.CadAlteracaoSenhaRespLic.getInstance();
//                DeskTop.add(clComp);
//                clComp.setVisible(true);
//            } else {
//                clComp = hlh.integrado.formularios.cadastro.CadAlteracaoSenhaRespLic.getInstance();
//                if (DeskTop.getComponentZOrder(clComp) < 0) {
//                    DeskTop.add(clComp);
//                    clComp.setVisible(true);
//                }
//            }
//            clComp.setSelected(true);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        try {

//            if (true) {
//                JOptionPane.showMessageDialog(this, ControleAcesso.MensagemSeguranca, CParametro.getSigla() + " - Sistema de Segurança", JOptionPane.INFORMATION_MESSAGE);
//                return;
//            }
//
//            
//            if (hlh.integrado.formularios.cadastro.CadUsuariosImportarPerfil.isInicializado() != 1) {
//                clComp = hlh.integrado.formularios.cadastro.CadUsuariosImportarPerfil.getInstance();
//                DeskTop.add(clComp);
//                clComp.setVisible(true);
//
//            } else {
//                clComp = hlh.integrado.formularios.cadastro.CadUsuariosImportarPerfil.getInstance();
//                if (DeskTop.getComponentZOrder(clComp) < 0) {
//                    DeskTop.add(clComp);
//                    clComp.setVisible(true);
//                }
//            }
//            clComp.setSelected(true);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void btFolhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFolhaActionPerformed
//        MDIFolha c = MDIFolha.getInstance();
//        c.setVisible(true);
    }//GEN-LAST:event_btFolhaActionPerformed

    private void btFolhaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btFolhaMouseExited
        btFolha.setBorder(exited);
    }//GEN-LAST:event_btFolhaMouseExited

    private void btFolhaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btFolhaMouseEntered
        btFolha.setBorder(entered);
    }//GEN-LAST:event_btFolhaMouseEntered

    private void btContabilidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btContabilidadeActionPerformed
      //  FContabil c = FContabil.getInstancia();
       // c.setVisible(true);
    }//GEN-LAST:event_btContabilidadeActionPerformed

    private void btContabilidadeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btContabilidadeMouseExited
        btContabilidade.setBorder(exited);
    }//GEN-LAST:event_btContabilidadeMouseExited

    private void btContabilidadeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btContabilidadeMouseEntered
        btContabilidade.setBorder(entered);
    }//GEN-LAST:event_btContabilidadeMouseEntered

   

    private void sair() {
        //Verificar numeros de usuários conectados
        //Fazer vacuum 
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FTelaPrincipal().setVisible(true);
            }
        });
    }

    private void processarImagemPlanoDeFundo() {
        try {

            String ICON = "/hlh/integrado/images/imagePagPrin/fundo.jpg";

            java.awt.Image image;

            image = getImagePlanoDeFundo(ICON);

            if (image != null) {

                int posW = DeskTop.getWidth();
                int posH = DeskTop.getHeight();

                planoDeFundo.setBounds(0, 0, posW, posH);
                planoDeFundo.setIcon(new ImageIcon(image.getScaledInstance(planoDeFundo.getWidth(), planoDeFundo.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));

            } else {

                planoDeFundo.setBounds(0, 0, 0, 0);
                planoDeFundo.setIcon(null);

            }

        } catch (Exception e) {

        }

        //Controle da posissão do painel de sintese  
        posicaoPainelSintese();

    }

    private java.awt.Image getImagePlanoDeFundo(String ICON) {
        try {

            //javax.swing.ImageIcon imgicone = new javax.swing.ImageIcon(CParametro.class.getResource(ICON));

            //return imgicone.getImage();

        } catch (Exception e) {
        }
        return null;
    }

    private void posicaoPaineis() {

        try {
            int heigthPainel = 450;
            int widthPainel = 900;
            //Controle da posissão do painel de link 
            

            int posX = (int) ((DeskTop.getWidth() / 2) - (widthPainel / 2));
            int posY = (int) ((DeskTop.getHeight() / 2) - (heigthPainel / 2) - 10);

            if (false || (palerta != null && palerta.isVisible())) {
                posX = posX - 150;
            }

            if (posX < 0) {
                posX = 0;
            }

            if (posY < 80) {
                posY = 80;
            }

            int posW = widthPainel;///painelDeLink.getWidth();
            int posH = heigthPainel;//painelDeLink.getHeight();

            painelDeLink.setBounds(posX, posY, posW, posH);

            //Controle da posissão do painel de alerta 
            int posX2 = (int) (DeskTop.getWidth() - palerta.getWidth() - 3);
            int posY2 = (int) -20;//(DeskTop.getHeight() - jif.getHeight());

            int h = DeskTop.getHeight() + 20;

            if (posX2 < 724) {
                posX2 = 724;
            }

            palerta.setBounds(posX2, posY2, palerta.getWidth(), h);

            //Controle da posissão do painel de titulo 
            posicaoPainelTitulo();

        } catch (Exception e) {
        }
    }

    private void posicaoPainelTitulo() {

        try {

           

            int posX = (int) ((DeskTop.getWidth() / 2) - (760 / 2));
            int posY = 0;//(int) ((DeskTop.getHeight() / 2) - (360 / 2)-10);

            if (false || (palerta != null && palerta.isVisible())) {
                posX = posX - 150;
            }

            if (posX < 0) {
                posX = 0;
            }

            int posW = 760;
            int posH = 80;

            painelTitulo.setBounds(posX, posY, posW, posH);

        } catch (Exception e) {

        }
    }

    private void iniciarParmetosTitulo() {
        try {


            String nomePref = "Grafica Atual";
            String exerci = "2020";
           

           

            String versao = GAControleVersao;

            nomePrefeitura.setText(nomePref.toUpperCase());
            exerc.setText(exerci.toUpperCase());
            nrVersaoSistema.setText(versao);

        } catch (Exception e) {
        }
    }

    private void posicaoPainelSintese() {
        try {

          

            int posIM = (int) ((DeskTop.getHeight() / 2) - 190);
            int tamDW = DeskTop.getWidth();

            int posX2 = (int) ((DeskTop.getWidth() / 2) - (760 / 2));
            int posY2 = (int) (posIM + 320);

            if (false || (palerta != null && palerta.isVisible())) {
                posX2 = posX2 - 150;
            }

            if (posX2 < 0) {
                posX2 = 0;
            }

            if (posY2 < 500) {
                posY2 = 500;
            }

            if (tamDW <= 1024) {
//                nomeSI1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 80));
//                nomeSI2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 80));
            } else if (tamDW > 1024 && tamDW < 1500) {
//                nomeSI1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 120));
//                nomeSI2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 120));
            } else {
//                nomeSI1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 180));
//                nomeSI2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 180));
            }

            int posW2 = 760;
            int posH2 = 160;

//            painelRodape.setBounds(posX2, posY2, posW2, posH2);
            msgExpiracao.setBounds(posX2, posY2 + posH2, msgExpiracao.getWidth(), msgExpiracao.getHeight());
        } catch (Exception e) {
        }
       
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DeskTop;
    private javax.swing.JMenuItem JMEntidade;
    private javax.swing.JMenu JMParametros;
    private javax.swing.JMenuItem JMUsuario;
    private javax.swing.JButton btContabilidade;
    private javax.swing.JButton btFolha;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel exerc;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JLabel msgExpiracao;
    private javax.swing.JLabel nomePrefeitura;
    private javax.swing.JLabel nrVersaoSistema;
    private javax.swing.JPanel painelDeLink;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JLabel planoDeFundo;
    // End of variables declaration//GEN-END:variables

    public static String EXERCICIO = "";

    ////////////////////////////////////////////////////////////////////////////
    public synchronized static String getVersao() {
        return GAControleVersao;
    }

    public synchronized static void setGAVersaoAnteriorBD(String GAVersaoAnteriorBD) {
        FTelaPrincipal.GAVersaoAnteriorBD = GAVersaoAnteriorBD;
    }

    public static String getGAVersaoAnteriorBD() {
        return GAVersaoAnteriorBD;
    }

    private static String GAControleVersao = "1";

    private static String GAVersaoAnteriorBD = "";

}
