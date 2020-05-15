/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.relatorio;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.relatorio.TextoPadrao;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @Danilo
 */
public class TextoPadraoRNE extends GenericDAO{
    
    public TextoPadrao salvar(EntityManager session, TextoPadrao entidade) throws Exception {
        return super.saveOrUpdatePojo(session, entidade);
    }

    public boolean excluir(EntityManager session, TextoPadrao entidade) throws Exception {
        return super.deletePojo(session, entidade);
    }

    public List<TextoPadrao> getList(EntityManager session, TextoPadrao entidade) throws Exception {
        return super.getPureList(session, TextoPadrao.class, "Select e from TextoPadrao e");
    }
    
     public TextoPadrao get(long codigo, EntityManager session) throws Exception {
        String sql = " select e from TextoPadrao e where e.codEntidade=?1 ";
        return getPojoUnique(session, TextoPadrao.class, sql, codigo);
    }
    
    
}
