/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;  
import graficaatual.entidades.Pedido;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Moisés
 */
public class PedidoRNE extends GenericDAO {

    public Pedido salvar(EntityManager session, Pedido pedido) throws Exception {
        return super.saveOrUpdatePojo(session, pedido);
    }

    public boolean excluir(EntityManager session, Pedido pedido) throws Exception {
        return super.deletePojo(session, pedido);
    }

    public List<Pedido> getList(EntityManager session, Pedido pedido) throws Exception {
        return super.getPureList(session, Pedido.class, "Select e from Orcamento e");
    }
    
     public Pedido get(int codigo, EntityManager session) {
        return getPojo(session, Pedido.class, codigo);
    }

    public List<Pedido> getList(EntityManager session) throws Exception {
        return super.getPureList(session, Pedido.class, "Select e from Pedido e order by e.codPedido");
    } 
}
