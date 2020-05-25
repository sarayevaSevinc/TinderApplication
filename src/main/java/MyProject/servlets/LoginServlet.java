package MyProject.servlets;

import MyProject.entity.User;
import MyProject.service.LoginService;
import MyProject.template.TemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Optional;

public class LoginServlet extends HttpServlet {

    private final TemplateEngine engine;
    private final LoginService loginService;

    public LoginServlet(TemplateEngine engine) {
        this.engine = engine;
        loginService = new LoginService();
    }

   @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       engine.render("login.ftl", resp);
   }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password= req.getParameter("password");
        Optional<User> optionalUser = loginService.checkUser(email, password);
        if(optionalUser.isPresent()){
            User currentUser = optionalUser.get();
            HttpSession session = req.getSession();
            session.setAttribute("user", currentUser);
           resp.sendRedirect("/MainPage/");
        }

    }
}
