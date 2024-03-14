package com.example.demo.controlador;

import com.example.demo.Servicio.RegistroService;
import com.example.demo.dao.RegistroDao;
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
    
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @PostMapping(value = "/InicioSesion")
    public String registrar(@RequestBody Registro registro){        
        //se envia en formato json 
        registroDao.nuevoRegistro(registro);
        /*se registra(envia al daoImpl) para ser manipulada por la persistencia, 
        permitiendo guardar(usuario, contrasenha)*/
        return "usuario creado";
    }
}