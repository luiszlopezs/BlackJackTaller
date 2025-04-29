
package edu.progavud.taller2pa.control;

import edu.progavud.taller2pa.modelo.Carta;
import edu.progavud.taller2pa.modelo.Mano;
/**
 *
 * @author sangr
 */
public class ControlMano {
    private Mano mano;
    private ControlCarta cCarta;

    public ControlMano(Mano mano, ControlCarta cCarta) {
        this.mano = mano;
        this.cCarta = cCarta;
    }
    
    public void agregarCarta(Carta carta) {
        mano.agregarCarta(carta); // Añade la carta al final de la lista
    }
    //metodo para calcular el valor de la mano
    public int calcularValor() {
        int valor = 0;
        int cantidadAses = 0;

        for (Carta carta : mano.getCartas()) {
            if (carta.getNumero() == 1) {//es un As
                cantidadAses++;
                valor += 11;
            } else {
                valor += cCarta.getValor();
            }

        }
        //En caso de que el valor de la mano sea mayor a 21, y haya un As, el valor de ese As será 1 en lugar de 11
        while(valor > 21 && cantidadAses > 0){
            valor -= 10;
            cantidadAses --;
        }
        return valor;
    }
    
    public boolean esBlackjack(){
        return mano.getCartas().size()== 2 && calcularValor() == 21; //Si hay 2 cartas en la mano, y el valor de esta es 21, eso significa que hay blackjack
    }
    
    public boolean esPasado(){
        return calcularValor() > 21; // 
    }
    
    public void limpiar(){
        mano.getCartas().clear();
    }
}
