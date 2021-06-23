package ru.kpumuk.web.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;


/*
* Как оказалось корень http://localhost:8080/hello , а это сервлет работает на url http://localhost:8080/hello/hello
* можно было даже не делать его, т. к. web автоматом подхватывает файл index.jsp, почему такое странное задание?
* */
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
        //config.getServletContext().getRequestDispatcher("/src/main/webapp/index.jsp").forward(servletRequest, servletResponse);
        //servletResponse.getWriter().println("<h1>Hello World, to second form</h2>");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
