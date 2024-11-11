package org.example.modelos;

import org.example.modelos.ubicaciones.Ubicacion;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

public class Funcion {

    private Date fechaHora;
    private String nombre;
    private int duracion;
    private Elenco grupo;
    private Map<String, Integer> asientosActuales;
    private Map<String, Integer> asientosMaximos;
    private float precioBase;

    public Funcion() {
    }

    public Funcion(Date fechaHora, String nombre, int duracion, Elenco grupo, Map<String, Integer> asientosActuales, Map<String, Integer> asientosMaximos, float precioBase) {
        this.fechaHora = fechaHora;
        this.nombre = nombre;
        this.duracion = duracion;
        this.grupo = grupo;
        this.asientosActuales = asientosActuales;
        this.asientosMaximos = asientosMaximos;
        this.precioBase = precioBase;
    }

    public boolean ubicacionLlena(String ubicacion){
        return asientosActuales.get(ubicacion) >= asientosMaximos.get(ubicacion);
    }

    public void sumarAsientoActual (String ubicacion){
        if (!ubicacionLlena(ubicacion)){
            asientosActuales.put(ubicacion, asientosActuales.get(ubicacion) + 1);
        }
    }

    public void restarAsientoActual (String ubicacion){
        if (asientosActuales.get(ubicacion) > 0){
            asientosActuales.put(ubicacion, asientosActuales.get(ubicacion) - 1);
        }
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Elenco getGrupo() {
        return grupo;
    }

    public void setGrupo(Elenco grupo) {
        this.grupo = grupo;
    }

    public Map<String, Integer> getAsientosActuales() {
        return asientosActuales;
    }

    public void setAsientosActuales(Map<String, Integer> asientosActuales) {
        this.asientosActuales = asientosActuales;
    }

    public Map<String, Integer> getAsientosMaximos() {
        return asientosMaximos;
    }

    public void setAsientosMaximos(Map<String, Integer> asientosMaximos) {
        this.asientosMaximos = asientosMaximos;
    }

    public float getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(float precioBase) {
        this.precioBase = precioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return
                "\n   -" + nombre +
                "\n   -Fecha: "  + fechaHora +
                "\n   -duracion: " + duracion +
                "\n   -$" + precioBase;
    }
}
