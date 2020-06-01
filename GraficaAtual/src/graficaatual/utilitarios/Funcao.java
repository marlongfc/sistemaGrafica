package graficaatual.utilitarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 *
 * @author adm
 */
public class Funcao {

    public static Properties getPropriedade(String Arquivo) {
        File file = new File(Arquivo);
        Properties Prop = new Properties();
        FileInputStream fis;

        try {
            fis = new FileInputStream(file);
            Prop.load(fis);
            fis.close();
        } catch (Exception e) {
            System.out.println("Erro em Util.getPropriedade: " + e);
        }
        return Prop;
    }

    public static void setPropriedade(Properties propriedade, String Arquivo) {
        File file = new File(Arquivo);
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            propriedade.store(fos, "Propriedades do Sistema Integrado de Gestão Pública. Atualizado em " + Data.getDate());
            fos.close();
        } catch (Exception e) {
            System.out.println("Erro em utilitarios.Funcao.setPropriedade: " + e);
        }
    }

}
