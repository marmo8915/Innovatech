package Innovatech.Project.Services;

import Innovatech.Project.DTO.EmprendimientoDTO;
import Innovatech.Project.Entity.Ciudad;
import Innovatech.Project.Entity.Emprendimiento;
import Innovatech.Project.Entity.Usuario;
import Innovatech.Project.Repositorio.CiudadRepository;
import Innovatech.Project.Repositorio.EmprendimientoRepository;
import Innovatech.Project.Repositorio.UsuarioRepository;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpredimientoService {

    @Autowired
    private EmprendimientoRepository emprendimientoRepository;

    @Autowired
    private CiudadRepository ciudadRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Emprendimiento registrarEmprendimiento(Emprendimiento emprendimiento){
        // Validar y asignar Ciudad
        if (emprendimiento.getId_ciudad() != null && emprendimiento.getId_ciudad().getId() > 0) {
            Ciudad ciudad = ciudadRepository.findById(emprendimiento.getId_ciudad().getId())
                    .orElseThrow(() -> new RuntimeException("Ciudad no encontrada"));
            emprendimiento.setId_ciudad(ciudad);
        }

        // Validar y asignar Usuario
        if (emprendimiento.getId_usuario() != null && emprendimiento.getId_usuario().getId() > 0) {
            Usuario usuario = usuarioRepository.findById(emprendimiento.getId_usuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            emprendimiento.setId_usuario(usuario);
        }

        return  emprendimientoRepository.save(emprendimiento);
    }

    public Optional<Emprendimiento> buscarById(Integer id) {
        return emprendimientoRepository.findById(id);
    }

    public List<Emprendimiento> consultarAll(){
        return emprendimientoRepository.findAll();
    }

    public void eliminarEmprendimiento(Integer id){
        if (emprendimientoRepository.existsById(id)) {
            emprendimientoRepository.deleteById(id);
        } else {
            throw new RuntimeException(id + " no encontrado");
        }
    }

    public Optional<Emprendimiento> actualizarEmprendimiento(Integer id, Emprendimiento emprendimiento) {
        return emprendimientoRepository.findById(id).map(e -> {

            e.setNIT(emprendimiento.getNIT());

            e.setMatricula(emprendimiento.getMatricula());

            if (emprendimiento.getId_ciudad() != null)
                e.setId_ciudad(emprendimiento.getId_ciudad());

            if (emprendimiento.getRazon_social() != null)
                e.setRazon_social(emprendimiento.getRazon_social());

            return emprendimientoRepository.save(e);
        });
    }

    public List<EmprendimientoDTO> listaEmprendimientos() {
        List<Tuple> tuples = emprendimientoRepository.listaEmprendimientos();
        return tuples.stream()
                .map(tuple -> new EmprendimientoDTO(
                        tuple.get("nit", Integer.class),
                        tuple.get("matricula", Integer.class),
                        tuple.get("nombre", String.class),
                        tuple.get("fecha_creacion", Timestamp.class),
                        tuple.get("razonSocial", String.class),
                        tuple.get("ciudad", String.class),
                        tuple.get("usuario", String.class)
                ))
                .collect(Collectors.toList());
    }

    public List<EmprendimientoDTO> listaEmprendimientosByUsuario(int id) {
        List<Tuple> tuples = emprendimientoRepository.listaEmprendimientosById(id);
        return tuples.stream()
                .map(tuple -> new EmprendimientoDTO(
                        tuple.get("nit", Integer.class),
                        tuple.get("matricula", Integer.class),
                        tuple.get("nombre", String.class),
                        tuple.get("fecha", Timestamp.class),
                        tuple.get("razonSocial", String.class),
                        tuple.get("ciudad", String.class),
                        tuple.get("usuario", String.class)
                ))
                .collect(Collectors.toList());
    }
}
