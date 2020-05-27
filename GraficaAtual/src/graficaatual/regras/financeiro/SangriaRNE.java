/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.financeiro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.financeiro.Sangria;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class SangriaRNE extends GenericDAO {

    public Sangria salvar(EntityManager session, Sangria sangria) throws Exception {
        return super.saveOrUpdatePojo(session, sangria);
    }

    public boolean excluir(EntityManager session, Sangria sangria) throws Exception {
        return super.deletePojo(session, sangria);
    }

    public Sangria get(int codigo, EntityManager session) {
        return getPojo(session, Sangria.class, codigo);
    }

    public List<Sangria> getList(EntityManager session) throws Exception {
        return super.getPureList(session, Sangria.class, "Select e from Sangria e order by e.codSangria");
    }
    
     public List<Sangria> getListNome(EntityManager session, Sangria san) {
        return getPureList(session, Sangria.class, "select e from Sangria e where e.descricao  = '" + san.getDescricao() + "' ");
    }

    public boolean confereSangria(EntityManager session, Sangria san) {
        List<Sangria> aux = getListNome(session, san);
        if (aux.size() > 0) {
            return false;
        }
        return true;
    }
    
    public String getSqlLista(Integer inicio, Integer fim) {
      String sql = " select s.codSangria, s.descricao, s.valor"  
                + " from Sangria as s" 
                + " where s.codSangria >="+inicio +" and s.codSangria <= "+ fim 
                + " order by s.descricao ";
        return sql;
    }  

}
