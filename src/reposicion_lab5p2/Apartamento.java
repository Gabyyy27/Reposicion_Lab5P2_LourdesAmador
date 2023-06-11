/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reposicion_lab5p2;

import java.awt.Color;

/**
 *
 * @author Lourdes
 */
public class Apartamento extends Lote {
    private int cuartosFamiliares;
    private int cuartosPersonales;

    // Constructor
    public Apartamento(String codigoLote, Villa villaPertenencia, int cantidadPisos, Color color,
            int cuartosFamiliares, int cuartosPersonales) {
        super(codigoLote, villaPertenencia, cantidadPisos, color);
        this.cuartosFamiliares = cuartosFamiliares;
        this.cuartosPersonales = cuartosPersonales;
    }

    // Getters y setters específicos de Apartamento
    public int getCuartosFamiliares() {
        return cuartosFamiliares;
    }

    public int getCuartosPersonales() {
        return cuartosPersonales;
    }
}
