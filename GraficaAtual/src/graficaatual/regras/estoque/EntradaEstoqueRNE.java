/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.estoque;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.estoque.EntradaEstoque;
import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class EntradaEstoqueRNE extends GenericDAO {

    public EntradaEstoque salvar(EntityManager session, EntradaEstoque entradaEstoque) throws Exception {
        return super.saveOrUpdatePojo(session, entradaEstoque);
    }

    public boolean excluir(EntityManager session, EntradaEstoque entradaEstoque) throws Exception {
        return super.deletePojo(session, entradaEstoque);
    }
    
    public Boolean insere(EntityManager session, EntradaEstoque entradaEstoque) throws Exception {
        return super.savePojo(session, entradaEstoque);
    }

    public long getNextItem(EntityManager session) throws Exception {
        String q = " select max(e.codEntradaEstoque) from EntradaEstoque e ";

        Long ret = getLong(session, q);

        return ret == null ? 1 : ret + 1;
    }

    public EntradaEstoque get(long codigo, EntityManager session) throws Exception {
        String sql = " select e from EntradaEstoque e where e.codEntradaEstoque=?1 ";
        return getPojoUnique(session, EntradaEstoque.class, sql, codigo);
    }
        
     public List<EntradaEstoque> getListPorMaterial(long codMaterial, EntityManager session) throws Exception {
        String sql = " select e from EntradaEstoque e where e.codMaterial=?1 ";
        return getPureList(session, EntradaEstoque.class, sql);
    }


    public List<EntradaEstoque> getList(EntityManager session) throws Exception {
        String sql = " select e from EntradaEstoque e order by e.codEntradaEstoque";
        return getPureList(session, EntradaEstoque.class, sql);
    }

    public List<EntradaEstoque> getList(EntityManager session, String sql) throws Exception {
        return getPureList(session, EntradaEstoque.class, sql);
    }

    public String getSqlLista(Date inicio, Date fim) {

        String sql = "select e.codentradaEstoque as codigo,"
                + " case e.tipoEntrada when 1 then 'Compra' when 2 then 'Devolução' "
                + " when 3 then 'Reaproveitamento' when 4 then 'Doação' end as tipoEntrada,"
                + " e.notaFiscal as notaFiscal, e.valorCompra as valorCompra,"
                + " e.quantidade as quantidade, e.observacao as observacao, "
                + " l.codLocalArmazenamento as codLocalArmazenamento, l.descricao as descLocalArmazenamento,"
                + " m.codMaterial as codMaterial, m.descricao as descMaterial, "
                + " f.codFornecedor as codFornecedor, f.descricao as descFornecedor "
                + " from entradaEstoqueEstoque e"
                + " inner join Fornecedor f on f.codFornecedor = e.codFornecedor "
                + " inner join Material m on m.codMaterial = e.codMaterial "
                + " inner join LocalArmazenamento l on l.codLocalArmazenamento= e.codLocalArmazenamento"
                + " where e.dataCadastro>=" + inicio + " and e.dataCadastro<=" + fim
                + " order by e.descricao asc";

        return sql;
    }
}
