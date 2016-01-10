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

    private void createFactory(){

        factory = new AnnotationConfiguration().configure().addAnnotatedClass(mytable.class).buildSessionFactory();
    }
    public String check(String login,String password){
        if(factory==null){
            createFactory();
        }
        Session session = factory.openSession();


        try {
            Query query = session.createQuery("FROM mytable WHERE login = :log");

            query.setParameter("log", login);

            List usersList = query.list();

            mytable user = (mytable) usersList.iterator().next();
            return "Добро пожаловать " + user.getFirst_name() + " " + user.getLast_name();
        }catch (HibernateException e){
            e.printStackTrace();
        }catch (NoSuchElementException e){
            return " asd Простите, но ваш логин или пароль введён неверно. Пожалуйста, введите снова пароль и логин";
        }finally {
            session.close();
        }
        return "Простите, но ваш логин или пароль введён неверно. Пожалуйста, введите снова пароль и логин";

    }
}
