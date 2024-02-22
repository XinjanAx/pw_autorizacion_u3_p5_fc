package repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Column(name = "usu_id")
    private Integer id;

    @Column(name = "usu_nombre")
    private String nombre;

    @Column(name = "usu_constrasenia")
    private String contrasenia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
