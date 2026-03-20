package com.api.medical_log.repo;

import com.api.medical_log.Entity.MedicalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntryRepo extends JpaRepository<MedicalEntry, Long> {
    List<MedicalEntry> findByPatient_PatientId(Long patientId);
    Optional<MedicalEntry> findByIdAndPatient_PatientId(Long id, Long patientId);
}
