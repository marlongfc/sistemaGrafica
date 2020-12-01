/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.producao;

import graficaatual.daos.producao.OrdemServicoDAO;
import graficaatual.daos.relatorio.TextoPadraoDAO;
import graficaatual.entidades.ControleAcesso;
import graficaatual.entidades.producao.AnexoDTO;
import graficaatual.entidades.producao.OrdemServico;
import graficaatual.utilitarios.Conexao;
import graficaatual.utilitarios.Data;
import graficaatual.utilitarios.VisualizaRelatorio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author si10
 */
public class FOrdemServico extends javax.swing.JInternalFrame {

    // Tela
    private static int initControle;
    private int localIncusao;
    private static FOrdemServico instance;
    private static FOrdemServico instanceCont;

    //Entidades para trabalhar
    private OrdemServico ordem  = null;
    private OrdemServicoDAO ordemDao = new OrdemServicoDAO();
            
    private JFormattedTextField cpf;

    public FOrdemServico() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    }

    public static int isInicializado() {
        return initControle;
    }

    private void Finalizar() {

        if (localIncusao == 1) {
            instanceCont = null;
        } else {
            initControle = 0;
            instance = null;
        }
        dispose();
    }

    public synchronized static FOrdemServico getInstance() {
        if (instance == null) {
            instance = new FOrdemServico();
            initControle = 1;
        }
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        try {
            cpf = new JFormattedTextField(
                new MaskFormatter("###.###.###-##"));
            ((JFormattedTextField) cpf).setFocusLostBehavior(0);

        } catch (Exception e) {
        }
        jLabel2 = new javax.swing.JLabel();
        salvar = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        jCBSetor = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabOrdensFazer = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabConcluido = new javax.swing.JTable();
        jLSelecao = new javax.swing.JLabel();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cliente");
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1100, 700));
        getContentPane().setLayout(null);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setToolTipText("Cadastro de Pessoas");
        jPanel10.setMaximumSize(new java.awt.Dimension(999999, 999999));
        jPanel10.setMinimumSize(new java.awt.Dimension(1100, 700));
        jPanel10.setName(""); // NOI18N
        jPanel10.setPreferredSize(new java.awt.Dimension(1100, 700));
        jPanel10.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ORDEM DE PRODUÇÃO");
        jPanel10.add(jLabel2);
        jLabel2.setBounds(0, 0, 1030, 70);

        salvar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/colaborador2.png"))); // NOI18N
        salvar.setText("Finalizar Tarefa");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });
        jPanel10.add(salvar);
        salvar.setBounds(730, 80, 180, 40);

        sair.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAIR2.png"))); // NOI18N
        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        jPanel10.add(sair);
        sair.setBounds(910, 80, 130, 40);

        jCBSetor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jCBSetor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolha um setor", "CRIAÇÃO", "PROJETO", "PLOTAGEM", "IMPRESSÃO DIGITAL", "ACABAMENTO IMPRESSÃO", "PLOTAGEM RECORTE", "SERRALHERIA", "PINTURA", "CAIXARIA ACABAMENTO", "CORTE ROUTER" }));
        jCBSetor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBSetorItemStateChanged(evt);
            }
        });
        jPanel10.add(jCBSetor);
        jCBSetor.setBounds(40, 80, 690, 38);

        jScrollPane6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        tabOrdensFazer.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tabOrdensFazer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ordem Serviço", "Pedido (cód.)", "Descrição", "Cliente", "Data Entrega"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabOrdensFazer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabOrdensFazerMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabOrdensFazer);

        jTabbedPane1.addTab("Lista de Produção  - A Fazer", jScrollPane6);

        jPanel1.setLayout(null);

        jScrollPane7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        tabConcluido.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tabConcluido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pedido (cód.)", "Item Pedido (cód.)", "Descrição", "Cliente", "Data Entrega"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabConcluido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabConcluidoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabConcluido);

        jPanel1.add(jScrollPane7);
        jScrollPane7.setBounds(0, 0, 1040, 510);

        jTabbedPane1.addTab("Lista de Produção - Concluída", jPanel1);

        jPanel10.add(jTabbedPane1);
        jTabbedPane1.setBounds(40, 140, 1000, 520);

        jLSelecao.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jPanel10.add(jLSelecao);
        jLSelecao.setBounds(40, 120, 690, 20);

        getContentPane().add(jPanel10);
        jPanel10.setBounds(0, 0, 1100, 700);
        jPanel10.getAccessibleContext().setAccessibleName("Cadastro de Pessoas");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        try {
            salvar();
            pesquisarFazer();
            pesquisarConcluido();
            jLSelecao.setText("");
            JOptionPane.showMessageDialog(this, " Tarefa Finalizada com Sucesso! ");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_salvarActionPerformed

    private void salvar() throws Exception {
        int setor = jCBSetor.getSelectedIndex();
        ordem = new OrdemServicoDAO().get((Integer) tabOrdensFazer.getValueAt(tabOrdensFazer.getSelectedRow(), 0));
        if (ordem != null) {

            switch (setor) {
                //Criação
                case 1:
                    ordem.setDataFimCriacao(new Date());
                    ordem.setUsuarioFimCriacao(ControleAcesso.usuario.getCodUsuario() + "-" + ControleAcesso.usuario.getLogin());
                    break;
                //Projeto    
                case 2:
                    ordem.setDataFimProjeto(new Date());
                    ordem.setUsuarioFimProjeto(ControleAcesso.usuario.getCodUsuario() + "-" + ControleAcesso.usuario.getLogin());
                    break;
                //Plotagem     
                case 3:
                    ordem.setDataFimPlotagem(new Date());
                    ordem.setUsuarioFimPlotagem(ControleAcesso.usuario.getCodUsuario() + "-" + ControleAcesso.usuario.getLogin());
                    break;
                //Impressão Digital    
                case 4:
                    ordem.setDataFimImpressaoDigital(new Date());
                    ordem.setUsuarioFimImpressaoDigital(ControleAcesso.usuario.getCodUsuario() + "-" + ControleAcesso.usuario.getLogin());
                    break;
                //Acabamento Impressão    
                case 5:
                    ordem.setDataFimAcabamentoImp(new Date());
                    ordem.setUsuarioFimAcabamentoImp(ControleAcesso.usuario.getCodUsuario() + "-" + ControleAcesso.usuario.getLogin());
                    break;
                //Plotagem Recorte
                case 6:
                    ordem.setDataFimPloterRecorte(new Date());
                    ordem.setUsuarioFimPloterRecorte(ControleAcesso.usuario.getCodUsuario() + "-" + ControleAcesso.usuario.getLogin());
                    break;
                //Serralheria    
                case 7:
                    ordem.setDataFimSerralheria(new Date());
                    ordem.setUsuarioFimSerralheria(ControleAcesso.usuario.getCodUsuario() + "-" + ControleAcesso.usuario.getLogin());
                    break;
                //Pintura    
                case 8:
                    ordem.setDataFimPintura(new Date());
                    ordem.setUsuarioFimPintura(ControleAcesso.usuario.getCodUsuario() + "-" + ControleAcesso.usuario.getLogin());
                    break;
                //Caixaria    
                case 9:
                    ordem.setDataFimCaixariaAcabamento(new Date());
                    ordem.setUsuarioFimCaixariaAcabamento(ControleAcesso.usuario.getCodUsuario() + "-" + ControleAcesso.usuario.getLogin());
                    break;
                //Corte    
                case 10:
                    ordem.setDataFimRouter(new Date());
                    ordem.setUsuarioFimRouter(ControleAcesso.usuario.getCodUsuario() + "-" + ControleAcesso.usuario.getLogin());
                    break;
                default:
                    break;    
            }
            ordem = ordemDao.addOrdem(ordem);
            enviarEmail();
        } else {
            JOptionPane.showMessageDialog(this, " Escolha uma Ordem de seviço, selecionando com um click.");
        }
    }


    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void tabOrdensFazerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabOrdensFazerMouseClicked
        try {
            jLSelecao.setText(" Ordem de Serviço Selecionada: "+tabOrdensFazer.getValueAt(tabOrdensFazer.getSelectedRow(), 0) 
                    + " Pedido - "+ tabOrdensFazer.getValueAt(tabOrdensFazer.getSelectedRow(), 1) 
                    + " Produto - " + tabOrdensFazer.getValueAt(tabOrdensFazer.getSelectedRow(), 2)
                    + " Pedido - "+ tabOrdensFazer.getValueAt(tabOrdensFazer.getSelectedRow(), 3)  );
            if (evt.getClickCount() > 1) {
                imprimir((Integer) tabOrdensFazer.getValueAt(tabOrdensFazer.getSelectedRow(), 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar Orçamento! \n " + e);
        }
    }//GEN-LAST:event_tabOrdensFazerMouseClicked

    private void tabConcluidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabConcluidoMouseClicked
         try {
             
            if (evt.getClickCount() > 1) {
                 imprimir((Integer) tabConcluido.getValueAt(tabConcluido.getSelectedRow(), 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar Orçamento! \n " + e);
        }
    }//GEN-LAST:event_tabConcluidoMouseClicked

    private void jCBSetorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBSetorItemStateChanged
        try {
            pesquisarFazer();
            pesquisarConcluido();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jCBSetorItemStateChanged

    public static void removeLinhas(JTable table) {
        int n = table.getRowCount();

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (int i = n - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCBSetor;
    private javax.swing.JLabel jLSelecao;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton sair;
    private javax.swing.JButton salvar;
    private javax.swing.JTable tabConcluido;
    private javax.swing.JTable tabOrdensFazer;
    // End of variables declaration//GEN-END:variables

    private void imprimir(Integer valor) throws Exception {
        try {

            String sql = "select cli.codcliente, pes.nome, pes.cnpj, pes.inscestadual, pes.numcasa, pes.uf, pes.cep,pes.email, pes.telefone,"
                    + " log.descricao logradouro, bai.descricao bairro, cid.descricao cidade, "
                    + " orc.clientesecundario, orc.codorcamento,orc.dataorcamento, orc.validadeorcamento, orc.prazoentrega, orc.formapagamento, orc.clientesecundario, "
                    + " orc.enderecosecundario, orc.telefonesecundario, orc.tipodeentrega, "
                    + " prod.codproduto, prod.descricao produto,item.quantprod, item.medida, item.unidade, item.valortotalproduto, item.valorunitario,aca.descricao acabamento, orc.valortotal,"
                    + " case when orc.situacao = true then 'PEDIDO' "
                    + " ELSE 'ORÇAMENTO' end nomeRell "
                    + " FROM orcamento orc "
                    + " INNER JOIN cliente cli ON cli.codcliente = orc.cliente "
                    + " INNER JOIN pessoa pes ON pes.codPessoa = cli.pessoa "
                    + " INNER JOIN itemorcamento item ON item.orcamento = orc.codOrcamento "
                    + " LEFT JOIN logradouro log ON log.codlogradouro = pes.logradouro "
                    + " LEFT JOIN bairro bai ON bai.codbairro = pes.bairro "
                    + " LEFT JOIN cidade cid ON cid.codcidade = pes.cidade "
                    + " LEFT JOIN produto prod ON prod.codproduto = orc.produto"
                    + " LEFT JOIN acabamento aca ON aca.codacabamento = item.acabamento"
                    + " WHERE orc.codOrcamento = " + valor;

            Map tx = new HashMap();

            tx.put("TEXTOPADRAO", new TextoPadraoDAO().get(1).getTextoOrcamento());
            new VisualizaRelatorio().visRel("graficaatual/relatorios/arquivos/RelOrcamentoSemValor.jasper", "Orçamento/Pedido", tx, sql);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar Orçamento! \n " + e);
        }
    }

    private void pesquisarFazer() {
        DefaultTableModel model = (DefaultTableModel) tabOrdensFazer.getModel();
        Statement bancoConsulta = null;
        Connection conexao = null;
        removeLinhas(tabOrdensFazer);

        try {
            conexao = Conexao.getConexao();
            bancoConsulta = Conexao.getBanco(conexao);

            String pesq = getSetor(0);

            String sql = getSql();
            sql = sql + pesq
                    + " order by orc.prazoentrega desc, orc.codorcamento ";
            //System.out.println(" vvvvvv "+sql);
            ResultSet rs = bancoConsulta.executeQuery(sql);
            while (rs.next()) {
                Object[] o = new Object[]{
                    rs.getInt("codordemservico"),
                    rs.getInt("codorcamento"),
                    rs.getString("descricao"),
                    rs.getString("nome"),
                    Data.getDateParse(rs.getDate("prazoentrega"), Data.FORMAT_DATA_BR)
                };
                model.addRow(o);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bancoConsulta != null) {
                    bancoConsulta.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception ex) {
            }
        }
    }

    private void pesquisarConcluido() {

        DefaultTableModel model = (DefaultTableModel) tabConcluido.getModel();
        Statement bancoConsulta = null;
        Connection conexao = null;
        removeLinhas(tabConcluido);

        try {
            conexao = Conexao.getConexao();
            bancoConsulta = Conexao.getBanco(conexao);

            String pesq = getSetor(1);

            String sql = getSql();
            sql = sql + pesq
                    + " order by orc.prazoentrega desc, orc.codorcamento ";
            //System.out.println(" uuuuuuuuuuuu "+sql);
            ResultSet rs = bancoConsulta.executeQuery(sql);
            while (rs.next()) {
                Object[] o = new Object[]{
                    rs.getInt("codordemservico"),
                    rs.getInt("codorcamento"),
                    rs.getString("descricao"),
                    rs.getString("nome"),
                    Data.getDateParse(rs.getDate("prazoentrega"), Data.FORMAT_DATA_BR)
                };
                model.addRow(o);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bancoConsulta != null) {
                    bancoConsulta.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception ex) {
            }
        }
    }

    // tipo 0 - a fazer
    // tipo 1 - concluida
    private String getSetor(int tipo) {
        int setor = jCBSetor.getSelectedIndex();
        String aux = "";

        // tipo 0 - a fazer
        // tipo 1 - concluida
        if (tipo == 1) {
            aux = " not ";
        }
        String ret = "";
        switch (setor) {
            case 1:
                ret = " and ord.checkcriacao and  ord.datafimcriacao is" + aux + " null";
                break;
            case 2:
                ret = " and ord.checkprojeto and ord.datafimprojeto is" + aux + " null";
                break;
            case 3:
                ret = " and  ord.checkplotagem and ord.datafimplotagem is" + aux + " null";
                break;
            case 4:
                ret = " and ord.checkimpressaodigital and ord.datafimimpressaodigital is" + aux + " null";
                break;
            case 5:
                ret = " and ord.checkacabamentoimp and ord.datafimacabamentoimp is" + aux + " null";
                break;
            case 6:
                ret = " and ord.checkploterrecorte and ord.datafimploterrecorte is" + aux + " null";
                break;
            case 7:
                ret = " and ord.checkserralheria and ord.datafimserralheria is" + aux + " null";
                break;
            case 8:
                ret = " and ord.checkpintura and ord.datafimpintura is" + aux + " null";
                break;
            case 9:
                ret = " and ord.checkcaixariaacabamento and ord.datafimcaixariaacabamento is" + aux + " null";
                break;
            case 10:
                ret = " and ord.checkrouter and ord.datafimrouter is" + aux + " null";
                break;
            default:
                removeLinhas(tabOrdensFazer);
                removeLinhas(tabConcluido);
                break;
        }

        return ret;
    }

    private String getSql() {
        return " select ord.codordemservico as  codordemservico,"
                + "  orc.codorcamento as codorcamento , "
                + "  prod.descricao as descricao , "
                + " (pes.cnpj || ' ' || pes.nome) as nome , "
                + " orc.prazoentrega  as prazoentrega "
                + " from ordemservico as ord "
                + " inner join orcamento as orc on (orc.codorcamento = ord.orcamento )"
                + " inner join itemorcamento as item on (item.orcamento = orc.codorcamento)"
                + " left join produto as prod on (item.produto = prod.codproduto)"
                + " left join cliente as cli on (cli.codcliente = orc.cliente)"
                + " left join pessoa as pes on (cli.pessoa = pes.codpessoa)"
                + " where (ord.checkfaturamento = false and ord.checkfaturamento = false ) ";
    }

    private boolean enviarEmail() throws Exception {
        List<String> para = new ArrayList<String>();
        String de = "";
        String deNome = "Gráfica Atual - Sistema de Atendimento";
        //Conferir Senha
        String senha = "";
        String assunto = "teste de envio";
        String msg;
        String nomeAnexo = "Pedido - "+ordem.getOrcamento().getCodOrcamento();


            msg = " <p>Prezado " + ordem.getOrcamento().getCliente().getPessoa().getNome() + ","
                    + " <br/> Os imóveis listados abaixo são os que se encontram atrelados ao cpf/cnpj: "
                    + ", caso algum esteja com informações incorretas ou ausente, deve-se comparecer à prefeitura para a correção e ajustes necessários.</p> ";

  
                    
            para.add("danilo.alfenas@gmail.com");
            nomeAnexo = "Relacao_de_Imoveis";
            byte[] anexo = null;
            anexo = gerarRelatorioByteArray();

            AnexoDTO anexoPdf = new AnexoDTO();
            anexoPdf.setNome(nomeAnexo + ".pdf");
            anexoPdf.setMimeType("application/pdf");
            anexoPdf.setConteudo(anexo);

            List<AnexoDTO> anexos = new ArrayList<AnexoDTO>();
            anexos.add(anexoPdf);

            System.out.println("--------------- Chegou ao final do processo ---------------");

            return sendEmailAnexos(de, deNome, senha, assunto, msg, anexos, nomeAnexo, para.toArray(new String[para.size()]));
     
    }
    
     private byte[] gerarRelatorioByteArray() throws Exception {

        byte[] pdf = null;
      

        String SQL = " SELECT I.PESSOA, P.NOME, I.CODIGO, ( I.CODDISTRITO || '.' || I.SETOR || '.' || I.QUADRA || '.' || I.LOTE ||'.' || I.UNIDADE) INSCIMOB,"
                + " (TL.ABREVIATURA || ' ' || L.LOGRADOURO || ', ' || I.NUMERO || ' ' || I.COMPLEMENTO) ENDERECO,"
                + " I.AREATERRENOLANCADA, AREACONSTRUIDALANCADA,"
                + " CASE"
                + " WHEN I.TIPODETRIBUTACAO = 0 THEN 'Tributável' "
                + " WHEN I.TIPODETRIBUTACAO = 1 THEN 'Imune' "
                + " WHEN I.TIPODETRIBUTACAO = 2 THEN 'Isento' "
                + " END"
                + " TIPOTRIBUTACAO"
                + " FROM IMOVEL I"
                + " LEFT JOIN ENDERECOS EI ON (EI.CODENDERECO = I.ENDERECO)"
                + " LEFT JOIN LOGRADOUROS L ON (L.CODLOGRADOURO = EI.CODLOGRADOURO)"
                + " LEFT JOIN TIPOLOGRADOURO TL ON (TL.CODIGO = L.TIPO)"
                + " LEFT JOIN BAIRROS B ON (B.CODBAIRRO = EI.CODBAIRRO)"
                + " LEFT JOIN DISTRITOS D ON (D.CODDISTRITO = B.CODDISTRITO)"
                + " LEFT JOIN PESSOAS P ON (P.CODPESSOA = I.PESSOA)"
        //        + " WHERE P.CODPESSOA =" + p.getCodigo()
                + " ORDER BY I.codigo,L.LOGRADOURO, I.NUMERO";

        Map<String, Object> map = new HashMap<String, Object>();
       

      
        
        //new VisualizaRelatorio().visRel("hlh/tributos/relatorios/imovel/RTribImov_Contr.jasper", "Relatórios Imóveis por Contribuintes", null, SQL);
       // return gerarRelatorioByteArray(SQL,"Relatórios Imóveis por Contribuintes", "RTribImov_Contr.jasper", map);
       return null;
    }
        public static boolean sendEmailAnexos(String from, String fromName, String pass, String assunto, String msg,
            List<AnexoDTO> anexos, String nomeAnexo, String to[]) {
        if (to == null || to.length < 1 || to[0].trim().length() < 5) {
            return false;
        }
        String host = "";
        Properties props = System.getProperties();

        props.put("mail.smtp.starttls.enable", "false");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.trust", host);

        Session session = Session.getInstance(props, null);

        MimeMessage mimeMsg = new MimeMessage(session);

        MimeBodyPart mimeBP = new MimeBodyPart();
        MimeMultipart multipart = new MimeMultipart();
        try {
            mimeMsg.setFrom(new InternetAddress(from, fromName));

            InternetAddress[] toAddress = new InternetAddress[to.length];

            for (int i = 0; i < to.length; i++) {

                toAddress[i] = new InternetAddress(to[i]);

            }

            mimeMsg.setRecipients(Message.RecipientType.TO, toAddress);
            mimeMsg.setSubject(assunto);

            mimeBP.setContent(msg, "text/html; charset=UTF-8");

            multipart.addBodyPart(mimeBP);

            System.out.println("msg: " + msg);
            //Anexando arquivos /
            if (anexos != null) {
                for (AnexoDTO adto : anexos) {
                    mimeBP = new MimeBodyPart();
                    ByteArrayDataSource byteDS = new ByteArrayDataSource(adto.getConteudo(), adto.getMimeType());
                    mimeBP.setDataHandler(new DataHandler(byteDS));
                    mimeBP.setFileName(adto.getNome());
                    multipart.addBodyPart(mimeBP);
                }

                mimeMsg.setContent(multipart);

                System.out.println("anexos: " + anexos);
                System.out.println("mimeMsg.getAllRecipients() " + mimeMsg.getAllRecipients());
                System.out.println("mimeMsg: " + mimeMsg.toString());

                Transport transp = session.getTransport("smtp");
                transp.connect(host, from, pass);
                transp.sendMessage(mimeMsg, mimeMsg.getAllRecipients());
                transp.close();

                return true;
            } else {
                return true;
            }

        } catch (Exception ex) {
            //Logger.getLogger(UtEmailSender.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return false;
        }
    }
}
    