/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.Produto;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class ProdutoRNE extends GenericDAO {

    public Produto salvar(EntityManager session, Produto produto) throws Exception {
        return super.saveOrUpdatePojo(session, produto);
    }

    public boolean excluir(EntityManager session, Produto produto) throws Exception {
        return super.deletePojo(session, produto);
    }

    public List<Produto> getList(EntityManager session, Produto produto) throws Exception {
        return super.getPureList(session, Produto.class, "Select e from Produto e");
    }
    
     public long getNextItem(EntityManager session) throws Exception {
        String q = " select max(e.codProduto) from Produto e ";

        Long ret = getLong(session, q);

        return ret == null ? 1 : ret + 1;
    }
    
     public Produto get(long codigo, EntityManager session) throws Exception {
        String sql = " select e from Produto e where e.codProduto=?1 ";
        return getPojoUnique(session, Produto.class, sql, codigo);
    }
     
      public List<Produto> getList(EntityManager session) throws Exception {
        String sql = " select e from Produto e order by e.codProduto";
        return getPureList(session, Produto.class, sql);
    }

    public List<Produto> getList(EntityManager session, String sql) throws Exception {
        return getPureList(session, Produto.class, sql);
    }
}
