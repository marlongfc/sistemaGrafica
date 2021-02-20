/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.financeiro;
   
import graficaatual.entidades.financeiro.ContasAReceber;
import graficaatual.regras.financeiro.ContasAReceberRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class ContasAReceberDAO extends ContasAReceberRNE {

    public ContasAReceber salvar(ContasAReceber conta) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        ContasAReceber aux = null;
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

    public ContasAReceber altera(ContasAReceber obj) {
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

    public void delete(ContasAReceber c) throws Exception {

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

    public ContasAReceber get(int codigo) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        ContasAReceber aux;
        try {
            aux = super.get(codigo, session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<ContasAReceber> getList() {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        List<ContasAReceber> aux;
        try {
            aux = super.getList(session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }
    
        public List<ContasAReceber> getList2() {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        List<ContasAReceber> aux;
        try {
            aux = super.getList2(session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }


    public ContasAReceber getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        try {
            ContasAReceber aux = super.getPojo(ContasAReceber.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<ContasAReceber> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, ContasAReceber.class, SQL, parametros);
    }

    public boolean confereContasReceber(ContasAReceber c) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            return super.confereContas(session, c);
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
