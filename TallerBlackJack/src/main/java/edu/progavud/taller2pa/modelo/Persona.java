/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller2pa.modelo;

import java.util.List;

/**
 *
 * @author hailen
 */
public class Persona {
    
    protected String nombre;
    protected String apellido;
    protected int cedula;
    protected List<Mano> mano; // Se maneja una lista de manos, para manejar la opcion de split (dividir la mano del jugador)

    public Persona(String nombre, String apellido, int cedula, List<Mano> mano) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.mano = mano;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public List<Mano> getMano() {
        return mano;
    }

    public void setMano(List<Mano> Mano) {
        this.mano = Mano;
    }
    
    
    
}
