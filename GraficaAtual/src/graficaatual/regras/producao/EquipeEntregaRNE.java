/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.producao;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.ControleAcesso;
import graficaatual.entidades.producao.EquipeEntrega;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author 
 */
public class EquipeEntregaRNE extends GenericDAO{
    
    public EquipeEntrega salvar(EntityManager session, EquipeEntrega cliente) throws Exception {
        return super.saveOrUpdatePojo(session, cliente);
    }

    public boolean excluir(EntityManager session, EquipeEntrega cliente) throws Exception {
        return super.deletePojo(session, cliente);
    }

    public List<EquipeEntrega> getList(EntityManager session) throws Exception {
        return super.getPureList(session, EquipeEntrega.class, "Select e from EquipeEntrega e where e.dataCancelamento is null order by e.codEquipeEntrega ");
    }
    
     public EquipeEntrega get(Integer codigo, EntityManager session) throws Exception {
        String sql = " select e from EquipeEntrega e where e.codEquipeEntrega=?1 ";
        return getPojoUnique(session, EquipeEntrega.class, sql, codigo);
    }   
    
}
