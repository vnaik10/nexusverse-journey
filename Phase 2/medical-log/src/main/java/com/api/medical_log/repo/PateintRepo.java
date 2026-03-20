package com.api.medical_log.repo;

import com.api.medical_log.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PateintRepo extends JpaRepository<Patient, Long> {
}
