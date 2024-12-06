package Innovatech.Project.Controller;

import Innovatech.Project.Entity.Evento;
import Innovatech.Project.Entity.Reaccion;
import Innovatech.Project.Services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping
    public ResponseEntity<Evento> registrarEvento(@RequestBody Evento evento){
        Evento guardar = eventoService.guardar(evento);
        return  new ResponseEntity<>(guardar, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Evento> buscarID(@PathVariable int id){
        Optional<Evento> evento = eventoService.buscarById(id);
        return evento.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping
    public  ResponseEntity<List<Evento>> obtenerTodos(){
        List<Evento> eventos = eventoService.consultarAll();
        return  new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<String> eliminarEmprendimiento(@PathVariable int id){
        eventoService.eliminar(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Evento> actualizarRol(@PathVariable int id, @RequestBody Evento evento){
        Optional<Evento> update = eventoService.actualizar(id, evento);
        return update.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
}
