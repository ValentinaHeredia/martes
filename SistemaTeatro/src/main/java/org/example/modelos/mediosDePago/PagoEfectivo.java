package org.example.modelos.mediosDePago;

public class PagoEfectivo implements MedioDePago {

    private final float descuento=10;

    public float getDescuento() {
        return descuento;
    }

    @Override
    public float procesarPago(float montoBase) {
        System.out.println("Efectivo " + (montoBase - (montoBase * descuento / 100)));
        return montoBase - (montoBase * descuento / 100);
    }

    @Override
    public String nombreMedioDePago() {
        return "efectivo";
    }

    @Override
    public String toString() {
        return "\nEfectivo - descuento de %" + descuento + " \nTotal: ";
    }
}
