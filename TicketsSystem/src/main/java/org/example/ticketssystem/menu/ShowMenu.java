package org.example.ticketssystem.menu;

public class ShowMenu {
    public static final int MIN_MENU_NUM = 1;

    private static final String[] menuTitles = new String[] {
            "Create event",
            "Create customer",
            "Search free tickets by event",
            "Search nearest events",
            "Give the user a ticket",
            "Exit"
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
