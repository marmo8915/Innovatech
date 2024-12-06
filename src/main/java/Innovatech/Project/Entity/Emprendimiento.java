package Innovatech.Project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Emprendimiento")
public class Emprendimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = true)
    private int NIT;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = true)
    private  int matricula;

    private Date fecha_creacion;

    @ManyToOne(targetEntity =  Ciudad.class)
    @JoinColumn(name = "id_ciudad")
    //@JsonIgnore
    private Ciudad id_ciudad;

    private String razon_social;

    @ManyToOne(targetEntity =  Usuario.class)
    @JoinColumn(name = "id_usuario")
    //@JsonIgnore
    private  Usuario id_usuario;

    @OneToMany(targetEntity = Emprendimiento_evento.class,fetch = FetchType.LAZY, mappedBy = "id_emprendimiento")
    private List<Emprendimiento_evento> emprendimientoEventos;


    public Emprendimiento() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getNIT() {
        return NIT;
    }

    public void setNIT(int NIT) {
        this.NIT = NIT;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Ciudad getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(Ciudad id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Emprendimiento(int id, int NIT, int matricula, String nombre, Date fecha_creacion, String razon_social, Ciudad id_ciudad, Usuario id_usuario) {
        this.id = id;
        this.NIT = NIT;
        this.matricula = matricula;
        this.fecha_creacion = fecha_creacion;
        this.razon_social = razon_social;
        this.id_ciudad = id_ciudad;
        this.id_usuario = id_usuario;
        this.nombre= nombre;
    }
}
