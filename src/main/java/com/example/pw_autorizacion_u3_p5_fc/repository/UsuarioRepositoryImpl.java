package com.example.pw_autorizacion_u3_p5_fc.repository;

import org.springframework.stereotype.Repository;

import com.example.pw_autorizacion_u3_p5_fc.repository.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UsuarioRepositoryImpl implements IUsuarioRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Usuario consultarPorName(String name) {
        // TODO Auto-generated method stub
        var myQuery = this.entityManager.createQuery("SELECT u FROM Usuario u WHERE u.nombre = :nombre",Usuario.class);
        myQuery.setParameter("nombre", name);
        return myQuery.getSingleResult();
    }
    
}
