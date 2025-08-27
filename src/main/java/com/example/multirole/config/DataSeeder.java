package com.example.multirole.config;

import com.example.multirole.entity.Role;
import com.example.multirole.entity.User;
import com.example.multirole.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Seed an Admin user if not exists
            if (userRepository.findByUsername("admin").isEmpty()) {
                userRepository.save(User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin123"))
                        .role(Role.ADMIN)
                        .build());
                System.out.println("✅ Admin user created: admin/admin123");
            }

            // Seed a Doctor
            if (userRepository.findByUsername("doctor1").isEmpty()) {
                userRepository.save(User.builder()
                        .username("doctor1")
                        .password(passwordEncoder.encode("doc123"))
                        .role(Role.DOCTOR)
                        .build());
                System.out.println("✅ Doctor user created: doctor1/doc123");
            }

            // Seed a Patient
            if (userRepository.findByUsername("patient1").isEmpty()) {
                userRepository.save(User.builder()
                        .username("patient1")
                        .password(passwordEncoder.encode("patient123"))
                        .role(Role.PATIENT)
                        .build());
                System.out.println("✅ Patient user created: patient1/patient123");
            }

            // Seed an Employee
            if (userRepository.findByUsername("employee1").isEmpty()) {
                userRepository.save(User.builder()
                        .username("employee1")
                        .password(passwordEncoder.encode("emp123"))
                        .role(Role.EMPLOYEE)
                        .build());
                System.out.println("✅ Employee user created: employee1/emp123");
            }
        };
    }
}
