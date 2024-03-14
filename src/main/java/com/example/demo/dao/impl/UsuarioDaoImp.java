package com.example.demo.dao.impl;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.modelo.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    EntityManager entityManager;
    
    @Transactional
    @Override
    public List<Usuario> traerTodos() {
    return entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class)
            .getResultList();
}

    
    @Transactional
    @Override
    public Usuario traerUsuario(String documento) {
        return entityManager.createQuery("SELECT u FROM Usuario u WHERE u.Documento = :Documento", Usuario.class)
                .setParameter("Documento", documento)
                .getSingleResult();
    }

    @Transactional
    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        return entityManager.merge(usuario);
    }

    @Transactional
    @Override
    public void borrarUsuario(String documento) {
        
        Usuario eliminar = traerUsuario(documento);
    if (eliminar != null) {
        entityManager.remove(eliminar);
    }
        
    }        
}
