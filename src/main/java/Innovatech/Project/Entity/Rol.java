package Innovatech.Project.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="Rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Roles nombre;

    public  Rol(){

    }

    public Rol(int id, Roles nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
