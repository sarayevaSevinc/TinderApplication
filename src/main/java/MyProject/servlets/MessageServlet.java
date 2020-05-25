package MyProject.servlets;

import MyProject.entity.Message;
import MyProject.entity.User;
import MyProject.service.LoginService;
import MyProject.service.MessageService;
import MyProject.template.TemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class MessageServlet extends HttpServlet {
    private final TemplateEngine engine;
   private final MessageService messageService;
   private final LoginService loginService;

    public MessageServlet(TemplateEngine engine){
        this.engine = engine;
        messageService = new MessageService();
        loginService = new LoginService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getPathInfo();
        int receiver_id = Integer.parseInt(path.substring(1));
        HttpSession session = req.getSession();
        User currentUser = (User)session.getAttribute("user");
        int sender_id = currentUser.getId();
        System.out.println(receiver_id);
        System.out.println(sender_id);
        List<Message> messages = messageService.getMessageWithOnePerson(sender_id, receiver_id);
        HashMap<String, Object> data = new HashMap<>();
        data.put("messages", messages);
        data.put("loggedUserId", sender_id);
        User receiver =loginService.getUser(receiver_id).get();
        data.put("targetUser", receiver);
        System.out.println(data.toString());
        engine.render("chat.ftl",data, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        int receiver_id = Integer.parseInt(path.substring(1));
        HttpSession httpSession = req.getSession();
        User currentUser = (User) httpSession.getAttribute("user");
        int sender_id = currentUser.getId();
        String text = req.getParameter("input");
        messageService.addMessage(sender_id, receiver_id, text);
        doGet(req, resp);
    }
}
