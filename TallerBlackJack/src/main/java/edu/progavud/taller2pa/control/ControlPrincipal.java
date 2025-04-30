/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller2pa.control;

/**
 *
 * @author sangr
 */
public class ControlPrincipal {
    private ControlCarta cCarta;
    private ControlCrupier cCrupier;
    private ControlJugador cJugador;
    private ControlMano cMano;
    private GestorSerializacion gSerializacion;
    private Mazo mazo;

    public ControlPrincipal(ControlCarta cCarta, ControlCrupier cCrupier, ControlJugador cJugador, ControlMano cMano, GestorSerializacion gSerializacion, Mazo mazo) {
        this.cCarta = cCarta;
        this.cCrupier = cCrupier;
        this.cJugador = cJugador;
        this.cMano = cMano;
        this.gSerializacion = gSerializacion;
        this.mazo = mazo;
    }
    
    public int getValorCarta(){
        return cCarta.getValor();
    }
    public int calcularValorManoCrupier(){
        return cMano.calcularValor(cCrupier.getCrupier().getMano().get(0));
    }
}
