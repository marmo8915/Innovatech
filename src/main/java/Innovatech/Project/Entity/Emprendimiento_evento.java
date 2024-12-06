package Innovatech.Project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Emprendimiento_evento")
public class Emprendimiento_evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne(targetEntity = Evento.class)
    @JoinColumn(name = "id_evento")
    @JsonIgnore
    private int id_evento;

    @ManyToOne(targetEntity = Emprendimiento.class)
    @JoinColumn(name = "id_emprendimiento")
    @JsonIgnore
    private int id_emprendimiento;
}
