package ec.edu.uees.sistemapedidos;

public class Cliente {
    private String cedula;
    private String nombre;
    private String correo;

    public Cliente(String cedula, String nombre, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String mostrarInformacion() {
        return nombre + " | Cédula: " + cedula + " | Correo: " + correo;
    }
}
