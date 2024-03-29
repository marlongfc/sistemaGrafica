/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual;

import graficaatual.entidades.ControleAcesso;
import graficaatual.entidades.Permissao;
import graficaatual.formularios.cadastro.FCadAcabamento;
import graficaatual.formularios.cadastro.FCadBairro;
import graficaatual.formularios.cadastro.FCadCargo;
import graficaatual.formularios.cadastro.FCadCidade;
import graficaatual.formularios.cadastro.FCadCliente;
import graficaatual.formularios.cadastro.FCadColaborador;
import graficaatual.formularios.cadastro.FCadFornecedor;
import graficaatual.formularios.cadastro.FCadLogradouro;
import graficaatual.formularios.cadastro.FCadMaterial;
import graficaatual.formularios.cadastro.FCadPatrimonio;
import graficaatual.formularios.cadastro.FCadProduto;
import graficaatual.formularios.cadastro.FCadTurno;
import graficaatual.formularios.cadastro.FCadUsuario;
import graficaatual.formularios.financeiro.FCadFormaDePagamento;
import javax.swing.JButton;

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
        this.setLocationRelativeTo(null);
        
        
        //verificação de acesso as telas
        acessotela(jBCliente,"FCadCliente");
        acessotela(jBFornecedor,"FCadFornecedor");
        acessotela(jBLogradouro,"FCadLogradouro");
        acessotela(jBBairro,"FCadBairro");
        acessotela(jBCidade,"FCadCidade");
        acessotela(jBUsuario,"FCadUsuario");
        acessotela(jBColaborador,"FCadColaborador");
        acessotela(jBCargo,"FCadCargo");
        acessotela(jBTurno,"FCadTurno");
        acessotela(jBMaterial,"FCadMaterial");
        acessotela(jBProduto,"FCadProduto");
        acessotela(jBAcabamento,"FCadAcabamento");       
        acessotela(jBPatrimonio, "FCadPatrimonio");
        
       
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
        jBCliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jBCargo = new javax.swing.JButton();
        jBFornecedor = new javax.swing.JButton();
        jBLogradouro = new javax.swing.JButton();
        jBBairro = new javax.swing.JButton();
        jBCidade = new javax.swing.JButton();
        jBUsuario = new javax.swing.JButton();
        jBColaborador = new javax.swing.JButton();
        jBTurno = new javax.swing.JButton();
        jBMaterial = new javax.swing.JButton();
        jBProduto = new javax.swing.JButton();
        jBAcabamento = new javax.swing.JButton();
        jBSair = new javax.swing.JButton();
        deskTop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jBPatrimonio = new javax.swing.JButton();

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

        jBCliente.setBackground(new java.awt.Color(71, 37, 131));
        jBCliente.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBCliente.setForeground(new java.awt.Color(255, 255, 255));
        jBCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Clientes2.png"))); // NOI18N
        jBCliente.setText("Cliente");
        jBCliente.setBorderPainted(false);
        jBCliente.setFocusPainted(false);
        jBCliente.setFocusable(false);
        jBCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBClienteActionPerformed(evt);
            }
        });
        jPanel1.add(jBCliente);
        jBCliente.setBounds(30, 140, 180, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LOGO Amarela sem Fundo2.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 20, 120, 110);

        jBCargo.setBackground(new java.awt.Color(71, 37, 131));
        jBCargo.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBCargo.setForeground(new java.awt.Color(255, 255, 255));
        jBCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cargo2.png"))); // NOI18N
        jBCargo.setText("Cargo");
        jBCargo.setBorderPainted(false);
        jBCargo.setFocusPainted(false);
        jBCargo.setFocusable(false);
        jBCargo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCargoActionPerformed(evt);
            }
        });
        jPanel1.add(jBCargo);
        jBCargo.setBounds(30, 420, 180, 30);

        jBFornecedor.setBackground(new java.awt.Color(71, 37, 131));
        jBFornecedor.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBFornecedor.setForeground(new java.awt.Color(255, 255, 255));
        jBFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fornecedor2.png"))); // NOI18N
        jBFornecedor.setText("Fornecedor");
        jBFornecedor.setBorderPainted(false);
        jBFornecedor.setFocusPainted(false);
        jBFornecedor.setFocusable(false);
        jBFornecedor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFornecedorActionPerformed(evt);
            }
        });
        jPanel1.add(jBFornecedor);
        jBFornecedor.setBounds(30, 180, 180, 30);

        jBLogradouro.setBackground(new java.awt.Color(71, 37, 131));
        jBLogradouro.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBLogradouro.setForeground(new java.awt.Color(255, 255, 255));
        jBLogradouro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Endereco2.png"))); // NOI18N
        jBLogradouro.setText("Logradouro");
        jBLogradouro.setBorderPainted(false);
        jBLogradouro.setFocusPainted(false);
        jBLogradouro.setFocusable(false);
        jBLogradouro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLogradouroActionPerformed(evt);
            }
        });
        jPanel1.add(jBLogradouro);
        jBLogradouro.setBounds(30, 220, 180, 30);

        jBBairro.setBackground(new java.awt.Color(71, 37, 131));
        jBBairro.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBBairro.setForeground(new java.awt.Color(255, 255, 255));
        jBBairro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Endereco2.png"))); // NOI18N
        jBBairro.setText("Bairro");
        jBBairro.setBorderPainted(false);
        jBBairro.setFocusPainted(false);
        jBBairro.setFocusable(false);
        jBBairro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBairroActionPerformed(evt);
            }
        });
        jPanel1.add(jBBairro);
        jBBairro.setBounds(30, 260, 180, 30);

        jBCidade.setBackground(new java.awt.Color(71, 37, 131));
        jBCidade.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBCidade.setForeground(new java.awt.Color(255, 255, 255));
        jBCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Endereco2.png"))); // NOI18N
        jBCidade.setText("Cidade");
        jBCidade.setBorderPainted(false);
        jBCidade.setFocusPainted(false);
        jBCidade.setFocusable(false);
        jBCidade.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCidadeActionPerformed(evt);
            }
        });
        jPanel1.add(jBCidade);
        jBCidade.setBounds(30, 300, 180, 30);

        jBUsuario.setBackground(new java.awt.Color(71, 37, 131));
        jBUsuario.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jBUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/usuario2.png"))); // NOI18N
        jBUsuario.setText("Usuários");
        jBUsuario.setBorderPainted(false);
        jBUsuario.setFocusPainted(false);
        jBUsuario.setFocusable(false);
        jBUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(jBUsuario);
        jBUsuario.setBounds(30, 340, 180, 30);

        jBColaborador.setBackground(new java.awt.Color(71, 37, 131));
        jBColaborador.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBColaborador.setForeground(new java.awt.Color(255, 255, 255));
        jBColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/colaborador2.png"))); // NOI18N
        jBColaborador.setText("Colaborador");
        jBColaborador.setBorderPainted(false);
        jBColaborador.setFocusPainted(false);
        jBColaborador.setFocusable(false);
        jBColaborador.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBColaboradorActionPerformed(evt);
            }
        });
        jPanel1.add(jBColaborador);
        jBColaborador.setBounds(30, 380, 180, 30);

        jBTurno.setBackground(new java.awt.Color(71, 37, 131));
        jBTurno.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBTurno.setForeground(new java.awt.Color(255, 255, 255));
        jBTurno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/turno2.png"))); // NOI18N
        jBTurno.setText("Turno");
        jBTurno.setBorderPainted(false);
        jBTurno.setFocusPainted(false);
        jBTurno.setFocusable(false);
        jBTurno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTurnoActionPerformed(evt);
            }
        });
        jPanel1.add(jBTurno);
        jBTurno.setBounds(30, 460, 180, 30);

        jBMaterial.setBackground(new java.awt.Color(71, 37, 131));
        jBMaterial.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBMaterial.setForeground(new java.awt.Color(255, 255, 255));
        jBMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/material2.png"))); // NOI18N
        jBMaterial.setText("Material");
        jBMaterial.setBorderPainted(false);
        jBMaterial.setFocusPainted(false);
        jBMaterial.setFocusable(false);
        jBMaterial.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMaterialActionPerformed(evt);
            }
        });
        jPanel1.add(jBMaterial);
        jBMaterial.setBounds(30, 500, 180, 30);

        jBProduto.setBackground(new java.awt.Color(71, 37, 131));
        jBProduto.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBProduto.setForeground(new java.awt.Color(255, 255, 255));
        jBProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produto2.png"))); // NOI18N
        jBProduto.setText("Produtos");
        jBProduto.setBorderPainted(false);
        jBProduto.setFocusPainted(false);
        jBProduto.setFocusable(false);
        jBProduto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProdutoActionPerformed(evt);
            }
        });
        jPanel1.add(jBProduto);
        jBProduto.setBounds(30, 540, 180, 30);

        jBAcabamento.setBackground(new java.awt.Color(71, 37, 131));
        jBAcabamento.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBAcabamento.setForeground(new java.awt.Color(255, 255, 255));
        jBAcabamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/acabamento2.png"))); // NOI18N
        jBAcabamento.setText("Acabamentos");
        jBAcabamento.setBorderPainted(false);
        jBAcabamento.setFocusPainted(false);
        jBAcabamento.setFocusable(false);
        jBAcabamento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBAcabamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAcabamentoActionPerformed(evt);
            }
        });
        jPanel1.add(jBAcabamento);
        jBAcabamento.setBounds(30, 580, 180, 30);

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
        jBSair.setBounds(30, 660, 180, 30);

        deskTop.setMinimumSize(new java.awt.Dimension(1100, 700));
        deskTop.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                deskTopComponentResized(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CADASTRO COM FUNDO.jpg"))); // NOI18N
        deskTop.add(jLabel1);
        jLabel1.setBounds(280, 90, 550, 510);

        jPanel1.add(deskTop);
        deskTop.setBounds(210, 10, 1070, 700);

        jBPatrimonio.setBackground(new java.awt.Color(71, 37, 131));
        jBPatrimonio.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        jBPatrimonio.setForeground(new java.awt.Color(255, 255, 255));
        jBPatrimonio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/formasPagamento2.png"))); // NOI18N
        jBPatrimonio.setText("Patrimônio");
        jBPatrimonio.setBorderPainted(false);
        jBPatrimonio.setFocusPainted(false);
        jBPatrimonio.setFocusable(false);
        jBPatrimonio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBPatrimonio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPatrimonioActionPerformed(evt);
            }
        });
        jPanel1.add(jBPatrimonio);
        jBPatrimonio.setBounds(30, 620, 180, 30);

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

    private void jBCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCargoActionPerformed
        try {
            deskTop.removeAll();
            FCadCargo clComp;

            clComp = FCadCargo.getInstance();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBCargoActionPerformed

    private void jBBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBairroActionPerformed
        try {
            deskTop.removeAll();
            FCadBairro clComp;

            clComp = FCadBairro.getInstancia();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBBairroActionPerformed

    private void jBCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCidadeActionPerformed
       try {
            deskTop.removeAll();
            FCadCidade clComp;

            clComp = FCadCidade.getInstancia();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBCidadeActionPerformed

    private void jBUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUsuarioActionPerformed
        try {
            deskTop.removeAll();
            FCadUsuario clComp;

            clComp = FCadUsuario.getInstance().getInstance();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBUsuarioActionPerformed

    private void jBColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBColaboradorActionPerformed
         try {
            deskTop.removeAll();
            FCadColaborador clComp;

            clComp = FCadColaborador.getInstance().getInstance();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBColaboradorActionPerformed

    private void jBTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTurnoActionPerformed
     try {
            deskTop.removeAll();
            FCadTurno clComp;

            clComp = FCadTurno.getInstancia();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBTurnoActionPerformed

    private void jBMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMaterialActionPerformed
      try {
            deskTop.removeAll();
            FCadMaterial clComp;

            clComp = FCadMaterial.getInstancia();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBMaterialActionPerformed

    private void jBProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProdutoActionPerformed
       try {
            deskTop.removeAll();
            FCadProduto clComp;

            clComp = FCadProduto.getInstancia();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBProdutoActionPerformed

    private void jBAcabamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAcabamentoActionPerformed
        try {
            deskTop.removeAll();
            FCadAcabamento clComp;

            clComp = FCadAcabamento.getInstancia();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBAcabamentoActionPerformed

    private void jBLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLogradouroActionPerformed
        try {
            deskTop.removeAll();
            FCadLogradouro clComp;

            clComp = FCadLogradouro.getInstancia();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBLogradouroActionPerformed

    private void jBFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFornecedorActionPerformed
        try {
            deskTop.removeAll();
            FCadFornecedor clComp;

            clComp = FCadFornecedor.getInstance();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBFornecedorActionPerformed

    private void jBClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBClienteActionPerformed
        try {
            deskTop.removeAll();
            FCadCliente clComp;

            clComp = FCadCliente.getInstance();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBClienteActionPerformed

    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
       dispose();
    }//GEN-LAST:event_jBSairActionPerformed

    private void jBPatrimonioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPatrimonioActionPerformed
      try {
            deskTop.removeAll();
            FCadPatrimonio clComp;

            clComp = FCadPatrimonio.getInstancia();
            deskTop.add(clComp);
            clComp.setVisible(true);
            deskTop.add(jLabel1);
            jLabel1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar selecionar o formulário. Verifique o formulário e tente novamente. \nErro: " + e);
        }
    }//GEN-LAST:event_jBPatrimonioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane deskTop;
    private javax.swing.JButton jBAcabamento;
    private javax.swing.JButton jBBairro;
    private javax.swing.JButton jBCargo;
    private javax.swing.JButton jBCidade;
    private javax.swing.JButton jBCliente;
    private javax.swing.JButton jBColaborador;
    private javax.swing.JButton jBFornecedor;
    private javax.swing.JButton jBLogradouro;
    private javax.swing.JButton jBMaterial;
    private javax.swing.JButton jBPatrimonio;
    private javax.swing.JButton jBProduto;
    private javax.swing.JButton jBSair;
    private javax.swing.JButton jBTurno;
    private javax.swing.JButton jBUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void acessotela(JButton jB, String fCadCliente) {
        Permissao p = ControleAcesso.getPermissaoFormulario(fCadCliente,"CADASTRO");
        if(p!= null){
            jB.setEnabled(p.isAcesso());
        }else{
            jB.setEnabled(false);
        }
    }

}
