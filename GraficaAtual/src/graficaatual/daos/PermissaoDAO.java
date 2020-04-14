package graficaatual.daos;

import graficaatual.entidades.Usuario;
import graficaatual.entidades.Permissao;
import java.util.List;

/**
 *
 * @author Projeto x
 */
public class PermissaoDAO extends GenericDAO {
    private static final long serialVersionUID = 1L;
    public PermissaoDAO(){

    }
    public boolean addPermissao(Permissao entity){
        return savePojo(entity);
    }
    public boolean delete(Permissao entity){
        return deletePojo(entity);
    }
    public boolean delete(Usuario usr){
        return executeQuery("delete from Permissao where usuario.codigo = ?1", usr.getCodUsuario());
    }
    public Permissao getPermissao(int codPermissao){
        return getPojo(Permissao.class, codPermissao);
    }
    public Permissao getPermissaoFormulario(int codUsuario,int Codformulario){

        return getPurePojoUnique(Permissao.class, "select e from Permissao e where e.usuario.codUsuario=?1 and e.formulario.CodFormulario=?2",codUsuario,Codformulario);
    }
    public List<Permissao> getPermissaoUsuario(int codUsuario){
        List<Permissao> lista = getList("select e from Permissao e where e.usuario.codigo=?1", codUsuario);
        if(lista != null && lista.size() > 0){
            return lista;
        }
            return null;
        
    }
    public List<Permissao> getList(String SQL, Object... parametros){
        return getPureList(Permissao.class, SQL,parametros);
    }

    public Permissao getPermissaoFormulario(Integer codUsuario, String formulario) {
         return getPurePojoUnique(Permissao.class, "select e from Permissao e where e.usuario.codUsuario=?1 and e.formulario.formulario=?2",codUsuario,formulario);
    }
}
