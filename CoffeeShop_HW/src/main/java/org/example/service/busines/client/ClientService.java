package org.example.service.busines.client;

import org.example.model.Client;

import java.util.List;

public interface ClientService {
    void addClient(Client client);
    List<Client> getAllClients();
    Client getClientById(int id);
    void updateClientDiscount(Client client, int discount);
    void updateClient(Client client);
    boolean deleteClientById(int id);
}
