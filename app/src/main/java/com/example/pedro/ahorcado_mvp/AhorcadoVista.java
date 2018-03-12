package com.example.pedro.ahorcado_mvp;

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

    TableLayout teclado;
    TextView tvVidas;
    TextView tvPalabraOculta, tvPuntos;
    ImageView img, imgDefinicion;
    Button bPista, bSiguientePalabra, bNuevaPartida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ahorcado_view);
        p = new AhorcadoPresentador(this);

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
                mostrarDefinicion("");
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
        TextView tv = (TextView)v;

    }

    @Override
    public void damePista() {

    }

    @Override
    public void mostrarDefinicion(String definicion) {

    }

    @Override
    public void mostrarPalabraOculta(String palabraOculta) {

    }

    @Override
    public void siguienteRonda() {

    }

    @Override
    public void nuevaPartida() {
        crearTeclado();
    }


}
