/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.pedido;

import graficaatual.entidades.pedido.ItemOrcamento;
import graficaatual.regras.pedido.ItemOrcamentoRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class ItemOrcamentoDAO extends ItemOrcamentoRNE {

    public ItemOrcamento salvar(ItemOrcamento item) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        ItemOrcamento aux = null;
        try {
            aux = super.salvar(session, item);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            session.close();

        }
    }

    public ItemOrcamento altera(ItemOrcamento obj) {
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

    public void delete(ItemOrcamento o) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            super.excluir(session, o);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;

        } finally {
            session.close();
        }
    }

    public ItemOrcamento get(int codigo) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        ItemOrcamento aux;
        try {
            aux = super.get(codigo, session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<ItemOrcamento> getList() {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        List<ItemOrcamento> aux;
        try {
            aux = super.getList(session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public ItemOrcamento getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        try {
            ItemOrcamento aux = super.getPojo(ItemOrcamento.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<ItemOrcamento> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, ItemOrcamento.class, SQL, parametros);
    }

    public List<ItemOrcamento> getListOrcamento(Integer codOrc) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionSemBegin();

        try {
            return super.getListOrcamento(session, codOrc);
        } finally {
            session.close();
        }
    }

}
