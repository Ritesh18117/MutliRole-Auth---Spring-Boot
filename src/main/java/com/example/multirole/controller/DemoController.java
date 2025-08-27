package com.example.multirole.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Simple protected endpoints to show role-based access.
 */
@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/patient/hello")
    public String patientHello() {
        return "Hello Patient — you have ROLE_PATIENT access";
    }

    @GetMapping("/doctor/hello")
    public String doctorHello() {
        return "Hello Doctor — you have ROLE_DOCTOR access";
    }

    @GetMapping("/employee/hello")
    public String employeeHello() {
        return "Hello Employee — you have ROLE_EMPLOYEE access";
    }

    @GetMapping("/admin/hello")
    public String adminHello() {
        return "Hello Admin — you have ROLE_ADMIN access";
    }
}
