package org.example;

import org.example.modelos.*;
import org.example.modelos.mediosDePago.MedioDePago;
import org.example.modelos.mediosDePago.pagoCredito.PagoCredito2;
import org.example.modelos.mediosDePago.PagoDebito;
import org.example.modelos.mediosDePago.PagoEfectivo;
import org.example.modelos.mediosDePago.pagoCredito.PagoCredito4;
import org.example.modelos.mediosDePago.pagoCredito.PagoCredito6;
import org.example.modelos.personas.Actor;
import org.example.modelos.personas.Cliente;
import org.example.modelos.ubicaciones.Cazuela;
import org.example.modelos.ubicaciones.Paraiso;
import org.example.modelos.ubicaciones.Tertulia;
import org.example.modelos.ubicaciones.Ubicacion;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //----------------------------Actores----------------------------
        System.out.println("Ingrese el nombre del primer actor:");
        String nombreActor1 = scanner.nextLine();
        System.out.println("Ingrese la edad del primer actor:");
        int edadActor1 = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.println("Ingrese la profesión del primer actor:");
        String profesionActor1 = scanner.nextLine();

        Actor a1 = new Actor(nombreActor1, edadActor1, profesionActor1);

        System.out.println("Ingrese el nombre del segundo actor:");
        String nombreActor2 = scanner.nextLine();
        System.out.println("Ingrese la edad del segundo actor:");
        int edadActor2 = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.println("Ingrese la profesión del segundo actor:");
        String profesionActor2 = scanner.nextLine();

        Actor a2 = new Actor(nombreActor2, edadActor2, profesionActor2);

        List<Actor> listaA = new ArrayList<>();
        listaA.add(a1);
        listaA.add(a2);

        //---------------------------Elenco----------------------------
        System.out.println("Ingrese el nombre del elenco:");
        String nombreElenco = scanner.nextLine();
        Elenco elenco = new Elenco(nombreElenco, listaA);

        //----------------------------Asientos----------------------------
        Map<String, Integer> AsientosActuales = new HashMap<>();
        Map<String, Integer> AsientosMaximos = new HashMap<>();

        AsientosActuales.put("cazuela", 0);
        AsientosActuales.put("paraiso", 0);
        AsientosActuales.put("tertulia", 0);

        AsientosMaximos.put("cazuela", 50);
        AsientosMaximos.put("paraiso", 75);
        AsientosMaximos.put("tertulia", 100);

        //---------------------------Funciones----------------------------
        Map<Date, Funcion> funciones = new HashMap<>();
        boolean agregarOtraFuncion = true;

        while (agregarOtraFuncion) {
            System.out.println("Ingrese el nombre de la función:");
            String nombreFuncion = scanner.nextLine();
            System.out.println("Ingrese el precio de la entrada:");
            int precioEntrada = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            // Crear la nueva función con una fecha actual y otros parámetros
            Funcion funcion = new Funcion(new Date(), nombreFuncion, precioEntrada, elenco, AsientosActuales, AsientosMaximos, 100);

            // Agregar la función al mapa de funciones usando la fecha como clave
            funciones.put(new Date(), funcion);

            // Preguntar si desea agregar otra función
            System.out.println("¿Desea agregar otra función? (s/n)");
            String respuesta = scanner.nextLine();

            if (!respuesta.equalsIgnoreCase("s")) {
                agregarOtraFuncion = false;
            }
        }


        //----------------------------Teatro----------------------------
        System.out.println("Ingrese el nombre del teatro:");
        scanner.nextLine();
        String nombreTeatro = scanner.nextLine();
        System.out.println("Ingrese la dirección del teatro:");
        String direccionTeatro = scanner.nextLine();

        Teatro teatro = new Teatro(nombreTeatro, direccionTeatro, funciones);

        //----------------------------Ubicaciones----------------------------
        Ubicacion cazuela = new Cazuela();
        Ubicacion paraiso = new Paraiso();
        Ubicacion tertulia = new Tertulia();

        //----------------------------Entradas----------------------------

        List<Entrada> listaEntradas = new ArrayList<>();
        boolean seguirComprando = true;

        System.out.println("\nFunciones disponibles:");
        int i = 1;
        for (Date fecha : funciones.keySet()) {
            System.out.println(i + ". " + funciones.get(fecha).getNombre() + " - Fecha: " + fecha);
            i++;
        }

        while (seguirComprando) {


            System.out.print("\nSeleccione el número de la función que desea comprar: ");
            int seleccionFuncion = scanner.nextInt();
            scanner.nextLine();

            // Obtener la función seleccionada
            Funcion funcionSeleccionada = (Funcion) funciones.values().toArray()[seleccionFuncion - 1];

            boolean ubicacionValida = false;

            while (!ubicacionValida) {
                System.out.println("Seleccione la ubicación:\n 1. Cazuela\n 2. Paraiso\n 3. Tertulia\n 4. Cancelar");
                int seleccionUbicacion = scanner.nextInt();
                scanner.nextLine();

                if (seleccionUbicacion == 4) {
                    System.out.print("¿Desea seguir comprando? (s/n): ");
                    String respuesta = scanner.nextLine();
                    if (!respuesta.equalsIgnoreCase("s")) {
                        seguirComprando = false;
                    }
                    ubicacionValida = true; // Salimos del bucle interno de selección de ubicación
                    continue;
                }

                Ubicacion ubicacionElegida;
                switch (seleccionUbicacion) {
                    case 1:
                        ubicacionElegida = cazuela;
                        break;
                    case 2:
                        ubicacionElegida = paraiso;
                        break;
                    case 3:
                        ubicacionElegida = tertulia;
                        break;
                    default:
                        System.out.println("Ubicación inválida. Intente de nuevo.");
                        continue;
                }

                // Verificar si la ubicación está llena
                if (!funcionSeleccionada.ubicacionLlena(ubicacionElegida.nombreUbicacion())) {
                    Entrada entradaNueva = new Entrada(funcionSeleccionada, ubicacionElegida);
                    listaEntradas.add(entradaNueva);
                    System.out.println("Entrada agregada exitosamente en " + ubicacionElegida.nombreUbicacion() + ".");
                    ubicacionValida = true;
                } else {
                    System.out.println("La ubicación " + ubicacionElegida.nombreUbicacion() + " está llena. Seleccione otra ubicación.");
                }
            }

            if (seguirComprando) {
                System.out.print("¿Desea seguir comprando? (s/n): ");
                String respuesta = scanner.nextLine();
                seguirComprando = respuesta.equalsIgnoreCase("s");
            }
        }

        //----------------------------Medio de pago----------------------------
        MedioDePago credito2 = new PagoCredito2();
        MedioDePago credito4 = new PagoCredito4();
        MedioDePago credito6 = new PagoCredito6();
        MedioDePago efectivo = new PagoEfectivo();
        MedioDePago debito = new PagoDebito();

        //----------------------------Cliente----------------------------
        System.out.println("Ingrese el nombre del cliente:");
        String nombreCliente = scanner.nextLine();
        System.out.println("Ingrese la edad del cliente:");
        int edadCliente = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el email del cliente:");
        String emailCliente = scanner.nextLine();

        Cliente cliente1 = new Cliente(nombreCliente, edadCliente, emailCliente);

        // Selección del medio de pago
        MedioDePago medioDePagoSeleccionado = null;
        System.out.println("Seleccione el medio de pago:\n1. Crédito\n2. Débito\n3. Efectivo");
        int opcionPago = scanner.nextInt();
        scanner.nextLine();

        if (opcionPago == 1) { // Crédito
            System.out.println("Seleccione la cantidad de cuotas:\n1. 2 cuotas\n2. 4 cuotas\n3. 6 cuotas");
            int opcionCuotas = scanner.nextInt();
            scanner.nextLine();

            switch (opcionCuotas) {
                case 1:
                    medioDePagoSeleccionado = credito2;
                    break;
                case 2:
                    medioDePagoSeleccionado = credito4;
                    break;
                case 3:
                    medioDePagoSeleccionado = credito6;
                    break;
                default:
                    System.out.println("Opción de cuotas inválida. Se seleccionará el pago en 2 cuotas.");
                    medioDePagoSeleccionado = credito2;
                    break;
            }
        } else if (opcionPago == 2) { // Débito
            medioDePagoSeleccionado = debito;
        } else if (opcionPago == 3) { // Efectivo
            medioDePagoSeleccionado = efectivo;
        } else {
            System.out.println("Opción de pago inválida. Se seleccionará efectivo por defecto.");
            medioDePagoSeleccionado = efectivo;
        }

        // Realizar la compra
        cliente1.agrearCompra(listaEntradas, medioDePagoSeleccionado);
        cliente1.realizarCompra();

        scanner.close();
    }
}
