/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller2pa.vista;

import javax.swing.*;
import java.awt.*;

public class ResultadosView extends JFrame {

    private JLabel lblResultado;
    private JLabel lblGanador;
    private JLabel lblTrofeo;
    private JButton btnCerrar;

    public ResultadosView() {
        setTitle("Resultado de la partida");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal con fondo rojo claro
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(new Color(255, 235, 235));
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setContentPane(panelPrincipal);

        // Título
        lblResultado = new JLabel("Resultado de la partida");
        lblResultado.setFont(new Font("Arial", Font.BOLD, 22));
        lblResultado.setForeground(Color.ORANGE);
        lblResultado.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(lblResultado);

        panelPrincipal.add(Box.createVerticalStrut(20));

        // Imagen del trofeo
        lblTrofeo = new JLabel(escalarImagen("/img/Trofeo.png", 100, 100));
        lblTrofeo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(lblTrofeo);

        panelPrincipal.add(Box.createVerticalStrut(20));

        // Ganador
        lblGanador = new JLabel("Ganó el Jugador ...");
        lblGanador.setFont(new Font("Arial", Font.BOLD, 18));
        lblGanador.setForeground(Color.ORANGE);
        lblGanador.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(lblGanador);

        panelPrincipal.add(Box.createVerticalStrut(20));

        // Resultado final
        JLabel lblPuntaje = new JLabel("\"Puntaje final: Jugador 1 - 21, Jugador 2 - 18\"");
        lblPuntaje.setFont(new Font("Arial", Font.PLAIN, 14));
        lblPuntaje.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(lblPuntaje);

        panelPrincipal.add(Box.createVerticalStrut(20));

        // Botón cerrar
        btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Arial", Font.BOLD, 14));
        btnCerrar.setBackground(Color.YELLOW);
        btnCerrar.setFocusPainted(false);
        btnCerrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCerrar.addActionListener(e -> dispose());
        panelPrincipal.add(btnCerrar);
    }

    private ImageIcon escalarImagen(String ruta, int ancho, int alto) {
        ImageIcon icono = new ImageIcon(getClass().getResource(ruta));
        Image img = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ResultadosView().setVisible(true));
    }
}
