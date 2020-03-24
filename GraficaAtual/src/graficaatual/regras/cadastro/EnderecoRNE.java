/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.Endereco;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class EnderecoRNE extends GenericDAO {

    public Endereco salvar(EntityManager session, Endereco endereco) throws Exception {
        return super.saveOrUpdatePojo(session, endereco);
    }

    public boolean excluir(EntityManager session, Endereco endereco) throws Exception {
        return super.deletePojo(session, endereco);
    }

    public List<Endereco> getList(EntityManager session, Endereco endereco) throws Exception {
        return super.getPureList(session, Endereco.class, "Select e from Endereco e");
    }
}
