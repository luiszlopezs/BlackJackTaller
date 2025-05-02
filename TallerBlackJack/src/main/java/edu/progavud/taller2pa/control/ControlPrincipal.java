/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller2pa.control;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import edu.progavud.taller2pa.modelo.*;

/**
 *
 * @author sangr
 */
public class ControlPrincipal {

    private ControlJugador cJugador;
    private ControlCrupier cCrupier;
    private ControlMano cMano;
    private Mazo mazo;
    private ControlCarta cCarta;
    private GestorSerializacion gSerializacion;
    private int turnoActual;
    // Eliminamos el mapa redundante ya que Jugador y Crupier ya tienen una List<Mano>
    private boolean juegoEnCurso;

    public ControlPrincipal() {
        mazo = new Mazo(this);
        cCarta = new ControlCarta(this);
        cCrupier = new ControlCrupier(this);
        cJugador = new ControlJugador(this);
        cMano = new ControlMano(this);
        juegoEnCurso = false;
        // gSerializacion = new GestorSerializacion(); // Descomentarlo cuando implementes el GestorSerializacion
    }

    public void iniciarJuego() {
        if (juegoEnCurso) {
            return; // No iniciar un nuevo juego si ya hay uno en curso
        }
        
        juegoEnCurso = true;
        turnoActual = 0;
        
        // Cargar jugadores si es necesario
        cargarJugadores();
        
        // Seleccionar dos jugadores aleatorios
        List<Jugador> seleccionados = seleccionarDosAleatorios();
        cJugador.setJugadoresEnRonda(seleccionados);
        
        // Inicializar las manos para cada jugador
        for (Jugador jugador : cJugador.getJugadoresEnRonda()) {
            // Limpiar manos previas si existieran
            jugador.getMano().clear();
            // Crear una nueva mano para el jugador
            jugador.getMano().add(new Mano());
        }
        
        // Repartir cartas iniciales
        repartirCartasIniciales();
        
        // Iniciar el primer turno
        iniciarTurnoJugador();
    }
    
    private void cargarJugadores() {
  
    }

    private void repartirCartasIniciales() {
        // Repartir dos cartas a cada jugador
        for (Jugador jugador : cJugador.getJugadoresEnRonda()) {
            Mano manoJugador = jugador.getMano().get(0);
            manoJugador.agregarCarta(mazo.sacarCarta());
            manoJugador.agregarCarta(mazo.sacarCarta());
        }
        
        // Asegurarse de que el crupier tenga una mano inicializada
        if (cCrupier.getCrupier().getMano().isEmpty()) {
            cCrupier.getCrupier().getMano().add(new Mano());
        }
        
        // Repartir dos cartas al crupier
        cCrupier.getCrupier().getMano().get(0).agregarCarta(mazo.sacarCarta());
        cCrupier.getCrupier().getMano().get(0).agregarCarta(mazo.sacarCarta()); // Segunda carta (oculta)
        
        // Verificar si hay Blackjack inicial
        verificarBlackjackInicial();
    }
    
    private void verificarBlackjackInicial() {
        boolean crupierPuedeBlackjack = cCarta.getValor(cCrupier.getCrupier().getMano().get(0).getCartas().get(0)) >= 10 
                                       || cCarta.getValor(cCrupier.getCrupier().getMano().get(0).getCartas().get(0)) == 1;
        
        // Si el crupier muestra una carta que puede dar Blackjack (10, J, Q, K o A)
        if (crupierPuedeBlackjack) {
            // Ofrecer seguro a los jugadores (implementado en la interfaz gráfica)
        }
        
        // Verificar si el crupier tiene Blackjack
        boolean crupierTieneBlackjack = cMano.esBlackjack(cCrupier.getCrupier().getMano().get(0));
        
        if (crupierTieneBlackjack) {
            for (Jugador jugador : cJugador.getJugadoresEnRonda()) {
                Mano manoJugador = jugador.getMano().get(0);
                if (cMano.esBlackjack(manoJugador)) {
                    // Empate - devolver apuesta
                    jugador.setDinero(jugador.getDinero() + jugador.getValorApuesta());
                } else {
                    // Jugador pierde (no hacer nada, la apuesta ya está hecha)
                }
            }
            // Terminar juego si el crupier tiene Blackjack
            terminarRonda();
            return;
        }
        
        // Verificar si algún jugador tiene Blackjack
        for (Jugador jugador : cJugador.getJugadoresEnRonda()) {
            Mano manoJugador = jugador.getMano().get(0);
            if (cMano.esBlackjack(manoJugador)) {
                // Pagar 3:2 por Blackjack
                int ganancia = (int) (jugador.getValorApuesta() * 1.5);
                jugador.setDinero(jugador.getDinero() + jugador.getValorApuesta() + ganancia);
                jugador.setIsPlantado(true); // Este jugador ya terminó su turno
            }
        }
    }
    
    public List<Jugador> seleccionarDosAleatorios() {
        return cJugador.seleccionarDosAleatorios();
    }
    
    public void eliminarJugadoresSeleccionados() {
        List<Jugador> seleccionados = cJugador.getJugadoresEnRonda();
        for (Jugador jugador : seleccionados) {
            cJugador.getJugadores().remove(jugador);
        }
    }
    
    public void realizarApuesta(int fichas, Jugador jugador) {
        cJugador.comprarFichas(fichas, jugador);
        cJugador.apostar(jugador);
    }
    
    public void pedirCartaJugador() {
        Jugador jugadorActual = cJugador.getJugadoresEnRonda().get(turnoActual);
        Mano manoActual = jugadorActual.getMano().get(0);
        
        // Agregar carta a la mano del jugador
        manoActual.agregarCarta(mazo.sacarCarta());
        
        // Verificar si se pasó de 21
        if (cMano.esPasado(manoActual)) {
            jugadorActual.setIsPlantado(true);
            avanzarTurno();
        }
    }
    
