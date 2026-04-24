package hlanz.programacion.criptoanalisis.cesar;

import hlanz.programacion.criptoanalisis.HackResult;
import hlanz.programacion.criptoanalisis.Hackeador;
import hlanz.programacion.criptoanalisis.Idioma;
import hlanz.programacion.criptografia.cesar.CesarFactory;
import hlanz.programacion.criptografia.cesar.ImplementacionCesar;
import hlanz.programacion.criptografia.general.CriptoGrafiaFactory;
import hlanz.programacion.criptografia.general.Descifrador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CesarHacker implements Hackeador {
    protected List<Idioma> idiomasPosibles;
    protected int porcentajeTolerancia;
    CesarHacker(int porcentajeTolerancia){
        this.idiomasPosibles = new ArrayList<>();
        this.porcentajeTolerancia = porcentajeTolerancia;
        try {
            Idioma ingles = new Idioma("Ingles", "englis.txt");
            Idioma español = new Idioma("Español", "spanish.txt");
            this.idiomasPosibles.add(ingles);
            this.idiomasPosibles.add(español);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public HackResult descrifrar(String texto) {
        Descifrador descifrador = new CesarFactory().getDescifrador();
        for (int i = 0; i< 26; i++){
            String clave = ""+i;
            String fraseDescifrada = descifrador.descifrar(texto, clave);

        }
        return null;
    }
}
