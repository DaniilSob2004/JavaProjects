package com.company.tests;

import com.company.City;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class TestUtils {
    private static final String[] FIRST_NAMES = {
            "Daniil", "Bob", "Thomas", "Robert", "Andrey", "Max", "Tom", "Anna", "Ksenia", "Daniel"
    };
    private static final String[] LAST_NAMES = {
            "Sobolev", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez"
    };
    private static final String[] CITIES = {
            "New York", "Odessa", "Kiev", "London", "Madrid", "Berlin", "Paris", "Kharkiv", "Toronto", "Tbilisi"
    };
    private static final String[] COUNTRIES = {
            "USA", "Ukraine", "Italia", "Spain", "India", "China", "Japan", "Canada", "Germany", "France"
    };
    private static final String[] STREETS = {
            "St 1", "St 2", "St 3", "St 4", "St 5", "St 6", "St 7", "St 8", "St 9", "St 10"
    };
    private static final String[] REGIONS = {
            "California", "Texas", "Florida", "New York", "Illinois", "Pennsylvania", "Ohio", "Georgia", "North Carolina", "Michigan"
    };
    private static final String[] CONTINENTS = {
            "Africa", "Asia", "Europe", "North America", "South America", "Australia", "Antarctica", "Oceania", "Central America", "Middle East"
    };
    private static final String[] ANY_TITLES = {
            "To Kill a Mockingbird",
            "1984",
            "Pride and Prejudice",
            "The Great Gatsby",
            "One Hundred Years of Solitude",
            "Moby-Dick",
            "War and Peace",
            "Brave New World",
            "The Catcher in the Rye",
            "The Lord of the Rings"
    };
    private static final String[] BOOK_GENRES = {
            "Science Fiction",
            "Fantasy",
            "Mystery",
            "Thriller",
            "Romance",
            "Historical Fiction",
            "Non-Fiction",
            "Biography",
            "Horror",
            "Young Adult"
    };
    private static final String[] CAR_MODELS = {
            "Toyota Camry",
            "Honda Accord",
            "Ford Mustang",
            "Chevrolet Malibu",
            "BMW 3 Series",
            "Audi A4",
            "Mercedes-Benz C-Class",
            "Tesla Model S",
            "Nissan",
            "Hyundai Sonata"
    };
    private static final Random RAND = new Random();
    private static final int CURRENT_YEAR = Year.now().getValue();
    private static final int SIZE_PHONE = 12;
    private static final int MIN_INT = 1;
    private static final int MAX_INT = 100_000_000;
    private static final int MAX_SIZE_NUM_STRING = 6;


    public static String getRandomFirstName() {
        return FIRST_NAMES[RAND.nextInt(FIRST_NAMES.length)];
    }

    public static String getRandomLastName() {
        return LAST_NAMES[RAND.nextInt(LAST_NAMES.length)];
    }

    public static String getRandomCity() {
        return CITIES[RAND.nextInt(CITIES.length)];
    }

    public static String[] getRandomCities() {
        int countCities = RAND.nextInt(CITIES.length + 1);
        String[] cities = new String[countCities];
        for (int i = 0; i < countCities; i++) {
            cities[i] = CITIES[RAND.nextInt(CITIES.length)];
        }
        return cities;
    }

    public static String getRandomAnyTitles() {
        return ANY_TITLES[RAND.nextInt(ANY_TITLES.length)];
    }

    public static String getRandomStreet() {
        return STREETS[RAND.nextInt(STREETS.length)];
    }

    public static String getRandomRegion() {
        return REGIONS[RAND.nextInt(REGIONS.length)];
    }

    public static String getRandomContinent() {
        return CONTINENTS[RAND.nextInt(CONTINENTS.length)];
    }

    public static String getRandomBookGenre() {
        return BOOK_GENRES[RAND.nextInt(BOOK_GENRES.length)];
    }

    public static String getRandomCountry() {
        return COUNTRIES[RAND.nextInt(COUNTRIES.length)];
    }

    public static String getRandomCarModel() {
        return CAR_MODELS[RAND.nextInt(CAR_MODELS.length)];
    }

    public static LocalDate getRandomDate() {
        long minDay = LocalDate.of(1900, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(CURRENT_YEAR - 10, 12, 31).toEpochDay();
        long randDay = RAND.nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randDay);
    }

    public static String getRandomPhone() {
        StringBuilder phone = new StringBuilder("+");
        for (int i = 0; i < SIZE_PHONE; i++) {
            phone.append(RAND.nextInt(10));
        }
        return phone.toString();
    }

    public static int getRandomInteger() {
        return getRandomInteger(MIN_INT, MAX_INT);
    }

    public static int getRandomInteger(int min) {
        return getRandomInteger(min, MAX_INT);
    }

    public static int getRandomInteger(int min, int max) {
        return RAND.nextInt(min, max);
    }

    public static float getRandomFloat(float min, float max) {
        return RAND.nextFloat(min, max);
    }

    public static String getRandomNumberString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < MAX_SIZE_NUM_STRING; i++) {
            str.append(RAND.nextInt(10));
        }
        return str.toString();
    }
}
