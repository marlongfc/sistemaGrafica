package graficaatual.daos;

import graficaatual.utilitarios.Persistencia;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Projeto X
 *
 */
public abstract class GenericDAO implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    EntityManager session = null;
    protected String LogMensagem = "";
    protected boolean FvaControleTransacao = false;
    protected boolean FvaInjectionTransaction = false;

    public GenericDAO() {

    }

    public boolean savePojo(Serializable pojo) {
        boolean FvaRetorno = false;
        session = Persistencia.getInstance().getSessionComBegin();
        try {
            pojo = session.merge(pojo);
            session.persist(pojo);
            session.flush();
            session.getTransaction().commit();
            session.clear();
            FvaRetorno = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LogMensagem = "Ocorreu um erro ao tentar salvar a entidade. Erro: " + e;
            System.out.println("Ocorreu um erro no método savePojo. Erro: " + e);
            e.printStackTrace();

        }
        session.close();
        session = null;
        return FvaRetorno;
    }

    public boolean savePojoTesteExcpetion(Serializable pojo) throws Exception {
        boolean FvaRetorno = false;
        session = Persistencia.getInstance().getSessionComBegin();
        //try{               
        pojo = session.merge(pojo);
        session.persist(pojo);
        session.flush();
        session.getTransaction().commit();
        session.clear();
        FvaRetorno = true;
        session.close();
        session = null;
        return FvaRetorno;
    }

    public boolean savePojo(EntityManager xSession, Serializable pojo) {
        boolean FvaRetorno = false;
        try {
            pojo = xSession.merge(pojo);
            FvaRetorno = true;
        } catch (Exception e) {
            LogMensagem = "Ocorreu um erro ao tentar salvar a entidade. Erro: " + e;
            System.out.println("Ocorreu um erro no método savePojo. Erro: " + e);
            e.printStackTrace();
        }
        return FvaRetorno;
    }

    public <T extends Serializable> T saveOrUpdatePojo(Serializable pojo) {
        session = Persistencia.getInstance().getSessionComBegin();
        try {
            pojo = session.merge(pojo);
            session.persist(pojo);
            session.flush();
            session.getTransaction().commit();
            return (T) pojo;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LogMensagem = "Ocorreu um erro ao tentar salvar a entidade. Erro: " + e;
            System.out.println("Ocorreu um erro no método savePojo. Erro: " + e);
            e.printStackTrace();
        }
        session.close();
        session = null;
        return null;
    }

    public <T extends Serializable> T saveOrUpdatePojo(EntityManager xSession, Serializable pojo) {
        pojo = xSession.merge(pojo);
        return (T) pojo;
    }

    public <T extends Serializable> T persist(EntityManager xSession, Serializable pojo) {
        try {
            xSession.persist(pojo);;
            return (T) pojo;
        } catch (Exception e) {
            LogMensagem = "Ocorreu um erro ao tentar salvar a entidade. Erro: " + e;
            System.out.println("Ocorreu um erro no método savePojo. Erro: " + e);
            e.printStackTrace();
        }
        return null;
    }

    public boolean deletePojo(Serializable pojo) {
        boolean FvaRetorno = false;
        session = Persistencia.getInstance().getSessionComBegin();
        try {
            session.remove(session.contains(pojo) ? pojo : session.merge(pojo));
            session.flush();
            session.getTransaction().commit();
            session.clear();
            FvaRetorno = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            LogMensagem = "Ocorreu um erro ao tentar deletar a entidade. Erro: " + e;
            System.out.println(LogMensagem);
            e.printStackTrace();
        }
        session.close();
        session = null;
        return FvaRetorno;
    }

    public boolean deletePojo(EntityManager xSession, Serializable pojo) {
        boolean FvaRetorno = false;
        try {
            xSession.remove(xSession.contains(pojo) ? pojo : xSession.merge(pojo));
            FvaRetorno = true;
        } catch (Exception e) {
            LogMensagem = "Ocorreu um erro ao tentar deletar a entidade. Erro: " + e;
            System.out.println(LogMensagem);
            e.printStackTrace();
        }
        return FvaRetorno;
    }

    public <T extends Serializable> T getPojo(Class<T> classToSearchPojo, Serializable key) {
        try {
            Serializable pojo = (Serializable) Persistencia.getInstance().getEntityManager().find(classToSearchPojo, key);
            return (T) pojo;
        } catch (Exception e) {
            LogMensagem = "Ocorreu um erro ao tentar buscar a entidade. Erro: " + e;
            System.out.println("Erro em getPojo. Erro: " + e);
            e.printStackTrace();
        }
        return null;
    }

    public <T extends Serializable> T getPojo(EntityManager xSession, Class<T> classToSearchPojo, Serializable key) {
        try {
            Serializable pojo = (Serializable) xSession.find(classToSearchPojo, key);
            return (T) pojo;
        } catch (Exception e) {
            LogMensagem = "Ocorreu um erro ao tentar buscar a entidade. Erro: " + e;
            System.out.println("Erro em getPojo. Erro: " + e);
            e.printStackTrace();
        }
        return null;
    }

    public <T extends Serializable> List<T> getPureList(Class<T> classToSearch, String query, Object... parametros) {
        try {
            Query qr = Persistencia.getInstance().getEntityManager().createQuery(query);
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i + 1, parametros[i]);
            }

            @SuppressWarnings("unchecked")
            List<T> toList = qr.getResultList();
            return toList;
        } catch (Exception e) {
            LogMensagem = "Ocorre um erro ao tentar buscar lista de entidades. Erro: " + e;
            System.out.println(LogMensagem);
            e.printStackTrace();
        }
        return null;
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

    public <T extends Serializable> List<T> getPureList(int registroInicial, int qtdeRegistro, Class<T> classToSearch, String query, Object... parametros) {
        try {
            Query qr = Persistencia.getInstance().getEntityManager().createQuery(query).setMaxResults(qtdeRegistro).setFirstResult(registroInicial);
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i + 1, parametros[i]);
            }
            @SuppressWarnings("unchecked")
            List<T> toList = qr.getResultList();
            return toList;
        } catch (Exception e) {
            LogMensagem = "Ocorre um erro ao tentar buscar lista de entidades. Erro: " + e;
            System.out.println(LogMensagem);
            e.printStackTrace();
        }
        return null;
    }

    public <T extends Serializable> List<T> getPureList(EntityManager xSession, int registroInicial, int qtdeRegistro, Class<T> classToSearch, String query, Object... parametros) {
        try {
            Query qr = xSession.createQuery(query).setMaxResults(qtdeRegistro).setFirstResult(registroInicial);
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i + 1, parametros[i]);
            }
            @SuppressWarnings("unchecked")
            List<T> toList = qr.getResultList();
            return toList;
        } catch (Exception e) {
            LogMensagem = "Ocorre um erro ao tentar buscar lista de entidades. Erro: " + e;
            System.out.println(LogMensagem);
            e.printStackTrace();
        }
        return null;
    }

    public Iterator getPureListIterator(String query, Object... parametros) {
        try {
            Query qr = Persistencia.getInstance().getEntityManager().createQuery(query);
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i + 1, parametros[i]);
            }
            Iterator t = qr.getResultList().iterator();
            return t;
        } catch (Exception e) {
            LogMensagem = "Ocorre um erro ao tentar buscar lista de entidades. Erro: " + e;
            System.out.println(LogMensagem);
            e.printStackTrace();
        }
        return null;
    }

    public Iterator getPureListIterator(EntityManager xSession, String query, Object... parametros) {
        try {
            Query qr = xSession.createQuery(query);
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i + 1, parametros[i]);
            }
            Iterator t = qr.getResultList().iterator();
            return t;
        } catch (Exception e) {
            LogMensagem = "Ocorre um erro ao tentar buscar lista de entidades. Erro: " + e;
            System.out.println(LogMensagem);
            e.printStackTrace();
        }
        return null;
    }

    public <T extends Serializable> T getPurePojoUnique(Class<T> classToSearch, String query, Object... parametros) {
        try {
            Query qr = Persistencia.getInstance().getEntityManager().createQuery(query).setMaxResults(1).setFirstResult(0);
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i + 1, parametros[i]);
            }
            Serializable pojo = (Serializable) qr.getSingleResult();
            return (T) pojo;
        } catch (Exception e) {
            LogMensagem = "Ocorreu um erro ao tentar realizar pesquisa. Erro: " + e;
            System.out.println("Ocorreu um erro ao tentar realizar pesquisa. Erro: " + e);
            e.printStackTrace();
        }
        return null;
    }

    public <T extends Serializable> T getPurePojoUnique(EntityManager xSession, Class<T> classToSearch, String query, Object... parametros) {
        try {
            Query qr = xSession.createQuery(query).setMaxResults(1).setFirstResult(0);
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i + 1, parametros[i]);
            }
            Serializable pojo = (Serializable) qr.getSingleResult();
            return (T) pojo;
        } catch (Exception e) {
            LogMensagem = "Ocorreu um erro ao tentar realizar pesquisa. Erro: " + e;
            System.out.println("Ocorreu um erro ao tentar realizar pesquisa. Erro: " + e);
            e.printStackTrace();
        }
        return null;
    }

    /*
     * pesquisar resultado unico
     *
     * @param classToSearch Classe da pesquisa Ex.
     * LicitacaoAdjudicacaoPorItem.class;
     * @param query Sql da consulta.
     * @param parametros parametros da consulta
     * @return Retorna o primeiro resultado da pesquisa se encontrado se não
     * retorna null.
     * @since Ley 06/11/2013 
     */
    public <T extends Serializable> T getPojoUnique(Class<T> classToSearch, String query, Object... parametros) {

        try {

            EntityManager xsession = Persistencia.getInstance().getEntityManager();

            Query qr = xsession.createQuery(query);

            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i + 1, parametros[i]);
            }

            List results = qr.getResultList();
            if (!results.isEmpty()) {
                //Inguinora multiplos resultados              
                Serializable pojo = (Serializable) results.get(0);
                return (T) pojo;

            } else {
                LogMensagem = "Nenhum resultados encontrado.";
                return null;
            }

        } catch (Exception e) {
            LogMensagem = "Ocorreu um erro ao tentar realizar pesquisa. Erro: " + e;
            e.printStackTrace();
        }

        return null;
    }

    public <T extends Serializable> T getPojoUnique(EntityManager xsession, Class<T> classToSearch, String query, Object... parametros) {

        try {

            Query qr = xsession.createQuery(query);

            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i + 1, parametros[i]);
            }

            List results = qr.getResultList();
            if (!results.isEmpty()) {
                Serializable pojo = (Serializable) results.get(0);
                return (T) pojo;

            } else {
                LogMensagem = "Nenhum resultados encontrado.";
                return null;
            }

        } catch (Exception e) {
            LogMensagem = "Ocorreu um erro ao tentar realizar pesquisa. Erro: " + e;
            e.printStackTrace();
        }

        return null;
    }

    public Double getSUMDouble(String query, Object... parametros) {
        Double FvaRetorno = 0.0;
        try {
            Query qr = Persistencia.getInstance().getEntityManager().createQuery(query);
            if (parametros.length > 0) {
                for (int i = 0; i < parametros.length; i++) {
                    qr.setParameter(i + 1, parametros[i]);
                }
            }
            if (qr.getSingleResult() instanceof Double) {
                FvaRetorno = (Double) qr.getSingleResult();
            } else if (qr.getSingleResult() instanceof BigDecimal) {
                FvaRetorno = ((BigDecimal) qr.getSingleResult()).doubleValue();
            }
        } catch (Exception e) {
            FvaRetorno = 0.0;
            LogMensagem = "Ocorreu um erro ao tentar realizar pesquisa. Erro: " + e;
            System.out.println("Ocorreu um erro ao tentar realizar pesquisa. Erro: " + e);
            e.printStackTrace();
        }
        return FvaRetorno;
    }

    public Double getSUMDouble(EntityManager xSession, String query, Object... parametros) {
        Double FvaRetorno = 0.0;
        try {
            Query qr = xSession.createQuery(query);
            if (parametros.length > 0) {
                for (int i = 0; i < parametros.length; i++) {
                    qr.setParameter(i + 1, parametros[i]);
                }
            }
            if (qr.getSingleResult() instanceof Double) {
                FvaRetorno = (Double) qr.getSingleResult();
            } else if (qr.getSingleResult() instanceof BigDecimal) {
                FvaRetorno = ((BigDecimal) qr.getSingleResult()).doubleValue();
            }
        } catch (Exception e) {
            FvaRetorno = 0.0;
            LogMensagem = "Ocorreu um erro ao tentar realizar pesquisa . Erro: " + e;
            System.out.println("Ocorreu um erro ao tentar realizar pesquisa. Erro: " + e);
            e.printStackTrace();
        }
        return FvaRetorno;
    }

    public BigDecimal getSUMBigDecimalNamed(String query, Object... parametros) {
        return getSUMBigDecimalNamed(Persistencia.getInstance().getEntityManager(), query, parametros);
    }

    public BigDecimal getSUMBigDecimalNamed(EntityManager xSession, String query, Object... parametros) {
        BigDecimal retorno = BigDecimal.ZERO;
        try {
            Query qr = xSession.createNamedQuery(query);
            if (parametros.length > 0) {
                for (int i = 0; i < parametros.length; i++) {
                    qr.setParameter(i + 1, parametros[i]);
                }
            }
            if (qr.getSingleResult() instanceof Double) {
                retorno = new BigDecimal("" + qr.getSingleResult());
            } else if (qr.getSingleResult() instanceof BigDecimal) {
                retorno = (BigDecimal) qr.getSingleResult();
            } else if (qr.getSingleResult() instanceof Integer) {
                retorno = new BigDecimal("" + qr.getSingleResult());
            }
        } catch (Exception e) {
            retorno = BigDecimal.ZERO;
            LogMensagem = "Ocorreu um erro ao tentar realizar pesquisa. Erro: " + e;
            System.out.println("Ocorreu um erro ao tentar realizar pesquisa. Erro: " + e);
            e.printStackTrace();
        }
        return retorno;
    }

    public BigDecimal getSUMBigDecimal(String query, Object... parametros) {
        return getSUMBigDecimal(Persistencia.getInstance().getEntityManager(), query, parametros);
    }

    public BigDecimal getSUMBigDecimal(EntityManager xSession, String query, Object... parametros) {
        BigDecimal retorno = BigDecimal.ZERO;
        try {
            Query qr = xSession.createQuery(query);
            if (parametros.length > 0) {
                for (int i = 0; i < parametros.length; i++) {
                    qr.setParameter(i + 1, parametros[i]);
                }
            }
            if (qr.getSingleResult() instanceof Double) {
                retorno = new BigDecimal("" + qr.getSingleResult());
            } else if (qr.getSingleResult() instanceof BigDecimal) {
                retorno = (BigDecimal) qr.getSingleResult();
            } else if (qr.getSingleResult() instanceof Integer) {
                retorno = new BigDecimal("" + qr.getSingleResult());
            }
        } catch (Exception e) {
            retorno = BigDecimal.ZERO;
            LogMensagem = "Ocorreu um erro ao tentar realizar pesquisa. Erro: " + e;
            System.out.println("Ocorreu um erro ao tentar realizar pesquisa. Erro: " + e);
            e.printStackTrace();
        }
        return retorno;
    }

    public int getResultado(String query, Object... parametros) {
        Integer FvaRetorno = 0;
        try {
            Query qr = Persistencia.getInstance().getEntityManager().createQuery(query);
            if (parametros.length > 0) {
                for (int i = 0; i < parametros.length; i++) {
                    qr.setParameter(i + 1, parametros[i]);
                }
            }

            if (qr.getSingleResult() instanceof Integer) {
                FvaRetorno = ((Integer) qr.getSingleResult()).intValue();
            } else if (qr.getSingleResult() instanceof Long) {
                FvaRetorno = ((Long) qr.getSingleResult()).intValue();
            }

        } catch (Exception e) {
            FvaRetorno = 0;
            LogMensagem = "Ocorreu um erro ao tentar realizar pesquisa em getResultado. Erro: " + e;
            System.out.println("Ocorreu um erro ao tentar realizar pesquisa em getResultado. Erro: " + e);
            e.printStackTrace();
        }
        return FvaRetorno;
    }

    public int getResultado(EntityManager sessao, String query, Object... parametros) {
        Integer FvaRetorno = 0;
        Query qr = sessao.createQuery(query);
        if (parametros.length > 0) {
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i + 1, parametros[i]);
            }
        }

        if (qr.getSingleResult() instanceof Integer) {
            FvaRetorno = ((Integer) qr.getSingleResult()).intValue();
        } else if (qr.getSingleResult() instanceof Long) {
            FvaRetorno = ((Long) qr.getSingleResult()).intValue();
        }

        return FvaRetorno;
    }

    public long getResultadolong(EntityManager sessao, String query, Object... parametros) {
        Long FvaRetorno = 0l;
        Query qr = sessao.createQuery(query);
        if (parametros.length > 0) {
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i + 1, parametros[i]);
            }
        }

        if (qr.getSingleResult() instanceof Integer) {
            FvaRetorno = ((Long) qr.getSingleResult()).longValue();
        } else if (qr.getSingleResult() instanceof Long) {
            FvaRetorno = ((Long) qr.getSingleResult()).longValue();
        }

        return FvaRetorno;
    }

    public String getLogDAO() {
        return LogMensagem;
    }

    public int getResultadoInt(String query, Object... parametros) {
        Integer FvaRetorno = 0;
        try {
            Query qr = Persistencia.getInstance().getEntityManager().createQuery(query);
            if (parametros.length > 0) {
                for (int i = 0; i < parametros.length; i++) {
                    qr.setParameter(i + 1, parametros[i]);
                }
            }
            if (qr.getSingleResult() instanceof Integer) {
                FvaRetorno = ((Integer) qr.getSingleResult()).intValue();
            }
            if (qr.getSingleResult() instanceof Long) {
                FvaRetorno = ((Long) qr.getSingleResult()).intValue();
            }
        } catch (Exception e) {
            FvaRetorno = 0;
            LogMensagem = "Ocorreu um erro ao tentar realizar pesquisa. Erro: " + e;
            System.out.println("Ocorreu um erro ao tentar realizar pesquisa em getResultadoInt. Erro: " + e);
            e.printStackTrace();
        }
        return FvaRetorno;
    }

    public int getResultadoInt(EntityManager sessao, String query, Object... parametros) {
        Integer FvaRetorno = 0;
        try {
            Query qr = sessao.createQuery(query);
            if (parametros.length > 0) {
                for (int i = 0; i < parametros.length; i++) {
                    qr.setParameter(i + 1, parametros[i]);
                }
            }
            if (qr.getSingleResult() instanceof Integer) {
                FvaRetorno = ((Integer) qr.getSingleResult()).intValue();
            }
            if (qr.getSingleResult() instanceof Long) {
                FvaRetorno = ((Long) qr.getSingleResult()).intValue();
            }
        } catch (Exception e) {
            FvaRetorno = 0;
            LogMensagem = "Ocorreu um erro ao tentar realizar pesquisa. Erro: " + e;
            System.out.println("Ocorreu um erro ao tentar realizar pesquisa em getResultadoInt. Erro: " + e);
            e.printStackTrace();
        }
        return FvaRetorno;
    }

    public List executeNativeQuery(String SQL, Object... parametros) {
        List FvaRetorno = null;
        session = Persistencia.getInstance().getSessionComBegin();
        try {
            Query qr = session.createNativeQuery(SQL);
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i + 1, parametros[i]);
            }
            FvaRetorno = qr.getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar executar a query: " + SQL + ". Erro: " + e);
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        session = null;
        return FvaRetorno;
    }

    public List executeNativeQuery(EntityManager xSession, String SQL, Object... parametros) {
        List FvaRetorno = null;
        try {
            Query qr = xSession.createNativeQuery(SQL);
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i + 1, parametros[i]);
            }
            FvaRetorno = qr.getResultList();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar executar a query: " + SQL + ". Erro: " + e);
            e.printStackTrace();
        }
        return FvaRetorno;
    }

    public <T extends Serializable> List<T> executeNativeQuery(Class<T> classe, String SQL, Object... parametros) {
        session = Persistencia.getInstance().getSessionComBegin();
        try {
            Query qr = session.createNativeQuery(SQL);
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i + 1, parametros[i]);
            }
            List<T> pojo = qr.getResultList();
            session.getTransaction().commit();
            session.close();
            session = null;
            return pojo;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("Ocorreu um erro ao tentar executar a query: " + SQL + ". Erro: " + e);
            e.printStackTrace();
        }
        session.close();
        session = null;
        return null;
    }

    public <T extends Serializable> List<T> executeNativeQuery(EntityManager xSession, Class<T> classe, String SQL, Object... parametros) {
        try {
            Query qr = xSession.createNativeQuery(SQL);
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i + 1, parametros[i]);
            }
            List<T> pojo = qr.getResultList();
            return pojo;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar executar a query: " + SQL + ". Erro: " + e);
            e.printStackTrace();
        }
        return null;
    }

    public boolean executeQuery(String SQL, Object... parametros) {
        boolean FvaRetorno = false;
        session = Persistencia.getInstance().getSessionComBegin();
        try {
            Query qr = session.createQuery(SQL);
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i + 1, parametros[i]);
            }
            qr.executeUpdate();
            session.getTransaction().commit();
            FvaRetorno = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("Ocorreu um erro ao tentar executar a query: " + SQL + ". Erro: " + e);
            e.printStackTrace();
        }
        session.close();
        session = null;
        return FvaRetorno;
    }

    public boolean executeQuery(EntityManager xSession, String SQL, Object... parametros) {
        boolean FvaRetorno = false;
        try {
            Query qr = xSession.createQuery(SQL);
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i + 1, parametros[i]);
            }
            qr.executeUpdate();
            FvaRetorno = true;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar executar a query: " + SQL + ". Erro: " + e);
            e.printStackTrace();
        }
        return FvaRetorno;
    }

    public <T extends Serializable> List<T> getPureListNamed(EntityManager session, int registroInicial, int qtdeRegistro, Class<T> classToSearch, String query, Object... parametros) {
        try {
            Query qr = session.createNamedQuery(query).setMaxResults(qtdeRegistro).setFirstResult(registroInicial);
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i + 1, parametros[i]);
            }
            @SuppressWarnings("unchecked")
            List<T> toList = qr.getResultList();
            return toList;
        } catch (Exception e) {
            System.out.println("Ocorre um erro ao tentar buscar lista de entidades. Erro: " + e);
            e.printStackTrace();
        }
        return null;
    }

    public <T extends Serializable> List<T> getPureListNamed(EntityManager session, Class<T> classToSearch, String query, Object... parametros) {
        try {
            Query qr = session.createNamedQuery(query);
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i + 1, parametros[i]);
            }
            @SuppressWarnings("unchecked")
            List<T> toList = qr.getResultList();
            return toList;
        } catch (Exception e) {
            System.out.println("Ocorre um erro ao tentar buscar lista de entidades. Erro: " + e);
            e.printStackTrace();
        }
        return null;
    }

    public <T extends Serializable> List<T> getPureListNamed(Class<T> classToSearch, String query, Object... parametros) {
        List<T> lista = null;
        session = Persistencia.getInstance().getSessionComBegin();
        try {
            Query qr = session.createNamedQuery(query);
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i + 1, parametros[i]);
            }
            @SuppressWarnings("unchecked")
            List<T> toList = qr.getResultList();
            lista = toList;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("Ocorre um erro ao tentar buscar lista de entidades. Erro: " + e);
            e.printStackTrace();
        }
        session.close();
        session = null;

        return lista;
    }

    public <T extends Serializable> T getPurePojoUniqueNamed(EntityManager session, Class<T> classToSearch, String query, Object... parametros) {
        try {
            Query qr = session.createNamedQuery(query).setMaxResults(1).setFirstResult(0);
            for (int i = 0; i < parametros.length; i++) {
                qr.setParameter(i + 1, parametros[i]);
            }
            Serializable pojo = (Serializable) qr.getSingleResult();
            return (T) pojo;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar realizar pesquisa. Erro: " + e);
            e.printStackTrace();
        }
        return null;
    }

    public BigDecimal getBigDecimal(String query, EntityManager session, Object... parametros) {
        BigDecimal ret = getPojoUnique(session, BigDecimal.class, query, parametros);
        return ret == null ? BigDecimal.ZERO : ret;
    }

    public double getSDouble(String query, EntityManager session, Object... parametros) {
        Double ret = getPojoUnique(session, Double.class, query, parametros);
        return ret == null ? 0.00 : ret;
    }

    public BigDecimal getBigDecimal(String query, Object... parametros) {
        BigDecimal ret = getPojoUnique(BigDecimal.class, query, parametros);
        return ret == null ? BigDecimal.ZERO : ret;
    }

}
