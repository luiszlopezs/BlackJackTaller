/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller2pa.control;

import edu.progavud.taller2pa.modelo.Carta;

/**
 *
 * @author sangr
 */
public class ControlCarta {
    private Carta carta;

    public ControlCarta(Carta carta) {
        this.carta = carta;
    }
    
    public int getValor() {
        if (carta.getNumero() == 1) {
            return 1; // El As vale 1 por defecto, la lógica para 11 está en Mano
        } else if (carta.getNumero()>= 11 && carta.getNumero() <= 13) {
            return 10; // J, Q, K valen 10
        } else {
            return carta.getNumero(); // 2-10 simplemente se les asigna el valor del numero que los identifica
        }
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }
    
    
    
    
}
