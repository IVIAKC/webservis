package ru.ros.servlet;

/**
 * Created by IVIAKC on 10.01.2016.
 */
public class main {
    public static void main(String[] args){
        hibernate hib = new hibernate();
        System.out.println(hib.check("IVI","qwe"));
    }
}