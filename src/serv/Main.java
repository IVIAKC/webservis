package serv;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import org.hibernate.Session;
/**
 * Created by IVIAKC on 06.11.2015.
 */
public class Main extends HttpServlet {
    public static void main(String[] args) {
        HibernateUtil wdb = new HibernateUtil();
        System.out.println(wdb.checkUser("IVIAKC","qwe"));

    }
}
