package com.rohini.institute.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohini.institute.management.model.Institute;

public interface InstituteRepository extends JpaRepository<Institute, Long> {

}
