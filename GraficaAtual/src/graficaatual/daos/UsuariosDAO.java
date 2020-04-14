/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos;

import graficaatual.entidades.Usuario;
import graficaatual.utilitarios.Persistencia;
import java.util.List;

/**
 *
 * @author Projeto X
 */
public class UsuariosDAO extends GenericDAO{
    
    public boolean addUsuario(Usuario usuario) {
        return saveOrUpdatePojo(usuario);
    }

    public boolean deleteUsuario(Usuario usuario) {
        return deletePojo(usuario);
    }

    public Usuario getUsuario(int codUsuario) {
        return getPojo(Usuario.class, codUsuario);
    }

    public Usuario getUsuario(String login) {
        Usuario us = null;
        us = getPurePojoUnique(Usuario.class,
                "select u from Usuario u where u.login=?1 ",
                login.trim());

        if (us != null && us.getCodUsuario()> 0) {
            return us;
        }

        return null;
    }

    public Usuario getUsCodigo(Integer codigo) {
        Usuario us = null;
        us = getPurePojoUnique(Usuario.class, "select usuario from Usuarios usuario where usuario.codigo=?1"
                + " and usuario.codigo not in (select ex.usuario.codigo from ResponsavelUsuario ex where ex.usuario.codigo = usuario.codigo)"
                + " order by usuario.codigo", codigo);

        if (us != null && us.getCodUsuario()> 0) {
            return us;
        }

        return null;
    }

    public int getCount() {
        return getPureList(Usuario.class, "select usuarios from Usuarios usuario order by usuario.nome").size();
    }

    public List<Usuario> getLista() {
        return getPureList(Usuario.class, "select e from Usuarios e order by e.nome");
    }

    public List<Usuario> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, Usuario.class, SQL, parametros);
    }

    public List<Usuario> getListaAdministradores() {
        return getPureList(Usuario.class, "select e from Usuarios e where e.tipoPermissao.codigo >= 5 order by e.nome");
    }
    //

    public boolean verificarLogin(String login) {
        Integer x= (getPureList(Usuario.class, "select u from Usuario u where u.login=?1", login).size());
        
        if(x == null || x<=0){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean verificarColaborador(int codColaborador) {
        Integer x= (getPureList(Usuario.class, "select u from Usuario u where u.ativo='true' and u.colaborador.codColaborador=?1", codColaborador).size());
        
        if(x == null || x<=0){
            return false;
        }else{
            return true;
        }
    }
}
