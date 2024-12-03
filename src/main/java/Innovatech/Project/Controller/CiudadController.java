package Innovatech.Project.Controller;

import Innovatech.Project.Entity.Ciudad;
import Innovatech.Project.Services.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Ciudad")
public class CiudadController {

    @Autowired
    private CiudadService  ciudadService;

    public ResponseEntity<Ciudad> crearCity(@RequestBody Ciudad ciudad) {
        Ciudad city = ciudadService.saveCity(ciudad);
        return  new ResponseEntity<>(city,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Ciudad> buscarID(@PathVariable int id){
        Optional<Ciudad> city = ciudadService.buscarById(id);
        return city.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "http://localhost:4200") // Permite solicitudes desde localhost:4200
    @GetMapping
    public  ResponseEntity<List<Ciudad>> obtenerTodos(){
        List<Ciudad> ciudad = ciudadService.consultarALLCiudad();
        return  new ResponseEntity<>(ciudad, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<String> eliminarCity(@PathVariable int id){
        ciudadService.eliminarCiudad(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Ciudad> actualizarRol(@PathVariable int id, @RequestBody Ciudad ciudad){
        Optional<Ciudad> update = ciudadService.actualizarCiudad(id, ciudad);
        return update.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

}
