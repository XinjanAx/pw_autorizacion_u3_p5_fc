package com.example.pw_autorizacion_u3_p5_fc.security;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
    private static final Logger LOG = LoggerFactory.getLogger(JwtUtils.class);

    public String generateJwtToken(String nombre, String semilla, int tiempo) {
        LOG.info("Semilla: " + semilla + " Tiempo: " + tiempo);
        return Jwts.builder().setSubject(nombre).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + tiempo))
                .signWith(SignatureAlgorithm.HS512, semilla).compact();
    }

}