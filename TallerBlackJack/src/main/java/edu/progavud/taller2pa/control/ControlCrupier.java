/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller2pa.control;

import edu.progavud.taller2pa.modelo.Crupier;

/**
 *
 * @author sangr
 */
public class ControlCrupier {
    private Crupier crupier;
    private ControlPrincipal cPrinc;

    public ControlCrupier(Crupier crupier,ControlPrincipal cPrinc) {
        this.crupier = crupier;
        this.cPrinc = cPrinc;
    }
    
    public boolean debePedirCarta(){
        if(cPrinc.getcMano().calcularValorMano(crupier.getMano().get(0)) <17){ //si el valor de la mano del crupier es menor a 17, el crupier deberá pedir una carta
            return true;
        }else {
            return false;
        }
    }
    
    public Crupier getCrupier(){
        return crupier;
    }
    
    
    
    
    
}
