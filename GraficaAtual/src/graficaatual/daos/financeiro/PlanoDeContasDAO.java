/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.financeiro;

import graficaatual.entidades.financeiro.PlanoDeContas;
import graficaatual.regras.financeiro.PlanoDeContasRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class PlanoDeContasDAO extends PlanoDeContasRNE {

    public PlanoDeContas salvar(PlanoDeContas c) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        PlanoDeContas aux = null;
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

    public PlanoDeContas altera(PlanoDeContas obj) {
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

    public void delete(PlanoDeContas p) throws Exception {

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

    public PlanoDeContas get(int codigo) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        PlanoDeContas aux;
        try {
            aux = super.get(codigo, session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<PlanoDeContas> getList() {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        List<PlanoDeContas> aux;
        try {
            aux = super.getList(session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public PlanoDeContas getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        try {
            PlanoDeContas aux = super.getPojo(PlanoDeContas.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<PlanoDeContas> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, PlanoDeContas.class, SQL, parametros);
    }

    public boolean conferePlano(PlanoDeContas p) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            return super.conferePlano(session, p);
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
