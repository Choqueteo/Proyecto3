package hlanz.programacion.criptoanalisis.cesar;

import hlanz.programacion.criptoanalisis.*;
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
        boolean finalizarBucle = true;
        HackResult hackResult = null;
        String claveFinal = null;
        Idioma idioma = null;
        for (int i = 0; i< 26 && finalizarBucle; i++){
            String clave = ""+i;
            String fraseDescifrada = descifrador.descifrar(texto, clave);
            for (Idioma id : this.idiomasPosibles){
                if (id.contieneFrase(fraseDescifrada, this.porcentajeTolerancia)){
                    claveFinal = clave;
                    finalizarBucle = false;
                    idioma = id;
                }
            }
            if (finalizarBucle){
                hackResult = new HackFracaso("Idioma desconocido");
            } else {
                hackResult = new HackExito(texto, fraseDescifrada, claveFinal, idioma.getNombre());
            }
        }
        return hackResult;
    }
}
