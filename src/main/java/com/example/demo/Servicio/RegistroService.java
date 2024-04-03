package com.example.demo.Servicio;

import com.example.demo.dao.RegistroDao;
import com.example.demo.dao.impl.RegistroDaoImp;
import com.example.demo.modelo.Registro;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.stereotype.Service;

@Service
public class RegistroService {
    
        RegistroDao registroDao;
      
        public void registrarLogin(Registro registro){
                //Se agrega el metodo para que se cree el hash
                crearHash(registro);
         }
  
        public void crearHash (Registro registro){
                try {
                         // Selecciona el algoritmo de hash (en este caso, SHA-256)
                         MessageDigest md = MessageDigest.getInstance("SHA-256");

                         // Convierte la contraseña en bytes y calcula el hash
                         byte[] hashedBytes = md.digest(registro.getContrasenha().getBytes());

                         // Convierte el hash en una representación hexadecimal
                         StringBuilder hexStringBuilder = new StringBuilder();
                         for (byte hashedByte : hashedBytes) {
                                  hexStringBuilder.append(String.format("%02x", hashedByte));
                         }

                         // Asigna el hash al campo de contraseña antes de persistir
                         registro.setContrasenha(hexStringBuilder.toString());

                 }catch (NoSuchAlgorithmException e) {
                         // Manejo de excepciones en caso de que no se encuentre el algoritmo
                         System.err.println("no se encuentra el algoritmo");
                 }    
        }
}