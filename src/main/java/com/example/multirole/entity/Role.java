package com.example.multirole.entity;

/**
 * Role enum — saved as STRING in DB (PATIENT, DOCTOR, EMPLOYEE, ADMIN).
 * When we construct GrantedAuthority we will use "ROLE_" + name() so Spring's hasRole() works.
 */
public enum Role {
    PATIENT,
    DOCTOR,
    EMPLOYEE,
    ADMIN
}
