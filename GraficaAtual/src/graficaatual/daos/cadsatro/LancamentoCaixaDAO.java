/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.cadsatro;
 
import graficaatual.entidades.LancamentoCaixa;
import graficaatual.regras.cadastro.LancamentoCaixaRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class LancamentoCaixaDAO extends LancamentoCaixaRNE {

    public LancamentoCaixa salvar(LancamentoCaixa lanc) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        LancamentoCaixa aux = null;
        try {
            aux = super.salvar(session, lanc);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();

        }
    }

    public LancamentoCaixa altera(LancamentoCaixa obj) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            session.getTransaction().begin();
            obj = super.salvar(session, obj);
            session.getTransaction().commit();
            return obj;
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    public void delete(LancamentoCaixa t) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            super.excluir(session, t);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;

        } finally {
            session.close();
        }
    }

    public LancamentoCaixa get(int codigo) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        LancamentoCaixa aux;
        try {
            aux = super.get(codigo, session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<LancamentoCaixa> getList() {
         EntityManager session = Persistencia.getInstance().getSessionComBegin();
        List<LancamentoCaixa> aux;
        try {
            aux = super.getList(session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public LancamentoCaixa getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            LancamentoCaixa aux = super.getPojo(LancamentoCaixa.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<LancamentoCaixa> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, LancamentoCaixa.class, SQL, parametros);
    }

}
