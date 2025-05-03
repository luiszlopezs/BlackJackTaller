/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller2pa.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionJugadoresView extends JFrame {

    private JLabel[] cartasJugador1 = new JLabel[5];
    private JLabel[] cartasJugador2 = new JLabel[5];
    private JLabel lblNombre1, lblNombre2, lblFichas1, lblFichas2, lblDinero1, lblDinero2;
    private JButton btnPedir1, btnDoblar1, btnPlantarse1;
    private JButton btnPedir2, btnDoblar2, btnPlantarse2;

    public SeleccionJugadoresView() {
        setTitle("Mesa de Blackjack");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ImagenFondoPanel panelPrincipal = new ImagenFondoPanel("/img/mesaBlackjack.png");
        panelPrincipal.setLayout(null);
        setContentPane(panelPrincipal);

        // Estilo de botón dorado
        Color dorado = new Color(255, 215, 0);

        // Cartas Jugador 1
        for (int i = 0; i < cartasJugador1.length; i++) {
            cartasJugador1[i] = new JLabel();
            cartasJugador1[i].setBounds(30 + i * 70, 460, 60, 90);
            cartasJugador1[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
            panelPrincipal.add(cartasJugador1[i]);
        }

        // Cartas Jugador 2
        for (int i = 0; i < cartasJugador2.length; i++) {
            cartasJugador2[i] = new JLabel();
            cartasJugador2[i].setBounds(600 + i * 70, 460, 60, 90);
            cartasJugador2[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
            panelPrincipal.add(cartasJugador2[i]);
        }

        // Labels Jugador 1
        lblNombre1 = new JLabel("Jugador 1");
        lblNombre1.setForeground(Color.WHITE);
        lblNombre1.setBounds(50, 570, 100, 20);
        panelPrincipal.add(lblNombre1);

        lblFichas1 = new JLabel("Fichas: 0");
        lblFichas1.setForeground(Color.WHITE);
        lblFichas1.setBounds(50, 590, 100, 20);
        panelPrincipal.add(lblFichas1);

        lblDinero1 = new JLabel("Dinero: 1000");
        lblDinero1.setForeground(Color.WHITE);
        lblDinero1.setBounds(50, 610, 120, 20);
        panelPrincipal.add(lblDinero1);

        // Botones Jugador 1
        btnPedir1 = new JButton("Pedir carta");
        btnDoblar1 = new JButton("Doblar apuesta");
        btnPlantarse1 = new JButton("Plantarse");
        configurarBoton(btnPedir1, dorado, 50, 640);
        configurarBoton(btnDoblar1, dorado, 180, 640);
        configurarBoton(btnPlantarse1, dorado, 330, 640);
        panelPrincipal.add(btnPedir1);
        panelPrincipal.add(btnDoblar1);
        panelPrincipal.add(btnPlantarse1);

        // Labels Jugador 2
        lblNombre2 = new JLabel("Jugador 2");
        lblNombre2.setForeground(Color.WHITE);
        lblNombre2.setBounds(800, 570, 100, 20);
        panelPrincipal.add(lblNombre2);

        lblFichas2 = new JLabel("Fichas: 0");
        lblFichas2.setForeground(Color.WHITE);
        lblFichas2.setBounds(800, 590, 100, 20);
        panelPrincipal.add(lblFichas2);

        lblDinero2 = new JLabel("Dinero: 1000");
        lblDinero2.setForeground(Color.WHITE);
        lblDinero2.setBounds(800, 610, 120, 20);
        panelPrincipal.add(lblDinero2);

        // Botones Jugador 2
        btnPedir2 = new JButton("Pedir carta");
        btnDoblar2 = new JButton("Doblar apuesta");
        btnPlantarse2 = new JButton("Plantarse");
        configurarBoton(btnPedir2, dorado, 800, 640);
        configurarBoton(btnDoblar2, dorado, 930, 640);
        configurarBoton(btnPlantarse2, dorado, 1080, 640); // puede quedar fuera si la ventana es muy pequeña
        panelPrincipal.add(btnPedir2);
        panelPrincipal.add(btnDoblar2);
        panelPrincipal.add(btnPlantarse2);
    }

    private void configurarBoton(JButton boton, Color color, int x, int y) {
        boton.setBackground(color);
        boton.setForeground(Color.BLACK);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setBounds(x, y, 120, 30);
    }
}
