package MyProject.servlets;

import MyProject.entity.User;
import MyProject.service.MainPageService;
import MyProject.template.TemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class LikedServlet extends HttpServlet {
private final MainPageService mainPageService;
    private final TemplateEngine engine;

    public LikedServlet(TemplateEngine engine) {
        this.engine = engine;
        mainPageService = new MainPageService();
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("user");
        int id = currentUser.getId();
        try {
            List<User> allLikedOnes = getUsers(id);
            HashMap < String, Object> data = new HashMap<>();
            data.put("allusers", allLikedOnes);
            engine.render("people-list.ftl", data, resp);
             } catch (SQLException e){
            e.printStackTrace();
            }
    }
    public List<User> getUsers(int id) throws SQLException {
      return   mainPageService.allLikedOnes(id);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String button = req.getParameter("button");
        if(button.equals("logout")) resp.sendRedirect("/logout");
        else{
        int id = Integer.parseInt(req.getParameter("id"));
        String path = "/messages/"+ id;
        resp.sendRedirect(path);
    }
    }
}
