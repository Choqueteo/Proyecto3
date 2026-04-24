package hlanz.programacion.criptografia.cesar;

import hlanz.programacion.criptografia.general.Cifrador;
import hlanz.programacion.criptografia.general.CriptoGrafiaFactory;
import hlanz.programacion.criptografia.general.Descifrador;

public class CesarFactory implements CriptoGrafiaFactory {
    private ImplementacionCesar cesar;
    public CesarFactory(){
        this.cesar = new ImplementacionCesar();
    }

    @Override
    public Cifrador getCifrado() {
        return this.cesar;
    }

    @Override
    public Descifrador getDescifrador() {
        return this.cesar;
    }
}
