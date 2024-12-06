package Innovatech.Project.Services;

import Innovatech.Project.Entity.Evento;
import Innovatech.Project.Repositorio.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public Evento guardar(Evento evento){
        return eventoRepository.save(evento);
    }

    public Optional<Evento> buscarById(Integer id) {
        return eventoRepository.findById(id);
    }

    public List<Evento> consultarAll(){
        return eventoRepository.findAll();
    }

    public void eliminar(Integer id){
        if (eventoRepository.existsById(id)) {
            eventoRepository.deleteById(id);
        } else {
            throw new RuntimeException(id + " no encontrado");
        }
    }

    public Optional<Evento> actualizar(Integer id, Evento evento) {
        return eventoRepository.findById(id).map(e -> {
            e.setTitulo(evento.getTitulo());

            if (evento.getDescripcion() != null)
                e.setDescripcion(evento.getDescripcion());

            if (evento.getFecha() != null)
                e.setFecha(evento.getFecha());

            if (evento.getUbicacion() != null)
                e.setUbicacion(evento.getUbicacion());

            return eventoRepository.save(e);
        });
    }
}
