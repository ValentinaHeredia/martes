package org.example.modelos;

import org.example.modelos.personas.Actor;

import java.util.List;

public class Elenco {
    private String nombre;
    private List<Actor> listaActores;

    public Elenco() {
    }

    public Elenco(String nombre, List<Actor> listaActores) {
        this.nombre = nombre;
        this.listaActores = listaActores;
    }

    public void agregarActor(Actor actor) {
        this.listaActores.add(actor);
    }

    public void eliminarActor(Actor actor) {
        this.listaActores.remove(actor);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Actor> getListaActores() {
        return listaActores;
    }

    public void setListaActores(List<Actor> listaActores) {
        this.listaActores = listaActores;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "nombre='" + nombre + '\'' +
                ", listaActores=" + listaActores +
                '}';
    }
}