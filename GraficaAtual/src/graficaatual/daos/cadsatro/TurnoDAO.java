/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.cadsatro;

import graficaatual.entidades.Turno;
import graficaatual.regras.cadastro.TurnoRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class TurnoDAO extends TurnoRNE {

    public Turno salvar(Turno turno) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Turno aux = null;
        try {
            aux = super.salvar(session, turno);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();

        }
    }

    public Turno altera(Turno obj) {
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

    public void delete(Turno t) throws Exception {

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

    public Turno get(int codigo) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Turno aux;
        try {
            aux = super.get(codigo, session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<Turno> getList() {
         EntityManager session = Persistencia.getInstance().getSessionComBegin();
        List<Turno> aux;
        try {
            aux = super.getList(session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public Turno getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            Turno aux = super.getPojo(Turno.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<Turno> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, Turno.class, SQL, parametros);
    }

}
