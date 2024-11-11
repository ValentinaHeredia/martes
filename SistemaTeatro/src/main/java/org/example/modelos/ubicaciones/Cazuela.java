package org.example.modelos.ubicaciones;

public class Cazuela implements Ubicacion{
    private float multiplicador;

    public Cazuela() {
    }

    public Cazuela(float multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public float calcularPrecio(float precioBase) {
        return precioBase + (precioBase * multiplicador / 100);
    }

    @Override
    public String nombreUbicacion() {
        return "cazuela";
    }

    public float getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(float multiplicador) {
        this.multiplicador = multiplicador;
    }


    @Override
    public String toString() {
        return " Cazuela";
    }
}
