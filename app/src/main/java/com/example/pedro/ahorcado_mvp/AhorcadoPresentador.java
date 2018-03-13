package com.example.pedro.ahorcado_mvp;


public class AhorcadoPresentador implements AhorcadoInterface.Presentador {
    private AhorcadoInterface.Vista v;
    private AhorcadoInterface.Modelo m;

    public AhorcadoPresentador(AhorcadoVista v){
        this.v = v;
        this.m = new AhorcadoModelo(this);
    }


    @Override
    public void iniciarPartida() {

    }

    @Override
    public void mostrarPalabraOculta(String palabraOculta) {

    }

    @Override
    public boolean comprobarLetra(String letra) {
        return false;
    }

    @Override
    public void mostrarDefinicion(String definicion) {

    }

    @Override
    public void siguienteRonda() {

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
