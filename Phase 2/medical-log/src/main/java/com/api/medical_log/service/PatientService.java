package com.api.medical_log.service;

import com.api.medical_log.Entity.Patient;
import com.api.medical_log.repo.PateintRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
@Autowired
    PateintRepo pRepo;
   public List<Patient> getAllPatient(){
        return pRepo.findAll();
    }

    public void savePatient(Patient data){
        pRepo.save(data);
    }

    public void deletePatient(Long id){
       pRepo.deleteById(id);
    }

    public Optional<Patient> getPatientById(Long id){
       return pRepo.findById(id);
    }

    public Patient updatePatient(Long id, Patient newData) {

        Patient existing = pRepo.findById(id).orElse(null);

        if (existing != null) {

            if (newData.getName() != null && !newData.getName().isEmpty()) {
                existing.setName(newData.getName());
            }

            if (newData.getLastVisitDate() != null) {
                existing.setLastVisitDate(newData.getLastVisitDate());
            }

            return pRepo.save(existing);
        }

        return null;
    }

}
