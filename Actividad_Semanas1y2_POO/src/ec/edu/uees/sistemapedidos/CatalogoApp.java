package ec.edu.uees.sistemapedidos;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CatalogoApp extends Application {

    private CatalogoProductos catalogo;
    private ObservableList<Producto> datosTabla;

    private TextField txtCodigo;
    private TextField txtNombre;
    private TextField txtPrecio;

    private TableView<Producto> tabla;

    @Override
    public void start(Stage stage) {

        catalogo = new CatalogoProductos();
        datosTabla = FXCollections.observableArrayList();

        Label titulo = new Label("CATÁLOGO DE PRODUCTOS");
        titulo.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        txtCodigo = new TextField();
        txtCodigo.setPromptText("Ejemplo: P001");

        txtNombre = new TextField();
        txtNombre.setPromptText("Nombre del producto");

        txtPrecio = new TextField();
        txtPrecio.setPromptText("Ejemplo: 25.50");

        GridPane formulario = new GridPane();
        formulario.setHgap(10);
        formulario.setVgap(10);

        formulario.add(new Label("Código:"), 0, 0);
        formulario.add(txtCodigo, 1, 0);

        formulario.add(new Label("Nombre:"), 0, 1);
        formulario.add(txtNombre, 1, 1);

        formulario.add(new Label("Precio:"), 0, 2);
        formulario.add(txtPrecio, 1, 2);

        Button btnAgregar = new Button("Agregar");
        Button btnBuscar = new Button("Buscar");
        Button btnActualizar = new Button("Actualizar");
        Button btnEliminar = new Button("Eliminar");
        Button btnLimpiar = new Button("Limpiar");

        HBox botones = new HBox(
                10,
                btnAgregar,
                btnBuscar,
                btnActualizar,
                btnEliminar,
                btnLimpiar
        );

        tabla = new TableView<>();

        TableColumn<Producto, String> colCodigo =
                new TableColumn<>("Código");

        colCodigo.setCellValueFactory(
                new PropertyValueFactory<>("codigo")
        );

        TableColumn<Producto, String> colNombre =
                new TableColumn<>("Nombre");

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre")
        );

        TableColumn<Producto, Double> colPrecio =
                new TableColumn<>("Precio");

        colPrecio.setCellValueFactory(
                new PropertyValueFactory<>("precio")
        );

        tabla.getColumns().addAll(
                colCodigo,
                colNombre,
                colPrecio
        );

        tabla.setItems(datosTabla);

        colCodigo.setPrefWidth(120);
        colNombre.setPrefWidth(250);
        colPrecio.setPrefWidth(120);

        btnAgregar.setOnAction(event -> agregarProducto());
        btnBuscar.setOnAction(event -> buscarProducto());
        btnActualizar.setOnAction(event -> actualizarProducto());
        btnEliminar.setOnAction(event -> eliminarProducto());
        btnLimpiar.setOnAction(event -> limpiarCampos());

        tabla.setOnMouseClicked(event -> {

            Producto producto =
                    tabla.getSelectionModel().getSelectedItem();

            if (producto != null) {

                txtCodigo.setText(producto.getCodigo());
                txtNombre.setText(producto.getNombre());
                txtPrecio.setText(
                        String.valueOf(producto.getPrecio())
                );
            }
        });

        VBox contenedor = new VBox(
                20,
                titulo,
                formulario,
                botones,
                tabla
        );

        contenedor.setPadding(new Insets(20));

        Scene scene = new Scene(contenedor, 650, 500);

        stage.setTitle("Sistema de Pedidos - Catálogo");
        stage.setScene(scene);
        stage.show();
    }

    private void agregarProducto() {

        try {

            String codigo = txtCodigo.getText().trim();
            String nombre = txtNombre.getText().trim();
            String precioTexto = txtPrecio.getText().trim();

            if (codigo.isEmpty()
                    || nombre.isEmpty()
                    || precioTexto.isEmpty()) {

                mostrarMensaje(
                        "Error",
                        "Debe completar todos los campos."
                );

                return;
            }

            double precio =
                    Double.parseDouble(precioTexto);

            Producto producto =
                    new Producto(codigo, nombre, precio);

            boolean agregado =
                    catalogo.agregarProducto(producto);

            if (agregado) {

                datosTabla.add(producto);

                mostrarMensaje(
                        "Correcto",
                        "Producto agregado correctamente."
                );

                limpiarCampos();

            } else {

                mostrarMensaje(
                        "Error",
                        "Ya existe un producto con ese código."
                );
            }

        } catch (NumberFormatException e) {

            mostrarMensaje(
                    "Error",
                    "El precio debe ser un número válido."
            );

        } catch (IllegalArgumentException e) {

            mostrarMensaje(
                    "Error",
                    e.getMessage()
            );
        }
    }

    private void buscarProducto() {

        String codigo =
                txtCodigo.getText().trim();

        if (codigo.isEmpty()) {

            mostrarMensaje(
                    "Error",
                    "Ingrese un código para buscar."
            );

            return;
        }

        Producto producto =
                catalogo.buscarProducto(codigo);

        if (producto != null) {

            txtNombre.setText(producto.getNombre());

            txtPrecio.setText(
                    String.valueOf(producto.getPrecio())
            );

            mostrarMensaje(
                    "Resultado",
                    "Producto encontrado."
            );

        } else {

            mostrarMensaje(
                    "Resultado",
                    "Producto no encontrado."
            );
        }
    }

    private void actualizarProducto() {

        try {

            String codigo =
                    txtCodigo.getText().trim();

            String nombre =
                    txtNombre.getText().trim();

            String precioTexto =
                    txtPrecio.getText().trim();

            if (codigo.isEmpty()
                    || nombre.isEmpty()
                    || precioTexto.isEmpty()) {

                mostrarMensaje(
                        "Error",
                        "Debe completar todos los campos."
                );

                return;
            }

            double precio =
                    Double.parseDouble(precioTexto);

            boolean actualizado =
                    catalogo.actualizarProducto(
                            codigo,
                            nombre,
                            precio
                    );

            if (actualizado) {

                actualizarTabla();

                mostrarMensaje(
                        "Correcto",
                        "Producto actualizado correctamente."
                );

                limpiarCampos();

            } else {

                mostrarMensaje(
                        "Error",
                        "No existe un producto con ese código."
                );
            }

        } catch (NumberFormatException e) {

            mostrarMensaje(
                    "Error",
                    "El precio debe ser un número válido."
            );

        } catch (IllegalArgumentException e) {

            mostrarMensaje(
                    "Error",
                    e.getMessage()
            );
        }
    }

    private void eliminarProducto() {

        String codigo =
                txtCodigo.getText().trim();

        if (codigo.isEmpty()) {

            mostrarMensaje(
                    "Error",
                    "Ingrese el código del producto."
            );

            return;
        }

        boolean eliminado =
                catalogo.eliminarProducto(codigo);

        if (eliminado) {

            actualizarTabla();

            mostrarMensaje(
                    "Correcto",
                    "Producto eliminado correctamente."
            );

            limpiarCampos();

        } else {

            mostrarMensaje(
                    "Error",
                    "No existe un producto con ese código."
            );
        }
    }

    private void actualizarTabla() {

        datosTabla.setAll(
                catalogo.listarProductos()
        );
    }

    private void limpiarCampos() {

        txtCodigo.clear();
        txtNombre.clear();
        txtPrecio.clear();

        txtCodigo.requestFocus();
    }

    private void mostrarMensaje(
            String titulo,
            String mensaje) {

        Alert alerta =
                new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}