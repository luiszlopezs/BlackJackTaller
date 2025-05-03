/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller2pa.vista;

import javax.swing.*;
import java.awt.*;

public class BienvenidaView extends JFrame {

    private JButton btnIniciarJuego;
    private JLabel lblTitulo;

    public BienvenidaView() {
        setTitle("Blackjack - Bienvenida");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Fondo personalizado con imagen
        ImagenFondoPanel panelFondo = new ImagenFondoPanel("/img/cartasFondo.png");
        panelFondo.setLayout(null); // Posicionamiento absoluto
        setContentPane(panelFondo);

        // Título con fondo negro y letras blancas
        lblTitulo = new JLabel("¡BIENVENIDO A BLACKJACK 21!", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBackground(Color.BLACK);
        lblTitulo.setOpaque(true);
        lblTitulo.setBounds(120, 100, 560, 50);
        panelFondo.add(lblTitulo);

        // Botón dorado centrado
        btnIniciarJuego = new JButton("Iniciar Juego");
        btnIniciarJuego.setFont(new Font("SansSerif", Font.BOLD, 18));
        btnIniciarJuego.setBackground(new Color(255, 204, 0)); // Dorado
        btnIniciarJuego.setFocusPainted(false);
        btnIniciarJuego.setBounds(300, 300, 200, 45);
        panelFondo.add(btnIniciarJuego);
    }
}
