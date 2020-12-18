/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.financeiro;

import graficaatual.entidades.financeiro.CentroDeCustos;
import graficaatual.regras.financeiro.CentroDeCustosRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class CentroDeCustoDAO extends CentroDeCustosRNE {

    public CentroDeCustos salvar(CentroDeCustos c) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        CentroDeCustos aux = null;
        try {
            aux = super.salvar(session, c);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();

        }
    }

    public CentroDeCustos altera(CentroDeCustos obj) {
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

    public void delete(CentroDeCustos c) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            super.excluir(session, c);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;

        } finally {
            session.close();
        }
    }

    public CentroDeCustos get(int codigo) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        CentroDeCustos aux;
        try {
            aux = super.get(codigo, session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<CentroDeCustos> getList() {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        List<CentroDeCustos> aux;
        try {
            aux = super.getList(session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public CentroDeCustos getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        try {
            CentroDeCustos aux = super.getPojo(CentroDeCustos.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<CentroDeCustos> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, CentroDeCustos.class, SQL, parametros);
    }

    public boolean confereCentro(CentroDeCustos c) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            return super.confereCentro(session, c);
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
