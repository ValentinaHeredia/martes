package org.example.modelos.ubicaciones;

public class Paraiso implements Ubicacion {
    private float multiplicador;

    public Paraiso() {
    }

    public Paraiso(float multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public float calcularPrecio(float precioBase) {
        return precioBase + (precioBase * multiplicador / 100);
    }

    public String nombreUbicacion(){
        return "paraiso";
    }

    public float getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(float multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public String toString() {
        return "Paraiso{" +
                "multiplicador=" + multiplicador +
                '}';
    }
}