package ec.edu.uees.sistemapedidos;

public class ClienteMayorista extends Cliente {

    public ClienteMayorista(String cedula, String nombre, String correo) {
        super(cedula, nombre, correo);
    }

    @Override
    public double calcularDescuento(double subtotal) {
        return subtotal * 0.15;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion()
                + " | Tipo: Mayorista"
                + " | Descuento: 15%";
    }
}