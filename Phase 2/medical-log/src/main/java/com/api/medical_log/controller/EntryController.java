package com.api.medical_log.controller;

import com.api.medical_log.Entity.MedicalEntry;
import com.api.medical_log.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients/{patientId}/entries")
public class EntryController {

    @Autowired
    EntryService entryService;

    @GetMapping
    public ResponseEntity<List<MedicalEntry>> getAllEntries(@PathVariable("patientId") Long patientId) {
        List<MedicalEntry> entries = entryService.getAllEntries(patientId);
        return new ResponseEntity<>(entries, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MedicalEntry> createEntry(@PathVariable("patientId") Long patientId, @RequestBody MedicalEntry data) {
        try {
            data.setDate(LocalDateTime.now());
            MedicalEntry saved = entryService.saveEntry(patientId, data);
            if (saved != null) {
                return new ResponseEntity<>(saved, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{entryId}")
    public ResponseEntity<Void> deleteEntry(@PathVariable("patientId") Long patientId, @PathVariable("entryId") Long entryId) {
        boolean deleted = entryService.deleteEntry(patientId, entryId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{entryId}")
    public ResponseEntity<MedicalEntry> getEntryById(@PathVariable("patientId") Long patientId, @PathVariable("entryId") Long entryId) {
        Optional<MedicalEntry> entry = entryService.getEntryById(patientId, entryId);
        return entry.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{entryId}")
    public ResponseEntity<MedicalEntry> updateEntry(@PathVariable("patientId") Long patientId, @PathVariable("entryId") Long entryId, @RequestBody MedicalEntry newData) {
        MedicalEntry updatedEntry = entryService.updateEntry(patientId, entryId, newData);

        if (updatedEntry != null) {
            return new ResponseEntity<>(updatedEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
