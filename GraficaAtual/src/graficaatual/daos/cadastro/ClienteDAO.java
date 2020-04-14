/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.cadastro;

import graficaatual.entidades.Cliente;
import graficaatual.regras.cadastro.ClienteRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Projeto X
 */
public class ClienteDAO extends ClienteRNE {
    
    public Cliente addCliente(Cliente cliente) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Cliente aux = null;
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
        
   public Cliente addCliente(EntityManager session, Cliente cliente) throws Exception {

       
        Cliente aux = null;
        try {
            aux = super.salvar(session, cliente);
           
            return aux;
        } catch (Exception e) {
            
            throw e;
        }
        
        
    }

    public Cliente get(Long cod) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            Cliente aux = super.getPojo(Cliente.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }
    
    public Cliente getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            Cliente aux = super.getPojo(Cliente.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }
    
     public List<Cliente> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, Cliente.class, SQL, parametros);
    }
     

  
}
