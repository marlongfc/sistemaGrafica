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

    public String getSqlListaPorProduto(Long codigoParam) {

        String sql = "select p.codproduto as codProduto, p.descricao as descProduto, "
                + " p.valorprodutom2 as  valorProdutom2,"
                + " p.maodeobra as maoDeObraProd, p.custoempresa as custoEmpresa, p.custototal as custoTotalProd, "
                + " p.margemlucro as margemLucroProd, p.valorunitario as valorUnitarioTotalProd, "
                + " "
                + " m.codmaterial as codMaterial, m.descricao as descMaterial,"
                + " "
                + " c.metragemlinear as metragemLinearComp, c.altura as alturaComp, c.largura as larguraComp,"
                + " c.unidade as unidadeComp, c.peso as pesoComp, c.litro as litroComp, "
                + " c.customaterial as custoPorMaterialComp "
                + " "
                + " from produto as p "
                + " inner join composicaoproduto c on c.produto = p.codproduto "
                + " inner join material m on m.codmaterial = c.material"
                + " where p.codProduto=" + codigoParam;

        return sql;
    }

    public String getSqlListagemProdutos(Integer inicio, Integer fim) {

        String sql = "select p.codproduto as codProduto, p.descricao as descProduto, "
                + " p.valorprodutom2 as valorProdutom2, "
                + " p.maodeobra as maoDeObraProd, p.custoempresa as custoEmpresa, "
                + " p.custototal as custoTotalProd, "
                + " p.margemlucro as margemLucroProd, "
                + " p.valorunitario as valorUnitarioTotalProd "
                + " from produto as p " 
                + " where p.codProduto>=" + inicio + " and p.codProduto <=" + fim
                + "order by descProduto asc";
        return sql;
    }

}
