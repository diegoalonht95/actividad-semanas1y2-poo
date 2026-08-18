package ec.edu.uees.sistemapedidos;

public class ProductoPerecible extends Producto {
    private String fechaCaducidad;

    public ProductoPerecible(String codigo, String nombre, double precio, String fechaCaducidad) {
        super(codigo, nombre, precio);
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getFechaCaducidad() { return fechaCaducidad; }
    public void setFechaCaducidad(String fechaCaducidad) { this.fechaCaducidad = fechaCaducidad; }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + " | Caduca: " + fechaCaducidad;
    }
}
