package org.example.dao.clientDAO;

import org.example.dao.ConnectionFactory;
import org.example.exception.ConnectionDBException;
import org.example.model.Client;
import org.example.model.Personal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao {
    private static final String FIND_ALL_CLIENTS = "SELECT * FROM client";
    private static final String SAVE_CLIENT = """
        INSERT INTO client(
            name, surname, patronymic, birthdate, numTel, email, discount
        )
            VALUES(?, ?, ?, ?, ?, ?, ?)
        """;
    private static final String UPDATE_CLIENT = """
            UPDATE client SET
                       name = ?,
                       surname = ?,
                       patronymic = ?,
                       birthdate = ?,
                       numTel = ?,
                       email = ?,
                       discount = ?
            WHERE client.id = ?
            """;
    private static final String DELETE_ALL_CLIENTS = "DELETE FROM client";
    private static final String DELETE_CLIENT = "DELETE FROM client WHERE client.id = ?";


    @Override
    public Client getClientById(int id) {
        List<Client> clients = findAll();
        return clients.stream()
                .filter(client -> client.getId() == id)
                .findFirst()
                .orElse(null);
    }


    @Override
    public void save(Client client) {
        try (Connection conn = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = conn.prepareStatement(SAVE_CLIENT)) {
            ps.setString(1, client.getName());
            ps.setString(2, client.getSurname());
            ps.setString(3, client.getPatronymic());
            ps.setDate(4, java.sql.Date.valueOf(client.getBirthdate()));
            ps.setString(5, client.getNumTel());
            ps.setString(6, client.getEmail());
            ps.setInt(7, client.getDiscount());
            ps.execute();
        } catch (ConnectionDBException | SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void saveMany(List<Client> clients) {
        try (Connection conn = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = conn.prepareStatement(SAVE_CLIENT)) {
            for (var currClient : clients) {
                ps.setString(1, currClient.getName());
                ps.setString(2, currClient.getSurname());
                ps.setString(3, currClient.getPatronymic());
                ps.setDate(4, java.sql.Date.valueOf(currClient.getBirthdate()));
                ps.setString(5, currClient.getNumTel());
                ps.setString(6, currClient.getEmail());
                ps.setInt(7, currClient.getDiscount());
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (ConnectionDBException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void update(Client client) {
        try (Connection conn = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_CLIENT)) {
            ps.setString(1, client.getName());
            ps.setString(2, client.getSurname());
            ps.setString(3, client.getPatronymic());
            ps.setDate(4, java.sql.Date.valueOf(client.getBirthdate()));
            ps.setString(5, client.getNumTel());
            ps.setString(6, client.getEmail());
            ps.setInt(7, client.getDiscount());
            ps.setInt(8, client.getId());
            ps.execute();
        } catch (ConnectionDBException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void delete(Client client) {
        try (Connection conn = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE_CLIENT)) {
            ps.setInt(1, client.getId());
            ps.execute();
        } catch (ConnectionDBException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Client> findAll() {
        List<Client> resultAddClients = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = conn.prepareStatement(FIND_ALL_CLIENTS);
             ResultSet result = ps.executeQuery()) {

            while (result.next()) {
                Client addClient = new Client();
                addClient.setId(result.getInt(1));
                addClient.setName(result.getString(2));
                addClient.setSurname(result.getString(3));
                addClient.setPatronymic(result.getString(4));
                addClient.setBirthdate(result.getDate(5).toLocalDate());
                addClient.setNumTel(result.getString(6));
                addClient.setEmail(result.getString(7));
                addClient.setDiscount(result.getInt(8));
                resultAddClients.add(addClient);
            }
            return resultAddClients;
        } catch (ConnectionDBException | SQLException e) {
            System.err.println(e.getMessage());
        }
        return resultAddClients;
    }

    @Override
    public void deleteAll() {
        try (Connection conn = ConnectionFactory.getInstance().makeConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE_ALL_CLIENTS)) {
            ps.execute();
        } catch (ConnectionDBException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
