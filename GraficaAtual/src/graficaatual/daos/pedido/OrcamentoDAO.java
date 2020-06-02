/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.pedido;

import graficaatual.entidades.pedido.Orcamento;
import graficaatual.regras.pedido.OrcamentoRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class OrcamentoDAO extends OrcamentoRNE {

    public Orcamento salvar(Orcamento orca) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Orcamento aux = null;
        try {
            aux = super.salvar(session, orca);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();

        }
    }

    public Orcamento altera(Orcamento obj) {
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

    public void delete(Orcamento o) throws Exception {

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

    public Orcamento get(int codigo) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Orcamento aux;
        try {
            aux = super.get(codigo, session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<Orcamento> getList() {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        List<Orcamento> aux;
        try {
            aux = super.getList(session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<Orcamento> getListOrcamento() {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        List<Orcamento> aux;
        try {
            aux = super.getListOrcamento(session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<Orcamento> getListPedido() {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        List<Orcamento> aux;
        try {
            aux = super.getListPedido(session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public Orcamento getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            Orcamento aux = super.getPojo(Orcamento.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<Orcamento> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, Orcamento.class, SQL, parametros);
    }

}
