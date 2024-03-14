
package com.example.demo.Servicio;

import com.example.demo.dao.RutasDao;
import com.example.demo.modelo.Rutas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RutasService {
    
    @Autowired
    RutasDao rutasdao; 
           
    public List<Rutas> getAll() {
       return rutasdao.getAll();
    }


    public Rutas get(long id) {
        return rutasdao.get(id);
    }


    public Rutas registrar(Rutas ruta) {
        return rutasdao.registrar(ruta);
    }

    
    public Rutas eliminar(long id) {
        return rutasdao.eliminar(id);
    }

}
