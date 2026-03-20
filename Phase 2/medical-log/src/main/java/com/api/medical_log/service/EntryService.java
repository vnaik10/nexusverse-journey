package com.api.medical_log.service;

import com.api.medical_log.Entity.MedicalEntry;
import com.api.medical_log.Entity.Patient;
import com.api.medical_log.repo.EntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryService {

    @Autowired
    EntryRepo entryRepo;

    @Autowired
    PatientService patientService;

    public List<MedicalEntry> getAllEntries(Long patientId) {
        return entryRepo.findByPatient_PatientId(patientId);
    }

    public MedicalEntry saveEntry(Long patientId, MedicalEntry data) {
        Optional<Patient> patientOpt = patientService.getPatientById(patientId);
        if (patientOpt.isPresent()) {
            data.setPatient(patientOpt.get());
            return entryRepo.save(data);
        }
        return null;
    }

    public boolean deleteEntry(Long patientId, Long id) {
        Optional<MedicalEntry> existing = entryRepo.findByIdAndPatient_PatientId(id, patientId);
        if (existing.isPresent()) {
            entryRepo.delete(existing.get());
            return true;
        }
        return false;
    }

    public Optional<MedicalEntry> getEntryById(Long patientId, Long id) {
        return entryRepo.findByIdAndPatient_PatientId(id, patientId);
    }

    public MedicalEntry updateEntry(Long patientId, Long id, MedicalEntry newData) {
        Optional<MedicalEntry> existingOpt = entryRepo.findByIdAndPatient_PatientId(id, patientId);

        if (existingOpt.isPresent()) {
            MedicalEntry existing = existingOpt.get();
            if (newData.getTitle() != null && !newData.getTitle().isEmpty()) {
                existing.setTitle(newData.getTitle());
            }

            if (newData.getNotes() != null && !newData.getNotes().isEmpty()) {
                existing.setNotes(newData.getNotes());
            }

            if (newData.getDate() != null) {
                existing.setDate(newData.getDate());
            }

            return entryRepo.save(existing);
        }

        return null;
    }
}
