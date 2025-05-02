/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller2pa.vista;

import javax.swing.*;
import java.awt.*;

public class SeleccionJugadoresView extends JFrame {
    private JLabel fondoMesa;
    private JLabel lblImagenCrupier;
    private JLabel[] cartasJugador1;
    private JLabel[] cartasJugador2;
    private JLabel lblNombreJugador1, lblFichasJugador1, lblDineroJugador1;
    private JLabel lblNombreJugador2, lblFichasJugador2, lblDineroJugador2;

    public SeleccionJugadoresView() {
        setTitle("Mesa de Blackjack");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        fondoMesa = new JLabel();
        fondoMesa.setLayout(new BorderLayout());
        setContentPane(fondoMesa);
        fondoMesa.setIcon(escalarImagen("/img/mesaBlacjack.png", 1000, 700));

        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.setOpaque(false);
        fondoMesa.add(panelCentro, BorderLayout.CENTER);

        // Imagen Crupier
        lblImagenCrupier = new JLabel(escalarImagen("/img/Crupier.png", 120, 120));
        lblImagenCrupier.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentro.add(lblImagenCrupier, BorderLayout.NORTH);

        // Panel Jugadores
        JPanel panelJugadores = new JPanel(new GridLayout(1, 2));
        panelJugadores.setOpaque(false);
        panelCentro.add(panelJugadores, BorderLayout.CENTER);

        panelJugadores.add(crearPanelJugador("Jugador 1", true));
        panelJugadores.add(crearPanelJugador("Jugador 2", false));
    }

    private JPanel crearPanelJugador(String nombre, boolean esJugador1) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);

        // Etiquetas nombre, fichas, dinero
        JLabel lblNombre = new JLabel(nombre, SwingConstants.CENTER);
        JLabel lblFichas = new JLabel("Fichas: 0", SwingConstants.CENTER);
        JLabel lblDinero = new JLabel("Dinero: 1000", SwingConstants.CENTER);

        JPanel panelDatos = new JPanel(new GridLayout(3, 1));
        panelDatos.setOpaque(false);
        panelDatos.add(lblNombre);
        panelDatos.add(lblFichas);
        panelDatos.add(lblDinero);

        panel.add(panelDatos, BorderLayout.NORTH);

        // Cartas
        JLabel[] cartas = new JLabel[5];
        JPanel panelCartas = new JPanel(new FlowLayout());
        panelCartas.setOpaque(false);
        for (int i = 0; i < 5; i++) {
            cartas[i] = new JLabel();
            cartas[i].setPreferredSize(new Dimension(60, 90));
            panelCartas.add(cartas[i]);
        }

        panel.add(panelCartas, BorderLayout.CENTER);

        if (esJugador1) {
            lblNombreJugador1 = lblNombre;
            lblFichasJugador1 = lblFichas;
            lblDineroJugador1 = lblDinero;
            cartasJugador1 = cartas;
        } else {
            lblNombreJugador2 = lblNombre;
            lblFichasJugador2 = lblFichas;
            lblDineroJugador2 = lblDinero;
            cartasJugador2 = cartas;
        }

        // Botones
        JPanel panelBotones = new JPanel();
        panelBotones.setOpaque(false);
        panelBotones.add(new JButton("Pedir carta"));
        panelBotones.add(new JButton("Doblar apuesta"));
        panelBotones.add(new JButton("Plantarse"));

        panel.add(panelBotones, BorderLayout.SOUTH);

        return panel;
    }

    private ImageIcon escalarImagen(String ruta, int ancho, int alto) {
        ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
        Image img = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SeleccionJugadoresView().setVisible(true));
    }
}
