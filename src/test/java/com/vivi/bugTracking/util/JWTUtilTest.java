package com.vivi.bugTracking.util;

import com.vivi.bugTracking.model.Permission;
import io.jsonwebtoken.Claims;
import org.junit.Test;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;

public class JWTUtilTest {

    @Test
    public void createToken() {
//        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        Set<String> permissions = new HashSet<>();
        permissions.add("project:create");
        String token = JWTUtil.createToken("root", "admin", permissions);
        JWTUtil.parseToken(token);
        System.out.println(token);
    }

    @Test
    public void parseToken() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyb290IiwiZXhwIjoxNTM2NzY5MzcwLCJpYXQiOjE1MzY2ODI5NzAsImlzcyI6ImJ1Z3RyYWNraW5nLmlvIn0.tVorthvXe3DRSbrTQ0Q2cIWq2vXEgO8AuKoC7K8xEUtrj2fyNiwoPsd_a7OraXWn1KayDygvwKDlBy2Du76Wlg";
        Claims claims = JWTUtil.parseToken(token);
        assertNotNull(claims);
        assertEquals("root", claims.getSubject());
    }

    @Test
    public void testOptional() {
        Optional.ofNullable(null).map(
                n -> {
                    System.out.println("value: " + n);
                    if (Integer.parseInt((String) n) != 1) {
                        throw new IllegalArgumentException("invalid number");
                    }
                    return null;
                }
        ).orElseThrow(RuntimeException::new);
    }
}