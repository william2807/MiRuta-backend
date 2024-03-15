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
        verificarDatosUnicos(usu);
        verificarDuplicidad(usu);
        listaUsuarios.add(usu);
    }
    
    public void verificarDatosUnicos(Usuario usu){
        
        for (Usuario usuario : listaUsuarios) {
            String nombre = usuario.getNombres();
            String apellidos = usuario.getApellidos();
            
            try {
                 if (usu.getNombres().equals(nombre) || usu.getDocumento().equals(apellidos)) {
                         throw new IllegalArgumentException("debes ingresar tu nombre y documento valido");
                }
              } catch (IllegalArgumentException e) {
                          System.out.println( e.getMessage());
        }
      }
    }
    
    public void verificarDuplicidad(Usuario usu){
        
        for (Usuario usuario : listaUsuarios) {
            String documento = usuario.getDocumento();
            String telefono = usuario.getTelefono();
            
            try{
                 if(usu.getTarjeta_sitp().equals(documento)){
                          throw new IllegalArgumentException("Lamentamos, pero el numero de tu tarjeta sitp ya esta registrado");
                }
            } catch (IllegalArgumentException e){
                          System.out.println(e.getMessage());
                }
            
            try{
                if(usu.getTelefono().equals(telefono)){
                         throw new IllegalArgumentException("lamentamos, intenta un numero valido");
                }
            } catch(IllegalArgumentException e){
                          System.out.println(e.getMessage());
            }
        }
    }
}
