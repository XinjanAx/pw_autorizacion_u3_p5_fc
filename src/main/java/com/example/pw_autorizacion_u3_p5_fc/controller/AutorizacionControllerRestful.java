package com.example.pw_autorizacion_u3_p5_fc.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.pw_autorizacion_u3_p5_fc.security.JwtUtils;
import com.example.pw_autorizacion_u3_p5_fc.server.to.UsuarioTO;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/autorizaciones")
public class AutorizacionControllerRestful {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping(path="/jwt",consumes = MediaType.APPLICATION_JSON_VALUE)   
    public String obtenerToken(@RequestBody UsuarioTO usuarioTO){
        /*
         * autenticacion
         * validarcel usuario y el password
         * si es correcto mando el token
         */
        this.autenticacion(usuarioTO.getNombre(), usuarioTO.getContrasenia());
        return this.jwtUtils.buildTokenJwt(usuarioTO.getNombre());
    }
    private void autenticacion(String usuario, String password){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(usuario, password);
        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
