package com.vivi.bugTracking.util;

import com.vivi.bugTracking.model.Permission;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Slf4j
public class JWTUtil {
    static final long EXPIRATIONTIME = 864_000_000; // 10 days
    static final String SECRET = "ThisIsASecret";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    private static String base64Secret = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=";
    private static Key key = Keys.hmacShaKeyFor(base64Secret.getBytes(StandardCharsets.UTF_8));
    private final static int expireMinutes = 24 * 60;

    public static String createToken(String username, String role, Set<String> permissions) {
        Date atDate = new Date();
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, expireMinutes);
        Date expireDate = nowTime.getTime();
        JwtBuilder jwtBuilder = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS512")
                .setSubject(username)
                .claim("role", role)
                .claim("permissions", permissions)
                .setExpiration(expireDate)
                .setIssuedAt(atDate)
                .setIssuer("bugtracking.io")
                .signWith(key);
        return jwtBuilder.compact();
    }

    public static Claims parseToken(String token) {
        try {
            return Jwts.parser().setSigningKey(key)
                    .requireIssuer("bugtracking.io")
                    .parseClaimsJws(token)
                    .getBody();//load user from database/cache
        } catch (Exception e) {
            log.error("Jwt verification failed", e);
            return null;
        }
    }

}
