
package com.example.demo.dao.impl;

import com.example.demo.dao.RegistroDao;
import com.example.demo.modelo.Registro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
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
        //Se crear el login, para que el usuario pueda loguearse
        public Registro registrarLogin(Registro registro) {

                 //se inicializa una variable con el fin de que se sobrescriba la variable del catch del metodo
                 Registro registroGuardado = null;

                 /*se realiza una consulta en la cual traiga cualquier contraseña igual y en caso de que haya un resultado igual, 
                 se lanza una excepcion con un msj */
                 try{

                         entityManager.createQuery("SELECT u FROM Registro u WHERE u.contrasenha = :contrasenha", Registro.class)
                                  .setParameter("contrasenha", registro.getContrasenha())
                                  .getSingleResult();

                         throw new NonUniqueResultException("contraseña invalida");

                //en esta excepcion, en caso de que no se encuentre ningun resultado igual de contraseña, entonces realiza la persistencia
                }catch(NoResultException e){            
                         System.err.println("contraseña valida");
                         registroGuardado = entityManager.merge(registro);
                }

        return registroGuardado;
    }
}
