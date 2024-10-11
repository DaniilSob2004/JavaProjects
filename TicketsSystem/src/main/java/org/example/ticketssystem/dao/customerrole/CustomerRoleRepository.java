package org.example.ticketssystem.dao.customerrole;

import org.example.ticketssystem.model.CustomerRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CustomerRoleRepository extends JpaRepository<CustomerRole, Integer> {
    @Query("Select cr.role.roleName from CustomerRole cr where cr.customer.id = ?1")
    List<String> getRoleNames(Integer customerId);
}
