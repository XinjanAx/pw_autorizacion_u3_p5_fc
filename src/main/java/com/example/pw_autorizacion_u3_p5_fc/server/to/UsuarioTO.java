package com.example.pw_autorizacion_u3_p5_fc.server.to;

import java.io.Serializable;


public class UsuarioTO implements Serializable{
    
    //private static final long serializableUId=1l;

    private String nombre;
    private String contrasenia;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
