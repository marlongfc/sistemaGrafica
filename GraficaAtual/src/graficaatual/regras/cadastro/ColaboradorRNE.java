/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.Colaborador;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author 
 */
public class ColaboradorRNE extends GenericDAO{
    

    public Colaborador salvar(EntityManager session, Colaborador colaborador) throws Exception {
        return super.saveOrUpdatePojo(session, colaborador);
    }

    public boolean excluir(EntityManager session, Colaborador colaborador) throws Exception {
        return super.deletePojo(session, colaborador);
    }

    public List<Colaborador> getList(EntityManager session, Colaborador colaborador) throws Exception {
        return super.getPureList(session, Colaborador.class, "Select e from Colaborador e");
    }
    
    public Colaborador get(int codigo, EntityManager session) throws Exception {
        return super.getPojo(session, Colaborador.class, codigo);
    }

    public String getSqlLista(Integer inicio, Integer fim) {
      String sql = " select c.codColaborador as codigo,"
                + " case when c.ativo is true then 'SIM' else 'NÃO' end ativo,"
                + " p.nome as nome,"
                + " c.dataInicio as inicio,"
                + " c.dataFim as fim,"
                + " p.telefone as telefone,"
                + " (g.codcargo||'-'||g.descricao) as cargo"
                + " from Colaborador as c"
                + " left join cargo as g on (g.codcargo = c.cargo)"
                + " left join pessoa as p on (c.pessoa = p.codpessoa)"
                + " where c.codColaborador >="+inicio +" and c.codColaborador <= "+ fim 
                + " order by ativo desc, nome ";
        return sql;
    }
    
    
}
