package com.patientservices.repository;

import com.patientservices.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepo extends JpaRepository<Patient, UUID> {

}
