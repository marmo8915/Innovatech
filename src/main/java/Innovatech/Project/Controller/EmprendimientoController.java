package Innovatech.Project.Controller;

import Innovatech.Project.DTO.EmprendimientoDTO;
import Innovatech.Project.Entity.Emprendimiento;
import Innovatech.Project.Services.EmpredimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Emprendimiento")
public class EmprendimientoController {

    @Autowired
    private EmpredimientoService empredimientoService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<Emprendimiento> registrarEmprendimiento(@RequestBody Emprendimiento emprendimiento){
        Emprendimiento guardar = empredimientoService.registrarEmprendimiento(emprendimiento);
        return  new ResponseEntity<>(guardar, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Emprendimiento> buscarID(@PathVariable int id){
        Optional<Emprendimiento> reaccion = empredimientoService.buscarById(id);
        return reaccion.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping
    public  ResponseEntity<List<Emprendimiento>> obtenerTodos(){
        List<Emprendimiento> reaccions = empredimientoService.consultarAll();
        return  new ResponseEntity<>(reaccions, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("{id}")
    public  ResponseEntity<String> eliminarEmprendimiento(@PathVariable int id){
        empredimientoService.eliminarEmprendimiento(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("{id}")
    public ResponseEntity<Emprendimiento> actualizarEmprendimiento(@PathVariable int id, @RequestBody Emprendimiento emprendimiento){
        Optional<Emprendimiento> update = empredimientoService.actualizarEmprendimiento(id, emprendimiento);
        return update.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping("/listaEmprendimientos")
    public List<EmprendimientoDTO> listaEmprendimientos() {
        return empredimientoService.listaEmprendimientos();
    }

    @CrossOrigin(origins = "http://localhost:4200") // Permite solicitudes desde localhost:4200
    @GetMapping("/getEmprendimientoUsuario/{id}")
    public List<EmprendimientoDTO> listaEmprendimientosByUsuario(@PathVariable int id) {
        return empredimientoService.listaEmprendimientosByUsuario(id);
    }
}
