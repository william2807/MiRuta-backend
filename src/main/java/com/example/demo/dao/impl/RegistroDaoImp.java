
package com.example.demo.dao.impl;

import com.example.demo.dao.RegistroDao;
import com.example.demo.modelo.Registro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class RegistroDaoImp implements RegistroDao{

    @PersistenceContext
    EntityManager entityManager;
    
    @Transactional
    @Override
    public Registro nuevoRegistro(Registro registro) {
      /*se usa el metodo merge para que se pueda ingresar 
      nuevos nombres de usuarios con su respectiva contraseña*/
      return entityManager.merge(registro);
    }
    
}
