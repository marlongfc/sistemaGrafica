/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.Turno;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class TurnoRNE extends GenericDAO {

    public Turno salvar(EntityManager session, Turno turno) throws Exception {
        return super.saveOrUpdatePojo(session, turno);
    }

    public boolean excluir(EntityManager session, Turno turno) throws Exception {
        return super.deletePojo(session, turno);
    }

    public Turno get(int codigo, EntityManager session) {
        return getPojo(session, Turno.class, codigo);
    }

    public List<Turno> getList(EntityManager session) throws Exception {
        return super.getPureList(session, Turno.class, "Select e from Turno e order by e.codTurno");
    } 
    
      public List<Turno> getListNome(EntityManager session, Turno tur) {
       return getPureList(session,Turno.class, "select t from Turno t where t.descricao  = '"+tur.getDescricao()+"' ");
    }
    
    public boolean confereTurno(EntityManager session, Turno t) {
         List<Turno> aux = getListNome(session,t);
        if( aux.size()> 0){
            return false;
        }
        return true;
    }
    
    
    
    public String getSqlLista(Integer inicio, Integer fim) {
      String sql = " select t.codTurno, t.descricao " 
                + " from Turno as t" 
                + " where t.codTurno >="+inicio +" and t.codTurno <= "+ fim 
                + " order by t.descricao ";
        return sql;
    }
    

}
