package com.example.pedro.ahorcado_mvp;

/**
 * Created by pedro on 12/03/2018.
 */

public interface AhorcadoInterface {

    interface Vista {
        void damePista();
        void mostrarDefinicion(String definicion);
        void mostrarPalabraOculta();
        void siguienteRonda();
        void nuevaPartida();
    }

    interface Modelo{
        void nuevaPartida();
        void siguienteRonda();
        String mostrarDefinicion();
        void darPista();
        void rondaGanada();
        void rondaPerdida();
        String mostrarPalabraOculta();
        void partidaPerdida();
    }

    interface Presentador{
        void iniciarPartida();
       void mostrarPalabraOculta();
       boolean comprobarLetra(String letra);
       void mostrarDefinicion();
       void siguienteRonda();
       void darPista();
       void rondaGanada();
       void rondaPerdida();
       void partidaPerdida();
    }
}
