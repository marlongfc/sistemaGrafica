/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.Cliente;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author 
 */
public class ClienteRNE extends GenericDAO{
    
    public Cliente salvar(EntityManager session, Cliente cliente) throws Exception {
        return super.saveOrUpdatePojo(session, cliente);
    }

    public boolean excluir(EntityManager session, Cliente cliente) throws Exception {
        return super.deletePojo(session, cliente);
    }

    public List<Cliente> getList(EntityManager session, Cliente cliente) throws Exception {
        return super.getPureList(session, Cliente.class, "Select e from Cliente e");
    }
    
     public Cliente get(long codigo, EntityManager session) throws Exception {
        String sql = " select e from Cliente e where e.codCliente=?1 ";
        return getPojoUnique(session, Cliente.class, sql, codigo);
    }

    public String getSqlLista(Integer inicio, Integer fim) throws Exception { 
        String sql = " select c.codcliente as codigo,"
                + " case when c.ativo is true then 'SIM' else 'NÃO' end ativo,"
                + " p.cnpj as cpf, "
                + " p.nome as nome,"
                + " p.nomeFantasia as fantasia,"
                + " p.telefone as telefone"
                + " from Cliente as c"
                + " left join pessoa as p on (c.pessoa = p.codpessoa)"
                + " where c.codcliente >="+inicio +" and c.codcliente <= "+ fim 
                + " order by ativo desc, nome ";
        return sql;
    }
    
    
}
