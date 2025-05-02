/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller2pa.control;

import edu.progavud.taller2pa.modelo.Jugador;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author sangr
 */
public class ControlJugador {

    private ArrayList<Jugador> jugadores;
    private List<Jugador> jugadoresEnRonda;
    private ControlPrincipal cPrinc;

    public ControlJugador(ControlPrincipal cPrinc) {
        this.jugadores = new ArrayList();
        this.jugadoresEnRonda = new ArrayList();
        this.cPrinc = cPrinc;

        jugadores.add(new Jugador("Carlos", "Sangronis", 1101821145, 5000, 314, "vgdcs"));
        jugadores.add(new Jugador("J2", "Sangronis", 1101821145, 5000, 314, "vgdcs"));
        jugadores.add(new Jugador("J3", "Sangronis", 1101821145, 5000, 314, "vgdcs"));
        jugadores.add(new Jugador("J4", "Sangronis", 1101821145, 5000, 314, "vgdcs"));
        jugadores.add(new Jugador("J5", "Sangronis", 1101821145, 5000, 314, "vgdcs"));
        jugadores.add(new Jugador("J6", "Sangronis", 1101821145, 5000, 314, "vgdcs"));

    }

    public void comprarFichas(int fichas, Jugador jugador) {
        if (jugador.getDinero() >= fichas && fichas >= 50) { //Si el dinero del jugador es mayor o igual que las fichas que quiere comprar, entonces podrá comprar la cantidad de fichas igual a su dinero. (debe apostar entre 50 y 5000 fichas)
            jugador.setFichas(fichas);
            jugador.setDinero(jugador.getDinero() - fichas); //Al comprar las fichas, al valor del dinero del jugador se le restará la cantidad de fichas que compró
        }
    }

    public int apostar(Jugador jugador) { //metodo para apostar el valor de fichas compradas por el jugador, dado que cada jugador debe participar en una sola ronda, todas las fichas que compre deberán ser utilizadas en esa ronda
        jugador.realizarApuesta(jugador.getFichas());
        return jugador.getValorApuesta();
    }
    
    public void realizarApuesta(){
        
    }

    public void pedirCarta() {
        cPrinc.getcMano().agregarCarta(cPrinc.getMazo().sacarCarta());  //Se añade una carta a la mano
    }

    public void asegurar(Jugador jugador) {
        if (cPrinc.getcMano().esBlackjack(cPrinc.getcCrupier().getCrupier().getMano().get(0))) { //cPrinc llama al metodo esBlackJack de cMano, y le pasa com parametro la mano del crupier. Si esta es blackjack, gana la apuesta 2 a 1 de asegurar
            jugador.setDinero(jugador.getDinero() + (apostar(jugador) / 2) * 2); //apuesta máximo la mitad del dinero apostado inicialmente, y se paga a 2-1
        } else {
            jugador.setDinero(jugador.getDinero() - apostar(jugador)); // si no ocurre esto, el jugador pierde el dinero apostado
        }
    }

    public void doblar(Jugador jugador) { //Metodo para doblar la apuesta, a cambio de pedir una sola carta
        jugador.setValorApuesta(jugador.getValorApuesta() * 2);
        pedirCarta();
    }

    public void plantarse(Jugador jugador) {
        jugador.setIsPlantado(true);
    }

    public List<Jugador> seleccionarDosAleatorios() { //Se crea una lista de dos jugadores a partir de la lista inicial de 6 jugadores  ya creados
        Collections.shuffle(jugadores); //Se usa el método shuffle para "desordenar" la lista, e implementar la aleatoriedad
        return jugadores.subList(0, 2);//Se retorna la nueva lista con los dos jugadores seleccionados

    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public List<Jugador> getJugadoresEnRonda() {
        return jugadoresEnRonda;
    }

    public void setJugadoresEnRonda(List<Jugador> jugadoresEnRonda) {
        this.jugadoresEnRonda = jugadoresEnRonda;
    }

}
