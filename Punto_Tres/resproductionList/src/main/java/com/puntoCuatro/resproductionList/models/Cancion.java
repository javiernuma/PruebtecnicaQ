package com.puntoCuatro.resproductionList.models;

import com.puntoCuatro.resproductionList.dto.CancionDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "canciones")
public class Cancion extends Model<CancionDTO> {
    @Id
    @Column(name = "id_cancion", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "artista")
    private String artista;

    @Column(name = "album")
    private String album;

    @Column(name = "anno")
    private String anno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }


    @Override
    public CancionDTO getDto(){
        return super.getDto();
    }

    @Override
    public Class<CancionDTO> getDtoClass(){
        return CancionDTO.class;
    }
}
