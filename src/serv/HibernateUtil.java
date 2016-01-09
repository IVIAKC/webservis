package serv;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;


public class HibernateUtil{


    private static SessionFactory dbSessions;

    private void createSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure("/src/hibernate.cfg.xml");
        configuration.addAnnotatedClass(Person.class);
        configuration.buildSessionFactory();
    }

    public String checkUser(String login, String pas) {
        createSessionFactory();
        Session session = dbSessions.openSession();
        try
        {
            Query query = session.createQuery("from serv.Person where login = :login AND pas = :pas");
            query.setParameter("login", login);
            query.setParameter("pas", pas);
            List list = query.list();
            String otv ="";
            for (Iterator iterator = list.iterator(); iterator.hasNext();)
            {
                Person fm = (Person) iterator.next();
                otv = otv + "Привет " + fm.getFirst_name() + " " + fm.getLast_name();
                //System.out.print("Last name: " + fm.getLastName() + "\nFirst name: " + fm.getFirstName() + "\nMiddle name: " + fm.getMiddleName() + "\nAge: " + fm.getAge() + "\n\n");
            }
            if (otv == "") otv = "Ошибка";
            return otv;
        }
        catch (HibernateException e) {e.printStackTrace();} finally {session.close();}
        return "error";
    }
}