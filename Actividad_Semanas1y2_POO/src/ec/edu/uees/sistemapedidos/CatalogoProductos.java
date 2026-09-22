package ec.edu.uees.sistemapedidos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CatalogoProductos {

    private ArrayList<Producto> productos;
    private HashMap<String, Producto> productosPorCodigo;
    private HashSet<String> codigosRegistrados;

    public CatalogoProductos() {
        productos = new ArrayList<>();
        productosPorCodigo = new HashMap<>();
        codigosRegistrados = new HashSet<>();
    }

    // AGREGAR PRODUCTO
    public boolean agregarProducto(Producto producto) {

        if (codigosRegistrados.contains(producto.getCodigo())) {
            return false;
        }

        productos.add(producto);
        productosPorCodigo.put(producto.getCodigo(), producto);
        codigosRegistrados.add(producto.getCodigo());

        return true;
    }

    // BUSCAR PRODUCTO
    public Producto buscarProducto(String codigo) {
        return productosPorCodigo.get(codigo);
    }

    // LISTAR PRODUCTOS
    public ArrayList<Producto> listarProductos() {
        return productos;
    }

    // ACTUALIZAR PRODUCTO
    public boolean actualizarProducto(
            String codigo,
            String nuevoNombre,
            double nuevoPrecio) {

        Producto producto = buscarProducto(codigo);

        if (producto == null) {
            return false;
        }

        producto.setNombre(nuevoNombre);
        producto.setPrecio(nuevoPrecio);

        return true;
    }

    // ELIMINAR PRODUCTO
    public boolean eliminarProducto(String codigo) {

        Producto producto = buscarProducto(codigo);

        if (producto == null) {
            return false;
        }

        productos.remove(producto);
        productosPorCodigo.remove(codigo);
        codigosRegistrados.remove(codigo);

        return true;
    }
}