package graficaatual.utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {

    @SuppressWarnings("static-access")
    public static Connection getConexao() throws Exception {
        Persistencia p = Persistencia.getInstance();

        return getConexao(p.GADatabase);
    }

    @SuppressWarnings("static-access")
    public static Connection getConexao(String db) throws Exception {
        Persistencia p = Persistencia.getInstance();

        return getConexao(db, p.GAIpServidor);
    }

    @SuppressWarnings("static-access")
    public static Connection getConexao(String db, String ip) throws Exception {
        Connection conexao;

        Class.forName("org.postgresql.Driver").newInstance();

        Persistencia p = Persistencia.getInstance();

        ip = ip.trim().equals("") ? "localhost" : ip;

        String url = "jdbc:postgresql://" + ip + ":" + p.GAPorta + "/" + db;
        String use="postgres";
        //String use = p.GAUserName;
        String sen = p.GAPassword;
        
        System.out.println(" ------------- "+url);
        System.out.println(" ------------- "+use );
        System.out.println(" ------------- "+sen );
        conexao = DriverManager.getConnection(url, use, sen);

        conexao.setAutoCommit(false);

        return conexao;
    }

    @SuppressWarnings("static-access")
    public static Connection getConexao(String servidor, String porta, String db) throws Exception {
        Connection conexao;

        Class.forName("org.postgresql.Driver").newInstance();

        Persistencia p = Persistencia.getInstance();

        servidor = servidor == null || servidor.trim().equals("") ? "localhost" : servidor;
        porta = porta == null || porta.trim().equals("") ? "5432" : porta;

        String url = "jdbc:postgresql://" + servidor + ":" + porta + "/" + db;
        //String use="postgres";
        String use = p.GAUserName;
        String sen = p.GAPassword;

        conexao = DriverManager.getConnection(url, use, sen);

        conexao.setAutoCommit(false);

        return conexao;
    }

    @SuppressWarnings("static-access")
    public static Connection getConexaoImp(String servidor, String porta, String db, String userName, String password) throws Exception {
        Connection conexao;

        Class.forName("org.postgresql.Driver").newInstance();

        Persistencia p = Persistencia.getInstance();

        servidor = servidor == null || servidor.trim().equals("") ? "localhost" : servidor;
        porta = porta == null || porta.trim().equals("") ? "5432" : porta;

        String url = "jdbc:postgresql://" + servidor + ":" + porta + "/" + db;
        
        String use = userName;
        String sen = password;

        conexao = DriverManager.getConnection(url, use, sen);

        conexao.setAutoCommit(false);

        return conexao;
    }

    @SuppressWarnings("static-access")
    public static Connection getConexao(String db, String ip, String usuario, String senha) throws Exception {
        Connection conexao;

        Class.forName("org.postgresql.Driver").newInstance();

        Persistencia p = Persistencia.getInstance();

        ip = ip.trim().equals("") ? "localhost" : ip;

        String url = "jdbc:postgresql://" + ip + ":" + p.GAPorta + "/" + db;
        //String use="postgres";
        String use = usuario;
        String sen = senha;

        conexao = DriverManager.getConnection(url, use, sen);

        conexao.setAutoCommit(false);

        return conexao;
    }
    @SuppressWarnings("static-access")
    public static Connection getConexao(String db, String ip, String porta, String usuario, String senha) throws Exception {
        Connection conexao;

        Class.forName("org.postgresql.Driver").newInstance();

        Persistencia p = Persistencia.getInstance();

        ip = ip == null || ip.trim().equals("") ? p.GAIpServidor : ip;
        porta = porta == null || porta.trim().equals("") ? p.GAPorta : porta;
        usuario = usuario == null || usuario.trim().equals("") ? p.GAUserName : usuario;
        senha = senha == null || senha.trim().equals("") ? p.GAPassword : senha;
       
        String url = "jdbc:postgresql://" + ip + ":" + porta + "/" + db;
        
        String use = usuario;
        String sen = senha;

        conexao = DriverManager.getConnection(url, use, sen);

        conexao.setAutoCommit(false);

        return conexao;
    }    

    public static Statement getBanco(Connection conexao) throws Exception {
        Statement banco = conexao.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        return banco;
    }

}
