package Innovatech.Project.Controller;

import Innovatech.Project.Entity.Reaccion;
import Innovatech.Project.Entity.Rol;
import Innovatech.Project.Services.ReaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Reaccion")
public class ReaccionController {

    @Autowired
    private ReaccionService reaccionService;

    @PostMapping
    public ResponseEntity<Reaccion> crearRol(@RequestBody Reaccion reaccion){
        Reaccion guardar = reaccionService.guardar(reaccion);
        return  new ResponseEntity<>(guardar, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Reaccion> buscarID(@PathVariable int id){
        Optional<Reaccion> reaccion = reaccionService.buscarById(id);
        return reaccion.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping
    public  ResponseEntity<List<Reaccion>> obtenerTodos(){
        List<Reaccion> reaccions = reaccionService.consultarAll();
        return  new ResponseEntity<>(reaccions, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<String> eliminarRol(@PathVariable int id){
        reaccionService.eliminar(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Reaccion> actualizarRol(@PathVariable int id, @RequestBody Reaccion reaccion){
        Optional<Reaccion> update = reaccionService.actualizar(id, reaccion);
        return update.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
}
