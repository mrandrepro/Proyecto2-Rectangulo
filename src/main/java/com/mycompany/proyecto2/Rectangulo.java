package com.mycompany.proyecto2;

/** Rectángulo definido por dos vértices opuestos (composición con Punto). */
public class Rectangulo extends FiguraGeometrica {
    private Punto p1;
    private Punto p2;

    public Rectangulo(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Punto getP1() { return p1; }
    public Punto getP2() { return p2; }

    public double getBase() {
        return Math.abs(p2.getX() - p1.getX());
    }

    public double getAltura() {
        return Math.abs(p2.getY() - p1.getY());
    }

    /** Implementación del método abstracto: base x altura. */
    @Override
    public double calcularArea() {
        return getBase() * getAltura();
    }

    /** Implementación del método abstracto: mueve ambos vértices. */
    @Override
    public void mover(double dx, double dy) {
        p1.mover(dx, dy);
        p2.mover(dx, dy);
    }

    /** Escala el rectángulo dejando fijo el vértice p1. */
    public void escalar(double factor) {
        double nuevoX = p1.getX() + (p2.getX() - p1.getX()) * factor;
        double nuevoY = p1.getY() + (p2.getY() - p1.getY()) * factor;
        p2.setX(nuevoX);
        p2.setY(nuevoY);
    }

    /** Un punto está dentro si su X está entre X1 y X2 Y su Y entre Y1 y Y2. */
    public boolean contiene(Punto p) {
        double minX = Math.min(p1.getX(), p2.getX());
        double maxX = Math.max(p1.getX(), p2.getX());
        double minY = Math.min(p1.getY(), p2.getY());
        double maxY = Math.max(p1.getY(), p2.getY());
        return p.getX() >= minX && p.getX() <= maxX
            && p.getY() >= minY && p.getY() <= maxY;
    }

    @Override
    public String toString() {
        return "Rectángulo[" + p1 + " - " + p2 + "] base=" + getBase()
                + ", altura=" + getAltura();
    }
}
