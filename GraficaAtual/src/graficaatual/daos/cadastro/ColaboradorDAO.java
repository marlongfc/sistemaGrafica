/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.cadastro;


import graficaatual.entidades.Colaborador;
import graficaatual.regras.cadastro.ColaboradorRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Projeto X
 */
public class ColaboradorDAO extends ColaboradorRNE {
    
    public Colaborador addColaborador(Colaborador colaborador) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Colaborador aux = null;
        try {
            aux = super.salvar(session, colaborador);
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
    
    public Colaborador altera(Colaborador obj) {
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

    public Colaborador get(Integer cod) throws Exception{
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            Colaborador aux = super.get(cod, session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }
    
    public List<Colaborador> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, Colaborador.class, SQL, parametros);
    }
       

  
}
