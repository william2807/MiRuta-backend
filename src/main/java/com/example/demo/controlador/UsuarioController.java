package com.example.demo.controlador;

import com.example.demo.Servicio.UsuarioService;
import com.example.demo.dao.UsuarioDao;
import com.example.demo.dao.impl.UsuarioDaoImp;
import com.example.demo.modelo.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioDao usuarioDao;
    
    @Autowired
    UsuarioService usuarioService;
    
    
    @GetMapping("/all")
    public List<Usuario> traerTodos(){
        return usuarioDao.traerTodos();
    }
    @GetMapping("/{documento}")
    public Usuario traerUsuario(@PathVariable String documento){
        return usuarioDao.traerUsuario(documento);
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/registrar")
    public Usuario registrarUsuario( @RequestBody Usuario usuario){
        usuarioService.registrarUsuario(usuario);
        return usuarioDao.registrarUsuario(usuario);
    }
    @DeleteMapping("/eliminar/{documento}")
    public void borrarUsuario(@PathVariable String documento){
        usuarioDao.borrarUsuario(documento);
    }
}
