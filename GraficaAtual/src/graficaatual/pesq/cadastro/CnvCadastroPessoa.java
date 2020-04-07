package graficaatual.pesq.cadastro;


import graficaatual.utilitarios.CnvNativeQueryRNE;
import graficaatual.utilitarios.Persistencia;
import javax.persistence.EntityManager;

/**
 *
 * @author Projeto X
 */
public class CnvCadastroPessoa extends CnvNativeQueryRNE {

    public CnvCadastroPessoa() {

    }

    public void iniciarNavTabelaPessoa() {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            String sql = " select  "
                    + " p.codpessoa ,  "
                    + " p.cnpj, "
                    + " p.nome,  "
                    + " p.nomefantasia, "
                    + " p.ativo "
                    + " from pessoa p  "
                    + " where p.ativo = 'true'"
                    + " order by p.nome";

            String sqlNrReg = " select  count(p.codpessoa)"
                    + " from pessoa p  "
                    + " where p.ativo = 'true'";
                   
            
            
            super.iniciarCnv(session, sqlNrReg, sql, 5);

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
