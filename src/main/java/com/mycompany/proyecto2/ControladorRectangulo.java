package com.mycompany.proyecto2;

/** Controlador: lógica del gestor y conexión entre vista y modelo. */
public class ControladorRectangulo {
    private Rectangulo rectangulo;
    private VistaRectangulo vista;

    public ControladorRectangulo(VistaRectangulo vista) {
        this.vista = vista;
        vista.addCrearListener(e -> crear());
        vista.addAreaListener(e -> area());
        vista.addMoverListener(e -> mover());
        vista.addEscalarListener(e -> escalar());
        vista.addPuntoListener(e -> puntoDentro());
    }

    private boolean hayRectangulo() {
        if (rectangulo == null) {
            vista.mostrar("Primero debe crear un rectángulo.");
            return false;
        }
        return true;
    }

    private void crear() {
        try {
            Punto a = new Punto(vista.getX1(), vista.getY1());
            Punto b = new Punto(vista.getX2(), vista.getY2());
            if (a.getX() == b.getX() || a.getY() == b.getY()) {
                vista.mostrar("Los vértices deben tener X y Y distintos.");
                return;
            }
            rectangulo = new Rectangulo(a, b);
            vista.mostrar("Creado: " + rectangulo);
        } catch (NumberFormatException ex) {
            vista.mostrar("Ingrese números válidos en las coordenadas.");
        }
    }

    private void area() {
        if (!hayRectangulo()) return;
        vista.mostrar("Área = " + rectangulo.calcularArea());
    }

    private void mover() {
        if (!hayRectangulo()) return;
        try {
            rectangulo.mover(vista.getDx(), vista.getDy());
            vista.mostrar("Movido: " + rectangulo);
        } catch (NumberFormatException ex) {
            vista.mostrar("Ingrese números válidos en dx y dy.");
        }
    }

    private void escalar() {
        if (!hayRectangulo()) return;
        try {
            double f = vista.getFactor();
            if (f <= 0) {
                vista.mostrar("El factor debe ser mayor que 0.");
                return;
            }
            rectangulo.escalar(f);
            vista.mostrar("Escalado x" + f + ": " + rectangulo);
        } catch (NumberFormatException ex) {
            vista.mostrar("Ingrese un factor válido.");
        }
    }

    private void puntoDentro() {
        if (!hayRectangulo()) return;
        try {
            Punto p = new Punto(vista.getPx(), vista.getPy());
            if (rectangulo.contiene(p)) {
                vista.mostrar("El punto " + p + " ESTÁ dentro del rectángulo.");
            } else {
                vista.mostrar("El punto " + p + " NO está dentro del rectángulo.");
            }
        } catch (NumberFormatException ex) {
            vista.mostrar("Ingrese números válidos en el punto.");
        }
    }
}
