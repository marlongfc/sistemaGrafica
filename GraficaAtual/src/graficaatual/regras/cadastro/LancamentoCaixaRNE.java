/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.LancamentoCaixa;
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

    public List<LancamentoCaixa> getList(EntityManager session, LancamentoCaixa lancamento) throws Exception {
        return super.getPureList(session, LancamentoCaixa.class, "Select e from LancamentoCaixa e");
    }
}
