/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.financeiro;

import graficaatual.daos.GenericDAO; 
import graficaatual.entidades.financeiro.ContasAReceber;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class ContasAReceberRNE extends GenericDAO {

    public ContasAReceber salvar(EntityManager session, ContasAReceber contas) throws Exception {
        return super.saveOrUpdatePojo(session, contas);
    }

    public boolean excluir(EntityManager session, ContasAReceber contas) throws Exception {
        return super.deletePojo(session, contas);
    }

    public ContasAReceber get(int codigo, EntityManager session) {
        return getPojo(session, ContasAReceber.class, codigo);
    }

    public List<ContasAReceber> getList(EntityManager session) throws Exception {
        return super.getPureList(session, ContasAReceber.class, "Select e from ContasAReceber e order by e.codContasRec");
    }
    
     public List<ContasAReceber> getList2(EntityManager session) throws Exception {
        return super.getPureList(session, ContasAReceber.class, "Select e from ContasAReceber e where e.dataPagamento is null order by e.codContasRec");
    }

    public List<ContasAReceber> getListNome(EntityManager session, ContasAReceber conta) {
        return getPureList(session, ContasAReceber.class, "select t from ContasAReceber t where t.descricao  = '" + conta.getDescricao() + "' ");
    }

    public boolean confereContas(EntityManager session, ContasAReceber c) {
        List<ContasAReceber> aux = getListNome(session, c);
        if (aux.size() > 0) {
            return false;
        }
        return true;
    }

    public String getSqlLista(Integer inicio, Integer fim) {
        String sql = " select c.codContasRec, c.descricao"
                + " from ContasAReceber as c"
                + " where c.codContasRec >=" + inicio + " and c.codContasRec <= " + fim
                + " order by c.descricao ";
        return sql;
    }

}
