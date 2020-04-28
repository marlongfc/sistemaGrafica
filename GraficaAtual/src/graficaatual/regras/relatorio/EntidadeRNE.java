/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.relatorio;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.relatorio.Entidade;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author 
 */
public class EntidadeRNE extends GenericDAO{
    
    public Entidade salvar(EntityManager session, Entidade entidade) throws Exception {
        return super.saveOrUpdatePojo(session, entidade);
    }

    public boolean excluir(EntityManager session, Entidade entidade) throws Exception {
        return super.deletePojo(session, entidade);
    }

    public List<Entidade> getList(EntityManager session, Entidade entidade) throws Exception {
        return super.getPureList(session, Entidade.class, "Select e from Entidade e");
    }
    
     public Entidade get(long codigo, EntityManager session) throws Exception {
        String sql = " select e from Entidade e where e.codEntidade=?1 ";
        return getPojoUnique(session, Entidade.class, sql, codigo);
    }
    
    
}
