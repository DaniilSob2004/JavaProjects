package com.company;

import java.util.Scanner;

public class City {
    private String title;
    private String region;
    private String country;
    private int population;
    private String postalCode;
    private String telCode;

    public City() {
        this("", "", "", 0, "", "");
    }

    public City(
            String title,
            String region,
            String country) {
        this(title, region, country, 0, "", "");
    }

    public City(
            String title,
            String region,
            String country,
            int population,
            String postalCode,
            String telCode) {
        this.title = title;
        this.telCode = telCode;
        this.postalCode = postalCode;
        this.population = population;
        this.country = country;
        this.region = region;
    }


    public void print() {
        System.out.println("---------- City info ----------");
        System.out.println("Title: " + title);
        System.out.println("Region: " + region);
        System.out.println("Country: " + country);
        System.out.println("Population: " + population);
        System.out.println("Postal Code: " + postalCode);
        System.out.println("Tel Code: " + telCode);
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input title: ");
        this.title = scanner.nextLine();

        System.out.print("Input region: ");
        this.region = scanner.nextLine();

        System.out.print("Input country: ");
        this.country = scanner.nextLine();

        System.out.print("Input population: ");
        this.population = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Input postal code: ");
        this.postalCode = scanner.nextLine();

        System.out.print("Input tel code: ");
        this.telCode = scanner.nextLine();

        scanner.close();
    }


    public String getTitle() {
        return title;
    }

    public String getTelCode() {
        return telCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public int getPopulation() {
        return population;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }


    public void setName(String title) {
        this.title = title;
    }

    public void setTelCode(String telCode) {
        this.telCode = telCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
