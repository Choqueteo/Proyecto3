package hlanz.programacion.criptografia.cesar;

public class ImplementacionROT13 extends ImplementacionCesar{
    ImplementacionROT13(){

    }

    @Override
    public String cifrar(String texto, String clave) {
        return ImplementacionCesar.desplazarLetrasFrase(texto,13);
    }

    @Override
    public String descifrar(String texto, String clave) {
        return ImplementacionCesar.desplazarLetrasFrase(texto,-13);
    }
}
