package ec.edu.uees.sistemapedidos;

public interface PedidoRepository {

    void guardar(Pedido pedido);

    Pedido obtenerSiguiente();

    Pedido procesarSiguiente();

    boolean estaVacio();

    int cantidad();
}