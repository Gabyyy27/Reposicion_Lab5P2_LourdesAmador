/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reposicion_lab5p2;

import java.awt.Color;
import java.time.LocalTime;

/**
 *
 * @author Lourdes
 */
public  class Negocio extends Lote {
    private LocalTime horaApertura;
    private LocalTime horaCierre;

    // Constructor
    public Negocio(String codigoLote, Villa villaPertenencia, int cantidadPisos, Color color,
            LocalTime horaApertura, LocalTime horaCierre) {
        super(codigoLote, villaPertenencia, cantidadPisos, color);
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    // Getters específicos de Negocio
    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    public LocalTime getHoraCierre() {
        return horaCierre;
    }
}
