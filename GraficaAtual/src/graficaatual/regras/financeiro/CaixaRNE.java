/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.financeiro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.financeiro.Caixa;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class CaixaRNE extends GenericDAO {

    public Caixa salvar(EntityManager session, Caixa caixa) throws Exception {
        return super.saveOrUpdatePojo(session, caixa);
    }

    public boolean excluir(EntityManager session, Caixa caixa) throws Exception {
        return super.deletePojo(session, caixa);
    }

    public Caixa get(int codigo, EntityManager session) {
        return getPojo(session, Caixa.class, codigo);
    }

    public List<Caixa> getList(EntityManager session) throws Exception {
        return super.getPureList(session, Caixa.class, "Select e from Caixa e order by e.codCaixa");
    }

    public List<Caixa> getListNome(EntityManager session, Caixa cai) {
        return getPureList(session, Caixa.class, "select t from Caixa t where t.descricao  = '" + cai.getDescricao() + "' ");
    }

    public boolean confereCaixa(EntityManager session, Caixa cai) {
        List<Caixa> aux = getListNome(session, cai);
        if (aux.size() > 0) {
            return false;
        }
        return true;
    }

    public String getSqlLista(Integer inicio, Integer fim) {
        String sql = " select c.codCaixa, c.descricao"
                + " from Caixa as c"
                + " where c.codCaixa >=" + inicio + " and c.codCaixa <= " + fim
                + " order by c.descricao ";
        return sql;
    }

}
