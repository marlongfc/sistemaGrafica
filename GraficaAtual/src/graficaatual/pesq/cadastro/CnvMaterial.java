package graficaatual.pesq.cadastro;

import graficaatual.utilitarios.CnvNativeQueryRNE;
import graficaatual.utilitarios.Persistencia;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class CnvMaterial extends CnvNativeQueryRNE {

    public CnvMaterial() {

    }

    public void iniciarNavMaterial() {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            String sql = " select e.codMaterial, e.descricao, case e.unidademedida when 0 then 'Metro (linear)' "
                    + " when 1 then 'Metro (m²)' when 2 then 'Unidade (un)' when 3 then 'Peso (kg)' "
                    + " when 4 then 'Litros (l)' end as unidademedida,"
                    + " e.estoqueMinimo   from Material e order by e.descricao asc";

            String sqlNrReg = " select  count(e.codMaterial)"
                    + " from Material e  ";

            super.iniciarCnv(session, sqlNrReg, sql, 15);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
        }

    }

    public void iniciarCnv(String sqlNrReg, String sql, int nrReg, Object... parametros) {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            super.iniciarCnv(session, sqlNrReg, sql, nrReg, parametros);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
        }

    }

    public void proximo(Object... parametros) {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            super.proximo(session, parametros);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
        }

    }

    public void anterior(Object... parametros) {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            super.anterior(session, parametros);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
        }

    }

    public void primeiro(Object... parametros) {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            super.primeiro(session, parametros);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
        }

    }

    public void ultimo(Object... parametros) {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            super.ultimo(session, parametros);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void atualizarPosicaoRegistro(Object... parametros) {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            super.atualizarPosisaoRegistro(session, parametros);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
