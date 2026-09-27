package ec.edu.uees.sistemapedidos;

public class ColaPedidos<T> {

    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tamanio;

    public ColaPedidos() {
        frente = null;
        fin = null;
        tamanio = 0;
    }

    public void encolar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);

        if (estaVacia()) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
        }

        tamanio++;
    }

    public T desencolar() {
        if (estaVacia()) {
            return null;
        }

        T elemento = frente.getDato();
        frente = frente.getSiguiente();
        tamanio--;

        if (frente == null) {
            fin = null;
        }

        return elemento;
    }

    public T frente() {
        if (estaVacia()) {
            return null;
        }

        return frente.getDato();
    }

    public boolean estaVacia() {
        return tamanio == 0;
    }

    public int tamanio() {
        return tamanio;
    }
}