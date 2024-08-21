package com.company;

import java.time.LocalDate;
import java.util.Scanner;

public class Human {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String phone;
    private String city;
    private String country;
    private String address;

    public Human() {
        this("Username", "", null, "", "", "", "");
    }

    public Human(
            String firstName,
            String lastName) {
        this(firstName, lastName, null, "", "", "", "");
    }

    public Human(
            String firstName,
            String lastName,
            LocalDate birthDate,
            String phone,
            String city,
            String country,
            String address) {
        this.firstName = firstName;
        this.address = address;
        this.country = country;
        this.city = city;
        this.phone = phone;
        this.birthDate = birthDate;
        this.lastName = lastName;
    }


    public void print() {
        System.out.println("---------- People info ----------");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Birthdate: " + (birthDate == null ? "" : birthDate.toString()));
        System.out.println("Phone: " + phone);
        System.out.println("City: " + city);
        System.out.println("Country: " + country);
        System.out.println("Address: " + address);
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input your first name: ");
        this.firstName = scanner.nextLine();

        System.out.print("Input your last name: ");
        this.lastName = scanner.nextLine();

        System.out.print("Input your 'day' birth date: ");
        int day = scanner.nextInt();
        System.out.print("Input your 'month' birth date: ");
        int month = scanner.nextInt();
        System.out.print("Input your 'year' birth date: ");
        int year = scanner.nextInt();
        this.birthDate = LocalDate.of(year, month, day);

        scanner.nextLine();

        System.out.print("Input your phone number: ");
        this.phone = scanner.nextLine();

        System.out.print("Input your city: ");
        this.city = scanner.nextLine();

        System.out.print("Input your country: ");
        this.country = scanner.nextLine();

        System.out.print("Input your address: ");
        this.address = scanner.nextLine();

        scanner.close();
    }


    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
