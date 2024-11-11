package org.example.modelos.mediosDePago.pagoCredito;

import org.example.modelos.mediosDePago.MedioDePago;

public interface PagoCredito extends MedioDePago {

    public float procesarPago(float montoBase);

}
