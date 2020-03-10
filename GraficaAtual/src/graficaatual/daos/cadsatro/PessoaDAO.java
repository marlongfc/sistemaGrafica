/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.cadsatro;

import graficaatual.entidades.Pessoa;
import graficaatual.regras.cadastro.PessoaRNE;
import graficaatual.utilitarios.Persistencia;
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

  
}
