/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller2pa.vista;

import javax.swing.*;
import java.awt.*;

public class SeleccionJugadoresView extends JFrame {

    private JLabel lblCrupier;
    private JLabel[] lblCartasJugador1;
    private JLabel[] lblCartasJugador2;
    private JLabel lblFichasJugador1;
    private JLabel lblDineroJugador1;
    private JLabel lblFichasJugador2;
    private JLabel lblDineroJugador2;
    private JLabel lblNombreJugador1;
    private JLabel lblNombreJugador2;
    private JPanel panelCartasJugador1;
    private JPanel panelCartasJugador2;
    private JPanel panelBotonesJugador1;
    private JPanel panelBotonesJugador2;

    public SeleccionJugadoresView() {
        setTitle("Mesa de Blackjack");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Capa principal con fondo
        JLabel fondo = new JLabel();
        fondo.setLayout(new BorderLayout());
        fondo.setIcon(escalarImagen("/img/mesaBlacjack.png", 800, 600));
        setContentPane(fondo);

        // Panel central con contenido
        JPanel panelCentral = new JPanel();
        panelCentral.setOpaque(false);
        panelCentral.setLayout(new BorderLayout());
        fondo.add(panelCentral, BorderLayout.CENTER);

        // Crupier
        lblCrupier = new JLabel();
        lblCrupier.setHorizontalAlignment(SwingConstants.CENTER);
        lblCrupier.setIcon(escalarImagen("/img/Crupier.png", 100, 100));
        panelCentral.add(lblCrupier, BorderLayout.NORTH);

        // Panel cartas y jugadores
        JPanel panelJugadores = new JPanel(new GridLayout(2, 1));
        panelJugadores.setOpaque(false);
        panelCentral.add(panelJugadores, BorderLayout.CENTER);

        // Jugador 1
        JPanel panelJugador1 = new JPanel(new BorderLayout());
        panelJugador1.setOpaque(false);
        panelJugadores.add(panelJugador1);

        panelCartasJugador1 = new JPanel(new GridLayout(1, 5));
        panelCartasJugador1.setOpaque(false);
        lblCartasJugador1 = new JLabel[5];
        for (int i = 0; i < 5; i++) {
            lblCartasJugador1[i] = new JLabel();
            lblCartasJugador1[i].setHorizontalAlignment(SwingConstants.CENTER);
            panelCartasJugador1.add(lblCartasJugador1[i]);
        }
        panelJugador1.add(panelCartasJugador1, BorderLayout.NORTH);

        JPanel panelInfo1 = new JPanel();
        panelInfo1.setOpaque(false);
        lblNombreJugador1 = new JLabel("Jugador 1");
        lblFichasJugador1 = new JLabel("Fichas: 0");
        lblDineroJugador1 = new JLabel("Dinero: 1000");
        panelInfo1.add(lblNombreJugador1);
        panelInfo1.add(lblFichasJugador1);
        panelInfo1.add(lblDineroJugador1);
        panelJugador1.add(panelInfo1, BorderLayout.CENTER);

        panelBotonesJugador1 = new JPanel();
        panelBotonesJugador1.setOpaque(false);
        panelBotonesJugador1.add(new JButton("Pedir carta"));
        panelBotonesJugador1.add(new JButton("Doblar apuesta"));
        panelBotonesJugador1.add(new JButton("Plantarse"));
        panelJugador1.add(panelBotonesJugador1, BorderLayout.SOUTH);

        // Jugador 2
        JPanel panelJugador2 = new JPanel(new BorderLayout());
        panelJugador2.setOpaque(false);
        panelJugadores.add(panelJugador2);

        panelCartasJugador2 = new JPanel(new GridLayout(1, 5));
        panelCartasJugador2.setOpaque(false);
        lblCartasJugador2 = new JLabel[5];
        for (int i = 0; i < 5; i++) {
            lblCartasJugador2[i] = new JLabel();
            lblCartasJugador2[i].setHorizontalAlignment(SwingConstants.CENTER);
            panelCartasJugador2.add(lblCartasJugador2[i]);
        }
        panelJugador2.add(panelCartasJugador2, BorderLayout.NORTH);

        JPanel panelInfo2 = new JPanel();
        panelInfo2.setOpaque(false);
        lblNombreJugador2 = new JLabel("Jugador 2");
        lblFichasJugador2 = new JLabel("Fichas: 0");
        lblDineroJugador2 = new JLabel("Dinero: 1000");
        panelInfo2.add(lblNombreJugador2);
        panelInfo2.add(lblFichasJugador2);
        panelInfo2.add(lblDineroJugador2);
        panelJugador2.add(panelInfo2, BorderLayout.CENTER);

        panelBotonesJugador2 = new JPanel();
        panelBotonesJugador2.setOpaque(false);
        panelBotonesJugador2.add(new JButton("Pedir carta"));
        panelBotonesJugador2.add(new JButton("Doblar apuesta"));
        panelBotonesJugador2.add(new JButton("Plantarse"));
        panelJugador2.add(panelBotonesJugador2, BorderLayout.SOUTH);
    }

    private ImageIcon escalarImagen(String ruta, int ancho, int alto) {
        ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
        Image imagen = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagen);
    }
}
