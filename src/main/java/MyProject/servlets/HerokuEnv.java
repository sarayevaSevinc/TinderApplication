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
      //  String url =System.getenv("JDBC_DATABASE_URL");
        String url ="jdbc:postgresql://ec2-35-169-254-43.compute-1.amazonaws.com:5432/d7clhtro91tq7l";
        if (url==null) throw new IllegalArgumentException("JDBS_DATABASE_URL is empty");
        return url;
    }

    public static String jdbc_username(){
     //   String username =System.getenv("JDBC_DATABASE_USERNAME");
        String username ="mupvcapvhlgtse";
        if (username==null) throw new IllegalArgumentException("JDBC_DATABASE_USERNAME is empty");
        return username;
    }

    public static String jdbc_password(){
       // String password = System.getenv("JDBC_DATABASE_PASSWORD");
        String password = "02d0f777b1f71a29ed0bb225224a30c050b51370e2096f82adf6efd6c2573b5e";
        if (password==null) throw new IllegalArgumentException("JDBS_DATABASE_PASSWORD is empty");
        return password;
    }
}
