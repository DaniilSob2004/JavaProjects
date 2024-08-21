package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Country {
    private String title;
    private String continent;
    private int population;
    private String telCode;
    private String capitalTitle;
    private String[] cities;

    public Country() {
        this("", "", 0, "", "", null);
    }

    public Country(
            String title,
            String continent) {
        this(title, continent, 0, "", "", null);
    }

    public Country(
            String title,
            String continent,
            String[] cities) {
        this(title, continent, 0, "", "", cities);
    }

    public Country(
            String title,
            String continent,
            int population,
            String telCode,
            String capitalTitle,
            String[] cities) {
        this.title = title;
        this.continent = continent;
        this.population = population;
        this.telCode = telCode;
        this.capitalTitle = capitalTitle;
        setCities(cities);
    }


    public void print() {
        System.out.println("---------- Country info ----------");
        System.out.println("Title: " + title);
        System.out.println("Continent: " + continent);
        System.out.println("Population: " + population);
        System.out.println("Tel Code: " + telCode);
        System.out.println("Capital Title: " + capitalTitle);

        printCities();
    }

    public void printCities() {
        printCities(cities.length);
    }

    public void printCities(int count) {
        if (count > cities.length) {
            count = cities.length;
        }

        System.out.print("Cities: ");
        for (int i = 0; i < count; i++) {
            System.out.print(cities[i]);
            if (i < count - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input title: ");
        this.title = scanner.nextLine();

        System.out.print("Input continent: ");
        this.continent = scanner.nextLine();

        System.out.print("Input population: ");
        this.population = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Input tel code: ");
        this.telCode = scanner.nextLine();

        System.out.print("Input capital title: ");
        this.capitalTitle = scanner.nextLine();

        System.out.print("Input cities (0 - cancel input): ");
        String userCity = null;
        do {
            userCity = scanner.nextLine();
        } while(!userCity.equals("0"));

        scanner.close();
    }


    public String getTitle() {
        return title;
    }

    public String getContinent() {
        return continent;
    }

    public int getPopulation() {
        return population;
    }

    public String getTelCode() {
        return telCode;
    }

    public String getCapitalTitle() {
        return capitalTitle;
    }

    public String[] getCities() {
        // TODO проверка на null и выбросить исключение если null
        return Arrays.copyOf(cities, cities.length);
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setCities(String[] cities) {
        if (cities != null) {
            this.cities = Arrays.copyOf(cities, cities.length);
        }
    }

    public void setCapitalTitle(String capitalTitle) {
        this.capitalTitle = capitalTitle;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setTelCode(String telCode) {
        this.telCode = telCode;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
