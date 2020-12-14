package com.example.demosqlite02;

public class ModelRecord {

    String id, nombre, image, artista, genero, pais, anio;


    public ModelRecord() {

    }

    public ModelRecord(String id, String nombre, String image, String artista, String genero, String pais, String anio) {
        this.id = id;
        this.nombre = nombre;
        this.image = image;
        this.artista = artista;
        this.genero = genero;
        this.pais = pais;
        this.anio = anio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

}
