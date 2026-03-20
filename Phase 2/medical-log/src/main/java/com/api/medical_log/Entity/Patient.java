package com.api.medical_log.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long patientId ;

    private String name;
 private LocalDate lastVisitDate;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<MedicalEntry> entries;
}
