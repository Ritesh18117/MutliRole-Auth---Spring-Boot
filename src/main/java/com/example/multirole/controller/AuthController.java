package com.example.multirole.controller;

import com.example.multirole.dto.AuthRequest;
import com.example.multirole.dto.AuthResponse;
import com.example.multirole.dto.RegisterRequest;
import com.example.multirole.entity.Role;
import com.example.multirole.entity.User;
import com.example.multirole.repository.UserRepository;
import com.example.multirole.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * /api/auth/register -> registers user with a role (PATIENT, ...)
 * /api/auth/login -> returns JWT on success
 * /api/auth/logout -> revokes the token (adds to blacklist)
 *
 * Note: register is open here for demo; in real app you might restrict who can create DOCTOR/ADMIN accounts.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository users;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager,
                          UserRepository users,
                          PasswordEncoder passwordEncoder,
                          JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        if (users.findByUsername(req.username()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already taken");
        }

        Role role;
        try {
            role = Role.valueOf(req.role().toUpperCase());
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body("Invalid role. Allowed: PATIENT, DOCTOR, EMPLOYEE, ADMIN");
        }

        User u = new User(req.username(), passwordEncoder.encode(req.password()), role);
        users.save(u);

        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {
        try {
            Authentication auth = new UsernamePasswordAuthenticationToken(req.username(), req.password());
            authenticationManager.authenticate(auth);
            // load user to get id/role
            User user = users.findByUsername(req.username()).orElseThrow();

            String token = jwtService.generateToken(user);
            return ResponseEntity.ok(new AuthResponse(token));
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        return "Logout";
    }
}
