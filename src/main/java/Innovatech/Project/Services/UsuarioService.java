package Innovatech.Project.Services;

import Innovatech.Project.Entity.Usuario;
import Innovatech.Project.Repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarById(Integer id) {
        return usuarioRepository.findById(id);
    }

    public List<Usuario> consultarAll(){
        return usuarioRepository.findAll();
    }

    public void eliminar(Integer id){
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException(id + " no encontrado");
        }
    }

    public Optional<Usuario> actualizar(Integer id, Usuario usuario) {
        return usuarioRepository.findById(id).map(e -> {
            if (usuario.getNombre() != null)
                e.setNombre(usuario.getNombre());

            if (usuario.getApellido() != null)
                e.setApellido(usuario.getApellido());

            if (usuario.getEmail() != null)
                e.setEmail(usuario.getEmail());

            if (usuario.getPassword() != null)
                e.setPassword(usuario.getPassword());

            if (usuario.getTelefono() != null)
                e.setTelefono(usuario.getTelefono());

            if (usuario.getId_rol() != null)
                e.setId_rol(usuario.getId_rol());

            return usuarioRepository.save(e);
        });
    }

    public List<Object[]> obtenerUsuariosConNombreModificado() {
        return usuarioRepository.findUsuariosConNombreModificado();
    }

    public List<Object[]> obtenerUsuarioPorCredenciales(String email, String password) {
        return usuarioRepository.findUsuariosByEmailAndPassword(email, password);
    }
}
