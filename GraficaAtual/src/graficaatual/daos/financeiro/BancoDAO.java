/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.financeiro;

import graficaatual.entidades.financeiro.Banco;
import graficaatual.regras.financeiro.BancoRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class BancoDAO extends BancoRNE {

    public Banco salvar(Banco ban) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Banco aux = null;
        try {
            aux = super.salvar(session, ban);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();

        }
    }

    public Banco altera(Banco obj) {
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

    public void delete(Banco b) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            super.excluir(session, b);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;

        } finally {
            session.close();
        }
    }

    public Banco get(int codigo) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Banco aux;
        try {
            aux = super.get(codigo, session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<Banco> getList() {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        List<Banco> aux;
        try {
            aux = super.getList(session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public Banco getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            Banco aux = super.getPojo(Banco.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<Banco> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, Banco.class, SQL, parametros);
    }

    public boolean confereBanco(Banco b) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            return super.confereBanco(session, b);
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }
    }
    
     public String getSqlList(Integer inicio, Integer fim) throws Exception {
       String aux = null;
        try {
            aux = super.getSqlLista(inicio,fim);
            return aux;
            
        } catch (Exception e) {
            
            throw e;
        }
    }

}
