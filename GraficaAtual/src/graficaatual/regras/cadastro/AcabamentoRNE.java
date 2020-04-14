/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

 
import graficaatual.daos.GenericDAO; 
import graficaatual.entidades.Acabamento;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class AcabamentoRNE extends GenericDAO {

    public Acabamento salvar(EntityManager session, Acabamento a) throws Exception {
        return super.saveOrUpdatePojo(session, a);
    }

    public boolean excluir(EntityManager session, Acabamento a) throws Exception {
        return super.deletePojo(session, a);
    }

    public Acabamento get(int codigo, EntityManager session) {
        return getPojo(session, Acabamento.class, codigo);
    }

    public List<Acabamento> getList(EntityManager session) throws Exception {
        return super.getPureList(session, Acabamento.class, "Select e from Acabamento e order by e.codAcabamento");
    }
    
     public List<Acabamento> getListNome(EntityManager session, Acabamento a) {
        return getPureList(session, Acabamento.class, "select e from Acabamento e where e.descricao  = '" + a.getDescricao() + "' ");
    }

    public boolean confereAcabamento(EntityManager session, Acabamento a) {
        List<Acabamento> aux = getListNome(session, a);
        if (aux.size() > 0) {
            return false;
        }
        return true;
    }

}
