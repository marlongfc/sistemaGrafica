/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.Pessoa;
import javax.persistence.EntityManager;

/**
 *
 * @author 
 */
public class PessoaRNE extends GenericDAO{
    
    public Pessoa salvar(EntityManager session, Pessoa pessoa) throws Exception{
       return super.saveOrUpdatePojo(session, pessoa);
    }
    
}
