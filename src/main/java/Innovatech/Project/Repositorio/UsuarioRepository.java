package Innovatech.Project.Repositorio;

import Innovatech.Project.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value =  "SELECT u.id, u.id_rol, u.apellido, u.email, u.nombre, u.password, u.telefono FROM Usuario u", nativeQuery = true)
    List<Object[]> findUsuariosConNombreModificado();

    @Query(value = "SELECT u.id, u.id_rol, u.apellido, u.email, u.nombre, u.password, u.telefono " +
            "FROM Usuario u " +
            "WHERE u.email = :email AND u.password = :password",
            nativeQuery = true)
    List<Object[]> findUsuariosByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
