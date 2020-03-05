/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos;

import graficaatual.entidades.Usuarios;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author testes
 */
public class UsuariosDao extends GenericDao{
    
    public boolean addUsuario(Usuarios usuario) {
        return savePojo(usuario);
    }

    public boolean deleteUsuario(Usuarios usuario) {
        return deletePojo(usuario);
    }

    public Usuarios getUsuario(int codUsuario) {
        return getPojo(Usuarios.class, codUsuario);
    }

    public Usuarios getUsuario(String login) {
        Usuarios us = null;
        us = getPurePojoUnique(Usuarios.class,
                "select usuario from Usuario usuario where usuario.login=?1 order by usuario.nome",
                login.trim());

        if (us != null && us.getCodUsuario()> 0) {
            return us;
        }

        return null;
    }

    public Usuarios getUsCodigo(Integer codigo) {
        Usuarios us = null;
        us = getPurePojoUnique(Usuarios.class, "select usuario from Usuario usuario where usuario.codigo=?1"
                + " and usuario.codigo not in (select ex.usuario.codigo from ResponsavelUsuario ex where ex.usuario.codigo = usuario.codigo)"
                + " order by usuario.codigo", codigo);

        if (us != null && us.getCodUsuario()> 0) {
            return us;
        }

        return null;
    }

    public int getCount() {
        return getPureList(Usuarios.class, "select usuarios from Usuario usuario order by usuario.nome").size();
    }

    public List<Usuarios> getLista() {
        return getPureList(Usuarios.class, "select e from Usuarios e order by e.nome");
    }

    public List<Usuarios> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, Usuarios.class, SQL, parametros);
    }

    public List<Usuarios> getListaAdministradores() {
        return getPureList(Usuarios.class, "select e from Usuario e where e.tipoPermissao.codigo >= 5 order by e.nome");
    }
    
}
