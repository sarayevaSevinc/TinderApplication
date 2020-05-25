package MyProject;

import MyProject.Filters.LoginFilter;
import MyProject.Filters.MessageFilter;
import MyProject.Filters.SessionFilter;
import MyProject.db.DbSetup;
import MyProject.db.SqlConnection;
import MyProject.servlets.*;
import MyProject.template.TemplateEngine;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.DispatcherType;
import java.sql.Connection;
import java.util.EnumSet;

public class  TinderProject2 {
    public static void main(String[] args) throws Exception {
        DbSetup.migrate(HerokuEnv.jdbc_url(), HerokuEnv.jdbc_username(), HerokuEnv.jdbc_password());
        Server server=new Server(HerokuEnv.port());
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        TemplateEngine templateEngine=TemplateEngine.resources("/templates");
        // -------- servlets ------ //
        handler.addServlet(new ServletHolder(new StaticContentServlet("src/main/resources/templates")),"/static/*");
        handler.addServlet(new ServletHolder(new RegisterServlet(templateEngine)),"/register/*");
        handler.addServlet(new ServletHolder(new LoginServlet(templateEngine)),"/login/*");
        handler.addServlet(new ServletHolder(new MainPageServlet(templateEngine)),"/MainPage/");
        handler.addServlet(new ServletHolder(new LikedServlet(templateEngine)),"/liked/*");
        handler.addServlet(new ServletHolder(new LogoutServlet()),"/logout/*");
        handler.addServlet(new ServletHolder(new MessageServlet(templateEngine)),"/messages/*");
         // ------- filters  ----------- //
        handler.addFilter(new FilterHolder(new LoginFilter(templateEngine)), "/login/*", EnumSet.of(DispatcherType.REQUEST));
        handler.addFilter(SessionFilter.class, "/liked", EnumSet.of(DispatcherType.REQUEST));
        handler.addFilter(SessionFilter.class, "/messages/{id}", EnumSet.of(DispatcherType.REQUEST));
        handler.addFilter(SessionFilter.class, "/MainPage", EnumSet.of(DispatcherType.REQUEST));
        handler.addFilter(MessageFilter.class, "/messages/{id}", EnumSet.of(DispatcherType.REQUEST));
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
