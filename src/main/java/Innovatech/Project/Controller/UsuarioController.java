package Innovatech.Project.Controller;

import Innovatech.Project.Entity.Usuario;
import Innovatech.Project.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    public ResponseEntity<Usuario> crearCity(@RequestBody Usuario usuario) {
        Usuario usuario1 = usuarioService.guardarUsuario(usuario);
        return  new ResponseEntity<>(usuario1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Usuario> buscarID(@PathVariable int id){
        Optional<Usuario> usuario = usuarioService.buscarById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping
    public  ResponseEntity<List<Usuario>> obtenerTodos(){
        List<Usuario> usuarios = usuarioService.consultarAll();
        return  new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<String> eliminar(@PathVariable int id){
        usuarioService.eliminar(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable int id, @RequestBody Usuario usuario){
        Optional<Usuario> update = usuarioService.actualizar(id, usuario);
        return update.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
}
