package com.example.demo.Servicio;

import com.example.demo.controlador.UsuarioController;
import com.example.demo.modelo.Usuario;
import java.util.ArrayList;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService  {
    
    
    UsuarioController controller = new UsuarioController();
    
    public List<Usuario> traerTodos(){
        return controller.traerTodos();
        
    }
    public Usuario traerUsuario(String documento){
        return controller.traerUsuario(documento);
    }
    public void registrarUsuario(){

    }
    
    public void borrarUsuario(String documento){    
        controller.borrarUsuario(documento);
    }
    
   //logica de negocio
    public void verificarDatosUnicos(Usuario usu){
      try {
          if (usu.getNombres() == null || usu.getDocumento() == null) {
              throw new NullPointerException("Al menos uno de los datos únicos es nulo");
          }
      } catch (NullPointerException e) {
          // Aquí manejas la excepción
          System.out.println( e.getMessage());
      }
  }

}
