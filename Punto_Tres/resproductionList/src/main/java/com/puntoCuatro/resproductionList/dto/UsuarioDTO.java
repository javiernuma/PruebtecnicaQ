package com.puntoCuatro.resproductionList.dto;

import com.puntoCuatro.resproductionList.models.Rol;

import java.util.Date;
import java.util.List;

public class UsuarioDTO extends DTO{

    private String login;

    private String contraseña;

    private String habilitado;

    private Date fechaIngreso;

    private String nombre;

    private String apellido;

    private String correo;

    private List<Rol> roles;

    private Date fechaIngresoReg;

    private Date fechaModificaReg;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public Date getFechaIngresoReg() {
        return fechaIngresoReg;
    }

    public void setFechaIngresoReg(Date fechaIngresoReg) {
        this.fechaIngresoReg = fechaIngresoReg;
    }


    public Date getFechaModificaReg() {
        return fechaModificaReg;
    }

    public void setFechaModificaReg(Date fechaModificaReg) {
        this.fechaModificaReg = fechaModificaReg;
    }
}
