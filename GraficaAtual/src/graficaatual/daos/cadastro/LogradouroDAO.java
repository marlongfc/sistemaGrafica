/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.cadastro;

import graficaatual.entidades.Logradouro;
import graficaatual.regras.cadastro.LogradouroRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class LogradouroDAO extends LogradouroRNE {

    public Logradouro salvar(Logradouro logradouro) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Logradouro aux = null;
        try {
            aux = super.salvar(session, logradouro);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
            return null;
        }

    }

    public boolean delete(Logradouro l) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Boolean del = false;
        
        try {
            del = super.excluir(session, l);
            session.getTransaction().commit();

        } catch (Exception e) {
            del = false;
            session.getTransaction().rollback();
            throw e;

        } finally {
            session.close();
            return del;
        }
    }

    public long getNextItem() throws Exception {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            return super.getNextItem(session);
        } finally {
            session.close();
        }
    }

    public Logradouro getPorCodigo(long codigo) throws Exception {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();

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

    public List<Logradouro> getList() throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {
            return super.getList(session);
        } finally {
            session.close();
        }
    }

    public List<Logradouro> getList(String sql) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {
            return super.getList(session, sql);
        } finally {
            session.close();
        }
    }

    public List<Logradouro> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, Logradouro.class, SQL, parametros);
    }

}
