/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.Bairro;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class BairroRNE extends GenericDAO {

    public Bairro salvar(EntityManager session, Bairro bairro) throws Exception {
        return super.saveOrUpdatePojo(session, bairro);
    }

    public boolean excluir(EntityManager session, Bairro bairro) throws Exception {
        return super.deletePojo(session, bairro);
    }

    public List<Bairro> getList(EntityManager session, Bairro bairro) throws Exception {
        return super.getPureList(session, Bairro.class, "Select e from Bairro e");
    }
    
     public Bairro get(long codigo, EntityManager session) throws Exception {
        String sql = " select e from Bairro e where e.codBairro=?1 ";
        return getPojoUnique(session, Bairro.class, sql, codigo);
    }
}
