package org.example.modelos.mediosDePago;

public class PagoDebito implements MedioDePago{

    public float procesarPago(float montoBase) {
        return montoBase;
    }

    @Override
    public String nombreMedioDePago() {
        return "debito";
    }

    @Override
    public String toString() {
        return "\nTarjeta de débito";
    }
}
