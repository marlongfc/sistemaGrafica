/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.financeiro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.financeiro.PlanoDeContas;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class PlanoDeContasRNE extends GenericDAO {

    public PlanoDeContas salvar(EntityManager session, PlanoDeContas plano) throws Exception {
        return super.saveOrUpdatePojo(session, plano);
    }

    public boolean excluir(EntityManager session, PlanoDeContas plano) throws Exception {
        return super.deletePojo(session, plano);
    }

    public PlanoDeContas get(int codigo, EntityManager session) {
        return getPojo(session, PlanoDeContas.class, codigo);
    }

    public List<PlanoDeContas> getList(EntityManager session) throws Exception {
        return super.getPureList(session, PlanoDeContas.class, "Select e from PlanoDeContas e order by e.codPlano");
    }

    public List<PlanoDeContas> getListNome(EntityManager session, PlanoDeContas p) {
        return getPureList(session, PlanoDeContas.class, "select e from PlanoDeContas e where e.descricao  = '" + p.getDescricao() + "' ");
    }

    public boolean conferePlano(EntityManager session, PlanoDeContas c) {
        List<PlanoDeContas> aux = getListNome(session, c);
        if (aux.size() > 0) {
            return false;
        }
        return true;
    }

    public String getSqlLista(Integer inicio, Integer fim) {
        String sql = " select p.codPlano, p.descricao, c.descricao, c.tipo "
                + " from PlanoDeContas as p "
                + " inner join CentroDeCustos c On c.codcentro = p.centro "
                + " where p.codPlano >=" + inicio + " and p.codPlano <= " + fim
                + " order by p.descricao ";
        return sql;
    }

}
