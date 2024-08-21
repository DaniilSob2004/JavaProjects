package com.company;

import com.company.tests.TaskFactory;

public class Main {
    public static void main(String[] args) {
        Human human = TaskFactory.getHuman();
        human.print();

        System.out.println("--------------------");

        City city = TaskFactory.getCity();
        city.print();

        System.out.println("--------------------");

        Country country = TaskFactory.getCountry();
        country.print();

        System.out.println("--------------------");

        Fraction fraction = TaskFactory.getFraction();
        fraction.print();
        System.out.println("+");
        Fraction fraction2 = TaskFactory.getFraction();
        fraction2.print();
        System.out.println("=");
        Fraction fraction3 = fraction.add(fraction2);
        fraction3.print();

        System.out.println("--------------------");

        human.input();
        human.print();

        System.out.println("--------------------");

        Book book = TaskFactory.getBook();
        book.print();

        System.out.println("--------------------");

        Car car = TaskFactory.getCar();
        car.print();
        car.input();
        car.print();
    }
}