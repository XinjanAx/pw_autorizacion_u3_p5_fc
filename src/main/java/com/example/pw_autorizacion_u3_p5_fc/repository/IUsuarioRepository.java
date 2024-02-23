package com.example.pw_autorizacion_u3_p5_fc.repository;

import com.example.pw_autorizacion_u3_p5_fc.repository.model.Usuario;

public interface IUsuarioRepository {

    public Usuario consultarPorName(String name);
}
