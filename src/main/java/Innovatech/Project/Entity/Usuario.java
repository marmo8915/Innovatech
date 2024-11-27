package Innovatech.Project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @ManyToOne(targetEntity = Rol.class)
    @JoinColumn(name = "id_rol")
    @JsonIgnore
    private Rol id_rol;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String telefono;

    @OneToMany(targetEntity = Emprendimiento.class,fetch = FetchType.LAZY, mappedBy = "id_usuario")
    private List<Emprendimiento> emprendimientos;

    @OneToMany(targetEntity = Reaccion.class,fetch = FetchType.LAZY, mappedBy = "id_usuario")
    private List<Reaccion> reaccions;

    @OneToMany(targetEntity = Evento.class,fetch = FetchType.LAZY, mappedBy = "id_usuario")
    private List<Evento> eventos;

    @OneToMany(targetEntity = usuario_evento.class,fetch = FetchType.LAZY, mappedBy = "id_usuario")
    private List<usuario_evento> usuarioEventos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Rol getId_rol() {
        return id_rol;
    }

    public void setId_rol(Rol id_rol) {
        this.id_rol = id_rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Usuario(int id, String telefono, String nombre, String apellido, Rol id_rol, String email, String password) {
        this.id = id;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_rol = id_rol;
        this.email = email;
        this.password = password;
    }
}
