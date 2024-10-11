package org.example.ticketssystem.service.securityservice;

import org.example.ticketssystem.model.Customer;

public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
