/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.UF;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class UFRNE extends GenericDAO {

    public UF salvar(EntityManager session, UF uf) throws Exception {
        return super.saveOrUpdatePojo(session, uf);
    }

    public boolean excluir(EntityManager session, UF uf) throws Exception {
        return super.deletePojo(session, uf);
    }

    public List<UF> getList(EntityManager session, UF uf) throws Exception {
        return super.getPureList(session, UF.class, "Select e from UF e");
    }
    
     public UF get(long codigo, EntityManager session) throws Exception {
        String sql = " select e from UF e where e.codUF=?1 ";
        return getPojoUnique(session, UF.class, sql, codigo);
    }
     
         public long getNextItem(EntityManager session) throws Exception {
        String q = " select max(e.codUF) from UF e ";

        Long ret = getLong(session, q);

        return ret == null ? 1 : ret + 1;
    }
    
              public List<UF> getList(EntityManager session) throws Exception {
        String sql = " select e from UF e order by e.codUF";
        return getPureList(session, UF.class, sql);
    }

    public List<UF> getList(EntityManager session, String sql) throws Exception {
        return getPureList(session, UF.class, sql);
    }
}
