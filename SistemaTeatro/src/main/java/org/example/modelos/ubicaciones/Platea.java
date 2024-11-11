package org.example.modelos.ubicaciones;

public class Platea implements Ubicacion {
    private float multiplicador;

    public Platea() {
    }

    public Platea(float multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public float calcularPrecio(float precioBase) {
        return precioBase + (precioBase * multiplicador / 100);
    }

    public String nombreUbicacion(){
        return "platea";
    }

    public float getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(float multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public String toString() {
        return "Platea{" +
                "multiplicador=" + multiplicador +
                '}';
    }
}
