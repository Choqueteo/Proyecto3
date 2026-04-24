package hlanz.programacion.criptografia.cesar;

import hlanz.programacion.criptoanalisis.util.AnalizadorFrase;
import hlanz.programacion.criptografia.general.Cifrador;
import hlanz.programacion.criptografia.general.Descifrador;
import javafx.scene.control.Alert;

import java.util.List;

public class ImplementacionCesar implements Descifrador, Cifrador {

    ImplementacionCesar(){
    }

    protected static char getLetraDesplazada(char letra, int desplazamiento){
        char le = 'n';
        if (letra>='A' & letra<='Z'){
            int letraDesplazada = letra;
            if (desplazamiento>=1){
                for (int i = 0;i<desplazamiento;i++){
                    letraDesplazada++;
                    if (letraDesplazada>'Z'){
                        letraDesplazada='A';
                    }
                }
            }else if(desplazamiento<=-1){
                for (int i = 0;i>desplazamiento;i--){
                    letraDesplazada--;
                    if (letraDesplazada<'A'){
                        letraDesplazada='Z';
                    }
                }
            }

            le=(char)letraDesplazada;
        }else {
            throw new IllegalArgumentException("Solo se pueden desplazar letras mayúsculas");
        }
        return le;
    }

    protected static String desplazarPalabra(String palabra, int desplazamiento){
        String palabraDesplazada = null;

        String palabraMayus = palabra.toUpperCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<palabraMayus.length();i++){
            char letra = palabraMayus.charAt(i);

            sb.append(ImplementacionCesar.getLetraDesplazada(letra,desplazamiento));
        }
        palabraDesplazada = sb.toString();

        return palabraDesplazada;
    }

    protected static String desplazarLetrasFrase(String frase, int desplazamiento){
        String fraseDesplazada = null;

        AnalizadorFrase analizador = new AnalizadorFrase(frase);
        List<String> palabras = analizador.getPalabras();
        StringBuilder sb = new StringBuilder();

        for (int i = 0;i<palabras.size();i++){
            String palbraDesplazada = ImplementacionCesar.desplazarPalabra(palabras.get(i),desplazamiento);

            if (i==0){
                sb.append(palbraDesplazada);
            }else {
                sb.append(" "+palbraDesplazada);
            }
        }

        fraseDesplazada = sb.toString();

        return fraseDesplazada;
    }
    @Override
    public String descifrar(String texto, String clave) {
        String fraseDescifrada = null;

        try{
            int claveNum = Integer.parseInt(clave);
            if (claveNum>=0){
                fraseDescifrada = ImplementacionCesar.desplazarLetrasFrase(texto,-claveNum);
            }else {
                throw new IllegalArgumentException("La clave debe ser un numero positivo");
            }
        }catch (IllegalArgumentException e){
            System.out.println("La clave debe ser números");
        }
        return  fraseDescifrada;
    }

    @Override
    public String cifrar(String texto, String clave) {
        String fraseCifrada = null;
        try{
            int claveNum = Integer.parseInt(clave);
            if (claveNum>0){
                  fraseCifrada = ImplementacionCesar.desplazarLetrasFrase(texto,claveNum);
            }else {
                throw new IllegalArgumentException("La clave debe ser un número positivo");
            }
        }catch (IllegalArgumentException e){
            System.out.println("La clave debe ser un número");
        }
        return fraseCifrada;
    }
}
