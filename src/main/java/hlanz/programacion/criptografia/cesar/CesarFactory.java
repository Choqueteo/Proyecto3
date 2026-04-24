package hlanz.programacion.criptografia.cesar;

import hlanz.programacion.criptografia.general.Cifrador;
import hlanz.programacion.criptografia.general.CriptoGrafiaFactory;
import hlanz.programacion.criptografia.general.Descifrador;

public class CesarFactory implements CriptoGrafiaFactory {
    private ImplementacionCesar cesar;
    public CesarFactory(){

    }

    @Override
    public Cifrador getCifrado() {
        return null;
    }

    @Override
    public Descifrador getDescifrador() {
        return null;
    }
}
