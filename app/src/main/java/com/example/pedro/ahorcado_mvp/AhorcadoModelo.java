package com.example.pedro.ahorcado_mvp;

public class AhorcadoModelo implements AhorcadoInterface.Modelo {
    private AhorcadoInterface.Presentador p;
    private Diccionario diccionario;

    public AhorcadoModelo(AhorcadoPresentador p){
        this.p = p;
        diccionario = new Diccionario();
    }

    @Override
    public boolean comprobarLetra(String letra) {
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
