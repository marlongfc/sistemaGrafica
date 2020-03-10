/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.utilitarios;

import graficaatual.daos.FormularioDAO;
import graficaatual.daos.PermissaoDAO;
import graficaatual.entidades.Usuario;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Projeto X
 */
public class ControleAcesso {

    private static PermissaoDAO pedao = new PermissaoDAO();
    public static Usuario usuario = new Usuario();
    public static FormularioDAO fordao = new FormularioDAO();
    public static String MensagemSeguranca = "Acesso negado ao formulário."
            + "\nCaso necessite de acesso ao formulário, solicite permissão ao administrador do sistema.";

    public static int anoExercicio = -1;

    public ControleAcesso(JInternalFrame jif) {
        this(jif.getContentPane().getComponents(), jif.getName(), jif.getTitle());
    }

    public ControleAcesso(Component[] lista, String FvaFormulario, String FvaTitulo) {

        Boolean[] lp = {false, false, false};

        try {

            ControleAcesso.addFormulario(FvaFormulario.trim(), FvaTitulo.trim());

            if (usuario.getTipoPermissao().getCodigo() == 30
                    || usuario.getTipoPermissao().getCodigo() == 10
                    || usuario.getTipoPermissao().getCodigo() == 5) {
                lp[0] = true;
                lp[1] = true;
                lp[2] = true;

            } else {

                Permissao per = ControleAcesso.getPermissaoFormulario(FvaFormulario);

                if (per != null) {
                    lp[0] = per.isSalvar();
                    lp[1] = per.isExcluir();
                    lp[2] = per.isImprimir();
                }

                ProcessarPermissao(lista, lp);

            }

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar permissões. Erro: " + e);
            e.printStackTrace();
        }
    }

    private void ProcessarPermissao(Component[] lista, Boolean[] lp) {
        try {

            for (Component comp : lista) {

                if (comp instanceof JButton) {

                    JButton bt = ((JButton) comp);

                    if (bt.getName() != null) {
                        if (bt.getName().equalsIgnoreCase("S")) {
                            bt.setVisible(lp[0]);
                        } else if (bt.getName().equalsIgnoreCase("E")) {
                            bt.setVisible(lp[1]);
                        } else if (bt.getName().equalsIgnoreCase("I")) {
                            bt.setVisible(lp[2]);
                        }
                    }

                } else if (comp instanceof JComboBox) {

                    JComboBox jb = ((JComboBox) comp);

                    if (jb.getName() != null) {
                        if (jb.getName().equalsIgnoreCase("S")) {
                            jb.setVisible(lp[0]);
                        } else if (jb.getName().equalsIgnoreCase("E")) {
                            jb.setVisible(lp[1]);
                        } else if (jb.getName().equalsIgnoreCase("I")) {
                            jb.setVisible(lp[2]);
                        }
                    }

                } else if (comp instanceof JPanel) {

                    Component[] lc = ((JPanel) comp).getComponents();

                    if (lc != null) {
                        ProcessarPermissao(lc, lp);
                    }

                } else if (comp instanceof JTabbedPane) {
                    Component[] lc = ((JTabbedPane) comp).getComponents();
                    if (lc != null) {
                        ProcessarPermissao(lc, lp);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar permissões. Erro: " + e);
            e.printStackTrace();
        }
    }

    public static int getPermissaoUsuario() {
        int FvaRetorno = 0;
        try {
            if (usuario != null) {
                FvaRetorno = usuario.getTipoPermissao().getCodigo();
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar permissão do usuário. Erro: " + e);
        }
        return FvaRetorno;
    }

    public static Permissao getPermissaoFormulario(Usuario usuario, String formulario) {
        return pedao.getPermissaoFormulario(usuario.getCodUsuario(), formulario);
    }

    public static Permissao getPermissaoFormulario(String formulario) {
        return pedao.getPermissaoFormulario(usuario.getCodUsuario(), formulario);
    }

    public static void addFormulario(String formulario, String titulo) {
        fordao.addFormulario(formulario, titulo);
    }

    public static boolean getAcessoFormulario(int nivel, String formulario) {

        boolean FvaRetorno = false;

        try {
            if (usuario.getTipoPermissao().getCodigo() == 30) {
                FvaRetorno = true;
            } else if (usuario.getTipoPermissao().getCodigo() == 10) {
                if (nivel <= 10) {
                    FvaRetorno = true;
                }
            } else if (usuario.getTipoPermissao().getCodigo() == 5) {

                if (nivel <= 5) {
                    FvaRetorno = true;
                }
            } else {
                Permissao per = pedao.getPermissaoFormulario(usuario.getCodUsuario(), formulario);
                if (per != null) {
                    FvaRetorno = per.isAcesso();
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar buscar permissão de acesso ao formulario. Erro: " + e);
            e.printStackTrace();
        }
        return FvaRetorno;
    }

}
