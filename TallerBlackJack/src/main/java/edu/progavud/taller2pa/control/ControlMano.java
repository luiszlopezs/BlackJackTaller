
package edu.progavud.taller2pa.control;

import edu.progavud.taller2pa.modelo.Carta;
import edu.progavud.taller2pa.modelo.Mano;
/**
 *
 * @author sangr
 */
public class ControlMano {
    private Mano mano;
    private ControlPrincipal cPrinc;

    public ControlMano(ControlPrincipal cPrinc) {
        this.cPrinc = cPrinc;
    }
    
    public void agregarCarta(Carta carta) {
        mano.agregarCarta(carta); // Añade la carta al final de la lista
    }
    //metodo para calcular el valor de la mano
    public int calcularValorMano(Mano mano) {
        int valor = 0;
        int cantidadAses = 0;

        for (Carta carta : mano.getCartas()) {
            int valorCarta = cPrinc.getcCarta().getValor(carta);
            valor += valorCarta;
            
            if(carta.getNumero() == 1){
                cantidadAses++;
            }

        }
        //En caso de que el valor de la mano sea mayor a 21, y haya un As, el valor de ese As será 1 en lugar de 11
        while(valor > 21 && cantidadAses > 0){
            valor -= 10;
            cantidadAses --;
        }
        return valor;
    }
    
    public boolean esBlackjack(Mano mano){
        return mano.getCartas().size()== 2 && calcularValorMano(mano) == 21; //Si hay 2 cartas en la mano, y el valor de esta es 21, eso significa que hay blackjack
    }
    
    public boolean esPasado(Mano mano){
        return calcularValorMano(mano) > 21; 
    }
    
    public boolean puedeDividir(Mano mano){
        if(mano.getCartas().size() != 2){ //Si el jugador recibe dos cartas del mismo valor, puede dividir
            return false;
        }
        Carta c1 = mano.getCartas().get(0);
        Carta c2 = mano.getCartas().get(1);
        
        return cPrinc.getcCarta().getValor(c1) == cPrinc.getcCarta().getValor(c2);
    }
    
    public void limpiar(){
        mano.getCartas().clear();
    }

   
    
    
    
}

