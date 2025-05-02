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

    public Mazo(ControlPrincipal cPrinc) {
        this.cartas = new ArrayList<>();
        this.cPrinc = cPrinc;

        inicializarMazo();
        barajarMazo();
    }

    public void inicializarMazo() { //metodo para crear mazo de 52 cartas
        for (Palo palo : Palo.values()) {
            for (int numero = 1; numero <= 13; numero++) {
                cartas.add(new Carta(numero, palo));
            }

        }
    }

    public void barajarMazo() { // metodo para desordenar los elementos de la lista cartas, de este modo
        Collections.shuffle(cartas);
    }
    // Método para sacar una carta del mazo

    public Carta sacarCarta() {
        if (cartas.isEmpty()) {
            throw new IllegalStateException("El mazo está vacío");
        }
        return cartas.remove(0); // Devuelve y elimina la primera carta de la lista (lo que simula sacar una carta)
    }

    public int getValor(Carta carta) {
        if (carta.getNumero() == 1) {
            return 11; // El As vale 1 por defecto, la lógica para 11 está en Mano
        } else if (carta.getNumero() >= 11 && carta.getNumero() <= 13) {
            return 10; // J, Q, K valen 10
        } else {
            return carta.getNumero(); // 2-10 simplemente se les asigna el valor del numero que los identifica
        }
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> carta) {
        this.cartas = carta;
    }
}
