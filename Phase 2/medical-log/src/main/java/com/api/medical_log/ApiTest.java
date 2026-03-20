package com.api.medical_log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class ApiTest {
    @GetMapping
    ResponseEntity<String> testMyApi(){
        return new ResponseEntity<>("Hello The Server Is Running Successfully!!", HttpStatus.OK);   }
}
