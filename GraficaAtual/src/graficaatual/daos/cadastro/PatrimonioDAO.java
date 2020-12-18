/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.cadastro;

import graficaatual.entidades.Patrimonio;
import graficaatual.regras.cadastro.PatrimonioRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class PatrimonioDAO extends PatrimonioRNE {

    public Patrimonio salvar(Patrimonio pat) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Patrimonio aux = null;
        try {
            aux = super.salvar(session, pat);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();

        }
    }

    public Patrimonio altera(Patrimonio obj) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            session.getTransaction().begin();
            obj = super.salvar(session, obj);
            session.getTransaction().commit();
            return obj;
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    public void delete(Patrimonio p) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            super.excluir(session, p);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;

        } finally {
            session.close();
        }
    }

    public Patrimonio get(int codigo) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        Patrimonio aux;
        try {
            aux = super.get(codigo, session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<Patrimonio> getList() {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        List<Patrimonio> aux;
        try {
            aux = super.getList(session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public Patrimonio getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        try {
            Patrimonio aux = super.getPojo(Patrimonio.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<Patrimonio> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, Patrimonio.class, SQL, parametros);
    }

    public boolean conferePatrimonio(Patrimonio p) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            return super.conferePatrimonio(session, p);
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }
    }

    public String getSqlList(Integer inicio, Integer fim) throws Exception {
        String aux = null;
        try {
            aux = super.getSqlLista(inicio, fim);
            return aux;

        } catch (Exception e) {

            throw e;
        }
    }

}
