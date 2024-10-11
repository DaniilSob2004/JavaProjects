package org.example.ticketssystem.service.roleservice;

import org.example.ticketssystem.model.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findRoleByName(String name);
}
