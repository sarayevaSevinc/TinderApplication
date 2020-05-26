package MyProject.servlets;

public class HerokuEnv {


    public static int port() {
        try {
            String port = System.getenv("PORT");
            return Integer.parseInt(port);
        } catch (NumberFormatException e) {
            return 5000;
        }
    }


    public static String jdbc_url(){
       String url =System.getenv("JDBC_DATABASE_URL");

        if (url==null) throw new IllegalArgumentException("JDBS_DATABASE_URL is empty");
        return url;
    }

    public static String jdbc_username(){
       String username =System.getenv("JDBC_DATABASE_USERNAME");

        if (username==null) throw new IllegalArgumentException("JDBC_DATABASE_USERNAME is empty");
        return username;
    }

    public static String jdbc_password(){
        String password = System.getenv("JDBC_DATABASE_PASSWORD");
        if (password==null) throw new IllegalArgumentException("JDBS_DATABASE_PASSWORD is empty");
        return password;
    }
}
