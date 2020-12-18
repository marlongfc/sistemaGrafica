/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.financeiro;
  
import graficaatual.entidades.financeiro.ContasAPagar;
import graficaatual.regras.financeiro.ContasAPagarRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class ContasAPagarDAO extends ContasAPagarRNE {

    public ContasAPagar salvar(ContasAPagar conta) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        ContasAPagar aux = null;
        try {
            aux = super.salvar(session, conta);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();

        }
    }

    public ContasAPagar altera(ContasAPagar obj) {
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

    public void delete(ContasAPagar c) throws Exception {

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

    public ContasAPagar get(int codigo) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        ContasAPagar aux;
        try {
            aux = super.get(codigo, session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<ContasAPagar> getList() {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        List<ContasAPagar> aux;
        try {
            aux = super.getList(session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public ContasAPagar getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        try {
            ContasAPagar aux = super.getPojo(ContasAPagar.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<ContasAPagar> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, ContasAPagar.class, SQL, parametros);
    }

    public boolean confereContaPagar(ContasAPagar c) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            return super.confereContaAPagar(session, c);
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
