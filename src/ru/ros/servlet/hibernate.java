package ru.ros.servlet;

import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * Created by IVIAKC on 10.01.2016.
 */
public class hibernate {
    private static SessionFactory factory;

    private static void createFactory(){
        factory = new AnnotationConfiguration().configure("/resources/hibernate.cfg.xml").addAnnotatedClass(mytable.class).buildSessionFactory();
    }

    public static String check(String login, String password){
        if(factory==null){
            createFactory();
        }
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("FROM mytable WHERE login = :log AND password = :pass");

            query.setParameter("log", login);
            query.setParameter("pass", password);
            List usersList = query.list();

            mytable user = (mytable) usersList.iterator().next();
            return "Добро пожаловать " + user.getFirst_name() + " " + user.getLast_name();
        }catch (HibernateException e){
            e.printStackTrace();
        }catch (NoSuchElementException e){
            return "Аля-улю";
        }finally {
            session.close();
        }

        return "Неправильно ввели пароль или логин";

    }
}
