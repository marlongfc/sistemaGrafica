/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.financeiro;

 
 
import graficaatual.entidades.financeiro.RequisicaoFinanceira;
import graficaatual.regras.financeiro.requisicaoFinanceiraRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class RequisicaoFinanceiraDAO extends requisicaoFinanceiraRNE {

    public RequisicaoFinanceira salvar(RequisicaoFinanceira req) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        RequisicaoFinanceira aux = null;
        try {
            aux = super.salvar(session, req);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();

        }
    }

    public RequisicaoFinanceira altera(RequisicaoFinanceira obj) {
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

    public void delete(RequisicaoFinanceira req) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            super.excluir(session, req);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;

        } finally {
            session.close();
        }
    }

    public RequisicaoFinanceira get(int codigo) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        RequisicaoFinanceira aux;
        try {
            aux = super.get(codigo, session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<RequisicaoFinanceira> getList() {
         EntityManager session = Persistencia.getInstance().getSessionComBegin();
        List<RequisicaoFinanceira> aux;
        try {
            aux = super.getList(session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public RequisicaoFinanceira getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            RequisicaoFinanceira aux = super.getPojo(RequisicaoFinanceira.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<RequisicaoFinanceira> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, RequisicaoFinanceira.class, SQL, parametros);
    }
    
     public boolean confereRequisicao(RequisicaoFinanceira r) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            return super.confereRequisicao(session, r);
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
