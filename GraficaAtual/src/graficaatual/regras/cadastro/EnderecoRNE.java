/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.Endereco;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class EnderecoRNE extends GenericDAO {

    public Endereco salvar(EntityManager session, Endereco endereco) throws Exception {
        return super.saveOrUpdatePojo(session, endereco);
    }

    public boolean excluir(EntityManager session, Endereco endereco) throws Exception {
        return super.deletePojo(session, endereco);
    }
    
         public long getNextItem(EntityManager session) throws Exception {
        String q = " select max(e.codEndereco) from Endereco e ";

        Long ret = getLong(session, q);

        return ret == null ? 1 : ret + 1;
    }

       public Endereco get(long codigo, EntityManager session) throws Exception {
        String sql = " select e from Endereco e where e.codEndereco=?1 ";
        return getPojoUnique(session, Endereco.class, sql, codigo);
    }
     
      public List<Endereco> getList(EntityManager session) throws Exception {
        String sql = " select e from Endereco e order by e.codEndereco";
        return getPureList(session, Endereco.class, sql);
    }

    public List<Endereco> getList(EntityManager session, String sql) throws Exception {
        return getPureList(session, Endereco.class, sql);
    }
}
