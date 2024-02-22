package repository;

import repository.model.Usuario;

public interface IUsuarioRepository {


    public Usuario consultarPorName(String name);
}
