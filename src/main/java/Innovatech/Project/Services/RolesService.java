package Innovatech.Project.Services;

import Innovatech.Project.Entity.Rol;
import Innovatech.Project.Repositorio.RolesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {

    @Autowired
    private RolesRepositorio rolesRepositorio;


    public Rol guardarRol(Rol rol){
        return rolesRepositorio.save(rol);
    }

    public Optional<Rol> buscarById(Integer id) {
        return rolesRepositorio.findById(id);
    }

    public List<Rol> consultarRol(){
        return rolesRepositorio.findAll();
    }

}
