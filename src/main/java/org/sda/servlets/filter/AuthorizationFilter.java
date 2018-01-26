package org.sda.servlets.filter;

import org.sda.servlets.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    private List<String> whiteList = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        whiteList.add("/pages/login.jsp");
        whiteList.add("/login");
        whiteList.add("/pages/registerUser.jsp");
        whiteList.add("/register");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        if (whiteList.contains(req.getRequestURI())) {
            chain.doFilter(request, response);
        } else {
            User user = (User) session.getAttribute("loggedInUser");
            if (user != null) {
                chain.doFilter(request, response);
            } else {
                resp.sendRedirect("/pages/login.jsp");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
