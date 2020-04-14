/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.ComposicaoProduto;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class ComposicaoProdutoRNE extends GenericDAO {

    public ComposicaoProduto salvar(EntityManager session, ComposicaoProduto composicaoProduto) throws Exception {
        return super.saveOrUpdatePojo(session, composicaoProduto);
    }

    public boolean excluir(EntityManager session, ComposicaoProduto composicaoProduto) throws Exception {
        return super.deletePojo(session, composicaoProduto);
    }
    
    
    
    
      public long getNextItem(EntityManager session) throws Exception {
        String q = " select max(e.codComposicaoProduto), max(e.produto) from ComposicaoProduto e ";

        Long ret = getLong(session, q);

        return ret == null ? 1 : ret + 1;
    }
    
      public ComposicaoProduto getPorCodComposicao(long codigo, EntityManager session) throws Exception {
        String sql = " select e from ComposicaoProduto e where e.codComposicaoProduto=?1 ";
        return getPojoUnique(session, ComposicaoProduto.class, sql, codigo);
    }
     
      
      
      public ComposicaoProduto getPorMaterial(long codigo, EntityManager session) throws Exception {
        String sql = " select e from ComposicaoProduto e where e.material=?1 ";
        return getPojoUnique(session, ComposicaoProduto.class, sql, codigo);
    }
      
     
      
     public List<ComposicaoProduto> getListPorProduto(long codigo, EntityManager session) throws Exception {
        String sql = " select e from ComposicaoProduto e where e.produto=?1 order by e.material.descMaterial asc";
        return getPureList(session, ComposicaoProduto.class, sql, codigo);
    }
     
     
      public List<ComposicaoProduto> getList(EntityManager session) throws Exception {
        String sql = " select e from ComposicaoProduto e order by e.codComposicaoProduto";
        return getPureList(session, ComposicaoProduto.class, sql);
    }

    public List<ComposicaoProduto> getList(EntityManager session, String sql) throws Exception {
        return getPureList(session, ComposicaoProduto.class, sql);
    }
}
