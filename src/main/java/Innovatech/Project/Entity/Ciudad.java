package Innovatech.Project.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Ciudad")
public class Ciudad {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private  String nombre;

    @Column(nullable = false)
    private String departamento;

    @Column(nullable = false)
    private String pais;

    @OneToMany(targetEntity = Emprendimiento.class,fetch = FetchType.LAZY, mappedBy = "id_ciudad")
    private List<Emprendimiento> emprendimientos;

    public Ciudad() {
    }

    public Ciudad(int id, String nombre, String departamento, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.pais = pais;
    }

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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
