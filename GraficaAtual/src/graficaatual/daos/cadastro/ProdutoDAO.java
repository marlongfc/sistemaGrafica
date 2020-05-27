/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.cadastro;

import graficaatual.entidades.Produto;
import graficaatual.regras.cadastro.ProdutoRNE;
import graficaatual.utilitarios.Persistencia;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class ProdutoDAO extends ProdutoRNE {

    public Produto salvar(Produto produto) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Produto aux = null;
        try {
            aux = super.salvar(session, produto);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();

        }

    }

    public void delete(Produto l) throws Exception {

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

    public Produto getPorCodigo(long codigo) throws Exception {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {
            return super.get(codigo, session);

        } catch (Exception e) {
            e.printStackTrace();
            session.close();
            return null;
        } finally {
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

    public List<Produto> getList() throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {
            return super.getList(session);
        } finally {
            session.close();
        }
    }

    public List<Produto> getList(String sql) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {
            return super.getList(session, sql);
        } finally {
            session.close();
        }
    }

    public List<Produto> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, Produto.class, SQL, parametros);
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

    public String getSqlListPorProduto(Long cod) throws Exception {

        try {
            return super.getSqlListaPorProduto(cod);

        } catch (Exception e) {

            throw e;
        }
    }

    public String getSqlListagem(Integer inicio, Integer fim) throws Exception {

        try {
            return super.getSqlListagemProdutos(inicio, fim);

        } catch (Exception e) {

            throw e;
        }
    }

}
