/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.financeiro;

import graficaatual.entidades.financeiro.FormaDePagamento;
import graficaatual.regras.financeiro.FormaDePagamentoRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class FormaDePagamentoDAO extends FormaDePagamentoRNE {

    public FormaDePagamento salvar(FormaDePagamento forma) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        FormaDePagamento aux = null;
        try {
            aux = super.salvar(session, forma);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();

        }
    }

    public FormaDePagamento altera(FormaDePagamento obj) {
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

    public void delete(FormaDePagamento f) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            super.excluir(session, f);
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;

        } finally {
            session.close();
        }
    }

    public FormaDePagamento get(int codigo) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        FormaDePagamento aux;
        try {
            aux = super.get(codigo, session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public FormaDePagamento getByDescricao(String desc) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        FormaDePagamento aux;
        try {
            aux = super.getByDescricao(session, desc);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<FormaDePagamento> getList() {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        List<FormaDePagamento> aux;
        try {
            aux = super.getList(session);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public FormaDePagamento getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            FormaDePagamento aux = super.getPojo(FormaDePagamento.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public List<FormaDePagamento> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, FormaDePagamento.class, SQL, parametros);
    }

    public boolean confereFormaPagamento(FormaDePagamento f) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            return super.confereFormaPagamento(session, f);
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }
    }

    public String getSqlList(Integer inicio, Integer fim) throws Exception {
        String aux = null;
        try {
            aux = super.getSqlLista(inicio, fim);
            return aux;

        } catch (Exception e) {

            throw e;
        }
    }
}
