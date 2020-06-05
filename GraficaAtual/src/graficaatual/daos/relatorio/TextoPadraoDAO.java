/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.relatorio;


import graficaatual.entidades.relatorio.TextoPadrao;
import graficaatual.regras.relatorio.TextoPadraoRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Projeto X
 */
public class TextoPadraoDAO extends TextoPadraoRNE {
    
    public TextoPadrao addTextoPadrao(TextoPadrao entidade) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        TextoPadrao aux = null;
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
        
   public TextoPadrao addCliente(EntityManager session, TextoPadrao entidade) throws Exception {

       
        TextoPadrao aux = null;
        try {
            aux = super.salvar(session, entidade);
           
            return aux;
        } catch (Exception e) {
            
            throw e;
        }
        
        
    }

    public TextoPadrao get(Integer cod) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        try {
            TextoPadrao aux = super.getPojo(TextoPadrao.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }
    
    public TextoPadrao getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        try {
            TextoPadrao aux = super.getPojo(TextoPadrao.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }
    
     public List<TextoPadrao> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, TextoPadrao.class, SQL, parametros);
    }
     

  
}
