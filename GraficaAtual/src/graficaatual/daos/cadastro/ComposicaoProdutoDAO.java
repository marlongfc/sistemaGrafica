/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.cadastro;

import graficaatual.entidades.ComposicaoProduto;
import graficaatual.regras.cadastro.ComposicaoProdutoRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class ComposicaoProdutoDAO extends ComposicaoProdutoRNE {

    public ComposicaoProduto salvar(ComposicaoProduto composicaoProduto) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        ComposicaoProduto aux = null;
        try {
            aux = super.salvar(session, composicaoProduto);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }

    }

    public void delete(ComposicaoProduto l) throws Exception {

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

    public long getNextItem() throws Exception {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            return super.getNextItem(session);
        } finally {
            session.close();
        }
    }

     public ComposicaoProduto getPorCodComposicao(long codigo) throws Exception {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {
            return super.getPorCodComposicao(codigo, session);

        } catch (Exception e) {
            e.printStackTrace();
            session.close();
            return null;
        } finally {
            session.close();
        }
    }
    
    public List<ComposicaoProduto> getListPorProduto(long codigo) throws Exception {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {
            return super.getListPorProduto(codigo, session);

        } catch (Exception e) {
            e.printStackTrace();
            session.close();
            return null;
        } finally {
            session.close();
        }
    }

    public List<ComposicaoProduto> getList() throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {
            return super.getList(session);
        } finally {
            session.close();
        }
    }

    public List<ComposicaoProduto> getList(String sql) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {
            return super.getList(session, sql);
        } finally {
            session.close();
        }
    }

    public List<ComposicaoProduto> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, ComposicaoProduto.class, SQL, parametros);
    }

}
