package Innovatech.Project.Repositorio;


import Innovatech.Project.DTO.EmprendimientoDTO;
import Innovatech.Project.Entity.Emprendimiento;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmprendimientoRepository extends JpaRepository<Emprendimiento, Integer> {

    @Query(value =  "SELECT nit, matricula, fecha_creacion, razon_social razonSocial, c.nombre ciudad, concat(u.nombre,' ' ,u.apellido) Usuario \n" +
            "FROM emprendimiento AS e\n" +
            "INNER JOIN ciudad AS c ON c.id = e.id_ciudad\n" +
            "INNER JOIN usuario AS u ON u.id = e.id_usuario", nativeQuery = true)
    List<Tuple> listaEmprendimientos();

    @Query(value =  "SELECT nit, e.nombre, matricula, fecha_creacion fecha, razon_social razonSocial, c.nombre ciudad, concat(u.nombre,' ' ,u.apellido) Usuario \n" +
            "FROM emprendimiento AS e\n" +
            "INNER JOIN ciudad AS c ON c.id = e.id_ciudad\n" +
            "INNER JOIN usuario AS u ON u.id = e.id_usuario " +
            "WHERE u.id = :id", nativeQuery = true)
    List<Tuple> listaEmprendimientosById(@Param("id") int id);
}
