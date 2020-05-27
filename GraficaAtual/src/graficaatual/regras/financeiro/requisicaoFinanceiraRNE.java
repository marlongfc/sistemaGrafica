/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.financeiro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.financeiro.RequisicaoFinanceira;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class requisicaoFinanceiraRNE extends GenericDAO {

    public RequisicaoFinanceira salvar(EntityManager session, RequisicaoFinanceira req) throws Exception {
        return super.saveOrUpdatePojo(session, req);
    }

    public boolean excluir(EntityManager session, RequisicaoFinanceira req) throws Exception {
        return super.deletePojo(session, req);
    }

    public RequisicaoFinanceira get(int codigo, EntityManager session) {
        return getPojo(session, RequisicaoFinanceira.class, codigo);
    }

    public List<RequisicaoFinanceira> getList(EntityManager session) throws Exception {
        return super.getPureList(session, RequisicaoFinanceira.class, "Select e from RequisicaoFinanceira e order by e.codRequisicao");
    }
    
     public List<RequisicaoFinanceira> getListNome(EntityManager session, RequisicaoFinanceira req) {
        return getPureList(session, RequisicaoFinanceira.class, "select e from RequisicaoFinanceira e where e.descricao  = '" + req.getDescricao() + "' ");
    }

    public boolean confereRequisicao(EntityManager session, RequisicaoFinanceira req) {
        List<RequisicaoFinanceira> aux = getListNome(session, req);
        if (aux.size() > 0) {
            return false;
        }
        return true;
    }
    
     public String getSqlLista(Integer inicio, Integer fim) {
      String sql = " select r.codRequisicao, r.descricao, r.quantidade, r.valor"  
                + " from requisicaofinanceira as r" 
                + " where r.codRequisicao >="+inicio +" and r.codRequisicao <= "+ fim 
                + " order by r.descricao ";
        return sql;
    }  

}
