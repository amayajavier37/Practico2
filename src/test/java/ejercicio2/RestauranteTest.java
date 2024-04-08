package ejercicio2;

import org.junit.jupiter.api.Test;
import persistenciaEj1.EnDiscoRegistroInscripcion;

import static org.junit.jupiter.api.Assertions.*;

class RestauranteTest {

    private Plato plato1 = new Plato("Milanesa", 1500);
    private Plato plato2 = new Plato("Pure de Papas", 3500);
    private Plato plato3 = new Plato("Asado", 5500);

    private Bebida bebida1 = new Bebida("Agua saborizada", 1000);
    private Bebida bebida2 = new Bebida("Gaseosa", 1500);
    private Bebida bebida3 = new Bebida("Vino", 2500);

    @Test
    public void testReservaMesa() {
        Mesa mesa = new Mesa(1, 5);
        mesa.reservarMesa(5);

        assertTrue(mesa.estaReservada());
    }

    @Test
    public void testDesocuparMesa() {
        Mesa mesa = new Mesa(1, 5);
        mesa.reservarMesa(5);
        mesa.desocuparMesa();

        assertFalse(mesa.estaReservada());
    }

    @Test
    public void testPagoTarjetaVisa() {
        Mesa mesa1 = new Mesa(1, 10);

        Pedido pedido1 = new Pedido(1, new EnDiscoRegistroInscripcion());
        pedido1.agregarplato(this.plato1);
        pedido1.agregarplato(this.plato2);
        pedido1.agregarBebida(this.bebida3);
        pedido1.confirmarPedido();
        mesa1.agregarPedido(pedido1);
        var visa = new Visa();

        assertEquals(7796.25, visa.montoAPagar(mesa1.cobrar()));
    }

    @Test
    public void testPagoTarjetaMastercard() {
        Mesa mesa2 = new Mesa(2, 8);

        Pedido pedido1 = new Pedido(2, new EnDiscoRegistroInscripcion());
        pedido1.agregarplato(this.plato3);
        pedido1.agregarBebida(this.bebida1);
        pedido1.agregarBebida(this.bebida2);
        pedido1.confirmarPedido();
        mesa2.agregarPedido(pedido1);

        var master = new MasterCard();
        assertEquals(8226.75, master.montoAPagar(mesa2.cobrar()));


    }

    @Test
    public void testPagoTarjetaComarca() {
        Mesa mesa2 = new Mesa(2, 8);

        Pedido pedido1 = new Pedido(2, new EnDiscoRegistroInscripcion());
        pedido1.agregarplato(this.plato3);
        pedido1.agregarBebida(this.bebida1);
        pedido1.agregarBebida(this.bebida2);
        pedido1.confirmarPedido();
        mesa2.agregarPedido(pedido1);

        var comarca = new ComarcaPlus();
        comarca.montoAPagar(mesa2.cobrar());

        assertEquals(8148.0, comarca.montoAPagar(mesa2.cobrar()));
    }

    @Test
    public void testPagoTarjetaViedma() {
        Mesa mesa2 = new Mesa(2, 8);

        Pedido pedido1 = new Pedido(2, new EnDiscoRegistroInscripcion());
        pedido1.agregarplato(this.plato3);
        pedido1.agregarBebida(this.bebida1);
        pedido1.agregarBebida(this.bebida2);
        pedido1.confirmarPedido();
        mesa2.agregarPedido(pedido1);

        var tarjetaComun = new TarjetaViedma();

        assertEquals(8400, tarjetaComun.montoAPagar(mesa2.cobrar()));
    }

}