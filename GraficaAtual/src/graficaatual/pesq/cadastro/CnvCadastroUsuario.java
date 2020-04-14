package graficaatual.pesq.cadastro;


import graficaatual.utilitarios.CnvNativeQueryRNE;
import graficaatual.utilitarios.Persistencia;
import javax.persistence.EntityManager;

/**
 *
 * @author Projeto X
 */
public class CnvCadastroUsuario extends CnvNativeQueryRNE {

    public CnvCadastroUsuario() {

    }

    public void iniciarNavTabela() {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            String sql = " select  "
                    + " u.codUsuario ,  "
                    + " p.nome, "
                    + " u.login,  "
                    + " u.ativo "
                    + " from usuario u  "
                    + " left join colaborador c  on (u.colaborador = c.codColaborador)"
                    + " left join pessoa p on (p.codpessoa = c.pessoa)"
                    + " order by u.login";

            String sqlNrReg = " select  count(u.codusuario)"
                    + " from usuario u ";
                   
                   
            
            
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
