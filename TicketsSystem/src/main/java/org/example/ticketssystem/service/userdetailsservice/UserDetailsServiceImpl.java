package org.example.ticketssystem.service.userdetailsservice;

import lombok.extern.slf4j.Slf4j;
import org.example.ticketssystem.model.Customer;
import org.example.ticketssystem.service.customerroleservice.CustomerRoleService;
import org.example.ticketssystem.service.customerservice.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRoleService customerRoleService;


    // Метод вызовется при сабмите логин формы
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // находим пользователя по имени
        Customer customer = customerService.findByName(userName).orElse(null);

        if (customer == null) {
            throw new UsernameNotFoundException("User '" + userName + "' was not found in the database...");
        }

        // установка ролей для данного пользователя
        List<String> roleNames = customerRoleService.getRoleNames(customer.getId());
        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roleNames != null) {
            grantList = roleNames.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        }

        // возвращаем объект внутреннего Spring User
        return new User(customer.getName(), customer.getEncryptedPassword(), grantList);
    }
}
