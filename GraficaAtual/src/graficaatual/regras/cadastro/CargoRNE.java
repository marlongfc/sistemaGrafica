/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.Cargo;
import javax.persistence.EntityManager;

/**
 *
 * @author 
 */
public class CargoRNE extends GenericDAO{
    
    public Cargo salvar(EntityManager session, Cargo pessoa) throws Exception{
       return super.saveOrUpdatePojo(session, pessoa);
    }
    
    
}
