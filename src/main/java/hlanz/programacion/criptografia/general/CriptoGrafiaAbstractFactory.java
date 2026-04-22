package hlanz.programacion.criptografia.general;

import hlanz.programacion.criptografia.cesar.CesarFactory;
import hlanz.programacion.criptografia.cesar.ROT13Factory;

public class CriptoGrafiaAbstractFactory {
    public static CriptoGrafiaFactory getFactory(AlgoritmoCifrado algoritmo){
        if(algoritmo == AlgoritmoCifrado.CESAR){
            return new CesarFactory();
        }else if(algoritmo == AlgoritmoCifrado.ROT13){
            return new ROT13Factory();
        }else{
            throw new IllegalArgumentException("Algoritmo desconocido: "+ algoritmo);
        }
    }
}
