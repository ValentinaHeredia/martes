package org.example.modelos;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Teatro {
    private static Teatro instance;
    private String nombre;
    private String direccion;
    private Map<Date, Funcion> dias;
    //private List<Funcion> funciones;

    public Teatro(String nombre, String direccion, Map<Date, Funcion> dias) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.dias = dias;
        //this.funciones = funciones;
    }

    public static Teatro getInstance(String nombre, String direccion, Map<Date, Funcion> dias) {
        if (instance == null) {
            instance = new Teatro(nombre, direccion,dias);
        }
        return instance;
    }

    public void agregarFunción(Date fecha, Funcion funcion) {
        this.dias.put(fecha, funcion);
    }

    public void eliminarFunción(Date fecha) {
        this.dias.remove(fecha);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Map<Date, Funcion> getDias() {
        return dias;
    }

    public void setDias(Map<Date, Funcion> dias) {
        this.dias = dias;
    }

    //public List<Funcion> getFunciones() {
    //    return funciones;
    //}
//
    //public void setFunciones(List<Funcion> funciones) {
    //    this.funciones = funciones;
    //}

    @Override
    public String toString() {
        return "Teatro{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", dias=" + dias +
                '}';
    }
}
