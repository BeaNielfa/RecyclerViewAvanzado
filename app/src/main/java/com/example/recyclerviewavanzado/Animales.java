package com.example.recyclerviewavanzado;

class Animales {
    private String nombre;
    private String color;
    private String urlFoto;
    private String raza;

    public Animales() {
    }

    public Animales(String nombre, String color, String urlFoto, String raza) {
        this.nombre = nombre;
        this.color = color;
        this.urlFoto = urlFoto;
        this.raza = raza;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}
