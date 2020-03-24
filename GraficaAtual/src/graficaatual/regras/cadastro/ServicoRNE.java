/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.Servico;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class ServicoRNE extends GenericDAO {

    public Servico salvar(EntityManager session, Servico servico) throws Exception {
        return super.saveOrUpdatePojo(session, servico);
    }

    public boolean excluir(EntityManager session, Servico servico) throws Exception {
        return super.deletePojo(session, servico);
    }

    public List<Servico> getList(EntityManager session, Servico servico) throws Exception {
        return super.getPureList(session, Servico.class, "Select e from Servico e");
    }
}
