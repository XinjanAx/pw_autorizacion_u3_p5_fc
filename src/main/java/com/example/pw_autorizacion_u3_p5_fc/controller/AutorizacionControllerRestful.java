package com.example.pw_autorizacion_u3_p5_fc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pw_autorizacion_u3_p5_fc.security.JwtUtils;
import com.example.pw_autorizacion_u3_p5_fc.server.to.UsuarioTO;



@RestController
@RequestMapping("/tokens")
@CrossOrigin
public class AutorizacionControllerRestful {

    private static final Logger LOG = LoggerFactory.getLogger(JwtUtils.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping(path = "/obtener/{semilla}/{tiempo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    private String getToken(@RequestBody UsuarioTO usuarioTO, @PathVariable String semilla, @PathVariable int tiempo) {
        LOG.info(usuarioTO.getContrasenia());
        this.authenticated(usuarioTO.getNombre(), usuarioTO.getContrasenia());
        return this.jwtUtils.generateJwtToken(usuarioTO.getNombre(),semilla, tiempo);
    }

    private void authenticated(String username, String password) {
        Authentication authentication = this.authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(username, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}
