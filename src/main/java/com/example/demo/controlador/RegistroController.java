package com.example.demo.controlador;

import com.example.demo.Servicio.RegistroService;
import com.example.demo.dao.RegistroDao;
import com.example.demo.dao.impl.RegistroDaoImp;
import com.example.demo.modelo.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Nuevo")
public class RegistroController {
    
        @Autowired
        RegistroDao registroDao;

        @Autowired
        RegistroService registroservice;

        @Autowired
        RegistroDaoImp registroImp;

                 @CrossOrigin(origins = "http://127.0.0.1:5500/")
                 @PostMapping(value = "/InicioSesion")
                 //Se envia en formato e
                 public Registro registrarLogin(@RequestBody Registro registro){      
                          //se llama al servicio para que traiga el hash
                          registroservice.registrarLogin(registro);
                         //retornamos la respectiva persistencia 
                         return registroImp.registrarLogin(registro);
                }
    
}