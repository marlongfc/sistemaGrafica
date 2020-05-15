/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.cadastro;



import graficaatual.entidades.Cargo;
import graficaatual.regras.cadastro.CargoRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Projeto X
 */
public class CargoDAO extends CargoRNE {
    
    public Cargo addCargo(Cargo cargo) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Cargo aux = null;
        try {
            aux = super.salvar(session, cargo);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
        finally {
            session.close();
        }
        
    }
    
    public Boolean delete(Cargo cargo) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Boolean aux = null;
        try {
            aux = super.deletePojo(session, cargo);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
        finally {
            session.close();
        }
        
    }
    
    public Cargo altera(Cargo obj) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            session.getTransaction().begin();
            obj = super.salvar( session,obj);
            session.getTransaction().commit();
            return obj;
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    public Cargo get(Integer cod) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            Cargo aux = super.getPojo(Cargo.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }
    
    public Cargo getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            Cargo aux = super.getPojo(Cargo.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }
    
     public List<Cargo> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, Cargo.class, SQL, parametros);
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
