package com.rohini.institute.management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rohini.institute.management.model.Institute;
import com.rohini.institute.management.model.InstituteUpdateDTO;
import com.rohini.institute.management.repositories.InstituteRepository;
import java.util.List;

@Service
public class InstituteService {

	@Autowired
	private InstituteRepository instituteRepository;

	public Institute registerInstitute(Institute institute) {
		return instituteRepository.save(institute);
	}

	public Institute modifyInstitute(Long id, InstituteUpdateDTO updateDTO) {
	    Institute existingInstitute = instituteRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Institute not found"));

	    // Update only the provided fields
	    existingInstitute.setName(updateDTO.getName());
	    existingInstitute.setLocation(updateDTO.getLocation());
	    existingInstitute.setContactInfo(updateDTO.getContactInfo());

	    return instituteRepository.save(existingInstitute);
	}
	
	public ResponseEntity<?> getInstituteById(Long id) {
		Institute institute = instituteRepository.findById(id).orElse(null);

	    if (institute == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Institute not found with ID: " + id);
	    }

	    return ResponseEntity.ok(institute);
		//return instituteRepository.findById(id).orElseThrow(() -> new RuntimeException("Institute not found"));
	}
	
	public List<Institute> getAllInstitute(){
		return instituteRepository.findAll();
	}
}
