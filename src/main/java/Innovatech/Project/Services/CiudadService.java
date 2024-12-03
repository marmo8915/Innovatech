package Innovatech.Project.Services;

import Innovatech.Project.Entity.Ciudad;
import Innovatech.Project.Repositorio.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    public Ciudad saveCity(Ciudad city){
        return  ciudadRepository.save(city);
    }

    public Optional<Ciudad> buscarById(Integer id){
        return  ciudadRepository.findById(id);
    }

    public List<Ciudad> consultarALLCiudad(){
        return  ciudadRepository.findAll();
    }

    public void eliminarCiudad(Integer id){
        if (ciudadRepository.existsById(id)) {
            ciudadRepository.deleteById(id);
        } else {
            throw new RuntimeException("Ciudad con ID " + id + " no encontrado");
        }
    }

    public Optional<Ciudad> actualizarCiudad(Integer id, Ciudad ciudad) {
        return ciudadRepository.findById(id).map(e -> {
            if (ciudad.getNombre() != null)
                e.setNombre(ciudad.getNombre());

            if (ciudad.getDepartamento() != null)
                e.setDepartamento(ciudad.getDepartamento());

            if (ciudad.getPais() != null)
                e.setPais(ciudad.getPais());

            return ciudadRepository.save(e);
        });
    }
}
