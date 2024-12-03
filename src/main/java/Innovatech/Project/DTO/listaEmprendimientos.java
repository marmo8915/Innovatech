package Innovatech.Project.DTO;

import java.util.Date;

public class listaEmprendimientos {
    private String nit;
    private String matricula;
    private String fecha_creacion;
    private String razon_social;
    private String ciudad;
    private String usuario;

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
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

    public listaEmprendimientos(String nit, String matricula, String fecha_creacion, String razon_social, String ciudad, String usuario) {
        this.nit = nit;
        this.matricula = matricula;
        this.fecha_creacion = fecha_creacion;
        this.razon_social = razon_social;
        this.ciudad = ciudad;
        this.usuario = usuario;
    }

    public listaEmprendimientos() {
    }
}
