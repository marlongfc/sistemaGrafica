/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.Material;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class MaterialRNE extends GenericDAO {

    public Material salvar(EntityManager session, Material material) throws Exception {
        return super.saveOrUpdatePojo(session, material);
    }

    public boolean excluir(EntityManager session, Material material) throws Exception {
        return super.deletePojo(session, material);
    }

    public List<Material> getList(EntityManager session, Material material) throws Exception {
        return super.getPureList(session, Material.class, "Select e from Material e");
    }
}
