package com.example.pw_autorizacion_u3_p5_fc.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.pw_autorizacion_u3_p5_fc.repository.IUsuarioRepository;
import com.example.pw_autorizacion_u3_p5_fc.repository.model.Usuario;

import static java.util.Collections.emptyList;

@Service
public class UsuarioServiceImpl implements UserDetailsService{

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Usuario us = this.iUsuarioRepository.consultarPorName(username);
        return new User( us.getNombre(), us.getContrasenia() , emptyList());
    }
    
}
