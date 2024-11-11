package org.example.modelos.mediosDePago;

public interface MedioDePago {
    float procesarPago(float montoBase);
    String nombreMedioDePago();
}
