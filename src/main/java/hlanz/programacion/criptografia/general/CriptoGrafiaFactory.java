package hlanz.programacion.criptografia.general;

public interface CriptoGrafiaFactory {
    public abstract Cifrador getCifrado();
    public abstract Descifrador getDescifrador();
}
