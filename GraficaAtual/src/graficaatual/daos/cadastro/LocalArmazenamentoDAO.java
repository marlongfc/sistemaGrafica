/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.cadastro;

import graficaatual.entidades.estoque.LocalArmazenamento;
import graficaatual.regras.estoque.LocalArmazenamentoRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class LocalArmazenamentoDAO extends LocalArmazenamentoRNE {

    public LocalArmazenamento salvar(LocalArmazenamento bairro) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        LocalArmazenamento aux = null;
        try {
            aux = super.salvar(session, bairro);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();

        }

    }

    public Boolean delete(LocalArmazenamento l) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Boolean aux = false;

        try {

            aux = super.excluir(session, l);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;

        } finally {
            session.close();
        }
        return aux;
    }

    public LocalArmazenamento getPorCodigo(long codigo) throws Exception {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();

        try {
            return super.get(codigo, session);

        } catch (Exception e) {
            e.printStackTrace();
            session.close();
            return null;
        } finally {
            session.close();
        }
    }

    public long getNextItem() throws Exception {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        try {
            return super.getNextItem(session);
        } finally {
            session.close();
        }
    }

    public List<LocalArmazenamento> getList() throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionSemBegin();

        try {
            return super.getList(session);
        } finally {
            session.close();
        }
    }

    public List<LocalArmazenamento> getList(String sql) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionSemBegin();

        try {
            return super.getList(session, sql);
        } finally {
            session.close();
        }
    }

    public List<LocalArmazenamento> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, LocalArmazenamento.class, SQL, parametros);
    }

    public String getSqlList(Integer inicio, Integer fim) throws Exception {

        try {
            return super.getSqlLista(inicio, fim);

        } catch (Exception e) {

            throw e;
        }
    }
}
