package com.example.pedro.ahorcado_mvp;

public class AhorcadoModelo implements AhorcadoInterface.Modelo {
    private AhorcadoInterface.Presentador p;
    private Diccionario diccionario;

    private boolean partidaEnCurso;
    private boolean pistaUsada;
    private int contadorPista;
    private int contadorErrores;
    private int vidas;
    private int puntuacion;
    private Palabras palabra;

    public AhorcadoModelo(AhorcadoPresentador p){
        this.p = p;
        diccionario = new Diccionario();
    }

    private boolean modificarPalabraOculta(String letra){
        if (palabra.contieneLetra(letra)) {
            for (int i = 0; i < palabra.palabraLetraALetra.length; i++) {
                if (palabra.palabraLetraALetra[i].equals(letra)) {
                    if(palabra.palabraOculta[i].contains(letra)){
                        return false;
                    }
                    palabra.palabraOculta[i] = letra;
                }
            }
            return true;
        }
        contadorErrores++;
        return false;
    }

    @Override
    public void nuevaPartida() {
        palabra = diccionario.getPalabra();
        vidas = 3;
        contadorErrores = 0;
        puntuacion = 0;
        contadorPista = 0;
        pistaUsada = false;
        partidaEnCurso = true;
    }

    @Override
    public void siguienteRonda() {
        palabra = diccionario.getPalabra();
        contadorErrores = 0;
        contadorPista = 0;
        pistaUsada = false;
        partidaEnCurso = true;
    }

    @Override
    public String mostrarDefinicion() {
        return palabra.getDefinicion();
    }

    @Override
    public void darPista() {
        if (contadorPista <= 2) {
            int random = (int) (Math.random() * palabra.palabraOculta.length);
            boolean pistaCorrecta = modificarPalabraOculta(palabra.palabraLetraALetra[random]);
            if (!pistaCorrecta) {
                darPista();
            }
            contadorPista++;
            pistaUsada = true;
        }
    }

    @Override
    public void rondaGanada(){
        partidaEnCurso = false;
        if(pistaUsada){
            puntuacion+=100 -(contadorPista*10);
        }else {
            puntuacion+=100;
        }
    }

    @Override
    public void rondaPerdida() {
        partidaEnCurso = false;
    }

    @Override
    public String mostrarPalabraOculta() {
        return palabra.getPalabraOculta();
    }

    @Override
    public void partidaPerdida() {


    }


}
