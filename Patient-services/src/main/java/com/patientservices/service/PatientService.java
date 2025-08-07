package com.patientservices.service;

import com.patientservices.dto.PatientRequestDTO;
import com.patientservices.dto.PatientResponseDTO;
import com.patientservices.mapper.PatientMapper;
import com.patientservices.model.Patient;
import com.patientservices.repository.PatientRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepo patientRepo;

    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public List<PatientResponseDTO> getPatient() {
        List<Patient> patients = patientRepo.findAll();
        return patients.stream()
                .map(PatientMapper::toDTO)
                .toList();
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {

        if(patientRepo.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExixtsException("A Patient with this emails" +
                    "already exists" + patientRequestDTO.getEmail());
        }

        Patient newPatient = patientRepo.save(PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDTO(newPatient);
    }
}
