/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.pedido;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.pedido.Orcamento;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class OrcamentoRNE extends GenericDAO {

    public Orcamento salvar(EntityManager session, Orcamento orcamento) throws Exception {
        return super.saveOrUpdatePojo(session, orcamento);
    }

    public boolean excluir(EntityManager session, Orcamento orcamento) throws Exception {
        return super.deletePojo(session, orcamento);
    }

    public List<Orcamento> getList(EntityManager session, Orcamento lancamento) throws Exception {
        return super.getPureList(session, Orcamento.class, "Select e from Orcamento e");
    }

    public Orcamento get(int codigo, EntityManager session) {
        return getPojo(session, Orcamento.class, codigo);
    }

    public List<Orcamento> getList(EntityManager session) throws Exception {
        return super.getPureList(session, Orcamento.class, "Select e from Orcamento e order by e.codOrcamento");
    }

    public List<Orcamento> getListOrcamento(EntityManager session) throws Exception {
        return super.getPureList(session, Orcamento.class, "Select e from Orcamento e where e.situacao = false  order by e.codOrcamento");
    }

    public List<Orcamento> getListPedido(EntityManager session) throws Exception {
        return super.getPureList(session, Orcamento.class, "Select e from Orcamento e where e.situacao = true order by e.codOrcamento");
    }

    public String getSqlListaOrc(Integer inicio, Integer fim) {
        String sql = "  select cli.codcliente, pes.nome, pes.cnpj, pes.inscestadual, pes.numcasa, pes.uf, pes.cep,pes.email, pes.telefone, "
                + " log.descricao logradouro, bai.descricao bairro, cid.descricao cidade, "
                + " orc.clientesecundario, orc.codorcamento,orc.dataorcamento, orc.validadeorcamento, orc.prazoentrega, orc.formapagamento, orc.clientesecundario,"
                + " orc.enderecosecundario, orc.telefonesecundario, orc.tipodeentrega,  "
                + " prod.codproduto, prod.descricao produto,item.quantprod, item.medida, item.unidade, item.valortotalproduto, item.valorunitario,aca.descricao acabamento "
                + " FROM orcamento orc "
                + " INNER JOIN cliente cli ON cli.codcliente = orc.cliente "
                + " INNER JOIN pessoa pes ON pes.codPessoa = cli.pessoa"
                + " INNER JOIN itemorcamento item ON item.orcamento = orc.codOrcamento "
                + " LEFT JOIN logradouro log ON log.codlogradouro = pes.logradouro "
                + " LEFT JOIN bairro bai ON bai.codbairro = pes.bairro "
                + " LEFT JOIN cidade cid ON cid.codcidade = pes.cidade "
                + " LEFT JOIN produto prod ON prod.codproduto = orc.produto"
                + " LEFT JOIN acabamento aca ON aca.codacabamento = orc.acabamento"
                + " where orc.situacao = false and orc.codOrcamento >=" + inicio + " and orc.codOrcamento <= " + fim
                + " order by pes.nome ";
        return sql;
    }
    
    public String getSqlListaPed(Integer inicio, Integer fim) {
        String sql = "  select cli.codcliente, pes.nome, pes.cnpj, pes.inscestadual, pes.numcasa, pes.uf, pes.cep,pes.email, pes.telefone, "
                + " log.descricao logradouro, bai.descricao bairro, cid.descricao cidade, "
                + " orc.clientesecundario, orc.codorcamento,orc.dataorcamento, orc.validadeorcamento, orc.prazoentrega, orc.formapagamento, orc.clientesecundario,"
                + " orc.enderecosecundario, orc.telefonesecundario, orc.tipodeentrega,  "
                + " prod.codproduto, prod.descricao produto,item.quantprod, item.medida, item.unidade, item.valortotalproduto, item.valorunitario,aca.descricao acabamento "
                + " FROM orcamento orc "
                + " INNER JOIN cliente cli ON cli.codcliente = orc.cliente "
                + " INNER JOIN pessoa pes ON pes.codPessoa = cli.pessoa"
                + " INNER JOIN itemorcamento item ON item.orcamento = orc.codOrcamento "
                + " LEFT JOIN logradouro log ON log.codlogradouro = pes.logradouro "
                + " LEFT JOIN bairro bai ON bai.codbairro = pes.bairro "
                + " LEFT JOIN cidade cid ON cid.codcidade = pes.cidade "
                + " LEFT JOIN produto prod ON prod.codproduto = orc.produto"
                + " LEFT JOIN acabamento aca ON aca.codacabamento = orc.acabamento"
                + " where orc.situacao = true and orc.codOrcamento >=" + inicio + " and orc.codOrcamento <= " + fim
                + " order by pes.nome ";
        return sql;
    }
 

}