    public void doblarApuesta() {
        Jugador jugadorActual = cJugador.getJugadoresEnRonda().get(turnoActual);
        Mano manoActual = jugadorActual.getMano().get(0);
        
        // Duplicar la apuesta
        jugadorActual.setValorApuesta(jugadorActual.getValorApuesta() * 2);
        
        // Dar una carta más y terminar el turno
        manoActual.agregarCarta(mazo.sacarCarta());
        jugadorActual.setIsPlantado(true);
        
        avanzarTurno();
    }
    
    public void plantarseJugador() {
        Jugador jugadorActual = cJugador.getJugadoresEnRonda().get(turnoActual);
        jugadorActual.setIsPlantado(true);
        avanzarTurno();
    }
    
    public void dividir(Jugador jugador){
        Mano manoOriginal = jugador.getMano().get(0);
        
        if(!cMano.puedeDividir(manoOriginal)){
            return;
        }
        
        Mano manoNueva1 = new Mano();
        manoNueva1.agregarCarta(manoOriginal.getCartas().get(0));
        manoNueva1.agregarCarta(mazo.sacarCarta());
        
        Mano manoNueva2 = new Mano();
        manoNueva2.agregarCarta(manoOriginal.getCartas().get(0));
        manoNueva2.agregarCarta(mazo.sacarCarta());
        
        //Reemplazar la mano original por las dos nuevas
        jugador.getMano().clear();
        jugador.getMano().add(manoNueva1);
        jugador.getMano().add(manoNueva2);
    }
    
    private void avanzarTurno() {
        turnoActual++;
        
        // Si todos los jugadores han terminado, es el turno del crupier
        if (turnoActual >= cJugador.getJugadoresEnRonda().size()) {
            jugarTurnoCrupier();
        } else {
            iniciarTurnoJugador();
        }
    }
    
    public void iniciarTurnoJugador() {
        if (turnoActual >= cJugador.getJugadoresEnRonda().size()) {
            jugarTurnoCrupier();
            return;
        }
        
        Jugador jugadorActual = cJugador.getJugadoresEnRonda().get(turnoActual);
        if (jugadorActual.isIsPlantado()) {
            // Si el jugador ya se plantó (por ejemplo, con un Blackjack), avanzar al siguiente
            avanzarTurno();
        }
        // Aquí podrías notificar a la interfaz gráfica que es el turno de un nuevo jugador
    }
    
    public void jugarTurnoCrupier() {
        // El crupier revela su carta oculta
        
        while (cCrupier.debePedirCarta()) {
            cCrupier.pedirCarta();
        }
        
        terminarRonda();
    }
    
    public void pedirCartaCrupier() {
        if (cCrupier.debePedirCarta()) {
            cCrupier.pedirCarta();
        } else {
            terminarRonda();
        }
    }
    
    public void terminarRonda() {
        // Calcular resultados
        determinarGanadores();
        
        // Finalizar el juego
        juegoEnCurso = false;
        
        // Guardar estado si es necesario
        guardarEstado();
    }
    
    private void determinarGanadores() {
        int valorManoCrupier = cMano.calcularValorMano(cCrupier.getCrupier().getMano().get(0));
        boolean crupierPasado = cMano.esPasado(cCrupier.getCrupier().getMano().get(0));
        
        for (Jugador jugador : cJugador.getJugadoresEnRonda()) {
            Mano manoJugador = jugador.getMano().get(0);
            int valorManoJugador = cMano.calcularValorMano(manoJugador);
            
            // Si el jugador se pasó, ya perdió (no se hace nada, la apuesta ya se perdió)
            if (cMano.esPasado(manoJugador)) {
                continue;
            }
            
            // Si el crupier se pasó, el jugador gana
            if (crupierPasado) {
                jugador.setDinero(jugador.getDinero() + (jugador.getValorApuesta() * 2)); // Devolver apuesta + ganancia
            } 
            // Si el jugador tiene más puntos que el crupier, gana
            else if (valorManoJugador > valorManoCrupier) {
                jugador.setDinero(jugador.getDinero() + (jugador.getValorApuesta() * 2)); // Devolver apuesta + ganancia
            } 
            // Si hay empate, se devuelve la apuesta
            else if (valorManoJugador == valorManoCrupier) {
                jugador.setDinero(jugador.getDinero() + jugador.getValorApuesta()); // Devolver solo la apuesta
            }
            // Si el jugador tiene menos puntos que el crupier, pierde (no se hace nada)
        }
    }
    
    private void guardarEstado() {
        // Aquí podrías utilizar el GestorSerializacion para guardar el estado del juego
        if (gSerializacion != null) {
            // gSerializacion.guardarJugadores(cJugador.getJugadores());
        }
    }
    
    public boolean esJuegoEnCurso() {
        return juegoEnCurso;
    }
    
    public Jugador getJugadorActual() {
        if (turnoActual < cJugador.getJugadoresEnRonda().size()) {
            return cJugador.getJugadoresEnRonda().get(turnoActual);
        }
        return null;
    }
    
    public ControlCarta getcCarta() {
        return cCarta;
    }

    public ControlCrupier getcCrupier() {
        return cCrupier;
    }

    public ControlJugador getcJugador() {
        return cJugador;
    }

    public ControlMano getcMano() {
        return cMano;
    }

    public GestorSerializacion getgSerializacion() {
        return gSerializacion;
    }

    public Mazo getMazo() {
        return mazo;
    }
    
}