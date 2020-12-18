/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.financeiro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.financeiro.CentroDeCustos;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class CentroDeCustosRNE extends GenericDAO {

    public CentroDeCustos salvar(EntityManager session, CentroDeCustos centro) throws Exception {
        return super.saveOrUpdatePojo(session, centro);
    }

    public boolean excluir(EntityManager session, CentroDeCustos centro) throws Exception {
        return super.deletePojo(session, centro);
    }

    public CentroDeCustos get(int codigo, EntityManager session) {
        return getPojo(session, CentroDeCustos.class, codigo);
    }

    public List<CentroDeCustos> getList(EntityManager session) throws Exception {
        return super.getPureList(session, CentroDeCustos.class, "Select e from CentroDeCustos e order by e.codCentro");
    }

    public List<CentroDeCustos> getListNome(EntityManager session, CentroDeCustos c) {
        return getPureList(session, CentroDeCustos.class, "select e from CentroDeCustos e where e.descricao  = '" + c.getDescricao() + "' ");
    }

    public boolean confereCentro(EntityManager session, CentroDeCustos c) {
        List<CentroDeCustos> aux = getListNome(session, c);
        if (aux.size() > 0) {
            return false;
        }
        return true;
    }

    public String getSqlLista(Integer inicio, Integer fim) {
        String sql = " select c.codCentro, c.descricao, c.tipo"
                + " from CentroDeCustos as c"
                + " where c.codCentro >=" + inicio + " and c.codCentro <= " + fim
                + " order by c.descricao ";
        return sql;
    }

}
