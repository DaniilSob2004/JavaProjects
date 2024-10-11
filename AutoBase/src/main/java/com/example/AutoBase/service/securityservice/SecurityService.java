package com.example.AutoBase.service.securityservice;

public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
