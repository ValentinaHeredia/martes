package org.example.modelos.personas;

import org.example.modelos.Compra;
import org.example.modelos.Entrada;
import org.example.modelos.mediosDePago.MedioDePago;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Persona {
    private String email;
    private List<Compra> compras;

    public Cliente(String nombre, int edad, String email) {
        super(nombre, edad);
        this.compras = new ArrayList<>();
        this.email = email;
    }

    public void realizarCompra() {
        for (Compra comp : compras) {
            System.out.println(comp.crearTicket().generarTicket());
        }
    }

    private Compra planearCompra(List<Entrada> entradas, MedioDePago md){
        //Scanner sc = new Scanner(System.in);
        Compra compra = new Compra(entradas, md);

        return compra;
    }

    public void agrearCompra(List<Entrada> entradas, MedioDePago md) {
        compras.add(planearCompra(entradas, md));
    }

    public void sacarCompra(int indice) {
        compras.remove(indice);
    }

    public String getEmail() {
        return email;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
}