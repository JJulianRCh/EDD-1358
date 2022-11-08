/**
 * Jose Julian Rodriguez Chagoya
 * Estructura de Datos 1358
 */
package mx.unam.EdD;

import java.util.ArrayList;

public class Cola<T> {

    private ArrayList<T> datos;

    /**
     * Construtor. Establece un ArrayList que representara la cola de datos
     */
    public Cola() {
        datos = new ArrayList<>();
    }

    /**
     * Regresa un booleano dependiendo de si la cola tenga o no datos
     * 
     * @return {@code  true} si la cola esta completamente vacia
     */
    public boolean estaVacia() {
        return datos.isEmpty();
    }

    /**
     * Regresa el tamaño de la cola
     * 
     * @return la longitud de la cola
     */
    public int longitud() {
        return datos.size();
    }

    /**
     * Ingresa un elemento al final de la cola
     * 
     * @param elemento que sera agregado al final de la cola
     */
    public void enqueue(T elemento) {
        datos.add(elemento);
    }

    /**
     * Remueve el primer elemento que se encuentra en la cola, es decir, el
     * elemento que se encuentra en el indice 0 del array
     * 
     * @return el elemento removido
     * @throws ArrayIndexOutOfBoundsException si la cola esta vacia
     */
    public T dequeue() {
        if (!estaVacia()) {
            return datos.remove(0);
        } else {
            throw new ArrayIndexOutOfBoundsException("La cola esta vacia");
        }
    }

     /**
     * Metodo toString que muestra el estado actual del objeto
     * 
     * @return estado del objeto
     */
    @Override
    public String toString() {
        String estado = "";
        for (T item : datos) {
            estado += "|" + item + "|  ";
        }
        estado += "\nTamaño: " + longitud();
        return estado;
    }
}
