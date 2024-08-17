package com.company;

// импорт моего static класса для ввода данных
import static com.company.InputData.inputIntNumber;

/**
 Пользователь вводит с клавиатуры номер месяца.
 В зависимости от полученного номера месяца программа выводит на экран надпись:
   - Winter (если введено значение 1,2 или 12)
   - Spring (если введено значение от 3 до 5)
   - Summer (если введено значение от 6 до 8)
   - Autumn (если введено значение от 9 до 11)
 */
public class Task5 {
    public static int FIRST_MONTH = 1;
    public static int LAST_MONTH = 12;

    public static void main(String[] args) {
        int month = inputIntNumber("Enter month number: ", "Invalid month number...");

        if (!isMonthNumber(month)) {
            System.out.println("Invalid month number...");
            return;
        }

        switch (month) {
            case 3:
            case 4:
            case 5:
                System.out.println("Spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Summer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Autumn");
                break;
            default:
                System.out.println("Winter");
        }
    }

    private static boolean isMonthNumber(int num) {
        return num >= FIRST_MONTH && num <= LAST_MONTH;
    }
}
