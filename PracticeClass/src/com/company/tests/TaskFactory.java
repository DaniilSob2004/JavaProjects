package com.company.tests;

import java.time.LocalDate;

import com.company.*;

public class TaskFactory {
    public static Human getHuman() {
        String firstName = TestUtils.getRandomFirstName();
        String lastName = TestUtils.getRandomLastName();
        LocalDate birthDate = TestUtils.getRandomDate();
        String phone = TestUtils.getRandomPhone();
        String city = TestUtils.getRandomCity();
        String country = TestUtils.getRandomCountry();
        String address = TestUtils.getRandomStreet();
        return new Human(firstName, lastName, birthDate, phone, city, country, address);
    }

    public static City getCity() {
        String title = TestUtils.getRandomCity();
        String region = TestUtils.getRandomRegion();
        String country = TestUtils.getRandomCountry();
        int population = TestUtils.getRandomInteger(10000);
        String postalCode = TestUtils.getRandomNumberString();
        String telCode = TestUtils.getRandomNumberString();
        return new City(title, region, country, population, postalCode, telCode);
    }

    public static Country getCountry() {
        String title = TestUtils.getRandomCountry();
        String continent = TestUtils.getRandomContinent();
        int population = TestUtils.getRandomInteger(10000);
        String telCode = TestUtils.getRandomNumberString();
        String capitalTitle = TestUtils.getRandomCity();
        String[] cities = TestUtils.getRandomCities();
        return new Country(title, continent, population, telCode, capitalTitle, cities);
    }

    public static Fraction getFraction() {
        int numerator = TestUtils.getRandomInteger(1, 100);
        int denominator = TestUtils.getRandomInteger(1, 100);
        return new Fraction(numerator, denominator);
    }

    public static Book getBook() {
        String title = TestUtils.getRandomAnyTitles();
        String author = TestUtils.getRandomFirstName() + " " + TestUtils.getRandomLastName();
        int year = TestUtils.getRandomInteger(1800, 2024);
        String publishingName = TestUtils.getRandomAnyTitles();
        String genre = TestUtils.getRandomBookGenre();
        int pages = TestUtils.getRandomInteger(10, 2000);
        return new Book(title, author, year, publishingName, genre, pages);
    }

    public static Car getCar() {
        String title = TestUtils.getRandomCarModel();
        String manufacturer = TestUtils.getRandomAnyTitles();
        int year = TestUtils.getRandomInteger(1800, 2024);
        float engine = TestUtils.getRandomFloat(1f, 5f);
        return new Car(title, manufacturer, year, engine);
    }
}
