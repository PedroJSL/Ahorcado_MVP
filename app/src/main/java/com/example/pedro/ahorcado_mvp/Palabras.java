package com.example.pedro.ahorcado_mvp;

/**
 * Created by pedro on 12/03/2018.
 */

public class Palabras {
    private String palabra;
    private String definicion;
    String[] palabraOculta;
    String[] palabraLetraALetra;

    public Palabras(String palabra, String definicion) {
        this.palabra = palabra;
        this.definicion = definicion;
        setPalabraOculta();
    }

    public boolean contieneLetra(String letra) {
        if (palabra.contains(letra)) {
            return true;
        }
        return false;
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

    public boolean palabraDescubierta(){
        for (int i = 0; i < palabraLetraALetra.length ; i++) {
          if(!palabraOculta[i].equals(palabraLetraALetra[i])){
              return false;
          }
        }
        return true;
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
