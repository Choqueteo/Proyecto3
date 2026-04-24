package hlanz.programacion.criptoanalisis.util;

import java.util.List;
import java.util.StringTokenizer;

public class AnalizadorFrase {
    private String[] palabras;
    public AnalizadorFrase(String frase){
        StringTokenizer st = new StringTokenizer(frase, " ");
        this.palabras = new String[st.countTokens()];
        for (int i = 0; i<=st.countTokens();i++){
            this.palabras[i] = st.nextToken();
        }
    }
    public int getNumeroPalabras(){
        return this.palabras.length;
    }
    public List<String> getPalabras(){
        List<String> listaPalabras = List.of(this.palabras);
        return listaPalabras;
    }
}
