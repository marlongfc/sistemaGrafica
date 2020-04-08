package graficaatual.pesq.cadastro;


import graficaatual.utilitarios.CnvNativeQueryRNE;
import graficaatual.utilitarios.Persistencia;
import javax.persistence.EntityManager;

/**
 *
 * @author Projeto X
 */
public class CnvCadastroCargo extends CnvNativeQueryRNE {

    public CnvCadastroCargo() {

    }

    public void iniciarNavTabela() {

        EntityManager session = Persistencia.getInstance().getSessionComBegin();

        try {

            String sql = " select  "
                    + " c.codCargo ,  "
                    + " c.descricao, "
                    + " (p.codTurno || '-' || p.descricao), "
                    + " c.crm "
                    + " from Cargo c  "
                    + " left join turno p on (p.codturno = c.turno)"
                    + " order by c.descricao";

            String sqlNrReg = " select  count(p.codCargo)"
                    + " from Cargo p  ";
                  
                   
            
            
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
