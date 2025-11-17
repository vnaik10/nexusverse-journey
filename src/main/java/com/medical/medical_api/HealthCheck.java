package com.medical.medical_api;

import com.medical.medical_api.model.Patient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v")
public class HealthCheck {

    @GetMapping("/check")
    public String checkHealth(){
        return "Api Running Successfully";
    }

}
