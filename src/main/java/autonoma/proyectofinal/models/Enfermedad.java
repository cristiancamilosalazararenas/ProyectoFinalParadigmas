/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectofinal.models;

import java.util.ArrayList;

/**
 *
 * @author camil
 */
public class Enfermedad {
    private int id;
    private String nombreEnfermedad;
    private String recomendacionBasica;
    private String nombreCategoria;
    private ArrayList<String> listaSintomas;

    public Enfermedad() {
    }
    
    public Enfermedad(int id, String nombreEnfermedad, String recomendacionBasica, String nombreCategoria, ArrayList<String> listaSintomas) {
        this.id = id;
        this.nombreEnfermedad = nombreEnfermedad;
        this.recomendacionBasica = recomendacionBasica;
        this.nombreCategoria = nombreCategoria;
        this.listaSintomas = listaSintomas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
    public String getNombreEnfermedad() {
        return nombreEnfermedad;
    }

    public void setNombreEnfermedad(String nombreEnfermedad) {
        this.nombreEnfermedad = nombreEnfermedad;
    }

    public String getRecomendacionBasica() {
        return recomendacionBasica;
    }

    public void setRecomendacionBasica(String recomendacionBasica) {
        this.recomendacionBasica = recomendacionBasica;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public ArrayList<String> getListaSintomas() {
        return listaSintomas;
    }

    public void setListaSintomas(ArrayList<String> listaSintomas) {
        this.listaSintomas = listaSintomas;
    }
    
    
    
}
