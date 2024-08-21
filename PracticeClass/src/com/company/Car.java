package com.company;

import java.time.LocalDate;
import java.util.Scanner;

public class Car {
    private String title;
    private String manufacturer;
    private int year;
    private float engine;

    public Car() {
        this("", "", 0, 0f);
    }

    public Car(String title, String manufacturer, int year, float engine) {
        this.title = title;
        this.manufacturer = manufacturer;
        this.year = year;
        this.engine = engine;
    }


    public void print() {
        System.out.println("---------- Car info ----------");
        System.out.println("Title: " + title);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Year: " + year);
        System.out.println("Engine capacity: " + String.format("%.1f", engine));
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input title: ");
        this.title = scanner.nextLine();

        System.out.print("Input manufacturer: ");
        this.manufacturer = scanner.nextLine();

        System.out.print("Input year: ");
        this.year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Input engine: ");
        this.engine = scanner.nextFloat();
        scanner.nextLine();

        scanner.close();
    }


    public String getTitle() {
        return title;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getYear() {
        return year;
    }

    public float getEngine() {
        return engine;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setEngine(float engine) {
        this.engine = engine;
    }
}
