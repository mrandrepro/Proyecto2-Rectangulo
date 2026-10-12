package com.mycompany.proyecto2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/** Vista: ventana Swing del gestor de figuras. */
public class VistaRectangulo extends JFrame {
    private JTextField txtX1 = new JTextField(5);
    private JTextField txtY1 = new JTextField(5);
    private JTextField txtX2 = new JTextField(5);
    private JTextField txtY2 = new JTextField(5);
    private JTextField txtDx = new JTextField(5);
    private JTextField txtDy = new JTextField(5);
    private JTextField txtFactor = new JTextField(5);
    private JTextField txtPx = new JTextField(5);
    private JTextField txtPy = new JTextField(5);

    private JButton btnCrear = new JButton("Crear rectángulo");
    private JButton btnArea = new JButton("Calcular área");
    private JButton btnMover = new JButton("Mover");
    private JButton btnEscalar = new JButton("Escalar");
    private JButton btnPunto = new JButton("¿Punto dentro?");

    private JTextArea txtSalida = new JTextArea(8, 40);

    public VistaRectangulo() {
        super("Gestor de Figuras - Rectángulo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(fila(new JLabel("X1:"), txtX1, new JLabel("Y1:"), txtY1,
                new JLabel("X2:"), txtX2, new JLabel("Y2:"), txtY2, btnCrear));
        panel.add(fila(btnArea));
        panel.add(fila(new JLabel("dx:"), txtDx, new JLabel("dy:"), txtDy, btnMover));
        panel.add(fila(new JLabel("Factor:"), txtFactor, btnEscalar));
        panel.add(fila(new JLabel("Px:"), txtPx, new JLabel("Py:"), txtPy, btnPunto));

        txtSalida.setEditable(false);
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(txtSalida), BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private JPanel fila(java.awt.Component... componentes) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        for (java.awt.Component c : componentes) {
            p.add(c);
        }
        return p;
    }

    // ----- Lectura de campos (lanzan NumberFormatException si no son números) -----
    private double leer(JTextField campo) {
        return Double.parseDouble(campo.getText().trim().replace(',', '.'));
    }

    public double getX1() { return leer(txtX1); }
    public double getY1() { return leer(txtY1); }
    public double getX2() { return leer(txtX2); }
    public double getY2() { return leer(txtY2); }
    public double getDx() { return leer(txtDx); }
    public double getDy() { return leer(txtDy); }
    public double getFactor() { return leer(txtFactor); }
    public double getPx() { return leer(txtPx); }
    public double getPy() { return leer(txtPy); }

    // ----- Salida -----
    public void mostrar(String mensaje) {
        txtSalida.append(mensaje + "\n");
    }

    // ----- Registro de listeners (los usa el controlador) -----
    public void addCrearListener(ActionListener l) { btnCrear.addActionListener(l); }
    public void addAreaListener(ActionListener l) { btnArea.addActionListener(l); }
    public void addMoverListener(ActionListener l) { btnMover.addActionListener(l); }
    public void addEscalarListener(ActionListener l) { btnEscalar.addActionListener(l); }
    public void addPuntoListener(ActionListener l) { btnPunto.addActionListener(l); }
}
