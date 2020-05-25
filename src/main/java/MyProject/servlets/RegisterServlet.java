package MyProject.servlets;

import MyProject.entity.User;
import MyProject.service.RegisterService;
import MyProject.template.TemplateEngine;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class RegisterServlet extends HttpServlet {

    private final TemplateEngine engine;
    private RegisterService registerService;

    public RegisterServlet(TemplateEngine engine) {
        this.engine = engine;
        registerService = new RegisterService();
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        engine.render("register.ftl", resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try { User user =new User(
                req.getParameter("username"),
                req.getParameter("gender"),
                req.getParameter("password"),
                req.getParameter("email"),
                req.getParameter("photoUrl"),
                req.getParameter("position")

        );
            HashMap <String, Object> data = new HashMap<>();
            String message = registerService.register(user);
            data.put("message", message);
            engine.render("register.ftl", data, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
