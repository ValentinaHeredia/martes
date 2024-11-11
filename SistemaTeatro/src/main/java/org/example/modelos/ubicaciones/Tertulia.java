package org.example.modelos.ubicaciones;

public class Tertulia implements Ubicacion {
    private float multiplicador;

    public Tertulia() {
    }

    public Tertulia(float multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public float calcularPrecio(float precioBase) {
        return precioBase + (precioBase * multiplicador / 100);
    }

    public String nombreUbicacion(){
        return "tertulia";
    }

    public float getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(float multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public String toString() {
        return "Tertulia{" +
                "multiplicador=" + multiplicador +
                '}';
    }
}
