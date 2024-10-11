package org.example.ticketssystem.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public enum Endpoints {
    // all
    HOME("/"),
    HOME_2("/main"),
    LOGIN("/login"),
    REGISTRATION("/registration"),
    LOGOUT("/logout"),
    LOGOUT_SUCCESSFUL("/logoutSuccessful"),

    // admin
    CUSTOMERS_GET("/customers/get"),
    CUSTOMER_CREATE_VIEW("/customer/create"),
    CUSTOMER_CREATE("/customer/create"),
    EVENTS_GET("/events/get"),
    EVENT_CREATE_VIEW("/event/create"),
    EVENT_CREATE("/event/create"),

    // user
    CUSTOMER_INFO("/customerInfo"),
    CUSTOMER_GET_TICKET_VIEW("/customer/getTicket"),
    CUSTOMER_GET_TICKET("/customer/getTicket"),
    EVENTS_GET_NEAREST_VIEW("/events/getNearest"),
    EVENTS_GET_NEAREST("/events/getNearest"),
    TICKETS_GET_BY_EVENT_VIEW("/tickets/getByEvent"),
    TICKETS_GET_BY_EVENT("/tickets/getByEvent"),
    ;

    private final String endPoint;

    static public List<Endpoints> getEndpointForAllUsers() {
        List<Endpoints> endpoints = new ArrayList<>();
        endpoints.add(HOME);
        endpoints.add(HOME_2);
        endpoints.add(LOGIN);
        endpoints.add(REGISTRATION);
        endpoints.add(LOGOUT);
        endpoints.add(LOGOUT_SUCCESSFUL);
        return endpoints;
    }

    static public List<Endpoints> getEndpointForAdmin() {
        List<Endpoints> endpoints = new ArrayList<>();
        endpoints.add(CUSTOMERS_GET);
        endpoints.add(CUSTOMER_CREATE_VIEW);
        endpoints.add(CUSTOMER_CREATE);
        endpoints.add(EVENTS_GET);
        endpoints.add(EVENT_CREATE_VIEW);
        endpoints.add(EVENT_CREATE);
        return endpoints;
    }

    static public List<Endpoints> getEndpointForAdminAndAuthUser() {
        List<Endpoints> endpoints = new ArrayList<>();
        endpoints.add(CUSTOMER_INFO);
        endpoints.add(CUSTOMER_GET_TICKET_VIEW);
        endpoints.add(CUSTOMER_GET_TICKET);
        endpoints.add(EVENTS_GET_NEAREST_VIEW);
        endpoints.add(EVENTS_GET_NEAREST);
        endpoints.add(TICKETS_GET_BY_EVENT_VIEW);
        endpoints.add(TICKETS_GET_BY_EVENT);
        return endpoints;
    }
}
