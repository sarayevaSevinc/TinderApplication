package MyProject.Filters;

import MyProject.service.LoginService;
import MyProject.template.TemplateEngine;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class LoginFilter implements Filter {
    TemplateEngine engine;
     LoginService loginService;

    public LoginFilter(TemplateEngine engine) {
        this.engine = engine;
        this.loginService = new LoginService();
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (((HttpServletRequest)servletRequest).getMethod().equals("POST")) {
            HashMap<String, Object> data = new HashMap<>();
            String email = servletRequest.getParameter("email");
            String password = servletRequest.getParameter("password");
            if (loginService.isUserValid(email, password)) {
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                data.put("message", "<label class=\"error\">Wrong password or email!</label>\n");
                engine.render("login.ftl", data, (HttpServletResponse) servletResponse);}
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
