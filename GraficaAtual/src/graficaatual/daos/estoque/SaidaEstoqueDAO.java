/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.estoque;

import graficaatual.entidades.estoque.SaidaEstoque;
import graficaatual.regras.estoque.SaidaEstoqueRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class SaidaEstoqueDAO extends SaidaEstoqueRNE {

    public SaidaEstoque salvar(SaidaEstoque entrada) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        SaidaEstoque aux = null;
        try {
            aux = super.salvar(session, entrada);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();

        }

    }

    public void delete(SaidaEstoque l) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            super.excluir(session, l);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;

        } finally {
            session.close();
        }
    }

    public SaidaEstoque getPorCodigo(long codigo) throws Exception {
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

    public SaidaEstoque getPorSaidaEstoque(long codigo) throws Exception {
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

    public List<SaidaEstoque> getList() throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionSemBegin();

        try {
            return super.getList(session);
        } finally {
            session.close();
        }
    }

    public List<SaidaEstoque> getList(String sql) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionSemBegin();

        try {
            return super.getList(session, sql);
        } finally {
            session.close();
        }
    }

    public List<SaidaEstoque> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, SaidaEstoque.class, SQL, parametros);
    }

    /*
    public String getSqlList(Integer inicio, Integer fim) throws Exception {
      
        try {
           return super.getSqlLista(inicio,fim);
                     
        } catch (Exception e) {
            
            throw e;
        }
    }
     */
}
