package graficaatual.pesq.cadastro;


import graficaatual.utilitarios.CnvNativeQueryRNE;
import graficaatual.utilitarios.Persistencia;
import javax.persistence.EntityManager;

/**
 *
 * @author Marlon
 */
public class CnvCidade extends CnvNativeQueryRNE {

    public CnvCidade() {

    }

    public void iniciarNavCidade() {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            String sql = " select e.codCidade, e.descricao, e.codIbge  from Cidade e order by e.descricao asc";

            String sqlNrReg = " select  count(e.codCidade)"
                    + " from Cidade e  ";
                               
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
