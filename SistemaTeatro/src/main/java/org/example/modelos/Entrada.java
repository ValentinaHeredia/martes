package org.example.modelos;

import org.example.modelos.ubicaciones.Ubicacion;

public class Entrada {
    private Funcion funcion;
    private Ubicacion ubicacion;
    private float precio;

    public Entrada() {
    }

    public Entrada(Funcion funcion, Ubicacion ubicacion) {
        this.funcion = funcion;
        this.ubicacion = ubicacion;
        this.precio = ubicacion.calcularPrecio(funcion.getPrecioBase());
        funcion.sumarAsientoActual(ubicacion.nombreUbicacion());
    }

    public boolean verificarUbicacion() {
       return funcion.ubicacionLlena(ubicacion.nombreUbicacion());
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        return  "\n ............................................  \n " + funcion +
                "\n  - Ubicacion: " + ubicacion;
    }
}
