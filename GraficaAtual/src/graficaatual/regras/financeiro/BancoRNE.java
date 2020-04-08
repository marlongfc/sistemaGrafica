/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.financeiro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.Banco;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class BancoRNE extends GenericDAO {

    public Banco salvar(EntityManager session, Banco banco) throws Exception {
        return super.saveOrUpdatePojo(session, banco);
    }

    public boolean excluir(EntityManager session, Banco banco) throws Exception {
        return super.deletePojo(session, banco);
    }

    public Banco get(int codigo, EntityManager session) {
        return getPojo(session, Banco.class, codigo);
    }

    public List<Banco> getList(EntityManager session) throws Exception {
        return super.getPureList(session, Banco.class, "Select e from Banco e order by e.codBanco");
    }

    public List<Banco> getListNome(EntityManager session, Banco ban) {
        return getPureList(session, Banco.class, "select t from Banco t where t.descricao  = '" + ban.getDescricao() + "' ");
    }

    public boolean confereBanco(EntityManager session, Banco ban) {
        List<Banco> aux = getListNome(session, ban);
        if (aux.size() > 0) {
            return false;
        }
        return true;
    }

}
