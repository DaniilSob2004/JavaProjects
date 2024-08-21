package com.company;

import java.util.Scanner;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        this(1, 1);
    }

    public Fraction(int numerator) {
        this(numerator, 1);
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        setDenominator(denominator);
    }


    public void print() {
        System.out.println(numerator + "/" + denominator);
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input numerator: ");
        this.numerator = scanner.nextInt();

        System.out.print("Input denominator: ");
        int denominator = scanner.nextInt();
        setDenominator(denominator);

        scanner.nextInt();

        scanner.close();
    }

    public Fraction add(Fraction other) {
        int commonDenominator = this.denominator * other.denominator;
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        return new Fraction(newNumerator, commonDenominator);
    }

    public Fraction subtract(Fraction other) {
        int commonDenominator = this.denominator * other.denominator;
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        return new Fraction(newNumerator, commonDenominator);
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            return null;
        }
        return new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);
    }


    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }


    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator == 0 ? 1 : denominator;
    }
}
