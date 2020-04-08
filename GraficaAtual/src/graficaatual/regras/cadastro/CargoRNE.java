/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.Cargo;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author 
 */
public class CargoRNE extends GenericDAO{
    
    public Cargo salvar(EntityManager session, Cargo cargo) throws Exception {
        return super.saveOrUpdatePojo(session, cargo);
    }

    public boolean excluir(EntityManager session, Cargo cargo) throws Exception {
        return super.deletePojo(session, cargo);
    }
    
      public long getNextItem(EntityManager session) throws Exception {
        String q = " select max(e.codCargo) from Cargo e ";

        Long ret = getLong(session, q);

        return ret == null ? 1 : ret + 1;
    }
    
     public Cargo get(long codigo, EntityManager session) throws Exception {
        String sql = " select e from Cargo e where e.codCargo=?1 ";
        return getPojoUnique(session, Cargo.class, sql, codigo);
    }
     
      public List<Cargo> getList(EntityManager session) throws Exception {
        String sql = " select e from Cargo e order by e.codCargo ";
        return getPureList(session, Cargo.class, sql);
    }

    public List<Cargo> getList(EntityManager session, String sql) throws Exception {
        return getPureList(session, Cargo.class, sql);
    }
    
    
}
