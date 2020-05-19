/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.utilitarios;

import graficaatual.daos.relatorio.EntidadeDAO;
import graficaatual.entidades.relatorio.Entidade;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author SI10
 */
public class VisualizaRelatorio {

    /**
     * Gerar Relatorio 06/01/2015
     *
     * @param nomeRel
     * @param titRel
     * @param parametros
     * @param sql
     */
    public void visRel(String nomeRel, String titRel, Map parametros, String sql) {
        visRel(nomeRel, titRel, parametros, sql, true);
    }

    public void visRel(String nomeRel, String titRel, Map parametros, String sql, boolean mostrarMsg) {
        try {
            System.out.println("RLT: " + sql);
            Connection conexao = Conexao.getConexao();
            Statement banco = Conexao.getBanco(conexao);
            System.out.println("RLT: 1");
            if (conexao == null || !ValidarConexao.isValidConexao(conexao, "postgres")) {
                System.out.println("RLT: 2");
                conexao = Conexao.getConexao();
                banco = Conexao.getBanco(conexao);
            }
            System.out.println("RLT: 3");
            visRel(nomeRel, titRel, sql, banco, parametros, mostrarMsg);

            banco.close();
            conexao.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Visualizar: " + e);
            e.printStackTrace();
        }
    }

    public void visRel(String nomeRel, String titRel, String sql, Statement banco, Map parametros, boolean mostrarMsg) {
        try {
            System.out.println("RLT: 4");
            if (parametros == null) {
                parametros = new HashMap();
            }
            System.out.println("RLT: 5");
            Entidade p = new EntidadeDAO().get(1);

            if (p != null) {
                System.out.println("RLT: 6");
                if (p.getBrasao() != null) {
                    System.out.println("RLT: 7");
                    ByteArrayInputStream bis = new ByteArrayInputStream(p.getBrasao(), 0, p.getBrasao().length);
                    System.out.println("RLT: 8");
                    InputStream is;
                    is = (InputStream) bis;

                    parametros.put("BRASAO", is);
                }

                System.out.println("RLT: 9");
                parametros.put("NOMEENT", p.getNome());
                if (p.getCidade() != null) {
                    System.out.println("RLT: 10");
                    parametros.put("CIDADEENT", p.getCidade().getDescricao());
                }
                if (p.getBairro() != null) {
                    System.out.println("RLT: 11");
                    parametros.put("BAIRROENT", p.getBairro().getDescricao());
                }
                if (p.getLogradouro() != null) {
                    System.out.println("RLT: 12");
                    parametros.put("LOGRADOUROENT", p.getLogradouro().getDescricao());
                }

                parametros.put("INSCESTENT", p.getInscEstadual());
                parametros.put("CNPJENT", p.getCnpj());
                parametros.put("NUMEROENT", p.getNumero());
                parametros.put("TELEFONEENT", p.getTelefone());
                parametros.put("COMPLEMENTOENT", p.getComplemento());
                parametros.put("EMAILENT", p.getEmail());

            } else {
                System.out.println("Parâmetro nulo");
            }

            ResultSet rs;
            rs = banco.executeQuery(sql);
            System.out.println("RLT: 14");
            if (rs.next()) {
                System.out.println("RLT: 15");
                rs.beforeFirst();
                JRResultSetDataSource jr = new JRResultSetDataSource(rs);

                URL file = getClass().getClassLoader().getResource(nomeRel);
                System.out.println("RLT: 16");
                if (file != null) {
                    System.out.println("RLT: 17");
                    JasperPrint impressao = JasperFillManager.fillReport(
                            file.openStream(), parametros,
                            jr);

                    JasperViewer viewer;
                    viewer = new JasperViewer(impressao, false);
                    viewer.setTitle("VISUALIZAÇÃO - " + titRel);
                    viewer.setVisible(true);

                } else {
                    System.out.println("RLT: 18");
                    JasperPrint impressao = JasperFillManager.fillReport(
                            nomeRel,
                            parametros,
                            jr);
                    System.out.println("RLT: 19");
                    JasperViewer viewer;
                    viewer = new JasperViewer(impressao, false);
                    viewer.setTitle("VISUALIZAÇÃO - " + titRel);
                    viewer.setVisible(true);

                }
            } else {
                if (mostrarMsg) {
                    JOptionPane.showMessageDialog(null, "Relatório Vazio");
                } else {
                    System.out.println("Relatório Vazio");
                }
            }
        } catch (Exception ex) {
            if (mostrarMsg) {
                JOptionPane.showMessageDialog(null, "Visualizar: " + ex.getLocalizedMessage());
            } else {
                System.out.println("Visualizar: " + ex.getLocalizedMessage());
            }
        }
    }

}
