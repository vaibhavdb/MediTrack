package com.patientservices.mapper;

import com.patientservices.dto.PatientRequestDTO;
import com.patientservices.dto.PatientResposeDTO;
import com.patientservices.model.Patient;

import java.time.LocalDate;

public class PatientMapper {

    public static PatientResposeDTO toDTO(Patient patient) {
        PatientResposeDTO patientDTO = new PatientResposeDTO();
        patientDTO.setId(patient.getId().toString());
        patientDTO.setName(patient.getName());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setDateOfBirth(patient.getDateOfBirth().toString());

        return patientDTO;
    }

    public  static  Patient toModel(PatientRequestDTO patientRequestDTO){

        Patient patient = new Patient();
        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateOfBirth(patientRequestDTO.getDateOfBirth());
        patient.setRegistredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));

        return patient;
    }

}
