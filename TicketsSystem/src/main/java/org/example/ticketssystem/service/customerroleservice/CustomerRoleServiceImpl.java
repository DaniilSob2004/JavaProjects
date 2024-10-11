package org.example.ticketssystem.service.customerroleservice;

import org.example.ticketssystem.dao.customerrole.CustomerRoleRepository;
import org.example.ticketssystem.model.CustomerRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerRoleServiceImpl implements CustomerRoleService {

    @Autowired
    private CustomerRoleRepository customerRoleRepository;


    @Override
    public CustomerRole save(CustomerRole customerRole) {
        return customerRoleRepository.save(customerRole);
    }

    @Override
    public int[] saveCustomerRolesList(List<CustomerRole> customerRoles) {
        customerRoleRepository.saveAll(customerRoles);
        return new int[0];
    }

    @Override
    public void update(CustomerRole customerRole) {
        customerRoleRepository.save(customerRole);
    }

    @Override
    public void delete(CustomerRole customerRole) {
        customerRoleRepository.delete(customerRole);
    }

    @Override
    public List<CustomerRole> findAll() {
        return customerRoleRepository.findAll();
    }

    @Override
    public void deleteAll() {
        customerRoleRepository.deleteAll();
    }


    @Override
    public List<String> getRoleNames(Integer customerId) {
        return customerRoleRepository.getRoleNames(customerId);
    }
}
