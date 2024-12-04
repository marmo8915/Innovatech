package Innovatech.Project.DTO;


import java.sql.Date;
import java.sql.Timestamp;

public class EmprendimientoDTO {
    private Integer nit;
    private Integer matricula;
    private Timestamp fecha;
    private String razonSocial;
    private String ciudad;
    private String usuario;
    private  String nombre;
    private Integer id;

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Timestamp getFechaCreacion() {
        return fecha;
    }

    public void setFechaCreacion(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmprendimientoDTO(Integer id, Integer nit, Integer matricula, String nombre, Timestamp fecha, String razonSocial, String ciudad, String usuario) {
        this.id = id;
        this.nit = nit;
        this.matricula = matricula;
        this.fecha = fecha;
        this.razonSocial = razonSocial;
        this.ciudad = ciudad;
        this.usuario = usuario;
        this.nombre = nombre;
    }
}
