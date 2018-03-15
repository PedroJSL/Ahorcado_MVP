package com.example.pedro.ahorcado_mvp;

/**
 * Created by pedro on 12/03/2018.
 */

public interface AhorcadoInterface {

    interface Vista {
        void damePista();
        void mostrarDefinicion();
        void mostrarPalabraOculta(String palabraOculta);
        void siguienteRonda();
        void nuevaPartida();
        void rondaGanada();
        void cambiarImagen(int errores);
        void rondaPerdida();
        int getErroresMaximos();
        void partidaPerdida();
        void mostrarPuntuacion(String puntuacion);
        void validarPista(String letra);
    }

    interface Modelo {
        void nuevaPartida();
        boolean comprobarLetra(String letra);
        void siguienteRonda();
        String mostrarDefinicion();
        void darPista();
        void rondaGanada();
        void rondaPerdida();
        void partidaPerdida();
        String damePalabra();
        Palabras getPalabra();
        int getErrores();
        boolean getPartidaEnCurso();
        int getPuntuacion();
        int getVidas();
        int getPistasUsadas();
    }

    interface Presentador {
        String damePalabra();
        void iniciarPartida();
        boolean comprobarLetra(String letra);
        String mostrarDefinicion();
        void siguienteRonda();
        void darPista();
        int getVidas();
        int getPuntuacion();
        boolean getEstadoPartida();
        void validarPista(String pista);
        int getPistasUsadas();
    }
}
