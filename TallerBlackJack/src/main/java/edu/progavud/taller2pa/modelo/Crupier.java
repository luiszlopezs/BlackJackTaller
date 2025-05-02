/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller2pa.modelo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author hailen
 */
public class Crupier implements Serializable {
    
    private String nombre;
    private String apellido;
    private int cedula;
    transient private List<Mano> mano;


    public Crupier(String nombre, String apellido, int cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

    public Crupier() {
    }
    

    
    public void repartirCartas(List<Jugador> jugadores) {
        for (Jugador jugador : jugadores) {
            jugador.getMano().get(0).agregarCarta(mazo.sacarCarta()); // Reparte dos cartas
            jugador.getMano().get(0).agregarCarta(mazo.sacarCarta());
        }
        // Banca reparte una carta visible y una oculta
        mano.agregarCarta(mazo.sacarCarta()); // Carta visible
        mano.agregarCarta(mazo.sacarCarta()); // Carta oculta
    }
    
    public void turnoBanca() {
        // Si la suma de las cartas de la banca es 16 o menos, toma carta
        while (mano.getValorMano() <= 16) { // con este getvalormano, tiene que crearse un metodo en control mano que maneje los valores de las cartas en especial de los aces, mirar capturas
            mano.agregarCarta(mazo.sacarCarta());
        }
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
    
    
    
    

    
    
    
    
    
}
