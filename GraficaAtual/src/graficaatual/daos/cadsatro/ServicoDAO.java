/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.cadsatro;


import graficaatual.entidades.Servico;
import graficaatual.regras.cadastro.ServicoRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class ServicoDAO extends ServicoRNE {

    public Servico salvar(Servico servico) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Servico aux = null;
        try {
            aux = super.salvar(session, servico);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();

        }
    }

    public Servico altera(Servico obj) {
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

    public void delete(Servico s) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            super.excluir(session, s);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;

        } finally {
            session.close();
        }
    }

    public Servico get(int codigo) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Servico aux;
        try {
            aux = super.get(codigo, session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<Servico> getList() {
         EntityManager session = Persistencia.getInstance().getSessionComBegin();
        List<Servico> aux;
        try {
            aux = super.getList(session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public Servico getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            Servico aux = super.getPojo(Servico.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<Servico> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, Servico.class, SQL, parametros);
    }

}
