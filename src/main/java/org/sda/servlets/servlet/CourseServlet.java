package org.sda.servlets.servlet;

import org.sda.servlets.domain.Course;
import org.sda.servlets.repository.CourseRepository;
import org.sda.servlets.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/courses")
public class CourseServlet extends HttpServlet{

    private CourseRepository courseRepository;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        ApplicationContext context =
                WebApplicationContextUtils.getRequiredWebApplicationContext(
                        this.getServletContext());
        courseRepository = context.getBean(CourseRepository.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("coursesList",courseRepository.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/coursesTable.jsp");
        requestDispatcher.forward(request, response);
    }
}
