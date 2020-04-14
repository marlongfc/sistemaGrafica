package graficaatual.daos;

import graficaatual.entidades.Formulario;
import java.util.List;

/**
 *
 * @author Projeto x
 */
public class FormularioDAO extends GenericDAO {

    private static final long serialVersionUID = 1L;

    public FormularioDAO() {

    }

    public Formulario addFormulario(Formulario entity) {
        return saveOrUpdatePojo(entity);
    }

    public boolean addFormulario(String formulario, String titulo) {
        Formulario FvaForm = getPurePojoUnique(Formulario.class, "select e from Formulario e where e.formulario=?1", formulario);
        if (FvaForm == null) {
            FvaForm = new Formulario();
            FvaForm.setFormulario(formulario.trim());
        }
        FvaForm.setTitulo(titulo.trim());
        FvaForm = saveOrUpdatePojo(FvaForm);

        if (FvaForm == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean delete(Formulario entity) {
        return deletePojo(entity);
    }

    public Formulario getFormulario(int codFormulario) {
        return getPojo(Formulario.class, codFormulario);
    }

    public Formulario getFormulario(String formulario, String titulo) {
        Formulario FvaRetorno = getPurePojoUnique(Formulario.class, "select e from Formulario e where e.formulario=?1", formulario);
        if (FvaRetorno == null) {
            FvaRetorno = new Formulario();
            FvaRetorno.setFormulario(formulario.trim());
            FvaRetorno.setTitulo(titulo.trim());
            FvaRetorno = saveOrUpdatePojo(FvaRetorno);
        }
        return FvaRetorno;
    }
    
    public List<Formulario> getFormulario(String modulo) {
        List<Formulario> FvaRetorno = getPureList(Formulario.class, " select e from Formulario e where e.Modulo=?1 order by e.CodFormulario ", modulo);
        return FvaRetorno;
    }

}
