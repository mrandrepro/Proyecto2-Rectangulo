package com.mycompany.proyecto2;

import javax.swing.SwingUtilities;

/** Clase principal: lanza la interfaz. */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VistaRectangulo vista = new VistaRectangulo();
            new ControladorRectangulo(vista);
            vista.setVisible(true);
        });
    }
}
