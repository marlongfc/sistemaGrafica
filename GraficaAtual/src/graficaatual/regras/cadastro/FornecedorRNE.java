/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.Fornecedor;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author 
 */
public class FornecedorRNE extends GenericDAO{
    
    public Fornecedor salvar(EntityManager session, Fornecedor fornecedor) throws Exception {
        return super.saveOrUpdatePojo(session, fornecedor);
    }

    public boolean excluir(EntityManager session, Fornecedor cliente) throws Exception {
        return super.deletePojo(session, cliente);
    }

    public List<Fornecedor> getList(EntityManager session, Fornecedor cliente) throws Exception {
        return super.getPureList(session, Fornecedor.class, "Select e from Fornecedor e");
    }
    
     public Fornecedor get(long codigo, EntityManager session) throws Exception {
        String sql = " select e from Fornecedor e where e.codFornecedor=?1 ";
        return getPojoUnique(session, Fornecedor.class, sql, codigo);
    }

    public String getSqlLista(Integer inicio, Integer fim) {
      String sql = " select c.codFornecedor as codigo,"
                + " case when c.ativo is true then 'SIM' else 'NÃO' end ativo,"
                + " p.cnpj as cpf, "
                + " p.nome as nome,"
                + " p.nomeFantasia as fantasia,"
                + " p.telefone as telefone"
                + " from Fornecedor as c"
                + " left join pessoa as p on (c.pessoa = p.codpessoa)"
                + " where c.codFornecedor >="+inicio +" and c.codFornecedor <= "+ fim 
                + " order by ativo desc, nome ";
        return sql;
    }
    
    
}
