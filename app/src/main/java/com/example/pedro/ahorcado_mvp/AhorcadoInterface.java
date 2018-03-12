package com.example.pedro.ahorcado_mvp;

/**
 * Created by pedro on 12/03/2018.
 */

public interface AhorcadoInterface {

    interface Vista {
        void damePista();
        void mostrarDefinicion(String definicion);
        void mostrarPalabraOculta(String palabraOculta);
        void siguienteRonda();
        void nuevaPartida();
    }

    interface Modelo{
        boolean comprobarLetra(String letra);
        void siguienteRonda();
        void mostrarDefinicion(String definicion);
        void darPista();
        void rondaGanada();
        void rondaPerdida();
        void partidaPerdida();
    }

    interface Presentador{
       void mostrarPalabraOculta(String palabraOculta);
       boolean comprobarLetra(String letra);
       void mostrarDefinicion(String definicion);
       void siguienteRonda();
       void darPista();
       void rondaGanada();
       void rondaPerdida();
       void partidaPerdida();
    }
}
