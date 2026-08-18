package ec.edu.uees.sistemapedidos;

public class ClienteVIP extends Cliente {
    private double descuento;

    public ClienteVIP(String cedula, String nombre, String correo, double descuento) {
        super(cedula, nombre, correo);
        setDescuento(descuento);
    }

    public double getDescuento() { return descuento; }
    public void setDescuento(double descuento) {
        if (descuento < 0 || descuento > 1) {
            throw new IllegalArgumentException("El descuento debe estar entre 0 y 1");
        }
        this.descuento = descuento;
    }

    public double aplicarDescuento(double subtotal) {
        return subtotal * (1 - descuento);
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + String.format(" | Cliente VIP (%.0f%% descuento)", descuento * 100);
    }
}
