package Innovatech.Project.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Roles name;

    @OneToMany(targetEntity = Usuario.class,fetch = FetchType.LAZY, mappedBy = "id_rol")
    private List<Usuario> usuario;

    public  Rol(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Roles getName() {
        return name;
    }

    public void setName(Roles name) {
        this.name = name;
    }

    public Rol(int id, Roles name) {
        this.id = id;
        this.name = name;
    }
}
