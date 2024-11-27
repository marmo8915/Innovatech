package Innovatech.Project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="Reaccion")
public class Reaccion {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  int id;

    private  int valoracion;

    private String comentario;

    @ManyToOne(targetEntity =  Emprendimiento.class)
    @JoinColumn(name = "id_emprendimiento")
    @JsonIgnore
    private Emprendimiento id_emprendimiento;

    @ManyToOne(targetEntity =  Usuario.class)
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    private Usuario id_usuario;

    public Reaccion(int valoracion, int id, String comentario, Emprendimiento id_emprendimiento, Usuario id_usuario) {
        this.valoracion = valoracion;
        this.id = id;
        this.comentario = comentario;
        this.id_emprendimiento = id_emprendimiento;
        this.id_usuario = id_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Emprendimiento getId_emprendimiento() {
        return id_emprendimiento;
    }

    public void setId_emprendimiento(Emprendimiento id_emprendimiento) {
        this.id_emprendimiento = id_emprendimiento;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }
}
