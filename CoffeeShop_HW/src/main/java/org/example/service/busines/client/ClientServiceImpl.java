package org.example.service.busines.client;

import lombok.*;

import org.example.dao.clientDAO.ClientDao;
import org.example.model.Client;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao;

    @Override
    public void addClient(Client client) {
        clientDao.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientDao.findAll();
    }

    @Override
    public Client getClientById(int id) {
        return clientDao.getClientById(id);
    }

    @Override
    public void updateClientDiscount(Client client, int discount) {
        client.setDiscount(discount);
        updateClient(client);
    }

    @Override
    public void updateClient(Client client) {
        clientDao.update(client);
    }

    @Override
    public boolean deleteClientById(int id) {
        Client client = clientDao.getClientById(id);
        if (client != null) {
            clientDao.delete(client);
            return true;
        }
        return false;
    }
}
