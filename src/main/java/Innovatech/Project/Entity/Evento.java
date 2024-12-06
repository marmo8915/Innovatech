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

    @OneToMany(targetEntity = usuario_evento.class,fetch = FetchType.LAZY, mappedBy = "id_evento")
    private List<usuario_evento> usuarioEventos;

    @OneToMany(targetEntity = Emprendimiento_evento.class,fetch = FetchType.LAZY, mappedBy = "id_evento")
    private List<Emprendimiento_evento> emprendimientoEventos;

    public Evento() {
    }

    public Evento(int id, String titulo, String descripcion, Date fecha, String ubicacion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
