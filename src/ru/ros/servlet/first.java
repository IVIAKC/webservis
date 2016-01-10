package ru.ros.servlet;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
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
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{


        resp.setContentType("text/html; charset=UTF-8");

        JsonReader reader = Json.createReader(req.getInputStream());
        JsonObject newJson = reader.readObject();
        reader.close();


        PrintWriter out = resp.getWriter();


        out.print(hibernate.check(newJson.getString("login"), newJson.getString("password")));
    }

}