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

    public long getNextItem(EntityManager session) throws Exception {
        String q = " select max(e.codBairro) from Bairro e ";

        Long ret = getLong(session, q);

        return ret == null ? 1 : ret + 1;
    }

    public Bairro get(long codigo, EntityManager session) throws Exception {
        String sql = " select e from Bairro e where e.codBairro=?1 ";
        return getPojoUnique(session, Bairro.class, sql, codigo);
    }

    public List<Bairro> getList(EntityManager session) throws Exception {
        String sql = " select e from Bairro e order by e.codBairro";
        return getPureList(session, Bairro.class, sql);
    }

    public List<Bairro> getList(EntityManager session, String sql) throws Exception {
        return getPureList(session, Bairro.class, sql);
    }

    public String getSqlLista(Integer inicio, Integer fim) {

        String sql = "select e.codBairro, e.descricao from Bairro e "
                + " where e.codBairro>=" + inicio + " and e.codBairro <=" + fim
                + " order by e.descricao asc";

        return sql;
    }
}
