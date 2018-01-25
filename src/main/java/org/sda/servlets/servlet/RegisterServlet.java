package org.sda.servlets.servlet;

import org.sda.servlets.domain.User;
import org.sda.servlets.repository.UserRepository;
import org.sda.servlets.util.UserValidation;
import org.sda.servlets.util.ValidationUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {

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
        PrintWriter out = resp.getWriter();
        User user = new User();
        user.setEmail(req.getParameter("Email"));
        user.setFirstName(req.getParameter("Name"));
        user.setLastName(req.getParameter("Surname"));

        String passw = req.getParameter("password");

        Set<ConstraintViolation<User>> violations = ValidationUtil.validateInternal(user);
        if(violations.isEmpty()) {
            userRepository.save(user, passw);
            out.println("Good!");
        } else {
            req.setAttribute("violations",violations);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/registerUser.jsp");
            requestDispatcher.forward(req, resp);

            Iterator<ConstraintViolation<User>> violationIterator = violations.iterator();
            while(violationIterator.hasNext()){
                ConstraintViolation<User> violation = violationIterator.next();
                System.out.println(violation.getPropertyPath());
                System.out.println(violation.getMessage());
            }
            out.println("Wrong data!");
        }
    }
}
