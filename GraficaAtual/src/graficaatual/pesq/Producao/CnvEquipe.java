package graficaatual.pesq.Producao;


import graficaatual.utilitarios.CnvNativeQueryRNE;
import graficaatual.utilitarios.Persistencia;
import javax.persistence.EntityManager;

/**
 *
 * @author Projeto X
 */
public class CnvEquipe extends CnvNativeQueryRNE {

    public CnvEquipe() {

    }

    public void iniciarNavTabela() {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            String sql =  " select"
                    + "  e.codequipeentrega,"
                    + "  e.nome,"
                    + "  e.placacarro, "
                    + "  e.telefone1,"
                    + "  e.telefone2,"
                    + "  case when e.datacancelamento is null then true else false end ativo"
                    + "  from equipeentrega e  "
                    + "  order by e.nome " ;

            String sqlNrReg = " select  count(e.codequipeentrega)"
                    + " from equipeentrega e ";
                   
                   
            
            
            super.iniciarCnv(session, sqlNrReg, sql, 6);

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
            System.out.println("entrei");
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

    /**
     * So para navegasão com um registro
     *
     * @param parametros
     */
    public void atualizarPosicaoRegistro(Object... parametros) {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            super.atualizarPosisaoRegistro(session, parametros);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
