/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller2pa.vista;

import javax.swing.*;
import java.awt.*;

public class ApuestaView extends JFrame {

    private JButton btnFichaVerde1, btnFichaAzul1, btnFichaRoja1;
    private JButton btnFichaVerde2, btnFichaAzul2, btnFichaRoja2;
    private JButton btnListo1, btnListo2;
    private JLabel lblFichas1, lblFichas2;
    private JLabel lblDinero1, lblDinero2;

    public ApuestaView() {
        setTitle("Apuesta de Jugadores");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 2));

        // Paneles
        add(crearPanelJugador("Jugador 1", true, new Color(204, 255, 204)));
        add(crearPanelJugador("Jugador 2", false, new Color(204, 229, 255)));
    }

    private JPanel crearPanelJugador(String nombre, boolean esJugador1, Color fondo) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(fondo);

        // Nombre
        JLabel lblNombre = new JLabel(nombre, SwingConstants.CENTER);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(lblNombre, BorderLayout.NORTH);

        // Centro con botones de fichas
        JPanel panelFichas = new JPanel(new GridLayout(3, 1, 5, 5));
        panelFichas.setOpaque(false);
        panelFichas.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

        // Crear botones con imágenes redimensionadas
        btnFichaVerde1 = crearBotonFicha("/img/ficha1.png");
        btnFichaAzul1 = crearBotonFicha("/img/ficha2.png");
        btnFichaRoja1 = crearBotonFicha("/img/ficha3.png");

        if (esJugador1) {
            panelFichas.add(btnFichaVerde1);
            panelFichas.add(btnFichaAzul1);
            panelFichas.add(btnFichaRoja1);
        } else {
            btnFichaVerde2 = crearBotonFicha("/img/ficha1.png");
            btnFichaAzul2 = crearBotonFicha("/img/ficha2.png");
            btnFichaRoja2 = crearBotonFicha("/img/ficha3.png");
            panelFichas.add(btnFichaVerde2);
            panelFichas.add(btnFichaAzul2);
            panelFichas.add(btnFichaRoja2);
        }

        panel.add(panelFichas, BorderLayout.CENTER);

        // Información y botón "Listo"
        JPanel panelInferior = new JPanel(new GridLayout(3, 1));
        panelInferior.setOpaque(false);

        JLabel lblFichas = new JLabel("Fichas: 0", SwingConstants.CENTER);
        JLabel lblDinero = new JLabel("Dinero: 1000", SwingConstants.CENTER);
        JButton btnListo = new JButton("Listo");

        if (esJugador1) {
            lblFichas1 = lblFichas;
            lblDinero1 = lblDinero;
            btnListo1 = btnListo;
        } else {
            lblFichas2 = lblFichas;
            lblDinero2 = lblDinero;
            btnListo2 = btnListo;
        }

        panelInferior.add(lblFichas);
        panelInferior.add(lblDinero);
        panelInferior.add(btnListo);

        panel.add(panelInferior, BorderLayout.SOUTH);

        return panel;
    }

    private JButton crearBotonFicha(String ruta) {
        ImageIcon icon = new ImageIcon(getClass().getResource(ruta));
        Image img = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        JButton boton = new JButton(new ImageIcon(img));
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        return boton;
    }

    // Métodos getters para el controlador
    public JButton getBtnFichaVerde1() { return btnFichaVerde1; }
    public JButton getBtnFichaAzul1() { return btnFichaAzul1; }
    public JButton getBtnFichaRoja1() { return btnFichaRoja1; }
    public JButton getBtnFichaVerde2() { return btnFichaVerde2; }
    public JButton getBtnFichaAzul2() { return btnFichaAzul2; }
    public JButton getBtnFichaRoja2() { return btnFichaRoja2; }
    public JButton getBtnListo1() { return btnListo1; }
    public JButton getBtnListo2() { return btnListo2; }

    public void setFichas1(int fichas) {
        lblFichas1.setText("Fichas: " + fichas);
    }

    public void setDinero1(int dinero) {
        lblDinero1.setText("Dinero: " + dinero);
    }

    public void setFichas2(int fichas) {
        lblFichas2.setText("Fichas: " + fichas);
    }

    public void setDinero2(int dinero) {
        lblDinero2.setText("Dinero: " + dinero);
    }
}
