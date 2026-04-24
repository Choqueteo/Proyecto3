package hlanz.programacion.criptoanalisis.cesar;

import hlanz.programacion.criptoanalisis.HackExito;
import hlanz.programacion.criptoanalisis.HackFracaso;
import hlanz.programacion.criptoanalisis.HackResult;
import hlanz.programacion.criptoanalisis.Idioma;
import hlanz.programacion.criptografia.cesar.ROT13Factory;
import hlanz.programacion.criptografia.general.Descifrador;

import java.io.IOException;
import java.util.ArrayList;

public class ROT13Hacker extends CesarHacker{
    ROT13Hacker(int nivelTolerancia) {
        super(nivelTolerancia);
        this.idiomasPosibles = new ArrayList<>();
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
        Descifrador descifrador = new ROT13Factory().getDescifrador();
        HackResult hackResult = null;
        Idioma idioma = null;
        boolean exito = false;
        String textoDescifrado = null;
        for (Idioma i: this.idiomasPosibles){
            textoDescifrado = descifrador.descifrar(texto, "13");
            if (i.contieneFrase(textoDescifrado, this.porcentajeTolerancia)){
                exito = true;
                idioma = i;
            }
        }
        if (exito){
            hackResult = new HackExito(texto, textoDescifrado, "13", idioma.getNombre());
        } else {
            hackResult = new HackFracaso("Idioma desconocido");
        }
        return hackResult;
    }

}
