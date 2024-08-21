package com.company;

import java.time.LocalDate;
import java.util.Scanner;

public class Book {
    private String title;
    private String author;
    private int year;
    private String publishingName;
    private String genre;
    private int pages;

    public Book() {
        this("", "", 0, "", "", 0);
    }

    public Book(
            String title,
            String author) {
        this(title, author, 0, "", "", 0);
    }

    public Book(
            String title,
            String author,
            int year,
            String publishingName,
            String genre,
            int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.publishingName = publishingName;
        this.genre = genre;
        this.pages = pages;
    }


    public void print() {
        System.out.println("---------- Book info ----------");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
        System.out.println("Publishing name: " + publishingName);
        System.out.println("Genre: " + genre);
        System.out.println("Pages: " + pages);
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input title: ");
        this.title = scanner.nextLine();

        System.out.print("Input author: ");
        this.author = scanner.nextLine();

        System.out.print("Input year: ");
        this.year = scanner.nextInt();

        scanner.nextInt();

        System.out.print("Input publishing name: ");
        this.publishingName = scanner.nextLine();

        System.out.print("Input genre: ");
        this.genre = scanner.nextLine();

        System.out.print("Input pages: ");
        this.pages = scanner.nextInt();

        scanner.nextInt();

        scanner.close();
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getPublishingName() {
        return publishingName;
    }

    public String getGenre() {
        return genre;
    }

    public int getPages() {
        return pages;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPublishingName(String publishingName) {
        this.publishingName = publishingName;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
