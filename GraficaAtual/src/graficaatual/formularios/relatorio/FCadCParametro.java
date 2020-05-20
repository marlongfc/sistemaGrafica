/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.formularios.relatorio;


import graficaatual.daos.cadastro.BairroDAO;
import graficaatual.daos.cadastro.CidadeDAO;
import graficaatual.daos.cadastro.LogradouroDAO;
import graficaatual.daos.relatorio.EntidadeDAO;
import graficaatual.entidades.Bairro;
import graficaatual.entidades.Cidade;
import graficaatual.entidades.Cliente;
import graficaatual.entidades.Logradouro;
import graficaatual.entidades.relatorio.Entidade;
import graficaatual.pesq.cadastro.CnvCadastroCliente;
import graficaatual.utilitarios.Componentes;
import graficaatual.utilitarios.Persistencia;
import graficaatual.utilitarios.ValidarValor;
import graficaatual.utilitarios.VisualizaRelatorio;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author si10
 */
public class FCadCParametro extends javax.swing.JInternalFrame {

    // Tela
    private static int initControle;
    private int localIncusao;
    private static FCadCParametro instance;
    private static FCadCParametro instanceCont;
    
    //Entidades 
    private String FvaFiguraBrasao="";

    private Entidade entidade = null;
    private EntidadeDAO entidadeDao = new EntidadeDAO();
    
    private Logradouro logradouro = null;
    private LogradouroDAO logradouroDao = new LogradouroDAO();
    
    private Bairro bairro = null;
    private BairroDAO bairroDao = new BairroDAO();
    
    private Cidade cidade = null;
    private CidadeDAO cidadeDao = new CidadeDAO();
    
    
    // Lista Suspensa
    private List<Cliente> listaClienteNome = null;
    private List<Cliente> listaClienteCPF = null;
    private List<Logradouro> listaLogradouroNome = null;
    private List<Bairro> listaBairroNome = null;
    private List<Cidade> listaCidadeNome = null;
    
    //Controle de Navegação
    CnvCadastroCliente cnvClienteCad = new CnvCadastroCliente();
    private JFormattedTextField cpf;
            
            
    public FCadCParametro() {
        initComponents();      
        
        listaLogradouroNome = ObservableCollections.observableList(new LinkedList<Logradouro>());
        Componentes comp4 = new Componentes(listaLogradouroNome, false, codLogradouro, descLogradouro, this, jPanel10, descLogradouro.getWidth(), 100);
        comp4.addCol(0, "codLogradouro", "Código", 50, Long.class.getName());
        comp4.addCol(1, "descricao", "Nome", 200, String.class.getName());
        comp4.bind();

        listaBairroNome = ObservableCollections.observableList(new LinkedList<Bairro>());
        Componentes comp5 = new Componentes(listaBairroNome, false, codBairro, descBairro, this, jPanel10, descBairro.getWidth(), 100);
        comp5.addCol(0, "codBairro", "Código", 50, Long.class.getName());
        comp5.addCol(1, "descricao", "Nome", 200, String.class.getName());
        comp5.bind();

        listaCidadeNome = ObservableCollections.observableList(new LinkedList<Cidade>());
        Componentes comp6 = new Componentes(listaCidadeNome, false, codCidade, descCidade, this, jPanel10, descCidade.getWidth(), 100);
        comp6.addCol(0, "codCidade", "Código", 50, Long.class.getName());
        comp6.addCol(1, "descricao", "Nome", 200, String.class.getName());
        comp6.bind();
        
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        
        habilitaCampos(true);
        try {
            verificaEntidade();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro: "+ ex.getMessage());
        }
    }
    
    public static int isInicializado() {
        return initControle;
    }
         
