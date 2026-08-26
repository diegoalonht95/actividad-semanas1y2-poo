package ec.edu.uees.sistemapedidos;

public class Main {

    public static void main(String[] args) {

        Producto producto1 = new Producto("P001", "Laptop", 800.00);
        Producto producto2 = new Producto("P002", "Mouse", 25.00);

        Cliente clienteMayorista =
                new ClienteMayorista("0912345678", "Carlos", "carlos@email.com");

        Cliente clienteMinorista =
                new ClienteMinorista("0987654321", "Andrea", "andrea@email.com");

        Cliente clienteVIP =
                new ClienteVIP("0999999999", "Luis", "luis@email.com", 0.20);

        Pedido pedido1 = new Pedido(1, clienteMayorista);
        pedido1.agregarProducto(producto1);
        pedido1.agregarProducto(producto2);

        Pedido pedido2 = new Pedido(2, clienteMinorista);
        pedido2.agregarProducto(producto1);
        pedido2.agregarProducto(producto2);

        Pedido pedido3 = new Pedido(3, clienteVIP);
        pedido3.agregarProducto(producto1);
        pedido3.agregarProducto(producto2);

        pedido1.mostrarResumen();
        pedido2.mostrarResumen();
        pedido3.mostrarResumen();
    }
}