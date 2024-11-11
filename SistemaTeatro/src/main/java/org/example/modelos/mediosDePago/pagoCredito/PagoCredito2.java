package org.example.modelos.mediosDePago.pagoCredito;

public class PagoCredito2 implements PagoCredito {

    private final int cuotas=2;
    private final float recargo=1.06f;

    @Override
    public float procesarPago(float montoBase) {
        float montoFinal;
        montoFinal = montoBase * recargo / cuotas;
        return montoFinal;
    }

    @Override
    public String nombreMedioDePago() {
        return "credito con 2 cuotas";
    }

    public int getCuotas() {
        return cuotas;
    }

    @Override
    public String toString() {
        return "\nTarjeta de credito - " + cuotas + " cuotas de ";
    }
}
