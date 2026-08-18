package ec.edu.uees.sistemapedidos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {
    private int numero;
    private Cliente cliente;
    private final List<Producto> productos;

    public Pedido(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public List<Producto> getProductos() {
        return Collections.unmodifiableList(productos);
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularSubtotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public double calcularTotal() {
        double subtotal = calcularSubtotal();
        if (cliente instanceof ClienteVIP clienteVIP) {
            return clienteVIP.aplicarDescuento(subtotal);
        }
        return subtotal;
    }

    public void mostrarResumen() {
        System.out.println("\n=== PEDIDO #" + numero + " ===");
        System.out.println("Cliente: " + cliente.mostrarInformacion());
        System.out.println("Productos:");
        for (Producto producto : productos) {
            System.out.println("- " + producto.mostrarInformacion());
        }
        System.out.printf("Subtotal: $%.2f%n", calcularSubtotal());
        System.out.printf("Total:    $%.2f%n", calcularTotal());
    }
}
