/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.financeiro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.financeiro.ContasAPagar;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class ContasAPagarRNE extends GenericDAO {

    public ContasAPagar salvar(EntityManager session, ContasAPagar contas) throws Exception {
        return super.saveOrUpdatePojo(session, contas);
    }

    public boolean excluir(EntityManager session, ContasAPagar contas) throws Exception {
        return super.deletePojo(session, contas);
    }

    public ContasAPagar get(int codigo, EntityManager session) {
        return getPojo(session, ContasAPagar.class, codigo);
    }

    public List<ContasAPagar> getList(EntityManager session) throws Exception {
        return super.getPureList(session, ContasAPagar.class, "Select e from ContasAPagar e order by e.codContasPag");
    }

    public List<ContasAPagar> getListNome(EntityManager session, ContasAPagar conta) {
        return getPureList(session, ContasAPagar.class, "select t from ContasAPagar t where t.descricao  = '" + conta.getDescricao() + "' ");
    }

    public boolean confereContaAPagar(EntityManager session, ContasAPagar c) {
        List<ContasAPagar> aux = getListNome(session, c);
        if (aux.size() > 0) {
            return false;
        }
        return true;
    }

    public String getSqlLista(Integer inicio, Integer fim) {
        String sql = " select c.codContasPag, c.descricao"
                + " from ContasAPagar as c"
                + " where c.codContasPag >=" + inicio + " and c.codContasPag <= " + fim
                + " order by c.descricao ";
        return sql;
    }

}
