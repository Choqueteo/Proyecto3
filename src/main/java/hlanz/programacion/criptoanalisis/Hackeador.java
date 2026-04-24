package hlanz.programacion.criptoanalisis;

import hlanz.programacion.criptografia.general.Descifrador;

public interface Hackeador extends Descifrador {
    public abstract HackResult descrifrar(String texto);
}
