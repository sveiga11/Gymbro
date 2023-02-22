package com.example.gymbro;

import android.widget.ImageView;

public class Ejercicio {
    String nombre;
    String descripcion;
    float valoracion;
    String zona;
    int imagenEjercicio;
    int imagenPortada;

    public Ejercicio(String nombre, String descripcion, String zona, int imagenEjercicio, int imagenPortada) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.zona = zona;
        this.imagenEjercicio = imagenEjercicio;
        this.imagenPortada = imagenPortada;
    }
}
