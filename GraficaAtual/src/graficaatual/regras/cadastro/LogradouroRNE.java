/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.Logradouro;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class LogradouroRNE extends GenericDAO {

    public Logradouro salvar(EntityManager session, Logradouro logradouro) throws Exception {
        return super.saveOrUpdatePojo(session, logradouro);
    }

    public boolean excluir(EntityManager session, Logradouro logradouro) throws Exception {
        return super.deletePojo(session, logradouro);
    }

    public long getNextItem(EntityManager session) throws Exception {
        String q = " select max(e.codLogradouro) from Logradouro e ";

        Long ret = getLong(session, q);

        return ret == null ? 1 : ret + 1;
    }

    public Logradouro get(long codigo, EntityManager session) throws Exception {
        String sql = " select e from Logradouro e where e.codLogradouro=?1 ";
        return getPojoUnique(session, Logradouro.class, sql, codigo);
    }

    public List<Logradouro> getList(EntityManager session) throws Exception {
        String sql = " select e from Logradouro e order by e.codLogradouro";
        return getPureList(session, Logradouro.class, sql);
    }

    public List<Logradouro> getList(EntityManager session, String sql) throws Exception {
        return getPureList(session, Logradouro.class, sql);
    }

}
