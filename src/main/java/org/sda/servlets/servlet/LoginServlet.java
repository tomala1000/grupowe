package org.sda.servlets.servlet;

import org.sda.servlets.domain.Password;
import org.sda.servlets.domain.User;
import org.sda.servlets.repository.UserRepository;
import org.sda.servlets.util.PasswordUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    private UserRepository userRepository;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        ApplicationContext context =
                WebApplicationContextUtils.getRequiredWebApplicationContext(
                        this.getServletContext());
        userRepository = context.getBean(UserRepository.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String passw = req.getParameter("password");

        User user  = userRepository.findByEmail(email);
        if(user != null){
            Password password = userRepository.findBy(user);
            if(PasswordUtil.checkPassword(passw, password.getValue())){
//                zalogowano
            } else {
//                spróbuj jeszcze raz
            }
        }
    }
}
