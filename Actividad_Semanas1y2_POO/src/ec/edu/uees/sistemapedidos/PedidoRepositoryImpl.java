package ec.edu.uees.sistemapedidos;

public class PedidoRepositoryImpl implements PedidoRepository {

    private final ColaPedidos<Pedido> colaPedidos;

    public PedidoRepositoryImpl() {
        colaPedidos = new ColaPedidos<>();
    }

    @Override
    public void guardar(Pedido pedido) {
        colaPedidos.encolar(pedido);
    }

    @Override
    public Pedido obtenerSiguiente() {
        return colaPedidos.frente();
    }

    @Override
    public Pedido procesarSiguiente() {
        return colaPedidos.desencolar();
    }

    @Override
    public boolean estaVacio() {
        return colaPedidos.estaVacia();
    }

    @Override
    public int cantidad() {
        return colaPedidos.tamanio();
    }
}