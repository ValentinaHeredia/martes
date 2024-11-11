package org.example.modelos.ubicaciones;

public class PalcoAlto implements Ubicacion {
    private float multiplicador;

    public PalcoAlto() {
    }

    public PalcoAlto(float multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public float calcularPrecio(float precioBase) {
        return precioBase + (precioBase * multiplicador / 100);
    }

    public float getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(float multiplicador) {
        this.multiplicador = multiplicador;
    }

    public String nombreUbicacion() {
        return "palco_alto";
    }

    @Override
    public String toString() {
        return "PalcoAlto{" +
                "multiplicador=" + multiplicador +
                '}';
    }
}