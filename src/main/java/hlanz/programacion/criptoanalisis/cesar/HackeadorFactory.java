package hlanz.programacion.criptoanalisis.cesar;

import hlanz.programacion.criptoanalisis.Hackeador;
import hlanz.programacion.criptografia.general.AlgoritmoCifrado;

public class HackeadorFactory   {
    public static Hackeador getHackeador(AlgoritmoCifrado a, int pcTolerancia){
        Hackeador hackeador = null;
        if (!(pcTolerancia>= 0 && pcTolerancia <= 100)){
            throw new IllegalArgumentException("El porcentaje debe estar entre [0,100]");
        }
        if (a.equals(AlgoritmoCifrado.CESAR)){
            hackeador = new CesarHacker(pcTolerancia);
        } else if (a.equals(AlgoritmoCifrado.ROT13)){
            hackeador = new ROT13Hacker(pcTolerancia);
        }
        return hackeador;
    }
}
