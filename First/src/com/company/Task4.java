package com.company;

// импорт моего static класса для ввода данных
import static com.company.InputData.inputIntNumber;

/**
 Пользователь вводит шестизначное число.
 Необходимопоменять в этом числе первую и шестую цифры, а также вторую и пятую цифры
 */
public class Task4 {
    public static void main(String[] args) {
        int number = inputIntNumber("Enter a six-digit number: ", "Invalid input number...");

        if (!isValidSixDigitNumber(Integer.toString(number))) {
            System.out.println(number + " is not a valid six digit number");
            return;
        }

        int firstDigit = number / 100000;
        int sixthDigit = number % 10;
        int secondDigit = (number / 10000) % 10;
        int fifthDigit = (number % 100) / 10;

        // change first and last
        number = number - ((firstDigit - sixthDigit) * 100000);
        number = number + (firstDigit - sixthDigit);

        // change second and fifth
        number = number + ((secondDigit - fifthDigit) * 10);
        number = number + ((fifthDigit - secondDigit) * 10000);

        System.out.println(number);
    }

    private static boolean isValidSixDigitNumber(String strNum) {
        return strNum.matches("\\d{6}");
    }
}
