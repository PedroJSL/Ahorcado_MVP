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
    }

    interface Modelo {
        void nuevaPartida();
        boolean comprobarLetra(String letra);
        void siguienteRonda();
        String mostrarDefinicion();
        void darPista();
        void rondaGanada();
        void rondaPerdida();
        String mostrarPalabraOculta();
        void partidaPerdida();
        String damePalbra();
        Palabras getPalabra();
        int getErrores();
        void setErrores(int errores);
        boolean getPartidaEnCurso();
        int getPuntuacion();
        int getVidas();
    }

    interface Presentador {
        String damePalabra();
        void iniciarPartida();
        String mostrarPalabraOculta();
        boolean comprobarLetra(String letra);
        String mostrarDefinicion();
        void siguienteRonda();
        void darPista();
        int getErrores();
        int getVidas();
        int getPuntuacion();
        boolean getEstadoPartida();
    }
}
