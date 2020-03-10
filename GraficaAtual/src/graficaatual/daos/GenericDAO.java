/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos;

import graficaatual.utilitarios.Persistencia;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
/**
 *
 * @author Projeto X
 */
public class GenericDAO {
    private static final long serialVersionUID = 1L;
    EntityManager session=null;
    protected String LogMensagem="";
    protected boolean FvaControleTransacao=false;
    protected boolean FvaInjectionTransaction=false;
    
     public GenericDAO(){

    }
     
     public boolean executeQuery(String SQL, Object ... parametros){
        boolean FvaRetorno=false;
        session=Persistencia.getInstance().getSessionComBegin();
        try{            
            Query qr=session.createQuery(SQL);
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i+1, parametros[i]);
            }
            qr.executeUpdate();
            session.getTransaction().commit();   
            FvaRetorno=true;            
        }catch(Exception e){
            session.getTransaction().rollback();
            System.out.println("Ocorreu um erro ao tentar executar a query: " +SQL+". Erro: "+e);
            e.printStackTrace();
        }
        session.close();
        session=null;
        return FvaRetorno;
    }
     
     public  boolean savePojo(Serializable pojo){
        boolean FvaRetorno=false;        
        session= Persistencia.getInstance().getSessionComBegin();
        try{               
            pojo=session.merge(pojo);
            session.persist(pojo);
            session.flush();
            session.getTransaction().commit();
            session.clear();
            FvaRetorno=true;
        }catch(Exception e){
            session.getTransaction().rollback();
            LogMensagem="Ocorreu um erro ao tentar salvar a entidade. Erro: "+e;
            System.out.println("Ocorreu um erro no método savePojo. Erro: "+e);
            e.printStackTrace();
          
        }
        session.close();
        session=null;
        return FvaRetorno;
    }
     
     public  <T extends Serializable> T  savePojo(EntityManager session, Class<T> classToSearch, Serializable pojo){
        try{               
            pojo = session.merge(pojo);
            session.persist(pojo);
            session.flush();
            session.getTransaction().commit();
            session.clear();
            
        }catch(Exception e){
            session.getTransaction().rollback();
            LogMensagem="Ocorreu um erro ao tentar salvar a entidade. Erro: "+e;
            System.out.println("Ocorreu um erro no método savePojo. Erro: "+e);
            e.printStackTrace();
          
        }
        return (T) pojo;
    }
     
     public  <T extends Serializable> T saveOrUpdatePojo(Serializable pojo){              
        session=Persistencia.getInstance().getSessionComBegin();
        try{               
            pojo=session.merge(pojo);
            session.persist(pojo);
            session.flush();
            session.getTransaction().commit();
           return (T) pojo;
        }catch(Exception e){
            session.getTransaction().rollback();
            LogMensagem="Ocorreu um erro ao tentar salvar a entidade. Erro: "+e;
            System.out.println("Ocorreu um erro no método savePojo. Erro: "+e);
            e.printStackTrace();
        }
        session.close();
        session=null;
        return null;
    }
     
     public boolean deletePojo(Serializable pojo){
        boolean FvaRetorno=false;
        session=Persistencia.getInstance().getSessionComBegin();
        try{            
            session.remove(session.contains(pojo)?pojo:session.merge(pojo));
            session.flush();
            session.getTransaction().commit();
            session.clear();
            FvaRetorno=true;
        }catch(Exception e){
            session.getTransaction().rollback();
            LogMensagem="Ocorreu um erro ao tentar deletar a entidade. Erro: "+e;
            System.out.println(LogMensagem);
            e.printStackTrace();            
        }
        session.close();
        session=null;
        return FvaRetorno;
    }
    
      public <T extends Serializable> List<T> getPureList(Class<T> classToSearch, String query, Object... parametros){        
        List<T> lista = null;
        session=Persistencia.getInstance().getSessionComBegin();
        try{
            Query qr=session.createNamedQuery(query);
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i+1, parametros[i]);
            }
            @SuppressWarnings("unchecked")
            List<T> toList=qr.getResultList();
            lista = toList;
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            System.out.println("Ocorre um erro ao tentar buscar lista de entidades. Erro: "+e);
            e.printStackTrace();
        }
        session.close();
        session=null;
        
        return lista;
    }
      
      public <T extends Serializable> T getPojo(Class<T> classToSearchPojo, Serializable key) {

        try {
            Serializable pojo = (Serializable) Persistencia.getInstance().getEntityManager()
                    .find(classToSearchPojo, key);

            return (T) pojo;
        } catch (Exception e) {
            LogMensagem = "Ocorreu um erro ao tentar buscar a entidade. Erro: " + e;
            System.out.println("Erro em getPojo. Erro: " + e);
            e.printStackTrace();
        }

        return null;
    }
      
      public <T extends Serializable> T getPurePojoUnique(Class<T> classToSearch, String query, Object...parametros){        
        
        try{
            Query qr=Persistencia.getInstance().getEntityManager().createQuery(query)
                    .setMaxResults(1).setFirstResult(0);
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i+1, parametros[i]);
            }
            Serializable pojo=(Serializable)qr.getSingleResult();
 
            return (T) pojo;
        }catch(Exception e){
            LogMensagem="Ocorreu um erro ao tentar realizar pesquisa. Erro: "+e;
            System.out.println("Ocorreu um erro ao tentar realizar pesquisa. Erro: "+e);
            e.printStackTrace();
        }
        
        return  null;
    }
     
    public <T extends Serializable> List<T> getPureList(EntityManager xSession, Class<T> classToSearch, String query, Object... parametros) {

        Query qr = xSession.createQuery(query);
        for (int i = 0; i < parametros.length; i++) {
            qr.setParameter(i + 1, parametros[i]);
        }

        @SuppressWarnings("unchecked")
        List<T> toList = qr.getResultList();

        return toList;
    }
    
    public <T extends Serializable> List<T> getPureList(EntityManager xSession,int registroInicial, int qtdeRegistro,Class<T> classToSearch, String query, Object... parametros){        
        try{
            Query qr=xSession.createQuery(query).setMaxResults(qtdeRegistro).setFirstResult(registroInicial);
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i+1, parametros[i]);
            }
            @SuppressWarnings("unchecked")
            List<T> toList=qr.getResultList();
   
            return toList;
        }catch(Exception e){
            LogMensagem="Ocorre um erro ao tentar buscar lista de entidades. Erro: "+e;
            System.out.println(LogMensagem);
            e.printStackTrace();
        }
        return null;
    }
}
