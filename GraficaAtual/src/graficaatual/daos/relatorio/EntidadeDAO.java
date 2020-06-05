/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.relatorio;


import graficaatual.entidades.relatorio.Entidade;
import graficaatual.regras.relatorio.EntidadeRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Projeto X
 */
public class EntidadeDAO extends EntidadeRNE {
    
    public Entidade addEntidade(Entidade entidade) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Entidade aux = null;
        try {
            aux = super.salvar(session, entidade);
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
        
   public Entidade addCliente(EntityManager session, Entidade entidade) throws Exception {

       
        Entidade aux = null;
        try {
            aux = super.salvar(session, entidade);
           
            return aux;
        } catch (Exception e) {
            
            throw e;
        }
        
        
    }

    public Entidade get(Integer cod) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        try {
            Entidade aux = super.getPojo(Entidade.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }
    
    public Entidade getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        try {
            Entidade aux = super.getPojo(Entidade.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }
    
     public List<Entidade> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, Entidade.class, SQL, parametros);
    }
     

  
}
