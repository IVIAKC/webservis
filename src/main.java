import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;
/**
 * Created by IVIAKC on 13.11.2015.
 */
public class Main {

    private  static SessionFactory dbSessions;

    public static void main (String[] args){

        Main caller = new Main();

        dbSessions = new AnnotationConfiguration()
                .configure("/resources/hibernate.cfg.xml")
                .addAnnotatedClass(tes.class)
                .buildSessionFactory();

        dbSessions.close();

    }

    private void getAllTes(){
        Session session = dbSessions.openSession();
        try{
            List tesList = session.createQuery("FROM tes").list();

        }
        catch (HibernateException e){e.printStackTrace();}
        finally {
            session.close();
        }


    }
}
