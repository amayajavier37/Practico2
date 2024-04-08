package ejercicio2;


import ejercicio1.RegistroInscripcion;
import persistenciaEj1.EnDiscoRegistroInscripcion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int idPedido;
    private RegistroInscripcion interfaz;
    private List<Plato> platos;
    private List<Bebida> bebidas;
    private boolean confirmado;

    public Pedido(int idPedido, RegistroInscripcion interfaz) {
        this.platos = new ArrayList<>();
        this.bebidas = new ArrayList<>();
        this.confirmado = false;
        this.idPedido = idPedido;
        this.interfaz = interfaz;
    }

    public void guardarRegistro(double monto){
        String data = LocalDateTime.now().toString() + " || " + monto + "\n";
        this.interfaz.registrar(data);
    }
    public void agregarplato(Plato plato) {
        platos.add(plato);
    }

    public void agregarBebida(Bebida bebida) {
        bebidas.add(bebida);
    }

    public double getPrecioPlatos() {
        double costoTotal = 0.0;
        for (Plato plato : platos) {
            costoTotal += plato.getPrecio();
        }
        return costoTotal;
    }

    public double getPrecioBebidas() {
        double costoTotal = 0.0;
        for (Bebida bebida : bebidas) {
            costoTotal += bebida.getPrecio();
        }
        return costoTotal;
    }

    public void confirmarPedido() {
        confirmado = true;
    }


}
