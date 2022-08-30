/**
 * Jose Julian Rodriguez Chagoya
 * Estructura de Datos 1358
 */
package mx.unam.EdD;

public class ArregloADT {

    private Object[] array; // arreglo que guardara objetos
    private final int tamaño; // El tamaño del arreglo (array)

    /**
     * Constructor de la clase ArregloADT
     *
     * @param tamaño longitud que tendra el arreglo
     * @throws ArrayIndexOutOfBoundsException si el tamaño es menor de 1
     */
    public ArregloADT(int tamaño) {
        if (tamaño <= 0) {
            // En caso de ingresar un valor menor de 1 como parametro, se arrojara una excepcion
            throw new ArrayIndexOutOfBoundsException("El tamaño no puede ser menor de 1");
        }
        this.tamaño = tamaño;
        array = new Object[this.tamaño];
    }

    /**
     * Devuelve el tamaño del arreglo ADT
     *
     * @return tamaño
     */
    public int getLongitud() {
        return tamaño;
    }

    /**
     * Agrega un valor en una posicion especificada por el indice
     *
     * @param indice posición especifica en el arreglo
     * @param valor elemento que se agregara al arreglo
     */
    public void setElemento(int indice, Object valor) {
        array[indice] = valor;
    }

    /**
     * Devuelve el valor en el indice correspondiente
     *
     * @param indice posición especifica del arreglo
     * @return array[indice]
     */
    public Object getElemento(int indice) {
        return array[indice];
    }

    /**
     * establece todos los elementos al valor enviado.
     *
     * @param valor elemento
     */
    public void limpiar(Object valor) {
        for (int i = 0; i < tamaño; i++) {
            array[i] = valor;
        }
    }

    /**
     * Mostrar el estado del objeto
     *
     * @return estado
     */
    @Override
    public String toString() {
        String estado = "\t\t--Estado del arreglo--";
        int contar = 0;
        estado += "\nTamaño: " + tamaño + "\n";
        for (Object item : array) {
            if (item != null) {
                contar++;
            }
        }
        estado += "Espacios usados: " + contar + "\nEspacios libres: " + (tamaño - contar);
        return estado;
    }
}
