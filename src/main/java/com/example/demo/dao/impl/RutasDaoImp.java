
package com.example.demo.dao.impl;

import com.example.demo.dao.RutasDao;
import com.example.demo.modelo.Rutas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class RutasDaoImp implements RutasDao {

    @PersistenceContext
    EntityManager entityManager;
    
    @Transactional
    @Override
    public List<Rutas> getAll() {
       return entityManager.createQuery("FROM Rutas as u ", Rutas.class).getResultList();
    }

    @Transactional
    @Override
    public Rutas get(long id) {
        return entityManager.find(Rutas.class, id);
    }

    @Transactional
    @Override
    public Rutas registrar(Rutas ruta) {
        entityManager.merge(ruta);
        return ruta;
    }

    @Transactional
    @Override
    public Rutas eliminar(long id) {
        
    Rutas eliminar = get(id);
    if (eliminar != null) {
        entityManager.remove(eliminar);
    }
        return null;
    }    
}