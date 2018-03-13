package com.example.pedro.ahorcado_mvp;

/**
 * Created by pedro on 12/03/2018.
 */

public class Palabras {
    private String palabra;
    private String definicion;
    private String[] palabraOculta;
    private String[] palabraLetraALetra;

    public Palabras(String palabra, String definicion) {
        this.palabra = palabra;
        this.definicion = definicion;
        setPalabraOculta();
    }


    private void setPalabraOculta() {
        palabraLetraALetra = new String[palabra.length()];
        for (int i = 0; i < palabraLetraALetra.length; i++) {
            palabraLetraALetra[i] = String.valueOf(palabra.charAt(i));
        }
        palabraOculta = new String[palabraLetraALetra.length];
        for (int i = 0; i < palabraLetraALetra.length; i++) {
            palabraOculta[i] = "_";
        }
    }

    public String getPalabraOculta() {
        String aux = "";
        for (String caracter : palabraOculta) {
            aux += caracter + " ";
        }
        return aux.trim();
    }

    public String getDefinicion() {
        return definicion;
    }
}
