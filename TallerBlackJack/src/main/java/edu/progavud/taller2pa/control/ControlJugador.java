/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller2pa.control;

import edu.progavud.taller2pa.modelo.Jugador;

/**
 *
 * @author sangr
 */
public class ControlJugador {

    private Jugador jugador;
    private ControlPrincipal cPrinc;

    public ControlJugador(Jugador jugador, ControlPrincipal cPrinc) {
        this.jugador = jugador;
        this.cPrinc = cPrinc;
    }

    public void comprarFichas(int fichas) {
        if (jugador.getDinero() >= fichas) { //Si el dinero del jugador es mayor o igual que las fichas que quiere comprar, entonces podrá comprar la cantidad de fichas igual a su dinero
            jugador.setFichas(fichas);
            jugador.setDinero(jugador.getDinero()-fichas); //Al comprar las fichas, al valor del dinero del jugador se le restará la cantidad de fichas que compró
        } 
}
    
    
}
