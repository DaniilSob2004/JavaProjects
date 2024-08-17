package com.company;

/**
 Напишите метод, который отображает горизонтальную или вертикальную линию из некоторого символа.
 Метод принимает в качестве параметра: длину линии, направление, символ
 */
public class Task11 {
    private enum Direction {
        VERTICAL,
        HORIZONTAL
    }

    public static void main(String[] args) {
        showLine('*', 15, Direction.HORIZONTAL);
        showLine('-', 5, Direction.VERTICAL);
    }

    public static void showLine(char symbol, int len, Direction direction) {
        for (int i = 0; i < len; i++) {
            System.out.print(symbol);
            if (direction == Direction.VERTICAL) {
                System.out.print("\n");
            }
        }
        System.out.println();
    }
}
