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
        contadorPista = 0;
        this.p = p;
        diccionario = new Diccionario();
    }

    @Override
    public boolean comprobarLetra(String letra){
            if (palabra.contieneLetra(letra)) {
                for (int i = 0; i < palabra.palabraLetraALetra.length; i++) {
                    if (palabra.palabraLetraALetra[i].equals(letra)) {
                        if (palabra.palabraOculta[i].equals(letra)) {
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
            boolean pistaCorrecta = p.comprobarLetra(palabra.palabraLetraALetra[random]);
            if (!pistaCorrecta) {
                darPista();
            }
            p.validarPista(palabra.palabraLetraALetra[random]);
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
        contadorPista=0;
    }

    @Override
    public void rondaPerdida() {
        partidaEnCurso = false;
        vidas--;
    }

    @Override
    public void partidaPerdida() {
        partidaEnCurso = false;

    }

    @Override
    public String damePalbra() {
        return  palabra.getPalabra();
    }

    @Override
    public Palabras getPalabra() {
        return palabra;
    }

    @Override
    public int getErrores() {
        return contadorErrores;
    }

    @Override
    public boolean getPartidaEnCurso() {
        return partidaEnCurso;
    }

    @Override
    public int getPuntuacion() {
        return puntuacion;
    }

    @Override
    public int getVidas() {
        return vidas;
    }


}
