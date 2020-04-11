/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.pedido;
 
import graficaatual.entidades.Pedido;
import graficaatual.regras.pedido.PedidoRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class PedidoDAO extends PedidoRNE {

    public Pedido salvar(Pedido ped) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Pedido aux = null;
        try {
            aux = super.salvar(session, ped);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();

        }
    }

    public Pedido altera(Pedido obj) {
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

    public void delete(Pedido t) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            super.excluir(session, t);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;

        } finally {
            session.close();
        }
    }

    public Pedido get(int codigo) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Pedido aux;
        try {
            aux = super.get(codigo, session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<Pedido> getList() {
         EntityManager session = Persistencia.getInstance().getSessionComBegin();
        List<Pedido> aux;
        try {
            aux = super.getList(session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public Pedido getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            Pedido aux = super.getPojo(Pedido.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<Pedido> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, Pedido.class, SQL, parametros);
    }

}
