package org.example.ticketssystem.menu;

import org.example.ticketssystem.dto.*;
import org.example.ticketssystem.model.Customer;
import org.example.ticketssystem.model.Event;
import org.example.ticketssystem.model.Ticket;
import org.example.ticketssystem.service.createeventservice.CreateEventServiceImpl;
import org.example.ticketssystem.service.customerservice.CustomerService;
import org.example.ticketssystem.service.eventservice.EventService;
import org.example.ticketssystem.service.ticketservice.TicketService;
import org.example.ticketssystem.utils.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketMenu {

    @Autowired
    private CreateEventServiceImpl createEventService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EventService eventService;

    @Autowired
    private TicketService ticketService;


    public void show() {
        System.out.println("CoffeeShop menu:");
        ShowMenu.show();
    }

    public int getChoice() {
        int maxChoice = ShowMenu.getSizeMenu();
        return Input.inputInteger(
                "\nPlease enter the number menu: ",
                "Invalid choice, need from " + ShowMenu.MIN_MENU_NUM + " to " + maxChoice,
                ShowMenu.MIN_MENU_NUM,
                maxChoice
        );
    }


    public void menuItem1Execute() {
        // Create event

        LocalDate eventDate = Input.inputDate("Input events date");
        String name = Input.inputString("Input events name: ", "Error, events name must be not null...");

        List<TicketPackDTO> ticketPacksDto = inputTicketsPack();

        String address = Input.inputString("Input place address: ", "Error, address must be not null...");
        String placeName = Input.inputString("Input place name: ", "Error, place name must be not null...");
        PlaceDTO placeDto = new PlaceDTO(address, placeName);

        EventCreationDTO eventCreationDTO = new EventCreationDTO(eventDate, name, ticketPacksDto, placeDto);

        String message = (createEventService.CreateEventByDto(eventCreationDTO))
                ? "Create event successful..."
                : "Several events on one day in one place...";
        System.out.println(message);
    }

    public void menuItem2Execute() {
        // Create customer

        String name = Input.inputString("Input customer name: ", "Error, name must be not null...");
        String email = Input.inputString("Input customer email: ", "Error, email must be not null...");
        String phone = Input.inputString("Input customer phone: ", "Error, phone must be not null...");

        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);

        Customer newCustomer = customerService.save(customer);
        String message = (newCustomer == null)
                ? "Customer creation failed..."
                : "Customer successfully created...";
        System.out.println(message);
    }

    public void menuItem3Execute() {
        // Search free tickets by event

        // dto для вывода Events
        List<EventDTO> eventsDto = eventService.findAllDTO();
        eventsDto.forEach(event -> {
            System.out.println(
                    "Event id: " + event.getId() + " | " +
                    "Event name: " + event.getName() + " | " +
                    "Event date: " + event.getEventDate() + " | " +
                    "Event place name: " + event.getPlaceName()
            );
        });

        int eventId = getInputId("Input event id: ");

        // получаем список Tickets
        List<Ticket> tickets = ticketService.findTicketsByEventAndStatus(eventId, "FREE");
        if (tickets == null || tickets.isEmpty()) {
            System.out.println("No tickets found...");
        }
        else {
            tickets.forEach(t -> System.out.println(t.getNumber() + " - " + t.getCost()));
        }
    }

    public void menuItem4Execute() {
        // Search nearest events

        LocalDate startDate = Input.inputDate("Input start date");
        LocalDate endDate = Input.inputDate("Input end date");

        List<EventDTO> eventsDto = eventService.findEventsBetweenDates(startDate, endDate);
        if (eventsDto == null || eventsDto.isEmpty()) {
            System.out.println("No tickets found...");
            return;
        }

        eventsDto.forEach(event -> {
            System.out.println(
                    "Event id: " + event.getId() + " | " +
                    "Event name: " + event.getName() + " | " +
                    "Event date: " + event.getEventDate() + " | " +
                    "Event place name: " + event.getPlaceName()
            );
        });
    }

    public void menuItem5Execute() {
        // Give the user a ticket

        // вывод Customers
        List<Customer> customers = customerService.findAll();
        customers.forEach(c -> System.out.println(c.getId() + " - " + c.getName() + c.getEmail()));

        int customerId = getInputId("Input customer id: ");

        // dto для вывода Events
        List<EventDTO> eventsDto = eventService.findAllDTO();
        eventsDto.forEach(event -> {
            System.out.println(
                    "Event id: " + event.getId() + " | " +
                    "Event name: " + event.getName() + " | " +
                    "Event date: " + event.getEventDate() + " | " +
                    "Event place name: " + event.getPlaceName()
            );
        });

        int eventId = getInputId("Input event id: ");

        // получаем свободный Ticket
        Ticket ticketFree = ticketService.findFirstTicketByEventAndStatusAndCustomerNull(eventId, "FREE").orElse(null);
        if (ticketFree == null) {
            System.out.println("No ticket found...");
            return;
        }

        // присваиваем Ticket нашему Customer
        System.out.println("Ticket found: " + ticketFree.getNumber() + " - " + ticketFree.getCost() + " - " + ticketFree.getId());
        Customer customer = customerService.findById(customerId).orElse(null);
        if (customer == null) {
            System.out.println("No customer found...");
            return;
        }
        ticketFree.setCustomer(customer);
        ticketService.save(ticketFree);

        System.out.println("A ticket has been successfully added to the customer...");
    }


    public boolean execute(int choiceMenu) {
        switch (choiceMenu) {
            case 1:
                menuItem1Execute();
                break;
            case 2:
                menuItem2Execute();
                break;
            case 3:
                menuItem3Execute();
                break;
            case 4:
                menuItem4Execute();
                break;
            case 5:
                menuItem5Execute();
                break;
            default:
                return false;
        }
        return true;
    }


    private List<TicketPackDTO> inputTicketsPack() {
        List<TicketPackDTO> ticketPacksDto = new ArrayList<>();

        int from = 1;
        int to = 5;
        int count = Input.inputInteger(
                "Input count tickets pack: ",
                "Error, count must be from " + from + " to " + to,
                from, to
        );

        int fromPrice = 10;
        int toPrice = 1000;
        int fromQuantity = 1;
        int toQuantity = 100;
        for (int i = 0; i < count; i++) {
            int price = Input.inputInteger(
                    "Input price tickets: ",
                    "Error, price must be from " + fromPrice + " to " + toPrice,
                    fromPrice, toPrice
            );
            int quantity = Input.inputInteger(
                    "Input quantity tickets: ",
                    "Error, quantity must be from " + fromQuantity + " to " + toQuantity,
                    fromQuantity, toPrice
            );
            ticketPacksDto.add(new TicketPackDTO(price, quantity));
        }

        return ticketPacksDto;
    }

    private int getInputId(String text) {
        int minId = 1;
        int maxId = 100000;
        return Input.inputInteger(
                text,
                "Id от " + minId + " до " + maxId + "...",
                minId, maxId
        );
    }
}
