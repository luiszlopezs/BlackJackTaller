/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller2pa.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author hailen
 */
public class Crupier extends Persona implements Serializable {

    public Crupier(String nombre, String apellido, int cedula, List<Mano> mano) {
        super(nombre, apellido, cedula, mano);
    }

    public Crupier() {
    }
    
    public void barajar() { // baraja el mazo 
        Collections.shuffle(mazo.getCartas());
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
    
    
    
    

    
    
    
    
    
}
