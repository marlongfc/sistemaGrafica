/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.utilitarios;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


/**
 *
 * @author ProjetoX
 */
 
public class Persistencia {

    private static final long serialVersionUID = 1L;
    
    public static String status = "";
    private static Persistencia me;
    private EntityManagerFactory emFactory;
    private final ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<EntityManager>();
    private final ThreadLocal<EntityTransaction> threadTransaction = new ThreadLocal<EntityTransaction>();
    private static final ThreadLocal<Long> threadCountTransaction = new ThreadLocal<Long>();
    public static String GAUserName = "prostgres";
    public static String GAPassword = "427623";
    public static String GAPorta = "5432";
    public static String GAIpServidor = "localhost";
    public static String GADatabase = "bancoGrafica";
    public static String nomePersistenceUnit = "PesistenceHibernate";
    public static String GADDL = "update";
    public static Map parametro = new HashMap();

    public static void closeALL() {
        me = null;
    }

    private Persistencia() {

        parametro.put("hibernate.connection.username", GAUserName);//Tava faltando ou ...
        parametro.put("hibernate.connection.password", GAPassword);//Tava faltando ou...
        parametro.put("hibernate.connection.url", "jdbc:postgresql://" + GAIpServidor.trim() + (GAPorta.trim().length() > 0 ? ":" + GAPorta.trim() : "") + "/" + GADatabase);
        parametro.put("hibernate.hbm2ddl.auto", GADDL);
        
        emFactory = Persistence.createEntityManagerFactory(nomePersistenceUnit, parametro);
        
    }

    private Persistencia(EntityManagerFactory factory) {
        emFactory = factory;
    }

    public String getStatus() {
        return status;
    }

    private void atualizaFactory(EntityManagerFactory factory) {
        emFactory = factory;
    }

    public static Persistencia getInstance() {

        if (me == null) {
            me = new Persistencia();
        }

        return me;
    }

    public static Persistencia getInstance(EntityManagerFactory factory) {
        if (me == null) {
            me = new Persistencia(factory);
        } else {
            me.atualizaFactory(factory);
        }
        return me;
    }

    public EntityManager getSessionComBegin() {

        EntityManager toSession = null;

        toSession = emFactory.createEntityManager();

        toSession.getTransaction().begin();
        return toSession;

    }
    public EntityManager getSessionSemBegin() {
        EntityManager toSession = null;

        toSession = emFactory.createEntityManager();

        return toSession;
    }

    public void closeSessionFactory() {
        emFactory.close();
    }

    //Métodos para controle de transações/sessões do sistema
    public EntityManager getEntityManager() {    // System.out.println("Abriu ou recuperou sess�o");
        EntityManager s = threadEntityManager.get();
        try {
            if (s != null) {
                if (!s.getTransaction().isActive()) {
                    closeEntityManager();
                    s = null;
                }
            }
            if (s == null) {

                s = emFactory.createEntityManager();
                threadEntityManager.set(s);
            }
        } catch (RuntimeException e) {
            System.out.println("Ocorreu um erro ao tentar criar sessão. Erro: " + e);
            e.printStackTrace();
        }
        return s;
    }

    public void closeEntityManager() {
        //if(!verificarComite()) return;
        try {
            EntityManager s = threadEntityManager.get();
            threadEntityManager.set(null);
            if (s != null && s.isOpen()) {
                s.close();
            }
            EntityTransaction tx = threadTransaction.get();
            if (tx != null && tx.isActive()) {
                rollbackTransaction();
            }
            s = null;
        } catch (RuntimeException e) {
            System.out.println("Ocorreu um erro ao tentar fechar sessão. Erro: " + e);
            e.printStackTrace();
        }
    }

    public void beginTransaction() {
        updateCountTransaction(1);
        EntityTransaction tx = threadTransaction.get();
        try {
            if (tx == null) {
                tx = getEntityManager().getTransaction();
                if (!tx.isActive()) {
                    tx.begin();
                }
                threadTransaction.set(tx);
            } else {
                System.out.println("Nao criou transacao para = " + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar criar transação. Erro: " + e);
            e.printStackTrace();
        }
    }

    public boolean isTransacaoAtiva() {
        EntityTransaction tx = threadTransaction.get();
        return (tx != null && tx.isActive());
    }

    private void updateCountTransaction(int i) {
        Long count = threadCountTransaction.get();
        if (count == null) {
            count = 0L;
        }
        count += i;
        threadCountTransaction.set(count);
        //System.out.println("Transacao Nº: " + count);
    }

    public boolean verificarComite() {
        Long count = threadCountTransaction.get();
        return (count == null || count == 0);
    }

    public void commitTransaction() {
        updateCountTransaction(-1);
        /*if (!verificarComite()) {
        System.out.println("NÂO comitou transacao para = " + Thread.currentThread().getName()+", Qtde de Transação abertas: "+threadCountTransaction.get());
        return;
        }*/
        EntityTransaction tx = threadTransaction.get();
        if (tx != null && tx.isActive()) {
            getEntityManager().flush();
            tx.commit();
            getEntityManager().clear();
            closeEntityManager();
        }
        tx = null;
        threadTransaction.set(null);
    }

    public void rollbackTransaction() {
        threadCountTransaction.set(0l);
        EntityTransaction tx = threadTransaction.get();
        try {
            threadTransaction.set(null);
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            closeEntityManager();
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar executar rollback no banco de dados. Erro: " + ex);
        } finally {
            closeEntityManager();
        }
    }

}
