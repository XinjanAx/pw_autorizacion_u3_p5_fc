package repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import repository.model.Usuario;

@Repository
@Transactional
public class UsuarioRepositoryImpl implements IUsuarioRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Usuario consultarPorName(String name) {
        // TODO Auto-generated method stub
        var myQuery = this.entityManager.createQuery("SELECT u FROM Usuario WHERE u.nomnre = :nomnre",Usuario.class);
        myQuery.setParameter("nombre", name);
        return myQuery.getSingleResult();
    }
    
}
