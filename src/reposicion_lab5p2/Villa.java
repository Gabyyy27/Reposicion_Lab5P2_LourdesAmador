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
    private String residencial;
    private String capacidadLotes;
    private String seguridad24Horas;

    public Villa(String nombre, String residencial, String capacidadLotes, String seguridad24Horas) {
        this.nombre = nombre;
        this.residencial = residencial;
        this.capacidadLotes = capacidadLotes;
        this.seguridad24Horas = seguridad24Horas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setResidencial(String residencial) {
        this.residencial = residencial;
    }

    public void setCapacidadLotes(String capacidadLotes) {
        this.capacidadLotes = capacidadLotes;
    }

    public void setSeguridad24Horas(String seguridad24Horas) {
        this.seguridad24Horas = seguridad24Horas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getResidencial() {
        return residencial;
    }

    public int getCapacidadLotes() {
        return Integer.parseInt(capacidadLotes);
    }

    public String getSeguridad24Horas() {
        return seguridad24Horas;
    }
}

