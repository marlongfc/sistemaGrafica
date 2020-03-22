/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.Cidade;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class CidadeRNE extends GenericDAO {

    public Cidade salvar(EntityManager session, Cidade cidade) throws Exception {
        return super.saveOrUpdatePojo(session, cidade);
    }

    public boolean excluir(EntityManager session, Cidade cidade) throws Exception {
        return super.deletePojo(session, cidade);
    }

    public List<Cidade> getList(EntityManager session, Cidade cidade) throws Exception {
        return super.getPureList(session, Cidade.class, "Select e from Cidade e");
    }
}
