package ru.ros.servlet;

/**
 * Created by IVIAKC on 10.01.2016.
 */
public class Main {
    public static void main(String[] args){
        Hibernate hib = new Hibernate();
        System.out.println(hib.check("IVIAKC","qwe"));
    }
}
