/**
 * Jose Julian Rodriguez Chagoya
 * Estructura de Datos 1358
 */
package mx.unam.EdD;

import java.util.LinkedList;

public class TablaHash<K, T> {

    private LinkedList<Elemento<K, T>>[] datos; // Arreglo de listas ligadas

    /**
     * Constructor. Inicializa un objeto de la clase TablaHash con un tamaño
     * dado.
     *
     * @param table_size tamaño de la tabla
     */
    public TablaHash(int table_size) {
        datos = new LinkedList[table_size];
        for (int i = 0; i < datos.length; i++) {
            datos[i] = new LinkedList<>();
        }
    }

    /**
     * Agrega un valor a un indice de la tabla tras una operación de busqueda
     * con la clave del valor.
     * <p>
     * {@code indice = llave % tamaño}
     *
     * @param key clave asociada al valor para definir su indice
     * @param valor valor a guardar
     * @return {@code index} donde se guardo el elemento.
     * @throws NullPointerException Si el valor dado es un null
     */
    public int add(K key, T valor) {
        if (valor == null) {
            throw new NullPointerException("No se puede almacenar valores nulos");
        }
        int index = Math.abs(key.hashCode()) % datos.length;
        datos[index].addLast(new Elemento(key, valor));
        return index;
    }

    /**
     * Realiza un acceso directo al slot y busca el valor asociado a la llave.
     *
     * @param key llave para tener acceso al valor
     * @return el valor asociado a la llave
     * <p>
     * regresa {@code null} si el valor no fue encontrado.
     */
    public T valueOf(K key) {
        int index = Math.abs(key.hashCode()) % datos.length;
        for (Elemento<K, T> elemento : datos[index]) {
            if (elemento.llave.equals(key)) {
                return elemento.valor;
            }
        }
        return null;
    }

    /**
     * Realiza una busqueda para encontrar el valor asociado a la llave dada
     * para eliminarla de la tabla.
     *
     * @param key llave asociada a un valor
     */
    public void remove(K key) {
        int index = Math.abs(key.hashCode()) % datos.length;
        for (int i = 0; i < datos[index].size(); i++) {
            if (datos[index].get(i).llave.equals(key)) {
                datos[index].remove(i);
                break;
            }
        }
    }

    /**
     * Regresa el estado de la tabla hash.
     *
     * @return estado del objeto
     */
    @Override
    public String toString() {
        String estado = "";
        for (LinkedList item : datos) {
            estado += item + "\n";
        }
        return estado;
    }

    /**
     * Clase que representa el par: llave-valor para ser guardadas en la tabla
     * hash.
     *
     * @param <K> llave asociado al valor
     * @param <T> valor asociada a una llave
     */
    private class Elemento<K, T> {

        K llave;
        T valor;

        public Elemento(K llave, T valor) {
            this.llave = llave;
            this.valor = valor;
        }

        @Override
        public String toString() {
            return llave + ": " + valor;
        }
    }
}
