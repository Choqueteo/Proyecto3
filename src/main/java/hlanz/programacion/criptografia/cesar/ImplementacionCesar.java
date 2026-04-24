package hlanz.programacion.criptografia.cesar;

import hlanz.programacion.criptografia.general.Descifrador;

public class ImplementacionCesar implements Descifrador {

    ImplementacionCesar(){

    }

    protected static char getLetraDesplazada(char letra, int desplazamiento){
        return 'n';
    }

    protected static String desplazarPalabra(String palabra, int desplazamiento){
        return null;
    }

    protected static String desplazarLetrasFrase(String frase, int desplazamiento){
        return null;
    }
    @Override
    public String descifrar(String texto, String clave) {
        return "";
    }
}
