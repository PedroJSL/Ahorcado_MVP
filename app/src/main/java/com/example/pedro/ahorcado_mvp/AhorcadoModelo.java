package com.example.pedro.ahorcado_mvp;

public class AhorcadoModelo implements AhorcadoInterface.Modelo {
    private AhorcadoInterface.Presentador p;
    private Diccionario diccionario;

    private boolean partidaEnCurso;
    private boolean pistaUsada;
    private int contadorPista;
    private int contadorErrores;
    private int vidas;
    private Palabras palabra;

    public AhorcadoModelo(AhorcadoPresentador p){
        this.p = p;
        diccionario = new Diccionario();
    }

    @Override
    public void nuevaPartida() {
        palabra = diccionario.getPalabra();
        vidas = 3;
        contadorErrores = 0;
        contadorPista = 0;
        pistaUsada = false;
        partidaEnCurso = true;
    }


    @Override
    public boolean comprobarLetra(String letra) {
        if()
        return false;
    }

    @Override
    public void siguienteRonda() {

    }

    @Override
    public void mostrarDefinicion(String definicion) {

    }

    @Override
    public void darPista() {

    }

    @Override
    public void rondaGanada() {

    }

    @Override
    public void rondaPerdida() {

    }

    @Override
    public void partidaPerdida() {

    }
}
