/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reposicion_lab5p2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lourdes
 */
public class Residencial {
    private String nombre;
    private int añoFundacion;
    private List<Villa> villas;

    // Constructor
    public Residencial(String nombre, int añoFundacion) {
        this.nombre = nombre;
        this.añoFundacion = añoFundacion;
        this.villas = new ArrayList<>();
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public int getAñoFundacion() {
        return añoFundacion;
    }

    public List<Villa> getVillas() {
        return villas;
    }

    // Método para agregar una villa a la residencial
    public void agregarVilla(Villa villa) {
        villas.add(villa);
    }
    
}
