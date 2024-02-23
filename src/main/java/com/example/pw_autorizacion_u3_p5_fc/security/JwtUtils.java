package com.example.pw_autorizacion_u3_p5_fc.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
    @Value("${app.jwtExpirationMs}")
    private int jwtExpirationMs;

    @Value("${app.jwtSemilla}")
    private String jwtSemilla;

    public String buildTokenJwt(String nombre){

        return Jwts.builder()
        .setSubject(nombre)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis()+this.jwtExpirationMs))
        .signWith(SignatureAlgorithm.HS512,this.jwtSemilla)
        .compact();
    }
}
