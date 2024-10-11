package org.example.ticketssystem.service.customerservice;

import org.example.ticketssystem.model.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer save(Customer customer);
    int[] saveCustomersList(List<Customer> customers);
    void update(Customer customer);
    void delete(Customer customer);
    List<Customer> findAll();
    void deleteAll();

    Optional<Customer> findById(int id);
    Optional<Customer> findByName(String name);
    Customer getCurrentCustomer();
}
