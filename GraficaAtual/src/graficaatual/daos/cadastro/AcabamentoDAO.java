/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.cadastro;

 
 
 
import graficaatual.entidades.Acabamento;
import graficaatual.regras.cadastro.AcabamentoRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class AcabamentoDAO extends AcabamentoRNE {

    public Acabamento salvar(Acabamento a) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Acabamento aux = null;
        try {
            aux = super.salvar(session, a);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();

        }
    }

    public Acabamento altera(Acabamento obj) {
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

    public void delete(Acabamento a) throws Exception {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            super.excluir(session, a);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;

        } finally {
            session.close();
        }
    }

    public Acabamento get(int codigo) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Acabamento aux;
        try {
            aux = super.get(codigo, session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<Acabamento> getList() {
         EntityManager session = Persistencia.getInstance().getSessionComBegin();
        List<Acabamento> aux;
        try {
            aux = super.getList(session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public Acabamento getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            Acabamento aux = super.getPojo(Acabamento.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<Acabamento> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, Acabamento.class, SQL, parametros);
    }
    
     public boolean confereAcabamento(Acabamento a) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            return super.confereAcabamento(session, a);
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }
    }

}
