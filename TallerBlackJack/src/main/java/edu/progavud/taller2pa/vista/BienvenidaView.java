/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller2pa.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BienvenidaView extends JFrame {

    private JButton btnIniciarJuego;
    private JLabel lblTitulo;

    public BienvenidaView() {
        setTitle("Blackjack - Bienvenida");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        
        ImagenFondoPanel panelFondo = new ImagenFondoPanel("/img/cartasFondo.png");
        panelFondo.setLayout(new BorderLayout());
        setContentPane(panelFondo);

        
        lblTitulo = new JLabel("¡Bienvenido a BlackJack 21!", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 32));
        lblTitulo.setForeground(Color.WHITE);
        panelFondo.add(lblTitulo, BorderLayout.NORTH);

        
        JPanel panelBoton = new JPanel();
        panelBoton.setOpaque(false); 
        btnIniciarJuego = new JButton("Iniciar Juego");
        btnIniciarJuego.setFont(new Font("Arial", Font.BOLD, 24));
        btnIniciarJuego.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "¡Vamos a jugar!");
            }
        });

        panelBoton.add(btnIniciarJuego);
        panelFondo.add(panelBoton, BorderLayout.CENTER);
    }
}
