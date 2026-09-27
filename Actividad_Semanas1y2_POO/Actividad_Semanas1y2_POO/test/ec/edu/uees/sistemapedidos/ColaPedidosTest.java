package ec.edu.uees.sistemapedidos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColaPedidosTest {

    @Test
    void colaNuevaDebeEstarVacia() {
        ColaPedidos<String> cola = new ColaPedidos<>();

        assertTrue(cola.estaVacia());
        assertEquals(0, cola.tamanio());
    }

    @Test
    void debeAgregarElemento() {
        ColaPedidos<String> cola = new ColaPedidos<>();

        cola.encolar("Pedido 1");

        assertFalse(cola.estaVacia());
        assertEquals(1, cola.tamanio());
    }

    @Test
    void debeConsultarElPrimerElemento() {
        ColaPedidos<String> cola = new ColaPedidos<>();

        cola.encolar("Pedido 1");
        cola.encolar("Pedido 2");

        assertEquals("Pedido 1", cola.frente());
    }

    @Test
    void debeEliminarElementosEnOrdenFIFO() {
        ColaPedidos<String> cola = new ColaPedidos<>();

        cola.encolar("Pedido 1");
        cola.encolar("Pedido 2");
        cola.encolar("Pedido 3");

        assertEquals("Pedido 1", cola.desencolar());
        assertEquals("Pedido 2", cola.desencolar());
        assertEquals("Pedido 3", cola.desencolar());
    }

    @Test
    void debeActualizarLaCantidad() {
        ColaPedidos<String> cola = new ColaPedidos<>();

        cola.encolar("Pedido 1");
        cola.encolar("Pedido 2");

        assertEquals(2, cola.tamanio());

        cola.desencolar();

        assertEquals(1, cola.tamanio());
    }

    @Test
    void colaDebeQuedarVaciaDespuesDeEliminarTodo() {
        ColaPedidos<String> cola = new ColaPedidos<>();

        cola.encolar("Pedido 1");
        cola.desencolar();

        assertTrue(cola.estaVacia());
        assertEquals(0, cola.tamanio());
    }
}