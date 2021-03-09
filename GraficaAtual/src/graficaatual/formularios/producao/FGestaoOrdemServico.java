/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.producao;

import graficaatual.daos.pedido.ItemOrcamentoDAO;
import graficaatual.daos.pedido.OrcamentoDAO;
import graficaatual.daos.producao.OrdemServicoDAO;
import graficaatual.daos.relatorio.TextoPadraoDAO;
import graficaatual.entidades.pedido.ItemOrcamento;
import graficaatual.entidades.pedido.Orcamento;
import graficaatual.entidades.producao.OrdemServico;
import graficaatual.utilitarios.Conexao;
import graficaatual.utilitarios.Data;
import graficaatual.utilitarios.Persistencia;
import graficaatual.utilitarios.VisualizaRelatorio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author si10
 */
public class FGestaoOrdemServico extends javax.swing.JInternalFrame {

    // Tela
    private static int initControle;
    private int localIncusao;
    private static FGestaoOrdemServico instance;
    private static FGestaoOrdemServico instanceCont;

    //Entidades para trabalhar
    private OrdemServico ordem = null;
    private OrdemServicoDAO ordemDao = new OrdemServicoDAO();
    
    private ItemOrcamentoDAO itemDao = new ItemOrcamentoDAO();
    private OrcamentoDAO orcamentoDao = new OrcamentoDAO();

    DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();

    private JFormattedTextField cpf;

    public FGestaoOrdemServico() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        pesquisarFazer();
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

    public synchronized static FGestaoOrdemServico getInstance() {
        if (instance == null) {
            instance = new FGestaoOrdemServico();
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabOrdensFazer = new javax.swing.JTable();
        tabOrdensFazer= new TabelaConsultaOrdem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabConcluida = new javax.swing.JTable();
        tabOrdensFazer= new TabelaConsultaOrdem();
        jLSelecao = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBorder(null);
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
        jLabel2.setText("GESTÃO PRODUÇÃO");
        jPanel10.add(jLabel2);
        jLabel2.setBounds(0, 0, 1060, 70);

        salvar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/colaborador2.png"))); // NOI18N
        salvar.setText("Enviar Entrega/Faturamento");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });
        jPanel10.add(salvar);
        salvar.setBounds(70, 590, 270, 40);

        sair.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAIR2.png"))); // NOI18N
        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        jPanel10.add(sair);
        sair.setBounds(840, 590, 130, 40);

