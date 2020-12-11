/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.producao;

import graficaatual.entidades.producao.EquipeEntrega;
import graficaatual.regras.producao.EquipeEntregaRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Projeto X
 */
public class EquipeEntregaDAO extends EquipeEntregaRNE {
    
    public EquipeEntrega addEquipe(EquipeEntrega cliente) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        EquipeEntrega aux = null;
        try {
            aux = super.salvar(session, cliente);
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
        
   public EquipeEntrega addOrdem(EntityManager session, EquipeEntrega cliente) throws Exception {
        EquipeEntrega aux = null;
        try {
            aux = super.salvar(session, cliente);
           
            return aux;
        } catch (Exception e) {
            
            throw e;
        }
        
        
    }

    public EquipeEntrega get(Integer cod) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        try {
            EquipeEntrega aux = super.getPojo(EquipeEntrega.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }
    
    public EquipeEntrega getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        try {
            EquipeEntrega aux = super.getPojo(EquipeEntrega.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }
    
     public List<EquipeEntrega> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, EquipeEntrega.class, SQL, parametros);
    }
  
}
