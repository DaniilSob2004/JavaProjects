package org.example.menu;

public class ShowMenu {
    public static final int MIN_MENU_NUM = 1;

    private static final String[] menuTitles = new String[] {
            "Добавить ассортимент",
            "Добавить бариста",
            "Добавить кондитера",
            "Добавить клиента",
            "Изменить email кондитеру",
            "Изменить номер тел баристу",
            "Изменить скидку клиента",
            "Удалить десерт",
            "Удалить официанта",
            "Удалить бариста",
            "Удалить клиента",
            "Вывод напитков",
            "Вывод десертов",
            "Вывод баристов",
            "Вывод официантов",
            "Выход"
    };

    public static void show() {
        for (int i = 0; i < menuTitles.length; i++) {
            System.out.println("\t" + (i + 1) + ". " + menuTitles[i]);
        }
    }

    public static int getSizeMenu() {
        return menuTitles.length;
    }
}
