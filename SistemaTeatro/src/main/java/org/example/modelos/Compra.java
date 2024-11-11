package org.example.modelos;

import org.example.modelos.mediosDePago.MedioDePago;

import java.util.Arrays;
import java.util.List;

public class Compra {
    private List<Entrada> listaEntradas;
    private float total;
    private MedioDePago medioDePago;

    public Compra() {
    }

    public Compra(List<Entrada> listaEntradas, MedioDePago medioDePago) {
        this.listaEntradas = listaEntradas;
        for (Entrada entradas : listaEntradas){
            this.total += medioDePago.procesarPago(entradas.getPrecio());
        }
        this.medioDePago = medioDePago;
    }

    public void calcularTotal() {
        this.total = 0;
        for (Entrada entradas : listaEntradas){ this.total += entradas.getPrecio();}
    }

    public Ticket crearTicket(){
        return new Ticket(total,medioDePago,listaEntradas);
    }

    public List<Entrada> getListaEntradas() {
        return listaEntradas;
    }

    public void setListaEntradas(List<Entrada> listaEntradas) {
        this.listaEntradas = listaEntradas;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public MedioDePago getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(MedioDePago medioDePago) {
        this.medioDePago = medioDePago;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "listaEntradas=" + listaEntradas +
                ", total=" + total +
                ", medioDePago=" + medioDePago +
                '}';
    }
}
