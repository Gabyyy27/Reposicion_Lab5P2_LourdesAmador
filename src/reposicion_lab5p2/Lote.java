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
public abstract class Lote {
    private String codigoLote;
    private Villa villaPertenencia;
    private int cantidadPisos;
    private String color;

    // Constructor
    public Lote(String codigoLote, Villa villaPertenencia, int cantidadPisos, String color) {
        this.codigoLote = codigoLote;
        this.villaPertenencia = villaPertenencia;
        this.cantidadPisos = cantidadPisos;
        this.color = color;
    }

    // Getters y setters
    public String getCodigoLote() {
        return codigoLote;
    }

    public Villa getVillaPertenencia() {
        return villaPertenencia;
    }

    public int getCantidadPisos() {
        return cantidadPisos;
    }

    public String getColor() {
        return color;
    }
    
}
