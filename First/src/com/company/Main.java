package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

/** Java-DOC comment */

class Demo {
    public void show() {
        System.out.println("Метод суперкласса");
    }
}

interface Hello {
    void show();
}

public class Main {
    static Hello hello = new Hello() {
        public void show() {
            System.out.println("Метод внутреннего анонимного класса");
        }
    };

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.show();

        Demo demo2 = new Demo() {
            @Override
            public void show() {
                System.out.println("Метод внутреннего анонимного класса");
            }
        };
        demo2.show();

        // ----------------------------------

        System.out.println("-".repeat(30));
        hello.show();

        // ----------------------------------

        System.out.println("-".repeat(30));
    }
}