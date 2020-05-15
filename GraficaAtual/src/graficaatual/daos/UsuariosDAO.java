/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.daos;

import graficaatual.entidades.Usuario;
import graficaatual.utilitarios.Persistencia;
import java.util.List;

/**
 *
 * @author Projeto X
 */
public class UsuariosDAO extends GenericDAO{
    
    public boolean addUsuario(Usuario usuario) {
        return saveOrUpdatePojo(usuario);
    }

    public boolean deleteUsuario(Usuario usuario) {
        return deletePojo(usuario);
    }

    public Usuario getUsuario(int codUsuario) {
        return getPojo(Usuario.class, codUsuario);
    }

    public Usuario getUsuario(String login) {
        Usuario us = null;
        us = getPurePojoUnique(Usuario.class,
                "select u from Usuario u where u.login=?1 ",
                login.trim());

        if (us != null && us.getCodUsuario()> 0) {
            return us;
        }

        return null;
    }

    public Usuario getUsCodigo(Integer codigo) {
        Usuario us = null;
        us = getPurePojoUnique(Usuario.class, "select usuario from Usuarios usuario where usuario.codigo=?1"
                + " and usuario.codigo not in (select ex.usuario.codigo from ResponsavelUsuario ex where ex.usuario.codigo = usuario.codigo)"
                + " order by usuario.codigo", codigo);

        if (us != null && us.getCodUsuario()> 0) {
            return us;
        }

        return null;
    }

    public int getCount() {
        return getPureList(Usuario.class, "select usuarios from Usuarios usuario order by usuario.nome").size();
    }

    public List<Usuario> getLista() {
        return getPureList(Usuario.class, "select e from Usuarios e order by e.nome");
    }

    public List<Usuario> getList(int NRegistros, String SQL, Object... parametros) {
        return getPureList(Persistencia.getInstance().getEntityManager(), 0, NRegistros, Usuario.class, SQL, parametros);
    }

    public List<Usuario> getListaAdministradores() {
        return getPureList(Usuario.class, "select e from Usuarios e where e.tipoPermissao.codigo >= 5 order by e.nome");
    }
    //

    public boolean verificarLogin(String login) {
        Integer x= (getPureList(Usuario.class, "select u from Usuario u where u.login=?1", login).size());
        
        if(x == null || x<=0){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean verificarColaborador(int codColaborador) {
        Integer x= (getPureList(Usuario.class, "select u from Usuario u where u.ativo='true' and u.colaborador.codColaborador=?1", codColaborador).size());
        
        if(x == null || x<=0){
            return false;
        }else{
            return true;
        }
    }

   public String getSqlLista(Integer inicio, Integer fim) {
      String sql = " select u.codUsuario as codigo,"
                + " u.login as login,"
                + " case when u.ativo is true then 'SIM' else 'NÃO' end ativo,"
                + " (c.codColaborador ||'-'||p.nome)as colaborador, "
                + " case when u.acessoCadastro is true then 'SIM' else 'NÃO' end modulo1,"
                + " case when u.acessoPedido is true then 'SIM' else 'NÃO' end modulo2,"
                + " case when u.acessoEstoque is true then 'SIM' else 'NÃO' end modulo3,"
                + " case when u.acessoFinanceiro is true then 'SIM' else 'NÃO' end modulo4,"
                + " case when u.acessoRelatorios is true then 'SIM' else 'NÃO' end modulo5,"
                + " case when u.acessoProducao is true then 'SIM' else 'NÃO' end modulo6"
                + " from Usuario as u"
                + " left join colaborador as c on (colaborador = c.codColaborador)"
                + " left join pessoa as p on (c.pessoa = p.codpessoa)"
                + " where colaborador >="+inicio +" and colaborador <= "+ fim 
                + " order by ativo desc, login ";
        return sql;
    }
}
