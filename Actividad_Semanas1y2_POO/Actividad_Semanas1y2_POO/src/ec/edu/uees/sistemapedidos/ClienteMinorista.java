package ec.edu.uees.sistemapedidos;

public class ClienteMinorista extends Cliente {

    public ClienteMinorista(String cedula, String nombre, String correo) {
        super(cedula, nombre, correo);
    }

    @Override
    public double calcularDescuento(double subtotal) {
        return subtotal * 0.05;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion()
                + " | Tipo: Minorista"
                + " | Descuento: 5%";
    }
}