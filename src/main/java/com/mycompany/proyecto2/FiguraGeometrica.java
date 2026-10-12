package com.mycompany.proyecto2;

/** Superclase abstracta de las figuras del gestor. */
public abstract class FiguraGeometrica {

    /** Cada figura calcula su área con su propia fórmula. */
    public abstract double calcularArea();

    /** Cada figura se desplaza a su manera. */
    public abstract void mover(double dx, double dy);
}
