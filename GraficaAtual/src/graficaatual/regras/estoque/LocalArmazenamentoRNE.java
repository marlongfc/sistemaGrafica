/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.estoque;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.estoque.LocalArmazenamento;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class LocalArmazenamentoRNE extends GenericDAO {

    public LocalArmazenamento salvar(EntityManager session, LocalArmazenamento localArmazenamento) throws Exception {
        return super.saveOrUpdatePojo(session, localArmazenamento);
    }

    public boolean excluir(EntityManager session, LocalArmazenamento localArmazenamento) throws Exception {
        return super.deletePojo(session, localArmazenamento);
    }

    public long getNextItem(EntityManager session) throws Exception {
        String q = " select max(e.codLocalArmazenamento) from LocalArmazenamento e ";

        Long ret = getLong(session, q);

        return ret == null ? 1 : ret + 1;
    }

    public LocalArmazenamento get(long codigo, EntityManager session) throws Exception {
        String sql = " select e from LocalArmazenamento e where e.codLocalArmazenamento=?1 ";
        return getPojoUnique(session, LocalArmazenamento.class, sql, codigo);
    }

    public LocalArmazenamento getByMaterial(long codigo, EntityManager session) throws Exception {
        String sql = " select e from LocalArmazenamento e where e.localArmazenamento=?1 ";
        return getPojoUnique(session, LocalArmazenamento.class, sql, codigo);
    }

    public List<LocalArmazenamento> getList(EntityManager session) throws Exception {
        String sql = " select e from LocalArmazenamento e order by e.codLocalArmazenamento";
        return getPureList(session, LocalArmazenamento.class, sql);
    }

    public List<LocalArmazenamento> getList(EntityManager session, String sql) throws Exception {
        return getPureList(session, LocalArmazenamento.class, sql);
    }

    public String getSqlLista(Integer inicio, Integer fim) {

        String sql = "select l.codlocalArmazenamento, l.descricao "
                + " from localArmazenamentoEstoque l"
                + " where l.codlocalArmazenamento>=" + inicio + " and l.codlocalArmazenamento<=" + fim
                + " order by l.descricao asc";

        return sql;
    }
}
