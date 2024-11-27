package Innovatech.Project.Controller;

import Innovatech.Project.Entity.Rol;
import Innovatech.Project.Services.RolesService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Rol")
public class RolController {

    @Autowired
    private RolesService rolesService;

    @PostMapping
    public ResponseEntity<Rol> crearRol(@RequestBody Rol rol){
        Rol guardar = rolesService.guardarRol(rol);
        return  new ResponseEntity<>(guardar, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Rol> buscarID(@PathVariable int id){
        Optional<Rol> rol = rolesService.buscarById(id);
        return rol.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping
    public  ResponseEntity<List<Rol>> obtenerTodos(){
        List<Rol> rol = rolesService.consultarRol();
        return  new ResponseEntity<>(rol, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<String> eliminarRol(@PathVariable int id){
        rolesService.eliminarRol(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Rol> actualizarRol(@PathVariable int id, @RequestBody Rol rol){
        Optional<Rol> update = rolesService.actualizarRol(id, rol);
        return update.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
}
