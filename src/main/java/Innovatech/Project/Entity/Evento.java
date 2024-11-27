package Innovatech.Project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Evento")
public class Evento {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  int id;

    @Column(nullable = false)
    private String titulo;

    private String descripcion;

    private Date fecha;

    @Column(nullable = false)
    private String ubicacion;

    @ManyToOne(targetEntity =  Usuario.class)
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    private Usuario id_usuario;

    @OneToMany(targetEntity = usuario_evento.class,fetch = FetchType.LAZY, mappedBy = "id_evento")
    private List<usuario_evento> usuarioEventos;

    @OneToMany(targetEntity = Emprendimiento_evento.class,fetch = FetchType.LAZY, mappedBy = "id_evento")
    private List<Emprendimiento_evento> emprendimientoEventos;

    public Evento(int id, String titulo, String descripcion, Date fecha, String ubicacion, Usuario id_usuario) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.id_usuario = id_usuario;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
