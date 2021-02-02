/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.financeiro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.financeiro.FormaDePagamento;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class FormaDePagamentoRNE extends GenericDAO {

    public FormaDePagamento salvar(EntityManager session, FormaDePagamento forma) throws Exception {
        return super.saveOrUpdatePojo(session, forma);
    }

    public boolean excluir(EntityManager session, FormaDePagamento forma) throws Exception {
        return super.deletePojo(session, forma);
    }

    public FormaDePagamento get(int codigo, EntityManager session) {
        return getPojo(session, FormaDePagamento.class, codigo);
    }

    public List<FormaDePagamento> getList(EntityManager session) throws Exception {
        
        return super.getPureList(session, FormaDePagamento.class, "Select e from FormaDePagamento e order by e.codForma");
    }

    public List<FormaDePagamento> getListNome(EntityManager session, FormaDePagamento forma) {
        return getPureList(session, FormaDePagamento.class, "select e from FormaDePagamento e where e.descricao  = '" + forma.getDescricao() + "' ");
    }

    public FormaDePagamento getByDescricao(EntityManager session, String desc) {
        return getPojoUnique(session, FormaDePagamento.class, "select e from FormaDePagamento e where e.descricao  = '" + desc + "' ");
    }

    public boolean confereFormaPagamento(EntityManager session, FormaDePagamento forma) {
        List<FormaDePagamento> aux = getListNome(session, forma);
        if (aux.size() > 0) {
            return false;
        }
        return true;
    }
    
    public String getSqlLista(Integer inicio, Integer fim) {
      String sql = " select f.codForma, f.descricao"
                + " from formaDePagamento as f" 
                + " where f.codForma >="+inicio +" and f.codForma <= "+ fim 
                + " order by f.descricao ";
        return sql;
    }

}
