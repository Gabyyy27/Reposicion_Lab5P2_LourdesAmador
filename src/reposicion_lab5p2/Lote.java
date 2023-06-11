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
public abstract class Lote {
    private String codigoLote;
    private Villa villaPertenencia;
    private int cantidadPisos;
    private Color color;

    // Constructor
    public Lote(String codigoLote, Villa villaPertenencia, int cantidadPisos, Color color) {
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
}
