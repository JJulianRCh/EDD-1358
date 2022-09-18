/**
 * Jose Julian Rodriguez Chagoya
 * Estructura de Datos 1358
 */
package mx.unam.EdD;

import java.util.ArrayList;

public class Arreglo2DADT<T> {

    private ArrayList<ArrayList<T>> array2D;
    private int filas;
    private int columnas;

    /**
     * Constructor de la clase Arreglo2DADT que generara una matriz
     *
     * @param filas numero de filas que tendra la matriz
     * @param columnas numero de columnas que tendra la matriz
     */
    public Arreglo2DADT(int filas, int columnas) {
        if (filas < 1 || columnas < 1) {
            throw new IndexOutOfBoundsException("La medidas no pueden ser menores de 1");
        }
        this.filas = filas;
        this.columnas = columnas;
        array2D = new ArrayList<>();
        for (int i = 0; i < this.filas; i++) {
            array2D.add(new ArrayList<>());
            for (int j = 0; j < this.columnas; j++) {
                array2D.get(i).add(null);
            }
        }
    }

    /**
     * Obtener el numero de filas que tiene la matriz del objeto
     *
     * @return filas
     */
    public int getFilas() {
        return filas;
    }

    /**
     * Obtener el numero de columnas que tiene la matriz del objeto
     *
     * @return columnas
     */
    public int getColumnas() {
        return columnas;
    }

    /**
     * Se regresa el elemento que se ubica en la matriz correspondiente a las
     * coordenas dadas por el usuario
     *
     * @param fila fila donde se ubica el valor deseado
     * @param columna columna donde se ubica el valor deseado
     * @return un elemento de la matriz
     */
    public T getElemento(int fila, int columna) {
        return array2D.get(fila).get(columna);
    }

    /**
     * Se agrega un elemento a la matriz en la ubicacion indicada por el usuario
     *
     * @param fila fila donde se agregara un elemento
     * @param columna columna donde se agregara un elemento
     * @param valor elemento que sera agregado en la matriz
     */
    public void setElemento(int fila, int columna, T valor) {
        array2D.get(fila).set(columna, valor);

    }

    /**
     * Establece todos los valores del arreglos al valor enviado
     *
     * @param valor elemento
     */
    public void limpiar(T valor) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                array2D.get(i).set(j, valor);
            }
        }
    }

    /**
     * Regresa un objeto string que representa el estado actual del objeto.
     *
     * @return estado
     */
    @Override
    public String toString() {
        String estado = "\t\t--Estado de la tabla--";
        estado += "\nFilas: " + this.filas + "\nColumnas: " + this.columnas + "\n";
        for (ArrayList<T> item : array2D) {
            if (item != null) {
                estado += item + "\n";
            }
        }
        return estado;
    }

    public static void main(String[] args) {
        Arreglo2DADT<Integer> matriz = new Arreglo2DADT<>(2, 2);
        matriz.setElemento(0, 0, 21);
        matriz.setElemento(0, 0, 14);
        matriz.setElemento(0, 1, 22);
        matriz.setElemento(1, 0, 23);
        matriz.setElemento(1, 1, 24);
        System.out.println(matriz);
    }
}
