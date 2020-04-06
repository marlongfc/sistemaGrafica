/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO; 
import graficaatual.entidades.Orcamento;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class OrcamentoRNE extends GenericDAO {

    public Orcamento salvar(EntityManager session, Orcamento orcamento) throws Exception {
        return super.saveOrUpdatePojo(session, orcamento);
    }

    public boolean excluir(EntityManager session, Orcamento orcamento) throws Exception {
        return super.deletePojo(session, orcamento);
    }

    public List<Orcamento> getList(EntityManager session, Orcamento lancamento) throws Exception {
        return super.getPureList(session, Orcamento.class, "Select e from Orcamento e");
    }
    
     public Orcamento get(int codigo, EntityManager session) {
        return getPojo(session, Orcamento.class, codigo);
    }

    public List<Orcamento> getList(EntityManager session) throws Exception {
        return super.getPureList(session, Orcamento.class, "Select e from Orcamento e order by e.codOrcamento");
    } 

}
