package com.rohini.institute.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohini.institute.management.model.Institute;
import com.rohini.institute.management.model.InstituteUpdateDTO;
import com.rohini.institute.management.services.InstituteService;

import javax.validation.Valid;

@RestController
@RequestMapping("/InstituteManagement")
public class InstituteController {
	
	@Autowired
    private InstituteService instituteService;

	//Save Institute 
	@PostMapping("/register")
    public Institute registerInstitute(@Valid @RequestBody Institute institute) {
        return instituteService.registerInstitute(institute);
    }
    
    //update Institute
    @PutMapping("/update/{id}")
    public Institute modifyInstitute(@PathVariable Long id, @Valid @RequestBody InstituteUpdateDTO updateDTO) {
        return instituteService.modifyInstitute(id, updateDTO);
    }
    
    // get Institute 
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getInstituteById(@PathVariable Long id) {
        return instituteService.getInstituteById(id);
    }
    
    // get All Institute 
    @GetMapping("/getAllInstitutes")
    public List<Institute> getInstitutes() {
        return instituteService.getAllInstitute();
    }
}
