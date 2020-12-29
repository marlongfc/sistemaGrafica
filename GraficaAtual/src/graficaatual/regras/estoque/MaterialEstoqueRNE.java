/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.estoque;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.estoque.MaterialEstoque;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class MaterialEstoqueRNE extends GenericDAO {

    public MaterialEstoque salvar(EntityManager session, MaterialEstoque material) throws Exception {
        return super.saveOrUpdatePojo(session, material);
    }

    public boolean excluir(EntityManager session, MaterialEstoque material) throws Exception {
        return super.deletePojo(session, material);
    }

    public long getNextItem(EntityManager session) throws Exception {
        String q = " select max(e.codMaterialEstoque) from MaterialEstoque e ";

        Long ret = getLong(session, q);

        return ret == null ? 1 : ret + 1;
    }

    public MaterialEstoque get(long codigo, EntityManager session) throws Exception {
        String sql = " select e from MaterialEstoque e where e.codMaterialEstoque=?1 ";
        return getPojoUnique(session, MaterialEstoque.class, sql, codigo);
    }
    
      public MaterialEstoque getByMaterial(long codigo, EntityManager session) throws Exception {
        String sql = " select e from MaterialEstoque e where e.material=?1 ";
        return getPojoUnique(session, MaterialEstoque.class, sql, codigo);
    }


    public List<MaterialEstoque> getList(EntityManager session) throws Exception {
        String sql = " select e from MaterialEstoque e order by e.codMaterialEstoque";
        return getPureList(session, MaterialEstoque.class, sql);
    }

    public List<MaterialEstoque> getList(EntityManager session, String sql) throws Exception {
        return getPureList(session, MaterialEstoque.class, sql);
    }

    public String getSqlLista(Integer inicio, Integer fim) {

        String sql = "select m.codmaterial, m.descricao ,"
                + " case m.unidademedida when 0 then 'Metro (linear)' when 1 then 'Metro Quadrado(m²)' "
                + " when 2 then 'Unidade (un)' when 3 then 'Peso (kg)' when 4 then 'Litros (l)' end as unidademedida,"
                + " quantidadeReal, quantidadeAprovisionada, f.descricao as nomeFornecedor "
                + " from materialEstoque me"
                + " inner join Fornecedor f on f.codFornecedor = me.fornecedor "
                + " inner join Material m on m.codMaterial = me.material "
                + " where m.codmaterial>=" + inicio + " and m.codmaterial<=" + fim
                + " order by e.descricao asc";

        return sql;
    }
}
