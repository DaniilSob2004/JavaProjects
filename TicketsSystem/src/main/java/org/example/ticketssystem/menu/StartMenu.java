package org.example.ticketssystem.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StartMenu {

    @Autowired
    private TicketMenu ticketMenu;

    public void start() {
        ticketMenu.show();

        int numMenu;
        boolean isNotExit;
        do {
            numMenu = ticketMenu.getChoice();
            isNotExit = ticketMenu.execute(numMenu);
        } while(isNotExit);

        System.out.println("You are exit!");
    }
}
