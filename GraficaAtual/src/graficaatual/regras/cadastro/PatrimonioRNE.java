/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.Patrimonio;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class PatrimonioRNE extends GenericDAO {

    public Patrimonio salvar(EntityManager session, Patrimonio pat) throws Exception {
        return super.saveOrUpdatePojo(session, pat);
    }

    public boolean excluir(EntityManager session, Patrimonio pat) throws Exception {
        return super.deletePojo(session, pat);
    }

    public Patrimonio get(int codigo, EntityManager session) {
        return getPojo(session, Patrimonio.class, codigo);
    }

    public List<Patrimonio> getList(EntityManager session) throws Exception {
        return super.getPureList(session, Patrimonio.class, "Select e from Patrimonio e order by e.codPatrimonio");
    }

    public List<Patrimonio> getListNome(EntityManager session, Patrimonio pat) {
        return getPureList(session, Patrimonio.class, "select t from Patrimonio t where t.descricao  = '" + pat.getDescricao() + "' ");
    }

    public boolean conferePatrimonio(EntityManager session, Patrimonio t) {
        List<Patrimonio> aux = getListNome(session, t);
        if (aux.size() > 0) {
            return false;
        }
        return true;
    }

    public String getSqlLista(Integer inicio, Integer fim) {
        String sql = " select p.codPatrimonio, p.descricao "
                + " from Patrimonio as p"
                + " where p.codPatrimonio >=" + inicio + " and p.codPatrimonio <= " + fim
                + " order by p.descricao ";
        return sql;
    }

}
