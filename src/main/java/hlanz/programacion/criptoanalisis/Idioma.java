package hlanz.programacion.criptoanalisis;

import hlanz.programacion.criptoanalisis.util.AnalizadorFrase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Idioma {

    private String nombre;
    private Set<String> palabras;

    public Idioma(String nombre, String rutaArchivo) throws IOException {
        this.nombre = nombre;
        this.palabras = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                this.palabras.add(linea.trim().toUpperCase());
            }
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public boolean contienePalabra(String palabra) {
        return this.palabras.contains(palabra.toUpperCase());
    }

    public boolean contieneFrase(String frase, double tolerancia) {
        if (tolerancia < 0 || tolerancia > 100) {
            throw new IllegalArgumentException("El porcentaje de tolerancia debe estar entre 0 y 100");
        }

        int totalPalabrasFrase = new AnalizadorFrase(frase).getNumeroPalabras();

        double limiteMinimo = (totalPalabrasFrase * tolerancia) / 100.0;

        List<String> listaPalabras = new AnalizadorFrase(frase).getPalabras();

        int palabrasEncontradas = 0;
        for (String p : listaPalabras) {
            if (this.contienePalabra(p)) {
                palabrasEncontradas++;
            }
        }
        return palabrasEncontradas > limiteMinimo;
    }
}