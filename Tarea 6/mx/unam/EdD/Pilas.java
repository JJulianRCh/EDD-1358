/**
 * Jose Julian Rodriguez Chagoya
 * Estructura de Datos 1358
 */
package mx.unam.EdD;

import java.util.ArrayList;

public class Pilas<T> {

    private final ArrayList<T> top;
    private int tamaño;

    public Pilas() {
        top = new ArrayList<>();
        tamaño = 0;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void push(T valor) {
        top.add(0, valor);
        tamaño++;
    }

    public T pop() {
        if (!estaVacia()) {
            tamaño--;
            return top.remove(0);
        } else {
            throw new IndexOutOfBoundsException("La pila esta vacia");
        }
    }

    public T peak() {
        if (!estaVacia()) {
            return top.get(0);
        } else {
            throw new IndexOutOfBoundsException("La pila esta vacia");
        }
    }

    @Override
    public String toString() {
        String estado = "";
        for (T item : top) {
            estado += item + "\n------\n";
        }
        return estado + "espacios: " + tamaño;
    }
}
