/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.producao;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.ControleAcesso;
import graficaatual.entidades.pedido.ItemOrcamento;
import graficaatual.entidades.producao.OrdemServico;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author 
 */
public class OrdemServicoRNE extends GenericDAO{
    
    public OrdemServico salvar(EntityManager session, OrdemServico cliente) throws Exception {
        return super.saveOrUpdatePojo(session, cliente);
    }

    public boolean excluir(EntityManager session, OrdemServico cliente) throws Exception {
        return super.deletePojo(session, cliente);
    }

    public List<OrdemServico> getList(EntityManager session, OrdemServico cliente) throws Exception {
        return super.getPureList(session, OrdemServico.class, "Select e from Cliente e");
    }
    
     public OrdemServico get(Integer codigo, EntityManager session) throws Exception {
        String sql = " select e from OrdemServico e where e.codOrdemServico=?1 ";
        return getPojoUnique(session, OrdemServico.class, sql, codigo);
    }
     
      public OrdemServico getByOrcamento(Integer codigo, EntityManager session) throws Exception {
        String sql = " select e from OrdemServico e where e.orcamento.codOrcamento=?1 ";
        return getPojoUnique(session, OrdemServico.class, sql, codigo);
    }

    public Boolean gerarOrdemServico(List<ItemOrcamento> listaItens,EntityManager session) throws Exception {
        if (listaItens != null && (!listaItens.isEmpty())) {
            OrdemServico ordemS = null;
            for (ItemOrcamento item : listaItens) {
                ordemS = new OrdemServico();
                ordemS.setDataCadastro(new Date());
                ordemS.setUsuarioCadastro(ControleAcesso.usuario.getCodUsuario() + " " + ControleAcesso.usuario.getColaborador().getPessoa().getNome());
                ordemS.setOrcamento(item.getOrcamento());
                ordemS.setCheckCriacao(item.getCheckCriacao());
                ordemS.setCheckSerralheria(item.getCheckSerralheria());
                ordemS.setCheckProjeto(item.getCheckProjeto());
                ordemS.setCheckPintura(item.getCheckPintura());
                ordemS.setCheckPlotagem(item.getCheckPlotagem());
                ordemS.setCheckImpressaoDigital(item.getCheckImpressaoDigital());
                ordemS.setCheckRouter(item.getCheckRouter());
                ordemS.setCheckAcabamentoImp(item.getCheckAcabamentoImp());
                ordemS.setCheckFaturamento(item.getCheckFaturamento());
                ordemS.setCheckPloterRecorte(item.getCheckPloterRecorte());
                ordemS.setCheckEntrega(item.getCheckEntrega());
                ordemS.setCheckCaixariaAcabamento(item.getCheckCaixariaAcabamento());
                ordemS = salvar(session, ordemS);
            }
        } else {
            throw new Exception("Verificar lista de itens do Pedido");
        }
        return true;
    }
    
    
}
