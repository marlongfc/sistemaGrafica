/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos.producao;


import graficaatual.entidades.pedido.ItemOrcamento;
import graficaatual.entidades.pedido.Orcamento;
import graficaatual.entidades.producao.OrdemServico;
import graficaatual.regras.producao.OrdemServicoRNE;
import graficaatual.utilitarios.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Projeto X
 */
public class OrdemServicoDAO extends OrdemServicoRNE {
    
    public OrdemServico addOrdem(OrdemServico cliente) throws Exception {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();
        OrdemServico aux = null;
        try {
            aux = super.salvar(session, cliente);
            session.getTransaction().commit();
            return aux;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
        finally {
            session.close();
        }
        
    }
        
   public OrdemServico addOrdem(EntityManager session, OrdemServico cliente) throws Exception {
        OrdemServico aux = null;
        try {
            aux = super.salvar(session, cliente);
           
            return aux;
        } catch (Exception e) {
            
            throw e;
        }
        
        
    }

    public OrdemServico get(Integer cod) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        try {
            OrdemServico aux = super.getPojo(OrdemServico.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }
       
    public OrdemServico getList(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        try {
            OrdemServico aux = super.getPojo(OrdemServico.class, cod);
            return aux;
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }
    
     public List<OrdemServico> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, OrdemServico.class, SQL, parametros);
    }

     public List<OrdemServico> getListByOrcamento(int cod) {
        EntityManager session = Persistencia.getInstance().getSessionSemBegin();
        try {
            return super.getListByOrcamento(cod, session);
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }
     
public Boolean gerarOrdemServico(List<ItemOrcamento> listaItens,EntityManager session)throws Exception {
       return super.gerarOrdemServico(listaItens, session);
}


  
}
