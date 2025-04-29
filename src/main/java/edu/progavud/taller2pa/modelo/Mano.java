/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller2pa.modelo;

import java.util.ArrayList;

/**
 *
 * @author hailen
 */
public class Mano {

    private int valorMano;

    private ArrayList<Carta> cartas;

    public Mano(int valorMano, ArrayList<Carta> cartas) {
        this.valorMano = valorMano;
        this.cartas = cartas;
    }

    public Mano(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public Mano() {
    }
    
    public void agregarCarta(Carta carta){
        cartas.add(carta);
    }

    public ArrayList<Carta> getCartas(){
        return cartas;
    }
    
    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public int getValorMano() {
        return valorMano;
    }

    public void setValorMano(int valorMano) {
        this.valorMano = valorMano;
    }

}
