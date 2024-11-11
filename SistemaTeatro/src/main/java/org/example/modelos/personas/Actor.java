package org.example.modelos.personas;

public class Actor extends Persona {
    private String especialidad;

    public Actor(String nombre, int edad) {
        super(nombre, edad);
    }

    public Actor(String nombre, int edad, String especialidad) {
        super(nombre, edad);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "especialidad='" + especialidad + '\'' +
                '}';
    }
}
