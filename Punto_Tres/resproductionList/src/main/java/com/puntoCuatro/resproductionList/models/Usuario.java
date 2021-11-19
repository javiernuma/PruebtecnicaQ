package com.puntoCuatro.resproductionList.models;

import com.puntoCuatro.resproductionList.dto.UsuarioDTO;
import com.puntoCuatro.resproductionList.general.utils.BooleanToStringConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario extends Model<UsuarioDTO> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    @Column(name = "usuario_login")
    private String login;

    @Column(name = "usuario_contraseña")
    private String contrasena;

    @Convert(converter = BooleanToStringConverter.class)
    @Column(name = "usuario_habilitado")
    private Boolean habilitado;

    @Column(name = "usuario_nombre")
    private String nombre;

    @Column(name = "usuario_apellido")
    private String apellido;

    @Column(name = "usuario_correo")
    private String correo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Roles_Usuarios", joinColumns = @JoinColumn(name = "roles_usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private List<Rol> roles;

    @Column(name = "usuario_fecha_ingreso_reg")
    @Temporal(TemporalType.DATE)
    private Date fechaIngresoReg;

    @Column(name = "usuario_fecha_modifica_reg")
    private Date fechaModificaReg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
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

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    @Override
    public UsuarioDTO getDto(){
        return super.getDto();
    }

    @Override
    public Class<UsuarioDTO> getDtoClass(){
        return UsuarioDTO.class;
    }

}
