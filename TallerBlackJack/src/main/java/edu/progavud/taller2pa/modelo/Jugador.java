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
public class Jugador {
    
    private String nombre;
    private String apellido;
    private int cedula;
    private List<Mano> mano;

    private int telefono;
    private int dinero;
    private String direccion;
    private int valorFichas;
    private int valorApuesta;
    private boolean isAsegurado;
    private boolean isPlantado;

    public Jugador(String nombre, String apellido, int cedula, int dinero, int telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.dinero = dinero;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    
    
    public Jugador() {
    }
    
    public void realizarApuesta(int valorFichas) {
        this.valorApuesta = valorFichas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getFichas() {
        return valorFichas;
    }

    public void setFichas(int valorFichas) {
        this.valorFichas = valorFichas;
    }

    public int getValorApuesta() {
        return valorApuesta;
    }

    public void setValorApuesta(int valorApuesta) {
        this.valorApuesta = valorApuesta;
    }

    public int getDinero() {
        return dinero;
    }

    public int getValorFichas() {
        return valorFichas;
    }
    
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public void setValorFichas(int valorFichas) {
        this.valorFichas = valorFichas;
    }
    
    public boolean isIsPlantado() {
        return isPlantado;
    }

    public void setIsPlantado(boolean isPlantado) {
        this.isPlantado = isPlantado;
    }

    public boolean isIsAsegurado() {
        return isAsegurado;
    }

    public void setIsAsegurado(boolean isAsegurado) {
        this.isAsegurado = isAsegurado;
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

    public void setMano(List<Mano> mano) {
        this.mano = mano;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
    

}

