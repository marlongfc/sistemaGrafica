/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.cadastro;


import graficaatual.entidades.UF;
import graficaatual.regras.cadastro.UFRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class UFDAO extends UFRNE {

    public UF salvar(UF bairro) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        UF aux = null;
        try {
            aux = super.salvar(session, bairro);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
            
        }

    }

    public void delete(UF l) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            super.excluir(session, l);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;

        } finally {
            session.close();
        }
    }
    
    public UF getPorCodigo(int codigo) throws Exception {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();

        try {
            return super.get(codigo, session);
            
        }catch(Exception e){
            e.printStackTrace();
            session.close();
            return null;
        }finally {
            session.close();
        }
    }

     public long getNextItem() throws Exception {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        try {
            return super.getNextItem(session);
        } finally {
            session.close();
        }
    }

    public List<UF> getList() throws Exception {

       EntityManager session = Persistencia.getInstance().getSessionSemBegin();

       try {
           return super.getList(session);
       } finally {
           session.close();
       }
   }

    public List<UF> getList(String sql) throws Exception {

       EntityManager session = Persistencia.getInstance().getSessionSemBegin();

        try {
            return super.getList(session, sql);
        } finally {
           session.close();
        }
    }

}
