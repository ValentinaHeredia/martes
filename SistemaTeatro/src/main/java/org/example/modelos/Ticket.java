package org.example.modelos;
import org.example.modelos.mediosDePago.MedioDePago;

import java.util.List;

public class Ticket {
    private float total;
    private MedioDePago medioPago;
    private List<Entrada> listaEntradas;

    public Ticket() {
    }

    public Ticket(float total, MedioDePago medioPago, List<Entrada> listaEntradas) {
        this.total = total;
        this.medioPago = medioPago;
        this.listaEntradas = listaEntradas;
    }

    public String generarTicket() {
        return "Ticket de compra" +
                "\n------------------------------------------------------------" +
                "\nEntradas: " + listaEntradas +
                "\n------------------------------------------------------------" +
                "\nMedio de Pago: " + medioPago + "$" + total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public MedioDePago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioDePago medioPago) {
        this.medioPago = medioPago;
    }

    public List<Entrada> getListaEntradas() {
        return listaEntradas;
    }

    public void setListaEntradas(List<Entrada> listaEntradas) {
        this.listaEntradas = listaEntradas;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "total=" + total +
                ", medioPago='" + medioPago + '\'' +
                ", listaEntradas=" + listaEntradas +
                '}';
    }
}
