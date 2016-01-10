package ru.ros.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IVIAKC on 06.11.2015.
 */

@WebServlet("/login")
public class first extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        hibernate hib = new hibernate();
        String otv ="";
        otv=hib.check(username,password);
        out.println(otv);

    }

}