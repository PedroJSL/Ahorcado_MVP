package com.example.pedro.ahorcado_mvp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;


public class AhorcadoVista extends AppCompatActivity implements AhorcadoInterface.Vista, View.OnClickListener{

    private AhorcadoInterface.Presentador p;

    private static final String[] letrasESP = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Ñ", "Z", "X", "C", "V", "B", "N", "M"};
    private ArrayList<TextView> teclas;

    int[] imagenes = {R.drawable.fallo_0,R.drawable.fallo_1,R.drawable.fallo_2,R.drawable.fallo_3,R.drawable.fallo_4,R.drawable.fallo_5,R.drawable.fallo_6};
    TableLayout teclado;
    TextView tvVidas;
    TextView tvPalabraOculta, tvPuntos;
    ImageView img, imgDefinicion;
    Button bPista, bSiguientePalabra, bNuevaPartida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ahorcado_view);

        teclas = new ArrayList<>();
        teclado = findViewById(R.id.teclado);

        img = findViewById(R.id.imgHorca);
        tvPuntos = findViewById(R.id.tvPuntuacion);
        tvVidas = findViewById(R.id.tvVidas);
        tvPalabraOculta = findViewById(R.id.tvPalabraOculta);
        bPista = findViewById(R.id.bPista);
        bPista.setOnClickListener(this);
        bSiguientePalabra = findViewById(R.id.bSiguientePalabra);
        bSiguientePalabra.setOnClickListener(this);
        bNuevaPartida = findViewById(R.id.bNuevaPartida);
        bNuevaPartida.setOnClickListener(this);
        imgDefinicion = findViewById(R.id.bDefinicion);
        imgDefinicion.setOnClickListener(this);

        p = new AhorcadoPresentador(this);
        nuevaPartida();
    }

    public void crearTeclado() {
        teclado.removeAllViews();
        teclas.clear();
        TableRow fila = null;
        TextView bLetra;
        int tvFila = 9;
        int cont = 0;
        int contLetra = 0;
        while (contLetra < letrasESP.length) {
            if (cont == 0) {
                fila = new TableRow(this);
                fila.setGravity(Gravity.CENTER);
                fila.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));
                fila.setPadding(5, 5, 5, 5);
                cont++;
            } else if (cont > 0 && cont < (tvFila + 2)) {
                bLetra = (TextView) getLayoutInflater().inflate(R.layout.textview_abecedario, null);
                bLetra.setText(letrasESP[contLetra]);
                teclas.add(bLetra);
                fila.addView(bLetra);
                contLetra++;
                cont++;
            } else {
                teclado.addView(fila);
                cont = 0;
            }
        }
        teclado.addView(fila);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bDefinicion:
                mostrarDefinicion();
                break;
            case R.id.bPista:
                damePista();
                break;
            case R.id.bSiguientePalabra:
                siguienteRonda();
                break;
            case R.id.bNuevaPartida:
                nuevaPartida();
                break;

        }

    }

    public void pulsarLetra(View v){
        if(p.getEstadoPartida()){
            TextView tv = (TextView) v;
            if(p.damePalabra().contains(((TextView) v).getText().toString())){
                tv.setTextColor(getResources().getColor(R.color.acierto));

            }
            if (p.comprobarLetra(tv.getText().toString())) {
                tv.setTextColor(getResources().getColor(R.color.acierto));
            } else {
                tv.setTextColor(getResources().getColor(R.color.error));
            }
            tv.setEnabled(false);
        }
    }

    @Override
    public void damePista() {
        p.darPista();
    }

    @Override
    public void mostrarDefinicion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View layout = this.getLayoutInflater().inflate(R.layout.dialog_definicion,null);
        builder.setView(layout);
        TextView tv = layout.findViewById(R.id.tvMDef);
        TextView tvTitulo = layout.findViewById(R.id.tvTitulo);
        tvTitulo.setText("DEFINICION DE: "+p.damePalabra());
        tv.setText(p.mostrarDefinicion());
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void mostrarPalabraOculta(String palabraOculta) {
        tvPalabraOculta.setText(palabraOculta);
    }


    @Override
    public void siguienteRonda() {
        p.siguienteRonda();
        actualizarLayout();
    }

    @Override
    public void nuevaPartida() {
        p.iniciarPartida();
        actualizarLayout();
    }

    @Override
    public void rondaGanada() {
        img.setImageResource(R.drawable.victoria);
        bPista.setVisibility(View.GONE);
        bSiguientePalabra.setVisibility(View.VISIBLE);
    }

    @Override
    public void cambiarImagen(int errores) {
        img.setImageResource(imagenes[errores]);
    }

    @Override
    public void rondaPerdida() {
        imgDefinicion.setVisibility(View.VISIBLE);
        bPista.setVisibility(View.GONE);
        bSiguientePalabra.setVisibility(View.VISIBLE);
    }

    @Override
    public int getErroresMaximos() {
        return imagenes.length-1;
    }

    @Override
    public void partidaPerdida() {

        bPista.setVisibility(View.GONE);
        bSiguientePalabra.setVisibility(View.GONE);
        bNuevaPartida.setVisibility(View.VISIBLE);
    }

    @Override
    public void mostrarPuntuacion(String puntuacion) {
        tvPuntos.setText(puntuacion);
    }

    @Override
    public void validarPista(String pista) {
        for (TextView tv:teclas) {
            if(tv.getText().toString().equals(pista)){
                tv.setTextColor(getResources().getColor(R.color.acierto));
                tv.setEnabled(false);
                return; //Pa que no siga buscando que solo hay una letra en el teclado xDD
            }
        }
    }

    private void actualizarLayout(){
        imgDefinicion.setVisibility(View.GONE);
        img.setImageResource(R.drawable.fallo_0);
        bPista.setVisibility(View.VISIBLE);
        bNuevaPartida.setVisibility(View.GONE);
        bSiguientePalabra.setVisibility(View.GONE);
        crearTeclado();
        tvVidas.setText(String.valueOf(p.getVidas()));
        tvPuntos.setText(String.valueOf(p.getPuntuacion()));

    }



}
