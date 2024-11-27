package Innovatech.Project.Services;

import Innovatech.Project.Entity.Reaccion;
import Innovatech.Project.Entity.Usuario;
import Innovatech.Project.Repositorio.ReaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaccionService {

    @Autowired
    private ReaccionRepository reaccionRepository;

    public Reaccion guardar(Reaccion reaccion){
        return reaccionRepository.save(reaccion);
    }

    public Optional<Reaccion> buscarById(Integer id) {
        return reaccionRepository.findById(id);
    }

    public List<Reaccion> consultarAll(){
        return reaccionRepository.findAll();
    }

    public void eliminar(Integer id){
        if (reaccionRepository.existsById(id)) {
            reaccionRepository.deleteById(id);
        } else {
            throw new RuntimeException(id + " no encontrado");
        }
    }

    public Optional<Reaccion> actualizar(Integer id, Reaccion reaccion) {
        return reaccionRepository.findById(id).map(e -> {
                e.setValoracion(reaccion.getValoracion());

            if (reaccion.getComentario() != null)
                e.setComentario(reaccion.getComentario());

            if (reaccion.getId_emprendimiento() != null)
                e.setId_emprendimiento(reaccion.getId_emprendimiento());

            if (reaccion.getId_usuario() != null)
                e.setId_usuario(reaccion.getId_usuario());

            return reaccionRepository.save(e);
        });
    }
}
