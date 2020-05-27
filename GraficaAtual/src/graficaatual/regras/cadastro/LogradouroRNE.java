/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.regras.cadastro;

import graficaatual.daos.GenericDAO;
import graficaatual.entidades.Logradouro;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class LogradouroRNE extends GenericDAO {

    public Logradouro salvar(EntityManager session, Logradouro logradouro) throws Exception {
        return super.saveOrUpdatePojo(session, logradouro);
    }

    public boolean excluir(EntityManager session, Logradouro logradouro) throws Exception {
        return super.deletePojo(session, logradouro);
    }

    public long getNextItem(EntityManager session) throws Exception {
        String q = " select max(e.codLogradouro) from Logradouro e ";

        Long ret = getLong(session, q);

        return ret == null ? 1 : ret + 1;
    }

    public Logradouro get(long codigo, EntityManager session) throws Exception {
        String sql = " select e from Logradouro e where e.codLogradouro=?1 ";
        return getPojoUnique(session, Logradouro.class, sql, codigo);
    }

    public List<Logradouro> getList(EntityManager session) throws Exception {
        String sql = " select e from Logradouro e order by e.codLogradouro";
        return getPureList(session, Logradouro.class, sql);
    }

    public List<Logradouro> getList(EntityManager session, String sql) throws Exception {
        return getPureList(session, Logradouro.class, sql);
    }

    public String getSqlLista(Integer inicio, Integer fim) {

        String sql = "select codlogradouro, descricao, (Case (e.tipo)    when 0"
                + "                    then 'Rua'"
                + "                when 1"
                + "                    then 'Praça'"
                + "                when 2"
                + "                    then 'Avenida'"
                + "                when 3"
                + "                    then 'Travessa'"
                + "                when 4"
                + "                    then 'Rodovia'"
                + "                when 5"
                + "                    then 'Anel Rodoviário'"
                + "                when 6"
                + "                    then 'Quadra'"
                + "                when 7"
                + "                    then 'Beco'"
                + "                when 8"
                + "                    then 'Campo'"
                + "                when 9"
                + "                    then 'Chácara'"
                + "                when 10"
                + "                    then 'Comunidade'"
                + "                when 11"
                + "                    then 'Condomínio'"
                + "                when 12"
                + "                    then 'Distrito'"
                + "                when 13"
                + "                    then 'Estrada'"
                + "                when 14"
                + "                    then 'Estacionamento'"
                + "                when 15"
                + "                    then 'Favela'"
                + "                when 16"
                + "                    then 'Fazenda'"
                + "                when 17"
                + "                    then 'Largo'"
                + "                when 18"
                + "                    then 'Lagoa'"
                + "                when 19"
                + "                    then 'Loteamento'"
                + "                when 20"
                + "                    then 'Lote'"
                + "                when 21"
                + "                    then 'Morro'"
                + "                when 22"
                + "                    then 'Passagem'"
                + "                when 23"
                + "                    then 'Ponte'"
                + "                when 24"
                + "                    then 'Rancho'"
                + "                when 25"
                + "                    then 'Sítio'"
                + "                when 26"
                + "                    then 'Vila'"
                + "                when null"
                + "                    then '' End) as tipo "
                + " from logradouro e "
                + " where e.codLogradouro>=" + inicio + " and e.codLogradouro <=" + fim
                + " order by e.descricao asc";

        return sql;
    }
}
