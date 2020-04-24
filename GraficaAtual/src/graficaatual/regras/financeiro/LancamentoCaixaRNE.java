/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.financeiro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.financeiro.LancamentoCaixa;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class LancamentoCaixaRNE extends GenericDAO {

    public LancamentoCaixa salvar(EntityManager session, LancamentoCaixa lancamento) throws Exception {
        return super.saveOrUpdatePojo(session, lancamento);
    }

    public boolean excluir(EntityManager session, LancamentoCaixa lancamento) throws Exception {
        return super.deletePojo(session, lancamento);
    }
    
     public LancamentoCaixa get(int codigo, EntityManager session) {
        return getPojo(session, LancamentoCaixa.class, codigo);
    }

    public List<LancamentoCaixa> getList(EntityManager session) throws Exception {
        return super.getPureList(session, LancamentoCaixa.class, "Select e from LancamentoCaixa e order by e.codLancamento");
    }  
    
      public List<LancamentoCaixa> getListNome(EntityManager session, LancamentoCaixa lan) {
        return getPureList(session, LancamentoCaixa.class, "select e from LancamentoCaixa e where e.descricao  = '" + lan.getDescricao() + "' ");
    }

    public boolean confereLancamento(EntityManager session, LancamentoCaixa lan) {
        List<LancamentoCaixa> aux = getListNome(session, lan);
        if (aux.size() > 0) {
            return false;
        }
        return true;
    }
}
