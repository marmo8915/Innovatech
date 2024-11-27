package Innovatech.Project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="usuario_evento")
public class usuario_evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @ManyToOne(targetEntity =  Usuario.class)
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    private  int id_usuario;

    @ManyToOne(targetEntity =  Evento.class)
    @JoinColumn(name = "id_evento")
    @JsonIgnore
    private  int id_evento;
}
