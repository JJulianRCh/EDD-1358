package mx.unam.EdD;

public class ColasPrioridadAcotada<T> {

    private final ArregloADT<Cola<T>> datos;

    /**
     * Constructor. Iniciamos una cola de prioridad acotada que se conforma de
     * un array de colas en niveles.
     *
     * @param niveles los niveles de prioridad que almacenan colas.
     */
    public ColasPrioridadAcotada(int niveles) {
        datos = new ArregloADT<>(niveles);
        for (int i = 0; i < datos.getLongitud(); i++) {
            datos.setElemento(i, new Cola<>());
        }
    }

    /**
     * Regrese un booleano si todas las colas de los niveles estan vacias
     * completamente.
     *
     * @return {@code true} si esta vacia
     */
    public boolean estaVacia() {
        return longitud() == 0;
    }

    /**
     * Regresa la suma total del tamaño de cada cola en n niveles.
     *
     * @return el numero total de elementos
     */
    public int longitud() {
        int longitud = 0;
        for (int i = 0; i < datos.getLongitud(); i++) {
            longitud += datos.getElemento(i).longitud();
        }
        return longitud;
    }

    /**
     * Ingresa un elemento al final de cola en uno de los niveles dependiendo de
     * su prioridad
     *
     * @param prioridad nivel importancia del elemento
     * @param elemento que sera ingresado a la cola
     */
    public void enqueue(int prioridad, T elemento) {
        datos.getElemento(prioridad).enqueue(elemento);
    }

    /**
     * Remueve el primer elemento de mayor prioriridad de todas las colas.
     *
     * @return el elemento removido
     * @throws ArrayIndexOutOfBoundsException si todas las colas estan vacias
     */
    public T dequeue() {
        if (!estaVacia()) {
            T datoRemovido = null;
            for (int i = 0; i < datos.getLongitud(); i++) {
                if (!datos.getElemento(i).estaVacia()) {
                    datoRemovido = datos.getElemento(i).dequeue();
                    break;
                }
            }
            return datoRemovido;
        } else {
            throw new ArrayIndexOutOfBoundsException("La cola con prioridad esta vacia");
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
        for (int i = 0; i < datos.getLongitud(); i++) {
            estado += i + " --> " + datos.getElemento(i) + "\n";
        }
        return estado;
    }
}
