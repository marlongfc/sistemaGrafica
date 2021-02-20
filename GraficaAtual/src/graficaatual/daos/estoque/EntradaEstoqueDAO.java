/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.estoque;

import graficaatual.entidades.estoque.EntradaEstoque;
import graficaatual.regras.estoque.EntradaEstoqueRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class EntradaEstoqueDAO extends EntradaEstoqueRNE {

    public EntradaEstoque salvar(EntradaEstoque entrada) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        EntradaEstoque aux = null;
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

    public void delete(EntradaEstoque l) throws Exception {

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

    public EntradaEstoque getPorCodigo(long codigo) throws Exception {
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

    public EntradaEstoque getPorEntradaEstoque(long codigo) throws Exception {
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

    public List<EntradaEstoque> getList() throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionSemBegin();

        try {
            return super.getList(session);
        } finally {
            session.close();
        }
    }

    public List<EntradaEstoque> getListPorMaterial(long codMaterial) throws Exception {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();

        try {
            String sql = " select e from EntradaEstoque e where e.codMaterial=?1 ";
            return getPureList(session, EntradaEstoque.class, sql);
        } finally {
            session.close();
        }
    }

    public List<EntradaEstoque> getList(String sql) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionSemBegin();

        try {
            return super.getList(session, sql);
        } finally {
            session.close();
        }
    }

    public List<EntradaEstoque> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, EntradaEstoque.class, SQL, parametros);
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
