package Innovatech.Project.Repositorio;

import Innovatech.Project.Entity.Reaccion;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReaccionRepository extends JpaRepository<Reaccion, Integer> {
    @Query(value =  "SELECT e.nombre emprendimiento, r.valoracion, r.comentario " +
            "FROM innovatech.reaccion AS r " +
            "INNER JOIN emprendimiento AS e ON e.id = r.id_emprendimiento " +
            "INNER JOIN usuario AS u ON u.id = e.id_usuario " +
            "WHERE u.id = :id", nativeQuery = true)
    List<Tuple> listaEmprendimientosById(@Param("id") int id);
}
