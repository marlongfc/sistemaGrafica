/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.entidades;

import graficaatual.daos.PermissaoDAO;
import graficaatual.entidades.Usuario;

/**
 *
 * @author Projeto X
 */
public class ControleAcesso {

    private static PermissaoDAO pedao = new PermissaoDAO();
    public static Usuario usuario = new Usuario();
    public static String MensagemSeguranca = "Acesso negado ao formulário."
            + "\nCaso necessite de acesso ao formulário, solicite permissão ao administrador do sistema.";


    public static Permissao getPermissaoFormulario(Usuario usuario, int formulario) {
        return pedao.getPermissaoFormulario(usuario.getCodUsuario(), formulario);
    }

    public static Permissao getPermissaoFormulario(String formulario,String modulo) {
        return pedao.getPermissaoFormulario(usuario.getCodUsuario(), formulario,modulo);
    }


}
