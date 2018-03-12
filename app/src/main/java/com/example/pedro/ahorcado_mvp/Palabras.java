package com.example.pedro.ahorcado_mvp;

/**
 * Created by pedro on 12/03/2018.
 */

public class Palabras {
    private String palabra;
    private String definicion;

    public Palabras(String palabra, String definicion) {
        this.palabra = palabra;
        this.definicion = definicion;
    }

    public String getPalabra() {
        return palabra;
    }

    public String getDefinicion() {
        return definicion;
    }
}
