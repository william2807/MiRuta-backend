package com.example.demo.dao;

import com.example.demo.modelo.Usuario;
import java.util.List;

public interface UsuarioDao {
    public List<Usuario> traerTodos();
    public Usuario traerUsuario(String documento);
    public Usuario registrarUsuario(Usuario usuario);
    public void borrarUsuario(String documento);
}
