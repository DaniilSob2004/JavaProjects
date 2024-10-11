package com.example.AutoBase.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public enum Endpoints {
    // all
    MAIN("/"),
    MAIN_2("/main"),
    LOGIN("/login"),
    REGISTRATION("/registration"),
    LOGOUT_SUCCESSFUL("/logoutSuccessful"),

    // auth users (driver)
    LOGOUT("/logout"),
    USER_INFO("/userInfo"),
    FLIGHT_CAR_BROKE_DOWN("/flight/car-broke-down"),

    // admin
    FLIGHTS_GET("/flights/get"),
    FLIGHT_PASSED_DAY_WAY("/flights/passed-day-way"),
    ORDERS_GET("/orders/get"),
    ORDER_CREATE_VIEW("/order/create"),
    ORDER_CREATE("/order/create"),
    ORDER_TO_FLIGHT("/order/to-flight"),
    ORDER_DELETE("/order/delete")
    ;

    private final String endPoint;

    static public List<Endpoints> getEndpointForAllUsers() {
        List<Endpoints> endpoints = new ArrayList<>();
        endpoints.add(MAIN);
        endpoints.add(MAIN_2);
        endpoints.add(LOGIN);
        endpoints.add(REGISTRATION);
        endpoints.add(LOGOUT_SUCCESSFUL);
        return endpoints;
    }

    static public List<Endpoints> getEndpointForAdmin() {
        List<Endpoints> endpoints = new ArrayList<>();
        endpoints.add(FLIGHTS_GET);
        endpoints.add(FLIGHT_PASSED_DAY_WAY);
        endpoints.add(ORDERS_GET);
        endpoints.add(ORDER_CREATE_VIEW);
        endpoints.add(ORDER_CREATE);
        endpoints.add(ORDER_TO_FLIGHT);
        endpoints.add(ORDER_DELETE);
        return endpoints;
    }

    static public List<Endpoints> getEndpointForAdminAndAuthUser() {
        List<Endpoints> endpoints = new ArrayList<>();
        endpoints.add(LOGOUT);
        endpoints.add(USER_INFO);
        endpoints.add(FLIGHT_CAR_BROKE_DOWN);
        return endpoints;
    }
}
