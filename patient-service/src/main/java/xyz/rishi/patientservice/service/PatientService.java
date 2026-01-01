package xyz.rishi.patientservice.service;

import org.springframework.stereotype.Service;
import xyz.rishi.patientservice.dto.PatientResponseDTO;
import xyz.rishi.patientservice.mapper.PatientMapper;
import xyz.rishi.patientservice.model.Patient;
import xyz.rishi.patientservice.repository.PatientRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    public List<PatientResponseDTO> getPatients() {
        List<Patient>patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientMapper::toDTO).toList();
    }
}
