/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.cadsatro;

import graficaatual.entidades.Pessoa;
import graficaatual.regras.cadastro.PessoaRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Projeto X
 */
public class PessoaDAO extends PessoaRNE {
    
    public Pessoa addUsuario(Pessoa pessoa) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        Pessoa aux = null;
        try {
            aux = super.salvar(session, pessoa);
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
    
    public Pessoa altera(Pessoa obj) {
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

    public void delete(Pessoa obj) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            session.getTransaction().begin();
            super.delete(session,obj);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public Pessoa get(Long cod) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            Pessoa aux = super.getPojo(Pessoa.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }
    
    
    public Pessoa getByCnpj(String cnpj) {
        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        try {
            Pessoa aux = super.getPojoUnique(Pessoa.class,"select e from Pessoa e where "
                    + "  REPLACE(REPLACE(REPLACE(trim(e.cnpj),'.',''),'-',''),' ', '') like ?1 order by e.cnpj", cnpj);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }
    
     public List<Pessoa> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, Pessoa.class, SQL, parametros);
    }

  
}
