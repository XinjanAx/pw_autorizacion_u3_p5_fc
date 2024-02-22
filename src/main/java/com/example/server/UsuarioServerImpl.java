package com.example.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import repository.IUsuarioRepository;
import repository.model.Usuario;

import static java.util.Collections.emptyList;

public class UsuarioServerImpl implements UserDetailsService{

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Usuario us = this.iUsuarioRepository.consultarPorName(username);
        return new User( us.getNombre(), us.getContrasenia() , emptyList());
    }
    
}
