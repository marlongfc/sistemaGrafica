/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.financeiro;

 
import graficaatual.entidades.financeiro.Sangria;
import graficaatual.regras.financeiro.SangriaRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class SangriaDAO extends SangriaRNE {

    public Sangria salvar(Sangria sang) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Sangria aux = null;
        try {
            aux = super.salvar(session, sang);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();

        }
    }

    public Sangria altera(Sangria obj) {
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

    public void delete(Sangria s) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            super.excluir(session, s);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;

        } finally {
            session.close();
        }
    }

    public Sangria get(int codigo) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        Sangria aux;
        try {
            aux = super.get(codigo, session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<Sangria> getList() {
         EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        List<Sangria> aux;
        try {
            aux = super.getList(session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public Sangria getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        try {
            Sangria aux = super.getPojo(Sangria.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<Sangria> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, Sangria.class, SQL, parametros);
    }
    
     public boolean confereSangria(Sangria s) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            return super.confereSangria(session, s);
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
