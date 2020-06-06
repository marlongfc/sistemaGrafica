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
           
            Connection conexao = Conexao.getConexao();
            Statement banco = Conexao.getBanco(conexao);
           
            if (conexao == null || !ValidarConexao.isValidConexao(conexao, "postgres")) {
               
                conexao = Conexao.getConexao();
                banco = Conexao.getBanco(conexao);
            }
            
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
           
            if (parametros == null) {
                parametros = new HashMap();
            }
           
            Entidade p = new EntidadeDAO().get(1);

            if (p != null) {
               
                if (p.getBrasao() != null) {
                 
                    ByteArrayInputStream bis = new ByteArrayInputStream(p.getBrasao(), 0, p.getBrasao().length);
                   
                    InputStream is;
                    is = (InputStream) bis;

                    parametros.put("BRASAO", is);
                }

               
                parametros.put("NOMEENT", p.getNome());
                if (p.getCidade() != null) {
                   
                    parametros.put("CIDADEENT", p.getCidade().getDescricao());
                }
                if (p.getBairro() != null) {
                  
                    parametros.put("BAIRROENT", p.getBairro().getDescricao());
                }
                if (p.getLogradouro() != null) {
                   
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
           
            if (rs.next()) {
                
                rs.beforeFirst();
                JRResultSetDataSource jr = new JRResultSetDataSource(rs);

                URL file = getClass().getClassLoader().getResource(nomeRel);
             
                if (file != null) {
                   
                    JasperPrint impressao = JasperFillManager.fillReport(
                            file.openStream(), parametros,
                            jr);

                    JasperViewer viewer;
                    viewer = new JasperViewer(impressao, false);
                    viewer.setTitle("VISUALIZAÇÃO - " + titRel);
                    viewer.setVisible(true);

                } else {
                    
                    JasperPrint impressao = JasperFillManager.fillReport(
                            nomeRel,
                            parametros,
                            jr);
                  
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
