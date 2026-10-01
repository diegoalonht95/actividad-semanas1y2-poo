package ec.edu.uees.sistemapedidos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CatalogoProductos {

    private ArrayList<Producto> productos;
    private HashMap<String, Producto> productosPorCodigo;
    private HashSet<String> codigosRegistrados;

    // Archivo donde se guardarán los productos
    private static final String ARCHIVO_PRODUCTOS = "productos.txt";

    public CatalogoProductos() {
        productos = new ArrayList<>();
        productosPorCodigo = new HashMap<>();
        codigosRegistrados = new HashSet<>();

        // Recuperar productos guardados anteriormente
        cargarProductos();
    }

    // AGREGAR PRODUCTO
    public boolean agregarProducto(Producto producto) {

        if (codigosRegistrados.contains(producto.getCodigo())) {
            return false;
        }

        productos.add(producto);
        productosPorCodigo.put(producto.getCodigo(), producto);
        codigosRegistrados.add(producto.getCodigo());

        guardarProductos();

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

        guardarProductos();

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

        guardarProductos();

        return true;
    }

    // GUARDAR PRODUCTOS EN ARCHIVO
    private void guardarProductos() {

        Path ruta = Paths.get(ARCHIVO_PRODUCTOS);

        try (BufferedWriter escritor =
                     Files.newBufferedWriter(
                             ruta,
                             StandardCharsets.UTF_8)) {

            for (Producto producto : productos) {

                escritor.write(
                        producto.getCodigo()
                                + ";"
                                + producto.getNombre()
                                + ";"
                                + producto.getPrecio());

                escritor.newLine();
            }

        } catch (IOException e) {
            System.out.println(
                    "Error al guardar los productos: "
                            + e.getMessage());
        }
    }

    // CARGAR PRODUCTOS DESDE ARCHIVO
    private void cargarProductos() {

        Path ruta = Paths.get(ARCHIVO_PRODUCTOS);

        if (!Files.exists(ruta)) {
            return;
        }

        try (BufferedReader lector =
                     Files.newBufferedReader(
                             ruta,
                             StandardCharsets.UTF_8)) {

            String linea;

            while ((linea = lector.readLine()) != null) {

                String[] datos = linea.split(";", 3);

                if (datos.length == 3) {

                    String codigo = datos[0];
                    String nombre = datos[1];
                    double precio =
                            Double.parseDouble(datos[2]);

                    Producto producto =
                            new Producto(
                                    codigo,
                                    nombre,
                                    precio);

                    productos.add(producto);
                    productosPorCodigo.put(
                            codigo,
                            producto);
                    codigosRegistrados.add(codigo);
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println(
                    "Error al cargar los productos: "
                            + e.getMessage());
        }
    }
}