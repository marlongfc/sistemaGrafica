/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.estoque;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.estoque.SaidaEstoque;
import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class SaidaEstoqueRNE extends GenericDAO {

    public SaidaEstoque salvar(EntityManager session, SaidaEstoque saidaEstoque) throws Exception {
        return super.saveOrUpdatePojo(session, saidaEstoque);
    }

    public boolean excluir(EntityManager session, SaidaEstoque saidaEstoque) throws Exception {
        return super.deletePojo(session, saidaEstoque);
    }

    public long getNextItem(EntityManager session) throws Exception {
        String q = " select max(e.codSaidaEstoque) from SaidaEstoque e ";

        Long ret = getLong(session, q);

        return ret == null ? 1 : ret + 1;
    }

    public SaidaEstoque get(long codigo, EntityManager session) throws Exception {
        String sql = " select e from SaidaEstoque e where e.codSaidaEstoque=?1 ";
        return getPojoUnique(session, SaidaEstoque.class, sql, codigo);
    }
    
      public SaidaEstoque getByMaterial(long codigo, EntityManager session) throws Exception {
        String sql = " select e from SaidaEstoque e where e.codMaterial=?1 ";
        return getPojoUnique(session, SaidaEstoque.class, sql, codigo);
    }


    public List<SaidaEstoque> getList(EntityManager session) throws Exception {
        String sql = " select e from SaidaEstoque e order by e.codSaidaEstoque";
        return getPureList(session, SaidaEstoque.class, sql);
    }

    public List<SaidaEstoque> getList(EntityManager session, String sql) throws Exception {
        return getPureList(session, SaidaEstoque.class, sql);
    }

    public String getSqlLista(Date inicio, Date fim) {

        String sql = "select e.codsaidaEstoque as codigo,"
                + " case e.tipoSaida when 1 then 'Pedido/Produção' when 2 then 'Venda Avulsa' "
                + " when 3 then 'Descarte' when 4 then 'Doação' end as tipoSaida,"
                + " e.valorVendaAvulsa as valorVenda,"
                + " e.quantidade as quantidade, e.observacao as observacao, "
                + " l.codLocalArmazenamento as codLocalArmazenamento, l.descricao as descLocalArmazenamento,"
                + " m.codMaterial as codMaterial, m.descricao as descMaterial, "
                + " f.codFornecedor as codFornecedor, f.descricao as descFornecedor "
                + " from saidaEstoqueEstoque e"
                + " inner join Fornecedor f on f.codFornecedor = e.codFornecedor "
                + " inner join Material m on m.codMaterial = e.codMaterial "
                + " inner join LocalArmazenamento l on l.codLocalArmazenamento= m.codLocalArmazenamento"
                + " where e.dataCadastro>=" + inicio + " and e.dataCadastro<=" + fim
                + " order by e.descricao asc";

        return sql;
    }
}
