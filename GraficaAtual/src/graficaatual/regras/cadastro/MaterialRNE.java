/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.Material;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class MaterialRNE extends GenericDAO {

    public Material salvar(EntityManager session, Material material) throws Exception {
        return super.saveOrUpdatePojo(session, material);
    }

    public boolean excluir(EntityManager session, Material material) throws Exception {
        return super.deletePojo(session, material);
    }

    public long getNextItem(EntityManager session) throws Exception {
        String q = " select max(e.codMaterial) from Material e ";

        Long ret = getLong(session, q);

        return ret == null ? 1 : ret + 1;
    }

    public Material get(long codigo, EntityManager session) throws Exception {
        String sql = " select e from Material e where e.codMaterial=?1 ";
        return getPojoUnique(session, Material.class, sql, codigo);
    }

    public List<Material> getList(EntityManager session) throws Exception {
        String sql = " select e from Material e order by e.codMaterial";
        return getPureList(session, Material.class, sql);
    }

    public List<Material> getList(EntityManager session, String sql) throws Exception {
        return getPureList(session, Material.class, sql);
    }

    public String getSqlLista(Integer inicio, Integer fim) {

        String sql = "select codmaterial, descricao ,"
                + " case unidademedida when 0 then 'Metro (linear)' when 1 then 'Metro Quadrado(m²)' "
                + " when 2 then 'Unidade (un)' when 3 then 'Peso (kg)' when 4 then 'Litros (l)' end as unidademedida,"
                + " metragemlinear, altura,  largura, unidade,  peso, litro, "
                + " frete,  precocompra, precocustototal, estoqueminimo  "
                + " from material"
                + " where codmaterial>=" + inicio + " and codmaterial <=" + fim
                + " order by descricao asc";

        return sql;
    }
}
