package com.example.demo.dao.impl;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.modelo.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
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
    
        try {
            
            String numeroTelefono = usuario.getTelefono();
            // se intenta traer un usuario que tenga un numero de telefono igual, para poder lanzar la excepcion.
            entityManager.createQuery("SELECT u FROM Usuario u WHERE u.Telefono = :Telefono", Usuario.class)
                .setParameter("Telefono", numeroTelefono)
                .getSingleResult();

            // se lanza la excepcion
            throw new NonUniqueResultException("Ya existe un usuario con el mismo número de teléfono, intenta de nuevo");

        } catch (NoResultException e) {
            // No se encontró ningún usuario con el mismo número de teléfono, por lo cual se puede continuar.
        }

        // Ahora, se intenta lanzar una excepción cuando el usuario tiene el mismo numero de documento.
        try {
            String documento = usuario.getDocumento();

            entityManager.createQuery("SELECT u FROM Usuario u WHERE u.Documento = :Documento", Usuario.class)
                .setParameter("Documento", documento)
                .getSingleResult();

            throw new NonUniqueResultException("El número de documento ya ha sido registrado, intenta de nuevo");

        } catch (NoResultException e) {
            // No se encontró ningún usuario con el mismo número de documento, por lo cual se puede continuar.
        }
        // Si no se lanzaron excepciones, significa que no hay usuarios duplicados y se puede registrar el nuevo usuario.
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
