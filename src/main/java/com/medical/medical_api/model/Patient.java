package com.medical.medical_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Patient {

    // private fields = encapsulation
    private Long id;
    private String name;
    private LocalDate lastVisitDate;

    // no-args constructor = required by Spring & Jackson
    public Patient() {}

    // all-args constructor = convenient initialization
    public Patient(Long id, String name, LocalDate lastVisitDate) {
        this.id = id;
        this.name = name;
        this.lastVisitDate = lastVisitDate;
    }

    // getters & setters = controlled access to private fields
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getLastVisitDate() { return lastVisitDate; }
    public void setLastVisitDate(LocalDate lastVisitDate) { this.lastVisitDate = lastVisitDate; }
}




