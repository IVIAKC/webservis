package ru.ros.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * Created by IVIAKC on 06.11.2015.
 */

@WebServlet("/login")
public class first extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{



        if(hibernate.check(req.getParameter("username"),req.getParameter("password"))){
            resp.getOutputStream().write("good".getBytes());
        }else{
            resp.getOutputStream().write("xyelt".getBytes());
        }

    }

}