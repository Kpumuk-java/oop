package ru.kpumuk.web.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/hello")
public class PrimaryServlet implements Servlet {

    private ServletConfig config;

    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    public ServletConfig getServletConfig() {
        return this.config;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //config.getServletContext().getRequestDispatcher("/hello.jsp").forward(servletRequest, servletResponse);
        servletResponse.getWriter().println("<h1>Hello World</h2>");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
