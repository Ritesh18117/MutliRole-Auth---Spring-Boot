package com.example.multirole.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.multirole.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Simple JWT utility using com.auth0 library.
 * Token contains:
 *  - subject: username
 *  - claim "role" : user's role (PATIENT, DOCTOR, ...)
 *  - claim "userId": user's DB id (number)
 */
@Service
public class JwtService {

    private final Algorithm algorithm;
    private final JWTVerifier verifier;
    private final long expirationMs;

    public JwtService(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.expiration}") long expirationMs
    ) {
        this.algorithm = Algorithm.HMAC256(secret.getBytes());
        this.verifier = JWT.require(algorithm).build();
        this.expirationMs = expirationMs;
    }


    public String generateToken(User user) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + expirationMs);
        return JWT.create()
                .withSubject(user.getUsername())
                .withClaim("role", user.getRole().name())
                .withClaim("userId", user.getId())
                .withIssuedAt(now)
                .withExpiresAt(exp)
                .sign(algorithm);
    }

    public DecodedJWT verifyToken(String token) {
        return verifier.verify(token);
    }

    public boolean isTokenValid(String token) {
        try {
            verifyToken(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        DecodedJWT decoded = JWT.decode(token);
        return decoded.getSubject();
    }

    public String getRoleFromToken(String token) {
        DecodedJWT decoded = JWT.decode(token);
        return decoded.getClaim("role").asString();
    }

    public Long getUserIdFromToken(String token) {
        DecodedJWT decoded = JWT.decode(token);
        // claim might be integer or long; using asLong() is okay if stored as number
        return decoded.getClaim("userId").asLong();
    }

    public Date getExpiryFromToken(String token) {
        DecodedJWT decoded = JWT.decode(token);
        return decoded.getExpiresAt();
    }
}
