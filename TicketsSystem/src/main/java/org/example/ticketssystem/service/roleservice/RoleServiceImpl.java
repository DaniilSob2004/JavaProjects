package org.example.ticketssystem.service.roleservice;

import org.example.ticketssystem.dao.role.RoleRepository;
import org.example.ticketssystem.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public Optional<Role> findRoleByName(String name) {
        return roleRepository.findRoleByRoleName(name);
    }
}
