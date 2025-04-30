/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller2pa.control;

import java.util.ArrayList;
import edu.progavud.taller2pa.modelo.*;
import java.util.Collections;

/**
 *
 * @author hailen
 */
public class Mazo {
    
    private ArrayList<Carta> cartas;
    private ControlPrincipal cPrinc;

    public Mazo(ArrayList<Carta> cartas, ControlPrincipal cPrinc) {
        this.cartas = new ArrayList<>();
        this.cPrinc = cPrinc;
        
        inicializarMazo();
        barajarMazo();
    }
    
    public void inicializarMazo(){ //metodo para crear mazo de 52 cartas
        for(Palo palo: Palo.values()){
            for(int numero =1 ; numero <= 13; numero ++){
                cartas.add(new Carta(numero,palo));
            }
            
        }
        
    }
    public void barajarMazo(){ // metodo para desordenar los elementos de la lista cartas, de este modo
        Collections.shuffle(cartas);
    }
        // Método para sacar una carta del mazo
    public Carta sacarCarta() {
        if (cartas.isEmpty()) {
            throw new IllegalStateException("El mazo está vacío");
        }
        return cartas.remove(0); // Devuelve y elimina la primera carta de la lista (lo que simula sacar una carta)
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> carta) {
        this.cartas = carta;
    }
}