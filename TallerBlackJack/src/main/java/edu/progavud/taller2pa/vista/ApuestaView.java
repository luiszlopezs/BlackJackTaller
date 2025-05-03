/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller2pa.vista;

import javax.swing.*;
import java.awt.*;

public class ApuestaView extends JFrame {

    private JLabel lblNombreJugador1, lblFichasJugador1, lblDineroJugador1;
    private JButton btnFicha10Jugador1, btnFicha50Jugador1, btnFicha100Jugador1, btnListoJugador1;

    private JLabel lblNombreJugador2, lblFichasJugador2, lblDineroJugador2;
    private JButton btnFicha10Jugador2, btnFicha50Jugador2, btnFicha100Jugador2, btnListoJugador2;

    public ApuestaView() {
        setTitle("Apuesta de Jugadores");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2, 10, 0)); // Dos paneles lado a lado

        add(crearPanelJugador1());
        add(crearPanelJugador2());

        setVisible(true);
    }

    private JPanel crearPanelJugador1() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(220, 240, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        lblNombreJugador1 = new JLabel("Jugador 1");
        lblFichasJugador1 = new JLabel("Fichas: 0");
        lblDineroJugador1 = new JLabel("Dinero: $1000");

        btnFicha10Jugador1 = new JButton(new ImageIcon(getClass().getResource("/img/ficha1.png")));
        btnFicha50Jugador1 = new JButton(new ImageIcon(getClass().getResource("/img/ficha2.png")));
        btnFicha100Jugador1 = new JButton(new ImageIcon(getClass().getResource("/img/ficha3.png")));
        btnListoJugador1 = new JButton("Listo");

        gbc.gridx = 0; gbc.gridy = 0; panel.add(lblNombreJugador1, gbc);
        gbc.gridy++; panel.add(lblFichasJugador1, gbc);
        gbc.gridy++; panel.add(lblDineroJugador1, gbc);
        gbc.gridy++; panel.add(btnFicha10Jugador1, gbc);
        gbc.gridy++; panel.add(btnFicha50Jugador1, gbc);
        gbc.gridy++; panel.add(btnFicha100Jugador1, gbc);
        gbc.gridy++; panel.add(btnListoJugador1, gbc);

        return panel;
    }

    private JPanel crearPanelJugador2() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 245, 220));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        lblNombreJugador2 = new JLabel("Jugador 2");
        lblFichasJugador2 = new JLabel("Fichas: 0");
        lblDineroJugador2 = new JLabel("Dinero: $1000");

        btnFicha10Jugador2 = new JButton(new ImageIcon(getClass().getResource("/img/ficha1.png")));
        btnFicha50Jugador2 = new JButton(new ImageIcon(getClass().getResource("/img/ficha2.png")));
        btnFicha100Jugador2 = new JButton(new ImageIcon(getClass().getResource("/img/ficha3.png")));
        btnListoJugador2 = new JButton("Listo");

        gbc.gridx = 0; gbc.gridy = 0; panel.add(lblNombreJugador2, gbc);
        gbc.gridy++; panel.add(lblFichasJugador2, gbc);
        gbc.gridy++; panel.add(lblDineroJugador2, gbc);
        gbc.gridy++; panel.add(btnFicha10Jugador2, gbc);
        gbc.gridy++; panel.add(btnFicha50Jugador2, gbc);
        gbc.gridy++; panel.add(btnFicha100Jugador2, gbc);
        gbc.gridy++; panel.add(btnListoJugador2, gbc);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ApuestaView::new);
    }
}
