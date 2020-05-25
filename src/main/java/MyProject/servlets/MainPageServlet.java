package MyProject.servlets;

import MyProject.entity.User;
import MyProject.service.LikeService;
import MyProject.service.MainPageService;
import MyProject.template.TemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class MainPageServlet extends HttpServlet {
    private final TemplateEngine engine;
    private final MainPageService mainPageService;

    public MainPageServlet(TemplateEngine engine) {
        this.engine = engine;
        mainPageService =new MainPageService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession();

        try {   User currentUser = (User) httpSession.getAttribute("user");
                int id = currentUser.getId();
                Optional<User> user = getUser(id);
                HashMap<String, Object> data = new HashMap<>();
                if (user.isPresent()) {
                    data.put("name", user.get().getFullName());
                    data.put("urlPhoto", user.get().getUrlPhoto());
                    data.put("position", user.get().getPosition());
                    data.put("id", user.get().getId());
                    engine.render("like-page.ftl", data, resp);
                }
                else {
                    resp.sendRedirect("/liked/");
                }
        }catch(SQLException e){
                e.printStackTrace();
            }
        }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String button = req.getParameter("button");
        if(button.equals("LikedList")){
            resp.sendRedirect("/liked/");
        }
        else if(button.equals("Logout")){
            resp.sendRedirect("/logout/");
        }
        else {
            String attidute = button.equals("like") ? "likes" : "dislikes";
            LikeService likeService = new LikeService(attidute);
            HttpSession httpSession = req.getSession();
            User currentUser = (User) httpSession.getAttribute("user");
            int id = currentUser.getId();
            int liked = Integer.parseInt(req.getParameter("id"));
            try {
                Optional<User> user = getUser(id);
                if (user.isPresent()) {
                    likeService.addLike(id, liked);
                }
                resp.sendRedirect( "/MainPage/");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Optional <User> getUser(int cookie_id) throws SQLException {
        List<User> users = mainPageService.allUsersExceptLikedDislikedOnes(cookie_id);
        if(users.size()==0) return Optional.empty();
        return Optional.of(users.get(generateRandom(users.size())));
    }
    public int generateRandom(int size){
        Random random = new Random();
        return random.nextInt(size);

    }

}
