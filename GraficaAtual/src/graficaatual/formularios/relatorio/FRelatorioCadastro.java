/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.relatorio;


import graficaatual.daos.UsuariosDAO;
import graficaatual.daos.cadastro.BairroDAO;
import graficaatual.daos.cadastro.CargoDAO;
import graficaatual.daos.cadastro.CidadeDAO;
import graficaatual.daos.cadastro.ClienteDAO;
import graficaatual.daos.cadastro.ColaboradorDAO;
import graficaatual.daos.cadastro.FornecedorDAO;
import graficaatual.daos.cadastro.LogradouroDAO;
import graficaatual.daos.relatorio.EntidadeDAO;
import graficaatual.entidades.Bairro;
import graficaatual.entidades.Cidade;
import graficaatual.entidades.Cliente;
import graficaatual.entidades.Logradouro;
import graficaatual.entidades.relatorio.Entidade;
import graficaatual.pesq.cadastro.CnvCadastroCliente;
import graficaatual.utilitarios.ValidarValor;
import graficaatual.utilitarios.VisualizaRelatorio;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author si10
 */
public class FRelatorioCadastro extends javax.swing.JInternalFrame {

    // Tela
    private static int initControle;
    private int localIncusao;
    private static FRelatorioCadastro instance;
    private static FRelatorioCadastro instanceCont;
        
    //Controle de Navegação
    CnvCadastroCliente cnvClienteCad = new CnvCadastroCliente();
    private JFormattedTextField cpf;
            
            
    public FRelatorioCadastro() {
        
        initComponents();              
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        

    }
    
    public static int isInicializado() {
        return initControle;
    }
         
