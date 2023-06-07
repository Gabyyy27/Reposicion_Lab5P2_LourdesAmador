/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reposicion_lab5p2;

/**
 *
 * @author Lourdes
 */
public class Casa extends Lote {
    private int cuartosPersonales;

    // Constructor
    public Casa(String codigoLote, Villa villaPertenencia, int cantidadPisos, String color, int cuartosPersonales) {
        super(codigoLote, villaPertenencia, cantidadPisos, color);
        this.cuartosPersonales = cuartosPersonales;
    }

    // Getter específico de Casa
    public int getCuartosPersonales() {
        return cuartosPersonales;
    }
}
