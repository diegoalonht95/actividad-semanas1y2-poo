package ec.edu.uees.sistemapedidos;

public class ClienteVIP extends Cliente {

    private double descuento;

    public ClienteVIP(String cedula, String nombre, String correo, double descuento) {
        super(cedula, nombre, correo);

        if (descuento >= 0 && descuento <= 1) {
            this.descuento = descuento;
        } else {
            this.descuento = 0;
        }
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        if (descuento >= 0 && descuento <= 1) {
            this.descuento = descuento;
        }
    }

    @Override
    public double calcularDescuento(double subtotal) {
        return subtotal * descuento;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion()
                + " | Tipo: VIP"
                + " | Descuento: " + (descuento * 100) + "%";
    }
}