package hlanz.programacion.criptografia.cesar;

import hlanz.programacion.criptografia.general.Cifrador;
import hlanz.programacion.criptografia.general.CriptoGrafiaFactory;
import hlanz.programacion.criptografia.general.Descifrador;

public class ROT13Factory implements CriptoGrafiaFactory {

    private ImplementacionROT13 rot13;
    public ROT13Factory(){

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
