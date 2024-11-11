package org.example.modelos.ubicaciones;

public class PalcoBajo implements Ubicacion {
    private float multiplicador;

    public PalcoBajo() {
    }

    public PalcoBajo(float multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public float calcularPrecio(float precioBase) {
        return precioBase + (precioBase * multiplicador / 100);
    }

    public String nombreUbicacion(){
        return "palco_bajo";
    }
    public float getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(float multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public String toString() {
        return "PalcoBajo{" +
                "multiplicador=" + multiplicador +
                '}';
    }
}