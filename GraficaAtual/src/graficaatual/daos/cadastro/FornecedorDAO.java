/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.cadastro;


import graficaatual.entidades.Fornecedor;
import graficaatual.regras.cadastro.FornecedorRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Projeto X
 */
public class FornecedorDAO extends FornecedorRNE {
    
    public Fornecedor addFornecedor(Fornecedor fornecedor) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Fornecedor aux = null;
        try {
            aux = super.salvar(session, fornecedor);
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
        
   public Fornecedor addFornecedor(EntityManager session, Fornecedor fornecedor) throws Exception {
        Fornecedor aux = null;
        try {
            aux = super.salvar(session, fornecedor);
            return aux;
        } catch (Exception e) {
            throw e;
        }
    }

    public Fornecedor get(Long cod) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            Fornecedor aux = super.getPojo(Fornecedor.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }
    
    public Fornecedor getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            Fornecedor aux = super.getPojo(Fornecedor.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }
    
     public List<Fornecedor> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, Fornecedor.class, SQL, parametros);
    }
     

  
}
