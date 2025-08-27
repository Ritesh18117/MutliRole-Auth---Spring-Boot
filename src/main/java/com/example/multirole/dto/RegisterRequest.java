package com.example.multirole.dto;

import lombok.Data;

/**
 * role should be one of PATIENT, DOCTOR, EMPLOYEE, ADMIN (no ROLE_ prefix).
 */

public record RegisterRequest(String username, String password, String role) {}