
package com.example.demo.dao;

import com.example.demo.modelo.Rutas;

import java.util.List;

public interface RutasDao {

    public List<Rutas> getAll();
    public Rutas get(long id); 
    public Rutas registrar(Rutas ruta);
    public Rutas eliminar(long id);
}
