/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graficaatual.utilitarios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author SI10
 */
public class ValidarConexao {

    /**
     * Teste de validade de uma conexão JDBC
     *
     * @param conn a JDBC conexão para teste
     * @param dbVendor db vendor {"oracle", "mysql", "postgres"}
     * @return true se a conexão é válida; caso contrário retornará false.
     */
    public static boolean isValidConexao(Connection conn, String dbVendor) {
        try {

            if (conn == null) {
                return false;
            }

            if (conn.isClosed()) {
                return false;
            }

            if (dbVendor.equalsIgnoreCase("mysql")) {
                return testConexao(conn, "select 1");
            } else if (dbVendor.equalsIgnoreCase("postgres")) {
                return testConexao(conn, "select 1");
            } else if (dbVendor.equalsIgnoreCase("oracle")) {
                return testConexao(conn, "select 1 from dual");
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }
    public static boolean testConexao(Connection conn, String query) {
        ResultSet rs = null;
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            if (stmt == null) {
                return false;
            }

            rs = stmt.executeQuery(query);
            if (rs == null) {
                return false;
            }

       
            if (rs.next()) {
                return true;
            }


            //Não há mais teste de validade de uma conexão
            return false;

        } catch (Exception e) {
            //Algo deu errado: conexão é ruim
            return false;
        } finally {
            // close recursos de banco de dados
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
