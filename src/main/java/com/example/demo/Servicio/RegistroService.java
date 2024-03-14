package com.example.demo.Servicio;

import com.example.demo.dao.RegistroDao;
import com.example.demo.modelo.Registro;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.stereotype.Service;

@Service
public class RegistroService {
    
    RegistroDao registroDao;
    
    public Registro registrarUsuario(Registro registro){ 
           return registroDao.nuevoRegistro(registro);  
    }
}
