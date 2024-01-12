package com.rohini.institute.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rohini.institute.management.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
