package com.example.pedro.ahorcado_mvp;
import java.util.ArrayList;

public class Diccionario {
    ArrayList<Palabras> palabras;
    String[] stPalabras = {"ACERO-Aleación de hierro y una pequeña proporción de carbono.",
            "ACIDO-De sabor amargo, parecido al del vinagre o al del limón.",
            "ADJUNTO-Que está unido o va con otra cosa.",
            "AFANAR-Esforzarse mucho en una actividad o para conseguir un propósito.",
            "AHORRO-Gasto o consumo menor.",
            "ATLAS-Libro formado por una colección de mapas, generalmente geográficos.",
            "BALSA-Embarcación hecha de maderos o troncos unidos entre sí.",
            "BERKELIO-Elemento químico, metálico arificial y radiactivo.",
            "BORRACHO-Que tiene disminuidas temporalmente las capacidades físicas o mentales a causa de un consuimo excesivo de bebidas alcohólicas.",
            "BUSCAVIDAS-Persona que sabe ingeniárselas para salir adelante en la vida.",
            "BUZO-Persona que se dedica  abucear o a realizar actividades bajo el agua.",
            "CAFRE-Muy bruto, violento o grosero.",
            "CALABAZAR-Terreno plantado de calabazas.",
            "CALAMIDAD-Desgracia, adversidad, infortunio, o sufrimiento, cuando afecta a muchas personas.",
            "CAMPAÑA-Conjunto de actividades o de esfuerzos organizados para conseguir un fin.",
            "DELINEANTE-Persona que se dedica profesionalmente al trazado o dibujo de planos.",
            "DELITO-Culpa, crimen o quebrantemiento de la ley.",
            "DIABETES-Enfermedad que se caracteriza por un alto nivel de glucosa en la sangre.",
            "ESQUIMAL-De un pubelo que habita en las regiones árticas americanas y asiáticas, o relacionados con él."};

    public Diccionario(){
        palabras = new ArrayList<>();
        leerPalabras();
    }

    private void leerPalabras(){
        for (String palabra:stPalabras) {
            String[] partes = palabra.split("-");
            Palabras p = new Palabras(partes[0],partes[1]);
            palabras.add(p);
        }
    }

    public Palabras getPalabra(){
        int random =(int) (Math.random()*palabras.size());
        Palabras p = palabras.get(random);
        return p;
    }

}
