package org.example.ticketssystem.service.customerroleservice;

import org.example.ticketssystem.model.CustomerRole;
import java.util.List;

public interface CustomerRoleService {
    CustomerRole save(CustomerRole customerRole);
    int[] saveCustomerRolesList(List<CustomerRole> customerRoles);
    void update(CustomerRole customerRole);
    void delete(CustomerRole customerRole);
    List<CustomerRole> findAll();
    void deleteAll();

    List<String> getRoleNames(Integer customerId);
}
