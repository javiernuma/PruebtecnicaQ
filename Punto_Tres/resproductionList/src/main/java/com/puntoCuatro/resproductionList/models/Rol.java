package com.puntoCuatro.resproductionList.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "GDL_Rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private Long id;

    @Column(name = "rol_nombre")
    private String nombre;

    @Temporal(TemporalType.DATE)
    @Column(name = "rol_fecha_ingreso_reg")
    private Date fechaIngresoReg;

    @Column(name = "rol_fecha_modifica_reg")
    private Date fechaModificaReg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
