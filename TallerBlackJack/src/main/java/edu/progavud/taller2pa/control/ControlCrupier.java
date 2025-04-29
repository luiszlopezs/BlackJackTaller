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
    private ControlMano cMano;

    public ControlCrupier(Crupier crupier, ControlMano cMano) {
        this.crupier = crupier;
        this.cMano = cMano;
    }

    public boolean debePedir(Crupier crupier){
        if(cMano.calcularValor(crupier.getMano().get(0)) < 16){
            return true;
        }else{
            return false;
        }      
    }
    
    
    
    
    
    
    
}
