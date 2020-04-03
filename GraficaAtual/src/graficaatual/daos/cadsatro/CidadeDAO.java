/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.cadsatro;


import graficaatual.entidades.Cidade;
import graficaatual.regras.cadastro.CidadeRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class CidadeDAO extends CidadeRNE {

    public Cidade salvar(Cidade bairro) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Cidade aux = null;
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

    public void delete(Cidade l) throws Exception {

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
    
    public Cidade getPorCodigo(int codigo) throws Exception {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();

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
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            return super.getNextItem(session);
        } finally {
            session.close();
        }
    }

    public List<Cidade> getList() throws Exception {

       EntityManager session = Persistencia.getInstance().getSessionComBegin();

       try {
           return super.getList(session);
       } finally {
           session.close();
       }
   }

    public List<Cidade> getList(String sql) throws Exception {

       EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {
            return super.getList(session, sql);
        } finally {
           session.close();
        }
    }

}
