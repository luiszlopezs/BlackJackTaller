/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller2pa.vista;

import javax.swing.*;
import java.awt.*;

public class ApuestaView extends JFrame {

    public ApuestaView() {
        setTitle("Apuesta de Jugadores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 700);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 2)); // Jugador 1 a la izquierda, Jugador 2 a la derecha

        // Panel Jugador 1
        JPanel panelJugador1 = crearPanelJugador("Jugador 1");
        panelJugador1.setBackground(new Color(200, 255, 200)); // verde claro
        add(panelJugador1);

        // Panel Jugador 2
        JPanel panelJugador2 = crearPanelJugador("Jugador 2");
        panelJugador2.setBackground(new Color(200, 230, 255)); // azul claro
        add(panelJugador2);

        setVisible(true);
    }

    private JPanel crearPanelJugador(String nombreJugador) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(true);

        JLabel lblNombre = new JLabel(nombreJugador, SwingConstants.CENTER);
        lblNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 18));

        JButton btnFicha10 = crearBotonFicha("/img/ficha1.png");
        JButton btnFicha50 = crearBotonFicha("/img/ficha2.png");
        JButton btnFicha100 = crearBotonFicha("/img/ficha3.png");

        JLabel lblFichas = new JLabel("Fichas: 0");
        JLabel lblDinero = new JLabel("Dinero: 1000");
        lblFichas.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblDinero.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnListo = new JButton("Listo");
        btnListo.setBackground(new Color(255, 204, 0)); // dorado
        btnListo.setForeground(Color.BLACK);
        btnListo.setFont(new Font("Arial", Font.BOLD, 14));
        btnListo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(10));
        panel.add(lblNombre);
        panel.add(Box.createVerticalStrut(30));
        panel.add(btnFicha10);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnFicha50);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnFicha100);
        panel.add(Box.createVerticalStrut(30));
        panel.add(lblFichas);
        panel.add(lblDinero);
        panel.add(Box.createVerticalStrut(30));
        panel.add(btnListo);

        return panel;
    }

    private JButton crearBotonFicha(String rutaImagen) {
        JButton boton = new JButton();
        ImageIcon icono = new ImageIcon(getClass().getResource(rutaImagen));
        Image imagen = icono.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH); // tamaño ajustable
        boton.setIcon(new ImageIcon(imagen));
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setPreferredSize(new Dimension(80, 80));
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        return boton;
    }
}
