package com.puntoCuatro.resproductionList.dto;

import com.puntoCuatro.resproductionList.models.Cancion;

import java.util.List;

public class ListaReproduccioDTO extends DTO{

    private String nombreLista;

    private String descripcion;

    private List<CancionDTO> listaCanciones;

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<CancionDTO> getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(List<CancionDTO> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }
}
