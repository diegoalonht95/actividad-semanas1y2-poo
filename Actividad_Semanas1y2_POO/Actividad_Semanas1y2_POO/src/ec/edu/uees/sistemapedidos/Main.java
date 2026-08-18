package ec.edu.uees.sistemapedidos;

public class Main {
    public static void main(String[] args) {
        ClienteVIP cliente = new ClienteVIP(
                "0912345678",
                "Diego Herrera",
                "diego@email.com",
                0.10
        );

        Producto hamburguesa = new Producto("P001", "Hamburguesa", 5.50);
        Producto jugo = new Producto("P002", "Jugo Natural", 2.00);
        ProductoPerecible yogurt = new ProductoPerecible(
                "P003",
                "Yogurt",
                3.50,
                "30/08/2026"
        );

        Pedido pedido = new Pedido(1, cliente);
        pedido.agregarProducto(hamburguesa);
        pedido.agregarProducto(jugo);
        pedido.agregarProducto(yogurt);

        pedido.mostrarResumen();
    }
}
