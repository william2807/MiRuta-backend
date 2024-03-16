package com.example.demo.Servicio;

import com.example.demo.controlador.UsuarioController;
import com.example.demo.modelo.Usuario;
import java.util.ArrayList;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService  {
          
    public List<Usuario> traerTodos(){     
        return null;
    }
    public void traerUsuario(String documento){
    
    }
    public void registrarUsuario(Usuario usuario){
        añadirALista(usuario);
    }
    
    public void borrarUsuario(String documento){    
         
    }
   //logica de negocio
    
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();
     
    public void añadirALista(Usuario usu){
        listaUsuarios.add(usu);
    }
}
