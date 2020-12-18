/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.financeiro;
 
import graficaatual.entidades.financeiro.Caixa;
import graficaatual.regras.financeiro.CaixaRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class CaixaDAO extends CaixaRNE {

    public Caixa salvar(Caixa cai) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Caixa aux = null;
        try {
            aux = super.salvar(session, cai);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();

        }
    }

    public Caixa altera(Caixa obj) {
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

    public void delete(Caixa c) throws Exception {

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

    public Caixa get(int codigo) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        Caixa aux;
        try {
            aux = super.get(codigo, session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<Caixa> getList() {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        List<Caixa> aux;
        try {
            aux = super.getList(session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public Caixa getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        try {
            Caixa aux = super.getPojo(Caixa.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<Caixa> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, Caixa.class, SQL, parametros);
    }

    public boolean confereCaixa(Caixa c) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            return super.confereCaixa(session, c);
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
