/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.Logradouro;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class LogradouroRNE extends GenericDAO {

    public Logradouro salvar(EntityManager session, Logradouro logradouro) throws Exception {
        return super.saveOrUpdatePojo(session, logradouro);
    }

    public boolean excluir(EntityManager session, Logradouro logradouro) throws Exception {
        return super.deletePojo(session, logradouro);
    }

    public List<Logradouro> getList(EntityManager session, Logradouro logradouro) throws Exception {
        return super.getPureList(session, Logradouro.class, "Select e from Logradouro e");
    }
}
