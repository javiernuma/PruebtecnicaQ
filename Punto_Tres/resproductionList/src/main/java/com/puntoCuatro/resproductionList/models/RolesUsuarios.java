package com.puntoCuatro.resproductionList.models;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class RolesUsuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rous_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rous_usuario_id")
    private Usuario usuarioId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rous_rol_id")
    private Rol rolId;

    @Temporal(TemporalType.DATE)
    @Column(name = "rous_fecha_ingreso_reg")
    private Date fechaIngresoReg;

    @Column(name = "rous_fecha_modifica_reg")
    private Date fechaModificaReg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Rol getRolId() {
        return rolId;
    }

    public void setRolId(Rol rolId) {
        this.rolId = rolId;
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
