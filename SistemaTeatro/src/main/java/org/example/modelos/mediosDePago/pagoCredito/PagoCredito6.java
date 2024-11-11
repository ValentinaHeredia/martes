package org.example.modelos.mediosDePago.pagoCredito;

public class PagoCredito6 implements PagoCredito {

    private final int cuotas=6;
    private final float recargo=1.20f;

    @Override
    public float procesarPago(float montoBase) {
        float montoFinal;

        montoFinal = montoBase * recargo / cuotas;

        return montoFinal;
    }

    @Override
    public String nombreMedioDePago() {
        return "credito con 6 cuotas";
    }

    public int getCuotas() {
        return cuotas;
    }

    @Override
    public String toString() {
        return "\nTarjeta de credito - " + cuotas + " cuotas de ";
    }
}
