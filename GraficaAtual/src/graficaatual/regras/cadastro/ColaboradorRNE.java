/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.Colaborador;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author 
 */
public class ColaboradorRNE extends GenericDAO{
    

    public Colaborador salvar(EntityManager session, Colaborador colaborador) throws Exception {
        return super.saveOrUpdatePojo(session, colaborador);
    }

    public boolean excluir(EntityManager session, Colaborador colaborador) throws Exception {
        return super.deletePojo(session, colaborador);
    }

    public List<Colaborador> getList(EntityManager session, Colaborador colaborador) throws Exception {
        return super.getPureList(session, Colaborador.class, "Select e from Colaborador e");
    }
    
    public Colaborador get(int codigo, EntityManager session) throws Exception {
        return super.getPojo(session, Colaborador.class, codigo);
    }
    
    
}
