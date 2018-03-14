package com.example.pedro.ahorcado_mvp;


public class AhorcadoPresentador implements AhorcadoInterface.Presentador {
    private AhorcadoInterface.Vista v;
    private AhorcadoInterface.Modelo m;

    public AhorcadoPresentador(AhorcadoVista v){
        this.v = v;
        this.m = new AhorcadoModelo(this);
        iniciarPartida();
    }


    @Override
    public String damePalabra() {
        return m.damePalbra();
    }

    @Override
    public void iniciarPartida() {
        if(v!=null){
            m.nuevaPartida();
            v.mostrarPalabraOculta(m.getPalabra().getPalabraOculta());
        }
    }

    @Override
    public String mostrarPalabraOculta() {
        return m.mostrarPalabraOculta();
    }


    @Override
    public boolean comprobarLetra(String letra) {
        if(v!=null){

            if(m.comprobarLetra(letra)){
                v.mostrarPalabraOculta(m.getPalabra().getPalabraOculta());
                if(m.getPalabra().palabraDescubierta()){
                    m.rondaGanada();
                    v.rondaGanada();
                    v.mostrarPuntuacion(String.valueOf(m.getPuntuacion()));
                }
                return true;
            }else{
                v.cambiarImagen(m.getErrores());
                if(m.getErrores()>=v.getErroresMaximos()){
                    m.rondaPerdida();
                    v.rondaPerdida();
                    if(m.getVidas()<=0){
                        m.partidaPerdida();
                        v.partidaPerdida();
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String mostrarDefinicion() {
        return m.mostrarDefinicion();
    }

    @Override
    public void siguienteRonda() {
            m.siguienteRonda();
            v.mostrarPalabraOculta(m.getPalabra().getPalabraOculta());

    }

    @Override
    public void darPista() {
            m.darPista();
        v.mostrarPalabraOculta(m.getPalabra().getPalabraOculta());
    }

    @Override
    public int getErrores() {
        return m.getErrores();
    }

    @Override
    public int getVidas() {
        return m.getVidas();
    }

    @Override
    public int getPuntuacion() {
        return m.getPuntuacion();
    }

    @Override
    public boolean getEstadoPartida() {
        return m.getPartidaEnCurso();
    }


}
