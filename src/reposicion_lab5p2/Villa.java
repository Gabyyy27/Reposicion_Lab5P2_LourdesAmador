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
public class Villa {
     private String nombre;
    private Residencial residencial;
    private int capacidadLotes;
    private String seguridad24Horas;

    public Villa(String nombre, Residencial residencial, int capacidadLotes, String seguridad24Horas) {
        this.nombre = nombre;
        this.residencial = residencial;
        this.capacidadLotes = capacidadLotes;
        this.seguridad24Horas = seguridad24Horas;
    }

    public String getNombre() {
        return nombre;
    }

    public Residencial getResidencial() {
        return residencial;
    }

    public int getCapacidadLotes() {
        return capacidadLotes;
    }

    public String getSeguridad24Horas() {
        return seguridad24Horas;
    }

    public void setSeguridad24Horas(String seguridad24Horas) {
        this.seguridad24Horas = seguridad24Horas;
    }
}