  public synchronized static FRelatorioCadastro getInstance() {
        if (instance == null) {
            instance = new FRelatorioCadastro();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel10 = new javax.swing.JPanel();
        try {
            cpf = new JFormattedTextField(
                new MaskFormatter("###.###.###-##"));
            ((JFormattedTextField) cpf).setFocusLostBehavior(0);

        } catch (Exception e) {
        }
        jLabel2 = new javax.swing.JLabel();
        jCRelatorio = new javax.swing.JComboBox<>();
        jRIndividual = new javax.swing.JRadioButton();
        jRLista = new javax.swing.JRadioButton();
        codFina = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        codInicial = new javax.swing.JTextField();
        imprimir = new javax.swing.JButton();
        sair = new javax.swing.JButton();

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
        jLabel2.setText("RELATÓRIO DE CADASTROS ");
        jPanel10.add(jLabel2);
        jLabel2.setBounds(50, 0, 970, 70);

        jCRelatorio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jCRelatorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Cadastro", "Clientes", "Fornecedores", "Logradouros", "Bairro", "Cidade", "Usuários", "Colaborador", "Cargo", "Turno", "Material", "Produtos", "Acabamentos", "Forma de Pagamento" }));
        jPanel10.add(jCRelatorio);
        jCRelatorio.setBounds(60, 90, 430, 30);

        jRIndividual.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRIndividual);
        jRIndividual.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jRIndividual.setText("Relatório Individual");
        jRIndividual.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRIndividualStateChanged(evt);
            }
        });
        jPanel10.add(jRIndividual);
        jRIndividual.setBounds(60, 130, 210, 23);

        jRLista.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRLista);
        jRLista.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jRLista.setSelected(true);
        jRLista.setText("Lista do Item Selecionado");
        jPanel10.add(jRLista);
        jRLista.setBounds(280, 130, 210, 23);
        jPanel10.add(codFina);
        codFina.setBounds(290, 190, 200, 20);

        jLabel72.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel72.setText("Código Final");
        jPanel10.add(jLabel72);
        jLabel72.setBounds(290, 170, 100, 20);

        jLabel73.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel73.setText("Código Inicial");
        jPanel10.add(jLabel73);
        jLabel73.setBounds(60, 170, 100, 20);

        codInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codInicialFocusLost(evt);
            }
        });
        jPanel10.add(codInicial);
        codInicial.setBounds(60, 190, 170, 20);

        imprimir.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir2.png"))); // NOI18N
        imprimir.setText("Imprimir");
        imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirActionPerformed(evt);
            }
        });
        jPanel10.add(imprimir);
        imprimir.setBounds(560, 320, 250, 40);

        sair.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAIR2.png"))); // NOI18N
        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        jPanel10.add(sair);
        sair.setBounds(310, 320, 250, 40);

        getContentPane().add(jPanel10);
        jPanel10.setBounds(0, 0, 1100, 700);
        jPanel10.getAccessibleContext().setAccessibleName("Cadastro de Pessoas");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirActionPerformed
        try{
            imprimir();
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Erro: "+ e.getMessage());
        }
    }//GEN-LAST:event_imprimirActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sairActionPerformed

    private void jRIndividualStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRIndividualStateChanged
        if(jRIndividual.isSelected()){
            codInicial.setText("0");
            codFina.setText("0");
            codFina.setEnabled(false);
        }else{
            codInicial.setText("0");
            codFina.setText("9999999");
            codFina.setEnabled(true);
        }
    }//GEN-LAST:event_jRIndividualStateChanged

    private void codInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codInicialFocusLost
         if(jRIndividual.isSelected()){
            codFina.setText( codInicial.getText());
        }
    }//GEN-LAST:event_codInicialFocusLost
  
    
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField codFina;
    private javax.swing.JTextField codInicial;
    private javax.swing.JButton imprimir;
    private javax.swing.JComboBox<String> jCRelatorio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JRadioButton jRIndividual;
    private javax.swing.JRadioButton jRLista;
    private javax.swing.JButton sair;
    // End of variables declaration//GEN-END:variables

    private void imprimir() throws Exception {
        String sql ="";
        switch(jCRelatorio.getSelectedIndex()){
            
            //Ordem     
            //1-Clientes, 2- Fornecedores, 3- Logradouros
            //4- Bairro, 5- Cidade, 6- Usuários
            //7- Colaborador, 8- Cargo,  9- Turno
            //10- Material, 11- Produtos, 12- Acabamentos
            //13- Forma de Pagamento
            
            case 1:
                sql = new ClienteDAO().getSqlLista(ValidarValor.getInt(codInicial.getText()),ValidarValor.getInt(codFina.getText()));  
                new VisualizaRelatorio().visRel("graficaatual/relatorios/arquivos/listaCliente.jasper", "Relatório de Lista de Clientes", null, sql);
                break;
            case 2:
                sql = new FornecedorDAO().getSqlList(ValidarValor.getInt(codInicial.getText()),ValidarValor.getInt(codFina.getText()));  
                new VisualizaRelatorio().visRel("graficaatual/relatorios/arquivos/listaFornecedor.jasper", "Relatório de Lista de Fornecedor", null, sql);
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                 sql = new UsuariosDAO().getSqlLista(ValidarValor.getInt(codInicial.getText()),ValidarValor.getInt(codFina.getText()));  
                new VisualizaRelatorio().visRel("graficaatual/relatorios/arquivos/listaUsuario.jasper", "Relatório de Lista de Usuários", null, sql);
        
                break;
            case 7:
                sql = new ColaboradorDAO().getSqlList(ValidarValor.getInt(codInicial.getText()),ValidarValor.getInt(codFina.getText()));  
                new VisualizaRelatorio().visRel("graficaatual/relatorios/arquivos/listaColaborador.jasper", "Relatório de Lista de Colaborador", null, sql);
                break;
            case 8:
                sql = new CargoDAO().getSqlList(ValidarValor.getInt(codInicial.getText()),ValidarValor.getInt(codFina.getText()));  
                new VisualizaRelatorio().visRel("graficaatual/relatorios/arquivos/listaCargo.jasper", "Relatório de Lista de Cargos", null, sql);
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            default:
                JOptionPane.showMessageDialog(this, "Erro na seleção");
                break;
        }
    }


  
}