        jScrollPane6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        tabOrdensFazer.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tabOrdensFazer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ORDEM", "PEDIDO", "PRODUTO", "ENTREGA", "CRIAÇÃO", "PROJETO", "PLOTAGEM", "IMP. DIGITAL", "ACABAMENTO IMP.", "RECORTE PLOTAGEM", "SERRALHERIA", "PINTURA", "CAIXARIA", "CORTE ROUTER"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabOrdensFazer.setRowHeight(90);
        tabOrdensFazer.getTableHeader().setReorderingAllowed(false);
        tabOrdensFazer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabOrdensFazerMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabOrdensFazer);
        if (tabOrdensFazer.getColumnModel().getColumnCount() > 0) {
            tabOrdensFazer.getColumnModel().getColumn(4).setHeaderValue("CRIAÇÃO");
            tabOrdensFazer.getColumnModel().getColumn(5).setHeaderValue("PROJETO");
            tabOrdensFazer.getColumnModel().getColumn(6).setHeaderValue("PLOTAGEM");
            tabOrdensFazer.getColumnModel().getColumn(7).setHeaderValue("IMP. DIGITAL");
            tabOrdensFazer.getColumnModel().getColumn(8).setHeaderValue("ACABAMENTO IMP.");
            tabOrdensFazer.getColumnModel().getColumn(9).setHeaderValue("RECORTE PLOTAGEM");
            tabOrdensFazer.getColumnModel().getColumn(10).setHeaderValue("SERRALHERIA");
            tabOrdensFazer.getColumnModel().getColumn(11).setHeaderValue("PINTURA");
            tabOrdensFazer.getColumnModel().getColumn(12).setHeaderValue("CAIXARIA");
        }

        jTabbedPane1.addTab("Lista de Produção  - A Fazer", jScrollPane6);

        jPanel1.setLayout(null);

        jScrollPane7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        tabConcluida.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tabConcluida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ORDEM", "PEDIDO", "PRODUTO", "ENTREGA", "CRIAÇÃO", "PROJETO", "PLOTAGEM", "IMP. DIGITAL", "ACABAMENTO IMP.", "RECORTE PLOTAGEM", "SERRALHERIA", "PINTURA", "CAIXARIA", "CORTE ROUTER"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabConcluida.setRowHeight(90);
        tabConcluida.getTableHeader().setReorderingAllowed(false);
        tabConcluida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabConcluidaMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabConcluida);
        if (tabConcluida.getColumnModel().getColumnCount() > 0) {
            tabConcluida.getColumnModel().getColumn(4).setHeaderValue("CRIAÇÃO");
            tabConcluida.getColumnModel().getColumn(5).setHeaderValue("PROJETO");
            tabConcluida.getColumnModel().getColumn(6).setHeaderValue("PLOTAGEM");
            tabConcluida.getColumnModel().getColumn(7).setHeaderValue("IMP. DIGITAL");
            tabConcluida.getColumnModel().getColumn(8).setHeaderValue("ACABAMENTO IMP.");
            tabConcluida.getColumnModel().getColumn(9).setHeaderValue("RECORTE PLOTAGEM");
            tabConcluida.getColumnModel().getColumn(10).setHeaderValue("SERRALHERIA");
            tabConcluida.getColumnModel().getColumn(11).setHeaderValue("PINTURA");
            tabConcluida.getColumnModel().getColumn(12).setHeaderValue("CAIXARIA");
        }

        jPanel1.add(jScrollPane7);
        jScrollPane7.setBounds(0, 0, 1040, 402);

        jTabbedPane1.addTab("Lista de Produção - Concluída", jPanel1);

        jPanel10.add(jTabbedPane1);
        jTabbedPane1.setBounds(20, 110, 1050, 470);

        jLSelecao.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jPanel10.add(jLSelecao);
        jLSelecao.setBounds(20, 80, 690, 20);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/turno2.png"))); // NOI18N
        jButton1.setText("Atualizar Tabela");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton1);
        jButton1.setBounds(860, 70, 200, 40);

        cancelar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excuir2.png"))); // NOI18N
        cancelar.setText("Cancelar Pedido");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel10.add(cancelar);
        cancelar.setBounds(340, 590, 270, 40);

        jButton2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir2.png"))); // NOI18N
        jButton2.setText("Lista Geral");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton2);
        jButton2.setBounds(610, 590, 230, 40);

        getContentPane().add(jPanel10);
        jPanel10.setBounds(10, 0, 1100, 700);
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

        ordem = new OrdemServicoDAO().get((Integer) tabOrdensFazer.getValueAt(tabOrdensFazer.getSelectedRow(), 0));
        if (ordem != null) {

            //Fauramento e Entrega
            ordem.setCheckEntrega(true);
            ordem.setCheckFaturamento(true);
            ordem = ordemDao.addOrdem(ordem);
            
        } else {
            JOptionPane.showMessageDialog(this, " Escolha uma Ordem de seviço, selecionando com um click.");
        }
    }


    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void tabOrdensFazerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabOrdensFazerMouseClicked
        try {

            jLSelecao.setText(" Ordem de Serviço Selecionada: " + tabOrdensFazer.getValueAt(tabOrdensFazer.getSelectedRow(), 0)
                    + ", Pedido - " + tabOrdensFazer.getValueAt(tabOrdensFazer.getSelectedRow(), 1));

            if (evt.getClickCount() > 1) {
                imprimir((Integer) tabOrdensFazer.getValueAt(tabOrdensFazer.getSelectedRow(), 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar Orçamento! \n " + e);
        }
    }//GEN-LAST:event_tabOrdensFazerMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            pesquisarFazer();
            pesquisarConcluido();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro :" + e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabConcluidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabConcluidaMouseClicked
        try {

            jLSelecao.setText(" Ordem de Serviço Selecionada: " + tabConcluida.getValueAt(tabConcluida.getSelectedRow(), 0)
                    + ", Pedido - " + tabConcluida.getValueAt(tabConcluida.getSelectedRow(), 1));

            if (evt.getClickCount() > 1) {
                imprimir((Integer) tabConcluida.getValueAt(tabConcluida.getSelectedRow(), 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar Orçamento! \n " + e);
        }
    }//GEN-LAST:event_tabConcluidaMouseClicked

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            ordem = new OrdemServicoDAO().get((Integer) tabOrdensFazer.getValueAt(tabOrdensFazer.getSelectedRow(), 0));
            if (ordem != null) {
                Orcamento orcamento = ordem.getOrcamento();
                if(orcamento !=null){
                    //Delete Itens OrdemDeSeviço
                    List<ItemOrcamento> listaItenOrcamento = itemDao.getListOrcamento(session,orcamento.getCodOrcamento());
                    if(listaItenOrcamento !=null && !listaItenOrcamento.isEmpty()){
                        for(ItemOrcamento item : listaItenOrcamento){
                            itemDao.deletePojo(session, item);
                        }
                    
                     //Delete Ordens de Serviço
                        List<OrdemServico> listaOrdens = ordemDao.getListByOrcamento(orcamento.getCodOrcamento(),session);
                        if(listaOrdens != null && !listaOrdens.isEmpty()){
                                for(OrdemServico o : listaOrdens ){
                                    ordemDao.deletePojo(session, o);
                                }
                        }
                        
                     //Cancela Orcamento
                        orcamento.setSituacao(false);
                        orcamento = new OrcamentoDAO().salvar(session, orcamento);
                        
                        session.getTransaction().commit();
                        session.close();
                        pesquisarFazer();
                        pesquisarConcluido();
                        
                          JOptionPane.showMessageDialog(this, " Cancelado com Sucesso! ");
                    }
                }else{
                    throw new Exception("Problema na Ordem, sem Pedido Vinculado.");
                }
            } else {
                throw new Exception("Selecione um Ordem/Pedido");
            }


        } catch (Exception ex) {
            session.getTransaction().rollback();
            session.close();
            JOptionPane.showMessageDialog(this, "Erro ao Cancelar. Tente Novamente");
        }
    }//GEN-LAST:event_cancelarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String sql = " select orc.codorcamento as codorcamento , "
                    + " orc.prazoentrega  as prazoentrega,"
                    + " (pes.nome || '-' || orc.clientesecundario ||', '||orc.telefonesecundario) as nome , "
                    + " orc.enderecosecundario as endereco,"
                    + " prod.descricao as descricao , "
                    + " ord.equipeentrega || ' ' || equipe.nome as equipe"
                    + " from ordemservico as ord "
                    + " inner join orcamento as orc on (orc.codorcamento = ord.orcamento )"
                    + " left join produto as prod on (ord.produto = prod.codproduto)"
                    + " left join cliente as cli on (cli.codcliente = orc.cliente)"
                    + " left join pessoa as pes on (cli.pessoa = pes.codpessoa) "
                    + " left join equipeentrega as equipe on (ord.equipeentrega = equipe.codequipeentrega)"
                    + " where ord.checkentrega=FALSE and  ord.datafimentrega is null"
                    + " order by orc.prazoentrega , orc.codorcamento , prod.descricao ";

            new VisualizaRelatorio().visRel("graficaatual/relatorios/arquivos/ordemServico.jasper", "RELATÓRIO - ORDEM DE SERVIÇOS", null, sql);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório de bairros! \n " + e);
        }     
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void removeLinhas(JTable table) {
        int n = table.getRowCount();

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (int i = n - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLSelecao;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton sair;
    private javax.swing.JButton salvar;
    private javax.swing.JTable tabConcluida;
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
                    + " LEFT JOIN produto prod ON prod.codproduto = item.produto"
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

            String pesq = "";

            String sql = getSql(true);
            sql = sql + pesq
                    + " order by orc.prazoentrega, orc.codorcamento ";
            ResultSet rs = bancoConsulta.executeQuery(sql);
            while (rs.next()) {
                Object[] o = new Object[]{
                    rs.getInt("codordemservico"),
                    rs.getInt("codorcamento"),
                    rs.getString("coditemorca"),
                    Data.getDateParse(rs.getDate("prazoentrega"), Data.FORMAT_DATA_BR),
                    (rs.getBoolean("checkcriacao")?(rs.getDate("datafimcriacao") !=null ? "<html>"+Data.getDateParse(rs.getDate("datafimcriacao"), Data.FORMAT_DATA_BR) +"<br>"+ rs.getString("usuariofimcriacao")+"</html>": "À Fazer") : ""),
                    (rs.getBoolean("checkprojeto")?(rs.getDate("datafimprojeto") !=null ?  "<html>"+Data.getDateParse(rs.getDate("datafimprojeto"), Data.FORMAT_DATA_BR)+"<br>"+ rs.getString("usuariofimprojeto")+"</html>": "À Fazer") : ""),
                    (rs.getBoolean("checkplotagem")?(rs.getDate("datafimplotagem") !=null ?  "<html>"+Data.getDateParse(rs.getDate("datafimplotagem"), Data.FORMAT_DATA_BR)+"<br>"+ rs.getString("usuariofimplotagem")+"</html>": "À Fazer") : ""),
                    (rs.getBoolean("checkimpressaodigital")?(rs.getDate("datafimimpressaodigital") !=null ?  "<html>"+Data.getDateParse(rs.getDate("datafimimpressaodigital"), Data.FORMAT_DATA_BR) +"<br>"+ rs.getString("usuariofimimpressaodigital")+"</html>": "À Fazer") : ""),
                    (rs.getBoolean("checkacabamentoimp")?(rs.getDate("datafimacabamentoimp") !=null ?  "<html>"+Data.getDateParse(rs.getDate("datafimacabamentoimp"), Data.FORMAT_DATA_BR) +"<br>"+ rs.getString("usuariofimacabamentoimp")+"</html>" : "À Fazer") : ""),
                    (rs.getBoolean("checkploterrecorte")?(rs.getDate("datafimploterrecorte") !=null ?  "<html>"+Data.getDateParse(rs.getDate("datafimploterrecorte"), Data.FORMAT_DATA_BR) +"<br>"+ rs.getString("usuariofimploterrecorte")+"</html>" : "À Fazer"): ""),
                    (rs.getBoolean("checkserralheria")?(rs.getDate("datafimserralheria") !=null ?  "<html>"+Data.getDateParse(rs.getDate("datafimserralheria"), Data.FORMAT_DATA_BR) +"<br>"+ rs.getString("usuariofimserralheria")+"</html>": "À Fazer") : ""),
                    (rs.getBoolean("checkpintura")?(rs.getDate("datafimpintura") !=null ?  "<html>"+Data.getDateParse(rs.getDate("datafimpintura"), Data.FORMAT_DATA_BR)+"<br>"+rs.getString("usuariofimpintura")+"</html>": "À Fazer") : ""),
                    (rs.getBoolean("checkcaixariaacabamento")?(rs.getDate("datafimcaixariaacabamento") !=null ? "<html>"+Data.getDateParse(rs.getDate("datafimcaixariaacabamento"), Data.FORMAT_DATA_BR)+"<br>"+ rs.getString("usuariofimcaixariaacabamento")+"</html>": "À Fazer") : ""),
                    (rs.getBoolean("checkrouter")?(rs.getDate("datafimrouter") !=null ?  "<html>"+Data.getDateParse(rs.getDate("datafimrouter"), Data.FORMAT_DATA_BR) +"<br>"+ rs.getString("usuariofimrouter")+"</html>": "À Fazer") : ""),
                };
                model.addRow(o);
            }
            int[] posicoes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,13};
            alinhaTableCentro(tabOrdensFazer, posicoes);
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

    public void alinhaTableCentro(JTable table, int[] posicoesDireita) {

        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        cellRender.setHorizontalAlignment(SwingConstants.CENTER);

        for (int numCol = 0; numCol < table.getColumnCount(); numCol++) {

            for (int i = 0; i < posicoesDireita.length; i++) {

                if (numCol == posicoesDireita[i]) {

                    table.getColumnModel().getColumn(numCol).setCellRenderer(
                            cellRender);
                }
            }
        }
    }

    private void pesquisarConcluido() {

        DefaultTableModel model = (DefaultTableModel) tabConcluida.getModel();
        Statement bancoConsulta = null;
        Connection conexao = null;
        removeLinhas(tabConcluida);

        try {
            conexao = Conexao.getConexao();
            bancoConsulta = Conexao.getBanco(conexao);

            String sql = getSql(false);
            sql = sql + " order by orc.prazoentrega desc, orc.codorcamento ";
            //System.out.println(" uuuuuuuuuuuu "+sql);
            ResultSet rs = bancoConsulta.executeQuery(sql);
             while (rs.next()) {
                Object[] o = new Object[]{
                    rs.getInt("codordemservico"),
                    rs.getInt("codorcamento"),
                    rs.getString("coditemorca"),
                    Data.getDateParse(rs.getDate("prazoentrega"), Data.FORMAT_DATA_BR),
                    (rs.getBoolean("checkcriacao")?(rs.getDate("datafimcriacao") !=null ? "<html>"+Data.getDateParse(rs.getDate("datafimcriacao"), Data.FORMAT_DATA_BR) +"<br>"+ rs.getString("usuariofimcriacao")+"</html>": "À Fazer") : ""),
                    (rs.getBoolean("checkprojeto")?(rs.getDate("datafimprojeto") !=null ?  "<html>"+Data.getDateParse(rs.getDate("datafimprojeto"), Data.FORMAT_DATA_BR)+"<br>"+ rs.getString("usuariofimprojeto")+"</html>": "À Fazer") : ""),
                    (rs.getBoolean("checkplotagem")?(rs.getDate("datafimplotagem") !=null ?  "<html>"+Data.getDateParse(rs.getDate("datafimplotagem"), Data.FORMAT_DATA_BR)+"<br>"+ rs.getString("usuariofimplotagem")+"</html>": "À Fazer") : ""),
                    (rs.getBoolean("checkimpressaodigital")?(rs.getDate("datafimimpressaodigital") !=null ?  "<html>"+Data.getDateParse(rs.getDate("datafimimpressaodigital"), Data.FORMAT_DATA_BR) +"<br>"+ rs.getString("usuariofimimpressaodigital")+"</html>": "À Fazer") : ""),
                    (rs.getBoolean("checkacabamentoimp")?(rs.getDate("datafimacabamentoimp") !=null ?  "<html>"+Data.getDateParse(rs.getDate("datafimacabamentoimp"), Data.FORMAT_DATA_BR) +"<br>"+ rs.getString("usuariofimacabamentoimp")+"</html>" : "À Fazer") : ""),
                    (rs.getBoolean("checkploterrecorte")?(rs.getDate("datafimploterrecorte") !=null ?  "<html>"+Data.getDateParse(rs.getDate("datafimploterrecorte"), Data.FORMAT_DATA_BR) +"<br>"+ rs.getString("usuariofimploterrecorte")+"</html>" : "À Fazer"): ""),
                    (rs.getBoolean("checkserralheria")?(rs.getDate("datafimserralheria") !=null ?  "<html>"+Data.getDateParse(rs.getDate("datafimserralheria"), Data.FORMAT_DATA_BR) +"<br>"+ rs.getString("usuariofimserralheria")+"</html>": "À Fazer") : ""),
                    (rs.getBoolean("checkpintura")?(rs.getDate("datafimpintura") !=null ?  "<html>"+Data.getDateParse(rs.getDate("datafimpintura"), Data.FORMAT_DATA_BR)+"<br>"+rs.getString("usuariofimpintura")+"</html>": "À Fazer") : ""),
                    (rs.getBoolean("checkcaixariaacabamento")?(rs.getDate("datafimcaixariaacabamento") !=null ? "<html>"+Data.getDateParse(rs.getDate("datafimcaixariaacabamento"), Data.FORMAT_DATA_BR)+"<br>"+ rs.getString("usuariofimcaixariaacabamento")+"</html>": "À Fazer") : ""),
                    (rs.getBoolean("checkrouter")?(rs.getDate("datafimrouter") !=null ?  "<html>"+Data.getDateParse(rs.getDate("datafimrouter"), Data.FORMAT_DATA_BR) +"<br>"+ rs.getString("usuariofimrouter")+"</html>": "À Fazer") : ""),
                };
                model.addRow(o);
            }
            
            int[] posicoes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,13};
            alinhaTableCentro(tabConcluida, posicoes); 
             
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

    private String getSql(boolean aFazer) {
        String sql = " select ord.codordemservico as  codordemservico,"
                + "  orc.codorcamento as codorcamento , "
                + " (ord.produto ||' '|| prod.descricao) as coditemorca  , "
                + " orc.prazoentrega  as prazoentrega,"
                + " ord.checkcriacao, ord.datafimcriacao, ord.usuariofimcriacao,"
                + " ord.checkprojeto, ord.datafimprojeto, ord.usuariofimprojeto,"
                + " ord.checkplotagem, ord.datafimplotagem, ord.usuariofimplotagem,"
                + " ord.checkimpressaodigital, ord.datafimimpressaodigital, ord.usuariofimimpressaodigital,"
                + " ord.checkacabamentoimp, ord.datafimacabamentoimp, ord.usuariofimacabamentoimp ,"
                + " ord.checkploterrecorte, ord.datafimploterrecorte, ord.usuariofimploterrecorte ,"
                + " ord.checkserralheria, ord.datafimserralheria, ord.usuariofimserralheria,"
                + " ord.checkpintura, ord.datafimpintura, ord.usuariofimpintura,"
                + " ord.checkcaixariaacabamento, ord.datafimcaixariaacabamento, ord.usuariofimcaixariaacabamento,"
                + " ord.checkrouter,ord.datafimrouter,ord.usuariofimrouter"
                + " from ordemservico as ord "
                + " inner join orcamento as orc on (orc.codorcamento = ord.orcamento )"
                + " left join produto as prod on (ord.produto = prod.codproduto)"
                + " left join cliente as cli on (cli.codcliente = orc.cliente)"
                + " left join pessoa as pes on (cli.pessoa = pes.codpessoa)";
        if (aFazer) {
                sql = sql + " where (ord.checkfaturamento = false and ord.checkfaturamento = false ) ";
        } else {
               sql = sql + " where (ord.checkfaturamento = true and ord.checkfaturamento = true ) ";
        }
        return sql;
    }

}