  public synchronized static FCadCParametro getInstance() {
        if (instance == null) {
            instance = new FCadCParametro();
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
        codLogradouro = new javax.swing.JTextField();
        descLogradouro = new javax.swing.JTextField();
        numero = new javax.swing.JTextField();
        codBairro = new javax.swing.JTextField();
        descBairro = new javax.swing.JTextField();
        complemento = new javax.swing.JTextField();
        codCidade = new javax.swing.JTextField();
        descCidade = new javax.swing.JTextField();
        cep = new javax.swing.JTextField();
        try{
            cep = new JFormattedTextField(
                new MaskFormatter("##.###-###"));
            ((JFormattedTextField) cep).setFocusLostBehavior(0);
        }catch(Exception e){}
        uf = new javax.swing.JTextField();
        cnpj = new javax.swing.JTextField();
        try {
            cnpj = new JFormattedTextField(
                new MaskFormatter("##.###.###/####-##"));
            ((JFormattedTextField) cnpj).setFocusLostBehavior(0);

        } catch (Exception e) {
        }
        nome = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        telefone = new javax.swing.JTextField();
        inscMunicipal = new javax.swing.JTextField();
        inscEstadual = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        salvar = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        brasao = new javax.swing.JButton();
        jLabel72 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

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

        codLogradouro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codLogradouroFocusLost(evt);
            }
        });
        jPanel10.add(codLogradouro);
        codLogradouro.setBounds(220, 210, 80, 20);

        descLogradouro.setBackground(new java.awt.Color(255, 255, 204));
        descLogradouro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descLogradouroKeyReleased(evt);
            }
        });
        jPanel10.add(descLogradouro);
        descLogradouro.setBounds(300, 210, 530, 20);
        jPanel10.add(numero);
        numero.setBounds(830, 210, 190, 20);

        codBairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codBairroFocusLost(evt);
            }
        });
        jPanel10.add(codBairro);
        codBairro.setBounds(220, 250, 80, 20);

        descBairro.setBackground(new java.awt.Color(255, 255, 204));
        descBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descBairroKeyReleased(evt);
            }
        });
        jPanel10.add(descBairro);
        descBairro.setBounds(300, 250, 530, 20);
        jPanel10.add(complemento);
        complemento.setBounds(830, 250, 190, 20);

        codCidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codCidadeFocusLost(evt);
            }
        });
        jPanel10.add(codCidade);
        codCidade.setBounds(220, 290, 80, 20);

        descCidade.setBackground(new java.awt.Color(255, 255, 204));
        descCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descCidadeKeyReleased(evt);
            }
        });
        jPanel10.add(descCidade);
        descCidade.setBounds(300, 290, 530, 20);
        jPanel10.add(cep);
        cep.setBounds(880, 290, 140, 20);
        jPanel10.add(uf);
        uf.setBounds(830, 290, 50, 20);
        jPanel10.add(cnpj);
        cnpj.setBounds(700, 100, 180, 20);
        jPanel10.add(nome);
        nome.setBounds(210, 100, 490, 20);
        jPanel10.add(email);
        email.setBounds(210, 140, 490, 20);
        jPanel10.add(telefone);
        telefone.setBounds(880, 100, 160, 20);
        jPanel10.add(inscMunicipal);
        inscMunicipal.setBounds(700, 140, 180, 20);
        jPanel10.add(inscEstadual);
        inscEstadual.setBounds(880, 140, 160, 20);

        jLabel23.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("UF");
        jPanel10.add(jLabel23);
        jLabel23.setBounds(830, 270, 50, 20);

        jLabel22.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("CEP");
        jPanel10.add(jLabel22);
        jLabel22.setBounds(880, 270, 140, 20);

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Número: ");
        jPanel10.add(jLabel16);
        jLabel16.setBounds(830, 190, 160, 20);

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Bairro");
        jPanel10.add(jLabel18);
        jLabel18.setBounds(300, 230, 100, 20);

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Logradouro");
        jPanel10.add(jLabel19);
        jLabel19.setBounds(300, 190, 100, 20);

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Complemento");
        jPanel10.add(jLabel20);
        jLabel20.setBounds(830, 230, 160, 20);

        jLabel21.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Codigo");
        jPanel10.add(jLabel21);
        jLabel21.setBounds(220, 190, 80, 20);

        jLabel28.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText(" CPF/CNPJ");
        jPanel10.add(jLabel28);
        jLabel28.setBounds(700, 80, 80, 20);

        jLabel29.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText(" Email");
        jPanel10.add(jLabel29);
        jLabel29.setBounds(210, 120, 220, 20);

        jLabel30.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText(" Insc. Munícipal");
        jPanel10.add(jLabel30);
        jLabel30.setBounds(700, 120, 140, 20);

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText(" Insc. Estadual");
        jPanel10.add(jLabel17);
        jLabel17.setBounds(880, 120, 140, 20);

        jLabel24.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Cidade");
        jPanel10.add(jLabel24);
        jLabel24.setBounds(300, 270, 100, 20);

        jLabel26.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Codigo");
        jPanel10.add(jLabel26);
        jLabel26.setBounds(220, 230, 80, 20);

        jLabel27.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Codigo");
        jPanel10.add(jLabel27);
        jLabel27.setBounds(220, 270, 80, 20);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CADASTRO DE PARÂMETROS");
        jPanel10.add(jLabel2);
        jLabel2.setBounds(50, 0, 970, 70);

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText(" Telefone");
        jPanel10.add(jLabel9);
        jLabel9.setBounds(880, 80, 90, 20);

        jLabel71.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("Insira a Logo");
        jPanel10.add(jLabel71);
        jLabel71.setBounds(40, 110, 150, 20);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço:"));
        jPanel10.add(jLabel14);
        jLabel14.setBounds(200, 170, 840, 160);

        salvar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar2.png"))); // NOI18N
        salvar.setText("Salvar/Atualizar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });
        jPanel10.add(salvar);
        salvar.setBounds(270, 370, 270, 40);

        sair.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SAIR2.png"))); // NOI18N
        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        jPanel10.add(sair);
        sair.setBounds(540, 370, 250, 40);

        brasao.setBackground(new java.awt.Color(255, 255, 255));
        brasao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brasaoActionPerformed(evt);
            }
        });
        jPanel10.add(brasao);
        brasao.setBounds(40, 140, 150, 140);

        jLabel72.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel72.setText(" Nome/Razão");
        jPanel10.add(jLabel72);
        jLabel72.setBounds(210, 80, 190, 20);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir2.png"))); // NOI18N
        jButton1.setText("Teste Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton1);
        jButton1.setBounds(790, 370, 230, 40);

        getContentPane().add(jPanel10);
        jPanel10.setBounds(0, 0, 1100, 700);
        jPanel10.getAccessibleContext().setAccessibleName("Cadastro de Pessoas");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codLogradouroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codLogradouroFocusLost
        try {
            carregaLogCadPessoa();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codLogradouroFocusLost

    private void descLogradouroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descLogradouroKeyReleased
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            List<Logradouro> merged = new LogradouroDAO().getPureList(session, 0, 12, Logradouro.class,
                "select e from Logradouro e where lower ( trim(e.descricao) ) like ?1 order by e.descricao",
                descLogradouro.getText().trim().toLowerCase() + "%");
            listaLogradouroNome.clear();
            listaLogradouroNome.addAll(merged);
        } catch (Exception e) {
        } finally {
            session.close();
        }
    }//GEN-LAST:event_descLogradouroKeyReleased

    private void codBairroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codBairroFocusLost
        try {
            carregaBairroCadPessoa();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codBairroFocusLost

    private void descBairroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descBairroKeyReleased
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            List<Bairro> merged = new BairroDAO().getPureList(session, 0, 12, Bairro.class,
                "select e from Bairro e where lower ( trim(e.descricao) ) like ?1 order by e.descricao",
                descBairro.getText().trim().toLowerCase() + "%");
            listaBairroNome.clear();
            listaBairroNome.addAll(merged);
        } catch (Exception e) {
        } finally {
            session.close();
        }
    }//GEN-LAST:event_descBairroKeyReleased

    private void codCidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codCidadeFocusLost
        try {
            carregaCidadeCadPessoa();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_codCidadeFocusLost

    private void descCidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descCidadeKeyReleased
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            List<Cidade> merged = new CidadeDAO().getPureList(session, 0, 12, Cidade.class,
                "select e from Cidade e where lower ( trim(e.descricao) ) like ?1 order by e.descricao",
                descCidade.getText().trim().toLowerCase() + "%");
            listaCidadeNome.clear();
            listaCidadeNome.addAll(merged);
        } catch (Exception e) {
        } finally {
            session.close();
        }
    }//GEN-LAST:event_descCidadeKeyReleased

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        try {
            salvar();
            habilitaCampos(true);
            JOptionPane.showMessageDialog(this, " Salvo com Sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_salvarActionPerformed
  
    private void salvar() throws Exception {
        try {
            
            entidade = entidadeDao.get(1);
            if (entidade == null) {
               entidade = new Entidade();
               entidade.setCodEntidade(1);
            } 
            
            
            if (logradouro == null) {
                throw new Exception(" Por favor, inserir um Logradouro ");
            }
            if (bairro == null) {
                throw new Exception(" Por favor, inserir um Bairro ");
            }
            if (cidade == null) {
                throw new Exception(" Por favor, inserir uma Cidade ");
            }
           
            setEntidade();
            entidade = entidadeDao.addEntidade(entidade);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(" Erro ao Salvar ");
        }
    }
    
    private void setEntidade() throws Exception {   
        entidade.setNome(nome.getText());
        entidade.setCnpj(cnpj.getText());
        entidade.setTelefone(telefone.getText());
        entidade.setEmail(email.getText());
        entidade.setInscEstadual(inscEstadual.getText());
        entidade.setInscMunicipal(inscMunicipal.getText());
        entidade.setLogradouro(logradouro);
        entidade.setBairro(bairro);
        entidade.setCidade(cidade);
        entidade.setNumero(ValidarValor.getInt(numero.getText()));
        entidade.setComplemento(complemento.getText());
        entidade.setCep(cep.getText());
        entidade.setUf(uf.getText());
        entidade.setBrasao(getByteImage());
    }
    
    private byte[] getByteImage(){
        try{                    
            if(FvaFiguraBrasao.trim().length()>0){
                ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
                byte buffer[] = new byte[4096];
                int bytesRead = 0;            
                FileInputStream fi = new FileInputStream(FvaFiguraBrasao);
                while ((bytesRead = fi.read(buffer))!=-1){
                   arrayOutputStream.write(buffer,0,bytesRead);
                }
                arrayOutputStream.close();
                return arrayOutputStream.toByteArray();
            }
        }catch(Exception e){
            System.out.println("Ocorreu um erro ao tentar buscar bytes da imagemn. Erro: "+e);
        }
        return null;
    }
    
    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        dispose();
    }//GEN-LAST:event_sairActionPerformed

    private void brasaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brasaoActionPerformed
        try {
            buscaFigura();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_brasaoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        imprimirTeste();
    }//GEN-LAST:event_jButton1ActionPerformed

  private void buscaFigura(){
        FvaFiguraBrasao = (FvaFiguraBrasao.equals(""))?"\\":FvaFiguraBrasao;
        JFileChooser chose  = new JFileChooser(FvaFiguraBrasao);
        chose.setFileFilter(
                new javax.swing.filechooser.FileFilter() {
            public boolean accept(File f) {
                String fname = f.getName().toLowerCase();
                return fname.endsWith(".gif")
                || fname.endsWith(".jpeg")
                || fname.endsWith(".jpg")
                || fname.endsWith(".png")
                || f.isDirectory();
            }
            public String getDescription() {
                return "Arquivos .GIF, .JPEG, .JPG e .PNG"; }
        }
        );
        if(chose.showOpenDialog(this) == 0){
            setImageIcon(chose.getSelectedFile().getPath());
        }   
    }
  
   private void setImageIcon(String path) {
        FvaFiguraBrasao="";
        brasao.setIcon(null);
        brasao.setToolTipText("");
        if(path.length()>0){
            FvaFiguraBrasao=path;
            ImageIcon img=new ImageIcon(FvaFiguraBrasao);
            brasao.setIcon(img);
            brasao.setToolTipText(FvaFiguraBrasao);
        }
            
    }
    
    private void carregaLogCadPessoa() throws Exception {
        logradouro = logradouroDao.getPorCodigo(ValidarValor.getLong(codLogradouro.getText()));
        if (logradouro != null) {
            codLogradouro.setText(logradouro.getCodLogradouro().toString());
            descLogradouro.setText(logradouro.getDescricao());
        } else {
            codLogradouro.setText("");
            descLogradouro.setText("");
        }
    }

    private void carregaBairroCadPessoa() throws Exception {
        bairro = bairroDao.getPorCodigo(ValidarValor.getInt(codBairro.getText()));
        if (bairro != null) {
            codBairro.setText(bairro.getCodBairro().toString());
            descBairro.setText(bairro.getDescricao());
        } else {
            codBairro.setText("");
            descBairro.setText("");
        }
    }

    private void carregaCidadeCadPessoa() throws Exception {
        cidade = cidadeDao.getPorCodigo(ValidarValor.getInt(codCidade.getText()));
        if (cidade != null) {
            codCidade.setText(cidade.getCodCidade().toString());
            descCidade.setText(cidade.getDescricao());
        } else {
            codCidade.setText("");
            descCidade.setText("");
        }
    }
    
    private void habilitaCampos(boolean b) {
        cnpj.setEnabled(b);
        nome.setEnabled(b);
        email.setEnabled(b);
        telefone.setEnabled(b);
        inscMunicipal.setEnabled(b);
        inscEstadual.setEnabled(b);
        codLogradouro.setEnabled(b);
        descLogradouro.setEnabled(b);
        numero.setEnabled(b);
        codBairro.setEnabled(b);
        descBairro.setEnabled(b);
        complemento.setEnabled(b);
        codCidade.setEnabled(b);
        descCidade.setEnabled(b);
        uf.setEnabled(b);
        cep.setEnabled(b);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brasao;
    private javax.swing.JTextField cep;
    private javax.swing.JTextField cnpj;
    private javax.swing.JTextField codBairro;
    private javax.swing.JTextField codCidade;
    private javax.swing.JTextField codLogradouro;
    private javax.swing.JTextField complemento;
    private javax.swing.JTextField descBairro;
    private javax.swing.JTextField descCidade;
    private javax.swing.JTextField descLogradouro;
    private javax.swing.JTextField email;
    private javax.swing.JTextField inscEstadual;
    private javax.swing.JTextField inscMunicipal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField numero;
    private javax.swing.JButton sair;
    private javax.swing.JButton salvar;
    private javax.swing.JTextField telefone;
    private javax.swing.JTextField uf;
    // End of variables declaration//GEN-END:variables

    private void verificaEntidade() throws Exception {
        entidade = entidadeDao.get(1);
        if(entidade ==null){
            JOptionPane.showMessageDialog(this, " Por favor, inserir dados");
        }else{
            carregaEntidade();
        }
    }

    private void carregaEntidade() throws Exception {
        if (entidade != null) {

            cnpj.setText(entidade.getCnpj());
            nome.setText(entidade.getNome());
            email.setText(entidade.getEmail());
            telefone.setText(entidade.getTelefone());
            inscMunicipal.setText(entidade.getInscMunicipal());
            inscEstadual.setText(entidade.getInscEstadual());
            if(entidade.getLogradouro()!=null){
            codLogradouro.setText(entidade.getLogradouro().getCodLogradouro()+"");
            carregaLogCadPessoa();
            }
            numero.setText(entidade.getNumero()+"");
            if(entidade.getBairro()!=null){
            codBairro.setText(entidade.getBairro().getCodBairro()+"");
            carregaBairroCadPessoa();
            }
            complemento.setText(entidade.getComplemento());
            if(entidade.getCidade()!=null){
            codCidade.setText(entidade.getCidade().getCodCidade()+"");
            carregaCidadeCadPessoa();
            }
            uf.setText(entidade.getUf());
            cep.setText(entidade.getCep());
            if(entidade.getBrasao()!=null){
                    criarImage(entidade.getBrasao());
                }
        }
    }
    private void criarImage(byte[] bytes){
        try{
            byte[] imgBytes=bytes;   
            FileOutputStream fos = new FileOutputStream("brasao.jpg");  
            fos.write(imgBytes);  
            FileDescriptor fd = fos.getFD();  
            fos.flush();  
            fd.sync();  
            fos.close(); 
            setImageIcon("brasao.jpg");
        }catch(Exception e){
            System.out.println("Ocorreu um erro ao tentar criar imagem. Erro: "+e);
        }
    }

    private void imprimirTeste() {
         String r = "select u.codusuario, u.login from usuario u " ;

        new VisualizaRelatorio().visRel("graficaatual/relatorios/relatorio/RTeste.jasper", "Relatório Usuários", null, r);
    }
    
  
}
