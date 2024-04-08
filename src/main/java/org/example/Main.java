package org.example;

import ejercicio1.Concurso;
import ejercicio1.Participante;
import ejercicio1.ProveedorFecha;
import ejercicio2.Bebida;
import ejercicio2.Mesa;
import ejercicio2.Pedido;
import ejercicio2.Plato;
import persistenciaEj1.EnBDRegistro;
import persistenciaEj1.EnMailRegistroInscripcion;
import practicaLambdas.AprendiendoLambdas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        var persistirDatos = new EnBDRegistro();
        var persistirMail = new EnMailRegistroInscripcion();
        var proveedorDeFecha = new ProveedorFecha() {
            @Override
            public LocalDateTime fecha() {
                return LocalDateTime.now();
            }

            @Override
            public String formatearFecha(LocalDateTime fecha) {
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                return fecha.format(formato);
            }
        };

        Plato plato1 = new Plato("Milanesa", 1500);
        Plato plato2 = new Plato("Pure de Papas", 3500);
        Plato plato3 = new Plato("Asado", 5500);

        Bebida bebida1 = new Bebida("Agua saborizada", 1000);
        Bebida bebida2 = new Bebida("Gaseosa", 1500);
        Bebida bebida3 = new Bebida("Vino", 2500);

        Mesa mesa = new Mesa(2, 8);
        Pedido pedido1 = new Pedido(1,persistirDatos);

        pedido1.agregarplato(plato1);
        pedido1.agregarplato(plato2);
        pedido1.agregarBebida(bebida3);
        pedido1.confirmarPedido();
        mesa.agregarPedido(pedido1);

        var concurso = new Concurso(LocalDate.now().minusDays(5),
                LocalDate.now().plusDays(10),
                "concurso", persistirMail ,proveedorDeFecha);
        var participante = new Participante("Javier",106413);
        concurso.inscribir(participante,LocalDate.now());


/*
        pedido1.asignarPlato(plato3);
        pedido1.asignarBebida(bebida1);
        pedido1.asignarBebida(bebida2);

        mesa2.asignarPedido(pedido1);

        var concurso = new Concurso(LocalDateTime.now().minusDays(5),
                LocalDateTime.now().plusDays(10),
                                    1,comunicador,persistirDatos,provedorDeFechas);
        var participante = new Participante("Victor",10);
        concurso.InscribirParticipante(participante,LocalDateTime.now());
*/
        AprendiendoLambdas aprendiendo = new AprendiendoLambdas();
        aprendiendo.unMetodo((c) -> c.length() % 2 == 0 );

        aprendiendo.unMetodo(c -> c.startsWith("a"));
    }
}