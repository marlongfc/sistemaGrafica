/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.pedido;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.pedido.ItemOrcamento;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class ItemOrcamentoRNE extends GenericDAO {

    public ItemOrcamento salvar(EntityManager session, ItemOrcamento item) throws Exception {
        return super.saveOrUpdatePojo(session, item);
    }

    public boolean excluir(EntityManager session, ItemOrcamento item) throws Exception {
        return super.deletePojo(session, item);
    }

    public List<ItemOrcamento> getList(EntityManager session, ItemOrcamento item) throws Exception {
        return super.getPureList(session, ItemOrcamento.class, "Select e from ItemOrcamento e");
    }

    public ItemOrcamento get(int codigo, EntityManager session) {
        return getPojo(session, ItemOrcamento.class, codigo);
    }

    public List<ItemOrcamento> getList(EntityManager session) throws Exception {
        return super.getPureList(session, ItemOrcamento.class, "Select e from ItemOrcamento e order by e.codItemOrca");
    }

    public List<ItemOrcamento> getListOrcamento(EntityManager session, Integer codOrca) throws Exception {
        String sql = " SELECT e FROM ItemOrcamento e INNER JOIN orcamento o ON o.codOrcamento = e.orcamento WHERE e.orcamento.codOrcamento = " + codOrca + " order by e.orcamento.codOrcamento";
        return getPureList(session, ItemOrcamento.class, sql); 
    }
    

}
