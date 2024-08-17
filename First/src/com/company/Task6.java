package com.company;

// импорт моего static класса для ввода данных
import static com.company.InputData.inputIntNumber;

/**
 Пользователь вводит с клавиатуры количество метров.
 В зависимости от выбора пользователя программа переводит метры в мили, дюймы или ярды
 */
public class Task6 {
    public static int START_MENU = 1;
    public static int LAST_MENU = 3;
    public static double MILES = 0.000621371;
    public static double INCHES = 39.3701;
    public static double YARD = 1.09361;

    public static void main(String[] args) {
        int meters = inputIntNumber("Enter meters: ", "Invalid input meters...");

        int userChoice = inputIntNumber(
                "Choice menu: 1 - miles, 2 - inches, 3 - yard: ",
                "Invalid choice menu..."
        );
        if (!isValidateChoiceMenu(userChoice)) {
            System.out.println("Invalid choice menu...");
            return;
        }

        double result = convertMeters(meters, userChoice);
        if (result != -1) {
            System.out.println("Your result: " + result);
        }
        else {
            System.out.println("Your result: N/A");
        }
    }

    private static double convertMeters(int meters, int choice) {
        return switch (choice) {
            case 1 -> meters * MILES;
            case 2 -> meters * INCHES;
            case 3 -> meters * YARD;
            default -> -1;
        };
    }

    private static boolean isValidateChoiceMenu(int num) {
        return num >= START_MENU && num <= LAST_MENU;
    }
}
