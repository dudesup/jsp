package org.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="HelloServlet", value="/hello", loadOnStartup = 1)


public class HelloServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Server initialized"+HelloServlet.class.getSimpleName());

    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Servlet destroyed" + HelloServlet.class.getSimpleName());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String surname=req.getParameter("surname");

        PrintWriter printWriter=resp.getWriter();
        printWriter.print(name+" "+surname);
    }
}
